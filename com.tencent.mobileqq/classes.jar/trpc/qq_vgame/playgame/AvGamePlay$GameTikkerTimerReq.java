package trpc.qq_vgame.playgame;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class AvGamePlay$GameTikkerTimerReq
  extends MessageMicro<GameTikkerTimerReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_notify_item" }, new Object[] { null }, GameTikkerTimerReq.class);
  public final PBRepeatMessageField<AvGamePlay.NotifyItem> rpt_notify_item = PBField.initRepeatMessage(AvGamePlay.NotifyItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.playgame.AvGamePlay.GameTikkerTimerReq
 * JD-Core Version:    0.7.0.1
 */