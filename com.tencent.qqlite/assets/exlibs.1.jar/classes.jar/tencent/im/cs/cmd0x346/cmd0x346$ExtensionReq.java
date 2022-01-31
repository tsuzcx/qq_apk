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

public final class cmd0x346$ExtensionReq
  extends MessageMicro
{
  public static final int BYTES_SIG_FIELD_NUMBER = 20;
  public static final int INT32_PHONE_CONVERT_TYPE_FIELD_NUMBER = 4;
  public static final int MSG_DEL_MESSAGE_REQ_FIELD_NUMBER = 90100;
  public static final int STR_DST_PHONENUM_FIELD_NUMBER = 3;
  public static final int UINT32_DOWNLOAD_URL_TYPE_FIELD_NUMBER = 90200;
  public static final int UINT64_ID_FIELD_NUMBER = 1;
  public static final int UINT64_ROUTE_ID_FIELD_NUMBER = 100;
  public static final int UINT64_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
  public cmd0x346.DelMessageReq msg_del_message_req = new cmd0x346.DelMessageReq();
  public final PBStringField str_dst_phonenum = PBField.initString("");
  public final PBUInt32Field uint32_download_url_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_route_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 800, 720802, 721600 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id", "msg_del_message_req", "uint32_download_url_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null, Integer.valueOf(0) }, ExtensionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq
 * JD-Core Version:    0.7.0.1
 */