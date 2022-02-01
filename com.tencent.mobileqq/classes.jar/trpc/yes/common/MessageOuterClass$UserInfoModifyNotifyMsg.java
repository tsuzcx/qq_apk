package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class MessageOuterClass$UserInfoModifyNotifyMsg
  extends MessageMicro<UserInfoModifyNotifyMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "qq_user_info" }, new Object[] { null }, UserInfoModifyNotifyMsg.class);
  public UserProxyCmdOuterClass.QQUserInfo qq_user_info = new UserProxyCmdOuterClass.QQUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.UserInfoModifyNotifyMsg
 * JD-Core Version:    0.7.0.1
 */