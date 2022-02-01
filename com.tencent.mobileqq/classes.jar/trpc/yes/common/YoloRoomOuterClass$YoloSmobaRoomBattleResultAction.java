package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import trpc.yes.wuji.WujiSmobaOuterClass.WujiSmobaHeroConfList;

public final class YoloRoomOuterClass$YoloSmobaRoomBattleResultAction
  extends MessageMicro<YoloSmobaRoomBattleResultAction>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "smoba_battle_result", "smoba_hero_conf_list", "daily_anchor_battle_result_statistics", "user_id_list", "battle_result_text" }, new Object[] { null, null, null, null, "" }, YoloSmobaRoomBattleResultAction.class);
  public final PBRepeatField<String> battle_result_text = PBField.initRepeat(PBStringField.__repeatHelper__);
  public YoloRoomOuterClass.AnchorBattleResultStatistics daily_anchor_battle_result_statistics = new YoloRoomOuterClass.AnchorBattleResultStatistics();
  public YoloBattleSmobaOuterClass.YoloSmobaBattleResult smoba_battle_result = new YoloBattleSmobaOuterClass.YoloSmobaBattleResult();
  public WujiSmobaOuterClass.WujiSmobaHeroConfList smoba_hero_conf_list = new WujiSmobaOuterClass.WujiSmobaHeroConfList();
  public final PBRepeatMessageField<CommonOuterClass.QQUserId> user_id_list = PBField.initRepeatMessage(CommonOuterClass.QQUserId.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomBattleResultAction
 * JD-Core Version:    0.7.0.1
 */