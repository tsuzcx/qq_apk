package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SerializationPB
{
  public static final class BannerFeed
    extends MessageMicro<BannerFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField blurb = PBField.initString("");
    public SerializationPB.CommentLikeFeed commet_like_feed = new SerializationPB.CommentLikeFeed();
    public final PBStringField content = PBField.initString("");
    public final PBStringField cover_url = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBStringField schema = PBField.initString("");
    public final PBStringField share_info_content = PBField.initString("");
    public final PBStringField share_info_icon = PBField.initString("");
    public final PBStringField share_info_jump_url = PBField.initString("");
    public final PBStringField share_info_title = PBField.initString("");
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88, 96, 106 }, new String[] { "commet_like_feed", "share_info_title", "share_info_icon", "share_info_content", "share_info_jump_url", "blurb", "schema", "content", "cover_url", "height", "width", "recommend_id", "title_wording" }, new Object[] { null, "", "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, BannerFeed.class);
    }
  }
  
  public static final class CommentLikeFeed
    extends MessageMicro<CommentLikeFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88 }, new String[] { "comment_count", "freind_commnet_count", "fan_comment_count", "comment_is_end", "comment_last_cookie", "like_count", "friend_like_count", "fan_like_count", "had_like", "view_total_time", "deny_comment" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CommentLikeFeed.class);
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBUInt32Field comment_is_end = PBField.initUInt32(0);
    public final PBStringField comment_last_cookie = PBField.initString("");
    public final PBUInt32Field deny_comment = PBField.initUInt32(0);
    public final PBUInt32Field fan_comment_count = PBField.initUInt32(0);
    public final PBUInt32Field fan_like_count = PBField.initUInt32(0);
    public final PBUInt32Field freind_commnet_count = PBField.initUInt32(0);
    public final PBUInt32Field friend_like_count = PBField.initUInt32(0);
    public final PBUInt32Field had_like = PBField.initUInt32(0);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBUInt64Field view_total_time = PBField.initUInt64(0L);
  }
  
  public static final class GeneralRecommendFeed
    extends MessageMicro<GeneralRecommendFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField blurb = PBField.initString("");
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "video_list_feed", "blurb", "recommend_id", "title_wording" }, new Object[] { null, "", Long.valueOf(0L), localByteStringMicro }, GeneralRecommendFeed.class);
    }
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 65, 73, 82, 88, 98, 104, 112 }, new String[] { "id", "path", "thumb", "width", "height", "orientation", "create_time", "lat", "lng", "geo_hash", "state", "mime", "size", "db_create_time" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Double.valueOf(0.0D), Double.valueOf(0.0D), "", Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L) }, PicInfo.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt64Field db_create_time = PBField.initUInt64(0L);
    public final PBStringField geo_hash = PBField.initString("");
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBDoubleField lat = PBField.initDouble(0.0D);
    public final PBDoubleField lng = PBField.initDouble(0.0D);
    public final PBStringField mime = PBField.initString("");
    public final PBUInt32Field orientation = PBField.initUInt32(0);
    public final PBStringField path = PBField.initString("");
    public final PBUInt64Field size = PBField.initUInt64(0L);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBStringField thumb = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class ShareGroupFeed
    extends MessageMicro<ShareGroupFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48 }, new String[] { "video_list_feed", "member_count", "video_count", "des", "group_id", "today_join_member_count" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) }, ShareGroupFeed.class);
    public final PBStringField des = PBField.initString("");
    public final PBStringField group_id = PBField.initString("");
    public final PBUInt32Field member_count = PBField.initUInt32(0);
    public final PBUInt32Field today_join_member_count = PBField.initUInt32(0);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
  }
  
  public static final class ShareGroupRecommendFeed
    extends MessageMicro<ShareGroupRecommendFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField blurb = PBField.initString("");
    public final PBBytesField join_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public SerializationPB.ShareGroupFeed share_group_feed = new SerializationPB.ShareGroupFeed();
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "share_group_feed", "blurb", "join_feed_id", "recommend_id", "title_wording" }, new Object[] { null, "", localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, ShareGroupRecommendFeed.class);
    }
  }
  
  public static final class StoryAlbum
    extends MessageMicro<StoryAlbum>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "geo_hash_list", "pic_list" }, new Object[] { "", null }, StoryAlbum.class);
    public final PBRepeatField<String> geo_hash_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<SerializationPB.PicInfo> pic_list = PBField.initRepeatMessage(SerializationPB.PicInfo.class);
  }
  
  public static final class TagFeed
    extends MessageMicro<TagFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField blur = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field join_count = PBField.initUInt32(0);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBStringField schema = PBField.initString("");
    public final PBStringField tag_desc = PBField.initString("");
    public final PBUInt64Field tag_id = PBField.initUInt64(0L);
    public final PBStringField tag_name = PBField.initString("");
    public final PBUInt32Field tag_type = PBField.initUInt32(0);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    public SerializationPB.VideoListFeed video_list_feed = new SerializationPB.VideoListFeed();
    public final PBStringField wording = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56, 66, 74, 82, 90, 96, 106 }, new String[] { "video_list_feed", "video_count", "tag_id", "tag_name", "tag_desc", "tag_type", "join_count", "wording", "schema", "content", "blur", "recommend_id", "title_wording" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), localByteStringMicro }, TagFeed.class);
    }
  }
  
  public static final class VideoListFeed
    extends MessageMicro<VideoListFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public SerializationPB.CommentLikeFeed commet_like_feed = new SerializationPB.CommentLikeFeed();
    public final PBUInt32Field has_public_video = PBField.initUInt32(0);
    public final PBUInt32Field has_tag = PBField.initUInt32(0);
    public final PBUInt32Field is_contribute = PBField.initUInt32(0);
    public final PBUInt32Field is_video_end = PBField.initUInt32(0);
    public final PBBytesField qim_sync_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField video_next_cookie = PBField.initString("");
    public final PBUInt32Field video_pull_type = PBField.initUInt32(0);
    public final PBUInt32Field video_seq = PBField.initUInt32(0);
    public final PBBytesField ws_schema_main = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField ws_schema_memories = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 74, 82, 90 }, new String[] { "commet_like_feed", "video_next_cookie", "video_pull_type", "is_video_end", "is_contribute", "video_seq", "has_tag", "has_public_video", "qim_sync_wording", "ws_schema_main", "ws_schema_memories" }, new Object[] { null, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, VideoListFeed.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB
 * JD-Core Version:    0.7.0.1
 */