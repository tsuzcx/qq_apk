package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_activity$ReqBody
  extends MessageMicro
{
  public static final int UINT32_ACT_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_act_id" }, new Object[] { Integer.valueOf(0) }, ReqBody.class);
  public final PBRepeatField uint32_act_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.qun.group_activity.group_activity.ReqBody
 * JD-Core Version:    0.7.0.1
 */