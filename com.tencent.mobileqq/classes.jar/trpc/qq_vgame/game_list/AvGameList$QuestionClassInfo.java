package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameList$QuestionClassInfo
  extends MessageMicro<QuestionClassInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "game_type", "question_class_list" }, new Object[] { Integer.valueOf(0), null }, QuestionClassInfo.class);
  public final PBUInt32Field game_type = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameList.QuestionClassInfoItem> question_class_list = PBField.initRepeatMessage(AvGameList.QuestionClassInfoItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.QuestionClassInfo
 * JD-Core Version:    0.7.0.1
 */