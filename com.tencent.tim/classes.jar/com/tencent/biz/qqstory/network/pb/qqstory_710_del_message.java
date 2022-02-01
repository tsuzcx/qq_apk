package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_del_message
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "start_time", "source", "version_ctrl" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqDelAllMessage.class);
    public final PBUInt32Field source = PBField.initUInt32(0);
    public final PBUInt32Field start_time = PBField.initUInt32(0);
    public final PBUInt32Field version_ctrl = PBField.initUInt32(0);
  }
  
  public static final class ReqDelOneMessage
    extends MessageMicro<ReqDelOneMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field message_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "feed_id", "message_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqDelOneMessage.class);
    }
  }
  
  public static final class RspDelAllMessage
    extends MessageMicro<RspDelAllMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "errinfo", "remain_num", "image_uid", "last_time" }, new Object[] { null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspDelAllMessage.class);
    public qqstory_710_del_message.ErrorInfo errinfo = new qqstory_710_del_message.ErrorInfo();
    public final PBUInt64Field image_uid = PBField.initUInt64(0L);
    public final PBUInt32Field last_time = PBField.initUInt32(0);
    public final PBUInt32Field remain_num = PBField.initUInt32(0);
  }
  
  public static final class RspDelOneMessage
    extends MessageMicro<RspDelOneMessage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "errinfo" }, new Object[] { null }, RspDelOneMessage.class);
    public qqstory_710_del_message.ErrorInfo errinfo = new qqstory_710_del_message.ErrorInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_del_message
 * JD-Core Version:    0.7.0.1
 */