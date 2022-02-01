package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Avatar2DLightAIData$AIExpression
  extends MessageMicro<AIExpression>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_key", "bool_value" }, new Object[] { "", Boolean.valueOf(false) }, AIExpression.class);
  public final PBBoolField bool_value = PBField.initBool(false);
  public final PBStringField str_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIExpression
 * JD-Core Version:    0.7.0.1
 */