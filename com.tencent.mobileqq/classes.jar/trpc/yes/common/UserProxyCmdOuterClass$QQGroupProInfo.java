package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserProxyCmdOuterClass$QQGroupProInfo
  extends MessageMicro<QQGroupProInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "joined_guild_info_list", "group_pro_user_info" }, new Object[] { null, null }, QQGroupProInfo.class);
  public UserProxyCmdOuterClass.QQGroupProUserInfo group_pro_user_info = new UserProxyCmdOuterClass.QQGroupProUserInfo();
  public final PBRepeatMessageField<UserProxyCmdOuterClass.JoinedGuildInfo> joined_guild_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass.JoinedGuildInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.QQGroupProInfo
 * JD-Core Version:    0.7.0.1
 */