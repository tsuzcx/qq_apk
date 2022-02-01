package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UgcRight$VerifyUgcRightReq
  extends MessageMicro<VerifyUgcRightReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "vuin", "ugcKeys" }, new Object[] { "", null }, VerifyUgcRightReq.class);
  public final PBRepeatMessageField<UgcRight.UgcDataKey> ugcKeys = PBField.initRepeatMessage(UgcRight.UgcDataKey.class);
  public final PBStringField vuin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.VerifyUgcRightReq
 * JD-Core Version:    0.7.0.1
 */