package tencent.im.oidb.qfind;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QFind
{
  public static final class DeviceInfo
    extends MessageMicro<DeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public QFind.DeviceLoc dev_loc = new QFind.DeviceLoc();
    public final PBUInt64Field din = PBField.initUInt64(0L);
    public QFind.HistoryData msg_walking_history = new QFind.HistoryData();
    public final PBUInt32Field pid = PBField.initUInt32(0);
    public final PBUInt64Field service_uuid = PBField.initUInt64(0L);
    public final PBBytesField sn = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_verify_dev = PBField.initUInt32(0);
    public final PBUInt32Field uint32_verify_dev_interval = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 58, 66, 72, 80, 162 }, new String[] { "service_uuid", "pid", "sn", "din", "timestamp", "type", "dev_loc", "bytes_sig", "uint32_need_verify_dev", "uint32_verify_dev_interval", "msg_walking_history" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), null }, DeviceInfo.class);
    }
  }
  
  public static final class DeviceLoc
    extends MessageMicro<DeviceLoc>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "timestamp", "lat", "lon", "gps_type", "uint32_precision" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DeviceLoc.class);
    public final PBUInt32Field gps_type = PBField.initUInt32(0);
    public final PBUInt32Field lat = PBField.initUInt32(0);
    public final PBUInt32Field lon = PBField.initUInt32(0);
    public final PBUInt32Field timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_precision = PBField.initUInt32(0);
  }
  
  public static final class HistoryData
    extends MessageMicro<HistoryData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "details", "tag" }, new Object[] { null, Integer.valueOf(0) }, HistoryData.class);
    public final PBRepeatMessageField<QFind.HistoryDetail> details = PBField.initRepeatMessage(QFind.HistoryDetail.class);
    public final PBUInt32Field tag = PBField.initUInt32(0);
  }
  
  public static final class HistoryDetail
    extends MessageMicro<HistoryDetail>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "date", "run", "walk", "duration" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, HistoryDetail.class);
    public final PBUInt32Field date = PBField.initUInt32(0);
    public final PBUInt32Field duration = PBField.initUInt32(0);
    public final PBUInt32Field run = PBField.initUInt32(0);
    public final PBUInt32Field walk = PBField.initUInt32(0);
  }
  
  public static final class ReqReportDevs
    extends MessageMicro<ReqReportDevs>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "dev_infos", "dev_loc" }, new Object[] { null, null }, ReqReportDevs.class);
    public final PBRepeatMessageField<QFind.DeviceInfo> dev_infos = PBField.initRepeatMessage(QFind.DeviceInfo.class);
    public QFind.DeviceLoc dev_loc = new QFind.DeviceLoc();
  }
  
  public static final class RespHeader
    extends MessageMicro<RespHeader>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "result", "desc" }, new Object[] { Integer.valueOf(0), "" }, RespHeader.class);
    public final PBStringField desc = PBField.initString("");
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class RspReportDevs
    extends MessageMicro<RspReportDevs>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90 }, new String[] { "result", "report_same_dev_interval", "report_any_devs_interval", "report_often_period", "report_often_frequence", "freq_limit_report_any_devs_interval", "force_report_lbs", "force_report_lbs_period", "report_same_lost_devs_interval", "report_max_dev_num", "lost_devs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RspReportDevs.class);
    public final PBUInt32Field force_report_lbs = PBField.initUInt32(0);
    public final PBUInt32Field force_report_lbs_period = PBField.initUInt32(0);
    public final PBUInt32Field freq_limit_report_any_devs_interval = PBField.initUInt32(0);
    public final PBRepeatMessageField<QFind.DeviceInfo> lost_devs = PBField.initRepeatMessage(QFind.DeviceInfo.class);
    public final PBUInt32Field report_any_devs_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_max_dev_num = PBField.initUInt32(0);
    public final PBUInt32Field report_often_frequence = PBField.initUInt32(0);
    public final PBUInt32Field report_often_period = PBField.initUInt32(0);
    public final PBUInt32Field report_same_dev_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_same_lost_devs_interval = PBField.initUInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qfind.QFind
 * JD-Core Version:    0.7.0.1
 */