package com.tencent.pb.signature;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SigActPb
{
  public static final class Platform
    extends MessageMicro<Platform>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Platform.class);
    public final PBStringField mqqver = PBField.initString("");
    public final PBStringField osver = PBField.initString("");
    public final PBInt64Field platform = PBField.initInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "cmd", "seq", "plf", "req", "auth_req", "source" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null, Integer.valueOf(0) }, ReqBody.class);
    public SigActPb.SigauthReq auth_req = new SigActPb.SigauthReq();
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public SigActPb.Platform plf = new SigActPb.Platform();
    public SigActPb.SigactReq req = new SigActPb.SigactReq();
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field source = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "ret", "desc", "cmd", "seq", "rsp", "auth_rsp" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), null, null }, RspBody.class);
    public SigActPb.SigauthRsp auth_rsp = new SigActPb.SigauthRsp();
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
    public SigActPb.SigactRsp rsp = new SigActPb.SigactRsp();
    public final PBUInt64Field seq = PBField.initUInt64(0L);
  }
  
  public static final class SigactReq
    extends MessageMicro<SigactReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin_disable", "actid", "acttype" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SigactReq.class);
    public final PBInt32Field actid = PBField.initInt32(0);
    public final PBInt32Field acttype = PBField.initInt32(0);
    public final PBUInt64Field uin_disable = PBField.initUInt64(0L);
  }
  
  public static final class SigactRsp
    extends MessageMicro<SigactRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "rank" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SigactRsp.class);
    public final PBUInt32Field rank = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class SigauthReq
    extends MessageMicro<SigauthReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field fontid = PBField.initInt32(0);
    public final PBInt32Field itemid = PBField.initInt32(0);
    public final PBInt32Field len = PBField.initInt32(0);
    public final PBUInt64Field uin_disable = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uin_disable", "itemid", "len", "data", "fontid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SigauthReq.class);
    }
  }
  
  public static final class SigauthRsp
    extends MessageMicro<SigauthRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field authfailed_appid = PBField.initInt32(0);
    public final PBBytesField result = PBField.initBytes(ByteStringMicro.EMPTY);
    public TipsInfo tips_info = new TipsInfo();
    public final PBStringField url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "result", "url", "tips_info", "authfailed_appid" }, new Object[] { localByteStringMicro, "", null, Integer.valueOf(0) }, SigauthRsp.class);
    }
    
    public static final class TipsInfo
      extends MessageMicro<TipsInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 72, 82 }, new String[] { "valid", "ret", "type", "title_wording", "wording", "right_btn_wording", "left_btn_wording", "vip_type", "vip_month", "url" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "" }, TipsInfo.class);
      public final PBStringField left_btn_wording = PBField.initString("");
      public final PBInt32Field ret = PBField.initInt32(0);
      public final PBStringField right_btn_wording = PBField.initString("");
      public final PBStringField title_wording = PBField.initString("");
      public final PBUInt32Field type = PBField.initUInt32(0);
      public final PBStringField url = PBField.initString("");
      public final PBBoolField valid = PBField.initBool(false);
      public final PBUInt32Field vip_month = PBField.initUInt32(0);
      public final PBStringField vip_type = PBField.initString("");
      public final PBStringField wording = PBField.initString("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.signature.SigActPb
 * JD-Core Version:    0.7.0.1
 */