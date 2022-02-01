package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleSmobaOuterClass$YoloSmobaTeamChangeEvent
  extends MessageMicro<YoloSmobaTeamChangeEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "change_type", "team_info" }, new Object[] { Integer.valueOf(0), null }, YoloSmobaTeamChangeEvent.class);
  public final PBEnumField change_type = PBField.initEnum(0);
  public SmobaDataOuterClass.YoloTeamInfo team_info = new SmobaDataOuterClass.YoloTeamInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaTeamChangeEvent
 * JD-Core Version:    0.7.0.1
 */