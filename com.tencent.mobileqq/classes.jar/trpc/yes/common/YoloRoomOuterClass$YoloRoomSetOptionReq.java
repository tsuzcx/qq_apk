package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomSetOptionReq
  extends MessageMicro<YoloRoomSetOptionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "room_id", "push_switch", "sound_switch" }, new Object[] { Long.valueOf(0L), null, null }, YoloRoomSetOptionReq.class);
  public YoloRoomOuterClass.YoloRoomPushSwitch push_switch = new YoloRoomOuterClass.YoloRoomPushSwitch();
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloRoomSoundSwitch sound_switch = new YoloRoomOuterClass.YoloRoomSoundSwitch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSetOptionReq
 * JD-Core Version:    0.7.0.1
 */