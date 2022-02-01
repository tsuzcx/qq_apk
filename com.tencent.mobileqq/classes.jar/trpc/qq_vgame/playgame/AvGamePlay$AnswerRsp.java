package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGamePlay$AnswerRsp
  extends MessageMicro<AnswerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field answer_result = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBStringField right_answer = PBField.initString("");
  public final PBUInt32Field score = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "res", "answer_result", "score", "right_answer" }, new Object[] { null, localInteger, localInteger, "" }, AnswerRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.AnswerRsp
 * JD-Core Version:    0.7.0.1
 */