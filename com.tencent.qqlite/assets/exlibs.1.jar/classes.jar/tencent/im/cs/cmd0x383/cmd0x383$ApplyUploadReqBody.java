package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyUploadReqBody
  extends MessageMicro
{
  public static final int BYTES_MD5_FIELD_NUMBER = 9;
  public static final int BYTES_SHA3_FIELD_NUMBER = 8;
  public static final int BYTES_SHA_FIELD_NUMBER = 7;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 4;
  public static final int STR_FILE_PATH_FIELD_NUMBER = 3;
  public static final int STR_LOCAL_PATH_FIELD_NUMBER = 5;
  public static final int UINT32_BUS_ID_FIELD_NUMBER = 1;
  public static final int UINT32_OPER_TYPE_FIELD_NUMBER = 2;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 6;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBStringField str_file_path = PBField.initString("");
  public final PBStringField str_local_path = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 74 }, new String[] { "uint32_bus_id", "uint32_oper_type", "str_file_path", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ApplyUploadReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyUploadReqBody
 * JD-Core Version:    0.7.0.1
 */