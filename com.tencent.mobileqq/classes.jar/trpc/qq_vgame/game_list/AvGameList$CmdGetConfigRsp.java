package trpc.qq_vgame.game_list;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.GameInfo;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameList$CmdGetConfigRsp
  extends MessageMicro<CmdGetConfigRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "game_info", "res" }, new Object[] { null, null }, CmdGetConfigRsp.class);
  public AvGameCommon.GameInfo game_info = new AvGameCommon.GameInfo();
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.game_list.AvGameList.CmdGetConfigRsp
 * JD-Core Version:    0.7.0.1
 */