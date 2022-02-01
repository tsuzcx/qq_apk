package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleObOuterClass$YoloBattleStartOBReq
  extends MessageMicro<YoloBattleStartOBReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "device_id", "notify_config", "route_info", "yolo_battle_id" }, new Object[] { "", null, null, Long.valueOf(0L) }, YoloBattleStartOBReq.class);
  public final PBStringField device_id = PBField.initString("");
  public YoloBattleObOuterClass.YoloBattleOBNotifyConfig notify_config = new YoloBattleObOuterClass.YoloBattleOBNotifyConfig();
  public YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo();
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleStartOBReq
 * JD-Core Version:    0.7.0.1
 */