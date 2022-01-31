package com.tencent.proto.lbsshare;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class LBSShare$POI
  extends MessageMicro
{
  public static final int ADDR_FIELD_NUMBER = 2;
  public static final int COORDINATE_FIELD_NUMBER = 6;
  public static final int DPID_FIELD_NUMBER = 9;
  public static final int ID_FIELD_NUMBER = 7;
  public static final int LAT_FIELD_NUMBER = 4;
  public static final int LNG_FIELD_NUMBER = 5;
  public static final int NAME_FIELD_NUMBER = 1;
  public static final int SHOP_URL_FIELD_NUMBER = 3;
  public static final int SHOP_URL_QUAN_FIELD_NUMBER = 8;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 66, 74 }, new String[] { "name", "addr", "shop_url", "lat", "lng", "coordinate", "id", "shop_url_quan", "dpid" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, POI.class);
  public final PBStringField addr = PBField.initString("");
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public final PBStringField dpid = PBField.initString("");
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field lat = PBField.initUInt32(0);
  public final PBUInt32Field lng = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField shop_url = PBField.initString("");
  public final PBStringField shop_url_quan = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.proto.lbsshare.LBSShare.POI
 * JD-Core Version:    0.7.0.1
 */