package com.tencent.pb.icebreakhotpic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IcebreakHotPic
{
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_img_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_img_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_img_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_thumb_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 88, 98, 106 }, new String[] { "bytes_resource_id", "bytes_img_md5", "uint32_img_width", "uint32_img_height", "bytes_img_down_url", "uint64_img_size", "bytes_thumb_img_md5", "uint32_thumb_img_width", "uint32_thumb_img_height", "bytes_thumb_down_url", "uint64_thumb_size", "bytes_img_word", "bytes_img_other" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7 }, ImgInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint64_to_uin", "uin32_gender", "uint32_age" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<IcebreakHotPic.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(IcebreakHotPic.ImgInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.icebreakhotpic.IcebreakHotPic
 * JD-Core Version:    0.7.0.1
 */