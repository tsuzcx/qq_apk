package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleObOuterClass$YoloBattleOBPreparingEvent
  extends MessageMicro<YoloBattleOBPreparingEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "status", "ob_url" }, new Object[] { Integer.valueOf(0), "" }, YoloBattleOBPreparingEvent.class);
  public final PBStringField ob_url = PBField.initString("");
  public final PBEnumField status = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBPreparingEvent
 * JD-Core Version:    0.7.0.1
 */