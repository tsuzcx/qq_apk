package tencent.im.oidb.cmd0x587;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x587$ReqBody
  extends MessageMicro
{
  public static final int UINT32_PARENT_ALLOW_FLAG_FIELD_NUMBER = 40542;
  public static final int UINT32_UEFLAG_FIELD_NUMBER = 40541;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 324328, 324336 }, new String[] { "uint32_ueflag", "uint32_parent_allow_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field uint32_parent_allow_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ueflag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody
 * JD-Core Version:    0.7.0.1
 */