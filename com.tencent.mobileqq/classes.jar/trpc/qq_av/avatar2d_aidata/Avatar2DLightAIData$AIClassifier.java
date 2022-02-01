package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Avatar2DLightAIData$AIClassifier
  extends MessageMicro<AIClassifier>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_trace_id", "str_classifier" }, new Object[] { Integer.valueOf(0), "" }, AIClassifier.class);
  public final PBRepeatField<String> str_classifier = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field uint32_trace_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIClassifier
 * JD-Core Version:    0.7.0.1
 */