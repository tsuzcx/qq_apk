package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameNotify$NotifyTranslateInfoS2CReq
  extends MessageMicro<NotifyTranslateInfoS2CReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uin", "trans_cost_time", "play_game_id", "answer" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "" }, NotifyTranslateInfoS2CReq.class);
  public final PBStringField answer = PBField.initString("");
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt32Field trans_cost_time = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyTranslateInfoS2CReq
 * JD-Core Version:    0.7.0.1
 */