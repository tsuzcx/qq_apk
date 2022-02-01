package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$SwitchRoleReq
  extends MessageMicro<SwitchRoleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "user_id", "host_user_id", "game_id", "role", "role_index" }, new Object[] { "", "", "", "", Integer.valueOf(0) }, SwitchRoleReq.class);
  public final PBStringField game_id = PBField.initString("");
  public final PBStringField host_user_id = PBField.initString("");
  public final PBStringField role = PBField.initString("");
  public final PBInt32Field role_index = PBField.initInt32(0);
  public final PBStringField user_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.SwitchRoleReq
 * JD-Core Version:    0.7.0.1
 */