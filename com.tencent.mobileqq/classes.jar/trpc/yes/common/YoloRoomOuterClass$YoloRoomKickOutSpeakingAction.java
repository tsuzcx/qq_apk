package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomKickOutSpeakingAction
  extends MessageMicro<YoloRoomKickOutSpeakingAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "user_id", "room_speaking_pos", "speaking_pos_list_version" }, new Object[] { null, null, Integer.valueOf(0) }, YoloRoomKickOutSpeakingAction.class);
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass.YoloRoomSpeakingPosInfo();
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutSpeakingAction
 * JD-Core Version:    0.7.0.1
 */