package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GameDataServerOuterClass$GetAnchorLivingHeroRsp
  extends MessageMicro<GetAnchorLivingHeroRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "hero_info" }, new Object[] { null }, GetAnchorLivingHeroRsp.class);
  public GameDataServerOuterClass.AnchorSmobaHeroInfo hero_info = new GameDataServerOuterClass.AnchorSmobaHeroInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorLivingHeroRsp
 * JD-Core Version:    0.7.0.1
 */