package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloSmobaRoomChooceHeroAction
  extends MessageMicro<YoloSmobaRoomChooceHeroAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "room_speaking_pos", "speaking_pos_list_version" }, new Object[] { null, Integer.valueOf(0) }, YoloSmobaRoomChooceHeroAction.class);
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass.YoloRoomSpeakingPosInfo();
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomChooceHeroAction
 * JD-Core Version:    0.7.0.1
 */