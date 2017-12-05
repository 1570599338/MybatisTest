/** MyBatis鐜閰嶇疆鍙婂叆闂�**/
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `dept` varchar(254) NOT NULL DEFAULT '',
  `website` varchar(254) DEFAULT '',
  `phone` varchar(16) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yiibai', 'Tech', 'http://www.baidu.com', '13800009988');


/**Mybatis表关联一对多**/

/**readuser表的结构和数据：**/
-- ----------------------------
-- Table structure for `readuser`
-- ----------------------------
CREATE TABLE `readuser` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL DEFAULT '',
  `mobile` int(10) unsigned NOT NULL DEFAULT '0',
  `created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `readuser` VALUES ('1', 'yiibai', '100', '2015-09-23 20:11:23');


/**帖子表 post 的结构和数据：**/
-- ----------------------------
-- Table structure for `post`
-- ----------------------------
CREATE TABLE `post` (
  `post_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(10) unsigned NOT NULL,
  `title` varchar(254) NOT NULL DEFAULT '',
  `content` text,
  `created` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('1', '1', 'MyBatis关联数据查询', '在实际项目中，经常使用关联表的查询，比如：多对一，一对多等。这些查询是如何处理的呢，这一讲就讲这个问题。我们首先创建一个 post 表，并初始化数据.', '2015-09-23 21:40:17');
INSERT INTO `post` VALUES ('2', '1', 'MyBatis开发环境搭建', '为了方便学习，这里直接建立java 工程，但一般都是开发 Web 项目。', '2015-09-23 21:42:14');
INSERT INTO `post` VALUES ('3', '2', '这个是别人发的', 'content,内容...', '0000-00-00 00:00:00');  



-- -------------------------
-- mybatis执行存储过程sql
-- --------------------------
create table p_user(  
    id int primary key auto_increment,  
    name varchar(10),
    sex char(2)
); 

insert into p_user(name,sex) values('A',"男");  
insert into p_user(name,sex) values('B',"女");  
insert into p_user(name,sex) values('C',"男");  

-- 创建存储过程(查询得到男性或女性的数量, 如果传入的是0就女性否则是男性)
DELIMITER $
CREATE PROCEDURE ges_user_count(IN sex_id INT, OUT user_count INT)
BEGIN  
	IF sex_id=0 THEN
		SELECT COUNT(*) FROM p_user WHERE p_user.sex='女' INTO user_count;
	ELSE
		SELECT COUNT(*) FROM p_user WHERE p_user.sex='男' INTO user_count;
	END IF;
END 
$

-- 调用存储过程
DELIMITER ;
SET @user_count = 0;
CALL ges_user_count(1, @user_count);
SELECT @user_count;


