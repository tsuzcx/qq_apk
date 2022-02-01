package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaRoomDismissEvent
  extends MessageMicro<YoloSmobaRoomDismissEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "reason", "room_info" }, new Object[] { Integer.valueOf(0), null }, YoloSmobaRoomDismissEvent.class);
  public final PBUInt32Field reason = PBField.initUInt32(0);
  public SmobaDataOuterClass.YoloBattleRoomInfo room_info = new SmobaDataOuterClass.YoloBattleRoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaRoomDismissEvent
 * JD-Core Version:    0.7.0.1
 */