package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattlePlayerBelongBattle
  extends MessageMicro<YoloBattlePlayerBelongBattle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "yolo_battle_id", "player" }, new Object[] { Long.valueOf(0L), null }, YoloBattlePlayerBelongBattle.class);
  public YoloBattleOuterClass.YoloBattleOnePlayer player = new YoloBattleOuterClass.YoloBattleOnePlayer();
  public final PBUInt64Field yolo_battle_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattlePlayerBelongBattle
 * JD-Core Version:    0.7.0.1
 */