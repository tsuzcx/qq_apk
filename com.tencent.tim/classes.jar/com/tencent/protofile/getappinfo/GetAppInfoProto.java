package com.tencent.protofile.getappinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qconn.protofile.appType.LoginSig;

public final class GetAppInfoProto
{
  public static final class Ads
    extends MessageMicro<Ads>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "imgURL", "txt", "beginTime", "endTime", "serverTime" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, Ads.class);
    public final PBInt64Field beginTime = PBField.initInt64(0L);
    public final PBInt64Field endTime = PBField.initInt64(0L);
    public final PBStringField imgURL = PBField.initString("");
    public final PBInt64Field serverTime = PBField.initInt64(0L);
    public final PBStringField txt = PBField.initString("");
  }
  
  public static final class AndroidInfo
    extends MessageMicro<AndroidInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "apkDownUrl", "packName", "className", "sourceUrl", "officalwebsite", "messagetail", "bundleid" }, new Object[] { "", "", "", "", "", "", "" }, AndroidInfo.class);
    public final PBStringField apkDownUrl = PBField.initString("");
    public final PBStringField bundleid = PBField.initString("");
    public final PBStringField className = PBField.initString("");
    public final PBStringField messagetail = PBField.initString("");
    public final PBStringField officalwebsite = PBField.initString("");
    public final PBStringField packName = PBField.initString("");
    public final PBStringField sourceUrl = PBField.initString("");
  }
  
  public static final class GetAppinfoRequest
    extends MessageMicro<GetAppinfoRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64, 72, 80, 88, 98, 514, 522 }, new String[] { "client_id", "sdkp", "icons", "qqv", "os", "md5time", "signature", "need_ads", "app_type", "channel_source", "referer", "appUniqueIdentifier", "skey", "login_sig" }, new Object[] { Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(1), "", "", null }, GetAppinfoRequest.class);
    public final PBStringField appUniqueIdentifier = PBField.initString("");
    public final PBEnumField app_type = PBField.initEnum(0);
    public final PBInt64Field channel_source = PBField.initInt64(0L);
    public final PBInt64Field client_id = PBField.initInt64(0L);
    public final PBRepeatField<String> icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public appType.LoginSig login_sig = new appType.LoginSig();
    public final PBInt64Field md5time = PBField.initInt64(0L);
    public final PBSInt32Field need_ads = PBField.initSInt32(0);
    public final PBStringField os = PBField.initString("");
    public final PBStringField qqv = PBField.initString("");
    public final PBEnumField referer = PBField.initEnum(1);
    public final PBStringField sdkp = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
  }
  
  public static final class GetAppinfoResponse
    extends MessageMicro<GetAppinfoResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 90 }, new String[] { "ret", "msg", "appName", "appComment", "providerName", "appClass", "iconsURL", "androidInfo", "iosInfo", "client_id", "ads" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", null, null, null, Long.valueOf(0L), null }, GetAppinfoResponse.class);
    public GetAppInfoProto.Ads ads = new GetAppInfoProto.Ads();
    public GetAppInfoProto.AndroidInfo androidInfo = new GetAppInfoProto.AndroidInfo();
    public final PBStringField appClass = PBField.initString("");
    public final PBStringField appComment = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public final PBInt64Field client_id = PBField.initInt64(0L);
    public final PBRepeatMessageField<GetAppInfoProto.MsgIconsurl> iconsURL = PBField.initRepeatMessage(GetAppInfoProto.MsgIconsurl.class);
    public GetAppInfoProto.IOSInfo iosInfo = new GetAppInfoProto.IOSInfo();
    public final PBStringField msg = PBField.initString("");
    public final PBStringField providerName = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class IOSInfo
    extends MessageMicro<IOSInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "urlSchema", "boundleID", "appstoreID", "sourceUrl", "officalwebsite", "messagetail", "a_bundleid" }, new Object[] { "", "", "", "", "", "", "" }, IOSInfo.class);
    public final PBStringField a_bundleid = PBField.initString("");
    public final PBStringField appstoreID = PBField.initString("");
    public final PBStringField boundleID = PBField.initString("");
    public final PBStringField messagetail = PBField.initString("");
    public final PBStringField officalwebsite = PBField.initString("");
    public final PBStringField sourceUrl = PBField.initString("");
    public final PBStringField urlSchema = PBField.initString("");
  }
  
  public static final class MsgIconsurl
    extends MessageMicro<MsgIconsurl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "size", "url" }, new Object[] { "", "" }, MsgIconsurl.class);
    public final PBStringField size = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.getappinfo.GetAppInfoProto
 * JD-Core Version:    0.7.0.1
 */