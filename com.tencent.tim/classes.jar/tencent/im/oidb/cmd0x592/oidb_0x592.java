package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.Timespan;
import com.trunk.Qworkflow.Qworkflow.UserSource;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;

public final class oidb_0x592
{
  public static final class AcceptScheduleReq
    extends MessageMicro<AcceptScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_schedule_id" }, new Object[] { localByteStringMicro }, AcceptScheduleReq.class);
    }
  }
  
  public static final class AcceptScheduleRsp
    extends MessageMicro<AcceptScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "bytes_schedule_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, AcceptScheduleRsp.class);
    }
  }
  
  public static final class AddScheduleReq
    extends MessageMicro<AddScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_schedule" }, new Object[] { null }, AddScheduleReq.class);
    public Qworkflow.Workflow msg_schedule = new Qworkflow.Workflow();
  }
  
  public static final class AddScheduleRsp
    extends MessageMicro<AddScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_result", "bytes_error_msg", "bytes_workflow_id", "uint32_data_version" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, AddScheduleRsp.class);
    }
  }
  
  public static final class BatchAddScheduleReq
    extends MessageMicro<BatchAddScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_schedule_list" }, new Object[] { null }, BatchAddScheduleReq.class);
    public final PBRepeatMessageField<Qworkflow.Workflow> rpt_msg_schedule_list = PBField.initRepeatMessage(Qworkflow.Workflow.class);
  }
  
  public static final class BatchAddScheduleResult
    extends MessageMicro<BatchAddScheduleResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_schedule_id", "uint32_result", "bytes_error_msg" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, BatchAddScheduleResult.class);
    }
  }
  
  public static final class BatchAddScheduleRsp
    extends MessageMicro<BatchAddScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.BatchAddScheduleResult> rpt_msg_result = PBField.initRepeatMessage(oidb_0x592.BatchAddScheduleResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, BatchAddScheduleRsp.class);
    }
  }
  
  public static final class ChangeMyNotificationReceivingStatusReq
    extends MessageMicro<ChangeMyNotificationReceivingStatusReq>
  {
    public static final int ADD_ME = 1;
    public static final int DELETE_ME = 2;
    public static final int OTHER_1 = 3;
    public static final int OTHER_2 = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, ChangeMyNotificationReceivingStatusReq.class);
    }
  }
  
  public static final class ChangeMyNotificationReceivingStatusRsp
    extends MessageMicro<ChangeMyNotificationReceivingStatusRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ChangeMyNotificationReceivingStatusRsp.class);
    }
  }
  
  public static final class DeleteMyScheduleReq
    extends MessageMicro<DeleteMyScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.Timespan msg_delete_time = new Qworkflow.Timespan();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_delete_time" }, new Object[] { localByteStringMicro, null }, DeleteMyScheduleReq.class);
    }
  }
  
  public static final class DeleteMyScheduleRsp
    extends MessageMicro<DeleteMyScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DeleteMyScheduleRsp.class);
    }
  }
  
  public static final class GetDateHasOnceScheduleReq
    extends MessageMicro<GetDateHasOnceScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_req_start_time", "uint64_req_end_time", "uint32_main_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0) }, GetDateHasOnceScheduleReq.class);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_req_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0L);
  }
  
  public static final class GetDateHasOnceScheduleRsp
    extends MessageMicro<GetDateHasOnceScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.GetDateResult> rpt_msg_date_result = PBField.initRepeatMessage(oidb_0x592.GetDateResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_rsp_end_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_result", "bytes_error_msg", "uint64_rsp_end_time", "rpt_msg_date_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), null }, GetDateHasOnceScheduleRsp.class);
    }
  }
  
  public static final class GetDateResult
    extends MessageMicro<GetDateResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_time" }, new Object[] { Long.valueOf(0L) }, GetDateResult.class);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  }
  
  public static final class GetOnceScheduleListIncrementallyReq
    extends MessageMicro<GetOnceScheduleListIncrementallyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_get_way", "uint64_lastest_modtime", "uint32_amount", "uint32_main_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, GetOnceScheduleListIncrementallyReq.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_way = PBField.initUInt32(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lastest_modtime = PBField.initUInt64(0L);
  }
  
  public static final class GetOnceScheduleListIncrementallyRsp
    extends MessageMicro<GetOnceScheduleListIncrementallyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.GetScheduleResult> rpt_msg_schedule_list = PBField.initRepeatMessage(oidb_0x592.GetScheduleResult.class);
    public final PBUInt32Field uint32_next_get_way = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_modtime = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_schedule_list", "uint64_next_modtime", "uint32_next_get_way" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), Integer.valueOf(0) }, GetOnceScheduleListIncrementallyRsp.class);
    }
  }
  
  public static final class GetOnceScheduleListReq
    extends MessageMicro<GetOnceScheduleListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "uint32_get_direction", "uint64_start_time", "uint32_amount", "rpt_msg_workflow_list", "uint32_main_type", "uint64_end_time" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L) }, GetOnceScheduleListReq.class);
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_direction = PBField.initUInt32(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  }
  
  public static final class GetOnceScheduleListRsp
    extends MessageMicro<GetOnceScheduleListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.GetScheduleResult> rpt_msg_result_list = PBField.initRepeatMessage(oidb_0x592.GetScheduleResult.class);
    public final PBUInt32Field uint32_get_direction = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_result", "bytes_error_msg", "uint32_get_direction", "uint64_end_time", "rpt_msg_result_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), null }, GetOnceScheduleListRsp.class);
    }
  }
  
  public static final class GetRepeatedScheduleListReq
    extends MessageMicro<GetRepeatedScheduleListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint64_lastest_modtime", "uint32_amount", "uint32_main_type", "uint32_get_way" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetRepeatedScheduleListReq.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_way = PBField.initUInt32(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_lastest_modtime = PBField.initUInt64(0L);
  }
  
  public static final class GetRepeatedScheduleListRsp
    extends MessageMicro<GetRepeatedScheduleListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.GetScheduleResult> rpt_msg_schedule_list = PBField.initRepeatMessage(oidb_0x592.GetScheduleResult.class);
    public final PBUInt32Field uint32_next_get_way = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_modtime = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_schedule_list", "uint64_next_modtime", "uint32_next_get_way" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null, Long.valueOf(0L), Integer.valueOf(0) }, GetRepeatedScheduleListRsp.class);
    }
  }
  
  public static final class GetScheduleByIDReq
    extends MessageMicro<GetScheduleByIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.WorkflowBrief msg_schedule_brief = new Qworkflow.WorkflowBrief();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_schedule_brief" }, new Object[] { localByteStringMicro, null }, GetScheduleByIDReq.class);
    }
  }
  
  public static final class GetScheduleByIDRsp
    extends MessageMicro<GetScheduleByIDRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x592.GetScheduleResult msg_schedule_result = new oidb_0x592.GetScheduleResult();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "msg_schedule_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, GetScheduleByIDRsp.class);
    }
  }
  
  public static final class GetScheduleResult
    extends MessageMicro<GetScheduleResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "msg_schedule" }, new Object[] { Integer.valueOf(0), null }, GetScheduleResult.class);
    public Qworkflow.Workflow msg_schedule = new Qworkflow.Workflow();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class ModifyRepeatedScheduleReq
    extends MessageMicro<ModifyRepeatedScheduleReq>
  {
    public static final int ALL_MODIFY = 1;
    public static final int PART_MODIFY = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_modify_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_modify_type = PBField.initEnum(1);
    public Qworkflow.Timespan msg_modify_timespan = new Qworkflow.Timespan();
    public Qworkflow.Workflow msg_new_schedule = new Qworkflow.Workflow();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "msg_new_schedule", "enum_modify_type", "bytes_modify_schedule_id", "msg_modify_timespan" }, new Object[] { null, Integer.valueOf(1), localByteStringMicro, null }, ModifyRepeatedScheduleReq.class);
    }
  }
  
  public static final class ModifyRepeatedScheduleRsp
    extends MessageMicro<ModifyRepeatedScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_new_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_result", "bytes_error_msg", "uint32_data_version", "bytes_new_workflow_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, ModifyRepeatedScheduleRsp.class);
    }
  }
  
  public static final class ModifyUnreadCntReq
    extends MessageMicro<ModifyUnreadCntReq>
  {
    public static final int CLEAR = 3;
    public static final int DECREASE = 2;
    public static final int INCREASE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_modify_type", "uint32_notice_var", "uint32_notice_version" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) }, ModifyUnreadCntReq.class);
    public final PBEnumField enum_modify_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_notice_var = PBField.initUInt32(0);
    public final PBUInt32Field uint32_notice_version = PBField.initUInt32(0);
  }
  
  public static final class ModifyUnreadCntRsp
    extends MessageMicro<ModifyUnreadCntRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ModifyUnreadCntRsp.class);
    }
  }
  
  public static final class RecallRepeatedScheduleReq
    extends MessageMicro<RecallRepeatedScheduleReq>
  {
    public static final int ALL_RECALL = 1;
    public static final int PART_RECALL = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_recall_type = PBField.initEnum(1);
    public Qworkflow.AppID msg_notify_source_id = new Qworkflow.AppID();
    public final PBUInt64Field uint64_recall_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recall_start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "bytes_workflow_id", "msg_notify_source_id", "enum_recall_type", "uint64_recall_start_time", "uint64_recall_end_time" }, new Object[] { localByteStringMicro, null, Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, RecallRepeatedScheduleReq.class);
    }
  }
  
  public static final class RecallRepeatedScheduleRsp
    extends MessageMicro<RecallRepeatedScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RecallRepeatedScheduleRsp.class);
    }
  }
  
  public static final class RecallScheduleReq
    extends MessageMicro<RecallScheduleReq>
  {
    public static final int CLOSE = 0;
    public static final int OPEN = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_silent_switch = PBField.initEnum(0);
    public Qworkflow.AppID msg_notify_source_id = new Qworkflow.AppID();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "enum_silent_switch", "msg_notify_source_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, RecallScheduleReq.class);
    }
  }
  
  public static final class RecallScheduleRsp
    extends MessageMicro<RecallScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RecallScheduleRsp.class);
    }
  }
  
  public static final class RepeatedScheduleShareInfo
    extends MessageMicro<RepeatedScheduleShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_share_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_schedule_id", "rpt_msg_share_timespan" }, new Object[] { localByteStringMicro, null }, RepeatedScheduleShareInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "msg_appid", "msg_add_schedule_req", "msg_get_once_schedule_list_req", "msg_get_schedule_by_id_req", "msg_get_repeated_schedule_list_req", "msg_update_schedule_content_req", "msg_delete_my_schedule_req", "msg_recall_schedule_req", "msg_share_schedule_req", "msg_change_my_recv_status_req", "msg_set_all_readed_time_req", "msg_modify_unread_cnt_req", "msg_set_remind_bell_switch_req", "msg_get_date_has_once_schedule_req", "msg_modify_repeated_schedule_req", "msg_recall_repeated_schedule_req", "msg_get_repeated_schedule_list_req_new", "msg_get_once_schedule_list_incrementally_req", "msg_accept_schedule_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public oidb_0x592.AcceptScheduleReq msg_accept_schedule_req = new oidb_0x592.AcceptScheduleReq();
    public oidb_0x592.AddScheduleReq msg_add_schedule_req = new oidb_0x592.AddScheduleReq();
    public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
    public oidb_0x592.ChangeMyNotificationReceivingStatusReq msg_change_my_recv_status_req = new oidb_0x592.ChangeMyNotificationReceivingStatusReq();
    public oidb_0x592.DeleteMyScheduleReq msg_delete_my_schedule_req = new oidb_0x592.DeleteMyScheduleReq();
    public oidb_0x592.GetDateHasOnceScheduleReq msg_get_date_has_once_schedule_req = new oidb_0x592.GetDateHasOnceScheduleReq();
    public oidb_0x592.GetOnceScheduleListIncrementallyReq msg_get_once_schedule_list_incrementally_req = new oidb_0x592.GetOnceScheduleListIncrementallyReq();
    public oidb_0x592.GetOnceScheduleListReq msg_get_once_schedule_list_req = new oidb_0x592.GetOnceScheduleListReq();
    public oidb_0x592.GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req = new oidb_0x592.GetRepeatedScheduleListReq();
    public oidb_0x592.GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req_new = new oidb_0x592.GetRepeatedScheduleListReq();
    public oidb_0x592.GetScheduleByIDReq msg_get_schedule_by_id_req = new oidb_0x592.GetScheduleByIDReq();
    public oidb_0x592.ModifyRepeatedScheduleReq msg_modify_repeated_schedule_req = new oidb_0x592.ModifyRepeatedScheduleReq();
    public oidb_0x592.ModifyUnreadCntReq msg_modify_unread_cnt_req = new oidb_0x592.ModifyUnreadCntReq();
    public oidb_0x592.RecallRepeatedScheduleReq msg_recall_repeated_schedule_req = new oidb_0x592.RecallRepeatedScheduleReq();
    public oidb_0x592.RecallScheduleReq msg_recall_schedule_req = new oidb_0x592.RecallScheduleReq();
    public oidb_0x592.SetAllReadedTimeReq msg_set_all_readed_time_req = new oidb_0x592.SetAllReadedTimeReq();
    public oidb_0x592.SetRemindBellSwitchReq msg_set_remind_bell_switch_req = new oidb_0x592.SetRemindBellSwitchReq();
    public oidb_0x592.ShareScheduleReq msg_share_schedule_req = new oidb_0x592.ShareScheduleReq();
    public oidb_0x592.UpdateScheduleContentReq msg_update_schedule_content_req = new oidb_0x592.UpdateScheduleContentReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "msg_appid", "msg_add_schedule_rsp", "msg_get_once_schedule_list_rsp", "msg_get_schedule_by_id_rsp", "msg_get_repeated_schedule_list_rsp", "msg_update_schedule_content_rsp", "msg_delete_my_schedule_rsp", "msg_recall_schedule_rsp", "msg_share_schedule_rsp", "msg_change_my_recv_status_rsp", "msg_set_all_readed_time_rsp", "msg_modify_unread_cnt_rsp", "msg_set_remind_bell_switch_rsp", "msg_get_date_has_once_schedule_rsp", "msg_modify_repeated_schedule_rsp", "msg_recall_repeated_schedule_rsp", "msg_get_repeated_schedule_list_rsp_new", "msg_get_once_schedule_list_incrementally_rsp", "msg_accept_schedule_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public oidb_0x592.AcceptScheduleRsp msg_accept_schedule_rsp = new oidb_0x592.AcceptScheduleRsp();
    public oidb_0x592.AddScheduleRsp msg_add_schedule_rsp = new oidb_0x592.AddScheduleRsp();
    public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
    public oidb_0x592.ChangeMyNotificationReceivingStatusRsp msg_change_my_recv_status_rsp = new oidb_0x592.ChangeMyNotificationReceivingStatusRsp();
    public oidb_0x592.DeleteMyScheduleRsp msg_delete_my_schedule_rsp = new oidb_0x592.DeleteMyScheduleRsp();
    public oidb_0x592.GetDateHasOnceScheduleRsp msg_get_date_has_once_schedule_rsp = new oidb_0x592.GetDateHasOnceScheduleRsp();
    public oidb_0x592.GetOnceScheduleListIncrementallyRsp msg_get_once_schedule_list_incrementally_rsp = new oidb_0x592.GetOnceScheduleListIncrementallyRsp();
    public oidb_0x592.GetOnceScheduleListRsp msg_get_once_schedule_list_rsp = new oidb_0x592.GetOnceScheduleListRsp();
    public oidb_0x592.GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp = new oidb_0x592.GetRepeatedScheduleListRsp();
    public oidb_0x592.GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp_new = new oidb_0x592.GetRepeatedScheduleListRsp();
    public oidb_0x592.GetScheduleByIDRsp msg_get_schedule_by_id_rsp = new oidb_0x592.GetScheduleByIDRsp();
    public oidb_0x592.ModifyRepeatedScheduleRsp msg_modify_repeated_schedule_rsp = new oidb_0x592.ModifyRepeatedScheduleRsp();
    public oidb_0x592.ModifyUnreadCntRsp msg_modify_unread_cnt_rsp = new oidb_0x592.ModifyUnreadCntRsp();
    public oidb_0x592.RecallRepeatedScheduleRsp msg_recall_repeated_schedule_rsp = new oidb_0x592.RecallRepeatedScheduleRsp();
    public oidb_0x592.RecallScheduleRsp msg_recall_schedule_rsp = new oidb_0x592.RecallScheduleRsp();
    public oidb_0x592.SetAllReadedTimeRsp msg_set_all_readed_time_rsp = new oidb_0x592.SetAllReadedTimeRsp();
    public oidb_0x592.SetRemindBellSwitchRsp msg_set_remind_bell_switch_rsp = new oidb_0x592.SetRemindBellSwitchRsp();
    public oidb_0x592.ShareScheduleRsp msg_share_schedule_rsp = new oidb_0x592.ShareScheduleRsp();
    public oidb_0x592.UpdateScheduleContentRsp msg_update_schedule_content_rsp = new oidb_0x592.UpdateScheduleContentRsp();
  }
  
  public static final class SetAllReadedTimeReq
    extends MessageMicro<SetAllReadedTimeReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint64_all_readed_time" }, new Object[] { Long.valueOf(0L) }, SetAllReadedTimeReq.class);
    public final PBUInt64Field uint64_all_readed_time = PBField.initUInt64(0L);
  }
  
  public static final class SetAllReadedTimeRsp
    extends MessageMicro<SetAllReadedTimeRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SetAllReadedTimeRsp.class);
    }
  }
  
  public static final class SetRemindBellSwitchReq
    extends MessageMicro<SetRemindBellSwitchReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_remind_bell_switch", "bytes_workflow_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SetRemindBellSwitchReq.class);
    }
  }
  
  public static final class SetRemindBellSwitchRsp
    extends MessageMicro<SetRemindBellSwitchRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, SetRemindBellSwitchRsp.class);
    }
  }
  
  public static final class ShareReceiver
    extends MessageMicro<ShareReceiver>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_source" }, new Object[] { Long.valueOf(0L), null }, ShareReceiver.class);
    public Qworkflow.UserSource msg_source = new Qworkflow.UserSource();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ShareScheduleReq
    extends MessageMicro<ShareScheduleReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public Qworkflow.AppID msg_receive_group = new Qworkflow.AppID();
    public final PBRepeatMessageField<oidb_0x592.RepeatedScheduleShareInfo> rpt_msg_repeated_schedule = PBField.initRepeatMessage(oidb_0x592.RepeatedScheduleShareInfo.class);
    public final PBRepeatMessageField<oidb_0x592.ShareReceiver> rpt_receiver_list = PBField.initRepeatMessage(oidb_0x592.ShareReceiver.class);
    public final PBRepeatField<ByteStringMicro> rpt_schedule_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_schedule_id_list", "rpt_receiver_list", "msg_receive_group", "rpt_msg_repeated_schedule" }, new Object[] { localByteStringMicro, null, null, null }, ShareScheduleReq.class);
    }
  }
  
  public static final class ShareScheduleResult
    extends MessageMicro<ShareScheduleResult>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_fail_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "bytes_schedule_id", "uint32_result", "bytes_error_msg", "rpt_msg_fail_timespan" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, null }, ShareScheduleResult.class);
    }
  }
  
  public static final class ShareScheduleRsp
    extends MessageMicro<ShareScheduleRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x592.ShareScheduleResult> rpt_fail_schedule_list = PBField.initRepeatMessage(oidb_0x592.ShareScheduleResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_fail_schedule_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, ShareScheduleRsp.class);
    }
  }
  
  public static final class UpdateScheduleContentReq
    extends MessageMicro<UpdateScheduleContentReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_schedule" }, new Object[] { null }, UpdateScheduleContentReq.class);
    public Qworkflow.Workflow msg_schedule = new Qworkflow.Workflow();
  }
  
  public static final class UpdateScheduleContentRsp
    extends MessageMicro<UpdateScheduleContentRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "bytes_error_msg", "uint32_data_version" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, UpdateScheduleContentRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592
 * JD-Core Version:    0.7.0.1
 */