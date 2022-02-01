package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePkManager$SyncGameVictorReq
  extends MessageMicro<SyncGameVictorReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "victor_uin" }, new Object[] { Long.valueOf(0L) }, SyncGameVictorReq.class);
  public final PBUInt64Field victor_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.SyncGameVictorReq
 * JD-Core Version:    0.7.0.1
 */