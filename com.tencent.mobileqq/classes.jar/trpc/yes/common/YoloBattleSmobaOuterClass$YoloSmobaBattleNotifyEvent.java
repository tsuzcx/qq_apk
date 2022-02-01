package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleNotifyEvent
  extends MessageMicro<YoloSmobaBattleNotifyEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field event_time = PBField.initUInt32(0);
  public final PBEnumField event_type = PBField.initEnum(0);
  public YoloBattleSmobaOuterClass.YoloOneSmobaBattleEvent one_event = new YoloBattleSmobaOuterClass.YoloOneSmobaBattleEvent();
  public YoloBattleSmobaOuterClass.YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass.YoloSmobaBattleConfig();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "event_type", "event_time", "one_event", "smoba_config" }, new Object[] { localInteger, localInteger, null, null }, YoloSmobaBattleNotifyEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleNotifyEvent
 * JD-Core Version:    0.7.0.1
 */