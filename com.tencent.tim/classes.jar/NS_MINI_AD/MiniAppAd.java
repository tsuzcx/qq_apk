package NS_MINI_AD;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MiniAppAd
{
  public static final class ContextInfo
    extends MessageMicro<ContextInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field article_id = PBField.initUInt64(0L);
    public final PBRepeatField<Long> existed_mini_program_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field public_id = PBField.initUInt64(0L);
    public final PBUInt32Field source_from = PBField.initUInt32(0);
    public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
    public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56 }, new String[] { "public_id", "article_id", "tribe_tag", "tribe_id_tag", "source_from", "page_url", "existed_mini_program_ids" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, ContextInfo.class);
    }
  }
  
  public static final class DebugInfo
    extends MessageMicro<DebugInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "debug_adindexid", "nomatch", "debug" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(false) }, DebugInfo.class);
    public final PBBoolField debug = PBField.initBool(false);
    public final PBUInt32Field debug_adindexid = PBField.initUInt32(0);
    public final PBBoolField nomatch = PBField.initBool(false);
  }
  
  public static final class DeviceInfo
    extends MessageMicro<DeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 128, 138, 146, 154, 162, 168, 176, 186, 194, 202, 210, 218, 226 }, new String[] { "muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "device_orientation", "android_imei", "ios_idfa", "android_id", "mac", "is_googleplay_version", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Boolean.valueOf(false), "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), "", "", "", "", "", "" }, DeviceInfo.class);
    public final PBStringField aid_ticket = PBField.initString("");
    public final PBStringField android_id = PBField.initString("");
    public final PBStringField android_imei = PBField.initString("");
    public final PBUInt32Field app_version_id = PBField.initUInt32(0);
    public final PBUInt32Field carrier_code = PBField.initUInt32(0);
    public final PBStringField client_ip = PBField.initString("");
    public final PBStringField client_ipv4 = PBField.initString("");
    public final PBUInt32Field conn = PBField.initUInt32(0);
    public final PBStringField device_brand_and_model = PBField.initString("");
    public final PBUInt32Field device_orientation = PBField.initUInt32(0);
    public final PBStringField ios_idfa = PBField.initString("");
    public final PBStringField ios_qidfa = PBField.initString("");
    public final PBBoolField is_googleplay_version = PBField.initBool(false);
    public final PBBoolField is_ios_review_state = PBField.initBool(false);
    public final PBBoolField is_wk_webview = PBField.initBool(false);
    public MiniAppAd.Location location = new MiniAppAd.Location();
    public final PBStringField mac = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField md5_android_id = PBField.initString("");
    public final PBStringField md5_mac = PBField.initString("");
    public final PBStringField muid = PBField.initString("");
    public final PBUInt32Field muid_type = PBField.initUInt32(0);
    public final PBStringField oaid = PBField.initString("");
    public final PBUInt32Field os_type = PBField.initUInt32(0);
    public final PBStringField os_ver = PBField.initString("");
    public final PBStringField qadid = PBField.initString("");
    public final PBStringField qq_ver = PBField.initString("");
    public final PBStringField taid_ticket = PBField.initString("");
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinates_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
    public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
  }
  
  public static final class PositionExt
    extends MessageMicro<PositionExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, "" }, PositionExt.class);
    public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
    public final PBEnumField get_ad_type = PBField.initEnum(0);
    public MiniAppAd.ShareInfo share_info = new MiniAppAd.ShareInfo();
    public final PBRepeatMessageField<MiniAppAd.SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(MiniAppAd.SpecifiedAdsItem.class);
    public final PBStringField sub_position_id = PBField.initString("");
  }
  
  public static final class PositionInfo
    extends MessageMicro<PositionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pos_id", "ad_count", "pos_ext" }, new Object[] { "", Integer.valueOf(0), null }, PositionInfo.class);
    public final PBUInt32Field ad_count = PBField.initUInt32(0);
    public MiniAppAd.PositionExt pos_ext = new MiniAppAd.PositionExt();
    public final PBStringField pos_id = PBField.initString("");
  }
  
  public static final class ShareInfo
    extends MessageMicro<ShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "share_rate", "share_check" }, new Object[] { Integer.valueOf(0), "" }, ShareInfo.class);
    public final PBStringField share_check = PBField.initString("");
    public final PBUInt32Field share_rate = PBField.initUInt32(0);
  }
  
  public static final class SpecifiedAdsItem
    extends MessageMicro<SpecifiedAdsItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "aid", "creative_id", "prefetch_timestamp" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, SpecifiedAdsItem.class);
    public final PBUInt64Field aid = PBField.initUInt64(0L);
    public final PBUInt64Field creative_id = PBField.initUInt64(0L);
    public final PBUInt32Field prefetch_timestamp = PBField.initUInt32(0);
  }
  
  public static final class StAdPageFlipTemplate
    extends MessageMicro<StAdPageFlipTemplate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "ad_type", "effect_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StAdPageFlipTemplate.class);
    public final PBInt32Field ad_type = PBField.initInt32(0);
    public final PBInt32Field effect_id = PBField.initInt32(0);
  }
  
  public static final class StAppAdInfo
    extends MessageMicro<StAppAdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "strAppId", "iPosition", "strAdInfo" }, new Object[] { "", Long.valueOf(0L), "" }, StAppAdInfo.class);
    public final PBInt64Field iPosition = PBField.initInt64(0L);
    public final PBStringField strAdInfo = PBField.initString("");
    public final PBStringField strAppId = PBField.initString("");
  }
  
  public static final class StAppPlayingFriList
    extends MessageMicro<StAppPlayingFriList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "strAppId", "vecFriUin", "total" }, new Object[] { "", Long.valueOf(0L), Integer.valueOf(0) }, StAppPlayingFriList.class);
    public final PBStringField strAppId = PBField.initString("");
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatField<Long> vecFriUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class StBatchGetAppPlayingFriReq
    extends MessageMicro<StBatchGetAppPlayingFriReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppId" }, new Object[] { null, "" }, StBatchGetAppPlayingFriReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> vecAppId = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StBatchGetAppPlayingFriRsp
    extends MessageMicro<StBatchGetAppPlayingFriRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "vecAppPlayingFri" }, new Object[] { null, null }, StBatchGetAppPlayingFriRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<MiniAppAd.StAppPlayingFriList> vecAppPlayingFri = PBField.initRepeatMessage(MiniAppAd.StAppPlayingFriList.class);
  }
  
  public static final class StGetAdForSdkReq
    extends MessageMicro<StGetAdForSdkReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "strGetAdUrl", "mapParam", "strAppid", "iAdType" }, new Object[] { null, "", null, "", Integer.valueOf(0) }, StGetAdForSdkReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field iAdType = PBField.initInt32(0);
    public final PBRepeatMessageField<COMM.Entry> mapParam = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBStringField strAppid = PBField.initString("");
    public final PBStringField strGetAdUrl = PBField.initString("");
  }
  
  public static final class StGetAdForSdkRsp
    extends MessageMicro<StGetAdForSdkRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "strAdRspJson" }, new Object[] { null, "" }, StGetAdForSdkRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAdRspJson = PBField.initString("");
  }
  
  public static final class StGetAdReq
    extends MessageMicro<StGetAdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 16010 }, new String[] { "extInfo", "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https", "appid", "ad_type", "busi_cookie" }, new Object[] { null, null, null, null, null, null, "", Boolean.valueOf(false), "", Integer.valueOf(0), "" }, StGetAdReq.class);
    public final PBInt32Field ad_type = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField busi_cookie = PBField.initString("");
    public MiniAppAd.ContextInfo context_info = new MiniAppAd.ContextInfo();
    public MiniAppAd.DebugInfo debug_info = new MiniAppAd.DebugInfo();
    public MiniAppAd.DeviceInfo device_info = new MiniAppAd.DeviceInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBRepeatMessageField<MiniAppAd.PositionInfo> position_info = PBField.initRepeatMessage(MiniAppAd.PositionInfo.class);
    public final PBBoolField support_https = PBField.initBool(false);
    public MiniAppAd.UserInfo user_info = new MiniAppAd.UserInfo();
  }
  
  public static final class StGetAdRsp
    extends MessageMicro<StGetAdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "extInfo", "strAdsJson", "strAdTemplateJson", "iTestId", "vecAppInfo", "iPreLoadLevel" }, new Object[] { null, "", "", Long.valueOf(0L), null, Long.valueOf(0L) }, StGetAdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt64Field iPreLoadLevel = PBField.initInt64(0L);
    public final PBInt64Field iTestId = PBField.initInt64(0L);
    public final PBStringField strAdTemplateJson = PBField.initString("");
    public final PBStringField strAdsJson = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StApiAppInfo> vecAppInfo = PBField.initRepeatMessage(INTERFACE.StApiAppInfo.class);
  }
  
  public static final class StGetDropdownAppAdListReq
    extends MessageMicro<StGetDropdownAppAdListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "extInfo", "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https" }, new Object[] { null, null, null, null, null, null, "", Boolean.valueOf(false) }, StGetDropdownAppAdListReq.class);
    public MiniAppAd.ContextInfo context_info = new MiniAppAd.ContextInfo();
    public MiniAppAd.DebugInfo debug_info = new MiniAppAd.DebugInfo();
    public MiniAppAd.DeviceInfo device_info = new MiniAppAd.DeviceInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBRepeatMessageField<MiniAppAd.PositionInfo> position_info = PBField.initRepeatMessage(MiniAppAd.PositionInfo.class);
    public final PBBoolField support_https = PBField.initBool(false);
    public MiniAppAd.UserInfo user_info = new MiniAppAd.UserInfo();
  }
  
  public static final class StGetDropdownAppAdListRsp
    extends MessageMicro<StGetDropdownAppAdListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "vecAppAdInfo", "gdt_cookie" }, new Object[] { null, null, "" }, StGetDropdownAppAdListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBRepeatMessageField<MiniAppAd.StAppAdInfo> vecAppAdInfo = PBField.initRepeatMessage(MiniAppAd.StAppAdInfo.class);
  }
  
  public static final class StGetPopAdBannerReq
    extends MessageMicro<StGetPopAdBannerReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "strAppId", "strRefer" }, new Object[] { null, "", "" }, StGetPopAdBannerReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAppId = PBField.initString("");
    public final PBStringField strRefer = PBField.initString("");
  }
  
  public static final class StGetPopAdBannerRsp
    extends MessageMicro<StGetPopAdBannerRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "strAdTitle", "strImgUrl", "strJumpUrl", "strAdTrace" }, new Object[] { null, "", "", "", "" }, StGetPopAdBannerRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strAdTitle = PBField.initString("");
    public final PBStringField strAdTrace = PBField.initString("");
    public final PBStringField strImgUrl = PBField.initString("");
    public final PBStringField strJumpUrl = PBField.initString("");
  }
  
  public static final class StGetSdkAdInfoReq
    extends MessageMicro<StGetSdkAdInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "strSubPosId", "strAppid", "iAdType" }, new Object[] { null, "", "", Integer.valueOf(0) }, StGetSdkAdInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field iAdType = PBField.initInt32(0);
    public final PBStringField strAppid = PBField.initString("");
    public final PBStringField strSubPosId = PBField.initString("");
  }
  
  public static final class StGetSdkAdInfoRsp
    extends MessageMicro<StGetSdkAdInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "strSourceFrom", "strMiniCategory", "strPosId" }, new Object[] { null, "", "", "" }, StGetSdkAdInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField strMiniCategory = PBField.initString("");
    public final PBStringField strPosId = PBField.initString("");
    public final PBStringField strSourceFrom = PBField.initString("");
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid" }, new Object[] { Long.valueOf(0L), "", "", "", Long.valueOf(0L), "" }, UserInfo.class);
    public final PBStringField media_specified_id = PBField.initString("");
    public final PBUInt64Field qq = PBField.initUInt64(0L);
    public final PBUInt64Field qq_appid = PBField.initUInt64(0L);
    public final PBStringField qq_openid = PBField.initString("");
    public final PBStringField wx_appid = PBField.initString("");
    public final PBStringField wx_openid = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_AD.MiniAppAd
 * JD-Core Version:    0.7.0.1
 */