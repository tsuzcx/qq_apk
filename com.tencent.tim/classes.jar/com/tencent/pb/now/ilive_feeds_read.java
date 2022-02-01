package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.MedalInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read
{
  public static final class FeedUserInfo
    extends MessageMicro<FeedUserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field age = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_user_basic_info.MedalInfo> medal_infos = PBField.initRepeatMessage(ilive_user_basic_info.MedalInfo.class);
    public final PBStringField nick = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field user_gender = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uin", "nick", "url", "medal_infos", "user_gender", "age" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0) }, FeedUserInfo.class);
    }
  }
  
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public ilive_feeds_tmem.ChangFeed chang_info = new ilive_feeds_tmem.ChangFeed();
    public final PBInt32Field comment_num = PBField.initInt32(0);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> comments = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
    public final PBUInt32Field create_time = PBField.initUInt32(0);
    public final PBDoubleField distance = PBField.initDouble(0.0D);
    public ilive_feeds_tmem.VideoFeed feed_info = new ilive_feeds_tmem.VideoFeed();
    public final PBEnumField feed_source = PBField.initEnum(0);
    public final PBEnumField feed_type = PBField.initEnum(1);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public FeedsProtocol.LbsInfo lbs_info = new FeedsProtocol.LbsInfo();
    public final PBInt32Field like = PBField.initInt32(0);
    public ilive_feeds_tmem.FeedsTmemLike like_info = new ilive_feeds_tmem.FeedsTmemLike();
    public ilive_feeds_tmem.LiveFeed live_info = new ilive_feeds_tmem.LiveFeed();
    public ilive_feeds_tmem.PicFeed pic_info = new ilive_feeds_tmem.PicFeed();
    public ilive_feeds_read.FeedUserInfo publish_info = new ilive_feeds_read.FeedUserInfo();
    public final PBUInt64Field publish_uin = PBField.initUInt64(0L);
    public final PBEnumField status = PBField.initEnum(1);
    public ilive_feeds_tmem.TextFeed text_feed = new ilive_feeds_tmem.TextFeed();
    public final PBRepeatMessageField<ilive_feeds_read.TopicCfg> topic_cfg = PBField.initRepeatMessage(ilive_feeds_read.TopicCfg.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBUInt32Field view_times = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 50, 58, 64, 72, 82, 90, 98, 106, 114, 122, 154, 800, 810, 818, 824, 832, 841, 850 }, new String[] { "publish_uin", "create_time", "feed_type", "feed_source", "feeds_id", "feed_info", "view_times", "status", "pic_info", "live_info", "chang_info", "jump_url", "publish_info", "lbs_info", "text_feed", "like", "like_info", "comments", "comment_num", "type", "distance", "topic_cfg" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro1, null, Integer.valueOf(0), Integer.valueOf(1), null, null, null, localByteStringMicro2, null, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), Integer.valueOf(0), Double.valueOf(0.0D), null }, FeedsInfo.class);
    }
  }
  
  public static final class FollowTabRedPointReq
    extends MessageMicro<FollowTabRedPointReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "op", "time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, FollowTabRedPointReq.class);
    public final PBInt32Field op = PBField.initInt32(0);
    public final PBInt64Field time = PBField.initInt64(0L);
  }
  
  public static final class FollowTabRedPointRsp
    extends MessageMicro<FollowTabRedPointRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field red = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "err_code", "err_msg", "red" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, FollowTabRedPointRsp.class);
    }
  }
  
  public static final class ReadFeedsByIdReq
    extends MessageMicro<ReadFeedsByIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> feeds_ids = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "feeds_ids" }, new Object[] { localByteStringMicro }, ReadFeedsByIdReq.class);
    }
  }
  
  public static final class ReadFeedsByIdRsp
    extends MessageMicro<ReadFeedsByIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "infos" }, new Object[] { null }, ReadFeedsByIdRsp.class);
    public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
  }
  
  public static final class ReadFollowFeedsReq
    extends MessageMicro<ReadFollowFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start_time", "num", "load_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReadFollowFeedsReq.class);
    public final PBUInt32Field load_num = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field start_time = PBField.initUInt64(0L);
  }
  
  public static final class ReadFollowFeedsRsp
    extends MessageMicro<ReadFollowFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "result", "err_msg", "end_flag", "infos", "total" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0) }, ReadFollowFeedsRsp.class);
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class ReadMediaDetailReq
    extends MessageMicro<ReadMediaDetailReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "feedid", "start", "num", "type", "follow_uid" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReadMediaDetailReq.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBUInt64Field follow_uid = PBField.initUInt64(0L);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReadMediaDetailRsp
    extends MessageMicro<ReadMediaDetailRsp>
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "media_list", "err_code", "err_msg", "is_end", "total" }, new Object[] { null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReadMediaDetailRsp.class);
    }
  }
  
  public static final class ReadNearUserFeedsReq
    extends MessageMicro<ReadNearUserFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field nowid = PBField.initUInt64(0L);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56 }, new String[] { "pos", "num", "uin", "lng", "lat", "nowid", "id_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0) }, ReadNearUserFeedsReq.class);
    }
  }
  
  public static final class ReadNearUserFeedsRsp
    extends MessageMicro<ReadNearUserFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "result", "err_msg", "end_flag", "infos", "total", "pos" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ReadNearUserFeedsRsp.class);
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
    public final PBUInt32Field pos = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class ReadNewUserFeedsReq
    extends MessageMicro<ReadNewUserFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "pos", "num", "uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReadNewUserFeedsReq.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt64Field pos = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ReadNewUserFeedsRsp
    extends MessageMicro<ReadNewUserFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "result", "err_msg", "end_flag", "infos", "total" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0) }, ReadNewUserFeedsRsp.class);
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class ReadOriginalFeedsReq
    extends MessageMicro<ReadOriginalFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uid", "type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReadOriginalFeedsReq.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class ReadOriginalFeedsRsp
    extends MessageMicro<ReadOriginalFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 34 }, new String[] { "result", "err_msg", "info" }, new Object[] { Integer.valueOf(0), "", null }, ReadOriginalFeedsRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public ilive_feeds_read.FeedsInfo info = new ilive_feeds_read.FeedsInfo();
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class ReadUserFeedsNumReq
    extends MessageMicro<ReadUserFeedsNumReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uid" }, new Object[] { Long.valueOf(0L) }, ReadUserFeedsNumReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
  }
  
  public static final class ReadUserFeedsNumRsp
    extends MessageMicro<ReadUserFeedsNumRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "result", "err_msg", "total" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ReadUserFeedsNumRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field total = PBField.initUInt32(0);
  }
  
  public static final class ReadUserFeedsReq
    extends MessageMicro<ReadUserFeedsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start", "num", "uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReadUserFeedsReq.class);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class ReadUserFeedsRsp
    extends MessageMicro<ReadUserFeedsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "infos", "total", "user_infos", "h5_url" }, new Object[] { null, Integer.valueOf(0), null, "" }, ReadUserFeedsRsp.class);
    public final PBStringField h5_url = PBField.initString("");
    public final PBRepeatMessageField<ilive_feeds_read.FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read.FeedsInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_read.FeedUserInfo> user_infos = PBField.initRepeatMessage(ilive_feeds_read.FeedUserInfo.class);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read
 * JD-Core Version:    0.7.0.1
 */