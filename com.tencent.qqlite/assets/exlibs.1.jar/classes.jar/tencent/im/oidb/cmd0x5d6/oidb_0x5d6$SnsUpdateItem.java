package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x5d6$SnsUpdateItem
  extends MessageMicro
{
  public static final int BYTES_VALUE_FIELD_NUMBER = 2;
  public static final int UINT32_UPDATE_SNS_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_VALUE_OFFSET_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_value_offset = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_update_sns_type", "bytes_value", "uint32_value_offset" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SnsUpdateItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem
 * JD-Core Version:    0.7.0.1
 */