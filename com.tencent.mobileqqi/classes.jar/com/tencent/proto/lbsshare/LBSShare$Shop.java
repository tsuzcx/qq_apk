package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$Shop
  extends MessageMicro
{
  public static final int DETAIL_FIELD_NUMBER = 5;
  public static final int DISCOUNT_FIELD_NUMBER = 6;
  public static final int HAS_QUAN_FIELD_NUMBER = 10;
  public static final int HAS_TUAN_FIELD_NUMBER = 9;
  public static final int ID_FIELD_NUMBER = 1;
  public static final int LOGO_FIELD_NUMBER = 3;
  public static final int NAME_FIELD_NUMBER = 2;
  public static final int PRICE_FIELD_NUMBER = 7;
  public static final int SOLDNUM_FIELD_NUMBER = 8;
  public static final int URL_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 72, 80 }, new String[] { "id", "name", "logo", "url", "detail", "discount", "price", "soldnum", "has_tuan", "has_quan" }, new Object[] { "", "", "", "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0) }, Shop.class);
  public final PBStringField detail = PBField.initString("");
  public final PBStringField discount = PBField.initString("");
  public final PBUInt32Field has_quan = PBField.initUInt32(0);
  public final PBUInt32Field has_tuan = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBStringField price = PBField.initString("");
  public final PBStringField soldnum = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.Shop
 * JD-Core Version:    0.7.0.1
 */