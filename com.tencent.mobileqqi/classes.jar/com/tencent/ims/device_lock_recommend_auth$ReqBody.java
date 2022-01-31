package com.tencent.ims;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class device_lock_recommend_auth$ReqBody
  extends MessageMicro
{
  public static final int BYTES_APPNAME_FIELD_NUMBER = 5;
  public static final int BYTES_GUID_FIELD_NUMBER = 2;
  public static final int UINT32_APPID_FIELD_NUMBER = 3;
  public static final int UINT32_SEQ_FIELD_NUMBER = 6;
  public static final int UINT32_SUBAPPID_FIELD_NUMBER = 4;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subappid = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "uint64_uin", "bytes_guid", "uint32_appid", "uint32_subappid", "bytes_appname", "uint32_seq" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.ims.device_lock_recommend_auth.ReqBody
 * JD-Core Version:    0.7.0.1
 */