package wtlogin.qrlogin.scanresult;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class QrLogin$ScanResultInfo
  extends MessageMicro<ScanResultInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "scan_result", "safe_info", "risk_info", "reject_info" }, new Object[] { Integer.valueOf(0), null, null, null }, ScanResultInfo.class);
  public QrLogin.RejectInfo reject_info = new QrLogin.RejectInfo();
  public QrLogin.RiskInfo risk_info = new QrLogin.RiskInfo();
  public QrLogin.SafeInfo safe_info = new QrLogin.SafeInfo();
  public final PBEnumField scan_result = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wtlogin.qrlogin.scanresult.QrLogin.ScanResultInfo
 * JD-Core Version:    0.7.0.1
 */