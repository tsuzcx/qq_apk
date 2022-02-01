package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UgcRight$BatchVerifyUgcRightRsp
  extends MessageMicro<BatchVerifyUgcRightRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "results" }, new Object[] { null }, BatchVerifyUgcRightRsp.class);
  public final PBRepeatMessageField<UgcRight.BatchVerifyResult> results = PBField.initRepeatMessage(UgcRight.BatchVerifyResult.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.BatchVerifyUgcRightRsp
 * JD-Core Version:    0.7.0.1
 */