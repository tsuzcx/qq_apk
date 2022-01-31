package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class VoipReportIP$SendUinInfoReq
  extends MessageMicro
{
  public static final int MIP_FIELD_NUMBER = 3;
  public static final int MISBINDCONTACT_FIELD_NUMBER = 4;
  public static final int MLANG_FIELD_NUMBER = 2;
  public static final int MUIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "mUin", "mLang", "mIp", "mIsBindContact" }, new Object[] { Long.valueOf(0L), "", "", Integer.valueOf(0) }, SendUinInfoReq.class);
  public final PBStringField mIp = PBField.initString("");
  public final PBInt32Field mIsBindContact = PBField.initInt32(0);
  public final PBStringField mLang = PBField.initString("");
  public final PBInt64Field mUin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipReportIP.SendUinInfoReq
 * JD-Core Version:    0.7.0.1
 */