package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserExtraInfo;
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

public final class FeedsProtocol
{
  public static final class ClearAnchorRedPointReq
    extends MessageMicro<ClearAnchorRedPointReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "anchor_uid", "feed_id" }, new Object[] { Long.valueOf(0L), "" }, ClearAnchorRedPointReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
    public final PBStringField feed_id = PBField.initString("");
  }
  
  public static final class ClearAnchorRedPointRsp
    extends MessageMicro<ClearAnchorRedPointRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, ClearAnchorRedPointRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class DelFeedReq
    extends MessageMicro<DelFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> feed_ids = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_ids" }, new Object[] { localByteStringMicro }, DelFeedReq.class);
    }
  }
  
  public static final class DelFeedRsp
    extends MessageMicro<DelFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, DelFeedRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class FeedDetailByIdReq
    extends MessageMicro<FeedDetailByIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "feed_id", "type", "follow_type", "follow_uid" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, FeedDetailByIdReq.class);
    }
  }
  
  public static final class FeedDetailByIdRsp
    extends MessageMicro<FeedDetailByIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "media_infos", "is_end", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, FeedDetailByIdRsp.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public FeedsProtocol.MediaInfo media_infos = new FeedsProtocol.MediaInfo();
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class FeedDetailByIdsReq
    extends MessageMicro<FeedDetailByIdsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feed_ids" }, new Object[] { null }, FeedDetailByIdsReq.class);
    public final PBRepeatMessageField<FeedsProtocol.FeedIds> feed_ids = PBField.initRepeatMessage(FeedsProtocol.FeedIds.class);
  }
  
  public static final class FeedDetailByIdsRsp
    extends MessageMicro<FeedDetailByIdsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "media_infos", "is_end", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, FeedDetailByIdsRsp.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol.MediaInfo> media_infos = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class FeedDetailReq
    extends MessageMicro<FeedDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid", "feed_id" }, new Object[] { Long.valueOf(0L), "" }, FeedDetailReq.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class FeedDetailRsp
    extends MessageMicro<FeedDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "media_infos", "is_end", "total" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, FeedDetailRsp.class);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol.MediaInfo> media_infos = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class FeedIds
    extends MessageMicro<FeedIds>
  {
    public static final int LIVE_AGGREGATE = 1;
    public static final int SHORT_VIDEO = 3;
    public static final int VIDEO_LIST = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "feed_id", "type", "follow_type", "follow_uid" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, FeedIds.class);
    }
  }
  
  public static final class FeedPreLoadInfo
    extends MessageMicro<FeedPreLoadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField doodle_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic_url", "video_url", "doodle_pic_url", "file_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, FeedPreLoadInfo.class);
    }
  }
  
  public static final class FeedViewOverReq
    extends MessageMicro<FeedViewOverReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "anchor_uid", "update_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, FeedViewOverReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
    public final PBUInt64Field update_time = PBField.initUInt64(0L);
  }
  
  public static final class FeedViewOverRsp
    extends MessageMicro<FeedViewOverRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, FeedViewOverRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    public static final int LIVE_AGGREGATE = 1;
    public static final int LIVE_ANCHOR = 4;
    public static final int MINE_FEED = 5;
    public static final int SHORT_VIDEO = 3;
    public static final int VIDEO_LIST = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedsProtocol.UserInfo anchor_info = new FeedsProtocol.UserInfo();
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedsProtocol.FeedPreLoadInfo feed_preload = new FeedsProtocol.FeedPreLoadInfo();
    public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_new = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField native_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedsProtocol.UserInfo publish_info = new FeedsProtocol.UserInfo();
    public final PBBytesField room_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field short_video_num = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0L);
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 48, 58, 64, 74, 80, 90, 98, 106, 114, 122 }, new String[] { "id", "type", "user_info", "view_times", "room_img_url", "update_time", "content", "short_video_num", "jump_url", "is_new", "feed_id", "publish_info", "anchor_info", "feed_preload", "native_jump_url" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, null, null, null, localByteStringMicro6 }, FeedsInfo.class);
    }
  }
  
  public static final class FollowFeedReq
    extends MessageMicro<FollowFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start", "num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, FollowFeedReq.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class FollowFeedRsp
    extends MessageMicro<FollowFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.FeedsInfo> msg_feeds = PBField.initRepeatMessage(FeedsProtocol.FeedsInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "result", "errmsg", "total", "end_flag", "msg_feeds" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, FollowFeedRsp.class);
    }
  }
  
  public static final class GetLivingAnchorListReq
    extends MessageMicro<GetLivingAnchorListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start", "num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, GetLivingAnchorListReq.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
  }
  
  public static final class GetLivingAnchorListRsp
    extends MessageMicro<GetLivingAnchorListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.LivingAnchorInfo> living_list = PBField.initRepeatMessage(FeedsProtocol.LivingAnchorInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "living_list", "result", "errmsg", "total" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, GetLivingAnchorListRsp.class);
    }
  }
  
  public static final class GetMediaDetailReq
    extends MessageMicro<GetMediaDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField querystring = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "querystring" }, new Object[] { localByteStringMicro }, GetMediaDetailReq.class);
    }
  }
  
  public static final class GetMediaDetailRsp
    extends MessageMicro<GetMediaDetailRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_end = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol.MediaInfo> media_list = PBField.initRepeatMessage(FeedsProtocol.MediaInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "media_list", "err_code", "err_msg", "is_end", "total" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetMediaDetailRsp.class);
    }
  }
  
  public static final class LbsInfo
    extends MessageMicro<LbsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField city = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "lng", "lat", "city", "name" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, LbsInfo.class);
    }
  }
  
  public static final class LiveAggregateInfo
    extends MessageMicro<LiveAggregateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "video", "short_video", "total_short_size", "id" }, new Object[] { null, null, Integer.valueOf(0), "" }, LiveAggregateInfo.class);
    public final PBStringField id = PBField.initString("");
    public final PBRepeatMessageField<FeedsProtocol.ShortVideoInfo> short_video = PBField.initRepeatMessage(FeedsProtocol.ShortVideoInfo.class);
    public final PBUInt32Field total_short_size = PBField.initUInt32(0);
    public FeedsProtocol.VideoItem video = new FeedsProtocol.VideoItem();
  }
  
  public static final class LiveAnchorItem
    extends MessageMicro<LiveAnchorItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_type = PBField.initUInt32(0);
    public final PBUInt64Field begin_time = PBField.initUInt64(0L);
    public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField location = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBBytesField room_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
    public final PBUInt32Field sub_room_id = PBField.initUInt32(0);
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBUInt32Field watch_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 72, 80, 88, 96 }, new String[] { "id", "user_info", "room_name", "rpt_msg_rich_title", "room_img_url", "location", "watch_count", "jump_url", "anchor_type", "room_id", "sub_room_id", "begin_time" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, null, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, LiveAnchorItem.class);
    }
  }
  
  public static final class LivingAnchorInfo
    extends MessageMicro<LivingAnchorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "anchor_id", "room_id", "subroom_id", "start_time", "logo_key" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, LivingAnchorInfo.class);
    public final PBUInt64Field anchor_id = PBField.initUInt64(0L);
    public final PBUInt32Field logo_key = PBField.initUInt32(0);
    public final PBUInt32Field room_id = PBField.initUInt32(0);
    public final PBUInt64Field start_time = PBField.initUInt64(0L);
    public final PBUInt32Field subroom_id = PBField.initUInt32(0);
  }
  
  public static final class MediaInfo
    extends MessageMicro<MediaInfo>
  {
    public static final int LIVE_AGGREGATE = 1;
    public static final int LIVE_ANCHOR = 4;
    public static final int PIC_FEEDS = 5;
    public static final int SHORT_VIDEO = 3;
    public static final int TEXT_FEEDS = 6;
    public static final int VIDEO_LIST = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 810, 816, 826 }, new String[] { "type", "msg_live_anchor", "video", "short_video", "live_aggregate", "pic_info", "topic_cfg", "is_my_feeds", "text_feed" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, Integer.valueOf(0), null }, MediaInfo.class);
    public final PBUInt32Field is_my_feeds = PBField.initUInt32(0);
    public FeedsProtocol.LiveAggregateInfo live_aggregate = new FeedsProtocol.LiveAggregateInfo();
    public FeedsProtocol.LiveAnchorItem msg_live_anchor = new FeedsProtocol.LiveAnchorItem();
    public FeedsProtocol.PicFeedsInfo pic_info = new FeedsProtocol.PicFeedsInfo();
    public FeedsProtocol.ShortVideoInfo short_video = new FeedsProtocol.ShortVideoInfo();
    public FeedsProtocol.TextFeed text_feed = new FeedsProtocol.TextFeed();
    public final PBRepeatMessageField<FeedsProtocol.TopicCfg> topic_cfg = PBField.initRepeatMessage(FeedsProtocol.TopicCfg.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public FeedsProtocol.VideoItem video = new FeedsProtocol.VideoItem();
  }
  
  public static final class PersonFeedReq
    extends MessageMicro<PersonFeedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "num", "uid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PersonFeedReq.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class PersonFeedRsp
    extends MessageMicro<PersonFeedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.FeedsInfo> msg_feeds = PBField.initRepeatMessage(FeedsProtocol.FeedsInfo.class);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "result", "errmsg", "total", "end_flag", "msg_feeds" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), null }, PersonFeedRsp.class);
    }
  }
  
  public static final class PicFeedsInfo
    extends MessageMicro<PicFeedsInfo>
  {
    public static final int FEED_SOURCE_ANDROID = 2;
    public static final int FEED_SOURCE_IOS = 1;
    public static final int TYPE_CHANG = 6;
    public static final int TYPE_CHANG_REPLAY = 7;
    public static final int TYPE_LIVE = 5;
    public static final int TYPE_PIC = 4;
    public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int TYPE_RECORD_VIDEO_FEED = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBUInt32Field feed_source = PBField.initUInt32(0);
    public final PBUInt32Field feed_type = PBField.initUInt32(0);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field is_like = PBField.initUInt32(0);
    public final PBUInt32Field is_listen = PBField.initUInt32(0);
    public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
    public final PBUInt32Field like_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol.PicInfo> pic_infos = PBField.initRepeatMessage(FeedsProtocol.PicInfo.class);
    public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
    public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 80, 88, 96, 104, 114, 122 }, new String[] { "user_info", "pic_infos", "create_time", "feed_type", "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", "like_num", "share_url", "lbs_info" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, null }, PicFeedsInfo.class);
    }
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field hight = PBField.initUInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "url", "hight", "width" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, PicInfo.class);
    }
  }
  
  public static final class RichTitleElement
    extends MessageMicro<RichTitleElement>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "text", "url" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, RichTitleElement.class);
    }
  }
  
  public static final class ShortVideoInfo
    extends MessageMicro<ShortVideoInfo>
  {
    public static final int FEED_SOURCE_ANDROID = 2;
    public static final int FEED_SOURCE_IOS = 1;
    public static final int FEED_STATUS_DELETE = 1;
    public static final int FEED_STATUS_INVALID = 2;
    public static final int FEED_STATUS_VALID = 0;
    public static final int TYPE_RECORD_LIVE_VIDEO_FEED = 1;
    public static final int TYPE_RECORD_STORY_VIDEO_FEED = 3;
    public static final int TYPE_RECORD_VIDEO_FEED = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public FeedsProtocol.UserInfo anchor_info = new FeedsProtocol.UserInfo();
    public final PBUInt32Field bg_color = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public final PBBytesField doodle_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField feed_source = PBField.initEnum(1);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
    public final PBUInt32Field is_like = PBField.initUInt32(0);
    public final PBUInt32Field is_listen = PBField.initUInt32(0);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
    public final PBUInt32Field like_num = PBField.initUInt32(0);
    public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
    public final PBBytesField share_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field up_status = PBField.initUInt32(0);
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_hight = PBField.initUInt32(0);
    public final PBUInt32Field video_time = PBField.initUInt32(0);
    public final PBBytesField video_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_width = PBField.initUInt32(0);
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74, 80, 90, 96, 104, 112, 122, 128, 136, 144, 154, 160, 170, 176, 186, 192, 202 }, new String[] { "user_info", "pic_url", "video_url", "anchor_info", "create_time", "feed_type", "feed_source", "feeds_id", "file_id", "video_time", "rpt_msg_rich_title", "view_times", "video_width", "video_hight", "doodle_pic_url", "is_listen", "is_like", "like_num", "share_url", "follow_uid", "jump_url", "up_status", "lbs_info", "bg_color", "vid" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, null, Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(1), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Long.valueOf(0L), localByteStringMicro7, Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro8 }, ShortVideoInfo.class);
    }
  }
  
  public static final class TabRedPointReq
    extends MessageMicro<TabRedPointReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_get" }, new Object[] { Boolean.valueOf(false) }, TabRedPointReq.class);
    public final PBBoolField is_get = PBField.initBool(false);
  }
  
  public static final class TabRedPointRsp
    extends MessageMicro<TabRedPointRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_red" }, new Object[] { Boolean.valueOf(false) }, TabRedPointRsp.class);
    public final PBBoolField is_red = PBField.initBool(false);
  }
  
  public static final class TextFeed
    extends MessageMicro<TextFeed>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 80, 90, 98, 106, 114, 120, 130 }, new String[] { "user_info", "create_time", "feed_type", "feed_source", "feeds_id", "rpt_msg_rich_title", "is_listen", "view_times", "is_like", "like_num", "share_url", "lbs_info", "share_main_title", "share_subheading", "comment_num", "text" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null, "", "", Integer.valueOf(0), "" }, TextFeed.class);
    public final PBUInt32Field comment_num = PBField.initUInt32(0);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBUInt32Field feed_source = PBField.initUInt32(0);
    public final PBUInt32Field feed_type = PBField.initUInt32(0);
    public final PBStringField feeds_id = PBField.initString("");
    public final PBUInt32Field is_like = PBField.initUInt32(0);
    public final PBUInt32Field is_listen = PBField.initUInt32(0);
    public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
    public final PBUInt32Field like_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
    public final PBStringField share_main_title = PBField.initString("");
    public final PBStringField share_subheading = PBField.initString("");
    public final PBStringField share_url = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBUInt32Field view_times = PBField.initUInt32(0);
  }
  
  public static final class TopicCfg
    extends MessageMicro<TopicCfg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 810 }, new String[] { "topic_tag", "topic_desc", "topic_name", "topic_parti_num", "topic_type", "topic_pic_url", "jump_url" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "" }, TopicCfg.class);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField topic_desc = PBField.initString("");
    public final PBStringField topic_name = PBField.initString("");
    public final PBUInt32Field topic_parti_num = PBField.initUInt32(0);
    public final PBStringField topic_pic_url = PBField.initString("");
    public final PBUInt32Field topic_tag = PBField.initUInt32(0);
    public final PBUInt32Field topic_type = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    public static final int APP_FRIEND = 1;
    public static final int QQ_FRIEND = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBBytesField anchor_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field explicit_uid = PBField.initUInt64(0L);
    public final PBUInt32Field friend_type = PBField.initUInt32(0);
    public final PBBytesField head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBUInt32Field is_qq_user = PBField.initUInt32(0);
    public final PBUInt64Field tinyid = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public ilive_user_basic_info.UserExtraInfo userExtraInfo = new ilive_user_basic_info.UserExtraInfo();
    public final PBUInt32Field user_gender = PBField.initUInt32(0);
    public final PBBytesField user_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104 }, new String[] { "uid", "head_img_url", "anchor_name", "userExtraInfo", "friend_type", "user_logo_url", "is_qq_user", "uin", "user_gender", "age", "tinyid", "explicit_uid", "id_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, UserInfo.class);
    }
  }
  
  public static final class VideoItem
    extends MessageMicro<VideoItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field anchor_type = PBField.initUInt32(0);
    public final PBBytesField id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field live_duration_time = PBField.initUInt32(0);
    public final PBBytesField room_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField room_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FeedsProtocol.RichTitleElement> rpt_msg_rich_title = PBField.initRepeatMessage(FeedsProtocol.RichTitleElement.class);
    public final PBUInt32Field total_money = PBField.initUInt32(0);
    public final PBUInt32Field total_view = PBField.initUInt32(0);
    public FeedsProtocol.UserInfo user_info = new FeedsProtocol.UserInfo();
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField video_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field video_end_time = PBField.initUInt32(0);
    public final PBUInt64Field video_start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 72, 80, 90, 96, 104, 112 }, new String[] { "id", "user_info", "vid", "room_name", "rpt_msg_rich_title", "video_cover_url", "room_cover_url", "total_view", "total_money", "video_end_time", "jump_url", "anchor_type", "video_start_time", "live_duration_time" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, VideoItem.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.FeedsProtocol
 * JD-Core Version:    0.7.0.1
 */