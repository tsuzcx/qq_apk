package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class UserProxyCmdOuterClass$GetUserInfoRsp
  extends MessageMicro<GetUserInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "user_info", "route_list" }, new Object[] { null, null }, GetUserInfoRsp.class);
  public CommonOuterClass.OnlineRouteInfoList route_list = new CommonOuterClass.OnlineRouteInfoList();
  public UserProxyCmdOuterClass.QQUserInfo user_info = new UserProxyCmdOuterClass.QQUserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.GetUserInfoRsp
 * JD-Core Version:    0.7.0.1
 */