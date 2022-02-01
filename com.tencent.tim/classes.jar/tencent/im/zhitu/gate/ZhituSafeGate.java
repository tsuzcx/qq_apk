package tencent.im.zhitu.gate;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ZhituSafeGate
{
  public static final class GateInfo
    extends MessageMicro<GateInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_state", "bytes_bytes_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GateInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_src_uin", "uint32_src_term", "bytes_other" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public ZhituSafeGate.GateInfo gate_info = new ZhituSafeGate.GateInfo();
    public final PBInt32Field int32_result = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_result", "bytes_fail_msg", "gate_info", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, null, localByteStringMicro2 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.zhitu.gate.ZhituSafeGate
 * JD-Core Version:    0.7.0.1
 */