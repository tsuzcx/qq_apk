package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleOuterClass$YoloBattleNotifyConfig
  extends MessageMicro<YoloBattleNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField notify_control = PBField.initEnum(0);
  public final PBRepeatField<Integer> notify_event = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBEnumField notify_type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "notify_control", "notify_type", "notify_event" }, new Object[] { localInteger, localInteger, localInteger }, YoloBattleNotifyConfig.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleNotifyConfig
 * JD-Core Version:    0.7.0.1
 */