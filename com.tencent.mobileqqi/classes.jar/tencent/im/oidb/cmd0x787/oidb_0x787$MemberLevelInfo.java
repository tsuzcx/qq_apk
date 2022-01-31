package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x787$MemberLevelInfo
  extends MessageMicro
{
  public static final int STR_NAME_FIELD_NUMBER = 5;
  public static final int UINT32_ACTIVE_DAY_FIELD_NUMBER = 3;
  public static final int UINT32_LEVEL_FIELD_NUMBER = 4;
  public static final int UINT32_POINT_FIELD_NUMBER = 2;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_point = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_uin", "uint32_point", "uint32_active_day", "uint32_level", "str_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, MemberLevelInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo
 * JD-Core Version:    0.7.0.1
 */