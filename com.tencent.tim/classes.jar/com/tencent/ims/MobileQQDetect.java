package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class MobileQQDetect
{
  public static final int BASELINE_BACKTOFRONT = 4;
  public static final int BASELINE_LOGIN = 2;
  public static final int BASELINE_NOW = 1;
  public static final int BUSINESS_LUCKYMONEY = 1;
  public static final int NETWORK_2G = 2;
  public static final int NETWORK_3G = 3;
  public static final int NETWORK_4G = 4;
  public static final int NETWORK_UNKNOWN = 0;
  public static final int NETWORK_WIFI = 1;
  public static final int PLATFORM_ALL = 3;
  public static final int PLATFORM_ANDROID = 1;
  public static final int PLATFORM_IOS = 2;
  public static final int TYPE_INSTALLED_APPINFO = 48;
  public static final int TYPE_MANIFESTINFO = 80;
  public static final int TYPE_RUNNING_APPINFO = 64;
  public static final int TYPE_SELF_MODULEINFO = 32;
  public static final int TYPE_SIGNATURE = 16;
  
  public static final class DetectConditionPacket
    extends MessageMicro<DetectConditionPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_iOSVersion", "u32_androidVersion" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DetectConditionPacket.class);
    public final PBUInt32Field u32_androidVersion = PBField.initUInt32(0);
    public final PBUInt32Field u32_iOSVersion = PBField.initUInt32(0);
  }
  
  public static final class DetectItemPacket
    extends MessageMicro<DetectItemPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "u32_type", "u32_platform", "str_targetJson" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, DetectItemPacket.class);
    public final PBStringField str_targetJson = PBField.initString("");
    public final PBUInt32Field u32_platform = PBField.initUInt32(0);
    public final PBUInt32Field u32_type = PBField.initUInt32(0);
  }
  
  public static final class DetectItemResultPacket
    extends MessageMicro<DetectItemResultPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "u32_type", "str_result" }, new Object[] { Integer.valueOf(0), "" }, DetectItemResultPacket.class);
    public final PBStringField str_result = PBField.initString("");
    public final PBUInt32Field u32_type = PBField.initUInt32(0);
  }
  
  public static final class DetectProjectPacket
    extends MessageMicro<DetectProjectPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "u32_id", "u32_ttl", "u32_business", "condition", "time", "arr_items" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, DetectProjectPacket.class);
    public final PBRepeatMessageField<MobileQQDetect.DetectItemPacket> arr_items = PBField.initRepeatMessage(MobileQQDetect.DetectItemPacket.class);
    public MobileQQDetect.DetectConditionPacket condition = new MobileQQDetect.DetectConditionPacket();
    public MobileQQDetect.DetectTimePacket time = new MobileQQDetect.DetectTimePacket();
    public final PBUInt32Field u32_business = PBField.initUInt32(0);
    public final PBUInt32Field u32_id = PBField.initUInt32(0);
    public final PBUInt32Field u32_ttl = PBField.initUInt32(0);
  }
  
  public static final class DetectProjectResultPacket
    extends MessageMicro<DetectProjectResultPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58 }, new String[] { "envParam", "u32_version", "u32_id", "u32_business", "result", "str_trunk", "str_extra" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, "", "" }, DetectProjectResultPacket.class);
    public MobileQQDetect.EnvParamPacket envParam = new MobileQQDetect.EnvParamPacket();
    public final PBRepeatMessageField<MobileQQDetect.DetectItemResultPacket> result = PBField.initRepeatMessage(MobileQQDetect.DetectItemResultPacket.class);
    public final PBStringField str_extra = PBField.initString("");
    public final PBStringField str_trunk = PBField.initString("");
    public final PBUInt32Field u32_business = PBField.initUInt32(0);
    public final PBUInt32Field u32_id = PBField.initUInt32(0);
    public final PBUInt32Field u32_version = PBField.initUInt32(0);
  }
  
  public static final class DetectStrategyPacket
    extends MessageMicro<DetectStrategyPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_uid", "u32_frequency", "u32_platform", "arr_projects" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, DetectStrategyPacket.class);
    public final PBRepeatMessageField<MobileQQDetect.DetectProjectPacket> arr_projects = PBField.initRepeatMessage(MobileQQDetect.DetectProjectPacket.class);
    public final PBUInt32Field u32_frequency = PBField.initUInt32(0);
    public final PBUInt32Field u32_platform = PBField.initUInt32(0);
    public final PBUInt32Field u32_uid = PBField.initUInt32(0);
  }
  
  public static final class DetectTimePacket
    extends MessageMicro<DetectTimePacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "u32_baseline", "u32_delay" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, DetectTimePacket.class);
    public final PBUInt32Field u32_baseline = PBField.initUInt32(0);
    public final PBUInt32Field u32_delay = PBField.initUInt32(0);
  }
  
  public static final class EnvParamPacket
    extends MessageMicro<EnvParamPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_androidid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_imsi = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_cpuarch = PBField.initString("");
    public final PBStringField str_rominfo = PBField.initString("");
    public final PBStringField str_sysversion = PBField.initString("");
    public final PBStringField str_wifimac = PBField.initString("");
    public final PBUInt32Field u32_appid = PBField.initUInt32(0);
    public final PBUInt32Field u32_network = PBField.initUInt32(0);
    public final PBUInt32Field u32_platform = PBField.initUInt32(0);
    public final PBUInt32Field u32_root = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 56, 64, 74, 82, 90, 98 }, new String[] { "u32_platform", "str_sysversion", "u32_appid", "bytes_guid", "bytes_imei", "bytes_androidid", "u32_network", "u32_root", "bytes_imsi", "str_wifimac", "str_cpuarch", "str_rominfo" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, "", "", "" }, EnvParamPacket.class);
    }
  }
  
  public static final class PushDetectSrategyPacket
    extends MessageMicro<PushDetectSrategyPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_buffer" }, new Object[] { localByteStringMicro }, PushDetectSrategyPacket.class);
    }
  }
  
  public static final class ReportDetectResultPacket
    extends MessageMicro<ReportDetectResultPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "bytes_buffer", "ret" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReportDetectResultPacket.class);
    }
  }
  
  public static final class ReqDetectSrategyPacket
    extends MessageMicro<ReqDetectSrategyPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "u32_version", "u32_lastTime", "u32_lastUid", "envParam" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ReqDetectSrategyPacket.class);
    public MobileQQDetect.EnvParamPacket envParam = new MobileQQDetect.EnvParamPacket();
    public final PBUInt32Field u32_lastTime = PBField.initUInt32(0);
    public final PBUInt32Field u32_lastUid = PBField.initUInt32(0);
    public final PBUInt32Field u32_version = PBField.initUInt32(0);
  }
  
  public static final class RspDetectSrategyPacket
    extends MessageMicro<RspDetectSrategyPacket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "i32_ret", "bytes_buffer" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RspDetectSrategyPacket.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ims.MobileQQDetect
 * JD-Core Version:    0.7.0.1
 */