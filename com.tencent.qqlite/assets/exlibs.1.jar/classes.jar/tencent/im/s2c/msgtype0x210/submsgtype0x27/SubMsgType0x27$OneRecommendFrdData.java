package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x27$OneRecommendFrdData
  extends MessageMicro
{
  public static final int BYTES_NICK_NAME_FIELD_NUMBER = 3;
  public static final int BYTES_TELNO_FIELD_NUMBER = 2;
  public static final int BYTES_WORDING_FIELD_NUMBER = 4;
  public static final int UINT32_SRC_ID_FIELD_NUMBER = 6;
  public static final int UINT32_SUB_SRC_ID_FIELD_NUMBER = 7;
  public static final int UINT64_BIND_QQ_FIELD_NUMBER = 5;
  public static final int UINT64_FRD_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_telno = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_src_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sub_src_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_bind_qq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_frd_id = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 48, 56 }, new String[] { "uint64_frd_id", "bytes_telno", "bytes_nick_name", "bytes_wording", "uint64_bind_qq", "uint32_src_id", "uint32_sub_src_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, OneRecommendFrdData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.OneRecommendFrdData
 * JD-Core Version:    0.7.0.1
 */