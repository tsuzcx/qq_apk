package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyFileSearchReqBody
  extends MessageMicro
{
  public static final int AUDIO = 3;
  public static final int DOCUMENT = 1;
  public static final int OTHER = 10000;
  public static final int PICTURE = 4;
  public static final int SEARCH_BY_FILE_TYPE = 2;
  public static final int SEARCH_BY_KEY_WORD = 0;
  public static final int VIDEO = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_key_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_search_type = PBField.initUInt32(0);
  public final PBRepeatField uint64_group_code_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 80, 88 }, new String[] { "uint64_group_code_list", "uint64_uin_list", "bytes_key_word", "bytes_sync_cookie", "uint32_count", "uint32_search_type", "uint32_file_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyFileSearchReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFileSearchReqBody
 * JD-Core Version:    0.7.0.1
 */