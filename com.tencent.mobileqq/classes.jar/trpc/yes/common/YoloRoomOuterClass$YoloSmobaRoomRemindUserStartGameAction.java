package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloRoomOuterClass$YoloSmobaRoomRemindUserStartGameAction
  extends MessageMicro<YoloSmobaRoomRemindUserStartGameAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "user_id_list" }, new Object[] { null }, YoloSmobaRoomRemindUserStartGameAction.class);
  public final PBRepeatMessageField<CommonOuterClass.QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass.QQUserId.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomRemindUserStartGameAction
 * JD-Core Version:    0.7.0.1
 */