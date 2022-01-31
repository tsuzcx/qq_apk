package tencent.im.oidb.cmd0x89e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89e$RspBody
  extends MessageMicro
{
  public static final int STR_ERRORINFO_FIELD_NUMBER = 5;
  public static final int UINT32_RESULT_FIELD_NUMBER = 4;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  public static final int UINT64_NEW_OWNER_FIELD_NUMBER = 3;
  public static final int UINT64_OLD_OWNER_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_errorinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt32Field uint64_new_owner = PBField.initUInt32(0);
  public final PBUInt64Field uint64_old_owner = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_group_code", "uint64_old_owner", "uint64_new_owner", "uint32_result", "str_errorinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89e.oidb_0x89e.RspBody
 * JD-Core Version:    0.7.0.1
 */