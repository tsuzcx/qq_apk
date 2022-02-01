package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomModifyInfoCmd
  extends MessageMicro<YoloRoomModifyInfoCmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_params", "smoba_room_params" }, new Object[] { null, null }, YoloRoomModifyInfoCmd.class);
  public YoloRoomOuterClass.YoloRoomParams room_params = new YoloRoomOuterClass.YoloRoomParams();
  public YoloRoomOuterClass.YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass.YoloSmobaRoomParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomModifyInfoCmd
 * JD-Core Version:    0.7.0.1
 */