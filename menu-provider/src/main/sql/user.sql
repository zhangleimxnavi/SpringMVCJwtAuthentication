/*
Navicat MySQL Data Transfer

Source Server         : 3.35 test
Source Server Version : 50627
Source Host           : 192.168.3.35:33306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2021-09-29 15:39:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `image` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhanglei', '123456', null);
INSERT INTO `user` VALUES ('2', 'druid', '123456', '45889850-94e0-4a0e-ba15-6a2a3da5a9e4.png');
