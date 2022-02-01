package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;

public final class AvGameList$GameListItemInfo
  extends MessageMicro<GameListItemInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 106, 114, 122, 130, 138, 144, 154, 162 }, new String[] { "game_type", "game_name", "game_desc", "backgroup_pic_url", "game_info", "prepare_pic_url", "prepare_pic_tp_url", "music_name", "status", "online_time", "prepare_wording", "offline_time", "game_name_url", "answer_right_pic_url", "game_over_pic_url", "tips_one_line_pic_url", "tips_two_line_pic_url", "total_player_num", "backgroup_small_pic_url", "answer_right_pic_url_new" }, new Object[] { Integer.valueOf(0), "", "", "", null, "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L), "", "", "", "", "", Long.valueOf(0L), "", "" }, GameListItemInfo.class);
  public final PBStringField answer_right_pic_url = PBField.initString("");
  public final PBStringField answer_right_pic_url_new = PBField.initString("");
  public final PBStringField backgroup_pic_url = PBField.initString("");
  public final PBStringField backgroup_small_pic_url = PBField.initString("");
  public final PBStringField game_desc = PBField.initString("");
  public AvGameCommon.GameInfo game_info = new AvGameCommon.GameInfo();
  public final PBStringField game_name = PBField.initString("");
  public final PBStringField game_name_url = PBField.initString("");
  public final PBStringField game_over_pic_url = PBField.initString("");
  public final PBEnumField game_type = PBField.initEnum(0);
  public final PBStringField music_name = PBField.initString("");
  public final PBUInt64Field offline_time = PBField.initUInt64(0L);
  public final PBUInt64Field online_time = PBField.initUInt64(0L);
  public final PBStringField prepare_pic_tp_url = PBField.initString("");
  public final PBStringField prepare_pic_url = PBField.initString("");
  public final PBStringField prepare_wording = PBField.initString("");
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField tips_one_line_pic_url = PBField.initString("");
  public final PBStringField tips_two_line_pic_url = PBField.initString("");
  public final PBUInt64Field total_player_num = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.GameListItemInfo
 * JD-Core Version:    0.7.0.1
 */