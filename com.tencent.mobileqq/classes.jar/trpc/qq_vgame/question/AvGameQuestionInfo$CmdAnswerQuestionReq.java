package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameQuestionInfo$CmdAnswerQuestionReq
  extends MessageMicro<CmdAnswerQuestionReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uin", "play_game_id", "answer", "trans_mod", "trans_cost" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0) }, CmdAnswerQuestionReq.class);
  public final PBStringField answer = PBField.initString("");
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field trans_cost = PBField.initUInt32(0);
  public final PBUInt32Field trans_mod = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionReq
 * JD-Core Version:    0.7.0.1
 */