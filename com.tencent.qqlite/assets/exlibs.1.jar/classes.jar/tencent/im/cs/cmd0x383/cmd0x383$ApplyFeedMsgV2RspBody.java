package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyFeedMsgV2RspBody
  extends MessageMicro
{
  public static final int BOOL_SAFE_CHECK_FLAG_FIELD_NUMBER = 11;
  public static final int STR_FILE_PATH1_FIELD_NUMBER = 4;
  public static final int STR_FILE_PATH2_FIELD_NUMBER = 5;
  public static final int STR_FILE_PATH3_FIELD_NUMBER = 6;
  public static final int UINT32_BUS_ID_FIELD_NUMBER = 3;
  public static final int UINT32_FILE_NUM_FIELD_NUMBER = 2;
  public static final int UINT32_TOTAL_FILE_NUM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 88 }, new String[] { "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "bool_safe_check_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Boolean.valueOf(false) }, ApplyFeedMsgV2RspBody.class);
  public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
  public final PBStringField str_file_path1 = PBField.initString("");
  public final PBStringField str_file_path2 = PBField.initString("");
  public final PBStringField str_file_path3 = PBField.initString("");
  public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyFeedMsgV2RspBody
 * JD-Core Version:    0.7.0.1
 */