package tencent.im.oidb.cmd0xbd2;

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
import tencent.im.oidb.articlesummary.feeds_info.UGCVideoInfo;

public final class oidb_cmd0xbd2
{
  public static final class DiscoverBanner
    extends MessageMicro<DiscoverBanner>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cover_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_data_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_jump_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42 }, new String[] { "uint64_id", "bytes_cover_url", "bytes_cover_title", "uint32_jump_type", "bytes_jump_data_json" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, DiscoverBanner.class);
    }
  }
  
  public static final class DiscoverTopic
    extends MessageMicro<DiscoverTopic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subtitle = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverTopicVideoCard> rpt_video_card_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverTopicVideoCard.class);
    public final PBUInt32Field uint32_effective_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expiation_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_recomment = PBField.initUInt32(0);
    public final PBBytesField uint64_play_count = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 72, 82, 162 }, new String[] { "uint64_topic_id", "bytes_title", "bytes_cover_url", "bytes_subtitle", "uint64_play_count", "bytes_url", "uint32_has_recomment", "uint32_effective_time", "uint32_expiation_time", "bytes_common_data", "rpt_video_card_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, null }, DiscoverTopic.class);
    }
  }
  
  public static final class DiscoverTopicVideoCard
    extends MessageMicro<DiscoverTopicVideoCard>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_corner_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sort_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feeds_type = PBField.initEnum(0);
    public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<feeds_info.UGCVideoInfo> msg_ugc_video_info_list = PBField.initRepeatMessage(feeds_info.UGCVideoInfo.class);
    public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
    public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_cuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50, 58, 64, 74, 82, 90, 98, 104, 114, 120, 130, 136, 146 }, new String[] { "bytes_corner_icon_url", "bytes_cover_url", "uint64_feeds_id", "feeds_type", "bytes_rowkey", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_article_content_url", "uint64_time", "json_video_list", "uint32_is_ugc", "msg_ugc_video_info_list", "uint64_cuin", "bytes_sort_data" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, Long.valueOf(0L), localByteStringMicro10, Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro11 }, DiscoverTopicVideoCard.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rpt_bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_entrance_topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_entrance_red_req = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_banner = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_topic_count_in_page = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_count_in_topic = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 64 }, new String[] { "rpt_bytes_cookie", "uint32_req_source", "uint32_req_banner", "uint32_topic_count_in_page", "uint32_video_count_in_topic", "rpt_uint64_entrance_topic_id_list", "bytes_push_context", "uint32_entrance_red_req" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverBanner> rpt_banner_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverBanner.class);
    public final PBBytesField rpt_bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_cmd0xbd2.DiscoverTopic> rpt_topic_list = PBField.initRepeatMessage(oidb_cmd0xbd2.DiscoverTopic.class);
    public final PBUInt32Field uint32_has_more = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "rpt_banner_list", "rpt_topic_list", "rpt_bytes_cookie", "uint32_has_more" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd2.oidb_cmd0xbd2
 * JD-Core Version:    0.7.0.1
 */