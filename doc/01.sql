create database com_ling_mybatis_begin;
use com_ling_mybatis_begin;

DROP TABLE IF EXISTS `t_sys_property`;
CREATE TABLE `t_sys_property` (
`seq_id`  bigint UNSIGNED NOT NULL AUTO_INCREMENT ,
`sys_group` varchar(255) NOT NULL default 'sys' COMMENT '属性组',
`sys_key` varchar(255) NOT NULL default '' COMMENT '属性名',
`sys_value` varchar(255) NOT NULL default '' COMMENT '属性值',
`remark` varchar(255) NOT NULL default '' comment '备注',
`enable` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否启用',
`create_time` datetime NOT NULL default '2019-01-01 00:00:00',
`create_by` varchar(50) NOT NULL default '',
`last_update_time` datetime NOT NULL default '2019-01-01 00:00:00',
`last_update_by` varchar(50) NOT NULL default '',
PRIMARY KEY (`seq_id`)
) ENGINE=InnoDB comment '系统配置';

insert into t_sys_property(
sys_group, sys_key, sys_value, remark, enable
, create_time, create_by, last_update_time, last_update_by)
values
('g1', 'k1', 'v1', 'r1', 1
,'2019-01-01 00:00:01', 'ling', '2019-01-01 00:00:01', 'ling')
,('g2', 'k2', 'v2', 'r2', 1
 ,'2019-01-02 00:00:01', 'ling', '2019-01-03 00:00:01', 'ling')
,('g3', 'k3', 'v3', 'r3', 0
,'2019-01-03 00:00:01', 'ling', '2019-01-03 00:00:01', 'ling')
,('g4', 'k3', 'v4', 'r4', 1
,'2019-01-04 00:00:01', 'ling', '2019-01-04 00:00:01', 'ling')
,('g1', 'k5', 'v1', 'r5', 0
,'2019-01-01 00:00:01', 'ling', '2019-01-01 00:00:01', 'ling')
;


