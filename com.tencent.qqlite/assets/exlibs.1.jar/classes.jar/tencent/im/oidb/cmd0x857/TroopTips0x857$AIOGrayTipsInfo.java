package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TroopTips0x857$AIOGrayTipsInfo
  extends MessageMicro
{
  public static final int OPT_BYTES_CONTENT_FIELD_NUMBER = 2;
  public static final int OPT_UINT32_SHOW_LASTEST_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField opt_bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field opt_uint32_show_lastest = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "opt_uint32_show_lastest", "opt_bytes_content" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, AIOGrayTipsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo
 * JD-Core Version:    0.7.0.1
 */