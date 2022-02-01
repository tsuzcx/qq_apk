package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloRoomOuterClass$YoloRoomForbiddenSpeechConf
  extends MessageMicro<YoloRoomForbiddenSpeechConf>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "second", "desc" }, new Object[] { Integer.valueOf(0), "" }, YoloRoomForbiddenSpeechConf.class);
  public final PBStringField desc = PBField.initString("");
  public final PBInt32Field second = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloRoomForbiddenSpeechConf
 * JD-Core Version:    0.7.0.1
 */