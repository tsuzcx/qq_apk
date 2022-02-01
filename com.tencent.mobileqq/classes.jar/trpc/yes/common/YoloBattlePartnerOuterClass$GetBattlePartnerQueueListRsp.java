package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloBattlePartnerOuterClass$GetBattlePartnerQueueListRsp
  extends MessageMicro<GetBattlePartnerQueueListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "ready_player", "partner_infos" }, new Object[] { null, null }, GetBattlePartnerQueueListRsp.class);
  public final PBRepeatMessageField<YoloBattlePartnerOuterClass.PendingPartnerInfo> partner_infos = PBField.initRepeatMessage(YoloBattlePartnerOuterClass.PendingPartnerInfo.class);
  public YoloBattlePartnerOuterClass.PendingPartnerInfo ready_player = new YoloBattlePartnerOuterClass.PendingPartnerInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattlePartnerOuterClass.GetBattlePartnerQueueListRsp
 * JD-Core Version:    0.7.0.1
 */