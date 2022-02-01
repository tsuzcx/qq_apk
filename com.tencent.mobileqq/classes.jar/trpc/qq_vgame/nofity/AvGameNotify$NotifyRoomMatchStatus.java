package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameNotify$NotifyRoomMatchStatus
  extends MessageMicro<NotifyRoomMatchStatus>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "roomid", "status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, NotifyRoomMatchStatus.class);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
  public final PBUInt32Field status = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyRoomMatchStatus
 * JD-Core Version:    0.7.0.1
 */