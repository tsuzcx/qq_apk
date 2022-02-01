package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloRoomOuterClass$YoloRoomSetOptionRsp
  extends MessageMicro<YoloRoomSetOptionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "push_switch", "sound_switch" }, new Object[] { null, null }, YoloRoomSetOptionRsp.class);
  public YoloRoomOuterClass.YoloRoomPushSwitch push_switch = new YoloRoomOuterClass.YoloRoomPushSwitch();
  public YoloRoomOuterClass.YoloRoomSoundSwitch sound_switch = new YoloRoomOuterClass.YoloRoomSoundSwitch();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSetOptionRsp
 * JD-Core Version:    0.7.0.1
 */