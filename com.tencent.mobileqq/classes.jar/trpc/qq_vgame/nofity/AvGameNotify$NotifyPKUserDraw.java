package trpc.qq_vgame.nofity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGameNotify$NotifyPKUserDraw
  extends MessageMicro<NotifyPKUserDraw>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "exit_room", "cur_round" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, NotifyPKUserDraw.class);
  public final PBUInt32Field cur_round = PBField.initUInt32(0);
  public final PBBoolField exit_room = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.nofity.AvGameNotify.NotifyPKUserDraw
 * JD-Core Version:    0.7.0.1
 */