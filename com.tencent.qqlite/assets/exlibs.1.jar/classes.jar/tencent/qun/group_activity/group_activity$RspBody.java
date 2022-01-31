package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_activity$RspBody
  extends MessageMicro
{
  public static final int ACT_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_error_code", "act_list" }, new Object[] { Integer.valueOf(0), null }, RspBody.class);
  public final PBRepeatMessageField act_list = PBField.initRepeatMessage(group_activity.GroupAct.class);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.qun.group_activity.group_activity.RspBody
 * JD-Core Version:    0.7.0.1
 */