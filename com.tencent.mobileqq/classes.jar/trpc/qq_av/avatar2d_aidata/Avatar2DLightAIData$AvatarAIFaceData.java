package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class Avatar2DLightAIData$AvatarAIFaceData
  extends MessageMicro<AvatarAIFaceData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "face_feature", "detect_image_size" }, new Object[] { null, null }, AvatarAIFaceData.class);
  public Avatar2DLightAIData.Size detect_image_size = new Avatar2DLightAIData.Size();
  public final PBRepeatMessageField<Avatar2DLightAIData.AvatarAIFaceFeature> face_feature = PBField.initRepeatMessage(Avatar2DLightAIData.AvatarAIFaceFeature.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAIFaceData
 * JD-Core Version:    0.7.0.1
 */