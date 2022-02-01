package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class AvGamePlay$GameTikkerTimerRsp
  extends MessageMicro<GameTikkerTimerRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_result" }, new Object[] { Integer.valueOf(0) }, GameTikkerTimerRsp.class);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.GameTikkerTimerRsp
 * JD-Core Version:    0.7.0.1
 */