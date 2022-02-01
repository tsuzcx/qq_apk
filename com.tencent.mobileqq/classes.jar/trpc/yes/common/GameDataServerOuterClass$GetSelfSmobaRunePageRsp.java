package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GameDataServerOuterClass$GetSelfSmobaRunePageRsp
  extends MessageMicro<GetSelfSmobaRunePageRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rune_pages" }, new Object[] { null }, GetSelfSmobaRunePageRsp.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaRunePage> rune_pages = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaRunePage.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetSelfSmobaRunePageRsp
 * JD-Core Version:    0.7.0.1
 */