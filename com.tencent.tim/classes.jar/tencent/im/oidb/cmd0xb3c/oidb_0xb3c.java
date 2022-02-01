package tencent.im.oidb.cmd0xb3c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb3c
{
  public static final class AIOMsgInfo
    extends MessageMicro<AIOMsgInfo>
  {
    public static final int MSG_TYPE_C2C = 3;
    public static final int MSG_TYPE_CONF = 2;
    public static final int MSG_TYPE_GROUP = 1;
    public static final int MSG_TYPE_TEMP = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50 }, new String[] { "enum_msg_type", "uint64_uin", "uint32_msg_seq", "uint32_msg_time", "uint32_msg_random", "msg_tmp_info" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null }, AIOMsgInfo.class);
    public final PBEnumField enum_msg_type = PBField.initEnum(1);
    public oidb_0xb3c.TempSessionInfo msg_tmp_info = new oidb_0xb3c.TempSessionInfo();
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
  
  public static final class AddTodoReq
    extends MessageMicro<AddTodoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg_source", "msg_content", "uint64_remind_time", "msg_aio_msginfo" }, new Object[] { null, null, Long.valueOf(0L), null }, AddTodoReq.class);
    public oidb_0xb3c.AIOMsgInfo msg_aio_msginfo = new oidb_0xb3c.AIOMsgInfo();
    public oidb_0xb3c.TodoContent msg_content = new oidb_0xb3c.TodoContent();
    public oidb_0xb3c.TodoSource msg_source = new oidb_0xb3c.TodoSource();
    public final PBUInt64Field uint64_remind_time = PBField.initUInt64(0L);
  }
  
  public static final class AddTodoRsp
    extends MessageMicro<AddTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xb3c.TodoSource msg_source = new oidb_0xb3c.TodoSource();
    public oidb_0xb3c.TodoItem msg_todo_item = new oidb_0xb3c.TodoItem();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_source", "bytes_todo_id", "msg_todo_item" }, new Object[] { null, localByteStringMicro, null }, AddTodoRsp.class);
    }
  }
  
  public static final class DeleteTodoReq
    extends MessageMicro<DeleteTodoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_todo_id" }, new Object[] { localByteStringMicro }, DeleteTodoReq.class);
    }
  }
  
  public static final class DeleteTodoRsp
    extends MessageMicro<DeleteTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_todo_id" }, new Object[] { localByteStringMicro }, DeleteTodoRsp.class);
    }
  }
  
  public static final class GetDoneCountReq
    extends MessageMicro<GetDoneCountReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GetDoneCountReq.class);
  }
  
  public static final class GetDoneCountRsp
    extends MessageMicro<GetDoneCountRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uint32_total_count" }, new Object[] { Integer.valueOf(0) }, GetDoneCountRsp.class);
    public final PBUInt32Field uint32_total_count = PBField.initUInt32(0);
  }
  
  public static final class GetDoneTodoReq
    extends MessageMicro<GetDoneTodoReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin_time", "uint32_wanted_count" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, GetDoneTodoReq.class);
    public final PBUInt32Field uint32_wanted_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_begin_time = PBField.initUInt64(0L);
  }
  
  public static final class GetDoneTodoRsp
    extends MessageMicro<GetDoneTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_todo_item", "uint64_next_begin_time" }, new Object[] { null, Long.valueOf(0L) }, GetDoneTodoRsp.class);
    public final PBRepeatMessageField<oidb_0xb3c.TodoItem> rpt_todo_item = PBField.initRepeatMessage(oidb_0xb3c.TodoItem.class);
    public final PBUInt64Field uint64_next_begin_time = PBField.initUInt64(0L);
  }
  
  public static final class GetTodoByIdReq
    extends MessageMicro<GetTodoByIdReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_todo_id" }, new Object[] { localByteStringMicro }, GetTodoByIdReq.class);
    }
  }
  
  public static final class GetTodoByIdRsp
    extends MessageMicro<GetTodoByIdRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_todo_item" }, new Object[] { null }, GetTodoByIdRsp.class);
    public oidb_0xb3c.TodoItem msg_todo_item = new oidb_0xb3c.TodoItem();
  }
  
  public static final class GetTodoResult
    extends MessageMicro<GetTodoResult>
  {
    public static final int STATE_DELETE = 3;
    public static final int STATE_DONE = 4;
    public static final int STATE_NEW = 1;
    public static final int STATE_UPDATE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "enum_ret_state", "msg_todo_item" }, new Object[] { Integer.valueOf(1), null }, GetTodoResult.class);
    public final PBEnumField enum_ret_state = PBField.initEnum(1);
    public oidb_0xb3c.TodoItem msg_todo_item = new oidb_0xb3c.TodoItem();
  }
  
  public static final class GetUndoneTodoReq
    extends MessageMicro<GetUndoneTodoReq>
  {
    public static final int GET_AVAILIABLE = 2;
    public static final int GET_INCREMENT = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_read_time", "uint32_wanted_count", "enum_get_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(1) }, GetUndoneTodoReq.class);
    public final PBEnumField enum_get_type = PBField.initEnum(1);
    public final PBUInt32Field uint32_wanted_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_time = PBField.initUInt64(0L);
  }
  
  public static final class GetUndoneTodoRsp
    extends MessageMicro<GetUndoneTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_todo_ret", "uint64_next_read_time", "uint32_finish_flag" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0) }, GetUndoneTodoRsp.class);
    public final PBRepeatMessageField<oidb_0xb3c.GetTodoResult> rpt_todo_ret = PBField.initRepeatMessage(oidb_0xb3c.GetTodoResult.class);
    public final PBUInt32Field uint32_finish_flag = PBField.initUInt32(0);
    public final PBUInt64Field uint64_next_read_time = PBField.initUInt64(0L);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "msg_add_todo_req", "msg_get_undone_todo_req", "msg_get_done_todo_req", "msg_get_todo_byid_req", "msg_update_todo_req", "msg_delete_todo_req", "msg_share_todo_req", "msg_get_done_count_req" }, new Object[] { null, null, null, null, null, null, null, null }, ReqBody.class);
    public oidb_0xb3c.AddTodoReq msg_add_todo_req = new oidb_0xb3c.AddTodoReq();
    public oidb_0xb3c.DeleteTodoReq msg_delete_todo_req = new oidb_0xb3c.DeleteTodoReq();
    public oidb_0xb3c.GetDoneCountReq msg_get_done_count_req = new oidb_0xb3c.GetDoneCountReq();
    public oidb_0xb3c.GetDoneTodoReq msg_get_done_todo_req = new oidb_0xb3c.GetDoneTodoReq();
    public oidb_0xb3c.GetTodoByIdReq msg_get_todo_byid_req = new oidb_0xb3c.GetTodoByIdReq();
    public oidb_0xb3c.GetUndoneTodoReq msg_get_undone_todo_req = new oidb_0xb3c.GetUndoneTodoReq();
    public oidb_0xb3c.ShareTodoReq msg_share_todo_req = new oidb_0xb3c.ShareTodoReq();
    public oidb_0xb3c.UpdateTodoReq msg_update_todo_req = new oidb_0xb3c.UpdateTodoReq();
  }
  
  public static final class ResultMsg
    extends MessageMicro<ResultMsg>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, ResultMsg.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74 }, new String[] { "msg_result", "msg_add_todo_rsp", "msg_get_undone_todo_rsp", "msg_get_done_todo_rsp", "msg_get_todo_byid_rsp", "msg_update_todo_rsp", "msg_delete_todo_rsp", "msg_share_todo_rsp", "msg_get_done_count_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null }, RspBody.class);
    public oidb_0xb3c.AddTodoRsp msg_add_todo_rsp = new oidb_0xb3c.AddTodoRsp();
    public oidb_0xb3c.DeleteTodoRsp msg_delete_todo_rsp = new oidb_0xb3c.DeleteTodoRsp();
    public oidb_0xb3c.GetDoneCountRsp msg_get_done_count_rsp = new oidb_0xb3c.GetDoneCountRsp();
    public oidb_0xb3c.GetDoneTodoRsp msg_get_done_todo_rsp = new oidb_0xb3c.GetDoneTodoRsp();
    public oidb_0xb3c.GetTodoByIdRsp msg_get_todo_byid_rsp = new oidb_0xb3c.GetTodoByIdRsp();
    public oidb_0xb3c.GetUndoneTodoRsp msg_get_undone_todo_rsp = new oidb_0xb3c.GetUndoneTodoRsp();
    public oidb_0xb3c.ResultMsg msg_result = new oidb_0xb3c.ResultMsg();
    public oidb_0xb3c.ShareTodoRsp msg_share_todo_rsp = new oidb_0xb3c.ShareTodoRsp();
    public oidb_0xb3c.UpdateTodoRsp msg_update_todo_rsp = new oidb_0xb3c.UpdateTodoRsp();
  }
  
  public static final class ShareTodoReq
    extends MessageMicro<ShareTodoReq>
  {
    public static final int SHARE_TYPE_CONF = 2;
    public static final int SHARE_TYPE_FRIEND = 3;
    public static final int SHARE_TYPE_GROUP = 1;
    public static final int SHARE_TYPE_TEMP = 4;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_share_type = PBField.initEnum(1);
    public oidb_0xb3c.TempSessionInfo msg_temp_info = new oidb_0xb3c.TempSessionInfo();
    public final PBUInt64Field uint64_conf_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_temp_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 58 }, new String[] { "enum_share_type", "bytes_todo_id", "uint64_group_code", "uint64_conf_code", "uint64_friend_uin", "uint64_temp_uin", "msg_temp_info" }, new Object[] { Integer.valueOf(1), localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, ShareTodoReq.class);
    }
  }
  
  public static final class ShareTodoRsp
    extends MessageMicro<ShareTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], ShareTodoRsp.class);
  }
  
  public static final class TempSessionInfo
    extends MessageMicro<TempSessionInfo>
  {
    public static final int C2C_TEMP_ADDR_LIST = 3;
    public static final int C2C_TEMP_CONF = 2;
    public static final int C2C_TEMP_GROUP = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "enum_session_type", "uint64_group_code", "uint64_conf_code", "msg_addrlist" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), null }, TempSessionInfo.class);
    public final PBEnumField enum_session_type = PBField.initEnum(1);
    public AddrListTmpInfo msg_addrlist = new AddrListTmpInfo();
    public final PBUInt64Field uint64_conf_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    
    public static final class AddrListTmpInfo
      extends MessageMicro<AddrListTmpInfo>
    {
      static final MessageMicro.FieldMap __fieldMap__;
      public final PBBytesField bytes_from_phone = PBField.initBytes(ByteStringMicro.EMPTY);
      public final PBBytesField bytes_to_phone = PBField.initBytes(ByteStringMicro.EMPTY);
      
      static
      {
        ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
        ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_from_phone", "bytes_to_phone" }, new Object[] { localByteStringMicro1, localByteStringMicro2 }, AddrListTmpInfo.class);
      }
    }
  }
  
  public static final class TodoContent
    extends MessageMicro<TodoContent>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_content = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_content" }, new Object[] { localByteStringMicro }, TodoContent.class);
    }
  }
  
  public static final class TodoItem
    extends MessageMicro<TodoItem>
  {
    public static final int STATE_DONE = 2;
    public static final int STATE_UNDONE = 1;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_state = PBField.initEnum(1);
    public oidb_0xb3c.AIOMsgInfo msg_aio_msginfo = new oidb_0xb3c.AIOMsgInfo();
    public oidb_0xb3c.TodoContent msg_content = new oidb_0xb3c.TodoContent();
    public oidb_0xb3c.TodoSource msg_source = new oidb_0xb3c.TodoSource();
    public oidb_0xb3c.TodoRemind msg_todo_remind = new oidb_0xb3c.TodoRemind();
    public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_create_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_finish_time = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 74, 82 }, new String[] { "msg_source", "bytes_todo_id", "uint64_author_uin", "msg_content", "uint64_create_time", "uint64_update_time", "uint64_finish_time", "enum_state", "msg_todo_remind", "msg_aio_msginfo" }, new Object[] { null, localByteStringMicro, Long.valueOf(0L), null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), null, null }, TodoItem.class);
    }
  }
  
  public static final class TodoRemind
    extends MessageMicro<TodoRemind>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_remind_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_remind_time", "bytes_schedule_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, TodoRemind.class);
    }
  }
  
  public static final class TodoSource
    extends MessageMicro<TodoSource>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "uin32_src_appid" }, new Object[] { Integer.valueOf(0) }, TodoSource.class);
    public final PBUInt32Field uin32_src_appid = PBField.initUInt32(0);
  }
  
  public static final class UpdateTodoReq
    extends MessageMicro<UpdateTodoReq>
  {
    public static final int UPDATE_COMM = 1;
    public static final int UPDATE_DEL_REMIND = 4;
    public static final int UPDATE_TO_DONE = 2;
    public static final int UPDATE_TO_UNDONE = 3;
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField enum_update_type = PBField.initEnum(1);
    public oidb_0xb3c.TodoContent msg_content = new oidb_0xb3c.TodoContent();
    public final PBUInt64Field uint64_remind_time = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "bytes_todo_id", "enum_update_type", "msg_content", "uint64_remind_time" }, new Object[] { localByteStringMicro, Integer.valueOf(1), null, Long.valueOf(0L) }, UpdateTodoReq.class);
    }
  }
  
  public static final class UpdateTodoRsp
    extends MessageMicro<UpdateTodoRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_todo_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public oidb_0xb3c.TodoItem msg_todo_item = new oidb_0xb3c.TodoItem();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_todo_id", "msg_todo_item" }, new Object[] { localByteStringMicro, null }, UpdateTodoRsp.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb3c.oidb_0xb3c
 * JD-Core Version:    0.7.0.1
 */