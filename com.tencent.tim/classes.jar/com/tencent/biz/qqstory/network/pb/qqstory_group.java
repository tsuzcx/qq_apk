package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group
{
  public static final class CommentInfo
    extends MessageMicro<CommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "comment" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, CommentInfo.class);
    }
  }
  
  public static final class CommentLikeCount
    extends MessageMicro<CommentLikeCount>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBUInt32Field error = PBField.initUInt32(0);
    public final PBUInt32Field is_has_like = PBField.initUInt32(0);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_group.NewlyLikeInfo> newly_three_like = PBField.initRepeatMessage(qqstory_group.NewlyLikeInfo.class);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50 }, new String[] { "error", "story_id", "like_count", "comment_count", "is_has_like", "newly_three_like" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, CommentLikeCount.class);
    }
  }
  
  public static final class GroupDynamicVideoItem
    extends MessageMicro<GroupDynamicVideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "group_id", "total", "story_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, GroupDynamicVideoItem.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatMessageField<qqstory_group.GroupVideoItem> story_list = PBField.initRepeatMessage(qqstory_group.GroupVideoItem.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class GroupFeed
    extends MessageMicro<GroupFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_group.VideoStoryId> story_id_list = PBField.initRepeatMessage(qqstory_group.VideoStoryId.class);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "union_id", "feed_id", "story_id_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null }, GroupFeed.class);
    }
  }
  
  public static final class GroupInfo
    extends MessageMicro<GroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GroupInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class GroupStoryItem
    extends MessageMicro<GroupStoryItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ts = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public qqstory_group.GroupStoryVideoNodeInfo video_info = new qqstory_group.GroupStoryVideoNodeInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "type", "ts", "count", "video_info", "feed_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro }, GroupStoryItem.class);
    }
  }
  
  public static final class GroupStoryVideoNodeInfo
    extends MessageMicro<GroupStoryVideoNodeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_count = PBField.initUInt32(0);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field union_id_role = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 56, 64 }, new String[] { "story_id", "vid", "uin", "union_id", "cover_url", "like_count", "comment_count", "union_id_role" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupStoryVideoNodeInfo.class);
    }
  }
  
  public static final class GroupVideo
    extends MessageMicro<GroupVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<qqstory_group.VideoObject> video_obj_list = PBField.initRepeatMessage(qqstory_group.VideoObject.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "union_id", "vid_list", "video_obj_list", "source" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, GroupVideo.class);
    }
  }
  
  public static final class GroupVideoItem
    extends MessageMicro<GroupVideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field publish_time = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "story_id", "vid", "uin", "union_id", "cover_url", "publish_time" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, GroupVideoItem.class);
    }
  }
  
  public static final class HotVideoCard
    extends MessageMicro<HotVideoCard>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_item_list" }, new Object[] { null }, HotVideoCard.class);
    public final PBRepeatMessageField<qqstory_group.HotVideoItem> video_item_list = PBField.initRepeatMessage(qqstory_group.HotVideoItem.class);
  }
  
  public static final class HotVideoItem
    extends MessageMicro<HotVideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field hot_val = PBField.initUInt32(0);
    public final PBUInt32Field like_count = PBField.initUInt32(0);
    public final PBUInt32Field publish_time = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field view_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 64 }, new String[] { "story_id", "feed_id", "union_id", "cover_url", "publish_time", "like_count", "view_count", "hot_val" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HotVideoItem.class);
    }
  }
  
  public static final class MemberCardInfo
    extends MessageMicro<MemberCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField card_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uin", "nick_name", "card_name" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, MemberCardInfo.class);
    }
  }
  
  public static final class NewlyLikeInfo
    extends MessageMicro<NewlyLikeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uin", "time", "union_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, NewlyLikeInfo.class);
    }
  }
  
  public static final class ReqAddComment
    extends MessageMicro<ReqAddComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "story_id", "reply_uid", "content", "fake_id" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L) }, ReqAddComment.class);
    }
  }
  
  public static final class ReqAddGroupVideo
    extends MessageMicro<ReqAddGroupVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "group_video_list", "ts" }, new Object[] { null, Long.valueOf(0L) }, ReqAddGroupVideo.class);
    public final PBRepeatMessageField<qqstory_group.GroupVideo> group_video_list = PBField.initRepeatMessage(qqstory_group.GroupVideo.class);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
  }
  
  public static final class ReqDelComment
    extends MessageMicro<ReqDelComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "story_id", "comment_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqDelComment.class);
    }
  }
  
  public static final class ReqGetCommentLikeCount
    extends MessageMicro<ReqGetCommentLikeCount>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> story_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "story_id_list" }, new Object[] { localByteStringMicro }, ReqGetCommentLikeCount.class);
    }
  }
  
  public static final class ReqGetGroupDynamicEntrancePicture
    extends MessageMicro<ReqGetGroupDynamicEntrancePicture>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "version" }, new Object[] { localByteStringMicro }, ReqGetGroupDynamicEntrancePicture.class);
    }
  }
  
  public static final class ReqGetGroupDynamicVideoInfo
    extends MessageMicro<ReqGetGroupDynamicVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "group_list" }, new Object[] { Long.valueOf(0L) }, ReqGetGroupDynamicVideoInfo.class);
    public final PBRepeatField<Long> group_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqGetGroupHotRankVideo
    extends MessageMicro<ReqGetGroupHotRankVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "union_id", "start_cookie", "size", "seq" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L) }, ReqGetGroupHotRankVideo.class);
    }
  }
  
  public static final class ReqGetGroupList
    extends MessageMicro<ReqGetGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetGroupList.class);
  }
  
  public static final class ReqGetGroupMemberCardInfo
    extends MessageMicro<ReqGetGroupMemberCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "group_id", "uin_list" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReqGetGroupMemberCardInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class ReqGetGroupUnreadStoryList
    extends MessageMicro<ReqGetGroupUnreadStoryList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "group_id", "start_cookie", "count" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqGetGroupUnreadStoryList.class);
    }
  }
  
  public static final class ReqGetGroupVideoCommentList
    extends MessageMicro<ReqGetGroupVideoCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field latest_comment_id = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "story_id", "latest_comment_id", "cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqGetGroupVideoCommentList.class);
    }
  }
  
  public static final class ReqGetGroupVideoInfo
    extends MessageMicro<ReqGetGroupVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> story_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "story_id_list" }, new Object[] { localByteStringMicro }, ReqGetGroupVideoInfo.class);
    }
  }
  
  public static final class ReqGetGroupVideoLikeList
    extends MessageMicro<ReqGetGroupVideoLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "story_id" }, new Object[] { localByteStringMicro }, ReqGetGroupVideoLikeList.class);
    }
  }
  
  public static final class ReqGetGroupVideoList
    extends MessageMicro<ReqGetGroupVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "group_id", "start", "size", "time_zone", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqGetGroupVideoList.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBInt32Field time_zone = PBField.initInt32(0);
  }
  
  public static final class ReqGetUserGroupList
    extends MessageMicro<ReqGetUserGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seq" }, new Object[] { Long.valueOf(0L) }, ReqGetUserGroupList.class);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
  }
  
  public static final class ReqGroupStoryFeedIdList
    extends MessageMicro<ReqGroupStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "start_cookie" }, new Object[] { localByteStringMicro }, ReqGroupStoryFeedIdList.class);
    }
  }
  
  public static final class ReqGroupVideoDelete
    extends MessageMicro<ReqGroupVideoDelete>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field remove_author = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "story_id", "type", "remove_author" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqGroupVideoDelete.class);
    }
  }
  
  public static final class ReqGroupVideoForward
    extends MessageMicro<ReqGroupVideoForward>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field forward_to = PBField.initUInt64(0L);
    public final PBUInt32Field time = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "type", "forward_to", "vid", "time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqGroupVideoForward.class);
    }
  }
  
  public static final class ReqGroupVideoPublish
    extends MessageMicro<ReqGroupVideoPublish>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBUInt32Field chat_type = PBField.initUInt32(0);
    public final PBUInt32Field client_type = PBField.initUInt32(0);
    public final PBStringField file_id = PBField.initString("");
    public final PBBytesField file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt64Field msg_seq = PBField.initUInt64(0L);
    public final PBUInt32Field msg_time = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field sync_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 64, 72, 80 }, new String[] { "chat_type", "client_type", "file_id", "group_id", "file_md5", "business_type", "source", "msg_seq", "sync_flag", "msg_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqGroupVideoPublish.class);
    }
  }
  
  public static final class ReqLikeVideo
    extends MessageMicro<ReqLikeVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "story_id", "union_id", "operation" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqLikeVideo.class);
    }
  }
  
  public static final class ReqWatchGroupVideoBatch
    extends MessageMicro<ReqWatchGroupVideoBatch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_list" }, new Object[] { null }, ReqWatchGroupVideoBatch.class);
    public final PBRepeatMessageField<qqstory_group.WatchGroupVideo> video_list = PBField.initRepeatMessage(qqstory_group.WatchGroupVideo.class);
  }
  
  public static final class RspAddComment
    extends MessageMicro<RspAddComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "comment_id", "fake_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspAddComment.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspAddGroupVideo
    extends MessageMicro<RspAddGroupVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "group_feed_list" }, new Object[] { null, null }, RspAddGroupVideo.class);
    public final PBRepeatMessageField<qqstory_group.GroupFeed> group_feed_list = PBField.initRepeatMessage(qqstory_group.GroupFeed.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspDelComment
    extends MessageMicro<RspDelComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspDelComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetCommentLikeCount
    extends MessageMicro<RspGetCommentLikeCount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "count_list" }, new Object[] { null, null }, RspGetCommentLikeCount.class);
    public final PBRepeatMessageField<qqstory_group.CommentLikeCount> count_list = PBField.initRepeatMessage(qqstory_group.CommentLikeCount.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetGroupDynamicEntrancePicture
    extends MessageMicro<RspGetGroupDynamicEntrancePicture>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "result", "group_id", "cover_url" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro }, RspGetGroupDynamicEntrancePicture.class);
    }
  }
  
  public static final class RspGetGroupDynamicVideoInfo
    extends MessageMicro<RspGetGroupDynamicVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "result", "info_list" }, new Object[] { null, null }, RspGetGroupDynamicVideoInfo.class);
    public final PBRepeatMessageField<qqstory_group.GroupDynamicVideoItem> info_list = PBField.initRepeatMessage(qqstory_group.GroupDynamicVideoItem.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetGroupHotRankVideo
    extends MessageMicro<RspGetGroupHotRankVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_group.HotVideoCard> video_card_list = PBField.initRepeatMessage(qqstory_group.HotVideoCard.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "result", "video_card_list", "is_end", "next_cookie", "seq", "total" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, RspGetGroupHotRankVideo.class);
    }
  }
  
  public static final class RspGetGroupList
    extends MessageMicro<RspGetGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "group_list", "mask_group_list" }, new Object[] { null, null, null }, RspGetGroupList.class);
    public final PBRepeatMessageField<qqstory_group.GroupInfo> group_list = PBField.initRepeatMessage(qqstory_group.GroupInfo.class);
    public final PBRepeatMessageField<qqstory_group.GroupInfo> mask_group_list = PBField.initRepeatMessage(qqstory_group.GroupInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetGroupMemberCardInfo
    extends MessageMicro<RspGetGroupMemberCardInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "info_list" }, new Object[] { null, null }, RspGetGroupMemberCardInfo.class);
    public final PBRepeatMessageField<qqstory_group.MemberCardInfo> info_list = PBField.initRepeatMessage(qqstory_group.MemberCardInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetGroupUnreadStoryList
    extends MessageMicro<RspGetGroupUnreadStoryList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_group.UserGroupStoryItem> story_list = PBField.initRepeatMessage(qqstory_group.UserGroupStoryItem.class);
    public final PBRepeatField<Long> top_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field total_unread = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "result", "is_end", "next_cookie", "story_list", "total_unread", "top_uin_list" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetGroupUnreadStoryList.class);
    }
  }
  
  public static final class RspGetGroupVideoCommentList
    extends MessageMicro<RspGetGroupVideoCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_group.CommentInfo> comment_list = PBField.initRepeatMessage(qqstory_group.CommentInfo.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "result", "comment_list", "is_end", "total_comment_num", "cookie" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspGetGroupVideoCommentList.class);
    }
  }
  
  public static final class RspGetGroupVideoInfo
    extends MessageMicro<RspGetGroupVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspGetGroupVideoInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_group.VideoInfoItem> video_list = PBField.initRepeatMessage(qqstory_group.VideoInfoItem.class);
  }
  
  public static final class RspGetGroupVideoLikeList
    extends MessageMicro<RspGetGroupVideoLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "uin_list" }, new Object[] { null, Long.valueOf(0L) }, RspGetGroupVideoLikeList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspGetGroupVideoList
    extends MessageMicro<RspGetGroupVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50 }, new String[] { "result", "is_end", "next", "seq", "group_id", "node_list" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null }, RspGetGroupVideoList.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field next = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_group.GroupStoryItem> node_list = PBField.initRepeatMessage(qqstory_group.GroupStoryItem.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field seq = PBField.initUInt32(0);
  }
  
  public static final class RspGetUserGroupList
    extends MessageMicro<RspGetUserGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "group_list", "total_unshow", "seq" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetUserGroupList.class);
    public final PBRepeatMessageField<qqstory_group.UserGroupVideoItem> group_list = PBField.initRepeatMessage(qqstory_group.UserGroupVideoItem.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt32Field total_unshow = PBField.initUInt32(0);
  }
  
  public static final class RspGroupStoryFeedIdList
    extends MessageMicro<RspGroupStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_seq_info_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "feed_seq_info_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGroupStoryFeedIdList.class);
    }
  }
  
  public static final class RspGroupVideoDelete
    extends MessageMicro<RspGroupVideoDelete>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspGroupVideoDelete.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGroupVideoForward
    extends MessageMicro<RspGroupVideoForward>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_id" }, new Object[] { null, localByteStringMicro }, RspGroupVideoForward.class);
    }
  }
  
  public static final class RspGroupVideoPublish
    extends MessageMicro<RspGroupVideoPublish>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspGroupVideoPublish.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspLikeVideo
    extends MessageMicro<RspLikeVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspLikeVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspWatchVideoBatch
    extends MessageMicro<RspWatchVideoBatch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspWatchVideoBatch.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class UserGroupStoryItem
    extends MessageMicro<UserGroupStoryItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "story_id", "vid", "uin", "union_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3 }, UserGroupStoryItem.class);
    }
  }
  
  public static final class UserGroupVideoItem
    extends MessageMicro<UserGroupVideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field publish_time = PBField.initUInt32(0);
    public final PBRepeatField<Long> top_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field total_unread = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "group_id", "total", "total_unread", "cover_url", "publish_time", "top_uin_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, UserGroupVideoItem.class);
    }
  }
  
  public static final class VideoInfoItem
    extends MessageMicro<VideoInfoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.Address address = new qqstory_struct.Address();
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field del_flag = PBField.initUInt32(0);
    public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field error = PBField.initUInt32(0);
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field publish_time = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field url_flag = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 48, 56, 66, 74, 80, 90, 98, 104, 114, 120, 128 }, new String[] { "error", "story_id", "vid", "uin", "union_id", "publish_time", "duration", "cover_url", "download_url", "url_flag", "video_attr", "address", "group_id", "doodle_url", "del_flag", "video_source" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, null, Long.valueOf(0L), localByteStringMicro7, Integer.valueOf(0), Integer.valueOf(0) }, VideoInfoItem.class);
    }
  }
  
  public static final class VideoObject
    extends MessageMicro<VideoObject>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field time_zone = PBField.initInt32(0);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "vid", "ts", "time_zone" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, VideoObject.class);
    }
  }
  
  public static final class VideoStoryId
    extends MessageMicro<VideoStoryId>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "vid", "story_id", "feed_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, VideoStoryId.class);
    }
  }
  
  public static final class WatchGroupVideo
    extends MessageMicro<WatchGroupVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field group_id = PBField.initUInt64(0L);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "story_id", "group_id", "source", "time" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, WatchGroupVideo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group
 * JD-Core Version:    0.7.0.1
 */