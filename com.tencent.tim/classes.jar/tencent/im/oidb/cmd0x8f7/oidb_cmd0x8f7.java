package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f7
{
  public static final class ApplyDelReqBody
    extends MessageMicro<ApplyDelReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> rpt_bytes_uuid = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_bytes_uuid" }, new Object[] { localByteStringMicro }, ApplyDelReqBody.class);
    }
  }
  
  public static final class ApplyDelRspBody
    extends MessageMicro<ApplyDelRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyDelRspBody.class);
  }
  
  public static final class ApplyDownAbsReq
    extends MessageMicro<ApplyDownAbsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_uuid" }, new Object[] { localByteStringMicro }, ApplyDownAbsReq.class);
    }
  }
  
  public static final class ApplyDownAbsRsp
    extends MessageMicro<ApplyDownAbsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_dns = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_download_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50 }, new String[] { "uint32_download_ip", "bytes_download_dns", "uint32_download_port", "bytes_file_sha", "bytes_download_key", "bytes_cookie" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4 }, ApplyDownAbsRsp.class);
    }
  }
  
  public static final class ApplyDownloadReqBody
    extends MessageMicro<ApplyDownloadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_url_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 72 }, new String[] { "bytes_uuid", "uint32_url_type" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ApplyDownloadReqBody.class);
    }
  }
  
  public static final class ApplyDownloadRspBody
    extends MessageMicro<ApplyDownloadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cookie_val = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_server_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_download_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "bytes_server_name", "bytes_url", "uint32_download_port", "bytes_cookie_name", "bytes_cookie_val", "uint32_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, ApplyDownloadRspBody.class);
    }
  }
  
  public static final class ApplyUploadReqBody
    extends MessageMicro<ApplyUploadReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_modify_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48 }, new String[] { "bytes_file_name", "uint64_file_size", "bytes_sha", "bytes_md5", "uint64_modify_time", "uint32_upload_type" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0) }, ApplyUploadReqBody.class);
    }
  }
  
  public static final class ApplyUploadRspBody
    extends MessageMicro<ApplyUploadRspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBytesField bytes_check_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_conflict_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_random_sha = PBField.initBytes(ByteStringMicro.copyFromUtf8(""));
    public final PBBytesField bytes_server_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_expired_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_server_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_uploadip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.copyFromUtf8("");
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64, 72, 80 }, new String[] { "bool_file_exist", "bytes_uuid", "bytes_check_key", "bytes_server_name", "uint32_server_port", "bytes_random_sha", "bytes_conflict_key", "uint32_expired_time", "uint32_version", "uint32_uploadip" }, new Object[] { Boolean.valueOf(false), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ApplyUploadRspBody.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_cmd0x8f7.ApplyDelReqBody msg_del_req_body = new oidb_cmd0x8f7.ApplyDelReqBody();
    public oidb_cmd0x8f7.ApplyDownAbsReq msg_downabs_req_body = new oidb_cmd0x8f7.ApplyDownAbsReq();
    public oidb_cmd0x8f7.ApplyDownloadReqBody msg_download_req_body = new oidb_cmd0x8f7.ApplyDownloadReqBody();
    public oidb_cmd0x8f7.SourceID msg_source_id = new oidb_cmd0x8f7.SourceID();
    public oidb_cmd0x8f7.ApplyUploadReqBody msg_upload_req_body = new oidb_cmd0x8f7.ApplyUploadReqBody();
    public final PBUInt32Field uint32_client_net = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 90, 98, 106, 114 }, new String[] { "uint32_subcmd", "msg_source_id", "uint32_client_type", "uint32_client_net", "uint32_client_ver", "bytes_workflow_id", "uint64_appid", "msg_upload_req_body", "msg_download_req_body", "msg_downabs_req_body", "msg_del_req_body" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null, null, null, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ret_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public oidb_cmd0x8f7.ApplyDelRspBody msg_del_rsp_body = new oidb_cmd0x8f7.ApplyDelRspBody();
    public oidb_cmd0x8f7.ApplyDownAbsRsp msg_downabs_rsp_body = new oidb_cmd0x8f7.ApplyDownAbsRsp();
    public oidb_cmd0x8f7.ApplyDownloadRspBody msg_download_rsp_body = new oidb_cmd0x8f7.ApplyDownloadRspBody();
    public oidb_cmd0x8f7.SourceID msg_source_id = new oidb_cmd0x8f7.SourceID();
    public oidb_cmd0x8f7.ApplyUploadRspBody msg_upload_rsp_body = new oidb_cmd0x8f7.ApplyUploadRspBody();
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 90, 98, 106, 114 }, new String[] { "int32_ret_code", "bytes_ret_msg", "uint32_subcmd", "msg_source_id", "bytes_workflow_id", "uint64_appid", "msg_upload_rsp_body", "msg_download_rsp_body", "msg_downabs_rsp_body", "msg_del_rsp_body" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, Long.valueOf(0L), null, null, null, null }, RspBody.class);
    }
  }
  
  public static final class SourceID
    extends MessageMicro<SourceID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_source_type", "uint64_source_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7
 * JD-Core Version:    0.7.0.1
 */