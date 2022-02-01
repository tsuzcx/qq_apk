package tencent.im.oidb.cmd0x829;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x829
{
  public static final class AddFrdInfo
    extends MessageMicro<AddFrdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_allow_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_req_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "bytes_mobile", "uint32_allow_type", "bytes_remark", "uint32_send_req_flag", "uint32_send_result" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, AddFrdInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_mobiles = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_request_platform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_source_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48 }, new String[] { "uint32_request_platform", "uint32_request_version", "rpt_bytes_mobiles", "bytes_msg", "uint32_source_id", "uint32_sub_source_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_add_frd_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_0x829.AddFrdInfo> rpt_add_frd_info = PBField.initRepeatMessage(oidb_0x829.AddFrdInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x829.oidb_0x829
 * JD-Core Version:    0.7.0.1
 */