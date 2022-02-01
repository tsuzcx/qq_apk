package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomConf
  extends MessageMicro<YoloRoomConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "yolo_room_smoba_conf", "yolo_room_family_conf", "yolo_room_common_conf", "yolo_room_live_conf", "yolo_room_chat_conf", "yolo_room_community_conf" }, new Object[] { null, null, null, null, null, null }, YoloRoomConf.class);
  public YoloRoomOuterClass.YoloRoomChatConf yolo_room_chat_conf = new YoloRoomOuterClass.YoloRoomChatConf();
  public YoloRoomOuterClass.YoloRoomCommonConf yolo_room_common_conf = new YoloRoomOuterClass.YoloRoomCommonConf();
  public YoloRoomOuterClass.YoloRoomCommunityConf yolo_room_community_conf = new YoloRoomOuterClass.YoloRoomCommunityConf();
  public YoloRoomOuterClass.YoloRoomFamilyConf yolo_room_family_conf = new YoloRoomOuterClass.YoloRoomFamilyConf();
  public YoloRoomOuterClass.YoloRoomLiveConf yolo_room_live_conf = new YoloRoomOuterClass.YoloRoomLiveConf();
  public YoloRoomOuterClass.YoloRoomSmobaConf yolo_room_smoba_conf = new YoloRoomOuterClass.YoloRoomSmobaConf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomConf
 * JD-Core Version:    0.7.0.1
 */