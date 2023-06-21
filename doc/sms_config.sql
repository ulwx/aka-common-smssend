/*
SQLyog Ultimate
MySQL - 5.7.22-log : Database - yscf_mdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

/*Table structure for table `sms_config` */

DROP TABLE IF EXISTS `sms_config`;

CREATE TABLE `sms_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sms_prex` varchar(20) DEFAULT NULL COMMENT '短信前缀',
  `url` varchar(255) DEFAULT NULL,
  `user_code` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `type` varchar(2) DEFAULT NULL COMMENT '类型：(1-验证码类短信 2-营销类短信 3:通知类短信)',
  `filter` varchar(100) DEFAULT '' COMMENT '过滤关键字，以英文逗号分隔',
  `commpany` varchar(10) DEFAULT NULL COMMENT '鼎汉',
  `black_phone` varchar(500) DEFAULT '' COMMENT '黑名单手机号码,以逗号分隔',
  `status` smallint(6) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='鼎汉配置表';

/*Data for the table `sms_config` */

insert  into `sms_config`(`id`,`sms_prex`,`url`,`user_code`,`user_pwd`,`type`,`filter`,`commpany`,`black_phone`,`status`) values 
(1,'粤商财富','http://120.76.79.226:9080','jianyidai001','jianyidai16888','1','抵押,质押','鼎汉','18814145843',1),
(2,'粤商财富','http://112.74.179.106:8080','jianyidai002','jianyidai16888','2','抵押,质押','鼎汉','',1),
(6,'粤商财富','http://120.76.79.226:9080','jianyidai003','jianyidai16888','3','抵押,质押','鼎汉','',1),
(7,'粤商财富','http://120.76.79.226:9080','jianyidai003','jianyidai16888','4','抵押,质押','鼎汉','',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
