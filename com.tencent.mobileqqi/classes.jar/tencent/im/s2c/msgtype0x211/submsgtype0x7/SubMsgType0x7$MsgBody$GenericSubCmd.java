package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x7$MsgBody$GenericSubCmd
  extends MessageMicro
{
  public static final int BYTES_BUF_FIELD_NUMBER = 5;
  public static final int UINT32_INDEX_FIELD_NUMBER = 3;
  public static final int UINT32_SIZE_FIELD_NUMBER = 2;
  public static final int UINT32_TYPE_FIELD_NUMBER = 4;
  public static final int UINT64_SESSIONID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_sessionid", "uint32_size", "uint32_index", "uint32_type", "bytes_buf" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, GenericSubCmd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.GenericSubCmd
 * JD-Core Version:    0.7.0.1
 */