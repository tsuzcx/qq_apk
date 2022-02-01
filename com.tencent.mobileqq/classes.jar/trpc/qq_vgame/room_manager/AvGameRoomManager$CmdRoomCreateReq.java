package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomCreateReq
  extends MessageMicro<CmdRoomCreateReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field creator_uin = PBField.initUInt64(0L);
  public final PBEnumField from = PBField.initEnum(0);
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBUInt32Field pool_id = PBField.initUInt32(0);
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBUInt32Field trans_mod = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "from", "creator_uin", "group_id", "game_type", "scene", "pk_id", "pool_id", "trans_mod" }, new Object[] { localInteger, localLong, localLong, localInteger, localInteger, localInteger, localInteger, localInteger }, CmdRoomCreateReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomCreateReq
 * JD-Core Version:    0.7.0.1
 */