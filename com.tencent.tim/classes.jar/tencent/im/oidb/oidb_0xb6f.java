package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb6f
{
  public static final class Identity
    extends MessageMicro<Identity>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 80, 162 }, new String[] { "apiName", "appid", "apptype", "bizid", "int_ext1", "str_ext1" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "" }, Identity.class);
    public final PBStringField apiName = PBField.initString("");
    public final PBInt32Field appid = PBField.initInt32(0);
    public final PBInt32Field apptype = PBField.initInt32(0);
    public final PBInt32Field bizid = PBField.initInt32(0);
    public final PBInt64Field int_ext1 = PBField.initInt64(0L);
    public final PBStringField str_ext1 = PBField.initString("");
  }
  
  public static final class ReportFreqReqBody
    extends MessageMicro<ReportFreqReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "identity", "invoke_times" }, new Object[] { null, Long.valueOf(1L) }, ReportFreqReqBody.class);
    public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
    public final PBInt64Field invoke_times = PBField.initInt64(1L);
  }
  
  public static final class ReportFreqRspBody
    extends MessageMicro<ReportFreqRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 32, 40 }, new String[] { "identity", "remain_times", "expire_time" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, ReportFreqRspBody.class);
    public final PBUInt32Field expire_time = PBField.initUInt32(0);
    public oidb_0xb6f.Identity identity = new oidb_0xb6f.Identity();
    public final PBInt64Field remain_times = PBField.initInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "report_freq_req" }, new Object[] { null }, ReqBody.class);
    public oidb_0xb6f.ReportFreqReqBody report_freq_req = new oidb_0xb6f.ReportFreqReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "report_freq_rsp" }, new Object[] { null }, RspBody.class);
    public oidb_0xb6f.ReportFreqRspBody report_freq_rsp = new oidb_0xb6f.ReportFreqRspBody();
  }
  
  public static final class ThresholdInfo
    extends MessageMicro<ThresholdInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "threshold_per_minute", "threshold_per_day", "threshold_per_hour", "threshold_per_week" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, ThresholdInfo.class);
    public final PBInt64Field threshold_per_day = PBField.initInt64(0L);
    public final PBInt64Field threshold_per_hour = PBField.initInt64(0L);
    public final PBInt64Field threshold_per_minute = PBField.initInt64(0L);
    public final PBInt64Field threshold_per_week = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb6f
 * JD-Core Version:    0.7.0.1
 */