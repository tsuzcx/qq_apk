package tencent.im.secretfile;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QQService$SecretFileInfo
  extends MessageMicro
{
  public static final int BYTES_VUUID_FIELD_NUMBER = 1;
  public static final int STR_FROMPHONENUM_FIELD_NUMBER = 9;
  public static final int STR_TOPHONENUM_FIELD_NUMBER = 10;
  public static final int UINT32_FILETYPE_FIELD_NUMBER = 8;
  public static final int UINT32_STARTTIME_FIELD_NUMBER = 5;
  public static final int UINT32_STATE_FIELD_NUMBER = 4;
  public static final int UINT32_VALIDTIMES_FIELD_NUMBER = 6;
  public static final int UINT32_WATCHTIMES_FIELD_NUMBER = 7;
  public static final int UINT64_FROMUIN_FIELD_NUMBER = 2;
  public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_vUuid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_fromphonenum = PBField.initString("");
  public final PBStringField str_tophonenum = PBField.initString("");
  public final PBUInt32Field uint32_State = PBField.initUInt32(0);
  public final PBUInt32Field uint32_fileType = PBField.initUInt32(0);
  public final PBUInt32Field uint32_startTime = PBField.initUInt32(0);
  public final PBUInt32Field uint32_validTimes = PBField.initUInt32(0);
  public final PBUInt32Field uint32_watchTimes = PBField.initUInt32(0);
  public final PBUInt64Field uint64_fromUin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_toUin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56, 64, 74, 82 }, new String[] { "bytes_vUuid", "uint64_fromUin", "uint64_toUin", "uint32_State", "uint32_startTime", "uint32_validTimes", "uint32_watchTimes", "uint32_fileType", "str_fromphonenum", "str_tophonenum" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "" }, SecretFileInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.secretfile.QQService.SecretFileInfo
 * JD-Core Version:    0.7.0.1
 */