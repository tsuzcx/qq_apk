package trpc.qq_av.avatar2d_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Avatar2DCommon$Avatar2DAIDataInfo
  extends MessageMicro<Avatar2DAIDataInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<Avatar2DCommon.Avatar2DAIData> avatar2d_ai_data_list = PBField.initRepeatMessage(Avatar2DCommon.Avatar2DAIData.class);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBStringField material_id = PBField.initString("");
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "material_id", "width", "height", "avatar2d_ai_data_list" }, new Object[] { "", localInteger, localInteger, null }, Avatar2DAIDataInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_common.Avatar2DCommon.Avatar2DAIDataInfo
 * JD-Core Version:    0.7.0.1
 */