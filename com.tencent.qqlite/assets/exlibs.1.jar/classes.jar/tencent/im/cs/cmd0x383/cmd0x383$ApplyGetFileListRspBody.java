package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListRspBody
  extends MessageMicro
{
  public static final int BOOL_IS_END_FIELD_NUMBER = 3;
  public static final int RPT_MSG_FILE_INFO_LIST_FIELD_NUMBER = 4;
  public static final int RPT_MSG_FOLDER_INFO_LIST_FIELD_NUMBER = 6;
  public static final int UINT32_ALL_FILE_COUNT_FIELD_NUMBER = 2;
  public static final int UINT32_FILE_COUNT_FIELD_NUMBER = 1;
  public static final int UINT32_FOLDER_COUNT_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "uint32_file_count", "uint32_all_file_count", "bool_is_end", "rpt_msg_file_info_list", "uint32_folder_count", "rpt_msg_folder_info_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(0), null }, ApplyGetFileListRspBody.class);
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public final PBRepeatMessageField rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FileInfo.class);
  public final PBRepeatMessageField rpt_msg_folder_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FolderInfo.class);
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_folder_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody
 * JD-Core Version:    0.7.0.1
 */