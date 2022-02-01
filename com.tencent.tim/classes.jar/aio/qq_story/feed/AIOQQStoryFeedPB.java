package aio.qq_story.feed;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AIOQQStoryFeedPB
{
  public static final class AIOQQStoryFeed
    extends MessageMicro<AIOQQStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50 }, new String[] { "str_feed_id", "uint64_time", "msg_covers_info", "uint32_video_num", "str_union_id", "str_location" }, new Object[] { "", Long.valueOf(0L), null, Integer.valueOf(0), "", "" }, AIOQQStoryFeed.class);
    public AIOQQStoryFeedPB.CoverItem msg_covers_info = new AIOQQStoryFeedPB.CoverItem();
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBStringField str_location = PBField.initString("");
    public final PBStringField str_union_id = PBField.initString("");
    public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  }
  
  public static final class CoverItem
    extends MessageMicro<CoverItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "str_cover", "str_content" }, new Object[] { "", "" }, CoverItem.class);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_cover = PBField.initString("");
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_keep_time", "uint32_latest_qzone_time", "msg_aio_feed", "uint64_msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, MsgBody.class);
    public AIOQQStoryFeedPB.AIOQQStoryFeed msg_aio_feed = new AIOQQStoryFeedPB.AIOQQStoryFeed();
    public final PBUInt32Field uint32_keep_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_latest_qzone_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aio.qq_story.feed.AIOQQStoryFeedPB
 * JD-Core Version:    0.7.0.1
 */