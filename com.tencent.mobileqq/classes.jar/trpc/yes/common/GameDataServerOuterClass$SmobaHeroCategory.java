package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$SmobaHeroCategory
  extends MessageMicro<SmobaHeroCategory>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "name", "hero_ids" }, new Object[] { "", Integer.valueOf(0) }, SmobaHeroCategory.class);
  public final PBRepeatField<Integer> hero_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaHeroCategory
 * JD-Core Version:    0.7.0.1
 */