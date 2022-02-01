package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameList$QuestionClassInfoItem
  extends MessageMicro<QuestionClassInfoItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "question_class", "question_class_name_url", "question_class_bg_url" }, new Object[] { "", "", "" }, QuestionClassInfoItem.class);
  public final PBStringField question_class = PBField.initString("");
  public final PBStringField question_class_bg_url = PBField.initString("");
  public final PBStringField question_class_name_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.QuestionClassInfoItem
 * JD-Core Version:    0.7.0.1
 */