package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQCircleClientSignalRecords
{
  public static final class SignalFlow
    extends MessageMicro<SignalFlow>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "records" }, new Object[] { null }, SignalFlow.class);
    public final PBRepeatMessageField<QQCircleClientSignalRecords.SignalRecord> records = PBField.initRepeatMessage(QQCircleClientSignalRecords.SignalRecord.class);
  }
  
  public static final class SignalRecord
    extends MessageMicro<SignalRecord>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "reportTime", "sessionid", "interval_time_ms", "opt_type" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Long.valueOf(0L) }, SignalRecord.class);
    public final PBInt64Field interval_time_ms = PBField.initInt64(0L);
    public final PBInt64Field opt_type = PBField.initInt64(0L);
    public final PBInt64Field reportTime = PBField.initInt64(0L);
    public final PBStringField sessionid = PBField.initString("");
  }
  
  public static final class StayTime
    extends MessageMicro<StayTime>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "todayTotalStayTime", "lastSyncStayTime" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, StayTime.class);
    public final PBInt64Field lastSyncStayTime = PBField.initInt64(0L);
    public final PBInt64Field todayTotalStayTime = PBField.initInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qqcircle.QQCircleClientSignalRecords
 * JD-Core Version:    0.7.0.1
 */