/*
Navicat MySQL Data Transfer

Source Server         : 3.35 test
Source Server Version : 50627
Source Host           : 192.168.3.35:33306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2021-09-29 15:39:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `description` varchar(30) DEFAULT NULL,
  `createtime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'students', '学生校色', '2021-09-27 10:55:02');
INSERT INTO `role` VALUES ('2', 'teachers', '学生校色', '2021-09-27 10:55:08');
