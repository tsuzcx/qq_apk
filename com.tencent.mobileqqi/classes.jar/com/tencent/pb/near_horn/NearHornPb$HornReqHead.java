package com.tencent.pb.near_horn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NearHornPb$HornReqHead
  extends MessageMicro
{
  public static final int CELLS_FIELD_NUMBER = 7;
  public static final int CLIENT_PLAT_ID_FIELD_NUMBER = 2;
  public static final int CLIENT_VER_FIELD_NUMBER = 3;
  public static final int GPS_FIELD_NUMBER = 6;
  public static final int OS_VER_FIELD_NUMBER = 4;
  public static final int PROTOCOL_VER_FIELD_NUMBER = 1;
  public static final int UIN_FIELD_NUMBER = 5;
  public static final int WIFIS_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66 }, new String[] { "protocol_ver", "client_plat_id", "client_ver", "os_ver", "uin", "gps", "cells", "wifis" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), null, null, null }, HornReqHead.class);
  public final PBRepeatMessageField cells = PBField.initRepeatMessage(NearHornPb.SosoCell.class);
  public final PBInt32Field client_plat_id = PBField.initInt32(0);
  public final PBStringField client_ver = PBField.initString("");
  public NearHornPb.GPSInfo gps = new NearHornPb.GPSInfo();
  public final PBStringField os_ver = PBField.initString("");
  public final PBInt32Field protocol_ver = PBField.initInt32(0);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField wifis = PBField.initRepeatMessage(NearHornPb.SosoWifi.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.pb.near_horn.NearHornPb.HornReqHead
 * JD-Core Version:    0.7.0.1
 */