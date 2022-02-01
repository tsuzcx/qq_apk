package tencent.im.oidb.cmd0x990;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0x990
{
  public static final class BatchTranslateReq
    extends MessageMicro<BatchTranslateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_dst_language = PBField.initString("");
    public final PBStringField str_src_language = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_src_language", "str_dst_language", "rpt_src_bytes_text_list" }, new Object[] { "", "", localByteStringMicro }, BatchTranslateReq.class);
    }
  }
  
  public static final class BatchTranslateRsp
    extends MessageMicro<BatchTranslateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_error_code = PBField.initInt32(0);
    public final PBRepeatField<ByteStringMicro> rpt_dst_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBRepeatField<ByteStringMicro> rpt_src_bytes_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBStringField str_dst_language = PBField.initString("");
    public final PBStringField str_src_language = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_error_code", "bytes_error_msg", "str_src_language", "str_dst_language", "rpt_src_bytes_text_list", "rpt_dst_bytes_text_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, "", "", localByteStringMicro2, localByteStringMicro3 }, BatchTranslateRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_translate_req", "msg_batch_translate_req" }, new Object[] { null, null }, ReqBody.class);
    public oidb_0x990.BatchTranslateReq msg_batch_translate_req = new oidb_0x990.BatchTranslateReq();
    public oidb_0x990.TranslateReq msg_translate_req = new oidb_0x990.TranslateReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_translate_rsp", "msg_batch_translate_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0x990.BatchTranslateRsp msg_batch_translate_rsp = new oidb_0x990.BatchTranslateRsp();
    public oidb_0x990.TranslateRsp msg_translate_rsp = new oidb_0x990.TranslateRsp();
  }
  
  public static final class TranslateReq
    extends MessageMicro<TranslateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBStringField str_dst_language = PBField.initString("");
    public final PBStringField str_src_language = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "bytes_text", "int32_type", "str_src_language", "str_dst_language" }, new Object[] { localByteStringMicro, Integer.valueOf(0), "", "" }, TranslateReq.class);
    }
  }
  
  public static final class TranslateRsp
    extends MessageMicro<TranslateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_trans_result = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBInt32Field int32_text_len = PBField.initInt32(0);
    public final PBInt32Field int32_type = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "int32_ret_code", "int32_type", "bytes_trans_result", "int32_text_len" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, TranslateRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x990.oidb_0x990
 * JD-Core Version:    0.7.0.1
 */