package NS_MINI_REPORT;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class REPORT
{
  public static final class SingleDcData
    extends MessageMicro<SingleDcData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "type", "dcid", "report_data", "extinfo" }, new Object[] { "", Integer.valueOf(0), null, null }, SingleDcData.class);
    public final PBUInt32Field dcid = PBField.initUInt32(0);
    public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBStringField type = PBField.initString("");
  }
  
  public static final class StDcReportReq
    extends MessageMicro<StDcReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDcReportReq.class);
    public final PBRepeatMessageField<REPORT.SingleDcData> dcdata = PBField.initRepeatMessage(REPORT.SingleDcData.class);
  }
  
  public static final class StDcReportRsp
    extends MessageMicro<StDcReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, StDcReportRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class StGameDcReportReq
    extends MessageMicro<StGameDcReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StGameDcReportReq.class);
    public final PBRepeatMessageField<REPORT.SingleDcData> dcdata = PBField.initRepeatMessage(REPORT.SingleDcData.class);
  }
  
  public static final class StGameDcReportRsp
    extends MessageMicro<StGameDcReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, StGameDcReportRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
  
  public static final class StThirdDcReportReq
    extends MessageMicro<StThirdDcReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StThirdDcReportReq.class);
    public final PBRepeatMessageField<REPORT.SingleDcData> dcdata = PBField.initRepeatMessage(REPORT.SingleDcData.class);
  }
  
  public static final class StThirdDcReportRsp
    extends MessageMicro<StThirdDcReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, StThirdDcReportRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_REPORT.REPORT
 * JD-Core Version:    0.7.0.1
 */