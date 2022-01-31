package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_sso$OIDBSSOPkg
  extends MessageMicro
{
  public static final int BYTES_BODYBUFFER_FIELD_NUMBER = 4;
  public static final int UINT32_COMMAND_FIELD_NUMBER = 1;
  public static final int UINT32_RESULT_FIELD_NUMBER = 3;
  public static final int UINT32_SERVICE_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_bodybuffer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_command = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_command", "uint32_service_type", "uint32_result", "bytes_bodybuffer" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, OIDBSSOPkg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.oidb_sso.OIDBSSOPkg
 * JD-Core Version:    0.7.0.1
 */