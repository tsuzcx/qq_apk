package com.tencent.pb.addcontacts;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.RichStatus;

public final class AccountSearchPb$record
  extends MessageMicro
{
  public static final int ACCOUT_FIELD_NUMBER = 7;
  public static final int AGE_FIELD_NUMBER = 6;
  public static final int BRIEF_FIELD_NUMBER = 8;
  public static final int CITY_FIELD_NUMBER = 16;
  public static final int CITY_NAME_FIELD_NUMBER = 21;
  public static final int CLASS_INDEX_FIELD_NUMBER = 17;
  public static final int CLASS_NAME_FIELD_NUMBER = 18;
  public static final int CODE_FIELD_NUMBER = 2;
  public static final int COUNTRY_FIELD_NUMBER = 14;
  public static final int COUNTRY_NAME_FIELD_NUMBER = 19;
  public static final int FLAG_FIELD_NUMBER = 10;
  public static final int MOBILE_FIELD_NUMBER = 12;
  public static final int NAME_FIELD_NUMBER = 4;
  public static final int NUMBER_FIELD_NUMBER = 9;
  public static final int PROVINCE_FIELD_NUMBER = 15;
  public static final int PROVINCE_NAME_FIELD_NUMBER = 20;
  public static final int RELATION_FIELD_NUMBER = 11;
  public static final int SEX_FIELD_NUMBER = 5;
  public static final int SIGN_FIELD_NUMBER = 13;
  public static final int SOURCE_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField accout = PBField.initString("");
  public final PBUInt32Field age = PBField.initUInt32(0);
  public final PBStringField brief = PBField.initString("");
  public final PBUInt32Field city = PBField.initUInt32(0);
  public final PBStringField city_name = PBField.initString("");
  public final PBUInt32Field class_index = PBField.initUInt32(0);
  public final PBStringField class_name = PBField.initString("");
  public final PBUInt64Field code = PBField.initUInt64(0L);
  public final PBUInt32Field country = PBField.initUInt32(0);
  public final PBStringField country_name = PBField.initString("");
  public final PBUInt64Field flag = PBField.initUInt64(0L);
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field number = PBField.initUInt32(0);
  public final PBUInt32Field province = PBField.initUInt32(0);
  public final PBStringField province_name = PBField.initString("");
  public final PBUInt64Field relation = PBField.initUInt64(0L);
  public RichStatus richStatus;
  public final PBUInt32Field sex = PBField.initUInt32(0);
  public final PBBytesField sign = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField source = PBField.initEnum(1);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 66, 72, 80, 88, 98, 106, 112, 120, 128, 136, 146, 154, 162, 170 }, new String[] { "uin", "code", "source", "name", "sex", "age", "accout", "brief", "number", "flag", "relation", "mobile", "sign", "country", "province", "city", "class_index", "class_name", "country_name", "province_name", "city_name" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", "" }, record.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.pb.addcontacts.AccountSearchPb.record
 * JD-Core Version:    0.7.0.1
 */