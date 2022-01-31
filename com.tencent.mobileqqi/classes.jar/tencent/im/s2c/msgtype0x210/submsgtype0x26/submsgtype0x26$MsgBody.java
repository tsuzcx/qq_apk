package tencent.im.s2c.msgtype0x210.submsgtype0x26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class submsgtype0x26$MsgBody
  extends MessageMicro
{
  public static final int MSG_SUBCMD_0X2_PUSH_BODY_FIELD_NUMBER = 3;
  public static final int MSG_SUBCMD_0X3_PUSH_BODY_FIELD_NUMBER = 4;
  public static final int RPT_MSG_SUBCMD_0X1_PUSH_BODY_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_sub_cmd", "rpt_msg_subcmd_0x1_push_body", "msg_subcmd_0x2_push_body", "msg_subcmd_0x3_push_body" }, new Object[] { Integer.valueOf(0), null, null, null }, MsgBody.class);
  public submsgtype0x26.MsgBody.SubCmd0x2UpdateAppList msg_subcmd_0x2_push_body = new submsgtype0x26.MsgBody.SubCmd0x2UpdateAppList();
  public submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo msg_subcmd_0x3_push_body = new submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo();
  public final PBRepeatMessageField rpt_msg_subcmd_0x1_push_body = PBField.initRepeatMessage(submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum.class);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody
 * JD-Core Version:    0.7.0.1
 */