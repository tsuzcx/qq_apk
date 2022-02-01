package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameLobbyInfo$PKCardInfo
  extends MessageMicro<PKCardInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 82, 88, 96, 106, 112, 122, 128 }, new String[] { "pk_id", "title_url", "backgroud_url", "start_time", "end_time", "is_reserve", "reserve_user_num", "play_user_num", "player_list", "wording", "color_start", "color_end", "time_wording", "game_type", "background_color_url", "is_qqcj_activity" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), null, "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), "", Boolean.valueOf(false) }, PKCardInfo.class);
  public final PBStringField backgroud_url = PBField.initString("");
  public final PBStringField background_color_url = PBField.initString("");
  public final PBUInt32Field color_end = PBField.initUInt32(0);
  public final PBUInt32Field color_start = PBField.initUInt32(0);
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBBoolField is_qqcj_activity = PBField.initBool(false);
  public final PBBoolField is_reserve = PBField.initBool(false);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBUInt32Field play_user_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameLobbyInfo.PlayerInfo> player_list = PBField.initRepeatMessage(AvGameLobbyInfo.PlayerInfo.class);
  public final PBUInt32Field reserve_user_num = PBField.initUInt32(0);
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  public final PBStringField time_wording = PBField.initString("");
  public final PBStringField title_url = PBField.initString("");
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.PKCardInfo
 * JD-Core Version:    0.7.0.1
 */