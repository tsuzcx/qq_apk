package com.tencent.ad.tangram.protocol;

public final class qq_ad_get
{
  public static final class QQAdGet
  {
    public String busi_cookie;
    public ContextInfo context_info;
    public DebugInfo debug_info;
    public DeviceInfo device_info;
    public ExternalExpInfo external_exp_info = new ExternalExpInfo();
    public String gdt_cookie;
    public PositionInfo[] position_info;
    public boolean support_https = false;
    public UserInfo user_info;
    
    public static final class ContextInfo
    {
      public long article_id = 0L;
      public long public_id = 0L;
      public qq_ad_get.QQAdGet.QQPublicCategoryInfo[] qq_public_category;
      public int source_from = 0;
      public String str_source_from;
      public int tribe_id_tag = 0;
      public int tribe_tag = 0;
    }
    
    public static final class DebugInfo
    {
      public boolean debug = false;
      public int debug_adindexid = 0;
      public boolean nomatch = false;
    }
    
    public static final class DeviceInfo
    {
      public String aid_ticket;
      public String android_id;
      public int app_version_id = 0;
      public int carrier_code = 0;
      public String client_ip;
      public String client_ipv4;
      public int conn = 0;
      public String device_brand_and_model;
      public int device_orientation = 0;
      public String idfa;
      public String imei;
      public String ios_qidfa;
      public boolean is_googleplay_version = false;
      public boolean is_ios_review_state = false;
      public boolean is_wk_webview = false;
      public Location location;
      public String mac;
      public String manufacturer;
      public String md5_android_id;
      public String md5_mac;
      public String muid;
      public int muid_type = 0;
      public String oaid;
      public int origin_network_type = 0;
      public int os_type = 0;
      public String os_ver;
      public String qadid;
      public String qq_ver;
      public String taid_ticket;
      public long wx_api_ver = 0L;
      public boolean wx_installed = false;
      public boolean wx_ul = false;
      
      public static final class Location
      {
        public int coordinates_type = 0;
        public int latitude = 0;
        public int longitude = 0;
      }
    }
    
    public static final class ExternalExpInfo
    {
      public String[] exp_id;
      public int traffic_type = 0;
    }
    
    public static final class PositionInfo
    {
      public int ad_count = 0;
      public PositionExt pos_ext;
      public String pos_id;
      
      public static final class PositionExt
      {
        public static final int FETCH_TYPE_PREFETCH = 1;
        public static final int FETCH_TYPE_REAL_TIME = 0;
        public static final int FETCH_TYPE_SPECIFY_AD = 2;
        public CpsReqInfo[] cps_req_info;
        public int deep_link_version = 0;
        public int get_ad_type = 0;
        public ShareInfo share_info;
        public SpecifiedAdsItem[] specified_ads;
        public String sub_position_id;
        public VideoReqInfo video_req_info = new VideoReqInfo();
        
        public static final class CpsReqInfo
        {
          public long catelog_id = 0L;
          public cps_info.PcgMediaTraceInfo[] pcg_media_trace_info;
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductLinkInfo[] product_link_info;
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ProductShareInfo[] product_share_info;
        }
        
        public static final class MiniProgramLink
        {
          public String app_id;
          public String page_path;
          public String schema_link;
          public String user_name;
        }
        
        public static final class ProductLinkInfo
        {
          public String h5_page;
          public long product_id = 0L;
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink qq_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink wx_miniprogram_link = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.MiniProgramLink();
        }
        
        public static final class ProductShareInfo
        {
          public long product_id = 0L;
          public qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo share_info = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
        }
        
        public static final class ShareInfo
        {
          public String share_check;
          public int share_rate = 0;
        }
        
        public static final class SpecifiedAdsItem
        {
          public long aid = 0L;
          public long creative_id = 0L;
          public int prefetch_timestamp = 0;
        }
        
        public static final class VideoReqInfo
        {
          public int video_max_duration = 0;
          public int video_min_duration = 0;
        }
      }
    }
    
    public static final class QQPublicCategoryInfo
    {
      public String qq_public_category_id;
      public int qq_public_category_level = 0;
    }
    
    public static final class UserInfo
    {
      public String media_specified_id;
      public long qq = 0L;
      public long qq_appid = 0L;
      public String qq_openid;
      public String wuid;
      public String wx_appid;
      public String wx_openid;
    }
  }
  
  public static final class QQAdGetRsp
  {
    public String busi_cookie;
    public String debug_info;
    public String gdt_cookie;
    public String msg;
    public PosAdInfo[] pos_ads_info;
    public int ret = 0;
    
    public static final class AdInfo
    {
      public AppInfo app_info;
      public CpsRspInfo[] cps_rsp_info;
      public DestInfo dest_info;
      public DisplayInfo display_info;
      public ExpInfo exp_info;
      public Ext ext;
      public String ext_json;
      public int product_type = 0;
      public ReportInfo report_info;
      public WeChatAppInfo wechat_app_info = new WeChatAppInfo();
      
      public static final class AppInfo
      {
        public String android_app_id;
        public String app_logo_url;
        public String app_name;
        public String app_package_name;
        public long app_package_size = 0L;
        public String app_package_version;
        public String app_score;
        public int app_score_num = 0;
        public String channel_id;
        public String customized_invoke_url;
        public long download_num = 0L;
        public String ios_app_id;
        public String pkg_download_schema;
        public String pkg_url;
      }
      
      public static final class CpsRspInfo
      {
        public String apurl;
        public long catelog_id = 0L;
        public String chantag;
        public String deep_link;
        public String h5_page;
        public String[] img_list;
        public long product_id = 0L;
        public String product_name;
        public int product_original_price = 0;
        public int product_price = 0;
        public qq_ad_get.QQAdGetRsp.AdInfo.QQAppInfo qq_app_info = new qq_ad_get.QQAdGetRsp.AdInfo.QQAppInfo();
        public String rl;
        public String sales_tips;
        public int source = 0;
        public qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo wechat_app_info = new qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo();
      }
      
      public static final class DestInfo
      {
        public String canvas_json;
        public int dest_type = 0;
        public int dest_url_display_type = 0;
        public String landing_page;
        public String pop_sheet;
        public String universal_link;
      }
      
      public static final class DisplayInfo
      {
        public AdvertiserInfo advertiser_info;
        public int animation_effect = 0;
        public BasicInfo basic_info;
        public ButtonInfo[] button_info;
        public int creative_size = 0;
        public float ecpm = 0.0F;
        public int inner_adshowtype = 0;
        public qq_common.LocalInfo local_info;
        public String mini_program_id;
        public String mini_program_name;
        public int mini_program_type = 0;
        public MutiPicTextInfo muti_pic_text_info;
        public int pattern_type = 0;
        public VideoInfo video_info;
        public VideoInfo video_info2;
        
        public static final class AdvertiserInfo
        {
          public long ad_first_category = 0L;
          public long ad_second_category = 0L;
          public long advertiser_id = 0L;
          public String corporate_image_name;
          public String corporate_logo;
          public String corporation_name;
        }
        
        public static final class BasicInfo
        {
          public String desc;
          public String img;
          public String img_s;
          public int pic_height = 0;
          public int pic_width = 0;
          public String txt;
        }
        
        public static final class ButtonInfo
        {
          public static final int BUTTON_POS_LEFT_BOTTOM_CORNER = 1;
          public static final int BUTTON_POS_RIGHT_BOTTOM_CORNER = 2;
          public int pos = 1;
          public String txt;
          public String url;
        }
        
        public static final class MutiPicTextInfo
        {
          public String[] image;
          public String[] txt;
          public String[] url;
        }
        
        public static final class VideoInfo
        {
          public int media_duration = 0;
          public boolean no_auto_play = false;
          public String tencent_video_id;
          public int video_file_size = 0;
          public String video_url;
        }
      }
      
      public static final class ExpInfo
      {
        public int interstitial_ad_style = 0;
        public int qq_game_video_ad_style = 0;
        public int reward_video_download_type = 0;
        public int video_countdown = 0;
        public int video_countdown_style = 0;
        public int video_volume = 0;
      }
      
      public static final class ExpParam
      {
        public int key = 0;
        public String value;
      }
      
      public static final class Ext
      {
        public boolean disable_auto_download = false;
        public qq_ad_get.QQAdGetRsp.AdInfo.ExpParam[] exp_map;
        public int landing_page_style = 0;
        public String market_deep_link;
        public String market_package_name;
        public int mini_program_preload = 0;
        public boolean no_clkcgi_jump = false;
        public int relation_target = 0;
        public int render_pos_type = 0;
        public qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo xj_offline = new qq_ad_get.QQAdGetRsp.AdInfo.OfflinePageInfo();
      }
      
      public static final class OfflinePageInfo
      {
        public int offline_id = 0;
        public String offline_json_key;
        public String offline_json_url;
        public String offline_landing_page;
      }
      
      public static final class QQAppInfo {}
      
      public static final class ReportInfo
      {
        public String click_url;
        public String effect_url;
        public String exposure_url;
        public String landing_page_report_url;
        public String negative_feedback_url;
        public ThirdPartyMonitorUrls thirdparty_monitor_urls;
        public TraceInfo trace_info;
        public String video_report_url;
        
        public static final class ThirdPartyMonitorUrls
        {
          public String active_view_tracking_url;
          public String[] api_click_monitor_url;
          public String[] api_exposure_monitor_url;
          public String[] sdk_click_monitor_url;
          public String[] sdk_exposure_monitor_url;
          public int video_play_duration;
          public String video_play_monitor_url;
        }
        
        public static final class TraceInfo
        {
          public long aid = 0L;
          public long creative_id = 0L;
          public String net_log_req_id;
          public long noco_id = 0L;
          public String product_id;
          public String traceid;
          public String via;
          public String view_id;
        }
      }
      
      public static final class WeChatAppInfo
      {
        public String ad_trace_data;
        public String app_id;
        public String app_path;
        public String app_token;
        public String app_username;
        public long pos_id = 0L;
      }
    }
    
    public static final class PosAdInfo
    {
      public qq_ad_get.QQAdGetRsp.AdInfo[] ads_info;
      public String msg;
      public indicator.NoAdIndicator no_ad_indicator = new indicator.NoAdIndicator();
      public String pos_id;
      public int ret = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.qq_ad_get
 * JD-Core Version:    0.7.0.1
 */