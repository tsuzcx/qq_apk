package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class newyear_report
{
  public static final class NYCommonInfo
    extends MessageMicro<NYCommonInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uin", "adcode", "plat", "report_array" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "" }, NYCommonInfo.class);
    public final PBStringField adcode = PBField.initString("");
    public final PBUInt32Field plat = PBField.initUInt32(0);
    public final PBStringField report_array = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class NYReportItems
    extends MessageMicro<NYReportItems>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "optime", "event", "action", "result", "param_array", "count" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, NYReportItems.class);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt32Field count = PBField.initUInt32(0);
    public final PBStringField event = PBField.initString("");
    public final PBUInt64Field optime = PBField.initUInt64(0L);
    public final PBStringField param_array = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
  
  public static final class NYReportReq
    extends MessageMicro<NYReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "commonInfo", "reportItems" }, new Object[] { null, null }, NYReportReq.class);
    public newyear_report.NYCommonInfo commonInfo = new newyear_report.NYCommonInfo();
    public final PBRepeatMessageField<newyear_report.NYReportItems> reportItems = PBField.initRepeatMessage(newyear_report.NYReportItems.class);
  }
  
  public static final class NYReportRsp
    extends MessageMicro<NYReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "ret", "errMsg", "batchSize", "reportLevel", "reportLevelTime" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NYReportRsp.class);
    public final PBUInt32Field batchSize = PBField.initUInt32(0);
    public final PBStringField errMsg = PBField.initString("");
    public final PBUInt32Field reportLevel = PBField.initUInt32(0);
    public final PBUInt32Field reportLevelTime = PBField.initUInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    
    public String toString()
    {
      return "NYReportRsp{ret=" + this.ret.get() + ", errMsg=" + this.errMsg.get() + ", batchSize=" + this.batchSize.get() + ", reportLevel=" + this.reportLevel.get() + ", reportLevelTime=" + this.reportLevelTime.get() + '}';
    }
  }
  
  public static final class OptionReq
    extends MessageMicro<OptionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 64, 74, 82 }, new String[] { "fingerprint", "model", "manufacturer", "brand", "device", "product", "id", "level", "cpu_abi", "cpu_abi2" }, new Object[] { "", "", "", "", "", "", "", Integer.valueOf(0), "", "" }, OptionReq.class);
    public final PBStringField brand = PBField.initString("");
    public final PBStringField cpu_abi = PBField.initString("");
    public final PBStringField cpu_abi2 = PBField.initString("");
    public final PBStringField device = PBField.initString("");
    public final PBStringField fingerprint = PBField.initString("");
    public final PBStringField id = PBField.initString("");
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField product = PBField.initString("");
  }
  
  public static final class SsoReq
    extends MessageMicro<SsoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "data", "option" }, new Object[] { null, null }, SsoReq.class);
    public newyear_report.NYReportReq data = new newyear_report.NYReportReq();
    public newyear_report.OptionReq option = new newyear_report.OptionReq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report
 * JD-Core Version:    0.7.0.1
 */