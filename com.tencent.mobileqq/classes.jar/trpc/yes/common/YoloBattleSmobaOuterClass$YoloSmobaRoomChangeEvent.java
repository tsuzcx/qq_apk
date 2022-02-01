package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaRoomChangeEvent
  extends MessageMicro<YoloSmobaRoomChangeEvent>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField change_type = PBField.initEnum(0);
  public final PBInt32Field is_kickout = PBField.initInt32(0);
  public SmobaDataOuterClass.YoloBattleRoomInfo room_info = new SmobaDataOuterClass.YoloBattleRoomInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "change_type", "is_kickout", "room_info" }, new Object[] { localInteger, localInteger, null }, YoloSmobaRoomChangeEvent.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaRoomChangeEvent
 * JD-Core Version:    0.7.0.1
 */