package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;

public final class AvGameNotify$NotifyActorGiveOutAnswerS2CReq
  extends MessageMicro<NotifyActorGiveOutAnswerS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "tips", "question_info" }, new Object[] { "", null }, NotifyActorGiveOutAnswerS2CReq.class);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public final PBStringField tips = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyActorGiveOutAnswerS2CReq
 * JD-Core Version:    0.7.0.1
 */