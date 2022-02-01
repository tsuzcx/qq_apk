package trpc.qq_vgame.game_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameRanking$GetRankingListReq
  extends MessageMicro<GetRankingListReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "play_game_id" }, new Object[] { Long.valueOf(0L), "" }, GetRankingListReq.class);
  public final PBStringField play_game_id = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListReq
 * JD-Core Version:    0.7.0.1
 */