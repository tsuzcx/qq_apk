package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon.BytesEntry;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudCommon.Result;

public final class QQCircleReport
{
  public static final class SingleDcData
    extends MessageMicro<SingleDcData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "dcid", "report_data", "extinfo", "byteExtinfo" }, new Object[] { Integer.valueOf(0), null, null, null }, SingleDcData.class);
    public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
    public final PBUInt32Field dcid = PBField.initUInt32(0);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> extinfo = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon.Entry> report_data = PBField.initRepeatMessage(FeedCloudCommon.Entry.class);
  }
  
  public static final class StDataReportReq
    extends MessageMicro<StDataReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "dcdata" }, new Object[] { null }, StDataReportReq.class);
    public final PBRepeatMessageField<QQCircleReport.SingleDcData> dcdata = PBField.initRepeatMessage(QQCircleReport.SingleDcData.class);
  }
  
  public static final class StDataReportRsp
    extends MessageMicro<StDataReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, StDataReportRsp.class);
    public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
  }
  
  public static final class StHeartbeatSignalReq
    extends MessageMicro<StHeartbeatSignalReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 410, 418, 426 }, new String[] { "uin", "interval_time_ms", "sig_optype", "app_info", "network_info", "byteExtinfo" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null }, StHeartbeatSignalReq.class);
    public QQCircleBase.StAppInfo app_info = new QQCircleBase.StAppInfo();
    public final PBRepeatMessageField<FeedCloudCommon.BytesEntry> byteExtinfo = PBField.initRepeatMessage(FeedCloudCommon.BytesEntry.class);
    public final PBInt64Field interval_time_ms = PBField.initInt64(0L);
    public QQCircleBase.StNetworkInfo network_info = new QQCircleBase.StNetworkInfo();
    public final PBEnumField sig_optype = PBField.initEnum(0);
    public final PBInt64Field uin = PBField.initInt64(0L);
  }
  
  public static final class StHeartbeatSignalRsp
    extends MessageMicro<StHeartbeatSignalRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "result" }, new Object[] { null }, StHeartbeatSignalRsp.class);
    public FeedCloudCommon.Result result = new FeedCloudCommon.Result();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleReport
 * JD-Core Version:    0.7.0.1
 */