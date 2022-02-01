package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleAbnormalQuitEvent
  extends MessageMicro<YoloSmobaBattleAbnormalQuitEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "partition_id", "game_openid", "game_roleid", "battle_id" }, new Object[] { Integer.valueOf(0), "", "", "" }, YoloSmobaBattleAbnormalQuitEvent.class);
  public final PBStringField battle_id = PBField.initString("");
  public final PBStringField game_openid = PBField.initString("");
  public final PBStringField game_roleid = PBField.initString("");
  public final PBInt32Field partition_id = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleAbnormalQuitEvent
 * JD-Core Version:    0.7.0.1
 */