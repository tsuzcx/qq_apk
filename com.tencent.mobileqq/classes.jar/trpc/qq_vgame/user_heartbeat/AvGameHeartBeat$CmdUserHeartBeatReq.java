package trpc.qq_vgame.user_heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameHeartBeat$CmdUserHeartBeatReq
  extends MessageMicro<CmdUserHeartBeatReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomid", "uin", "room_state" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, CmdUserHeartBeatReq.class);
  public final PBEnumField room_state = PBField.initEnum(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatReq
 * JD-Core Version:    0.7.0.1
 */