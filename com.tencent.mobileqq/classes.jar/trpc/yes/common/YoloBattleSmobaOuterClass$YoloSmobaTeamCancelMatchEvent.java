package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleSmobaOuterClass$YoloSmobaTeamCancelMatchEvent
  extends MessageMicro<YoloSmobaTeamCancelMatchEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "team_id" }, new Object[] { null }, YoloSmobaTeamCancelMatchEvent.class);
  public SmobaDataOuterClass.YoloTeamID team_id = new SmobaDataOuterClass.YoloTeamID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaTeamCancelMatchEvent
 * JD-Core Version:    0.7.0.1
 */