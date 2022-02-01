package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UgcRight$VerifyUgcRightRsp
  extends MessageMicro<VerifyUgcRightRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vuin", "result" }, new Object[] { "", null }, VerifyUgcRightRsp.class);
  public final PBRepeatMessageField<UgcRight.VerifyResult> result = PBField.initRepeatMessage(UgcRight.VerifyResult.class);
  public final PBStringField vuin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.VerifyUgcRightRsp
 * JD-Core Version:    0.7.0.1
 */