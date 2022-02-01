package com.tencent.mobileqq.datarecv.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ZhituReportMsg
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_aio_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_current_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_mobile_type = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pass = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pre_one_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pre_two_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_style = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_action = PBField.initUInt32(0);
    
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 74 }, new String[] { "bytes_pass", "bytes_pic_id", "bytes_style", "uint32_action", "bytes_aio_type", "bytes_mobile_type", "bytes_current_text", "bytes_pre_one_text", "bytes_pre_two_text" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, ReqBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datarecv.pb.ZhituReportMsg
 * JD-Core Version:    0.7.0.1
 */