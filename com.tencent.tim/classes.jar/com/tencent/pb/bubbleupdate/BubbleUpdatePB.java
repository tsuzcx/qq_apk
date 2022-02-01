package com.tencent.pb.bubbleupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleUpdatePB
{
  public static final class ReqUpdate
    extends MessageMicro<ReqUpdate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "int32_cmd", "uint64_uin", "uint32_plat_id", "str_version", "msg_req_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", null }, ReqUpdate.class);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);
    public BubbleUpdatePB.ReqUpdateData msg_req_data = new BubbleUpdatePB.ReqUpdateData();
    public final PBStringField str_version = PBField.initString("");
    public final PBUInt32Field uint32_plat_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ReqUpdateData
    extends MessageMicro<ReqUpdateData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_req_update" }, new Object[] { null }, ReqUpdateData.class);
    public final PBRepeatMessageField<BubbleUpdatePB.ReqUpdateTable> rpt_msg_req_update = PBField.initRepeatMessage(BubbleUpdatePB.ReqUpdateTable.class);
  }
  
  public static final class ReqUpdateTable
    extends MessageMicro<ReqUpdateTable>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_item_id", "uint32_version" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, ReqUpdateTable.class);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_version = PBField.initUInt32(0);
  }
  
  public static final class RspUpdate
    extends MessageMicro<RspUpdate>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_ret", "uint64_uin", "uint32_used_item_id", "msg_rsp_data" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null }, RspUpdate.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public BubbleUpdatePB.RspUpdateData msg_rsp_data = new BubbleUpdatePB.RspUpdateData();
    public final PBUInt32Field uint32_used_item_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class RspUpdateData
    extends MessageMicro<RspUpdateData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_rsp_update" }, new Object[] { null }, RspUpdateData.class);
    public final PBRepeatMessageField<BubbleUpdatePB.RspUpdateTable> rpt_msg_rsp_update = PBField.initRepeatMessage(BubbleUpdatePB.RspUpdateTable.class);
  }
  
  public static final class RspUpdateTable
    extends MessageMicro<RspUpdateTable>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_item_id", "uint32_is_update" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, RspUpdateTable.class);
    public final PBUInt32Field uint32_is_update = PBField.initUInt32(0);
    public final PBUInt32Field uint32_item_id = PBField.initUInt32(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.bubbleupdate.BubbleUpdatePB
 * JD-Core Version:    0.7.0.1
 */