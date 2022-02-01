package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleObOuterClass$YoloBattleOBNotifyConfig
  extends MessageMicro<YoloBattleOBNotifyConfig>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "notify_type" }, new Object[] { Integer.valueOf(0) }, YoloBattleOBNotifyConfig.class);
  public final PBEnumField notify_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBNotifyConfig
 * JD-Core Version:    0.7.0.1
 */