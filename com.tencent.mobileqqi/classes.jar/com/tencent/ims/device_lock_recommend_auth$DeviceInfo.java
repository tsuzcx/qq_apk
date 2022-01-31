package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class device_lock_recommend_auth$DeviceInfo
  extends MessageMicro
{
  public static final int BYTES_APPNAME_FIELD_NUMBER = 6;
  public static final int BYTES_DEVICE_NAME_FIELD_NUMBER = 1;
  public static final int BYTES_DEVICE_TYPEINFO_FIELD_NUMBER = 2;
  public static final int BYTES_GUID_FIELD_NUMBER = 3;
  public static final int UINT32_APPID_FIELD_NUMBER = 4;
  public static final int UINT32_AUTH_STATUS_FIELD_NUMBER = 7;
  public static final int UINT32_SUBAPPID_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_typeinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auth_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 50, 56 }, new String[] { "bytes_device_name", "bytes_device_typeinfo", "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "uint32_auth_status" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0) }, DeviceInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.ims.device_lock_recommend_auth.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */