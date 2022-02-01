package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class BaseInterfaceOuterClass$Terminal
  extends MessageMicro<Terminal>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50 }, new String[] { "imei", "imei2", "qimei", "phone_system", "platform_type", "client_version" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(1), "" }, Terminal.class);
  public final PBStringField client_version = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBStringField imei2 = PBField.initString("");
  public final PBEnumField phone_system = PBField.initEnum(0);
  public final PBEnumField platform_type = PBField.initEnum(1);
  public final PBStringField qimei = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.BaseInterfaceOuterClass.Terminal
 * JD-Core Version:    0.7.0.1
 */