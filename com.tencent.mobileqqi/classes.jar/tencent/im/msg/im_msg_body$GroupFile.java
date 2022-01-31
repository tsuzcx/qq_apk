package tencent.im.msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_msg_body$GroupFile
  extends MessageMicro
{
  public static final int BYTES_BATCH_ID_FIELD_NUMBER = 4;
  public static final int BYTES_BATCH_ITEM_ID_FIELD_NUMBER = 8;
  public static final int BYTES_FILENAME_FIELD_NUMBER = 1;
  public static final int BYTES_FILE_ID_FIELD_NUMBER = 3;
  public static final int BYTES_FILE_KEY_FIELD_NUMBER = 5;
  public static final int BYTES_MARK_FIELD_NUMBER = 6;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 2;
  public static final int UINT64_SEQUENCE_FIELD_NUMBER = 7;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_batch_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_batch_item_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_filename = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 56, 66 }, new String[] { "bytes_filename", "uint64_file_size", "bytes_file_id", "bytes_batch_id", "bytes_file_key", "bytes_mark", "uint64_sequence", "bytes_batch_item_id" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), localByteStringMicro6 }, GroupFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.msg.im_msg_body.GroupFile
 * JD-Core Version:    0.7.0.1
 */