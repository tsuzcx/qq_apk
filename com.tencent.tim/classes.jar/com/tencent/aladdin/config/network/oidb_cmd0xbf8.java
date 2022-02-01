package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xbf8
{
  public static final class BrandInfo
    extends MessageMicro<BrandInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "brand", "model", "manufacturer" }, new Object[] { "", "", "" }, BrandInfo.class);
    public final PBStringField brand = PBField.initString("");
    public final PBStringField manufacturer = PBField.initString("");
    public final PBStringField model = PBField.initString("");
  }
  
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
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Camera.class);
  }
  
  public static final class Config
    extends MessageMicro<Config>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "id", "version", "wipe_flag", "content" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, Config.class);
    public final PBStringField content = PBField.initString("");
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBUInt32Field wipe_flag = PBField.initUInt32(0);
  }
  
  public static final class ConfigResult
    extends MessageMicro<ConfigResult>
  {
    public static final int FAIL = 1;
    public static final int SUCCESS = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "id", "version", "ret_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ConfigResult.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class ConfigSeq
    extends MessageMicro<ConfigSeq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "id", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ConfigSeq.class);
    public final PBUInt32Field id = PBField.initUInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
  }
  
  public static final class DeviceInfo
    extends MessageMicro<DeviceInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "os", "cpu", "memory", "storage", "screen", "camera", "brand" }, new Object[] { null, null, null, null, null, null, null }, DeviceInfo.class);
    public oidb_cmd0xbf8.BrandInfo brand = new oidb_cmd0xbf8.BrandInfo();
    public oidb_cmd0xbf8.Camera camera = new oidb_cmd0xbf8.Camera();
    public oidb_cmd0xbf8.CPU cpu = new oidb_cmd0xbf8.CPU();
    public oidb_cmd0xbf8.Memory memory = new oidb_cmd0xbf8.Memory();
    public oidb_cmd0xbf8.OS os = new oidb_cmd0xbf8.OS();
    public oidb_cmd0xbf8.Screen screen = new oidb_cmd0xbf8.Screen();
    public oidb_cmd0xbf8.Storage storage = new oidb_cmd0xbf8.Storage();
  }
  
  public static final class Memory
    extends MessageMicro<Memory>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "total" }, new Object[] { Long.valueOf(0L) }, Memory.class);
    public final PBUInt64Field total = PBField.initUInt64(0L);
  }
  
  public static final class OS
    extends MessageMicro<OS>
  {
    public static final int ANDROID = 2;
    public static final int IOS = 1;
    public static final int OTHER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "type", "version", "sdk", "kernel" }, new Object[] { Integer.valueOf(1), "", "", "" }, OS.class);
    public final PBStringField kernel = PBField.initString("");
    public final PBStringField sdk = PBField.initString("");
    public final PBEnumField type = PBField.initEnum(1);
    public final PBStringField version = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "req_type", "body_type_1", "body_type_2", "uin", "appId" }, new Object[] { Integer.valueOf(0), null, null, "", Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field appId = PBField.initUInt32(0);
    public oidb_cmd0xbf8.ReqBodyType1 body_type_1 = new oidb_cmd0xbf8.ReqBodyType1();
    public oidb_cmd0xbf8.ReqBodyType2 body_type_2 = new oidb_cmd0xbf8.ReqBodyType2();
    public final PBUInt32Field req_type = PBField.initUInt32(0);
    public final PBStringField uin = PBField.initString("");
  }
  
  public static final class ReqBodyType1
    extends MessageMicro<ReqBodyType1>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField app_id = PBField.initString("");
    public final PBStringField app_version = PBField.initString("");
    public final PBBytesField cache = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0xbf8.DeviceInfo device_info = new oidb_cmd0xbf8.DeviceInfo();
    public final PBRepeatMessageField<oidb_cmd0xbf8.ConfigSeq> rpt_config_list = PBField.initRepeatMessage(oidb_cmd0xbf8.ConfigSeq.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "device_info", "app_version", "rpt_config_list", "app_id", "cache" }, new Object[] { null, "", null, "", localByteStringMicro }, ReqBodyType1.class);
    }
  }
  
  public static final class ReqBodyType2
    extends MessageMicro<ReqBodyType2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "cookie", "rpt_ret_list" }, new Object[] { "", null }, ReqBodyType2.class);
    public final PBStringField cookie = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xbf8.ConfigResult> rpt_ret_list = PBField.initRepeatMessage(oidb_cmd0xbf8.ConfigResult.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int INTERNAL_ERROR = 2;
    public static final int INVALID_PACKAGE = 3;
    public static final int INVALID_REQ1 = 1;
    public static final int SUCCESS = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "ret_code", "rsp_type", "body_type_1", "body_type_2" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null }, RspBody.class);
    public oidb_cmd0xbf8.RspBodyType1 body_type_1 = new oidb_cmd0xbf8.RspBodyType1();
    public oidb_cmd0xbf8.RspBodyType2 body_type_2 = new oidb_cmd0xbf8.RspBodyType2();
    public final PBEnumField ret_code = PBField.initEnum(0);
    public final PBUInt32Field rsp_type = PBField.initUInt32(0);
  }
  
  public static final class RspBodyType1
    extends MessageMicro<RspBodyType1>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField cache = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField cookie = PBField.initString("");
    public final PBStringField msg = PBField.initString("");
    public final PBRepeatMessageField<oidb_cmd0xbf8.Config> rpt_config_list = PBField.initRepeatMessage(oidb_cmd0xbf8.Config.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_config_list", "msg", "cookie", "cache" }, new Object[] { null, "", "", localByteStringMicro }, RspBodyType1.class);
    }
  }
  
  public static final class RspBodyType2
    extends MessageMicro<RspBodyType2>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg" }, new Object[] { "" }, RspBodyType2.class);
    public final PBStringField msg = PBField.initString("");
  }
  
  public static final class Screen
    extends MessageMicro<Screen>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "width", "height", "dpi" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Screen.class);
    public final PBUInt32Field dpi = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8
 * JD-Core Version:    0.7.0.1
 */