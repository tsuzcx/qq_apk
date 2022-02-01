package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GameDataServerOuterClass$AnchorSmobaHeroInfo
  extends MessageMicro<AnchorSmobaHeroInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public GameDataServerOuterClass.SmobaEquipConfig equip_config = new GameDataServerOuterClass.SmobaEquipConfig();
  public final PBUInt32Field fight_power = PBField.initUInt32(0);
  public final PBUInt32Field hero_id = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public GameDataServerOuterClass.SmobaRunePage rune_page = new GameDataServerOuterClass.SmobaRunePage();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50 }, new String[] { "hero_id", "name", "icon", "fight_power", "equip_config", "rune_page" }, new Object[] { localInteger, "", "", localInteger, null, null }, AnchorSmobaHeroInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.AnchorSmobaHeroInfo
 * JD-Core Version:    0.7.0.1
 */