package tencent.im.cs.cmd0x3fb;

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

public final class cmd0x3fb
{
  public static final class BufferExData
    extends MessageMicro<BufferExData>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField string_value = PBField.initString("");
    public final PBUInt32Field uint32_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_value = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint32_index", "uint32_value", "string_value", "bytes_value" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, BufferExData.class);
    }
  }
  
  public static final class GrayMsg
    extends MessageMicro<GrayMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90 }, new String[] { "uint32_subcmd", "msg_gray_req", "msg_gray_rsp" }, new Object[] { Integer.valueOf(0), null, null }, GrayMsg.class);
    public cmd0x3fb.ReqBody msg_gray_req = new cmd0x3fb.ReqBody();
    public cmd0x3fb.RspBody msg_gray_rsp = new cmd0x3fb.RspBody();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_identity", "uint64_to_guin", "uint32_client_id", "str_version" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "" }, ReqBody.class);
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field uint32_client_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identity = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_guin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 74, 80 }, new String[] { "int32_ret", "int32_gray_flag", "str_url", "int32_color", "rpt_msg_buffer_ex_data", "int32_enter_glive_strategy", "uint64_to_guin", "str_update_title", "str_update_content", "int32_pre_download_toggle" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), "", "", Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_color = PBField.initInt32(0);
    public final PBInt32Field int32_enter_glive_strategy = PBField.initInt32(0);
    public final PBInt32Field int32_gray_flag = PBField.initInt32(0);
    public final PBInt32Field int32_pre_download_toggle = PBField.initInt32(0);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x3fb.BufferExData> rpt_msg_buffer_ex_data = PBField.initRepeatMessage(cmd0x3fb.BufferExData.class);
    public final PBStringField str_update_content = PBField.initString("");
    public final PBStringField str_update_title = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBUInt64Field uint64_to_guin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x3fb.cmd0x3fb
 * JD-Core Version:    0.7.0.1
 */