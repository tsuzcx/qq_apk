package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloBattleOBRouteInfo
  extends MessageMicro<YoloBattleOBRouteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field battle_ob_expire_time = PBField.initUInt64(0L);
  public final PBInt64Field battle_ob_id = PBField.initInt64(0L);
  public final PBStringField battle_ob_pic_url = PBField.initString("");
  public final PBUInt32Field battle_ob_status = PBField.initUInt32(0);
  public final PBStringField battle_ob_url = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "battle_ob_url", "battle_ob_expire_time", "battle_ob_status", "battle_ob_pic_url", "battle_ob_id" }, new Object[] { "", localLong, Integer.valueOf(0), "", localLong }, YoloBattleOBRouteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloBattleOBRouteInfo
 * JD-Core Version:    0.7.0.1
 */