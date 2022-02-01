package com.hiboom.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DiyEmotionPb
{
  public static final class Filter_Req
    extends MessageMicro<Filter_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, Filter_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public DiyEmotionPb.Filter_Req_Comm comm = new DiyEmotionPb.Filter_Req_Comm();
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public DiyEmotionPb.Filter_Text_Req reqcmd_0x01 = new DiyEmotionPb.Filter_Text_Req();
  }
  
  public static final class Filter_Req_Comm
    extends MessageMicro<Filter_Req_Comm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Filter_Req_Comm.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class Filter_Rsp
    extends MessageMicro<Filter_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, Filter_Rsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public DiyEmotionPb.Filter_Rsp_Comm comm = new DiyEmotionPb.Filter_Rsp_Comm();
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public DiyEmotionPb.Filter_Text_Rsp rspcmd_0x01 = new DiyEmotionPb.Filter_Text_Rsp();
  }
  
  public static final class Filter_Rsp_Comm
    extends MessageMicro<Filter_Rsp_Comm>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Filter_Rsp_Comm.class);
  }
  
  public static final class Filter_Text_Req
    extends MessageMicro<Filter_Text_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "text" }, new Object[] { "" }, Filter_Text_Req.class);
    public final PBRepeatField<String> text = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class Filter_Text_Rsp
    extends MessageMicro<Filter_Text_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_valid" }, new Object[] { Boolean.valueOf(false) }, Filter_Text_Rsp.class);
    public final PBRepeatField<Boolean> is_valid = PBField.initRepeat(PBBoolField.__repeatHelper__);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hiboom.protocol.DiyEmotionPb
 * JD-Core Version:    0.7.0.1
 */