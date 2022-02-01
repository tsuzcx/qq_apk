package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class YoloBattleOuterClass$YoloBattlePlayerInfo
  extends MessageMicro<YoloBattlePlayerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "players", "players_quit_in_game" }, new Object[] { null, Long.valueOf(0L) }, YoloBattlePlayerInfo.class);
  public final PBRepeatMessageField<YoloBattleOuterClass.YoloBattleOnePlayer> players = PBField.initRepeatMessage(YoloBattleOuterClass.YoloBattleOnePlayer.class);
  public final PBRepeatField<Long> players_quit_in_game = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.YoloBattleOuterClass.YoloBattlePlayerInfo
 * JD-Core Version:    0.7.0.1
 */