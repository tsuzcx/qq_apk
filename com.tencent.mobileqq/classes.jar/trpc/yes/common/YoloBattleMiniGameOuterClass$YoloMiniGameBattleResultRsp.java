package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameBattleResultRsp
  extends MessageMicro<YoloMiniGameBattleResultRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "battle_result" }, new Object[] { null }, YoloMiniGameBattleResultRsp.class);
  public MiniGameDataOuterClass.YoloBattleMiniGameResult battle_result = new MiniGameDataOuterClass.YoloBattleMiniGameResult();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameBattleResultRsp
 * JD-Core Version:    0.7.0.1
 */