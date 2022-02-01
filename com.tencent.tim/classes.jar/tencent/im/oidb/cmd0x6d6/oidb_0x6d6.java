package tencent.im.oidb.cmd0x6d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6d6
{
  public static final class DeleteFileReqBody
    extends MessageMicro<DeleteFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 48, 56 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_parent_folder_id", "str_file_id", "uint32_msgdb_seq", "uint32_msg_rand" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0) }, DeleteFileReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_rand = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msgdb_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class DeleteFileRspBody
    extends MessageMicro<DeleteFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording" }, new Object[] { Integer.valueOf(0), "", "" }, DeleteFileRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class DownloadFileReqBody
    extends MessageMicro<DownloadFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 56, 64 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "bool_thumbnail_req", "uint32_url_type", "bool_preview_req", "uint32_src" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, DownloadFileReqBody.class);
    public final PBBoolField bool_preview_req = PBField.initBool(false);
    public final PBBoolField bool_thumbnail_req = PBField.initBool(false);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src = PBField.initUInt32(0);
    public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class DownloadFileRspBody
    extends MessageMicro<DownloadFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_val = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBBytesField str_download_dns = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_download_dns_https = PBField.initString("");
    public final PBStringField str_download_ip = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_save_file_name = PBField.initString("");
    public final PBUInt32Field uint32_preview_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_preview_port_https = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 112 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_download_ip", "str_download_dns", "bytes_download_url", "bytes_sha", "bytes_sha3", "bytes_md5", "bytes_cookie_val", "str_save_file_name", "uint32_preview_port", "str_download_dns_https", "uint32_preview_port_https" }, new Object[] { Integer.valueOf(0), "", "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, "", Integer.valueOf(0), "", Integer.valueOf(0) }, DownloadFileRspBody.class);
    }
  }
  
  public static final class MoveFileReqBody
    extends MessageMicro<MoveFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "str_parent_folder_id", "str_dest_folder_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, MoveFileReqBody.class);
    public final PBStringField str_dest_folder_id = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class MoveFileRspBody
    extends MessageMicro<MoveFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_parent_folder_id" }, new Object[] { Integer.valueOf(0), "", "", "" }, MoveFileRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class RenameFileReqBody
    extends MessageMicro<RenameFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "str_parent_folder_id", "str_new_file_name" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", "", "" }, RenameFileReqBody.class);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_new_file_name = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  }
  
  public static final class RenameFileRspBody
    extends MessageMicro<RenameFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording" }, new Object[] { Integer.valueOf(0), "", "" }, RenameFileRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "upload_file_req", "resend_file_req", "download_file_req", "delete_file_req", "rename_file_req", "move_file_req" }, new Object[] { null, null, null, null, null, null }, ReqBody.class);
    public oidb_0x6d6.DeleteFileReqBody delete_file_req = new oidb_0x6d6.DeleteFileReqBody();
    public oidb_0x6d6.DownloadFileReqBody download_file_req = new oidb_0x6d6.DownloadFileReqBody();
    public oidb_0x6d6.MoveFileReqBody move_file_req = new oidb_0x6d6.MoveFileReqBody();
    public oidb_0x6d6.RenameFileReqBody rename_file_req = new oidb_0x6d6.RenameFileReqBody();
    public oidb_0x6d6.ResendReqBody resend_file_req = new oidb_0x6d6.ResendReqBody();
    public oidb_0x6d6.UploadFileReqBody upload_file_req = new oidb_0x6d6.UploadFileReqBody();
  }
  
  public static final class ResendReqBody
    extends MessageMicro<ResendReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "str_file_id", "bytes_sha" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro }, ResendReqBody.class);
    }
  }
  
  public static final class ResendRspBody
    extends MessageMicro<ResendRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "bytes_file_key", "bytes_check_key" }, new Object[] { Integer.valueOf(0), "", "", "", localByteStringMicro1, localByteStringMicro2 }, ResendRspBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "upload_file_rsp", "resend_file_rsp", "download_file_rsp", "delete_file_rsp", "rename_file_rsp", "move_file_rsp" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
    public oidb_0x6d6.DeleteFileRspBody delete_file_rsp = new oidb_0x6d6.DeleteFileRspBody();
    public oidb_0x6d6.DownloadFileRspBody download_file_rsp = new oidb_0x6d6.DownloadFileRspBody();
    public oidb_0x6d6.MoveFileRspBody move_file_rsp = new oidb_0x6d6.MoveFileRspBody();
    public oidb_0x6d6.RenameFileRspBody rename_file_rsp = new oidb_0x6d6.RenameFileRspBody();
    public oidb_0x6d6.ResendRspBody resend_file_rsp = new oidb_0x6d6.ResendRspBody();
    public oidb_0x6d6.UploadFileRspBody upload_file_rsp = new oidb_0x6d6.UploadFileRspBody();
  }
  
  public static final class UploadFileReqBody
    extends MessageMicro<UploadFileReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_support_multi_upload = PBField.initBool(false);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_path = PBField.initString("");
    public final PBStringField str_parent_folder_id = PBField.initString("");
    public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 64, 74, 82, 90, 120 }, new String[] { "uint64_group_code", "uint32_app_id", "uint32_bus_id", "uint32_entrance", "str_parent_folder_id", "str_file_name", "str_local_path", "uint64_file_size", "bytes_sha", "bytes_sha3", "bytes_md5", "bool_support_multi_upload" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", "", Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false) }, UploadFileReqBody.class);
    }
  }
  
  public static final class UploadFileRspBody
    extends MessageMicro<UploadFileRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_client_wording = PBField.initString("");
    public final PBStringField str_file_id = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_server_dns = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBRepeatField<String> str_upload_ip_lan_v4 = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> str_upload_ip_lan_v6 = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_bus_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 80, 98, 106, 112 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "str_upload_ip", "str_server_dns", "uint32_bus_id", "str_file_id", "bytes_file_key", "bytes_check_key", "bool_file_exist", "str_upload_ip_lan_v4", "str_upload_ip_lan_v6", "uint32_upload_port" }, new Object[] { Integer.valueOf(0), "", "", "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), "", "", Integer.valueOf(0) }, UploadFileRspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d6.oidb_0x6d6
 * JD-Core Version:    0.7.0.1
 */