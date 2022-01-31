package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

public final class NearHornPb$SosoWifi
  extends MessageMicro
{
  public static final int MAC_FIELD_NUMBER = 1;
  public static final int RSSI_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "mac", "rssi" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, SosoWifi.class);
  public final PBInt64Field mac = PBField.initInt64(0L);
  public final PBInt32Field rssi = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.SosoWifi
 * JD-Core Version:    0.7.0.1
 */