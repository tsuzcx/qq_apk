package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class CommonOuterClass$OnlineRouteInfoList
  extends MessageMicro<OnlineRouteInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "route_list" }, new Object[] { null }, OnlineRouteInfoList.class);
  public final PBRepeatMessageField<CommonOuterClass.OnlineRouteInfo> route_list = PBField.initRepeatMessage(CommonOuterClass.OnlineRouteInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.CommonOuterClass.OnlineRouteInfoList
 * JD-Core Version:    0.7.0.1
 */