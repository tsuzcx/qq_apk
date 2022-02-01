package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class AvGameLobbyInfo$CmdGetGameLobbyInfoReq
  extends MessageMicro<CmdGetGameLobbyInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "version" }, new Object[] { "" }, CmdGetGameLobbyInfoReq.class);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetGameLobbyInfoReq
 * JD-Core Version:    0.7.0.1
 */