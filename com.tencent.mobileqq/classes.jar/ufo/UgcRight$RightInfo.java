package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class UgcRight$RightInfo
  extends MessageMicro<RightInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "rightFlag", "tagList", "uinList" }, new Object[] { Long.valueOf(0L), null, "" }, RightInfo.class);
  public final PBUInt64Field rightFlag = PBField.initUInt64(0L);
  public final PBRepeatMessageField<UgcRight.TagInfo> tagList = PBField.initRepeatMessage(UgcRight.TagInfo.class);
  public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.RightInfo
 * JD-Core Version:    0.7.0.1
 */