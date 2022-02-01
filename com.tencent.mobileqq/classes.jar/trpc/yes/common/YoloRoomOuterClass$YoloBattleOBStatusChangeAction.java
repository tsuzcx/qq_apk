package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloRoomOuterClass$YoloBattleOBStatusChangeAction
  extends MessageMicro<YoloBattleOBStatusChangeAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 82 }, new String[] { "status", "ob_url", "pic_url", "ob_close_event" }, new Object[] { Integer.valueOf(0), "", "", null }, YoloBattleOBStatusChangeAction.class);
  public YoloBattleObOuterClass.YoloBattleOBClosedEvent ob_close_event = new YoloBattleObOuterClass.YoloBattleOBClosedEvent();
  public final PBStringField ob_url = PBField.initString("");
  public final PBStringField pic_url = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloBattleOBStatusChangeAction
 * JD-Core Version:    0.7.0.1
 */