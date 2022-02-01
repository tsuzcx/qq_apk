package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$AllYoloRoomInfo
  extends MessageMicro<AllYoloRoomInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "room_info", "speaking_pos_info_list", "online_num" }, new Object[] { null, null, Integer.valueOf(0) }, AllYoloRoomInfo.class);
  public final PBInt32Field online_num = PBField.initInt32(0);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> speaking_pos_info_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.AllYoloRoomInfo
 * JD-Core Version:    0.7.0.1
 */