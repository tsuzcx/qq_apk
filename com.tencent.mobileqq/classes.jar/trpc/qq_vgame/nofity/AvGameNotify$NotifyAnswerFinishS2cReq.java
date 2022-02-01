package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.UserAnswerInfo;

public final class AvGameNotify$NotifyAnswerFinishS2cReq
  extends MessageMicro<NotifyAnswerFinishS2cReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "user_answer_info", "next_question_info", "score" }, new Object[] { null, null, Integer.valueOf(0) }, NotifyAnswerFinishS2cReq.class);
  public AvGameCommon.GameQuestionInfo next_question_info = new AvGameCommon.GameQuestionInfo();
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameCommon.UserAnswerInfo> user_answer_info = PBField.initRepeatMessage(AvGameCommon.UserAnswerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerFinishS2cReq
 * JD-Core Version:    0.7.0.1
 */