package tencent.gdt;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get
{
  public static final class QQAdGet
    extends MessageMicro<QQAdGet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 16010 }, new String[] { "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https", "external_exp_info", "busi_cookie" }, new Object[] { null, null, null, null, null, "", Boolean.valueOf(false), null, "" }, QQAdGet.class);
    public final PBStringField busi_cookie = PBField.initString("");
    public ContextInfo context_info = new ContextInfo();
    public DebugInfo debug_info = new DebugInfo();
    public DeviceInfo device_info = new DeviceInfo();
    public ExternalExpInfo external_exp_info = new ExternalExpInfo();
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBRepeatMessageField<PositionInfo> position_info = PBField.initRepeatMessage(PositionInfo.class);
    public final PBBoolField support_https = PBField.initBool(false);
    public UserInfo user_info = new UserInfo();
    
    public static final class ContextInfo
      extends MessageMicro<ContextInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBUInt64Field article_id = PBField.initUInt64(0L);
      public final PBBytesField page_url = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBUInt64Field public_id = PBField.initUInt64(0L);
      public final PBRepeatMessageField<qq_ad_get.QQAdGet.QQPublicCategoryInfo> qq_public_category = PBField.initRepeatMessage(qq_ad_get.QQAdGet.QQPublicCategoryInfo.class);
      public final PBUInt32Field source_from = PBField.initUInt32(0);
      public final PBStringField str_source_from = PBField.initString("");
      public final PBUInt32Field tribe_id_tag = PBField.initUInt32(0);
      public final PBUInt32Field tribe_tag = PBField.initUInt32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 66, 74 }, new String[] { "public_id", "article_id", "tribe_tag", "tribe_id_tag", "source_from", "page_url", "str_source_from", "qq_public_category" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, "", null }, ContextInfo.class);
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
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 130, 138, 146, 154, 160, 168, 176, 186, 194, 202, 210, 218, 226, 232, 240, 248, 256 }, new String[] { "muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "imei", "idfa", "android_id", "mac", "is_googleplay_version", "device_orientation", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket", "wx_api_ver", "wx_installed", "wx_ul", "origin_network_type" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Boolean.valueOf(false), "", "", "", Integer.valueOf(0), "", "", "", "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", "", "", "", Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0) }, DeviceInfo.class);
      public final PBStringField aid_ticket = PBField.initString("");
      public final PBStringField android_id = PBField.initString("");
      public final PBUInt32Field app_version_id = PBField.initUInt32(0);
      public final PBUInt32Field carrier_code = PBField.initUInt32(0);
      public final PBStringField client_ip = PBField.initString("");
      public final PBStringField client_ipv4 = PBField.initString("");
      public final PBUInt32Field conn = PBField.initUInt32(0);
      public final PBStringField device_brand_and_model = PBField.initString("");
      public final PBUInt32Field device_orientation = PBField.initUInt32(0);
      public final PBStringField idfa = PBField.initString("");
      public final PBStringField imei = PBField.initString("");
      public final PBStringField ios_qidfa = PBField.initString("");
      public final PBBoolField is_googleplay_version = PBField.initBool(false);
      public final PBBoolField is_ios_review_state = PBField.initBool(false);
      public final PBBoolField is_wk_webview = PBField.initBool(false);
      public Location location = new Location();
      public final PBStringField mac = PBField.initString("");
      public final PBStringField manufacturer = PBField.initString("");
      public final PBStringField md5_android_id = PBField.initString("");
      public final PBStringField md5_mac = PBField.initString("");
      public final PBStringField muid = PBField.initString("");
      public final PBUInt32Field muid_type = PBField.initUInt32(0);
      public final PBStringField oaid = PBField.initString("");
      public final PBUInt32Field origin_network_type = PBField.initUInt32(0);
      public final PBUInt32Field os_type = PBField.initUInt32(0);
      public final PBStringField os_ver = PBField.initString("");
      public final PBStringField qadid = PBField.initString("");
      public final PBStringField qq_ver = PBField.initString("");
      public final PBStringField taid_ticket = PBField.initString("");
      public final PBUInt64Field wx_api_ver = PBField.initUInt64(0L);
      public final PBBoolField wx_installed = PBField.initBool(false);
      public final PBBoolField wx_ul = PBField.initBool(false);
      
      public static final class Location
        extends MessageMicro<Location>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "latitude", "longitude", "coordinates_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Location.class);
        public final PBUInt32Field coordinates_type = PBField.initUInt32(0);
        public final PBInt32Field latitude = PBField.initInt32(0);
        public final PBInt32Field longitude = PBField.initInt32(0);
      }
    }
    
    public static final class ExternalExpInfo
      extends MessageMicro<ExternalExpInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "traffic_type", "exp_id" }, new Object[] { Integer.valueOf(0), "" }, ExternalExpInfo.class);
      public final PBRepeatField<String> exp_id = PBField.initRepeat(PBStringField.__repeatHelper__);
      public final PBInt32Field traffic_type = PBField.initInt32(0);
    }
    
    public static final class PositionInfo
      extends MessageMicro<PositionInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pos_id", "ad_count", "pos_ext" }, new Object[] { "", Integer.valueOf(0), null }, PositionInfo.class);
      public final PBUInt32Field ad_count = PBField.initUInt32(0);
      public PositionExt pos_ext = new PositionExt();
      public final PBStringField pos_id = PBField.initString("");
      
      public static final class PositionExt
        extends MessageMicro<PositionExt>
      {
        public static final int FETCH_TYPE_PREFETCH = 1;
        public static final int FETCH_TYPE_REAL_TIME = 0;
        public static final int FETCH_TYPE_SPECIFY_AD = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 66, 74 }, new String[] { "share_info", "deep_link_version", "get_ad_type", "specified_ads", "sub_position_id", "cps_req_info", "video_req_info" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null, "", null, null }, PositionExt.class);
        public final PBRepeatMessageField<CpsReqInfo> cps_req_info = PBField.initRepeatMessage(CpsReqInfo.class);
        public final PBUInt32Field deep_link_version = PBField.initUInt32(0);
        public final PBEnumField get_ad_type = PBField.initEnum(0);
        public ShareInfo share_info = new ShareInfo();
        public final PBRepeatMessageField<SpecifiedAdsItem> specified_ads = PBField.initRepeatMessage(SpecifiedAdsItem.class);
        public final PBStringField sub_position_id = PBField.initString("");
        public VideoReqInfo video_req_info = new VideoReqInfo();
        
        public static final class CpsReqInfo
          extends MessageMicro<CpsReqInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26, 34, 42 }, new String[] { "catelog_id", "product_link_info", "pcg_media_trace_info", "product_share_info" }, new Object[] { Long.valueOf(0L), null, null, null }, CpsReqInfo.class);
          public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
          public final PBRepeatMessageField<cps_info.PcgMediaTraceInfo> pcg_media_trace_info = PBField.initRepeatMessage(cps_info.PcgMediaTraceInfo.class);
          public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo> product_link_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo.class);
          public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductShareInfo> product_share_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductShareInfo.class);
        }
        
        public static final class MiniProgramLink
          extends MessageMicro<MiniProgramLink>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "app_id", "page_path", "schema_link", "user_name" }, new Object[] { "", "", "", "" }, MiniProgramLink.class);
          public final PBStringField app_id = PBField.initString("");
          public final PBStringField page_path = PBField.initString("");
          public final PBStringField schema_link = PBField.initString("");
          public final PBStringField user_name = PBField.initString("");
        }
        
        public static final class ProductLinkInfo
          extends MessageMicro<ProductLinkInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "product_id", "h5_page", "wx_miniprogram_link", "qq_miniprogram_link" }, new Object[] { Long.valueOf(0L), "", null, null }, ProductLinkInfo.class);
          public final PBStringField h5_page = PBField.initString("");
          public final PBUInt64Field product_id = PBField.initUInt64(0L);
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink qq_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink wx_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
        }
        
        public static final class ProductShareInfo
          extends MessageMicro<ProductShareInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "product_id", "share_info" }, new Object[] { Long.valueOf(0L), null }, ProductShareInfo.class);
          public final PBUInt64Field product_id = PBField.initUInt64(0L);
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
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
        
        public static final class VideoReqInfo
          extends MessageMicro<VideoReqInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "video_min_duration", "video_max_duration" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, VideoReqInfo.class);
          public final PBUInt32Field video_max_duration = PBField.initUInt32(0);
          public final PBUInt32Field video_min_duration = PBField.initUInt32(0);
        }
      }
    }
    
    public static final class QQPublicCategoryInfo
      extends MessageMicro<QQPublicCategoryInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "qq_public_category_id", "qq_public_category_level" }, new Object[] { "", Integer.valueOf(0) }, QQPublicCategoryInfo.class);
      public final PBStringField qq_public_category_id = PBField.initString("");
      public final PBUInt32Field qq_public_category_level = PBField.initUInt32(0);
    }
    
    public static final class UserInfo
      extends MessageMicro<UserInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid", "wuid" }, new Object[] { Long.valueOf(0L), "", "", "", Long.valueOf(0L), "", "" }, UserInfo.class);
      public final PBStringField media_specified_id = PBField.initString("");
      public final PBUInt64Field qq = PBField.initUInt64(0L);
      public final PBUInt64Field qq_appid = PBField.initUInt64(0L);
      public final PBStringField qq_openid = PBField.initString("");
      public final PBStringField wuid = PBField.initString("");
      public final PBStringField wx_appid = PBField.initString("");
      public final PBStringField wx_openid = PBField.initString("");
    }
  }
  
  public static final class QQAdGetRsp
    extends MessageMicro<QQAdGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "ret", "msg", "pos_ads_info", "gdt_cookie", "busi_cookie", "debug_info" }, new Object[] { Integer.valueOf(0), "", null, "", "", "" }, QQAdGetRsp.class);
    public final PBStringField busi_cookie = PBField.initString("");
    public final PBStringField debug_info = PBField.initString("");
    public final PBStringField gdt_cookie = PBField.initString("");
    public final PBStringField msg = PBField.initString("");
    public final PBRepeatMessageField<PosAdInfo> pos_ads_info = PBField.initRepeatMessage(PosAdInfo.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    
    public static final class AdInfo
      extends MessageMicro<AdInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "product_type", "display_info", "report_info", "dest_info", "app_info", "exp_info", "ext", "ext_json", "cps_rsp_info", "wechat_app_info" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, "", null, null }, AdInfo.class);
      public AppInfo app_info = new AppInfo();
      public final PBRepeatMessageField<CpsRspInfo> cps_rsp_info = PBField.initRepeatMessage(CpsRspInfo.class);
      public DestInfo dest_info = new DestInfo();
      public DisplayInfo display_info = new DisplayInfo();
      public ExpInfo exp_info = new ExpInfo();
      public Ext ext = new Ext();
      public final PBStringField ext_json = PBField.initString("");
      public final PBUInt32Field product_type = PBField.initUInt32(0);
      public ReportInfo report_info = new ReportInfo();
      public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
      
      public static final class AppInfo
        extends MessageMicro<AppInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 112 }, new String[] { "app_name", "app_score", "app_package_name", "app_package_size", "app_package_version", "app_logo_url", "pkg_url", "ios_app_id", "android_app_id", "pkg_download_schema", "customized_invoke_url", "channel_id", "app_score_num", "download_num" }, new Object[] { "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L) }, AppInfo.class);
        public final PBStringField android_app_id = PBField.initString("");
        public final PBStringField app_logo_url = PBField.initString("");
        public final PBStringField app_name = PBField.initString("");
        public final PBStringField app_package_name = PBField.initString("");
        public final PBUInt64Field app_package_size = PBField.initUInt64(0L);
        public final PBStringField app_package_version = PBField.initString("");
        public final PBStringField app_score = PBField.initString("");
        public final PBUInt32Field app_score_num = PBField.initUInt32(0);
        public final PBStringField channel_id = PBField.initString("");
        public final PBStringField customized_invoke_url = PBField.initString("");
        public final PBUInt64Field download_num = PBField.initUInt64(0L);
        public final PBStringField ios_app_id = PBField.initString("");
        public final PBStringField pkg_download_schema = PBField.initString("");
        public final PBStringField pkg_url = PBField.initString("");
      }
      
      public static final class CpsRspInfo
        extends MessageMicro<CpsRspInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88, 98, 106, 112, 122 }, new String[] { "product_id", "img_list", "product_name", "product_price", "sales_tips", "h5_page", "deep_link", "apurl", "rl", "catelog_id", "source", "wechat_app_info", "qq_app_info", "product_original_price", "chantag" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), "", "", "", "", "", Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), "" }, CpsRspInfo.class);
        public final PBStringField apurl = PBField.initString("");
        public final PBUInt64Field catelog_id = PBField.initUInt64(0L);
        public final PBStringField chantag = PBField.initString("");
        public final PBStringField deep_link = PBField.initString("");
        public final PBStringField h5_page = PBField.initString("");
        public final PBRepeatField<String> img_list = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBUInt64Field product_id = PBField.initUInt64(0L);
        public final PBStringField product_name = PBField.initString("");
        public final PBUInt32Field product_original_price = PBField.initUInt32(0);
        public final PBUInt32Field product_price = PBField.initUInt32(0);
        public qq_ad_get.QQAdGetRsp.AdInfo.QQAppInfo qq_app_info = new qq_ad_get.QQAdGetRsp.AdInfo.QQAppInfo();
        public final PBStringField rl = PBField.initString("");
        public final PBStringField sales_tips = PBField.initString("");
        public final PBUInt32Field source = PBField.initUInt32(0);
        public qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo wechat_app_info = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
      }
      
      public static final class DestInfo
        extends MessageMicro<DestInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "dest_url_display_type", "landing_page", "canvas_json", "dest_type", "pop_sheet", "universal_link" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", "" }, DestInfo.class);
        public final PBStringField canvas_json = PBField.initString("");
        public final PBUInt32Field dest_type = PBField.initUInt32(0);
        public final PBUInt32Field dest_url_display_type = PBField.initUInt32(0);
        public final PBStringField landing_page = PBField.initString("");
        public final PBStringField pop_sheet = PBField.initString("");
        public final PBStringField universal_link = PBField.initString("");
      }
      
      public static final class DisplayInfo
        extends MessageMicro<DisplayInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 66, 74, 80, 93, 96, 106, 114, 122 }, new String[] { "pattern_type", "creative_size", "animation_effect", "basic_info", "button_info", "muti_pic_text_info", "advertiser_info", "video_info", "local_info", "mini_program_type", "ecpm", "inner_adshowtype", "video_info2", "mini_program_name", "mini_program_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0), null, "", "" }, DisplayInfo.class);
        public AdvertiserInfo advertiser_info = new AdvertiserInfo();
        public final PBUInt32Field animation_effect = PBField.initUInt32(0);
        public BasicInfo basic_info = new BasicInfo();
        public final PBRepeatMessageField<ButtonInfo> button_info = PBField.initRepeatMessage(ButtonInfo.class);
        public final PBUInt32Field creative_size = PBField.initUInt32(0);
        public final PBFloatField ecpm = PBField.initFloat(0.0F);
        public final PBUInt32Field inner_adshowtype = PBField.initUInt32(0);
        public qq_common.LocalInfo local_info = new qq_common.LocalInfo();
        public final PBStringField mini_program_id = PBField.initString("");
        public final PBStringField mini_program_name = PBField.initString("");
        public final PBUInt32Field mini_program_type = PBField.initUInt32(0);
        public MutiPicTextInfo muti_pic_text_info = new MutiPicTextInfo();
        public final PBUInt32Field pattern_type = PBField.initUInt32(0);
        public VideoInfo video_info = new VideoInfo();
        public VideoInfo video_info2 = new VideoInfo();
        
        public static final class AdvertiserInfo
          extends MessageMicro<AdvertiserInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "corporation_name", "corporate_image_name", "corporate_logo", "advertiser_id", "ad_first_category", "ad_second_category" }, new Object[] { "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, AdvertiserInfo.class);
          public final PBUInt64Field ad_first_category = PBField.initUInt64(0L);
          public final PBUInt64Field ad_second_category = PBField.initUInt64(0L);
          public final PBUInt64Field advertiser_id = PBField.initUInt64(0L);
          public final PBStringField corporate_image_name = PBField.initString("");
          public final PBStringField corporate_logo = PBField.initString("");
          public final PBStringField corporation_name = PBField.initString("");
        }
        
        public static final class BasicInfo
          extends MessageMicro<BasicInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48 }, new String[] { "img", "img_s", "txt", "desc", "pic_width", "pic_height" }, new Object[] { "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, BasicInfo.class);
          public final PBStringField desc = PBField.initString("");
          public final PBStringField img = PBField.initString("");
          public final PBStringField img_s = PBField.initString("");
          public final PBUInt32Field pic_height = PBField.initUInt32(0);
          public final PBUInt32Field pic_width = PBField.initUInt32(0);
          public final PBStringField txt = PBField.initString("");
        }
        
        public static final class ButtonInfo
          extends MessageMicro<ButtonInfo>
        {
          public static final int BUTTON_POS_LEFT_BOTTOM_CORNER = 1;
          public static final int BUTTON_POS_RIGHT_BOTTOM_CORNER = 2;
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "txt", "url", "pos" }, new Object[] { "", "", Integer.valueOf(1) }, ButtonInfo.class);
          public final PBEnumField pos = PBField.initEnum(1);
          public final PBStringField txt = PBField.initString("");
          public final PBStringField url = PBField.initString("");
        }
        
        public static final class MutiPicTextInfo
          extends MessageMicro<MutiPicTextInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "txt", "image", "url" }, new Object[] { "", "", "" }, MutiPicTextInfo.class);
          public final PBRepeatField<String> image = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> txt = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> url = PBField.initRepeat(PBStringField.__repeatHelper__);
        }
        
        public static final class VideoInfo
          extends MessageMicro<VideoInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "video_url", "media_duration", "tencent_video_id", "video_file_size", "no_auto_play" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), Boolean.valueOf(false) }, VideoInfo.class);
          public final PBUInt32Field media_duration = PBField.initUInt32(0);
          public final PBBoolField no_auto_play = PBField.initBool(false);
          public final PBStringField tencent_video_id = PBField.initString("");
          public final PBUInt32Field video_file_size = PBField.initUInt32(0);
          public final PBStringField video_url = PBField.initString("");
        }
      }
      
      public static final class ExpInfo
        extends MessageMicro<ExpInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "qq_game_video_ad_style", "reward_video_download_type", "video_countdown", "video_volume", "video_countdown_style", "interstitial_ad_style" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ExpInfo.class);
        public final PBInt32Field interstitial_ad_style = PBField.initInt32(0);
        public final PBInt32Field qq_game_video_ad_style = PBField.initInt32(0);
        public final PBInt32Field reward_video_download_type = PBField.initInt32(0);
        public final PBInt32Field video_countdown = PBField.initInt32(0);
        public final PBInt32Field video_countdown_style = PBField.initInt32(0);
        public final PBInt32Field video_volume = PBField.initInt32(0);
      }
      
      public static final class ExpParam
        extends MessageMicro<ExpParam>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "key", "value" }, new Object[] { Integer.valueOf(0), "" }, ExpParam.class);
        public final PBUInt32Field key = PBField.initUInt32(0);
        public final PBStringField value = PBField.initString("");
      }
      
      public static final class Ext
        extends MessageMicro<Ext>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 66, 74, 80 }, new String[] { "mini_program_preload", "no_clkcgi_jump", "landing_page_style", "market_deep_link", "disable_auto_download", "market_package_name", "render_pos_type", "exp_map", "xj_offline", "relation_target" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), "", Boolean.valueOf(false), "", Integer.valueOf(0), null, null, Integer.valueOf(0) }, Ext.class);
        public final PBBoolField disable_auto_download = PBField.initBool(false);
        public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo.ExpParam> exp_map = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.ExpParam.class);
        public final PBInt32Field landing_page_style = PBField.initInt32(0);
        public final PBStringField market_deep_link = PBField.initString("");
        public final PBStringField market_package_name = PBField.initString("");
        public final PBUInt32Field mini_program_preload = PBField.initUInt32(0);
        public final PBBoolField no_clkcgi_jump = PBField.initBool(false);
        public final PBUInt32Field relation_target = PBField.initUInt32(0);
        public final PBEnumField render_pos_type = PBField.initEnum(0);
        public qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo xj_offline = new qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo();
      }
      
      public static final class OfflinePageInfo
        extends MessageMicro<OfflinePageInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "offline_landing_page", "offline_json_url", "offline_json_key", "offline_id" }, new Object[] { "", "", "", Integer.valueOf(0) }, OfflinePageInfo.class);
        public final PBInt32Field offline_id = PBField.initInt32(0);
        public final PBStringField offline_json_key = PBField.initString("");
        public final PBStringField offline_json_url = PBField.initString("");
        public final PBStringField offline_landing_page = PBField.initString("");
      }
      
      public static final class QQAppInfo
        extends MessageMicro<QQAppInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField app_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField app_path = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBytesField app_schema = PBField.initBytes(ByteStringMicro.EMPTY);
        
        static
        {
          ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
          ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
          ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
          __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "app_id", "app_path", "app_schema" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, QQAppInfo.class);
        }
      }
      
      public static final class ReportInfo
        extends MessageMicro<ReportInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "exposure_url", "click_url", "effect_url", "landing_page_report_url", "negative_feedback_url", "trace_info", "video_report_url", "thirdparty_monitor_urls" }, new Object[] { "", "", "", "", "", null, "", null }, ReportInfo.class);
        public final PBStringField click_url = PBField.initString("");
        public final PBStringField effect_url = PBField.initString("");
        public final PBStringField exposure_url = PBField.initString("");
        public final PBStringField landing_page_report_url = PBField.initString("");
        public final PBStringField negative_feedback_url = PBField.initString("");
        public ThirdPartyMonitorUrls thirdparty_monitor_urls = new ThirdPartyMonitorUrls();
        public TraceInfo trace_info = new TraceInfo();
        public final PBStringField video_report_url = PBField.initString("");
        
        public static final class ThirdPartyMonitorUrls
          extends MessageMicro<ThirdPartyMonitorUrls>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 58 }, new String[] { "api_exposure_monitor_url", "sdk_exposure_monitor_url", "api_click_monitor_url", "sdk_click_monitor_url", "video_play_monitor_url", "video_play_duration", "active_view_tracking_url" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), "" }, ThirdPartyMonitorUrls.class);
          public final PBRepeatField<String> active_view_tracking_url = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> api_click_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> api_exposure_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> sdk_click_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBRepeatField<String> sdk_exposure_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
          public final PBUInt32Field video_play_duration = PBField.initUInt32(0);
          public final PBRepeatField<String> video_play_monitor_url = PBField.initRepeat(PBStringField.__repeatHelper__);
        }
        
        public static final class TraceInfo
          extends MessageMicro<TraceInfo>
        {
          static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 64 }, new String[] { "aid", "traceid", "via", "view_id", "product_id", "noco_id", "net_log_req_id", "creative_id" }, new Object[] { Long.valueOf(0L), "", "", "", "", Long.valueOf(0L), "", Long.valueOf(0L) }, TraceInfo.class);
          public final PBUInt64Field aid = PBField.initUInt64(0L);
          public final PBUInt64Field creative_id = PBField.initUInt64(0L);
          public final PBStringField net_log_req_id = PBField.initString("");
          public final PBInt64Field noco_id = PBField.initInt64(0L);
          public final PBStringField product_id = PBField.initString("");
          public final PBStringField traceid = PBField.initString("");
          public final PBStringField via = PBField.initString("");
          public final PBStringField view_id = PBField.initString("");
        }
      }
      
      public static final class WeChatAppInfo
        extends MessageMicro<WeChatAppInfo>
      {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "app_username", "app_path", "app_token", "app_id", "ad_trace_data", "pos_id" }, new Object[] { "", "", "", "", "", Long.valueOf(0L) }, WeChatAppInfo.class);
        public final PBStringField ad_trace_data = PBField.initString("");
        public final PBStringField app_id = PBField.initString("");
        public final PBStringField app_path = PBField.initString("");
        public final PBStringField app_token = PBField.initString("");
        public final PBStringField app_username = PBField.initString("");
        public final PBUInt64Field pos_id = PBField.initUInt64(0L);
      }
    }
    
    public static final class PosAdInfo
      extends MessageMicro<PosAdInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "ret", "msg", "pos_id", "ads_info", "no_ad_indicator" }, new Object[] { Integer.valueOf(0), "", "", null, null }, PosAdInfo.class);
      public final PBRepeatMessageField<qq_ad_get.QQAdGetRsp.AdInfo> ads_info = PBField.initRepeatMessage(qq_ad_get.QQAdGetRsp.AdInfo.class);
      public final PBStringField msg = PBField.initString("");
      public indicator.NoAdIndicator no_ad_indicator = new indicator.NoAdIndicator();
      public final PBStringField pos_id = PBField.initString("");
      public final PBInt32Field ret = PBField.initInt32(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.gdt.qq_ad_get
 * JD-Core Version:    0.7.0.1
 */