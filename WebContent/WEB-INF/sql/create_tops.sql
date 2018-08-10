CREATE TABLE `tops` (

`id` int(11) NOT NULL AUTO_INCREMENT,

`ranking` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`star` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`releasetime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`score` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,

`gettime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

PRIMARY KEY (`id`) 

)

ENGINE = InnoDB

AUTO_INCREMENT = 1

AVG_ROW_LENGTH = 0

DEFAULT CHARACTER SET = utf8

COLLATE = utf8_general_ci

KEY_BLOCK_SIZE = 0

MAX_ROWS = 0

MIN_ROWS = 0

ROW_FORMAT = Dynamic;



