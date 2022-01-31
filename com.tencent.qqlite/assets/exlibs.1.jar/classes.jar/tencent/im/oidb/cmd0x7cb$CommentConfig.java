package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$CommentConfig
  extends MessageMicro
{
  public static final int RPT_MSG_CONFIGS_FIELD_NUMBER = 2;
  public static final int UINT32_APPOINT_SUBJECT_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_appoint_subject", "rpt_msg_configs" }, new Object[] { Integer.valueOf(0), null }, CommentConfig.class);
  public final PBRepeatMessageField rpt_msg_configs = PBField.initRepeatMessage(cmd0x7cb.ConfigItem.class);
  public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb.CommentConfig
 * JD-Core Version:    0.7.0.1
 */