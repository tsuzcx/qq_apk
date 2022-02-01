package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleObOuterClass$YoloBattleOBEventReq
  extends MessageMicro<YoloBattleOBEventReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "event_type", "route_info" }, new Object[] { Integer.valueOf(0), null }, YoloBattleOBEventReq.class);
  public final PBEnumField event_type = PBField.initEnum(0);
  public YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBEventReq
 * JD-Core Version:    0.7.0.1
 */