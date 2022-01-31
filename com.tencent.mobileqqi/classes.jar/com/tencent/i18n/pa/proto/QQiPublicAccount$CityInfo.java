package com.tencent.i18n.pa.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QQiPublicAccount$CityInfo
  extends MessageMicro
{
  public static final int ADMIN_AREA_FIELD_NUMBER = 2;
  public static final int COUNTRY_FIELD_NUMBER = 1;
  public static final int SUB_ADMIN_AREA_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "country", "admin_area", "sub_admin_area" }, new Object[] { "", "", "" }, CityInfo.class);
  public final PBStringField admin_area = PBField.initString("");
  public final PBStringField country = PBField.initString("");
  public final PBStringField sub_admin_area = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.i18n.pa.proto.QQiPublicAccount.CityInfo
 * JD-Core Version:    0.7.0.1
 */