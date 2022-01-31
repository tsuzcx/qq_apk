package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$RNFCNotify
  extends MessageMicro
{
  public static final int BYTES_TOKENKEY_FIELD_NUMBER = 7;
  public static final int BYTES_TOKEN_ORIGINAL_FIELD_NUMBER = 5;
  public static final int BYTES_URL_NOTIFY_FIELD_NUMBER = 6;
  public static final int BYTES_URL_NOTIFY_ORIGINAL_FIELD_NUMBER = 4;
  public static final int FIXED32_IP_FIELD_NUMBER = 2;
  public static final int UINT32_PORT_FIELD_NUMBER = 3;
  public static final int UINT64_FILE_LEN_FIELD_NUMBER = 8;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_token_original = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tokenkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_notify_original = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_len = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 21, 24, 34, 42, 50, 58, 64 }, new String[] { "uint64_sessionid", "fixed32_ip", "uint32_port", "bytes_url_notify_original", "bytes_token_original", "bytes_url_notify", "bytes_tokenkey", "uint64_file_len" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L) }, RNFCNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.RNFCNotify
 * JD-Core Version:    0.7.0.1
 */