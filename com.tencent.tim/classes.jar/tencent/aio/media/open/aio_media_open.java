package tencent.aio.media.open;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class aio_media_open
{
  public static final class ReqOpenIdentify
    extends MessageMicro<ReqOpenIdentify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 42 }, new String[] { "enum_aio_type", "uint64_id", "bytes_req_data", "bytes_req_sign" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ReqOpenIdentify.class);
    }
  }
  
  public static final class ReqOpenStart
    extends MessageMicro<ReqOpenStart>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_req_sign = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_aio_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 42 }, new String[] { "enum_aio_type", "uint64_id", "bytes_req_data", "bytes_req_sign" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2 }, ReqOpenStart.class);
    }
  }
  
  public static final class ResultInfo
    extends MessageMicro<ResultInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_show_err = PBField.initBool(false);
    public final PBBytesField bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "bytes_errmsg", "bool_show_err" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Boolean.valueOf(false) }, ResultInfo.class);
    }
  }
  
  public static final class RspOpenIdentify
    extends MessageMicro<RspOpenIdentify>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_button_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_confirm_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_introduce_text = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_introduce_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public aio_media_open.ResultInfo msg_result = new aio_media_open.ResultInfo();
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "msg_result", "bytes_button_text", "bytes_confirm_text", "bytes_introduce_title", "bytes_introduce_text", "uint32_business_type" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, RspOpenIdentify.class);
    }
  }
  
  public static final class RspOpenStart
    extends MessageMicro<RspOpenStart>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_jump_type = PBField.initEnum(1);
    public aio_media_open.ResultInfo msg_result = new aio_media_open.ResultInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "msg_result", "enum_jump_type", "bytes_jump_url" }, new Object[] { null, Integer.valueOf(1), localByteStringMicro }, RspOpenStart.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.aio.media.open.aio_media_open
 * JD-Core Version:    0.7.0.1
 */