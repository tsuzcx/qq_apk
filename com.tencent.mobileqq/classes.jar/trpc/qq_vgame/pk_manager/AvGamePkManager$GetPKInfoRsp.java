package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;

public final class AvGamePkManager$GetPKInfoRsp
  extends MessageMicro<GetPKInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34 }, new String[] { "res", "interval", "user_total_num", "user_in_pk" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0), null }, GetPKInfoRsp.class);
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBRepeatMessageField<AvGameCommon.UinWrap> user_in_pk = PBField.initRepeatMessage(AvGameCommon.UinWrap.class);
  public final PBUInt32Field user_total_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoRsp
 * JD-Core Version:    0.7.0.1
 */