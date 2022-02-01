package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class UgcRight$SetUgcRightReq
  extends MessageMicro<SetUgcRightReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ugcKey", "rightInfo" }, new Object[] { null, null }, SetUgcRightReq.class);
  public UgcRight.RightInfo rightInfo = new UgcRight.RightInfo();
  public UgcRight.UgcDataKey ugcKey = new UgcRight.UgcDataKey();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.SetUgcRightReq
 * JD-Core Version:    0.7.0.1
 */