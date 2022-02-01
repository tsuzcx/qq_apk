package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UgcRight$TagList
  extends MessageMicro<TagList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "taglist" }, new Object[] { null }, TagList.class);
  public final PBRepeatMessageField<UgcRight.TagInfo> taglist = PBField.initRepeatMessage(UgcRight.TagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.TagList
 * JD-Core Version:    0.7.0.1
 */