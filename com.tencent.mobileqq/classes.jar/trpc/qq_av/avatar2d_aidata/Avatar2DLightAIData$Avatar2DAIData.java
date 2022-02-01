package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Avatar2DLightAIData$Avatar2DAIData
  extends MessageMicro<Avatar2DAIData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "str_key", "keypoints", "classifiers", "ai_3dmm_data", "ai_face_data" }, new Object[] { "", null, null, null, null }, Avatar2DAIData.class);
  public Avatar2DLightAIData.AvatarAI3DMMData ai_3dmm_data = new Avatar2DLightAIData.AvatarAI3DMMData();
  public Avatar2DLightAIData.AvatarAIFaceData ai_face_data = new Avatar2DLightAIData.AvatarAIFaceData();
  public final PBRepeatMessageField<Avatar2DLightAIData.AIClassifier> classifiers = PBField.initRepeatMessage(Avatar2DLightAIData.AIClassifier.class);
  public final PBRepeatMessageField<Avatar2DLightAIData.AIKeyPoint> keypoints = PBField.initRepeatMessage(Avatar2DLightAIData.AIKeyPoint.class);
  public final PBStringField str_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIData
 * JD-Core Version:    0.7.0.1
 */