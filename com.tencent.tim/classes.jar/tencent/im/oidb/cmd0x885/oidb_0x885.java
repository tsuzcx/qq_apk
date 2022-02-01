package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
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

public final class oidb_0x885
{
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
    public final PBBytesField bytes_soft_ad_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_title_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_trace_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_via = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_view_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x885.ContainerAdItem> container_ad_item = PBField.initRepeatMessage(oidb_0x885.ContainerAdItem.class);
    public final PBEnumField enum_ad_jump_mode = PBField.initEnum(1);
    public final PBEnumField enum_ad_layout = PBField.initEnum(0);
    public final PBInt32Field int32_kd_pos = PBField.initInt32(0);
    public final PBInt32Field int32_product_type = PBField.initInt32(0);
    public final PBInt32Field int32_soft_ad_type = PBField.initInt32(0);
    public final PBInt64Field int64_noco_id = PBField.initInt64(0L);
    public oidb_0x885.LocalInfo local_info = new oidb_0x885.LocalInfo();
    public final PBRepeatMessageField<AdInfo> rpt_msg_inner_ad_info = PBField.initRepeatMessage(AdInfo.class);
    public final PBRepeatMessageField<oidb_0x885.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x885.NegFeedback.class);
    public final PBStringField string_canvas_json = PBField.initString("");
    public final PBStringField string_download_api_url = PBField.initString("");
    public final PBStringField string_effect_url = PBField.initString("");
    public final PBStringField string_interact_image_list = PBField.initString("");
    public final PBStringField string_interaction_report_url = PBField.initString("");
    public final PBStringField string_pop_sheel = PBField.initString("");
    public final PBStringField string_prime_ad_key = PBField.initString("");
    public final PBStringField string_unviersal_link = PBField.initString("");
    public final PBStringField string_video_report_url = PBField.initString("");
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
    public final PBUInt64Field uint64_download_num = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_response_ad_time = PBField.initUInt64(0L);
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
      ByteStringMicro localByteStringMicro29 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 130, 138, 146, 154, 162, 170, 178, 184, 194, 202, 208, 218, 226, 234, 240, 248, 256, 264, 272, 282, 288, 298, 304, 312, 320, 328, 338, 346, 354, 362, 370, 376, 384, 394, 400, 410, 416, 426, 432, 442, 448, 456, 466, 472, 482, 490, 496, 506, 512, 522, 528, 538, 546, 552, 562 }, new String[] { "uint64_channel_id", "int32_kd_pos", "bytes_cl", "bytes_img", "bytes_img_s", "bytes_txt", "bytes_desc", "bytes_rl", "bytes_apurl", "bytes_trace_id", "bytes_product_id", "int32_product_type", "uint32_ad_type", "rpt_msg_inner_ad_info", "bytes_landing_page", "bytes_price", "bytes_button_txt", "bytes_view_id", "bytes_customized_invoke_url", "bytes_corporation_name", "bytes_corporate_image_name", "bytes_corporate_logo", "uint64_ad_uin", "bytes_ext", "bytes_video_url", "uint32_cost_type", "bytes_title_list", "bytes_image_list", "bytes_url_list", "uint64_aid", "enum_ad_layout", "uint32_ad_material_id", "uint32_ad_material_width", "uint32_ad_material_height", "bytes_via", "uint32_dis_channel", "bytes_button_url", "uint32_duration", "enum_ad_jump_mode", "uint32_algo_id", "uint32_stra_id", "rpt_msg_neg_feedback", "bytes_extra_data", "bytes_app_download_schema", "string_canvas_json", "bytes_landing_page_report_url", "uint64_advertiser_id", "uint32_dest_type", "string_effect_url", "int64_noco_id", "container_ad_item", "uint64_response_ad_time", "string_video_report_url", "uint64_feeds_id", "string_interaction_report_url", "uint32_app_score_num", "uint64_download_num", "bytes_rowkey", "uint64_article_id", "string_pop_sheel", "string_download_api_url", "uint64_video_file_size", "local_info", "uint32_interact_effect_type", "string_interact_image_list", "uint32_interact_type", "string_prime_ad_key", "string_unviersal_link", "int32_soft_ad_type", "bytes_soft_ad_data" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Long.valueOf(0L), localByteStringMicro18, localByteStringMicro19, Integer.valueOf(0), localByteStringMicro20, localByteStringMicro21, localByteStringMicro22, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro25, localByteStringMicro26, "", localByteStringMicro27, Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), null, Long.valueOf(0L), "", Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro28, Long.valueOf(0L), "", "", Long.valueOf(0L), null, Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), localByteStringMicro29 }, AdInfo.class);
    }
  }
  
  public static final class AdReqInfo
    extends MessageMicro<AdReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50, 58, 66, 74, 80, 88, 98, 106, 112, 120 }, new String[] { "uint64_ad_channel_id", "int32_req_type", "msg_game_component_info", "int32_first_refresh", "int32_second_request", "rpt_feeds_context", "string_article_id", "msg_kol_info", "string_deep_link_version", "int32_scene_id", "int32_revision_video", "string_content_id", "string_account_id", "present_from", "source_channel_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, "", null, "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L) }, AdReqInfo.class);
    public final PBInt32Field int32_first_refresh = PBField.initInt32(0);
    public final PBInt32Field int32_req_type = PBField.initInt32(0);
    public final PBInt32Field int32_revision_video = PBField.initInt32(0);
    public final PBInt32Field int32_scene_id = PBField.initInt32(0);
    public final PBInt32Field int32_second_request = PBField.initInt32(0);
    public oidb_0x885.GameComponentInfo msg_game_component_info = new oidb_0x885.GameComponentInfo();
    public oidb_0x885.KolInfo msg_kol_info = new oidb_0x885.KolInfo();
    public final PBUInt32Field present_from = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_0x885.FeedsItem> rpt_feeds_context = PBField.initRepeatMessage(oidb_0x885.FeedsItem.class);
    public final PBUInt64Field source_channel_id = PBField.initUInt64(0L);
    public final PBStringField string_account_id = PBField.initString("");
    public final PBStringField string_article_id = PBField.initString("");
    public final PBStringField string_content_id = PBField.initString("");
    public final PBStringField string_deep_link_version = PBField.initString("");
    public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
  }
  
  public static final class AdTagInfo
    extends MessageMicro<AdTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_display_ad_flag = PBField.initInt32(0);
    public final PBInt32Field int32_pos = PBField.initInt32(0);
    public oidb_0x885.ClassInfo msg_class_info = new oidb_0x885.ClassInfo();
    public final PBRepeatMessageField<oidb_0x885.KdTagItem> rpt_kd_tag_list = PBField.initRepeatMessage(oidb_0x885.KdTagItem.class);
    public final PBStringField string_ad_feature_info = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "bytes_rowkey", "rpt_kd_tag_list", "int32_display_ad_flag", "int32_pos", "msg_class_info", "string_ad_feature_info" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), null, "" }, AdTagInfo.class);
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
  
  public static final class ClassInfo
    extends MessageMicro<ClassInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint64_ch1_id", "string_ch1", "uint64_ch2_id", "string_ch2", "uint64_ch3_id", "string_ch3" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), "", Long.valueOf(0L), "" }, ClassInfo.class);
    public final PBStringField string_ch1 = PBField.initString("");
    public final PBStringField string_ch2 = PBField.initString("");
    public final PBStringField string_ch3 = PBField.initString("");
    public final PBUInt64Field uint64_ch1_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ch2_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_ch3_id = PBField.initUInt64(0L);
  }
  
  public static final class ContainerAdItem
    extends MessageMicro<ContainerAdItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_dest_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_img_url_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_img_url_list", "bytes_desc", "bytes_dest_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ContainerAdItem.class);
    }
  }
  
  public static final class FeedsItem
    extends MessageMicro<FeedsItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 66 }, new String[] { "uint32_feed_pos", "string_title", "uint32_score", "uint32_ai_kongbu_level", "uint32_ai_disu_level", "uint32_ai_biaotidang_level", "uint32_ai_unsocial_level", "rpt_kd_tag_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, FeedsItem.class);
    public final PBRepeatMessageField<oidb_0x885.KdTagItem> rpt_kd_tag_list = PBField.initRepeatMessage(oidb_0x885.KdTagItem.class);
    public final PBStringField string_title = PBField.initString("");
    public final PBUInt32Field uint32_ai_biaotidang_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ai_disu_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ai_kongbu_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ai_unsocial_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feed_pos = PBField.initUInt32(0);
    public final PBUInt32Field uint32_score = PBField.initUInt32(0);
  }
  
  public static final class GameComponentInfo
    extends MessageMicro<GameComponentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_day_display_count", "uint32_session_display_count", "rpt_tag_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, GameComponentInfo.class);
    public final PBRepeatMessageField<oidb_0x885.AdTagInfo> rpt_tag_info = PBField.initRepeatMessage(oidb_0x885.AdTagInfo.class);
    public final PBUInt32Field uint32_day_display_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_session_display_count = PBField.initUInt32(0);
  }
  
  public static final class KdTagItem
    extends MessageMicro<KdTagItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_tagid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24 }, new String[] { "bytes_name", "uint64_tagid" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, KdTagItem.class);
    }
  }
  
  public static final class KolInfo
    extends MessageMicro<KolInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_is_kol", "string_koldid" }, new Object[] { Integer.valueOf(0), "" }, KolInfo.class);
    public final PBInt32Field int32_is_kol = PBField.initInt32(0);
    public final PBStringField string_koldid = PBField.initString("");
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
  
  public static final class PhoneInfo
    extends MessageMicro<PhoneInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type", "uint64_func_flag", "bytes_cookie", "bytes_manufacturer", "bytes_device_brand_and_model", "string_qadid", "string_oaid", "string_taid", "string_androidid", "string_mac", "string_client_ipv4", "string_imei", "string_idfa", "bytes_wx_ver" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, "", "", "", "", "", "", "", "", localByteStringMicro9 }, PhoneInfo.class);
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
    public final PBRepeatMessageField<oidb_0x885.AdInfo> rpt_msg_ad_info = PBField.initRepeatMessage(oidb_0x885.AdInfo.class);
    public final PBUInt32Field uint32_is_second_request = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_second_request = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pos_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48, 56, 64 }, new String[] { "int32_ret", "bytes_msg", "enum_pos_layout", "uint64_pos_id", "rpt_msg_ad_info", "is_auto_play", "uint32_need_second_request", "uint32_is_second_request" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, PosAdInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ad_display = PBField.initEnum(2);
    public oidb_0x885.AdReqInfo msg_ad_req_info = new oidb_0x885.AdReqInfo();
    public oidb_0x885.PhoneInfo msg_phone_info = new oidb_0x885.PhoneInfo();
    public oidb_0x885.VideoFloatInfo msg_video_float_info = new oidb_0x885.VideoFloatInfo();
    public final PBRepeatField<ByteStringMicro> rpt_bytes_req_row_key = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_user_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_pull_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public oidb_0x885.UserLocation user_location = new oidb_0x885.UserLocation();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 64, 74, 82, 90, 98, 104 }, new String[] { "uint64_uin", "msg_phone_info", "uint64_last_pull_time", "uint64_channel_id", "enum_ad_display", "msg_video_float_info", "rpt_bytes_req_row_key", "uint32_user_type", "user_location", "bytes_cookie", "bytes_ad_user_info", "msg_ad_req_info", "uint64_seq" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(2), null, localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3, null, Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_user_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBInt32Field int_req_type = PBField.initInt32(0);
    public final PBRepeatMessageField<oidb_0x885.NegFeedback> rpt_msg_neg_feedback = PBField.initRepeatMessage(oidb_0x885.NegFeedback.class);
    public final PBRepeatMessageField<oidb_0x885.PosAdInfo> rpt_msg_pos_ad_info = PBField.initRepeatMessage(oidb_0x885.PosAdInfo.class);
    public final PBUInt64Field uint64_ad_channel_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 72, 80, 88 }, new String[] { "int32_ret", "uint64_uin", "rpt_msg_pos_ad_info", "bytes_msg", "uint64_time", "rpt_msg_neg_feedback", "bytes_cookie", "bytes_ad_user_info", "uint64_ad_channel_id", "int_req_type", "uint64_seq" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, localByteStringMicro1, Long.valueOf(0L), null, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
    }
  }
  
  public static final class UserLocation
    extends MessageMicro<UserLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField district = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "country", "province", "city", "district" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, UserLocation.class);
    }
  }
  
  public static final class VideoFloatInfo
    extends MessageMicro<VideoFloatInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_ad_support", "uint32_info_num", "rpt_msg_ad_video_pos", "uint32_req_info_num", "uint32_req_vertical_video" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, VideoFloatInfo.class);
    public final PBRepeatMessageField<oidb_0x885.AdVideoPos> rpt_msg_ad_video_pos = PBField.initRepeatMessage(oidb_0x885.AdVideoPos.class);
    public final PBUInt32Field uint32_ad_support = PBField.initUInt32(0);
    public final PBUInt32Field uint32_info_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_info_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_vertical_video = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885
 * JD-Core Version:    0.7.0.1
 */