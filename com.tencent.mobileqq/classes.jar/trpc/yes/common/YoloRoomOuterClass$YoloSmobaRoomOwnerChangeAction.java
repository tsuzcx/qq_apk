package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$YoloSmobaRoomOwnerChangeAction
  extends MessageMicro<YoloSmobaRoomOwnerChangeAction>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public CommonOuterClass.QQUserId from_user_id = new CommonOuterClass.QQUserId();
  public final PBInt32Field reason = PBField.initInt32(0);
  public final PBRepeatMessageField<YoloRoomOuterClass.YoloRoomSpeakingPosInfo> room_speaking_pos_list = PBField.initRepeatMessage(YoloRoomOuterClass.YoloRoomSpeakingPosInfo.class);
  public final PBInt32Field speaking_pos_list_version = PBField.initInt32(0);
  public CommonOuterClass.QQUserId to_user_id = new CommonOuterClass.QQUserId();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40 }, new String[] { "from_user_id", "to_user_id", "room_speaking_pos_list", "speaking_pos_list_version", "reason" }, new Object[] { null, null, null, localInteger, localInteger }, YoloSmobaRoomOwnerChangeAction.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomOwnerChangeAction
 * JD-Core Version:    0.7.0.1
 */