package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleDiyComu
{
  public static final class Bubble_GetDiyText_Req
    extends MessageMicro<Bubble_GetDiyText_Req>
  {
    public static final int USER_TEXT_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_text_info" }, new Object[] { null }, Bubble_GetDiyText_Req.class);
    public final PBRepeatMessageField<BubbleDiyComu.UserTextInfo> user_text_info = PBField.initRepeatMessage(BubbleDiyComu.UserTextInfo.class);
  }
  
  public static final class Bubble_GetDiyText_Rsp
    extends MessageMicro<Bubble_GetDiyText_Rsp>
  {
    public static final int USER_TEXT_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_text_info" }, new Object[] { null }, Bubble_GetDiyText_Rsp.class);
    public final PBRepeatMessageField<BubbleDiyComu.UserTextInfo> user_text_info = PBField.initRepeatMessage(BubbleDiyComu.UserTextInfo.class);
  }
  
  public static final class Bubble_Req
    extends MessageMicro<Bubble_Req>
  {
    public static final int CMD_FIELD_NUMBER = 1;
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int PACKET_SEQ_FIELD_NUMBER = 2;
    public static final int REQCMD_0X01_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, Bubble_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public BubbleDiyComu.Bubble_Req_Comm comm = new BubbleDiyComu.Bubble_Req_Comm();
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public BubbleDiyComu.Bubble_GetDiyText_Req reqcmd_0x01 = new BubbleDiyComu.Bubble_GetDiyText_Req();
  }
  
  public static final class Bubble_Req_Comm
    extends MessageMicro<Bubble_Req_Comm>
  {
    public static final int MQQVER_FIELD_NUMBER = 3;
    public static final int OSVER_FIELD_NUMBER = 2;
    public static final int PLATFORM_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Bubble_Req_Comm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class Bubble_Rsp
    extends MessageMicro<Bubble_Rsp>
  {
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int COMM_FIELD_NUMBER = 5;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int PACKET_SEQ_FIELD_NUMBER = 4;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPCMD_0X01_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, Bubble_Rsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public BubbleDiyComu.Bubble_Rsp_Comm comm = new BubbleDiyComu.Bubble_Rsp_Comm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public BubbleDiyComu.Bubble_GetDiyText_Rsp rspcmd_0x01 = new BubbleDiyComu.Bubble_GetDiyText_Rsp();
  }
  
  public static final class Bubble_Rsp_Comm
    extends MessageMicro<Bubble_Rsp_Comm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Bubble_Rsp_Comm.class);
  }
  
  public static final class UserTextInfo
    extends MessageMicro<UserTextInfo>
  {
    public static final int CREATE_TS_FIELD_NUMBER = 4;
    public static final int TEXT_FIELD_NUMBER = 3;
    public static final int TEXT_ID_FIELD_NUMBER = 2;
    public static final int TEXT_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "text_uin", "text_id", "text", "create_ts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L) }, UserTextInfo.class);
    public final PBInt64Field create_ts = PBField.initInt64(0L);
    public final PBStringField text = PBField.initString("");
    public final PBUInt32Field text_id = PBField.initUInt32(0);
    public final PBUInt64Field text_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyComu
 * JD-Core Version:    0.7.0.1
 */