package face.qqlogin;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class FaceSecureCheck
{
  public static final class SecureCheckRequest
    extends MessageMicro<SecureCheckRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_client_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_guid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_client_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_nonce = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56, 64 }, new String[] { "uint32_timestamp", "uint32_seq", "uint32_client_addr", "bytes_client_addr", "uint32_version", "bytes_guid", "uint64_appid", "uint64_nonce" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L) }, SecureCheckRequest.class);
    }
  }
  
  public static final class SecureCheckResponse
    extends MessageMicro<SecureCheckResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 50 }, new String[] { "uint32_errcode", "str_err_msg", "uint32_seq", "bool_sec_pass", "str_openid", "str_tmpkey" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Boolean.valueOf(false), "", "" }, SecureCheckResponse.class);
    public final PBBoolField bool_sec_pass = PBField.initBool(false);
    public final PBStringField str_err_msg = PBField.initString("");
    public final PBStringField str_openid = PBField.initString("");
    public final PBStringField str_tmpkey = PBField.initString("");
    public final PBUInt32Field uint32_errcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     face.qqlogin.FaceSecureCheck
 * JD-Core Version:    0.7.0.1
 */