package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$CreateSessionRsp
  extends MessageMicro<CreateSessionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "server_session", "role", "players_max", "request_id" }, new Object[] { "", "", Integer.valueOf(0), "" }, CreateSessionRsp.class);
  public final PBInt32Field players_max = PBField.initInt32(0);
  public final PBStringField request_id = PBField.initString("");
  public final PBStringField role = PBField.initString("");
  public final PBStringField server_session = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.CreateSessionRsp
 * JD-Core Version:    0.7.0.1
 */