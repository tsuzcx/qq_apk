package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomCreateReq
  extends MessageMicro<YoloRoomCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "room_params", "smoba_room_params", "family_room_params", "live_room_params", "comm_room_params" }, new Object[] { null, null, null, null, null }, YoloRoomCreateReq.class);
  public YoloRoomOuterClass.YoloCommunityRoomParams comm_room_params = new YoloRoomOuterClass.YoloCommunityRoomParams();
  public YoloRoomOuterClass.YoloFamilyRoomParams family_room_params = new YoloRoomOuterClass.YoloFamilyRoomParams();
  public YoloRoomOuterClass.YoloLiveRoomParams live_room_params = new YoloRoomOuterClass.YoloLiveRoomParams();
  public YoloRoomOuterClass.YoloRoomParams room_params = new YoloRoomOuterClass.YoloRoomParams();
  public YoloRoomOuterClass.YoloSmobaRoomParams smoba_room_params = new YoloRoomOuterClass.YoloSmobaRoomParams();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCreateReq
 * JD-Core Version:    0.7.0.1
 */