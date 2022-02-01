package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Avatar2DLightAIData$Avatar2DAIDataWrapper
  extends MessageMicro<Avatar2DAIDataWrapper>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "material_id", "background_id", "wrapper_data_map" }, new Object[] { "", "", null }, Avatar2DAIDataWrapper.class);
  public final PBStringField background_id = PBField.initString("");
  public final PBStringField material_id = PBField.initString("");
  public final PBRepeatMessageField<Avatar2DLightAIData.Avatar2DAIDataMap> wrapper_data_map = PBField.initRepeatMessage(Avatar2DLightAIData.Avatar2DAIDataMap.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIDataWrapper
 * JD-Core Version:    0.7.0.1
 */