package tencent.im.s2c.msgtype0x210.submsgtype0x8d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x8d
{
  public static final class ChannelNotify
    extends MessageMicro<ChannelNotify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_channel_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_top_article_id_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint64_channel_id", "bytes_channel_name", "bytes_wording", "rpt_top_article_id_list" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L) }, ChannelNotify.class);
    }
  }
  
  public static final class CommentFeeds
    extends MessageMicro<CommentFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_comment_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_feeds_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 58, 66 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "bytes_comment_info", "bytes_feeds_subject" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, CommentFeeds.class);
    }
  }
  
  public static final class DeleteComment
    extends MessageMicro<DeleteComment>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reply_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_comment_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_reply_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_comment_uin", "bytes_comment_id", "uint64_reply_uin", "bytes_reply_id", "uint64_delete_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L) }, DeleteComment.class);
    }
  }
  
  public static final class DeleteFeeds
    extends MessageMicro<DeleteFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_delete_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, DeleteFeeds.class);
    public final PBUInt64Field uint64_delete_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
  }
  
  public static final class LikeFeeds
    extends MessageMicro<LikeFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_feeds_subject = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_like_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id", "uint64_like_uin", "bytes_feeds_subject" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro }, LikeFeeds.class);
    }
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "rpt_msg_notify_infos", "red_spot_notify_body" }, new Object[] { null, null }, MsgBody.class);
    public SubMsgType0x8d.RedSpotNotifyBody red_spot_notify_body = new SubMsgType0x8d.RedSpotNotifyBody();
    public final PBRepeatMessageField<SubMsgType0x8d.NotifyBody> rpt_msg_notify_infos = PBField.initRepeatMessage(SubMsgType0x8d.NotifyBody.class);
  }
  
  public static final class NotifyBody
    extends MessageMicro<NotifyBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 82, 90, 98, 106, 114 }, new String[] { "uint32_notify_type", "uint32_seq", "uint32_push_time", "msg_publish_feeds", "msg_comment_feeds", "msg_like_feeds", "msg_delete_feeds", "msg_delete_comment" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, NotifyBody.class);
    public SubMsgType0x8d.CommentFeeds msg_comment_feeds = new SubMsgType0x8d.CommentFeeds();
    public SubMsgType0x8d.DeleteComment msg_delete_comment = new SubMsgType0x8d.DeleteComment();
    public SubMsgType0x8d.DeleteFeeds msg_delete_feeds = new SubMsgType0x8d.DeleteFeeds();
    public SubMsgType0x8d.LikeFeeds msg_like_feeds = new SubMsgType0x8d.LikeFeeds();
    public SubMsgType0x8d.PublishFeeds msg_publish_feeds = new SubMsgType0x8d.PublishFeeds();
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_push_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class PublishFeeds
    extends MessageMicro<PublishFeeds>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_feeds_owner", "uint64_feeds_id" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, PublishFeeds.class);
    public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_feeds_owner = PBField.initUInt64(0L);
  }
  
  public static final class RedSpotNotifyBody
    extends MessageMicro<RedSpotNotifyBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_guide_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public SubMsgType0x8d.ChannelNotify msg_channel_notify = new SubMsgType0x8d.ChannelNotify();
    public final PBRepeatField<Long> rpt_new_channel_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_time", "rpt_new_channel_list", "bytes_guide_wording", "msg_channel_notify" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null }, RedSpotNotifyBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x8d.SubMsgType0x8d
 * JD-Core Version:    0.7.0.1
 */