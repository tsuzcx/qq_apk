package com.tencent.pb.now;

import com.tencent.ilive_user_basic_info.ilive_user_basic_info.UserExtraInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowNearbyVideoCommentProto
{
  public static final class AddCommentNoFilterReq
    extends MessageMicro<AddCommentNoFilterReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 64, 72 }, new String[] { "feed_type", "feed_id", "video_recorder", "video_owner", "video_anchor", "reply_user", "content", "is_aggregate_short_video", "reply_comment_id" }, new Object[] { Long.valueOf(0L), "", null, null, null, null, null, Integer.valueOf(0), Long.valueOf(0L) }, AddCommentNoFilterReq.class);
    public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field feed_type = PBField.initUInt64(0L);
    public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
    public final PBUInt64Field reply_comment_id = PBField.initUInt64(0L);
    public NowNearbyVideoCommentProto.UserInfo reply_user = new NowNearbyVideoCommentProto.UserInfo();
    public NowNearbyVideoCommentProto.UserInfo video_anchor = new NowNearbyVideoCommentProto.UserInfo();
    public NowNearbyVideoCommentProto.UserInfo video_owner = new NowNearbyVideoCommentProto.UserInfo();
    public NowNearbyVideoCommentProto.UserInfo video_recorder = new NowNearbyVideoCommentProto.UserInfo();
  }
  
  public static final class AddCommentNoFilterResp
    extends MessageMicro<AddCommentNoFilterResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field comment_id = PBField.initUInt64(0L);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "result", "comment_id", "wording" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, AddCommentNoFilterResp.class);
    }
  }
  
  public static final class AddCommentReq
    extends MessageMicro<AddCommentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 64 }, new String[] { "feed_type", "feed_id", "record_uid", "reply_uid", "feed_owner", "content", "is_aggregate_short_video", "anchor_uid" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, AddCommentReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0L);
    public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field feed_owner = PBField.initUInt64(0L);
    public final PBUInt64Field feed_type = PBField.initUInt64(0L);
    public final PBUInt32Field is_aggregate_short_video = PBField.initUInt32(0);
    public final PBUInt64Field record_uid = PBField.initUInt64(0L);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  }
  
  public static final class AddCommentResp
    extends MessageMicro<AddCommentResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field comment_id = PBField.initUInt64(0L);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBBytesField wording = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "result", "comment_id", "wording" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, AddCommentResp.class);
    }
  }
  
  public static final class Comment
    extends MessageMicro<Comment>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "comment_id", "publish_info", "reply_info", "content", "create_time", "update_time", "type" }, new Object[] { Long.valueOf(0L), null, null, null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, Comment.class);
    public final PBUInt64Field comment_id = PBField.initUInt64(0L);
    public NowNearbyVideoCommentProto.CommentMsgBody content = new NowNearbyVideoCommentProto.CommentMsgBody();
    public final PBUInt64Field create_time = PBField.initUInt64(0L);
    public NowNearbyVideoCommentProto.UserInfo publish_info = new NowNearbyVideoCommentProto.UserInfo();
    public NowNearbyVideoCommentProto.UserInfo reply_info = new NowNearbyVideoCommentProto.UserInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field update_time = PBField.initUInt64(0L);
  }
  
  public static final class CommentMsg
    extends MessageMicro<CommentMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "type", "msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, CommentMsg.class);
    }
  }
  
  public static final class CommentMsgBody
    extends MessageMicro<CommentMsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msgs" }, new Object[] { null }, CommentMsgBody.class);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.CommentMsg> msgs = PBField.initRepeatMessage(NowNearbyVideoCommentProto.CommentMsg.class);
  }
  
  public static final class DelCommentReq
    extends MessageMicro<DelCommentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField biz_date = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field comment_id = PBField.initUInt64(0L);
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field from_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "comment_id", "feed_id", "from_type", "biz_date" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, DelCommentReq.class);
    }
  }
  
  public static final class DelCommentResp
    extends MessageMicro<DelCommentResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Long.valueOf(0L) }, DelCommentResp.class);
    public final PBUInt64Field result = PBField.initUInt64(0L);
  }
  
  public static final class GetCommentListNoFilterReq
    extends MessageMicro<GetCommentListNoFilterReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "feed_type", "feed_id", "page", "count", "filter", "need_usrinfo" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GetCommentListNoFilterReq.class);
    public final PBUInt64Field count = PBField.initUInt64(0L);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field feed_type = PBField.initUInt64(0L);
    public final PBUInt64Field filter = PBField.initUInt64(0L);
    public final PBUInt64Field need_usrinfo = PBField.initUInt64(0L);
    public final PBUInt64Field page = PBField.initUInt64(0L);
  }
  
  public static final class GetCommentListNoFilterResp
    extends MessageMicro<GetCommentListNoFilterResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "lists", "total_num", "end_flag" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L) }, GetCommentListNoFilterResp.class);
    public final PBUInt64Field end_flag = PBField.initUInt64(0L);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> lists = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBUInt64Field total_num = PBField.initUInt64(0L);
  }
  
  public static final class GetCommentListReq
    extends MessageMicro<GetCommentListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "feed_type", "feed_id", "page", "count", "filter" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, GetCommentListReq.class);
    public final PBUInt64Field count = PBField.initUInt64(0L);
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field feed_type = PBField.initUInt64(0L);
    public final PBUInt64Field filter = PBField.initUInt64(0L);
    public final PBUInt64Field page = PBField.initUInt64(0L);
  }
  
  public static final class GetCommentListResp
    extends MessageMicro<GetCommentListResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "lists", "total_num", "end_flag" }, new Object[] { Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L) }, GetCommentListResp.class);
    public final PBUInt64Field end_flag = PBField.initUInt64(0L);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> lists = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBUInt64Field total_num = PBField.initUInt64(0L);
  }
  
  public static final class GetCommentsReq
    extends MessageMicro<GetCommentsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "comment_id" }, new Object[] { Long.valueOf(0L) }, GetCommentsReq.class);
    public final PBRepeatField<Long> comment_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class GetCommentsResp
    extends MessageMicro<GetCommentsResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "value" }, new Object[] { Long.valueOf(0L), null }, GetCommentsResp.class);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> value = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
  }
  
  public static final class GetStickReq
    extends MessageMicro<GetStickReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field feed_type = PBField.initUInt64(0L);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feeds_id", "feed_type" }, new Object[] { localByteStringMicro, Long.valueOf(0L) }, GetStickReq.class);
    }
  }
  
  public static final class GetStickRsp
    extends MessageMicro<GetStickRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "err_msg", "value", "total_num" }, new Object[] { Integer.valueOf(0), "", null, Long.valueOf(0L) }, GetStickRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt64Field total_num = PBField.initUInt64(0L);
    public final PBRepeatMessageField<NowNearbyVideoCommentProto.Comment> value = PBField.initRepeatMessage(NowNearbyVideoCommentProto.Comment.class);
  }
  
  public static final class HippoMsg
    extends MessageMicro<HippoMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field action = PBField.initUInt32(0);
    public NowNearbyVideoCommentProto.AddCommentReq comm = new NowNearbyVideoCommentProto.AddCommentReq();
    public final PBUInt64Field comm_id = PBField.initUInt64(0L);
    public final PBBytesField feeds_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40 }, new String[] { "uid", "comm", "action", "feeds_id", "comm_id" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, HippoMsg.class);
    }
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField anchor_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField head_img_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field now_id = PBField.initUInt64(0L);
    public final PBUInt64Field uid = PBField.initUInt64(0L);
    public ilive_user_basic_info.UserExtraInfo userExtraInfo = new ilive_user_basic_info.UserExtraInfo();
    public final PBUInt32Field user_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48 }, new String[] { "uid", "head_img_url", "anchor_name", "userExtraInfo", "user_type", "now_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0), Long.valueOf(0L) }, UserInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.NowNearbyVideoCommentProto
 * JD-Core Version:    0.7.0.1
 */