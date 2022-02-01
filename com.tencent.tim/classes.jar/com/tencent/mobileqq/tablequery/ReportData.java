package com.tencent.mobileqq.tablequery;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReportData
{
  public static final class ReportDataItem
    extends MessageMicro<ReportDataItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48, 58, 66, 74, 82, 90 }, new String[] { "reqReportId", "reportId", "pv", "pv_day_earlier", "pv_month_earlier", "uv", "uv_day_earlier", "uv_month_earlier", "time", "param", "description" }, new Object[] { "", "", Long.valueOf(0L), "", "", Long.valueOf(0L), "", "", "", "", "" }, ReportDataItem.class);
    public final PBStringField description = PBField.initString("");
    public final PBStringField param = PBField.initString("");
    public final PBUInt64Field pv = PBField.initUInt64(0L);
    public final PBStringField pv_day_earlier = PBField.initString("");
    public final PBStringField pv_month_earlier = PBField.initString("");
    public final PBStringField reportId = PBField.initString("");
    public final PBStringField reqReportId = PBField.initString("");
    public final PBStringField time = PBField.initString("");
    public final PBUInt64Field uv = PBField.initUInt64(0L);
    public final PBStringField uv_day_earlier = PBField.initString("");
    public final PBStringField uv_month_earlier = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "reportId", "type", "params" }, new Object[] { "", Integer.valueOf(0), null }, ReqBody.class);
    public final PBRepeatMessageField<ReportData.ReqMqqParam> params = PBField.initRepeatMessage(ReportData.ReqMqqParam.class);
    public final PBRepeatField<String> reportId = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReqMqqParam
    extends MessageMicro<ReqMqqParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "department", "opername", "action" }, new Object[] { "", "", "" }, ReqMqqParam.class);
    public final PBStringField action = PBField.initString("");
    public final PBStringField department = PBField.initString("");
    public final PBStringField opername = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ReportData.ReportDataItem> reportArray = PBField.initRepeatMessage(ReportData.ReportDataItem.class);
    public final PBInt64Field ret = PBField.initInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "reportArray" }, new Object[] { Long.valueOf(0L), localByteStringMicro, null }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.ReportData
 * JD-Core Version:    0.7.0.1
 */