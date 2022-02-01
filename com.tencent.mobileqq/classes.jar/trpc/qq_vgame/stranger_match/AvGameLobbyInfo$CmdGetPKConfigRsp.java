package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameLobbyInfo$CmdGetPKConfigRsp
  extends MessageMicro<CmdGetPKConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "res", "pk_config_list" }, new Object[] { null, null }, CmdGetPKConfigRsp.class);
  public final PBRepeatMessageField<AvGameLobbyInfo.PkConfig> pk_config_list = PBField.initRepeatMessage(AvGameLobbyInfo.PkConfig.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetPKConfigRsp
 * JD-Core Version:    0.7.0.1
 */