package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameQuestionInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameQuestionInfo$CmdGetQuestionRsp
  extends MessageMicro<CmdGetQuestionRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "res", "question_info", "seq" }, new Object[] { null, null, Long.valueOf(0L) }, CmdGetQuestionRsp.class);
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionRsp
 * JD-Core Version:    0.7.0.1
 */