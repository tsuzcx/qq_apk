package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class GameDataServerOuterClass$BatchGetGameDefaultRoleRsp
  extends MessageMicro<BatchGetGameDefaultRoleRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "role_list" }, new Object[] { null }, BatchGetGameDefaultRoleRsp.class);
  public final PBRepeatMessageField<GameDataServerOuterClass.UserDefaultRole> role_list = PBField.initRepeatMessage(GameDataServerOuterClass.UserDefaultRole.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.BatchGetGameDefaultRoleRsp
 * JD-Core Version:    0.7.0.1
 */