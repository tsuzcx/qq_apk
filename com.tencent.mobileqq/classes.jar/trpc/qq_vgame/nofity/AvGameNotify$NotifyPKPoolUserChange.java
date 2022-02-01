package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;

public final class AvGameNotify$NotifyPKPoolUserChange
  extends MessageMicro<NotifyPKPoolUserChange>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "opt", "total", "uins" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, NotifyPKPoolUserChange.class);
  public final PBUInt32Field opt = PBField.initUInt32(0);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBRepeatMessageField<AvGameCommon.UinWrap> uins = PBField.initRepeatMessage(AvGameCommon.UinWrap.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKPoolUserChange
 * JD-Core Version:    0.7.0.1
 */