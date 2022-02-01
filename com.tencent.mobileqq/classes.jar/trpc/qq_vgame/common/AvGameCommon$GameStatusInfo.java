package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameCommon$GameStatusInfo
  extends MessageMicro<GameStatusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public final PBUInt64Field actor_start_ts = PBField.initUInt64(0L);
  public AvGameCommon.GameInfo game_info = new AvGameCommon.GameInfo();
  public final PBUInt32Field game_mode = PBField.initUInt32(0);
  public final PBUInt32Field game_past_time = PBField.initUInt32(0);
  public final PBEnumField game_status = PBField.initEnum(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBStringField play_game_id = PBField.initString("");
  public final PBStringField question_class = PBField.initString("");
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public AvGameCommon.RoomUserInfo right_actor_info = new AvGameCommon.RoomUserInfo();
  public final PBEnumField scene_type = PBField.initEnum(0);
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameCommon.PKUserRankInfo> score_list = PBField.initRepeatMessage(AvGameCommon.PKUserRankInfo.class);
  public final PBUInt32Field status_past_time = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 66, 72, 80, 88, 96, 106, 112, 120, 128, 138 }, new String[] { "play_game_id", "game_status", "status_past_time", "actor_info", "question_info", "game_info", "game_past_time", "right_actor_info", "score", "actor_start_ts", "total", "index", "question_class", "pk_id", "game_mode", "scene_type", "score_list" }, new Object[] { "", localInteger, localInteger, null, null, null, localInteger, null, localInteger, Long.valueOf(0L), localInteger, localInteger, "", localInteger, localInteger, localInteger, null }, GameStatusInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GameStatusInfo
 * JD-Core Version:    0.7.0.1
 */