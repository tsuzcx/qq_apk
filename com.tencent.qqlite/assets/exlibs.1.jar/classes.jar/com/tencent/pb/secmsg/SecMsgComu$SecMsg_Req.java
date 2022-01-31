package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SecMsgComu$SecMsg_Req
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int COMM_FIELD_NUMBER = 3;
  public static final int PACKET_SEQ_FIELD_NUMBER = 2;
  public static final int REQCMD_0X01_FIELD_NUMBER = 4;
  public static final int REQCMD_0X02_FIELD_NUMBER = 5;
  public static final int REQCMD_0X03_FIELD_NUMBER = 6;
  public static final int REQCMD_0X04_FIELD_NUMBER = 7;
  public static final int REQCMD_0X05_FIELD_NUMBER = 8;
  public static final int REQCMD_0X06_FIELD_NUMBER = 9;
  public static final int REQCMD_0X07_FIELD_NUMBER = 10;
  public static final int REQCMD_0X08_FIELD_NUMBER = 11;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01", "reqcmd_0x02", "reqcmd_0x03", "reqcmd_0x04", "reqcmd_0x05", "reqcmd_0x06", "reqcmd_0x07", "reqcmd_0x08" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, SecMsg_Req.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SecMsgComu.SecMsg_Req_Comm comm = new SecMsgComu.SecMsg_Req_Comm();
  public final PBInt64Field packet_seq = PBField.initInt64(0L);
  public SecMsgComu.SecMsg_CreateSS_Req reqcmd_0x01 = new SecMsgComu.SecMsg_CreateSS_Req();
  public SecMsgComu.SecMsg_SendMsg_Req reqcmd_0x02 = new SecMsgComu.SecMsg_SendMsg_Req();
  public SecMsgComu.SecMsg_SendACK_Req reqcmd_0x03 = new SecMsgComu.SecMsg_SendACK_Req();
  public SecMsgComu.SecMsg_GetInbox_Req reqcmd_0x04 = new SecMsgComu.SecMsg_GetInbox_Req();
  public SecMsgComu.SecMsg_GetSSInfo_Req reqcmd_0x05 = new SecMsgComu.SecMsg_GetSSInfo_Req();
  public SecMsgComu.SecMsg_GetBaseInfo_Req reqcmd_0x06 = new SecMsgComu.SecMsg_GetBaseInfo_Req();
  public SecMsgComu.SecMsg_EnableSS_Req reqcmd_0x07 = new SecMsgComu.SecMsg_EnableSS_Req();
  public SecMsgComu.SecMsg_EnableSecMsg_Req reqcmd_0x08 = new SecMsgComu.SecMsg_EnableSecMsg_Req();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_Req
 * JD-Core Version:    0.7.0.1
 */