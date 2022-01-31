package tencent.im.s2c.msgtype0x210.submsgtype0x65;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x65$MsgExpiredPkg
  extends MessageMicro
{
  public static final int STR_EXPIRE_PKG_FIELD_NUMBER = 2;
  public static final int UINT32_PLATFORM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField str_expire_pkg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_platform", "str_expire_pkg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, MsgExpiredPkg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x65.SubMsgType0x65.MsgExpiredPkg
 * JD-Core Version:    0.7.0.1
 */