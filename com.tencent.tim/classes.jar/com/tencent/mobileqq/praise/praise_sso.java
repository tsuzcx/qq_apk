package com.tencent.mobileqq.praise;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class praise_sso
{
  public static final class TPraiseSsoReq
    extends MessageMicro<TPraiseSsoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "i32_cmd", "i32_implat", "str_qq_ver", "st_cmd0x1_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null }, TPraiseSsoReq.class);
    public final PBInt32Field i32_cmd = PBField.initInt32(0);
    public final PBInt32Field i32_implat = PBField.initInt32(0);
    public praise_sso.TSsoCmd0x1Req st_cmd0x1_req = new praise_sso.TSsoCmd0x1Req();
    public final PBStringField str_qq_ver = PBField.initString("");
  }
  
  public static final class TPraiseSsoRsp
    extends MessageMicro<TPraiseSsoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_ret", "st_cmd0x1_rsp" }, new Object[] { Integer.valueOf(0), null }, TPraiseSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public praise_sso.TSsoCmd0x1Rsp st_cmd0x1_rsp = new praise_sso.TSsoCmd0x1Rsp();
  }
  
  public static final class TSsoCmd0x1Req
    extends MessageMicro<TSsoCmd0x1Req>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "i32_itemId" }, new Object[] { Integer.valueOf(0) }, TSsoCmd0x1Req.class);
    public final PBInt32Field i32_itemId = PBField.initInt32(0);
  }
  
  public static final class TSsoCmd0x1Rsp
    extends MessageMicro<TSsoCmd0x1Rsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_itemId", "str_url" }, new Object[] { Integer.valueOf(0), "" }, TSsoCmd0x1Rsp.class);
    public final PBInt32Field i32_itemId = PBField.initInt32(0);
    public final PBStringField str_url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.praise.praise_sso
 * JD-Core Version:    0.7.0.1
 */