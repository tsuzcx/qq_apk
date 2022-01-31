package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class obj_msg$MsgContentInfo$MsgFile
  extends MessageMicro
{
  public static final int BYTES_FILE_PATH_FIELD_NUMBER = 2;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 4;
  public static final int UINT32_BUS_ID_FIELD_NUMBER = 1;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_bus_id", "bytes_file_path", "uint64_file_size", "str_file_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), "" }, MsgFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.obj_msg.MsgContentInfo.MsgFile
 * JD-Core Version:    0.7.0.1
 */