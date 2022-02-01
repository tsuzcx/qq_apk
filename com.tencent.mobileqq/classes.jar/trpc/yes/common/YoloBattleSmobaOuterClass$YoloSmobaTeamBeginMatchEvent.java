package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleSmobaOuterClass$YoloSmobaTeamBeginMatchEvent
  extends MessageMicro<YoloSmobaTeamBeginMatchEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "team_id", "battle_info" }, new Object[] { null, null }, YoloSmobaTeamBeginMatchEvent.class);
  public SmobaDataOuterClass.YoloTeamBattleInfo battle_info = new SmobaDataOuterClass.YoloTeamBattleInfo();
  public SmobaDataOuterClass.YoloTeamID team_id = new SmobaDataOuterClass.YoloTeamID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaTeamBeginMatchEvent
 * JD-Core Version:    0.7.0.1
 */