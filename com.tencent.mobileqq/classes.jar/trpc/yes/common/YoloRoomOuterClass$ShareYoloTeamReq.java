package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$ShareYoloTeamReq
  extends MessageMicro<ShareYoloTeamReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "room_info", "room_speaking_pos_list", "share_to_room_id" }, new Object[] { null, null, Long.valueOf(0L) }, ShareYoloTeamReq.class);
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
  public final PBUInt64Field share_to_room_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.ShareYoloTeamReq
 * JD-Core Version:    0.7.0.1
 */