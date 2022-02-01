package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattlePartnerOuterClass$AnchorSwitchReq
  extends MessageMicro<AnchorSwitchReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "queue_switch", "partner_config" }, new Object[] { Boolean.valueOf(false), null }, AnchorSwitchReq.class);
  public YoloBattlePartnerOuterClass.BattlePartnerConfig partner_config = new YoloBattlePartnerOuterClass.BattlePartnerConfig();
  public final PBBoolField queue_switch = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.AnchorSwitchReq
 * JD-Core Version:    0.7.0.1
 */