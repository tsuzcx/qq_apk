package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomInvitedSpeakingAction
  extends MessageMicro<YoloRoomInvitedSpeakingAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "invite_user_id", "invited_user_id", "expire_time" }, new Object[] { null, null, Long.valueOf(0L) }, YoloRoomInvitedSpeakingAction.class);
  public final PBUInt64Field expire_time = PBField.initUInt64(0L);
  public CommonOuterClass.QQUserId invite_user_id = new CommonOuterClass.QQUserId();
  public CommonOuterClass.QQUserId invited_user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomInvitedSpeakingAction
 * JD-Core Version:    0.7.0.1
 */