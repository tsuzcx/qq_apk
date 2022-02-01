package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$GameInfo
  extends MessageMicro<GameInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field answer_duration = PBField.initUInt32(0);
  public final PBUInt32Field finish_question_num = PBField.initUInt32(0);
  public final PBUInt32Field finish_type = PBField.initUInt32(0);
  public final PBUInt32Field game_duration = PBField.initUInt32(0);
  public final PBUInt32Field game_preptime = PBField.initUInt32(0);
  public final PBRepeatField<Integer> pk_available_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Integer> pk_available_rounds = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field question_duration = PBField.initUInt32(0);
  public final PBUInt32Field question_interim = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80 }, new String[] { "type", "game_duration", "game_preptime", "question_duration", "question_interim", "finish_type", "finish_question_num", "answer_duration", "pk_available_rounds", "pk_available_ids" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, GameInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GameInfo
 * JD-Core Version:    0.7.0.1
 */