package trpc.qq_vgame.stranger_match;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameStrangerMatch$AddMatchRoomReq
  extends MessageMicro<AddMatchRoomReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field owner_uin = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "roomid", "type", "owner_uin" }, new Object[] { localLong, Integer.valueOf(0), localLong }, AddMatchRoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.stranger_match.AvGameStrangerMatch.AddMatchRoomReq
 * JD-Core Version:    0.7.0.1
 */