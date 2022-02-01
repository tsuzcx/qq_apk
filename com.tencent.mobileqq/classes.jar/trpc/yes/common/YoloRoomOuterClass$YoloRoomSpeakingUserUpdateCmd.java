package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomSpeakingUserUpdateCmd
  extends MessageMicro<YoloRoomSpeakingUserUpdateCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "leave_status", "user_game_data" }, new Object[] { Integer.valueOf(0), null }, YoloRoomSpeakingUserUpdateCmd.class);
  public final PBInt32Field leave_status = PBField.initInt32(0);
  public YoloRoomOuterClass.YoloUserGameData user_game_data = new YoloRoomOuterClass.YoloUserGameData();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingUserUpdateCmd
 * JD-Core Version:    0.7.0.1
 */