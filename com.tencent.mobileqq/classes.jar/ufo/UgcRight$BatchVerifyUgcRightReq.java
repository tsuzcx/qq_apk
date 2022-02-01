package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UgcRight$BatchVerifyUgcRightReq
  extends MessageMicro<BatchVerifyUgcRightReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vuins", "ugc_key" }, new Object[] { "", null }, BatchVerifyUgcRightReq.class);
  public UgcRight.UgcDataKey ugc_key = new UgcRight.UgcDataKey();
  public final PBRepeatField<String> vuins = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.BatchVerifyUgcRightReq
 * JD-Core Version:    0.7.0.1
 */