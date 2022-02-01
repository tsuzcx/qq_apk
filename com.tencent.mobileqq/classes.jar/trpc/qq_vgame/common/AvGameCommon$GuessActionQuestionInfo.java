package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameCommon$GuessActionQuestionInfo
  extends MessageMicro<GuessActionQuestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "question", "answer", "reward_type", "extra_reward", "reward_stroke_color" }, new Object[] { "", "", "", "", "" }, GuessActionQuestionInfo.class);
  public final PBStringField answer = PBField.initString("");
  public final PBStringField extra_reward = PBField.initString("");
  public final PBStringField question = PBField.initString("");
  public final PBStringField reward_stroke_color = PBField.initString("");
  public final PBStringField reward_type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GuessActionQuestionInfo
 * JD-Core Version:    0.7.0.1
 */