package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class OlympicMedalEvent$MedalEventRequest
  extends MessageMicro<MedalEventRequest>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "from_aio" }, new Object[] { Boolean.valueOf(false) }, MedalEventRequest.class);
  public final PBBoolField from_aio = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventRequest
 * JD-Core Version:    0.7.0.1
 */