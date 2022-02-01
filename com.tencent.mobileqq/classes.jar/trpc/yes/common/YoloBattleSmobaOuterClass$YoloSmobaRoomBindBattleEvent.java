package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleSmobaOuterClass$YoloSmobaRoomBindBattleEvent
  extends MessageMicro<YoloSmobaRoomBindBattleEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_id", "room_entity" }, new Object[] { null, null }, YoloSmobaRoomBindBattleEvent.class);
  public YoloBattleSmobaOuterClass.YoloSmobaBattleEntity room_entity = new YoloBattleSmobaOuterClass.YoloSmobaBattleEntity();
  public SmobaDataOuterClass.RoomID room_id = new SmobaDataOuterClass.RoomID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaRoomBindBattleEvent
 * JD-Core Version:    0.7.0.1
 */