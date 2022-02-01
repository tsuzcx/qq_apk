package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameLobbyInfo$CmdGetPKTimeRsp
  extends MessageMicro<CmdGetPKTimeRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field end_time = PBField.initUInt64(0L);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt64Field start_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "res", "start_time", "end_time" }, new Object[] { null, localLong, localLong }, CmdGetPKTimeRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameLobbyInfo.CmdGetPKTimeRsp
 * JD-Core Version:    0.7.0.1
 */