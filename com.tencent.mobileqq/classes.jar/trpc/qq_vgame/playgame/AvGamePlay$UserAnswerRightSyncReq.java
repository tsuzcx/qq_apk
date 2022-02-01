package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;

public final class AvGamePlay$UserAnswerRightSyncReq
  extends MessageMicro<UserAnswerRightSyncReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uin", "play_game_id", "cur_question_info", "score" }, new Object[] { Long.valueOf(0L), "", null, Integer.valueOf(0) }, UserAnswerRightSyncReq.class);
  public AvGameCommon.GameQuestionInfo cur_question_info = new AvGameCommon.GameQuestionInfo();
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.UserAnswerRightSyncReq
 * JD-Core Version:    0.7.0.1
 */