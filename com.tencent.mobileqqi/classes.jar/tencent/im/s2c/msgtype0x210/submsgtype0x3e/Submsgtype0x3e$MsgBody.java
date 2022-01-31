package tencent.im.s2c.msgtype0x210.submsgtype0x3e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Submsgtype0x3e$MsgBody
  extends MessageMicro
{
  public static final int BYTES_DEVICE_FIELD_NUMBER = 4;
  public static final int UINT32_RANDOM_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 3;
  public static final int UINT32_SID_FIELD_NUMBER = 5;
  public static final int UINT32_SUBCMD_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_device = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint32_subcmd", "uint32_random", "uint32_result", "bytes_device", "uint32_sid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, MsgBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x3e.Submsgtype0x3e.MsgBody
 * JD-Core Version:    0.7.0.1
 */