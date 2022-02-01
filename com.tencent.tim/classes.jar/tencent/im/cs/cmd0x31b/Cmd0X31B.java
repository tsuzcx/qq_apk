package tencent.im.cs.cmd0x31b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Cmd0X31B
{
  public static final int CMD_REQ_ALBUM_STATUS_REPORT = 273;
  public static final int CMD_REQ_DELETE_FILE = 7;
  public static final int CMD_REQ_DOWN_LOAD_FILE = 6;
  public static final int CMD_REQ_FILE_PREVIEW = 11;
  public static final int CMD_REQ_GET_LIB_LIST = 2;
  public static final int CMD_REQ_GET_LIB_TYPE = 1;
  public static final int CMD_REQ_OFFLINE_FILE = 257;
  public static final int CMD_REQ_OFFLINE_FILE_DOWNLOAD = 258;
  public static final int CMD_REQ_QCLOUD2FTN = 13;
  public static final int CMD_REQ_QUERY_PWD = 15;
  public static final int CMD_REQ_RESUME_FILE_UPLOAD = 10;
  public static final int CMD_REQ_STORE_FILE_PREVIEW = 19;
  public static final int CMD_REQ_UPLOAD2QCLOUD = 5;
  public static final int CMD_REQ_VERIFY_PWD = 16;
  public static final int CMD_UNKNOWN = 0;
  
  public static final class AlbumStatusReportReqBody
    extends MessageMicro<AlbumStatusReportReqBody>
  {
    public static final int BOOL_NEW_USER_FIELD_NUMBER = 3;
    public static final int UINT32_DURING_TIME_FIELD_NUMBER = 2;
    public static final int UINT32_NEW_PIC_NUMBER_FIELD_NUMBER = 1;
    public static final int UINT32_UNBAKED_PIC_NUMBER_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_new_pic_number", "uint32_during_time", "bool_new_user", "uint32_unbaked_pic_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, AlbumStatusReportReqBody.class);
    public final PBBoolField bool_new_user = PBField.initBool(false);
    public final PBUInt32Field uint32_during_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_new_pic_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_unbaked_pic_number = PBField.initUInt32(0);
  }
  
  public static final class AlbumStatusReportRspBody
    extends MessageMicro<AlbumStatusReportRspBody>
  {
    public static final int BOOL_NEED_RED_TOUCH_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "bool_need_red_touch" }, new Object[] { Boolean.valueOf(false) }, AlbumStatusReportRspBody.class);
    public final PBBoolField bool_need_red_touch = PBField.initBool(false);
  }
  
  public static final class ApplyOfflineFileDownloadReq
    extends MessageMicro<ApplyOfflineFileDownloadReq>
  {
    public static final int BYTES_UUID_FIELD_NUMBER = 20;
    public static final int UINT32_OWNER_TYPE_FIELD_NUMBER = 30;
    public static final int UINT64_UIN_FIELD_NUMBER = 10;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_owner_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240 }, new String[] { "uint64_uin", "bytes_uuid", "uint32_owner_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ApplyOfflineFileDownloadReq.class);
    }
  }
  
  public static final class ApplyOfflineFileDownloadRsp
    extends MessageMicro<ApplyOfflineFileDownloadRsp>
  {
    public static final int MSG_OF_DOWNLOAD_INFO_FIELD_NUMBER = 30;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 242 }, new String[] { "msg_of_download_info" }, new Object[] { null }, ApplyOfflineFileDownloadRsp.class);
    public Cmd0X31B.OFDownloadInfo msg_of_download_info = new Cmd0X31B.OFDownloadInfo();
  }
  
  public static final class DeleteFileReqBody
    extends MessageMicro<DeleteFileReqBody>
  {
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int UINT32_FILE_RESOURCE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_file_id", "uint32_file_resource" }, new Object[] { "", Integer.valueOf(0) }, DeleteFileReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_file_resource = PBField.initUInt32(0);
  }
  
  public static final class DeleteFileRspBody
    extends MessageMicro<DeleteFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], DeleteFileRspBody.class);
  }
  
  public static final class DownloadFileReqBody
    extends MessageMicro<DownloadFileReqBody>
  {
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
    public static final int STR_LOCAL_MD5_FIELD_NUMBER = 6;
    public static final int UINT32_FILE_RESOURCE_FIELD_NUMBER = 2;
    public static final int UINT32_REQUEST_TYPE_FIELD_NUMBER = 5;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "str_file_id", "uint32_file_resource", "str_file_name", "uint64_file_size", "uint32_request_type", "str_local_md5" }, new Object[] { "", Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), "" }, DownloadFileReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_md5 = PBField.initString("");
    public final PBUInt32Field uint32_file_resource = PBField.initUInt32(0);
    public final PBUInt32Field uint32_request_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  }
  
  public static final class DownloadFileRspBody
    extends MessageMicro<DownloadFileRspBody>
  {
    public static final int BYTES_ENCRYPT_URL_FIELD_NUMBER = 1;
    public static final int STR_COOKIE_NAME_FIELD_NUMBER = 2;
    public static final int STR_COOKIE_VALUE_FIELD_NUMBER = 3;
    public static final int STR_NEW_NAME_FIELD_NUMBER = 7;
    public static final int STR_SVR_FILE_MD5_FIELD_NUMBER = 8;
    public static final int STR_SVR_FILE_NAME_FIELD_NUMBER = 11;
    public static final int STR_SVR_HOST_FIELD_NUMBER = 4;
    public static final int UINT32_PORT_FIELD_NUMBER = 5;
    public static final int UINT32_SAFE_LEVEL_FIELD_NUMBER = 6;
    public static final int UINT64_SVR_FILE_MTIME_FIELD_NUMBER = 10;
    public static final int UINT64_SVR_FILE_SIZE_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_cookie_name = PBField.initString("");
    public final PBStringField str_cookie_value = PBField.initString("");
    public final PBStringField str_new_name = PBField.initString("");
    public final PBStringField str_svr_file_md5 = PBField.initString("");
    public final PBStringField str_svr_file_name = PBField.initString("");
    public final PBStringField str_svr_host = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_safe_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_svr_file_mtime = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_svr_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 58, 66, 72, 80, 90 }, new String[] { "bytes_encrypt_url", "str_cookie_name", "str_cookie_value", "str_svr_host", "uint32_port", "uint32_safe_level", "str_new_name", "str_svr_file_md5", "uint64_svr_file_size", "uint64_svr_file_mtime", "str_svr_file_name" }, new Object[] { localByteStringMicro, "", "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Long.valueOf(0L), Long.valueOf(0L), "" }, DownloadFileRspBody.class);
    }
  }
  
  public static final class ExtensionReq
    extends MessageMicro<ExtensionReq>
  {
    public static final int BYTES_SIG_FIELD_NUMBER = 4;
    public static final int STR_DST_PHONENUM_FIELD_NUMBER = 3;
    public static final int UINT64_ID_FIELD_NUMBER = 1;
    public static final int UINT64_TYPE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_dst_phonenum = PBField.initString("");
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "bytes_sig" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro }, ExtensionReq.class);
    }
  }
  
  public static final class FileInfo
    extends MessageMicro<FileInfo>
  {
    public static final int BYTES_ENCODE_URL_FIELD_NUMBER = 6;
    public static final int BYTES_MD5_FIELD_NUMBER = 11;
    public static final int STR_COOKIE_NAME_FIELD_NUMBER = 7;
    public static final int STR_COOKIE_VALUE_FIELD_NUMBER = 8;
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
    public static final int STR_HOST_NAME_FIELD_NUMBER = 9;
    public static final int UINT32_FILE_RESOURCE_FIELD_NUMBER = 5;
    public static final int UINT32_SERVER_PORT_FIELD_NUMBER = 10;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 4;
    public static final int UINT64_MTIME_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encode_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_cookie_name = PBField.initString("");
    public final PBStringField str_cookie_value = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_host_name = PBField.initString("");
    public final PBUInt32Field uint32_file_resource = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_mtime = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 58, 66, 74, 80, 90 }, new String[] { "str_file_id", "str_file_name", "uint64_mtime", "uint64_file_size", "uint32_file_resource", "bytes_encode_url", "str_cookie_name", "str_cookie_value", "str_host_name", "uint32_server_port", "bytes_md5" }, new Object[] { "", "", Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, "", "", "", Integer.valueOf(0), localByteStringMicro2 }, FileInfo.class);
    }
  }
  
  public static final class FilePreviewReqBody
    extends MessageMicro<FilePreviewReqBody>
  {
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 2;
    public static final int UINT32_BUILD_VERSION_FIELD_NUMBER = 4;
    public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 5;
    public static final int UINT32_PREVIEW_TYPE_FIELD_NUMBER = 3;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "str_file_id", "str_file_name", "uint32_preview_type", "uint32_build_version", "uint32_client_type", "uint64_file_size" }, new Object[] { "", "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, FilePreviewReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_build_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_preview_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  }
  
  public static final class FilePreviewRspBody
    extends MessageMicro<FilePreviewRspBody>
  {
    public static final int STR_URL_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_url" }, new Object[] { "" }, FilePreviewRspBody.class);
    public final PBStringField str_url = PBField.initString("");
  }
  
  public static final class GetLibListReqBody
    extends MessageMicro<GetLibListReqBody>
  {
    public static final int STR_LIBTYPE_FIELD_NUMBER = 1;
    public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
    public static final int UINT32_OFFSET_FIELD_NUMBER = 2;
    public static final int UINT64_TIME_STAMP_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "str_libtype", "uint32_offset", "uint32_number", "uint64_time_stamp" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, GetLibListReqBody.class);
    public final PBStringField str_libtype = PBField.initString("");
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
  }
  
  public static final class GetLibListRspBody
    extends MessageMicro<GetLibListRspBody>
  {
    public static final int RPT_MSG_FILE_INFO_FIELD_NUMBER = 3;
    public static final int STR_LIBTYPE_FIELD_NUMBER = 1;
    public static final int UINT32_FILE_TOTAL_NUM_FIELD_NUMBER = 2;
    public static final int UINT64_TIME_STAMP_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "str_libtype", "uint32_file_total_num", "rpt_msg_file_info", "uint64_time_stamp" }, new Object[] { "", Integer.valueOf(0), null, Long.valueOf(0L) }, GetLibListRspBody.class);
    public final PBRepeatMessageField<Cmd0X31B.FileInfo> rpt_msg_file_info = PBField.initRepeatMessage(Cmd0X31B.FileInfo.class);
    public final PBStringField str_libtype = PBField.initString("");
    public final PBUInt32Field uint32_file_total_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_time_stamp = PBField.initUInt64(0L);
  }
  
  public static final class GetLibTypeReqBody
    extends MessageMicro<GetLibTypeReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetLibTypeReqBody.class);
  }
  
  public static final class GetLibTypeRspBody
    extends MessageMicro<GetLibTypeRspBody>
  {
    public static final int RPT_MSG_LIB_TYPE_INFO_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_lib_type_info" }, new Object[] { null }, GetLibTypeRspBody.class);
    public final PBRepeatMessageField<Cmd0X31B.LibTypeInfo> rpt_msg_lib_type_info = PBField.initRepeatMessage(Cmd0X31B.LibTypeInfo.class);
  }
  
  public static final class GetOfflineFileReqBody
    extends MessageMicro<GetOfflineFileReqBody>
  {
    public static final int UINT32_NUMBER_FIELD_NUMBER = 3;
    public static final int UINT32_OFFLINE_TYPE_FIELD_NUMBER = 1;
    public static final int UINT32_OFFSET_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_offline_type", "uint32_offset", "uint32_number" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetOfflineFileReqBody.class);
    public final PBUInt32Field uint32_number = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offline_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
  }
  
  public static final class GetOfflineFileRspBody
    extends MessageMicro<GetOfflineFileRspBody>
  {
    public static final int RPT_MSG_RECV_OFFLINE_FILE_FIELD_NUMBER = 1;
    public static final int RPT_MSG_SEND_OFFLINE_FILE_FIELD_NUMBER = 3;
    public static final int UINT32_RECV_FILE_TOTAL_FIELD_NUMBER = 2;
    public static final int UINT32_RECV_LIST_END_FIELD_NUMBER = 7;
    public static final int UINT32_SEND_FILE_TOTAL_FIELD_NUMBER = 4;
    public static final int UINT32_SEND_LIST_END_FIELD_NUMBER = 8;
    public static final int UINT64_TOT_LIMIT_FIELD_NUMBER = 5;
    public static final int UINT64_USED_LIMIT_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 56, 64 }, new String[] { "rpt_msg_recv_offline_file", "uint32_recv_file_total", "rpt_msg_send_offline_file", "uint32_send_file_total", "uint64_tot_limit", "uint64_used_limit", "uint32_recv_list_end", "uint32_send_list_end" }, new Object[] { null, Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetOfflineFileRspBody.class);
    public final PBRepeatMessageField<Cmd0X31B.OfflineFileInfo> rpt_msg_recv_offline_file = PBField.initRepeatMessage(Cmd0X31B.OfflineFileInfo.class);
    public final PBRepeatMessageField<Cmd0X31B.OfflineFileInfo> rpt_msg_send_offline_file = PBField.initRepeatMessage(Cmd0X31B.OfflineFileInfo.class);
    public final PBUInt32Field uint32_recv_file_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_recv_list_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_file_total = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_list_end = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0L);
  }
  
  public static final class LibTypeInfo
    extends MessageMicro<LibTypeInfo>
  {
    public static final int STR_LOGO_URL_FIELD_NUMBER = 5;
    public static final int STR_TYPE_DESC_FIELD_NUMBER = 2;
    public static final int STR_TYPE_NAME_FIELD_NUMBER = 1;
    public static final int UINT32_FILE_TOTAL_NUM_FIELD_NUMBER = 3;
    public static final int UINT64_TIMESTAMP_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "str_type_name", "str_type_desc", "uint32_file_total_num", "uint64_timestamp", "str_logo_url" }, new Object[] { "", "", Integer.valueOf(0), Long.valueOf(0L), "" }, LibTypeInfo.class);
    public final PBStringField str_logo_url = PBField.initString("");
    public final PBStringField str_type_desc = PBField.initString("");
    public final PBStringField str_type_name = PBField.initString("");
    public final PBUInt32Field uint32_file_total_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  }
  
  public static final class OFDownloadInfo
    extends MessageMicro<OFDownloadInfo>
  {
    public static final int BYTES_DOWNLOAD_KEY_FIELD_NUMBER = 10;
    public static final int STR_DOWNLOAD_DOMAIN_FIELD_NUMBER = 30;
    public static final int STR_DOWNLOAD_IP_FIELD_NUMBER = 20;
    public static final int UINT32_PORT_FIELD_NUMBER = 40;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_download_domain = PBField.initString("");
    public final PBStringField str_download_ip = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 320 }, new String[] { "bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port" }, new Object[] { localByteStringMicro, "", "", Integer.valueOf(0) }, OFDownloadInfo.class);
    }
  }
  
  public static final class OfflineFileInfo
    extends MessageMicro<OfflineFileInfo>
  {
    public static final int BYTES_10M_MD5_FIELD_NUMBER = 100;
    public static final int BYTES_UUID_FIELD_NUMBER = 6;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 7;
    public static final int UINT32_ABS_FILE_TYPE_FIELD_NUMBER = 90;
    public static final int UINT32_DANGER_EVEL_FIELD_NUMBER = 2;
    public static final int UINT32_LIFE_TIME_FIELD_NUMBER = 4;
    public static final int UINT32_UPLOAD_TIME_FIELD_NUMBER = 5;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 3;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 720, 802 }, new String[] { "uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2 }, OfflineFileInfo.class);
    }
  }
  
  public static final class PreviewTypeInfo
    extends MessageMicro<PreviewTypeInfo>
  {
    public static final int STR_PREVIEW_TYPE_NAME_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "str_preview_type_name" }, new Object[] { "" }, PreviewTypeInfo.class);
    public final PBStringField str_preview_type_name = PBField.initString("");
  }
  
  public static final class QCloud2FtnReqBody
    extends MessageMicro<QCloud2FtnReqBody>
  {
    public static final int BYTES_FILE_MD5_FIELD_NUMBER = 8;
    public static final int EXTENSION_REQ_FIELD_NUMBER = 100;
    public static final int STR_DST_PATH_FIELD_NUMBER = 3;
    public static final int STR_FILE_ID_FIELD_NUMBER = 4;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 5;
    public static final int UINT32_DST_BID_FIELD_NUMBER = 2;
    public static final int UINT32_FILE_RESOURCE_FIELD_NUMBER = 7;
    public static final int UINT64_DST_ID_FIELD_NUMBER = 1;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public Cmd0X31B.ExtensionReq extension_req = new Cmd0X31B.ExtensionReq();
    public final PBStringField str_dst_path = PBField.initString("/");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_dst_bid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_resource = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 56, 66, 802 }, new String[] { "uint64_dst_id", "uint32_dst_bid", "str_dst_path", "str_file_id", "str_file_name", "uint64_file_size", "uint32_file_resource", "bytes_file_md5", "extension_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "/", "", "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, null }, QCloud2FtnReqBody.class);
    }
  }
  
  public static final class QCloud2FtnRspBody
    extends MessageMicro<QCloud2FtnRspBody>
  {
    public static final int STR_FILE_PATH_FIELD_NUMBER = 1;
    public static final int UINT32_SAFE_LEVEL_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_file_path", "uint32_safe_level" }, new Object[] { "", Integer.valueOf(0) }, QCloud2FtnRspBody.class);
    public final PBStringField str_file_path = PBField.initString("");
    public final PBUInt32Field uint32_safe_level = PBField.initUInt32(0);
  }
  
  public static final class QueryPwdReqBody
    extends MessageMicro<QueryPwdReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], QueryPwdReqBody.class);
  }
  
  public static final class QueryPwdRspBody
    extends MessageMicro<QueryPwdRspBody>
  {
    public static final int UINT32_PWD_OPEN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_pwd_open" }, new Object[] { Integer.valueOf(0) }, QueryPwdRspBody.class);
    public final PBUInt32Field uint32_pwd_open = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    public static final int MSG_ALBUM_STATUS_REPORT_REQ_BODY_FIELD_NUMBER = 111;
    public static final int MSG_APPLY_OFFLINE_FILE_DOWNLOAD_REQ_FIELD_NUMBER = 102;
    public static final int MSG_DELETE_FILE_REQ_BODY_FIELD_NUMBER = 9;
    public static final int MSG_DOWNLOAD_FILE_REQ_BODY_FIELD_NUMBER = 8;
    public static final int MSG_FILE_PREVIEW_REQ_BODY_FIELD_NUMBER = 13;
    public static final int MSG_GET_LIB_LIST_REQ_BODY_FIELD_NUMBER = 4;
    public static final int MSG_GET_LIB_TYPE_REQ_BODY_FIELD_NUMBER = 3;
    public static final int MSG_GET_OFFLINE_FILE_REQ_BODY_FIELD_NUMBER = 101;
    public static final int MSG_QCLOUD2FTN_REQ_BODY_FIELD_NUMBER = 15;
    public static final int MSG_QUERYPWD_REQ_BODY_FIELD_NUMBER = 17;
    public static final int MSG_RESUME_FILE_UPLOAD_REQ_BODY_FIELD_NUMBER = 12;
    public static final int MSG_STOREFILEPREVIEW_REQ_BODY_FIELD_NUMBER = 19;
    public static final int MSG_UPLOAD2QCLOUD_REQ_BODY_FIELD_NUMBER = 7;
    public static final int MSG_VERIFYPWD_REQ_BODY_FIELD_NUMBER = 18;
    public static final int STR_APP_ID_FIELD_NUMBER = 2;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 58, 66, 74, 98, 106, 122, 138, 146, 154, 810, 818, 890 }, new String[] { "uint32_sub_cmd", "str_app_id", "msg_get_lib_type_req_body", "msg_get_lib_list_req_body", "msg_upload2qcloud_req_body", "msg_download_file_req_body", "msg_delete_file_req_body", "msg_resume_file_upload_req_body", "msg_file_preview_req_body", "msg_qcloud2ftn_req_body", "msg_querypwd_req_body", "msg_verifypwd_req_body", "msg_storefilepreview_req_body", "msg_get_offline_file_req_body", "msg_apply_offline_file_download_req", "msg_album_status_report_req_body" }, new Object[] { Integer.valueOf(0), "", null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public Cmd0X31B.AlbumStatusReportReqBody msg_album_status_report_req_body = new Cmd0X31B.AlbumStatusReportReqBody();
    public Cmd0X31B.ApplyOfflineFileDownloadReq msg_apply_offline_file_download_req = new Cmd0X31B.ApplyOfflineFileDownloadReq();
    public Cmd0X31B.DeleteFileReqBody msg_delete_file_req_body = new Cmd0X31B.DeleteFileReqBody();
    public Cmd0X31B.DownloadFileReqBody msg_download_file_req_body = new Cmd0X31B.DownloadFileReqBody();
    public Cmd0X31B.FilePreviewReqBody msg_file_preview_req_body = new Cmd0X31B.FilePreviewReqBody();
    public Cmd0X31B.GetLibListReqBody msg_get_lib_list_req_body = new Cmd0X31B.GetLibListReqBody();
    public Cmd0X31B.GetLibTypeReqBody msg_get_lib_type_req_body = new Cmd0X31B.GetLibTypeReqBody();
    public Cmd0X31B.GetOfflineFileReqBody msg_get_offline_file_req_body = new Cmd0X31B.GetOfflineFileReqBody();
    public Cmd0X31B.QCloud2FtnReqBody msg_qcloud2ftn_req_body = new Cmd0X31B.QCloud2FtnReqBody();
    public Cmd0X31B.QueryPwdReqBody msg_querypwd_req_body = new Cmd0X31B.QueryPwdReqBody();
    public Cmd0X31B.ResumeFileUploadReqBody msg_resume_file_upload_req_body = new Cmd0X31B.ResumeFileUploadReqBody();
    public Cmd0X31B.StoreFilePreviewReqBody msg_storefilepreview_req_body = new Cmd0X31B.StoreFilePreviewReqBody();
    public Cmd0X31B.Upload2QCloudReqBody msg_upload2qcloud_req_body = new Cmd0X31B.Upload2QCloudReqBody();
    public Cmd0X31B.VerifyPwdReqBody msg_verifypwd_req_body = new Cmd0X31B.VerifyPwdReqBody();
    public final PBStringField str_app_id = PBField.initString("");
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class ResumeFileUploadReqBody
    extends MessageMicro<ResumeFileUploadReqBody>
  {
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
    public static final int STR_SHA_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_file_id", "str_sha", "str_file_name" }, new Object[] { "", "", "" }, ResumeFileUploadReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_sha = PBField.initString("");
  }
  
  public static final class ResumeFileUploadRspBody
    extends MessageMicro<ResumeFileUploadRspBody>
  {
    public static final int STR_CHECK_KEY_FIELD_NUMBER = 1;
    public static final int STR_HOSTNAME_FIELD_NUMBER = 2;
    public static final int UINT32_SERVER_PORT_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "str_check_key", "str_hostname", "uint32_server_port" }, new Object[] { "", "", Integer.valueOf(0) }, ResumeFileUploadRspBody.class);
    public final PBStringField str_check_key = PBField.initString("");
    public final PBStringField str_hostname = PBField.initString("");
    public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    public static final int MSG_ALBUM_STATUS_REPORT_RSP_BODY_FIELD_NUMBER = 111;
    public static final int MSG_APPLY_OFFLINE_FILE_DOWNLOAD_RSP_FIELD_NUMBER = 102;
    public static final int MSG_DELETE_FILE_RSP_BODY_FIELD_NUMBER = 9;
    public static final int MSG_DOWNLOAD_FILE_RSP_BODY_FIELD_NUMBER = 8;
    public static final int MSG_FILE_PREVIEW_RSP_BODY_FIELD_NUMBER = 13;
    public static final int MSG_GET_LIB_LIST_RSP_BODY_FIELD_NUMBER = 4;
    public static final int MSG_GET_LIB_TYPE_RSP_BODY_FIELD_NUMBER = 3;
    public static final int MSG_GET_OFFLINE_FILE_RSP_BODY_FIELD_NUMBER = 101;
    public static final int MSG_QCLOUD2FTN_RSP_BODY_FIELD_NUMBER = 15;
    public static final int MSG_QUERYPWD_RSP_BODY_FIELD_NUMBER = 17;
    public static final int MSG_RESUME_FILE_UPLOAD_RSP_BODY_FIELD_NUMBER = 12;
    public static final int MSG_STOREFILEPREVIEW_RSP_BODY_FIELD_NUMBER = 19;
    public static final int MSG_UPLOAD2QCLOUD_RSP_BODY_FIELD_NUMBER = 7;
    public static final int MSG_VERIFYPWD_RSP_BODY_FIELD_NUMBER = 18;
    public static final int STR_CLIENT_WORDING_FIELD_NUMBER = 1001;
    public static final int STR_ERROR_MSG_FIELD_NUMBER = 1000;
    public static final int UINT32_RETURN_CODE_FIELD_NUMBER = 2;
    public static final int UINT32_SUB_CMD_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 58, 66, 74, 98, 106, 122, 138, 146, 154, 810, 818, 890, 8002, 8010 }, new String[] { "uint32_sub_cmd", "uint32_return_code", "msg_get_lib_type_rsp_body", "msg_get_lib_list_rsp_body", "msg_upload2qcloud_rsp_body", "msg_download_file_rsp_body", "msg_delete_file_rsp_body", "msg_resume_file_upload_rsp_body", "msg_file_preview_rsp_body", "msg_qcloud2ftn_rsp_body", "msg_querypwd_rsp_body", "msg_verifypwd_rsp_body", "msg_storefilepreview_rsp_body", "msg_get_offline_file_rsp_body", "msg_apply_offline_file_download_rsp", "msg_album_status_report_rsp_body", "str_error_msg", "str_client_wording" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, "", "" }, RspBody.class);
    public Cmd0X31B.AlbumStatusReportRspBody msg_album_status_report_rsp_body = new Cmd0X31B.AlbumStatusReportRspBody();
    public Cmd0X31B.ApplyOfflineFileDownloadRsp msg_apply_offline_file_download_rsp = new Cmd0X31B.ApplyOfflineFileDownloadRsp();
    public Cmd0X31B.DeleteFileRspBody msg_delete_file_rsp_body = new Cmd0X31B.DeleteFileRspBody();
    public Cmd0X31B.DownloadFileRspBody msg_download_file_rsp_body = new Cmd0X31B.DownloadFileRspBody();
    public Cmd0X31B.FilePreviewRspBody msg_file_preview_rsp_body = new Cmd0X31B.FilePreviewRspBody();
    public Cmd0X31B.GetLibListRspBody msg_get_lib_list_rsp_body = new Cmd0X31B.GetLibListRspBody();
    public Cmd0X31B.GetLibTypeRspBody msg_get_lib_type_rsp_body = new Cmd0X31B.GetLibTypeRspBody();
    public Cmd0X31B.GetOfflineFileRspBody msg_get_offline_file_rsp_body = new Cmd0X31B.GetOfflineFileRspBody();
    public Cmd0X31B.QCloud2FtnRspBody msg_qcloud2ftn_rsp_body = new Cmd0X31B.QCloud2FtnRspBody();
    public Cmd0X31B.QueryPwdRspBody msg_querypwd_rsp_body = new Cmd0X31B.QueryPwdRspBody();
    public Cmd0X31B.ResumeFileUploadRspBody msg_resume_file_upload_rsp_body = new Cmd0X31B.ResumeFileUploadRspBody();
    public Cmd0X31B.StoreFilePreviewRspBody msg_storefilepreview_rsp_body = new Cmd0X31B.StoreFilePreviewRspBody();
    public Cmd0X31B.Upload2QCloudRspBody msg_upload2qcloud_rsp_body = new Cmd0X31B.Upload2QCloudRspBody();
    public Cmd0X31B.VerifyPwdRspBody msg_verifypwd_rsp_body = new Cmd0X31B.VerifyPwdRspBody();
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_return_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
  }
  
  public static final class StoreFilePreviewReqBody
    extends MessageMicro<StoreFilePreviewReqBody>
  {
    public static final int FILE_ID_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "file_id" }, new Object[] { "" }, StoreFilePreviewReqBody.class);
    public final PBStringField file_id = PBField.initString("");
  }
  
  public static final class StoreFilePreviewRspBody
    extends MessageMicro<StoreFilePreviewRspBody>
  {
    public static final int COOKIE_FIELD_NUMBER = 6;
    public static final int DOWNLOADDNS_FIELD_NUMBER = 2;
    public static final int DOWNLOADIP_FIELD_NUMBER = 1;
    public static final int DOWNLOADKEY_FIELD_NUMBER = 5;
    public static final int DOWNLOADPORT_FIELD_NUMBER = 3;
    public static final int FILESHA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField cookie = PBField.initString("");
    public final PBStringField downloaddns = PBField.initString("");
    public final PBStringField downloadip = PBField.initString("");
    public final PBBytesField downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field downloadport = PBField.initUInt32(0);
    public final PBBytesField filesha = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "downloadip", "downloaddns", "downloadport", "filesha", "downloadkey", "cookie" }, new Object[] { "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "" }, StoreFilePreviewRspBody.class);
    }
  }
  
  public static final class Upload2QCloudReqBody
    extends MessageMicro<Upload2QCloudReqBody>
  {
    public static final int STR_FILE_NAME_FIELD_NUMBER = 3;
    public static final int STR_MD5_FIELD_NUMBER = 1;
    public static final int STR_SHA_FIELD_NUMBER = 2;
    public static final int UINT32_DST_TYPE_FIELD_NUMBER = 6;
    public static final int UINT32_UPLOAD_TYPE_FIELD_NUMBER = 4;
    public static final int UINT64_DST_UIN_FIELD_NUMBER = 7;
    public static final int UINT64_FILE_SIZE_FIELD_NUMBER = 5;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56 }, new String[] { "str_md5", "str_sha", "str_file_name", "uint32_upload_type", "uint64_file_size", "uint32_dst_type", "uint64_dst_uin" }, new Object[] { "", "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, Upload2QCloudReqBody.class);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_md5 = PBField.initString("");
    public final PBStringField str_sha = PBField.initString("");
    public final PBUInt32Field uint32_dst_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
  }
  
  public static final class Upload2QCloudRspBody
    extends MessageMicro<Upload2QCloudRspBody>
  {
    public static final int STR_CHECK_SUM_FIELD_NUMBER = 2;
    public static final int STR_FILE_ID_FIELD_NUMBER = 1;
    public static final int STR_HOST_FIELD_NUMBER = 3;
    public static final int UINT32_PORT_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "str_file_id", "str_check_sum", "str_host", "uint32_port" }, new Object[] { "", "", "", Integer.valueOf(0) }, Upload2QCloudRspBody.class);
    public final PBStringField str_check_sum = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_host = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class VerifyPwdReqBody
    extends MessageMicro<VerifyPwdReqBody>
  {
    public static final int BYTES_CS_SIG_FIELD_NUMBER = 2;
    public static final int BYTES_PWD_MD5_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pwd_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_pwd_md5", "bytes_cs_sig" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, VerifyPwdReqBody.class);
    }
  }
  
  public static final class VerifyPwdRspBody
    extends MessageMicro<VerifyPwdRspBody>
  {
    public static final int BYTES_CS_SIG_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cs_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_cs_sig" }, new Object[] { localByteStringMicro }, VerifyPwdRspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x31b.Cmd0X31B
 * JD-Core Version:    0.7.0.1
 */