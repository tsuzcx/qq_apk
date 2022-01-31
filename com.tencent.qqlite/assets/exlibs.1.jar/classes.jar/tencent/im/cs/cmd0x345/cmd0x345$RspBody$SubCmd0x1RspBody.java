package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x345$RspBody$SubCmd0x1RspBody
  extends MessageMicro
{
  public static final int STR_CHECK_SUM_FIELD_NUMBER = 2;
  public static final int STR_FILE_ID_FIELD_NUMBER = 1;
  public static final int STR_FILE_KEY_FIELD_NUMBER = 5;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 6;
  public static final int STR_HOST_FIELD_NUMBER = 3;
  public static final int STR_WARN_FIELD_NUMBER = 7;
  public static final int UINT32_COSTOM_ID_FIELD_NUMBER = 8;
  public static final int UINT32_PORT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64 }, new String[] { "str_file_id", "str_check_sum", "str_host", "uint32_port", "str_file_key", "str_file_name", "str_warn", "uint32_costom_id" }, new Object[] { "", "", "", Integer.valueOf(80), "", "", "", Integer.valueOf(0) }, SubCmd0x1RspBody.class);
  public final PBStringField str_check_sum = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_host = PBField.initString("");
  public final PBStringField str_warn = PBField.initString("");
  public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(80);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.RspBody.SubCmd0x1RspBody
 * JD-Core Version:    0.7.0.1
 */