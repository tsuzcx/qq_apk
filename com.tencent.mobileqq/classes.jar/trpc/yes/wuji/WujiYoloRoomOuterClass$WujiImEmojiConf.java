package trpc.yes.wuji;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class WujiYoloRoomOuterClass$WujiImEmojiConf
  extends MessageMicro<WujiImEmojiConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field _sort = PBField.initInt32(0);
  public final PBInt32Field animation_type = PBField.initInt32(0);
  public final PBStringField animation_url = PBField.initString("");
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBInt32Field id = PBField.initInt32(0);
  public final PBBoolField is_time_limit = PBField.initBool(false);
  public final PBBoolField is_use = PBField.initBool(false);
  public final PBRepeatField<String> query_term = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField query_terms = PBField.initString("");
  public final PBStringField resource_url = PBField.initString("");
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBStringField text = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 72, 82, 802, 808 }, new String[] { "id", "text", "resource_url", "is_use", "is_time_limit", "start_time", "end_time", "query_term", "animation_type", "animation_url", "query_terms", "_sort" }, new Object[] { localInteger, "", "", localBoolean, localBoolean, localLong, localLong, "", localInteger, "", "", localInteger }, WujiImEmojiConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.wuji.WujiYoloRoomOuterClass.WujiImEmojiConf
 * JD-Core Version:    0.7.0.1
 */