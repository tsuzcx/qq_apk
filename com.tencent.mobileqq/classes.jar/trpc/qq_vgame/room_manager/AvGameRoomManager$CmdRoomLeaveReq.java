package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRoomManager$CmdRoomLeaveReq
  extends MessageMicro<CmdRoomLeaveReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField no_need_ban = PBField.initBool(false);
  public final PBUInt64Field operator_uin = PBField.initUInt64(0L);
  public final PBUInt32Field reason = PBField.initUInt32(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBUInt64Field target_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "roomid", "reason", "operator_uin", "target_uin", "no_need_ban", "scene" }, new Object[] { localLong, localInteger, localLong, localLong, Boolean.valueOf(false), localInteger }, CmdRoomLeaveReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomLeaveReq
 * JD-Core Version:    0.7.0.1
 */