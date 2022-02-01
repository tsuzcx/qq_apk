package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Avatar2DLightAIData$AIKeyPoint
  extends MessageMicro<AIKeyPoint>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21 }, new String[] { "uint32_trace_id", "float_keypoint" }, new Object[] { Integer.valueOf(0), Float.valueOf(0.0F) }, AIKeyPoint.class);
  public final PBRepeatField<Float> float_keypoint = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBUInt32Field uint32_trace_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AIKeyPoint
 * JD-Core Version:    0.7.0.1
 */