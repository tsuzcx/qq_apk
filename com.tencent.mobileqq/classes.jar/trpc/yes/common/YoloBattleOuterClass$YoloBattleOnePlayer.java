package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattleOnePlayer
  extends MessageMicro<YoloBattleOnePlayer>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field area = PBField.initInt32(0);
  public final PBInt32Field camp_id = PBField.initInt32(0);
  public final PBStringField game_openid = PBField.initString("");
  public final PBUInt64Field game_uid = PBField.initUInt64(0L);
  public final PBInt32Field is_ai = PBField.initInt32(0);
  public final PBInt32Field login_type = PBField.initInt32(0);
  public final PBBoolField need_update_battle_route = PBField.initBool(false);
  public final PBInt32Field partition = PBField.initInt32(0);
  public final PBEnumField partner_type = PBField.initEnum(0);
  public final PBInt32Field phone_system = PBField.initInt32(0);
  public final PBUInt32Field player_status = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 72, 80, 88, 160 }, new String[] { "login_type", "uid", "game_uid", "phone_system", "game_openid", "area", "partition", "camp_id", "need_update_battle_route", "player_status", "partner_type", "is_ai" }, new Object[] { localInteger, localLong, localLong, localInteger, "", localInteger, localInteger, localInteger, Boolean.valueOf(false), localInteger, localInteger, localInteger }, YoloBattleOnePlayer.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleOnePlayer
 * JD-Core Version:    0.7.0.1
 */