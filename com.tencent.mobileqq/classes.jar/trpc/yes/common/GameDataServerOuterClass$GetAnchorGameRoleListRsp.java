package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GameDataServerOuterClass$GetAnchorGameRoleListRsp
  extends MessageMicro<GetAnchorGameRoleListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "equip_status", "role_list" }, new Object[] { Integer.valueOf(0), null }, GetAnchorGameRoleListRsp.class);
  public final PBInt32Field equip_status = PBField.initInt32(0);
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaGameRoleAbsInfo> role_list = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaGameRoleAbsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetAnchorGameRoleListRsp
 * JD-Core Version:    0.7.0.1
 */