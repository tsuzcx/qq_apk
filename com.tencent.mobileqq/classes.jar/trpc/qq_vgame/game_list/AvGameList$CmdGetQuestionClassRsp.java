package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameList$CmdGetQuestionClassRsp
  extends MessageMicro<CmdGetQuestionClassRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "res", "question_class_list", "question_class_title_url", "question_class_button_url" }, new Object[] { null, null, "", "" }, CmdGetQuestionClassRsp.class);
  public final PBStringField question_class_button_url = PBField.initString("");
  public final PBRepeatMessageField<AvGameList.QuestionClassInfo> question_class_list = PBField.initRepeatMessage(AvGameList.QuestionClassInfo.class);
  public final PBStringField question_class_title_url = PBField.initString("");
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdGetQuestionClassRsp
 * JD-Core Version:    0.7.0.1
 */