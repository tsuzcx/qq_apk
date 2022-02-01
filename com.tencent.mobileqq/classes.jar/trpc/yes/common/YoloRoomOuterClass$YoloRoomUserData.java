package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomUserData
  extends MessageMicro<YoloRoomUserData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 42 }, new String[] { "user_id", "yolo_room_user_white_list" }, new Object[] { null, null }, YoloRoomUserData.class);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
  public YoloRoomOuterClass.YoloRoomUserWhiteList yolo_room_user_white_list = new YoloRoomOuterClass.YoloRoomUserWhiteList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomUserData
 * JD-Core Version:    0.7.0.1
 */