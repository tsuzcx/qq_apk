package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class YoloBattleOuterClass$YoloBattleYesAPPNotifyConfig
  extends MessageMicro<YoloBattleYesAPPNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "users" }, new Object[] { null }, YoloBattleYesAPPNotifyConfig.class);
  public final PBRepeatMessageField<YoloBattleOuterClass.YesAPPNotifyUser> users = PBField.initRepeatMessage(YoloBattleOuterClass.YesAPPNotifyUser.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleYesAPPNotifyConfig
 * JD-Core Version:    0.7.0.1
 */