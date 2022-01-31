package tencent.im.cs.cmd0x352;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x352$GetImgUrlReq
  extends MessageMicro
{
  public static final int BOOL_ADDRESS_BOOK_FIELD_NUMBER = 11;
  public static final int BYTES_BUILD_VER_FIELD_NUMBER = 13;
  public static final int BYTES_FILE_RESID_FIELD_NUMBER = 3;
  public static final int UINT32_BU_TYPE_FIELD_NUMBER = 12;
  public static final int UINT32_INNER_IP_FIELD_NUMBER = 10;
  public static final int UINT32_REQ_PLATFORM_TYPE_FIELD_NUMBER = 8;
  public static final int UINT32_REQ_TERM_FIELD_NUMBER = 7;
  public static final int UINT32_SRC_FILE_TYPE_FIELD_NUMBER = 9;
  public static final int UINT32_URL_FLAG_FIELD_NUMBER = 4;
  public static final int UINT32_URL_TYPE_FIELD_NUMBER = 6;
  public static final int UINT64_DST_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_SRC_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_address_book = PBField.initBool(false);
  public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_resid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_bu_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_platform_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_term = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 48, 56, 64, 72, 80, 88, 96, 106 }, new String[] { "uint64_src_uin", "uint64_dst_uin", "bytes_file_resid", "uint32_url_flag", "uint32_url_type", "uint32_req_term", "uint32_req_platform_type", "uint32_src_file_type", "uint32_inner_ip", "bool_address_book", "uint32_bu_type", "bytes_build_ver" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), localByteStringMicro2 }, GetImgUrlReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x352.cmd0x352.GetImgUrlReq
 * JD-Core Version:    0.7.0.1
 */