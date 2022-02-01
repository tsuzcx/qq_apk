package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaTeamDismissEvent
  extends MessageMicro<YoloSmobaTeamDismissEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "reason", "team_id" }, new Object[] { Integer.valueOf(0), null }, YoloSmobaTeamDismissEvent.class);
  public final PBUInt32Field reason = PBField.initUInt32(0);
  public SmobaDataOuterClass.YoloTeamID team_id = new SmobaDataOuterClass.YoloTeamID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaTeamDismissEvent
 * JD-Core Version:    0.7.0.1
 */