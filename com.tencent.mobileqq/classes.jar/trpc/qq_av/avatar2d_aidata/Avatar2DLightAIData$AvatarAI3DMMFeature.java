package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Avatar2DLightAIData$AvatarAI3DMMFeature
  extends MessageMicro<AvatarAI3DMMFeature>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_kissing = PBField.initBool(false);
  public final PBRepeatField<Float> float_euler = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBRepeatField<Float> float_exp = PBField.initRepeat(PBFloatField.__repeatHelper__);
  public final PBFloatField float_point_scale = PBField.initFloat(0.0F);
  public final PBFloatField float_scale = PBField.initFloat(0.0F);
  public final PBRepeatMessageField<Avatar2DLightAIData.Matrix4> trans_matrix = PBField.initRepeatMessage(Avatar2DLightAIData.Matrix4.class);
  public final PBRepeatMessageField<Avatar2DLightAIData.Matrix4> transform = PBField.initRepeatMessage(Avatar2DLightAIData.Matrix4.class);
  public Avatar2DLightAIData.Point translate = new Avatar2DLightAIData.Point();
  public final PBUInt32Field uint32_trace_id = PBField.initUInt32(0);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 45, 50, 61, 69, 77 }, new String[] { "uint32_trace_id", "bool_is_kissing", "trans_matrix", "transform", "float_euler", "translate", "float_scale", "float_point_scale", "float_exp" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false), null, null, localFloat, null, localFloat, localFloat, localFloat }, AvatarAI3DMMFeature.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.AvatarAI3DMMFeature
 * JD-Core Version:    0.7.0.1
 */