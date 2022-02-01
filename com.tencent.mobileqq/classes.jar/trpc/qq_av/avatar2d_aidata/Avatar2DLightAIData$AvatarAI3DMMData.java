package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Avatar2DLightAIData$AvatarAI3DMMData
  extends MessageMicro<AvatarAI3DMMData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "detect_image_size", "result_expression" }, new Object[] { null, null }, AvatarAI3DMMData.class);
  public Avatar2DLightAIData.Size detect_image_size = new Avatar2DLightAIData.Size();
  public final PBRepeatMessageField<Avatar2DLightAIData.AvatarAI3DMMFeature> result_expression = PBField.initRepeatMessage(Avatar2DLightAIData.AvatarAI3DMMFeature.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAI3DMMData
 * JD-Core Version:    0.7.0.1
 */