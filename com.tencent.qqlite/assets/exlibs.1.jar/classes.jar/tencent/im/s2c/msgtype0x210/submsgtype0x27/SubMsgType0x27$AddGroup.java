package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$AddGroup
  extends MessageMicro
{
  public static final int BYTES_GROUPNAME_FIELD_NUMBER = 3;
  public static final int UINT32_GROUPID_FIELD_NUMBER = 1;
  public static final int UINT32_SORTID_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_groupname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sortid = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_groupid", "uint32_sortid", "bytes_groupname" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, AddGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup
 * JD-Core Version:    0.7.0.1
 */