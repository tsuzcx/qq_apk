package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloRoomOuterClass$YoloSmobaGameRouteInfo
  extends MessageMicro<YoloSmobaGameRouteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 826, 834 }, new String[] { "base_info", "smoba_schema", "create_type", "team_info", "battle_room_info", "battle_entity", "battle_begin_event_info" }, new Object[] { null, null, Integer.valueOf(0), null, null, null, null }, YoloSmobaGameRouteInfo.class);
  public YoloBattleOuterClass.YoloBattleBaseInfo base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public YoloBattleSmobaOuterClass.YoloSmobaBattleBeginEvent battle_begin_event_info = new YoloBattleSmobaOuterClass.YoloSmobaBattleBeginEvent();
  public YoloBattleSmobaOuterClass.YoloSmobaBattleEntity battle_entity = new YoloBattleSmobaOuterClass.YoloSmobaBattleEntity();
  public SmobaDataOuterClass.YoloBattleRoomInfo battle_room_info = new SmobaDataOuterClass.YoloBattleRoomInfo();
  public final PBInt32Field create_type = PBField.initInt32(0);
  public YoloBattleSmobaOuterClass.YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass.YoloSmobaSchema();
  public SmobaDataOuterClass.YoloTeamInfo team_info = new SmobaDataOuterClass.YoloTeamInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameRouteInfo
 * JD-Core Version:    0.7.0.1
 */