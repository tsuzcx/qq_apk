package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$NFCNotify
  extends MessageMicro
{
  public static final int BYTES_FILE_MD5_FIELD_NUMBER = 3;
  public static final int BYTES_ORIGINFILE_MD5_FIELD_NUMBER = 9;
  public static final int BYTES_TOKENKEY_FIELD_NUMBER = 7;
  public static final int BYTES_URL_NOTIFY_FIELD_NUMBER = 6;
  public static final int FIXED32_IP_FIELD_NUMBER = 4;
  public static final int MSG_ACTIONINFO_FIELD_NUMBER = 20;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
  public static final int UINT32_BATCHID_FIELD_NUMBER = 21;
  public static final int UINT32_GROUPFLAG_FIELD_NUMBER = 22;
  public static final int UINT32_GROUP_CURINDEX_FIELD_NUMBER = 13;
  public static final int UINT32_GROUP_ID_FIELD_NUMBER = 11;
  public static final int UINT32_GROUP_SIZE_FIELD_NUMBER = 12;
  public static final int UINT32_ORIGINFILETYPE_FIELD_NUMBER = 10;
  public static final int UINT32_PORT_FIELD_NUMBER = 5;
  public static final int UINT64_FILE_LEN_FIELD_NUMBER = 8;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_originfile_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tokenkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_url_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBFixed32Field fixed32_ip = PBField.initFixed32(0);
  public SubMsgType0x7.MsgBody.ActionInfo msg_ActionInfo = new SubMsgType0x7.MsgBody.ActionInfo();
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_batchID = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_groupflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_originfiletype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_len = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 37, 40, 50, 58, 64, 74, 80, 88, 96, 104, 162, 168, 176 }, new String[] { "uint64_sessionid", "str_file_name", "bytes_file_md5", "fixed32_ip", "uint32_port", "bytes_url_notify", "bytes_tokenkey", "uint64_file_len", "bytes_originfile_md5", "uint32_originfiletype", "uint32_group_id", "uint32_group_size", "uint32_group_curindex", "msg_ActionInfo", "uint32_batchID", "uint32_groupflag" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, NFCNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.NFCNotify
 * JD-Core Version:    0.7.0.1
 */