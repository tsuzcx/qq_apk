package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleInfo
  extends MessageMicro<YoloSmobaBattleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 82, 90, 98, 106, 800, 810 }, new String[] { "status", "smoba_config", "battle_entity", "team_info", "room_info", "smoba_schema", "last_event_type", "last_event" }, new Object[] { Integer.valueOf(1), null, null, null, null, null, Integer.valueOf(0), null }, YoloSmobaBattleInfo.class);
  public YoloBattleSmobaOuterClass.YoloSmobaBattleEntity battle_entity = new YoloBattleSmobaOuterClass.YoloSmobaBattleEntity();
  public YoloBattleSmobaOuterClass.YoloOneSmobaBattleEvent last_event = new YoloBattleSmobaOuterClass.YoloOneSmobaBattleEvent();
  public final PBEnumField last_event_type = PBField.initEnum(0);
  public SmobaDataOuterClass.YoloBattleRoomInfo room_info = new SmobaDataOuterClass.YoloBattleRoomInfo();
  public YoloBattleSmobaOuterClass.YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass.YoloSmobaBattleConfig();
  public YoloBattleSmobaOuterClass.YoloSmobaSchema smoba_schema = new YoloBattleSmobaOuterClass.YoloSmobaSchema();
  public final PBEnumField status = PBField.initEnum(1);
  public SmobaDataOuterClass.YoloTeamInfo team_info = new SmobaDataOuterClass.YoloTeamInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleInfo
 * JD-Core Version:    0.7.0.1
 */