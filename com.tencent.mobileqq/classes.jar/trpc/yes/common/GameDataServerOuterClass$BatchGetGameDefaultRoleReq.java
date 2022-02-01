package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GameDataServerOuterClass$BatchGetGameDefaultRoleReq
  extends MessageMicro<BatchGetGameDefaultRoleReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uid_list", "game_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, BatchGetGameDefaultRoleReq.class);
  public final PBInt32Field game_id = PBField.initInt32(0);
  public final PBRepeatField<Long> uid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.BatchGetGameDefaultRoleReq
 * JD-Core Version:    0.7.0.1
 */