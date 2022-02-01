package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloRoomVoiceSwitchChangeAction
  extends MessageMicro<YoloRoomVoiceSwitchChangeAction>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field op = PBField.initInt32(0);
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass.YoloRoomSpeakingPosInfo();
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "op", "room_speaking_pos", "speaking_pos_list_version" }, new Object[] { localInteger, null, localInteger }, YoloRoomVoiceSwitchChangeAction.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomVoiceSwitchChangeAction
 * JD-Core Version:    0.7.0.1
 */