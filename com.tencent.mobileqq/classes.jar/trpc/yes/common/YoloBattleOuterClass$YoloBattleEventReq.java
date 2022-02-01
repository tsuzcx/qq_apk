package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleOuterClass$YoloBattleEventReq
  extends MessageMicro<YoloBattleEventReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "base_info", "player_info", "event_id", "extra_data" }, new Object[] { null, null, Integer.valueOf(0), "" }, YoloBattleEventReq.class);
  public YoloBattleOuterClass.YoloBattleBaseInfo base_info = new YoloBattleOuterClass.YoloBattleBaseInfo();
  public final PBUInt32Field event_id = PBField.initUInt32(0);
  public final PBStringField extra_data = PBField.initString("");
  public YoloBattleOuterClass.YoloBattlePlayerInfo player_info = new YoloBattleOuterClass.YoloBattlePlayerInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattleEventReq
 * JD-Core Version:    0.7.0.1
 */