package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattlePartnerOuterClass$BattlePartnerConfig
  extends MessageMicro<BattlePartnerConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 40 }, new String[] { "battle_game", "anchor_nick", "queue_switch" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false) }, BattlePartnerConfig.class);
  public final PBStringField anchor_nick = PBField.initString("");
  public final PBEnumField battle_game = PBField.initEnum(0);
  public final PBBoolField queue_switch = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.BattlePartnerConfig
 * JD-Core Version:    0.7.0.1
 */