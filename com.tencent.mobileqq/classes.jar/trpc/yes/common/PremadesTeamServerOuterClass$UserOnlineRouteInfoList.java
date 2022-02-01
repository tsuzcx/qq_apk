package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PremadesTeamServerOuterClass$UserOnlineRouteInfoList
  extends MessageMicro<UserOnlineRouteInfoList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uid", "list" }, new Object[] { Long.valueOf(0L), null }, UserOnlineRouteInfoList.class);
  public CommonOuterClass.OnlineRouteInfoList list = new CommonOuterClass.OnlineRouteInfoList();
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.PremadesTeamServerOuterClass.UserOnlineRouteInfoList
 * JD-Core Version:    0.7.0.1
 */