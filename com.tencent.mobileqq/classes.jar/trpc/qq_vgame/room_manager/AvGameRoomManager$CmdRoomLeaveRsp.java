package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameRoomManager$CmdRoomLeaveRsp
  extends MessageMicro<CmdRoomLeaveRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "room_info" }, new Object[] { null, null }, CmdRoomLeaveRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveRsp
 * JD-Core Version:    0.7.0.1
 */