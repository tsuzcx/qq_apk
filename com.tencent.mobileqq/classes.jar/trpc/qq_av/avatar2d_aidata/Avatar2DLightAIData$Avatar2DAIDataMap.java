package trpc.qq_av.avatar2d_aidata;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Avatar2DLightAIData$Avatar2DAIDataMap
  extends MessageMicro<Avatar2DAIDataMap>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_key", "ai_data" }, new Object[] { "", null }, Avatar2DAIDataMap.class);
  public Avatar2DLightAIData.Avatar2DAIData ai_data = new Avatar2DLightAIData.Avatar2DAIData();
  public final PBStringField str_key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_aidata.Avatar2DLightAIData.Avatar2DAIDataMap
 * JD-Core Version:    0.7.0.1
 */