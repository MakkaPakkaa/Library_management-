/*
Navicat MySQL Data Transfer

Source Server         : huangry
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : books

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-11-11 14:44:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET gbk COLLATE gbk_bin NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `status` int(2) DEFAULT '1',
  `lend_num` int(11) DEFAULT NULL,
  `max_num` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '123', '12355678', '123', '12348', '1234558', '2', '30', '5');
INSERT INTO `admin` VALUES ('2', '13', '13', '13', '13', '13', '2', '30', '5');
INSERT INTO `admin` VALUES ('4', '456', '456', '456', '456', '456', '2', '30', '5');
INSERT INTO `admin` VALUES ('6', 'hry', 'hry', '123456', '123456', '123456', '1', '30', '5');
INSERT INTO `admin` VALUES ('12', 'qq', 'hqq', '123456', '123456', '123456', '1', '30', '5');
INSERT INTO `admin` VALUES ('13', 'huangry', 'HHH', '123456', '123@qq.com', '123887744445', '1', '30', '5');
INSERT INTO `admin` VALUES ('9', 'my', '12', '123456', '123@qq.com', '123887744445', '1', '30', '5');
INSERT INTO `admin` VALUES ('14', 'makaa', 'BBB', '123456', '123@qq.com', '123887744445', '1', '30', '5');
INSERT INTO `admin` VALUES ('15', 'Pakka', '智慧', '123456', '123@qq.com', '123887744445', '1', '30', '5');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(205) NOT NULL,
  `card` varchar(205) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `autho` varchar(200) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `num` int(11) NOT NULL,
  `press` varchar(200) CHARACTER SET gbk COLLATE gbk_chinese_ci DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  UNIQUE KEY `ISBN` (`card`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('4', '红楼梦', '2', '曹雪芹', '5', '人民文学出版社', '名著');
INSERT INTO `book` VALUES ('2', '活着', '3', '余华', '5', '作家出版社', '名著');
INSERT INTO `book` VALUES ('3', '坏小孩 : 推理之王', '6', '紫金陈', '4', '湖南文艺出版社', '小说');
INSERT INTO `book` VALUES ('5', '解忧杂货店', '4', '东野圭吾', '9', '南海出版公司', '小说');
INSERT INTO `book` VALUES ('9', '挪威的森林', '10', '巫哲', '7', '北京联合出版公司', '小说');
INSERT INTO `book` VALUES ('7', 'python编程语言', '1', 'HHH', '4', '清华出版社', '学习');
INSERT INTO `book` VALUES ('8', '1984', '89', '乔治奥威尔', '1', '北京十月文艺出版社', '小说');
INSERT INTO `book` VALUES ('10', '基督山伯爵', '15', '大仲马', '6', '上海译文出版社', '小说');
INSERT INTO `book` VALUES ('11', '城南旧事 ', '16', '林海音', '7', '中国青年出版社', '小说');
INSERT INTO `book` VALUES ('12', '傲慢与偏见', '11', '奥斯丁', '14', '人民文学出版社', '言情');
INSERT INTO `book` VALUES ('13', '射雕英雄传', '12', '金庸', '8', ' 生活·读书·新知三联书店', '武侠');
INSERT INTO `book` VALUES ('14', '西游记（全二册）', '13', '吴承恩', '17', '人民文学出版社', '名著');

-- ----------------------------
-- Table structure for `booktype`
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('1', '名著');
INSERT INTO `booktype` VALUES ('2', '小说');
INSERT INTO `booktype` VALUES ('4', '学习');
INSERT INTO `booktype` VALUES ('5', '科普');
INSERT INTO `booktype` VALUES ('6', '言情');
INSERT INTO `booktype` VALUES ('8', '漫画');
INSERT INTO `booktype` VALUES ('9', '武侠');
INSERT INTO `booktype` VALUES ('10', '历史');

-- ----------------------------
-- Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `hid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  `card` char(255) DEFAULT NULL,
  `bookname` char(255) DEFAULT NULL,
  `adminname` char(255) DEFAULT NULL,
  `username` char(255) DEFAULT NULL,
  `begintime` char(255) DEFAULT NULL,
  `endtime` char(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`hid`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('8', '9', '5', '4', '解忧杂货店', 'my', '12', '2020-8-26', '2020-8-26', '0');
INSERT INTO `history` VALUES ('9', '9', '3', '6', '坏小孩 : 推理之王', 'my', '12', '2020-8-26', '2020-9-26', '1');
INSERT INTO `history` VALUES ('10', '12', '3', '6', '坏小孩 : 推理之王', 'qq', 'hqq', '2020-8-26', '2020-8-26', '0');
INSERT INTO `history` VALUES ('11', '12', '2', '3', '活着', 'qq', 'hqq', '2020-8-26', '2020-8-26', '0');
INSERT INTO `history` VALUES ('12', '12', '8', '89', '1984', 'qq', 'hqq', '2020-8-26', '2020-9-26', '1');
INSERT INTO `history` VALUES ('6', '9', '5', '4', '解忧杂货店', 'my', '12', '2020-8-26', '2020-8-26', '0');
INSERT INTO `history` VALUES ('7', '9', '5', '4', '解忧杂货店', 'my', '12', '2020-8-26', '2020-9-26', '1');
INSERT INTO `history` VALUES ('13', '9', '8', '89', '1984', 'my', '12', '2020-8-26', '2020-9-26', '1');
INSERT INTO `history` VALUES ('14', '9', '8', '89', '1984', 'my', '12', '2020-8-26', '2020-8-26', '0');
INSERT INTO `history` VALUES ('15', '14', '10', '15', '基督山伯爵', 'makaa', 'BBB', '2020-8-29', '2020-8-29', '0');
INSERT INTO `history` VALUES ('16', '14', '12', '11', '傲慢与偏见', 'makaa', 'BBB', '2020-8-29', '2020-8-29', '0');
INSERT INTO `history` VALUES ('17', '14', '13', '12', '射雕英雄传', 'makaa', 'BBB', '2020-8-29', '2020-8-29', '0');
INSERT INTO `history` VALUES ('18', '14', '4', '2', '红楼梦', 'makaa', 'BBB', '2020-8-29', '2020-9-29', '1');
INSERT INTO `history` VALUES ('19', '14', '9', '10', '挪威的森林', 'makaa', 'BBB', '2020-8-29', '2020-9-29', '1');
INSERT INTO `history` VALUES ('20', '9', '11', '16', '城南旧事', 'my', '12', '2020-8-29', '2020-9-29', '1');
