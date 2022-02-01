package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_bhd_upload_pic
{
  public static final class ReqStoryPic
    extends MessageMicro<ReqStoryPic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField img_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField platform = PBField.initEnum(1);
    public final PBUInt32Field tojpg = PBField.initUInt32(0);
    public final PBBytesField version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "img_data", "tojpg", "platform", "version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro2 }, ReqStoryPic.class);
    }
  }
  
  public static final class RspStoryPic
    extends MessageMicro<RspStoryPic>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field h = PBField.initUInt32(0);
    public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field w = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "retcode", "url", "w", "h", "msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, RspStoryPic.class);
    }
  }
  
  public static final class RspStoryVideo
    extends MessageMicro<RspStoryVideo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cdn_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "retcode", "msg", "cdn_url", "file_key", "file_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, RspStoryVideo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic
 * JD-Core Version:    0.7.0.1
 */