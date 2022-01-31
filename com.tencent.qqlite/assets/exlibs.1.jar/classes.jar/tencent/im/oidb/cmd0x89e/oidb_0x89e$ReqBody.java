package tencent.im.oidb.cmd0x89e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89e$ReqBody
  extends MessageMicro
{
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_NEW_OWNER_FIELD_NUMBER = 3;
  public static final int UINT64_OLD_OWNER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint64_old_owner", "uint64_new_owner" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_new_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_old_owner = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89e.oidb_0x89e.ReqBody
 * JD-Core Version:    0.7.0.1
 */