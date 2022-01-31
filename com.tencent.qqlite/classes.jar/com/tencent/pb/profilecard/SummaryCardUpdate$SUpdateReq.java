package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SummaryCardUpdate$SUpdateReq
  extends MessageMicro
{
  public static final int CLIENT_VERSION_FIELD_NUMBER = 4;
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int PLATFORM_FIELD_NUMBER = 5;
  public static final int UIN_FIELD_NUMBER = 2;
  public static final int VERSION_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "cmd", "uin", "version", "client_version", "platform" }, new Object[] { Integer.valueOf(3), Long.valueOf(0L), "", "4.7.0", Integer.valueOf(0) }, SUpdateReq.class);
  public final PBStringField client_version = PBField.initString("4.7.0");
  public final PBEnumField cmd = PBField.initEnum(3);
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateReq
 * JD-Core Version:    0.7.0.1
 */