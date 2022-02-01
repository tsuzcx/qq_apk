package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class UgcRight$GetTagListRsp
  extends MessageMicro<GetTagListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "taglist" }, new Object[] { null }, GetTagListRsp.class);
  public final PBRepeatMessageField<UgcRight.TagInfo> taglist = PBField.initRepeatMessage(UgcRight.TagInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.GetTagListRsp
 * JD-Core Version:    0.7.0.1
 */