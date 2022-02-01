package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloRoomOuterClass$YoloRoomAgreeSpeakingAction
  extends MessageMicro<YoloRoomAgreeSpeakingAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "user_id", "expire_time" }, new Object[] { null, Long.valueOf(0L) }, YoloRoomAgreeSpeakingAction.class);
  public final PBUInt64Field expire_time = PBField.initUInt64(0L);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomAgreeSpeakingAction
 * JD-Core Version:    0.7.0.1
 */