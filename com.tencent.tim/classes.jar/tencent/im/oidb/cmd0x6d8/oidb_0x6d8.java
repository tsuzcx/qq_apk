package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.cs.group_file_common.group_file_common.FileInfo;
import tencent.im.cs.group_file_common.group_file_common.FolderInfo;

public final class oidb_0x6d8
{
  public static final class FileTimeStamp
    extends MessageMicro<FileTimeStamp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_upload_time", "str_file_id" }, new Object[] { Integer.valueOf(0), "" }, FileTimeStamp.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  }
  
  public static final class GetFileCountReqBody
    extends MessageMicro<GetFileCountReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetFileCountReqBody.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetFileCountRspBody
    extends MessageMicro<GetFileCountRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "uint32_all_file_count", "bool_file_too_many", "uint32_limit_count", "bool_is_full" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false) }, GetFileCountRspBody.class);
    public final PBBoolField bool_file_too_many = PBField.initBool(false);
    public final PBBoolField bool_is_full = PBField.initBool(false);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limit_count = PBField.initUInt32(0);
  }
  
  public static final class GetFileInfoReqBody
    extends MessageMicro<GetFileInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "uint32_field_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(16777215) }, GetFileInfoReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetFileInfoRspBody
    extends MessageMicro<GetFileInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "file_info" }, new Object[] { Integer.valueOf(0), "", "", null }, GetFileInfoRspBody.class);
    public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class GetFileListReqBody
    extends MessageMicro<GetFileListReqBody>
  {
    public static final int SORT_BY_DOWNLOAD = 6;
    public static final int SORT_BY_FILENAME = 4;
    public static final int SORT_BY_FILESIZE = 5;
    public static final int SORT_BY_FILETYPE = 2;
    public static final int SORT_BY_TIMESTAMP = 1;
    public static final int SORT_BY_UPLOADER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x6d8.FileTimeStamp max_timestamp = new oidb_0x6d8.FileTimeStamp();
    public oidb_0x6d8.FileTimeStamp start_timestamp = new oidb_0x6d8.FileTimeStamp();
    public final PBStringField str_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
    public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_onlinedoc_folder = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_by = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sort_order = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_white_list = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 136, 144 }, new String[] { "uint64_group_code", "uint32_app_id", "str_folder_id", "start_timestamp", "uint32_file_count", "max_timestamp", "uint32_all_file_count", "uint32_req_from", "uint32_sort_by", "uint32_filter_code", "uint64_uin", "uint32_field_flag", "uint32_start_index", "bytes_context", "uint32_client_version", "uint32_white_list", "uint32_sort_order", "uint32_show_onlinedoc_folder" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(16777215), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetFileListReqBody.class);
    }
  }
  
  public static final class GetFileListRspBody
    extends MessageMicro<GetFileListRspBody>
  {
    public static final int TYPE_FILE = 1;
    public static final int TYPE_FOLDER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBBytesField bytes_context = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public oidb_0x6d8.FileTimeStamp msg_max_timestamp = new oidb_0x6d8.FileTimeStamp();
    public final PBRepeatMessageField<Item> rpt_item_list = PBField.initRepeatMessage(Item.class);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_next_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_open_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_role = PBField.initUInt32(0);
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 42, 50, 56, 64, 88, 96, 104, 114, 120, 128 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "bool_is_end", "rpt_item_list", "msg_max_timestamp", "uint32_all_file_count", "uint32_filter_code", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_next_index", "bytes_context", "uint32_role", "uint32_open_flag" }, new Object[] { Integer.valueOf(0), "", "", Boolean.valueOf(false), null, null, Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, GetFileListRspBody.class);
    }
    
    public static final class Item
      extends MessageMicro<Item>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_type", "folder_info", "file_info" }, new Object[] { Integer.valueOf(0), null, null }, Item.class);
      public group_file_common.FileInfo file_info = new group_file_common.FileInfo();
      public group_file_common.FolderInfo folder_info = new group_file_common.FolderInfo();
      public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    }
  }
  
  public static final class GetFilePreviewReqBody
    extends MessageMicro<GetFilePreviewReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "" }, GetFilePreviewReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetFilePreviewRspBody
    extends MessageMicro<GetFilePreviewRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_reserved_field = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBUInt32Field int32_server_ip = PBField.initUInt32(0);
    public final PBUInt32Field int32_server_port = PBField.initUInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_cookie_val = PBField.initString("");
    public final PBStringField str_download_dns = PBField.initString("");
    public final PBBytesField str_download_dns_https = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_preview_port_https = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 66, 74, 82, 88 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "int32_server_ip", "int32_server_port", "str_download_dns", "bytes_download_url", "str_cookie_val", "bytes_reserved_field", "str_download_dns_https", "uint32_preview_port_https" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, "", localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0) }, GetFilePreviewRspBody.class);
    }
  }
  
  public static final class GetSpaceReqBody
    extends MessageMicro<GetSpaceReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_group_code", "uint32_app_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetSpaceReqBody.class);
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class GetSpaceRspBody
    extends MessageMicro<GetSpaceRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "uint64_total_space", "uint64_used_space", "bool_all_upload" }, new Object[] { Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), Boolean.valueOf(false) }, GetSpaceRspBody.class);
    public final PBBoolField bool_all_upload = PBField.initBool(false);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "file_info_req", "file_list_info_req", "group_file_cnt_req", "group_space_req", "file_preview_req" }, new Object[] { null, null, null, null, null }, ReqBody.class);
    public oidb_0x6d8.GetFileInfoReqBody file_info_req = new oidb_0x6d8.GetFileInfoReqBody();
    public oidb_0x6d8.GetFileListReqBody file_list_info_req = new oidb_0x6d8.GetFileListReqBody();
    public oidb_0x6d8.GetFilePreviewReqBody file_preview_req = new oidb_0x6d8.GetFilePreviewReqBody();
    public oidb_0x6d8.GetFileCountReqBody group_file_cnt_req = new oidb_0x6d8.GetFileCountReqBody();
    public oidb_0x6d8.GetSpaceReqBody group_space_req = new oidb_0x6d8.GetSpaceReqBody();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "file_info_rsp", "file_list_info_rsp", "group_file_cnt_rsp", "group_space_rsp", "file_preview_rsp" }, new Object[] { null, null, null, null, null }, RspBody.class);
    public oidb_0x6d8.GetFileInfoRspBody file_info_rsp = new oidb_0x6d8.GetFileInfoRspBody();
    public oidb_0x6d8.GetFileListRspBody file_list_info_rsp = new oidb_0x6d8.GetFileListRspBody();
    public oidb_0x6d8.GetFilePreviewRspBody file_preview_rsp = new oidb_0x6d8.GetFilePreviewRspBody();
    public oidb_0x6d8.GetFileCountRspBody group_file_cnt_rsp = new oidb_0x6d8.GetFileCountRspBody();
    public oidb_0x6d8.GetSpaceRspBody group_space_rsp = new oidb_0x6d8.GetSpaceRspBody();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8
 * JD-Core Version:    0.7.0.1
 */