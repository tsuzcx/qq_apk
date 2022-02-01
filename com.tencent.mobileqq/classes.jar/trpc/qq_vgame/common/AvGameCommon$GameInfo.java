package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$GameInfo
  extends MessageMicro<GameInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56 }, new String[] { "type", "game_duration", "game_preptime", "question_duration", "question_interim", "finish_type", "finish_question_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GameInfo.class);
  public final PBUInt32Field finish_question_num = PBField.initUInt32(0);
  public final PBUInt32Field finish_type = PBField.initUInt32(0);
  public final PBUInt32Field game_duration = PBField.initUInt32(0);
  public final PBUInt32Field game_preptime = PBField.initUInt32(0);
  public final PBUInt32Field question_duration = PBField.initUInt32(0);
  public final PBUInt32Field question_interim = PBField.initUInt32(0);
  public final PBEnumField type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GameInfo
 * JD-Core Version:    0.7.0.1
 */