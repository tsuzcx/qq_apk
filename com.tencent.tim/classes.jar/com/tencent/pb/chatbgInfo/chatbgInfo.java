package com.tencent.pb.chatbgInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class chatbgInfo
{
  public static final class Bg_Auth_Rst
    extends MessageMicro<Bg_Auth_Rst>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "bgId", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_Auth_Rst.class);
    public final PBInt32Field bgId = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class Bg_CheckAuth_Req
    extends MessageMicro<Bg_CheckAuth_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "IdList", "BgEffectList" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_CheckAuth_Req.class);
    public final PBRepeatField<Integer> BgEffectList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> IdList = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  }
  
  public static final class Bg_CheckAuth_Rsp
    extends MessageMicro<Bg_CheckAuth_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "AuthRst", "AuthEffectRst" }, new Object[] { null, null }, Bg_CheckAuth_Rsp.class);
    public final PBRepeatMessageField<chatbgInfo.Bg_Effect_Auth_Rst> AuthEffectRst = PBField.initRepeatMessage(chatbgInfo.Bg_Effect_Auth_Rst.class);
    public final PBRepeatMessageField<chatbgInfo.Bg_Auth_Rst> AuthRst = PBField.initRepeatMessage(chatbgInfo.Bg_Auth_Rst.class);
  }
  
  public static final class Bg_Effect_Auth_Rst
    extends MessageMicro<Bg_Effect_Auth_Rst>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "effectId", "result" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Bg_Effect_Auth_Rst.class);
    public final PBInt32Field effectId = PBField.initInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class Bg_Req
    extends MessageMicro<Bg_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "cmd", "packet_seq", "comm", "reqcmd_0x01" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, Bg_Req.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public chatbgInfo.Platform_Comm_Req comm = new chatbgInfo.Platform_Comm_Req();
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public chatbgInfo.Bg_CheckAuth_Req reqcmd_0x01 = new chatbgInfo.Bg_CheckAuth_Req();
  }
  
  public static final class Bg_Rsp
    extends MessageMicro<Bg_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "errmsg", "cmd", "packet_seq", "comm", "rspcmd_0x01" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, Bg_Rsp.class);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public chatbgInfo.Platform_Comm_Rsp comm = new chatbgInfo.Platform_Comm_Rsp();
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt64Field packet_seq = PBField.initUInt64(0L);
    public final PBInt64Field ret = PBField.initInt64(0L);
    public chatbgInfo.Bg_CheckAuth_Rsp rspcmd_0x01 = new chatbgInfo.Bg_CheckAuth_Rsp();
  }
  
  public static final class Platform_Comm_Req
    extends MessageMicro<Platform_Comm_Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ImPlat", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform_Comm_Req.class);
    public final PBInt64Field ImPlat = PBField.initInt64(0L);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
  }
  
  public static final class Platform_Comm_Rsp
    extends MessageMicro<Platform_Comm_Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Platform_Comm_Rsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.chatbgInfo.chatbgInfo
 * JD-Core Version:    0.7.0.1
 */