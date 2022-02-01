package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameLobbyInfo$CmdGetPKTimeReq
  extends MessageMicro<CmdGetPKTimeReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "pk_id" }, new Object[] { Integer.valueOf(0) }, CmdGetPKTimeReq.class);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetPKTimeReq
 * JD-Core Version:    0.7.0.1
 */