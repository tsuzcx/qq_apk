package trpc.qq_vgame.game_ranking;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameRanking$GetRankingListRsp
  extends MessageMicro<GetRankingListRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "ranking_list" }, new Object[] { null, null }, GetRankingListRsp.class);
  public final PBRepeatMessageField<AvGameRanking.UserScoreInfo> ranking_list = PBField.initRepeatMessage(AvGameRanking.UserScoreInfo.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp
 * JD-Core Version:    0.7.0.1
 */