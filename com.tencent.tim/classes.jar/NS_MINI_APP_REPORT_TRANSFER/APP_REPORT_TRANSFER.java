package NS_MINI_APP_REPORT_TRANSFER;

import NS_COMM.COMM.Entry;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class APP_REPORT_TRANSFER
{
  public static final class SingleDcData
    extends MessageMicro<SingleDcData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "dcid", "report_data", "extinfo" }, new Object[] { Integer.valueOf(0), null, null }, SingleDcData.class);
    public final PBUInt32Field dcid = PBField.initUInt32(0);
    public final PBRepeatMessageField<COMM.Entry> extinfo = PBField.initRepeatMessage(COMM.Entry.class);
    public final PBRepeatMessageField<COMM.Entry> report_data = PBField.initRepeatMessage(COMM.Entry.class);
  }
  
  public static final class StDataReportReq
    extends MessageMicro<StDataReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDataReportReq.class);
    public final PBRepeatMessageField<APP_REPORT_TRANSFER.SingleDcData> dcdata = PBField.initRepeatMessage(APP_REPORT_TRANSFER.SingleDcData.class);
  }
  
  public static final class StDataReportRsp
    extends MessageMicro<StDataReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "ret" }, new Object[] { Integer.valueOf(0) }, StDataReportRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER
 * JD-Core Version:    0.7.0.1
 */