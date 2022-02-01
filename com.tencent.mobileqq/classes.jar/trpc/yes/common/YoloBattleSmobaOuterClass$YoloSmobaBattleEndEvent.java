package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleSmobaOuterClass$YoloSmobaBattleEndEvent
  extends MessageMicro<YoloSmobaBattleEndEvent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "game_id", "battle_id", "camp_settle_list", "smoba_config" }, new Object[] { Integer.valueOf(0), "", null, null }, YoloSmobaBattleEndEvent.class);
  public final PBStringField battle_id = PBField.initString("");
  public final PBRepeatMessageField<SmobaDataOuterClass.GameCampSettleInfo> camp_settle_list = PBField.initRepeatMessage(SmobaDataOuterClass.GameCampSettleInfo.class);
  public final PBInt32Field game_id = PBField.initInt32(0);
  public YoloBattleSmobaOuterClass.YoloSmobaBattleConfig smoba_config = new YoloBattleSmobaOuterClass.YoloSmobaBattleConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleSmobaOuterClass.YoloSmobaBattleEndEvent
 * JD-Core Version:    0.7.0.1
 */