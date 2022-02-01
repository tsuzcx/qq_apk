package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTRule;

public final class oidb_cmd0x80a
{
  public static final class AttributeList
    extends MessageMicro<AttributeList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "att_id", "att_name", "att_value" }, new Object[] { Integer.valueOf(0), "", "" }, AttributeList.class);
    public final PBUInt32Field att_id = PBField.initUInt32(0);
    public final PBStringField att_name = PBField.initString("");
    public final PBStringField att_value = PBField.initString("");
  }
  
  public static final class CriticalEventConfiguration
    extends MessageMicro<CriticalEventConfiguration>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "path_1", "path_2", "path_3", "filter_list" }, new Object[] { "", "", "", "" }, CriticalEventConfiguration.class);
    public final PBRepeatField<String> filter_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField path_1 = PBField.initString("");
    public final PBStringField path_2 = PBField.initString("");
    public final PBStringField path_3 = PBField.initString("");
  }
  
  public static final class IdlePushWakeParam
    extends MessageMicro<IdlePushWakeParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "package_name" }, new Object[] { "" }, IdlePushWakeParam.class);
    public final PBStringField package_name = PBField.initString("");
  }
  
  public static final class KDEventReportReq
    extends MessageMicro<KDEventReportReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "event_id", "event_name", "att_list", "version" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, KDEventReportReq.class);
    public final PBRepeatMessageField<oidb_cmd0x80a.AttributeList> att_list = PBField.initRepeatMessage(oidb_cmd0x80a.AttributeList.class);
    public final PBUInt32Field event_id = PBField.initUInt32(0);
    public final PBStringField event_name = PBField.initString("");
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class KDEventReportResp
    extends MessageMicro<KDEventReportResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "result", "err_msg", "condParams", "unit_reset" }, new Object[] { Integer.valueOf(0), "", null, Integer.valueOf(0) }, KDEventReportResp.class);
    public final PBRepeatMessageField<oidb_cmd0x80a.ReportConditionParam> condParams = PBField.initRepeatMessage(oidb_cmd0x80a.ReportConditionParam.class);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBUInt32Field unit_reset = PBField.initUInt32(0);
  }
  
  public static final class ReportConditionParam
    extends MessageMicro<ReportConditionParam>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_event_id", "uint32_report_next_time", "report_time_seg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReportConditionParam.class);
    public final PBRepeatField<Long> report_time_seg = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_event_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_report_next_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 90 }, new String[] { "uint64_uin", "uint32_network_type", "uint32_kandian_mode", "uint32_app_bitmap", "uint32_configuration_bitmap", "uint32_is_concise_mode", "uint32_privacy_status", "req_kd_event_report_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqBody.class);
    public oidb_cmd0x80a.KDEventReportReq req_kd_event_report_req = new oidb_cmd0x80a.KDEventReportReq();
    public final PBUInt32Field uint32_app_bitmap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_configuration_bitmap = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_concise_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_kandian_mode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_network_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_privacy_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 90, 96, 104, 112, 120, 128, 138, 144, 154, 162, 176, 184 }, new String[] { "uint64_uin", "pulseTimerDuration", "leftBtmRedPntPulseMaxCnt", "firstScnRedPntPulseMaxCnt", "AIOPulseMaxCnt", "lastRecvMsgDuration", "lastSendMsgDuration", "leftBtmRedCntMaxForExitAIO", "uint64_main_video_tab_red", "rsp_kd_event_report_resp", "uint64_scroll_interval_time", "uint64_scroll_all_time", "uint64_chat_aio_time", "report_critical_event", "critical_event_debounce_interval", "critical_event_configuration", "force_top_daily_red_day_offset", "idle_push_wake_param", "msg_srt_rule_list", "uint64_delete_kdtab_num_redpnt", "uint64_should_hide_kdtab_num_redpnt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), null, Long.valueOf(0L), null, null, Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
    public final PBUInt64Field AIOPulseMaxCnt = PBField.initUInt64(0L);
    public oidb_cmd0x80a.CriticalEventConfiguration critical_event_configuration = new oidb_cmd0x80a.CriticalEventConfiguration();
    public final PBUInt64Field critical_event_debounce_interval = PBField.initUInt64(0L);
    public final PBUInt64Field firstScnRedPntPulseMaxCnt = PBField.initUInt64(0L);
    public final PBInt64Field force_top_daily_red_day_offset = PBField.initInt64(0L);
    public final PBRepeatMessageField<oidb_cmd0x80a.IdlePushWakeParam> idle_push_wake_param = PBField.initRepeatMessage(oidb_cmd0x80a.IdlePushWakeParam.class);
    public final PBUInt64Field lastRecvMsgDuration = PBField.initUInt64(0L);
    public final PBUInt64Field lastSendMsgDuration = PBField.initUInt64(0L);
    public final PBUInt64Field leftBtmRedCntMaxForExitAIO = PBField.initUInt64(0L);
    public final PBUInt64Field leftBtmRedPntPulseMaxCnt = PBField.initUInt64(0L);
    public final PBRepeatMessageField<oidb_cmd0x64e.SRTRule> msg_srt_rule_list = PBField.initRepeatMessage(oidb_cmd0x64e.SRTRule.class);
    public final PBUInt64Field pulseTimerDuration = PBField.initUInt64(0L);
    public final PBBoolField report_critical_event = PBField.initBool(false);
    public oidb_cmd0x80a.KDEventReportResp rsp_kd_event_report_resp = new oidb_cmd0x80a.KDEventReportResp();
    public final PBUInt64Field uint64_chat_aio_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_delete_kdtab_num_redpnt = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_main_video_tab_red = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_scroll_all_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_scroll_interval_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_should_hide_kdtab_num_redpnt = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a
 * JD-Core Version:    0.7.0.1
 */