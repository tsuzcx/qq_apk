package trpc.qq_vgame.question;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameQuestionInfo$CmdGetQuestionReq
  extends MessageMicro<CmdGetQuestionReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field req_src = PBField.initUInt32(0);
  public final PBUInt32Field req_type = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "play_game_id", "uin", "req_src", "req_type" }, new Object[] { "", Long.valueOf(0L), localInteger, localInteger }, CmdGetQuestionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.question.AvGameQuestionInfo.CmdGetQuestionReq
 * JD-Core Version:    0.7.0.1
 */