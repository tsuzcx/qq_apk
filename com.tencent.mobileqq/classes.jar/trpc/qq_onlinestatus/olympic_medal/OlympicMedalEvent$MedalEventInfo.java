package trpc.qq_onlinestatus.olympic_medal;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OlympicMedalEvent$MedalEventInfo
  extends MessageMicro<MedalEventInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field end = PBField.initUInt64(0L);
  public final PBUInt32Field event_id = PBField.initUInt32(0);
  public final PBStringField msg = PBField.initString("");
  public final PBUInt64Field start = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "event_id", "start", "end", "msg" }, new Object[] { Integer.valueOf(0), localLong, localLong, "" }, MedalEventInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventInfo
 * JD-Core Version:    0.7.0.1
 */