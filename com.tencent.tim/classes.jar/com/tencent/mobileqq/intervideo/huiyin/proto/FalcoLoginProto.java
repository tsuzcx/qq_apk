package com.tencent.mobileqq.intervideo.huiyin.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FalcoLoginProto
{
  public static final class ForbidInfo
    extends MessageMicro<ForbidInfo>
  {
    public static final int ALERT_TIPS_FIELD_NUMBER = 6;
    public static final int EFFECT_TIME_FIELD_NUMBER = 3;
    public static final int END_TIME_FIELD_NUMBER = 4;
    public static final int FORBID_FOREVER_FIELD_NUMBER = 5;
    public static final int PUNISH_TYPE_FIELD_NUMBER = 2;
    public static final int TINY_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "tiny_id", "punish_type", "effect_time", "end_time", "forbid_forever", "alert_tips" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), "" }, ForbidInfo.class);
    public final PBStringField alert_tips = PBField.initString("");
    public final PBUInt64Field effect_time = PBField.initUInt64(0L);
    public final PBUInt64Field end_time = PBField.initUInt64(0L);
    public final PBBoolField forbid_forever = PBField.initBool(false);
    public final PBUInt32Field punish_type = PBField.initUInt32(0);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0L);
  }
  
  public static final class GetWxTokenReq
    extends MessageMicro<GetWxTokenReq>
  {
    public static final int CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "code" }, new Object[] { "" }, GetWxTokenReq.class);
    public final PBStringField code = PBField.initString("");
  }
  
  public static final class GetWxTokenRsp
    extends MessageMicro<GetWxTokenRsp>
  {
    public static final int ACCESS_TOKEN_FIELD_NUMBER = 1;
    public static final int ERRCODE_FIELD_NUMBER = 6;
    public static final int ERRMSG_FIELD_NUMBER = 7;
    public static final int EXPIRES_IN_FIELD_NUMBER = 2;
    public static final int OPENID_FIELD_NUMBER = 4;
    public static final int REFRESH_TOKEN_FIELD_NUMBER = 3;
    public static final int SCOPE_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "access_token", "expires_in", "refresh_token", "openid", "scope", "errcode", "errmsg" }, new Object[] { "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, GetWxTokenRsp.class);
    public final PBStringField access_token = PBField.initString("");
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field expires_in = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField refresh_token = PBField.initString("");
    public final PBStringField scope = PBField.initString("");
  }
  
  public static final class LoginCheckReq
    extends MessageMicro<LoginCheckReq>
  {
    public static final int IS_TEST_FIELD_NUMBER = 2;
    public static final int REFRESH_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "refresh", "is_test" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) }, LoginCheckReq.class);
    public final PBBoolField is_test = PBField.initBool(false);
    public final PBBoolField refresh = PBField.initBool(false);
  }
  
  public static final class LoginCheckRsp
    extends MessageMicro<LoginCheckRsp>
  {
    public static final int A2_KEY_FIELD_NUMBER = 6;
    public static final int EX_FIELD_NUMBER = 11;
    public static final int IS_FIRST_LOGIN_FIELD_NUMBER = 10;
    public static final int IS_NOT_REGISTERED_FIELD_NUMBER = 9;
    public static final int RESULT_FIELD_NUMBER = 1;
    public static final int SERVER_TIME_FIELD_NUMBER = 8;
    public static final int SIG_EXPIRE_FIELD_NUMBER = 7;
    public static final int TINYID_FIELD_NUMBER = 5;
    public static final int UIN_FIELD_NUMBER = 3;
    public static final int USER_NAME_FIELD_NUMBER = 2;
    public static final int USER_SIG_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField a2_key = PBField.initString("");
    public final PBBytesField ex = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField is_first_login = PBField.initBool(false);
    public final PBBoolField is_not_registered = PBField.initBool(true);
    public FalcoLoginProto.RetInfo result = new FalcoLoginProto.RetInfo();
    public final PBUInt64Field server_time = PBField.initUInt64(0L);
    public final PBUInt32Field sig_expire = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBStringField user_name = PBField.initString("");
    public final PBStringField user_sig = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 56, 64, 72, 80, 90 }, new String[] { "result", "user_name", "uin", "user_sig", "tinyid", "a2_key", "sig_expire", "server_time", "is_not_registered", "is_first_login", "ex" }, new Object[] { null, "", Long.valueOf(0L), "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(true), Boolean.valueOf(false), localByteStringMicro }, LoginCheckRsp.class);
    }
  }
  
  public static final class RetInfo
    extends MessageMicro<RetInfo>
  {
    public static final int ERR_CODE_FIELD_NUMBER = 1;
    public static final int ERR_MSG_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "err_code", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, RetInfo.class);
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
  }
  
  public static final class UpdateWxTokenReq
    extends MessageMicro<UpdateWxTokenReq>
  {
    public static final int REFRESH_TOKEN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "refresh_token" }, new Object[] { "" }, UpdateWxTokenReq.class);
    public final PBStringField refresh_token = PBField.initString("");
  }
  
  public static final class UpdateWxTokenRsp
    extends MessageMicro<UpdateWxTokenRsp>
  {
    public static final int ACCESS_TOKEN_FIELD_NUMBER = 1;
    public static final int ERRCODE_FIELD_NUMBER = 6;
    public static final int ERRMSG_FIELD_NUMBER = 7;
    public static final int EXPIRES_IN_FIELD_NUMBER = 2;
    public static final int OPENID_FIELD_NUMBER = 4;
    public static final int REFRESH_TOKEN_FIELD_NUMBER = 3;
    public static final int SCOPE_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58 }, new String[] { "access_token", "expires_in", "refresh_token", "openid", "scope", "errcode", "errmsg" }, new Object[] { "", Integer.valueOf(0), "", "", "", Integer.valueOf(0), "" }, UpdateWxTokenRsp.class);
    public final PBStringField access_token = PBField.initString("");
    public final PBUInt32Field errcode = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBUInt32Field expires_in = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField refresh_token = PBField.initString("");
    public final PBStringField scope = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.proto.FalcoLoginProto
 * JD-Core Version:    0.7.0.1
 */