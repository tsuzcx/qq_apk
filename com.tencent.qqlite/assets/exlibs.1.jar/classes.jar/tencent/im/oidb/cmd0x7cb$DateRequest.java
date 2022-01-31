package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7cb$DateRequest
  extends MessageMicro
{
  public static final int STR_ERR_MSG_FIELD_NUMBER = 2;
  public static final int UINT32_TIME_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_time", "str_err_msg" }, new Object[] { Integer.valueOf(0), "" }, DateRequest.class);
  public final PBStringField str_err_msg = PBField.initString("");
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7cb.DateRequest
 * JD-Core Version:    0.7.0.1
 */