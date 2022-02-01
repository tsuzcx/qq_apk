package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$YoloRoomModifyInfoAction
  extends MessageMicro<YoloRoomModifyInfoAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "action_content_list", "room_info", "room_speaking_pos_list", "speaking_pos_list_version" }, new Object[] { null, null, null, Integer.valueOf(0) }, YoloRoomModifyInfoAction.class);
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomModifyInfoActionContent> action_content_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomModifyInfoActionContent.class);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoAction
 * JD-Core Version:    0.7.0.1
 */