package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class AvGamePkManager$GetPKInfoReq
  extends MessageMicro<GetPKInfoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64 }, new String[] { "pk_id", "pool_id", "uin", "scene", "pull_count", "pk_start", "in_game", "support_fresh_at_midfield" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Boolean.valueOf(false) }, GetPKInfoReq.class);
  public final PBBoolField in_game = PBField.initBool(false);
  public final PBUInt32Field pk_id = PBField.initUInt32(0);
  public final PBBoolField pk_start = PBField.initBool(false);
  public final PBUInt32Field pool_id = PBField.initUInt32(0);
  public final PBUInt64Field pull_count = PBField.initUInt64(0L);
  public final PBEnumField scene = PBField.initEnum(0);
  public final PBBoolField support_fresh_at_midfield = PBField.initBool(false);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoReq
 * JD-Core Version:    0.7.0.1
 */