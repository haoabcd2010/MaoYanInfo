#!/usr/bin/python
# -*- coding: utf-8 -*-

"""
 @ author:  happy_code
 @ contact: happy_code@foxmail.com
 @ software: 猫眼电影TOP榜爬虫
 @ desc: 爬虫，可以马上跑一次，可以指定时间每天跑
"""

import urllib
import requests
import re
import os
import pymysql
import schedule
import time


class Spider:

    # 图片保存地址
    myrobot = "D:/scinfo/"

    # 数据库连接参数
    db = None

    # 获取 排名， 图片， 电影名， 主演， 上映时间， 评分
    part = '<dd>\s*' \
	'\s*<i.*>(\d*)</i>\s*' \
    '\s*<a.*>\s*' \
		'\s*<img.*>\s*' \
        '\s*<img data-src="(.*?)" alt=".*?" class="board-img" />' \
        '\s*</a>\s*' \
    '\s*<div class="board-item-main">\s*' \
      '\s*<div class="board-item-content">\s*' \
              '\s*<div class="movie-item-info">\s*' \
    '\s*<p class="name"><a href=".*" title=".*" data-act="boarditem-click" data-val=".*">(.*)</a></p>\s*' \
    '\s*<p class="star">\s*' \
                '\s*(.*)\s*' \
    '\s*</p>\s*'\
    '\s*<p class="releasetime">(.*?)</p>\s*</div>\s*' \
    '\s*<div class="movie-item-number score-num">\s*' \
        '\s*<p class="score"><i class="integer">(.*?)</i><i class="fraction">(.*?)</i></p>\s*'



    # 获取网站源代码
    def gethtml(self, url):
        res = requests.get(url)
        res.encoding = "UTF-8"
        return res.text


    # 处理一下评分小数部分的结果
    def cleaninfo(self, all):
        ret = []
        for i in all:
            x = []
            for j in i[0:-2]:
                x.append(j)
            x.append(i[-2] + i[-1])
            ret.append(x)
        return ret


    # 获得某一页信息, 整理
    def gethtmlinfo(self, url):
        html = self.gethtml(url)
        all = re.findall(self.part, html)
        all = self.cleaninfo(all)
        return all


    # 获取top100
    def gethtmlallinfo(self, url):
        allData = self.gethtmlinfo(url)

        urltemp = url + "?offset={page}"
        for i in range(1,10):
            turl = urltemp.format(page=i*10)
            lis = self.gethtmlinfo(turl)
            allData.extend(lis)
        return allData


    # 下载图片,保存到myrobot下, 可以自定义文件名,哈哈重复下载保证成功(最多3次)
    def downloadimg(self, url, name=None):
        ok = 0
        for i in range(3):
            try:
                if name != None:
                    path = self.myrobot + name + "." +url.split('.')[-1]
                else:
                    path = self.myrobot + url.split('/')[-1]
                url = url.replace('\\', '')
                r = requests.get(url, timeout=30)
                r.raise_for_status()
                r.encoding = r.apparent_encoding
                if not os.path.exists(self.myrobot):
                    os.makedirs(self.myrobot)
                if not os.path.exists(path):
                    with open(path, 'wb') as f:
                        f.write(r.content)
                        f.close()
                        print(path + ' 文件保存成功')
                        ok = 1
                else:
                    print('文件已经存在')
            except:
                print("异常")
                continue

            if ok == 1:
                break


    # 保存图片信息
    def saveinfo(self, data):
        for i in data:
            s.downloadimg(i[0], i[1]+"-"+str(i[2]));


    # 插入一条记录到数据库
    def inserttobase(self, data):
        # 使用cursor()方法获取操作游标
        cur = self.db.cursor()

        sql_insert = "INSERT INTO tops(ranking, picture, name, star, releasetime, score)" \
            " VALUES(%s, %s, %s, %s, %s, %s)"

        try:
            cur.execute(sql_insert ,(data[0], data[1], data[2], data[3], data[4], data[5]))
            # 提交
            self.db.commit()
        except Exception as e:
            # 错误回滚
            self.db.rollback()


    # 插入全部信息到数据库
    def savetobase(self, data):
        # 开启连接
        self.db = pymysql.connect(host="localhost", user="root",
                        password="twh123456", db="maoyan", port=3306)
        dlen = len(data)
        for i in range (0, dlen):
            self.inserttobase(data[i])

        self.db.close()

    # 完成工作
    def work(self):
        # 查询单个页面
        # data = s.gethtmlinfo("http://maoyan.com/board/4")

        # 查询所有页面并保存到数据库, 指定了url
        data = s.gethtmlallinfo("http://maoyan.com/board/4")
        s.savetobase(data)


def job():
    print("I'm working...")

# 定时完成工作
"""
if __name__ == "__main__":
    s = Spider()
    print("完成")
    schedule.every().days.at("10:05").do(s.work())
    while True:
        schedule.run_pending()
        time.sleep(1)
"""

# 马上跑一遍
if __name__ == "__main__":
    s = Spider()
    s.work();