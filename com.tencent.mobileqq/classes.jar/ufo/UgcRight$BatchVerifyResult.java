package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UgcRight$BatchVerifyResult
  extends MessageMicro<BatchVerifyResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vuin", "authResult" }, new Object[] { "", null }, BatchVerifyResult.class);
  public UgcRight.AuthResult authResult = new UgcRight.AuthResult();
  public final PBStringField vuin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.BatchVerifyResult
 * JD-Core Version:    0.7.0.1
 */