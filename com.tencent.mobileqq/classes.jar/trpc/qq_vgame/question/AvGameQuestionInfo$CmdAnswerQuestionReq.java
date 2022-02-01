package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameQuestionInfo$CmdAnswerQuestionReq
  extends MessageMicro<CmdAnswerQuestionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField answer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "answer" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, CmdAnswerQuestionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.question.AvGameQuestionInfo.CmdAnswerQuestionReq
 * JD-Core Version:    0.7.0.1
 */