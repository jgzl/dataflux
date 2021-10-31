drop database if exists dataflux;
create database dataflux character set utf8mb4;
use dataflux;
/*
 Navicat Premium Data Transfer

 Source Server         : mysql7
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : dataflux

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 31/10/2021 15:12:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account` varchar(32) NOT NULL COMMENT '账户',
  `username` varchar(64) NOT NULL COMMENT '用户姓名',
  `nickname` varchar(64) DEFAULT NULL COMMENT '用户别名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `age` int(3) NOT NULL COMMENT '年龄',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_account` (`account`) USING BTREE COMMENT '账户'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

SET FOREIGN_KEY_CHECKS = 1;
