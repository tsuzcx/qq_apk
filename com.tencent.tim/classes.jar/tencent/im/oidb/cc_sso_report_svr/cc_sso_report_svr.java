package tencent.im.oidb.cc_sso_report_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cc_sso_report_svr
{
  public static final class BasicInfo
    extends MessageMicro<BasicInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "channel", "platform", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, BasicInfo.class);
    public final PBUInt32Field channel = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class KeyVal
    extends MessageMicro<KeyVal>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "key", "val" }, new Object[] { "", "" }, KeyVal.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
  }
  
  public static final class PlayInfo
    extends MessageMicro<PlayInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48 }, new String[] { "genurl_duration", "genurl_errcode", "prepare_duration", "play_duration", "play_errcode", "skipframe_cnt" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, PlayInfo.class);
    public final PBUInt64Field genurl_duration = PBField.initUInt64(0L);
    public final PBUInt32Field genurl_errcode = PBField.initUInt32(0);
    public final PBUInt64Field play_duration = PBField.initUInt64(0L);
    public final PBStringField play_errcode = PBField.initString("");
    public final PBUInt64Field prepare_duration = PBField.initUInt64(0L);
    public final PBUInt32Field skipframe_cnt = PBField.initUInt32(0);
  }
  
  public static final class ReportInfoReq
    extends MessageMicro<ReportInfoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "basic_info", "video_info", "play_info", "ext_info" }, new Object[] { null, null, null, null }, ReportInfoReq.class);
    public cc_sso_report_svr.BasicInfo basic_info = new cc_sso_report_svr.BasicInfo();
    public final PBRepeatMessageField<cc_sso_report_svr.KeyVal> ext_info = PBField.initRepeatMessage(cc_sso_report_svr.KeyVal.class);
    public cc_sso_report_svr.PlayInfo play_info = new cc_sso_report_svr.PlayInfo();
    public cc_sso_report_svr.VideoInfo video_info = new cc_sso_report_svr.VideoInfo();
  }
  
  public static final class ReportInfoRsp
    extends MessageMicro<ReportInfoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "ret_code", "ret_msg" }, new Object[] { Integer.valueOf(0), "" }, ReportInfoRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "busitype", "video_type", "file_size", "video_duration", "encode_type", "weight", "height", "rate" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "" }, VideoInfo.class);
    public final PBUInt32Field busitype = PBField.initUInt32(0);
    public final PBUInt32Field encode_type = PBField.initUInt32(0);
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBUInt64Field height = PBField.initUInt64(0L);
    public final PBStringField rate = PBField.initString("");
    public final PBUInt64Field video_duration = PBField.initUInt64(0L);
    public final PBUInt32Field video_type = PBField.initUInt32(0);
    public final PBUInt64Field weight = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cc_sso_report_svr.cc_sso_report_svr
 * JD-Core Version:    0.7.0.1
 */