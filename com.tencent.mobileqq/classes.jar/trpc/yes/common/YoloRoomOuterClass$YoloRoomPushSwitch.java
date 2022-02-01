package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloRoomOuterClass$YoloRoomPushSwitch
  extends MessageMicro<YoloRoomPushSwitch>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField is_off_all = PBField.initBool(false);
  public final PBBoolField is_off_battle_result_push = PBField.initBool(false);
  public final PBBoolField is_off_other_push = PBField.initBool(false);
  public final PBBoolField is_off_send_gift_push = PBField.initBool(false);
  public final PBBoolField is_off_user_enter_push = PBField.initBool(false);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 80 }, new String[] { "is_off_all", "is_off_battle_result_push", "is_off_send_gift_push", "is_off_user_enter_push", "is_off_other_push" }, new Object[] { localBoolean, localBoolean, localBoolean, localBoolean, localBoolean }, YoloRoomPushSwitch.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomPushSwitch
 * JD-Core Version:    0.7.0.1
 */