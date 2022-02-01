package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloRoomOuterClass$YoloRoomSoundSwitch
  extends MessageMicro<YoloRoomSoundSwitch>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "is_off_listen_sound" }, new Object[] { Boolean.valueOf(false) }, YoloRoomSoundSwitch.class);
  public final PBBoolField is_off_listen_sound = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomSoundSwitch
 * JD-Core Version:    0.7.0.1
 */