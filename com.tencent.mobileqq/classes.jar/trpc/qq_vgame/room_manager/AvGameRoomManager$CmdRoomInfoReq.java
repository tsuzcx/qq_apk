package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomInfoReq
  extends MessageMicro<CmdRoomInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomids", "uin", "opt" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, CmdRoomInfoReq.class);
  public final PBUInt32Field opt = PBField.initUInt32(0);
  public final PBUInt64Field roomids = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoReq
 * JD-Core Version:    0.7.0.1
 */