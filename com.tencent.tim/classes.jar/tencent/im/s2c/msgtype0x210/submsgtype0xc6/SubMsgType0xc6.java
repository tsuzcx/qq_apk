package tencent.im.s2c.msgtype0x210.submsgtype0xc6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xc6
{
  public static final class AccountExceptionAlertBody
    extends MessageMicro<AccountExceptionAlertBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56 }, new String[] { "str_title", "str_content", "str_left_button_text", "str_right_button_text", "str_right_button_link", "uint32_left_button_id", "uint32_right_button_id" }, new Object[] { "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, AccountExceptionAlertBody.class);
    public final PBStringField str_content = PBField.initString("");
    public final PBStringField str_left_button_text = PBField.initString("");
    public final PBStringField str_right_button_link = PBField.initString("");
    public final PBStringField str_right_button_text = PBField.initString("");
    public final PBStringField str_title = PBField.initString("");
    public final PBUInt32Field uint32_left_button_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_right_button_id = PBField.initUInt32(0);
  }
  
  public static final class MsgBody
    extends MessageMicro<MsgBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sec_cmd", "msg_s2c_account_exception_notify" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
    public SubMsgType0xc6.AccountExceptionAlertBody msg_s2c_account_exception_notify = new SubMsgType0xc6.AccountExceptionAlertBody();
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6
 * JD-Core Version:    0.7.0.1
 */