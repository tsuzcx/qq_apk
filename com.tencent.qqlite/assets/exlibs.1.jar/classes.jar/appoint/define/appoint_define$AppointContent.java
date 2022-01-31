package appoint.define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class appoint_define$AppointContent
  extends MessageMicro
{
  public static final int MSG_APPOINT_ADDRESS_FIELD_NUMBER = 6;
  public static final int STR_APPOINT_INTRODUCE_FIELD_NUMBER = 5;
  public static final int UINT32_APPOINT_DATE_FIELD_NUMBER = 3;
  public static final int UINT32_APPOINT_GENDER_FIELD_NUMBER = 4;
  public static final int UINT32_APPOINT_SUBJECT_FIELD_NUMBER = 1;
  public static final int UINT32_PAY_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "uint32_appoint_subject", "uint32_pay_type", "uint32_appoint_date", "uint32_appoint_gender", "str_appoint_introduce", "msg_appoint_address" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", null }, AppointContent.class);
  public appoint_define.AddressInfo msg_appoint_address = new appoint_define.AddressInfo();
  public final PBStringField str_appoint_introduce = PBField.initString("");
  public final PBUInt32Field uint32_appoint_date = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appoint_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appoint_subject = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pay_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     appoint.define.appoint_define.AppointContent
 * JD-Core Version:    0.7.0.1
 */