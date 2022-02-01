package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$SmobaConfigItem
  extends MessageMicro<SmobaConfigItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "key", "value" }, new Object[] { "", Integer.valueOf(0) }, SmobaConfigItem.class);
  public final PBStringField key = PBField.initString("");
  public final PBRepeatField<Integer> value = PBField.initRepeat(PBInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaConfigItem
 * JD-Core Version:    0.7.0.1
 */