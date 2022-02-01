package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class Avatar2DLightAIData$Matrix4
  extends MessageMicro<Matrix4>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField m1 = PBField.initFloat(0.0F);
  public final PBFloatField m2 = PBField.initFloat(0.0F);
  public final PBFloatField m3 = PBField.initFloat(0.0F);
  public final PBFloatField m4 = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21, 29, 37 }, new String[] { "m1", "m2", "m3", "m4" }, new Object[] { localFloat, localFloat, localFloat, localFloat }, Matrix4.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Matrix4
 * JD-Core Version:    0.7.0.1
 */