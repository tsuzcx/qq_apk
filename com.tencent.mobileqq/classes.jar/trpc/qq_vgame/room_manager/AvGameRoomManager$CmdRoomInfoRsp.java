package trpc.qq_vgame.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.GameStatusInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.game_list.AvGameList.CmdGameListRsp;
import trpc.qq_vgame.game_ranking.AvGameRanking.GetRankingListRsp;

public final class AvGameRoomManager$CmdRoomInfoRsp
  extends MessageMicro<CmdRoomInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "res", "room_info", "game_status_info", "game_cfg_info", "game_ranking_info" }, new Object[] { null, null, null, null, null }, CmdRoomInfoRsp.class);
  public AvGameList.CmdGameListRsp game_cfg_info = new AvGameList.CmdGameListRsp();
  public AvGameRanking.GetRankingListRsp game_ranking_info = new AvGameRanking.GetRankingListRsp();
  public AvGameCommon.GameStatusInfo game_status_info = new AvGameCommon.GameStatusInfo();
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public AvGameCommon.RoomInfo room_info = new AvGameCommon.RoomInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.room_manager.AvGameRoomManager.CmdRoomInfoRsp
 * JD-Core Version:    0.7.0.1
 */