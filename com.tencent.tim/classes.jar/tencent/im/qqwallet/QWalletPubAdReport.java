package tencent.im.qqwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class QWalletPubAdReport
{
  public static final class QueryReq
    extends MessageMicro<QueryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "uin", "pskey", "channel", "terminal_infor" }, new Object[] { "", "", Integer.valueOf(0), null }, QueryReq.class);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBStringField pskey = PBField.initString("");
    public QWalletPubAdReport.TerminalInfor terminal_infor = new QWalletPubAdReport.TerminalInfor();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class QueryRsp
    extends MessageMicro<QueryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 72 }, new String[] { "ret", "msg", "uin", "pv_flag", "pv_timestamp", "uv_flag", "uv_day_freq", "uv_week_freq", "uv_mon_freq" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, QueryRsp.class);
    public final PBStringField msg = PBField.initString("");
    public final PBInt32Field pv_flag = PBField.initInt32(0);
    public final PBInt64Field pv_timestamp = PBField.initInt64(0L);
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
    public final PBInt32Field uv_day_freq = PBField.initInt32(0);
    public final PBInt32Field uv_flag = PBField.initInt32(0);
    public final PBInt32Field uv_mon_freq = PBField.initInt32(0);
    public final PBInt32Field uv_week_freq = PBField.initInt32(0);
  }
  
  public static final class ReportReq
    extends MessageMicro<ReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "uin", "pskey", "ad_reslut", "channel", "terminal_infor" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), null }, ReportReq.class);
    public final PBInt32Field ad_reslut = PBField.initInt32(0);
    public final PBInt32Field channel = PBField.initInt32(0);
    public final PBStringField pskey = PBField.initString("");
    public QWalletPubAdReport.TerminalInfor terminal_infor = new QWalletPubAdReport.TerminalInfor();
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class ReportRsp
    extends MessageMicro<ReportRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "ret", "msg", "uin" }, new Object[] { Integer.valueOf(0), "", "" }, ReportRsp.class);
    public final PBStringField msg = PBField.initString("");
    public final PBInt32Field ret = PBField.initInt32(0);
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class TerminalInfor
    extends MessageMicro<TerminalInfor>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66 }, new String[] { "model", "appid", "edition", "qq_version", "device_name", "client_os", "root_flag", "device_id" }, new Object[] { "", "", "", "", "", "", Integer.valueOf(0), "" }, TerminalInfor.class);
    public final PBStringField appid = PBField.initString("");
    public final PBStringField client_os = PBField.initString("");
    public final PBStringField device_id = PBField.initString("");
    public final PBStringField device_name = PBField.initString("");
    public final PBStringField edition = PBField.initString("");
    public final PBStringField model = PBField.initString("");
    public final PBStringField qq_version = PBField.initString("");
    public final PBInt32Field root_flag = PBField.initInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.qqwallet.QWalletPubAdReport
 * JD-Core Version:    0.7.0.1
 */