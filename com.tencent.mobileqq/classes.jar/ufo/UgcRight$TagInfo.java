package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UgcRight$TagInfo
  extends MessageMicro<TagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "tagID", "tagName", "uinList", "updateTime" }, new Object[] { "", "", "", Integer.valueOf(0) }, TagInfo.class);
  public final PBStringField tagID = PBField.initString("");
  public final PBStringField tagName = PBField.initString("");
  public final PBRepeatField<String> uinList = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field updateTime = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.TagInfo
 * JD-Core Version:    0.7.0.1
 */