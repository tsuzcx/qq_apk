package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SetFunctionFlagRequset
  extends MessageMicro
{
  public static final int ACCOUNT_TYPE_FIELD_NUMBER = 4;
  public static final int LUIN_FIELD_NUMBER = 5;
  public static final int TYPE_FIELD_NUMBER = 2;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int VALUE_FIELD_NUMBER = 3;
  public static final int VERSION_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "uin", "type", "value", "account_type", "luin", "version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, SetFunctionFlagRequset.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt32Field uin = PBField.initUInt32(0);
  public final PBUInt32Field value = PBField.initUInt32(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset
 * JD-Core Version:    0.7.0.1
 */