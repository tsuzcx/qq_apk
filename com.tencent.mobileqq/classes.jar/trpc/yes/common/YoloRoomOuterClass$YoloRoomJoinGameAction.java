package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomJoinGameAction
  extends MessageMicro<YoloRoomJoinGameAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_info", "user_id" }, new Object[] { null, null }, YoloRoomJoinGameAction.class);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomJoinGameAction
 * JD-Core Version:    0.7.0.1
 */