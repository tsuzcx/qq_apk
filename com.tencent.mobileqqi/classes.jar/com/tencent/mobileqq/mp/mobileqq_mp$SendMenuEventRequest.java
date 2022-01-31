package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SendMenuEventRequest
  extends MessageMicro
{
  public static final int CLICK = 1;
  public static final int EVENT = 3;
  public static final int IS_NEED_LBS_FIELD_NUMBER = 4;
  public static final int KEY_FIELD_NUMBER = 2;
  public static final int LATITUDE_FIELD_NUMBER = 5;
  public static final int LONGITUDE_FIELD_NUMBER = 6;
  public static final int LUIN_FIELD_NUMBER = 7;
  public static final int TYPE_FIELD_NUMBER = 3;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int URL = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 41, 49, 56 }, new String[] { "uin", "key", "type", "is_need_lbs", "latitude", "longitude", "luin" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(1), Boolean.valueOf(false), Double.valueOf(0.0D), Double.valueOf(0.0D), Long.valueOf(0L) }, SendMenuEventRequest.class);
  public final PBBoolField is_need_lbs = PBField.initBool(false);
  public final PBStringField key = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBUInt64Field luin = PBField.initUInt64(0L);
  public final PBEnumField type = PBField.initEnum(1);
  public final PBUInt32Field uin = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SendMenuEventRequest
 * JD-Core Version:    0.7.0.1
 */