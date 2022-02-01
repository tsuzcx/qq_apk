package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$QuestionFeedbackInfo
  extends MessageMicro<QuestionFeedbackInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "content", "duration", "content_md5" }, new Object[] { "", Integer.valueOf(0), "" }, QuestionFeedbackInfo.class);
  public final PBStringField content = PBField.initString("");
  public final PBStringField content_md5 = PBField.initString("");
  public final PBUInt32Field duration = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.QuestionFeedbackInfo
 * JD-Core Version:    0.7.0.1
 */