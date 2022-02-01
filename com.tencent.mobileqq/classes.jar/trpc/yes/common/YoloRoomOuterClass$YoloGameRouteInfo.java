package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloGameRouteInfo
  extends MessageMicro<YoloGameRouteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloRoomOuterClass.YoloBattleOBRouteInfo battle_ob_route_info = new YoloRoomOuterClass.YoloBattleOBRouteInfo();
  public final PBUInt32Field create_time = PBField.initUInt32(0);
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> double_check_players = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomDoubleCheckPlayer.class);
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBInt32Field game_status = PBField.initInt32(0);
  public final PBUInt32Field refresh_reason = PBField.initUInt32(0);
  public YoloRoomOuterClass.YoloSmobaGameRouteInfo smoba_game_route_info = new YoloRoomOuterClass.YoloSmobaGameRouteInfo();
  public final PBUInt32Field timeout_report_scene = PBField.initUInt32(0);
  public YoloRoomOuterClass.YoloLiveRouteInfo yolo_live_route_info = new YoloRoomOuterClass.YoloLiveRouteInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 800, 808, 816, 824 }, new String[] { "game_status", "double_check_players", "smoba_game_route_info", "battle_ob_route_info", "yolo_live_route_info", "expire_time", "create_time", "timeout_report_scene", "refresh_reason" }, new Object[] { localInteger, null, null, null, null, localInteger, localInteger, localInteger, localInteger }, YoloGameRouteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo
 * JD-Core Version:    0.7.0.1
 */