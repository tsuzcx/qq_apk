package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Qworkflow
{
  public static final class AppID
    extends MessageMicro<AppID>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_type", "uint64_appid" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L) }, AppID.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  }
  
  public static final class Approver
    extends MessageMicro<Approver>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.UserSource msg_approver_source = new Qworkflow.UserSource();
    public Qworkflow.ApproverState msg_approver_state = new Qworkflow.ApproverState();
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "uint64_uin", "msg_approver_source", "msg_approver_state", "bytes_userdef", "uint64_recv_time" }, new Object[] { Long.valueOf(0L), null, null, localByteStringMicro, Long.valueOf(0L) }, Approver.class);
    }
  }
  
  public static final class ApproverState
    extends MessageMicro<ApproverState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_comment = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_bepushed_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_bepushed_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_state = PBField.initUInt32(0);
    public final PBUInt64Field uint64_approve_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint32_state", "uint32_bepushed_times", "bytes_comment", "uint32_last_bepushed_time", "uint64_approve_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L) }, ApproverState.class);
    }
  }
  
  public static final class BusinessInfo
    extends MessageMicro<BusinessInfo>
  {
    public static final int JIAXIAO_GROUP = 1;
    public static final int TIM_TODO = 2;
    public static final int UNDEFINED = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_busi_type = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_busi_type", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, BusinessInfo.class);
    }
  }
  
  public static final class Button
    extends MessageMicro<Button>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.Operation msg_on_click_operation = new Qworkflow.Operation();
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "uint32_id", "bytes_title", "msg_on_click_operation" }, new Object[] { Integer.valueOf(0), localByteStringMicro, null }, Button.class);
    }
  }
  
  public static final class ContentElement
    extends MessageMicro<ContentElement>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.OrdinaryFile> rpt_file_list = PBField.initRepeatMessage(Qworkflow.OrdinaryFile.class);
    public final PBRepeatMessageField<Qworkflow.Picture> rpt_picture_list = PBField.initRepeatMessage(Qworkflow.Picture.class);
    public final PBRepeatMessageField<Qworkflow.Text> rpt_text_list = PBField.initRepeatMessage(Qworkflow.Text.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rpt_text_list", "rpt_file_list", "rpt_picture_list", "bytes_userdef" }, new Object[] { null, null, null, localByteStringMicro }, ContentElement.class);
    }
  }
  
  public static final class NoticedUser
    extends MessageMicro<NoticedUser>
  {
    public static final int ACCEPTED = 2;
    public static final int UNHANDLED = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_uin", "msg_user_source", "enum_handle_state" }, new Object[] { Long.valueOf(0L), null, Integer.valueOf(1) }, NoticedUser.class);
    public final PBEnumField enum_handle_state = PBField.initEnum(1);
    public Qworkflow.UserSource msg_user_source = new Qworkflow.UserSource();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class Notification
    extends MessageMicro<Notification>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "msg_appid", "msg_workflow_change", "msg_schedule_change", "msg_todoitem_change", "msg_timtodo_notice" }, new Object[] { null, null, null, null, null }, Notification.class);
    public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
    public Qworkflow.ScheduleChangeNotification msg_schedule_change = new Qworkflow.ScheduleChangeNotification();
    public Qworkflow.TimTodoNotification msg_timtodo_notice = new Qworkflow.TimTodoNotification();
    public Qworkflow.TodoChangeNotification msg_todoitem_change = new Qworkflow.TodoChangeNotification();
    public Qworkflow.WorkflowChangeNotification msg_workflow_change = new Qworkflow.WorkflowChangeNotification();
  }
  
  public static final class Observer
    extends MessageMicro<Observer>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_uin", "msg_observer_source" }, new Object[] { Long.valueOf(0L), null }, Observer.class);
    public Qworkflow.UserSource msg_observer_source = new Qworkflow.UserSource();
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class Operation
    extends MessageMicro<Operation>
  {
    public static final int LOCAL = 1;
    public static final int URL_BACKGROUND = 3;
    public static final int URL_IN_NEW_WINDOW = 2;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_command = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_operation_act = PBField.initEnum(1);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16, 26 }, new String[] { "enum_operation_act", "bytes_command" }, new Object[] { Integer.valueOf(1), localByteStringMicro }, Operation.class);
    }
  }
  
  public static final class OrdinaryFile
    extends MessageMicro<OrdinaryFile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_sha = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_file_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_file_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50, 58 }, new String[] { "bytes_file_name", "bytes_file_url", "uint32_file_size", "bytes_file_sha", "bytes_file_md5", "bytes_file_uuid", "bytes_userdef" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6 }, OrdinaryFile.class);
    }
  }
  
  public static final class Picture
    extends MessageMicro<Picture>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_pic_size = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_pic_size", "bytes_pic_url", "bytes_pic_md5", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, Picture.class);
    }
  }
  
  public static final class RemindTimer
    extends MessageMicro<RemindTimer>
  {
    public static final int AFTER_START_TIME = 2;
    public static final int BEFORE_START_TIME = 1;
    public static final int EVERY_DAY = 2;
    public static final int EVERY_FORTNIGHT = 4;
    public static final int EVERY_MONTH = 5;
    public static final int EVERY_WEEK = 3;
    public static final int EVERY_WORKDAY = 6;
    public static final int EVERY_YEAR = 7;
    public static final int NO_REPEATE = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 48, 56, 66 }, new String[] { "uint64_start_time", "uint64_end_time", "enum_remind_offset_type", "uint32_remind_offset", "rpt_msg_observers", "enum_repeat_type", "uint32_remind_flag", "rpt_msg_repeated_effective_timespan" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Integer.valueOf(0), null, Integer.valueOf(1), Integer.valueOf(0), null }, RemindTimer.class);
    public final PBEnumField enum_remind_offset_type = PBField.initEnum(1);
    public final PBEnumField enum_repeat_type = PBField.initEnum(1);
    public final PBRepeatMessageField<Qworkflow.Observer> rpt_msg_observers = PBField.initRepeatMessage(Qworkflow.Observer.class);
    public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
    public final PBUInt32Field uint32_remind_flag = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remind_offset = PBField.initUInt32(0);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  }
  
  public static final class ScheduleChangeNotification
    extends MessageMicro<ScheduleChangeNotification>
  {
    public static final int ACCEPT = 7;
    public static final int CREATE = 5;
    public static final int DELETE = 3;
    public static final int EXPIRED = 1;
    public static final int RECALL = 4;
    public static final int SHARE_RECVD = 2;
    public static final int UPDATE = 6;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_change_type = PBField.initEnum(1);
    public final PBEnumField enum_repeated_type = PBField.initEnum(1);
    public Qworkflow.BusinessInfo msg_busi_info = new Qworkflow.BusinessInfo();
    public Qworkflow.Timespan msg_changed_timespan = new Qworkflow.Timespan();
    public Qworkflow.Text msg_summary = new Qworkflow.Text();
    public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_repeated_effective_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 32, 40, 50, 58, 64, 72, 80, 90, 98, 104, 112, 122 }, new String[] { "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "uint32_remind_bell_switch", "enum_repeated_type", "msg_changed_timespan", "rpt_msg_repeated_effective_timespan", "uint64_start_time", "uint64_end_time", "msg_busi_info" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(1), null, null, Long.valueOf(0L), Long.valueOf(0L), null }, ScheduleChangeNotification.class);
    }
  }
  
  public static final class Text
    extends MessageMicro<Text>
  {
    public static final int CONTENT_SUMMARY = 3;
    public static final int CONTENT_TYPE_LINK = 1;
    public static final int CONTENT_TYPE_NUMBER = 2;
    public static final int CONTENT_TYPE_TEXT = 0;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_type = PBField.initEnum(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_type", "bytes_content", "bytes_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, Text.class);
    }
  }
  
  public static final class TimTodoNotification
    extends MessageMicro<TimTodoNotification>
  {
    public static final int SHARE_TODO = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_notice_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_remind_end = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_remind_start = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48 }, new String[] { "enum_notice_type", "bytes_todo_id", "uint64_author_uin", "bytes_title", "uint64_remind_start", "uint64_remind_end" }, new Object[] { Integer.valueOf(1), localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Long.valueOf(0L), Long.valueOf(0L) }, TimTodoNotification.class);
    }
  }
  
  public static final class Timespan
    extends MessageMicro<Timespan>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_start_time", "uint64_end_time" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L) }, Timespan.class);
    public final PBUInt64Field uint64_end_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_start_time = PBField.initUInt64(0L);
  }
  
  public static final class TodoChangeItem
    extends MessageMicro<TodoChangeItem>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.AppID msg_source_appid = new Qworkflow.AppID();
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40 }, new String[] { "msg_source_appid", "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, TodoChangeItem.class);
    }
  }
  
  public static final class TodoChangeNotification
    extends MessageMicro<TodoChangeNotification>
  {
    public static final int ADD_NEW = 1;
    public static final int CONFIRM_READ = 4;
    public static final int DELETE = 2;
    public static final int DELETE_ALL = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_change_type", "rpt_change_item_list" }, new Object[] { Integer.valueOf(1), null }, TodoChangeNotification.class);
    public final PBEnumField enum_change_type = PBField.initEnum(1);
    public final PBRepeatMessageField<Qworkflow.TodoChangeItem> rpt_change_item_list = PBField.initRepeatMessage(Qworkflow.TodoChangeItem.class);
  }
  
  public static final class TodoInfo
    extends MessageMicro<TodoInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42 }, new String[] { "msg_todo_title", "msg_todo_content", "uint32_template_type", "msg_default_button", "rpt_button_list" }, new Object[] { null, null, Integer.valueOf(0), null, null }, TodoInfo.class);
    public Qworkflow.Button msg_default_button = new Qworkflow.Button();
    public Qworkflow.Text msg_todo_content = new Qworkflow.Text();
    public Qworkflow.Text msg_todo_title = new Qworkflow.Text();
    public final PBRepeatMessageField<Qworkflow.Button> rpt_button_list = PBField.initRepeatMessage(Qworkflow.Button.class);
    public final PBUInt32Field uint32_template_type = PBField.initUInt32(0);
  }
  
  public static final class UserSource
    extends MessageMicro<UserSource>
  {
    public static final int FROM_FRIEND = 3;
    public static final int FROM_GROUP = 1;
    public static final int FROM_GTALK = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "enum_source_type", "uint64_source_code", "uint64_root_id" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L) }, UserSource.class);
    public final PBEnumField enum_source_type = PBField.initEnum(1);
    public final PBUInt64Field uint64_root_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0L);
  }
  
  public static final class Workflow
    extends MessageMicro<Workflow>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.BusinessInfo msg_busi_info = new Qworkflow.BusinessInfo();
    public Qworkflow.WorkflowState msg_current_state = new Qworkflow.WorkflowState();
    public Qworkflow.Text msg_online_push_content = new Qworkflow.Text();
    public Qworkflow.RemindTimer msg_remind_timer = new Qworkflow.RemindTimer();
    public Qworkflow.TodoInfo msg_todo_info = new Qworkflow.TodoInfo();
    public Qworkflow.WorkflowContent msg_workflow_content = new Qworkflow.WorkflowContent();
    public Qworkflow.WorkflowExtendState msg_workflow_extend_state = new Qworkflow.WorkflowExtendState();
    public Qworkflow.AppID related_source_id = new Qworkflow.AppID();
    public final PBRepeatMessageField<Qworkflow.Observer> rpt_msg_observers = PBField.initRepeatMessage(Qworkflow.Observer.class);
    public final PBRepeatMessageField<Qworkflow.WorkflowStateWithApprover> rpt_msg_workflow_state_with_approver = PBField.initRepeatMessage(Qworkflow.WorkflowStateWithApprover.class);
    public final PBRepeatMessageField<Qworkflow.NoticedUser> rpt_noticed_users = PBField.initRepeatMessage(Qworkflow.NoticedUser.class);
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 58, 66, 74, 82, 90, 96, 106, 112, 122, 130, 138, 144, 154, 162 }, new String[] { "bytes_workflow_id", "uint64_author_uin", "uint32_main_type", "uint32_sub_type", "uint64_create_time", "uint64_last_modify_time", "msg_current_state", "msg_workflow_content", "rpt_msg_workflow_state_with_approver", "rpt_msg_observers", "msg_workflow_extend_state", "uint32_data_version", "msg_remind_timer", "uint64_recv_time", "msg_online_push_content", "msg_todo_info", "related_source_id", "uint32_remind_bell_switch", "msg_busi_info", "rpt_noticed_users" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), null, null, null, Integer.valueOf(0), null, null }, Workflow.class);
    }
  }
  
  public static final class WorkflowBrief
    extends MessageMicro<WorkflowBrief>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public Qworkflow.WorkflowExtendState msg_extend_state = new Qworkflow.WorkflowExtendState();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_last_modify_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_recv_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 48, 56 }, new String[] { "bytes_workflow_id", "uint64_author_uin", "uint64_last_modify_time", "uint64_create_time", "msg_extend_state", "uint32_data_version", "uint64_recv_time" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, WorkflowBrief.class);
    }
  }
  
  public static final class WorkflowChangeNotification
    extends MessageMicro<WorkflowChangeNotification>
  {
    public static final int DENY_END = 3;
    public static final int HASTEN_RECVED = 4;
    public static final int NEED_APPROVE = 7;
    public static final int NEED_OBSERVE = 8;
    public static final int PERMIT_END = 2;
    public static final int READED = 6;
    public static final int RECALLED = 1;
    public static final int SHARE_RECVD = 5;
    public static final int UPDATED = 9;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_change_type = PBField.initEnum(1);
    public Qworkflow.WorkflowState msg_current_state = new Qworkflow.WorkflowState();
    public Qworkflow.Text msg_summary = new Qworkflow.Text();
    public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 18, 24, 32, 40, 50, 58, 64, 74, 80 }, new String[] { "bytes_workflow_id", "uint32_main_type", "uint32_sub_type", "uint64_author_uin", "bytes_title", "msg_summary", "enum_change_type", "msg_current_state", "uint32_data_version" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, null, Integer.valueOf(1), null, Integer.valueOf(0) }, WorkflowChangeNotification.class);
    }
  }
  
  public static final class WorkflowContent
    extends MessageMicro<WorkflowContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_title = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<Qworkflow.ContentElement> rpt_content_list = PBField.initRepeatMessage(Qworkflow.ContentElement.class);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_title", "rpt_content_list", "bytes_userdef" }, new Object[] { localByteStringMicro1, null, localByteStringMicro2 }, WorkflowContent.class);
    }
  }
  
  public static final class WorkflowExtendState
    extends MessageMicro<WorkflowExtendState>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_read_state", "uint32_delete_state", "rpt_msg_delete_timespan" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null }, WorkflowExtendState.class);
    public final PBRepeatMessageField<Qworkflow.Timespan> rpt_msg_delete_timespan = PBField.initRepeatMessage(Qworkflow.Timespan.class);
    public final PBUInt32Field uint32_delete_state = PBField.initUInt32(0);
    public final PBUInt32Field uint32_read_state = PBField.initUInt32(0);
  }
  
  public static final class WorkflowState
    extends MessageMicro<WorkflowState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_state_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_state_num = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_state_num", "bytes_state_userdef" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, WorkflowState.class);
    }
  }
  
  public static final class WorkflowStateWithApprover
    extends MessageMicro<WorkflowStateWithApprover>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_workflow_state", "rpt_msg_approver_list" }, new Object[] { null, null }, WorkflowStateWithApprover.class);
    public Qworkflow.WorkflowState msg_workflow_state = new Qworkflow.WorkflowState();
    public final PBRepeatMessageField<Qworkflow.Approver> rpt_msg_approver_list = PBField.initRepeatMessage(Qworkflow.Approver.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow
 * JD-Core Version:    0.7.0.1
 */