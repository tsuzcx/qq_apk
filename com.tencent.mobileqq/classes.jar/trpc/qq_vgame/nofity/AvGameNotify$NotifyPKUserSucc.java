package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameNotify$NotifyPKUserSucc
  extends MessageMicro<NotifyPKUserSucc>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "reason", "cur_round", "draw_res" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, NotifyPKUserSucc.class);
  public final PBUInt32Field cur_round = PBField.initUInt32(0);
  public AvGameNotify.PKDrawRes draw_res = new AvGameNotify.PKDrawRes();
  public final PBUInt32Field reason = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserSucc
 * JD-Core Version:    0.7.0.1
 */