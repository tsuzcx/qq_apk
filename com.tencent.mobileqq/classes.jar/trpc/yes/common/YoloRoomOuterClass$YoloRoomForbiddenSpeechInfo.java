package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechInfo
  extends MessageMicro<YoloRoomForbiddenSpeechInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "end_time", "is_gm_forbidden" }, new Object[] { Integer.valueOf(0), Boolean.valueOf(false) }, YoloRoomForbiddenSpeechInfo.class);
  public final PBUInt32Field end_time = PBField.initUInt32(0);
  public final PBBoolField is_gm_forbidden = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomForbiddenSpeechInfo
 * JD-Core Version:    0.7.0.1
 */