package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloRoomUpdateGameRouteInfoAction
  extends MessageMicro<YoloRoomUpdateGameRouteInfoAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_info", "status_change_text" }, new Object[] { null, "" }, YoloRoomUpdateGameRouteInfoAction.class);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBStringField status_change_text = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomUpdateGameRouteInfoAction
 * JD-Core Version:    0.7.0.1
 */