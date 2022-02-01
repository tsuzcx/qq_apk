package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameCommon$RoomInfo
  extends MessageMicro<RoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField create_from = PBField.initEnum(0);
  public final PBStringField game_name = PBField.initString("");
  public final PBEnumField game_status = PBField.initEnum(0);
  public final PBUInt32Field match_status = PBField.initUInt32(0);
  public final PBEnumField match_tag = PBField.initEnum(0);
  public final PBBoolField opened_match = PBField.initBool(false);
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBUInt32Field room_create_ts = PBField.initUInt32(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field seq = PBField.initUInt64(0L);
  public final PBRepeatMessageField<AvGameCommon.RoomUserInfo> users = PBField.initRepeatMessage(AvGameCommon.RoomUserInfo.class);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64, 72, 80, 88 }, new String[] { "seq", "roomid", "owner_uin", "game_status", "game_name", "users", "room_create_ts", "match_status", "match_tag", "opened_match", "create_from" }, new Object[] { localLong, localLong, localLong, localInteger, "", null, localInteger, localInteger, localInteger, Boolean.valueOf(false), localInteger }, RoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.RoomInfo
 * JD-Core Version:    0.7.0.1
 */