package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346$ExtensionReq
  extends MessageMicro
{
  public static final int BYTES_SIG_FIELD_NUMBER = 20;
  public static final int MSG_DEL_MESSAGE_REQ_FIELD_NUMBER = 90100;
  public static final int STR_DST_PHONENUM_FIELD_NUMBER = 3;
  public static final int UINT64_ID_FIELD_NUMBER = 1;
  public static final int UINT64_ROUTE_ID_FIELD_NUMBER = 100;
  public static final int UINT64_TYPE_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public cmd0x346.DelMessageReq msg_del_message_req = new cmd0x346.DelMessageReq();
  public final PBStringField str_dst_phonenum = PBField.initString("");
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_route_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 162, 800, 720802 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "bytes_sig", "uint64_route_id", "msg_del_message_req" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, Long.valueOf(0L), null }, ExtensionReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ExtensionReq
 * JD-Core Version:    0.7.0.1
 */