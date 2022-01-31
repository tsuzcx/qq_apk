package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;

public final class QQiPublicAccount$Position
  extends MessageMicro
{
  public static final int LATITUDE_FIELD_NUMBER = 2;
  public static final int LONGITUDE_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 9, 17 }, new String[] { "longitude", "latitude" }, new Object[] { Double.valueOf(0.0D), Double.valueOf(0.0D) }, Position.class);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.Position
 * JD-Core Version:    0.7.0.1
 */