package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleObOuterClass$YoloBattleOBNotifyEventRouteInfo
  extends MessageMicro<YoloBattleOBNotifyEventRouteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "route_id" }, new Object[] { Long.valueOf(0L) }, YoloBattleOBNotifyEventRouteInfo.class);
  public final PBUInt64Field route_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo
 * JD-Core Version:    0.7.0.1
 */