package tencent.im.s2c.msgtype0x211.submsgtype0x8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class C2CType0x211_SubC2CType0x8$GPS
  extends MessageMicro
{
  public static final int ETYPE_FIELD_NUMBER = 4;
  public static final int INT32_ALT_FIELD_NUMBER = 3;
  public static final int INT32_LAT_FIELD_NUMBER = 1;
  public static final int INT32_LON_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "int32_lat", "int32_lon", "int32_alt", "eType" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(-10000000), Integer.valueOf(0) }, GPS.class);
  public final PBEnumField eType = PBField.initEnum(0);
  public final PBInt32Field int32_alt = PBField.initInt32(-10000000);
  public final PBInt32Field int32_lat = PBField.initInt32(900000000);
  public final PBInt32Field int32_lon = PBField.initInt32(900000000);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x8.C2CType0x211_SubC2CType0x8.GPS
 * JD-Core Version:    0.7.0.1
 */