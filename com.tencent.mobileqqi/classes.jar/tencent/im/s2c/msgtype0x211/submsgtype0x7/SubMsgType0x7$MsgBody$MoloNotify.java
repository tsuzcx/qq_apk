package tencent.im.s2c.msgtype0x211.submsgtype0x7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x7$MsgBody$MoloNotify
  extends MessageMicro
{
  public static final int BYTES_BUF_FIELD_NUMBER = 1;
  public static final int UINT32_GROUP_CURINDEX_FIELD_NUMBER = 4;
  public static final int UINT32_GROUP_ID_FIELD_NUMBER = 2;
  public static final int UINT32_GROUP_SIZE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_buf = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_group_curindex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_size = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_buf", "uint32_group_id", "uint32_group_size", "uint32_group_curindex" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MoloNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7.MsgBody.MoloNotify
 * JD-Core Version:    0.7.0.1
 */