package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DoutuRecommend
{
  public static final class GetImgInfoReq
    extends MessageMicro<GetImgInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField chat_type = PBField.initEnum(1);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64 }, new String[] { "uint64_src_uin", "uint64_to_uin", "uint32_src_term", "bytes_md5", "chat_type", "bytes_url", "uin32_gender", "uint32_age" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(1), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, GetImgInfoReq.class);
    }
  }
  
  public static final class GetImgInfoRsp
    extends MessageMicro<GetImgInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pass_through = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<DoutuRecommend.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(DoutuRecommend.ImgInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_result", "bytes_fail_msg", "rpt_msg_img_info", "bytes_pass_through" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2 }, GetImgInfoRsp.class);
    }
  }
  
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_source_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_down_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_thumb_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_pic_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_thumb_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 64, 72, 82, 90 }, new String[] { "bytes_pic_md5", "uint64_pic_size", "uint32_pic_width", "uint32_pic_height", "bytes_pic_down_url", "bytes_thumb_file_md5", "uint64_thumb_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_down_url", "bytes_source_name" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, ImgInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_req" }, new Object[] { null }, ReqBody.class);
    public DoutuRecommend.GetImgInfoReq msg_get_imginfo_req = new DoutuRecommend.GetImgInfoReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_rsp" }, new Object[] { null }, RspBody.class);
    public DoutuRecommend.GetImgInfoRsp msg_get_imginfo_rsp = new DoutuRecommend.GetImgInfoRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.doutu.DoutuRecommend
 * JD-Core Version:    0.7.0.1
 */