package com.tencent.pb.remind;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class RemindPB$RemindQuota
  extends MessageMicro
{
  public static final int UINT32_COMM_QUOTA_FIELD_NUMBER = 1;
  public static final int UINT32_SVIP_QUOTA_FIELD_NUMBER = 2;
  public static final int UINT32_USED_FIELD_NUMBER = 4;
  public static final int UINT32_USER_QUOTA_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_comm_quota", "uint32_svip_quota", "uint32_user_quota", "uint32_used" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RemindQuota.class);
  public final PBUInt32Field uint32_comm_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svip_quota = PBField.initUInt32(0);
  public final PBUInt32Field uint32_used = PBField.initUInt32(0);
  public final PBUInt32Field uint32_user_quota = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.remind.RemindPB.RemindQuota
 * JD-Core Version:    0.7.0.1
 */