package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomRecoverRsp
  extends MessageMicro<YoloRoomRecoverRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 50, 58, 66 }, new String[] { "room_info", "room_speaking_pos_list", "speaking_pos_list_version", "room_conf", "cur_action_id", "rotate_messsage_list", "forbidden_speech_info", "room_user_data" }, new Object[] { null, null, Integer.valueOf(0), null, Long.valueOf(0L), null, null, null }, YoloRoomRecoverRsp.class);
  public final PBUInt64Field cur_action_id = PBField.initUInt64(0L);
  public YoloRoomOuterClass.YoloRoomForbiddenSpeechInfo forbidden_speech_info = new YoloRoomOuterClass.YoloRoomForbiddenSpeechInfo();
  public YoloRoomOuterClass.YoloRoomConf room_conf = new YoloRoomOuterClass.YoloRoomConf();
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
  public YoloRoomOuterClass.YoloRoomUserData room_user_data = new YoloRoomOuterClass.YoloRoomUserData();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomRotateMessage> rotate_messsage_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomRotateMessage.class);
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverRsp
 * JD-Core Version:    0.7.0.1
 */