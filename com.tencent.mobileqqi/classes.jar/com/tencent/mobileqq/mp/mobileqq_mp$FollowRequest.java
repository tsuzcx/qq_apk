package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$FollowRequest
  extends MessageMicro
{
  public static final int ACCOUNT_TYPE_FIELD_NUMBER = 3;
  public static final int EXT_FIELD_NUMBER = 2;
  public static final int LUIN_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uin", "ext", "account_type", "luin" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L) }, FollowRequest.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBStringField ext = PBField.initString("");
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest
 * JD-Core Version:    0.7.0.1
 */