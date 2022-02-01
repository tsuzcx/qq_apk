package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Avatar2DLightAIData$AvatarAIFaceFeature
  extends MessageMicro<AvatarAIFaceFeature>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_has_outline = PBField.initBool(false);
  public final PBRepeatMessageField<Avatar2DLightAIData.AIExpression> expression = PBField.initRepeatMessage(Avatar2DLightAIData.AIExpression.class);
  public Avatar2DLightAIData.Rect face_bounds = new Avatar2DLightAIData.Rect();
  public final PBRepeatField<Float> float_face_points83 = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> float_face_points83_vis = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBFloatField float_pitch = PBField.initFloat(0.0F);
  public final PBFloatField float_roll = PBField.initFloat(0.0F);
  public final PBFloatField float_yaw = PBField.initFloat(0.0F);
  public Avatar2DLightAIData.Size image_size = new Avatar2DLightAIData.Size();
  public Avatar2DLightAIData.Rect le_bounds = new Avatar2DLightAIData.Rect();
  public Avatar2DLightAIData.Rect mouth_bounds = new Avatar2DLightAIData.Rect();
  public Avatar2DLightAIData.Rect re_bounds = new Avatar2DLightAIData.Rect();
  public final PBStringField str_emotion = PBField.initString("");
  public final PBStringField str_gender = PBField.initString("");
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 53, 61, 69, 72, 82, 90, 98, 109, 117 }, new String[] { "image_size", "face_bounds", "le_bounds", "re_bounds", "mouth_bounds", "float_pitch", "float_yaw", "float_roll", "bool_has_outline", "str_gender", "expression", "str_emotion", "float_face_points83", "float_face_points83_vis" }, new Object[] { null, null, null, null, null, localFloat, localFloat, localFloat, Boolean.valueOf(false), "", null, "", localFloat, localFloat }, AvatarAIFaceFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAIFaceFeature
 * JD-Core Version:    0.7.0.1
 */