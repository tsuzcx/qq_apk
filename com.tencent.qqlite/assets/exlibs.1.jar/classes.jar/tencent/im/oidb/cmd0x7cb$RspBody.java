package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$RspBody
  extends MessageMicro
{
  public static final int MSG_DATE_REQUEST_FIELD_NUMBER = 7;
  public static final int RPT_CANCLE_CONFIG_FIELD_NUMBER = 6;
  public static final int RPT_COMMENT_CONFIGS_FIELD_NUMBER = 3;
  public static final int STR_ATTEND_TIPS_TO_A_FIELD_NUMBER = 4;
  public static final int STR_FIRST_MSG_TIPS_FIELD_NUMBER = 5;
  public static final int UINT32_TIME_GAP_FIELD_NUMBER = 2;
  public static final int UINT32_TIME_STAMP_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_time_stamp", "uint32_time_gap", "rpt_comment_configs", "str_attend_tips_to_A", "str_first_msg_tips", "rpt_cancle_config", "msg_date_request" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, "", "", null, null }, RspBody.class);
  public cmd0x7cb.DateRequest msg_date_request = new cmd0x7cb.DateRequest();
  public final PBRepeatMessageField rpt_cancle_config = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
  public final PBRepeatMessageField rpt_comment_configs = PBField.initRepeatMessage(cmd0x7cb.CommentConfig.class);
  public final PBStringField str_attend_tips_to_A = PBField.initString("");
  public final PBStringField str_first_msg_tips = PBField.initString("");
  public final PBUInt32Field uint32_time_gap = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time_stamp = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb.RspBody
 * JD-Core Version:    0.7.0.1
 */