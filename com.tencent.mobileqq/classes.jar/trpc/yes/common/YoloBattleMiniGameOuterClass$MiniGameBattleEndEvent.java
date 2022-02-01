package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleMiniGameOuterClass$MiniGameBattleEndEvent
  extends MessageMicro<MiniGameBattleEndEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "mini_game_battle_result" }, new Object[] { null }, MiniGameBattleEndEvent.class);
  public MiniGameDataOuterClass.YoloBattleMiniGameResult mini_game_battle_result = new MiniGameDataOuterClass.YoloBattleMiniGameResult();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.MiniGameBattleEndEvent
 * JD-Core Version:    0.7.0.1
 */