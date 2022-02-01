package com.tencent.pb.now;

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

public final class ilive_feeds_tmem
{
  public static final class Chang
    extends MessageMicro<Chang>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field change_type = PBField.initUInt32(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "id", "change_type", "create_time" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, Chang.class);
    }
  }
  
  public static final class ChangFeed
    extends MessageMicro<ChangFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ilive_feeds_tmem.Chang> chang = PBField.initRepeatMessage(ilive_feeds_tmem.Chang.class);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hight = PBField.initUInt32(0);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public ilive_feeds_tmem.Chang replay = new ilive_feeds_tmem.Chang();
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBUInt32Field short_video_num = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field view_num = PBField.initUInt32(0);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58, 64, 72, 80 }, new String[] { "chang", "pic_url", "vid", "width", "hight", "replay", "desc", "short_video_num", "roomid", "view_num" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ChangFeed.class);
    }
  }
  
  public static final class Exposure
    extends MessageMicro<Exposure>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "count" }, new Object[] { Integer.valueOf(0) }, Exposure.class);
    public final PBUInt32Field count = PBField.initUInt32(0);
  }
  
  public static final class FeedLikeStatus
    extends MessageMicro<FeedLikeStatus>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "like_status", "last_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedLikeStatus.class);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBUInt32Field like_status = PBField.initUInt32(0);
  }
  
  public static final class FeedsList
    extends MessageMicro<FeedsList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feedlist" }, new Object[] { null }, FeedsList.class);
    public final PBRepeatMessageField<ilive_feeds_tmem.FeedsListItem> feedlist = PBField.initRepeatMessage(ilive_feeds_tmem.FeedsListItem.class);
  }
  
  public static final class FeedsListItem
    extends MessageMicro<FeedsListItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field feed_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feed_id", "create_time", "feed_status" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, FeedsListItem.class);
    }
  }
  
  public static final class FeedsTmem
    extends MessageMicro<FeedsTmem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bg_color = PBField.initUInt32(0);
    public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public ilive_feeds_tmem.VideoFeed feed_info = new ilive_feeds_tmem.VideoFeed();
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBEnumField feed_status = PBField.initEnum(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public ilive_feeds_tmem.LbsInfoOld lbs_info = new ilive_feeds_tmem.LbsInfoOld();
    public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
    public final PBUInt32Field local_video_flag = PBField.initUInt32(0);
    public final PBUInt64Field nowid = PBField.initUInt64(0L);
    public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
    public final PBUInt64Field publish_uin = PBField.initUInt64(0L);
    public final PBEnumField up_status = PBField.initEnum(1);
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90, 98, 104, 112, 122, 128 }, new String[] { "publish_uin", "create_time", "feed_type", "feed_source", "feed_status", "feeds_id", "feed_info", "view_times", "up_status", "pic_info", "live_info", "chang_info", "nowid", "bg_color", "lbs_info", "local_video_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(1), null, null, null, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, FeedsTmem.class);
    }
  }
  
  public static final class FeedsTmemLike
    extends MessageMicro<FeedsTmemLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "like_number", "like_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FeedsTmemLike.class);
    public final PBRepeatField<Integer> like_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field like_number = PBField.initUInt32(0);
  }
  
  public static final class KInfo
    extends MessageMicro<KInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField song_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "song_name" }, new Object[] { localByteStringMicro }, KInfo.class);
    }
  }
  
  public static final class LbsInfoOld
    extends MessageMicro<LbsInfoOld>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField location = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "lng", "lat", "location" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, LbsInfoOld.class);
    }
  }
  
  public static final class LiveFeed
    extends MessageMicro<LiveFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public ilive_feeds_tmem.KInfo k_info = new ilive_feeds_tmem.KInfo();
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field room_type = PBField.initUInt32(0);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58 }, new String[] { "topic", "desc", "roomid", "pic_url", "vid", "room_type", "k_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null }, LiveFeed.class);
    }
  }
  
  public static final class NoInterest
    extends MessageMicro<NoInterest>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feedid", "type", "count" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, NoInterest.class);
    public final PBInt32Field count = PBField.initInt32(0);
    public final PBStringField feedid = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
  }
  
  public static final class PicFeed
    extends MessageMicro<PicFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ilive_feeds_tmem.PicInfo> infos = PBField.initRepeatMessage(ilive_feeds_tmem.PicInfo.class);
    public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "topic", "desc", "infos", "feed_md5" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, localByteStringMicro3 }, PicFeed.class);
    }
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hight = PBField.initUInt32(0);
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66 }, new String[] { "url", "hight", "width", "file_id", "pic_md5", "lng", "lat", "city" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, PicInfo.class);
    }
  }
  
  public static final class RankBlackFeeds
    extends MessageMicro<RankBlackFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field insert_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "insert_time", "feeds_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RankBlackFeeds.class);
    }
  }
  
  public static final class RecommondItem
    extends MessageMicro<RecommondItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "id", "start_time", "end_time", "recom_pos", "uin_lists_key" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RecommondItem.class);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBStringField id = PBField.initString("");
    public final PBUInt32Field recom_pos = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBStringField uin_lists_key = PBField.initString("");
  }
  
  public static final class RecommondNumPerDay
    extends MessageMicro<RecommondNumPerDay>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "num_per_day" }, new Object[] { Integer.valueOf(0) }, RecommondNumPerDay.class);
    public final PBUInt32Field num_per_day = PBField.initUInt32(0);
  }
  
  public static final class RedInfo
    extends MessageMicro<RedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uid", "time", "last_feed_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, RedInfo.class);
    public final PBUInt64Field last_feed_time = PBField.initUInt64(0L);
    public final PBUInt64Field time = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class TextFeed
    extends MessageMicro<TextFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "text", "topic" }, new Object[] { "", "" }, TextFeed.class);
    public final PBStringField text = PBField.initString("");
    public final PBRepeatField<String> topic = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class TimeLineItem
    extends MessageMicro<TimeLineItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "create_time", "id", "feed_type" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(1) }, TimeLineItem.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBStringField id = PBField.initString("");
  }
  
  public static final class UserActList
    extends MessageMicro<UserActList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field act_uin = PBField.initUInt64(0L);
    public final PBRepeatField<ByteStringMicro> feeds_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_uin", "feeds_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, UserActList.class);
    }
  }
  
  public static final class UserBlackList
    extends MessageMicro<UserBlackList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "act_uin", "black_feeds" }, new Object[] { Long.valueOf(0L), null }, UserBlackList.class);
    public final PBUInt64Field act_uin = PBField.initUInt64(0L);
    public final PBRepeatMessageField<ilive_feeds_tmem.RankBlackFeeds> black_feeds = PBField.initRepeatMessage(ilive_feeds_tmem.RankBlackFeeds.class);
  }
  
  public static final class VideoFeed
    extends MessageMicro<VideoFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field anchor_uin = PBField.initUInt64(0L);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField doodle_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field end_time = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field has_face = PBField.initUInt32(0);
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> topic = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_hight = PBField.initUInt32(0);
    public final PBBytesField video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_time = PBField.initUInt32(0);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_width = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56, 64, 72, 82, 90, 96, 104, 114, 122, 130, 138, 146, 152 }, new String[] { "pic_url", "video_url", "anchor_uin", "topic", "desc", "file_id", "video_width", "video_hight", "video_time", "video_md5", "vid", "start_time", "end_time", "doodle_pic_url", "lng", "lat", "city", "feed_id", "has_face" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0) }, VideoFeed.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_tmem
 * JD-Core Version:    0.7.0.1
 */