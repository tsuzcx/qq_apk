package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleNotifyEvent
  extends MessageMicro<YoloMiniGameBattleNotifyEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig config = new YoloBattleMiniGameOuterClass.YoloMiniGameBattleConfig();
  public final PBUInt32Field event_time = PBField.initUInt32(0);
  public final PBEnumField event_type = PBField.initEnum(0);
  public final PBStringField extra_data = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 162 }, new String[] { "event_type", "event_time", "config", "extra_data" }, new Object[] { localInteger, localInteger, null, "" }, YoloMiniGameBattleNotifyEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameBattleNotifyEvent
 * JD-Core Version:    0.7.0.1
 */