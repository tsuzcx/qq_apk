package fudai;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FudaiActiveReport
{
  public static final class ActiveReportReq
    extends MessageMicro<ActiveReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128, 136, 144 }, new String[] { "act_id", "optime", "touin", "group_uin", "banner_id", "pendant_id", "vid", "game_id", "brand_id", "card_id", "fudai_id", "award_type", "cash_value", "entrance_remind", "fd_status_type", "share_source", "share_type", "follow_brand" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1), Boolean.valueOf(false) }, ActiveReportReq.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBEnumField award_type = PBField.initEnum(0);
    public final PBStringField banner_id = PBField.initString("");
    public final PBStringField brand_id = PBField.initString("");
    public final PBStringField card_id = PBField.initString("");
    public final PBUInt32Field cash_value = PBField.initUInt32(0);
    public final PBBoolField entrance_remind = PBField.initBool(false);
    public final PBEnumField fd_status_type = PBField.initEnum(0);
    public final PBBoolField follow_brand = PBField.initBool(false);
    public final PBStringField fudai_id = PBField.initString("");
    public final PBStringField game_id = PBField.initString("");
    public final PBUInt64Field group_uin = PBField.initUInt64(0L);
    public final PBUInt64Field optime = PBField.initUInt64(0L);
    public final PBStringField pendant_id = PBField.initString("");
    public final PBEnumField share_source = PBField.initEnum(1);
    public final PBEnumField share_type = PBField.initEnum(1);
    public final PBUInt64Field touin = PBField.initUInt64(0L);
    public final PBStringField vid = PBField.initString("");
  }
  
  public static final class ExceptionHandle
    extends MessageMicro<ExceptionHandle>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "task_id", "errcode", "msg", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, ExceptionHandle.class);
    public final PBEnumField errcode = PBField.initEnum(0);
    public final PBStringField msg = PBField.initString("");
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class FdConfig
    extends MessageMicro<FdConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "result", "type", "version", "task_id", "msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, FdConfig.class);
    public final PBStringField msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class PkgReq
    extends MessageMicro<PkgReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "user_comm_report", "fd_config", "resource_download", "exception_handle", "active_report" }, new Object[] { null, null, null, null, null }, PkgReq.class);
    public final PBRepeatMessageField<FudaiActiveReport.ActiveReportReq> active_report = PBField.initRepeatMessage(FudaiActiveReport.ActiveReportReq.class);
    public final PBRepeatMessageField<FudaiActiveReport.ExceptionHandle> exception_handle = PBField.initRepeatMessage(FudaiActiveReport.ExceptionHandle.class);
    public final PBRepeatMessageField<FudaiActiveReport.FdConfig> fd_config = PBField.initRepeatMessage(FudaiActiveReport.FdConfig.class);
    public final PBRepeatMessageField<FudaiActiveReport.ResourceDownload> resource_download = PBField.initRepeatMessage(FudaiActiveReport.ResourceDownload.class);
    public FudaiActiveReport.UserCommReport user_comm_report = new FudaiActiveReport.UserCommReport();
  }
  
  public static final class PkgRsp
    extends MessageMicro<PkgRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret", "err_msg", "batch_size" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, PkgRsp.class);
    public final PBUInt32Field batch_size = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field ret = PBField.initUInt32(0);
  }
  
  public static final class ResourceDownload
    extends MessageMicro<ResourceDownload>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "result", "url", "version", "task_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, ResourceDownload.class);
    public final PBEnumField result = PBField.initEnum(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class UserCommReport
    extends MessageMicro<UserCommReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 34, 40, 48, 58, 66 }, new String[] { "imei", "longitude", "latitude", "city_code", "net_type", "from_id", "mobile_type", "qua" }, new Object[] { "", Double.valueOf(0.0D), Double.valueOf(0.0D), "", Integer.valueOf(1), Integer.valueOf(0), "", "" }, UserCommReport.class);
    public final PBStringField city_code = PBField.initString("");
    public final PBUInt32Field from_id = PBField.initUInt32(0);
    public final PBStringField imei = PBField.initString("");
    public final PBDoubleField latitude = PBField.initDouble(0.0D);
    public final PBDoubleField longitude = PBField.initDouble(0.0D);
    public final PBStringField mobile_type = PBField.initString("");
    public final PBEnumField net_type = PBField.initEnum(1);
    public final PBStringField qua = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     fudai.FudaiActiveReport
 * JD-Core Version:    0.7.0.1
 */