package localpb.dataline;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class DatalineMsgData$MsgData
  extends MessageMicro
{
  public static final int BYTES_TOKENKEY_FIELD_NUMBER = 13;
  public static final int BYTES_URL_NOTIFY_FIELD_NUMBER = 12;
  public static final int FIXED32_IP_FIELD_NUMBER = 10;
  public static final int STR_MOLOICONURL_FIELD_NUMBER = 5;
  public static final int STR_MOLOKEY_FIELD_NUMBER = 4;
  public static final int STR_MOLOSOURCE_FIELD_NUMBER = 6;
  public static final int STR_MOLOSRCURL_FIELD_NUMBER = 7;
  public static final int STR_MSG_FIELD_NUMBER = 1;
  public static final int STR_RESERVE1_FIELD_NUMBER = 8;
  public static final int UINT32_ISAPKFILE_FIELD_NUMBER = 9;
  public static final int UINT32_ISMOLOIMAGE_FIELD_NUMBER = 14;
  public static final int UINT32_PORT_FIELD_NUMBER = 11;
  public static final int UINT64_FILEMSGSTATUS_FIELD_NUMBER = 2;
  public static final int UINT64_WEIYUNSESSIONID_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tokenkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
  public final PBStringField str_moloiconurl = PBField.initString("");
  public final PBStringField str_molokey = PBField.initString("");
  public final PBStringField str_molosource = PBField.initString("");
  public final PBStringField str_molosrcurl = PBField.initString("");
  public final PBStringField str_msg = PBField.initString("");
  public final PBStringField str_reserve1 = PBField.initString("");
  public final PBUInt32Field uint32_isapkfile = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ismoloimage = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_filemsgstatus = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_weiyunsessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 72, 85, 88, 98, 106, 112 }, new String[] { "str_msg", "uint64_filemsgstatus", "uint64_weiyunsessionid", "str_molokey", "str_moloiconurl", "str_molosource", "str_molosrcurl", "str_reserve1", "uint32_isapkfile", "fixed32_ip", "uint32_port", "bytes_url_notify", "bytes_tokenkey", "uint32_ismoloimage" }, new Object[] { "", Long.valueOf(0L), Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, MsgData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.dataline.DatalineMsgData.MsgData
 * JD-Core Version:    0.7.0.1
 */