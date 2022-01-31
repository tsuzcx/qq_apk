package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
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
  
  public static final class DataHighwayHead
    extends MessageMicro<DataHighwayHead>
  {
    public static final int BYTES_BUILD_VER_FIELD_NUMBER = 9;
    public static final int BYTES_COMMAND_FIELD_NUMBER = 3;
    public static final int BYTES_UIN_FIELD_NUMBER = 2;
    public static final int UINT32_APPID_FIELD_NUMBER = 6;
    public static final int UINT32_COMMAND_ID_FIELD_NUMBER = 8;
    public static final int UINT32_DATAFLAG_FIELD_NUMBER = 7;
    public static final int UINT32_RETRY_TIMES_FIELD_NUMBER = 5;
    public static final int UINT32_SEQ_FIELD_NUMBER = 4;
    public static final int UINT32_VERSION_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_build_ver = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_command = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_uin = PBField.initBytes(ByteStringMicro.EMPTY);
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 74 }, new String[] { "uint32_version", "bytes_uin", "bytes_command", "uint32_seq", "uint32_retry_times", "uint32_appid", "uint32_dataflag", "uint32_command_id", "bytes_build_ver" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3 }, DataHighwayHead.class);
    }
  }
  
  public static final class DataHole
    extends MessageMicro<DataHole>
  {
    public static final int UINT64_BEGIN_FIELD_NUMBER = 1;
    public static final int UINT64_END_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin", "uint64_end" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, DataHole.class);
    public final PBUInt64Field uint64_begin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end = PBField.initUInt64(0L);
  }
  
  public static final class LoginSigHead
    extends MessageMicro<LoginSigHead>
  {
    public static final int BYTES_LOGINSIG_FIELD_NUMBER = 2;
    public static final int UINT32_LOGINSIG_TYPE_FIELD_NUMBER = 1;
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
    public static final int BYTES_SIGNATURE_FIELD_NUMBER = 1;
    public static final int BYTES_UKEY_FIELD_NUMBER = 2;
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
    public static final int UINT32_APP_PIC_TYPE_FIELD_NUMBER = 9;
    public static final int UINT32_BUSI_TYPE_FIELD_NUMBER = 4;
    public static final int UINT32_IMG_TYPE_FIELD_NUMBER = 8;
    public static final int UINT32_NET_TYPE_FIELD_NUMBER = 7;
    public static final int UINT32_PIC_FLAG_FIELD_NUMBER = 3;
    public static final int UINT32_PIC_HEIGHT_FIELD_NUMBER = 2;
    public static final int UINT32_PIC_WIDTH_FIELD_NUMBER = 1;
    public static final int UINT32_PLAT_TYPE_FIELD_NUMBER = 6;
    public static final int UINT32_SRC_TERM_FIELD_NUMBER = 5;
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
    public static final int BYTES_SKEY_FIELD_NUMBER = 1;
    public static final int UINT32_CLIENT_IP_FIELD_NUMBER = 2;
    public static final int UINT64_BLOCK_SIZE_FIELD_NUMBER = 4;
    public static final int UINT64_UP_OFFSET_FIELD_NUMBER = 3;
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
    public static final int BOOL_COMP_FLAG_FIELD_NUMBER = 3;
    public static final int RPT_DATA_HOLE_FIELD_NUMBER = 2;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "rpt_data_hole", "bool_comp_flag" }, new Object[] { Integer.valueOf(0), null, Boolean.valueOf(false) }, QueryHoleRsp.class);
    public final PBBoolField bool_comp_flag = PBField.initBool(false);
    public final PBRepeatMessageField<CSDataHighwayHead.DataHole> rpt_data_hole = PBField.initRepeatMessage(CSDataHighwayHead.DataHole.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class ReqDataHighwayHead
    extends MessageMicro<ReqDataHighwayHead>
  {
    public static final int BYTES_REQ_EXTENDINFO_FIELD_NUMBER = 3;
    public static final int MSG_BASEHEAD_FIELD_NUMBER = 1;
    public static final int MSG_LOGIN_SIG_HEAD_FIELD_NUMBER = 5;
    public static final int MSG_SEGHEAD_FIELD_NUMBER = 2;
    public static final int UINT64_TIMESTAMP_FIELD_NUMBER = 4;
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
    public static final int MSG_QUERY_HOLE_RSP_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_query_hole_rsp" }, new Object[] { null }, RspBody.class);
    public CSDataHighwayHead.QueryHoleRsp msg_query_hole_rsp = new CSDataHighwayHead.QueryHoleRsp();
  }
  
  public static final class RspDataHighwayHead
    extends MessageMicro<RspDataHighwayHead>
  {
    public static final int BYTES_RSP_EXTENDINFO_FIELD_NUMBER = 7;
    public static final int MSG_BASEHEAD_FIELD_NUMBER = 1;
    public static final int MSG_SEGHEAD_FIELD_NUMBER = 2;
    public static final int UINT32_ALLOW_RETRY_FIELD_NUMBER = 4;
    public static final int UINT32_CACHECOST_FIELD_NUMBER = 5;
    public static final int UINT32_ERROR_CODE_FIELD_NUMBER = 3;
    public static final int UINT32_HTCOST_FIELD_NUMBER = 6;
    public static final int UINT64_TIMESTAMP_FIELD_NUMBER = 8;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public CSDataHighwayHead.DataHighwayHead msg_basehead = new CSDataHighwayHead.DataHighwayHead();
    public CSDataHighwayHead.SegHead msg_seghead = new CSDataHighwayHead.SegHead();
    public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cachecost = PBField.initUInt32(0);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBUInt32Field uint32_htcost = PBField.initUInt32(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 64 }, new String[] { "msg_basehead", "msg_seghead", "uint32_error_code", "uint32_allow_retry", "uint32_cachecost", "uint32_htcost", "bytes_rsp_extendinfo", "uint64_timestamp" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L) }, RspDataHighwayHead.class);
    }
  }
  
  public static final class SegHead
    extends MessageMicro<SegHead>
  {
    public static final int BYTES_FILE_MD5_FIELD_NUMBER = 9;
    public static final int BYTES_MD5_FIELD_NUMBER = 8;
    public static final int BYTES_SERVICETICKET_FIELD_NUMBER = 6;
    public static final int UINT32_DATALENGTH_FIELD_NUMBER = 4;
    public static final int UINT32_FLAG_FIELD_NUMBER = 7;
    public static final int UINT32_RTCODE_FIELD_NUMBER = 5;
    public static final int UINT32_SERVICEID_FIELD_NUMBER = 1;
    public static final int UINT64_DATAOFFSET_FIELD_NUMBER = 3;
    public static final int UINT64_FILESIZE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_serviceticket = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_datalength = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_rtcode = PBField.initUInt32(0);
    public final PBUInt32Field uint32_serviceid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_dataoffset = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_filesize = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74 }, new String[] { "uint32_serviceid", "uint64_filesize", "uint64_dataoffset", "uint32_datalength", "uint32_rtcode", "bytes_serviceticket", "uint32_flag", "bytes_md5", "bytes_file_md5" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, SegHead.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead
 * JD-Core Version:    0.7.0.1
 */