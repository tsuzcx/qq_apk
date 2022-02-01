package tencent.im.oidb.cmd0x64e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x64e
{
  public static final class BiuMultiLevel
    extends MessageMicro<BiuMultiLevel>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_biu_mutli_level", "uint64_origin_feeds_id", "uint64_origin_feeds_type" }, new Object[] { null, Long.valueOf(0L), Long.valueOf(0L) }, BiuMultiLevel.class);
    public final PBRepeatMessageField<oidb_cmd0x64e.BiuOneLevelItem> rpt_biu_mutli_level = PBField.initRepeatMessage(oidb_cmd0x64e.BiuOneLevelItem.class);
    public final PBUInt64Field uint64_origin_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_origin_feeds_type = PBField.initUInt64(0L);
  }
  
  public static final class BiuOneLevelItem
    extends MessageMicro<BiuOneLevelItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_biu_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_feeds_id", "uint64_uin", "uint32_biu_time", "bytes_biu_comments", "feeds_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, BiuOneLevelItem.class);
    }
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_src = PBField.initEnum(0);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public oidb_cmd0x64e.SocializeFeedsInfo msg_social_feeds_info = new oidb_cmd0x64e.SocializeFeedsInfo();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 90, 160 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "msg_social_feeds_info", "enum_ugc_src" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, FeedsInfo.class);
    }
  }
  
  public static final class FeedsReportData
    extends MessageMicro<FeedsReportData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_feeds_id", "uint64_publish_uin", "rpt_like_uin_list", "uint32_like_total_count", "uint32_comment_total_count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, FeedsReportData.class);
    public final PBRepeatField<Long> rpt_like_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_comment_total_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_total_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_publish_uin = PBField.initUInt64(0L);
  }
  
  public static final class PGCFeedsInfo
    extends MessageMicro<PGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pgc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x64e.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.PGCPicInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x64e.PGCVideoInfo> msg_pgc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.PGCVideoInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106 }, new String[] { "msg_pgc_pic_info_list", "msg_pgc_video_info_list", "bytes_pgc_comments" }, new Object[] { null, null, localByteStringMicro }, PGCFeedsInfo.class);
    }
  }
  
  public static final class PGCPicInfo
    extends MessageMicro<PGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, PGCPicInfo.class);
    }
  }
  
  public static final class PGCVideoInfo
    extends MessageMicro<PGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, PGCVideoInfo.class);
    }
  }
  
  public static final class ReportInfo
    extends MessageMicro<ReportInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_gallery = PBField.initBool(false);
    public final PBBytesField bytes_a2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_author_reply_to_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_collect_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gallery_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_hot_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_origin_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_words = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_search_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_server_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_feeds_type = PBField.initEnum(0);
    public final PBEnumField enum_fit_type = PBField.initEnum(0);
    public final PBEnumField enum_in_onetree_source = PBField.initEnum(0);
    public final PBEnumField enum_in_videochannel_source = PBField.initEnum(0);
    public final PBEnumField enum_jumpway_which = PBField.initEnum(0);
    public final PBEnumField enum_network_type = PBField.initEnum(0);
    public final PBEnumField enum_op_source = PBField.initEnum(0);
    public final PBEnumField enum_operation = PBField.initEnum(1);
    public final PBEnumField enum_user_state_notify = PBField.initEnum(0);
    public oidb_cmd0x64e.SRTClickInfo msg_srt_click_info = new oidb_cmd0x64e.SRTClickInfo();
    public final PBEnumField operator_platform = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_cmd0x64e.FeedsReportData> rpt_feeds_report_data_list = PBField.initRepeatMessage(oidb_cmd0x64e.FeedsReportData.class);
    public final PBUInt32Field uint32_a2_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_algorithm_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_article_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_current_video_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_folder_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_no_difference_jump = PBField.initUInt32(0);
    public final PBUInt32Field uint32_onetree_video_from_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_time_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_article_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_time_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_duration = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_reply_to_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_shared_user_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_subscribe_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    public final PBBoolField whether_click_in = PBField.initBool(false);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 48, 56, 64, 74, 80, 88, 98, 104, 112, 122, 130, 138, 146, 152, 162, 170, 178, 184, 192, 202, 210, 218, 224, 232, 240, 248, 258, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 352, 362, 400, 410, 480, 488, 498, 506, 514, 522, 528, 536, 546, 554, 560, 570 }, new String[] { "uint64_uin", "uint32_source", "uint64_source_article_id", "uint32_channel_id", "uint32_algorithm_id", "enum_operation", "uint32_read_time_length", "bytes_collect_url", "enum_op_source", "uint32_strategy_id", "bytes_inner_id", "uint32_play_time_length", "uint64_subscribe_id", "bytes_server_context", "bytes_search_tag_name", "bytes_comment_content", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_skey", "bytes_a2", "uint32_a2_appid", "uint64_shared_user_id", "bytes_device_id", "rpt_feeds_report_data_list", "bytes_recommend_words", "uint32_folder_status", "uint64_cuin", "uint64_topic_id", "uint64_author_reply_to_uin", "bytes_author_reply_to_comment_content", "uint32_video_duration", "enum_jumpway_which", "enum_network_type", "enum_in_onetree_source", "whether_click_in", "uint32_current_video_time", "operator_platform", "enum_in_videochannel_source", "enum_user_state_notify", "enum_fit_type", "uint64_feeds_id", "enum_feeds_type", "bytes_origin_comment_id", "bool_is_gallery", "bytes_gallery_report_info", "uint32_article_length", "uint32_read_article_length", "bytes_version", "bytes_vid", "bytes_hot_word", "bytes_gw_common_data", "uint32_onetree_video_from_type", "uint32_column_id", "bytes_video_report_info", "msg_srt_click_info", "uint32_no_difference_jump", "bytes_first_rowkey" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro10, null, localByteStringMicro11, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro12, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro13, Boolean.valueOf(false), localByteStringMicro14, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, localByteStringMicro18, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro19, null, Integer.valueOf(0), localByteStringMicro20 }, ReportInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pre_load_req_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0x64e.ReportInfo> rpt_report_info = PBField.initRepeatMessage(oidb_cmd0x64e.ReportInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_report_info", "bytes_pre_load_req_info" }, new Object[] { null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], RspBody.class);
  }
  
  public static final class SRTClickInfo
    extends MessageMicro<SRTClickInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_srt_rule_list", "uint32_hit_srt_rule_index", "msg_hit_srt_rule" }, new Object[] { null, Integer.valueOf(0), null }, SRTClickInfo.class);
    public oidb_cmd0x64e.SRTRule msg_hit_srt_rule = new oidb_cmd0x64e.SRTRule();
    public final PBRepeatMessageField<oidb_cmd0x64e.SRTRule> msg_srt_rule_list = PBField.initRepeatMessage(oidb_cmd0x64e.SRTRule.class);
    public final PBUInt32Field uint32_hit_srt_rule_index = PBField.initUInt32(0);
  }
  
  public static final class SRTRule
    extends MessageMicro<SRTRule>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_app_package_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_h5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> uint32_click_number = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<Integer> uint32_feeds_type = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint32_network_type", "uint32_click_number", "uint32_feeds_type", "bytes_h5", "bytes_schema", "bytes_app_package_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SRTRule.class);
    }
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
    public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x64e.BiuMultiLevel msg_biu_mutli_level = new oidb_cmd0x64e.BiuMultiLevel();
    public oidb_cmd0x64e.SocializeFeedsInfoUser msg_master_uin = new oidb_cmd0x64e.SocializeFeedsInfoUser();
    public oidb_cmd0x64e.PGCFeedsInfo msg_pgc_topic_feeds_info = new oidb_cmd0x64e.PGCFeedsInfo();
    public oidb_cmd0x64e.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new oidb_cmd0x64e.SocializeFeedsExtInfo();
    public oidb_cmd0x64e.UGCFeedsInfo msg_ugc_topic_feeds_info = new oidb_cmd0x64e.UGCFeedsInfo();
    public oidb_cmd0x64e.VerifyResult msg_verify_result = new oidb_cmd0x64e.VerifyResult();
    public final PBRepeatMessageField<oidb_cmd0x64e.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(oidb_cmd0x64e.SocializeFeedsInfoUser.class);
    public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
    public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, SocializeFeedsInfo.class);
    }
  }
  
  public static final class SocializeFeedsInfoUser
    extends MessageMicro<SocializeFeedsInfoUser>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_uin", "enum_uin_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SocializeFeedsInfoUser.class);
    public final PBEnumField enum_uin_type = PBField.initEnum(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class UGCFeedsInfo
    extends MessageMicro<UGCFeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ugc_comments = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_ugc_feeds_card_type = PBField.initEnum(0);
    public final PBRepeatMessageField<oidb_cmd0x64e.UGCPicInfo> msg_ugc_pic_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.UGCPicInfo.class);
    public final PBRepeatMessageField<oidb_cmd0x64e.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(oidb_cmd0x64e.UGCVideoInfo.class);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106 }, new String[] { "enum_ugc_feeds_card_type", "uint64_cuin", "msg_ugc_pic_info_list", "msg_ugc_video_info_list", "bytes_ugc_comments" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro }, UGCFeedsInfo.class);
    }
  }
  
  public static final class UGCPicInfo
    extends MessageMicro<UGCPicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_pic_width", "uint32_pic_height", "bytes_pic_md5", "bytes_pic_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, UGCPicInfo.class);
    }
  }
  
  public static final class UGCVideoInfo
    extends MessageMicro<UGCVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 64, 72, 80, 88 }, new String[] { "bytes_video_md5", "bytes_video_url", "bytes_pic_md5", "bytes_pic_url", "bytes_title", "bytes_uuid", "uint64_duration", "uint32_video_width", "uint32_video_height", "uint32_pic_width", "uint32_pic_height" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UGCVideoInfo.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x64e.oidb_cmd0x64e
 * JD-Core Version:    0.7.0.1
 */