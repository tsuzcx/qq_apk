package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;
import trpc.qq_vgame.common.AvGameCommon.UserAnswerInfo;

public final class AvGameNotify$NotifyAnswerRightS2CReq
  extends MessageMicro<NotifyAnswerRightS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public final PBUInt32Field actor_score = PBField.initUInt32(0);
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  public final PBUInt64Field continue_correct_num = PBField.initUInt64(0L);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public final PBUInt32Field score = PBField.initUInt32(0);
  public AvGameCommon.UserAnswerInfo user_answer_info = new AvGameCommon.UserAnswerInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58 }, new String[] { "actor_info", "question_info", "score", "actor_score", "actor_uin", "continue_correct_num", "user_answer_info" }, new Object[] { null, null, localInteger, localInteger, localLong, localLong, null }, NotifyAnswerRightS2CReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyAnswerRightS2CReq
 * JD-Core Version:    0.7.0.1
 */