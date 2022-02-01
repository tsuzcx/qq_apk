package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BaseInterfaceOuterClass$CSQQAccessReqHeader
  extends MessageMicro<CSQQAccessReqHeader>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "cmd", "seq", "lock_key" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "" }, CSQQAccessReqHeader.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public final PBStringField lock_key = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessReqHeader
 * JD-Core Version:    0.7.0.1
 */