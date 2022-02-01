package tencent.im.c2s.splashscreenad;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SplashScreenAdReport
{
  public static final class ReportMsg
    extends MessageMicro<ReportMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_ad_id", "uint32_action_type" }, new Object[] { "", Integer.valueOf(0) }, ReportMsg.class);
    public final PBStringField str_ad_id = PBField.initString("");
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_report" }, new Object[] { Long.valueOf(0L), null }, ReqBody.class);
    public SplashScreenAdReport.ReportMsg msg_report = new SplashScreenAdReport.ReportMsg();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "int32_ret", "str_msg", "uint32_stop_exposure" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBUInt32Field uint32_stop_exposure = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.c2s.splashscreenad.SplashScreenAdReport
 * JD-Core Version:    0.7.0.1
 */