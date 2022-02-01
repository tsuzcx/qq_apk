package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class UserProxyCmdOuterClass$GetUserRouteInfoRsp
  extends MessageMicro<GetUserRouteInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "route_list" }, new Object[] { null }, GetUserRouteInfoRsp.class);
  public CommonOuterClass.OnlineRouteInfoList route_list = new CommonOuterClass.OnlineRouteInfoList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.GetUserRouteInfoRsp
 * JD-Core Version:    0.7.0.1
 */