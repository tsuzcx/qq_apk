package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$UrlParams
  extends MessageMicro<UrlParams>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "url", "media_format" }, new Object[] { "", Integer.valueOf(0) }, UrlParams.class);
  public final PBEnumField media_format = PBField.initEnum(0);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.UrlParams
 * JD-Core Version:    0.7.0.1
 */