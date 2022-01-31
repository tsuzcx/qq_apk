package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$TagRecord
  extends MessageMicro
{
  public static final int BYTES_TAG_ID_FIELD_NUMBER = 3;
  public static final int BYTES_TAG_VALUE_FIELD_NUMBER = 8;
  public static final int UINT32_BAD_NUM_FIELD_NUMBER = 6;
  public static final int UINT32_GOOD_NUM_FIELD_NUMBER = 5;
  public static final int UINT32_TAG_LEN_FIELD_NUMBER = 7;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  public static final int UINT64_SET_TIME_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tag_value = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bad_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_good_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_tag_len = PBField.initUInt32(0);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_set_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 66 }, new String[] { "uint64_from_uin", "uint64_group_code", "bytes_tag_id", "uint64_set_time", "uint32_good_num", "uint32_bad_num", "uint32_tag_len", "bytes_tag_value" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, TagRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord
 * JD-Core Version:    0.7.0.1
 */