package com.tencent.pb.secmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SecMsgComu$SecMsg_Rsp
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 3;
  public static final int COMM_FIELD_NUMBER = 5;
  public static final int ERRMSG_FIELD_NUMBER = 2;
  public static final int PACKET_SEQ_FIELD_NUMBER = 4;
  public static final int RET_FIELD_NUMBER = 1;
  public static final int RSPCMD_0X01_FIELD_NUMBER = 6;
  public static final int RSPCMD_0X02_FIELD_NUMBER = 7;
  public static final int RSPCMD_0X03_FIELD_NUMBER = 8;
  public static final int RSPCMD_0X04_FIELD_NUMBER = 9;
  public static final int RSPCMD_0X05_FIELD_NUMBER = 10;
  public static final int RSPCMD_0X06_FIELD_NUMBER = 11;
  public static final int RSPCMD_0X07_FIELD_NUMBER = 12;
  public static final int RSPCMD_0X08_FIELD_NUMBER = 13;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01", "rspcmd_0x02", "rspcmd_0x03", "rspcmd_0x04", "rspcmd_0x05", "rspcmd_0x06", "rspcmd_0x07", "rspcmd_0x08" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, SecMsg_Rsp.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SecMsgComu.SecMsg_Rsp_Comm comm = new SecMsgComu.SecMsg_Rsp_Comm();
  public final PBStringField errmsg = PBField.initString("");
  public final PBInt64Field packet_seq = PBField.initInt64(0L);
  public final PBInt64Field ret = PBField.initInt64(0L);
  public SecMsgComu.SecMsg_CreateSS_Rsp rspcmd_0x01 = new SecMsgComu.SecMsg_CreateSS_Rsp();
  public SecMsgComu.SecMsg_SendMsg_Rsp rspcmd_0x02 = new SecMsgComu.SecMsg_SendMsg_Rsp();
  public SecMsgComu.SecMsg_SendACK_Rsp rspcmd_0x03 = new SecMsgComu.SecMsg_SendACK_Rsp();
  public SecMsgComu.SecMsg_GetInbox_Rsp rspcmd_0x04 = new SecMsgComu.SecMsg_GetInbox_Rsp();
  public SecMsgComu.SecMsg_GetSSInfo_Rsp rspcmd_0x05 = new SecMsgComu.SecMsg_GetSSInfo_Rsp();
  public SecMsgComu.SecMsg_GetBaseInfo_Rsp rspcmd_0x06 = new SecMsgComu.SecMsg_GetBaseInfo_Rsp();
  public SecMsgComu.SecMsg_EnableSS_Rsp rspcmd_0x07 = new SecMsgComu.SecMsg_EnableSS_Rsp();
  public SecMsgComu.SecMsg_EnableSecMsg_Rsp rspcmd_0x08 = new SecMsgComu.SecMsg_EnableSecMsg_Rsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.secmsg.SecMsgComu.SecMsg_Rsp
 * JD-Core Version:    0.7.0.1
 */