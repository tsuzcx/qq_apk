package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$YoloRoomCreateRsp
  extends MessageMicro<YoloRoomCreateRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 50, 58, 66, 74 }, new String[] { "room_info", "room_speaking_pos_list", "speaking_pos_list_version", "room_conf", "rotate_messsage_list", "forbidden_speech_info", "room_user_data", "safe_check_result" }, new Object[] { null, null, Integer.valueOf(0), null, null, null, null, null }, YoloRoomCreateRsp.class);
  public YoloRoomOuterClass.YoloRoomForbiddenSpeechInfo forbidden_speech_info = new YoloRoomOuterClass.YoloRoomForbiddenSpeechInfo();
  public YoloRoomOuterClass.YoloRoomConf room_conf = new YoloRoomOuterClass.YoloRoomConf();
  public YoloRoomOuterClass.YoloRoomInfo room_info = new YoloRoomOuterClass.YoloRoomInfo();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
  public YoloRoomOuterClass.YoloRoomUserData room_user_data = new YoloRoomOuterClass.YoloRoomUserData();
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomRotateMessage> rotate_messsage_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomRotateMessage.class);
  public YoloRoomOuterClass.SafeCheckResult safe_check_result = new YoloRoomOuterClass.SafeCheckResult();
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomCreateRsp
 * JD-Core Version:    0.7.0.1
 */