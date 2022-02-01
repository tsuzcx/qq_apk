package tencent.im.oidb.cmd0xbed;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbed
{
  public static final class ArticleSummary
    extends MessageMicro<ArticleSummary>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbed.ChannelInfo msg_channel_info = new oidb_cmd0xbed.ChannelInfo();
    public oidb_cmd0xbed.VideoData msg_video_data = new oidb_cmd0xbed.VideoData();
    public final PBRepeatMessageField<ArticleSummary> rpt_article_list = PBField.initRepeatMessage(ArticleSummary.class);
    public final PBRepeatMessageField<oidb_cmd0xbed.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(oidb_cmd0xbed.ArticleTagInfo.class);
    public final PBRepeatMessageField<oidb_cmd0xbed.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(oidb_cmd0xbed.ChannelInfo.class);
    public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_article_style = PBField.initUInt32(0);
    public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feeds_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
    public final PBUInt32Field uint32_play_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uptime = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 136, 144, 152, 162, 170, 178, 186, 194, 200, 210, 218, 224, 234, 242, 250, 256, 274, 80010 }, new String[] { "uint64_article_id", "bytes_rowkey", "uint32_is_ugc", "uint32_uptime", "uint32_feeds_type", "uint32_video_count", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "uint64_time", "bytes_name", "bytes_icon", "bytes_uin", "uint32_comment_count", "uint64_recommend_time", "uint64_recommend_seq", "uint64_algorithm_id", "uint32_strategy_id", "bytes_recommend_reason", "msg_video_data", "rpt_article_tag_list", "msg_channel_info", "bytes_push_context", "uint32_play_count", "rpt_label_list", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_video_subscript_txt", "bytes_video_subscript_color", "bytes_video_report_info", "uint32_article_style", "rpt_article_list", "bytes_business_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro9, null, null, null, localByteStringMicro10, Integer.valueOf(0), null, localByteStringMicro11, Integer.valueOf(0), localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), null, localByteStringMicro15 }, ArticleSummary.class);
    }
  }
  
  public static final class ArticleTagInfo
    extends MessageMicro<ArticleTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_tag_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_tag_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_tag_id", "bytes_tag_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ArticleTagInfo.class);
    }
  }
  
  public static final class ChannelInfo
    extends MessageMicro<ChannelInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_channel_id", "uint32_channel_type", "bytes_channel_name", "bytes_channel_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, ChannelInfo.class);
    }
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
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reqChannelPara" }, new Object[] { null }, ReqBody.class);
    public oidb_cmd0xbed.ReqChannelPara reqChannelPara = new oidb_cmd0xbed.ReqChannelPara();
  }
  
  public static final class ReqChannelPara
    extends MessageMicro<ReqChannelPara>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_begin_recommend_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_business_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_device_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_end_recommend_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xbed.InnerMsg> rpt_inner_msg_list = PBField.initRepeatMessage(oidb_cmd0xbed.InnerMsg.class);
    public final PBRepeatField<Long> rpt_subscription_article_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sim_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_times = PBField.initUInt32(0);
    public final PBUInt64Field uint64_begin_collection_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_begin_recommend_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_collection_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_recommend_seq = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 66, 72, 82, 88, 96, 104, 112, 80010 }, new String[] { "uint32_channel_id", "uint32_channel_type", "uint64_begin_recommend_seq", "uint64_end_recommend_seq", "bytes_begin_recommend_rowkey", "bytes_end_recommend_rowkey", "rpt_subscription_article_list", "bytes_device_id", "uint32_update_times", "rpt_inner_msg_list", "uint32_sim_type", "uint64_begin_collection_id", "uint64_end_collection_id", "uint32_network_type", "bytes_business_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro4 }, ReqChannelPara.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rspChannelArticle" }, new Object[] { null }, RspBody.class);
    public oidb_cmd0xbed.RspChannelArticle rspChannelArticle = new oidb_cmd0xbed.RspChannelArticle();
  }
  
  public static final class RspChannelArticle
    extends MessageMicro<RspChannelArticle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_channel_id", "uint32_channel_type", "rpt_article_list", "uint32_is_no_more_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, RspChannelArticle.class);
    public final PBRepeatMessageField<oidb_cmd0xbed.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(oidb_cmd0xbed.ArticleSummary.class);
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  }
  
  public static final class VideoData
    extends MessageMicro<VideoData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 58 }, new String[] { "uint32_busi_type", "uint32_duration", "uint32_width", "uint32_height", "bytes_vid", "uint32_file_size", "bytes_video_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, VideoData.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbed.oidb_cmd0xbed
 * JD-Core Version:    0.7.0.1
 */