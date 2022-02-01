package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class UserProxyCmdOuterClass$UpdateUserInfoRsp
  extends MessageMicro<UpdateUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_info" }, new Object[] { null }, UpdateUserInfoRsp.class);
  public UserProxyCmdOuterClass.QQUserInfo user_info = new UserProxyCmdOuterClass.QQUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.UpdateUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */