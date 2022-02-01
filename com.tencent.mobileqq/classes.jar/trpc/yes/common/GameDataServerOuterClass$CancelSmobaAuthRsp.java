package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GameDataServerOuterClass$CancelSmobaAuthRsp
  extends MessageMicro<CancelSmobaAuthRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "auth_desc", "is_auth" }, new Object[] { "", Boolean.valueOf(false) }, CancelSmobaAuthRsp.class);
  public final PBRepeatField<String> auth_desc = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBBoolField is_auth = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp
 * JD-Core Version:    0.7.0.1
 */