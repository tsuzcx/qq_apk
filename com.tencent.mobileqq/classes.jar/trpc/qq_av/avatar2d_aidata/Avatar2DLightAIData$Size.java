package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;

public final class Avatar2DLightAIData$Size
  extends MessageMicro<Size>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBFloatField height = PBField.initFloat(0.0F);
  public final PBFloatField width = PBField.initFloat(0.0F);
  
  static
  {
    Float localFloat = Float.valueOf(0.0F);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 13, 21 }, new String[] { "width", "height" }, new Object[] { localFloat, localFloat }, Size.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Size
 * JD-Core Version:    0.7.0.1
 */