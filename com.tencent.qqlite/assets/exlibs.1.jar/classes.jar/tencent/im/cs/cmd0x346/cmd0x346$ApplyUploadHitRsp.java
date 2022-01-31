package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ApplyUploadHitRsp
  extends MessageMicro
{
  public static final int BYTES_UPLOAD_KEY_FIELD_NUMBER = 70;
  public static final int BYTES_UUID_FIELD_NUMBER = 60;
  public static final int INT32_RET_CODE_FIELD_NUMBER = 10;
  public static final int STR_RET_MSG_FIELD_NUMBER = 20;
  public static final int STR_UPLOAD_DOMAIN_FIELD_NUMBER = 50;
  public static final int STR_UPLOAD_IP_FIELD_NUMBER = 30;
  public static final int UINT32_UPLOAD_PORT_FIELD_NUMBER = 40;
  public static final int UINT64_TOTAL_SPACE_FIELD_NUMBER = 80;
  public static final int UINT64_USED_SPACE_FIELD_NUMBER = 90;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public final PBStringField str_ret_msg = PBField.initString("");
  public final PBStringField str_upload_domain = PBField.initString("");
  public final PBStringField str_upload_ip = PBField.initString("");
  public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320, 402, 482, 562, 640, 720 }, new String[] { "int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L) }, ApplyUploadHitRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ApplyUploadHitRsp
 * JD-Core Version:    0.7.0.1
 */