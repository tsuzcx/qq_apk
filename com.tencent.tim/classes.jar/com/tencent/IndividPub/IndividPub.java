package com.tencent.IndividPub;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IndividPub
{
  public static final class Platform_Comm_Req
    extends MessageMicro<Platform_Comm_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platForm", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform_Comm_Req.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platForm = PBField.initInt64(0L);
  }
  
  public static final class Platform_Comm_Rsp
    extends MessageMicro<Platform_Comm_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Platform_Comm_Rsp.class);
  }
  
  public static final class expTips_Pull_Req
    extends MessageMicro<expTips_Pull_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from" }, new Object[] { Integer.valueOf(0) }, expTips_Pull_Req.class);
    public final PBUInt32Field from = PBField.initUInt32(0);
  }
  
  public static final class expTips_Pull_Rsp
    extends MessageMicro<expTips_Pull_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48 }, new String[] { "expFlag", "content", "clickText", "action", "url", "itemId" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, expTips_Pull_Rsp.class);
    public final PBEnumField action = PBField.initEnum(0);
    public final PBStringField clickText = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field expFlag = PBField.initUInt32(0);
    public final PBUInt32Field itemId = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class expTips_Req
    extends MessageMicro<expTips_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, expTips_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public IndividPub.Platform_Comm_Req comm = new IndividPub.Platform_Comm_Req();
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public IndividPub.expTips_Pull_Req reqcmd_0x01 = new IndividPub.expTips_Pull_Req();
  }
  
  public static final class expTips_Rsp
    extends MessageMicro<expTips_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, expTips_Rsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public IndividPub.Platform_Comm_Rsp comm = new IndividPub.Platform_Comm_Rsp();
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public IndividPub.expTips_Pull_Rsp rspcmd_0x01 = new IndividPub.expTips_Pull_Rsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.IndividPub.IndividPub
 * JD-Core Version:    0.7.0.1
 */