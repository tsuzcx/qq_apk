package com.tencent.pb;

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

public final class ReportTrace
{
  public static final class ExtParam
    extends MessageMicro<ExtParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "param_id", "value" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, ExtParam.class);
    public final PBUInt32Field param_id = PBField.initUInt32(0);
    public final PBUInt64Field value = PBField.initUInt64(0L);
  }
  
  public static final class ReportAnnoReq
    extends MessageMicro<ReportAnnoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "anno_list" }, new Object[] { null, null }, ReportAnnoReq.class);
    public final PBRepeatMessageField<ReportTrace.TraceAnnoEntry> anno_list = PBField.initRepeatMessage(ReportTrace.TraceAnnoEntry.class);
    public ReportTrace.ReportHead head = new ReportTrace.ReportHead();
  }
  
  public static final class ReportAnnoRsp
    extends MessageMicro<ReportAnnoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ReportAnnoRsp.class);
  }
  
  public static final class ReportHead
    extends MessageMicro<ReportHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBBytesField client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field conn_type = PBField.initUInt32(0);
    public final PBUInt32Field ip_type = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
    public final PBStringField os_ver = PBField.initString("");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField udid = PBField.initString("");
    public final PBStringField ver = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 66, 72 }, new String[] { "appid", "platform", "ver", "os_ver", "model", "udid", "ip_type", "client_ip", "conn_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ReportHead.class);
    }
  }
  
  public static final class ReportTraceReq
    extends MessageMicro<ReportTraceReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "head", "trace_list" }, new Object[] { null, null }, ReportTraceReq.class);
    public ReportTrace.ReportHead head = new ReportTrace.ReportHead();
    public final PBRepeatMessageField<ReportTrace.TraceEntry> trace_list = PBField.initRepeatMessage(ReportTrace.TraceEntry.class);
  }
  
  public static final class ReportTraceRsp
    extends MessageMicro<ReportTraceRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "report_interval", "report_num", "report_fail" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReportTraceRsp.class);
    public final PBUInt32Field report_fail = PBField.initUInt32(0);
    public final PBUInt32Field report_interval = PBField.initUInt32(0);
    public final PBUInt32Field report_num = PBField.initUInt32(0);
  }
  
  public static final class SpanAnnoEntry
    extends MessageMicro<SpanAnnoEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "span_id", "time_stamp", "anno_msg", "errCode" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0) }, SpanAnnoEntry.class);
    public final PBStringField anno_msg = PBField.initString("");
    public final PBInt32Field errCode = PBField.initInt32(0);
    public final PBUInt32Field span_id = PBField.initUInt32(0);
    public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
  }
  
  public static final class SpanEntry
    extends MessageMicro<SpanEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "span_id", "time_stamp", "result", "param_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null }, SpanEntry.class);
    public final PBRepeatMessageField<ReportTrace.ExtParam> param_list = PBField.initRepeatMessage(ReportTrace.ExtParam.class);
    public ReportTrace.reportStat result = new ReportTrace.reportStat();
    public final PBUInt32Field span_id = PBField.initUInt32(0);
    public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
  }
  
  public static final class TraceAnnoEntry
    extends MessageMicro<TraceAnnoEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48 }, new String[] { "uid", "trace_id", "span_anno_list", "ret", "server_timestamp", "feature_id" }, new Object[] { "", Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, TraceAnnoEntry.class);
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBUInt64Field server_timestamp = PBField.initUInt64(0L);
    public final PBRepeatMessageField<ReportTrace.SpanAnnoEntry> span_anno_list = PBField.initRepeatMessage(ReportTrace.SpanAnnoEntry.class);
    public final PBUInt64Field trace_id = PBField.initUInt64(0L);
    public final PBStringField uid = PBField.initString("");
  }
  
  public static final class TraceEntry
    extends MessageMicro<TraceEntry>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 64, 72, 80, 88 }, new String[] { "feature_id", "trace_id", "from_uid", "to_uid", "time_stamp", "span_list", "result", "extra1", "extra2", "extra3", "server_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, TraceEntry.class);
    public final PBUInt32Field extra1 = PBField.initUInt32(0);
    public final PBUInt32Field extra2 = PBField.initUInt32(0);
    public final PBUInt32Field extra3 = PBField.initUInt32(0);
    public final PBUInt32Field feature_id = PBField.initUInt32(0);
    public final PBStringField from_uid = PBField.initString("");
    public ReportTrace.reportStat result = new ReportTrace.reportStat();
    public final PBUInt64Field server_timestamp = PBField.initUInt64(0L);
    public final PBRepeatMessageField<ReportTrace.SpanEntry> span_list = PBField.initRepeatMessage(ReportTrace.SpanEntry.class);
    public final PBUInt64Field time_stamp = PBField.initUInt64(0L);
    public final PBStringField to_uid = PBField.initString("");
    public final PBUInt64Field trace_id = PBField.initUInt64(0L);
  }
  
  public static final class reportStat
    extends MessageMicro<reportStat>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "ret", "cost", "memory", "cpu", "net_type", "display", "java_heap", "native_heap" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, reportStat.class);
    public final PBInt32Field cost = PBField.initInt32(0);
    public final PBInt32Field cpu = PBField.initInt32(0);
    public final PBUInt32Field display = PBField.initUInt32(0);
    public final PBInt32Field java_heap = PBField.initInt32(0);
    public final PBInt32Field memory = PBField.initInt32(0);
    public final PBInt32Field native_heap = PBField.initInt32(0);
    public final PBUInt32Field net_type = PBField.initUInt32(0);
    public final PBInt32Field ret = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.ReportTrace
 * JD-Core Version:    0.7.0.1
 */