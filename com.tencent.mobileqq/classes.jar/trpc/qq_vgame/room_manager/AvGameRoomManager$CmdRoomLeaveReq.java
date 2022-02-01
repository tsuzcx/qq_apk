package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomLeaveReq
  extends MessageMicro<CmdRoomLeaveReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "roomid", "reason", "operator_uin", "target_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, CmdRoomLeaveReq.class);
  public final PBUInt64Field operator_uin = PBField.initUInt64(0L);
  public final PBUInt32Field reason = PBField.initUInt32(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field target_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq
 * JD-Core Version:    0.7.0.1
 */