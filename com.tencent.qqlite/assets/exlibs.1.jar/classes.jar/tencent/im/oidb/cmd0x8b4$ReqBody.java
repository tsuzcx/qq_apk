package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x8b4$ReqBody
  extends MessageMicro
{
  public static final int BYTES_TAG_FIELD_NUMBER = 24;
  public static final int UINT32_CNT_FIELD_NUMBER = 23;
  public static final int UINT32_FLAG_FIELD_NUMBER = 3;
  public static final int UINT32_START_FIELD_NUMBER = 22;
  public static final int UINT64_DST_UIN_FIELD_NUMBER = 21;
  public static final int UINT64_GC_FIELD_NUMBER = 1;
  public static final int UINT64_GUIN_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_tag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_gc = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_guin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 168, 176, 184, 194 }, new String[] { "uint64_gc", "uint64_guin", "uint32_flag", "uint64_dst_uin", "uint32_start", "uint32_cnt", "bytes_tag" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8b4.ReqBody
 * JD-Core Version:    0.7.0.1
 */