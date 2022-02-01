package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$CreateSessionReq
  extends MessageMicro<CreateSessionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "client_session", "user_id", "game_id", "host_user_id", "role" }, new Object[] { "", "", "", "", "" }, CreateSessionReq.class);
  public final PBStringField client_session = PBField.initString("");
  public final PBStringField game_id = PBField.initString("");
  public final PBStringField host_user_id = PBField.initString("");
  public final PBStringField role = PBField.initString("");
  public final PBStringField user_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.CreateSessionReq
 * JD-Core Version:    0.7.0.1
 */