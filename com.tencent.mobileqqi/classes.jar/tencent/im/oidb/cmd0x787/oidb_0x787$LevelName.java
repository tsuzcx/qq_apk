package tencent.im.oidb.cmd0x787;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x787$LevelName
  extends MessageMicro
{
  public static final int STR_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_LEVEL_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_level", "str_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LevelName.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.oidb.cmd0x787.oidb_0x787.LevelName
 * JD-Core Version:    0.7.0.1
 */