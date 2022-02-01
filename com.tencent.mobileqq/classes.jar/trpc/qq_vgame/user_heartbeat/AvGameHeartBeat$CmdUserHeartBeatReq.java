package trpc.qq_vgame.user_heartbeat;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameHeartBeat$CmdUserHeartBeatReq
  extends MessageMicro<CmdUserHeartBeatReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField room_state = PBField.initEnum(0);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomid", "uin", "room_state" }, new Object[] { localLong, localLong, Integer.valueOf(0) }, CmdUserHeartBeatReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     trpc.qq_vgame.user_heartbeat.AvGameHeartBeat.CmdUserHeartBeatReq
 * JD-Core Version:    0.7.0.1
 */