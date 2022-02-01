package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$SmobaSkill
  extends MessageMicro<SmobaSkill>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "name", "desc" }, new Object[] { "", "" }, SmobaSkill.class);
  public final PBStringField desc = PBField.initString("");
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaSkill
 * JD-Core Version:    0.7.0.1
 */