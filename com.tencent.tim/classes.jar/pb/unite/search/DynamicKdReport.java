package pb.unite.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class DynamicKdReport
{
  public static final class KdReportResever
    extends MessageMicro<KdReportResever>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "sreseverkey", "sresevervalue" }, new Object[] { "", "" }, KdReportResever.class);
    public final PBStringField sreseverkey = PBField.initString("");
    public final PBStringField sresevervalue = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "suin", "sguid", "squa", "sclientIp", "splatform", "sversion", "ssessionId", "stimeStamp", "sopername", "smodule", "saction", "sreseverobj1", "sreseverobj2", "sreseverobj3", "sreseverver1", "sreseverver2", "sreseverver3", "sreseverver4", "sreseverver5", "sreseverver6", "sreseverver7", "vecresever" }, new Object[] { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", null }, ReqBody.class);
    public final PBStringField saction = PBField.initString("");
    public final PBStringField sclientIp = PBField.initString("");
    public final PBStringField sguid = PBField.initString("");
    public final PBStringField smodule = PBField.initString("");
    public final PBStringField sopername = PBField.initString("");
    public final PBStringField splatform = PBField.initString("");
    public final PBStringField squa = PBField.initString("");
    public final PBStringField sreseverobj1 = PBField.initString("");
    public final PBStringField sreseverobj2 = PBField.initString("");
    public final PBStringField sreseverobj3 = PBField.initString("");
    public final PBStringField sreseverver1 = PBField.initString("");
    public final PBStringField sreseverver2 = PBField.initString("");
    public final PBStringField sreseverver3 = PBField.initString("");
    public final PBStringField sreseverver4 = PBField.initString("");
    public final PBStringField sreseverver5 = PBField.initString("");
    public final PBStringField sreseverver6 = PBField.initString("");
    public final PBStringField sreseverver7 = PBField.initString("");
    public final PBStringField ssessionId = PBField.initString("");
    public final PBStringField stimeStamp = PBField.initString("");
    public final PBStringField suin = PBField.initString("");
    public final PBStringField sversion = PBField.initString("");
    public final PBRepeatMessageField<DynamicKdReport.KdReportResever> vecresever = PBField.initRepeatMessage(DynamicKdReport.KdReportResever.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "iret", "sreason" }, new Object[] { Integer.valueOf(0), "" }, RspBody.class);
    public final PBInt32Field iret = PBField.initInt32(0);
    public final PBStringField sreason = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pb.unite.search.DynamicKdReport
 * JD-Core Version:    0.7.0.1
 */