package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x346
{
  public static final class Addr
    extends MessageMicro<Addr>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint32_out_ip", "uint32_out_port", "uint32_inner_ip", "uint32_inner_port", "uint32_ip_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, Addr.class);
    public final PBUInt32Field uint32_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_inner_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ip_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_out_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_out_port = PBField.initUInt32(0);
  }
  
  public static final class AddrList
    extends MessageMicro<AddrList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 26, 32 }, new String[] { "rpt_str_ip", "rpt_str_domain", "uint32_port" }, new Object[] { "", "", Integer.valueOf(0) }, AddrList.class);
    public final PBStringField rpt_str_domain = PBField.initString("");
    public final PBRepeatField<String> rpt_str_ip = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class ApplyCleanTrafficReq
    extends MessageMicro<ApplyCleanTrafficReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyCleanTrafficReq.class);
  }
  
  public static final class ApplyCleanTrafficRsp
    extends MessageMicro<ApplyCleanTrafficRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, ApplyCleanTrafficRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ApplyCopyFromReq
    extends MessageMicro<ApplyCopyFromReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_parentfolder = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_src_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_svcid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_group = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 560, 640, 722, 800, 880 }, new String[] { "uint64_src_uin", "uint64_src_group", "uint32_src_svcid", "bytes_src_parentfolder", "bytes_src_uuid", "bytes_file_md5", "uint64_dst_uin", "uint64_file_size", "str_file_name", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyCopyFromReq.class);
    }
  }
  
  public static final class ApplyCopyFromRsp
    extends MessageMicro<ApplyCopyFromRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320 }, new String[] { "int32_ret_code", "str_ret_msg", "bytes_uuid", "uint64_total_space" }, new Object[] { Integer.valueOf(0), "", localByteStringMicro, Long.valueOf(0L) }, ApplyCopyFromRsp.class);
    }
  }
  
  public static final class ApplyCopyToReq
    extends MessageMicro<ApplyCopyToReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_dst_svcid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dst_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_dst_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 320, 400, 482, 562, 642 }, new String[] { "uint64_dst_id", "uint64_dst_uin", "uint32_dst_svcid", "uint64_src_uin", "uint64_file_size", "str_file_name", "str_local_filepath", "bytes_uuid" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), "", "", localByteStringMicro }, ApplyCopyToReq.class);
    }
  }
  
  public static final class ApplyCopyToRsp
    extends MessageMicro<ApplyCopyToRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 322 }, new String[] { "int32_ret_code", "str_ret_msg", "str_file_key", "str_file_name" }, new Object[] { Integer.valueOf(0), "", "", "" }, ApplyCopyToRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_file_key = PBField.initString("");
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ApplyDownloadAbsReq
    extends MessageMicro<ApplyDownloadAbsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "uint64_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), localByteStringMicro, "" }, ApplyDownloadAbsReq.class);
    }
  }
  
  public static final class ApplyDownloadAbsRsp
    extends MessageMicro<ApplyDownloadAbsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "int32_ret_code", "str_ret_msg", "msg_download_info" }, new Object[] { Integer.valueOf(0), "", null }, ApplyDownloadAbsRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public cmd0x346.DownloadInfo msg_download_info = new cmd0x346.DownloadInfo();
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ApplyDownloadReq
    extends MessageMicro<ApplyDownloadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt32Field uint32_ext_uintype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filetype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_https_url = PBField.initUInt32(0);
    public final PBUInt32Field uint32_owner_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 400, 482, 4000, 4008 }, new String[] { "uint64_uin", "bytes_uuid", "uint32_owner_type", "uint32_filetype", "str_fileidcrc", "uint32_ext_uintype", "uint32_need_https_url" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0) }, ApplyDownloadReq.class);
    }
  }
  
  public static final class ApplyDownloadRsp
    extends MessageMicro<ApplyDownloadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public cmd0x346.DownloadInfo msg_download_info = new cmd0x346.DownloadInfo();
    public cmd0x346.FileInfo msg_file_info = new cmd0x346.FileInfo();
    public final PBStringField str_ret_msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 322, 402 }, new String[] { "int32_ret_code", "str_ret_msg", "msg_download_info", "msg_file_info", "bytes_file_sha" }, new Object[] { Integer.valueOf(0), "", null, null, localByteStringMicro }, ApplyDownloadRsp.class);
    }
  }
  
  public static final class ApplyForwardFileReq
    extends MessageMicro<ApplyForwardFileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 320, 400, 482 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "bytes_uuid", "uint32_danger_level", "uint64_total_space", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), "" }, ApplyForwardFileReq.class);
    }
  }
  
  public static final class ApplyForwardFileRsp
    extends MessageMicro<ApplyForwardFileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 402, 482 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "bytes_uuid", "str_fileidcrc" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, "" }, ApplyForwardFileRsp.class);
    }
  }
  
  public static final class ApplyGetTrafficReq
    extends MessageMicro<ApplyGetTrafficReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ApplyGetTrafficReq.class);
  }
  
  public static final class ApplyGetTrafficRsp
    extends MessageMicro<ApplyGetTrafficRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_use_file_size", "uint32_use_file_num", "uint64_all_file_size", "uint32_all_file_num" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, ApplyGetTrafficRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_all_file_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_use_file_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_all_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_use_file_size = PBField.initUInt64(0L);
  }
  
  public static final class ApplyListDownloadReq
    extends MessageMicro<ApplyListDownloadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240 }, new String[] { "uint64_uin", "uint32_begin_index", "uint32_req_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ApplyListDownloadReq.class);
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ApplyListDownloadRsp
    extends MessageMicro<ApplyListDownloadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 480, 562 }, new String[] { "int32_ret_code", "str_ret_msg", "uint32_total_count", "uint32_begin_index", "uint32_rsp_count", "uint32_is_end", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ApplyListDownloadRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x346.FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346.FileInfo.class);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  }
  
  public static final class ApplyUploadHitReq
    extends MessageMicro<ApplyUploadHitReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 560, 640 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadHitReq.class);
    }
  }
  
  public static final class ApplyUploadHitReqV2
    extends MessageMicro<ApplyUploadHitReqV2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_3sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 562, 642, 720, 800 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_3sha", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadHitReqV2.class);
    }
  }
  
  public static final class ApplyUploadHitReqV3
    extends MessageMicro<ApplyUploadHitReqV3>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 562, 640, 720 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadHitReqV3.class);
    }
  }
  
  public static final class ApplyUploadHitRsp
    extends MessageMicro<ApplyUploadHitRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320, 402, 482, 562, 640, 720, 802 }, new String[] { "int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "str_upload_dns" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), "" }, ApplyUploadHitRsp.class);
    }
  }
  
  public static final class ApplyUploadHitRspV2
    extends MessageMicro<ApplyUploadHitRspV2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_https_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_upload_https_port = PBField.initUInt32(443);
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320, 402, 482, 562, 640, 720, 800, 882, 962 }, new String[] { "int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(443), "", "" }, ApplyUploadHitRspV2.class);
    }
  }
  
  public static final class ApplyUploadHitRspV3
    extends MessageMicro<ApplyUploadHitRspV3>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242, 320, 402, 482, 562, 640, 720, 802 }, new String[] { "int32_ret_code", "str_ret_msg", "str_upload_ip", "uint32_upload_port", "str_upload_domain", "bytes_uuid", "bytes_upload_key", "uint64_total_space", "uint64_used_space", "str_upload_dns" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0), "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L), "" }, ApplyUploadHitRspV3.class);
    }
  }
  
  public static final class ApplyUploadReq
    extends MessageMicro<ApplyUploadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 320, 402, 482, 562, 640, 720 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint32_file_type", "uint64_file_size", "str_file_name", "bytes_10m_md5", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), "", localByteStringMicro, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadReq.class);
    }
  }
  
  public static final class ApplyUploadReqV2
    extends MessageMicro<ApplyUploadReqV2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_3sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 562, 640, 720 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_3sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), Long.valueOf(0L) }, ApplyUploadReqV2.class);
    }
  }
  
  public static final class ApplyUploadReqV3
    extends MessageMicro<ApplyUploadReqV3>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_3sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_local_filepath = PBField.initString("");
    public final PBEnumField uint32_contenttype = PBField.initEnum(0);
    public final PBUInt32Field uint32_danger_level = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402, 482, 562, 640, 720, 800, 882, 962 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "uint64_file_size", "str_file_name", "bytes_10m_md5", "bytes_sha", "str_local_filepath", "uint32_danger_level", "uint64_total_space", "uint32_contenttype", "bytes_md5", "bytes_3sha" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", localByteStringMicro1, localByteStringMicro2, "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4 }, ApplyUploadReqV3.class);
    }
  }
  
  public static final class ApplyUploadRsp
    extends MessageMicro<ApplyUploadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatField<String> rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 482, 562, 640, 722, 802, 880, 960, 1042, 1122 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "str_upload_dns" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), "", "" }, ApplyUploadRsp.class);
    }
  }
  
  public static final class ApplyUploadRspV2
    extends MessageMicro<ApplyUploadRspV2>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatField<String> rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_https_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBStringField str_upload_lanip = PBField.initString("");
    public final PBUInt32Field uint32_httpsvr_api_ver = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_https_port = PBField.initUInt32(443);
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 482, 562, 640, 722, 802, 880, 960, 1042, 1120, 1130, 1136, 1146, 1202, 1282 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "uint32_httpsvr_api_ver", "bytes_sha", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns", "str_upload_lanip" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(443), "", "", "" }, ApplyUploadRspV2.class);
    }
  }
  
  public static final class ApplyUploadRspV3
    extends MessageMicro<ApplyUploadRspV3>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_file_exist = PBField.initBool(false);
    public final PBBytesField bytes_media_plateform_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_upload_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatField<String> rpt_str_uploadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<cmd0x346.Addr> rtp_media_platform_upload_address = PBField.initRepeatMessage(cmd0x346.Addr.class);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBStringField str_upload_dns = PBField.initString("");
    public final PBStringField str_upload_domain = PBField.initString("");
    public final PBStringField str_upload_https_domain = PBField.initString("");
    public final PBStringField str_upload_ip = PBField.initString("");
    public final PBStringField str_upload_lanip = PBField.initString("");
    public final PBUInt32Field uint32_pack_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_https_port = PBField.initUInt32(443);
    public final PBUInt32Field uint32_upload_port = PBField.initUInt32(0);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uploaded_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_space = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240, 320, 400, 482, 562, 640, 722, 802, 880, 960, 1042, 1120, 1202, 1282, 1362, 1602, 1682, 1762 }, new String[] { "int32_ret_code", "str_ret_msg", "uint64_total_space", "uint64_used_space", "uint64_uploaded_size", "str_upload_ip", "str_upload_domain", "uint32_upload_port", "bytes_uuid", "bytes_upload_key", "bool_file_exist", "uint32_pack_size", "rpt_str_uploadip_list", "uint32_upload_https_port", "str_upload_https_domain", "str_upload_dns", "str_upload_lanip", "str_fileidcrc", "rtp_media_platform_upload_address", "bytes_media_plateform_upload_key" }, new Object[] { Integer.valueOf(0), "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), "", "", Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Boolean.valueOf(false), Integer.valueOf(0), "", Integer.valueOf(443), "", "", "", "", null, localByteStringMicro3 }, ApplyUploadRspV3.class);
    }
  }
  
  public static final class DelMessageReq
    extends MessageMicro<DelMessageReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 80, 160, 240 }, new String[] { "uint64_uin_sender", "uint64_uin_receiver", "uint32_msg_time", "uint32_msg_random", "uint32_msg_seq_no" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, DelMessageReq.class);
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq_no = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin_receiver = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin_sender = PBField.initUInt64(0L);
  }
  
  public static final class DeleteFileReq
    extends MessageMicro<DeleteFileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt32Field uint32_delete_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 240, 322, 402 }, new String[] { "uint64_uin", "uint64_peer_uin", "uint32_delete_type", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, "" }, DeleteFileReq.class);
    }
  }
  
  public static final class DeleteFileRsp
    extends MessageMicro<DeleteFileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, DeleteFileRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class DownloadInfo
    extends MessageMicro<DownloadInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_media_platform_download_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<String> rpt_str_downloadip_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_cookie = PBField.initString("");
    public final PBStringField str_download_dns = PBField.initString("");
    public final PBStringField str_download_domain = PBField.initString("");
    public final PBStringField str_download_ip = PBField.initString("");
    public final PBStringField str_download_url = PBField.initString("");
    public final PBStringField str_https_download_domain = PBField.initString("");
    public final PBUInt32Field uint32_https_port = PBField.initUInt32(443);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 320, 402, 482, 562, 640, 722, 882, 962 }, new String[] { "bytes_download_key", "str_download_ip", "str_download_domain", "uint32_port", "str_download_url", "rpt_str_downloadip_list", "str_cookie", "uint32_https_port", "str_https_download_domain", "str_download_dns", "bytes_media_platform_download_key" }, new Object[] { localByteStringMicro1, "", "", Integer.valueOf(0), "", "", "", Integer.valueOf(443), "", "", localByteStringMicro2 }, DownloadInfo.class);
    }
  }
  
  public static final class DownloadSuccReq
    extends MessageMicro<DownloadSuccReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "uint64_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), localByteStringMicro, "" }, DownloadSuccReq.class);
    }
  }
  
  public static final class DownloadSuccRsp
    extends MessageMicro<DownloadSuccRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 240 }, new String[] { "int32_ret_code", "str_ret_msg", "int32_down_stat" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0) }, DownloadSuccRsp.class);
    public final PBInt32Field int32_down_stat = PBField.initInt32(0);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ExtensionReq
    extends MessageMicro<ExtensionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tim_cloud_extension_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tim_cloud_pdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_tim_cloud_ppdir_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_phone_convert_type = PBField.initInt32(0);
    public cmd0x346.DelMessageReq msg_del_message_req = new cmd0x346.DelMessageReq();
    public final PBStringField str_dst_phonenum = PBField.initString("");
    public final PBUInt32Field uint32_bdh_cmdid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_download_url_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_auto = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_need_inner_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(255);
    public final PBUInt32Field uint32_ptt_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ptt_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_tim_file_exist_option = PBField.initUInt32(0);
    public final PBUInt32Field uint32_voice_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_route_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_type = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 162, 800, 720802, 721600, 722400, 723200, 724000, 724800, 725600, 726400, 727200, 728000, 728800, 736002, 736010, 736016, 736026 }, new String[] { "uint64_id", "uint64_type", "str_dst_phonenum", "int32_phone_convert_type", "bytes_sig", "uint64_route_id", "msg_del_message_req", "uint32_download_url_type", "uint32_ptt_format", "uint32_is_need_inner_ip", "uint32_net_type", "uint32_voice_type", "uint32_file_type", "uint32_ptt_time", "uint32_bdh_cmdid", "uint32_req_transfer_type", "uint32_is_auto", "bytes_tim_cloud_pdir_key", "bytes_tim_cloud_extension_info", "uint32_tim_file_exist_option", "bytes_tim_cloud_ppdir_key" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(255), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4 }, ExtensionReq.class);
    }
  }
  
  public static final class ExtensionRsp
    extends MessageMicro<ExtensionRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "uint32_transfer_type", "uint32_channel_type", "uint32_allow_retry", "server_addr_ipv6_list" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, ExtensionRsp.class);
    public cmd0x346.AddrList server_addr_ipv6_list = new cmd0x346.AddrList();
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_transfer_type = PBField.initUInt32(0);
  }
  
  public static final class FileInfo
    extends MessageMicro<FileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_10m_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt32Field uint32_abs_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_danger_evel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_life_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_upload_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_owner_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_peer_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 720, 802, 810, 880, 960, 968, 1040, 1122 }, new String[] { "uint64_uin", "uint32_danger_evel", "uint64_file_size", "uint32_life_time", "uint32_upload_time", "bytes_uuid", "str_file_name", "uint32_abs_file_type", "bytes_10m_md5", "bytes_sha", "uint32_client_type", "uint64_owner_uin", "uint64_peer_uin", "uint32_expire_time", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, "", Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, FileInfo.class);
    }
  }
  
  public static final class FileQueryReq
    extends MessageMicro<FileQueryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "uint64_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), localByteStringMicro, "" }, FileQueryReq.class);
    }
  }
  
  public static final class FileQueryRsp
    extends MessageMicro<FileQueryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "int32_ret_code", "str_ret_msg", "msg_file_info" }, new Object[] { Integer.valueOf(0), "", null }, FileQueryRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public cmd0x346.FileInfo msg_file_info = new cmd0x346.FileInfo();
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class RecallFileReq
    extends MessageMicro<RecallFileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint64_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), localByteStringMicro, "" }, RecallFileReq.class);
    }
  }
  
  public static final class RecallFileRsp
    extends MessageMicro<RecallFileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, RecallFileRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class RecvListQueryReq
    extends MessageMicro<RecvListQueryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_begin_index", "uint32_req_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, RecvListQueryReq.class);
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RecvListQueryRsp
    extends MessageMicro<RecvListQueryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58 }, new String[] { "int32_ret_code", "str_ret_msg", "uint32_file_tot_count", "uint32_begin_index", "uint32_rsp_file_count", "uint32_is_end", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, RecvListQueryRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x346.FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346.FileInfo.class);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_tot_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_file_count = PBField.initUInt32(0);
  }
  
  public static final class RenewFileReq
    extends MessageMicro<RenewFileReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_add_ttl = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "bytes_uuid", "uint32_add_ttl" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, RenewFileReq.class);
    }
  }
  
  public static final class RenewFileRsp
    extends MessageMicro<RenewFileRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, RenewFileRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 808, 816, 1600, 720002, 720010, 720018, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_req", "msg_send_list_query_req", "msg_renew_file_req", "msg_recall_file_req", "msg_apply_upload_req", "msg_apply_upload_hit_req", "msg_apply_forward_file_req", "msg_upload_succ_req", "msg_delete_file_req", "msg_download_succ_req", "msg_apply_download_abs_req", "msg_apply_download_req", "msg_apply_list_download_req", "msg_file_query_req", "msg_apply_copy_from_req", "msg_apply_upload_req_v2", "msg_apply_upload_req_v3", "msg_apply_upload_hit_req_v2", "msg_apply_upload_hit_req_v3", "uint32_business_id", "uint32_client_type", "uint32_flag_support_mediaplatform", "msg_apply_copy_to_req", "msg_apply_clean_traffic_req", "msg_apply_get_traffic_req", "msg_extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ReqBody.class);
    public cmd0x346.ApplyCleanTrafficReq msg_apply_clean_traffic_req = new cmd0x346.ApplyCleanTrafficReq();
    public cmd0x346.ApplyCopyFromReq msg_apply_copy_from_req = new cmd0x346.ApplyCopyFromReq();
    public cmd0x346.ApplyCopyToReq msg_apply_copy_to_req = new cmd0x346.ApplyCopyToReq();
    public cmd0x346.ApplyDownloadAbsReq msg_apply_download_abs_req = new cmd0x346.ApplyDownloadAbsReq();
    public cmd0x346.ApplyDownloadReq msg_apply_download_req = new cmd0x346.ApplyDownloadReq();
    public cmd0x346.ApplyForwardFileReq msg_apply_forward_file_req = new cmd0x346.ApplyForwardFileReq();
    public cmd0x346.ApplyGetTrafficReq msg_apply_get_traffic_req = new cmd0x346.ApplyGetTrafficReq();
    public cmd0x346.ApplyListDownloadReq msg_apply_list_download_req = new cmd0x346.ApplyListDownloadReq();
    public cmd0x346.ApplyUploadHitReq msg_apply_upload_hit_req = new cmd0x346.ApplyUploadHitReq();
    public cmd0x346.ApplyUploadHitReqV2 msg_apply_upload_hit_req_v2 = new cmd0x346.ApplyUploadHitReqV2();
    public cmd0x346.ApplyUploadHitReqV3 msg_apply_upload_hit_req_v3 = new cmd0x346.ApplyUploadHitReqV3();
    public cmd0x346.ApplyUploadReq msg_apply_upload_req = new cmd0x346.ApplyUploadReq();
    public cmd0x346.ApplyUploadReqV2 msg_apply_upload_req_v2 = new cmd0x346.ApplyUploadReqV2();
    public cmd0x346.ApplyUploadReqV3 msg_apply_upload_req_v3 = new cmd0x346.ApplyUploadReqV3();
    public cmd0x346.DeleteFileReq msg_delete_file_req = new cmd0x346.DeleteFileReq();
    public cmd0x346.DownloadSuccReq msg_download_succ_req = new cmd0x346.DownloadSuccReq();
    public cmd0x346.ExtensionReq msg_extension_req = new cmd0x346.ExtensionReq();
    public cmd0x346.FileQueryReq msg_file_query_req = new cmd0x346.FileQueryReq();
    public cmd0x346.RecallFileReq msg_recall_file_req = new cmd0x346.RecallFileReq();
    public cmd0x346.RecvListQueryReq msg_recv_list_query_req = new cmd0x346.RecvListQueryReq();
    public cmd0x346.RenewFileReq msg_renew_file_req = new cmd0x346.RenewFileReq();
    public cmd0x346.SendListQueryReq msg_send_list_query_req = new cmd0x346.SendListQueryReq();
    public cmd0x346.UploadSuccReq msg_upload_succ_req = new cmd0x346.UploadSuccReq();
    public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_mediaplatform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 400, 720002, 720010, 720018, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_rsp", "msg_send_list_query_rsp", "msg_renew_file_rsp", "msg_recall_file_rsp", "msg_apply_upload_rsp", "msg_apply_upload_hit_rsp", "msg_apply_forward_file_rsp", "msg_upload_succ_rsp", "msg_delete_file_rsp", "msg_download_succ_rsp", "msg_apply_download_abs_rsp", "msg_apply_download_rsp", "msg_apply_list_download_rsp", "msg_file_query_rsp", "msg_apply_copy_from_rsp", "msg_apply_upload_rsp_v2", "msg_apply_upload_rsp_v3", "msg_apply_upload_hit_rsp_v2", "msg_apply_upload_hit_rsp_v3", "uint32_flag_use_media_platform", "msg_apply_copy_to_rsp", "msg_apply_clean_traffic_rsp", "msg_apply_get_traffic_rsp", "msg_extension_rsp" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), null, null, null, null }, RspBody.class);
    public cmd0x346.ApplyCleanTrafficRsp msg_apply_clean_traffic_rsp = new cmd0x346.ApplyCleanTrafficRsp();
    public cmd0x346.ApplyCopyFromRsp msg_apply_copy_from_rsp = new cmd0x346.ApplyCopyFromRsp();
    public cmd0x346.ApplyCopyToRsp msg_apply_copy_to_rsp = new cmd0x346.ApplyCopyToRsp();
    public cmd0x346.ApplyDownloadAbsRsp msg_apply_download_abs_rsp = new cmd0x346.ApplyDownloadAbsRsp();
    public cmd0x346.ApplyDownloadRsp msg_apply_download_rsp = new cmd0x346.ApplyDownloadRsp();
    public cmd0x346.ApplyForwardFileRsp msg_apply_forward_file_rsp = new cmd0x346.ApplyForwardFileRsp();
    public cmd0x346.ApplyGetTrafficRsp msg_apply_get_traffic_rsp = new cmd0x346.ApplyGetTrafficRsp();
    public cmd0x346.ApplyListDownloadRsp msg_apply_list_download_rsp = new cmd0x346.ApplyListDownloadRsp();
    public cmd0x346.ApplyUploadHitRsp msg_apply_upload_hit_rsp = new cmd0x346.ApplyUploadHitRsp();
    public cmd0x346.ApplyUploadHitRspV2 msg_apply_upload_hit_rsp_v2 = new cmd0x346.ApplyUploadHitRspV2();
    public cmd0x346.ApplyUploadHitRspV3 msg_apply_upload_hit_rsp_v3 = new cmd0x346.ApplyUploadHitRspV3();
    public cmd0x346.ApplyUploadRsp msg_apply_upload_rsp = new cmd0x346.ApplyUploadRsp();
    public cmd0x346.ApplyUploadRspV2 msg_apply_upload_rsp_v2 = new cmd0x346.ApplyUploadRspV2();
    public cmd0x346.ApplyUploadRspV3 msg_apply_upload_rsp_v3 = new cmd0x346.ApplyUploadRspV3();
    public cmd0x346.DeleteFileRsp msg_delete_file_rsp = new cmd0x346.DeleteFileRsp();
    public cmd0x346.DownloadSuccRsp msg_download_succ_rsp = new cmd0x346.DownloadSuccRsp();
    public cmd0x346.ExtensionRsp msg_extension_rsp = new cmd0x346.ExtensionRsp();
    public cmd0x346.FileQueryRsp msg_file_query_rsp = new cmd0x346.FileQueryRsp();
    public cmd0x346.RecallFileRsp msg_recall_file_rsp = new cmd0x346.RecallFileRsp();
    public cmd0x346.RecvListQueryRsp msg_recv_list_query_rsp = new cmd0x346.RecvListQueryRsp();
    public cmd0x346.RenewFileRsp msg_renew_file_rsp = new cmd0x346.RenewFileRsp();
    public cmd0x346.SendListQueryRsp msg_send_list_query_rsp = new cmd0x346.SendListQueryRsp();
    public cmd0x346.UploadSuccRsp msg_upload_succ_rsp = new cmd0x346.UploadSuccRsp();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_use_media_platform = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class SendListQueryReq
    extends MessageMicro<SendListQueryReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_uin", "uint32_begin_index", "uint32_req_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, SendListQueryReq.class);
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class SendListQueryRsp
    extends MessageMicro<SendListQueryRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 74 }, new String[] { "int32_ret_code", "str_ret_msg", "uint32_file_tot_count", "uint32_begin_index", "uint32_rsp_file_count", "uint32_is_end", "uint64_tot_limit", "uint64_used_limit", "rpt_msg_file_list" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null }, SendListQueryRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x346.FileInfo> rpt_msg_file_list = PBField.initRepeatMessage(cmd0x346.FileInfo.class);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_begin_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_tot_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rsp_file_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_tot_limit = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_used_limit = PBField.initUInt64(0L);
  }
  
  public static final class UploadSuccReq
    extends MessageMicro<UploadSuccReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileidcrc = PBField.initString("");
    public final PBUInt64Field uint64_recver_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_sender_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 160, 242, 322 }, new String[] { "uint64_sender_uin", "uint64_recver_uin", "bytes_uuid", "str_fileidcrc" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, "" }, UploadSuccReq.class);
    }
  }
  
  public static final class UploadSuccRsp
    extends MessageMicro<UploadSuccRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 162, 242 }, new String[] { "int32_ret_code", "str_ret_msg", "msg_file_info" }, new Object[] { Integer.valueOf(0), "", null }, UploadSuccRsp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public cmd0x346.FileInfo msg_file_info = new cmd0x346.FileInfo();
    public final PBStringField str_ret_msg = PBField.initString("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346
 * JD-Core Version:    0.7.0.1
 */