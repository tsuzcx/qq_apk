package tencent.im.longconn.longmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class LongMsg$MsgUpReq
  extends MessageMicro
{
  public static final int BYTES_MSG_CONTENT_FIELD_NUMBER = 4;
  public static final int BYTES_MSG_UKEY_FIELD_NUMBER = 6;
  public static final int UINT32_MSG_ID_FIELD_NUMBER = 3;
  public static final int UINT32_MSG_TYPE_FIELD_NUMBER = 1;
  public static final int UINT32_STORE_TYPE_FIELD_NUMBER = 5;
  public static final int UINT64_DST_UIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_msg_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_msg_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_msg_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_store_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "uint32_msg_type", "uint64_dst_uin", "uint32_msg_id", "bytes_msg_content", "uint32_store_type", "bytes_msg_ukey" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, MsgUpReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.longconn.longmsg.LongMsg.MsgUpReq
 * JD-Core Version:    0.7.0.1
 */