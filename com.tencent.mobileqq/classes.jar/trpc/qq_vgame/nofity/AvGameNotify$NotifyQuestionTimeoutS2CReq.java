package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;

public final class AvGameNotify$NotifyQuestionTimeoutS2CReq
  extends MessageMicro<NotifyQuestionTimeoutS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "question_info" }, new Object[] { null }, NotifyQuestionTimeoutS2CReq.class);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyQuestionTimeoutS2CReq
 * JD-Core Version:    0.7.0.1
 */