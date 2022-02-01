package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameLobbyInfo$RandomMatchInfo
  extends MessageMicro<RandomMatchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "players_num", "player_list" }, new Object[] { Integer.valueOf(0), null }, RandomMatchInfo.class);
  public final PBRepeatMessageField<AvGameLobbyInfo.PlayerInfo> player_list = PBField.initRepeatMessage(AvGameLobbyInfo.PlayerInfo.class);
  public final PBUInt32Field players_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.RandomMatchInfo
 * JD-Core Version:    0.7.0.1
 */