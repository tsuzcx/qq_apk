package tencent.im.oidb.cmd0x5e0;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x5e0$UpdateProfileList
  extends MessageMicro
{
  public static final int UINT32_FRIENDLIST_TYPE_FIELD_NUMBER = 3;
  public static final int UINT32_GET_CONTENT_TIMESTAMP_FIELD_NUMBER = 2;
  public static final int UINT32_NEED_CONTENT_FIELD_NUMBER = 4;
  public static final int UINT32_UPDATE_PROFILE_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_update_profile_id", "uint32_get_content_timestamp", "uint32_friendlist_type", "uint32_need_content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UpdateProfileList.class);
  public final PBUInt32Field uint32_friendlist_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_get_content_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_need_content = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_profile_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.UpdateProfileList
 * JD-Core Version:    0.7.0.1
 */