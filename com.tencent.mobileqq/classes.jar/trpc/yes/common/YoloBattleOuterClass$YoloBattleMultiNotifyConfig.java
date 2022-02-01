package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloBattleOuterClass$YoloBattleMultiNotifyConfig
  extends MessageMicro<YoloBattleMultiNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "notify_config_list" }, new Object[] { null }, YoloBattleMultiNotifyConfig.class);
  public final PBRepeatMessageField<YoloBattleOuterClass.YoloBattleNotifyConfig> notify_config_list = PBField.initRepeatMessage(YoloBattleOuterClass.YoloBattleNotifyConfig.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleMultiNotifyConfig
 * JD-Core Version:    0.7.0.1
 */