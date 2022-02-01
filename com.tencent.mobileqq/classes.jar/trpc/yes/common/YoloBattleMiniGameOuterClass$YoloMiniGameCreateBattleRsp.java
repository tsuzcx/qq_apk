package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class YoloBattleMiniGameOuterClass$YoloMiniGameCreateBattleRsp
  extends MessageMicro<YoloMiniGameCreateBattleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "expire_time", "battle_access_info", "players" }, new Object[] { Integer.valueOf(0), "", null }, YoloMiniGameCreateBattleRsp.class);
  public final PBStringField battle_access_info = PBField.initString("");
  public final PBUInt32Field expire_time = PBField.initUInt32(0);
  public final PBRepeatMessageField<YoloBattleMiniGameOuterClass.YoloMiniGamePlayerInfo> players = PBField.initRepeatMessage(YoloBattleMiniGameOuterClass.YoloMiniGamePlayerInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleMiniGameOuterClass.YoloMiniGameCreateBattleRsp
 * JD-Core Version:    0.7.0.1
 */