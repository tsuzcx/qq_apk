package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_del_message
{
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
  
  public static final class ReqDelAllMessage
    extends MessageMicro<ReqDelAllMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "start_time" }, new Object[] { Integer.valueOf(0) }, ReqDelAllMessage.class);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
  }
  
  public static final class ReqDelOneMessage
    extends MessageMicro<ReqDelOneMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public qqstory_del_message.StoryCommentSimpleInfo comment_info = new qqstory_del_message.StoryCommentSimpleInfo();
    public final PBUInt32Field comment_type = PBField.initUInt32(0);
    public final PBUInt64Field comment_uid = PBField.initUInt64(0L);
    public final PBUInt64Field remind_uid = PBField.initUInt64(0L);
    public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "vid", "comment_uid", "comment_type", "comment_info", "remind_uid" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, ReqDelOneMessage.class);
    }
  }
  
  public static final class RspDelAllMessage
    extends MessageMicro<RspDelAllMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "errinfo", "remain_num", "image_uid", "last_time" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspDelAllMessage.class);
    public qqstory_del_message.ErrorInfo errinfo = new qqstory_del_message.ErrorInfo();
    public final PBUInt64Field image_uid = PBField.initUInt64(0L);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBUInt32Field remain_num = PBField.initUInt32(0);
  }
  
  public static final class RspDelOneMessage
    extends MessageMicro<RspDelOneMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "errinfo" }, new Object[] { null }, RspDelOneMessage.class);
    public qqstory_del_message.ErrorInfo errinfo = new qqstory_del_message.ErrorInfo();
  }
  
  public static final class StoryCommentSimpleInfo
    extends MessageMicro<StoryCommentSimpleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "comment_id", "reply_uid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, StoryCommentSimpleInfo.class);
    public final PBUInt32Field comment_id = PBField.initUInt32(0);
    public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_del_message
 * JD-Core Version:    0.7.0.1
 */