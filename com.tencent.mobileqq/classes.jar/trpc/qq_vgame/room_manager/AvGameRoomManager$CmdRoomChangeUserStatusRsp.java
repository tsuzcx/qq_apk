package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameRoomManager$CmdRoomChangeUserStatusRsp
  extends MessageMicro<CmdRoomChangeUserStatusRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "room_info" }, new Object[] { null, null }, CmdRoomChangeUserStatusRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusRsp
 * JD-Core Version:    0.7.0.1
 */