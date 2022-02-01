package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public final class AvGameNotify$NotifyAnswerRightS2CReq
  extends MessageMicro<NotifyAnswerRightS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "actor_info", "question_info", "score", "actor_score", "actor_uin", "continue_correct_num" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, NotifyAnswerRightS2CReq.class);
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public final PBUInt32Field actor_score = PBField.initUInt32(0);
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  public final PBUInt64Field continue_correct_num = PBField.initUInt64(0L);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public final PBUInt32Field score = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerRightS2CReq
 * JD-Core Version:    0.7.0.1
 */