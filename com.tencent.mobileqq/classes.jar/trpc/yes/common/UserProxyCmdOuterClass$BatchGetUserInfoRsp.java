package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UserProxyCmdOuterClass$BatchGetUserInfoRsp
  extends MessageMicro<BatchGetUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "ret_user_info_list" }, new Object[] { null }, BatchGetUserInfoRsp.class);
  public final PBRepeatMessageField<UserProxyCmdOuterClass.RetQQUserInfo> ret_user_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass.RetQQUserInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.BatchGetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */