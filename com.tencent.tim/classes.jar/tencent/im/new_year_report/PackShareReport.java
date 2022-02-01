package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackShareReport
{
  public static final class PkgHead
    extends MessageMicro<PkgHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cmdtype = PBField.initUInt32(0);
    public final PBBytesField resp_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field retcode = PBField.initUInt32(0);
    public final PBStringField retmsg = PBField.initString("");
    public final PBUInt64Field seq = PBField.initUInt64(0L);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "cmdtype", "uin", "seq", "resp_name", "retcode", "retmsg" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), "" }, PkgHead.class);
    }
  }
  
  public static final class PkgReq
    extends MessageMicro<PkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "head", "report_share" }, new Object[] { null, null }, PkgReq.class);
    public PackShareReport.PkgHead head = new PackShareReport.PkgHead();
    public PackShareReport.ReportShareReq report_share = new PackShareReport.ReportShareReq();
  }
  
  public static final class PkgResp
    extends MessageMicro<PkgResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "head", "report_share" }, new Object[] { null, null }, PkgResp.class);
    public PackShareReport.PkgHead head = new PackShareReport.PkgHead();
    public PackShareReport.ReportShareResp report_share = new PackShareReport.ReportShareResp();
  }
  
  public static final class ReportShareReq
    extends MessageMicro<ReportShareReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "promotion_id", "share_type", "share_channel", "swipe_count", "combo_count", "win_money_count", "win_goods_count", "share_error" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReportShareReq.class);
    public final PBUInt32Field combo_count = PBField.initUInt32(0);
    public final PBUInt32Field promotion_id = PBField.initUInt32(0);
    public final PBUInt32Field share_channel = PBField.initUInt32(0);
    public final PBUInt32Field share_error = PBField.initUInt32(0);
    public final PBUInt32Field share_type = PBField.initUInt32(0);
    public final PBUInt32Field swipe_count = PBField.initUInt32(0);
    public final PBUInt32Field win_goods_count = PBField.initUInt32(0);
    public final PBUInt32Field win_money_count = PBField.initUInt32(0);
  }
  
  public static final class ReportShareResp
    extends MessageMicro<ReportShareResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "reserve" }, new Object[] { Integer.valueOf(0) }, ReportShareResp.class);
    public final PBUInt32Field reserve = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport
 * JD-Core Version:    0.7.0.1
 */