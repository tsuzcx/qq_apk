package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class preAuth
{
  public static final class PreAuthProxyRequest
    extends MessageMicro<PreAuthProxyRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "appid" }, new Object[] { Long.valueOf(0L) }, PreAuthProxyRequest.class);
    public final PBInt64Field appid = PBField.initInt64(0L);
  }
  
  public static final class PreAuthRequest
    extends MessageMicro<PreAuthRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 82, 90, 96, 106, 160, 168, 178, 184, 402, 522, 562 }, new String[] { "appid", "sdkp", "sdkv", "icons", "qqv", "os", "scope", "skey", "md5time", "sign", "app_type", "channel_source", "appUniqueIdentifier", "referer", "proxy_req", "login_sig", "url_encoded_data" }, new Object[] { Long.valueOf(0L), "", "", "", "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(1), null, null, "" }, PreAuthRequest.class);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBInt64Field appid = PBField.initInt64(0L);
    public final PBInt64Field channel_source = PBField.initInt64(0L);
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public appType.LoginSig login_sig = new appType.LoginSig();
    public final PBInt64Field md5time = PBField.initInt64(0L);
    public final PBStringField os = PBField.initString("");
    public preAuth.PreAuthProxyRequest proxy_req = new preAuth.PreAuthProxyRequest();
    public final PBStringField qqv = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBStringField scope = PBField.initString("");
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField sdkv = PBField.initString("");
    public final PBStringField sign = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public final PBStringField url_encoded_data = PBField.initString("");
  }
  
  public static final class PreAuthResponse
    extends MessageMicro<PreAuthResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 50, 122, 130, 162, 170, 322, 328 }, new String[] { "ret", "msg", "appid", "app_name", "icons_url", "android_info", "ios_info", "auth_items", "authorized_union_text", "profiles", "vid" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), "", null, null, null, null, "", null, Long.valueOf(0L) }, PreAuthResponse.class);
    public appType.AndroidInfo android_info = new appType.AndroidInfo();
    public final PBStringField app_name = PBField.initString("");
    public final PBInt64Field appid = PBField.initInt64(0L);
    public final PBRepeatMessageField<appType.AuthItem> auth_items = PBField.initRepeatMessage(appType.AuthItem.class);
    public final PBStringField authorized_union_text = PBField.initString("");
    public final PBRepeatMessageField<appType.MsgIconsurl> icons_url = PBField.initRepeatMessage(appType.MsgIconsurl.class);
    public appType.IOSInfo ios_info = new appType.IOSInfo();
    public final PBStringField msg = PBField.initString("");
    public final PBRepeatMessageField<preAuth.VirtualProfile> profiles = PBField.initRepeatMessage(preAuth.VirtualProfile.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public final PBUInt64Field vid = PBField.initUInt64(0L);
  }
  
  public static final class VirtualProfile
    extends MessageMicro<VirtualProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "vid", "nick_name", "avatar_url" }, new Object[] { Long.valueOf(0L), "", "" }, VirtualProfile.class);
    public final PBStringField avatar_url = PBField.initString("");
    public final PBStringField nick_name = PBField.initString("");
    public final PBUInt64Field vid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qconn.protofile.preAuth
 * JD-Core Version:    0.7.0.1
 */