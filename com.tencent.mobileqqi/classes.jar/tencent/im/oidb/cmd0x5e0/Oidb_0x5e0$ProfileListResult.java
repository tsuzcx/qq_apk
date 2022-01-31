package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$ProfileListResult
  extends MessageMicro
{
  public static final int UINT32_NEW_CONTENT_TIMESTAMP_FIELD_NUMBER = 3;
  public static final int UINT32_RESULT_FIELD_NUMBER = 1;
  public static final int UINT32_UPDATE_PROFILE_ID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_result", "uint32_update_profile_id", "uint32_new_content_timestamp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ProfileListResult.class);
  public final PBUInt32Field uint32_new_content_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileListResult
 * JD-Core Version:    0.7.0.1
 */