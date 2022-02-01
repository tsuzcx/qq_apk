package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdChangeRoomMatchStatusReq
  extends MessageMicro<CmdChangeRoomMatchStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uin", "roomid", "match_status", "owner_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, CmdChangeRoomMatchStatusReq.class);
  public final PBUInt32Field match_status = PBField.initUInt32(0);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdChangeRoomMatchStatusReq
 * JD-Core Version:    0.7.0.1
 */