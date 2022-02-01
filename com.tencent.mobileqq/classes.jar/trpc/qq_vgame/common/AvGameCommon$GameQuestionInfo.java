package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$GameQuestionInfo
  extends MessageMicro<GameQuestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "type", "id", "topic", "picture", "questions", "index" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, GameQuestionInfo.class);
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public AvGameCommon.GuessPictureQuestionInfo picture = new AvGameCommon.GuessPictureQuestionInfo();
  public final PBRepeatMessageField<AvGameCommon.CommonQuestionInfo> questions = PBField.initRepeatMessage(AvGameCommon.CommonQuestionInfo.class);
  public AvGameCommon.GuessActionQuestionInfo topic = new AvGameCommon.GuessActionQuestionInfo();
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo
 * JD-Core Version:    0.7.0.1
 */