package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$InstInfo
  extends MessageMicro
{
  public static final int UINT32_APPPID_FIELD_NUMBER = 1;
  public static final int UINT32_INSTID_FIELD_NUMBER = 2;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_apppid", "uint32_instid", "uint32_platform" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, InstInfo.class);
  public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.InstInfo
 * JD-Core Version:    0.7.0.1
 */