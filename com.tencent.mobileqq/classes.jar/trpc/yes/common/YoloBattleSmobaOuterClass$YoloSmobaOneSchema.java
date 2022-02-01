package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleSmobaOuterClass$YoloSmobaOneSchema
  extends MessageMicro<YoloSmobaOneSchema>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 82 }, new String[] { "uid", "game_openid", "schema" }, new Object[] { Long.valueOf(0L), "", "" }, YoloSmobaOneSchema.class);
  public final PBStringField game_openid = PBField.initString("");
  public final PBStringField schema = PBField.initString("");
  public final PBUInt64Field uid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaOneSchema
 * JD-Core Version:    0.7.0.1
 */