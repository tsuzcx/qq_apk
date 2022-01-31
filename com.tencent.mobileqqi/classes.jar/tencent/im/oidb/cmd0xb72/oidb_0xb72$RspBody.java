package tencent.im.oidb.cmd0xb72;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb72$RspBody
  extends MessageMicro
{
  public static final int STR_COUNTRY_FIELD_NUMBER = 4;
  public static final int UINT32_LOC_FLAG_UE_FIELD_NUMBER = 1;
  public static final int UINT32_PARENT_ALLOW_FIELD_NUMBER = 3;
  public static final int UINT32_USER_FLAG_UE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_loc_flag_ue", "uint32_user_flag_ue", "uint32_parent_allow", "str_country" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, RspBody.class);
  public final PBStringField str_country = PBField.initString("");
  public final PBUInt32Field uint32_loc_flag_ue = PBField.initUInt32(0);
  public final PBUInt32Field uint32_parent_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_flag_ue = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb72.oidb_0xb72.RspBody
 * JD-Core Version:    0.7.0.1
 */