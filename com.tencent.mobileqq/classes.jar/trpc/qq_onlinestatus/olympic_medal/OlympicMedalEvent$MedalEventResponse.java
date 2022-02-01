package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class OlympicMedalEvent$MedalEventResponse
  extends MessageMicro<MedalEventResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "event_valid", "pull_interval_seconds", "event" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), null }, MedalEventResponse.class);
  public OlympicMedalEvent.MedalEventInfo event = new OlympicMedalEvent.MedalEventInfo();
  public final PBBoolField event_valid = PBField.initBool(false);
  public final PBUInt32Field pull_interval_seconds = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventResponse
 * JD-Core Version:    0.7.0.1
 */