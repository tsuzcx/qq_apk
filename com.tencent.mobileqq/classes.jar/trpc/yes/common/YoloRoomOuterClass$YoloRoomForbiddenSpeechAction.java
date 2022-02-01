package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechAction
  extends MessageMicro<YoloRoomForbiddenSpeechAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "user_id", "end_time", "is_gm_forbidden" }, new Object[] { null, Integer.valueOf(0), Boolean.valueOf(false) }, YoloRoomForbiddenSpeechAction.class);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBoolField is_gm_forbidden = PBField.initBool(false);
  public CommonOuterClass.QQUserId user_id = new CommonOuterClass.QQUserId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomForbiddenSpeechAction
 * JD-Core Version:    0.7.0.1
 */