package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$UserLeaveRoomSyncReq
  extends MessageMicro<UserLeaveRoomSyncReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "roomid", "scene" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, UserLeaveRoomSyncReq.class);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.UserLeaveRoomSyncReq
 * JD-Core Version:    0.7.0.1
 */