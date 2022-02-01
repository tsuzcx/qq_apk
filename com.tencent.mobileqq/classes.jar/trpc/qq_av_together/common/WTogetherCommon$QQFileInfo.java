package trpc.qq_av_together.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class WTogetherCommon$QQFileInfo
  extends MessageMicro<QQFileInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "file_uuid", "file_id" }, new Object[] { "", "" }, QQFileInfo.class);
  public final PBStringField file_id = PBField.initString("");
  public final PBStringField file_uuid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_av_together.common.WTogetherCommon.QQFileInfo
 * JD-Core Version:    0.7.0.1
 */