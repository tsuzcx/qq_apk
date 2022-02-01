package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class Avatar2DLightAIData$Point
  extends MessageMicro<Point>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField x = PBField.initFloat(0.0F);
  public final PBFloatField y = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21 }, new String[] { "x", "y" }, new Object[] { localFloat, localFloat }, Point.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Point
 * JD-Core Version:    0.7.0.1
 */