package com.tencent.biz.qqstory.network.pb;

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

public final class qqstory_struct
{
  public static final class ActivityFeedNode
    extends MessageMicro<ActivityFeedNode>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "feed_type", "feed_time", "feed_add_friend", "feed_like", "feed_comment", "feed_vote", "feed_grade", "feed_follow_dav", "feed_new_friend", "feed_qa", "feed_add_frd_n", "feed_follow_dav_n", "feed_frd_add_frd" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null }, ActivityFeedNode.class);
    public qqstory_struct.FeedAddFrd_N feed_add_frd_n = new qqstory_struct.FeedAddFrd_N();
    public qqstory_struct.FeedAddFriend feed_add_friend = new qqstory_struct.FeedAddFriend();
    public qqstory_struct.FeedComment feed_comment = new qqstory_struct.FeedComment();
    public qqstory_struct.FeedFollowDav feed_follow_dav = new qqstory_struct.FeedFollowDav();
    public qqstory_struct.FeedFollowDav_N feed_follow_dav_n = new qqstory_struct.FeedFollowDav_N();
    public qqstory_struct.FeedFrdAddFrd feed_frd_add_frd = new qqstory_struct.FeedFrdAddFrd();
    public qqstory_struct.FeedGrade feed_grade = new qqstory_struct.FeedGrade();
    public qqstory_struct.FeedLike feed_like = new qqstory_struct.FeedLike();
    public qqstory_struct.FeedNewFriend feed_new_friend = new qqstory_struct.FeedNewFriend();
    public qqstory_struct.FeedQA feed_qa = new qqstory_struct.FeedQA();
    public final PBUInt32Field feed_time = PBField.initUInt32(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public qqstory_struct.FeedVote feed_vote = new qqstory_struct.FeedVote();
  }
  
  public static final class Address
    extends MessageMicro<Address>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField building = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField district = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 64, 74, 82 }, new String[] { "street", "province", "city", "country", "building", "coordinate", "gps", "district" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), null, localByteStringMicro6 }, Address.class);
    }
  }
  
  public static final class BannerFeed
    extends MessageMicro<BannerFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField blurb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.BannerShareInfo share_info = new qqstory_struct.BannerShareInfo();
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 42, 48, 56, 66, 74, 82, 88, 96, 106 }, new String[] { "schema", "content", "cover_url", "width", "height", "user", "blurb", "share_info", "date", "recommend_id", "title_wording" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro4, null, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro5 }, BannerFeed.class);
    }
  }
  
  public static final class BannerShareInfo
    extends MessageMicro<BannerShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "title", "content", "icon", "jump_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, BannerShareInfo.class);
    }
  }
  
  public static final class BigVColleciton
    extends MessageMicro<BigVColleciton>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field fans = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBytesField logo = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56 }, new String[] { "id", "user", "cover", "logo", "color", "desc", "fans" }, new Object[] { Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, BigVColleciton.class);
    }
  }
  
  public static final class CardInfo
    extends MessageMicro<CardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField card_type = PBField.initEnum(1);
    public qqstory_struct.GatherCardInfo gather_card = new qqstory_struct.GatherCardInfo();
    public qqstory_struct.NearbyCardInfo nearby_card = new qqstory_struct.NearbyCardInfo();
    public qqstory_struct.NormalCardInfo normal_card = new qqstory_struct.NormalCardInfo();
    public qqstory_struct.OperationCardInfo operation_card = new qqstory_struct.OperationCardInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50 }, new String[] { "card_id", "card_type", "normal_card", "nearby_card", "operation_card", "gather_card" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, null, null, null }, CardInfo.class);
    }
  }
  
  public static final class CardVideoInfo
    extends MessageMicro<CardVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field total_like_num = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field view_total_num = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "vid", "video_cover", "label", "view_total_num", "total_like_num", "total_comment_num", "feed_id", "vid_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, CardVideoInfo.class);
    }
  }
  
  public static final class ClickUrlInfo
    extends MessageMicro<ClickUrlInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field color = PBField.initUInt32(0);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBytesField logo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "id", "url", "cover", "logo", "color", "desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, ClickUrlInfo.class);
    }
  }
  
  public static final class CompInfoBase
    extends MessageMicro<CompInfoBase>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "title", "backgroud_url", "compared_vid", "is_compared_able", "oa_task_id", "icon_url" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), "" }, CompInfoBase.class);
    public final PBStringField backgroud_url = PBField.initString("");
    public final PBStringField compared_vid = PBField.initString("");
    public final PBStringField icon_url = PBField.initString("");
    public final PBUInt32Field is_compared_able = PBField.initUInt32(0);
    public final PBUInt32Field oa_task_id = PBField.initUInt32(0);
    public final PBStringField title = PBField.initString("");
  }
  
  public static final class DateVideoCollection
    extends MessageMicro<DateVideoCollection>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField address = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field collection_id = PBField.initUInt32(0);
    public final PBUInt64Field collection_time = PBField.initUInt64(0L);
    public final PBUInt32Field collection_type = PBField.initUInt32(0);
    public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
    public final PBUInt32Field total_view_count = PBField.initUInt32(0);
    public final PBUInt32Field total_view_times = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoSimpleInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoSimpleInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 96 }, new String[] { "collection_id", "collection_type", "collection_time", "collection_video_count", "video_list", "vid_list", "label", "address", "total_view_count", "total_view_times", "feed_id", "share_to_discover" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, DateVideoCollection.class);
    }
  }
  
  public static final class DateVideoCollectionID
    extends MessageMicro<DateVideoCollectionID>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field collection_id = PBField.initUInt32(0);
    public final PBUInt32Field collection_type = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "collection_id", "collection_type", "feed_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, DateVideoCollectionID.class);
    }
  }
  
  public static final class DiscoveryShareGroupInfo
    extends MessageMicro<DiscoveryShareGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "group", "video_info" }, new Object[] { null, null }, DiscoveryShareGroupInfo.class);
    public qqstory_struct.ShareGroupInfo group = new qqstory_struct.ShareGroupInfo();
    public final PBRepeatMessageField<qqstory_struct.DiscoveryShareGroupVideoInfo> video_info = PBField.initRepeatMessage(qqstory_struct.DiscoveryShareGroupVideoInfo.class);
  }
  
  public static final class DiscoveryShareGroupVideoInfo
    extends MessageMicro<DiscoveryShareGroupVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field time = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "video_cover", "vid", "time", "video_attr", "feed_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4 }, DiscoveryShareGroupVideoInfo.class);
    }
  }
  
  public static final class Emoticon
    extends MessageMicro<Emoticon>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "icon" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, Emoticon.class);
    }
  }
  
  public static final class EmoticonPack
    extends MessageMicro<EmoticonPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField download_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pack_id = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 66, 74 }, new String[] { "pack_id", "icon", "name", "download_url", "type", "md5", "version", "download_icon", "config" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(1), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6 }, EmoticonPack.class);
    }
  }
  
  public static final class ErrorInfo
    extends MessageMicro<ErrorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field error_code = PBField.initUInt32(0);
    public final PBBytesField error_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "error_code", "error_desc" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ErrorInfo.class);
    }
  }
  
  public static final class FeedAddFrd_N
    extends MessageMicro<FeedAddFrd_N>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from_uid", "to_uid_list" }, new Object[] { null, null }, FeedAddFrd_N.class);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public final PBRepeatMessageField<qqstory_struct.UserInfo> to_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  }
  
  public static final class FeedAddFriend
    extends MessageMicro<FeedAddFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> from_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    public final PBUInt32Field from_uid_num = PBField.initUInt32(0);
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "from_uid_num", "from_uid_list", "to_uid", "feed_id", "video_isend", "video_next", "video_list" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FeedAddFriend.class);
    }
  }
  
  public static final class FeedComment
    extends MessageMicro<FeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58 }, new String[] { "from_uid", "to_uid", "feed_id", "video_isend", "video_next", "video_list", "comment_content" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, FeedComment.class);
    }
  }
  
  public static final class FeedCommentAtVideoInfo
    extends MessageMicro<FeedCommentAtVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field length = PBField.initUInt32(0);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBUInt32Field start_index = PBField.initUInt32(0);
    public final PBInt32Field timezone_offset = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48 }, new String[] { "timezone_offset", "create_time", "union_id", "start_index", "length", "role" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedCommentAtVideoInfo.class);
    }
  }
  
  public static final class FeedCommentInfo
    extends MessageMicro<FeedCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.StoryVideoCommentInfo> comment_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoCommentInfo.class);
    public final PBUInt32Field comment_total_num = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "feed_id", "comment_list", "comment_total_num", "is_end", "next_cookie" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, FeedCommentInfo.class);
    }
  }
  
  public static final class FeedFeature
    extends MessageMicro<FeedFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field deny_comment = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field has_like = PBField.initUInt32(0);
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field total_like_num = PBField.initUInt32(0);
    public final PBUInt32Field total_viewing_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48 }, new String[] { "feed_id", "total_comment_num", "total_like_num", "total_viewing_num", "has_like", "deny_comment" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedFeature.class);
    }
  }
  
  public static final class FeedFollowDav
    extends MessageMicro<FeedFollowDav>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> from_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    public final PBUInt32Field from_uid_num = PBField.initUInt32(0);
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "from_uid_num", "from_uid_list", "to_uid", "feed_id", "video_isend", "video_next", "video_list" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FeedFollowDav.class);
    }
  }
  
  public static final class FeedFollowDav_N
    extends MessageMicro<FeedFollowDav_N>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from_uid", "to_uid_list" }, new Object[] { null, null }, FeedFollowDav_N.class);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public final PBRepeatMessageField<qqstory_struct.UserInfo> to_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  }
  
  public static final class FeedFrdAddFrd
    extends MessageMicro<FeedFrdAddFrd>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "from_uid", "to_uid" }, new Object[] { null, null }, FeedFrdAddFrd.class);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
  }
  
  public static final class FeedGrade
    extends MessageMicro<FeedGrade>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public final PBInt32Field grade_result = PBField.initInt32(0);
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 56 }, new String[] { "from_uid", "to_uid", "feed_id", "video_isend", "video_next", "video_list", "grade_result" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0) }, FeedGrade.class);
    }
  }
  
  public static final class FeedInfo
    extends MessageMicro<FeedInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField feed_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pull_type = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88 }, new String[] { "user", "date", "feed_attr", "feed_video_info_list", "next_cookie", "seq", "feed_id", "is_end", "pull_type", "video_total", "share_to_discover" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FeedInfo.class);
    }
  }
  
  public static final class FeedLike
    extends MessageMicro<FeedLike>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> from_uid_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    public final PBUInt32Field from_uid_num = PBField.initUInt32(0);
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "from_uid_num", "from_uid_list", "to_uid", "feed_id", "video_isend", "video_next", "video_list" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FeedLike.class);
    }
  }
  
  public static final class FeedLikeInfo
    extends MessageMicro<FeedLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field has_like = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoLikeInfo> like_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoLikeInfo.class);
    public final PBUInt32Field like_total_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feed_id", "like_list", "like_total_count", "has_like" }, new Object[] { localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, FeedLikeInfo.class);
    }
  }
  
  public static final class FeedNewFriend
    extends MessageMicro<FeedNewFriend>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "from_type", "from_uid", "to_uid", "feed_id", "video_isend", "video_next", "video_list" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FeedNewFriend.class);
    }
  }
  
  public static final class FeedQA
    extends MessageMicro<FeedQA>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public final PBBytesField qa_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58 }, new String[] { "from_uid", "to_uid", "feed_id", "video_isend", "video_next", "video_list", "qa_result" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, FeedQA.class);
    }
  }
  
  public static final class FeedSeqInfo
    extends MessageMicro<FeedSeqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_playable = PBField.initUInt32(0);
    public final PBUInt32Field rcmd_more = PBField.initUInt32(0);
    public final PBBytesField rcmd_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 58 }, new String[] { "feed_id", "seq", "union_id", "date", "is_playable", "rcmd_more", "rcmd_word" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, FeedSeqInfo.class);
    }
  }
  
  public static final class FeedVideoInfo
    extends MessageMicro<FeedVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field time = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "video_cover", "vid", "time", "video_attr", "video_tag", "video_extern_link_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, null, localByteStringMicro4 }, FeedVideoInfo.class);
    }
  }
  
  public static final class FeedVote
    extends MessageMicro<FeedVote>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo from_uid = new qqstory_struct.UserInfo();
    public qqstory_struct.UserInfo to_uid = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_isend = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field video_next = PBField.initUInt32(0);
    public final PBBytesField vote_result = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 58 }, new String[] { "from_uid", "to_uid", "feed_id", "video_isend", "video_next", "video_list", "vote_result" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, FeedVote.class);
    }
  }
  
  public static final class FilterListPack
    extends MessageMicro<FilterListPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField filter_config_file = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField filter_config_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field filter_id = PBField.initUInt64(0L);
    public final PBBytesField filter_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field filter_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "filter_id", "filter_name", "filter_type", "filter_config_file", "filter_config_md5" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, FilterListPack.class);
    }
  }
  
  public static final class FriendStoryDes
    extends MessageMicro<FriendStoryDes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "des", "simple_info_list", "user_seq_info" }, new Object[] { null, null, null }, FriendStoryDes.class);
    public qqstory_struct.StoryDes des = new qqstory_struct.StoryDes();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoSimpleInfo> simple_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoSimpleInfo.class);
    public qqstory_struct.UserSeqInfo user_seq_info = new qqstory_struct.UserSeqInfo();
  }
  
  public static final class GatherCardInfo
    extends MessageMicro<GatherCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field join_num = PBField.initUInt32(0);
    public final PBUInt32Field rsp_type = PBField.initUInt32(0);
    public final PBBytesField rsp_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField topic_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
    public final PBBytesField topic_label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 58 }, new String[] { "topic_id", "topic_name", "topic_cover", "topic_label", "join_num", "rsp_type", "rsp_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4 }, GatherCardInfo.class);
    }
  }
  
  public static final class GeneralFeed
    extends MessageMicro<GeneralFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField feed_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
    public final PBUInt32Field hasVideoTag = PBField.initUInt32(0);
    public final PBUInt32Field has_public_video = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pull_type = PBField.initUInt32(0);
    public final PBBytesField qim_sync_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_total = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> ws_schemas = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 48, 58, 64, 72, 80, 88, 96, 104, 114, 122 }, new String[] { "user", "date", "feed_attr", "feed_video_info_list", "next_cookie", "seq", "feed_id", "is_end", "pull_type", "video_total", "share_to_discover", "hasVideoTag", "has_public_video", "qim_sync_wording", "ws_schemas" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, GeneralFeed.class);
    }
  }
  
  public static final class GeneralRecommendFeed
    extends MessageMicro<GeneralRecommendFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField blurb = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.GeneralFeed recommend_feed = new qqstory_struct.GeneralFeed();
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "recommend_feed", "blurb", "recommend_id", "title_wording" }, new Object[] { null, localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2 }, GeneralRecommendFeed.class);
    }
  }
  
  public static final class GpsMsg
    extends MessageMicro<GpsMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "lat", "lng" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GpsMsg.class);
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lng = PBField.initInt32(0);
  }
  
  public static final class GroupId
    extends MessageMicro<GroupId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBBytesField group_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "err_code", "group_uin", "group_union_id" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, GroupId.class);
    }
  }
  
  public static final class GroupNodeInfo
    extends MessageMicro<GroupNodeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field feed_time = PBField.initUInt64(0L);
    public final PBUInt32Field feed_type = PBField.initUInt32(0);
    public final PBUInt32Field feed_video_total = PBField.initUInt32(0);
    public final PBUInt32Field isend = PBField.initUInt32(0);
    public final PBBytesField more_start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> storyid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<qqstory_struct.GroupStoryInfo> video_list = PBField.initRepeatMessage(qqstory_struct.GroupStoryInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66 }, new String[] { "feed_id", "feed_type", "feed_time", "feed_video_total", "video_list", "storyid_list", "isend", "more_start_cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, GroupNodeInfo.class);
    }
  }
  
  public static final class GroupStoryInfo
    extends MessageMicro<GroupStoryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField author_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field vid_time = PBField.initUInt64(0L);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "video_cover", "vid", "story_id", "vid_time", "author_uin", "video_source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Integer.valueOf(0) }, GroupStoryInfo.class);
    }
  }
  
  public static final class GroupVideoBasicInfo
    extends MessageMicro<GroupVideoBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56, 66 }, new String[] { "author", "msg_time", "file_id", "video_vid", "group_gid", "story_source", "duration", "video_attr" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, GroupVideoBasicInfo.class);
    public final PBUInt64Field author = PBField.initUInt64(0L);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBStringField file_id = PBField.initString("");
    public final PBUInt64Field group_gid = PBField.initUInt64(0L);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field story_source = PBField.initUInt32(0);
    public final PBStringField video_attr = PBField.initString("");
    public final PBStringField video_vid = PBField.initString("");
  }
  
  public static final class HotTopicPack
    extends MessageMicro<HotTopicPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_join = PBField.initUInt32(0);
    public final PBUInt32Field topic_color = PBField.initUInt32(0);
    public final PBBytesField topic_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField topic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
    public final PBBytesField topic_logo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField topic_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56 }, new String[] { "topic_id", "topic_name", "topic_cover", "topic_color", "topic_logo", "topic_desc", "is_join" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, HotTopicPack.class);
    }
  }
  
  public static final class IconInfo
    extends MessageMicro<IconInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UsrIcon> usr_icon_list = PBField.initRepeatMessage(qqstory_struct.UsrIcon.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "err_code", "union_id", "usr_icon_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, IconInfo.class);
    }
  }
  
  public static final class InteractPasterInfo
    extends MessageMicro<InteractPasterInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "paster_type", "paster_contents" }, new Object[] { Integer.valueOf(0), "" }, InteractPasterInfo.class);
    public final PBRepeatField<String> paster_contents = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field paster_type = PBField.initUInt32(0);
  }
  
  public static final class LiveVideoDes
    extends MessageMicro<LiveVideoDes>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from_id = PBField.initUInt32(0);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt64Field start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "room_id", "start_time", "from_id", "cover_url" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, LiveVideoDes.class);
    }
  }
  
  public static final class LoadMoreReqNode
    extends MessageMicro<LoadMoreReqNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field start = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id", "start" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, LoadMoreReqNode.class);
    }
  }
  
  public static final class LoadMoreRspNode
    extends MessageMicro<LoadMoreRspNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "feed_id", "is_end", "next", "video_list" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, LoadMoreRspNode.class);
    }
  }
  
  public static final class LoginSig
    extends MessageMicro<LoginSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_type", "bytes_sig", "uint32_appid" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, LoginSig.class);
    }
  }
  
  public static final class MultiRecommend
    extends MessageMicro<MultiRecommend>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField rcmd_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.MultiRecommendItem> recommend_feed = PBField.initRepeatMessage(qqstory_struct.MultiRecommendItem.class);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field top_location = PBField.initUInt32(0);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 66, 74 }, new String[] { "recommend_feed", "recommend_id", "top_location", "next_cookie", "is_end", "seq", "date", "user", "rcmd_word" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, MultiRecommend.class);
    }
  }
  
  public static final class MultiRecommendItem
    extends MessageMicro<MultiRecommendItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
    public final PBStringField rcmd_wording = PBField.initString("");
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user", "feed_video_info_list", "rcmd_wording", "feed_id" }, new Object[] { null, null, "", localByteStringMicro }, MultiRecommendItem.class);
    }
  }
  
  public static final class MusicConfigInfo
    extends MessageMicro<MusicConfigInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField audio_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBBytesField image_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56 }, new String[] { "id", "title", "desc", "audio_url", "image_url", "share_url", "duration" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, MusicConfigInfo.class);
    }
  }
  
  public static final class NearbyCardInfo
    extends MessageMicro<NearbyCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.NormalCardInfo card_info = new qqstory_struct.NormalCardInfo();
    public final PBBytesField distance = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_info", "distance" }, new Object[] { null, localByteStringMicro }, NearbyCardInfo.class);
    }
  }
  
  public static final class NormalCardInfo
    extends MessageMicro<NormalCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "owner", "story_video_info" }, new Object[] { null, null }, NormalCardInfo.class);
    public qqstory_struct.UserInfo owner = new qqstory_struct.UserInfo();
    public final PBRepeatMessageField<qqstory_struct.CardVideoInfo> story_video_info = PBField.initRepeatMessage(qqstory_struct.CardVideoInfo.class);
  }
  
  public static final class OperationCardInfo
    extends MessageMicro<OperationCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.NormalCardInfo card_info = new qqstory_struct.NormalCardInfo();
    public final PBBytesField operation_label = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "card_info", "operation_label" }, new Object[] { null, localByteStringMicro }, OperationCardInfo.class);
    }
  }
  
  public static final class POIPosterData
    extends MessageMicro<POIPosterData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField poster_json_layout_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField poster_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField poster_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField thumb_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 82 }, new String[] { "thumb_url", "poster_name", "poster_url", "name", "poster_json_layout_desc" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, POIPosterData.class);
    }
  }
  
  public static final class PicSpecs
    extends MessageMicro<PicSpecs>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField pic_bid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> pic_spec = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "pic_bid", "pic_spec" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, PicSpecs.class);
    }
  }
  
  public static final class PreloadInfo
    extends MessageMicro<PreloadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "union_id", "topic_id", "video_list" }, new Object[] { localByteStringMicro, Long.valueOf(0L), null }, PreloadInfo.class);
    }
  }
  
  public static final class PreloadVideoInfo
    extends MessageMicro<PreloadVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field id = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "id", "video_list", "union_id" }, new Object[] { Long.valueOf(0L), null, localByteStringMicro }, PreloadVideoInfo.class);
    }
  }
  
  public static final class QimVideoInfo
    extends MessageMicro<QimVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField qim_feedID = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField qim_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField qim_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "qim_vid", "qim_unionid", "qim_feedID" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, QimVideoInfo.class);
    }
  }
  
  public static final class RecommendItem
    extends MessageMicro<RecommendItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "type", "topic_info", "bigv_info", "url_info", "item_id" }, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, RecommendItem.class);
    public qqstory_struct.BigVColleciton bigv_info = new qqstory_struct.BigVColleciton();
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public qqstory_struct.HotTopicPack topic_info = new qqstory_struct.HotTopicPack();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public qqstory_struct.ClickUrlInfo url_info = new qqstory_struct.ClickUrlInfo();
  }
  
  public static final class ShareGroupBasicInfo
    extends MessageMicro<ShareGroupBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64, 72 }, new String[] { "shared_group_id", "name", "owner", "header_unionid_list", "allow_stranger_visit_and_post", "background_url", "type", "group_code", "has_disband" }, new Object[] { "", "", "", "", Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ShareGroupBasicInfo.class);
    public final PBUInt32Field allow_stranger_visit_and_post = PBField.initUInt32(0);
    public final PBStringField background_url = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBUInt32Field has_disband = PBField.initUInt32(0);
    public final PBRepeatField<String> header_unionid_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField name = PBField.initString("");
    public final PBStringField owner = PBField.initString("");
    public final PBStringField shared_group_id = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ShareGroupExtInfo
    extends MessageMicro<ShareGroupExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "has_join", "total_members", "total_videos", "owner_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ShareGroupExtInfo.class);
    public final PBUInt32Field has_join = PBField.initUInt32(0);
    public final PBUInt32Field owner_type = PBField.initUInt32(0);
    public final PBUInt32Field total_members = PBField.initUInt32(0);
    public final PBUInt32Field total_videos = PBField.initUInt32(0);
  }
  
  public static final class ShareGroupFeed
    extends MessageMicro<ShareGroupFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField des = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ShareGroupInfo info = new qqstory_struct.ShareGroupInfo();
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pull_type = PBField.initUInt32(0);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> today_new_member = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    public final PBRepeatMessageField<qqstory_struct.ShareGroupVideoInfo> video_list = PBField.initRepeatMessage(qqstory_struct.ShareGroupVideoInfo.class);
    public final PBUInt32Field video_total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 34, 42, 48, 56, 64, 74, 96, 106 }, new String[] { "date", "info", "video_list", "next_cookie", "is_end", "seq", "video_total", "des", "pull_type", "today_new_member" }, new Object[] { Integer.valueOf(0), null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), null }, ShareGroupFeed.class);
    }
  }
  
  public static final class ShareGroupInfo
    extends MessageMicro<ShareGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "basic_info", "ext_info" }, new Object[] { null, null }, ShareGroupInfo.class);
    public qqstory_struct.ShareGroupBasicInfo basic_info = new qqstory_struct.ShareGroupBasicInfo();
    public qqstory_struct.ShareGroupExtInfo ext_info = new qqstory_struct.ShareGroupExtInfo();
  }
  
  public static final class ShareGroupRecommendFeed
    extends MessageMicro<ShareGroupRecommendFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField blurb = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField join_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ShareGroupFeed recommend_feed = new qqstory_struct.ShareGroupFeed();
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "recommend_feed", "blurb", "join_feed_id", "recommend_id", "title_wording" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3 }, ShareGroupRecommendFeed.class);
    }
  }
  
  public static final class ShareGroupVideoInfo
    extends MessageMicro<ShareGroupVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField owenr_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.FeedVideoInfo video_info = new qqstory_struct.FeedVideoInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "video_info", "owenr_name", "union_id", "feed_id" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ShareGroupVideoInfo.class);
    }
  }
  
  public static final class SquareBannerItem
    extends MessageMicro<SquareBannerItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField item_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_target_action = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "item_id", "image", "jump_target_action" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SquareBannerItem.class);
    }
  }
  
  public static final class StoryDayNode
    extends MessageMicro<StoryDayNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field feed_date = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "feed_id", "feed_date", "video_count", "cover" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, StoryDayNode.class);
    }
  }
  
  public static final class StoryDes
    extends MessageMicro<StoryDes>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field has_unwatched_video = PBField.initUInt32(0);
    public qqstory_struct.LiveVideoDes live_video = new qqstory_struct.LiveVideoDes();
    public final PBUInt64Field new_story_time = PBField.initUInt64(0L);
    public final PBBytesField storyCover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField story_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField story_video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 66 }, new String[] { "user", "storyCover", "new_story_time", "has_unwatched_video", "video_count", "live_video", "story_title", "story_video_attr" }, new Object[] { null, localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2, localByteStringMicro3 }, StoryDes.class);
    }
  }
  
  public static final class StoryFeed
    extends MessageMicro<StoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field additional_feed = PBField.initUInt32(0);
    public qqstory_struct.BannerFeed banner_feed = new qqstory_struct.BannerFeed();
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field feed_source_tag_type = PBField.initUInt32(0);
    public qqstory_struct.GeneralFeed general_feed = new qqstory_struct.GeneralFeed();
    public qqstory_struct.GeneralRecommendFeed general_recommend_feed = new qqstory_struct.GeneralRecommendFeed();
    public qqstory_struct.MultiRecommend multi_recommend_feed = new qqstory_struct.MultiRecommend();
    public qqstory_struct.ShareGroupFeed share_group_feed = new qqstory_struct.ShareGroupFeed();
    public qqstory_struct.ShareGroupRecommendFeed share_group_recommend_feed = new qqstory_struct.ShareGroupRecommendFeed();
    public qqstory_struct.TagFeed tag_feed = new qqstory_struct.TagFeed();
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 80, 88 }, new String[] { "type", "feed_id", "general_feed", "share_group_feed", "general_recommend_feed", "share_group_recommend_feed", "banner_feed", "tag_feed", "multi_recommend_feed", "additional_feed", "feed_source_tag_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, StoryFeed.class);
    }
  }
  
  public static final class StoryReqInfo
    extends MessageMicro<StoryReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "ret_user_info", "union_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, StoryReqInfo.class);
    }
  }
  
  public static final class StoryVideoBasicInfo
    extends MessageMicro<StoryVideoBasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.Address address = new qqstory_struct.Address();
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
    public final PBUInt32Field has_related_videos = PBField.initUInt32(0);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField owner_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField poll_text = PBField.initString("");
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field video_index = PBField.initUInt64(0L);
    public final PBUInt32Field video_source = PBField.initUInt32(0);
    public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
    public final PBUInt64Field video_total_time = PBField.initUInt64(0L);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 66, 72, 82, 88, 130, 138, 144, 154, 160, 170, 176, 194, 202 }, new String[] { "vid", "video_url", "video_cover", "title", "doodle_url", "create_time", "label", "video_total_time", "address", "has_related_videos", "video_attr", "owner_union_id", "ban_type", "group_list", "video_source", "video_tag", "video_index", "poll_text", "poll_options" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), null, Integer.valueOf(0), null, Long.valueOf(0L), "", "" }, StoryVideoBasicInfo.class);
    }
  }
  
  public static final class StoryVideoCommentInfo
    extends MessageMicro<StoryVideoCommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedCommentAtVideoInfo> at_video_info = PBField.initRepeatMessage(qqstory_struct.FeedCommentAtVideoInfo.class);
    public final PBUInt32Field at_video_shoot_time = PBField.initUInt32(0);
    public final PBUInt32Field author_role = PBField.initUInt32(0);
    public final PBUInt64Field author_uid = PBField.initUInt64(0L);
    public final PBStringField author_union_id = PBField.initString("");
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField extras = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field reply_role = PBField.initUInt32(0);
    public final PBUInt64Field reply_time = PBField.initUInt64(0L);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
    public final PBStringField reply_union_id = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 82, 90, 96, 106, 114, 122, 128 }, new String[] { "comment_id", "reply_uid", "author_uid", "reply_time", "content", "fake_id", "author_role", "author_union_id", "reply_role", "reply_union_id", "at_video_info", "type", "extras", "vid", "feed_id", "at_video_shoot_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), "", Integer.valueOf(0), "", null, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, StoryVideoCommentInfo.class);
    }
  }
  
  public static final class StoryVideoDes
    extends MessageMicro<StoryVideoDes>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.Address address = new qqstory_struct.Address();
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field has_like = PBField.initUInt32(0);
    public final PBUInt32Field has_related_videos = PBField.initUInt32(0);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfo owner = new qqstory_struct.UserInfo();
    public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total_like_num = PBField.initUInt32(0);
    public final PBUInt32Field uncheck_like_num = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field video_total_time = PBField.initUInt64(0L);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field view_total_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 66, 72, 82, 88, 130, 138, 144, 152, 160, 168, 176 }, new String[] { "vid", "video_url", "video_cover", "title", "doodle_url", "create_time", "view_total_num", "label", "video_total_time", "address", "has_related_videos", "video_attr", "owner", "stranger_view_total_num", "has_like", "uncheck_like_num", "total_like_num", "ban_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro7, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, StoryVideoDes.class);
    }
  }
  
  public static final class StoryVideoFeature
    extends MessageMicro<StoryVideoFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field deny_comment = PBField.initUInt32(0);
    public final PBUInt32Field has_like = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoLikeInfo> newest_like_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoLikeInfo.class);
    public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
    public final PBUInt32Field total_like_num = PBField.initUInt32(0);
    public final PBUInt32Field uncheck_like_num = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field viewer_total_num = PBField.initUInt32(0);
    public final PBUInt32Field viewing_total_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 66, 72, 80 }, new String[] { "vid", "viewer_total_num", "stranger_view_total_num", "has_like", "uncheck_like_num", "total_like_num", "total_comment_num", "newest_like_list", "deny_comment", "viewing_total_num" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, StoryVideoFeature.class);
    }
  }
  
  public static final class StoryVideoFullInfo
    extends MessageMicro<StoryVideoFullInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public final PBBytesField compared_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.VideoUrl> compressed_video = PBField.initRepeatMessage(qqstory_struct.VideoUrl.class);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field duration = PBField.initUInt64(0L);
    public final PBUInt32Field error = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
    public qqstory_struct.InteractPasterInfo interact_paster_info = new qqstory_struct.InteractPasterInfo();
    public final PBStringField original_author_id = PBField.initString("");
    public final PBBytesField original_author_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field player_scale_type = PBField.initUInt32(0);
    public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField poll_text = PBField.initString("");
    public qqstory_struct.QimVideoInfo qim_video_info = new qqstory_struct.QimVideoInfo();
    public final PBUInt32Field source_type = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field url_flag = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field video_index = PBField.initUInt64(0L);
    public final PBUInt32Field video_source = PBField.initUInt32(0);
    public final PBUInt32Field video_source_tag_type = PBField.initUInt32(0);
    public qqstory_struct.TagInfoBase video_tag = new qqstory_struct.TagInfoBase();
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_url_expire_time = PBField.initUInt32(0);
    public final PBBytesField ws_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 64, 72, 82, 88, 98, 104, 112, 120, 130, 136, 146, 154, 162, 170, 178, 184, 192, 202, 208, 218, 226, 234, 242, 248 }, new String[] { "error", "vid", "type", "union_id", "video_url", "video_cover", "doodle_url", "create_time", "duration", "video_attr", "ban_type", "group_list", "video_source", "url_flag", "group_id", "video_tag", "video_index", "poll_text", "poll_options", "compressed_video", "qim_video_info", "interact_paster_info", "source_type", "player_scale_type", "ws_schema", "video_url_expire_time", "original_author_id", "original_author_name", "video_extern_link_attr", "compared_vid", "video_source_tag_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro6, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), "", "", null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), "", localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0) }, StoryVideoFullInfo.class);
    }
  }
  
  public static final class StoryVideoLikeInfo
    extends MessageMicro<StoryVideoLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uid", "like_time", "role", "union_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, StoryVideoLikeInfo.class);
    public final PBUInt64Field like_time = PBField.initUInt64(0L);
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBStringField union_id = PBField.initString("");
  }
  
  public static final class StoryVideoSimpleInfo
    extends MessageMicro<StoryVideoSimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 34, 40, 50, 58 }, new String[] { "video_cover", "vid", "group_list", "ban_type", "union_id", "video_attr" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, StoryVideoSimpleInfo.class);
    }
  }
  
  public static final class StoryVideoTotalInfo
    extends MessageMicro<StoryVideoTotalInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "feature", "basic_info" }, new Object[] { null, null }, StoryVideoTotalInfo.class);
    public qqstory_struct.StoryVideoBasicInfo basic_info = new qqstory_struct.StoryVideoBasicInfo();
    public qqstory_struct.StoryVideoFeature feature = new qqstory_struct.StoryVideoFeature();
  }
  
  public static final class TagFeed
    extends MessageMicro<TagFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField blur = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField schema = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public qqstory_struct.TagItem tag_item = new qqstory_struct.TagItem();
    public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.TagVideoInfo> video_list = PBField.initRepeatMessage(qqstory_struct.TagVideoInfo.class);
    public final PBUInt32Field video_total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 98 }, new String[] { "tag_item", "video_list", "next_cookie", "is_end", "seq", "video_total", "date", "schema", "content", "blur", "recommend_id", "title_wording" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5 }, TagFeed.class);
    }
  }
  
  public static final class TagInfoBase
    extends MessageMicro<TagInfoBase>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "tag_id", "tag_name", "tag_desc", "tag_type" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, TagInfoBase.class);
    public final PBStringField tag_desc = PBField.initString("");
    public final PBUInt64Field tag_id = PBField.initUInt64(0L);
    public final PBStringField tag_name = PBField.initString("");
    public final PBUInt32Field tag_type = PBField.initUInt32(0);
  }
  
  public static final class TagInfoBaseList
    extends MessageMicro<TagInfoBaseList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.TagInfoBase> tag_info_list = PBField.initRepeatMessage(qqstory_struct.TagInfoBase.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tag_info_list", "feed_id" }, new Object[] { null, localByteStringMicro }, TagInfoBaseList.class);
    }
  }
  
  public static final class TagInfoBaseVidList
    extends MessageMicro<TagInfoBaseVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.CompInfoBase comp_info = new qqstory_struct.CompInfoBase();
    public final PBBytesField extern_config_json = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "vid", "tag_info", "comp_info", "extern_config_json" }, new Object[] { localByteStringMicro1, null, null, localByteStringMicro2 }, TagInfoBaseVidList.class);
    }
  }
  
  public static final class TagItem
    extends MessageMicro<TagItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "base_info", "join_count", "wording" }, new Object[] { null, Integer.valueOf(0), "" }, TagItem.class);
    public qqstory_struct.TagInfoBase base_info = new qqstory_struct.TagInfoBase();
    public final PBUInt32Field join_count = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
  }
  
  public static final class TagVideoInfo
    extends MessageMicro<TagVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField owner_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.FeedVideoInfo video_Info = new qqstory_struct.FeedVideoInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "video_Info", "owner_name", "union_id", "feed_id" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, TagVideoInfo.class);
    }
  }
  
  public static final class UnWatchStoryDes
    extends MessageMicro<UnWatchStoryDes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "des", "latest_video_list", "user_seq_info", "unwatch_count" }, new Object[] { null, null, null, Integer.valueOf(0) }, UnWatchStoryDes.class);
    public qqstory_struct.StoryDes des = new qqstory_struct.StoryDes();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> latest_video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    public final PBUInt32Field unwatch_count = PBField.initUInt32(0);
    public qqstory_struct.UserSeqInfo user_seq_info = new qqstory_struct.UserSeqInfo();
  }
  
  public static final class UserConfig
    extends MessageMicro<UserConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field config_value = PBField.initUInt32(0);
    public final PBBytesField config_value_bytes = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "config_key", "config_value", "config_value_bytes" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, UserConfig.class);
    }
  }
  
  public static final class UserId
    extends MessageMicro<UserId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid", "union_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, UserId.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBBytesField background_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.UserInfoExt ext = new qqstory_struct.UserInfoExt();
    public final PBUInt32Field fans_count = PBField.initUInt32(0);
    public final PBUInt32Field fans_incr_count = PBField.initUInt32(0);
    public final PBUInt32Field friend_type = PBField.initUInt32(0);
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBUInt64Field gid_in_group = PBField.initUInt64(0L);
    public final PBInt32Field grade_speed = PBField.initInt32(0);
    public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
    public final PBUInt32Field is_vip = PBField.initUInt32(0);
    public final PBInt32Field medal_level = PBField.initInt32(0);
    public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField phone = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field subscribe_count = PBField.initUInt32(0);
    public final PBBytesField symbol = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UsrIcon> usr_icon_list = PBField.initRepeatMessage(qqstory_struct.UsrIcon.class);
    public final PBUInt32Field video_source_tag_type = PBField.initUInt32(0);
    public final PBUInt64Field vip_id = PBField.initUInt64(0L);
    public qqstory_struct.WatcherExt watcher = new qqstory_struct.WatcherExt();
    public final PBBytesField ws_schema = PBField.initBytes(ByteStringMicro.EMPTY);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 80, 88, 96, 104, 114, 122, 128, 136, 146, 152, 162, 170, 178, 184, 192, 202, 208, 216, 224 }, new String[] { "uid", "nick", "head_url", "remark", "ext", "is_vip", "union_id", "symbol", "watcher", "is_subscribe", "friend_type", "fans_count", "subscribe_count", "signature", "background_url", "fans_incr_count", "gid_in_group", "usr_icon_list", "vip_id", "phone", "nick_postfix", "ws_schema", "gender", "age", "desc", "medal_level", "grade_speed", "video_source_tag_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfo.class);
    }
  }
  
  public static final class UserInfoExt
    extends MessageMicro<UserInfoExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "my_story_forbidden", "his_story_forbidden", "deny_comment" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserInfoExt.class);
    public final PBUInt32Field deny_comment = PBField.initUInt32(0);
    public final PBUInt32Field his_story_forbidden = PBField.initUInt32(0);
    public final PBUInt32Field my_story_forbidden = PBField.initUInt32(0);
  }
  
  public static final class UserSeqInfo
    extends MessageMicro<UserSeqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field seq = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id", "seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, UserSeqInfo.class);
    }
  }
  
  public static final class UserSimpleInfo
    extends MessageMicro<UserSimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field role = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uid", "union_id", "role" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, UserSimpleInfo.class);
    }
  }
  
  public static final class UserVidList
    extends MessageMicro<UserVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field is_end = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "union_id", "vid_list", "is_end" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, UserVidList.class);
    }
  }
  
  public static final class UsrIcon
    extends MessageMicro<UsrIcon>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField icon_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jmp_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "icon_postfix", "jmp_postfix" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, UsrIcon.class);
    }
  }
  
  public static final class VidPollInfo
    extends MessageMicro<VidPollInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field self_poll_result = PBField.initInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> video_poll_result = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> video_poll_users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "vid", "self_poll_result", "video_poll_result", "video_poll_users" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, VidPollInfo.class);
    }
  }
  
  public static final class VidQAInfo
    extends MessageMicro<VidQAInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField self_qa_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field total_qa_count = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> video_qa_users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "vid", "self_qa_result", "video_qa_users", "total_qa_count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, VidQAInfo.class);
    }
  }
  
  public static final class VidRateInfo
    extends MessageMicro<VidRateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field self_rate_result = PBField.initInt32(0);
    public final PBUInt32Field total_rate_count = PBField.initUInt32(0);
    public final PBUInt64Field total_rate_score = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> video_rate_users = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "vid", "self_rate_result", "total_rate_count", "total_rate_score", "video_rate_users" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null }, VidRateInfo.class);
    }
  }
  
  public static final class VideoReaderConf
    extends MessageMicro<VideoReaderConf>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ban_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> user_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> user_unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ban_type", "user_list", "user_unionid_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, VideoReaderConf.class);
    }
  }
  
  public static final class VideoSourceTagInfo
    extends MessageMicro<VideoSourceTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field source_tag_type = PBField.initUInt32(0);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "source_tag_type", "jump_url", "wording" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, VideoSourceTagInfo.class);
    }
  }
  
  public static final class VideoSpreadGroupList
    extends MessageMicro<VideoSpreadGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<Long> group_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> share_group_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field visibility_sharegroup_type = PBField.initUInt32(0);
    public final PBUInt32Field visibility_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "visibility_type", "group_list", "visibility_sharegroup_type", "share_group_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, VideoSpreadGroupList.class);
    }
  }
  
  public static final class VideoSpreadShareGroupList
    extends MessageMicro<VideoSpreadShareGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> share_group_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_list" }, new Object[] { localByteStringMicro }, VideoSpreadShareGroupList.class);
    }
  }
  
  public static final class VideoTarget
    extends MessageMicro<VideoTarget>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vid", "feed_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, VideoTarget.class);
    }
  }
  
  public static final class VideoUrl
    extends MessageMicro<VideoUrl>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "video_level", "video_url" }, new Object[] { Integer.valueOf(0), "" }, VideoUrl.class);
    public final PBUInt32Field video_level = PBField.initUInt32(0);
    public final PBStringField video_url = PBField.initString("");
  }
  
  public static final class WatcherExt
    extends MessageMicro<WatcherExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "has_like" }, new Object[] { Integer.valueOf(0) }, WatcherExt.class);
    public final PBUInt32Field has_like = PBField.initUInt32(0);
  }
  
  public static final class YearNodeInfo
    extends MessageMicro<YearNodeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "year", "video_total_count" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, YearNodeInfo.class);
    public final PBUInt32Field video_total_count = PBField.initUInt32(0);
    public final PBUInt32Field year = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct
 * JD-Core Version:    0.7.0.1
 */