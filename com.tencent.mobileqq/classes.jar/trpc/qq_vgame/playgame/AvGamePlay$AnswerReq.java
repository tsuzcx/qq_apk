package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePlay$AnswerReq
  extends MessageMicro<AnswerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "uin", "play_game_id", "question_index", "answer_index", "scene_type", "answer_duration", "trans_mod", "trans_cost", "answer" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, AnswerReq.class);
  public final PBStringField answer = PBField.initString("");
  public final PBUInt32Field answer_duration = PBField.initUInt32(0);
  public final PBUInt32Field answer_index = PBField.initUInt32(0);
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field question_index = PBField.initUInt32(0);
  public final PBEnumField scene_type = PBField.initEnum(0);
  public final PBUInt32Field trans_cost = PBField.initUInt32(0);
  public final PBUInt32Field trans_mod = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.AnswerReq
 * JD-Core Version:    0.7.0.1
 */