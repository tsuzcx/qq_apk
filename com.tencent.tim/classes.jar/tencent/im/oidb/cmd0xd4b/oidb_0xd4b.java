package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd4b
{
  public static final class CheckUserSubStatusReq
    extends MessageMicro<CheckUserSubStatusReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_video_column_id" }, new Object[] { Integer.valueOf(0) }, CheckUserSubStatusReq.class);
    public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class CheckUserSubStatusRsp
    extends MessageMicro<CheckUserSubStatusRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "rpt_subscribe_status" }, new Object[] { Integer.valueOf(0) }, CheckUserSubStatusRsp.class);
    public final PBRepeatField<Integer> rpt_subscribe_status = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  }
  
  public static final class KdVideoColumnInfo
    extends MessageMicro<KdVideoColumnInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_video_column_id", "int64_last_update_time", "uint32_video_num", "uint32_is_subscribed" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, KdVideoColumnInfo.class);
    public final PBInt64Field int64_last_update_time = PBField.initInt64(0L);
    public final PBUInt32Field uint32_is_subscribed = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_num = PBField.initUInt32(0);
  }
  
  public static final class QueryKdVideoColumnReq
    extends MessageMicro<QueryKdVideoColumnReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_query_sub_status", "rpt_video_column_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, QueryKdVideoColumnReq.class);
    public final PBRepeatField<Integer> rpt_video_column_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBUInt32Field uint32_query_sub_status = PBField.initUInt32(0);
  }
  
  public static final class QueryKdVideoColumnRsp
    extends MessageMicro<QueryKdVideoColumnRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_kd_video_column" }, new Object[] { null }, QueryKdVideoColumnRsp.class);
    public final PBRepeatMessageField<oidb_0xd4b.KdVideoColumnInfo> rpt_kd_video_column = PBField.initRepeatMessage(oidb_0xd4b.KdVideoColumnInfo.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_subscribe_video_column_req", "msg_checkuser_substatus_req", "msg_query_kd_video_column_req" }, new Object[] { null, null, null }, ReqBody.class);
    public oidb_0xd4b.CheckUserSubStatusReq msg_checkuser_substatus_req = new oidb_0xd4b.CheckUserSubStatusReq();
    public oidb_0xd4b.QueryKdVideoColumnReq msg_query_kd_video_column_req = new oidb_0xd4b.QueryKdVideoColumnReq();
    public oidb_0xd4b.SubscribeVideoColumnReq msg_subscribe_video_column_req = new oidb_0xd4b.SubscribeVideoColumnReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_subscribe_video_column_rsp", "query_kd_video_column_rsp" }, new Object[] { null, null }, RspBody.class);
    public oidb_0xd4b.SubscribeVideoColumnRsp msg_subscribe_video_column_rsp = new oidb_0xd4b.SubscribeVideoColumnRsp();
    public oidb_0xd4b.QueryKdVideoColumnRsp query_kd_video_column_rsp = new oidb_0xd4b.QueryKdVideoColumnRsp();
  }
  
  public static final class SubscribeVideoColumnReq
    extends MessageMicro<SubscribeVideoColumnReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_video_column_id", "uint32_oper_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, SubscribeVideoColumnReq.class);
    public final PBUInt32Field uint32_oper_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_video_column_id = PBField.initUInt32(0);
  }
  
  public static final class SubscribeVideoColumnRsp
    extends MessageMicro<SubscribeVideoColumnRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SubscribeVideoColumnRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd4b.oidb_0xd4b
 * JD-Core Version:    0.7.0.1
 */