/*
 Navicat Premium Data Transfer

 Source Server         : 陈雨晨
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : javaaccounting

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 26/06/2024 20:53:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for factor
-- ----------------------------
DROP TABLE IF EXISTS `factor`;
CREATE TABLE `factor`  (
  `factorid` int NOT NULL,
  `factor name` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `factor define` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `factor feature` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factor source` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factor classify` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `factor confirm` char(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`factorid`) USING BTREE,
  UNIQUE INDEX `factorname_UNIQUE`(`factorid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of factor
-- ----------------------------
INSERT INTO `factor` VALUES (1, '资产', '企业过去的交易或者事项形成的,由企业拥有或者控制的,预期会给企业带来经济利益的资源', '过去的+为企业拥有或者控制+预期会给企业带来经济利益', NULL, '流动资产/非流动资产', NULL);
INSERT INTO `factor` VALUES (2, '负债', '企业过去的交易或者事项形成的,预期会导致经济利益流出企业的现时义务', '过去的+预期会导致经济利益流出+企业承担的现时义务', NULL, '流动负债/非流动负债', '很可能流出企业+能够可靠的计量');
INSERT INTO `factor` VALUES (3, '所有者权益', '企业资产扣除负债后,由所有者享有的剩余权益', NULL, '所有者投入的资本+其他综合收益+留存收益', NULL, '所有者在企业中的剩余权益');
INSERT INTO `factor` VALUES (4, '收入', '企业在日常活动中形成的,会导致所有者权益增加的,与所有者投入资本无关的经济利益的总流入', '日常活动+与所有者投入资本无关+会导致所有者权益增加', NULL, NULL, '已批准合同+明确权利和义务+明确支付条款+具有商业实质+对价很可能回收');
INSERT INTO `factor` VALUES (5, '费用', '企业在日常活动中发生的,会导致所有者权益减少的,与向所有者分配利润无关的经济利益的总流出', '日常活动+与向所有者权益分配利润无关+会导致所有者权益减少', NULL, NULL, '很可能流出企业+会导致资产的减少或负债的增加+流出额能可靠计量');
INSERT INTO `factor` VALUES (6, '利润', '企业在一定会计期间的经营成果', NULL, NULL, '收入减去费用后的净额/直接计入当期利润的利得和损失', '收入减去费用、里的减去损失后的净额');

-- ----------------------------
-- Table structure for knowledge_points
-- ----------------------------
DROP TABLE IF EXISTS `knowledge_points`;
CREATE TABLE `knowledge_points`  (
  `idknowledge_points` int NOT NULL,
  `knowledge_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `type_id` int NULL DEFAULT NULL,
  `number` int NULL DEFAULT NULL,
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `describe1` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `difficulty` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`idknowledge_points`) USING BTREE,
  UNIQUE INDEX `idknowledge_points_id_UNIQUE`(`idknowledge_points`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of knowledge_points
-- ----------------------------
INSERT INTO `knowledge_points` VALUES (2001, '企业所得税', 2, 5, '黄洁洵', '企业所得税是对中国境内的企业和其他取得收入的组织的生产经营所得和其他所得征收的一种所得税', '较难');
INSERT INTO `knowledge_points` VALUES (2002, '固定资产折旧', 1, 3, '马小新', '折旧是指固定资产由于使用而逐渐磨损所减少的那部分价值', '特难');
INSERT INTO `knowledge_points` VALUES (2003, '政府决算报告', 1, 7, '马小新', '是指经济独立核算单位，定期向财经主管部门或代表大会作的财政、财务方面的决算总结的书面报告', '简单');
INSERT INTO `knowledge_points` VALUES (2004, '房产税', 2, 4, '黄洁洵', '是以房屋为征税对象，按房屋的计税余值或租赁收入为计税依据，向产权所有人征收的一种财产税', '一般');
INSERT INTO `knowledge_points` VALUES (2005, '合同取得成本', 1, 5, '马小新', '是新收入准则下的一个会计科目，定义为企业为取得合同发生的增量成本预期能够收回的，应当作为合同取得成本确认为一项资产', '较难');
INSERT INTO `knowledge_points` VALUES (2006, '借贷记账法', 1, 6, '马小新', '我国会计准则规定,企业,行政单位和事业单位会计核算采用借贷记账法记账.', '简单');
INSERT INTO `knowledge_points` VALUES (2007, '车船税', 2, 1, '黄洁洵', '是指在中华人民共和国境内的车辆、船舶的所有人或者管理人按照中华人民共和国车船税法应缴纳的一种税', '较难');
INSERT INTO `knowledge_points` VALUES (2008, '增值税', 2, 7, '黄洁洵', '是以商品（含应税劳务）在流转过程中产生的增值额作为计税依据而征收的一种流转税', '一般');
INSERT INTO `knowledge_points` VALUES (2009, '长期股权投资', 1, 2, '马小新', '反映和监督长期股权投资的取得,持有,处置等业务活动', '特难');
INSERT INTO `knowledge_points` VALUES (2011, '存货', 1, 4, '马小新', '企业持有存货的最终目的是为了销售', '一般');
INSERT INTO `knowledge_points` VALUES (2012, '契税', 2, 8, '黄洁洵', '是指不动产（土地、房屋）产权发生转移变动时，就当事人所订契约按产价的一定比例向新业主（产权承受人）征收的一次性税收。', '简单');
INSERT INTO `knowledge_points` VALUES (2013, '成本核算', 1, 3, '马小新', '指企业在生产产品过程中发生的材料费用,职工薪酬及间接费用', '特难');
INSERT INTO `knowledge_points` VALUES (2014, '劳动合同', NULL, 9, '黄洁洵', '是确立劳动者与用人单位劳动关系的基本前提，在劳动法中占据核心的地位。', '一般');
INSERT INTO `knowledge_points` VALUES (2015, '银行汇票', 2, 4, '黄洁洵', '是指由出票银行签发的，由其在见票时按照实际结算金额无条件付给收款人或者持票人的票据。', '简单');
INSERT INTO `knowledge_points` VALUES (2016, '财产清查', 1, 3, '马小新', '库存现金采用实地盘点法,银行存款与开户银行核对账目', '简单');
INSERT INTO `knowledge_points` VALUES (2017, '支票', 1, 5, '黄洁洵', '是出票人签发的，委托办理支票存款业务的银行或者其他金融机构在见票时无条件支付确定的金额给收款人或者持票人的票据。', '较难');
INSERT INTO `knowledge_points` VALUES (2018, '银行存款', 1, 6, '马小新', '企业存放在银行或其他金融机构的货币资金', '一般');
INSERT INTO `knowledge_points` VALUES (2019, '商业汇票', 2, 7, '黄洁洵', '是出票人签发，委托付款人在指定日期无条件支付确定的金额给收款人或者持票人的票据。', '特难');
INSERT INTO `knowledge_points` VALUES (2020, '交易性金融资产', 1, 5, '马小新', '企业以公允价值计量且其变动计入当期损益的金融资产', '较难');

-- ----------------------------
-- Table structure for situation
-- ----------------------------
DROP TABLE IF EXISTS `situation`;
CREATE TABLE `situation`  (
  `user_id` int NOT NULL,
  `idknowledge_points` int NOT NULL,
  `begin` date NULL DEFAULT NULL,
  `end` date NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `idknowledge_points`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of situation
-- ----------------------------
INSERT INTO `situation` VALUES (1001, 2003, '2024-06-01', '2024-06-03');
INSERT INTO `situation` VALUES (1004, 2001, '2024-06-15', '2024-06-23');
INSERT INTO `situation` VALUES (1006, 2002, '2024-06-16', '2024-06-16');
INSERT INTO `situation` VALUES (1008, 2008, '2024-06-17', '2024-06-25');
INSERT INTO `situation` VALUES (1010, 2001, '2024-06-18', '2024-06-17');
INSERT INTO `situation` VALUES (1012, 2010, '2024-06-18', '2024-06-19');
INSERT INTO `situation` VALUES (1014, 2018, '2024-06-19', '2024-06-26');
INSERT INTO `situation` VALUES (1016, 2015, '2024-06-20', '2024-06-27');
INSERT INTO `situation` VALUES (1018, 2020, '2024-06-21', '2024-06-28');
INSERT INTO `situation` VALUES (1019, 2001, '2024-05-21', '2024-06-22');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` int NOT NULL,
  `sex` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `area` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_id_UNIQUE`(`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, '张三', '1233456qw', 1, '男', '杭州');
INSERT INTO `user` VALUES (1002, '李四', '234fgn5678', 1, '男', '北京');
INSERT INTO `user` VALUES (1003, '王五', '098765kj4', 1, '男', '银川');
INSERT INTO `user` VALUES (1004, '赵六', '45632dt10', 1, '女', '北京');
INSERT INTO `user` VALUES (1005, '陈雨晨1', '123456cyc', 2, '女', '石家庄');
INSERT INTO `user` VALUES (1007, '李经硕', '12398sy', 1, '男', '石家庄');
INSERT INTO `user` VALUES (1008, '陈雨晨2', '123456cyc', 1, '女', '石家庄');
INSERT INTO `user` VALUES (1009, '张晓雨', '0997868sdvc', 1, '女', '银川');
INSERT INTO `user` VALUES (1010, '赵怡嘉', '67389zyj', 1, '女', '北京');
INSERT INTO `user` VALUES (1011, '赵晓宇', '000272zxy', 2, '女', '杭州');
INSERT INTO `user` VALUES (1012, '牛美婷', '0812358nmt', 1, '女', '石家庄');
INSERT INTO `user` VALUES (1013, '李雍雍', '08977lyy', 2, '男', '北京');
INSERT INTO `user` VALUES (1014, '陈雨晨0', '123456abc', 1, '男', '北京');
INSERT INTO `user` VALUES (1015, '测试人', '123456abc', 1, '男', '北 京');

SET FOREIGN_KEY_CHECKS = 1;
