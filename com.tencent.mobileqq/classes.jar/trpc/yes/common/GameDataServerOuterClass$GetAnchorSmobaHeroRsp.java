package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GameDataServerOuterClass$GetAnchorSmobaHeroRsp
  extends MessageMicro<GetAnchorSmobaHeroRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "hero_info", "category" }, new Object[] { null, null }, GetAnchorSmobaHeroRsp.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaHeroCategory> category = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaHeroCategory.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.AnchorSmobaHeroInfo> hero_info = PBField.initRepeatMessage(GameDataServerOuterClass.AnchorSmobaHeroInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorSmobaHeroRsp
 * JD-Core Version:    0.7.0.1
 */