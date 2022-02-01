package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleSmobaOuterClass$YoloSmobaTeamBindBattleEvent
  extends MessageMicro<YoloSmobaTeamBindBattleEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "team_id", "team_entity" }, new Object[] { null, null }, YoloSmobaTeamBindBattleEvent.class);
  public YoloBattleSmobaOuterClass.YoloSmobaBattleEntity team_entity = new YoloBattleSmobaOuterClass.YoloSmobaBattleEntity();
  public SmobaDataOuterClass.YoloTeamID team_id = new SmobaDataOuterClass.YoloTeamID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaTeamBindBattleEvent
 * JD-Core Version:    0.7.0.1
 */