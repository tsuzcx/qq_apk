package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x383$ApplyGetFileListV2RspBody
  extends MessageMicro
{
  public static final int BOOL_IS_END_FIELD_NUMBER = 1;
  public static final int MSG_MAX_TIMESTAMP_FIELD_NUMBER = 3;
  public static final int RPT_MSG_FILE_INFO_LIST_FIELD_NUMBER = 2;
  public static final int UINT32_ALL_FILE_COUNT_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "bool_is_end", "rpt_msg_file_info_list", "msg_max_timestamp", "uint32_all_file_count" }, new Object[] { Boolean.valueOf(false), null, null, Integer.valueOf(0) }, ApplyGetFileListV2RspBody.class);
  public final PBBoolField bool_is_end = PBField.initBool(false);
  public cmd0x383.FileTimestamp msg_max_timestamp = new cmd0x383.FileTimestamp();
  public final PBRepeatMessageField rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FileInfo.class);
  public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListV2RspBody
 * JD-Core Version:    0.7.0.1
 */