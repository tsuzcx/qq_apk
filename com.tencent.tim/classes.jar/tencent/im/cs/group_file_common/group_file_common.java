package tencent.im.cs.group_file_common;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import msf.msgsvc.msg_ctrl.MsgCtrl;

public final class group_file_common
{
  public static final class FeedsInfo
    extends MessageMicro<FeedsInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public msg_ctrl.MsgCtrl msg_ctrl = new msg_ctrl.MsgCtrl();
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_feed_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 50 }, new String[] { "uint32_bus_id", "str_file_id", "uint32_msg_random", "bytes_ext", "uint32_feed_flag", "msg_ctrl" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null }, FeedsInfo.class);
    }
  }
  
  public static final class FeedsResult
    extends MessageMicro<FeedsResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "int32_ret_code", "str_detail", "str_file_id", "uint32_bus_id", "uint32_dead_time" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, FeedsResult.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_detail = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
  }
  
  public static final class FileInfo
    extends MessageMicro<FileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_blob_ext = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserved_field = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_feed_id = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_uploader_name = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_safe_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uploader_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 82, 90, 98, 106, 114, 120, 130, 136, 162, 168, 178, 186 }, new String[] { "str_file_id", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name", "uint64_uploader_uin", "str_parent_folder_id", "uint32_safe_type", "bytes_file_blob_ext", "uint64_owner_uin", "str_feed_id", "bytes_reserved_field" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", "", Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro4, Long.valueOf(0L), "", localByteStringMicro5 }, FileInfo.class);
    }
  }
  
  public static final class FileInfoTmem
    extends MessageMicro<FileInfoTmem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "rpt_files" }, new Object[] { Long.valueOf(0L), null }, FileInfoTmem.class);
    public final PBRepeatMessageField<group_file_common.FileInfo> rpt_files = PBField.initRepeatMessage(group_file_common.FileInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class FileItem
    extends MessageMicro<FileItem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "folder_info", "file_info" }, new Object[] { Integer.valueOf(0), null, null }, FileItem.class);
    public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
    public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
  }
  
  public static final class FolderInfo
    extends MessageMicro<FolderInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 58, 64, 72, 82, 88 }, new String[] { "str_folder_id", "str_parent_folder_id", "str_folder_name", "uint32_create_time", "uint32_modify_time", "uint64_create_uin", "str_creator_name", "uint32_total_file_count", "uint64_modify_uin", "str_modify_name", "uint64_used_space" }, new Object[] { "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L), "", Long.valueOf(0L) }, FolderInfo.class);
    public final PBStringField str_creator_name = PBField.initString("");
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBStringField str_folder_name = PBField.initString("");
    public final PBStringField str_modify_name = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_file_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_modify_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  }
  
  public static final class FolderInfoTmem
    extends MessageMicro<FolderInfoTmem>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_group_code", "rpt_folders" }, new Object[] { Long.valueOf(0L), null }, FolderInfoTmem.class);
    public final PBRepeatMessageField<group_file_common.FolderInfo> rpt_folders = PBField.initRepeatMessage(group_file_common.FolderInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class OverwriteInfo
    extends MessageMicro<OverwriteInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_file_id", "uint32_download_times" }, new Object[] { "", Integer.valueOf(0) }, OverwriteInfo.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.group_file_common.group_file_common
 * JD-Core Version:    0.7.0.1
 */