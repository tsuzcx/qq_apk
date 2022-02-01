package tencent.im.cs.cmd0x345;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x345
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "uint32_sub_cmd", "msg_subcmd_0x1_req_body", "msg_subcmd_0x2_req_body", "msg_subcmd_0x3_req_body", "msg_subcmd_0x4_req_body", "msg_subcmd_0x5_req_body", "msg_subcmd_0x6_req_body", "msg_subcmd_0x7_req_body", "msg_subcmd_0x9_req_body", "msg_subcmd_0xa_req_body" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public SubCmd0x1ReqBody msg_subcmd_0x1_req_body = new SubCmd0x1ReqBody();
    public SubCmd0x2ReqBody msg_subcmd_0x2_req_body = new SubCmd0x2ReqBody();
    public SubCmd0x3ReqBody msg_subcmd_0x3_req_body = new SubCmd0x3ReqBody();
    public SubCmd0x4ReqBody msg_subcmd_0x4_req_body = new SubCmd0x4ReqBody();
    public SubCmd0x5ReqBody msg_subcmd_0x5_req_body = new SubCmd0x5ReqBody();
    public SubCmd0x6ReqBody msg_subcmd_0x6_req_body = new SubCmd0x6ReqBody();
    public SubCmd0x7ReqBody msg_subcmd_0x7_req_body = new SubCmd0x7ReqBody();
    public SubCmd0x9ReqBody msg_subcmd_0x9_req_body = new SubCmd0x9ReqBody();
    public SubCmd0xaReqBody msg_subcmd_0xa_req_body = new SubCmd0xaReqBody();
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    public static final class SubCmd0x1ReqBody
      extends MessageMicro<SubCmd0x1ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64 }, new String[] { "str_md5", "str_sha", "str_file_name", "uint64_file_size", "uint32_upload_type", "uint32_disscus_uin", "uint32_sender_uin", "uint32_costom_id" }, new Object[] { "", "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x1ReqBody.class);
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_md5 = PBField.initString("");
      public final PBStringField str_sha = PBField.initString("");
      public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_upload_type = PBField.initUInt32(0);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x2ReqBody
      extends MessageMicro<SubCmd0x2ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_pb_bytes_reserve = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_batch_id = PBField.initString("");
      public final PBStringField str_batch_item_id = PBField.initString("");
      public final PBStringField str_client_key = PBField.initString("");
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_file_key = PBField.initString("");
      public final PBStringField str_file_name = PBField.initString("");
      public final PBUInt32Field uint32_busid = PBField.initUInt32(0);
      public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_mark = PBField.initUInt32(0);
      public final PBUInt32Field uint32_random = PBField.initUInt32(0);
      public final PBUInt32Field uint32_sender_uin = PBField.initUInt32(0);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_sequence = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66, 74, 80, 88, 96, 104, 112, 122 }, new String[] { "uint32_disscus_uin", "uint32_sender_uin", "str_file_name", "uint64_file_size", "str_file_id", "str_batch_id", "str_batch_item_id", "str_client_key", "str_file_key", "uint32_mark", "uint64_time", "uint64_sequence", "uint32_busid", "uint32_random", "bytes_pb_bytes_reserve" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro }, SubCmd0x2ReqBody.class);
      }
    }
    
    public static final class SubCmd0x3ReqBody
      extends MessageMicro<SubCmd0x3ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "uint32_uin", "str_file_id", "uint32_disscus_uin", "uint32_costom_id", "uint64_uin", "uint64_disscus_uin" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, SubCmd0x3ReqBody.class);
      public final PBStringField str_file_id = PBField.initString("");
      public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_disscus_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_uin = PBField.initUInt32(0);
      public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x4ReqBody
      extends MessageMicro<SubCmd0x4ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x4ReqBody.class);
    }
    
    public static final class SubCmd0x5ReqBody
      extends MessageMicro<SubCmd0x5ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_src_file_path = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_src_parent_folder = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_file_name = PBField.initString("");
      public final PBUInt32Field uint32_dst_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_from_uin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_src_bus_id = PBField.initUInt32(0);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 58, 66 }, new String[] { "uint32_src_bus_id", "bytes_src_parent_folder", "bytes_src_file_path", "uint32_dst_uin", "uint64_file_size", "uint32_from_uin", "str_file_name", "bytes_md5" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", localByteStringMicro3 }, SubCmd0x5ReqBody.class);
      }
    }
    
    public static final class SubCmd0x6ReqBody
      extends MessageMicro<SubCmd0x6ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_tim_cloud_extension_info = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_tim_cloud_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_tim_cloud_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_dst_phone_number = PBField.initString("");
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_src_file_path = PBField.initString("");
      public final PBStringField str_src_parent_folder = PBField.initString("");
      public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
      public final PBUInt32Field uint32_dst_bus_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_tim_file_exist_option = PBField.initUInt32(0);
      public final PBUInt64Field uint64_app_id = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_talk_type = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 74, 80, 88, 98, 106, 112, 802, 810, 818, 824 }, new String[] { "uint32_dst_bus_id", "uint64_src_uin", "bytes_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "str_src_file_path", "str_src_parent_folder", "uint32_client_type", "uint64_app_id", "str_dst_phone_number", "bytes_sig", "uint64_talk_type", "bytes_tim_cloud_pdir_key", "bytes_tim_cloud_ppdir_key", "bytes_tim_cloud_extension_info", "uint32_tim_file_exist_option" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Long.valueOf(0L), "", localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0) }, SubCmd0x6ReqBody.class);
      }
    }
    
    public static final class SubCmd0x7ReqBody
      extends MessageMicro<SubCmd0x7ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_disscus_uin", "str_file_path" }, new Object[] { Long.valueOf(0L), "" }, SubCmd0x7ReqBody.class);
      public final PBStringField str_file_path = PBField.initString("");
      public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x9ReqBody
      extends MessageMicro<SubCmd0x9ReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_disscus_uin", "uint32_begin", "uint32_file_num" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x9ReqBody.class);
      public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
      public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0xaReqBody
      extends MessageMicro<SubCmd0xaReqBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "uint64_uin", "uint64_disscus_uin", "str_file_id", "str_session_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "" }, SubCmd0xaReqBody.class);
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_session_info = PBField.initString("");
      public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90 }, new String[] { "uint32_sub_cmd", "uint32_return_code", "msg_subcmd_0x1_rsp_body", "msg_subcmd_0x2_rsp_body", "msg_subcmd_0x3_rsp_body", "msg_subcmd_0x4_rsp_body", "msg_subcmd_0x5_rsp_body", "msg_subcmd_0x6_rsp_body", "msg_subcmd_0x7_rsp_body", "msg_subcmd_0x9_rsp_body", "msg_subcmd_0xa_rsp_body" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null }, RspBody.class);
    public SubCmd0x1RspBody msg_subcmd_0x1_rsp_body = new SubCmd0x1RspBody();
    public SubCmd0x2RspBody msg_subcmd_0x2_rsp_body = new SubCmd0x2RspBody();
    public SubCmd0x3RspBody msg_subcmd_0x3_rsp_body = new SubCmd0x3RspBody();
    public SubCmd0x4RspBody msg_subcmd_0x4_rsp_body = new SubCmd0x4RspBody();
    public SubCmd0x5RspBody msg_subcmd_0x5_rsp_body = new SubCmd0x5RspBody();
    public SubCmd0x6RspBody msg_subcmd_0x6_rsp_body = new SubCmd0x6RspBody();
    public SubCmd0x7RspBody msg_subcmd_0x7_rsp_body = new SubCmd0x7RspBody();
    public SubCmd0x9RspBody msg_subcmd_0x9_rsp_body = new SubCmd0x9RspBody();
    public SubCmd0xaRspBody msg_subcmd_0xa_rsp_body = new SubCmd0xaRspBody();
    public final PBUInt32Field uint32_return_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    
    public static final class FileAttr
      extends MessageMicro<FileAttr>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sha3 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_file_path = PBField.initString("");
      public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_download_times = PBField.initUInt32(0);
      public final PBUInt32Field uint32_modify_time = PBField.initUInt32(0);
      public final PBUInt32Field uint32_owner = PBField.initUInt32(0);
      public final PBUInt32Field uint32_trans_from = PBField.initUInt32(0);
      public final PBUInt32Field uint32_ttl = PBField.initUInt32(0);
      public final PBUInt32Field uint32_upload_uin = PBField.initUInt32(0);
      public final PBUInt64Field uint64_size = PBField.initUInt64(0L);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 104 }, new String[] { "uint64_size", "uint32_ttl", "uint32_download_times", "uint32_owner", "uint32_trans_from", "str_file_path", "bytes_md5", "bytes_sha", "bytes_sha3", "str_file_name", "uint32_create_time", "uint32_modify_time", "uint32_upload_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, FileAttr.class);
      }
    }
    
    public static final class SubCmd0x1RspBody
      extends MessageMicro<SubCmd0x1RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "str_file_id", "str_check_sum", "str_host", "uint32_port", "str_file_key", "str_file_name", "str_warn", "uint32_costom_id", "uint32_https_port", "str_https_domain", "str_dns" }, new Object[] { "", "", "", Integer.valueOf(80), "", "", "", Integer.valueOf(0), Integer.valueOf(443), "", "" }, SubCmd0x1RspBody.class);
      public final PBStringField str_check_sum = PBField.initString("");
      public final PBStringField str_dns = PBField.initString("");
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_file_key = PBField.initString("");
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_host = PBField.initString("");
      public final PBStringField str_https_domain = PBField.initString("");
      public final PBStringField str_warn = PBField.initString("");
      public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
      public final PBUInt32Field uint32_port = PBField.initUInt32(80);
    }
    
    public static final class SubCmd0x2RspBody
      extends MessageMicro<SubCmd0x2RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubCmd0x2RspBody.class);
    }
    
    public static final class SubCmd0x3RspBody
      extends MessageMicro<SubCmd0x3RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBInt32Field int32_ret_code = PBField.initInt32(0);
      public final PBStringField str_check_sum = PBField.initString("");
      public final PBStringField str_cookie = PBField.initString("");
      public final PBStringField str_dns = PBField.initString("");
      public final PBStringField str_host = PBField.initString("");
      public final PBStringField str_https_domain = PBField.initString("");
      public final PBStringField str_ret_msg = PBField.initString("");
      public final PBStringField str_suggest_file_name = PBField.initString("");
      public final PBUInt32Field uint32_costom_id = PBField.initUInt32(0);
      public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
      public final PBUInt32Field uint32_port = PBField.initUInt32(80);
      
      static
      {
        ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 50, 56, 66, 74, 80, 90, 98 }, new String[] { "str_host", "uint32_port", "str_check_sum", "str_cookie", "uint32_costom_id", "str_ret_msg", "int32_ret_code", "str_suggest_file_name", "bytes_sha", "uint32_https_port", "str_https_domain", "str_dns" }, new Object[] { "", Integer.valueOf(80), "", "", Integer.valueOf(0), "", Integer.valueOf(0), "", localByteStringMicro, Integer.valueOf(443), "", "" }, SubCmd0x3RspBody.class);
      }
    }
    
    public static final class SubCmd0x4RspBody
      extends MessageMicro<SubCmd0x4RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_max_transfer_file_count", "uint64_max_transfer_single_file_size", "uint32_max_transfer_file_queue_num", "uint32_max_download_file_num" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SubCmd0x4RspBody.class);
      public final PBUInt32Field uint32_max_download_file_num = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_transfer_file_count = PBField.initUInt32(0);
      public final PBUInt32Field uint32_max_transfer_file_queue_num = PBField.initUInt32(0);
      public final PBUInt64Field uint64_max_transfer_single_file_size = PBField.initUInt64(0L);
    }
    
    public static final class SubCmd0x5RspBody
      extends MessageMicro<SubCmd0x5RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_ret_msg", "str_file_id" }, new Object[] { "", "" }, SubCmd0x5RspBody.class);
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_ret_msg = PBField.initString("");
    }
    
    public static final class SubCmd0x6RspBody
      extends MessageMicro<SubCmd0x6RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_ret_msg", "str_file_id", "str_file_name" }, new Object[] { "", "", "" }, SubCmd0x6RspBody.class);
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_file_name = PBField.initString("");
      public final PBStringField str_ret_msg = PBField.initString("");
    }
    
    public static final class SubCmd0x7RspBody
      extends MessageMicro<SubCmd0x7RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_thri_sha = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBStringField str_dns = PBField.initString("");
      public final PBStringField str_https_domain = PBField.initString("");
      public final PBStringField str_ret_msg = PBField.initString("");
      public final PBStringField str_server_ip = PBField.initString("");
      public final PBStringField str_url = PBField.initString("");
      public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
      public final PBFixed32Field uint32_server_port = PBField.initFixed32(0);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 21, 26, 34, 42, 50, 58, 66, 74, 80, 90 }, new String[] { "str_server_ip", "uint32_server_port", "str_dns", "str_url", "bytes_sha", "bytes_thri_sha", "bytes_md5", "bytes_cookie", "str_ret_msg", "uint32_https_port", "str_https_domain" }, new Object[] { "", Integer.valueOf(0), "", "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, "", Integer.valueOf(443), "" }, SubCmd0x7RspBody.class);
      }
    }
    
    public static final class SubCmd0x9RspBody
      extends MessageMicro<SubCmd0x9RspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_begin", "uint32_total_file_num", "uint32_file_num", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, SubCmd0x9RspBody.class);
      public final PBRepeatMessageField<cmd0x345.RspBody.FileAttr> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x345.RspBody.FileAttr.class);
      public final PBUInt32Field uint32_begin = PBField.initUInt32(0);
      public final PBUInt32Field uint32_file_num = PBField.initUInt32(0);
      public final PBUInt32Field uint32_total_file_num = PBField.initUInt32(0);
    }
    
    public static final class SubCmd0xaRspBody
      extends MessageMicro<SubCmd0xaRspBody>
    {
      static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint64_uin", "uint64_disscus_uin", "str_file_id", "str_session_info", "str_ret_msg" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", "", "" }, SubCmd0xaRspBody.class);
      public final PBStringField str_file_id = PBField.initString("");
      public final PBStringField str_ret_msg = PBField.initString("");
      public final PBStringField str_session_info = PBField.initString("");
      public final PBUInt64Field uint64_disscus_uin = PBField.initUInt64(0L);
      public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x345.cmd0x345
 * JD-Core Version:    0.7.0.1
 */