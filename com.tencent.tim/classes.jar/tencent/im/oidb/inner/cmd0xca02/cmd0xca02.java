package tencent.im.oidb.inner.cmd0xca02;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xca02
{
  public static final class AppInfo
    extends MessageMicro<AppInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plat_type", "str_app_version" }, new Object[] { Integer.valueOf(1), "" }, AppInfo.class);
    public final PBEnumField plat_type = PBField.initEnum(1);
    public final PBStringField str_app_version = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_type", "rpt_app_ids", "msg_app_info", "uint64_group_code", "uint32_group_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public cmd0xca02.AppInfo msg_app_info = new cmd0xca02.AppInfo();
    public final PBRepeatField<Integer> rpt_app_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_group_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class Result
    extends MessageMicro<Result>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_can_remove = PBField.initBool(false);
    public final PBBoolField bool_red_point = PBField.initBool(false);
    public cmd0xca02.AppInfo msg_app_info = new cmd0xca02.AppInfo();
    public final PBBytesField string_hash_val = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_icon = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField string_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_add_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_identify_visibilty = PBField.initUInt32(31);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 56, 64, 74, 80, 88 }, new String[] { "uint32_id", "uint32_res", "string_hash_val", "string_icon", "string_name", "string_url", "bool_red_point", "bool_can_remove", "msg_app_info", "uint32_add_timestamp", "uint32_identify_visibilty" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Boolean.valueOf(false), Boolean.valueOf(false), null, Integer.valueOf(0), Integer.valueOf(31) }, Result.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50, 56, 66, 74 }, new String[] { "uint32_timestamp", "rpt_result", "uint32_res", "bool_order", "available_app", "often_app", "disable_often", "often_app_wording", "all_app_wording" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Boolean.valueOf(false), null, null, Boolean.valueOf(false), "", "" }, RspBody.class);
    public final PBStringField all_app_wording = PBField.initString("");
    public final PBRepeatMessageField<cmd0xca02.Result> available_app = PBField.initRepeatMessage(cmd0xca02.Result.class);
    public final PBBoolField bool_order = PBField.initBool(false);
    public final PBBoolField disable_often = PBField.initBool(false);
    public final PBRepeatMessageField<cmd0xca02.Result> often_app = PBField.initRepeatMessage(cmd0xca02.Result.class);
    public final PBStringField often_app_wording = PBField.initString("");
    public final PBRepeatMessageField<cmd0xca02.Result> rpt_result = PBField.initRepeatMessage(cmd0xca02.Result.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.inner.cmd0xca02.cmd0xca02
 * JD-Core Version:    0.7.0.1
 */