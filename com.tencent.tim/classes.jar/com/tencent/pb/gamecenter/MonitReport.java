package com.tencent.pb.gamecenter;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MonitReport
{
  public static final class MonitReportReq
    extends MessageMicro<MonitReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 26 }, new String[] { "type", "public_acct_req" }, new Object[] { Integer.valueOf(0), null }, MonitReportReq.class);
    public final PBRepeatMessageField<MonitReport.PublicAccountReq> public_acct_req = PBField.initRepeatMessage(MonitReport.PublicAccountReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class PublicAccountReq
    extends MessageMicro<PublicAccountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "msgid", "action", "url", "ts", "taskid" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L) }, PublicAccountReq.class);
    public final PBUInt32Field action = PBField.initUInt32(0);
    public final PBUInt64Field msgid = PBField.initUInt64(0L);
    public final PBUInt64Field taskid = PBField.initUInt64(0L);
    public final PBUInt64Field ts = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.gamecenter.MonitReport
 * JD-Core Version:    0.7.0.1
 */