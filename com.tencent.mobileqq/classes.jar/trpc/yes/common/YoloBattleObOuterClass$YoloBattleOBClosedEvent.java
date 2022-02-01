package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class YoloBattleObOuterClass$YoloBattleOBClosedEvent
  extends MessageMicro<YoloBattleOBClosedEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "status", "battle_base_info" }, new Object[] { Integer.valueOf(0), null }, YoloBattleOBClosedEvent.class);
  public YoloBattleOuterClass.YoloBattleBaseInfo battle_base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public final PBEnumField status = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleObOuterClass.YoloBattleOBClosedEvent
 * JD-Core Version:    0.7.0.1
 */