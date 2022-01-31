package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyFeedMsgV2ReqBody
  extends MessageMicro
{
  public static final int BOOL_FIRST_PKG_FLAG_FIELD_NUMBER = 1;
  public static final int STR_FILE_PATH1_FIELD_NUMBER = 5;
  public static final int STR_FILE_PATH2_FIELD_NUMBER = 6;
  public static final int STR_FILE_PATH3_FIELD_NUMBER = 7;
  public static final int UINT32_BUS_ID_FIELD_NUMBER = 4;
  public static final int UINT32_FILE_NUM_FIELD_NUMBER = 3;
  public static final int UINT32_MSG_RANDOM1_FIELD_NUMBER = 11;
  public static final int UINT32_MSG_RANDOM2_FIELD_NUMBER = 12;
  public static final int UINT32_MSG_RANDOM3_FIELD_NUMBER = 13;
  public static final int UINT32_TOTAL_FILE_NUM_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 88, 96, 104 }, new String[] { "bool_first_pkg_flag", "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "uint32_msg_random1", "uint32_msg_random2", "uint32_msg_random3" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyFeedMsgV2ReqBody.class);
  public final PBBoolField bool_first_pkg_flag = PBField.initBool(false);
  public final PBStringField str_file_path1 = PBField.initString("");
  public final PBStringField str_file_path2 = PBField.initString("");
  public final PBStringField str_file_path3 = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_random3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFeedMsgV2ReqBody
 * JD-Core Version:    0.7.0.1
 */