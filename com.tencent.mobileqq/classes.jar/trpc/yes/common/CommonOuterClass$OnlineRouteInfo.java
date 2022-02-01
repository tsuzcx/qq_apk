package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class CommonOuterClass$OnlineRouteInfo
  extends MessageMicro<OnlineRouteInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBInt32Field route_status = PBField.initInt32(0);
  public final PBUInt32Field update_time = PBField.initUInt32(0);
  public CommonOuterClass.RoomRouteInfo yolo_room_route_info = new CommonOuterClass.RoomRouteInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "route_status", "expire_time", "update_time", "yolo_room_route_info" }, new Object[] { localInteger, localInteger, localInteger, null }, OnlineRouteInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.CommonOuterClass.OnlineRouteInfo
 * JD-Core Version:    0.7.0.1
 */