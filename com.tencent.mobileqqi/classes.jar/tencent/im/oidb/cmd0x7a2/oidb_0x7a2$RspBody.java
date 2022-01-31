package tencent.im.oidb.cmd0x7a2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7a2$RspBody
  extends MessageMicro
{
  public static final int STR_ERRMSG_FIELD_NUMBER = 2;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  public static final int UINT64_BIND_UIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "str_errmsg", "uint64_bind_uin" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L) }, RspBody.class);
  public final PBStringField str_errmsg = PBField.initString("");
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bind_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7a2.oidb_0x7a2.RspBody
 * JD-Core Version:    0.7.0.1
 */