package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyUploadRsp
  extends MessageMicro
{
  public static final int BOOL_FILE_EXIST_FIELD_NUMBER = 110;
  public static final int BYTES_UPLOAD_KEY_FIELD_NUMBER = 100;
  public static final int BYTES_UUID_FIELD_NUMBER = 90;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int RPT_STR_UPLOADIP_LIST_FIELD_NUMBER = 130;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  public static final int STR_UPLOAD_DOMAIN_FIELD_NUMBER = 70;
  public static final int STR_UPLOAD_IP_FIELD_NUMBER = 60;
  public static final int UINT32_PACK_SIZE_FIELD_NUMBER = 120;
  public static final int UINT32_UPLOAD_PORT_FIELD_NUMBER = 80;
  public static final int UINT64_TOTAL_SPACE_FIELD_NUMBER = 30;
  public static final int UINT64_UPLOADED_SIZE_FIELD_NUMBER = 50;
  public static final int UINT64_USED_SPACE_FIELD_NUMBER = 40;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_file_exist = PBField.initBool(false);
  public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBRepeatField rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_upload_domain = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 482, 562, 640, 722, 802, 880, 960, 1042 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), "" }, ApplyUploadRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadRsp
 * JD-Core Version:    0.7.0.1
 */