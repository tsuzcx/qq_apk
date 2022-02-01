package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead
{
  public static final int RET_ERR_BUSY = 128;
  public static final int RET_ERR_MAINTAIN = 129;
  public static final int RET_FAIL = 192;
  public static final int RET_NOT_EXIST = 193;
  public static final int RET_SUC = 0;
  
  public static final class C2CCommonExtendinfo
    extends MessageMicro<C2CCommonExtendinfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_info_id", "msg_filter_extendinfo" }, new Object[] { Integer.valueOf(0), null }, C2CCommonExtendinfo.class);
    public CSDataHighwayHead.FilterExtendinfo msg_filter_extendinfo = new CSDataHighwayHead.FilterExtendinfo();
    public final PBUInt32Field uint32_info_id = PBField.initUInt32(0);
  }
  
  public static final class DataHighwayHead
    extends MessageMicro<DataHighwayHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_command = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field env_id = PBField.initUInt32(0);
    public final PBUInt32Field locale_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_command_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_dataflag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74, 80, 88 }, new String[] { "uint32_version", "bytes_uin", "bytes_command", "uint32_seq", "uint32_retry_times", "uint32_appid", "uint32_dataflag", "uint32_command_id", "bytes_build_ver", "locale_id", "env_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0) }, DataHighwayHead.class);
    }
  }
  
  public static final class DataHole
    extends MessageMicro<DataHole>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin", "uint64_end" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DataHole.class);
    public final PBUInt64Field uint64_begin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end = PBField.initUInt64(0L);
  }
  
  public static final class FilterExtendinfo
    extends MessageMicro<FilterExtendinfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_filter_flag", "msg_image_filter_request" }, new Object[] { Integer.valueOf(0), null }, FilterExtendinfo.class);
    public CSDataHighwayHead.ImageFilterRequest msg_image_filter_request = new CSDataHighwayHead.ImageFilterRequest();
    public final PBUInt32Field uint32_filter_flag = PBField.initUInt32(0);
  }
  
  public static final class FilterStyle
    extends MessageMicro<FilterStyle>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field style_id = PBField.initUInt32(0);
    public final PBBytesField style_name = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "style_id", "style_name" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, FilterStyle.class);
    }
  }
  
  public static final class ImageFilterRequest
    extends MessageMicro<ImageFilterRequest>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field client_ip = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBBytesField image_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public CSDataHighwayHead.FilterStyle style = new CSDataHighwayHead.FilterStyle();
    public final PBUInt64Field uin = PBField.initUInt64(0L);
    public final PBUInt32Field width = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 58 }, new String[] { "session_id", "client_ip", "uin", "style", "width", "height", "image_data" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, ImageFilterRequest.class);
    }
  }
  
  public static final class ImageFilterResponse
    extends MessageMicro<ImageFilterResponse>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field cost_time = PBField.initUInt32(0);
    public final PBBytesField image_data = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "ret_code", "image_data", "cost_time" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, ImageFilterResponse.class);
    }
  }
  
  public static final class LoginSigHead
    extends MessageMicro<LoginSigHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_loginsig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_loginsig_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_loginsig_type", "bytes_loginsig" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, LoginSigHead.class);
    }
  }
  
  public static final class NewServiceTicket
    extends MessageMicro<NewServiceTicket>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_signature = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_signature", "bytes_ukey" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, NewServiceTicket.class);
    }
  }
  
  public static final class PicInfoExt
    extends MessageMicro<PicInfoExt>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_pic_width", "uint32_pic_height", "uint32_pic_flag", "uint32_busi_type", "uint32_src_term", "uint32_plat_type", "uint32_net_type", "uint32_img_type", "uint32_app_pic_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, PicInfoExt.class);
    public final PBUInt32Field uint32_app_pic_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_net_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pic_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_plat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  }
  
  public static final class PicRspExtInfo
    extends MessageMicro<PicRspExtInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_skey", "uint32_client_ip", "uint64_up_offset", "uint64_block_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, PicRspExtInfo.class);
    }
  }
  
  public static final class QueryHoleRsp
    extends MessageMicro<QueryHoleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "rpt_data_hole", "bool_comp_flag" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false) }, QueryHoleRsp.class);
    public final PBBoolField bool_comp_flag = PBField.initBool(false);
    public final PBRepeatMessageField<CSDataHighwayHead.DataHole> rpt_data_hole = PBField.initRepeatMessage(CSDataHighwayHead.DataHole.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class ReqDataHighwayHead
    extends MessageMicro<ReqDataHighwayHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public CSDataHighwayHead.DataHighwayHead msg_basehead = new CSDataHighwayHead.DataHighwayHead();
    public CSDataHighwayHead.LoginSigHead msg_login_sig_head = new CSDataHighwayHead.LoginSigHead();
    public CSDataHighwayHead.SegHead msg_seghead = new CSDataHighwayHead.SegHead();
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42 }, new String[] { "msg_basehead", "msg_seghead", "bytes_req_extendinfo", "uint64_timestamp", "msg_login_sig_head" }, new Object[] { null, null, localByteStringMicro, Long.valueOf(0L), null }, ReqDataHighwayHead.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_query_hole_rsp" }, new Object[] { null }, RspBody.class);
    public CSDataHighwayHead.QueryHoleRsp msg_query_hole_rsp = new CSDataHighwayHead.QueryHoleRsp();
  }
  
  public static final class RspDataHighwayHead
    extends MessageMicro<RspDataHighwayHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public CSDataHighwayHead.DataHighwayHead msg_basehead = new CSDataHighwayHead.DataHighwayHead();
    public CSDataHighwayHead.SegHead msg_seghead = new CSDataHighwayHead.SegHead();
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cachecost = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_htcost = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_reset = PBField.initUInt32(0);
    public final PBUInt64Field uint64_range = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 64, 72, 80 }, new String[] { "msg_basehead", "msg_seghead", "uint32_error_code", "uint32_allow_retry", "uint32_cachecost", "uint32_htcost", "bytes_rsp_extendinfo", "uint64_timestamp", "uint64_range", "uint32_is_reset" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, RspDataHighwayHead.class);
    }
  }
  
  public static final class SegHead
    extends MessageMicro<SegHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_serviceticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_cache_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_datalength = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_query_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rtcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_serviceid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_update_cacheip = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dataoffset = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_filesize = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74, 80, 88, 96 }, new String[] { "uint32_serviceid", "uint64_filesize", "uint64_dataoffset", "uint32_datalength", "uint32_rtcode", "bytes_serviceticket", "uint32_flag", "bytes_md5", "bytes_file_md5", "uint32_cache_addr", "uint32_query_times", "uint32_update_cacheip" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SegHead.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead
 * JD-Core Version:    0.7.0.1
 */