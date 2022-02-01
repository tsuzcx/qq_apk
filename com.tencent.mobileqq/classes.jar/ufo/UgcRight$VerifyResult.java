package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class UgcRight$VerifyResult
  extends MessageMicro<VerifyResult>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ugcKey", "authResult" }, new Object[] { null, null }, VerifyResult.class);
  public UgcRight.AuthResult authResult = new UgcRight.AuthResult();
  public UgcRight.UgcDataKey ugcKey = new UgcRight.UgcDataKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.VerifyResult
 * JD-Core Version:    0.7.0.1
 */