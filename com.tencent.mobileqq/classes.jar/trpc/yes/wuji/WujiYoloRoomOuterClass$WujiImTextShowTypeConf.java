package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WujiYoloRoomOuterClass$WujiImTextShowTypeConf
  extends MessageMicro<WujiImTextShowTypeConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBBoolField is_limit_free = PBField.initBool(false);
  public final PBBoolField is_time_limit = PBField.initBool(false);
  public final PBBoolField is_use = PBField.initBool(false);
  public final PBInt32Field show_type = PBField.initInt32(0);
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBStringField text = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Boolean localBoolean = Boolean.valueOf(false);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56, 64 }, new String[] { "id", "show_type", "text", "is_use", "is_time_limit", "start_time", "end_time", "is_limit_free" }, new Object[] { localInteger, localInteger, "", localBoolean, localBoolean, localLong, localLong, localBoolean }, WujiImTextShowTypeConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiImTextShowTypeConf
 * JD-Core Version:    0.7.0.1
 */