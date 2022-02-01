package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QrLogin$RejectInfo
  extends MessageMicro<RejectInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_tips" }, new Object[] { "" }, RejectInfo.class);
  public final PBStringField str_tips = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wtlogin.qrlogin.scanresult.QrLogin.RejectInfo
 * JD-Core Version:    0.7.0.1
 */