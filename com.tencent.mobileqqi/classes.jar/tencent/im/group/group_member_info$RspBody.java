package tencent.im.group;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$RspBody
  extends MessageMicro
{
  public static final int MSG_MEMINFO_FIELD_NUMBER = 3;
  public static final int UINT32_SELF_ROLE_FIELD_NUMBER = 2;
  public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint64_group_code", "uint32_self_role", "msg_meminfo" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspBody.class);
  public group_member_info.MemberInfo msg_meminfo = new group_member_info.MemberInfo();
  public final PBUInt32Field uint32_self_role = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.group.group_member_info.RspBody
 * JD-Core Version:    0.7.0.1
 */