package tencent.im.oidb.cmd0x6cf;

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
import tencent.im.oidb.cmd0x885.oidb_0x885.AdReqInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;
import tencent.im.oidb.cmd0x885.oidb_0x885.RspBody;

public final class oidb_0x6cf
{
  public static final class AccountVInfo
    extends MessageMicro<AccountVInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_v_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_v_icon_url" }, new Object[] { localByteStringMicro }, AccountVInfo.class);
    }
  }
  
  public static final class AdInfo
    extends MessageMicro<AdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_download_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_apurl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporate_image_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporate_logo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corporation_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_customized_invoke_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_api_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_extra_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_image_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_img = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_s = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_landing_page = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_landing_page_report_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_price = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_product_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rl = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_title_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_via = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_view_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ad_jump_mode = PBField.initEnum(1);
    public final PBEnumField enum_ad_layout = PBField.initEnum(0);
    public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
    public final PBInt32Field int32_product_type = PBField.initInt32(0);
    public final PBInt64Field int64_noco_id = PBField.initInt64(0L);
    public final PBRepeatMessageField<AdInfo> rpt_msg_inner_ad_info = PBField.initRepeatMessage(AdInfo.class);
    public final PBRepeatMessageField<oidb_0x6cf.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x6cf.NegFeedback.class);
    public final PBStringField string_canvas_json = PBField.initString("");
    public final PBStringField string_effect_url = PBField.initString("");
    public final PBUInt32Field uint32_ad_material_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_material_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_material_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_algo_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dest_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dis_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stra_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ad_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_advertiser_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
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
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro25 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro26 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro27 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro28 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro29 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 130, 138, 146, 154, 162, 170, 178, 184, 194, 202, 208, 218, 226, 234, 240, 248, 256, 264, 272, 282, 288, 298, 304, 312, 320, 328, 338, 346, 354, 362, 370, 376, 384, 394, 400, 432, 466, 472, 490 }, new String[] { "uint64_channel_id", "int32_kd_pos", "bytes_cl", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "bytes_rl", "bytes_apurl", "bytes_trace_id", "bytes_product_id", "int32_product_type", "uint32_ad_type", "rpt_msg_inner_ad_info", "bytes_landing_page", "bytes_price", "bytes_button_txt", "bytes_view_id", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "bytes_title_list", "bytes_image_list", "bytes_url_list", "uint64_aid", "enum_ad_layout", "uint32_ad_material_id", "uint32_ad_material_width", "uint32_ad_material_height", "bytes_via", "uint32_dis_channel", "bytes_button_url", "uint32_duration", "enum_ad_jump_mode", "uint32_algo_id", "uint32_stra_id", "rpt_msg_neg_feedback", "bytes_extra_data", "bytes_app_download_schema", "string_canvas_json", "bytes_landing_page_report_url", "uint64_advertiser_id", "uint32_dest_type", "string_effect_url", "int64_noco_id", "uint64_feeds_id", "bytes_rowkey", "uint64_article_id", "bytes_download_api_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Long.valueOf(0L), localByteStringMicro18, localByteStringMicro19, Integer.valueOf(0), localByteStringMicro20, localByteStringMicro21, localByteStringMicro22, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro25, localByteStringMicro26, "", localByteStringMicro27, Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro28, Long.valueOf(0L), localByteStringMicro29 }, AdInfo.class);
    }
  }
  
  public static final class AdVideoPos
    extends MessageMicro<AdVideoPos>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
    public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_trace_id", "uint64_aid", "int32_kd_pos" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, AdVideoPos.class);
    }
  }
  
  public static final class AppAdInfo
    extends MessageMicro<AppAdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_download_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_open_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_clipboard_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_bundle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "bytes_icon_url", "bytes_name", "uint32_jump_type", "bytes_jump_url", "bytes_jump_bundle", "bytes_jump_schema", "bytes_app_download_wording", "bytes_app_open_wording", "bytes_app_desc", "bytes_clipboard_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9 }, AppAdInfo.class);
    }
  }
  
  public static final class ArticleSummary
    extends MessageMicro<ArticleSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ads_guide_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_aio_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_avatar_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_frd_praise_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qzone_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_recommend_barrage_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wechat_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.AccountVInfo msg_account_v_info = new oidb_0x6cf.AccountVInfo();
    public oidb_0x6cf.DownloadBarInfo msg_download_bar_info = new oidb_0x6cf.DownloadBarInfo();
    public oidb_0x6cf.ECommerceEntranceInfo msg_ecommerce_entrance_info = new oidb_0x6cf.ECommerceEntranceInfo();
    public oidb_0x6cf.FeedsInfo msg_feeds_info = new oidb_0x6cf.FeedsInfo();
    public oidb_0x6cf.FusionBiuInfo msg_fusion_biu_info = new oidb_0x6cf.FusionBiuInfo();
    public oidb_0x885.AdTagInfo msg_kd_tag_info = new oidb_0x885.AdTagInfo();
    public oidb_0x6cf.LikeDownloadBarInfo msg_like_download_bar_info = new oidb_0x6cf.LikeDownloadBarInfo();
    public oidb_0x6cf.SoftAdDownloadBarInfo msg_soft_ad_download_bar_info = new oidb_0x6cf.SoftAdDownloadBarInfo();
    public oidb_0x6cf.TopBarInfo msg_top_bar_info = new oidb_0x6cf.TopBarInfo();
    public oidb_0x6cf.TopicRecommendInfo msg_topic_recommend_info = new oidb_0x6cf.TopicRecommendInfo();
    public oidb_0x6cf.UGDownloadBarInfo msg_ug_bottom_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
    public oidb_0x6cf.UGDownloadBarInfo msg_ug_middle_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
    public oidb_0x6cf.UGDownloadBarInfo msg_ug_top_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
    public oidb_0x6cf.UGCFeedsInfo msg_ugc_feeds_info = new oidb_0x6cf.UGCFeedsInfo();
    public final PBRepeatMessageField<oidb_0x6cf.DisLikeInfo> rpt_dislike_list = PBField.initRepeatMessage(oidb_0x6cf.DisLikeInfo.class);
    public final PBRepeatMessageField<oidb_0x6cf.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(oidb_0x6cf.ChannelInfo.class);
    public final PBUInt32Field uint32_account_grade = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ads_guide_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_forbid_reprint_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_no_show_cover = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_trigger_sec = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public oidb_0x6cf.VideoColumnInfo video_column_info = new oidb_0x6cf.VideoColumnInfo();
    
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
      ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro25 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 168, 176, 186, 194, 202, 210, 242, 248, 258, 266, 272, 282, 288, 296, 304, 312, 320, 328, 338, 346, 354, 360, 370, 378, 386, 392, 402, 410, 418, 426, 432, 440, 450, 456, 466, 474, 482, 490, 498, 506, 514, 522, 530, 538, 544, 554, 562, 570 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_strategy_id", "uint32_video_play_count", "bytes_frd_praise_info", "bytes_inner_id", "msg_feeds_info", "rpt_label_list", "bytes_recommend_barrage_text_list", "uint32_video_comment_count", "rpt_dislike_list", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_ads_guide_txt", "uint32_ads_guide_time", "uint32_ads_source", "uint32_like_count", "uint32_myself_like_status", "uint32_video_source_type", "uint32_account_grade", "bytes_video_subscript_txt", "bytes_video_subscript_color", "msg_topic_recommend_info", "uint32_is_ugc", "msg_ugc_feeds_info", "msg_top_bar_info", "bytes_video_report_info", "uint32_biu_count", "msg_ecommerce_entrance_info", "bytes_avatar_jump_url", "msg_download_bar_info", "bytes_first_page_gif_url", "uint32_is_first_page_use_gif", "uint32_is_no_show_cover", "bytes_kb_id", "uint32_trigger_sec", "bytes_video_logo_url", "msg_kd_tag_info", "msg_like_download_bar_info", "video_column_info", "msg_soft_ad_download_bar_info", "msg_ug_top_download_bar_info", "msg_account_v_info", "msg_ug_middle_download_bar_info", "msg_ug_bottom_download_bar_info", "msg_fusion_biu_info", "uint32_forbid_reprint_flag", "bytes_wechat_share_url", "bytes_aio_share_url", "bytes_qzone_share_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, null, null, localByteStringMicro13, Integer.valueOf(0), null, localByteStringMicro14, Integer.valueOf(0), localByteStringMicro15, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro16, localByteStringMicro17, null, Integer.valueOf(0), null, null, localByteStringMicro18, Integer.valueOf(0), null, localByteStringMicro19, null, localByteStringMicro20, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro21, Integer.valueOf(0), localByteStringMicro22, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), localByteStringMicro23, localByteStringMicro24, localByteStringMicro25 }, ArticleSummary.class);
    }
  }
  
  public static final class BackOffGroupInfo
    extends MessageMicro<BackOffGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_back_off_group = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_max_evoke_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_max_fresh_evoke_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_residence_threshold = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_back_off_group", "uint32_max_evoke_count", "uint32_max_fresh_evoke_count", "uint32_residence_threshold" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, BackOffGroupInfo.class);
    }
  }
  
  public static final class BiuMultiLevel
    extends MessageMicro<BiuMultiLevel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2) }, BiuMultiLevel.class);
    public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
    public final PBRepeatMessageField<oidb_0x6cf.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_0x6cf.BiuOneLevelItem.class);
    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  }
  
  public static final class BiuOneLevelItem
    extends MessageMicro<BiuOneLevelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type", "op_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, BiuOneLevelItem.class);
    }
  }
  
  public static final class ChannelInfo
    extends MessageMicro<ChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_channel_display_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58 }, new String[] { "uint32_channel_id", "uint32_channel_type", "bytes_channel_name", "bytes_channel_display_name", "bytes_channel_url", "uint32_is_topic", "bytes_common_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, ChannelInfo.class);
    }
  }
  
  public static final class DisLikeInfo
    extends MessageMicro<DisLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_dislike_account_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_dislike_describe = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt64Field uint64_dislike_tagid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "type", "bytes_dislike_describe", "uint64_dislike_tagid", "bytes_dislike_account_id" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, DisLikeInfo.class);
    }
  }
  
  public static final class DownloadBarInfo
    extends MessageMicro<DownloadBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_open_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBUInt32Field uint32_appear_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_button_bg_color = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "uint32_appear_time", "bytes_logo_url", "bytes_download_button_text", "bytes_open_button_text", "uint32_button_bg_color", "msg_url_jump_info", "bytes_common_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, localByteStringMicro4 }, DownloadBarInfo.class);
    }
  }
  
  public static final class ECommerceEntranceInfo
    extends MessageMicro<ECommerceEntranceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x6cf.AppAdInfo appInfo = new oidb_0x6cf.AppAdInfo();
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_link_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_display_count_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ecommerce_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_one_day_max_display_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_max_display_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    public final PBUInt32Field video_play_length = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 72, 80, 88, 96, 106, 112 }, new String[] { "uint32_ecommerce_id", "bytes_title", "bytes_subtitle", "bytes_thumbnail_url", "bytes_link_icon_url", "uint32_jump_type", "bytes_jump_url", "bytes_common_data", "uint32_session_max_display_count", "uint32_one_day_max_display_count", "uint32_display_count_ver", "uint32_style", "appInfo", "video_play_length" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, ECommerceEntranceInfo.class);
    }
  }
  
  public static final class EntranceDownloadInfo
    extends MessageMicro<EntranceDownloadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_entrance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_small_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_use_gif = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 74, 82 }, new String[] { "bytes_icon_url", "bytes_small_icon_url", "uint32_is_use_gif", "msg_url_jump_info", "bytes_common_data", "uint32_column_id", "bytes_column_name", "bytes_sub_text", "bytes_entrance_cookie", "bytes_rowkey" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, EntranceDownloadInfo.class);
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
  
  public static final class FeedsIdInfo
    extends MessageMicro<FeedsIdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_feeds_type", "uint64_feeds_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, FeedsIdInfo.class);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "feeds_type", "msg_pos_ad_info", "rpt_msg_neg_feedback" }, new Object[] { Integer.valueOf(0), null, null }, FeedsInfo.class);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public oidb_0x6cf.PosAdInfo msg_pos_ad_info = new oidb_0x6cf.PosAdInfo();
    public final PBRepeatMessageField<oidb_0x6cf.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x6cf.NegFeedback.class);
  }
  
  public static final class FusionBiuInfo
    extends MessageMicro<FusionBiuInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "bool_is_gray", "uint32_biu_count", "bool_is_biu", "uint64_feeds_id" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Long.valueOf(0L) }, FusionBiuInfo.class);
    public final PBBoolField bool_is_biu = PBField.initBool(false);
    public final PBBoolField bool_is_gray = PBField.initBool(false);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
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
  
  public static final class InterruptedWeishiAd
    extends MessageMicro<InterruptedWeishiAd>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x6cf.AppAdInfo appInfo = new oidb_0x6cf.AppAdInfo();
    public final PBBytesField bytes_ad_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_show_positon = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.ECommerceEntranceInfo msg_ecommerce_entrance_info = new oidb_0x6cf.ECommerceEntranceInfo();
    public final PBUInt32Field uint32_interrupted_ad_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_show_in_play_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_show_in_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_after_play_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 64, 74 }, new String[] { "bytes_show_positon", "uint32_is_show_in_switch", "uint32_is_show_in_play_end", "uint32_show_after_play_time", "bytes_ad_url", "bytes_common_data", "msg_ecommerce_entrance_info", "uint32_interrupted_ad_type", "appInfo" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), null }, InterruptedWeishiAd.class);
    }
  }
  
  public static final class LikeDownloadBarInfo
    extends MessageMicro<LikeDownloadBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bar_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_icon_url", "bytes_bar_text", "msg_url_jump_info", "bytes_common_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3 }, LikeDownloadBarInfo.class);
    }
  }
  
  public static final class NegFeedback
    extends MessageMicro<NegFeedback>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_type_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_type_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_type_id", "bytes_type_desc" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, NegFeedback.class);
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
  
  public static final class PosAdInfo
    extends MessageMicro<PosAdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_pos_layout = PBField.initEnum(0);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBUInt64Field is_auto_play = PBField.initUInt64(0L);
    public oidb_0x6cf.AdInfo msg_ad_info = new oidb_0x6cf.AdInfo();
    public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "msg_ad_info", "is_auto_play" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L) }, PosAdInfo.class);
    }
  }
  
  public static final class ReqAdvertisePara
    extends MessageMicro<ReqAdvertisePara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x885.AdReqInfo msg_ad_req_info = new oidb_0x885.AdReqInfo();
    public oidb_0x6cf.PhoneInfo msg_phone_info = new oidb_0x6cf.PhoneInfo();
    public oidb_0x6cf.VideoFloatInfo msg_video_float_info = new oidb_0x6cf.VideoFloatInfo();
    public final PBUInt64Field uint64_last_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "msg_phone_info", "uint64_last_time", "msg_video_float_info", "msg_ad_req_info", "bytes_ad_user_info" }, new Object[] { null, Long.valueOf(0L), null, null, localByteStringMicro }, ReqAdvertisePara.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_end_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_entrance_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_context_pb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_range_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_web = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_article_source = PBField.initEnum(0);
    public final PBEnumField enum_req_video_show_mode = PBField.initEnum(0);
    public oidb_0x6cf.ReqAdvertisePara req_advertise_para = new oidb_0x6cf.ReqAdvertisePara();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_redo_inner_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<oidb_0x6cf.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_0x6cf.InnerMsg.class);
    public final PBRepeatMessageField<oidb_0x6cf.PkgInstallInfo> rpt_pkg_install_info = PBField.initRepeatMessage(oidb_0x6cf.PkgInstallInfo.class);
    public final PBRepeatField<Long> rpt_uint64_redo_article_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0x6cf.FeedsIdInfo ugc_feeds_info = new oidb_0x6cf.FeedsIdInfo();
    public final PBUInt32Field uint32_entrance_one_day_display_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_cache_pre_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_dislike_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_network = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_os = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_recommend_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_sim_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_sub_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_topic_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_vertical_video = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_youngster_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public oidb_0x6cf.UserExposeArticle user_expose_article = new oidb_0x6cf.UserExposeArticle();
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 64, 74, 80, 112, 120, 128, 138, 144, 154, 162, 170, 176, 184, 192, 202, 208, 216, 224, 234, 242, 248, 256, 264, 272, 282, 306, 322, 328, 336, 346 }, new String[] { "uint64_uin", "uint64_article_id", "bytes_inner_id", "enum_article_source", "uint32_want_count", "uint32_want_type", "req_advertise_para", "rpt_uint64_redo_article_id", "rpt_bytes_redo_inner_id", "uint32_req_source", "uint32_req_dislike_type", "uint32_req_topic_id", "uint32_req_vertical_video", "ugc_feeds_info", "uint32_is_ugc", "bytes_req_web", "bytes_cookie", "rpt_inner_msg_list", "uint32_req_network", "uint32_req_os", "uint32_req_times", "bytes_req_range_cookie", "uint32_req_sub_source", "uint32_req_sim_type", "uint64_end_recommend_seq", "bytes_end_rowkey", "bytes_req_context_pb", "uint32_has_cache_pre_video", "uint32_entrance_one_day_display_count", "uint32_req_column_id", "enum_req_video_show_mode", "rpt_pkg_install_info", "user_expose_article", "bytes_req_ug_interface_data", "uint32_youngster_status", "uint32_req_recommend_flag", "bytes_entrance_cookie" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9 }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ads_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x885.RspBody msg_ad_rsp = new oidb_0x885.RspBody();
    public oidb_0x6cf.InterruptedWeishiAd msg_ecommerce_entrance_config = new oidb_0x6cf.InterruptedWeishiAd();
    public oidb_0x6cf.EntranceDownloadInfo msg_entrance_download_info = new oidb_0x6cf.EntranceDownloadInfo();
    public oidb_0x6cf.InterruptedWeishiAd msg_interrupted_ad_weishi = new oidb_0x6cf.InterruptedWeishiAd();
    public oidb_0x6cf.ArticleSummary req_article_summary = new oidb_0x6cf.ArticleSummary();
    public final PBRepeatMessageField<oidb_0x6cf.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(oidb_0x6cf.ArticleSummary.class);
    public final PBRepeatMessageField<oidb_0x6cf.BackOffGroupInfo> rpt_back_off_group_info = PBField.initRepeatMessage(oidb_0x6cf.BackOffGroupInfo.class);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pos_ad_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 74, 80, 90, 98, 106, 122 }, new String[] { "uint64_uin", "rpt_article_list", "bytes_inner_id", "req_article_summary", "uint64_pos_ad_time", "bytes_cookie", "msg_interrupted_ad_weishi", "msg_ecommerce_entrance_config", "bytes_ads_context", "uint32_is_end", "msg_ad_rsp", "msg_entrance_download_info", "rpt_back_off_group_info", "bytes_rsp_ug_interface_data" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2, null, null, localByteStringMicro3, Integer.valueOf(0), null, null, null, localByteStringMicro4 }, RspBody.class);
    }
  }
  
  public static final class SoftAdDownloadBarInfo
    extends MessageMicro<SoftAdDownloadBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_big_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_small_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBUInt32Field uint32_change_bigger_position = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56 }, new String[] { "bytes_title", "bytes_sub_title", "bytes_small_icon_url", "bytes_big_icon_url", "uint32_change_bigger_position", "msg_url_jump_info", "uint32_style" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null, Integer.valueOf(0) }, SoftAdDownloadBarInfo.class);
    }
  }
  
  public static final class TopBarInfo
    extends MessageMicro<TopBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ios_jump_bundle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topbar_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80 }, new String[] { "uint32_topbar_id", "bytes_icon_url", "bytes_title", "uint32_jump_type", "bytes_jump_url", "bytes_ios_jump_bundle", "bytes_common_data", "bytes_jump_schema", "bytes_background_url", "uint32_style" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0) }, TopBarInfo.class);
    }
  }
  
  public static final class TopicRecommendInfo
    extends MessageMicro<TopicRecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_follow = PBField.initUInt32(0);
    public final PBUInt32Field uint32_number_of_participants = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "uint32_number_of_participants", "bytes_pic_url", "uint32_is_follow" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, TopicRecommendInfo.class);
    }
  }
  
  public static final class UGCFeedsInfo
    extends MessageMicro<UGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "ugc_feeds_info", "uint64_cuin", "msg_ugc_video_info_list", "uint32_follow_status" }, new Object[] { null, Long.valueOf(0L), null, Integer.valueOf(0) }, UGCFeedsInfo.class);
    public oidb_0x6cf.UGCVideoInfo msg_ugc_video_info_list = new oidb_0x6cf.UGCVideoInfo();
    public oidb_0x6cf.FeedsIdInfo ugc_feeds_info = new oidb_0x6cf.FeedsIdInfo();
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
  }
  
  public static final class UGCPicInfo
    extends MessageMicro<UGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_animation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "uint32_pic_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, UGCPicInfo.class);
    }
  }
  
  public static final class UGCVideoInfo
    extends MessageMicro<UGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_duration = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88, 98, 104, 114, 120, 130 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_title", "bytes_uuid", "uint64_duration", "uint32_video_width", "uint32_video_height", "uint32_pic_width", "uint32_pic_height", "bytes_uniq_id", "uint32_create_time", "bytes_share_url", "uint32_busi_type", "bytes_vid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9 }, UGCVideoInfo.class);
    }
  }
  
  public static final class UGDownloadBarInfo
    extends MessageMicro<UGDownloadBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public oidb_0x6cf.WeishiUGInfo weishiUGInfo = new oidb_0x6cf.WeishiUGInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_title", "bytes_icon_url", "msg_url_jump_info", "weishiUGInfo" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, null }, UGDownloadBarInfo.class);
    }
  }
  
  public static final class UrlJumpInfo
    extends MessageMicro<UrlJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_clipboard_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_bundle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uint32_jump_type", "bytes_jump_url", "bytes_jump_bundle", "bytes_jump_schema", "bytes_clipboard_info", "bytes_common_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, UrlJumpInfo.class);
    }
  }
  
  public static final class UserExposeArticle
    extends MessageMicro<UserExposeArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_article" }, new Object[] { null }, UserExposeArticle.class);
    public final PBRepeatMessageField<oidb_0x6cf.ExposeArticleInfo> rpt_article = PBField.initRepeatMessage(oidb_0x6cf.ExposeArticleInfo.class);
  }
  
  public static final class VideoColumnInfo
    extends MessageMicro<VideoColumnInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public oidb_0x6cf.UrlJumpInfo app_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBBytesField bytes_app_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_from_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo default_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public oidb_0x6cf.UrlJumpInfo subscribe_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 48, 56, 90, 98, 106, 122, 130, 136, 146 }, new String[] { "uint32_column_id", "bytes_column_name", "bytes_column_icon_url", "uint32_subscribe_count", "uint32_is_subscribed", "bytes_app_name", "bytes_app_icon_url", "default_jump_info", "subscribe_jump_info", "app_jump_info", "uint32_style", "bytes_from_txt" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, null, null, null, Integer.valueOf(0), localByteStringMicro5 }, VideoColumnInfo.class);
    }
  }
  
  public static final class VideoFloatInfo
    extends MessageMicro<VideoFloatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_ad_support", "uint32_info_num", "rpt_msg_ad_video_pos" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, VideoFloatInfo.class);
    public final PBRepeatMessageField<oidb_0x6cf.AdVideoPos> rpt_msg_ad_video_pos = PBField.initRepeatMessage(oidb_0x6cf.AdVideoPos.class);
    public final PBUInt32Field uint32_ad_support = PBField.initUInt32(0);
    public final PBUInt32Field uint32_info_num = PBField.initUInt32(0);
  }
  
  public static final class WeishiUGInfo
    extends MessageMicro<WeishiUGInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_back_off_group = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_click_h5_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_click_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_click_schema_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_exposure_report_tail = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_base_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ug_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6cf.UrlJumpInfo msg_url_jump_info = new oidb_0x6cf.UrlJumpInfo();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_report_base_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_auto_play = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_ug = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 90 }, new String[] { "bytes_report_base_url", "bytes_exposure_report_tail", "bytes_click_report_tail", "bytes_click_schema_report_tail", "bytes_click_h5_report_tail", "rpt_bytes_report_base_url", "msg_url_jump_info", "uint32_auto_play", "bytes_back_off_group", "uint32_use_ug", "bytes_ug_interface_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), localByteStringMicro8 }, WeishiUGInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf
 * JD-Core Version:    0.7.0.1
 */