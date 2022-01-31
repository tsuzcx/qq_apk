package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Bdh_extinfo
{
  public static final class PicInfo
    extends MessageMicro<PicInfo>
  {
    public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
    public static final int UINT32_IDX_FIELD_NUMBER = 1;
    public static final int UINT32_SIZE_FIELD_NUMBER = 2;
    public static final int UINT32_TYPE_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, PicInfo.class);
    }
  }
  
  public static final class ShortVideoReqExtInfo
    extends MessageMicro<ShortVideoReqExtInfo>
  {
    public static final int MSG_SHORTVIDEO_SURE_REQ_FIELD_NUMBER = 5;
    public static final int MSG_THUMBINFO_FIELD_NUMBER = 3;
    public static final int MSG_VIDEOINFO_FIELD_NUMBER = 4;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42 }, new String[] { "uint32_cmd", "uint64_session_id", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_req" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), null, null, null }, ShortVideoReqExtInfo.class);
    public Bdh_extinfo.ShortVideoSureReqInfo msg_shortvideo_sure_req = new Bdh_extinfo.ShortVideoSureReqInfo();
    public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
    public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
  }
  
  public static final class ShortVideoRspExtInfo
    extends MessageMicro<ShortVideoRspExtInfo>
  {
    public static final int BYTES_ERRINFO_FIELD_NUMBER = 4;
    public static final int INT32_RETCODE_FIELD_NUMBER = 3;
    public static final int MSG_SHORTVIDEO_SURE_RSP_FIELD_NUMBER = 7;
    public static final int MSG_THUMBINFO_FIELD_NUMBER = 5;
    public static final int MSG_VIDEOINFO_FIELD_NUMBER = 6;
    public static final int UINT32_CMD_FIELD_NUMBER = 1;
    public static final int UINT32_RETRY_FLAG_FIELD_NUMBER = 8;
    public static final int UINT64_SESSION_ID_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_retcode = PBField.initInt32(0);
    public Bdh_extinfo.ShortVideoSureRspInfo msg_shortvideo_sure_rsp = new Bdh_extinfo.ShortVideoSureRspInfo();
    public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
    public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_retry_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_session_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 50, 58, 64 }, new String[] { "uint32_cmd", "uint64_session_id", "int32_retcode", "bytes_errinfo", "msg_thumbinfo", "msg_videoinfo", "msg_shortvideo_sure_rsp", "uint32_retry_flag" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, null, null, null, Integer.valueOf(0) }, ShortVideoRspExtInfo.class);
    }
  }
  
  public static final class ShortVideoSureReqInfo
    extends MessageMicro<ShortVideoSureReqInfo>
  {
    public static final int MSG_THUMBINFO_FIELD_NUMBER = 6;
    public static final int RPT_MSG_DROP_VIDEOINFO_FIELD_NUMBER = 8;
    public static final int RPT_MSG_MERGE_VIDEOINFO_FIELD_NUMBER = 7;
    public static final int UINT32_BUSINESS_TYPE_FIELD_NUMBER = 9;
    public static final int UINT32_CHAT_TYPE_FIELD_NUMBER = 2;
    public static final int UINT32_CLIENT_TYPE_FIELD_NUMBER = 5;
    public static final int UINT64_FROMUIN_FIELD_NUMBER = 1;
    public static final int UINT64_GROUP_CODE_FIELD_NUMBER = 4;
    public static final int UINT64_TOUIN_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72 }, new String[] { "uint64_fromuin", "uint32_chat_type", "uint64_touin", "uint64_group_code", "uint32_client_type", "msg_thumbinfo", "rpt_msg_merge_videoinfo", "rpt_msg_drop_videoinfo", "uint32_business_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), null, null, null, Integer.valueOf(0) }, ShortVideoSureReqInfo.class);
    public Bdh_extinfo.PicInfo msg_thumbinfo = new Bdh_extinfo.PicInfo();
    public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_drop_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
    public final PBRepeatMessageField<Bdh_extinfo.VideoInfo> rpt_msg_merge_videoinfo = PBField.initRepeatMessage(Bdh_extinfo.VideoInfo.class);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  }
  
  public static final class ShortVideoSureRspInfo
    extends MessageMicro<ShortVideoSureRspInfo>
  {
    public static final int BYTES_FILEID_FIELD_NUMBER = 1;
    public static final int BYTES_UKEY_FIELD_NUMBER = 2;
    public static final int MSG_VIDEOINFO_FIELD_NUMBER = 3;
    public static final int UINT32_MERGE_COST_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fileid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public Bdh_extinfo.VideoInfo msg_videoinfo = new Bdh_extinfo.VideoInfo();
    public final PBUInt32Field uint32_merge_cost = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "bytes_fileid", "bytes_ukey", "msg_videoinfo", "uint32_merge_cost" }, new Object[] { localByteStringMicro1, localByteStringMicro2, null, Integer.valueOf(0) }, ShortVideoSureRspInfo.class);
    }
  }
  
  public static final class VideoInfo
    extends MessageMicro<VideoInfo>
  {
    public static final int BYTES_BIN_MD5_FIELD_NUMBER = 3;
    public static final int UINT32_FORMAT_FIELD_NUMBER = 4;
    public static final int UINT32_IDX_FIELD_NUMBER = 1;
    public static final int UINT32_RES_LEN_FIELD_NUMBER = 5;
    public static final int UINT32_RES_WIDTH_FIELD_NUMBER = 6;
    public static final int UINT32_SIZE_FIELD_NUMBER = 2;
    public static final int UINT32_TIME_FIELD_NUMBER = 7;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_bin_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_format = PBField.initUInt32(0);
    public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res_len = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res_width = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40, 48, 56 }, new String[] { "uint32_idx", "uint32_size", "bytes_bin_md5", "uint32_format", "uint32_res_len", "uint32_res_width", "uint32_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, VideoInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.Bdh_extinfo
 * JD-Core Version:    0.7.0.1
 */