package trpc.qq_vgame.pk_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import trpc.qq_vgame.common.AvGameCommon.Result;
import trpc.qq_vgame.common.AvGameCommon.UinWrap;

public final class AvGamePkManager$GetPKInfoRsp
  extends MessageMicro<GetPKInfoRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField change_pool_id = PBField.initBool(false);
  public final PBBoolField fresh_at_midfield = PBField.initBool(false);
  public final PBUInt32Field interval = PBField.initUInt32(0);
  public final PBUInt32Field real_pool_id = PBField.initUInt32(0);
  public AvGameCommon.Result res = new AvGameCommon.Result();
  public final PBRepeatMessageField<AvGameCommon.UinWrap> user_in_pk = PBField.initRepeatMessage(AvGameCommon.UinWrap.class);
  public final PBUInt32Field user_total_num = PBField.initUInt32(0);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56 }, new String[] { "res", "interval", "user_total_num", "user_in_pk", "change_pool_id", "real_pool_id", "fresh_at_midfield" }, new Object[] { null, localInteger, localInteger, null, localBoolean, localInteger, localBoolean }, GetPKInfoRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.qq_vgame.pk_manager.AvGamePkManager.GetPKInfoRsp
 * JD-Core Version:    0.7.0.1
 */