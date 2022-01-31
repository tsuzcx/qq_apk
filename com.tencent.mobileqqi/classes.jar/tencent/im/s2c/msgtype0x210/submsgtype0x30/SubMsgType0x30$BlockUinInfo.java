package tencent.im.s2c.msgtype0x210.submsgtype0x30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x30$BlockUinInfo
  extends MessageMicro
{
  public static final int UINT32_SOURCE_ID_FIELD_NUMBER = 2;
  public static final int UINT32_SOURCE_SUB_ID_FIELD_NUMBER = 3;
  public static final int UINT64_BLOCK_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_block_uin", "uint32_source_id", "uint32_source_sub_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, BlockUinInfo.class);
  public final PBUInt32Field uint32_source_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_sub_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x30.SubMsgType0x30.BlockUinInfo
 * JD-Core Version:    0.7.0.1
 */