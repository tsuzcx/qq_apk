package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomKickOutRoomAction
  extends MessageMicro<YoloRoomKickOutRoomAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "user_id", "room_speaking_pos", "speaking_pos_list_version", "reason" }, new Object[] { null, null, Integer.valueOf(0), Long.valueOf(0L) }, YoloRoomKickOutRoomAction.class);
  public final PBUInt64Field reason = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloRoomSpeakingPosInfo room_speaking_pos = new YoloRoomOuterClass.YoloRoomSpeakingPosInfo();
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomKickOutRoomAction
 * JD-Core Version:    0.7.0.1
 */