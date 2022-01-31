package tencent.im.cs.cmd0x3bb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x3bb$RspBody
  extends MessageMicro
{
  public static final int INT32_RET_FIELD_NUMBER = 1;
  public static final int MSG_ANONY_STATUS_FIELD_NUMBER = 10;
  public static final int STR_ANONY_NAME_FIELD_NUMBER = 3;
  public static final int UINT32_BUBBLE_INDEX_FIELD_NUMBER = 5;
  public static final int UINT32_EXPIRED_TIME_FIELD_NUMBER = 6;
  public static final int UINT32_PORTRAIT_INDEX_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_ret = PBField.initInt32(0);
  public cmd0x3bb.AnonyStatus msg_anony_status = new cmd0x3bb.AnonyStatus();
  public final PBBytesField str_anony_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bubble_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_portrait_index = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 82 }, new String[] { "int32_ret", "uint64_group_code", "str_anony_name", "uint32_portrait_index", "uint32_bubble_index", "uint32_expired_time", "msg_anony_status" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody
 * JD-Core Version:    0.7.0.1
 */