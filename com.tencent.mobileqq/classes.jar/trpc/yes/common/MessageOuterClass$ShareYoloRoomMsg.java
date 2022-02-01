package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class MessageOuterClass$ShareYoloRoomMsg
  extends MessageMicro<ShareYoloRoomMsg>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "room_info", "room_speaking_pos_list" }, new Object[] { null, null }, ShareYoloRoomMsg.class);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.MessageOuterClass.ShareYoloRoomMsg
 * JD-Core Version:    0.7.0.1
 */