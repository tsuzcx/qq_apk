package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.Approver;
import com.trunk.Qworkflow.Qworkflow.ApproverState;
import com.trunk.Qworkflow.Qworkflow.UserSource;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowBrief;
import com.trunk.Qworkflow.Qworkflow.WorkflowState;

public final class oidb_0x4d4
{
  public static final class AddWorkflowReq
    extends MessageMicro<AddWorkflowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_workflow" }, new Object[] { null }, AddWorkflowReq.class);
    public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
  }
  
  public static final class AddWorkflowRsp
    extends MessageMicro<AddWorkflowRsp>
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
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32 }, new String[] { "uint32_result", "bytes_error_msg", "bytes_workflow_id", "uint32_data_version" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, AddWorkflowRsp.class);
    }
  }
  
  public static final class ApproverChange
    extends MessageMicro<ApproverChange>
  {
    public static final int ADD = 1;
    public static final int DELETE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_change_type", "msg_approver" }, new Object[] { Integer.valueOf(1), null }, ApproverChange.class);
    public final PBEnumField enum_change_type = PBField.initEnum(1);
    public Qworkflow.Approver msg_approver = new Qworkflow.Approver();
  }
  
  public static final class ApproverChangeInState
    extends MessageMicro<ApproverChangeInState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_change_list" }, new Object[] { null, null }, ApproverChangeInState.class);
    public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
    public final PBRepeatMessageField<oidb_0x4d4.ApproverChange> rpt_msg_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4.ApproverChange.class);
  }
  
  public static final class DeleteWorkflowReq
    extends MessageMicro<DeleteWorkflowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, DeleteWorkflowReq.class);
    }
  }
  
  public static final class DeleteWorkflowRsp
    extends MessageMicro<DeleteWorkflowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DeleteWorkflowRsp.class);
    }
  }
  
  public static final class GetWorkflowByIDReq
    extends MessageMicro<GetWorkflowByIDReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.WorkflowBrief msg_workflow_brief = new Qworkflow.WorkflowBrief();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_workflow_brief" }, new Object[] { localByteStringMicro, null }, GetWorkflowByIDReq.class);
    }
  }
  
  public static final class GetWorkflowByIDRsp
    extends MessageMicro<GetWorkflowByIDRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x4d4.GetWorkflowResult msg_workflow_result = new oidb_0x4d4.GetWorkflowResult();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "msg_workflow_result" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, GetWorkflowByIDRsp.class);
    }
  }
  
  public static final class GetWorkflowListReq
    extends MessageMicro<GetWorkflowListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "uint64_end_time", "rpt_msg_workflow_list", "uint32_amount", "msg_filter", "msg_order" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(0), null, null }, GetWorkflowListReq.class);
    public oidb_0x4d4.WorkflowFilter msg_filter = new oidb_0x4d4.WorkflowFilter();
    public oidb_0x4d4.WorkflowOrder msg_order = new oidb_0x4d4.WorkflowOrder();
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
    public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  }
  
  public static final class GetWorkflowListRsp
    extends MessageMicro<GetWorkflowListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x4d4.GetWorkflowResult> rpt_msg_result_list = PBField.initRepeatMessage(oidb_0x4d4.GetWorkflowResult.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "uint32_result", "bytes_error_msg", "uint64_start_time", "uint64_end_time", "rpt_msg_result_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), null }, GetWorkflowListRsp.class);
    }
  }
  
  public static final class GetWorkflowResult
    extends MessageMicro<GetWorkflowResult>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "msg_workflow_source", "msg_workflow" }, new Object[] { Integer.valueOf(0), null, null }, GetWorkflowResult.class);
    public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
    public oidb_0x4d4.WorkflowSource msg_workflow_source = new oidb_0x4d4.WorkflowSource();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  }
  
  public static final class HastenWorkflowReq
    extends MessageMicro<HastenWorkflowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, HastenWorkflowReq.class);
    }
  }
  
  public static final class HastenWorkflowRsp
    extends MessageMicro<HastenWorkflowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, HastenWorkflowRsp.class);
    }
  }
  
  public static final class RecallWorkflowReq
    extends MessageMicro<RecallWorkflowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_workflow_id" }, new Object[] { localByteStringMicro }, RecallWorkflowReq.class);
    }
  }
  
  public static final class RecallWorkflowRsp
    extends MessageMicro<RecallWorkflowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RecallWorkflowRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_appid", "msg_get_workflow_list_req", "msg_update_workflows_req", "msg_add_workflow_req", "msg_delete_workflow_req", "msg_recall_workflow_req", "msg_set_workflows_readed_req", "msg_set_all_workflow_processed_req", "msg_get_workflow_by_id_req", "msg_set_workflows_ignore_state_req", "msg_share_workflow_req", "msg_hasten_workflow_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
    public oidb_0x4d4.AddWorkflowReq msg_add_workflow_req = new oidb_0x4d4.AddWorkflowReq();
    public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
    public oidb_0x4d4.DeleteWorkflowReq msg_delete_workflow_req = new oidb_0x4d4.DeleteWorkflowReq();
    public oidb_0x4d4.GetWorkflowByIDReq msg_get_workflow_by_id_req = new oidb_0x4d4.GetWorkflowByIDReq();
    public oidb_0x4d4.GetWorkflowListReq msg_get_workflow_list_req = new oidb_0x4d4.GetWorkflowListReq();
    public oidb_0x4d4.HastenWorkflowReq msg_hasten_workflow_req = new oidb_0x4d4.HastenWorkflowReq();
    public oidb_0x4d4.RecallWorkflowReq msg_recall_workflow_req = new oidb_0x4d4.RecallWorkflowReq();
    public oidb_0x4d4.SetAllWorkflowProcessedReq msg_set_all_workflow_processed_req = new oidb_0x4d4.SetAllWorkflowProcessedReq();
    public oidb_0x4d4.SetWorkflowsIgnoreStateReq msg_set_workflows_ignore_state_req = new oidb_0x4d4.SetWorkflowsIgnoreStateReq();
    public oidb_0x4d4.SetWorkflowsReadedReq msg_set_workflows_readed_req = new oidb_0x4d4.SetWorkflowsReadedReq();
    public oidb_0x4d4.ShareWorkflowReq msg_share_workflow_req = new oidb_0x4d4.ShareWorkflowReq();
    public oidb_0x4d4.UpdateWorkflowsReq msg_update_workflows_req = new oidb_0x4d4.UpdateWorkflowsReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_appid", "msg_get_workflow_list_rsp", "msg_update_workflow_rsp", "msg_add_workflow_rsp", "msg_delete_workflow_rsp", "msg_recall_workflow_rsp", "msg_set_workflows_readed_rsp", "msg_set_all_workflow_processed_rsp", "msg_get_workflow_by_id_rsp", "msg_set_workflows_ignore_state_rsp", "msg_share_workflow_rsp", "msg_hasten_workflow_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
    public oidb_0x4d4.AddWorkflowRsp msg_add_workflow_rsp = new oidb_0x4d4.AddWorkflowRsp();
    public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
    public oidb_0x4d4.DeleteWorkflowRsp msg_delete_workflow_rsp = new oidb_0x4d4.DeleteWorkflowRsp();
    public oidb_0x4d4.GetWorkflowByIDRsp msg_get_workflow_by_id_rsp = new oidb_0x4d4.GetWorkflowByIDRsp();
    public oidb_0x4d4.GetWorkflowListRsp msg_get_workflow_list_rsp = new oidb_0x4d4.GetWorkflowListRsp();
    public oidb_0x4d4.HastenWorkflowRsp msg_hasten_workflow_rsp = new oidb_0x4d4.HastenWorkflowRsp();
    public oidb_0x4d4.RecallWorkflowRsp msg_recall_workflow_rsp = new oidb_0x4d4.RecallWorkflowRsp();
    public oidb_0x4d4.SetAllWorkflowProcessedRsp msg_set_all_workflow_processed_rsp = new oidb_0x4d4.SetAllWorkflowProcessedRsp();
    public oidb_0x4d4.SetWorkflowsIgnoreStateRsp msg_set_workflows_ignore_state_rsp = new oidb_0x4d4.SetWorkflowsIgnoreStateRsp();
    public oidb_0x4d4.SetWorkflowsReadedRsp msg_set_workflows_readed_rsp = new oidb_0x4d4.SetWorkflowsReadedRsp();
    public oidb_0x4d4.ShareWorkflowRsp msg_share_workflow_rsp = new oidb_0x4d4.ShareWorkflowRsp();
    public oidb_0x4d4.UpdateWorkflowsRsp msg_update_workflow_rsp = new oidb_0x4d4.UpdateWorkflowsRsp();
  }
  
  public static final class SetAllWorkflowProcessedReq
    extends MessageMicro<SetAllWorkflowProcessedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_end_time", "msg_approver_state" }, new Object[] { Long.valueOf(0L), null }, SetAllWorkflowProcessedReq.class);
    public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
  }
  
  public static final class SetAllWorkflowProcessedRsp
    extends MessageMicro<SetAllWorkflowProcessedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_failure_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_result", "bytes_error_msg", "uint32_failure_count" }, new Object[] { Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0) }, SetAllWorkflowProcessedRsp.class);
    }
  }
  
  public static final class SetWorkflowsIgnoreStateReq
    extends MessageMicro<SetWorkflowsIgnoreStateReq>
  {
    public static final int IGNORED = 1;
    public static final int NOT_IGNORED = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_state", "rpt_msg_workflow_list" }, new Object[] { Integer.valueOf(1), null }, SetWorkflowsIgnoreStateReq.class);
    public final PBEnumField enum_state = PBField.initEnum(1);
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
  }
  
  public static final class SetWorkflowsIgnoreStateRsp
    extends MessageMicro<SetWorkflowsIgnoreStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_failure_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_failure_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, SetWorkflowsIgnoreStateRsp.class);
    }
  }
  
  public static final class SetWorkflowsReadedReq
    extends MessageMicro<SetWorkflowsReadedReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_workflow_list" }, new Object[] { null }, SetWorkflowsReadedReq.class);
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
  }
  
  public static final class SetWorkflowsReadedRsp
    extends MessageMicro<SetWorkflowsReadedRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.WorkflowBrief> rpt_msg_failure_list = PBField.initRepeatMessage(Qworkflow.WorkflowBrief.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_result", "bytes_error_msg", "rpt_msg_failure_list" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, SetWorkflowsReadedRsp.class);
    }
  }
  
  public static final class ShareReceiver
    extends MessageMicro<ShareReceiver>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_source" }, new Object[] { Long.valueOf(0L), null }, ShareReceiver.class);
    public Qworkflow.UserSource msg_source = new Qworkflow.UserSource();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class ShareWorkflowReq
    extends MessageMicro<ShareWorkflowReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0x4d4.ShareReceiver msg_receiver = new oidb_0x4d4.ShareReceiver();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_workflow_id", "msg_receiver" }, new Object[] { localByteStringMicro, null }, ShareWorkflowReq.class);
    }
  }
  
  public static final class ShareWorkflowRsp
    extends MessageMicro<ShareWorkflowRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_error_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ShareWorkflowRsp.class);
    }
  }
  
  public static final class UpdateApproverListOfState
    extends MessageMicro<UpdateApproverListOfState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0x4d4.ApproverChangeInState> rpt_msg_state_approver_change_list = PBField.initRepeatMessage(oidb_0x4d4.ApproverChangeInState.class);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "uint32_data_version", "rpt_msg_state_approver_change_list" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, UpdateApproverListOfState.class);
    }
  }
  
  public static final class UpdateApproverProcessState
    extends MessageMicro<UpdateApproverProcessState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "uint32_data_version", "msg_approver_state" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, UpdateApproverProcessState.class);
    }
  }
  
  public static final class UpdateFailure
    extends MessageMicro<UpdateFailure>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.Workflow msg_workflow = new Qworkflow.Workflow();
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_result", "bytes_error_msg", "bytes_workflow_id", "msg_workflow" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, null }, UpdateFailure.class);
    }
  }
  
  public static final class UpdateHandOver
    extends MessageMicro<UpdateHandOver>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.Approver msg_approver = new Qworkflow.Approver();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "bytes_workflow_id", "uint32_data_version", "msg_approver" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, UpdateHandOver.class);
    }
  }
  
  public static final class UpdateWorkflowsReq
    extends MessageMicro<UpdateWorkflowsReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_update_type", "rpt_msg_update_list", "rpt_msg_process_workflows", "msg_hand_over" }, new Object[] { Integer.valueOf(1), null, null, null }, UpdateWorkflowsReq.class);
    public final PBEnumField enum_update_type = PBField.initEnum(1);
    public oidb_0x4d4.UpdateHandOver msg_hand_over = new oidb_0x4d4.UpdateHandOver();
    public final PBRepeatMessageField<oidb_0x4d4.UpdateApproverProcessState> rpt_msg_process_workflows = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverProcessState.class);
    public final PBRepeatMessageField<oidb_0x4d4.UpdateApproverListOfState> rpt_msg_update_list = PBField.initRepeatMessage(oidb_0x4d4.UpdateApproverListOfState.class);
  }
  
  public static final class UpdateWorkflowsRsp
    extends MessageMicro<UpdateWorkflowsRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_update_type = PBField.initEnum(1);
    public final PBRepeatMessageField<oidb_0x4d4.UpdateFailure> rpt_msg_udpate_failure_list = PBField.initRepeatMessage(oidb_0x4d4.UpdateFailure.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "enum_update_type", "uint32_result", "bytes_error_msg", "rpt_msg_udpate_failure_list" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), localByteStringMicro, null }, UpdateWorkflowsRsp.class);
    }
  }
  
  public static final class WorkflowFilter
    extends MessageMicro<WorkflowFilter>
  {
    public static final int IGNORED = 1;
    public static final int NOT_IGNORED = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 50 }, new String[] { "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "rpt_msg_my_state", "enum_ignore_state", "msg_workflow_source" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), null, Integer.valueOf(1), null }, WorkflowFilter.class);
    public final PBEnumField enum_ignore_state = PBField.initEnum(1);
    public oidb_0x4d4.WorkflowSource msg_workflow_source = new oidb_0x4d4.WorkflowSource();
    public final PBRepeatMessageField<Qworkflow.ApproverState> rpt_msg_my_state = PBField.initRepeatMessage(Qworkflow.ApproverState.class);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
  }
  
  public static final class WorkflowOrder
    extends MessageMicro<WorkflowOrder>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], WorkflowOrder.class);
  }
  
  public static final class WorkflowSource
    extends MessageMicro<WorkflowSource>
  {
    public static final int NEED_APPROVE = 2;
    public static final int NEED_OBSERVE = 1;
    public static final int SELF_CREATE = 3;
    public static final int SHARED = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "enum_source_type" }, new Object[] { Integer.valueOf(1) }, WorkflowSource.class);
    public final PBEnumField enum_source_type = PBField.initEnum(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4
 * JD-Core Version:    0.7.0.1
 */