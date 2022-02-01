package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GameDataServerOuterClass$GetSelfSmobaHeroEquipRsp
  extends MessageMicro<GetSelfSmobaHeroEquipRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "equip_configs" }, new Object[] { null }, GetSelfSmobaHeroEquipRsp.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaEquipConfig> equip_configs = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaEquipConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetSelfSmobaHeroEquipRsp
 * JD-Core Version:    0.7.0.1
 */