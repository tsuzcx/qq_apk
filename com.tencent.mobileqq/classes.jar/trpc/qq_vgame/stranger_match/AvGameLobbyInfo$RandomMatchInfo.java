package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameLobbyInfo$RandomMatchInfo
  extends MessageMicro<RandomMatchInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField backgroud_url = PBField.initString("");
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBRepeatMessageField<AvGameLobbyInfo.PlayerInfo> player_list = PBField.initRepeatMessage(AvGameLobbyInfo.PlayerInfo.class);
  public final PBUInt32Field players_num = PBField.initUInt32(0);
  public final PBStringField title_url = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "players_num", "player_list", "game_type", "title_url", "backgroud_url", "wording" }, new Object[] { localInteger, null, localInteger, "", "", "" }, RandomMatchInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.RandomMatchInfo
 * JD-Core Version:    0.7.0.1
 */