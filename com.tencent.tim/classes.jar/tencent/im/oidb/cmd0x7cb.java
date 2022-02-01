package tencent.im.oidb;

import appoint.define.appoint_define.LocaleInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb
{
  public static final class CommentConfig
    extends MessageMicro<CommentConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appoint_subject", "rpt_msg_configs" }, new Object[] { Integer.valueOf(0), null }, CommentConfig.class);
    public final PBRepeatMessageField<cmd0x7cb.ConfigItem> rpt_msg_configs = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
    public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
  }
  
  public static final class ConfigItem
    extends MessageMicro<ConfigItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_id", "str_config" }, new Object[] { Integer.valueOf(0), "" }, ConfigItem.class);
    public final PBStringField str_config = PBField.initString("");
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
  }
  
  public static final class DateRequest
    extends MessageMicro<DateRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_time", "str_err_msg" }, new Object[] { Integer.valueOf(0), "" }, DateRequest.class);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_time_stamp" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104 }, new String[] { "uint32_time_stamp", "uint32_time_gap", "rpt_comment_configs", "str_attend_tips_to_A", "str_first_msg_tips", "rpt_cancle_config", "msg_date_request", "rpt_msg_hot_locale", "rpt_msg_topic_list", "str_travel_msg_tips", "str_travel_profile_tips", "str_travel_atten_tips", "uint32_topic_default" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", "", null, null, null, null, "", "", "", Integer.valueOf(0) }, RspBody.class);
    public cmd0x7cb.DateRequest msg_date_request = new cmd0x7cb.DateRequest();
    public final PBRepeatMessageField<cmd0x7cb.ConfigItem> rpt_cancle_config = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
    public final PBRepeatMessageField<cmd0x7cb.CommentConfig> rpt_comment_configs = PBField.initRepeatMessage(cmd0x7cb.CommentConfig.class);
    public final PBRepeatMessageField<appoint_define.LocaleInfo> rpt_msg_hot_locale = PBField.initRepeatMessage(appoint_define.LocaleInfo.class);
    public final PBRepeatMessageField<cmd0x7cb.TopicConfig> rpt_msg_topic_list = PBField.initRepeatMessage(cmd0x7cb.TopicConfig.class);
    public final PBStringField str_attend_tips_to_A = PBField.initString("");
    public final PBStringField str_first_msg_tips = PBField.initString("");
    public final PBStringField str_travel_atten_tips = PBField.initString("");
    public final PBStringField str_travel_msg_tips = PBField.initString("");
    public final PBStringField str_travel_profile_tips = PBField.initString("");
    public final PBUInt32Field uint32_time_gap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_default = PBField.initUInt32(0);
  }
  
  public static final class TopicConfig
    extends MessageMicro<TopicConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_topic_id", "str_topic_name", "uint32_deadline", "str_err_deadline" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "" }, TopicConfig.class);
    public final PBStringField str_err_deadline = PBField.initString("");
    public final PBStringField str_topic_name = PBField.initString("");
    public final PBUInt32Field uint32_deadline = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb
 * JD-Core Version:    0.7.0.1
 */