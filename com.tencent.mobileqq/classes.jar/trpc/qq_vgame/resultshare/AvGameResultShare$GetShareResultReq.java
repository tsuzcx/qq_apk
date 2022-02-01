package trpc.qq_vgame.resultshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameResultShare$GetShareResultReq
  extends MessageMicro<GetShareResultReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "key" }, new Object[] { "" }, GetShareResultReq.class);
  public final PBStringField key = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.resultshare.AvGameResultShare.GetShareResultReq
 * JD-Core Version:    0.7.0.1
 */