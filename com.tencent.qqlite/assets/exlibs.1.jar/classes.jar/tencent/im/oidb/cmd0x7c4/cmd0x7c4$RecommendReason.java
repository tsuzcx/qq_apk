package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x7c4$RecommendReason
  extends MessageMicro
{
  public static final int BYTES_RECOMMEND_REASON_FIELD_NUMBER = 2;
  public static final int UINT32_REASON_ID_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_reason_id", "bytes_recommend_reason" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RecommendReason.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7c4.cmd0x7c4.RecommendReason
 * JD-Core Version:    0.7.0.1
 */