package trpc.qq_vgame.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameCommon$GameStatusInfo
  extends MessageMicro<GameStatusInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 56, 66, 72 }, new String[] { "play_game_id", "game_status", "status_past_time", "actor_info", "question_info", "game_info", "game_past_time", "right_actor_info", "score" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), null, null, null, Integer.valueOf(0), null, Integer.valueOf(0) }, GameStatusInfo.class);
  public AvGameCommon.RoomUserInfo actor_info = new AvGameCommon.RoomUserInfo();
  public AvGameCommon.GameInfo game_info = new AvGameCommon.GameInfo();
  public final PBUInt32Field game_past_time = PBField.initUInt32(0);
  public final PBEnumField game_status = PBField.initEnum(0);
  public final PBStringField play_game_id = PBField.initString("");
  public AvGameCommon.GameQuestionInfo question_info = new AvGameCommon.GameQuestionInfo();
  public AvGameCommon.RoomUserInfo right_actor_info = new AvGameCommon.RoomUserInfo();
  public final PBUInt32Field score = PBField.initUInt32(0);
  public final PBUInt32Field status_past_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.common.AvGameCommon.GameStatusInfo
 * JD-Core Version:    0.7.0.1
 */