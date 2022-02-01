package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QrLogin$RiskInfo
  extends MessageMicro<RiskInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_tips_template", "str_login_loc", "str_appname" }, new Object[] { "", "", "" }, RiskInfo.class);
  public final PBStringField str_appname = PBField.initString("");
  public final PBStringField str_login_loc = PBField.initString("");
  public final PBStringField str_tips_template = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtlogin.qrlogin.scanresult.QrLogin.RiskInfo
 * JD-Core Version:    0.7.0.1
 */