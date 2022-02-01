package tencent.im.cs.doutu;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Doutu
{
  public static final class GetHotPicReq
    extends MessageMicro<GetHotPicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_src_uin", "uint32_src_term", "bytes_pic_md5", "uin32_gender", "uint32_age" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetHotPicReq.class);
    }
  }
  
  public static final class GetImgInfoReq
    extends MessageMicro<GetImgInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_src_uin", "uint32_src_term", "uint32_age", "uin32_gender" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetImgInfoReq.class);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  }
  
  public static final class GetImgInfoRsp
    extends MessageMicro<GetImgInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<Doutu.ImgInfo> rpt_msg_img_info = PBField.initRepeatMessage(Doutu.ImgInfo.class);
    public final PBUInt32Field uint32_rsp_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "int32_result", "bytes_fail_msg", "rpt_msg_img_info", "uint32_rsp_type" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0) }, GetImgInfoRsp.class);
    }
  }
  
  public static final class GetShanMengReq
    extends MessageMicro<GetShanMengReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64 }, new String[] { "uint64_src_uin", "uint32_src_term", "bytes_uuid", "bytes_md5", "uint32_command_id", "bytes_url", "uin32_gender", "uint32_age" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, GetShanMengReq.class);
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
  
  public static final class ReportHotPicReq
    extends MessageMicro<ReportHotPicReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public Doutu.ImgInfo msg_img_info = new Doutu.ImgInfo();
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint64_src_uin", "uint32_src_term", "msg_img_info", "bytes_md5", "uin32_gender", "uint32_age" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReportHotPicReq.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_get_imginfo_req", "msg_get_hotpic_req", "msg_get_shanmeng_req", "msg_report_hotpic_req" }, new Object[] { null, null, null, null }, ReqBody.class);
    public Doutu.GetHotPicReq msg_get_hotpic_req = new Doutu.GetHotPicReq();
    public Doutu.GetImgInfoReq msg_get_imginfo_req = new Doutu.GetImgInfoReq();
    public Doutu.GetShanMengReq msg_get_shanmeng_req = new Doutu.GetShanMengReq();
    public Doutu.ReportHotPicReq msg_report_hotpic_req = new Doutu.ReportHotPicReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_get_imginfo_rsp" }, new Object[] { null }, RspBody.class);
    public Doutu.GetImgInfoRsp msg_get_imginfo_rsp = new Doutu.GetImgInfoRsp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.doutu.Doutu
 * JD-Core Version:    0.7.0.1
 */