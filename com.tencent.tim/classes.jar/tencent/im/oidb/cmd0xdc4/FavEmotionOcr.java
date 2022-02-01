package tencent.im.oidb.cmd0xdc4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FavEmotionOcr
{
  public static final class ModifyReq
    extends MessageMicro<ModifyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "pic_info", "string_self_desc_new" }, new Object[] { null, "" }, ModifyReq.class);
    public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
    public final PBStringField string_self_desc_new = PBField.initString("");
  }
  
  public static final class ModifyRsp
    extends MessageMicro<ModifyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "pic_info", "int32_result", "string_fail_msg" }, new Object[] { null, Integer.valueOf(0), "" }, ModifyRsp.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
    public final PBStringField string_fail_msg = PBField.initString("");
  }
  
  public static final class OcrInfo
    extends MessageMicro<OcrInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pic_info", "string_pic_ocr", "string_self_desc", "string_bytes_other" }, new Object[] { null, "", "", "" }, OcrInfo.class);
    public FavEmotionOcr.PicInfo pic_info = new FavEmotionOcr.PicInfo();
    public final PBStringField string_bytes_other = PBField.initString("");
    public final PBStringField string_pic_ocr = PBField.initString("");
    public final PBStringField string_self_desc = PBField.initString("");
  }
  
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 40, 48 }, new String[] { "string_pic_fileid", "string_pic_md5", "uint32_img_width", "uint32_img_height", "uint64_img_size" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PicInfo.class);
    public final PBStringField string_pic_fileid = PBField.initString("");
    public final PBStringField string_pic_md5 = PBField.initString("");
    public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<FavEmotionOcr.ModifyReq> list_modify_req = PBField.initRepeatMessage(FavEmotionOcr.ModifyReq.class);
    public final PBRepeatMessageField<FavEmotionOcr.PicInfo> list_pic_info = PBField.initRepeatMessage(FavEmotionOcr.PicInfo.class);
    public final PBStringField string_version = PBField.initString("");
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_src_term", "string_version", "uint32_cmd_type", "list_pic_info", "list_modify_req", "bytes_other" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null, localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBRepeatMessageField<FavEmotionOcr.ModifyRsp> list_modify_rsp = PBField.initRepeatMessage(FavEmotionOcr.ModifyRsp.class);
    public final PBRepeatMessageField<FavEmotionOcr.OcrInfo> list_ocr_info = PBField.initRepeatMessage(FavEmotionOcr.OcrInfo.class);
    public final PBStringField string_fail_msg = PBField.initString("");
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "int32_result", "string_fail_msg", "uint32_cmd_type", "list_ocr_info", "list_modify_rsp", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null, null, localByteStringMicro }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdc4.FavEmotionOcr
 * JD-Core Version:    0.7.0.1
 */