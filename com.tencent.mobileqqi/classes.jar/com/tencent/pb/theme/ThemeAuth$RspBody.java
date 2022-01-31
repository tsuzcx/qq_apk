package com.tencent.pb.theme;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ThemeAuth$RspBody
  extends MessageMicro
{
  public static final int MSG_SUBCMD0X1_RSP_AUTH_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_subcmd0x1_rsp_auth" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public ThemeAuth.SubCmd0x1RspAuth msg_subcmd0x1_rsp_auth = new ThemeAuth.SubCmd0x1RspAuth();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.theme.ThemeAuth.RspBody
 * JD-Core Version:    0.7.0.1
 */