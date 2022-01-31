package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyDownloadRspBody
  extends MessageMicro
{
  public static final int BOOL_SAFE_CHECK_FLAG_FIELD_NUMBER = 11;
  public static final int BYTES_COOKIE_VAL_FIELD_NUMBER = 7;
  public static final int BYTES_DOWNLOAD_URL_FIELD_NUMBER = 3;
  public static final int BYTES_MD5_FIELD_NUMBER = 6;
  public static final int BYTES_SHA3_FIELD_NUMBER = 5;
  public static final int BYTES_SHA_FIELD_NUMBER = 4;
  public static final int STR_DOWNLOAD_DNS_FIELD_NUMBER = 2;
  public static final int STR_DOWNLOAD_IP_FIELD_NUMBER = 1;
  public static final int STR_MSG_FIELD_NUMBER = 14;
  public static final int STR_SAVE_FILE_NAME_FIELD_NUMBER = 8;
  public static final int UINT32_PREVIEW_PORT_FIELD_NUMBER = 13;
  public static final int UINT32_SAFE_CHECK_RES_FIELD_NUMBER = 12;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBBytesField bytes_cookie_val = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_download_dns = PBField.initString("");
  public final PBStringField str_download_ip = PBField.initString("");
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_save_file_name = PBField.initString("");
  public final PBUInt32Field uint32_preview_port = PBField.initUInt32(0);
  public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 88, 96, 104, 114 }, new String[] { "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_preview_port", "str_msg" }, new Object[] { "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, "", Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "" }, ApplyDownloadRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyDownloadRspBody
 * JD-Core Version:    0.7.0.1
 */