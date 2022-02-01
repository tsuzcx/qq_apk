package tencent.im.oidb.cmd0x769;

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

public final class Oidb_0x769
{
  public static final int ANDROID = 2;
  public static final int FEATURE = 5;
  public static final int IOS = 1;
  public static final int SYMBIAN = 4;
  public static final int WINDOWSPHONE = 3;
  
  public static final class CPU
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "model", "cores", "frequency" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0) }, CPU.class);
    public final PBUInt32Field cores = PBField.initUInt32(0);
    public final PBUInt32Field frequency = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
  }
  
  public static final class Camera
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "primary", "secondary", "flash" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, Camera.class);
    public final PBBoolField flash = PBField.initBool(false);
    public final PBUInt64Field primary = PBField.initUInt64(0L);
    public final PBUInt64Field secondary = PBField.initUInt64(0L);
  }
  
  public static final class Config
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_type", "uint32_version", "rpt_content_list", "debug_msg", "rpt_msg_content_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", null }, Config.class);
    public final PBStringField debug_msg = PBField.initString("");
    public final PBRepeatField rpt_content_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField rpt_msg_content_list = PBField.initRepeatMessage(Oidb_0x769.Content.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  }
  
  public static final class ConfigSeq
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ConfigSeq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class Content
    extends MessageMicro
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
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "brand", "model", "os", "cpu", "memory", "storage", "screen", "camera" }, new Object[] { "", "", null, null, null, null, null, null }, DeviceInfo.class);
    public final PBStringField brand = PBField.initString("");
    public Oidb_0x769.Camera camera = new Oidb_0x769.Camera();
    public Oidb_0x769.CPU cpu = new Oidb_0x769.CPU();
    public Oidb_0x769.Memory memory = new Oidb_0x769.Memory();
    public final PBStringField model = PBField.initString("");
    public Oidb_0x769.OS os = new Oidb_0x769.OS();
    public Oidb_0x769.Screen screen = new Oidb_0x769.Screen();
    public Oidb_0x769.Storage storage = new Oidb_0x769.Storage();
  }
  
  public static final class Memory
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "total", "process" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Memory.class);
    public final PBUInt64Field process = PBField.initUInt64(0L);
    public final PBUInt64Field total = PBField.initUInt64(0L);
  }
  
  public static final class OS
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42 }, new String[] { "type", "version", "sdk", "kernel", "rom" }, new Object[] { Integer.valueOf(1), "", "", "", "" }, OS.class);
    public final PBStringField kernel = PBField.initString("");
    public final PBStringField rom = PBField.initString("");
    public final PBStringField sdk = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class QueryUinPackageUsageReq
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "type", "uin_file_size" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, QueryUinPackageUsageReq.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field uin_file_size = PBField.initUInt64(0L);
  }
  
  public static final class QueryUinPackageUsageRsp
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 82 }, new String[] { "status", "left_uin_num", "max_uin_num", "proportion", "uin_package_used_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null }, QueryUinPackageUsageRsp.class);
    public final PBUInt64Field left_uin_num = PBField.initUInt64(0L);
    public final PBUInt64Field max_uin_num = PBField.initUInt64(0L);
    public final PBUInt32Field proportion = PBField.initUInt32(0);
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBRepeatMessageField uin_package_used_list = PBField.initRepeatMessage(Oidb_0x769.UinPackageUsedInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 810 }, new String[] { "rpt_config_list", "msg_device_info", "str_info", "province", "city", "req_debug_msg", "query_uin_package_usage_req" }, new Object[] { null, null, "", "", "", Integer.valueOf(0), null }, ReqBody.class);
    public final PBStringField city = PBField.initString("");
    public Oidb_0x769.DeviceInfo msg_device_info = new Oidb_0x769.DeviceInfo();
    public final PBStringField province = PBField.initString("");
    public Oidb_0x769.QueryUinPackageUsageReq query_uin_package_usage_req = new Oidb_0x769.QueryUinPackageUsageReq();
    public final PBInt32Field req_debug_msg = PBField.initInt32(0);
    public final PBRepeatMessageField rpt_config_list = PBField.initRepeatMessage(Oidb_0x769.ConfigSeq.class);
    public final PBStringField str_info = PBField.initString("");
  }
  
  public static final class RspBody
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 810 }, new String[] { "uint32_result", "rpt_config_list", "query_uin_package_usage_rsp" }, new Object[] { Integer.valueOf(0), null, null }, RspBody.class);
    public Oidb_0x769.QueryUinPackageUsageRsp query_uin_package_usage_rsp = new Oidb_0x769.QueryUinPackageUsageRsp();
    public final PBRepeatMessageField rpt_config_list = PBField.initRepeatMessage(Oidb_0x769.Config.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class Screen
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "model", "width", "height", "dpi", "multi_touch" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false) }, Screen.class);
    public final PBUInt32Field dpi = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBStringField model = PBField.initString("");
    public final PBBoolField multi_touch = PBField.initBool(false);
    public final PBUInt32Field width = PBField.initUInt32(0);
  }
  
  public static final class Storage
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "builtin", "external" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Storage.class);
    public final PBUInt64Field builtin = PBField.initUInt64(0L);
    public final PBUInt64Field external = PBField.initUInt64(0L);
  }
  
  public static final class UinPackageUsedInfo
    extends MessageMicro
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "rule_id", "author", "url", "uin_num" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L) }, UinPackageUsedInfo.class);
    public final PBStringField author = PBField.initString("");
    public final PBUInt32Field rule_id = PBField.initUInt32(0);
    public final PBUInt64Field uin_num = PBField.initUInt64(0L);
    public final PBStringField url = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x769.Oidb_0x769
 * JD-Core Version:    0.7.0.1
 */