package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class VoipReportIP$SendUinInfoRes
  extends MessageMicro
{
  public static final int MCOUNTRYCODE_FIELD_NUMBER = 2;
  public static final int MERRORCODE_FIELD_NUMBER = 3;
  public static final int MUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "mUin", "mCountryCode", "mErrorCode" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SendUinInfoRes.class);
  public final PBInt32Field mCountryCode = PBField.initInt32(0);
  public final PBInt32Field mErrorCode = PBField.initInt32(0);
  public final PBInt64Field mUin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipReportIP.SendUinInfoRes
 * JD-Core Version:    0.7.0.1
 */