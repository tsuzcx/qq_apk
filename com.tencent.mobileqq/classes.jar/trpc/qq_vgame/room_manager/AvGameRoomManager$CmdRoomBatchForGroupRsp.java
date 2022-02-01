package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameRoomManager$CmdRoomBatchForGroupRsp
  extends MessageMicro<CmdRoomBatchForGroupRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "res", "total_room_num", "next", "is_end", "room_infos" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, CmdRoomBatchForGroupRsp.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBUInt32Field next = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBRepeatMessageField<AvGameCommon.RoomInfo> room_infos = PBField.initRepeatMessage(AvGameCommon.RoomInfo.class);
  public final PBUInt32Field total_room_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomBatchForGroupRsp
 * JD-Core Version:    0.7.0.1
 */