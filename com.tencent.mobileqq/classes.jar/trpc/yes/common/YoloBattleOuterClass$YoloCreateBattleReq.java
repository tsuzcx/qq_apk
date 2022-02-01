package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoloBattleOuterClass$YoloCreateBattleReq
  extends MessageMicro<YoloCreateBattleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 48 }, new String[] { "notify_config", "player_info", "notify_config_list", "extra_data", "battle_type" }, new Object[] { null, null, null, "", Integer.valueOf(0) }, YoloCreateBattleReq.class);
  public final PBEnumField battle_type = PBField.initEnum(0);
  public final PBStringField extra_data = PBField.initString("");
  public YoloBattleOuterClass.YoloBattleNotifyConfig notify_config = new YoloBattleOuterClass.YoloBattleNotifyConfig();
  public final PBRepeatMessageField<YoloBattleOuterClass.YoloBattleNotifyConfig> notify_config_list = PBField.initRepeatMessage(YoloBattleOuterClass.YoloBattleNotifyConfig.class);
  public YoloBattleOuterClass.YoloBattlePlayerInfo player_info = new YoloBattleOuterClass.YoloBattlePlayerInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloCreateBattleReq
 * JD-Core Version:    0.7.0.1
 */