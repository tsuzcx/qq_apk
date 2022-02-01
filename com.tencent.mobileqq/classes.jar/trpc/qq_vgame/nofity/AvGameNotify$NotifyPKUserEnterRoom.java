package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameNotify$NotifyPKUserEnterRoom
  extends MessageMicro<NotifyPKUserEnterRoom>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "roomid", "peer_uin" }, new Object[] { localLong, localLong }, NotifyPKUserEnterRoom.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserEnterRoom
 * JD-Core Version:    0.7.0.1
 */