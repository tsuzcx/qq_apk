package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardUpdate$SUpdateRsp
  extends MessageMicro
{
  public static final int CMD_FIELD_NUMBER = 1;
  public static final int CODE_FIELD_NUMBER = 2;
  public static final int INTERV_FIELD_NUMBER = 5;
  public static final int URL_FIELD_NUMBER = 4;
  public static final int VERSION_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40 }, new String[] { "cmd", "code", "version", "url", "interv" }, new Object[] { Integer.valueOf(3), Integer.valueOf(0), "", "", Integer.valueOf(0) }, SUpdateRsp.class);
  public final PBEnumField cmd = PBField.initEnum(3);
  public final PBUInt32Field code = PBField.initUInt32(0);
  public final PBUInt32Field interv = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardUpdate.SUpdateRsp
 * JD-Core Version:    0.7.0.1
 */