package trpc.qq_vgame.user_heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGameHeartBeat$CmdUserHeartBeatRsp
  extends MessageMicro<CmdUserHeartBeatRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "res", "seq", "report_interval" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, CmdUserHeartBeatRsp.class);
  public final PBUInt32Field report_interval = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt64Field seq = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatRsp
 * JD-Core Version:    0.7.0.1
 */