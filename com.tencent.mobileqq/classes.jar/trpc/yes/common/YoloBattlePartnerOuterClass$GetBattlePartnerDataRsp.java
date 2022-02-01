package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattlePartnerOuterClass$GetBattlePartnerDataRsp
  extends MessageMicro<GetBattlePartnerDataRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField join_limit = PBField.initString("");
  public final PBBoolField myself_is_ready = PBField.initBool(false);
  public final PBInt32Field need_wait_time = PBField.initInt32(0);
  public YoloBattlePartnerOuterClass.BattlePartnerConfig partner_config = new YoloBattlePartnerOuterClass.BattlePartnerConfig();
  public final PBStringField pay_jump_text = PBField.initString("");
  public YoloBattlePartnerOuterClass.PendingPartnerInfo pending_info = new YoloBattlePartnerOuterClass.PendingPartnerInfo();
  public final PBInt32Field queue_size = PBField.initInt32(0);
  public final PBBoolField queue_switch = PBField.initBool(false);
  public final PBRepeatField<String> queue_text = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBInt32Field rank = PBField.initInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58, 66, 72, 80 }, new String[] { "queue_switch", "partner_config", "queue_size", "queue_text", "pay_jump_text", "rank", "join_limit", "pending_info", "myself_is_ready", "need_wait_time" }, new Object[] { localBoolean, null, localInteger, "", "", localInteger, "", null, localBoolean, localInteger }, GetBattlePartnerDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.GetBattlePartnerDataRsp
 * JD-Core Version:    0.7.0.1
 */