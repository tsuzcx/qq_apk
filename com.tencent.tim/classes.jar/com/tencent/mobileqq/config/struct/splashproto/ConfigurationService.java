package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ConfigurationService
{
  public static final class CPU
    extends MessageMicro<CPU>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "model", "cores", "frequency" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, CPU.class);
    public final PBUInt32Field cores = PBField.initUInt32(0);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
  }
  
  public static final class Camera
    extends MessageMicro<Camera>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "primary", "secondary", "flash" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, Camera.class);
    public final PBBoolField flash = PBField.initBool(false);
    public final PBUInt64Field primary = PBField.initUInt64(0L);
    public final PBUInt64Field secondary = PBField.initUInt64(0L);
  }
  
  public static final class Config
    extends MessageMicro<Config>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "type", "version", "content_list", "msg_content_list", "msg_rich_info" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", null, null }, Config.class);
    public final PBRepeatField<String> content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<ConfigurationService.Content> msg_content_list = PBField.initRepeatMessage(ConfigurationService.Content.class);
    public ConfigurationService.RichInfo msg_rich_info = new ConfigurationService.RichInfo();
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field version = PBField.initInt32(0);
  }
  
  public static final class ConfigSeq
    extends MessageMicro<ConfigSeq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "type", "version", "compress" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ConfigSeq.class);
    public final PBInt32Field compress = PBField.initInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field version = PBField.initInt32(0);
  }
  
  public static final class Content
    extends MessageMicro<Content>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field compress = PBField.initUInt32(0);
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82 }, new String[] { "task_id", "compress", "content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, Content.class);
    }
  }
  
  public static final class DeviceInfo
    extends MessageMicro<DeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "brand", "model", "os", "cpu", "memory", "storage", "screen", "camera" }, new Object[] { "", "", null, null, null, null, null, null }, DeviceInfo.class);
    public final PBStringField brand = PBField.initString("");
    public ConfigurationService.Camera camera = new ConfigurationService.Camera();
    public ConfigurationService.CPU cpu = new ConfigurationService.CPU();
    public ConfigurationService.Memory memory = new ConfigurationService.Memory();
    public final PBStringField model = PBField.initString("");
    public ConfigurationService.OS os = new ConfigurationService.OS();
    public ConfigurationService.Screen screen = new ConfigurationService.Screen();
    public ConfigurationService.Storage storage = new ConfigurationService.Storage();
  }
  
  public static final class Memory
    extends MessageMicro<Memory>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "total", "process" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Memory.class);
    public final PBUInt64Field process = PBField.initUInt64(0L);
    public final PBUInt64Field total = PBField.initUInt64(0L);
  }
  
  public static final class OS
    extends MessageMicro<OS>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "type", "version", "sdk", "kernel", "rom" }, new Object[] { Integer.valueOf(1), "", "", "", "" }, OS.class);
    public final PBStringField kernel = PBField.initString("");
    public final PBStringField rom = PBField.initString("");
    public final PBStringField sdk = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class PageReqInfo
    extends MessageMicro<PageReqInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "task_id", "offset", "version", "cookies" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, PageReqInfo.class);
    }
  }
  
  public static final class PageRespInfo
    extends MessageMicro<PageRespInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field compress = PBField.initUInt32(0);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField md5 = PBField.initString("");
    public final PBInt32Field next_offset = PBField.initInt32(-1);
    public final PBUInt32Field page_size = PBField.initUInt32(0);
    public final PBUInt32Field report = PBField.initUInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field total_size = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 64, 74 }, new String[] { "task_id", "version", "compress", "total_size", "page_size", "md5", "report", "next_offset", "cookies" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(-1), localByteStringMicro }, PageRespInfo.class);
    }
  }
  
  public static final class ReportConfig
    extends MessageMicro<ReportConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66 }, new String[] { "type", "task_id", "version", "report_type", "result", "real_size", "total_size", "err_msgs" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ReportConfig.class);
    public final PBRepeatField<String> err_msgs = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field real_size = PBField.initUInt32(0);
    public final PBUInt32Field report_type = PBField.initUInt32(0);
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBUInt32Field total_size = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ReqGetConfig
    extends MessageMicro<ReqGetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field adcode = PBField.initUInt64(0L);
    public final PBStringField bind_phone_no = PBField.initString("");
    public final PBInt32Field carrier = PBField.initInt32(0);
    public final PBRepeatField<Integer> carriers = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBStringField city = PBField.initString("");
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBInt32Field is_page_req = PBField.initInt32(0);
    public final PBRepeatField<String> phone_nos = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField province = PBField.initString("");
    public final PBInt32Field req_debug_msg = PBField.initInt32(0);
    public final PBRepeatMessageField<ConfigurationService.ConfigSeq> seq_list = PBField.initRepeatMessage(ConfigurationService.ConfigSeq.class);
    public final PBStringField str_info = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 56, 64, 72, 82, 90, 96, 104, 808, 818 }, new String[] { "seq_list", "device_info", "str_info", "province", "city", "adcode", "int32_lat", "int32_lon", "carrier", "phone_nos", "bind_phone_no", "carriers", "req_debug_msg", "is_page_req", "cookies" }, new Object[] { null, null, "", "", "", Long.valueOf(0L), Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqGetConfig.class);
    }
  }
  
  public static final class ReqGetConfigByPage
    extends MessageMicro<ReqGetConfigByPage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "type", "page_info", "device_info" }, new Object[] { Integer.valueOf(0), null, null }, ReqGetConfigByPage.class);
    public ConfigurationService.DeviceInfo device_info = new ConfigurationService.DeviceInfo();
    public ConfigurationService.PageReqInfo page_info = new ConfigurationService.PageReqInfo();
    public final PBUInt32Field type = PBField.initUInt32(0);
  }
  
  public static final class ReqReportConfig
    extends MessageMicro<ReqReportConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "config_list" }, new Object[] { null }, ReqReportConfig.class);
    public final PBRepeatMessageField<ConfigurationService.ReportConfig> config_list = PBField.initRepeatMessage(ConfigurationService.ReportConfig.class);
  }
  
  public static final class RespGetConfig
    extends MessageMicro<RespGetConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<ConfigurationService.Config> config_list = PBField.initRepeatMessage(ConfigurationService.Config.class);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> debug_msg_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field min_req_interval_for_reconnect = PBField.initUInt32(0);
    public final PBRepeatField<Integer> next_req_types = PBField.initRepeat(PBInt32Field.__repeatHelper__);
    public final PBInt32Field result = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 802, 808 }, new String[] { "result", "config_list", "debug_msg_list", "next_req_types", "cookies", "min_req_interval_for_reconnect" }, new Object[] { Integer.valueOf(0), null, "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, RespGetConfig.class);
    }
  }
  
  public static final class RespGetConfigByPage
    extends MessageMicro<RespGetConfigByPage>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Integer> delay_time = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public ConfigurationService.PageRespInfo page_info = new ConfigurationService.PageRespInfo();
    public final PBInt32Field result = PBField.initInt32(0);
    public final PBRepeatField<Integer> seed_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field show_strategy = PBField.initUInt32(0);
    public final PBUInt32Field show_time = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field wording_no = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 808, 816, 824, 832, 840 }, new String[] { "result", "type", "content", "page_info", "delay_time", "wording_no", "seed_ids", "show_time", "show_strategy" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RespGetConfigByPage.class);
    }
  }
  
  public static final class RespReportConfig
    extends MessageMicro<RespReportConfig>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "result" }, new Object[] { Integer.valueOf(0) }, RespReportConfig.class);
    public final PBInt32Field result = PBField.initInt32(0);
  }
  
  public static final class RichInfo
    extends MessageMicro<RichInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "delay_time" }, new Object[] { Integer.valueOf(0) }, RichInfo.class);
    public final PBRepeatField<Integer> delay_time = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class Screen
    extends MessageMicro<Screen>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "model", "width", "height", "dpi", "multi_touch" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, Screen.class);
    public final PBUInt32Field dpi = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
    public final PBBoolField multi_touch = PBField.initBool(false);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class Storage
    extends MessageMicro<Storage>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "builtin", "external" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Storage.class);
    public final PBUInt64Field builtin = PBField.initUInt64(0L);
    public final PBUInt64Field external = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.splashproto.ConfigurationService
 * JD-Core Version:    0.7.0.1
 */