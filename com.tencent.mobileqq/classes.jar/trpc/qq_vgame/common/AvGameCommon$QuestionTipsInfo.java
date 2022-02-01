package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$QuestionTipsInfo
  extends MessageMicro<QuestionTipsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "show_delay_ts", "tips" }, new Object[] { Integer.valueOf(0), "" }, QuestionTipsInfo.class);
  public final PBUInt32Field show_delay_ts = PBField.initUInt32(0);
  public final PBStringField tips = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.QuestionTipsInfo
 * JD-Core Version:    0.7.0.1
 */