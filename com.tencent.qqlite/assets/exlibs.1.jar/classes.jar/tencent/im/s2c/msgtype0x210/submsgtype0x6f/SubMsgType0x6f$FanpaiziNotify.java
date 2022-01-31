package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$FanpaiziNotify
  extends MessageMicro
{
  public static final int BYTES_SIG_FIELD_NUMBER = 4;
  public static final int BYTES_TIPS_CONTENT_FIELD_NUMBER = 3;
  public static final int STR_FROM_NICK_FIELD_NUMBER = 2;
  public static final int UINT64_FROM_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_from_nick = PBField.initString("");
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint64_from_uin", "str_from_nick", "bytes_tips_content", "bytes_sig" }, new Object[] { Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2 }, FanpaiziNotify.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.FanpaiziNotify
 * JD-Core Version:    0.7.0.1
 */