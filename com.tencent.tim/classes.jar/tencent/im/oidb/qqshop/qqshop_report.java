package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqshop_report
{
  public static final class SQQSHPCliAdfbReq
    extends MessageMicro<SQQSHPCliAdfbReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50 }, new String[] { "puin", "msgid", "uin", "msg_type", "adid", "viewid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", "" }, SQQSHPCliAdfbReq.class);
    public final PBStringField adid = PBField.initString("");
    public final PBInt32Field msg_type = PBField.initInt32(0);
    public final PBUInt64Field msgid = PBField.initUInt64(0L);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBStringField viewid = PBField.initString("");
  }
  
  public static final class SQQSHPCliLogInfo
    extends MessageMicro<SQQSHPCliLogInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 72, 80, 88, 96, 106, 114 }, new String[] { "puin", "tvalue", "cnt", "network", "strp1", "strp2", "strp3", "strp4", "uintp1", "uintp2", "uintp3", "uintp4", "wifimac", "ifda" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "" }, SQQSHPCliLogInfo.class);
    public final PBUInt32Field cnt = PBField.initUInt32(0);
    public final PBStringField ifda = PBField.initString("");
    public final PBUInt32Field network = PBField.initUInt32(0);
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField strp1 = PBField.initString("");
    public final PBStringField strp2 = PBField.initString("");
    public final PBStringField strp3 = PBField.initString("");
    public final PBStringField strp4 = PBField.initString("");
    public final PBUInt32Field tvalue = PBField.initUInt32(0);
    public final PBUInt64Field uintp1 = PBField.initUInt64(0L);
    public final PBUInt64Field uintp2 = PBField.initUInt64(0L);
    public final PBUInt64Field uintp3 = PBField.initUInt64(0L);
    public final PBUInt64Field uintp4 = PBField.initUInt64(0L);
    public final PBStringField wifimac = PBField.initString("");
  }
  
  public static final class SQQSHPCliLogReq
    extends MessageMicro<SQQSHPCliLogReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "logs" }, new Object[] { null }, SQQSHPCliLogReq.class);
    public final PBRepeatMessageField<qqshop_report.SQQSHPCliLogInfo> logs = PBField.initRepeatMessage(qqshop_report.SQQSHPCliLogInfo.class);
  }
  
  public static final class SQQSHPCliLogRsp
    extends MessageMicro<SQQSHPCliLogRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, SQQSHPCliLogRsp.class);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_report
 * JD-Core Version:    0.7.0.1
 */