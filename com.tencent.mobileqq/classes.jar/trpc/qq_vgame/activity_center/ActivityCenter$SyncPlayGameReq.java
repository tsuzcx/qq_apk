package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ActivityCenter$SyncPlayGameReq
  extends MessageMicro<SyncPlayGameReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "play_game_id", "uin_list" }, new Object[] { "", Long.valueOf(0L) }, SyncPlayGameReq.class);
  public final PBStringField play_game_id = PBField.initString("");
  public final PBRepeatField<Long> uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.activity_center.ActivityCenter.SyncPlayGameReq
 * JD-Core Version:    0.7.0.1
 */