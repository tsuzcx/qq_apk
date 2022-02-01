package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$QuestionItemInfo
  extends MessageMicro<QuestionItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 120 }, new String[] { "question_content", "question_duration", "answer_content", "answer_duration", "question_md5", "answer_md5", "reward_type", "extra_reward", "reward_stroke_color", "question_url", "answer_option", "answer_index", "business_flag", "business_ads", "prize_id" }, new Object[] { "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", "", "", Integer.valueOf(0), Boolean.valueOf(false), "", Integer.valueOf(0) }, QuestionItemInfo.class);
  public final PBStringField answer_content = PBField.initString("");
  public final PBUInt32Field answer_duration = PBField.initUInt32(0);
  public final PBUInt32Field answer_index = PBField.initUInt32(0);
  public final PBStringField answer_md5 = PBField.initString("");
  public final PBRepeatField<String> answer_option = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField business_ads = PBField.initString("");
  public final PBBoolField business_flag = PBField.initBool(false);
  public final PBStringField extra_reward = PBField.initString("");
  public final PBUInt32Field prize_id = PBField.initUInt32(0);
  public final PBStringField question_content = PBField.initString("");
  public final PBUInt32Field question_duration = PBField.initUInt32(0);
  public final PBStringField question_md5 = PBField.initString("");
  public final PBStringField question_url = PBField.initString("");
  public final PBStringField reward_stroke_color = PBField.initString("");
  public final PBStringField reward_type = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.QuestionItemInfo
 * JD-Core Version:    0.7.0.1
 */