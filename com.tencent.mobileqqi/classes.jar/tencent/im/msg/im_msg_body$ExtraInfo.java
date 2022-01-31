package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class im_msg_body$ExtraInfo
  extends MessageMicro
{
  public static final int BYTES_GROUP_CARD_FIELD_NUMBER = 2;
  public static final int BYTES_NICK_FIELD_NUMBER = 1;
  public static final int UINT32_FLAGS_FIELD_NUMBER = 4;
  public static final int UINT32_LEVEL_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_flags = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "bytes_nick", "bytes_group_card", "uint32_level", "uint32_flags" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ExtraInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.ExtraInfo
 * JD-Core Version:    0.7.0.1
 */