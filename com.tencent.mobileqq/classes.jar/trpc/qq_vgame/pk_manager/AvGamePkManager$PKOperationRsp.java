package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;

public final class AvGamePkManager$PKOperationRsp
  extends MessageMicro<PKOperationRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "res", "pool_id", "start_user_num" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, PKOperationRsp.class);
  public final PBUInt32Field pool_id = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBUInt32Field start_user_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationRsp
 * JD-Core Version:    0.7.0.1
 */