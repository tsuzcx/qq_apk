package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.ArticleTagInfo;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;

public final class oidb_cmd0x68b
{
  public static final class AdPosInfo
    extends MessageMicro<AdPosInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_ad_pos = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ad_article_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_ad_pos", "uint64_ad_article_id", "bytes_trace_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, AdPosInfo.class);
    }
  }
  
  public static final class AdPosMap
    extends MessageMicro<AdPosMap>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int_req_type = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_cmd0x68b.AdPosInfo> rpt_ad_pos_info_list = PBField.initRepeatMessage(oidb_cmd0x68b.AdPosInfo.class);
    public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "rpt_ad_pos_info_list", "bytes_ads_context", "bytes_ad_user_info", "uint64_ad_channel_id", "int_req_type" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, AdPosMap.class);
    }
  }
  
  public static final class AdReqInfo
    extends MessageMicro<AdReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_ad_channel_id" }, new Object[] { Long.valueOf(0L) }, AdReqInfo.class);
    public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
  }
  
  public static final class BackOffGroupInfo
    extends MessageMicro<BackOffGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_back_off_group = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_max_evoke_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_fresh_evoke_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_back_off_group", "uint32_max_evoke_count", "uint32_max_fresh_evoke_count" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, BackOffGroupInfo.class);
    }
  }
  
  public static final class ChannelLocationInfo
    extends MessageMicro<ChannelLocationInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField city_code = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nation = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 74, 90, 98, 106 }, new String[] { "city_code", "nation", "province", "city" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ChannelLocationInfo.class);
    }
  }
  
  public static final class CommentInfoList
    extends MessageMicro<CommentInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_comment_info_list" }, new Object[] { null }, CommentInfoList.class);
    public final PBRepeatMessageField<articlesummary.CommentInfo> rpt_comment_info_list = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
  }
  
  public static final class DailyArticleInfo
    extends MessageMicro<DailyArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(articlesummary.ArticleTagInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_rowkey", "rpt_article_tag_list" }, new Object[] { localByteStringMicro, null }, DailyArticleInfo.class);
    }
  }
  
  public static final class ExposeArticleInfo
    extends MessageMicro<ExposeArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkeys = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_rowkeys", "uint64_algorithm_id", "uint32_feeds_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, ExposeArticleInfo.class);
    }
  }
  
  public static final class ExposeTopic
    extends MessageMicro<ExposeTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_business_id", "uint32_expose_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ExposeTopic.class);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_time = PBField.initUInt32(0);
  }
  
  public static final class InnerMsg
    extends MessageMicro<InnerMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField article_content_type = PBField.initEnum(1);
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField template_id = PBField.initEnum(70001);
    public final PBEnumField uint32_jump_src_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "bytes_inner_uniq_id", "bytes_title", "uint64_algorithm_id", "uint32_strategy_id", "uint32_jump_src_type", "bytes_push_context", "template_id", "article_content_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro3, Integer.valueOf(70001), Integer.valueOf(1) }, InnerMsg.class);
    }
  }
  
  public static final class OneSetTopCookie
    extends MessageMicro<OneSetTopCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flash_times = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_server_update_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_set_top_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_article_id", "uint64_set_top_time", "uint32_flash_times", "uint64_server_update_time", "bytes_inner_uniq_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, OneSetTopCookie.class);
    }
  }
  
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wx_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_androidid = PBField.initString("");
    public final PBStringField string_client_ipv4 = PBField.initString("");
    public final PBStringField string_idfa = PBField.initString("");
    public final PBStringField string_imei = PBField.initString("");
    public final PBStringField string_mac = PBField.initString("");
    public final PBStringField string_oaid = PBField.initString("");
    public final PBStringField string_qadid = PBField.initString("");
    public final PBStringField string_taid = PBField.initString("");
    public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
    public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
    public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_func_flag = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type", "uint64_func_flag", "bytes_ads_context", "bytes_manufacturer", "bytes_device_brand_and_model", "string_qadid", "string_oaid", "string_taid", "string_androidid", "string_mac", "string_client_ipv4", "string_imei", "string_idfa", "bytes_wx_ver" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, "", "", "", "", "", "", "", "", localByteStringMicro9 }, PhoneInfo.class);
    }
  }
  
  public static final class PkgInstallInfo
    extends MessageMicro<PkgInstallInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pkg_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_installed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "bytes_pkg_name", "uint32_is_installed", "uint32_platform_type", "bytes_version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, PkgInstallInfo.class);
    }
  }
  
  public static final class RefreshHistory
    extends MessageMicro<RefreshHistory>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> rpt_refresh_history = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_session_id", "rpt_refresh_history" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, RefreshHistory.class);
    }
  }
  
  public static final class ReqAdvertisePara
    extends MessageMicro<ReqAdvertisePara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x68b.AdReqInfo msg_ad_req_info = new oidb_cmd0x68b.AdReqInfo();
    public oidb_cmd0x68b.PhoneInfo msg_phone_info = new oidb_cmd0x68b.PhoneInfo();
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_channel_id", "msg_phone_info", "uint64_last_time", "bytes_ad_user_info", "msg_ad_req_info" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), localByteStringMicro, null }, ReqAdvertisePara.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nearby_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sso_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_style_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_refresh_type = PBField.initEnum(1);
    public final PBEnumField enum_req_feeds_style = PBField.initEnum(0);
    public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
    public oidb_cmd0x68b.ReqGetFollowTabPara msg_get_follow_tab_feeds_para = new oidb_cmd0x68b.ReqGetFollowTabPara();
    public oidb_cmd0x68b.RefreshHistory msg_refresh_history = new oidb_cmd0x68b.RefreshHistory();
    public oidb_cmd0x68b.ReqChannelPara reqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
    public oidb_cmd0x68b.ReqAdvertisePara req_advertise_para = new oidb_cmd0x68b.ReqAdvertisePara();
    public final PBRepeatField<Long> rpt_curr_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_sim_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_topic_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_client_swithes = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 96, 104, 112, 120, 128, 138, 144, 154, 162, 170, 178, 184, 194, 1602 }, new String[] { "uint64_uin", "uint32_network_type", "reqChannelPara", "uint32_req_topic_list", "rpt_curr_topicid_list", "uint32_req_dislike_type", "enum_req_feeds_style", "uint64_client_swithes", "req_advertise_para", "enum_refresh_type", "msg_refresh_history", "msg_get_follow_tab_feeds_para", "location_info", "bytes_nearby_cookie", "uint32_req_sim_type", "bytes_sso_client_version", "bytes_style_version" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(1), null, null, null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, ReqBody.class);
    }
  }
  
  public static final class ReqChannelPara
    extends MessageMicro<ReqChannelPara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_group_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_lbs_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_recommend_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sso_service_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x68b.ChannelLocationInfo msg_channel_location_info = new oidb_cmd0x68b.ChannelLocationInfo();
    public final PBRepeatField<Long> rpt_curr_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_curr_article_rowkey = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x68b.DailyArticleInfo> rpt_daily_article_info = PBField.initRepeatMessage(oidb_cmd0x68b.DailyArticleInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.InnerMsg.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.PkgInstallInfo> rpt_pkg_install_info = PBField.initRepeatMessage(oidb_cmd0x68b.PkgInstallInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.SubscribeMsg> rpt_subscribe_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.SubscribeMsg.class);
    public final PBRepeatField<Long> rpt_subscription_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_is_support_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_support_packinfo = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_support_video_with_small_picture = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_support_without_picture = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_force_set_top = PBField.initUInt32(0);
    public final PBUInt32Field uint32_privacy_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_article_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_channel_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_deleted_article_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_is_disp_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_media_specs = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_merged_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_neisou_article_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_picture_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_picture_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_video_list = PBField.initUInt32(0);
    public final PBUInt32Field uint32_residence_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_times_one_day = PBField.initUInt32(0);
    public final PBUInt32Field uint32_youngster_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_cur_feeds_refresh_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
    public oidb_cmd0x68b.UserExposeArticle user_expose_article = new oidb_cmd0x68b.UserExposeArticle();
    public oidb_cmd0x68b.UserReadArticle user_read_article = new oidb_cmd0x68b.UserReadArticle();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160, 170, 176, 184, 194, 200, 208, 216, 226, 232, 240, 248, 256, 274, 282, 290, 298, 306, 314, 322, 330, 336, 346, 352, 362, 368, 376, 386, 392, 402 }, new String[] { "uint64_channel_id", "uint32_req_channel_list", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "uint32_req_article_list", "uint32_req_deleted_article_list", "rpt_curr_article_list", "uint32_req_recommend_flag", "rpt_subscription_article_list", "uint32_req_video_list", "uint32_req_picture_list", "uint32_need_force_set_top", "bytes_set_top_cookie", "uint32_req_neisou_article_list", "bytes_device_id", "uint32_update_times", "uint32_req_merged_video", "rpt_subscribe_msg_list", "uint32_is_support_without_picture", "uint32_req_media_specs", "uint32_is_support_video_with_small_picture", "rpt_inner_msg_list", "uint32_req_is_disp_timestamp", "uint32_is_support_gallery", "uint32_req_picture_number", "uint32_is_support_packinfo", "bytes_lbs_data", "bytes_group_push_context", "rpt_curr_article_rowkey", "bytes_manufacturer", "bytes_device_brand_and_model", "rpt_pkg_install_info", "rpt_daily_article_info", "msg_channel_location_info", "uint32_privacy_status", "user_read_article", "uint64_cur_feeds_refresh_seq", "bytes_sso_service_data", "uint32_update_times_one_day", "uint32_residence_time", "user_expose_article", "uint32_youngster_status", "bytes_req_recommend_json" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro9 }, ReqChannelPara.class);
    }
  }
  
  public static final class ReqGetFollowTabPara
    extends MessageMicro<ReqGetFollowTabPara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_last_feed_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_red_dot_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_refresh_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_curr_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<oidb_cmd0x68b.ExposeTopic> rpt_expose_topic_list = PBField.initRepeatMessage(oidb_cmd0x68b.ExposeTopic.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0x68b.InnerMsg.class);
    public final PBUInt32Field uint32_enter_topic_reddot_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
    public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 88, 96, 104, 114, 122, 128, 138, 146, 152, 162, 170, 178 }, new String[] { "uint64_channel_id", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "rpt_curr_article_list", "bytes_set_top_cookie", "bytes_device_id", "uint32_update_times", "rpt_inner_msg_list", "rpt_expose_topic_list", "uint32_enter_topic_reddot_time", "bytes_refresh_cookie", "bytes_last_feed_cookie", "bytes_red_dot_cookie" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ReqGetFollowTabPara.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_new_style_params = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x68b.RspGetFollowTabData msg_rsp_get_follow_tab_data = new oidb_cmd0x68b.RspGetFollowTabData();
    public oidb_cmd0x68b.RspTrace msg_rsp_trace = new oidb_cmd0x68b.RspTrace();
    public final PBRepeatField<Long> rpt_obsolete_topicid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_cmd0x68b.RspChannelArticle rspChannelArticle = new oidb_cmd0x68b.RspChannelArticle();
    public oidb_cmd0x68b.RspRedBonusInfo rspRedBonusInfo = new oidb_cmd0x68b.RspRedBonusInfo();
    public oidb_cmd0x68b.RspTopicList rspTopicList = new oidb_cmd0x68b.RspTopicList();
    public final PBUInt64Field uint64_client_swithes = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104, 114, 122, 128, 138, 802 }, new String[] { "uint64_uin", "rspChannelArticle", "rspTopicList", "rpt_obsolete_topicid_list", "rspRedBonusInfo", "msg_rsp_get_follow_tab_data", "uint64_client_swithes", "msg_rsp_trace", "bytes_new_style_params" }, new Object[] { Long.valueOf(0L), null, null, Long.valueOf(0L), null, null, Long.valueOf(0L), null, localByteStringMicro }, RspBody.class);
    }
  }
  
  public static final class RspChannelArticle
    extends MessageMicro<RspChannelArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nearby_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pre_load_req_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_small_game_rsp_pack = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x68b.AdPosMap msg_ad_pos_map = new oidb_cmd0x68b.AdPosMap();
    public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_advertise_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
    public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.BackOffGroupInfo> rpt_back_off_group_info = PBField.initRepeatMessage(oidb_cmd0x68b.BackOffGroupInfo.class);
    public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_deleted_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
    public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_cur_feeds_refresh_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 112, 122, 130, 138, 146, 152, 162, 170 }, new String[] { "uint64_channel_id", "uint32_is_no_more_data", "rpt_article_list", "rpt_deleted_article_list", "bytes_set_top_cookie", "uint64_pos_ad_time", "rpt_advertise_list", "msg_ad_pos_map", "bytes_nearby_cookie", "bytes_pre_load_req_info", "uint64_cur_feeds_refresh_seq", "rpt_back_off_group_info", "bytes_small_game_rsp_pack" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro1, Long.valueOf(0L), null, null, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), null, localByteStringMicro4 }, RspChannelArticle.class);
    }
  }
  
  public static final class RspGetFollowTabData
    extends MessageMicro<RspGetFollowTabData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_refresh_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x68b.RspGetFollowTabFeeds.class);
    public articlesummary.TopicRecommendFeedsInfo topic_update_info = new articlesummary.TopicRecommendFeedsInfo();
    public final PBUInt32Field uint32_has_followed_topic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hint_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
    public final PBUInt32Field uint32_refresh_topic_update_info = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_reddot_update_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104, 114, 120, 128, 138, 144 }, new String[] { "uint32_is_no_more_data", "rpt_article_list", "bytes_set_top_cookie", "uint32_refresh_topic_update_info", "topic_update_info", "uint32_has_followed_topic", "uint32_topic_reddot_update_num", "bytes_refresh_cookie", "uint32_hint_index" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, RspGetFollowTabData.class);
    }
  }
  
  public static final class RspGetFollowTabFeeds
    extends MessageMicro<RspGetFollowTabFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_feeds_type", "msg_article_summary", "uint64_follow_recommend_id" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, RspGetFollowTabFeeds.class);
    public articlesummary.ArticleSummary msg_article_summary = new articlesummary.ArticleSummary();
    public final PBEnumField uint32_feeds_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_follow_recommend_id = PBField.initUInt64(0L);
  }
  
  public static final class RspRedBonusInfo
    extends MessageMicro<RspRedBonusInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_accumlated_days", "uint32_required_days", "str_turntable_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, RspRedBonusInfo.class);
    public final PBStringField str_turntable_url = PBField.initString("");
    public final PBUInt32Field uint32_accumlated_days = PBField.initUInt32(0);
    public final PBUInt32Field uint32_required_days = PBField.initUInt32(0);
  }
  
  public static final class RspTopicList
    extends MessageMicro<RspTopicList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint32_position", "uint32_fix_position", "rpt_topic_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, RspTopicList.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.TopicInfo> rpt_topic_list = PBField.initRepeatMessage(oidb_cmd0x68b.TopicInfo.class);
    public final PBUInt32Field uint32_fix_position = PBField.initUInt32(0);
    public final PBUInt32Field uint32_position = PBField.initUInt32(0);
  }
  
  public static final class RspTrace
    extends MessageMicro<RspTrace>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_trace_record_list" }, new Object[] { null }, RspTrace.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.RspTraceRecord> rpt_trace_record_list = PBField.initRepeatMessage(oidb_cmd0x68b.RspTraceRecord.class);
  }
  
  public static final class RspTraceRecord
    extends MessageMicro<RspTraceRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_method = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cost = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_method", "uint32_cost" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, RspTraceRecord.class);
    }
  }
  
  public static final class ServerContext
    extends MessageMicro<ServerContext>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "rpt_recommend_uin_list", "rpt_circle_id_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ServerContext.class);
    public final PBRepeatField<Long> rpt_circle_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> rpt_recommend_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class SetTopCookie
    extends MessageMicro<SetTopCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_one_set_top_cookie" }, new Object[] { null }, SetTopCookie.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.OneSetTopCookie> rpt_one_set_top_cookie = PBField.initRepeatMessage(oidb_cmd0x68b.OneSetTopCookie.class);
  }
  
  public static final class SubscribeMsg
    extends MessageMicro<SubscribeMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_source_article_id", "bytes_title", "uint64_algorithm_id", "uint32_strategy_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, SubscribeMsg.class);
    }
  }
  
  public static final class TopicInfo
    extends MessageMicro<TopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sum_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pv = PBField.initUInt32(0);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "uint64_topic_id", "bytes_title", "bytes_url", "bytes_sum_pic_url", "bytes_summary", "uint32_pv" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, TopicInfo.class);
    }
  }
  
  public static final class UserExposeArticle
    extends MessageMicro<UserExposeArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_article" }, new Object[] { null }, UserExposeArticle.class);
    public final PBRepeatMessageField<oidb_cmd0x68b.ExposeArticleInfo> rpt_article = PBField.initRepeatMessage(oidb_cmd0x68b.ExposeArticleInfo.class);
  }
  
  public static final class UserReadArticle
    extends MessageMicro<UserReadArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> bytes_read_rowkeys = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> bytes_unread_rowkeys = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_source", "bytes_read_rowkeys", "bytes_unread_rowkeys" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, UserReadArticle.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b
 * JD-Core Version:    0.7.0.1
 */