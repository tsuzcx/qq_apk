package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGameNotify$NotifyMatchUserEnterRoom
  extends MessageMicro<NotifyMatchUserEnterRoom>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "roomid" }, new Object[] { Long.valueOf(0L) }, NotifyMatchUserEnterRoom.class);
  public final PBUInt64Field roomid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyMatchUserEnterRoom
 * JD-Core Version:    0.7.0.1
 */