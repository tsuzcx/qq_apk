package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383
{
  public static final class ApplyCheckAuditFlagReqBody
    extends MessageMicro<ApplyCheckAuditFlagReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bus_id", "str_file_path" }, new Object[] { Integer.valueOf(0), "" }, ApplyCheckAuditFlagReqBody.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyCheckAuditFlagRspBody
    extends MessageMicro<ApplyCheckAuditFlagRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_audit_flag" }, new Object[] { Integer.valueOf(0) }, ApplyCheckAuditFlagRspBody.class);
    public final PBUInt32Field uint32_audit_flag = PBField.initUInt32(0);
  }
  
  public static final class ApplyCopyFromReqBody
    extends MessageMicro<ApplyCopyFromReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 50, 58, 64, 82 }, new String[] { "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_bus_id", "uint64_file_size", "str_local_path", "str_file_name", "uint64_src_uin", "bytes_md5" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), "", "", Long.valueOf(0L), localByteStringMicro3 }, ApplyCopyFromReqBody.class);
    }
  }
  
  public static final class ApplyCopyFromRspBody
    extends MessageMicro<ApplyCopyFromRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBBytesField bytes_save_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "bytes_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { localByteStringMicro, Boolean.valueOf(false), Integer.valueOf(0) }, ApplyCopyFromRspBody.class);
    }
  }
  
  public static final class ApplyCopyToReqBody
    extends MessageMicro<ApplyCopyToReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id", "uint64_dst_uin" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyCopyToReqBody.class);
    public final PBStringField str_src_file_path = PBField.initString("");
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
  }
  
  public static final class ApplyCopyToRspBody
    extends MessageMicro<ApplyCopyToRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "str_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, ApplyCopyToRspBody.class);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBStringField str_save_file_path = PBField.initString("");
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  }
  
  public static final class ApplyCreateFolderReqBody
    extends MessageMicro<ApplyCreateFolderReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_bus_id", "str_folder_name", "str_parent_folder_path" }, new Object[] { Integer.valueOf(0), "", "" }, ApplyCreateFolderReqBody.class);
    public final PBStringField str_folder_name = PBField.initString("");
    public final PBStringField str_parent_folder_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyCreateFolderRspBody
    extends MessageMicro<ApplyCreateFolderRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "str_folder_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, ApplyCreateFolderRspBody.class);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBStringField str_folder_path = PBField.initString("");
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  }
  
  public static final class ApplyDelFileReqBody
    extends MessageMicro<ApplyDelFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bus_id", "str_file_path" }, new Object[] { Integer.valueOf(0), "" }, ApplyDelFileReqBody.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyDelFileRspBody
    extends MessageMicro<ApplyDelFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyDelFileRspBody.class);
  }
  
  public static final class ApplyDownloadReqBody
    extends MessageMicro<ApplyDownloadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40 }, new String[] { "uint32_bus_id", "str_file_path", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req" }, new Object[] { Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false) }, ApplyDownloadReqBody.class);
    public final PBBoolField bool_preview_req = PBField.initBool(false);
    public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
  }
  
  public static final class ApplyDownloadRspBody
    extends MessageMicro<ApplyDownloadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBBytesField bytes_cookie_val = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_download_dns = PBField.initString("");
    public final PBStringField str_download_ip = PBField.initString("");
    public final PBStringField str_msg = PBField.initString("");
    public final PBStringField str_save_file_name = PBField.initString("");
    public final PBUInt32Field uint32_preview_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 88, 96, 104, 114 }, new String[] { "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_preview_port", "str_msg" }, new Object[] { "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, "", Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), "" }, ApplyDownloadRspBody.class);
    }
  }
  
  public static final class ApplyFeedMsgV2ReqBody
    extends MessageMicro<ApplyFeedMsgV2ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_first_pkg_flag = PBField.initBool(false);
    public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_imei = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_session_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_key_type = PBField.initInt32(0);
    public final PBStringField str_file_path1 = PBField.initString("");
    public final PBStringField str_file_path2 = PBField.initString("");
    public final PBStringField str_file_path3 = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_random1 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_random2 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_random3 = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pt_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 88, 96, 104, 240, 248, 258, 266, 272, 282 }, new String[] { "bool_first_pkg_flag", "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "uint32_msg_random1", "uint32_msg_random2", "uint32_msg_random3", "uint32_pt_appid", "int32_key_type", "bytes_session_key", "bytes_client_ip", "uint32_client_port", "bytes_imei" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3 }, ApplyFeedMsgV2ReqBody.class);
    }
  }
  
  public static final class ApplyFeedMsgV2RspBody
    extends MessageMicro<ApplyFeedMsgV2RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 88 }, new String[] { "uint32_total_file_num", "uint32_file_num", "uint32_bus_id", "str_file_path1", "str_file_path2", "str_file_path3", "bool_safe_check_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Boolean.valueOf(false) }, ApplyFeedMsgV2RspBody.class);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBStringField str_file_path1 = PBField.initString("");
    public final PBStringField str_file_path2 = PBField.initString("");
    public final PBStringField str_file_path3 = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
  }
  
  public static final class ApplyFileSearchReqBody
    extends MessageMicro<ApplyFileSearchReqBody>
  {
    public static final int AUDIO = 3;
    public static final int DOCUMENT = 1;
    public static final int OTHER = 10000;
    public static final int PICTURE = 4;
    public static final int SEARCH_BY_FILE_TYPE = 2;
    public static final int SEARCH_BY_KEY_WORD = 0;
    public static final int VIDEO = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_search_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_group_code_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Long> uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 80, 88 }, new String[] { "uint64_group_code_list", "uint64_uin_list", "bytes_key_word", "bytes_sync_cookie", "uint32_count", "uint32_search_type", "uint32_file_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyFileSearchReqBody.class);
    }
  }
  
  public static final class ApplyFileSearchRspBody
    extends MessageMicro<ApplyFileSearchRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_key_word = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sync_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Item> item_list = PBField.initRepeatMessage(Item.class);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_match_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40 }, new String[] { "bytes_sync_cookie", "uint32_is_end", "bytes_key_word", "item_list", "uint32_total_match_count" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null, Integer.valueOf(0) }, ApplyFileSearchRspBody.class);
    }
    
    public static final class Item
      extends MessageMicro<Item>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBRepeatField<ByteStringMicro> bytes_match_word = PBField.initRepeat(PBBytesField.__repeatHelper__);
      public final PBBytesField bytes_uploader_nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
      public cmd0x383.ApplyGetFileListRspBody.FileInfo file_info = new cmd0x383.ApplyGetFileListRspBody.FileInfo();
      public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_match_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_upload_uin = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 58 }, new String[] { "uint64_group_code", "bytes_group_name", "uint64_upload_uin", "bytes_uploader_nick_name", "bytes_match_word", "uint64_match_uin", "file_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), null }, Item.class);
      }
    }
  }
  
  public static final class ApplyGetFileCountReqBody
    extends MessageMicro<ApplyGetFileCountReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_bus_id" }, new Object[] { Integer.valueOf(0) }, ApplyGetFileCountReqBody.class);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyGetFileCountRspBody
    extends MessageMicro<ApplyGetFileCountRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_all_file_count" }, new Object[] { Integer.valueOf(0) }, ApplyGetFileCountRspBody.class);
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
  }
  
  public static final class ApplyGetFileInfoReqBody
    extends MessageMicro<ApplyGetFileInfoReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_bus_id", "str_file_path", "uint32_field_flag" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(16777215) }, ApplyGetFileInfoReqBody.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_field_flag = PBField.initUInt32(16777215);
  }
  
  public static final class ApplyGetFileInfoRspBody
    extends MessageMicro<ApplyGetFileInfoRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "fileInfo" }, new Object[] { null }, ApplyGetFileInfoRspBody.class);
    public cmd0x383.ApplyGetFileListRspBody.FileInfo fileInfo = new cmd0x383.ApplyGetFileListRspBody.FileInfo();
  }
  
  public static final class ApplyGetFileListReqBody
    extends MessageMicro<ApplyGetFileListReqBody>
  {
    public static final int REQ_FROM_ANPING_SVR = 21;
    public static final int REQ_FROM_MB_FILE_LIST = 3;
    public static final int REQ_FROM_MB_GROUP_CARD = 2;
    public static final int REQ_FROM_PC_CLIENT_INNERWEB = 11;
    public static final int REQ_FROM_PC_CLIENT_INNERWEB_PAGE = 12;
    public static final int REQ_FROM_PC_GROUP_CARD = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_start_index", "uint32_file_count", "uint32_req_from", "str_parent_folder_path" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "" }, ApplyGetFileListReqBody.class);
    public final PBStringField str_parent_folder_path = PBField.initString("");
    public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start_index = PBField.initUInt32(0);
  }
  
  public static final class ApplyGetFileListRspBody
    extends MessageMicro<ApplyGetFileListRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50, 56 }, new String[] { "uint32_file_count", "uint32_all_file_count", "bool_is_end", "rpt_msg_file_info_list", "uint32_folder_count", "rpt_msg_folder_info_list", "uint32_filter_code" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), null, Integer.valueOf(0), null, Integer.valueOf(0) }, ApplyGetFileListRspBody.class);
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public final PBRepeatMessageField<FileInfo> rpt_msg_file_info_list = PBField.initRepeatMessage(FileInfo.class);
    public final PBRepeatMessageField<FolderInfo> rpt_msg_folder_info_list = PBField.initRepeatMessage(FolderInfo.class);
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_folder_count = PBField.initUInt32(0);
    
    public static final class FileInfo
      extends MessageMicro<FileInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_file_path = PBField.initString("");
      public final PBStringField str_local_path = PBField.initString("");
      public final PBStringField str_uploader_name = PBField.initString("");
      public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_dead_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
      public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_upload_uin = PBField.initUInt32(0);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 106, 114, 202 }, new String[] { "str_file_path", "str_file_name", "uint64_file_size", "uint32_bus_id", "uint32_upload_uin", "uint64_uploaded_size", "uint32_upload_time", "uint32_dead_time", "uint32_modify_time", "uint32_download_times", "bytes_sha", "bytes_sha3", "bytes_md5", "str_local_path", "str_uploader_name" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", "" }, FileInfo.class);
      }
    }
    
    public static final class FolderInfo
      extends MessageMicro<FolderInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "str_folder_path", "str_folder_name", "uint32_create_time", "uint64_create_uin" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L) }, FolderInfo.class);
      public final PBStringField str_folder_name = PBField.initString("");
      public final PBStringField str_folder_path = PBField.initString("");
      public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
      public final PBUInt64Field uint64_create_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class ApplyGetFileListV2ReqBody
    extends MessageMicro<ApplyGetFileListV2ReqBody>
  {
    public static final int REQ_FROM_MB_FILE_LIST_BY_FILETYPE = 2;
    public static final int REQ_FROM_MB_FILE_LIST_BY_TIMESTAMP = 1;
    public static final int REQ_FROM_MB_FILE_LIST_BY_UPLOADER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "msg_start_timestamp", "uint32_file_count", "msg_max_timestamp", "uint32_all_file_count", "uint32_req_from" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0) }, ApplyGetFileListV2ReqBody.class);
    public cmd0x383.FileTimestamp msg_max_timestamp = new cmd0x383.FileTimestamp();
    public cmd0x383.FileTimestamp msg_start_timestamp = new cmd0x383.FileTimestamp();
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_from = PBField.initUInt32(0);
  }
  
  public static final class ApplyGetFileListV2RspBody
    extends MessageMicro<ApplyGetFileListV2RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "bool_is_end", "rpt_msg_file_info_list", "msg_max_timestamp", "uint32_all_file_count", "uint32_filter_code" }, new Object[] { Boolean.valueOf(false), null, null, Integer.valueOf(0), Integer.valueOf(0) }, ApplyGetFileListV2RspBody.class);
    public final PBBoolField bool_is_end = PBField.initBool(false);
    public cmd0x383.FileTimestamp msg_max_timestamp = new cmd0x383.FileTimestamp();
    public final PBRepeatMessageField<cmd0x383.ApplyGetFileListRspBody.FileInfo> rpt_msg_file_info_list = PBField.initRepeatMessage(cmd0x383.ApplyGetFileListRspBody.FileInfo.class);
    public final PBUInt32Field uint32_all_file_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_code = PBField.initUInt32(0);
  }
  
  public static final class ApplyGetSpaceReqBody
    extends MessageMicro<ApplyGetSpaceReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyGetSpaceReqBody.class);
  }
  
  public static final class ApplyGetSpaceRspBody
    extends MessageMicro<ApplyGetSpaceRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_total_space", "uint64_used_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, ApplyGetSpaceRspBody.class);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
  }
  
  public static final class ApplyLinkFileReqBody
    extends MessageMicro<ApplyLinkFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_src_bus_id", "str_src_file_path", "uint32_dst_bus_id" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, ApplyLinkFileReqBody.class);
    public final PBStringField str_src_file_path = PBField.initString("");
    public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyLinkFileRspBody
    extends MessageMicro<ApplyLinkFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 88, 96 }, new String[] { "str_save_file_path", "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { "", Boolean.valueOf(false), Integer.valueOf(0) }, ApplyLinkFileRspBody.class);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBStringField str_save_file_path = PBField.initString("");
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  }
  
  public static final class ApplyRenameReqBody
    extends MessageMicro<ApplyRenameReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_bus_id", "str_file_path", "str_file_name" }, new Object[] { Integer.valueOf(0), "", "" }, ApplyRenameReqBody.class);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyRenameRspBody
    extends MessageMicro<ApplyRenameRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 88, 96 }, new String[] { "bool_safe_check_flag", "uint32_safe_check_res" }, new Object[] { Boolean.valueOf(false), Integer.valueOf(0) }, ApplyRenameRspBody.class);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
  }
  
  public static final class ApplyResendReqBody
    extends MessageMicro<ApplyResendReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_bus_id", "str_file_path", "bytes_sha" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro }, ApplyResendReqBody.class);
    }
  }
  
  public static final class ApplyResendRspBody
    extends MessageMicro<ApplyResendRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_upload_ip = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_upload_ip", "bytes_file_key", "bytes_check_key" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2 }, ApplyResendRspBody.class);
    }
  }
  
  public static final class ApplyTransFileReqBody
    extends MessageMicro<ApplyTransFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_bus_id", "str_file_path" }, new Object[] { Integer.valueOf(0), "" }, ApplyTransFileReqBody.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
  }
  
  public static final class ApplyTransFileRspBody
    extends MessageMicro<ApplyTransFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_save_file_path" }, new Object[] { "" }, ApplyTransFileRspBody.class);
    public final PBStringField str_save_file_path = PBField.initString("");
  }
  
  public static final class ApplyUploadReqBody
    extends MessageMicro<ApplyUploadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 74 }, new String[] { "uint32_bus_id", "uint32_oper_type", "str_file_path", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, ApplyUploadReqBody.class);
    }
  }
  
  public static final class ApplyUploadRspBody
    extends MessageMicro<ApplyUploadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBoolField bool_safe_check_flag = PBField.initBool(false);
    public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBStringField str_server_dns = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_im_fail_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_safe_check_res = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48, 88, 96, 104 }, new String[] { "str_upload_ip", "str_server_dns", "str_file_path", "bytes_file_key", "bytes_check_key", "bool_file_exist", "bool_safe_check_flag", "uint32_safe_check_res", "uint32_im_fail_reason" }, new Object[] { "", "", "", localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) }, ApplyUploadRspBody.class);
    }
  }
  
  public static final class FileTimestamp
    extends MessageMicro<FileTimestamp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_upload_time", "str_file_path" }, new Object[] { Integer.valueOf(0), "" }, FileTimestamp.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int APP_ID_ANDROID_CLIENT = 3;
    public static final int APP_ID_ANPING_SVR = 100;
    public static final int APP_ID_DISCUSS_SVR = 13;
    public static final int APP_ID_FEEDS_TRANS_SVR = 17;
    public static final int APP_ID_GJ_UNKNOWN_SVR = 101;
    public static final int APP_ID_GROUPACTIVE_SVR = 16;
    public static final int APP_ID_GROUPCARD_SVR = 15;
    public static final int APP_ID_GROUPSPACE_SVR = 11;
    public static final int APP_ID_IOS_CLIENT = 2;
    public static final int APP_ID_IPAD_CLIENT = 5;
    public static final int APP_ID_NEW_GROUP_EVENT = 40;
    public static final int APP_ID_OFFlINE_SVR = 12;
    public static final int APP_ID_PC_CLIENT = 1;
    public static final int APP_ID_PC_CLIENT_WEB = 4;
    public static final int APP_ID_WEIYUN_SVR = 14;
    public static final int APP_ID_WINPHONE_CLIENT = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 890, 898, 906, 914, 922, 930, 938, 954 }, new String[] { "uint64_groupcode", "uint32_app_id", "msg_upload_req_body", "msg_resend_req_body", "msg_download_req_body", "msg_del_file_req_body", "msg_rename_req_body", "msg_trans_file_req_body", "msg_link_file_req_body", "msg_feed_msg_v2_req_body", "msg_get_space_req_body", "msg_check_audit_flag_req_body", "msg_copy_from_req_body", "msg_copy_to_req_body", "msg_get_file_list_req_body", "msg_create_folder_req_body", "msg_get_file_count_req_body", "msg_get_file_info_req_body", "msg_get_file_list_v2_req_body", "msg_file_search_req_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public cmd0x383.ApplyCheckAuditFlagReqBody msg_check_audit_flag_req_body = new cmd0x383.ApplyCheckAuditFlagReqBody();
    public cmd0x383.ApplyCopyFromReqBody msg_copy_from_req_body = new cmd0x383.ApplyCopyFromReqBody();
    public cmd0x383.ApplyCopyToReqBody msg_copy_to_req_body = new cmd0x383.ApplyCopyToReqBody();
    public cmd0x383.ApplyCreateFolderReqBody msg_create_folder_req_body = new cmd0x383.ApplyCreateFolderReqBody();
    public cmd0x383.ApplyDelFileReqBody msg_del_file_req_body = new cmd0x383.ApplyDelFileReqBody();
    public cmd0x383.ApplyDownloadReqBody msg_download_req_body = new cmd0x383.ApplyDownloadReqBody();
    public cmd0x383.ApplyFeedMsgV2ReqBody msg_feed_msg_v2_req_body = new cmd0x383.ApplyFeedMsgV2ReqBody();
    public cmd0x383.ApplyFileSearchReqBody msg_file_search_req_body = new cmd0x383.ApplyFileSearchReqBody();
    public cmd0x383.ApplyGetFileCountReqBody msg_get_file_count_req_body = new cmd0x383.ApplyGetFileCountReqBody();
    public cmd0x383.ApplyGetFileInfoReqBody msg_get_file_info_req_body = new cmd0x383.ApplyGetFileInfoReqBody();
    public cmd0x383.ApplyGetFileListReqBody msg_get_file_list_req_body = new cmd0x383.ApplyGetFileListReqBody();
    public cmd0x383.ApplyGetFileListV2ReqBody msg_get_file_list_v2_req_body = new cmd0x383.ApplyGetFileListV2ReqBody();
    public cmd0x383.ApplyGetSpaceReqBody msg_get_space_req_body = new cmd0x383.ApplyGetSpaceReqBody();
    public cmd0x383.ApplyLinkFileReqBody msg_link_file_req_body = new cmd0x383.ApplyLinkFileReqBody();
    public cmd0x383.ApplyRenameReqBody msg_rename_req_body = new cmd0x383.ApplyRenameReqBody();
    public cmd0x383.ApplyResendReqBody msg_resend_req_body = new cmd0x383.ApplyResendReqBody();
    public cmd0x383.ApplyTransFileReqBody msg_trans_file_req_body = new cmd0x383.ApplyTransFileReqBody();
    public cmd0x383.ApplyUploadReqBody msg_upload_req_body = new cmd0x383.ApplyUploadReqBody();
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 890, 898, 906, 914, 922, 930, 938, 954 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "msg_upload_rsp_body", "msg_resend_rsp_body", "msg_download_rsp_body", "msg_del_file_rsp_body", "msg_rename_rsp_body", "msg_trans_file_rsp_body", "msg_link_file_rsp_body", "msg_feed_msg_v2_rsp_body", "msg_get_space_rsp_body", "msg_check_audit_flag_rsp_body", "msg_copy_from_rsp_body", "msg_copy_to_rsp_body", "msg_get_file_list_rsp_body", "msg_create_folder_rsp_body", "msg_get_file_count_rsp_body", "msg_get_file_info_rsp_body", "msg_get_file_list_v2_rsp_body", "msg_file_search_rsp_body" }, new Object[] { Integer.valueOf(0), "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public cmd0x383.ApplyCheckAuditFlagRspBody msg_check_audit_flag_rsp_body = new cmd0x383.ApplyCheckAuditFlagRspBody();
    public cmd0x383.ApplyCopyFromRspBody msg_copy_from_rsp_body = new cmd0x383.ApplyCopyFromRspBody();
    public cmd0x383.ApplyCopyToRspBody msg_copy_to_rsp_body = new cmd0x383.ApplyCopyToRspBody();
    public cmd0x383.ApplyCreateFolderRspBody msg_create_folder_rsp_body = new cmd0x383.ApplyCreateFolderRspBody();
    public cmd0x383.ApplyDelFileRspBody msg_del_file_rsp_body = new cmd0x383.ApplyDelFileRspBody();
    public cmd0x383.ApplyDownloadRspBody msg_download_rsp_body = new cmd0x383.ApplyDownloadRspBody();
    public cmd0x383.ApplyFeedMsgV2RspBody msg_feed_msg_v2_rsp_body = new cmd0x383.ApplyFeedMsgV2RspBody();
    public cmd0x383.ApplyFileSearchRspBody msg_file_search_rsp_body = new cmd0x383.ApplyFileSearchRspBody();
    public cmd0x383.ApplyGetFileCountRspBody msg_get_file_count_rsp_body = new cmd0x383.ApplyGetFileCountRspBody();
    public cmd0x383.ApplyGetFileInfoRspBody msg_get_file_info_rsp_body = new cmd0x383.ApplyGetFileInfoRspBody();
    public cmd0x383.ApplyGetFileListRspBody msg_get_file_list_rsp_body = new cmd0x383.ApplyGetFileListRspBody();
    public cmd0x383.ApplyGetFileListV2RspBody msg_get_file_list_v2_rsp_body = new cmd0x383.ApplyGetFileListV2RspBody();
    public cmd0x383.ApplyGetSpaceRspBody msg_get_space_rsp_body = new cmd0x383.ApplyGetSpaceRspBody();
    public cmd0x383.ApplyLinkFileRspBody msg_link_file_rsp_body = new cmd0x383.ApplyLinkFileRspBody();
    public cmd0x383.ApplyRenameRspBody msg_rename_rsp_body = new cmd0x383.ApplyRenameRspBody();
    public cmd0x383.ApplyResendRspBody msg_resend_rsp_body = new cmd0x383.ApplyResendRspBody();
    public cmd0x383.ApplyTransFileRspBody msg_trans_file_rsp_body = new cmd0x383.ApplyTransFileRspBody();
    public cmd0x383.ApplyUploadRspBody msg_upload_rsp_body = new cmd0x383.ApplyUploadRspBody();
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383
 * JD-Core Version:    0.7.0.1
 */