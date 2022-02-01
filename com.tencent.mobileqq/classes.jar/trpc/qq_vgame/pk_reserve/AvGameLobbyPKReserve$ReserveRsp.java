package trpc.qq_vgame.pk_reserve;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameLobbyPKReserve$ReserveRsp
  extends MessageMicro<ReserveRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "res" }, new Object[] { null }, ReserveRsp.class);
  public AvGameCommon.Result res = new AvGameCommon.Result();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.pk_reserve.AvGameLobbyPKReserve.ReserveRsp
 * JD-Core Version:    0.7.0.1
 */