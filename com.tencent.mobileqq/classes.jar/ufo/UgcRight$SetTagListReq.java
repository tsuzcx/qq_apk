package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class UgcRight$SetTagListReq
  extends MessageMicro<SetTagListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "uin", "cmd", "taginfo" }, new Object[] { "", Integer.valueOf(0), null }, SetTagListReq.class);
  public final PBInt32Field cmd = PBField.initInt32(0);
  public UgcRight.TagInfo taginfo = new UgcRight.TagInfo();
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     ufo.UgcRight.SetTagListReq
 * JD-Core Version:    0.7.0.1
 */