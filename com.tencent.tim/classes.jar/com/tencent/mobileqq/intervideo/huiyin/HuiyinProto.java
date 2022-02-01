package com.tencent.mobileqq.intervideo.huiyin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HuiyinProto
{
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
    public static final int IS_NEW_USER_FIELD_NUMBER = 9;
    public static final int RESULT_FIELD_NUMBER = 1;
    public static final int SERVER_TIME_FIELD_NUMBER = 8;
    public static final int SIG_EXPIRE_FIELD_NUMBER = 7;
    public static final int UID_FIELD_NUMBER = 5;
    public static final int UIN_FIELD_NUMBER = 3;
    public static final int USER_NAME_FIELD_NUMBER = 2;
    public static final int USER_SIG_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50, 56, 64, 72 }, new String[] { "result", "user_name", "uin", "user_sig", "uid", "a2_key", "sig_expire", "server_time", "is_new_user" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false) }, LoginCheckRsp.class);
    public final PBStringField a2_key = PBField.initString("");
    public final PBBoolField is_new_user = PBField.initBool(false);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt64Field server_time = PBField.initUInt64(0L);
    public final PBUInt32Field sig_expire = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBInt64Field uin = PBField.initInt64(0L);
    public final PBStringField user_name = PBField.initString("");
    public final PBStringField user_sig = PBField.initString("");
  }
  
  public static final class commRequest
    extends MessageMicro<commRequest>
  {
    public static final int A2_KEY_FIELD_NUMBER = 22;
    public static final int APP_NAME_FIELD_NUMBER = 2;
    public static final int AUTH_APPID_FIELD_NUMBER = 11;
    public static final int AUTH_IP_FIELD_NUMBER = 10;
    public static final int AUTH_KEY_FIELD_NUMBER = 8;
    public static final int AUTH_TYPE_FIELD_NUMBER = 9;
    public static final int BODY_FIELD_NUMBER = 15;
    public static final int BUSINESS_FIELD_NUMBER = 7;
    public static final int CLIENT_IP_FIELD_NUMBER = 5;
    public static final int CLIENT_RELEASE_FIELD_NUMBER = 18;
    public static final int CLIENT_TYPE_FIELD_NUMBER = 17;
    public static final int CMD_FIELD_NUMBER = 3;
    public static final int FROM_ID_FIELD_NUMBER = 21;
    public static final int MICROTIME_FIELD_NUMBER = 16;
    public static final int NETWORK_FIELD_NUMBER = 20;
    public static final int OPENID_FIELD_NUMBER = 14;
    public static final int SEQ_FIELD_NUMBER = 4;
    public static final int SERVICE_IP_FIELD_NUMBER = 6;
    public static final int UID_FIELD_NUMBER = 12;
    public static final int UIN_FIELD_NUMBER = 13;
    public static final int USER_SIG_FIELD_NUMBER = 19;
    public static final int VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField a2_key = PBField.initString("");
    public final PBStringField app_name = PBField.initString("");
    public final PBUInt64Field auth_appid = PBField.initUInt64(0L);
    public final PBStringField auth_ip = PBField.initString("");
    public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField auth_type = PBField.initEnum(0);
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField business = PBField.initString("");
    public final PBStringField client_ip = PBField.initString("");
    public final PBStringField client_release = PBField.initString("");
    public final PBEnumField client_type = PBField.initEnum(0);
    public final PBUInt32Field cmd = PBField.initUInt32(0);
    public final PBStringField from_id = PBField.initString("");
    public final PBUInt64Field microtime = PBField.initUInt64(0L);
    public final PBEnumField network = PBField.initEnum(-1);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBStringField service_ip = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField user_sig = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(1);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 58, 66, 72, 82, 88, 96, 104, 114, 122, 128, 136, 146, 154, 160, 170, 178 }, new String[] { "version", "app_name", "cmd", "seq", "client_ip", "service_ip", "business", "auth_key", "auth_type", "auth_ip", "auth_appid", "uid", "uin", "openid", "body", "microtime", "client_type", "client_release", "user_sig", "network", "from_id", "a2_key" }, new Object[] { Integer.valueOf(1), "", Integer.valueOf(0), Long.valueOf(0L), "", "", "", localByteStringMicro1, Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(-1), "", "" }, commRequest.class);
    }
  }
  
  public static final class commResponse
    extends MessageMicro<commResponse>
  {
    public static final int BODY_FIELD_NUMBER = 4;
    public static final int CODE_FIELD_NUMBER = 2;
    public static final int MSG_FIELD_NUMBER = 3;
    public static final int SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField body = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field code = PBField.initInt32(0);
    public final PBStringField msg = PBField.initString("");
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "seq", "code", "msg", "body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", localByteStringMicro }, commResponse.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huiyin.HuiyinProto
 * JD-Core Version:    0.7.0.1
 */