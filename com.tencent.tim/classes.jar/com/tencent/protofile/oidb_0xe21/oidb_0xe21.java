package com.tencent.protofile.oidb_0xe21;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.terminal_info.terminal_info.TerminalInfo;

public final class oidb_0xe21
{
  public static final class ADItem
    extends MessageMicro<ADItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rowkey", "read_duration", "read_time" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L) }, ADItem.class);
    public final PBUInt64Field read_duration = PBField.initUInt64(0L);
    public final PBUInt64Field read_time = PBField.initUInt64(0L);
    public final PBStringField rowkey = PBField.initString("");
  }
  
  public static final class ADReportReq
    extends MessageMicro<ADReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_ad" }, new Object[] { null }, ADReportReq.class);
    public final PBRepeatMessageField<oidb_0xe21.ADItem> rpt_ad = PBField.initRepeatMessage(oidb_0xe21.ADItem.class);
  }
  
  public static final class ADReportRsp
    extends MessageMicro<ADReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "today_ad_count" }, new Object[] { Integer.valueOf(0) }, ADReportRsp.class);
    public final PBUInt32Field today_ad_count = PBField.initUInt32(0);
  }
  
  public static final class ConsumeReportItem
    extends MessageMicro<ConsumeReportItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 24, 34, 40, 48, 56, 66, 72 }, new String[] { "current_progress", "total_progress", "rowkey", "current_rowkey_progress", "need_record", "next_request_time", "rpt_tips_items", "current_rowkey_incr_progress" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0) }, ConsumeReportItem.class);
    public final PBUInt32Field current_progress = PBField.initUInt32(0);
    public final PBUInt32Field current_rowkey_incr_progress = PBField.initUInt32(0);
    public final PBUInt32Field current_rowkey_progress = PBField.initUInt32(0);
    public final PBUInt32Field need_record = PBField.initUInt32(0);
    public final PBUInt64Field next_request_time = PBField.initUInt64(0L);
    public final PBStringField rowkey = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xe21.TipsItem> rpt_tips_items = PBField.initRepeatMessage(oidb_0xe21.TipsItem.class);
    public final PBUInt32Field total_progress = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 82, 122 }, new String[] { "rowkey", "type", "progress", "skey", "ad_report_req", "terminal_info" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", null, null }, ReqBody.class);
    public oidb_0xe21.ADReportReq ad_report_req = new oidb_0xe21.ADReportReq();
    public final PBUInt32Field progress = PBField.initUInt32(0);
    public final PBStringField rowkey = PBField.initString("");
    public final PBStringField skey = PBField.initString("");
    public terminal_info.TerminalInfo terminal_info = new terminal_info.TerminalInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 82 }, new String[] { "result_code", "rpt_consume_report_item", "task_config", "ad_report_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_0xe21.ADReportRsp ad_report_rsp = new oidb_0xe21.ADReportRsp();
    public final PBInt32Field result_code = PBField.initInt32(0);
    public oidb_0xe21.ConsumeReportItem rpt_consume_report_item = new oidb_0xe21.ConsumeReportItem();
    public oidb_0xe21.TaskConfig task_config = new oidb_0xe21.TaskConfig();
  }
  
  public static final class TaskConfig
    extends MessageMicro<TaskConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "total_progress", "total_cycle", "article_max_time", "article_still_max_time", "rpt_record_article_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, TaskConfig.class);
    public final PBUInt32Field article_max_time = PBField.initUInt32(0);
    public final PBUInt32Field article_still_max_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_record_article_type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBUInt32Field total_cycle = PBField.initUInt32(0);
    public final PBUInt32Field total_progress = PBField.initUInt32(0);
  }
  
  public static final class TipsItem
    extends MessageMicro<TipsItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "tips" }, new Object[] { "" }, TipsItem.class);
    public final PBStringField tips = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.protofile.oidb_0xe21.oidb_0xe21
 * JD-Core Version:    0.7.0.1
 */