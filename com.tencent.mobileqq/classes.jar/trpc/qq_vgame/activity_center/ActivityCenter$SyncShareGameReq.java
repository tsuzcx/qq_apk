package trpc.qq_vgame.activity_center;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ActivityCenter$SyncShareGameReq
  extends MessageMicro<SyncShareGameReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "play_game_id" }, new Object[] { "" }, SyncShareGameReq.class);
  public final PBStringField play_game_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.activity_center.ActivityCenter.SyncShareGameReq
 * JD-Core Version:    0.7.0.1
 */