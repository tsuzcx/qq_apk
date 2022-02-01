package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$UserDefaultRole
  extends MessageMicro<UserDefaultRole>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uid", "openid", "auth_status", "role_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), null }, UserDefaultRole.class);
  public final PBInt32Field auth_status = PBField.initInt32(0);
  public final PBStringField openid = PBField.initString("");
  public GameDataServerOuterClass.SmobaGameRoleInfo role_info = new GameDataServerOuterClass.SmobaGameRoleInfo();
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.UserDefaultRole
 * JD-Core Version:    0.7.0.1
 */