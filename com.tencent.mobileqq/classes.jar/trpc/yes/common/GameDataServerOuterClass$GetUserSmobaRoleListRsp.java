package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$GetUserSmobaRoleListRsp
  extends MessageMicro<GetUserSmobaRoleListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "role_list", "openid" }, new Object[] { null, "" }, GetUserSmobaRoleListRsp.class);
  public final PBStringField openid = PBField.initString("");
  public final PBRepeatMessageField<GameDataServerOuterClass.SmobaGameRoleAbsInfo> role_list = PBField.initRepeatMessage(GameDataServerOuterClass.SmobaGameRoleAbsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp
 * JD-Core Version:    0.7.0.1
 */