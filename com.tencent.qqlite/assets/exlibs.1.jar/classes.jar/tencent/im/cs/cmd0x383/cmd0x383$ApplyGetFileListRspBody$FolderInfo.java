package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ApplyGetFileListRspBody$FolderInfo
  extends MessageMicro
{
  public static final int STR_FOLDER_NAME_FIELD_NUMBER = 2;
  public static final int STR_FOLDER_PATH_FIELD_NUMBER = 1;
  public static final int UINT32_CREATE_TIME_FIELD_NUMBER = 3;
  public static final int UINT64_CREATE_UIN_FIELD_NUMBER = 4;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_folder_path", "str_folder_name", "uint32_create_time", "uint64_create_uin" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L) }, FolderInfo.class);
  public final PBStringField str_folder_name = PBField.initString("");
  public final PBStringField str_folder_path = PBField.initString("");
  public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ApplyGetFileListRspBody.FolderInfo
 * JD-Core Version:    0.7.0.1
 */