package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleOuterClass$YoloBattleTrpcNotifyConfig
  extends MessageMicro<YoloBattleTrpcNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "target", "selector", "name_space", "method_name" }, new Object[] { "", "polaris", "", "" }, YoloBattleTrpcNotifyConfig.class);
  public final PBStringField method_name = PBField.initString("");
  public final PBStringField name_space = PBField.initString("");
  public final PBStringField selector = PBField.initString("polaris");
  public final PBStringField target = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleTrpcNotifyConfig
 * JD-Core Version:    0.7.0.1
 */