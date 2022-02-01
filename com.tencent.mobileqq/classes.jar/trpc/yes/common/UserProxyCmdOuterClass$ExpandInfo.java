package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class UserProxyCmdOuterClass$ExpandInfo
  extends MessageMicro<ExpandInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "declarationa", "voice_url", "voice_duration", "voice_color" }, new Object[] { "", "", Integer.valueOf(0), "" }, ExpandInfo.class);
  public final PBStringField declarationa = PBField.initString("");
  public final PBStringField voice_color = PBField.initString("");
  public final PBUInt32Field voice_duration = PBField.initUInt32(0);
  public final PBStringField voice_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.UserProxyCmdOuterClass.ExpandInfo
 * JD-Core Version:    0.7.0.1
 */