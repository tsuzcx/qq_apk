package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomEnterReq
  extends MessageMicro<CmdRoomEnterReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField from = PBField.initEnum(0);
  public final PBUInt32Field init_status = PBField.initUInt32(0);
  public final PBUInt64Field invitor_uin = PBField.initUInt64(0L);
  public final PBUInt64Field pk_opponent_uin = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBUInt32Field trans_mod = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "from", "roomid", "uin", "invitor_uin", "init_status", "scene", "pk_opponent_uin", "trans_mod" }, new Object[] { localInteger, localLong, localLong, localLong, localInteger, localInteger, localLong, localInteger }, CmdRoomEnterReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomEnterReq
 * JD-Core Version:    0.7.0.1
 */