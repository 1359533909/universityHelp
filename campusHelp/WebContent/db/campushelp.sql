/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.47 : Database - campushelp
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`campushelp` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `campushelp`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(6) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL DEFAULT '123456',
  `name` varchar(255) NOT NULL DEFAULT 'name',
  `addtime` datetime(6) NOT NULL,
  `state` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`account`,`password`,`name`,`addtime`,`state`) values (10,'222016602063019','222016602063019','莫小林','2020-02-18 03:54:08.000000',0),(11,'123456','123456','123456','2020-02-24 04:13:45.347000',0);

/*Table structure for table `evaluation` */

DROP TABLE IF EXISTS `evaluation`;

CREATE TABLE `evaluation` (
  `taskid` int(8) unsigned NOT NULL COMMENT '与任务表一致',
  `content` text COMMENT '评价内容',
  `isEvaluation` tinyint(1) DEFAULT NULL COMMENT '是否评价，1代表TRUE,0代表FALSE',
  `state` int(11) DEFAULT NULL COMMENT '任务状态，3已完成，2解决中，1已关闭，0为完成',
  PRIMARY KEY (`taskid`),
  CONSTRAINT `evaluation_ibfk_1` FOREIGN KEY (`taskid`) REFERENCES `task` (`taskid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `evaluation` */

insert  into `evaluation`(`taskid`,`content`,`isEvaluation`,`state`) values (37,' 大家好啊！\r\n我很喜欢这次活动！',1,0),(49,NULL,0,0),(50,NULL,0,0);

/*Table structure for table `recharge` */

DROP TABLE IF EXISTS `recharge`;

CREATE TABLE `recharge` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) unsigned NOT NULL COMMENT '充值订单',
  `studentid` varchar(20) DEFAULT NULL COMMENT '用户学号',
  `schoolid` int(11) DEFAULT NULL COMMENT '用户学院',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `amount` int(10) unsigned DEFAULT NULL COMMENT '充值数额',
  `isRecharge` tinyint(1) DEFAULT NULL COMMENT '是否充值，1代表TRUE,0代表FALSE',
  `adminAcount` varchar(255) DEFAULT NULL COMMENT '操作的管理员账号',
  `adminName` varchar(255) DEFAULT NULL COMMENT '操作的管理员姓名',
  PRIMARY KEY (`id`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `recharge` */

insert  into `recharge`(`id`,`orderId`,`studentid`,`schoolid`,`name`,`amount`,`isRecharge`,`adminAcount`,`adminName`) values (12,1230728113860775936,'222016602063019',9,'林',2,1,'222016602063019','莫小林'),(13,1230728135130091520,'222016602063019',9,'林',10,2,'222016602063019','莫小林'),(16,1231792139927687168,'222016602063019',9,'林',5,1,'222016602063019','莫小林'),(17,1231812867712487424,'222016602063019',9,'林',0,0,NULL,NULL),(18,1231813105911205888,'222016602063019',9,'林',0,0,NULL,NULL),(19,1232175489318260736,'2220166026098',9,'小',2,0,NULL,NULL);

/*Table structure for table `school` */

DROP TABLE IF EXISTS `school`;

CREATE TABLE `school` (
  `schoolid` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT 'schoolname',
  `addtime` datetime(6) NOT NULL,
  `state` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`schoolid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `school` */

insert  into `school`(`schoolid`,`name`,`addtime`,`state`) values (9,'商贸学院','2020-02-17 19:55:10.893000',0),(10,'动科学院','2020-02-17 19:55:48.550000',0),(11,'网教部','2020-02-17 19:56:18.144000',0);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `taskid` int(8) unsigned NOT NULL AUTO_INCREMENT,
  `publish_user_id` varchar(255) NOT NULL COMMENT '发布用户学号',
  `publish_user_name` varchar(255) NOT NULL,
  `publish_school_id` int(6) NOT NULL COMMENT '发布用户学校ID',
  `accept_user_id` int(11) NOT NULL DEFAULT '0',
  `reward` double(30,0) NOT NULL DEFAULT '0' COMMENT '任务奖励',
  `addtime` datetime(6) NOT NULL COMMENT '发布时间',
  `endtime` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `taskname` varchar(255) NOT NULL COMMENT '任务名称',
  `taskcontext` varchar(255) NOT NULL COMMENT '任务描述',
  `state` int(2) NOT NULL DEFAULT '0' COMMENT '任务状态',
  PRIMARY KEY (`taskid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `task` */

insert  into `task`(`taskid`,`publish_user_id`,`publish_user_name`,`publish_school_id`,`accept_user_id`,`reward`,`addtime`,`endtime`,`taskname`,`taskcontext`,`state`) values (37,'7','林',9,8,0,'2020-02-20 09:23:28.833000','2020-02-20 09:23:29','拿快递','求帮忙去楼下拿快递',3),(49,'7','林',9,0,0,'2020-02-26 07:03:49.116000','2020-02-26 07:03:49','纾解','借书',0),(50,'7','林',9,0,0,'2020-02-26 07:15:54.017000','2020-02-26 07:15:54','借演出服装','需要借一天的演出服装',0);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `stuid` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` varchar(20) NOT NULL DEFAULT '' COMMENT '学号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `schoolid` int(6) NOT NULL,
  `sex` int(2) NOT NULL DEFAULT '0',
  `name` varchar(255) NOT NULL DEFAULT 'name',
  `registertime` datetime(6) NOT NULL COMMENT '注册时间',
  `money` double(20,0) NOT NULL DEFAULT '0',
  `state` int(2) NOT NULL DEFAULT '0',
  `hierarchy` int(11) DEFAULT NULL COMMENT '用户信誉等级',
  PRIMARY KEY (`stuid`,`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

/*Data for the table `user` */

insert  into `user`(`stuid`,`studentid`,`password`,`schoolid`,`sex`,`name`,`registertime`,`money`,`state`,`hierarchy`) values (7,'222016602063019','222016602063019',9,0,'林','2020-02-17 19:57:04.714000',6,0,6),(8,'123456','123456',9,0,'123456','2020-02-20 09:25:35.869000',0,0,6),(9,'2220166026098','2220166026098',9,0,'小','2020-02-25 05:25:00.604000',0,0,6),(10,'222016602063016','222016602063016',9,0,'小东','2020-02-27 03:23:43.354000',0,0,6);

/*Table structure for table `withdraw` */

DROP TABLE IF EXISTS `withdraw`;

CREATE TABLE `withdraw` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orderId` bigint(20) unsigned NOT NULL COMMENT '提现订单',
  `studentid` varchar(20) DEFAULT NULL COMMENT '用户学号',
  `schoolid` int(11) DEFAULT NULL COMMENT '用户学院',
  `name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `amount` int(10) unsigned DEFAULT NULL COMMENT '提现数额',
  `isWithdraw` tinyint(1) DEFAULT NULL COMMENT '是否提现，1代表TRUE,0代表FALSE',
  `adminAcount` varchar(255) DEFAULT NULL COMMENT '操作的管理员账号',
  `adminName` varchar(255) DEFAULT NULL COMMENT '操作的管理员姓名',
  PRIMARY KEY (`id`,`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `withdraw` */

insert  into `withdraw`(`id`,`orderId`,`studentid`,`schoolid`,`name`,`amount`,`isWithdraw`,`adminAcount`,`adminName`) values (15,1231607184454979584,'222016602063019',9,'林',1,1,'222016602063019','莫小林'),(16,1231809695245799424,'222016602063019',9,'林',1,2,'222016602063019','莫小林'),(17,1231809765257121792,'222016602063019',9,'林',5,0,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
