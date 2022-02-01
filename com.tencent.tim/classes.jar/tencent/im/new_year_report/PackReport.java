package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackReport
{
  public static final class PkgReq
    extends MessageMicro<PkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uin", "promotion_id", "report", "seq" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, PkgReq.class);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<PackReport.Report> report = PBField.initRepeatMessage(PackReport.Report.class);
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class PkgResp
    extends MessageMicro<PkgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), "" }, PkgResp.class);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField retmsg = PBField.initString("");
  }
  
  public static final class Report
    extends MessageMicro<Report>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "id", "elems" }, new Object[] { Long.valueOf(0L), null }, Report.class);
    public final PBRepeatMessageField<PackReport.ReportElem> elems = PBField.initRepeatMessage(PackReport.ReportElem.class);
    public final PBUInt64Field id = PBField.initUInt64(0L);
  }
  
  public static final class ReportElem
    extends MessageMicro<ReportElem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "timestamp", "count" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ReportElem.class);
    public final PBUInt64Field count = PBField.initUInt64(0L);
    public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_report.PackReport
 * JD-Core Version:    0.7.0.1
 */