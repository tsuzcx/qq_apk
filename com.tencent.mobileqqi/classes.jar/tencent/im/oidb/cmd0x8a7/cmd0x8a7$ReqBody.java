package tencent.im.oidb.cmd0x8a7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8a7$ReqBody
  extends MessageMicro
{
  public static final int UINT32_LIMIT_INTERVAL_TYPE_FOR_GROUP_FIELD_NUMBER = 3;
  public static final int UINT32_LIMIT_INTERVAL_TYPE_FOR_UIN_FIELD_NUMBER = 2;
  public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 5;
  public static final int UINT64_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_sub_cmd", "uint32_limit_interval_type_for_uin", "uint32_limit_interval_type_for_group", "uint64_uin", "uint64_group_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt32Field uint32_limit_interval_type_for_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_limit_interval_type_for_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody
 * JD-Core Version:    0.7.0.1
 */