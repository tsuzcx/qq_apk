package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobile_monitor_report
{
  public static final class ExceptionReport
    extends MessageMicro<ExceptionReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "busi_id", "errcode", "msg" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), "" }, ExceptionReport.class);
    public final PBEnumField busi_id = PBField.initEnum(1);
    public final PBInt32Field errcode = PBField.initInt32(0);
    public final PBStringField msg = PBField.initString("");
  }
  
  public static final class PkgExceptionReq
    extends MessageMicro<PkgExceptionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_comm_report", "exception_report" }, new Object[] { null, null }, PkgExceptionReq.class);
    public final PBRepeatMessageField<mobile_monitor_report.ExceptionReport> exception_report = PBField.initRepeatMessage(mobile_monitor_report.ExceptionReport.class);
    public mobile_monitor_report.UserCommReport user_comm_report = new mobile_monitor_report.UserCommReport();
  }
  
  public static final class PkgRsp
    extends MessageMicro<PkgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "ret", "err_msg", "mult_cnt", "mult_delay" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, PkgRsp.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBInt32Field mult_cnt = PBField.initInt32(0);
    public final PBInt32Field mult_delay = PBField.initInt32(0);
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class PkgTraceReq
    extends MessageMicro<PkgTraceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "user_busi_type", "user_comm_report", "trace_report" }, new Object[] { Integer.valueOf(1), null, null }, PkgTraceReq.class);
    public final PBRepeatMessageField<mobile_monitor_report.TraceReport> trace_report = PBField.initRepeatMessage(mobile_monitor_report.TraceReport.class);
    public final PBEnumField user_busi_type = PBField.initEnum(1);
    public mobile_monitor_report.UserCommReport user_comm_report = new mobile_monitor_report.UserCommReport();
  }
  
  public static final class TraceReport
    extends MessageMicro<TraceReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg", "trace_id", "trace_num", "page_id" }, new Object[] { "", "", Integer.valueOf(0), "" }, TraceReport.class);
    public final PBStringField msg = PBField.initString("");
    public final PBStringField page_id = PBField.initString("");
    public final PBStringField trace_id = PBField.initString("");
    public final PBUInt32Field trace_num = PBField.initUInt32(0);
  }
  
  public static final class UserCommReport
    extends MessageMicro<UserCommReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 34, 40, 48, 58, 66 }, new String[] { "imei", "longitude", "latitude", "city_code", "net_type", "from_id", "mobile_type", "qua" }, new Object[] { "", Double.valueOf(0.0D), Double.valueOf(0.0D), "", Integer.valueOf(1), Integer.valueOf(0), "", "" }, UserCommReport.class);
    public final PBStringField city_code = PBField.initString("");
    public final PBUInt32Field from_id = PBField.initUInt32(0);
    public final PBStringField imei = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBStringField mobile_type = PBField.initString("");
    public final PBEnumField net_type = PBField.initEnum(1);
    public final PBStringField qua = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report
 * JD-Core Version:    0.7.0.1
 */