package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloSmobaGameDataInfo
  extends MessageMicro<YoloSmobaGameDataInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBUInt64Field base_room_id = PBField.initUInt64(0L);
  public final PBInt32Field create_type = PBField.initInt32(0);
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBInt32Field is_auto_dismiss = PBField.initInt32(0);
  public final PBInt32Field is_off_double_check = PBField.initInt32(0);
  public final PBStringField mode_name = PBField.initString("");
  public final PBRepeatField<Integer> need_lane_type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBInt32Field voice_control = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 80 }, new String[] { "area", "game_mode", "grade_list", "voice_control", "mode_name", "create_type", "is_auto_dismiss", "is_off_double_check", "base_room_id", "need_lane_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger, Long.valueOf(0L), localInteger }, YoloSmobaGameDataInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameDataInfo
 * JD-Core Version:    0.7.0.1
 */