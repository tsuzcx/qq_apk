package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$GetSmobaDefaultRoleRsp
  extends MessageMicro<GetSmobaDefaultRoleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "role_info", "openid" }, new Object[] { null, "" }, GetSmobaDefaultRoleRsp.class);
  public final PBStringField openid = PBField.initString("");
  public GameDataServerOuterClass.SmobaGameRoleInfo role_info = new GameDataServerOuterClass.SmobaGameRoleInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp
 * JD-Core Version:    0.7.0.1
 */