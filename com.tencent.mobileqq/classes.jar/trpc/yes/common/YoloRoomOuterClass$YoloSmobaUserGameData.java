package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloSmobaUserGameData
  extends MessageMicro<YoloSmobaUserGameData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField cur_resource_id = PBField.initString("");
  public final PBStringField cur_version_id = PBField.initString("");
  public GameDataServerOuterClass.GameRoleHeroInfo game_rolo_hero_info = new GameDataServerOuterClass.GameRoleHeroInfo();
  public final PBInt32Field game_status = PBField.initInt32(0);
  public final PBStringField gift_bill_no = PBField.initString("");
  public final PBInt32Field hero_lane_type = PBField.initInt32(0);
  public final PBInt32Field is_need_update_tips = PBField.initInt32(0);
  public final PBUInt32Field last_notify_time = PBField.initUInt32(0);
  public final PBInt32Field login_type = PBField.initInt32(0);
  public final PBStringField new_resource_id = PBField.initString("");
  public final PBStringField new_version_id = PBField.initString("");
  public final PBInt32Field phone_system = PBField.initInt32(0);
  public GameDataServerOuterClass.GameRoleAbsInfo role_abs_info = new GameDataServerOuterClass.GameRoleAbsInfo();
  public GameDataServerOuterClass.GameRoleId role_id = new GameDataServerOuterClass.GameRoleId();
  public GameDataServerOuterClass.GameRoleInfo role_info = new GameDataServerOuterClass.GameRoleInfo();
  public final PBInt32Field update_process = PBField.initInt32(0);
  public final PBInt32Field update_status = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 66, 74, 82, 90, 96, 104, 112, 122, 808, 818 }, new String[] { "role_id", "role_abs_info", "game_rolo_hero_info", "hero_lane_type", "game_status", "update_status", "update_process", "cur_version_id", "new_version_id", "cur_resource_id", "new_resource_id", "login_type", "phone_system", "is_need_update_tips", "role_info", "last_notify_time", "gift_bill_no" }, new Object[] { null, null, null, localInteger, localInteger, localInteger, localInteger, "", "", "", "", localInteger, localInteger, localInteger, null, localInteger, "" }, YoloSmobaUserGameData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaUserGameData
 * JD-Core Version:    0.7.0.1
 */