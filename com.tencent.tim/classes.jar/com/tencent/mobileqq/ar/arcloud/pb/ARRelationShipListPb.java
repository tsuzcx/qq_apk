package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ARRelationShipListPb
{
  public static final class PageCookie
    extends MessageMicro<PageCookie>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_my_send_start_idx", "uint32_my_recv_start_idx" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, PageCookie.class);
    public final PBUInt32Field uint32_my_recv_start_idx = PBField.initUInt32(0);
    public final PBUInt32Field uint32_my_send_start_idx = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_req_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_peer_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_req_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_list_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_recv_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_del_to_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_share_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64, 72 }, new String[] { "uint32_req_list_type", "bytes_req_page_cookies", "uint32_req_count", "uint64_start_time", "uint64_topic_id", "rpt_uint64_peer_uin", "uint64_share_id", "uint32_send_recv_flag", "uint64_del_to_uin" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_rsp_page_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<ARRelationShipListPb.SendRecvShareInfo> rpt_send_recv_share_list = PBField.initRepeatMessage(ARRelationShipListPb.SendRecvShareInfo.class);
    public final PBUInt32Field uint32_is_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_share_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_recv_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_total_send_count = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "uint32_share_flag", "rpt_send_recv_share_list", "uint32_is_end", "bytes_rsp_page_cookies", "uint32_total_send_count", "uint32_total_recv_count" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
    }
  }
  
  public static final class SendRecvShareInfo
    extends MessageMicro<SendRecvShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 66, 72, 80, 160, 168, 178, 186 }, new String[] { "uint64_from_uin", "uint64_topic_id", "uint64_share_id", "enum_content_type", "uint64_create_time", "str_video_url", "str_cover_url", "str_desc", "uint32_duration", "uint32_size", "rpt_uint64_to_uin", "uint32_send_recv_flag", "str_to_from_nick", "str_to_from_remark" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Long.valueOf(0L), "", "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "" }, SendRecvShareInfo.class);
    public final PBEnumField enum_content_type = PBField.initEnum(1);
    public final PBRepeatField<Long> rpt_uint64_to_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBStringField str_cover_url = PBField.initString("");
    public final PBStringField str_desc = PBField.initString("");
    public final PBStringField str_to_from_nick = PBField.initString("");
    public final PBStringField str_to_from_remark = PBField.initString("");
    public final PBStringField str_video_url = PBField.initString("");
    public final PBUInt32Field uint32_duration = PBField.initUInt32(0);
    public final PBUInt32Field uint32_send_recv_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_share_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_topic_id = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARRelationShipListPb
 * JD-Core Version:    0.7.0.1
 */