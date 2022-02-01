package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleObOuterClass$YoloBattleOBStoreData
  extends MessageMicro<YoloBattleOBStoreData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public YoloBattleOuterClass.YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public YoloBattleObOuterClass.YoloBattleOBNotifyConfig notify_config = new YoloBattleObOuterClass.YoloBattleOBNotifyConfig();
  public final PBInt64Field ob_id = PBField.initInt64(0L);
  public final PBUInt64Field ob_start_time = PBField.initUInt64(0L);
  public final PBStringField ob_url = PBField.initString("");
  public YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo route_info = new YoloBattleObOuterClass.YoloBattleOBNotifyEventRouteInfo();
  public final PBEnumField status = PBField.initEnum(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58 }, new String[] { "notify_config", "route_info", "ob_id", "status", "ob_start_time", "battle_base_info", "ob_url" }, new Object[] { null, null, localLong, Integer.valueOf(0), localLong, null, "" }, YoloBattleOBStoreData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBStoreData
 * JD-Core Version:    0.7.0.1
 */