package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8ca$RspBody
  extends MessageMicro
{
  public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "opt_uint64_group_code" }, new Object[] { Long.valueOf(0L) }, RspBody.class);
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8ca.cmd0x8ca.RspBody
 * JD-Core Version:    0.7.0.1
 */