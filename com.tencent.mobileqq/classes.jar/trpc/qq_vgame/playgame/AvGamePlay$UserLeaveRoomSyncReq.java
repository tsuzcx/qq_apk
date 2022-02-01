package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$UserLeaveRoomSyncReq
  extends MessageMicro<UserLeaveRoomSyncReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt32Field scene = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "roomid", "scene" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, UserLeaveRoomSyncReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.UserLeaveRoomSyncReq
 * JD-Core Version:    0.7.0.1
 */