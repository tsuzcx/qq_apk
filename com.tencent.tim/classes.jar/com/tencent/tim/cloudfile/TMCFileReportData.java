package com.tencent.tim.cloudfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class TMCFileReportData
{
  public static final class TMCListReportData
    extends MessageMicro<TMCListReportData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 74, 80, 88, 96 }, new String[] { "sdk_version", "qq_version", "terminal_type", "report_group_id", "cmd_type", "cmd_error_code", "upward", "dir_key", "version", "fetched_item_count", "time_elapsed", "self_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, TMCListReportData.class);
    public final PBInt64Field cmd_error_code = PBField.initInt64(0L);
    public final PBUInt32Field cmd_type = PBField.initUInt32(0);
    public final PBStringField dir_key = PBField.initString("");
    public final PBUInt32Field fetched_item_count = PBField.initUInt32(0);
    public final PBUInt32Field qq_version = PBField.initUInt32(0);
    public final PBUInt64Field report_group_id = PBField.initUInt64(0L);
    public final PBUInt32Field sdk_version = PBField.initUInt32(0);
    public final PBUInt64Field self_uin = PBField.initUInt64(0L);
    public final PBUInt32Field terminal_type = PBField.initUInt32(0);
    public final PBUInt64Field time_elapsed = PBField.initUInt64(0L);
    public final PBUInt32Field upward = PBField.initUInt32(0);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class TMCRecursiveListReportData
    extends MessageMicro<TMCRecursiveListReportData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88 }, new String[] { "sdk_version", "qq_version", "terminal_type", "report_group_id", "recursive_fetch_type", "total_cmd_count", "last_cmd_error", "fetched_item_count", "time_out", "time_elapsed", "self_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, TMCRecursiveListReportData.class);
    public final PBUInt32Field fetched_item_count = PBField.initUInt32(0);
    public final PBInt64Field last_cmd_error = PBField.initInt64(0L);
    public final PBUInt32Field qq_version = PBField.initUInt32(0);
    public final PBUInt32Field recursive_fetch_type = PBField.initUInt32(0);
    public final PBUInt64Field report_group_id = PBField.initUInt64(0L);
    public final PBUInt32Field sdk_version = PBField.initUInt32(0);
    public final PBUInt64Field self_uin = PBField.initUInt64(0L);
    public final PBUInt32Field terminal_type = PBField.initUInt32(0);
    public final PBUInt64Field time_elapsed = PBField.initUInt64(0L);
    public final PBUInt32Field time_out = PBField.initUInt32(0);
    public final PBUInt32Field total_cmd_count = PBField.initUInt32(0);
  }
  
  public static final class TMCTransferData
    extends MessageMicro<TMCTransferData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 98, 104, 114, 120, 128, 136, 144, 152, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 248, 258, 266, 272 }, new String[] { "sdk_version", "qq_version", "terminal_type", "transfer_type", "suffix", "file_size", "life_left_second", "result", "sub_reason", "srv_code", "user_return_code", "server_ip", "server_port", "file_url", "proxy_type", "security_time", "check_time", "peer_uin", "peer_type", "is_online", "online_type", "is_online_create_in_TMC", "start_size", "transfer_size", "transfer_time", "transfer_speed", "retry_count", "timeout_duration", "flash_transfer", "airCopy_type", "self_uin", "file_name", "weiyun_file_id", "weiyun_task_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L) }, TMCTransferData.class);
    public final PBUInt32Field airCopy_type = PBField.initUInt32(0);
    public final PBUInt32Field check_time = PBField.initUInt32(0);
    public final PBStringField file_name = PBField.initString("");
    public final PBUInt64Field file_size = PBField.initUInt64(0L);
    public final PBStringField file_url = PBField.initString("");
    public final PBUInt32Field flash_transfer = PBField.initUInt32(0);
    public final PBUInt32Field is_online = PBField.initUInt32(0);
    public final PBUInt32Field is_online_create_in_TMC = PBField.initUInt32(0);
    public final PBUInt32Field life_left_second = PBField.initUInt32(0);
    public final PBUInt32Field online_type = PBField.initUInt32(0);
    public final PBUInt32Field peer_type = PBField.initUInt32(0);
    public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
    public final PBUInt32Field proxy_type = PBField.initUInt32(0);
    public final PBUInt32Field qq_version = PBField.initUInt32(0);
    public final PBUInt64Field result = PBField.initUInt64(0L);
    public final PBUInt32Field retry_count = PBField.initUInt32(0);
    public final PBUInt32Field sdk_version = PBField.initUInt32(0);
    public final PBUInt32Field security_time = PBField.initUInt32(0);
    public final PBUInt64Field self_uin = PBField.initUInt64(0L);
    public final PBStringField server_ip = PBField.initString("");
    public final PBUInt32Field server_port = PBField.initUInt32(0);
    public final PBInt64Field srv_code = PBField.initInt64(0L);
    public final PBUInt64Field start_size = PBField.initUInt64(0L);
    public final PBInt64Field sub_reason = PBField.initInt64(0L);
    public final PBStringField suffix = PBField.initString("");
    public final PBUInt32Field terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field timeout_duration = PBField.initUInt32(0);
    public final PBUInt64Field transfer_size = PBField.initUInt64(0L);
    public final PBUInt64Field transfer_speed = PBField.initUInt64(0L);
    public final PBUInt64Field transfer_time = PBField.initUInt64(0L);
    public final PBUInt32Field transfer_type = PBField.initUInt32(0);
    public final PBInt64Field user_return_code = PBField.initInt64(0L);
    public final PBStringField weiyun_file_id = PBField.initString("");
    public final PBUInt64Field weiyun_task_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.TMCFileReportData
 * JD-Core Version:    0.7.0.1
 */