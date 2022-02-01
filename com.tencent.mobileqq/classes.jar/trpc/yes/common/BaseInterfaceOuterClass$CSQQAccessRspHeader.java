package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BaseInterfaceOuterClass$CSQQAccessRspHeader
  extends MessageMicro<CSQQAccessRspHeader>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField disply_error_message = PBField.initString("");
  public final PBInt32Field error_code = PBField.initInt32(0);
  public final PBStringField error_message = PBField.initString("");
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBInt32Field system_error_sub_code = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "error_code", "error_message", "disply_error_message", "system_error_sub_code", "seq" }, new Object[] { localInteger, "", "", localInteger, Long.valueOf(0L) }, CSQQAccessRspHeader.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.BaseInterfaceOuterClass.CSQQAccessRspHeader
 * JD-Core Version:    0.7.0.1
 */