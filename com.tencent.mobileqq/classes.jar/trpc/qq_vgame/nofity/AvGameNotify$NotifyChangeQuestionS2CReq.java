package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;

public final class AvGameNotify$NotifyChangeQuestionS2CReq
  extends MessageMicro<NotifyChangeQuestionS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "question_info", "switcher_uin" }, new Object[] { null, Long.valueOf(0L) }, NotifyChangeQuestionS2CReq.class);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public final PBUInt64Field switcher_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyChangeQuestionS2CReq
 * JD-Core Version:    0.7.0.1
 */