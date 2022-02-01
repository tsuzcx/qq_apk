package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_report
{
  public static final class CommentInfo
    extends MessageMicro<CommentInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "time", "content" }, new Object[] { Long.valueOf(0L), "" }, CommentInfo.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt64Field time = PBField.initUInt64(0L);
  }
  
  public static final class ReportMsg
    extends MessageMicro<ReportMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 74, 82 }, new String[] { "informer", "type", "source_key", "report_reason", "platform", "version", "reportee", "from", "sub_source_key", "comment_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), "", null }, ReportMsg.class);
    public ilive_report.CommentInfo comment_info = new ilive_report.CommentInfo();
    public final PBUInt32Field from = PBField.initUInt32(0);
    public final PBUInt64Field informer = PBField.initUInt64(0L);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField report_reason = PBField.initString("");
    public final PBUInt64Field reportee = PBField.initUInt64(0L);
    public final PBStringField source_key = PBField.initString("");
    public final PBStringField sub_source_key = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ReportReq
    extends MessageMicro<ReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "report_msg" }, new Object[] { null }, ReportReq.class);
    public final PBRepeatMessageField<ilive_report.ReportMsg> report_msg = PBField.initRepeatMessage(ilive_report.ReportMsg.class);
  }
  
  public static final class ReportRsp
    extends MessageMicro<ReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, ReportRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.now.ilive_report
 * JD-Core Version:    0.7.0.1
 */