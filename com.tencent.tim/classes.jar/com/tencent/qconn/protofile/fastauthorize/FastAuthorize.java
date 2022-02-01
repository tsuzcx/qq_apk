package com.tencent.qconn.protofile.fastauthorize;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class FastAuthorize
{
  public static final class AuthorizeRequest
    extends MessageMicro<AuthorizeRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 42, 50, 58, 66, 74, 80, 90, 98, 106 }, new String[] { "uin", "client_id", "pf", "qqv", "sdkp", "skey", "vkey", "version", "flags", "os", "sid", "apk_sign" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "1.0", Integer.valueOf(0), "", "", "" }, AuthorizeRequest.class);
    public final PBStringField apk_sign = PBField.initString("");
    public final PBInt64Field client_id = PBField.initInt64(0L);
    public final PBInt32Field flags = PBField.initInt32(0);
    public final PBStringField os = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sid = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBStringField version = PBField.initString("1.0");
    public final PBStringField vkey = PBField.initString("");
  }
  
  public static final class AuthorizeResponse
    extends MessageMicro<AuthorizeResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "ret", "msg", "access_token", "expires_in", "openid", "pay_token", "encrytoken", "pf", "pfkey", "encrykey", "md5key", "apk_name" }, new Object[] { "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "", "" }, AuthorizeResponse.class);
    public final PBStringField access_token = PBField.initString("");
    public final PBStringField apk_name = PBField.initString("");
    public final PBStringField encrykey = PBField.initString("");
    public final PBStringField encrytoken = PBField.initString("");
    public final PBInt64Field expires_in = PBField.initInt64(0L);
    public final PBStringField md5key = PBField.initString("");
    public final PBStringField msg = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
    public final PBStringField pay_token = PBField.initString("");
    public final PBStringField pf = PBField.initString("");
    public final PBStringField pfkey = PBField.initString("");
    public final PBStringField ret = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.fastauthorize.FastAuthorize
 * JD-Core Version:    0.7.0.1
 */