package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class NearHornPb$GPSInfo
  extends MessageMicro
{
  public static final int ALT_FIELD_NUMBER = 3;
  public static final int ETYPE_FIELD_NUMBER = 4;
  public static final int LAT_FIELD_NUMBER = 1;
  public static final int LON_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "lat", "lon", "alt", "eType" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GPSInfo.class);
  public final PBInt32Field alt = PBField.initInt32(0);
  public final PBEnumField eType = PBField.initEnum(0);
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lon = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.GPSInfo
 * JD-Core Version:    0.7.0.1
 */