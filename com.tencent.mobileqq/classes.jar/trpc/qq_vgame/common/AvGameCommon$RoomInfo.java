package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameCommon$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "seq", "roomid", "owner_uin", "game_status", "game_name", "users", "room_create_ts", "match_status" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "", null, Integer.valueOf(0), Integer.valueOf(0) }, RoomInfo.class);
  public final PBStringField game_name = PBField.initString("");
  public final PBEnumField game_status = PBField.initEnum(0);
  public final PBUInt32Field match_status = PBField.initUInt32(0);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBUInt32Field room_create_ts = PBField.initUInt32(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBRepeatMessageField<AvGameCommon.RoomUserInfo> users = PBField.initRepeatMessage(AvGameCommon.RoomUserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.RoomInfo
 * JD-Core Version:    0.7.0.1
 */