package trpc.qq_av.avatar2d_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Avatar2DCommon$Avatar2DAIData
  extends MessageMicro<Avatar2DAIData>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_aidata_type", "ai_data_str" }, new Object[] { Integer.valueOf(0), "" }, Avatar2DAIData.class);
  public final PBStringField ai_data_str = PBField.initString("");
  public final PBUInt32Field uint32_aidata_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av.avatar2d_common.Avatar2DCommon.Avatar2DAIData
 * JD-Core Version:    0.7.0.1
 */