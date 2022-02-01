package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomCmdRsp
  extends MessageMicro<YoloRoomCmdRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 162, 170, 402, 410 }, new String[] { "yolo_room_start_game_cmd_rsp", "yolo_room_join_game_cmd_rsp", "yolo_start_battle_ob_cmd_rsp", "yolo_close_battle_ob_cmd_rsp" }, new Object[] { null, null, null, null }, YoloRoomCmdRsp.class);
  public YoloRoomOuterClass.YoloCloseBattleOBCmdRsp yolo_close_battle_ob_cmd_rsp = new YoloRoomOuterClass.YoloCloseBattleOBCmdRsp();
  public YoloRoomOuterClass.YoloRoomJoinGameCmdRsp yolo_room_join_game_cmd_rsp = new YoloRoomOuterClass.YoloRoomJoinGameCmdRsp();
  public YoloRoomOuterClass.YoloRoomStartGameCmdRsp yolo_room_start_game_cmd_rsp = new YoloRoomOuterClass.YoloRoomStartGameCmdRsp();
  public YoloRoomOuterClass.YoloStartBattleOBCmdRsp yolo_start_battle_ob_cmd_rsp = new YoloRoomOuterClass.YoloStartBattleOBCmdRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp
 * JD-Core Version:    0.7.0.1
 */