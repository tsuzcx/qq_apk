package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameLobbyInfo$CmdGetGameLobbyInfoRsp
  extends MessageMicro<CmdGetGameLobbyInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "res", "banner_list", "random_match_info", "pk_list", "operate_activity_info", "random_match_info_by_type" }, new Object[] { null, null, null, null, null, null }, CmdGetGameLobbyInfoRsp.class);
  public final PBRepeatMessageField<AvGameLobbyInfo.BannerInfo> banner_list = PBField.initRepeatMessage(AvGameLobbyInfo.BannerInfo.class);
  public final PBRepeatMessageField<AvGameLobbyInfo.PKCardInfo> operate_activity_info = PBField.initRepeatMessage(AvGameLobbyInfo.PKCardInfo.class);
  public final PBRepeatMessageField<AvGameLobbyInfo.PKCardInfo> pk_list = PBField.initRepeatMessage(AvGameLobbyInfo.PKCardInfo.class);
  public AvGameLobbyInfo.RandomMatchInfo random_match_info = new AvGameLobbyInfo.RandomMatchInfo();
  public final PBRepeatMessageField<AvGameLobbyInfo.RandomMatchInfo> random_match_info_by_type = PBField.initRepeatMessage(AvGameLobbyInfo.RandomMatchInfo.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetGameLobbyInfoRsp
 * JD-Core Version:    0.7.0.1
 */