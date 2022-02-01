package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service
{
  public static final class MsgListRingPushNotify
    extends MessageMicro<MsgListRingPushNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msglist_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_service.MsgTabNodeInfo msglist_head_notify_node_info = new qqstory_service.MsgTabNodeInfo();
    public final PBUInt32Field uint32_is_test_env = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msglist_notify_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "msglist_head_notify_node_info", "uint32_msglist_notify_type", "bytes_msglist_current_seq", "uint32_is_test_env" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, MsgListRingPushNotify.class);
    }
  }
  
  public static final class MsgTabNodeInfo
    extends MessageMicro<MsgTabNodeInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField link_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field no_update = PBField.initUInt32(0);
    public final PBInt32Field node_position = PBField.initInt32(0);
    public final PBBytesField node_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField recommend_name_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField redpoint = PBField.initBool(false);
    public final PBRepeatMessageField<qqstory_service.MsgTabNodeVideoInfo> rpt_msg_video_info_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeVideoInfo.class);
    public final PBUInt32Field uint32_node_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cache_seq = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_node_info_time_stamp = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_time_stamp = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uid = PBField.initUInt64(0L);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_cover_type = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 72, 82, 90, 98, 104, 114, 120, 130, 136, 144, 800 }, new String[] { "uint32_node_type", "uint64_uid", "bytes_union_id", "rpt_msg_video_info_list", "uint64_req_time_stamp", "uint64_node_info_time_stamp", "bytes_title", "bytes_icon_url", "recommend_id", "link_url", "node_vid", "video_cover", "node_position", "recommend_name_icon", "uint64_cache_seq", "passthrough", "redpoint", "video_cover_type", "no_update" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), localByteStringMicro7, Long.valueOf(0L), localByteStringMicro8, Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, MsgTabNodeInfo.class);
    }
  }
  
  public static final class MsgTabNodePushNotify
    extends MessageMicro<MsgTabNodePushNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_msglist_current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_service.MsgTabNodeInfo msg_notify_node_info = new qqstory_service.MsgTabNodeInfo();
    public qqstory_service.MsgTabNodeInfo msglist_head_notify_node_info = new qqstory_service.MsgTabNodeInfo();
    public final PBUInt32Field uint32_animate = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_test_env = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msglist_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58, 64 }, new String[] { "bytes_current_seq", "msg_notify_node_info", "uint32_notify_type", "msglist_head_notify_node_info", "uint32_msglist_notify_type", "uint32_animate", "bytes_msglist_current_seq", "uint32_is_test_env" }, new Object[] { localByteStringMicro1, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, MsgTabNodePushNotify.class);
    }
  }
  
  public static final class MsgTabNodeVidInfo
    extends MessageMicro<MsgTabNodeVidInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> recommand_id_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<Long> video_index_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feed_id", "vid_list", "video_index_list", "recommand_id_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, MsgTabNodeVidInfo.class);
    }
  }
  
  public static final class MsgTabNodeVideoInfo
    extends MessageMicro<MsgTabNodeVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField bottom_link = PBField.initString("");
    public final PBStringField bottom_wording = PBField.initString("");
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field recommand_id = PBField.initUInt32(0);
    public final PBUInt32Field show_bottom = PBField.initUInt32(0);
    public final PBUInt32Field show_text = PBField.initUInt32(0);
    public final PBStringField text_link = PBField.initString("");
    public final PBStringField text_wording = PBField.initString("");
    public final PBUInt32Field uint32_did_read = PBField.initUInt32(0);
    public final PBUInt64Field uint64_video_index = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.StoryVideoFullInfo video_info = new qqstory_struct.StoryVideoFullInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 74, 80, 90, 98 }, new String[] { "uint64_video_index", "uint32_did_read", "feed_id", "video_info", "vid", "recommand_id", "show_bottom", "bottom_wording", "bottom_link", "show_text", "text_wording", "text_link" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "" }, MsgTabNodeVideoInfo.class);
    }
  }
  
  public static final class POI
    extends MessageMicro<POI>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "address", "poi_type" }, new Object[] { null, Integer.valueOf(0) }, POI.class);
    public qqstory_struct.Address address = new qqstory_struct.Address();
    public final PBUInt32Field poi_type = PBField.initUInt32(0);
  }
  
  public static final class PromoteTask
    extends MessageMicro<PromoteTask>
  {
    public static final int HOME_FEED = 2;
    public static final int MSG_NODE = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_promote_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_limit_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_minimal_video_count = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_taskid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 56 }, new String[] { "uint64_taskid", "uint32_promote_type", "bytes_union_id", "bytes_feed_id", "uint64_limit_count", "uint64_minimal_video_count", "uint64_expire_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, PromoteTask.class);
    }
  }
  
  public static final class ReqActivityLoadMoreVideo
    extends MessageMicro<ReqActivityLoadMoreVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "req_list", "fetch_num" }, new Object[] { null, Integer.valueOf(0) }, ReqActivityLoadMoreVideo.class);
    public final PBUInt32Field fetch_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.LoadMoreReqNode> req_list = PBField.initRepeatMessage(qqstory_struct.LoadMoreReqNode.class);
  }
  
  public static final class ReqAddComment
    extends MessageMicro<ReqAddComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.GroupVideoBasicInfo video_info = new qqstory_struct.GroupVideoBasicInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "vid", "reply_uid", "content", "fake_id", "video_info" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), null }, ReqAddComment.class);
    }
  }
  
  public static final class ReqAddFeedComment
    extends MessageMicro<ReqAddFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedCommentAtVideoInfo> at_video_info = PBField.initRepeatMessage(qqstory_struct.FeedCommentAtVideoInfo.class);
    public final PBUInt32Field comment_type = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField extras = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField reply_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 64, 74 }, new String[] { "feed_id", "reply_union_id", "content", "fake_id", "source", "type", "at_video_info", "comment_type", "extras" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro4 }, ReqAddFeedComment.class);
    }
  }
  
  public static final class ReqAuthKey
    extends MessageMicro<ReqAuthKey>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqAuthKey.class);
  }
  
  public static final class ReqBannerVideoList
    extends MessageMicro<ReqBannerVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField banner_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "banner_id", "start_cookie" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqBannerVideoList.class);
    }
  }
  
  public static final class ReqBatchFeedComment
    extends MessageMicro<ReqBatchFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> feed_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feed_id_list", "source", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqBatchFeedComment.class);
    }
  }
  
  public static final class ReqBatchFeedLike
    extends MessageMicro<ReqBatchFeedLike>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> feed_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feed_id_list", "source", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqBatchFeedLike.class);
    }
  }
  
  public static final class ReqBatchGetPOIList
    extends MessageMicro<ReqBatchGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps" }, new Object[] { null }, ReqBatchGetPOIList.class);
    public final PBRepeatMessageField<qqstory_struct.GpsMsg> gps = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
  }
  
  public static final class ReqBatchGetVideoFullInfoList
    extends MessageMicro<ReqBatchGetVideoFullInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "vid_list", "source" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqBatchGetVideoFullInfoList.class);
    }
  }
  
  public static final class ReqBatchGetVideoInfo
    extends MessageMicro<ReqBatchGetVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> story_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "story_id_list" }, new Object[] { localByteStringMicro }, ReqBatchGetVideoInfo.class);
    }
  }
  
  public static final class ReqBatchStoryPollData
    extends MessageMicro<ReqBatchStoryPollData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid_list" }, new Object[] { localByteStringMicro }, ReqBatchStoryPollData.class);
    }
  }
  
  public static final class ReqCardList
    extends MessageMicro<ReqCardList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBEnumField req_type = PBField.initEnum(1);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "start_cookie", "count", "req_type", "topic_id", "gps" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(0L), null }, ReqCardList.class);
    }
  }
  
  public static final class ReqCheckActivity
    extends MessageMicro<ReqCheckActivity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "adcode", "version" }, new Object[] { Long.valueOf(0L), "" }, ReqCheckActivity.class);
    public final PBUInt64Field adcode = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ReqCheckBlackList
    extends MessageMicro<ReqCheckBlackList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps_list" }, new Object[] { null }, ReqCheckBlackList.class);
    public final PBRepeatMessageField<qqstory_struct.GpsMsg> gps_list = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
  }
  
  public static final class ReqCheckText
    extends MessageMicro<ReqCheckText>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField description = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "label", "description" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqCheckText.class);
    }
  }
  
  public static final class ReqCollectionViewCount
    extends MessageMicro<ReqCollectionViewCount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "collection_id" }, new Object[] { null }, ReqCollectionViewCount.class);
    public final PBRepeatMessageField<qqstory_struct.DateVideoCollectionID> collection_id = PBField.initRepeatMessage(qqstory_struct.DateVideoCollectionID.class);
  }
  
  public static final class ReqComment
    extends MessageMicro<ReqComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField author_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField comment_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field createTime = PBField.initUInt64(0L);
    public final PBBytesField summary = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 66 }, new String[] { "vid", "cover", "title", "summary", "createTime", "comment_content", "author_union_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, localByteStringMicro6 }, ReqComment.class);
    }
  }
  
  public static final class ReqConvertGroupId
    extends MessageMicro<ReqConvertGroupId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "convert_from", "group_req_list" }, new Object[] { Integer.valueOf(0), null }, ReqConvertGroupId.class);
    public final PBUInt32Field convert_from = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.GroupId> group_req_list = PBField.initRepeatMessage(qqstory_struct.GroupId.class);
  }
  
  public static final class ReqConvertUinAndUnionId
    extends MessageMicro<ReqConvertUinAndUnionId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "convert_from", "user_id_list", "need_medal", "need_grade_speed" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReqConvertUinAndUnionId.class);
    public final PBUInt32Field convert_from = PBField.initUInt32(0);
    public final PBUInt32Field need_grade_speed = PBField.initUInt32(0);
    public final PBUInt32Field need_medal = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserId> user_id_list = PBField.initRepeatMessage(qqstory_struct.UserId.class);
  }
  
  public static final class ReqCreateShareGroup
    extends MessageMicro<ReqCreateShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "share_group_info", "member_list", "show_in_friend_story_main_page" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, ReqCreateShareGroup.class);
    public final PBRepeatField<Long> member_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public qqstory_struct.ShareGroupInfo share_group_info = new qqstory_struct.ShareGroupInfo();
    public final PBUInt32Field show_in_friend_story_main_page = PBField.initUInt32(0);
  }
  
  public static final class ReqDateCollectionList
    extends MessageMicro<ReqDateCollectionList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field collection_count = PBField.initUInt32(0);
    public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
    public final PBInt32Field is_friend = PBField.initInt32(0);
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field time_zone = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 56 }, new String[] { "start_cookie", "collection_count", "collection_video_count", "seqno", "time_zone", "union_id", "is_friend" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqDateCollectionList.class);
    }
  }
  
  public static final class ReqDelComment
    extends MessageMicro<ReqDelComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "vid", "comment_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqDelComment.class);
    }
  }
  
  public static final class ReqDelFeedComment
    extends MessageMicro<ReqDelFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id", "comment_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqDelFeedComment.class);
    }
  }
  
  public static final class ReqDeleteVideo
    extends MessageMicro<ReqDeleteVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid_list" }, new Object[] { localByteStringMicro }, ReqDeleteVideo.class);
    }
  }
  
  public static final class ReqDiscoveryShareGroupInfoList
    extends MessageMicro<ReqDiscoveryShareGroupInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> share_group_unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_unionid_list" }, new Object[] { localByteStringMicro }, ReqDiscoveryShareGroupInfoList.class);
    }
  }
  
  public static final class ReqDiscoveryShareGroupList
    extends MessageMicro<ReqDiscoveryShareGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "coordinate", "gps" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, ReqDiscoveryShareGroupList.class);
    }
  }
  
  public static final class ReqEditShareGroup
    extends MessageMicro<ReqEditShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_info" }, new Object[] { null }, ReqEditShareGroup.class);
    public qqstory_struct.ShareGroupInfo share_group_info = new qqstory_struct.ShareGroupInfo();
  }
  
  public static final class ReqFeedCommentList
    extends MessageMicro<ReqFeedCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feed_id", "cookie", "source", "type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqFeedCommentList.class);
    }
  }
  
  public static final class ReqFeedLikeList
    extends MessageMicro<ReqFeedLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feed_id", "source", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqFeedLikeList.class);
    }
  }
  
  public static final class ReqFetchActivityFeeds
    extends MessageMicro<ReqFetchActivityFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field feed_video_num = PBField.initUInt32(0);
    public final PBUInt64Field feeds_seq = PBField.initUInt64(0L);
    public final PBUInt32Field fetch_time = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "start_cookie", "num", "fetch_time", "feed_video_num", "feeds_seq" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqFetchActivityFeeds.class);
    }
  }
  
  public static final class ReqForbidStory
    extends MessageMicro<ReqForbidStory>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field forbid_my_story = PBField.initUInt32(0);
    public final PBUInt32Field forbidden = PBField.initUInt32(0);
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uid_list", "forbidden", "forbid_my_story", "union_id_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqForbidStory.class);
    }
  }
  
  public static final class ReqForbidVideo
    extends MessageMicro<ReqForbidVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid" }, new Object[] { "" }, ReqForbidVideo.class);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class ReqFriendStoryFeed
    extends MessageMicro<ReqFriendStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id_list", "date" }, new Object[] { null, Integer.valueOf(0) }, ReqFriendStoryFeed.class);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_id_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
  }
  
  public static final class ReqFriendStoryFeedVideoList
    extends MessageMicro<ReqFriendStoryFeedVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field pull_type = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "start_cookie", "feed_id", "pull_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqFriendStoryFeedVideoList.class);
    }
  }
  
  public static final class ReqGetBatchFeedFeature
    extends MessageMicro<ReqGetBatchFeedFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> feed_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_id_list" }, new Object[] { localByteStringMicro }, ReqGetBatchFeedFeature.class);
    }
  }
  
  public static final class ReqGetBatchUserVidList
    extends MessageMicro<ReqGetBatchUserVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField pull_type = PBField.initEnum(1);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id_list", "pull_type" }, new Object[] { localByteStringMicro, Integer.valueOf(1) }, ReqGetBatchUserVidList.class);
    }
  }
  
  public static final class ReqGetBatchVideoBasicInfoList
    extends MessageMicro<ReqGetBatchVideoBasicInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "union_id", "vid_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqGetBatchVideoBasicInfoList.class);
    }
  }
  
  public static final class ReqGetBatchVideoFeatureList
    extends MessageMicro<ReqGetBatchVideoFeatureList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "union_id", "vid_list" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqGetBatchVideoFeatureList.class);
    }
  }
  
  public static final class ReqGetBlackList
    extends MessageMicro<ReqGetBlackList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "union_id" }, new Object[] { localByteStringMicro }, ReqGetBlackList.class);
    }
  }
  
  public static final class ReqGetCollectionVideoList
    extends MessageMicro<ReqGetCollectionVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field collection_id = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field identify = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field target_uid = PBField.initUInt64(0L);
    public final PBInt32Field time_zone = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_dir = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 58, 64, 72 }, new String[] { "target_uid", "start_cookie", "count", "collection_id", "time_zone", "union_id", "feed_id", "identify", "video_dir" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, ReqGetCollectionVideoList.class);
    }
  }
  
  public static final class ReqGetCommentList
    extends MessageMicro<ReqGetCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field latest_comment_id = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid", "latest_comment_id", "cookie" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqGetCommentList.class);
    }
  }
  
  public static final class ReqGetConfig
    extends MessageMicro<ReqGetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "get_pic_specs", "get_video_tag_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqGetConfig.class);
    public final PBUInt32Field get_pic_specs = PBField.initUInt32(0);
    public final PBUInt32Field get_video_tag_info = PBField.initUInt32(0);
  }
  
  public static final class ReqGetConfigFile
    extends MessageMicro<ReqGetConfigFile>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "config_file_type", "mobile_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqGetConfigFile.class);
    public final PBUInt32Field config_file_type = PBField.initUInt32(0);
    public final PBUInt32Field mobile_type = PBField.initUInt32(0);
  }
  
  public static final class ReqGetEmoticonPackList
    extends MessageMicro<ReqGetEmoticonPackList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "start_cookie", "count", "version" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqGetEmoticonPackList.class);
    }
  }
  
  public static final class ReqGetFeedVisitor
    extends MessageMicro<ReqGetFeedVisitor>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_id" }, new Object[] { localByteStringMicro }, ReqGetFeedVisitor.class);
    }
  }
  
  public static final class ReqGetFilterList
    extends MessageMicro<ReqGetFilterList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "start_cookie", "count" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetFilterList.class);
    }
  }
  
  public static final class ReqGetForbiddenList
    extends MessageMicro<ReqGetForbiddenList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field forbid_my_story = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "start_cookie", "count", "forbid_my_story" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqGetForbiddenList.class);
    }
  }
  
  public static final class ReqGetForbiddenStates
    extends MessageMicro<ReqGetForbiddenStates>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid_list", "union_id_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReqGetForbiddenStates.class);
    }
  }
  
  public static final class ReqGetFriendStoryNoExpireList
    extends MessageMicro<ReqGetFriendStoryNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uin_list", "ret_user_info" }, new Object[] { null, Integer.valueOf(0) }, ReqGetFriendStoryNoExpireList.class);
    public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserSeqInfo> uin_list = PBField.initRepeatMessage(qqstory_struct.UserSeqInfo.class);
  }
  
  public static final class ReqGetGroupVidList
    extends MessageMicro<ReqGetGroupVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id", "pull_type" }, new Object[] { "", Integer.valueOf(1) }, ReqGetGroupVidList.class);
    public final PBEnumField pull_type = PBField.initEnum(1);
    public final PBStringField union_id = PBField.initString("");
  }
  
  public static final class ReqGetHomePOI
    extends MessageMicro<ReqGetHomePOI>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetHomePOI.class);
  }
  
  public static final class ReqGetHotTopicInfo
    extends MessageMicro<ReqGetHotTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "topic_id" }, new Object[] { Long.valueOf(0L) }, ReqGetHotTopicInfo.class);
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
  }
  
  public static final class ReqGetHotTopicPack
    extends MessageMicro<ReqGetHotTopicPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "start_cookie", "gps" }, new Object[] { localByteStringMicro, null }, ReqGetHotTopicPack.class);
    }
  }
  
  public static final class ReqGetHotTopicVideoList
    extends MessageMicro<ReqGetHotTopicVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "topic_id", "start_cookie", "count" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqGetHotTopicVideoList.class);
    }
  }
  
  public static final class ReqGetJoinedShareGroupFriList
    extends MessageMicro<ReqGetJoinedShareGroupFriList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField share_group_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_unionid" }, new Object[] { localByteStringMicro }, ReqGetJoinedShareGroupFriList.class);
    }
  }
  
  public static final class ReqGetLabelList
    extends MessageMicro<ReqGetLabelList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "keyword", "start_cookie", "count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqGetLabelList.class);
    }
  }
  
  public static final class ReqGetLikeList
    extends MessageMicro<ReqGetLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid" }, new Object[] { localByteStringMicro }, ReqGetLikeList.class);
    }
  }
  
  public static final class ReqGetLocation
    extends MessageMicro<ReqGetLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "coordinate", "gps" }, new Object[] { Integer.valueOf(0), null }, ReqGetLocation.class);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  }
  
  public static final class ReqGetMissStoryInfo
    extends MessageMicro<ReqGetMissStoryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetMissStoryInfo.class);
  }
  
  public static final class ReqGetMusicListConfig
    extends MessageMicro<ReqGetMusicListConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "version" }, new Object[] { Integer.valueOf(0) }, ReqGetMusicListConfig.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqGetOfficialRecommends
    extends MessageMicro<ReqGetOfficialRecommends>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "count", "gps" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, ReqGetOfficialRecommends.class);
    }
  }
  
  public static final class ReqGetPOIList
    extends MessageMicro<ReqGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField keyword = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "keyword", "start_cookie", "count", "coordinate", "gps" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null }, ReqGetPOIList.class);
    }
  }
  
  public static final class ReqGetPOIMarkPack
    extends MessageMicro<ReqGetPOIMarkPack>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps" }, new Object[] { null }, ReqGetPOIMarkPack.class);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  }
  
  public static final class ReqGetPOIPosters
    extends MessageMicro<ReqGetPOIPosters>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "coordinate", "gps", "version" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqGetPOIPosters.class);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqGetPhotographyGuide
    extends MessageMicro<ReqGetPhotographyGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "seqno" }, new Object[] { Integer.valueOf(0) }, ReqGetPhotographyGuide.class);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
  }
  
  public static final class ReqGetPreloadVideoList
    extends MessageMicro<ReqGetPreloadVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField pull_type = PBField.initEnum(1);
    public final PBRepeatField<Long> ugc_topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 32 }, new String[] { "pull_type", "union_id_list", "ugc_topic_id_list" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Long.valueOf(0L) }, ReqGetPreloadVideoList.class);
    }
  }
  
  public static final class ReqGetPromoteTaskList
    extends MessageMicro<ReqGetPromoteTaskList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_cookie" }, new Object[] { localByteStringMicro }, ReqGetPromoteTaskList.class);
    }
  }
  
  public static final class ReqGetPublicCommentList
    extends MessageMicro<ReqGetPublicCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field latest_comment_id = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "vid", "latest_comment_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetPublicCommentList.class);
    }
  }
  
  public static final class ReqGetPublishConfig
    extends MessageMicro<ReqGetPublishConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetPublishConfig.class);
  }
  
  public static final class ReqGetRelatedVideoList
    extends MessageMicro<ReqGetRelatedVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField current_view_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "label", "start_cookie", "count", "current_view_vid" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, ReqGetRelatedVideoList.class);
    }
  }
  
  public static final class ReqGetShareGroupInfo
    extends MessageMicro<ReqGetShareGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_id_list" }, new Object[] { "" }, ReqGetShareGroupInfo.class);
    public final PBRepeatField<String> share_group_id_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  }
  
  public static final class ReqGetShareGroupMemList
    extends MessageMicro<ReqGetShareGroupMemList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "group_id", "start_cookie", "count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqGetShareGroupMemList.class);
    }
  }
  
  public static final class ReqGetShareVideoList
    extends MessageMicro<ReqGetShareVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt64Field share_time = PBField.initUInt64(0L);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field target_uid = PBField.initUInt64(0L);
    public final PBInt32Field time_zone = PBField.initInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 50 }, new String[] { "target_uid", "share_time", "start_cookie", "count", "time_zone", "union_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ReqGetShareVideoList.class);
    }
  }
  
  public static final class ReqGetSquareBannerItemList
    extends MessageMicro<ReqGetSquareBannerItemList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetSquareBannerItemList.class);
  }
  
  public static final class ReqGetStoryDes
    extends MessageMicro<ReqGetStoryDes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "req_info_list" }, new Object[] { null }, ReqGetStoryDes.class);
    public final PBRepeatMessageField<qqstory_struct.StoryReqInfo> req_info_list = PBField.initRepeatMessage(qqstory_struct.StoryReqInfo.class);
  }
  
  public static final class ReqGetStoryUinList
    extends MessageMicro<ReqGetStoryUinList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "start_cookie", "count", "ret_user_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqGetStoryUinList.class);
    }
  }
  
  public static final class ReqGetStoryUinNoExpireList
    extends MessageMicro<ReqGetStoryUinNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBUInt32Field req_list_type = PBField.initUInt32(0);
    public final PBUInt32Field req_type = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "start_cookie", "count", "req_type", "req_list_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqGetStoryUinNoExpireList.class);
    }
  }
  
  public static final class ReqGetTagInfo
    extends MessageMicro<ReqGetTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "tag_id", "type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqGetTagInfo.class);
    public final PBUInt64Field tag_id = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReqGetTagList
    extends MessageMicro<ReqGetTagList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "start_cookie", "size", "music_type", "music_id" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqGetTagList.class);
    public final PBUInt64Field music_id = PBField.initUInt64(0L);
    public final PBUInt32Field music_type = PBField.initUInt32(0);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBStringField start_cookie = PBField.initString("");
  }
  
  public static final class ReqGetUnWatchStoryList
    extends MessageMicro<ReqGetUnWatchStoryList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "start_cookie", "count" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetUnWatchStoryList.class);
    }
  }
  
  public static final class ReqGetUnWatchStoryNoExpireList
    extends MessageMicro<ReqGetUnWatchStoryNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "uin_list", "ret_user_info" }, new Object[] { null, Integer.valueOf(0) }, ReqGetUnWatchStoryNoExpireList.class);
    public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserSeqInfo> uin_list = PBField.initRepeatMessage(qqstory_struct.UserSeqInfo.class);
  }
  
  public static final class ReqGetUnreadLiker
    extends MessageMicro<ReqGetUnreadLiker>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "count", "vid" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqGetUnreadLiker.class);
    }
  }
  
  public static final class ReqGetUserGuide
    extends MessageMicro<ReqGetUserGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetUserGuide.class);
  }
  
  public static final class ReqGetUserSelfInfo
    extends MessageMicro<ReqGetUserSelfInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqGetUserSelfInfo.class);
  }
  
  public static final class ReqGetUserShareGroupList
    extends MessageMicro<ReqGetUserShareGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "union_id", "start_cookie", "count" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqGetUserShareGroupList.class);
    }
  }
  
  public static final class ReqGetUserVideoInfo
    extends MessageMicro<ReqGetUserVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 40 }, new String[] { "vid", "source" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetUserVideoInfo.class);
    }
  }
  
  public static final class ReqGetUserVideoList
    extends MessageMicro<ReqGetUserVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBEnumField pull_type = PBField.initEnum(1);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "uid", "start_cookie", "count", "pull_type", "union_id", "seq" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2, Integer.valueOf(0) }, ReqGetUserVideoList.class);
    }
  }
  
  public static final class ReqGetWatcher
    extends MessageMicro<ReqGetWatcher>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "count", "vid" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqGetWatcher.class);
    }
  }
  
  public static final class ReqGetWeather
    extends MessageMicro<ReqGetWeather>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "longitude", "latitude", "coordinate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqGetWeather.class);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public final PBInt32Field latitude = PBField.initInt32(0);
    public final PBInt32Field longitude = PBField.initInt32(0);
  }
  
  public static final class ReqGroupDateVideoList
    extends MessageMicro<ReqGroupDateVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date_count = PBField.initUInt32(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBBytesField group_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field time_zone = PBField.initInt32(0);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "group_unionid", "start_cookie", "date_count", "video_count", "seqno", "time_zone", "from" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqGroupDateVideoList.class);
    }
  }
  
  public static final class ReqIconPostfix
    extends MessageMicro<ReqIconPostfix>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "union_id_list" }, new Object[] { localByteStringMicro }, ReqIconPostfix.class);
    }
  }
  
  public static final class ReqJoinShareGroup
    extends MessageMicro<ReqJoinShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field exit_src = PBField.initUInt32(0);
    public final PBBytesField group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> member_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field oper_type = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "group_id", "oper_type", "member_list", "source", "exit_src" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqJoinShareGroup.class);
    }
  }
  
  public static final class ReqLikeFeed
    extends MessageMicro<ReqLikeFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "feed_id", "operation", "source", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqLikeFeed.class);
    }
  }
  
  public static final class ReqLikeVideo
    extends MessageMicro<ReqLikeVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.GroupVideoBasicInfo video_info = new qqstory_struct.GroupVideoBasicInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "vid", "union_id", "operation", "video_info" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null }, ReqLikeVideo.class);
    }
  }
  
  public static final class ReqLoadMoreVideoList
    extends MessageMicro<ReqLoadMoreVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "feed_id", "start_cookie", "video_count", "from" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqLoadMoreVideoList.class);
    }
  }
  
  public static final class ReqMarkAsRead
    extends MessageMicro<ReqMarkAsRead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "union_id" }, new Object[] { localByteStringMicro }, ReqMarkAsRead.class);
    }
  }
  
  public static final class ReqMonitorValue
    extends MessageMicro<ReqMonitorValue>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field ID = PBField.initUInt32(0);
    public final PBUInt32Field Value = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ID", "Value", "errmsg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqMonitorValue.class);
    }
  }
  
  public static final class ReqMsgListHeadNode
    extends MessageMicro<ReqMsgListHeadNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "current_seq", "uin_list", "source" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0) }, ReqMsgListHeadNode.class);
    }
  }
  
  public static final class ReqMsgTabNodeList
    extends MessageMicro<ReqMsgTabNodeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field adcode = PBField.initUInt64(0L);
    public final PBBytesField client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField device = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBoolField force_refresh = PBField.initBool(false);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "current_seq", "start_cookie", "source", "version", "adcode", "device", "force_refresh", "client_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4 }, ReqMsgTabNodeList.class);
    }
  }
  
  public static final class ReqMsgTabNodeVideoList
    extends MessageMicro<ReqMsgTabNodeVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field adcode = PBField.initUInt64(0L);
    public final PBStringField cookie = PBField.initString("");
    public final PBBytesField device = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field node_type = PBField.initUInt32(0);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBUInt64Field req_time_stamp = PBField.initUInt64(0L);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField start_vid = PBField.initString("");
    public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90 }, new String[] { "unionID", "req_time_stamp", "node_type", "recommend_id", "source", "cookie", "start_vid", "page_size", "adcode", "device", "passthrough" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, ReqMsgTabNodeVideoList.class);
    }
  }
  
  public static final class ReqMsgTabNodeWatched
    extends MessageMicro<ReqMsgTabNodeWatched>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field node_type = PBField.initUInt32(0);
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
    public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "unionID", "node_type", "operation", "recommend_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqMsgTabNodeWatched.class);
    }
  }
  
  public static final class ReqMultiRcmdDisLike
    extends MessageMicro<ReqMultiRcmdDisLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid" }, new Object[] { "" }, ReqMultiRcmdDisLike.class);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class ReqMyStoryNode
    extends MessageMicro<ReqMyStoryNode>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReqMyStoryNode.class);
  }
  
  public static final class ReqPreloadVideoList
    extends MessageMicro<ReqPreloadVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBEnumField pull_type = PBField.initEnum(1);
    public final PBRepeatField<Long> topic_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "pull_type", "union_id_list", "topic_id_list" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Long.valueOf(0L) }, ReqPreloadVideoList.class);
    }
  }
  
  public static final class ReqProfileStoryFeedIdList
    extends MessageMicro<ReqProfileStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "start_cookie", "union_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, ReqProfileStoryFeedIdList.class);
    }
  }
  
  public static final class ReqProfileYearNodeList
    extends MessageMicro<ReqProfileYearNodeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "union_id" }, new Object[] { localByteStringMicro }, ReqProfileYearNodeList.class);
    }
  }
  
  public static final class ReqPublishVideo
    extends MessageMicro<ReqPublishVideo>
  {
    public static final int STRING_STORY_COMBO = 5;
    public static final int STRING_STORY_FILTER = 3;
    public static final int STRING_STORY_MUSIC = 4;
    public static final int STRING_STORY_PENDANT = 2;
    public static final int STRING_STORY_TEXT = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.Address address = new qqstory_struct.Address();
    public final PBUInt32Field client_version = PBField.initUInt32(0);
    public final PBUInt32Field compared_activity_id = PBField.initUInt32(0);
    public final PBUInt32Field compared_level = PBField.initUInt32(0);
    public final PBStringField compared_vid = PBField.initString("");
    public final PBUInt32Field content_origin = PBField.initUInt32(0);
    public final PBUInt32Field content_type = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField doodle_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField doodle_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field dov_fresh_task_id = PBField.initUInt32(0);
    public final PBUInt32Field dov_from_new_version = PBField.initUInt32(0);
    public final PBBytesField extra = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField game_pk_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.VideoSpreadGroupList group_list = new qqstory_struct.VideoSpreadGroupList();
    public final PBUInt32Field group_source = PBField.initUInt32(0);
    public final PBUInt32Field ignore_personal_publish = PBField.initUInt32(0);
    public qqstory_struct.InteractPasterInfo interact_paster_info = new qqstory_struct.InteractPasterInfo();
    public final PBUInt32Field is_capture_together_video = PBField.initUInt32(0);
    public final PBBytesField label = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> mention_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField multi_shoot_group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> poll_options = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField poll_text = PBField.initString("");
    public final PBUInt32Field qim_sync_to_qq = PBField.initUInt32(0);
    public qqstory_struct.VideoReaderConf reader_conf = new qqstory_struct.VideoReaderConf();
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field sync_to_qzone = PBField.initUInt32(0);
    public final PBBytesField title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field total_time = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_extern_link_attr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field video_label_id = PBField.initUInt64(0L);
    public final PBBytesField video_label_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_label_type = PBField.initUInt32(0);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> wording_check = PBField.initRepeat(PBStringField.__repeatHelper__);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 82, 114, 122, 128, 136, 146, 152, 160, 170, 178, 184, 192, 200, 210, 216, 224, 232, 242, 248, 266, 274, 282, 288, 298, 304, 314, 320, 330, 336, 344, 354, 360 }, new String[] { "title", "vid", "video_cover", "doodle_url", "total_time", "address", "label", "create_time", "video_url", "doodle_text", "video_attr", "mention_list", "source", "reader_conf", "content_type", "content_origin", "group_list", "multi_shoot_group_id", "date", "ignore_personal_publish", "group_source", "video_label_title", "video_label_id", "video_label_type", "client_version", "extra", "qim_sync_to_qq", "poll_text", "poll_options", "interact_paster_info", "sync_to_qzone", "video_extern_link_attr", "dov_fresh_task_id", "compared_vid", "is_capture_together_video", "game_pk_vid", "compared_level", "compared_activity_id", "wording_check", "dov_from_new_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), null, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, Integer.valueOf(0), "", "", null, Integer.valueOf(0), localByteStringMicro12, Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro13, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ReqPublishVideo.class);
    }
  }
  
  public static final class ReqQQStoryGuide
    extends MessageMicro<ReqQQStoryGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uid", "version", "platform" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, ReqQQStoryGuide.class);
    public final PBInt32Field platform = PBField.initInt32(0);
    public final PBUInt64Field to_uid = PBField.initUInt64(0L);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ReqRecordZombieRead
    extends MessageMicro<ReqRecordZombieRead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field newest_video_ts = PBField.initUInt64(0L);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "union_id", "newest_video_ts" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, ReqRecordZombieRead.class);
    }
  }
  
  public static final class ReqRemoveMemberListFromShareGroup
    extends MessageMicro<ReqRemoveMemberListFromShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField group_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field remove_story = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "group_id", "unionid_list", "remove_story" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqRemoveMemberListFromShareGroup.class);
    }
  }
  
  public static final class ReqReportComment
    extends MessageMicro<ReqReportComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "vid", "comment_id", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(1) }, ReqReportComment.class);
    }
  }
  
  public static final class ReqReportEvil
    extends MessageMicro<ReqReportEvil>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field tuin = PBField.initUInt64(0L);
    public final PBEnumField type = PBField.initEnum(1);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "vid", "type", "tuin", "union_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro2 }, ReqReportEvil.class);
    }
  }
  
  public static final class ReqReportFeedComment
    extends MessageMicro<ReqReportFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField type = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "feed_id", "comment_id", "type" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(1) }, ReqReportFeedComment.class);
    }
  }
  
  public static final class ReqSetConfig
    extends MessageMicro<ReqSetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_config" }, new Object[] { null }, ReqSetConfig.class);
    public final PBRepeatMessageField<qqstory_struct.UserConfig> user_config = PBField.initRepeatMessage(qqstory_struct.UserConfig.class);
  }
  
  public static final class ReqShareToDiscover
    extends MessageMicro<ReqShareToDiscover>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_id" }, new Object[] { localByteStringMicro }, ReqShareToDiscover.class);
    }
  }
  
  public static final class ReqShareVideoCollectionList
    extends MessageMicro<ReqShareVideoCollectionList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field collection_count = PBField.initUInt32(0);
    public final PBUInt32Field collection_video_count = PBField.initUInt32(0);
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "start_cookie", "collection_count", "collection_video_count", "seqno", "union_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, ReqShareVideoCollectionList.class);
    }
  }
  
  public static final class ReqSimpleInfoList
    extends MessageMicro<ReqSimpleInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid_list" }, new Object[] { localByteStringMicro }, ReqSimpleInfoList.class);
    }
  }
  
  public static final class ReqStoryCreateVideoTag
    extends MessageMicro<ReqStoryCreateVideoTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "tag_name", "tag_desc", "tag_type", "music_type", "music_id" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqStoryCreateVideoTag.class);
    public final PBUInt64Field music_id = PBField.initUInt64(0L);
    public final PBUInt32Field music_type = PBField.initUInt32(0);
    public final PBStringField tag_desc = PBField.initString("");
    public final PBStringField tag_name = PBField.initString("");
    public final PBUInt32Field tag_type = PBField.initUInt32(0);
  }
  
  public static final class ReqStoryFeed
    extends MessageMicro<ReqStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id_list", "date" }, new Object[] { null, Integer.valueOf(0) }, ReqStoryFeed.class);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_id_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
  }
  
  public static final class ReqStoryFeedIdList
    extends MessageMicro<ReqStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
    public qqstory_struct.LoginSig bind_uin_login_sig = new qqstory_struct.LoginSig();
    public final PBUInt32Field client_version = PBField.initUInt32(0);
    public final PBUInt32Field coordinate = PBField.initUInt32(0);
    public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
    public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "start_cookie", "coordinate", "gps", "client_version", "bind_uin", "bind_uin_login_sig" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), null }, ReqStoryFeedIdList.class);
    }
  }
  
  public static final class ReqStoryFeedTagInfo
    extends MessageMicro<ReqStoryFeedTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> feed_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id_list", "date" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqStoryFeedTagInfo.class);
    }
  }
  
  public static final class ReqStoryPlayerTagInfo
    extends MessageMicro<ReqStoryPlayerTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field client = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "vid_list", "client", "version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqStoryPlayerTagInfo.class);
    }
  }
  
  public static final class ReqStorySearchVideoTag
    extends MessageMicro<ReqStorySearchVideoTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "size", "video_tag_name" }, new Object[] { "", Integer.valueOf(0), "" }, ReqStorySearchVideoTag.class);
    public final PBUInt32Field size = PBField.initUInt32(0);
    public final PBStringField start_cookie = PBField.initString("");
    public final PBStringField video_tag_name = PBField.initString("");
  }
  
  public static final class ReqStorySubmitPollData
    extends MessageMicro<ReqStorySubmitPollData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field no_feed_id = PBField.initUInt32(0);
    public final PBUInt32Field poll_data = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "vid", "poll_data", "feed_id", "no_feed_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqStorySubmitPollData.class);
    }
  }
  
  public static final class ReqStorySubmitQAData
    extends MessageMicro<ReqStorySubmitQAData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field no_feed_id = PBField.initUInt32(0);
    public final PBBytesField qa_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "vid", "qa_data", "feed_id", "no_feed_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, ReqStorySubmitQAData.class);
    }
  }
  
  public static final class ReqStorySubmitRateData
    extends MessageMicro<ReqStorySubmitRateData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field no_feed_id = PBField.initUInt32(0);
    public final PBUInt32Field rate_data = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "vid", "rate_data", "feed_id", "no_feed_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqStorySubmitRateData.class);
    }
  }
  
  public static final class ReqSyncVideoPublish
    extends MessageMicro<ReqSyncVideoPublish>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_service.ReqPublishVideo publish_struct = new qqstory_service.ReqPublishVideo();
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66 }, new String[] { "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "bytes_file_md5", "uint32_business_type", "source", "publish_struct" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, ReqSyncVideoPublish.class);
    }
  }
  
  public static final class ReqTodayStoryVidList
    extends MessageMicro<ReqTodayStoryVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field date = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "date", "cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ReqTodayStoryVidList.class);
    }
  }
  
  public static final class ReqTranslateToken
    extends MessageMicro<ReqTranslateToken>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField src_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "src_buffer", "type", "feed_id" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ReqTranslateToken.class);
    }
  }
  
  public static final class ReqUploadStoryVideo
    extends MessageMicro<ReqUploadStoryVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "md5", "sha", "size" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, ReqUploadStoryVideo.class);
    }
  }
  
  public static final class ReqVideoReaderConf
    extends MessageMicro<ReqVideoReaderConf>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "vid" }, new Object[] { localByteStringMicro }, ReqVideoReaderConf.class);
    }
  }
  
  public static final class ReqWatchVideo
    extends MessageMicro<ReqWatchVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field compress_level = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field is_live_video = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField to_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field vid_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 32, 40, 48, 56, 64 }, new String[] { "vid", "to_union_id", "is_live_video", "source", "create_time", "vid_type", "compress_level" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqWatchVideo.class);
    }
  }
  
  public static final class ReqWatchVideoBatch
    extends MessageMicro<ReqWatchVideoBatch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "video_list" }, new Object[] { null }, ReqWatchVideoBatch.class);
    public final PBRepeatMessageField<qqstory_service.VideoItem> video_list = PBField.initRepeatMessage(qqstory_service.VideoItem.class);
  }
  
  public static final class RspActivityLoadMoreVideo
    extends MessageMicro<RspActivityLoadMoreVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "rsp_list" }, new Object[] { null, null }, RspActivityLoadMoreVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.LoadMoreRspNode> rsp_list = PBField.initRepeatMessage(qqstory_struct.LoadMoreRspNode.class);
  }
  
  public static final class RspAddComment
    extends MessageMicro<RspAddComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "comment_id", "fake_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspAddComment.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspAddFeedComment
    extends MessageMicro<RspAddFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "comment_id" }, new Object[] { null, Integer.valueOf(0) }, RspAddFeedComment.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspAuthKey
    extends MessageMicro<RspAuthKey>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField backup_server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField backup_server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field expire_time = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField server_ip1 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField server_ip2 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField user_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64 }, new String[] { "result", "user_ip", "server_ip1", "server_ip2", "backup_server_ip1", "backup_server_ip2", "auth_key", "expire_time" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Long.valueOf(0L) }, RspAuthKey.class);
    }
  }
  
  public static final class RspBannerVideoList
    extends MessageMicro<RspBannerVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.VideoTarget> video_list = PBField.initRepeatMessage(qqstory_struct.VideoTarget.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "video_list", "is_end", "next_cookie", "total_count" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspBannerVideoList.class);
    }
  }
  
  public static final class RspBatchFeedComment
    extends MessageMicro<RspBatchFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_comment_info_list" }, new Object[] { null, null }, RspBatchFeedComment.class);
    public final PBRepeatMessageField<qqstory_struct.FeedCommentInfo> feed_comment_info_list = PBField.initRepeatMessage(qqstory_struct.FeedCommentInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspBatchFeedLike
    extends MessageMicro<RspBatchFeedLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_like_info_list" }, new Object[] { null, null }, RspBatchFeedLike.class);
    public final PBRepeatMessageField<qqstory_struct.FeedLikeInfo> feed_like_info_list = PBField.initRepeatMessage(qqstory_struct.FeedLikeInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspBatchGetPOIList
    extends MessageMicro<RspBatchGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "poi_list" }, new Object[] { null, null }, RspBatchGetPOIList.class);
    public final PBRepeatMessageField<qqstory_service.POI> poi_list = PBField.initRepeatMessage(qqstory_service.POI.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspBatchGetVideoFullInfoList
    extends MessageMicro<RspBatchGetVideoFullInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "result", "video_list", "interact_status" }, new Object[] { null, null, Integer.valueOf(0) }, RspBatchGetVideoFullInfoList.class);
    public final PBUInt32Field interact_status = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
  }
  
  public static final class RspBatchGetVideoInfo
    extends MessageMicro<RspBatchGetVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "vid_info_list" }, new Object[] { null, null }, RspBatchGetVideoInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.GroupStoryInfo> vid_info_list = PBField.initRepeatMessage(qqstory_struct.GroupStoryInfo.class);
  }
  
  public static final class RspBatchStoryPollData
    extends MessageMicro<RspBatchStoryPollData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "result", "poll_info_list", "rate_info_list", "qa_info_list" }, new Object[] { null, null, null, null }, RspBatchStoryPollData.class);
    public final PBRepeatMessageField<qqstory_struct.VidPollInfo> poll_info_list = PBField.initRepeatMessage(qqstory_struct.VidPollInfo.class);
    public final PBRepeatMessageField<qqstory_struct.VidQAInfo> qa_info_list = PBField.initRepeatMessage(qqstory_struct.VidQAInfo.class);
    public final PBRepeatMessageField<qqstory_struct.VidRateInfo> rate_info_list = PBField.initRepeatMessage(qqstory_struct.VidRateInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspCardList
    extends MessageMicro<RspCardList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.CardInfo> card_info_list = PBField.initRepeatMessage(qqstory_struct.CardInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "result", "card_info_list", "next_cookie", "is_end" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, RspCardList.class);
    }
  }
  
  public static final class RspCheckActivity
    extends MessageMicro<RspCheckActivity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "is_activity", "next_check_time" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspCheckActivity.class);
    public final PBUInt32Field is_activity = PBField.initUInt32(0);
    public final PBUInt32Field next_check_time = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspCheckBlackList
    extends MessageMicro<RspCheckBlackList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "black_gps_list" }, new Object[] { null, null }, RspCheckBlackList.class);
    public final PBRepeatMessageField<qqstory_struct.GpsMsg> black_gps_list = PBField.initRepeatMessage(qqstory_struct.GpsMsg.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspCheckText
    extends MessageMicro<RspCheckText>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspCheckText.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspCollectionViewCount
    extends MessageMicro<RspCollectionViewCount>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "collection_list" }, new Object[] { null, null }, RspCollectionViewCount.class);
    public final PBRepeatMessageField<qqstory_struct.DateVideoCollection> collection_list = PBField.initRepeatMessage(qqstory_struct.DateVideoCollection.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspComment
    extends MessageMicro<RspComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspConvertGroupId
    extends MessageMicro<RspConvertGroupId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "group_rsp_list" }, new Object[] { null, null }, RspConvertGroupId.class);
    public final PBRepeatMessageField<qqstory_struct.GroupId> group_rsp_list = PBField.initRepeatMessage(qqstory_struct.GroupId.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspConvertUinAndUnionId
    extends MessageMicro<RspConvertUinAndUnionId>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user_list" }, new Object[] { null, null }, RspConvertUinAndUnionId.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  }
  
  public static final class RspCreateShareGroup
    extends MessageMicro<RspCreateShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "share_group_info" }, new Object[] { null, null }, RspCreateShareGroup.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public qqstory_struct.ShareGroupInfo share_group_info = new qqstory_struct.ShareGroupInfo();
  }
  
  public static final class RspDateVideoCollectionList
    extends MessageMicro<RspDateVideoCollectionList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.DateVideoCollection> collection_list = PBField.initRepeatMessage(qqstory_struct.DateVideoCollection.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBInt32Field is_friend = PBField.initInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    public final PBUInt32Field total_video_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56 }, new String[] { "result", "collection_list", "is_end", "next_cookie", "total_video_count", "seqno", "is_friend" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspDateVideoCollectionList.class);
    }
  }
  
  public static final class RspDelComment
    extends MessageMicro<RspDelComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspDelComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspDelFeedComment
    extends MessageMicro<RspDelFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspDelFeedComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspDeleteVideo
    extends MessageMicro<RspDeleteVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspDeleteVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspDiscoveryShareGroupInfoList
    extends MessageMicro<RspDiscoveryShareGroupInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "share_group_info_list" }, new Object[] { null, null }, RspDiscoveryShareGroupInfoList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.DiscoveryShareGroupInfo> share_group_info_list = PBField.initRepeatMessage(qqstory_struct.DiscoveryShareGroupInfo.class);
  }
  
  public static final class RspDiscoveryShareGroupList
    extends MessageMicro<RspDiscoveryShareGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatField<ByteStringMicro> share_group_unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "share_group_unionid_list", "is_end", "next_cookie" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, RspDiscoveryShareGroupList.class);
    }
  }
  
  public static final class RspEditShareGroup
    extends MessageMicro<RspEditShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspEditShareGroup.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspFeedCommentList
    extends MessageMicro<RspFeedCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_comment_info" }, new Object[] { null, null }, RspFeedCommentList.class);
    public qqstory_struct.FeedCommentInfo feed_comment_info = new qqstory_struct.FeedCommentInfo();
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspFeedLikeList
    extends MessageMicro<RspFeedLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_like_info" }, new Object[] { null, null }, RspFeedLikeList.class);
    public qqstory_struct.FeedLikeInfo feed_like_info = new qqstory_struct.FeedLikeInfo();
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspFetchActivityFeeds
    extends MessageMicro<RspFetchActivityFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.ActivityFeedNode> feed_list = PBField.initRepeatMessage(qqstory_struct.ActivityFeedNode.class);
    public final PBUInt64Field feeds_seq = PBField.initUInt64(0L);
    public final PBUInt32Field fetch_time = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48 }, new String[] { "result", "next_cookie", "is_end", "fetch_time", "feed_list", "feeds_seq" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L) }, RspFetchActivityFeeds.class);
    }
  }
  
  public static final class RspForbidStory
    extends MessageMicro<RspForbidStory>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspForbidStory.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspForbidVideo
    extends MessageMicro<RspForbidVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspForbidVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspFriendStoryFeed
    extends MessageMicro<RspFriendStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_list" }, new Object[] { null, null }, RspFriendStoryFeed.class);
    public final PBRepeatMessageField<qqstory_struct.FeedInfo> feed_list = PBField.initRepeatMessage(qqstory_struct.FeedInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspFriendStoryFeedVideoList
    extends MessageMicro<RspFriendStoryFeedVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedVideoInfo> feed_video_info_list = PBField.initRepeatMessage(qqstory_struct.FeedVideoInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.MultiRecommendItem> multi_rcmd_feed_info_list = PBField.initRepeatMessage(qqstory_struct.MultiRecommendItem.class);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.ShareGroupVideoInfo> share_group_video_info_list = PBField.initRepeatMessage(qqstory_struct.ShareGroupVideoInfo.class);
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58 }, new String[] { "result", "is_end", "next_cookie", "feed_video_info_list", "union_id", "share_group_video_info_list", "multi_rcmd_feed_info_list" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2, null, null }, RspFriendStoryFeedVideoList.class);
    }
  }
  
  public static final class RspGetBatchFeedFeature
    extends MessageMicro<RspGetBatchFeedFeature>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_feature_list" }, new Object[] { null, null }, RspGetBatchFeedFeature.class);
    public final PBRepeatMessageField<qqstory_struct.FeedFeature> feed_feature_list = PBField.initRepeatMessage(qqstory_struct.FeedFeature.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetBatchUserVidList
    extends MessageMicro<RspGetBatchUserVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user_vid_list" }, new Object[] { null, null }, RspGetBatchUserVidList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserVidList> user_vid_list = PBField.initRepeatMessage(qqstory_struct.UserVidList.class);
  }
  
  public static final class RspGetBatchVideoBasicInfoList
    extends MessageMicro<RspGetBatchVideoBasicInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspGetBatchVideoBasicInfoList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
  }
  
  public static final class RspGetBatchVideoFeatureList
    extends MessageMicro<RspGetBatchVideoFeatureList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspGetBatchVideoFeatureList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFeature> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFeature.class);
  }
  
  public static final class RspGetBlackList
    extends MessageMicro<RspGetBlackList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "black_status", "update_interval" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, RspGetBlackList.class);
    public final PBUInt32Field black_status = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field update_interval = PBField.initUInt32(0);
  }
  
  public static final class RspGetCollectionVideoList
    extends MessageMicro<RspGetCollectionVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> full_video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field interact_status = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 56 }, new String[] { "result", "video_list", "is_end", "next_cookie", "video_info_list", "full_video_info_list", "interact_status" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, null, null, Integer.valueOf(0) }, RspGetCollectionVideoList.class);
    }
  }
  
  public static final class RspGetCommentList
    extends MessageMicro<RspGetCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.StoryVideoCommentInfo> comment_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoCommentInfo.class);
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "result", "comment_list", "is_end", "total_comment_num", "cookie" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspGetCommentList.class);
    }
  }
  
  public static final class RspGetConfig
    extends MessageMicro<RspGetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "result", "user_config", "pic_specs_list", "video_source_tag_list" }, new Object[] { null, null, null, null }, RspGetConfig.class);
    public final PBRepeatMessageField<qqstory_struct.PicSpecs> pic_specs_list = PBField.initRepeatMessage(qqstory_struct.PicSpecs.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserConfig> user_config = PBField.initRepeatMessage(qqstory_struct.UserConfig.class);
    public final PBRepeatMessageField<qqstory_struct.VideoSourceTagInfo> video_source_tag_list = PBField.initRepeatMessage(qqstory_struct.VideoSourceTagInfo.class);
  }
  
  public static final class RspGetConfigFile
    extends MessageMicro<RspGetConfigFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField config_download_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField config_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field config_file_type = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "result", "config_file_type", "config_download_url", "config_download_md5" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RspGetConfigFile.class);
    }
  }
  
  public static final class RspGetEmoticonPackList
    extends MessageMicro<RspGetEmoticonPackList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.EmoticonPack> pack_list = PBField.initRepeatMessage(qqstory_struct.EmoticonPack.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "pack_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetEmoticonPackList.class);
    }
  }
  
  public static final class RspGetFeedVisitor
    extends MessageMicro<RspGetFeedVisitor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 72 }, new String[] { "result", "user_list", "view_total_num" }, new Object[] { null, null, Integer.valueOf(0) }, RspGetFeedVisitor.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserSimpleInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserSimpleInfo.class);
    public final PBUInt32Field view_total_num = PBField.initUInt32(0);
  }
  
  public static final class RspGetFilterList
    extends MessageMicro<RspGetFilterList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FilterListPack> filter_list = PBField.initRepeatMessage(qqstory_struct.FilterListPack.class);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "filter_list", "is_end", "next_cookie", "frequency" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspGetFilterList.class);
    }
  }
  
  public static final class RspGetForbiddenList
    extends MessageMicro<RspGetForbiddenList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "user_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetForbiddenList.class);
    }
  }
  
  public static final class RspGetForbiddenStates
    extends MessageMicro<RspGetForbiddenStates>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user_list" }, new Object[] { null, null }, RspGetForbiddenStates.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  }
  
  public static final class RspGetFriendStoryNoExpireList
    extends MessageMicro<RspGetFriendStoryNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_list" }, new Object[] { null, null }, RspGetFriendStoryNoExpireList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.FriendStoryDes> story_list = PBField.initRepeatMessage(qqstory_struct.FriendStoryDes.class);
  }
  
  public static final class RspGetGroupVidList
    extends MessageMicro<RspGetGroupVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "user_vid_list" }, new Object[] { null, null }, RspGetGroupVidList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public qqstory_struct.UserVidList user_vid_list = new qqstory_struct.UserVidList();
  }
  
  public static final class RspGetHomePOI
    extends MessageMicro<RspGetHomePOI>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "country", "city" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2 }, RspGetHomePOI.class);
    }
  }
  
  public static final class RspGetHotTopicInfo
    extends MessageMicro<RspGetHotTopicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field bkg_color = PBField.initUInt32(0);
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField guide_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field join_count = PBField.initUInt32(0);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField topic_label = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48, 58, 66 }, new String[] { "result", "pic_url", "subject", "join_count", "guide_word", "bkg_color", "topic_label", "cover_url" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, RspGetHotTopicInfo.class);
    }
  }
  
  public static final class RspGetHotTopicPack
    extends MessageMicro<RspGetHotTopicPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.HotTopicPack> topic_list = PBField.initRepeatMessage(qqstory_struct.HotTopicPack.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "topic_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetHotTopicPack.class);
    }
  }
  
  public static final class RspGetHotTopicVideoList
    extends MessageMicro<RspGetHotTopicVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField topic_desc = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field totle_time = PBField.initUInt64(0L);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58 }, new String[] { "result", "video_list", "is_end", "next_cookie", "totle_time", "video_count", "topic_desc" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro2 }, RspGetHotTopicVideoList.class);
    }
  }
  
  public static final class RspGetJoinedShareGroupFriList
    extends MessageMicro<RspGetJoinedShareGroupFriList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatField<ByteStringMicro> uin_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "uin_list" }, new Object[] { null, localByteStringMicro }, RspGetJoinedShareGroupFriList.class);
    }
  }
  
  public static final class RspGetLabelList
    extends MessageMicro<RspGetLabelList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> label_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "label_list", "is_end", "next_cookie" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, RspGetLabelList.class);
    }
  }
  
  public static final class RspGetLikeList
    extends MessageMicro<RspGetLikeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "result", "like_list", "like_total_count" }, new Object[] { null, null, Integer.valueOf(0) }, RspGetLikeList.class);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoLikeInfo> like_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoLikeInfo.class);
    public final PBUInt32Field like_total_count = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetLocation
    extends MessageMicro<RspGetLocation>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField district = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "result", "country", "province", "city", "district", "street" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, RspGetLocation.class);
    }
  }
  
  public static final class RspGetMissStoryInfo
    extends MessageMicro<RspGetMissStoryInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "word" }, new Object[] { null, localByteStringMicro }, RspGetMissStoryInfo.class);
    }
  }
  
  public static final class RspGetMusicListConfig
    extends MessageMicro<RspGetMusicListConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "music_config" }, new Object[] { null, null }, RspGetMusicListConfig.class);
    public final PBRepeatMessageField<qqstory_struct.MusicConfigInfo> music_config = PBField.initRepeatMessage(qqstory_struct.MusicConfigInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetOfficialRecommends
    extends MessageMicro<RspGetOfficialRecommends>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field recom_count = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.RecommendItem> recom_item_list = PBField.initRepeatMessage(qqstory_struct.RecommendItem.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "result", "recom_item_list", "recom_count", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspGetOfficialRecommends.class);
    }
  }
  
  public static final class RspGetPOIList
    extends MessageMicro<RspGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.Address> poi_list = PBField.initRepeatMessage(qqstory_struct.Address.class);
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58, 66 }, new String[] { "result", "poi_list", "is_end", "next_cookie", "country", "province", "city", "street" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, RspGetPOIList.class);
    }
  }
  
  public static final class RspGetPOIMarkPack
    extends MessageMicro<RspGetPOIMarkPack>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField country = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.EmoticonPack poi_mark_pack = new qqstory_struct.EmoticonPack();
    public final PBBytesField province = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField street = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "result", "poi_mark_pack", "country", "province", "city", "street" }, new Object[] { null, null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspGetPOIMarkPack.class);
    }
  }
  
  public static final class RspGetPOIPosters
    extends MessageMicro<RspGetPOIPosters>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "poi_posters" }, new Object[] { null, null }, RspGetPOIPosters.class);
    public final PBRepeatMessageField<qqstory_struct.POIPosterData> poi_posters = PBField.initRepeatMessage(qqstory_struct.POIPosterData.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetPhotographyGuide
    extends MessageMicro<RspGetPhotographyGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> word = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "result", "word", "seqno" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, RspGetPhotographyGuide.class);
    }
  }
  
  public static final class RspGetPreloadVideoList
    extends MessageMicro<RspGetPreloadVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "preload_video_list" }, new Object[] { null, null }, RspGetPreloadVideoList.class);
    public final PBRepeatMessageField<qqstory_struct.PreloadVideoInfo> preload_video_list = PBField.initRepeatMessage(qqstory_struct.PreloadVideoInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetPromoteTaskList
    extends MessageMicro<RspGetPromoteTaskList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_global_promote_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_service.PromoteTask> promote_tasks = PBField.initRepeatMessage(qqstory_service.PromoteTask.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "result", "bytes_cookie", "promote_tasks", "uint64_expire_time", "bytes_global_promote_url" }, new Object[] { null, localByteStringMicro1, null, Long.valueOf(0L), localByteStringMicro2 }, RspGetPromoteTaskList.class);
    }
  }
  
  public static final class RspGetPublicCommentList
    extends MessageMicro<RspGetPublicCommentList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "comment_list", "is_end", "total_comment_num" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, RspGetPublicCommentList.class);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoCommentInfo> comment_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoCommentInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
  }
  
  public static final class RspGetPublishConfig
    extends MessageMicro<RspGetPublishConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "result", "show_now_entry", "can_take_picture", "is_firsttime_show_take_pic", "video_use_bdh" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetPublishConfig.class);
    public final PBUInt32Field can_take_picture = PBField.initUInt32(0);
    public final PBUInt32Field is_firsttime_show_take_pic = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field show_now_entry = PBField.initUInt32(0);
    public final PBUInt32Field video_use_bdh = PBField.initUInt32(0);
  }
  
  public static final class RspGetRelatedVideoList
    extends MessageMicro<RspGetRelatedVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "video_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetRelatedVideoList.class);
    }
  }
  
  public static final class RspGetShareGroupInfo
    extends MessageMicro<RspGetShareGroupInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "share_group_info_list" }, new Object[] { null, null }, RspGetShareGroupInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.ShareGroupInfo> share_group_info_list = PBField.initRepeatMessage(qqstory_struct.ShareGroupInfo.class);
  }
  
  public static final class RspGetShareGroupMemList
    extends MessageMicro<RspGetShareGroupMemList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_count = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "union_id_list", "total_count", "next_cookie", "is_end" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, RspGetShareGroupMemList.class);
    }
  }
  
  public static final class RspGetShareVideoList
    extends MessageMicro<RspGetShareVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.StoryVideoFullInfo> full_video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoFullInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoBasicInfo> video_info_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoBasicInfo.class);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "result", "video_list", "is_end", "next_cookie", "video_info_list", "full_video_info_list" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, null, null }, RspGetShareVideoList.class);
    }
  }
  
  public static final class RspGetSquareBannerItemList
    extends MessageMicro<RspGetSquareBannerItemList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "item_list" }, new Object[] { null, null }, RspGetSquareBannerItemList.class);
    public final PBRepeatMessageField<qqstory_struct.SquareBannerItem> item_list = PBField.initRepeatMessage(qqstory_struct.SquareBannerItem.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspGetStoryDes
    extends MessageMicro<RspGetStoryDes>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_list" }, new Object[] { null, null }, RspGetStoryDes.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryDes> story_list = PBField.initRepeatMessage(qqstory_struct.StoryDes.class);
  }
  
  public static final class RspGetStoryUinList
    extends MessageMicro<RspGetStoryUinList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> union_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_info_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50 }, new String[] { "result", "uin_list", "is_end", "next_cookie", "union_id_list", "user_info_list" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, RspGetStoryUinList.class);
    }
  }
  
  public static final class RspGetStoryUinNoExpireList
    extends MessageMicro<RspGetStoryUinNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UserSeqInfo> user_seq_info_list = PBField.initRepeatMessage(qqstory_struct.UserSeqInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "user_seq_info_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspGetStoryUinNoExpireList.class);
    }
  }
  
  public static final class RspGetTagInfo
    extends MessageMicro<RspGetTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "tag_info", "music_type", "music_id" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, RspGetTagInfo.class);
    public final PBUInt64Field music_id = PBField.initUInt64(0L);
    public final PBUInt32Field music_type = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
  }
  
  public static final class RspGetTagList
    extends MessageMicro<RspGetTagList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "tag_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), "" }, RspGetTagList.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBStringField next_cookie = PBField.initString("");
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.TagItem> tag_list = PBField.initRepeatMessage(qqstory_struct.TagItem.class);
  }
  
  public static final class RspGetUnWatchStoryList
    extends MessageMicro<RspGetUnWatchStoryList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UnWatchStoryDes> story_list = PBField.initRepeatMessage(qqstory_struct.UnWatchStoryDes.class);
    public final PBRepeatMessageField<qqstory_struct.StoryDes> zombie_friends = PBField.initRepeatMessage(qqstory_struct.StoryDes.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "result", "story_list", "is_end", "next_cookie", "zombie_friends" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, null }, RspGetUnWatchStoryList.class);
    }
  }
  
  public static final class RspGetUnWatchStoryNoExpireList
    extends MessageMicro<RspGetUnWatchStoryNoExpireList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "story_list" }, new Object[] { null, null }, RspGetUnWatchStoryNoExpireList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.UnWatchStoryDes> story_list = PBField.initRepeatMessage(qqstory_struct.UnWatchStoryDes.class);
  }
  
  public static final class RspGetUnreadLiker
    extends MessageMicro<RspGetUnreadLiker>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field unread_like_total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "user_list", "is_end", "next_cookie", "unread_like_total_num" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspGetUnreadLiker.class);
    }
  }
  
  public static final class RspGetUserGuide
    extends MessageMicro<RspGetUserGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cancel_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField confirm_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBBytesField word = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50 }, new String[] { "result", "pic_url", "word", "seqno", "confirm_word", "cancel_word" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, RspGetUserGuide.class);
    }
  }
  
  public static final class RspGetUserSelfInfo
    extends MessageMicro<RspGetUserSelfInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field fans_count = PBField.initUInt32(0);
    public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_vip = PBField.initUInt32(0);
    public final PBBytesField newest_video_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField newest_video_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_count = PBField.initUInt32(0);
    public final PBUInt32Field visit_total_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58, 66, 74 }, new String[] { "result", "is_vip", "fans_count", "union_id", "video_count", "visit_total_count", "newest_video_cover", "newest_video_vid", "head_url" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspGetUserSelfInfo.class);
    }
  }
  
  public static final class RspGetUserShareGroupList
    extends MessageMicro<RspGetUserShareGroupList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.ShareGroupInfo> share_group_info = PBField.initRepeatMessage(qqstory_struct.ShareGroupInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "result", "share_group_info", "next_cookie", "is_end" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0) }, RspGetUserShareGroupList.class);
    }
  }
  
  public static final class RspGetUserVideoInfo
    extends MessageMicro<RspGetUserVideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "video_info", "base_info" }, new Object[] { null, null, null }, RspGetUserVideoInfo.class);
    public qqstory_struct.StoryVideoBasicInfo base_info = new qqstory_struct.StoryVideoBasicInfo();
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public qqstory_struct.StoryVideoDes video_info = new qqstory_struct.StoryVideoDes();
  }
  
  public static final class RspGetUserVideoList
    extends MessageMicro<RspGetUserVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.LiveVideoDes live_video_des = new qqstory_struct.LiveVideoDes();
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt64Field story_video_list_total_time = PBField.initUInt64(0L);
    public final PBRepeatMessageField<qqstory_struct.StoryVideoDes> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoDes.class);
    public final PBUInt32Field video_list_total_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 58, 64 }, new String[] { "result", "video_list", "is_end", "next_cookie", "story_video_list_total_time", "video_list_total_count", "live_video_des", "seq" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0) }, RspGetUserVideoList.class);
    }
  }
  
  public static final class RspGetWatcher
    extends MessageMicro<RspGetWatcher>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field like_total_num = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field stranger_like_total_num = PBField.initUInt32(0);
    public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
    public final PBUInt32Field view_total_num = PBField.initUInt32(0);
    public final PBUInt32Field view_total_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "result", "user_list", "is_end", "next_cookie", "view_total_num", "stranger_view_total_num", "like_total_num", "stranger_like_total_num", "view_total_time" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetWatcher.class);
    }
  }
  
  public static final class RspGetWeather
    extends MessageMicro<RspGetWeather>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "result", "temperature", "wea_desc" }, new Object[] { null, Integer.valueOf(0), "" }, RspGetWeather.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBInt32Field temperature = PBField.initInt32(0);
    public final PBStringField wea_desc = PBField.initString("");
  }
  
  public static final class RspGroupDateVideoList
    extends MessageMicro<RspGroupDateVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.GroupNodeInfo> group_node_info = PBField.initRepeatMessage(qqstory_struct.GroupNodeInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42 }, new String[] { "result", "is_end", "next_cookie", "seqno", "group_node_info" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, RspGroupDateVideoList.class);
    }
  }
  
  public static final class RspIconPostfix
    extends MessageMicro<RspIconPostfix>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "icon_info" }, new Object[] { null, null }, RspIconPostfix.class);
    public final PBRepeatMessageField<qqstory_struct.IconInfo> icon_info = PBField.initRepeatMessage(qqstory_struct.IconInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspJoinShareGroup
    extends MessageMicro<RspJoinShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "total_member_count" }, new Object[] { null, Integer.valueOf(0) }, RspJoinShareGroup.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_member_count = PBField.initUInt32(0);
  }
  
  public static final class RspLikeFeed
    extends MessageMicro<RspLikeFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspLikeFeed.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspLikeVideo
    extends MessageMicro<RspLikeVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspLikeVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspLoadMoreVideoList
    extends MessageMicro<RspLoadMoreVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.GroupStoryInfo> video_list = PBField.initRepeatMessage(qqstory_struct.GroupStoryInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "result", "is_end", "next_cookie", "video_list" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, null }, RspLoadMoreVideoList.class);
    }
  }
  
  public static final class RspMarkAsRead
    extends MessageMicro<RspMarkAsRead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspMarkAsRead.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspMonitorValue
    extends MessageMicro<RspMonitorValue>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspMonitorValue.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspMsgListHeadNode
    extends MessageMicro<RspMsgListHeadNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField list_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_service.MsgTabNodeInfo> node_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "result", "list_seq", "node_list" }, new Object[] { null, localByteStringMicro, null }, RspMsgListHeadNode.class);
    }
  }
  
  public static final class RspMsgTabNodeList
    extends MessageMicro<RspMsgTabNodeList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field is_animate = PBField.initUInt32(0);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField list_seq = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_service.MsgTabNodeInfo> node_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "result", "list_seq", "next_cookie", "is_end", "node_list", "is_animate" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), null, Integer.valueOf(0) }, RspMsgTabNodeList.class);
    }
  }
  
  public static final class RspMsgTabNodeVideoList
    extends MessageMicro<RspMsgTabNodeVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "video_list", "is_end", "cookie" }, new Object[] { null, null, Integer.valueOf(0), "" }, RspMsgTabNodeVideoList.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_service.MsgTabNodeVidInfo> video_list = PBField.initRepeatMessage(qqstory_service.MsgTabNodeVidInfo.class);
  }
  
  public static final class RspMsgTabNodeWatched
    extends MessageMicro<RspMsgTabNodeWatched>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspMsgTabNodeWatched.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspMultiRcmdDisLike
    extends MessageMicro<RspMultiRcmdDisLike>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspMultiRcmdDisLike.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspMyStoryNode
    extends MessageMicro<RspMyStoryNode>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field has_more_feed = PBField.initUInt32(0);
    public final PBBytesField has_more_feed_cover = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_struct.StoryDayNode> list = PBField.initRepeatMessage(qqstory_struct.StoryDayNode.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "list", "has_more_feed", "has_more_feed_cover" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspMyStoryNode.class);
    }
  }
  
  public static final class RspPreloadVideoList
    extends MessageMicro<RspPreloadVideoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "preload_info_list" }, new Object[] { null, null }, RspPreloadVideoList.class);
    public final PBRepeatMessageField<qqstory_struct.PreloadInfo> preload_info_list = PBField.initRepeatMessage(qqstory_struct.PreloadInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspProfileStoryFeedIdList
    extends MessageMicro<RspProfileStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_seq_info_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "feed_seq_info_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro }, RspProfileStoryFeedIdList.class);
    }
  }
  
  public static final class RspProfileYearNodeList
    extends MessageMicro<RspProfileYearNodeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "year_node_list" }, new Object[] { null, null }, RspProfileYearNodeList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.YearNodeInfo> year_node_list = PBField.initRepeatMessage(qqstory_struct.YearNodeInfo.class);
  }
  
  public static final class RspPublishVideo
    extends MessageMicro<RspPublishVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<qqstory_group.GroupFeed> group_feed_list = PBField.initRepeatMessage(qqstory_group.GroupFeed.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field video_index = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 56, 66 }, new String[] { "result", "create_time", "feed_id", "date", "story_id", "group_feed_list", "video_index", "vid" }, new Object[] { null, Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, Long.valueOf(0L), localByteStringMicro3 }, RspPublishVideo.class);
    }
  }
  
  public static final class RspQQStoryGuide
    extends MessageMicro<RspQQStoryGuide>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspQQStoryGuide.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspRecordZombieRead
    extends MessageMicro<RspRecordZombieRead>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspRecordZombieRead.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspRemoveMemberListFromShareGroup
    extends MessageMicro<RspRemoveMemberListFromShareGroup>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "total_member_count" }, new Object[] { null, Integer.valueOf(0) }, RspRemoveMemberListFromShareGroup.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_member_count = PBField.initUInt32(0);
  }
  
  public static final class RspReportComment
    extends MessageMicro<RspReportComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspReportComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspReportEvil
    extends MessageMicro<RspReportEvil>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspReportEvil.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspReportFeedComment
    extends MessageMicro<RspReportFeedComment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspReportFeedComment.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspSetConfig
    extends MessageMicro<RspSetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspSetConfig.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspShareToDiscover
    extends MessageMicro<RspShareToDiscover>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, RspShareToDiscover.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspShareVideoCollectionList
    extends MessageMicro<RspShareVideoCollectionList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.ShareGroupFeed> collection_list = PBField.initRepeatMessage(qqstory_struct.ShareGroupFeed.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt64Field seqno = PBField.initUInt64(0L);
    public final PBUInt32Field total_share_group_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48 }, new String[] { "result", "collection_list", "is_end", "next_cookie", "total_share_group_count", "seqno" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, RspShareVideoCollectionList.class);
    }
  }
  
  public static final class RspSimpleInfoList
    extends MessageMicro<RspSimpleInfoList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "video_list" }, new Object[] { null, null }, RspSimpleInfoList.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.StoryVideoSimpleInfo> video_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoSimpleInfo.class);
  }
  
  public static final class RspStoryCreateVideoTag
    extends MessageMicro<RspStoryCreateVideoTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "tag_info" }, new Object[] { null, null }, RspStoryCreateVideoTag.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public qqstory_struct.TagInfoBase tag_info = new qqstory_struct.TagInfoBase();
  }
  
  public static final class RspStoryFeed
    extends MessageMicro<RspStoryFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_list" }, new Object[] { null, null }, RspStoryFeed.class);
    public final PBRepeatMessageField<qqstory_struct.StoryFeed> feed_list = PBField.initRepeatMessage(qqstory_struct.StoryFeed.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspStoryFeedIdList
    extends MessageMicro<RspStoryFeedIdList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<qqstory_struct.FeedSeqInfo> feed_seq_info_list = PBField.initRepeatMessage(qqstory_struct.FeedSeqInfo.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBUInt32Field is_today_end = PBField.initUInt32(0);
    public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40 }, new String[] { "result", "feed_seq_info_list", "is_end", "next_cookie", "is_today_end" }, new Object[] { null, null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RspStoryFeedIdList.class);
    }
  }
  
  public static final class RspStoryFeedTagInfo
    extends MessageMicro<RspStoryFeedTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "tag_info" }, new Object[] { null, null }, RspStoryFeedTagInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.TagInfoBaseList> tag_info = PBField.initRepeatMessage(qqstory_struct.TagInfoBaseList.class);
  }
  
  public static final class RspStoryPlayerTagInfo
    extends MessageMicro<RspStoryPlayerTagInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "tag_info" }, new Object[] { null, null }, RspStoryPlayerTagInfo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.TagInfoBaseVidList> tag_info = PBField.initRepeatMessage(qqstory_struct.TagInfoBaseVidList.class);
  }
  
  public static final class RspStorySearchVideoTag
    extends MessageMicro<RspStorySearchVideoTag>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "result", "video_tag_list", "is_end", "next_cookie" }, new Object[] { null, null, Integer.valueOf(0), "" }, RspStorySearchVideoTag.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBStringField next_cookie = PBField.initString("");
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct.TagInfoBase> video_tag_list = PBField.initRepeatMessage(qqstory_struct.TagInfoBase.class);
  }
  
  public static final class RspStorySubmitPollData
    extends MessageMicro<RspStorySubmitPollData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "result", "video_poll_result", "comment_id", "fake_id" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspStorySubmitPollData.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatField<Integer> video_poll_result = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class RspStorySubmitQAData
    extends MessageMicro<RspStorySubmitQAData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "result", "comment_id", "fake_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L) }, RspStorySubmitQAData.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspStorySubmitRateData
    extends MessageMicro<RspStorySubmitRateData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "result", "total_rate_count", "total_rate_score", "comment_id", "fake_id" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, RspStorySubmitRateData.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field fake_id = PBField.initUInt64(0L);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field total_rate_count = PBField.initUInt32(0);
    public final PBUInt64Field total_rate_score = PBField.initUInt64(0L);
  }
  
  public static final class RspSyncVideoPublish
    extends MessageMicro<RspSyncVideoPublish>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "publish_result" }, new Object[] { null, null }, RspSyncVideoPublish.class);
    public qqstory_service.RspPublishVideo publish_result = new qqstory_service.RspPublishVideo();
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspTodayStoryVidList
    extends MessageMicro<RspTodayStoryVidList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field share_to_discover = PBField.initUInt32(0);
    public final PBRepeatField<ByteStringMicro> vid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 48 }, new String[] { "result", "vid_list", "feed_id", "is_end", "cookie", "share_to_discover" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0) }, RspTodayStoryVidList.class);
    }
  }
  
  public static final class RspTranslateToken
    extends MessageMicro<RspTranslateToken>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField dst_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField oldest_vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field shoot_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "result", "dst_buffer", "cover_url", "shoot_time", "oldest_vid" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, RspTranslateToken.class);
    }
  }
  
  public static final class RspUploadStoryVideo
    extends MessageMicro<RspUploadStoryVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field exists = PBField.initUInt32(0);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBBytesField server_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 50 }, new String[] { "result", "server_ip", "server_port", "exists", "check_key", "vid" }, new Object[] { null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, RspUploadStoryVideo.class);
    }
  }
  
  public static final class RspVideoReaderConf
    extends MessageMicro<RspVideoReaderConf>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "reader_conf" }, new Object[] { null, null }, RspVideoReaderConf.class);
    public qqstory_struct.VideoReaderConf reader_conf = new qqstory_struct.VideoReaderConf();
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  }
  
  public static final class RspWatchVideo
    extends MessageMicro<RspWatchVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "result", "unread_count" }, new Object[] { null, Integer.valueOf(0) }, RspWatchVideo.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBUInt32Field unread_count = PBField.initUInt32(0);
  }
  
  public static final class RspWatchVideoBatch
    extends MessageMicro<RspWatchVideoBatch>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "succ_video_list" }, new Object[] { null, null }, RspWatchVideoBatch.class);
    public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
    public final PBRepeatMessageField<qqstory_service.VideoItem> succ_video_list = PBField.initRepeatMessage(qqstory_service.VideoItem.class);
  }
  
  public static final class VideoItem
    extends MessageMicro<VideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field is_live_video = PBField.initUInt32(0);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBBytesField to_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field vid_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 32, 40, 48, 56 }, new String[] { "vid", "to_union_id", "is_live_video", "source", "create_time", "vid_type" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, VideoItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service
 * JD-Core Version:    0.7.0.1
 */