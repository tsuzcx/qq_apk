package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomChangeUserStatusReq
  extends MessageMicro<CmdRoomChangeUserStatusReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBEnumField user_status = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "roomid", "uin", "user_status", "scene" }, new Object[] { localLong, localLong, localInteger, localInteger }, CmdRoomChangeUserStatusReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomChangeUserStatusReq
 * JD-Core Version:    0.7.0.1
 */