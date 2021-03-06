package localpb.readinjoy;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Readinjoy
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
    public Readinjoy.ChannelInfo msg_channel_info = new Readinjoy.ChannelInfo();
    public Readinjoy.VideoData msg_video_data = new Readinjoy.VideoData();
    public final PBRepeatMessageField<ArticleSummary> rpt_article_list = PBField.initRepeatMessage(ArticleSummary.class);
    public final PBRepeatMessageField<Readinjoy.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(Readinjoy.ArticleTagInfo.class);
    public final PBRepeatMessageField<Readinjoy.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(Readinjoy.ChannelInfo.class);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58, 66, 74, 82, 88, 98, 106, 114, 120, 128, 136, 144, 152, 162, 170, 178, 186, 194, 200, 210, 218, 224, 234, 242, 250, 256, 266, 274 }, new String[] { "uint64_article_id", "bytes_rowkey", "uint32_is_ugc", "uint32_uptime", "uint32_feeds_type", "uint32_video_count", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "uint64_time", "bytes_name", "bytes_icon", "bytes_uin", "uint32_comment_count", "uint64_recommend_time", "uint64_recommend_seq", "uint64_algorithm_id", "uint32_strategy_id", "bytes_recommend_reason", "msg_video_data", "rpt_article_tag_list", "msg_channel_info", "bytes_push_context", "uint32_play_count", "rpt_label_list", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_video_subscript_txt", "bytes_video_subscript_color", "bytes_video_report_info", "uint32_article_style", "bytes_business_info", "rpt_article_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro9, null, null, null, localByteStringMicro10, Integer.valueOf(0), null, localByteStringMicro11, Integer.valueOf(0), localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), localByteStringMicro15, null }, ArticleSummary.class);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     localpb.readinjoy.Readinjoy
 * JD-Core Version:    0.7.0.1
 */