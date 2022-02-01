package tianshu;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQCircleTianShu$CommInfo
  extends MessageMicro<CommInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field iBid = PBField.initUInt32(0);
  public final PBInt32Field iNetWorkEnv = PBField.initInt32(0);
  public final PBUInt64Field lUin = PBField.initUInt64(0L);
  public QQCircleTianShu.Gps stGps = new QQCircleTianShu.Gps();
  public final PBStringField strApp = PBField.initString("");
  public final PBStringField strCityCode = PBField.initString("");
  public final PBStringField strDeviceInfo = PBField.initString("");
  public final PBStringField strExpSeq = PBField.initString("");
  public final PBStringField strOpenId = PBField.initString("");
  public final PBStringField strOs = PBField.initString("");
  public final PBStringField strQimei = PBField.initString("");
  public final PBStringField strQua = PBField.initString("");
  public final PBStringField strUid = PBField.initString("");
  public final PBStringField strUserIp = PBField.initString("");
  public final PBStringField strVersion = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26, 34, 40, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 162 }, new String[] { "lUin", "strDeviceInfo", "stGps", "iBid", "strUserIp", "strApp", "strOs", "strVersion", "strOpenId", "strCityCode", "iNetWorkEnv", "strQua", "strQimei", "strUid", "strExpSeq" }, new Object[] { Long.valueOf(0L), "", null, localInteger, "", "", "", "", "", "", localInteger, "", "", "", "" }, CommInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tianshu.QQCircleTianShu.CommInfo
 * JD-Core Version:    0.7.0.1
 */