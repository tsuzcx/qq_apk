package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePkManager$PKOperationReq
  extends MessageMicro<PKOperationReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "pk_id", "opt", "pool_id", "uin", "cur_round", "support_cj", "local_mod_status", "leave_scene" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, PKOperationReq.class);
  public final PBUInt32Field cur_round = PBField.initUInt32(0);
  public final PBUInt32Field leave_scene = PBField.initUInt32(0);
  public final PBUInt32Field local_mod_status = PBField.initUInt32(0);
  public final PBEnumField opt = PBField.initEnum(0);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBUInt32Field pool_id = PBField.initUInt32(0);
  public final PBBoolField support_cj = PBField.initBool(false);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.PKOperationReq
 * JD-Core Version:    0.7.0.1
 */