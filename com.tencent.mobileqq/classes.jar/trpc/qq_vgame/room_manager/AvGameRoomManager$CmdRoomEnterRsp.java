package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;

public final class AvGameRoomManager$CmdRoomEnterRsp
  extends MessageMicro<CmdRoomEnterRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field already_in_roomid = PBField.initUInt64(0L);
  public final PBBytesField auth_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field black_ban_expire_time = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "res", "room_info", "auth_info", "black_ban_expire_time", "already_in_roomid" }, new Object[] { null, null, localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, CmdRoomEnterRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterRsp
 * JD-Core Version:    0.7.0.1
 */