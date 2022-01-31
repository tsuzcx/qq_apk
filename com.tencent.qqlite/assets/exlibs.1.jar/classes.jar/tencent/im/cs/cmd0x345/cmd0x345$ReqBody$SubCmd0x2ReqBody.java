package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345$ReqBody$SubCmd0x2ReqBody
  extends MessageMicro
{
  public static final int STR_BATCH_ID_FIELD_NUMBER = 6;
  public static final int STR_BATCH_ITEM_ID_FIELD_NUMBER = 7;
  public static final int STR_CLIENT_KEY_FIELD_NUMBER = 8;
  public static final int STR_FILE_ID_FIELD_NUMBER = 5;
  public static final int STR_FILE_KEY_FIELD_NUMBER = 9;
  public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
  public static final int UINT32_BUSID_FIELD_NUMBER = 13;
  public static final int UINT32_DISSCUS_UIN_FIELD_NUMBER = 1;
  public static final int UINT32_MARK_FIELD_NUMBER = 10;
  public static final int UINT32_RANDOM_FIELD_NUMBER = 14;
  public static final int UINT32_SENDER_UIN_FIELD_NUMBER = 2;
  public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 4;
  public static final int UINT64_SEQUENCE_FIELD_NUMBER = 12;
  public static final int UINT64_TIME_FIELD_NUMBER = 11;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 104, 112 }, new String[] { "uint32_disscus_uin", "uint32_sender_uin", "str_file_name", "uint64_file_size", "str_file_id", "str_batch_id", "str_batch_item_id", "str_client_key", "str_file_key", "uint32_mark", "uint64_time", "uint64_sequence", "uint32_busid", "uint32_random" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x2ReqBody.class);
  public final PBStringField str_batch_id = PBField.initString("");
  public final PBStringField str_batch_item_id = PBField.initString("");
  public final PBStringField str_client_key = PBField.initString("");
  public final PBStringField str_file_id = PBField.initString("");
  public final PBStringField str_file_key = PBField.initString("");
  public final PBStringField str_file_name = PBField.initString("");
  public final PBUInt32Field uint32_busid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
  public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345.ReqBody.SubCmd0x2ReqBody
 * JD-Core Version:    0.7.0.1
 */