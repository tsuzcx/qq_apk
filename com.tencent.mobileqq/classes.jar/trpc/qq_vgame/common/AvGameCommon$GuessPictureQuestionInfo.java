package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$GuessPictureQuestionInfo
  extends MessageMicro<GuessPictureQuestionInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "url", "answer", "tip_list", "size" }, new Object[] { "", "", null, Integer.valueOf(0) }, GuessPictureQuestionInfo.class);
  public final PBStringField answer = PBField.initString("");
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameCommon.GuessPictureTipsInfo> tip_list = PBField.initRepeatMessage(AvGameCommon.GuessPictureTipsInfo.class);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GuessPictureQuestionInfo
 * JD-Core Version:    0.7.0.1
 */