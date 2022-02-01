package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PttShortVideo
{
  public static final class DataHole
    extends MessageMicro<DataHole>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin", "uint64_end" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DataHole.class);
    public final PBUInt64Field uint64_begin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end = PBField.initUInt64(0L);
  }
  
  public static final class ExtensionReq
    extends MessageMicro<ExtensionReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_sub_busi_type", "uint32_user_cnt" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ExtensionReq.class);
    public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_cnt = PBField.initUInt32(0);
  }
  
  public static final class PttShortVideoAddr
    extends MessageMicro<PttShortVideoAddr>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 82, 90, 170, 178 }, new String[] { "uint32_host_type", "rpt_str_host", "str_url_args", "rpt_str_host_ipv6", "rpt_str_domain" }, new Object[] { Integer.valueOf(0), "", "", "", "" }, PttShortVideoAddr.class);
    public final PBRepeatField<String> rpt_str_domain = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> rpt_str_host = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<String> rpt_str_host_ipv6 = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField str_url_args = PBField.initString("");
    public final PBUInt32Field uint32_host_type = PBField.initUInt32(0);
  }
  
  public static final class PttShortVideoDeleteReq
    extends MessageMicro<PttShortVideoDeleteReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5", "uint32_business_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PttShortVideoDeleteReq.class);
    }
  }
  
  public static final class PttShortVideoDeleteResp
    extends MessageMicro<PttShortVideoDeleteResp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_ret_code", "str_ret_msg" }, new Object[] { Integer.valueOf(0), "" }, PttShortVideoDeleteResp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
  }
  
  public static final class PttShortVideoDownloadReq
    extends MessageMicro<PttShortVideoDownloadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_down_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_inner_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_host_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scene_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 160 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5", "uint32_business_type", "uint32_file_type", "uint32_down_type", "uint32_scene_type", "uint32_need_inner_addr", "uint32_req_transfer_type", "uint32_req_host_type", "uint32_flag_support_large_size" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoDownloadReq.class);
    }
  }
  
  public static final class PttShortVideoDownloadResp
    extends MessageMicro<PttShortVideoDownloadResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_downloadkey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public PttShortVideo.PttShortVideoAddr msg_download_addr = new PttShortVideo.PttShortVideoAddr();
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBStringField str_ret_msg = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66, 74, 82 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "bytes_downloadkey", "bytes_file_md5", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "msg_download_addr", "bytes_encrypt_key" }, new Object[] { Integer.valueOf(0), "", null, null, localByteStringMicro1, localByteStringMicro2, null, null, null, localByteStringMicro3 }, PttShortVideoDownloadResp.class);
    }
  }
  
  public static final class PttShortVideoFileInfo
    extends MessageMicro<PttShortVideoFileInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_decrypt_thumb_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_decrypt_video_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_thumb_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_file_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_res_length = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_res_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_decrypt_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_decrypt_thumb_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_file_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_thumb_file_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48, 56, 64, 72, 82, 88, 98, 104 }, new String[] { "str_file_name", "bytes_file_md5", "bytes_thumb_file_md5", "uint64_file_size", "uint32_file_res_length", "uint32_file_res_width", "uint32_file_format", "uint32_file_time", "uint64_thumb_file_size", "bytes_decrypt_video_md5", "uint64_decrypt_file_size", "bytes_decrypt_thumb_md5", "uint64_decrypt_thumb_size" }, new Object[] { "", localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), localByteStringMicro4, Long.valueOf(0L) }, PttShortVideoFileInfo.class);
    }
  }
  
  public static final class PttShortVideoIpList
    extends MessageMicro<PttShortVideoIpList>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_ip", "uint32_port" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoIpList.class);
    public final PBUInt32Field uint32_ip = PBField.initUInt32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
  }
  
  public static final class PttShortVideoRetweetReq
    extends MessageMicro<PttShortVideoRetweetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 88, 160 }, new String[] { "uint64_from_uin", "uint64_to_uin", "uint32_from_chat_type", "uint32_to_chat_type", "uint32_from_busi_type", "uint32_to_busi_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint32_agent_type", "str_fileid", "uint64_group_code", "uint32_flag_support_large_size" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, PttShortVideoRetweetReq.class);
    public PttShortVideo.PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_chat_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  }
  
  public static final class PttShortVideoRetweetResp
    extends MessageMicro<PttShortVideoRetweetResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<PttShortVideo.DataHole> rpt_data_hole = PBField.initRepeatMessage(PttShortVideo.DataHole.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_file_exist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_hot_file = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_video_carry_watch_point_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 88, 96 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "str_fileid", "bytes_ukey", "uint32_file_exist", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "rpt_data_hole", "uint32_is_hot_file", "uint32_long_video_carry_watch_point_type" }, new Object[] { Integer.valueOf(0), "", null, null, "", localByteStringMicro, Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoRetweetResp.class);
    }
  }
  
  public static final class PttShortVideoUploadReq
    extends MessageMicro<PttShortVideoUploadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public PttShortVideo.PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_business_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 64, 74, 80, 160 }, new String[] { "uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint64_group_code", "uint32_agent_type", "uint32_business_type", "bytes_encrypt_key", "uint32_sub_business_type", "uint32_flag_support_large_size" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoUploadReq.class);
    }
  }
  
  public static final class PttShortVideoUploadResp
    extends MessageMicro<PttShortVideoUploadResp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBRepeatMessageField<PttShortVideo.DataHole> rpt_data_hole = PBField.initRepeatMessage(PttShortVideo.DataHole.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo.PttShortVideoIpList.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBUInt32Field uint32_file_exist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_hot_file = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_video_carry_watch_point_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 90, 96, 104 }, new String[] { "int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "str_fileid", "bytes_ukey", "uint32_file_exist", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "rpt_data_hole", "bytes_encrypt_key", "uint32_is_hot_file", "uint32_long_video_carry_watch_point_type" }, new Object[] { Integer.valueOf(0), "", null, null, "", localByteStringMicro1, Integer.valueOf(0), null, null, null, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, PttShortVideoUploadResp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 802 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Req", "msg_PttShortVideoDownload_Req", "rpt_msg_short_video_retweet_req", "rpt_msg_short_video_delete_req", "rpt_msg_extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null }, ReqBody.class);
    public PttShortVideo.PttShortVideoDownloadReq msg_PttShortVideoDownload_Req = new PttShortVideo.PttShortVideoDownloadReq();
    public PttShortVideo.PttShortVideoUploadReq msg_PttShortVideoUpload_Req = new PttShortVideo.PttShortVideoUploadReq();
    public final PBRepeatMessageField<PttShortVideo.ExtensionReq> rpt_msg_extension_req = PBField.initRepeatMessage(PttShortVideo.ExtensionReq.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoDeleteReq> rpt_msg_short_video_delete_req = PBField.initRepeatMessage(PttShortVideo.PttShortVideoDeleteReq.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoRetweetReq> rpt_msg_short_video_retweet_req = PBField.initRepeatMessage(PttShortVideo.PttShortVideoRetweetReq.class);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 800, 808 }, new String[] { "uint32_cmd", "uint32_seq", "msg_PttShortVideoUpload_Resp", "msg_PttShortVideoDownload_Resp", "rpt_msg_short_video_retweet_resp", "rpt_msg_short_video_delete_resp", "uint32_change_channel", "uint32_allow_retry" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    public PttShortVideo.PttShortVideoDownloadResp msg_PttShortVideoDownload_Resp = new PttShortVideo.PttShortVideoDownloadResp();
    public PttShortVideo.PttShortVideoUploadResp msg_PttShortVideoUpload_Resp = new PttShortVideo.PttShortVideoUploadResp();
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoDeleteResp> rpt_msg_short_video_delete_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoDeleteResp.class);
    public final PBRepeatMessageField<PttShortVideo.PttShortVideoRetweetResp> rpt_msg_short_video_retweet_resp = PBField.initRepeatMessage(PttShortVideo.PttShortVideoRetweetResp.class);
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_change_channel = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pttcenterservice.PttShortVideo
 * JD-Core Version:    0.7.0.1
 */