package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class UserProxyCmdOuterClass$StopGameReq
  extends MessageMicro<StopGameReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_id", "host_user_id" }, new Object[] { "", "" }, StopGameReq.class);
  public final PBStringField host_user_id = PBField.initString("");
  public final PBStringField user_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.StopGameReq
 * JD-Core Version:    0.7.0.1
 */