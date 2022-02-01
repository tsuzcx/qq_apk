package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x496
{
  public static final class AioKeyword
    extends MessageMicro<AioKeyword>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "keywords", "rules", "version" }, new Object[] { null, null, Integer.valueOf(0) }, AioKeyword.class);
    public final PBRepeatMessageField<oidb_0x496.AioKeywordInfo> keywords = PBField.initRepeatMessage(oidb_0x496.AioKeywordInfo.class);
    public final PBRepeatMessageField<oidb_0x496.AioKeywordRuleInfo> rules = PBField.initRepeatMessage(oidb_0x496.AioKeywordRuleInfo.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class AioKeywordInfo
    extends MessageMicro<AioKeywordInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "word", "rule_id" }, new Object[] { "", Integer.valueOf(0) }, AioKeywordInfo.class);
    public final PBRepeatField<Integer> rule_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBStringField word = PBField.initString("");
  }
  
  public static final class AioKeywordRuleInfo
    extends MessageMicro<AioKeywordRuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "rule_id", "start_time", "end_time", "postion_flag", "match_group_class", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, AioKeywordRuleInfo.class);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> match_group_class = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field postion_flag = PBField.initUInt32(0);
    public final PBUInt32Field rule_id = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class GroupMsgConfig
    extends MessageMicro<GroupMsgConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "bool_uin_enable", "uint32_max_aio_msg", "uint32_enable_helper", "uint32_group_max_number", "uint32_next_update_time" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupMsgConfig.class);
    public final PBBoolField bool_uin_enable = PBField.initBool(false);
    public final PBUInt32Field uint32_enable_helper = PBField.initUInt32(0);
    public final PBUInt32Field uint32_group_max_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_aio_msg = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_update_time = PBField.initUInt32(0);
  }
  
  public static final class MsgSeqInfo
    extends MessageMicro<MsgSeqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_group_code", "rpt_manager_uin_list", "uint64_update_time", "uint64_first_unread_manager_msg_seq", "rpt_uint64_manager_msg_seq" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, MsgSeqInfo.class);
    public final PBRepeatField<Long> rpt_manager_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_uint64_manager_msg_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_first_unread_manager_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "uint64_group_code", "uint64_update_time", "uint64_manager_uin_list", "uint64_first_unread_manager_msg_seq", "uint32_just_fetch_msg_config", "uint32_type", "uint32_version", "uint32_aio_keyword_version" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_aio_keyword_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_just_fetch_msg_config = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_first_unread_manager_msg_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_manager_uin_list = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  }
  
  public static final class Robot
    extends MessageMicro<Robot>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58 }, new String[] { "version", "uin_range", "fire_keywords", "start_keywords", "end_keywords", "session_timeout", "subscribe_categories" }, new Object[] { Integer.valueOf(0), null, "", "", "", Integer.valueOf(0), null }, Robot.class);
    public final PBRepeatField<String> end_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> fire_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field session_timeout = PBField.initUInt32(0);
    public final PBRepeatField<String> start_keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0x496.RobotSubscribeCategory> subscribe_categories = PBField.initRepeatMessage(oidb_0x496.RobotSubscribeCategory.class);
    public final PBRepeatMessageField<oidb_0x496.UinRange> uin_range = PBField.initRepeatMessage(oidb_0x496.UinRange.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class RobotSubscribeCategory
    extends MessageMicro<RobotSubscribeCategory>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "id", "name", "type", "next_wording", "next_content" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "" }, RobotSubscribeCategory.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField next_content = PBField.initString("");
    public final PBStringField next_wording = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "rpt_msg_seq_info", "uint64_max_aio_msg", "uint64_max_position_msg", "msg_group_msg_config", "robot_config", "aio_keyword_config" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), null, null, null }, RspBody.class);
    public oidb_0x496.AioKeyword aio_keyword_config = new oidb_0x496.AioKeyword();
    public oidb_0x496.GroupMsgConfig msg_group_msg_config = new oidb_0x496.GroupMsgConfig();
    public oidb_0x496.Robot robot_config = new oidb_0x496.Robot();
    public final PBRepeatMessageField<oidb_0x496.MsgSeqInfo> rpt_msg_seq_info = PBField.initRepeatMessage(oidb_0x496.MsgSeqInfo.class);
    public final PBUInt64Field uint64_max_aio_msg = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_max_position_msg = PBField.initUInt64(0L);
  }
  
  public static final class UinRange
    extends MessageMicro<UinRange>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_uin", "end_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, UinRange.class);
    public final PBUInt64Field end_uin = PBField.initUInt64(0L);
    public final PBUInt64Field start_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496
 * JD-Core Version:    0.7.0.1
 */