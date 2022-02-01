package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
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
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.MedalInfo;

public final class articlesummary
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
    public articlesummary.LocalInfo local_info = new articlesummary.LocalInfo();
    public final PBRepeatMessageField<AdInfo> rpt_msg_inner_ad_info = PBField.initRepeatMessage(AdInfo.class);
    public final PBRepeatMessageField<articlesummary.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(articlesummary.NegFeedback.class);
    public final PBStringField string_canvas_json = PBField.initString("");
    public final PBStringField string_download_api_url = PBField.initString("");
    public final PBStringField string_effect_url = PBField.initString("");
    public final PBStringField string_interact_image_list = PBField.initString("");
    public final PBStringField string_interaction_report_url = PBField.initString("");
    public final PBUInt32Field uint32_ad_material_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_material_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_material_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ad_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_algo_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_app_score_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cost_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dest_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dis_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interact_effect_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_interact_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_stra_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ad_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_advertiser_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_aid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_video_file_size = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 130, 138, 146, 154, 162, 170, 178, 184, 194, 202, 208, 218, 226, 234, 240, 248, 256, 264, 272, 282, 288, 298, 304, 312, 320, 328, 338, 346, 354, 362, 370, 376, 384, 394, 400, 432, 442, 448, 466, 472, 490, 496, 506, 512, 522, 528 }, new String[] { "uint64_channel_id", "int32_kd_pos", "bytes_cl", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "bytes_rl", "bytes_apurl", "bytes_trace_id", "bytes_product_id", "int32_product_type", "uint32_ad_type", "rpt_msg_inner_ad_info", "bytes_landing_page", "bytes_price", "bytes_button_txt", "bytes_view_id", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "bytes_title_list", "bytes_image_list", "bytes_url_list", "uint64_aid", "enum_ad_layout", "uint32_ad_material_id", "uint32_ad_material_width", "uint32_ad_material_height", "bytes_via", "uint32_dis_channel", "bytes_button_url", "uint32_duration", "enum_ad_jump_mode", "uint32_algo_id", "uint32_stra_id", "rpt_msg_neg_feedback", "bytes_extra_data", "bytes_app_download_schema", "string_canvas_json", "bytes_landing_page_report_url", "uint64_advertiser_id", "uint32_dest_type", "string_effect_url", "int64_noco_id", "uint64_feeds_id", "string_interaction_report_url", "uint32_app_score_num", "bytes_rowkey", "uint64_article_id", "string_download_api_url", "uint64_video_file_size", "local_info", "uint32_interact_effect_type", "string_interact_image_list", "uint32_interact_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Long.valueOf(0L), localByteStringMicro18, localByteStringMicro19, Integer.valueOf(0), localByteStringMicro20, localByteStringMicro21, localByteStringMicro22, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro25, localByteStringMicro26, "", localByteStringMicro27, Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro28, Long.valueOf(0L), "", Long.valueOf(0L), null, Integer.valueOf(0), "", Integer.valueOf(0) }, AdInfo.class);
    }
  }
  
  public static final class AggregatedList
    extends MessageMicro<AggregatedList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_article_summary", "uint32_aggregated_content_type", "rpt_multi_biu_same_content" }, new Object[] { null, Integer.valueOf(1), null }, AggregatedList.class);
    public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_summary = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
    public final PBRepeatMessageField<articlesummary.MultiBiuSameContent> rpt_multi_biu_same_content = PBField.initRepeatMessage(articlesummary.MultiBiuSameContent.class);
    public final PBUInt32Field uint32_aggregated_content_type = PBField.initUInt32(1);
  }
  
  public static final class AnswerDetail
    extends MessageMicro<AnswerDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "question_rowkey", "question_title", "answer_content", "agreed_num", "card_style" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, AnswerDetail.class);
    public final PBUInt32Field agreed_num = PBField.initUInt32(0);
    public final PBStringField answer_content = PBField.initString("");
    public final PBUInt32Field card_style = PBField.initUInt32(0);
    public final PBStringField question_rowkey = PBField.initString("");
    public final PBStringField question_title = PBField.initString("");
  }
  
  public static final class ArkAppFeedsInfo
    extends MessageMicro<ArkAppFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_meta = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_view = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "bytes_app_name", "bytes_app_view", "bytes_app_desc", "bytes_app_prompt", "bytes_app_ver", "bytes_app_meta" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, ArkAppFeedsInfo.class);
    }
  }
  
  public static final class ArticleBasicInfo
    extends MessageMicro<ArticleBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rowkey", "title", "msg_pgc_pic_info_list", "jump_url" }, new Object[] { "", "", null, "" }, ArticleBasicInfo.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBRepeatMessageField<articlesummary.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(articlesummary.PGCPicInfo.class);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class ArticleSummary
    extends MessageMicro<ArticleSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public articlesummary.AwesomeCommentInfo awesome_comment_icon = new articlesummary.AwesomeCommentInfo();
    public articlesummary.BusinessBarInfo business_bar = new articlesummary.BusinessBarInfo();
    public final PBBytesField bytes_ad_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_aio_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_circle_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_colour = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_button_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_friend_like_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gallery_busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gallery_report_extdata = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_media_specs = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qzone_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_server_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_small_game_rsp_pack = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wechat_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.VideoColumnInfo> card_column_entrances = PBField.initRepeatMessage(articlesummary.VideoColumnInfo.class);
    public articlesummary.DiandianLabel diandian_label = new articlesummary.DiandianLabel();
    public articlesummary.DiandianWording diandian_wording = new articlesummary.DiandianWording();
    public final PBEnumField enum_article_style = PBField.initEnum(0);
    public final PBFloatField float_aspect_ratio = PBField.initFloat(0.0F);
    public articlesummary.HotWordInfo hot_word_info = new articlesummary.HotWordInfo();
    public final PBUInt32Field is_accountless = PBField.initUInt32(0);
    public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.AccountVInfo msg_account_v_info = new articlesummary.AccountVInfo();
    public articlesummary.ChannelInfo msg_channel_info = new articlesummary.ChannelInfo();
    public articlesummary.FamilyCommentInfo msg_family_comment_info = new articlesummary.FamilyCommentInfo();
    public articlesummary.FeedsInfo msg_feeds_info = new articlesummary.FeedsInfo();
    public articlesummary.FusionBiuInfo msg_fusion_biu_info = new articlesummary.FusionBiuInfo();
    public articlesummary.KdLiveInfo msg_kd_live_info = new articlesummary.KdLiveInfo();
    public articlesummary.NewPackInfo msg_new_pack_info = new articlesummary.NewPackInfo();
    public articlesummary.PackInfo msg_pack_info = new articlesummary.PackInfo();
    public articlesummary.PartnerAccountInfo msg_partner_account_info = new articlesummary.PartnerAccountInfo();
    public articlesummary.ScripCmsInfo msg_scrip_cms_info = new articlesummary.ScripCmsInfo();
    public final PBRepeatMessageField<articlesummary.SRTUniversalID> msg_srt_universal_id = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
    public final PBRepeatMessageField<ArticleSummary> msg_sub_article_summary = PBField.initRepeatMessage(ArticleSummary.class);
    public articlesummary.SubscribeInfo msg_subscribe_info = new articlesummary.SubscribeInfo();
    public articlesummary.WeishiUGInfo msg_ug_info = new articlesummary.WeishiUGInfo();
    public articlesummary.RecommendFollowInfos recommend_info = new articlesummary.RecommendFollowInfos();
    public final PBRepeatMessageField<articlesummary.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(articlesummary.ArticleTagInfo.class);
    public final PBRepeatMessageField<articlesummary.CommentInfo> rpt_comments = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
    public final PBRepeatMessageField<articlesummary.DisLikeInfo> rpt_dislike_list = PBField.initRepeatMessage(articlesummary.DisLikeInfo.class);
    public final PBRepeatMessageField<articlesummary.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(articlesummary.ChannelInfo.class);
    public final PBUInt32Field uint32_abandon_repeat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_icon_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expose_repeat_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_forbid_reprint_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_active = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_close_dislike = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_disp_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_show_search_word = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_super_top_article = PBField.initUInt32(0);
    public final PBUInt32Field uint32_picture_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_red_package_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_show_small_picture = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_merged_video_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public articlesummary.VideoColumnInfo video_column_info = new articlesummary.VideoColumnInfo();
    public articlesummary.VideoDownloadBarInfo video_download_bar_info = new articlesummary.VideoDownloadBarInfo();
    public articlesummary.VideoColumnInfo video_multi_column_info = new articlesummary.VideoColumnInfo();
    public articlesummary.VideoColumnInfo video_simple_column_info = new articlesummary.VideoColumnInfo();
    
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
      ByteStringMicro localByteStringMicro30 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro31 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro32 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro33 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro34 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro35 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro36 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro37 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 144, 154, 162, 168, 176, 184, 194, 202, 210, 216, 226, 234, 240, 250, 258, 264, 272, 280, 290, 298, 306, 312, 322, 330, 338, 349, 352, 362, 368, 378, 386, 394, 400, 408, 418, 424, 434, 442, 448, 458, 466, 474, 482, 488, 498, 506, 514, 522, 530, 538, 546, 554, 562, 568, 576, 584, 594, 602, 610, 618, 626, 634, 640, 650, 658, 666, 674, 682, 690, 706, 714, 722, 730, 738, 744, 752, 760, 770, 778, 786, 794 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_abandon_repeat_flag", "bytes_test", "bytes_colour", "uint32_strategy_id", "uint64_source_article_id", "uint64_merged_video_id", "rpt_article_tag_list", "bytes_friend_like_wording", "bytes_media_specs", "uint32_video_show_small_picture", "msg_channel_info", "bytes_inner_uniq_id", "uint32_comment_icon_type", "bytes_server_context", "rpt_dislike_list", "uint32_is_disp_timestamp", "uint32_is_gallery", "uint32_picture_number", "msg_pack_info", "rpt_comments", "bytes_circle_id", "uint32_is_active", "bytes_push_context", "msg_subscribe_info", "msg_feeds_info", "float_aspect_ratio", "uint32_video_play_count", "rpt_label_list", "is_accountless", "msg_sub_article_summary", "bytes_interface_data", "bytes_gallery_report_extdata", "enum_article_style", "uint32_video_comment_count", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_video_subscript_txt", "bytes_video_subscript_color", "uint32_ads_source", "bytes_video_report_info", "diandian_wording", "msg_new_pack_info", "bytes_first_page_gif_url", "uint32_is_first_page_use_gif", "recommend_info", "hot_word_info", "diandian_label", "bytes_gallery_busi_data", "business_bar", "video_download_bar_info", "awesome_comment_icon", "bytes_gw_common_data", "bytes_kb_id", "uint32_article_type", "uint32_is_close_dislike", "uint32_is_super_top_article", "bytes_jump_card_id", "bytes_report_common_data", "bytes_video_logo_url", "msg_partner_account_info", "video_column_info", "bytes_comment_button_jump_url", "uint32_is_show_search_word", "bytes_ad_report_common_data", "msg_srt_universal_id", "video_multi_column_info", "msg_account_v_info", "msg_scrip_cms_info", "video_simple_column_info", "msg_fusion_biu_info", "msg_kd_live_info", "msg_ug_info", "msg_family_comment_info", "card_column_entrances", "uint32_expose_repeat_flag", "uint32_red_package_flag", "uint32_forbid_reprint_flag", "bytes_wechat_share_url", "bytes_aio_share_url", "bytes_qzone_share_url", "bytes_small_game_rsp_pack" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), null, localByteStringMicro15, Integer.valueOf(0), localByteStringMicro16, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro17, Integer.valueOf(0), localByteStringMicro18, null, null, Float.valueOf(0.0F), Integer.valueOf(0), null, Integer.valueOf(0), null, localByteStringMicro19, localByteStringMicro20, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro21, Integer.valueOf(0), localByteStringMicro22, localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, null, null, localByteStringMicro25, Integer.valueOf(0), null, null, null, localByteStringMicro26, null, null, null, localByteStringMicro27, localByteStringMicro28, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro29, localByteStringMicro30, localByteStringMicro31, null, null, localByteStringMicro32, Integer.valueOf(0), localByteStringMicro33, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro34, localByteStringMicro35, localByteStringMicro36, localByteStringMicro37 }, ArticleSummary.class);
    }
  }
  
  public static final class ArticleTagInfo
    extends MessageMicro<ArticleTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_tag_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_tag_id", "bytes_tag_name", "uint32_tag_level" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ArticleTagInfo.class);
    }
  }
  
  public static final class AwesomeCommentInfo
    extends MessageMicro<AwesomeCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField avatar = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field icon_height = PBField.initUInt32(0);
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field icon_with = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 66, 74, 82 }, new String[] { "rowkey", "icon_url", "icon_with", "icon_height", "jump_url", "uin", "nick_name", "avatar", "comment_id", "content" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, AwesomeCommentInfo.class);
    }
  }
  
  public static final class BiuMultiLevel
    extends MessageMicro<BiuMultiLevel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type", "enum_origin_verify_status" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2) }, BiuMultiLevel.class);
    public final PBEnumField enum_origin_verify_status = PBField.initEnum(2);
    public final PBRepeatMessageField<articlesummary.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(articlesummary.BiuOneLevelItem.class);
    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  }
  
  public static final class BiuOneLevelItem
    extends MessageMicro<BiuOneLevelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field feeds_type = PBField.initUInt32(0);
    public articlesummary.JumpInfo msg_jump_info = new articlesummary.JumpInfo();
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type", "op_type", "msg_jump_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, BiuOneLevelItem.class);
    }
  }
  
  public static final class BuluoInfo
    extends MessageMicro<BuluoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_buluo_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "bytes_wording", "bytes_jump_url", "uint64_buluo_id", "bytes_name", "bytes_head_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, BuluoInfo.class);
    }
  }
  
  public static final class BusinessBarInfo
    extends MessageMicro<BusinessBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ios_jump_bundle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bar_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58, 66, 74, 80, 88 }, new String[] { "uint32_bar_id", "bytes_icon_url", "bytes_title", "uint32_jump_type", "bytes_jump_url", "bytes_ios_jump_bundle", "bytes_common_data", "bytes_jump_schema", "bytes_background_url", "uint64_channel_id", "uint64_topic_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L) }, BusinessBarInfo.class);
    }
  }
  
  public static final class CardJumpInfo
    extends MessageMicro<CardJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_card_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_btn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_available = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_available", "bytes_card_jump_url", "bytes_comment_btn_url", "bytes_share_url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, CardJumpInfo.class);
    }
  }
  
  public static final class ChannelInfo
    extends MessageMicro<ChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_channel_display_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "uint32_channel_id", "uint32_channel_type", "bytes_channel_name", "bytes_channel_display_name", "bytes_channel_url", "uint32_is_topic" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, ChannelInfo.class);
    }
  }
  
  public static final class ColumnTopicInfo
    extends MessageMicro<ColumnTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_id", "str_title", "str_jump_url" }, new Object[] { Long.valueOf(0L), "", "" }, ColumnTopicInfo.class);
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  }
  
  public static final class CommentInfo
    extends MessageMicro<CommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "str_content", "str_jump_url" }, new Object[] { Long.valueOf(0L), "", "" }, CommentInfo.class);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_jump_url = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class DiandianLabel
    extends MessageMicro<DiandianLabel>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 42 }, new String[] { "bytes_icon_url", "bytes_icon_wording" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, DiandianLabel.class);
    }
  }
  
  public static final class DiandianWording
    extends MessageMicro<DiandianWording>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin_or_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_uin_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "bytes_uin_or_nick", "bytes_msg_wording", "uint32_uin_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, DiandianWording.class);
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
  
  public static final class FamilyCommentInfo
    extends MessageMicro<FamilyCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field medal_urls_height = PBField.initUInt32(0);
    public final PBUInt32Field medal_urls_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "icon_url", "jump_url", "medal_urls_width", "medal_urls_height" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, FamilyCommentInfo.class);
    }
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_src = PBField.initEnum(0);
    public final PBUInt32Field feeds_type = PBField.initUInt32(0);
    public articlesummary.AggregatedList msg_aggregated_list = new articlesummary.AggregatedList();
    public articlesummary.ArkAppFeedsInfo msg_ark_app_feeds_info = new articlesummary.ArkAppFeedsInfo();
    public articlesummary.FollowRecommendFeedsInfo msg_follow_recommend_feeds_info = new articlesummary.FollowRecommendFeedsInfo();
    public articlesummary.PosAdInfo msg_pos_ad_info = new articlesummary.PosAdInfo();
    public articlesummary.SocializeFeedsInfo msg_social_feeds_info = new articlesummary.SocializeFeedsInfo();
    public articlesummary.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new articlesummary.TopicRecommendFeedsInfo();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_hot_biulist = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_index = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 98, 106, 114, 122, 160, 170, 1600, 1608, 1618, 1680 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "msg_pos_ad_info", "msg_follow_recommend_feeds_info", "msg_topic_recommend_feeds_info", "msg_ark_app_feeds_info", "enum_ugc_src", "msg_aggregated_list", "uint64_feeds_index", "uint64_feeds_time", "bytes_feeds_cookie", "uint32_hot_biulist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro4, Integer.valueOf(0) }, FeedsInfo.class);
    }
  }
  
  public static final class FollowRecommendFeedsInfo
    extends MessageMicro<FollowRecommendFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 88, 96, 104, 112, 120, 128 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "uint32_biu_count", "uint32_myself_follow_status", "uint32_follow_counts" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FollowRecommendFeedsInfo.class);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class FriendRecommendInfo
    extends MessageMicro<FriendRecommendInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "rpt_recommenders", "str_header_title", "rpt_jumps", "rpt_social_leader_info" }, new Object[] { Long.valueOf(0L), "", null, null }, FriendRecommendInfo.class);
    public final PBRepeatMessageField<articlesummary.PackJumpInfo> rpt_jumps = PBField.initRepeatMessage(articlesummary.PackJumpInfo.class);
    public final PBRepeatField<Long> rpt_recommenders = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatMessageField<articlesummary.SocialLeaderInfoData> rpt_social_leader_info = PBField.initRepeatMessage(articlesummary.SocialLeaderInfoData.class);
    public final PBStringField str_header_title = PBField.initString("");
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
  
  public static final class FusionInfo
    extends MessageMicro<FusionInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_comment_id", "str_comment_key", "uint32_comment_src" }, new Object[] { "", "", Integer.valueOf(0) }, FusionInfo.class);
    public final PBStringField str_comment_id = PBField.initString("");
    public final PBStringField str_comment_key = PBField.initString("");
    public final PBUInt32Field uint32_comment_src = PBField.initUInt32(0);
  }
  
  public static final class GalleryPGCFeedsInfo
    extends MessageMicro<GalleryPGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_gallery_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_exdata = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(articlesummary.PGCPicInfo.class);
    public final PBUInt64Field uint64_pic_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sub_source = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 402 }, new String[] { "uint64_pic_count", "msg_pgc_pic_info_list", "uint64_source", "uint64_sub_source", "bytes_report_exdata", "bytes_gallery_url" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, GalleryPGCFeedsInfo.class);
    }
  }
  
  public static final class GameLiveInfo
    extends MessageMicro<GameLiveInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_game_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_play_bill_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_play_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tips_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_audience_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "bytes_play_bill_id", "uint32_status", "uint32_audience_count", "bytes_play_url", "bytes_game_name", "bytes_tips_wording", "bytes_status", "bytes_status_icon_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, GameLiveInfo.class);
    }
  }
  
  public static final class GroupRecommendAccount
    extends MessageMicro<GroupRecommendAccount>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_class = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.RecommendAccountInfo> rpt_recommend_account_info = PBField.initRepeatMessage(articlesummary.RecommendAccountInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_class", "rpt_recommend_account_info" }, new Object[] { localByteStringMicro, null }, GroupRecommendAccount.class);
    }
  }
  
  public static final class HotWordInfo
    extends MessageMicro<HotWordInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_hot_word_item" }, new Object[] { null }, HotWordInfo.class);
    public final PBRepeatMessageField<articlesummary.HotWordItem> rpt_hot_word_item = PBField.initRepeatMessage(articlesummary.HotWordItem.class);
  }
  
  public static final class HotWordItem
    extends MessageMicro<HotWordItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField hot_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField index_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField index_word_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "hot_word", "index_word_color", "index_bg_color", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, HotWordItem.class);
    }
  }
  
  public static final class JumpInfo
    extends MessageMicro<JumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_id", "bytes_wording", "bytes_jump_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, JumpInfo.class);
    }
  }
  
  public static final class KdLiveInfo
    extends MessageMicro<KdLiveInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_hot_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hot_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_status_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_style_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_style_type", "bytes_status_bg_url", "bytes_status_icon_url", "bytes_status_text", "bytes_hot_icon_url", "bytes_hot_text", "bytes_title_jump_url", "bytes_report_common_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, KdLiveInfo.class);
    }
  }
  
  public static final class LocalInfo
    extends MessageMicro<LocalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_corporate_image_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_distance_description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_distance_limit = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_store_address = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_store_latitude = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_store_longitude = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_store_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_store_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "bytes_store_name", "bytes_store_url", "bytes_store_address", "bytes_store_longitude", "bytes_store_latitude", "bytes_distance_description", "bytes_corporate_image_name", "bytes_distance_limit" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, LocalInfo.class);
    }
  }
  
  public static final class LongContentInfo
    extends MessageMicro<LongContentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_long_content_card_type", "msg_article_basic_ingo", "msg_pgc_video_info", "msg_outside_link_info" }, new Object[] { Integer.valueOf(1), null, null, null }, LongContentInfo.class);
    public final PBEnumField enum_long_content_card_type = PBField.initEnum(1);
    public articlesummary.ArticleBasicInfo msg_article_basic_ingo = new articlesummary.ArticleBasicInfo();
    public articlesummary.OutsideLinkInfo msg_outside_link_info = new articlesummary.OutsideLinkInfo();
    public articlesummary.PGCVideoInfo msg_pgc_video_info = new articlesummary.PGCVideoInfo();
  }
  
  public static final class MultiBiuSameContent
    extends MessageMicro<MultiBiuSameContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_uin_type = PBField.initEnum(0);
    public final PBRepeatMessageField<articlesummary.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(articlesummary.BiuOneLevelItem.class);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 74 }, new String[] { "uint64_uin", "enum_uin_type", "uint64_feeds_id", "uint32_feeds_type", "uint32_biu_time", "bytes_biu_comments", "uint64_algorithm_id", "uint32_strategy_id", "rpt_biu_mutli_level" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null }, MultiBiuSameContent.class);
    }
  }
  
  public static final class NegFeedback
    extends MessageMicro<NegFeedback>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_type_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_f_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_type_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint64_type_id", "bytes_type_desc", "uint32_id", "uint32_f_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, NegFeedback.class);
    }
  }
  
  public static final class NewPackInfo
    extends MessageMicro<NewPackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_more_href = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_more_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_head_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_top_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_top_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.UrlJumpInfo msg_head_url_jump_info = new articlesummary.UrlJumpInfo();
    public articlesummary.UrlJumpInfo msg_right_more_url_jump_info = new articlesummary.UrlJumpInfo();
    public final PBEnumField pack_type = PBField.initEnum(1);
    public final PBRepeatMessageField<articlesummary.PackArticleInfo> rpt_pack_article_list = PBField.initRepeatMessage(articlesummary.PackArticleInfo.class);
    public final PBUInt32Field uin32_head_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_size_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 98, 104 }, new String[] { "pack_type", "rpt_pack_article_list", "bytes_top_icon_url", "bytes_top_title", "bytes_more_tips", "bytes_more_href", "bytes_sub_head_icon_url", "uint32_follow_status", "uin32_head_type", "uint32_video_size_type", "msg_head_url_jump_info", "msg_right_more_url_jump_info", "uint32_column_id" }, new Object[] { Integer.valueOf(1), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, Integer.valueOf(0) }, NewPackInfo.class);
    }
  }
  
  public static final class OutsideLinkInfo
    extends MessageMicro<OutsideLinkInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "title", "bring_goods_url", "icon_url" }, new Object[] { "", "", "" }, OutsideLinkInfo.class);
    public final PBStringField bring_goods_url = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class PGCFeedsInfo
    extends MessageMicro<PGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_pgc_feeds_card_type = PBField.initEnum(0);
    public final PBEnumField enum_pgc_feeds_type = PBField.initEnum(0);
    public articlesummary.GalleryPGCFeedsInfo msg_gallery_feeds_info = new articlesummary.GalleryPGCFeedsInfo();
    public final PBRepeatMessageField<articlesummary.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(articlesummary.PGCPicInfo.class);
    public final PBRepeatMessageField<articlesummary.PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(articlesummary.PGCVideoInfo.class);
    public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 112, 120, 160, 170 }, new String[] { "enum_pgc_feeds_card_type", "uint64_puin", "uint32_article_type", "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments", "uint32_myself_follow_status", "uint32_follow_counts", "enum_pgc_feeds_type", "msg_gallery_feeds_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, PGCFeedsInfo.class);
    }
  }
  
  public static final class PGCPicInfo
    extends MessageMicro<PGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumbnail_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_animation = PBField.initUInt32(0);
    public articlesummary.PGCVideoInfo msg_video_info = new articlesummary.PGCVideoInfo();
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_gallery_index = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 82, 88 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url", "bytes_thumbnail_url", "is_animation", "msg_video_info", "bytes_pic_desc", "uint64_gallery_index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), null, localByteStringMicro4, Long.valueOf(0L) }, PGCPicInfo.class);
    }
  }
  
  public static final class PGCVideoInfo
    extends MessageMicro<PGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_play_num = PBField.initUInt64(0L);
    public final PBBoolField video_auto_play = PBField.initBool(false);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90, 98 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_vid", "uint32_duration", "uint32_busi_type", "uint64_play_num", "video_auto_play", "rowkey", "title", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), "", "", "" }, PGCVideoInfo.class);
    }
  }
  
  public static final class PackArticleInfo
    extends MessageMicro<PackArticleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_button_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cell_style_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.PackFeedsInfo msg_pack_feeds_info = new articlesummary.PackFeedsInfo();
    public articlesummary.PackQuestionAnswerExtraInfo msg_pack_question_answer_info = new articlesummary.PackQuestionAnswerExtraInfo();
    public articlesummary.PackTopicExtraInfo msg_pack_topic_list_info = new articlesummary.PackTopicExtraInfo();
    public articlesummary.PackVideoInfo msg_pack_video_info = new articlesummary.PackVideoInfo();
    public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_gallery = PBField.initUInt32(0);
    public final PBUInt32Field uint32_picture_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 50, 74, 82, 112, 168, 234, 272, 280, 290, 298, 304, 352, 408, 554, 602, 8010, 8018, 8026, 8034 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_algorithm_id", "uint32_strategy_id", "bytes_inner_uniq_id", "uint32_is_gallery", "uint32_picture_number", "bytes_button_wording", "bytes_cell_style_id", "uint32_is_first_page_use_gif", "uint32_video_play_count", "uint32_video_comment_count", "bytes_gw_common_data", "bytes_report_common_data", "msg_pack_feeds_info", "msg_pack_video_info", "msg_pack_topic_list_info", "msg_pack_question_answer_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, null, null, null, null }, PackArticleInfo.class);
    }
  }
  
  public static final class PackFeedsInfo
    extends MessageMicro<PackFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_feeds_id", "uint32_feeds_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, PackFeedsInfo.class);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  }
  
  public static final class PackInfo
    extends MessageMicro<PackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "uint64_pack_id", "pack_type", "msg_friend_recommend_info", "msg_special_topic_info", "uint32_follow_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1), null, null, Integer.valueOf(0) }, PackInfo.class);
    public articlesummary.FriendRecommendInfo msg_friend_recommend_info = new articlesummary.FriendRecommendInfo();
    public articlesummary.SpecialTopicInfo msg_special_topic_info = new articlesummary.SpecialTopicInfo();
    public final PBEnumField pack_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pack_id = PBField.initUInt64(0L);
  }
  
  public static final class PackJumpInfo
    extends MessageMicro<PackJumpInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_style", "str_wording", "str_url" }, new Object[] { Integer.valueOf(1), "", "" }, PackJumpInfo.class);
    public final PBEnumField enum_style = PBField.initEnum(1);
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_wording = PBField.initString("");
  }
  
  public static final class PackQuestionAnswerExtraInfo
    extends MessageMicro<PackQuestionAnswerExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_question_rowkey", "bytes_question_desc" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, PackQuestionAnswerExtraInfo.class);
    }
  }
  
  public static final class PackTopicExtraInfo
    extends MessageMicro<PackTopicExtraInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_join_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_adtag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uint32_join_count", "bytes_join_wording", "uint32_topic_id", "bytes_topic_name", "uint32_adtag" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, PackTopicExtraInfo.class);
    }
  }
  
  public static final class PackVideoInfo
    extends MessageMicro<PackVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_action = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_third_uin_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_third_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 88, 98, 106, 114, 122 }, new String[] { "uint32_busi_type", "bytes_vid", "uint32_width", "uint32_height", "uint32_duration", "uint64_file_size", "bytes_video_url", "bytes_share_url", "uint64_third_uin", "bytes_third_uin_name", "bytes_third_name", "bytes_third_icon", "bytes_third_action" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7 }, PackVideoInfo.class);
    }
  }
  
  public static final class PartnerAccountInfo
    extends MessageMicro<PartnerAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_head_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_v_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_account_display = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_voila = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 58 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_recommend_reason", "uint32_is_account_display", "bytes_head_jump_url", "uint32_is_voila", "bytes_v_icon_url" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, PartnerAccountInfo.class);
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
    public articlesummary.AdInfo msg_ad_info = new articlesummary.AdInfo();
    public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "msg_ad_info", "is_auto_play" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L) }, PosAdInfo.class);
    }
  }
  
  public static final class RecommendAccountInfo
    extends MessageMicro<RecommendAccountInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_class = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_followed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_star = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_vip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_issue_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 64, 72, 80, 88, 98 }, new String[] { "uint64_uin", "uint32_account_type", "bytes_recommend_reason", "bytes_nick_name", "bytes_head_img_url", "uint32_is_vip", "uint32_is_star", "uint32_is_followed", "uint64_algorithm_id", "uint32_strategy_id", "uint64_issue_time", "bytes_class" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro4 }, RecommendAccountInfo.class);
    }
  }
  
  public static final class RecommendFollowInfos
    extends MessageMicro<RecommendFollowInfos>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_account_next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_card_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.GroupRecommendAccount> rpt_group_recommend_account = PBField.initRepeatMessage(articlesummary.GroupRecommendAccount.class);
    public final PBRepeatMessageField<articlesummary.RecommendAccountInfo> rpt_recommend_account_info = PBField.initRepeatMessage(articlesummary.RecommendAccountInfo.class);
    public final PBUInt32Field uint32_card_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_full_card = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 58 }, new String[] { "uint32_show_full_card", "rpt_recommend_account_info", "bytes_account_next_cookie", "uint32_card_style", "bytes_card_title", "bytes_jump_url", "rpt_group_recommend_account" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, null }, RecommendFollowInfos.class);
    }
  }
  
  public static final class SRTUniversalID
    extends MessageMicro<SRTUniversalID>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ks_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ws_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_kb_id", "bytes_ks_id", "bytes_ws_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SRTUniversalID.class);
    }
  }
  
  public static final class ScripCmsInfo
    extends MessageMicro<ScripCmsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_background_animation_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guide_background_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guide_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guide_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_left_bottom_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_main_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_scrip_tag = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_frequency_limit = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scrip_total_sum = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 58, 66, 74, 82, 88, 96, 106, 112 }, new String[] { "bytes_main_title", "bytes_sub_title", "bytes_background_url", "bytes_icon_url", "bytes_left_bottom_txt", "bytes_background_animation_url", "bytes_guide_main_title", "bytes_guide_sub_title", "bytes_guide_background_url", "uint32_frequency_limit", "uint32_scrip_total_sum", "bytes_scrip_tag", "uint64_from_uin" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, Long.valueOf(0L) }, ScripCmsInfo.class);
    }
  }
  
  public static final class SocialLeaderInfoData
    extends MessageMicro<SocialLeaderInfoData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 25 }, new String[] { "ddwLeaderUin", "dwCircleId", "dCentrality" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Double.valueOf(0.0D) }, SocialLeaderInfoData.class);
    public final PBDoubleField dCentrality = PBField.initDouble(0.0D);
    public final PBUInt64Field ddwLeaderUin = PBField.initUInt64(0L);
    public final PBUInt32Field dwCircleId = PBField.initUInt32(0);
  }
  
  public static final class SocializeFeedsExtInfo
    extends MessageMicro<SocializeFeedsExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_site_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sum_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_publish_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50 }, new String[] { "uint32_publish_time", "uint32_source", "bytes_article_url", "bytes_subject", "bytes_sum_pic_url", "bytes_site_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, SocializeFeedsExtInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfo
    extends MessageMicro<SocializeFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public articlesummary.BuluoInfo buluo_info = new articlesummary.BuluoInfo();
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_recommend_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_recommend_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_private_status_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_account_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.GameLiveInfo game_live_info = new articlesummary.GameLiveInfo();
    public feeds_info.IconWordingInfo icon_wording_info = new feeds_info.IconWordingInfo();
    public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
    public articlesummary.LongContentInfo long_content_info = new articlesummary.LongContentInfo();
    public articlesummary.BiuMultiLevel msg_biu_mutli_level = new articlesummary.BiuMultiLevel();
    public articlesummary.CardJumpInfo msg_card_jump_info = new articlesummary.CardJumpInfo();
    public articlesummary.ColumnTopicInfo msg_column_topic_info = new articlesummary.ColumnTopicInfo();
    public articlesummary.FusionInfo msg_fusion_info = new articlesummary.FusionInfo();
    public articlesummary.SocializeFeedsInfoUser msg_master_uin = new articlesummary.SocializeFeedsInfoUser();
    public articlesummary.PGCFeedsInfo msg_pgc_topic_feeds_info = new articlesummary.PGCFeedsInfo();
    public articlesummary.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new articlesummary.SocializeFeedsExtInfo();
    public articlesummary.TopicEntranceInfo msg_topic_entrance_info = new articlesummary.TopicEntranceInfo();
    public articlesummary.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new articlesummary.TopicRecommendFeedsInfo();
    public articlesummary.UGCFeedsInfo msg_ugc_topic_feeds_info = new articlesummary.UGCFeedsInfo();
    public articlesummary.VerifyResult msg_verify_result = new articlesummary.VerifyResult();
    public final PBRepeatMessageField<articlesummary.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(articlesummary.SocializeFeedsInfoUser.class);
    public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feed_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_jump_recommend_page = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_origin_feeds_deleted = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
    public articlesummary.WendaInfo wenda_info = new articlesummary.WendaInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224, 234, 242, 250, 256, 266, 290, 298, 304, 314, 320, 330, 338, 346, 378, 394, 402, 418, 426, 434 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_counts", "bytes_recommend_account_reason", "buluo_info", "wenda_info", "uint32_is_origin_feeds_deleted", "icon_wording_info", "share_web_page_info", "location_info", "uint32_feed_status", "bytes_private_status_title", "uint32_is_jump_recommend_page", "bytes_jump_recommend_url", "bytes_jump_recommend_prompt", "visible_info", "msg_card_jump_info", "game_live_info", "long_content_info", "msg_column_topic_info", "msg_fusion_info", "msg_topic_entrance_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, null, Integer.valueOf(0), null, null, null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, null, null, null, null, null, null }, SocializeFeedsInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfoUser
    extends MessageMicro<SocializeFeedsInfoUser>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_person_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_uin_type = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_cmd0xb57.MedalInfo> rpt_msg_medal_info = PBField.initRepeatMessage(oidb_cmd0xb57.MedalInfo.class);
    public final PBUInt32Field uint32_is_real_user = PBField.initUInt32(0);
    public final PBUInt32Field uint32_star_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_real_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 64 }, new String[] { "uint64_uin", "enum_uin_type", "uint32_star_style", "bytes_person_desc", "rpt_msg_medal_info", "uint64_real_uin", "uint32_is_real_user" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), Integer.valueOf(0) }, SocializeFeedsInfoUser.class);
    }
  }
  
  public static final class SpecialTopicInfo
    extends MessageMicro<SpecialTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<articlesummary.PackJumpInfo> rpt_jumps = PBField.initRepeatMessage(articlesummary.PackJumpInfo.class);
    public final PBStringField str_header_icon_url = PBField.initString("");
    public final PBStringField str_header_jump_url = PBField.initString("");
    public final PBStringField str_header_title = PBField.initString("");
    public final PBUInt32Field uint32_icon_shape = PBField.initUInt32(0);
    public final PBUInt32Field uint32_posttime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 72, 80, 88 }, new String[] { "str_header_icon_url", "str_header_title", "rpt_jumps", "str_header_jump_url", "uint32_posttime", "bytes_recommend_reason", "uint64_puin", "uint32_icon_shape", "uint64_algorithm_id", "uint32_strategy_id", "uint64_topic_id" }, new Object[] { "", "", null, "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, SpecialTopicInfo.class);
    }
  }
  
  public static final class SubVideoInfo
    extends MessageMicro<SubVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.UrlJumpInfo bytes_jum_url = new articlesummary.UrlJumpInfo();
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_first_page_pic_url", "bytes_jum_url", "bytes_inner_uniq_id", "uint32_video_play_count", "uint32_duration" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, SubVideoInfo.class);
    }
  }
  
  public static final class SubscribeInfo
    extends MessageMicro<SubscribeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_colour = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_is_subscribed", "bytes_test", "bytes_colour" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, SubscribeInfo.class);
    }
  }
  
  public static final class TopicEntranceInfo
    extends MessageMicro<TopicEntranceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_arron = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hotkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_is_topic = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "bytes_hotkey", "bytes_icon", "bytes_title", "bytes_arron", "uint32_is_topic" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, TopicEntranceInfo.class);
    }
  }
  
  public static final class TopicRecommendFeedsInfo
    extends MessageMicro<TopicRecommendFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.TopicRecommendFeedsTitle msg_left_title = new articlesummary.TopicRecommendFeedsTitle();
    public articlesummary.TopicRecommendFeedsTitle msg_right_title = new articlesummary.TopicRecommendFeedsTitle();
    public final PBRepeatMessageField<articlesummary.TopicRecommendInfo> msg_topic_recommend_info = PBField.initRepeatMessage(articlesummary.TopicRecommendInfo.class);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 90, 98, 106, 114 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "bytes_subscribe_name", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, null, null, localByteStringMicro3 }, TopicRecommendFeedsInfo.class);
    }
  }
  
  public static final class TopicRecommendFeedsTitle
    extends MessageMicro<TopicRecommendFeedsTitle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_title_content", "bytes_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, TopicRecommendFeedsTitle.class);
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
    static final MessageMicro.FieldMap __fieldMap__;
    public feeds_info.AccountProfile account_profile = new feeds_info.AccountProfile();
    public final PBBytesField bytes_json_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_pic_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
    public final PBEnumField enum_ugc_feeds_src = PBField.initEnum(0);
    public articlesummary.BiuMultiLevel msg_at_multi_level = new articlesummary.BiuMultiLevel();
    public final PBRepeatMessageField<articlesummary.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(articlesummary.UGCPicInfo.class);
    public final PBRepeatMessageField<articlesummary.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(articlesummary.UGCVideoInfo.class);
    public final PBRepeatMessageField<articlesummary.UGCVoiceInfo> msg_ugc_voice_info_list = PBField.initRepeatMessage(articlesummary.UGCVoiceInfo.class);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 122, 130, 138, 178, 186, 210 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "enum_ugc_feeds_src", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments", "bytes_json_pic_list", "bytes_json_video_list", "bytes_json_content", "msg_at_multi_level", "bytes_jump_url", "account_profile", "msg_ugc_voice_info_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, null, localByteStringMicro5, null, null }, UGCFeedsInfo.class);
    }
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
  
  public static final class UGCVoiceInfo
    extends MessageMicro<UGCVoiceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "bytes_voice_url", "uint32_duration", "uint32_file_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, UGCVoiceInfo.class);
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
    public final PBUInt32Field uint32_jump_src = PBField.initUInt32(0);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56 }, new String[] { "uint32_jump_type", "bytes_jump_url", "bytes_jump_bundle", "bytes_jump_schema", "bytes_clipboard_info", "bytes_common_data", "uint32_jump_src" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, UrlJumpInfo.class);
    }
  }
  
  public static final class VerifyResult
    extends MessageMicro<VerifyResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_verify_status = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_verify_status", "bytes_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, VerifyResult.class);
    }
  }
  
  public static final class VideoColumnInfo
    extends MessageMicro<VideoColumnInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public articlesummary.UrlJumpInfo app_jump_info = new articlesummary.UrlJumpInfo();
    public final PBBytesField bytes_app_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_app_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_card_bg_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_card_bg_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_card_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_column_name_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_from_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sub_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.UrlJumpInfo default_jump_info = new articlesummary.UrlJumpInfo();
    public final PBRepeatMessageField<articlesummary.SubVideoInfo> rpt_sub_video_info = PBField.initRepeatMessage(articlesummary.SubVideoInfo.class);
    public articlesummary.UrlJumpInfo subscribe_jump_info = new articlesummary.UrlJumpInfo();
    public final PBUInt32Field uin32_column_card_bg_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subscribe_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_update_time = PBField.initUInt64(0L);
    public articlesummary.UrlJumpInfo video_jump_info = new articlesummary.UrlJumpInfo();
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 90, 98, 106, 114, 122, 130, 136, 146, 154, 160, 170, 178 }, new String[] { "uint32_column_id", "bytes_column_name", "bytes_column_icon_url", "uint64_last_update_time", "uint32_video_count", "uint32_subscribe_count", "uint32_is_subscribed", "bytes_column_card_bg_url", "bytes_column_card_bg_color", "bytes_column_card_icon_url", "bytes_app_name", "bytes_app_icon_url", "default_jump_info", "video_jump_info", "subscribe_jump_info", "app_jump_info", "uin32_column_card_bg_style", "rpt_sub_video_info", "bytes_sub_title", "uint32_update_count", "bytes_from_txt", "bytes_column_name_color" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, null, null, null, null, Integer.valueOf(0), null, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10 }, VideoColumnInfo.class);
    }
  }
  
  public static final class VideoDownloadBarInfo
    extends MessageMicro<VideoDownloadBarInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public articlesummary.UrlJumpInfo msg_url_jump_info = new articlesummary.UrlJumpInfo();
    public final PBUInt32Field uint32_appear_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appear_time = PBField.initUInt32(0);
    public articlesummary.WeishiUGInfo weishiUGInfo = new articlesummary.WeishiUGInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58 }, new String[] { "uint32_appear_style", "uint32_appear_time", "bytes_icon_url", "bytes_icon_text", "msg_url_jump_info", "bytes_common_data", "weishiUGInfo" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3, null }, VideoDownloadBarInfo.class);
    }
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
    public articlesummary.UrlJumpInfo msg_url_jump_info = new articlesummary.UrlJumpInfo();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_report_base_url = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_auto_play = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_with_angle_sign = PBField.initUInt32(0);
    public final PBUInt32Field uint32_residence_threshold = PBField.initUInt32(0);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 80, 88, 96 }, new String[] { "bytes_report_base_url", "bytes_exposure_report_tail", "bytes_click_report_tail", "bytes_click_schema_report_tail", "bytes_click_h5_report_tail", "rpt_bytes_report_base_url", "msg_url_jump_info", "uint32_auto_play", "bytes_back_off_group", "uint32_use_ug", "uint32_is_with_angle_sign", "uint32_residence_threshold" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, WeishiUGInfo.class);
    }
  }
  
  public static final class WendaInfo
    extends MessageMicro<WendaInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public articlesummary.AnswerDetail answer_detail = new articlesummary.AnswerDetail();
    public final PBStringField author_nick = PBField.initString("");
    public final PBBytesField bytes_answer_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_question_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wenda_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field channel_id = PBField.initUInt32(0);
    public final PBStringField channel_id_name = PBField.initString("");
    public final PBUInt32Field channel_second_id = PBField.initUInt32(0);
    public final PBStringField channel_second_id_name = PBField.initString("");
    public final PBStringField icon_color = PBField.initString("");
    public final PBStringField icon_name = PBField.initString("");
    public final PBRepeatField<String> images_url = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField super_wenda_button_title = PBField.initString("");
    public final PBRepeatField<Integer> tag_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<String> tag_id_name = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_answer_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_super_wenda = PBField.initUInt32(0);
    public final PBUInt32Field uint32_question_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 66, 72, 82, 88, 98, 104, 114, 120, 130, 138, 146, 154, 162, 170, 178, 186 }, new String[] { "uint32_is_super_wenda", "bytes_question_rowkey", "bytes_question_desc", "bytes_question_pic_url", "bytes_wenda_url", "uint32_follow_count", "uint32_answer_count", "bytes_icon_url", "uint32_question_status", "bytes_answer_url", "channel_id", "channel_id_name", "channel_second_id", "channel_second_id_name", "tag_id", "tag_id_name", "author_nick", "jump_url", "images_url", "icon_name", "icon_color", "answer_detail", "super_wenda_button_title" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", "", null, "" }, WendaInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary
 * JD-Core Version:    0.7.0.1
 */