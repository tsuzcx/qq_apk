package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89a$ReqBody
  extends MessageMicro
{
  public static final int ST_GROUP_INFO_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "st_group_info" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
  public oidb_0x89a.groupinfo st_group_info = new oidb_0x89a.groupinfo();
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.ReqBody
 * JD-Core Version:    0.7.0.1
 */