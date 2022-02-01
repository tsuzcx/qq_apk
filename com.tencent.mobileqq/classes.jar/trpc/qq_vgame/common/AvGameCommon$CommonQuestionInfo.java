package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$CommonQuestionInfo
  extends MessageMicro<CommonQuestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "item", "feedbacks", "tips", "size" }, new Object[] { null, null, null, Integer.valueOf(0) }, CommonQuestionInfo.class);
  public final PBRepeatMessageField<AvGameCommon.QuestionFeedbackInfo> feedbacks = PBField.initRepeatMessage(AvGameCommon.QuestionFeedbackInfo.class);
  public AvGameCommon.QuestionItemInfo item = new AvGameCommon.QuestionItemInfo();
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameCommon.QuestionTipsInfo> tips = PBField.initRepeatMessage(AvGameCommon.QuestionTipsInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.CommonQuestionInfo
 * JD-Core Version:    0.7.0.1
 */