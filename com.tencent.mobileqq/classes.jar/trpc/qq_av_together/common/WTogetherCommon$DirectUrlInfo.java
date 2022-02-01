package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$DirectUrlInfo
  extends MessageMicro<DirectUrlInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "url", "cookie", "file_name", "media_format" }, new Object[] { "", "", "", Integer.valueOf(0) }, DirectUrlInfo.class);
  public final PBStringField cookie = PBField.initString("");
  public final PBStringField file_name = PBField.initString("");
  public final PBEnumField media_format = PBField.initEnum(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.DirectUrlInfo
 * JD-Core Version:    0.7.0.1
 */