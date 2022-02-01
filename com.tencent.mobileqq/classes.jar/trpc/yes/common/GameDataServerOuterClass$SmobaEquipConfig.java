package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$SmobaEquipConfig
  extends MessageMicro<SmobaEquipConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "name", "equips", "equip_idx", "equip_str" }, new Object[] { "", null, Integer.valueOf(0), "" }, SmobaEquipConfig.class);
  public final PBUInt32Field equip_idx = PBField.initUInt32(0);
  public final PBStringField equip_str = PBField.initString("");
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaEquip> equips = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaEquip.class);
  public final PBStringField name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.SmobaEquipConfig
 * JD-Core Version:    0.7.0.1
 */