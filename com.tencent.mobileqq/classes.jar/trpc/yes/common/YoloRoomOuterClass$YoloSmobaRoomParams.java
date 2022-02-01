package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloSmobaRoomParams
  extends MessageMicro<YoloSmobaRoomParams>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field base_room_id = PBField.initUInt64(0L);
  public final PBInt32Field game_mode = PBField.initInt32(0);
  public final PBRepeatField<Integer> grade_list = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public final PBInt32Field is_auto_dismiss = PBField.initInt32(0);
  public final PBInt32Field is_off_double_check = PBField.initInt32(0);
  public final PBRepeatField<Integer> need_lane_type = PBField.initRepeat(PBInt32Field.__repeatHelper__);
  public GameDataServerOuterClass.GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass.GameRoleAbsInfo();
  public GameDataServerOuterClass.GameRoleId role_id = new GameDataServerOuterClass.GameRoleId();
  public GameDataServerOuterClass.GameRoleInfo role_info = new GameDataServerOuterClass.GameRoleInfo();
  public final PBInt32Field voice_control = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58, 66, 74, 80 }, new String[] { "game_mode", "grade_list", "voice_control", "is_off_double_check", "is_auto_dismiss", "base_room_id", "role_id", "role_abs_info", "role_info", "need_lane_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, Long.valueOf(0L), null, null, null, localInteger }, YoloSmobaRoomParams.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams
 * JD-Core Version:    0.7.0.1
 */