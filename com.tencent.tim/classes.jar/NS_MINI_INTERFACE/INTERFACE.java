package NS_MINI_INTERFACE;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.Result;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_META.META_PROTOCOL.StAppInfo;
import NS_MINI_META.META_PROTOCOL.StDeveloperInfo;
import NS_MINI_META.META_PROTOCOL.StServerDomainInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class INTERFACE
{
  public static final class CommContentSetRsp
    extends MessageMicro<CommContentSetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "err_code", "err_msg" }, new Object[] { Integer.valueOf(0), "" }, CommContentSetRsp.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
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
    public INTERFACE.Location location = new INTERFACE.Location();
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
  
  public static final class GuardInstruction
    extends MessageMicro<GuardInstruction>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 57, 66 }, new String[] { "type", "title", "msg", "url", "modal", "data", "ratio", "ruleName" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", Double.valueOf(0.0D), "" }, GuardInstruction.class);
    public final PBStringField data = PBField.initString("");
    public final PBInt32Field modal = PBField.initInt32(0);
    public final PBStringField msg = PBField.initString("");
    public final PBDoubleField ratio = PBField.initDouble(0.0D);
    public final PBStringField ruleName = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class Location
    extends MessageMicro<Location>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinates_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
    public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
  }
  
  public static final class StAddPhoneNumberReq
    extends MessageMicro<StAddPhoneNumberReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "appId", "purePhoneNumber", "countryCode", "isSave" }, new Object[] { null, "", "", "", Integer.valueOf(0) }, StAddPhoneNumberReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField countryCode = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field isSave = PBField.initInt32(0);
    public final PBStringField purePhoneNumber = PBField.initString("");
  }
  
  public static final class StAddPhoneNumberRsp
    extends MessageMicro<StAddPhoneNumberRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "encryptedData", "iv" }, new Object[] { null, "", "" }, StAddPhoneNumberRsp.class);
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
  }
  
  public static final class StAddressInfo
    extends MessageMicro<StAddressInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "country", "province", "city" }, new Object[] { "", "", "" }, StAddressInfo.class);
    public final PBStringField city = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField province = PBField.initString("");
  }
  
  public static final class StApiAppInfo
    extends MessageMicro<StApiAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 154, 162, 170, 176, 186, 192, 202, 210, 216, 226, 234, 242, 250, 258, 266 }, new String[] { "appId", "appName", "icon", "donwLoadUrl", "version", "desc", "pubAccts", "type", "baselibMiniVersion", "subPkgs", "first", "domain", "appType", "mDebug", "versionId", "apiRight", "dataCache", "mainExt", "devInfo", "extData", "extGameCenter", "isRecommend", "serviceCategory", "supportOffline", "appMode", "operInfo", "skipDomainCheck", "extInfo", "extendData", "tags", "extConfig", "appNoCacheExt", "basicInfo" }, new Object[] { "", "", "", "", "", "", null, Integer.valueOf(0), "", null, null, null, Integer.valueOf(0), null, "", null, null, null, null, "", null, Integer.valueOf(0), "", Integer.valueOf(0), null, null, Integer.valueOf(0), null, "", "", null, null, null }, StApiAppInfo.class);
    public INTERFACE.StApiRightController apiRight = new INTERFACE.StApiRightController();
    public final PBStringField appId = PBField.initString("");
    public INTERFACE.StAppMode appMode = new INTERFACE.StAppMode();
    public final PBStringField appName = PBField.initString("");
    public INTERFACE.StAppFixInfoExt appNoCacheExt = new INTERFACE.StAppFixInfoExt();
    public final PBUInt32Field appType = PBField.initUInt32(0);
    public final PBStringField baselibMiniVersion = PBField.initString("");
    public INTERFACE.StAppBasicInfo basicInfo = new INTERFACE.StAppBasicInfo();
    public final PBRepeatMessageField<INTERFACE.StAppDataCache> dataCache = PBField.initRepeatMessage(INTERFACE.StAppDataCache.class);
    public final PBStringField desc = PBField.initString("");
    public INTERFACE.StDeveloperInfo devInfo = new INTERFACE.StDeveloperInfo();
    public INTERFACE.StDomainConfig domain = new INTERFACE.StDomainConfig();
    public final PBStringField donwLoadUrl = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StExtConfigInfo> extConfig = PBField.initRepeatMessage(INTERFACE.StExtConfigInfo.class);
    public final PBStringField extData = PBField.initString("");
    public INTERFACE.StGameCenterInfo extGameCenter = new INTERFACE.StGameCenterInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField extendData = PBField.initString("");
    public INTERFACE.StFirstPage first = new INTERFACE.StFirstPage();
    public final PBStringField icon = PBField.initString("");
    public final PBInt32Field isRecommend = PBField.initInt32(0);
    public INTERFACE.StMDebugInfo mDebug = new INTERFACE.StMDebugInfo();
    public INTERFACE.StMainPageExtInfo mainExt = new INTERFACE.StMainPageExtInfo();
    public INTERFACE.StOperationInfo operInfo = new INTERFACE.StOperationInfo();
    public final PBRepeatMessageField<INTERFACE.StPublicAccount> pubAccts = PBField.initRepeatMessage(INTERFACE.StPublicAccount.class);
    public final PBRepeatField<String> serviceCategory = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field skipDomainCheck = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StSubPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE.StSubPkgInfo.class);
    public final PBInt32Field supportOffline = PBField.initInt32(0);
    public final PBStringField tags = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField version = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
  }
  
  public static final class StApiAppMoreInfo
    extends MessageMicro<StApiAppMoreInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "appInfo", "developerInfo", "serverDomainInfo", "updateTime" }, new Object[] { null, null, null, Integer.valueOf(0) }, StApiAppMoreInfo.class);
    public META_PROTOCOL.StAppInfo appInfo = new META_PROTOCOL.StAppInfo();
    public META_PROTOCOL.StDeveloperInfo developerInfo = new META_PROTOCOL.StDeveloperInfo();
    public META_PROTOCOL.StServerDomainInfo serverDomainInfo = new META_PROTOCOL.StServerDomainInfo();
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
  }
  
  public static final class StApiRightController
    extends MessageMicro<StApiRightController>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "whiteLst", "blackLst", "secondApiRights" }, new Object[] { "", "", null }, StApiRightController.class);
    public final PBRepeatField<String> blackLst = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<INTERFACE.StApiRightItem> secondApiRights = PBField.initRepeatMessage(INTERFACE.StApiRightItem.class);
    public final PBRepeatField<String> whiteLst = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StApiRightItem
    extends MessageMicro<StApiRightItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "apiName", "secondName", "right" }, new Object[] { "", "", Integer.valueOf(0) }, StApiRightItem.class);
    public final PBStringField apiName = PBField.initString("");
    public final PBInt32Field right = PBField.initInt32(0);
    public final PBStringField secondName = PBField.initString("");
  }
  
  public static final class StApiUserInfo
    extends MessageMicro<StApiUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "nick", "avatar", "gender", "address", "language", "openid" }, new Object[] { "", "", Integer.valueOf(0), null, "", "" }, StApiUserInfo.class);
    public INTERFACE.StAddressInfo address = new INTERFACE.StAddressInfo();
    public final PBStringField avatar = PBField.initString("");
    public final PBInt32Field gender = PBField.initInt32(0);
    public final PBStringField language = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class StAppBasicInfo
    extends MessageMicro<StAppBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 64, 74, 82, 90, 98, 106, 114, 120, 130 }, new String[] { "operationTags", "feiqiziduan", "usrFileSizeLimit", "preCacheList", "versionUpdateTime", "noNeedRealRecommend", "pluginInfo", "pkgType", "renderInfo", "qualificationInfo", "shareId", "via", "ideConfig", "resourcePreCacheList", "splashScreenAd", "splashScreenAdId" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), null, "", "", "", null, null, Integer.valueOf(0), "" }, StAppBasicInfo.class);
    public final PBInt32Field feiqiziduan = PBField.initInt32(0);
    public INTERFACE.StIdeConfig ideConfig = new INTERFACE.StIdeConfig();
    public final PBInt32Field noNeedRealRecommend = PBField.initInt32(0);
    public final PBStringField operationTags = PBField.initString("");
    public final PBUInt32Field pkgType = PBField.initUInt32(0);
    public INTERFACE.StPluginInfo pluginInfo = new INTERFACE.StPluginInfo();
    public final PBRepeatMessageField<INTERFACE.StAppPreCacheInfo> preCacheList = PBField.initRepeatMessage(INTERFACE.StAppPreCacheInfo.class);
    public final PBRepeatField<String> qualificationInfo = PBField.initRepeat(PBStringField.__repeatHelper__);
    public INTERFACE.StRenderInfo renderInfo = new INTERFACE.StRenderInfo();
    public final PBRepeatMessageField<INTERFACE.StResourcePreCacheInfo> resourcePreCacheList = PBField.initRepeatMessage(INTERFACE.StResourcePreCacheInfo.class);
    public final PBStringField shareId = PBField.initString("");
    public final PBUInt32Field splashScreenAd = PBField.initUInt32(0);
    public final PBStringField splashScreenAdId = PBField.initString("");
    public final PBInt64Field usrFileSizeLimit = PBField.initInt64(0L);
    public final PBUInt32Field versionUpdateTime = PBField.initUInt32(0);
    public final PBStringField via = PBField.initString("");
  }
  
  public static final class StAppDataCache
    extends MessageMicro<StAppDataCache>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "wnsCgiUrl", "cacheKey" }, new Object[] { "", "" }, StAppDataCache.class);
    public final PBStringField cacheKey = PBField.initString("");
    public final PBStringField wnsCgiUrl = PBField.initString("");
  }
  
  public static final class StAppFixInfoExt
    extends MessageMicro<StAppFixInfoExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "clearAuths" }, new Object[] { Integer.valueOf(0) }, StAppFixInfoExt.class);
    public final PBInt32Field clearAuths = PBField.initInt32(0);
  }
  
  public static final class StAppMode
    extends MessageMicro<StAppMode>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "interMode", "authoritySilent", "keepOffPullList", "closeTopRightCapsule", "openNativeApi", "hideAppSearch", "isAppStore", "isWangKa", "interLoading", "closeWebviewBounce", "isLimitedAccess" }, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, StAppMode.class);
    public final PBBoolField authoritySilent = PBField.initBool(false);
    public final PBBoolField closeTopRightCapsule = PBField.initBool(false);
    public final PBBoolField closeWebviewBounce = PBField.initBool(false);
    public final PBBoolField hideAppSearch = PBField.initBool(false);
    public final PBBoolField interLoading = PBField.initBool(false);
    public final PBBoolField interMode = PBField.initBool(false);
    public final PBBoolField isAppStore = PBField.initBool(false);
    public final PBBoolField isLimitedAccess = PBField.initBool(false);
    public final PBBoolField isWangKa = PBField.initBool(false);
    public final PBBoolField keepOffPullList = PBField.initBool(false);
    public final PBBoolField openNativeApi = PBField.initBool(false);
  }
  
  public static final class StAppPath
    extends MessageMicro<StAppPath>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "path" }, new Object[] { "", "" }, StAppPath.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
  }
  
  public static final class StAppPreCacheInfo
    extends MessageMicro<StAppPreCacheInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "getDataUrl", "preCacheKey", "expireTime", "cacheType", "useProxy" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, StAppPreCacheInfo.class);
    public final PBInt32Field cacheType = PBField.initInt32(0);
    public final PBInt64Field expireTime = PBField.initInt64(0L);
    public final PBStringField getDataUrl = PBField.initString("");
    public final PBStringField preCacheKey = PBField.initString("");
    public final PBInt32Field useProxy = PBField.initInt32(0);
  }
  
  public static final class StAppVersionId
    extends MessageMicro<StAppVersionId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appId", "versionId" }, new Object[] { "", "" }, StAppVersionId.class);
    public final PBStringField appId = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
  }
  
  public static final class StBaseLibInfo
    extends MessageMicro<StBaseLibInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "version", "downloadUrl", "libType", "extInfo" }, new Object[] { "", "", Integer.valueOf(0), "" }, StBaseLibInfo.class);
    public final PBStringField downloadUrl = PBField.initString("");
    public final PBStringField extInfo = PBField.initString("");
    public final PBInt32Field libType = PBField.initInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class StBatchGetContactReq
    extends MessageMicro<StBatchGetContactReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "appids" }, new Object[] { "" }, StBatchGetContactReq.class);
    public final PBRepeatField<String> appids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StBatchGetContactRsp
    extends MessageMicro<StBatchGetContactRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "contactList" }, new Object[] { null }, StBatchGetContactRsp.class);
    public final PBRepeatMessageField<INTERFACE.StContactInfo> contactList = PBField.initRepeatMessage(INTERFACE.StContactInfo.class);
  }
  
  public static final class StBatchGetPluginPkgReq
    extends MessageMicro<StBatchGetPluginPkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "pluginPkgInfos" }, new Object[] { null, null }, StBatchGetPluginPkgReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StPluginPkgInfo> pluginPkgInfos = PBField.initRepeatMessage(INTERFACE.StPluginPkgInfo.class);
  }
  
  public static final class StBatchGetPluginPkgRsp
    extends MessageMicro<StBatchGetPluginPkgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "pluginPkgInfos" }, new Object[] { null, null }, StBatchGetPluginPkgRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StPluginPkgInfo> pluginPkgInfos = PBField.initRepeatMessage(INTERFACE.StPluginPkgInfo.class);
  }
  
  public static final class StBatchGetSchemaReq
    extends MessageMicro<StBatchGetSchemaReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "params" }, new Object[] { null, null }, StBatchGetSchemaReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StSchemeParam> params = PBField.initRepeatMessage(INTERFACE.StSchemeParam.class);
  }
  
  public static final class StBatchGetSchemaRsp
    extends MessageMicro<StBatchGetSchemaRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "results" }, new Object[] { null, null }, StBatchGetSchemaRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StSchemeResult> results = PBField.initRepeatMessage(INTERFACE.StSchemeResult.class);
  }
  
  public static final class StBatchGetUserInfoReq
    extends MessageMicro<StBatchGetUserInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "appid", "lang", "openIds" }, new Object[] { null, "", "", "" }, StBatchGetUserInfoReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField lang = PBField.initString("");
    public final PBRepeatField<String> openIds = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StBatchGetUserInfoRsp
    extends MessageMicro<StBatchGetUserInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "user" }, new Object[] { null, null }, StBatchGetUserInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StApiUserInfo> user = PBField.initRepeatMessage(INTERFACE.StApiUserInfo.class);
  }
  
  public static final class StBatchQueryAppInfoByPathReq
    extends MessageMicro<StBatchQueryAppInfoByPathReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appPaths" }, new Object[] { null, null }, StBatchQueryAppInfoByPathReq.class);
    public final PBRepeatMessageField<INTERFACE.StAppPath> appPaths = PBField.initRepeatMessage(INTERFACE.StAppPath.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StBatchQueryAppInfoByPathRsp
    extends MessageMicro<StBatchQueryAppInfoByPathRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appInfos" }, new Object[] { null, null }, StBatchQueryAppInfoByPathRsp.class);
    public final PBRepeatMessageField<INTERFACE.StApiAppInfo> appInfos = PBField.initRepeatMessage(INTERFACE.StApiAppInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StBatchQueryAppInfoReq
    extends MessageMicro<StBatchQueryAppInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appIds" }, new Object[] { null, "" }, StBatchQueryAppInfoReq.class);
    public final PBRepeatField<String> appIds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StBatchQueryAppInfoRsp
    extends MessageMicro<StBatchQueryAppInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appInfos" }, new Object[] { null, null }, StBatchQueryAppInfoRsp.class);
    public final PBRepeatMessageField<INTERFACE.StApiAppInfo> appInfos = PBField.initRepeatMessage(INTERFACE.StApiAppInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StCacheController
    extends MessageMicro<StCacheController>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "appInfo", "cachePkg" }, new Object[] { null, Integer.valueOf(0) }, StCacheController.class);
    public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
    public final PBInt32Field cachePkg = PBField.initInt32(0);
  }
  
  public static final class StCheckDownloadRightReq
    extends MessageMicro<StCheckDownloadRightReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "link" }, new Object[] { null, "" }, StCheckDownloadRightReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
  }
  
  public static final class StCheckDownloadRightRsp
    extends MessageMicro<StCheckDownloadRightRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "realLink" }, new Object[] { null, "" }, StCheckDownloadRightRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField realLink = PBField.initString("");
  }
  
  public static final class StCheckNavigateRightReq
    extends MessageMicro<StCheckNavigateRightReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appId", "targetAppId" }, new Object[] { null, "", "" }, StCheckNavigateRightReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField targetAppId = PBField.initString("");
  }
  
  public static final class StCheckNavigateRightRsp
    extends MessageMicro<StCheckNavigateRightRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "extInfo", "actionCode", "skipLocalCheck", "wording" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "" }, StCheckNavigateRightRsp.class);
    public final PBInt32Field actionCode = PBField.initInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field skipLocalCheck = PBField.initInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class StCheckSessionReq
    extends MessageMicro<StCheckSessionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "appid" }, new Object[] { null, "" }, StCheckSessionReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
  }
  
  public static final class StCheckSessionRsp
    extends MessageMicro<StCheckSessionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StCheckSessionRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StClearAppCountReq
    extends MessageMicro<StClearAppCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appid", "countType" }, new Object[] { null, "", Integer.valueOf(0) }, StClearAppCountReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field countType = PBField.initInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StClearAuthsReq
    extends MessageMicro<StClearAuthsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StClearAuthsReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StClearAuthsRsp
    extends MessageMicro<StClearAuthsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StClearAuthsRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StCode2SessionKeyReq
    extends MessageMicro<StCode2SessionKeyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "extInfo", "appid", "secret", "jsCode" }, new Object[] { null, "", "", "" }, StCode2SessionKeyReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField jsCode = PBField.initString("");
    public final PBStringField secret = PBField.initString("");
  }
  
  public static final class StCode2SessionKeyRsp
    extends MessageMicro<StCode2SessionKeyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "ret", "openid", "sessionKey", "unionid" }, new Object[] { null, null, "", "", "" }, StCode2SessionKeyRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public COMM.Result ret = new COMM.Result();
    public final PBStringField sessionKey = PBField.initString("");
    public final PBStringField unionid = PBField.initString("");
  }
  
  public static final class StContactInfo
    extends MessageMicro<StContactInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appId", "plugin_list" }, new Object[] { "", null }, StContactInfo.class);
    public final PBStringField appId = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StPluginDetail> plugin_list = PBField.initRepeatMessage(INTERFACE.StPluginDetail.class);
  }
  
  public static final class StContentAccelerateReq
    extends MessageMicro<StContentAccelerateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "appid", "dataUrl", "needCode", "reqHeaders" }, new Object[] { null, "", "", Integer.valueOf(0), null }, StContentAccelerateReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField dataUrl = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field needCode = PBField.initInt32(0);
    public final PBRepeatMessageField<COMM.Entry> reqHeaders = PBField.initRepeatMessage(COMM.Entry.class);
  }
  
  public static final class StContentAccelerateRsp
    extends MessageMicro<StContentAccelerateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cacheData = PBField.initBytes(ByteStringMicro.EMPTY);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field httpReturnCode = PBField.initInt32(0);
    public final PBRepeatMessageField<COMM.Entry> rspHeaders = PBField.initRepeatMessage(COMM.Entry.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "rspHeaders", "cacheData", "httpReturnCode" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, StContentAccelerateRsp.class);
    }
  }
  
  public static final class StCreateUpdatableMsgReq
    extends MessageMicro<StCreateUpdatableMsgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "extInfo", "appid", "shareInfo", "templateId", "from" }, new Object[] { null, "", null, "", Integer.valueOf(0) }, StCreateUpdatableMsgReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field from = PBField.initUInt32(0);
    public INTERFACE.StUpdatableMsgShareInfo shareInfo = new INTERFACE.StUpdatableMsgShareInfo();
    public final PBStringField templateId = PBField.initString("");
  }
  
  public static final class StCreateUpdatableMsgRsp
    extends MessageMicro<StCreateUpdatableMsgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StCreateUpdatableMsgRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StCurrChannelInfo
    extends MessageMicro<StCurrChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "refer", "via" }, new Object[] { "", "" }, StCurrChannelInfo.class);
    public final PBStringField refer = PBField.initString("");
    public final PBStringField via = PBField.initString("");
  }
  
  public static final class StDelPhoneNumbersReq
    extends MessageMicro<StDelPhoneNumbersReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appId", "purePhoneNumber" }, new Object[] { null, "", "" }, StDelPhoneNumbersReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField purePhoneNumber = PBField.initString("");
  }
  
  public static final class StDelPhoneNumbersRsp
    extends MessageMicro<StDelPhoneNumbersRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDelPhoneNumbersRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDelUserAppReq
    extends MessageMicro<StDelUserAppReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "extInfo", "appId", "verType", "isRecommend", "source", "noDelTop" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StDelUserAppReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field isRecommend = PBField.initInt32(0);
    public final PBInt32Field noDelTop = PBField.initInt32(0);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBEnumField verType = PBField.initEnum(0);
  }
  
  public static final class StDelUserAppRsp
    extends MessageMicro<StDelUserAppRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDelUserAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDeleteUserAuthReq
    extends MessageMicro<StDeleteUserAuthReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StDeleteUserAuthReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDeleteUserAuthRsp
    extends MessageMicro<StDeleteUserAuthRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StDeleteUserAuthRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StDeveloperInfo
    extends MessageMicro<StDeveloperInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "name" }, new Object[] { "" }, StDeveloperInfo.class);
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class StDomainConfig
    extends MessageMicro<StDomainConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "businessDomain", "udpIpList" }, new Object[] { "", "", "", "", "", "" }, StDomainConfig.class);
    public final PBRepeatField<String> businessDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> downloadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> requestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> socketDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> udpIpList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> uploadFileDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StDownLoadUrl
    extends MessageMicro<StDownLoadUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "fileid", "url" }, new Object[] { "", "" }, StDownLoadUrl.class);
    public final PBStringField fileid = PBField.initString("");
    public final PBStringField url = PBField.initString("");
  }
  
  public static final class StExampleDetail
    extends MessageMicro<StExampleDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "title", "contents" }, new Object[] { "", null }, StExampleDetail.class);
    public final PBRepeatMessageField<COMM.Entry> contents = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class StExpandItem
    extends MessageMicro<StExpandItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "appInfo", "icon", "name", "adId" }, new Object[] { null, "", "", Integer.valueOf(0) }, StExpandItem.class);
    public final PBUInt32Field adId = PBField.initUInt32(0);
    public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
    public final PBStringField icon = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class StExtConfigInfo
    extends MessageMicro<StExtConfigInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField configKey = PBField.initString("");
    public final PBStringField configVersion = PBField.initString("");
    public final PBBytesField dataBuf = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "configKey", "configVersion", "dataBuf" }, new Object[] { "", "", localByteStringMicro }, StExtConfigInfo.class);
    }
  }
  
  public static final class StFirstPage
    extends MessageMicro<StFirstPage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pagePath", "subPkgName" }, new Object[] { "", "" }, StFirstPage.class);
    public final PBStringField pagePath = PBField.initString("");
    public final PBStringField subPkgName = PBField.initString("");
  }
  
  public static final class StFriendRanking
    extends MessageMicro<StFriendRanking>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "gameInfo", "friendsNum", "rankingList", "hasmore", "animationPic" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), "" }, StFriendRanking.class);
    public final PBStringField animationPic = PBField.initString("");
    public final PBInt32Field friendsNum = PBField.initInt32(0);
    public INTERFACE.StUserAppInfo gameInfo = new INTERFACE.StUserAppInfo();
    public final PBInt32Field hasmore = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StRankingList> rankingList = PBField.initRepeatMessage(INTERFACE.StRankingList.class);
  }
  
  public static final class StGameCenterInfo
    extends MessageMicro<StGameCenterInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bg" }, new Object[] { "" }, StGameCenterInfo.class);
    public final PBStringField bg = PBField.initString("");
  }
  
  public static final class StGetAppInfoByIdReq
    extends MessageMicro<StGetAppInfoByIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "extInfo", "appid", "needVersionInfo", "checkDevRight", "firstPath", "envVersion" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, StGetAppInfoByIdReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field checkDevRight = PBField.initInt32(0);
    public final PBStringField envVersion = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField firstPath = PBField.initString("");
    public final PBInt32Field needVersionInfo = PBField.initInt32(0);
  }
  
  public static final class StGetAppInfoByIdRsp
    extends MessageMicro<StGetAppInfoByIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appInfo" }, new Object[] { null, null }, StGetAppInfoByIdRsp.class);
    public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetAppInfoByLinkReq
    extends MessageMicro<StGetAppInfoByLinkReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "link", "linkType" }, new Object[] { null, "", Integer.valueOf(0) }, StGetAppInfoByLinkReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
    public final PBInt32Field linkType = PBField.initInt32(0);
  }
  
  public static final class StGetAppInfoByLinkRsp
    extends MessageMicro<StGetAppInfoByLinkRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appInfo", "shareTicket" }, new Object[] { null, null, "" }, StGetAppInfoByLinkRsp.class);
    public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField shareTicket = PBField.initString("");
  }
  
  public static final class StGetAuthListReq
    extends MessageMicro<StGetAuthListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StGetAuthListReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetAuthListRsp
    extends MessageMicro<StGetAuthListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "auths", "settings" }, new Object[] { null, null, null }, StGetAuthListRsp.class);
    public final PBRepeatMessageField<INTERFACE.StUserAuthInfo> auths = PBField.initRepeatMessage(INTERFACE.StUserAuthInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserSettingInfo> settings = PBField.initRepeatMessage(INTERFACE.StUserSettingInfo.class);
  }
  
  public static final class StGetAuthStateReq
    extends MessageMicro<StGetAuthStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "scope" }, new Object[] { null, "", "" }, StGetAuthStateReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField scope = PBField.initString("");
  }
  
  public static final class StGetAuthStateRsp
    extends MessageMicro<StGetAuthStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "auth" }, new Object[] { null, null }, StGetAuthStateRsp.class);
    public INTERFACE.StUserAuthInfo auth = new INTERFACE.StUserAuthInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetCodeReq
    extends MessageMicro<StGetCodeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "appid" }, new Object[] { "" }, StGetCodeReq.class);
    public final PBStringField appid = PBField.initString("");
  }
  
  public static final class StGetCodeRsp
    extends MessageMicro<StGetCodeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "code" }, new Object[] { null, "" }, StGetCodeRsp.class);
    public final PBStringField code = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetDownLoadUrlReq
    extends MessageMicro<StGetDownLoadUrlReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "fileids" }, new Object[] { null, "" }, StGetDownLoadUrlReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatField<String> fileids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetDownLoadUrlRsp
    extends MessageMicro<StGetDownLoadUrlRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "urls" }, new Object[] { null, null }, StGetDownLoadUrlRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StDownLoadUrl> urls = PBField.initRepeatMessage(INTERFACE.StDownLoadUrl.class);
  }
  
  public static final class StGetDropdownAppListReq
    extends MessageMicro<StGetDropdownAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "extInfo", "oldRecommendList", "feiqi", "types", "hasCache", "deviceInfo", "subTypes", "itemIds" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "" }, StGetDropdownAppListReq.class);
    public INTERFACE.DeviceInfo deviceInfo = new INTERFACE.DeviceInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field feiqi = PBField.initInt32(0);
    public final PBInt32Field hasCache = PBField.initInt32(0);
    public final PBRepeatField<String> itemIds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
    public final PBRepeatField<Integer> subTypes = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> types = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  }
  
  public static final class StGetDropdownAppListRsp
    extends MessageMicro<StGetDropdownAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 56, 64, 72, 82, 88 }, new String[] { "extInfo", "modules", "cacheLst", "showStore", "showUserAppList", "fixApps", "isFinished", "freshInternal", "realRecommdInternal", "searchInfo", "useOld" }, new Object[] { null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, StGetDropdownAppListRsp.class);
    public final PBRepeatMessageField<INTERFACE.StCacheController> cacheLst = PBField.initRepeatMessage(INTERFACE.StCacheController.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> fixApps = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
    public final PBInt32Field freshInternal = PBField.initInt32(0);
    public final PBInt32Field isFinished = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StModuleInfo> modules = PBField.initRepeatMessage(INTERFACE.StModuleInfo.class);
    public final PBInt32Field realRecommdInternal = PBField.initInt32(0);
    public INTERFACE.StSearchModuleInfo searchInfo = new INTERFACE.StSearchModuleInfo();
    public final PBInt32Field showStore = PBField.initInt32(0);
    public final PBInt32Field showUserAppList = PBField.initInt32(0);
    public final PBInt32Field useOld = PBField.initInt32(0);
  }
  
  public static final class StGetExpandAppListReq
    extends MessageMicro<StGetExpandAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetExpandAppListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetExpandAppListRsp
    extends MessageMicro<StGetExpandAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "extInfo", "expandTitle", "expandItemList", "totalNum", "cacheTime" }, new Object[] { null, "", null, Integer.valueOf(0), Integer.valueOf(0) }, StGetExpandAppListRsp.class);
    public final PBUInt32Field cacheTime = PBField.initUInt32(0);
    public final PBRepeatMessageField<INTERFACE.StExpandItem> expandItemList = PBField.initRepeatMessage(INTERFACE.StExpandItem.class);
    public final PBStringField expandTitle = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field totalNum = PBField.initUInt32(0);
  }
  
  public static final class StGetExtConfigDetailReq
    extends MessageMicro<StGetExtConfigDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "configs" }, new Object[] { null, null }, StGetExtConfigDetailReq.class);
    public final PBRepeatMessageField<INTERFACE.StExtConfigInfo> configs = PBField.initRepeatMessage(INTERFACE.StExtConfigInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetExtConfigDetailRsp
    extends MessageMicro<StGetExtConfigDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "configs" }, new Object[] { null, null }, StGetExtConfigDetailRsp.class);
    public final PBRepeatMessageField<INTERFACE.StExtConfigInfo> configs = PBField.initRepeatMessage(INTERFACE.StExtConfigInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFormIdReq
    extends MessageMicro<StGetFormIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StGetFormIdReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetFormIdRsp
    extends MessageMicro<StGetFormIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "formId" }, new Object[] { null, "" }, StGetFormIdRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField formId = PBField.initString("");
  }
  
  public static final class StGetNAppForJumpReq
    extends MessageMicro<StGetNAppForJumpReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "extInfo", "mini_appid", "native_appid", "android_pkg_name", "ios_bundleid", "scene" }, new Object[] { null, "", "", "", "", Integer.valueOf(0) }, StGetNAppForJumpReq.class);
    public final PBStringField android_pkg_name = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField ios_bundleid = PBField.initString("");
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField native_appid = PBField.initString("");
    public final PBInt32Field scene = PBField.initInt32(0);
  }
  
  public static final class StGetNAppForJumpRsp
    extends MessageMicro<StGetNAppForJumpRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74 }, new String[] { "extInfo", "native_appid", "ios_bundleid", "ios_schema", "appName", "android_pkg", "ios_donwload_url", "onlyOpen", "android_donwload_url" }, new Object[] { null, "", "", "", "", "", "", Integer.valueOf(0), "" }, StGetNAppForJumpRsp.class);
    public final PBStringField android_donwload_url = PBField.initString("");
    public final PBStringField android_pkg = PBField.initString("");
    public final PBStringField appName = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField ios_bundleid = PBField.initString("");
    public final PBStringField ios_donwload_url = PBField.initString("");
    public final PBStringField ios_schema = PBField.initString("");
    public final PBStringField native_appid = PBField.initString("");
    public final PBInt32Field onlyOpen = PBField.initInt32(0);
  }
  
  public static final class StGetNewBaseLibReq
    extends MessageMicro<StGetNewBaseLibReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "curVersion", "type" }, new Object[] { null, "", Integer.valueOf(0) }, StGetNewBaseLibReq.class);
    public final PBStringField curVersion = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class StGetNewBaseLibRsp
    extends MessageMicro<StGetNewBaseLibRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "libInfo", "interval", "jsOrsoLibs" }, new Object[] { null, null, Integer.valueOf(0), null }, StGetNewBaseLibRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field interval = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StBaseLibInfo> jsOrsoLibs = PBField.initRepeatMessage(INTERFACE.StBaseLibInfo.class);
    public INTERFACE.StBaseLibInfo libInfo = new INTERFACE.StBaseLibInfo();
  }
  
  public static final class StGetOpenidByUinReq
    extends MessageMicro<StGetOpenidByUinReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "ext", "appid", "uin" }, new Object[] { null, "", "" }, StGetOpenidByUinReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StGetOpenidByUinRsp
    extends MessageMicro<StGetOpenidByUinRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "openid" }, new Object[] { null, "" }, StGetOpenidByUinRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class StGetPhoneNumberReq
    extends MessageMicro<StGetPhoneNumberReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appId" }, new Object[] { null, "" }, StGetPhoneNumberReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetPhoneNumberRsp
    extends MessageMicro<StGetPhoneNumberRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "purePhoneNumber", "countryCode", "encryptedData", "iv", "phoneLists" }, new Object[] { null, "", "", "", "", null }, StGetPhoneNumberRsp.class);
    public final PBStringField countryCode = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StPhoneNumber> phoneLists = PBField.initRepeatMessage(INTERFACE.StPhoneNumber.class);
    public final PBStringField purePhoneNumber = PBField.initString("");
  }
  
  public static final class StGetProfileReq
    extends MessageMicro<StGetProfileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "appid", "withCredentials", "lang" }, new Object[] { "", Integer.valueOf(0), "" }, StGetProfileReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField lang = PBField.initString("");
    public final PBInt32Field withCredentials = PBField.initInt32(0);
  }
  
  public static final class StGetProfileRsp
    extends MessageMicro<StGetProfileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "extInfo", "user", "rawData", "signature", "encryptedData", "iv" }, new Object[] { null, null, "", "", "", "" }, StGetProfileRsp.class);
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
    public final PBStringField rawData = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
    public INTERFACE.StApiUserInfo user = new INTERFACE.StApiUserInfo();
  }
  
  public static final class StGetRecommendAppListReq
    extends MessageMicro<StGetRecommendAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 33, 42, 50 }, new String[] { "extInfo", "appId", "verType", "useTime", "oldRecommendList", "deviceInfo" }, new Object[] { null, "", Integer.valueOf(0), Double.valueOf(0.0D), null, null }, StGetRecommendAppListReq.class);
    public final PBStringField appId = PBField.initString("");
    public INTERFACE.DeviceInfo deviceInfo = new INTERFACE.DeviceInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
    public final PBDoubleField useTime = PBField.initDouble(0.0D);
    public final PBEnumField verType = PBField.initEnum(0);
  }
  
  public static final class StGetRecommendAppListRsp
    extends MessageMicro<StGetRecommendAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "recommendModule" }, new Object[] { null, null }, StGetRecommendAppListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StModuleInfo> recommendModule = PBField.initRepeatMessage(INTERFACE.StModuleInfo.class);
  }
  
  public static final class StGetRobotUinReq
    extends MessageMicro<StGetRobotUinReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StGetRobotUinReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetRobotUinRsp
    extends MessageMicro<StGetRobotUinRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "uin" }, new Object[] { null, "" }, StGetRobotUinRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StGetSDKOpenKeyTokenReq
    extends MessageMicro<StGetSDKOpenKeyTokenReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetSDKOpenKeyTokenReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetSDKOpenKeyTokenRsp
    extends MessageMicro<StGetSDKOpenKeyTokenRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "token" }, new Object[] { null, "" }, StGetSDKOpenKeyTokenRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField token = PBField.initString("");
  }
  
  public static final class StGetSchemaReq
    extends MessageMicro<StGetSchemaReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 74, 82, 90 }, new String[] { "extInfo", "mini_appid", "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", "referer", "via", "scene" }, new Object[] { null, "", "", "", "", "", Integer.valueOf(0), "", "", "", "" }, StGetSchemaReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField extradata = PBField.initString("");
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBStringField querystring = PBField.initString("");
    public final PBStringField referer = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField sig_querystring = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
    public final PBStringField via = PBField.initString("");
  }
  
  public static final class StGetSchemaRsp
    extends MessageMicro<StGetSchemaRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "schema" }, new Object[] { null, "" }, StGetSchemaRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField schema = PBField.initString("");
  }
  
  public static final class StGetSwitchListReq
    extends MessageMicro<StGetSwitchListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StGetSwitchListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetSwitchListRsp
    extends MessageMicro<StGetSwitchListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "switchs" }, new Object[] { null, null }, StGetSwitchListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StSwitchInfo> switchs = PBField.initRepeatMessage(INTERFACE.StSwitchInfo.class);
  }
  
  public static final class StGetTCBTicketReq
    extends MessageMicro<StGetTCBTicketReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "envId" }, new Object[] { null, "", "" }, StGetTCBTicketReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField envId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetTCBTicketRsp
    extends MessageMicro<StGetTCBTicketRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "extInfo", "ticket", "createTime", "period" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0) }, StGetTCBTicketRsp.class);
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field period = PBField.initUInt32(0);
    public final PBStringField ticket = PBField.initString("");
  }
  
  public static final class StGetUinByOpenidReq
    extends MessageMicro<StGetUinByOpenidReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ext", "openid" }, new Object[] { null, "" }, StGetUinByOpenidReq.class);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
  }
  
  public static final class StGetUinByOpenidRsp
    extends MessageMicro<StGetUinByOpenidRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "uin" }, new Object[] { null, "", "" }, StGetUinByOpenidRsp.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StGetUserAppInfoReq
    extends MessageMicro<StGetUserAppInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "extInfo", "appIds", "verType", "versionIds" }, new Object[] { null, "", Integer.valueOf(0), null }, StGetUserAppInfoReq.class);
    public final PBRepeatField<String> appIds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField verType = PBField.initEnum(0);
    public final PBRepeatMessageField<INTERFACE.StAppVersionId> versionIds = PBField.initRepeatMessage(INTERFACE.StAppVersionId.class);
  }
  
  public static final class StGetUserAppInfoRsp
    extends MessageMicro<StGetUserAppInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userAppList" }, new Object[] { null, null }, StGetUserAppInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StGetUserAppListReq
    extends MessageMicro<StGetUserAppListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "extInfo", "uin", "num", "source" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, StGetUserAppListReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt64Field num = PBField.initUInt64(0L);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class StGetUserAppListRsp
    extends MessageMicro<StGetUserAppListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 64, 74, 82 }, new String[] { "extInfo", "userAppList", "totalNum", "isFinish", "cacheLst", "showStore", "putTopCount", "showUserAppList", "fixApps", "motionPics" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, StGetUserAppListRsp.class);
    public final PBRepeatMessageField<INTERFACE.StCacheController> cacheLst = PBField.initRepeatMessage(INTERFACE.StCacheController.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> fixApps = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
    public final PBInt32Field isFinish = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StMotionPicInfo> motionPics = PBField.initRepeatMessage(INTERFACE.StMotionPicInfo.class);
    public final PBUInt32Field putTopCount = PBField.initUInt32(0);
    public final PBInt32Field showStore = PBField.initInt32(0);
    public final PBInt32Field showUserAppList = PBField.initInt32(0);
    public final PBInt64Field totalNum = PBField.initInt64(0L);
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StGetUserAppMoreInfoReq
    extends MessageMicro<StGetUserAppMoreInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appIds", "verType" }, new Object[] { null, "", Integer.valueOf(0) }, StGetUserAppMoreInfoReq.class);
    public final PBRepeatField<String> appIds = PBField.initRepeat(PBStringField.__repeatHelper__);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField verType = PBField.initEnum(0);
  }
  
  public static final class StGetUserAppMoreInfoRsp
    extends MessageMicro<StGetUserAppMoreInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appMoreInfoList" }, new Object[] { null, null }, StGetUserAppMoreInfoRsp.class);
    public final PBRepeatMessageField<INTERFACE.StApiAppMoreInfo> appMoreInfoList = PBField.initRepeatMessage(INTERFACE.StApiAppMoreInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetUserGroupInfoReq
    extends MessageMicro<StGetUserGroupInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "groupId", "appid", "groupClass" }, new Object[] { null, "", "", Long.valueOf(0L) }, StGetUserGroupInfoReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt64Field groupClass = PBField.initInt64(0L);
    public final PBStringField groupId = PBField.initString("");
  }
  
  public static final class StGetUserGroupInfoRsp
    extends MessageMicro<StGetUserGroupInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "userGroupInfo" }, new Object[] { null, "" }, StGetUserGroupInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField userGroupInfo = PBField.initString("");
  }
  
  public static final class StGetUserHealthDataReq
    extends MessageMicro<StGetUserHealthDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StGetUserHealthDataReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetUserHealthDataRsp
    extends MessageMicro<StGetUserHealthDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "appid", "encryptedData", "iv", "cloudID" }, new Object[] { null, "", "", "", "" }, StGetUserHealthDataRsp.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField cloudID = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
  }
  
  public static final class StGetUserInfoExtraReq
    extends MessageMicro<StGetUserInfoExtraReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "appid" }, new Object[] { null, "" }, StGetUserInfoExtraReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StGetUserInfoExtraRsp
    extends MessageMicro<StGetUserInfoExtraRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "encryptedData", "iv" }, new Object[] { null, "", "" }, StGetUserInfoExtraRsp.class);
    public final PBStringField encryptedData = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField iv = PBField.initString("");
  }
  
  public static final class StGetUserSettingReq
    extends MessageMicro<StGetUserSettingReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "extInfo", "appid", "openid", "settingItem", "templateIds" }, new Object[] { null, "", "", "", "" }, StGetUserSettingReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField openid = PBField.initString("");
    public final PBStringField settingItem = PBField.initString("");
    public final PBRepeatField<String> templateIds = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StGetUserSettingRsp
    extends MessageMicro<StGetUserSettingRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "setting" }, new Object[] { null, null }, StGetUserSettingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE.StUserSettingInfo setting = new INTERFACE.StUserSettingInfo();
  }
  
  public static final class StIdeConfig
    extends MessageMicro<StIdeConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "scene", "extraAppid", "extraData", "startExtInfo" }, new Object[] { "", "", "", null }, StIdeConfig.class);
    public final PBStringField extraAppid = PBField.initString("");
    public final PBStringField extraData = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public INTERFACE.StStartExtInfo startExtInfo = new INTERFACE.StStartExtInfo();
  }
  
  public static final class StJudgeTimingReq
    extends MessageMicro<StJudgeTimingReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 96, 106 }, new String[] { "extInfo", "appid", "factType", "duration", "reportTime", "afterCertify", "appType", "scene", "totalTime", "launchId", "via", "AdsTotalTime", "hostExtInfo" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, StJudgeTimingReq.class);
    public final PBInt32Field AdsTotalTime = PBField.initInt32(0);
    public final PBInt32Field afterCertify = PBField.initInt32(0);
    public final PBInt32Field appType = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field duration = PBField.initInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field factType = PBField.initInt32(0);
    public final PBStringField hostExtInfo = PBField.initString("");
    public final PBStringField launchId = PBField.initString("");
    public final PBInt64Field reportTime = PBField.initInt64(0L);
    public final PBInt32Field scene = PBField.initInt32(0);
    public final PBInt32Field totalTime = PBField.initInt32(0);
    public final PBStringField via = PBField.initString("");
  }
  
  public static final class StJudgeTimingRsp
    extends MessageMicro<StJudgeTimingRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "extInfo", "timingTraceId", "nextDuration", "loginInstructions", "loginTraceId", "timingInstructions" }, new Object[] { null, "", Integer.valueOf(0), null, "", null }, StJudgeTimingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.GuardInstruction> loginInstructions = PBField.initRepeatMessage(INTERFACE.GuardInstruction.class);
    public final PBStringField loginTraceId = PBField.initString("");
    public final PBInt32Field nextDuration = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.GuardInstruction> timingInstructions = PBField.initRepeatMessage(INTERFACE.GuardInstruction.class);
    public final PBStringField timingTraceId = PBField.initString("");
  }
  
  public static final class StLastVersion
    extends MessageMicro<StLastVersion>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "custom_version", "inner_version", "release_time", "source_md5", "source_size" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, StLastVersion.class);
    public final PBStringField custom_version = PBField.initString("");
    public final PBStringField inner_version = PBField.initString("");
    public final PBUInt32Field release_time = PBField.initUInt32(0);
    public final PBStringField source_md5 = PBField.initString("");
    public final PBUInt32Field source_size = PBField.initUInt32(0);
  }
  
  public static final class StMDebugInfo
    extends MessageMicro<StMDebugInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "roomId", "wsUrl" }, new Object[] { "", "" }, StMDebugInfo.class);
    public final PBStringField roomId = PBField.initString("");
    public final PBStringField wsUrl = PBField.initString("");
  }
  
  public static final class StMainPageExtInfo
    extends MessageMicro<StMainPageExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "file_size" }, new Object[] { Integer.valueOf(0) }, StMainPageExtInfo.class);
    public final PBInt32Field file_size = PBField.initInt32(0);
  }
  
  public static final class StMainPkgInfo
    extends MessageMicro<StMainPkgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "fileId", "pages", "file_size", "file_md5" }, new Object[] { "", "", Integer.valueOf(0), "" }, StMainPkgInfo.class);
    public final PBStringField fileId = PBField.initString("");
    public final PBRepeatField<String> file_md5 = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt32Field file_size = PBField.initInt32(0);
    public final PBRepeatField<String> pages = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StModuleInfo
    extends MessageMicro<StModuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 56, 66, 74, 80, 90, 98, 106, 112 }, new String[] { "title", "userAppList", "moduleType", "useOld", "jumpMoreApp", "isFinished", "appTotalNum", "desc", "ranks", "freshInternal", "titleIcon", "backgroundPic", "dittoDsl", "subTypes" }, new Object[] { "", null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, StModuleInfo.class);
    public final PBInt32Field appTotalNum = PBField.initInt32(0);
    public final PBStringField backgroundPic = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBStringField dittoDsl = PBField.initString("");
    public final PBInt32Field freshInternal = PBField.initInt32(0);
    public final PBInt32Field isFinished = PBField.initInt32(0);
    public INTERFACE.StUserAppInfo jumpMoreApp = new INTERFACE.StUserAppInfo();
    public final PBInt32Field moduleType = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StFriendRanking> ranks = PBField.initRepeatMessage(INTERFACE.StFriendRanking.class);
    public final PBInt32Field subTypes = PBField.initInt32(0);
    public final PBStringField title = PBField.initString("");
    public final PBStringField titleIcon = PBField.initString("");
    public final PBInt32Field useOld = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE.StUserAppInfo.class);
  }
  
  public static final class StMotionPicInfo
    extends MessageMicro<StMotionPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pic" }, new Object[] { "" }, StMotionPicInfo.class);
    public final PBStringField pic = PBField.initString("");
  }
  
  public static final class StOperationInfo
    extends MessageMicro<StOperationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "reportData", "amsAdInfo", "tianshuAdId" }, new Object[] { "", "", Integer.valueOf(0) }, StOperationInfo.class);
    public final PBStringField amsAdInfo = PBField.initString("");
    public final PBStringField reportData = PBField.initString("");
    public final PBUInt32Field tianshuAdId = PBField.initUInt32(0);
  }
  
  public static final class StPhoneNumber
    extends MessageMicro<StPhoneNumber>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "phoneType", "purePhoneNumber", "countryCode", "encryptedData", "iv" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, StPhoneNumber.class);
    public final PBStringField countryCode = PBField.initString("");
    public final PBStringField encryptedData = PBField.initString("");
    public final PBStringField iv = PBField.initString("");
    public final PBInt32Field phoneType = PBField.initInt32(0);
    public final PBStringField purePhoneNumber = PBField.initString("");
  }
  
  public static final class StPlugin
    extends MessageMicro<StPlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "plugin_id", "inner_version" }, new Object[] { "", "" }, StPlugin.class);
    public final PBStringField inner_version = PBField.initString("");
    public final PBStringField plugin_id = PBField.initString("");
  }
  
  public static final class StPluginDetail
    extends MessageMicro<StPluginDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "PluginNetWork", "brandiconurl", "headimgurl", "id", "last_version", "nickname", "signature" }, new Object[] { null, "", "", "", null, "", "" }, StPluginDetail.class);
    public INTERFACE.StPluginNetWork PluginNetWork = new INTERFACE.StPluginNetWork();
    public final PBStringField brandiconurl = PBField.initString("");
    public final PBStringField headimgurl = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public INTERFACE.StLastVersion last_version = new INTERFACE.StLastVersion();
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
  }
  
  public static final class StPluginInfo
    extends MessageMicro<StPluginInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "pluginId", "pluginName", "version", "url", "fileSize" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, StPluginInfo.class);
    public final PBInt32Field fileSize = PBField.initInt32(0);
    public final PBStringField pluginId = PBField.initString("");
    public final PBStringField pluginName = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class StPluginNetWork
    extends MessageMicro<StPluginNetWork>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "RequestDomain", "UploadDomain", "DownloadDomain", "BizDomain", "UDPDomain", "WsRequestDomain" }, new Object[] { "", "", "", "", "", "" }, StPluginNetWork.class);
    public final PBRepeatField<String> BizDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> DownloadDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> RequestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> UDPDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> UploadDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> WsRequestDomain = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StPluginPkgInfo
    extends MessageMicro<StPluginPkgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pluginId", "version", "pkgUrl" }, new Object[] { "", "", "" }, StPluginPkgInfo.class);
    public final PBStringField pkgUrl = PBField.initString("");
    public final PBStringField pluginId = PBField.initString("");
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class StPluginProfile
    extends MessageMicro<StPluginProfile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "plugin_id", "download_domain", "request_domain", "wsrequest_domain", "upload_domain", "host_sign", "noncestr", "timestamp", "running_flag_info" }, new Object[] { "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, StPluginProfile.class);
    public final PBRepeatField<String> download_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField host_sign = PBField.initString("");
    public final PBStringField noncestr = PBField.initString("");
    public final PBStringField plugin_id = PBField.initString("");
    public final PBRepeatField<String> request_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field running_flag_info = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBRepeatField<String> upload_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> wsrequest_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StPublicAccount
    extends MessageMicro<StPublicAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "id", "name", "icon", "desc" }, new Object[] { "", "", "", "" }, StPublicAccount.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField icon = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBStringField name = PBField.initString("");
  }
  
  public static final class StRankingList
    extends MessageMicro<StRankingList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "nick", "avatar", "ranks", "score", "unit" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, StRankingList.class);
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBInt32Field ranks = PBField.initInt32(0);
    public final PBInt32Field score = PBField.initInt32(0);
    public final PBStringField unit = PBField.initString("");
  }
  
  public static final class StRecommendApp
    extends MessageMicro<StRecommendApp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "appId", "exposuredNum", "pullTime" }, new Object[] { "", Integer.valueOf(0), Long.valueOf(0L) }, StRecommendApp.class);
    public final PBStringField appId = PBField.initString("");
    public final PBInt32Field exposuredNum = PBField.initInt32(0);
    public final PBInt64Field pullTime = PBField.initInt64(0L);
  }
  
  public static final class StRenderInfo
    extends MessageMicro<StRenderInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "renderMode", "renderMaterials" }, new Object[] { Integer.valueOf(0), null }, StRenderInfo.class);
    public final PBRepeatMessageField<INTERFACE.StRenderMaterial> renderMaterials = PBField.initRepeatMessage(INTERFACE.StRenderMaterial.class);
    public final PBEnumField renderMode = PBField.initEnum(0);
  }
  
  public static final class StRenderMaterial
    extends MessageMicro<StRenderMaterial>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "renderMode", "downloadUrl" }, new Object[] { Integer.valueOf(0), "" }, StRenderMaterial.class);
    public final PBStringField downloadUrl = PBField.initString("");
    public final PBEnumField renderMode = PBField.initEnum(0);
  }
  
  public static final class StReportExecuteReq
    extends MessageMicro<StReportExecuteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "extInfo", "appid", "instrTraceId", "execTime", "ruleName" }, new Object[] { null, "", "", Integer.valueOf(0), "" }, StReportExecuteReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBInt32Field execTime = PBField.initInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField instrTraceId = PBField.initString("");
    public final PBStringField ruleName = PBField.initString("");
  }
  
  public static final class StReportExecuteRsp
    extends MessageMicro<StReportExecuteRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StReportExecuteRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StReportLogFileReq
    extends MessageMicro<StReportLogFileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "extInfo", "appid", "fileUrl", "fileSize" }, new Object[] { null, "", "", Integer.valueOf(0) }, StReportLogFileReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field fileSize = PBField.initInt32(0);
    public final PBStringField fileUrl = PBField.initString("");
  }
  
  public static final class StReportLogFileRsp
    extends MessageMicro<StReportLogFileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StReportLogFileRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StReportShareReq
    extends MessageMicro<StReportShareReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 66 }, new String[] { "extInfo", "reportTime", "appid", "appType", "shareScene", "shareType", "destType", "destId" }, new Object[] { null, Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, StReportShareReq.class);
    public final PBInt32Field appType = PBField.initInt32(0);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField destId = PBField.initString("");
    public final PBUInt32Field destType = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt64Field reportTime = PBField.initInt64(0L);
    public final PBUInt32Field shareScene = PBField.initUInt32(0);
    public final PBUInt32Field shareType = PBField.initUInt32(0);
  }
  
  public static final class StReportShareRsp
    extends MessageMicro<StReportShareRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StReportShareRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StResourcePreCacheInfo
    extends MessageMicro<StResourcePreCacheInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "getDataUrl" }, new Object[] { "" }, StResourcePreCacheInfo.class);
    public final PBStringField getDataUrl = PBField.initString("");
  }
  
  public static final class StSchemeParam
    extends MessageMicro<StSchemeParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "mini_appid", "path", "sig_querystring", "querystring", "extradata", "versionType", "versionId", "referer", "via", "scene" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "", "", "", "" }, StSchemeParam.class);
    public final PBStringField extradata = PBField.initString("");
    public final PBStringField mini_appid = PBField.initString("");
    public final PBStringField path = PBField.initString("");
    public final PBStringField querystring = PBField.initString("");
    public final PBStringField referer = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
    public final PBStringField sig_querystring = PBField.initString("");
    public final PBStringField versionId = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
    public final PBStringField via = PBField.initString("");
  }
  
  public static final class StSchemeResult
    extends MessageMicro<StSchemeResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "mini_appid", "schema", "ret" }, new Object[] { "", "", Integer.valueOf(0) }, StSchemeResult.class);
    public final PBStringField mini_appid = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField schema = PBField.initString("");
  }
  
  public static final class StSearchModuleInfo
    extends MessageMicro<StSearchModuleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "searchApp", "keywords" }, new Object[] { null, "" }, StSearchModuleInfo.class);
    public final PBRepeatField<String> keywords = PBField.initRepeat(PBStringField.__repeatHelper__);
    public INTERFACE.StUserAppInfo searchApp = new INTERFACE.StUserAppInfo();
  }
  
  public static final class StSetAuthsReq
    extends MessageMicro<StSetAuthsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "auths" }, new Object[] { null, "", null }, StSetAuthsReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StUserAuthInfo> auths = PBField.initRepeatMessage(INTERFACE.StUserAuthInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetAuthsRsp
    extends MessageMicro<StSetAuthsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetAuthsRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetEnbalePushReq
    extends MessageMicro<StSetEnbalePushReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "appid", "enablePush" }, new Object[] { "", Integer.valueOf(0) }, StSetEnbalePushReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
  }
  
  public static final class StSetEnbalePushRsp
    extends MessageMicro<StSetEnbalePushRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enablePush" }, new Object[] { Integer.valueOf(0) }, StSetEnbalePushRsp.class);
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
  }
  
  public static final class StSetUserAppLikeReq
    extends MessageMicro<StSetUserAppLikeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "appId", "doLike" }, new Object[] { null, "", Integer.valueOf(0) }, StSetUserAppLikeReq.class);
    public final PBStringField appId = PBField.initString("");
    public final PBUInt32Field doLike = PBField.initUInt32(0);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetUserAppLikeRsp
    extends MessageMicro<StSetUserAppLikeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetUserAppLikeRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetUserAppTopReq
    extends MessageMicro<StSetUserAppTopReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "extInfo", "appId", "putTop", "verType", "oldIdx", "newIdx", "fromNewDownload" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StSetUserAppTopReq.class);
    public final PBStringField appId = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field fromNewDownload = PBField.initInt32(0);
    public final PBInt32Field newIdx = PBField.initInt32(0);
    public final PBInt32Field oldIdx = PBField.initInt32(0);
    public final PBUInt32Field putTop = PBField.initUInt32(0);
    public final PBEnumField verType = PBField.initEnum(0);
  }
  
  public static final class StSetUserAppTopRsp
    extends MessageMicro<StSetUserAppTopRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetUserAppTopRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetUserAvatarReq
    extends MessageMicro<StSetUserAvatarReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "extInfo", "appid", "uin", "set_type", "item_id", "busi_info" }, new Object[] { null, "", "", Integer.valueOf(0), "", "" }, StSetUserAvatarReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField busi_info = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField item_id = PBField.initString("");
    public final PBInt32Field set_type = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StSetUserAvatarRsp
    extends MessageMicro<StSetUserAvatarRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetUserAvatarRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSetUserSwitchReq
    extends MessageMicro<StSetUserSwitchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "extInfo", "key", "value" }, new Object[] { null, "", Integer.valueOf(0) }, StSetUserSwitchReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField key = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
  }
  
  public static final class StSetUserSwitchRsp
    extends MessageMicro<StSetUserSwitchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StSetUserSwitchRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StSplitPkgInfo
    extends MessageMicro<StSplitPkgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "subPkgName", "fileId", "independent", "pages", "file_size" }, new Object[] { "", "", Integer.valueOf(0), "", Integer.valueOf(0) }, StSplitPkgInfo.class);
    public final PBStringField fileId = PBField.initString("");
    public final PBInt32Field file_size = PBField.initInt32(0);
    public final PBInt32Field independent = PBField.initInt32(0);
    public final PBRepeatField<String> pages = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField subPkgName = PBField.initString("");
  }
  
  public static final class StStartExtInfo
    extends MessageMicro<StStartExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "deviceOrientation", "showStatusBar" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, StStartExtInfo.class);
    public final PBInt32Field deviceOrientation = PBField.initInt32(0);
    public final PBInt32Field showStatusBar = PBField.initInt32(0);
  }
  
  public static final class StSubPkgInfo
    extends MessageMicro<StSubPkgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "subPkgName", "dowLoadUrl", "independent", "file_size" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0) }, StSubPkgInfo.class);
    public final PBStringField dowLoadUrl = PBField.initString("");
    public final PBInt32Field file_size = PBField.initInt32(0);
    public final PBInt32Field independent = PBField.initInt32(0);
    public final PBStringField subPkgName = PBField.initString("");
  }
  
  public static final class StSubmitVersionReq
    extends MessageMicro<StSubmitVersionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 96, 104, 114, 122 }, new String[] { "extInfo", "appid", "version", "versionType", "intro", "mainPkg", "subPkgs", "pkgType", "firstPage", "roomId", "supportOffline", "skipDomainCheck", "property", "usePlugin", "ideConfig" }, new Object[] { null, "", "", Integer.valueOf(0), "", null, null, Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null }, StSubmitVersionReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField firstPage = PBField.initString("");
    public INTERFACE.StIdeConfig ideConfig = new INTERFACE.StIdeConfig();
    public final PBStringField intro = PBField.initString("");
    public INTERFACE.StMainPkgInfo mainPkg = new INTERFACE.StMainPkgInfo();
    public final PBUInt32Field pkgType = PBField.initUInt32(0);
    public final PBInt32Field property = PBField.initInt32(0);
    public final PBStringField roomId = PBField.initString("");
    public final PBInt32Field skipDomainCheck = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StSplitPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE.StSplitPkgInfo.class);
    public final PBInt32Field supportOffline = PBField.initInt32(0);
    public INTERFACE.StUsePlugin usePlugin = new INTERFACE.StUsePlugin();
    public final PBStringField version = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
  }
  
  public static final class StSubmitVersionRsp
    extends MessageMicro<StSubmitVersionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "link", "versionid" }, new Object[] { null, "", "" }, StSubmitVersionRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
    public final PBStringField versionid = PBField.initString("");
  }
  
  public static final class StSubscribeMessage
    extends MessageMicro<StSubscribeMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "templateId", "authState", "example" }, new Object[] { "", Integer.valueOf(0), null }, StSubscribeMessage.class);
    public final PBInt32Field authState = PBField.initInt32(0);
    public INTERFACE.StExampleDetail example = new INTERFACE.StExampleDetail();
    public final PBStringField templateId = PBField.initString("");
  }
  
  public static final class StSwitchInfo
    extends MessageMicro<StSwitchInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "title", "key", "value", "desc" }, new Object[] { "", "", Integer.valueOf(0), "" }, StSwitchInfo.class);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField key = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBInt32Field value = PBField.initInt32(0);
  }
  
  public static final class StTinyidOpenidPair
    extends MessageMicro<StTinyidOpenidPair>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "tinyid", "openid" }, new Object[] { Long.valueOf(0L), "" }, StTinyidOpenidPair.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  }
  
  public static final class StTrans4TinyidReq
    extends MessageMicro<StTrans4TinyidReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "appids" }, new Object[] { "" }, StTrans4TinyidReq.class);
    public final PBRepeatField<String> appids = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class StTrans4TinyidRsp
    extends MessageMicro<StTrans4TinyidRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tinyidOpenids" }, new Object[] { null }, StTrans4TinyidRsp.class);
    public final PBRepeatMessageField<INTERFACE.StTinyidOpenidPair> tinyidOpenids = PBField.initRepeatMessage(INTERFACE.StTinyidOpenidPair.class);
  }
  
  public static final class StUpdatableMsgShareInfo
    extends MessageMicro<StUpdatableMsgShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "scene", "groupId", "chatUin" }, new Object[] { Integer.valueOf(0), "", "" }, StUpdatableMsgShareInfo.class);
    public final PBStringField chatUin = PBField.initString("");
    public final PBStringField groupId = PBField.initString("");
    public final PBUInt32Field scene = PBField.initUInt32(0);
  }
  
  public static final class StUpdateUserSettingReq
    extends MessageMicro<StUpdateUserSettingReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "extInfo", "appid", "setting" }, new Object[] { null, "", null }, StUpdateUserSettingReq.class);
    public final PBStringField appid = PBField.initString("");
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE.StUserSettingInfo setting = new INTERFACE.StUserSettingInfo();
  }
  
  public static final class StUpdateUserSettingRsp
    extends MessageMicro<StUpdateUserSettingRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "extInfo" }, new Object[] { null }, StUpdateUserSettingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
  }
  
  public static final class StUsePlugin
    extends MessageMicro<StUsePlugin>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "pluginId", "pluginVersion", "pluginName" }, new Object[] { "", "", "" }, StUsePlugin.class);
    public final PBStringField pluginId = PBField.initString("");
    public final PBStringField pluginName = PBField.initString("");
    public final PBStringField pluginVersion = PBField.initString("");
  }
  
  public static final class StUseUserAppReq
    extends MessageMicro<StUseUserAppReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 33, 40, 48, 58, 66 }, new String[] { "extInfo", "appId", "verType", "useTime", "source", "needRecommend", "oldRecommendList", "channelInfo" }, new Object[] { null, "", Integer.valueOf(0), Double.valueOf(0.0D), Integer.valueOf(0), Integer.valueOf(0), null, null }, StUseUserAppReq.class);
    public final PBStringField appId = PBField.initString("");
    public INTERFACE.StCurrChannelInfo channelInfo = new INTERFACE.StCurrChannelInfo();
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBInt32Field needRecommend = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE.StRecommendApp> oldRecommendList = PBField.initRepeatMessage(INTERFACE.StRecommendApp.class);
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBDoubleField useTime = PBField.initDouble(0.0D);
    public final PBEnumField verType = PBField.initEnum(0);
  }
  
  public static final class StUseUserAppRsp
    extends MessageMicro<StUseUserAppRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "extInfo", "recommendModule" }, new Object[] { null, null }, StUseUserAppRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE.StModuleInfo> recommendModule = PBField.initRepeatMessage(INTERFACE.StModuleInfo.class);
  }
  
  public static final class StUserAppInfo
    extends MessageMicro<StUserAppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64, 74, 82, 90 }, new String[] { "appInfo", "useTime", "putTop", "doLike", "likeNum", "enablePush", "openid", "tinyid", "bgPic", "motionPics", "apngUrl" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "", null, "" }, StUserAppInfo.class);
    public final PBStringField apngUrl = PBField.initString("");
    public INTERFACE.StApiAppInfo appInfo = new INTERFACE.StApiAppInfo();
    public final PBStringField bgPic = PBField.initString("");
    public final PBUInt32Field doLike = PBField.initUInt32(0);
    public final PBUInt32Field enablePush = PBField.initUInt32(0);
    public final PBUInt32Field likeNum = PBField.initUInt32(0);
    public final PBRepeatMessageField<INTERFACE.StMotionPicInfo> motionPics = PBField.initRepeatMessage(INTERFACE.StMotionPicInfo.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field putTop = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBUInt32Field useTime = PBField.initUInt32(0);
  }
  
  public static final class StUserAuthInfo
    extends MessageMicro<StUserAuthInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "scope", "desc", "authState", "settingPageTitle" }, new Object[] { "", "", Integer.valueOf(0), "" }, StUserAuthInfo.class);
    public final PBInt32Field authState = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField scope = PBField.initString("");
    public final PBStringField settingPageTitle = PBField.initString("");
  }
  
  public static final class StUserInfoExtra
    extends MessageMicro<StUserInfoExtra>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "uin", "openid", "is_qq_vip", "is_qq_svip", "is_year_vip", "is_yellow_vip", "is_yellow_svip", "is_yellow_year_vip", "level_of_qq_vip", "level_of_yellow_vip" }, new Object[] { "", "", Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, StUserInfoExtra.class);
    public final PBBoolField is_qq_svip = PBField.initBool(false);
    public final PBBoolField is_qq_vip = PBField.initBool(false);
    public final PBBoolField is_year_vip = PBField.initBool(false);
    public final PBBoolField is_yellow_svip = PBField.initBool(false);
    public final PBBoolField is_yellow_vip = PBField.initBool(false);
    public final PBBoolField is_yellow_year_vip = PBField.initBool(false);
    public final PBInt32Field level_of_qq_vip = PBField.initInt32(0);
    public final PBInt32Field level_of_yellow_vip = PBField.initInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class StUserSettingInfo
    extends MessageMicro<StUserSettingInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "settingItem", "desc", "authState", "subItems" }, new Object[] { "", "", Integer.valueOf(0), null }, StUserSettingInfo.class);
    public final PBInt32Field authState = PBField.initInt32(0);
    public final PBStringField desc = PBField.initString("");
    public final PBStringField settingItem = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StSubscribeMessage> subItems = PBField.initRepeatMessage(INTERFACE.StSubscribeMessage.class);
  }
  
  public static final class StVerifyPluginReq
    extends MessageMicro<StVerifyPluginReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "appid", "plugins" }, new Object[] { "", null }, StVerifyPluginReq.class);
    public final PBStringField appid = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE.StPlugin> plugins = PBField.initRepeatMessage(INTERFACE.StPlugin.class);
  }
  
  public static final class StVerifyPluginRsp
    extends MessageMicro<StVerifyPluginRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pluginList" }, new Object[] { null }, StVerifyPluginRsp.class);
    public final PBRepeatMessageField<INTERFACE.StPluginProfile> pluginList = PBField.initRepeatMessage(INTERFACE.StPluginProfile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_INTERFACE.INTERFACE
 * JD-Core Version:    0.7.0.1
 */