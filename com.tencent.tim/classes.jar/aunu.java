import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.todo.data.TodoInfo;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.AIOMsgInfo;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.AddTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.AddTodoRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.DeleteTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.DeleteTodoRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetDoneCountReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetDoneCountRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetDoneTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetDoneTodoRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetTodoByIdReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetTodoByIdRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetTodoResult;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetUndoneTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.GetUndoneTodoRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.ReqBody;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.ResultMsg;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.RspBody;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.ShareTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.ShareTodoRsp;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TempSessionInfo;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TempSessionInfo.AddrListTmpInfo;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TodoContent;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TodoItem;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TodoRemind;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.TodoSource;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.UpdateTodoReq;
import tencent.im.oidb.cmd0xb3c.oidb_0xb3c.UpdateTodoRsp;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x9c.SubMsgType0x9c.MsgBody;
import tencent.im.todo.notice.todo_notice.TodoNotice;

public class aunu
  extends accg
{
  private List<Pair<Integer, TodoInfo>> Lb = new ArrayList();
  private List<Pair<Integer, TodoInfo>> Lc = new ArrayList();
  
  public aunu(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void bj(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "getUndoneTodo, lastReadTime = " + paramLong + ", getType = " + paramInt);
    }
    Object localObject2 = new oidb_0xb3c.GetUndoneTodoReq();
    ((oidb_0xb3c.GetUndoneTodoReq)localObject2).uint64_read_time.set(paramLong);
    ((oidb_0xb3c.GetUndoneTodoReq)localObject2).uint32_wanted_count.set(20);
    ((oidb_0xb3c.GetUndoneTodoReq)localObject2).enum_get_type.set(paramInt);
    Object localObject1 = new oidb_0xb3c.ReqBody();
    ((oidb_0xb3c.ReqBody)localObject1).msg_get_undone_todo_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xb3c.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xb3c_get_undone");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    ((ToServiceMsg)localObject1).extraData.putInt("get_undone_todo_type", paramInt);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  private void es(int paramInt, String paramString)
  {
    TodoInfo localTodoInfo = new TodoInfo();
    localTodoInfo.todoId = paramString;
    paramString = (auoi)this.app.getManager(376);
    if (paramInt == 1)
    {
      localArrayList = new ArrayList();
      localArrayList.add(new Pair(Integer.valueOf(3), localTodoInfo));
      paramString.of(localArrayList);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new Pair(Integer.valueOf(2), localTodoInfo));
    paramString.oe(localArrayList);
    paramString.aaT(paramString.OL() - 1);
  }
  
  private void mn(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          return;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleAddTodo ret = " + i);
        }
        if ((i != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        oidb_0xb3c.AddTodoRsp localAddTodoRsp;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("TodoHandler", 2, "handleAddTodo ", paramToServiceMsg);
        return;
        notifyUI(1, false, null);
        return;
        paramFromServiceMsg = null;
        continue;
        int i = 0;
        continue;
        paramObject = "";
        continue;
        continue;
      }
      try
      {
        paramObject = (oidb_0xb3c.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleAddTodo|parseFrom byte InvalidProtocolBufferMicroException");
        paramObject.printStackTrace();
      }
    }
    if (paramFromServiceMsg != null)
    {
      if ((paramFromServiceMsg.msg_result.has()) && (paramFromServiceMsg.msg_result.get() != null))
      {
        paramObject = (oidb_0xb3c.ResultMsg)paramFromServiceMsg.msg_result.get();
        i = paramObject.uint32_result.get();
        if ((!paramObject.bytes_err_msg.has()) || (paramObject.bytes_err_msg.get() == null)) {
          break label592;
        }
        paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleAddTodo|result = " + i + ", errMsg = " + paramObject);
        }
      }
      if ((paramFromServiceMsg.msg_add_todo_rsp.has()) && (paramFromServiceMsg.msg_add_todo_rsp.get() != null))
      {
        localAddTodoRsp = (oidb_0xb3c.AddTodoRsp)paramFromServiceMsg.msg_add_todo_rsp.get();
        if ((localAddTodoRsp.msg_source.has()) && (localAddTodoRsp.msg_source.get() != null) && (localAddTodoRsp.msg_source.uin32_src_appid.has()))
        {
          i = localAddTodoRsp.msg_source.uin32_src_appid.get();
          if ((localAddTodoRsp.bytes_todo_id.has()) && (localAddTodoRsp.bytes_todo_id.get() != null))
          {
            paramFromServiceMsg = localAddTodoRsp.bytes_todo_id.get().toStringUtf8();
            paramObject = localObject;
            if (localAddTodoRsp.msg_todo_item.has())
            {
              paramObject = a((oidb_0xb3c.TodoItem)localAddTodoRsp.msg_todo_item.get());
              if (i != 1) {
                break label599;
              }
              paramObject.istroop = paramToServiceMsg.extraData.getInt("add_todo_from_todo_message_uintype");
              paramObject.uniseq = paramToServiceMsg.extraData.getLong("add_todo_from_todo_message_uniseq");
              break label599;
            }
            paramToServiceMsg = new ArrayList();
            paramToServiceMsg.add(new Pair(Integer.valueOf(1), paramObject));
            ((auoi)this.app.getManager(376)).of(paramToServiceMsg);
            notifyUI(1, true, new Object[] { Integer.valueOf(i), paramFromServiceMsg, paramObject });
            return;
            if (i == 133)
            {
              notifyUI(1, false, new Object[] { Integer.valueOf(i) });
              return;
            }
          }
        }
      }
    }
    label592:
    label599:
    return;
  }
  
  private void mo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        k = paramToServiceMsg.extraData.getInt("get_undone_todo_type");
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          return;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetUndoneTodo ret = " + i);
        }
        if (i == 131)
        {
          paramToServiceMsg = (auoi)this.app.getManager(376);
          paramToServiceMsg.nu(0L);
          paramToServiceMsg.evO();
          bj(0L, k);
          return;
        }
        if ((i != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        int k;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("TodoHandler", 2, "handleGetUndoneTodo ", paramToServiceMsg);
        return;
        this.Lb.clear();
        notifyUI(2, false, null);
        return;
        paramToServiceMsg = null;
        continue;
        continue;
        long l = 0L;
        continue;
        int i = -1;
        continue;
        paramFromServiceMsg = "";
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0xb3c.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleGetUndoneTodo|parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
        continue;
        if (i != 1) {
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleGetUndoneTodo|size = " + this.Lb.size());
        paramToServiceMsg = (auoi)this.app.getManager(376);
        paramToServiceMsg.nu(l);
        paramToServiceMsg.of(this.Lb);
        notifyUI(2, true, null);
        return;
        bj(l, k);
        return;
      }
    }
    if (paramToServiceMsg != null)
    {
      if ((paramToServiceMsg.msg_result.has()) && (paramToServiceMsg.msg_result.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.ResultMsg)paramToServiceMsg.msg_result.get();
        i = paramFromServiceMsg.uint32_result.get();
        if ((!paramFromServiceMsg.bytes_err_msg.has()) || (paramFromServiceMsg.bytes_err_msg.get() == null)) {
          break label731;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetUndoneTodo|result = " + i + ", errMsg = " + paramFromServiceMsg);
        }
      }
      if ((paramToServiceMsg.msg_get_undone_todo_rsp.has()) && (paramToServiceMsg.msg_get_undone_todo_rsp.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.GetUndoneTodoRsp)paramToServiceMsg.msg_get_undone_todo_rsp.get();
        if (paramFromServiceMsg.uint32_finish_flag.has())
        {
          i = paramFromServiceMsg.uint32_finish_flag.get();
          if (paramFromServiceMsg.uint64_next_read_time.has())
          {
            l = paramFromServiceMsg.uint64_next_read_time.get();
            paramToServiceMsg = new ArrayList();
            if (paramFromServiceMsg.rpt_todo_ret.has())
            {
              paramToServiceMsg = paramFromServiceMsg.rpt_todo_ret.get();
              if (paramToServiceMsg != null)
              {
                paramFromServiceMsg = paramToServiceMsg.iterator();
                while (paramFromServiceMsg.hasNext())
                {
                  paramToServiceMsg = (oidb_0xb3c.GetTodoResult)paramFromServiceMsg.next();
                  if (paramToServiceMsg != null)
                  {
                    int j = -1;
                    if (paramToServiceMsg.enum_ret_state.has()) {
                      j = paramToServiceMsg.enum_ret_state.get();
                    }
                    if (!paramToServiceMsg.msg_todo_item.has()) {
                      break label711;
                    }
                    paramToServiceMsg = a((oidb_0xb3c.TodoItem)paramToServiceMsg.msg_todo_item.get());
                    if ((j != -1) && (paramToServiceMsg != null))
                    {
                      paramObject = new Pair(Integer.valueOf(j), paramToServiceMsg);
                      this.Lb.add(paramObject);
                      if (QLog.isColorLevel()) {
                        QLog.d("TodoHandler", 2, "handleGetUndoneTodo|info, id:" + paramToServiceMsg.todoId + ", content:" + paramToServiceMsg.content);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label711:
    label731:
    return;
  }
  
  private void mp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Pair localPair = null;
    int i;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetDoneTodo ret = " + i);
        }
        if ((i != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          break label621;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xb3c.RspBody();
      }
    }
    catch (Exception paramToServiceMsg)
    {
      label135:
      if (QLog.isColorLevel()) {
        QLog.d("TodoHandler", 2, "handleGetDoneTodo ", paramToServiceMsg);
      }
    }
    try
    {
      paramFromServiceMsg = (oidb_0xb3c.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      if (!QLog.isColorLevel()) {
        break label502;
      }
      QLog.d("TodoHandler", 2, "handleGetDoneTodo|parseFrom byte InvalidProtocolBufferMicroException");
      paramFromServiceMsg.printStackTrace();
      break label135;
    }
    if (paramToServiceMsg != null) {
      if ((paramToServiceMsg.msg_result.has()) && (paramToServiceMsg.msg_result.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.ResultMsg)paramToServiceMsg.msg_result.get();
        i = paramFromServiceMsg.uint32_result.get();
        if ((!paramFromServiceMsg.bytes_err_msg.has()) || (paramFromServiceMsg.bytes_err_msg.get() == null)) {
          break label632;
        }
      }
    }
    label502:
    label632:
    for (paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();; paramFromServiceMsg = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("TodoHandler", 2, "handleGetDoneTodo|result = " + i + ", errMsg = " + paramFromServiceMsg);
      }
      long l;
      if ((paramToServiceMsg.msg_get_done_todo_rsp.has()) && (paramToServiceMsg.msg_get_done_todo_rsp.get() != null))
      {
        paramToServiceMsg = (oidb_0xb3c.GetDoneTodoRsp)paramToServiceMsg.msg_get_done_todo_rsp.get();
        l = 0L;
        if (paramToServiceMsg.uint64_next_begin_time.has()) {
          l = paramToServiceMsg.uint64_next_begin_time.get();
        }
        paramFromServiceMsg = new ArrayList();
        if (!paramToServiceMsg.rpt_todo_item.has()) {
          break label629;
        }
        paramFromServiceMsg = paramToServiceMsg.rpt_todo_item.get();
      }
      for (;;)
      {
        paramToServiceMsg = localPair;
        if (paramFromServiceMsg != null)
        {
          paramObject = new ArrayList();
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          for (;;)
          {
            paramToServiceMsg = paramObject;
            if (!paramFromServiceMsg.hasNext()) {
              break;
            }
            paramToServiceMsg = a((oidb_0xb3c.TodoItem)paramFromServiceMsg.next());
            if (paramToServiceMsg != null)
            {
              paramObject.add(paramToServiceMsg);
              localPair = new Pair(Integer.valueOf(1), paramToServiceMsg);
              this.Lc.add(localPair);
              if (QLog.isColorLevel()) {
                QLog.d("TodoHandler", 2, "handleGetDoneTodo|info, id:" + paramToServiceMsg.todoId + ", content:" + paramToServiceMsg.content);
              }
            }
          }
          return;
        }
        if (QLog.isColorLevel()) {
          if ("handleGetDoneTodo|size = " + paramToServiceMsg != null) {
            break label610;
          }
        }
        for (i = 0;; i = paramToServiceMsg.size())
        {
          QLog.d("TodoHandler", 2, new Object[] { Integer.valueOf(i) });
          paramFromServiceMsg = (auoi)this.app.getManager(376);
          paramFromServiceMsg.nv(l);
          paramFromServiceMsg.oe(this.Lc);
          notifyUI(3, true, new Object[] { Long.valueOf(l), paramToServiceMsg });
          return;
        }
        notifyUI(3, false, null);
        return;
      }
    }
  }
  
  private void mq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has())) {
          return;
        }
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetTodoById ret = " + i);
        }
        if ((i != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("TodoHandler", 2, "handleGetTodoById ", paramToServiceMsg);
        return;
        notifyUI(4, false, null);
        return;
        paramFromServiceMsg = null;
        continue;
        paramObject = "";
        continue;
      }
      try
      {
        paramObject = (oidb_0xb3c.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleGetTodoById|parseFrom byte InvalidProtocolBufferMicroException");
        paramObject.printStackTrace();
        continue;
        notifyUI(4, true, paramFromServiceMsg);
        return;
      }
    }
    if (paramFromServiceMsg != null)
    {
      if ((paramFromServiceMsg.msg_result.has()) && (paramFromServiceMsg.msg_result.get() != null))
      {
        paramObject = (oidb_0xb3c.ResultMsg)paramFromServiceMsg.msg_result.get();
        i = paramObject.uint32_result.get();
        if ((!paramObject.bytes_err_msg.has()) || (paramObject.bytes_err_msg.get() == null)) {
          break label420;
        }
        paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetTodoById|result = " + i + ", errMsg = " + paramObject);
        }
      }
      if ((paramFromServiceMsg.msg_get_todo_byid_rsp.has()) && (paramFromServiceMsg.msg_get_todo_byid_rsp.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.GetTodoByIdRsp)paramFromServiceMsg.msg_get_todo_byid_rsp.get();
        if (paramFromServiceMsg.msg_todo_item.has())
        {
          paramFromServiceMsg = a((oidb_0xb3c.TodoItem)paramFromServiceMsg.msg_todo_item.get());
          paramObject = paramToServiceMsg.extraData.getString("get_todo_by_id_type", null);
          if (paramObject != null)
          {
            i = paramToServiceMsg.extraData.getInt("operation_type", 0);
            if ((!paramObject.equals("s2c.msgtype0x210.submsgtype0x9c")) || (i == 0)) {
              return;
            }
            a(paramFromServiceMsg, i);
            return;
          }
        }
      }
    }
    label420:
  }
  
  private void mr(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 3;
    int i = 1;
    if (paramFromServiceMsg.getResultCode() != 1000) {
      notifyUI(5, false, null);
    }
    int k;
    int m;
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label654;
        }
        k = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleUpdateTodo ret = " + k);
        }
        if ((k != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramObject = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        auoi localauoi;
        ArrayList localArrayList;
        if (!QLog.isColorLevel()) {
          break label654;
        }
        QLog.d("TodoHandler", 2, "handleUpdateTodo ", paramToServiceMsg);
        return;
        i = -1;
        j = -1;
        k = -1;
        continue;
        m = 1;
        continue;
        paramObject = null;
        continue;
        paramFromServiceMsg = null;
        continue;
        paramObject = "";
        continue;
      }
      try
      {
        paramObject = (oidb_0xb3c.RspBody)paramFromServiceMsg.mergeFrom(paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleUpdateTodo|parseFrom byte InvalidProtocolBufferMicroException");
        paramObject.printStackTrace();
      }
    }
    if (paramFromServiceMsg != null)
    {
      if ((paramFromServiceMsg.msg_result.has()) && (paramFromServiceMsg.msg_result.get() != null))
      {
        paramObject = (oidb_0xb3c.ResultMsg)paramFromServiceMsg.msg_result.get();
        k = paramObject.uint32_result.get();
        if ((!paramObject.bytes_err_msg.has()) || (paramObject.bytes_err_msg.get() == null)) {
          break label647;
        }
        paramObject = paramObject.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleUpdateTodo|result = " + k + ", errMsg = " + paramObject);
        }
      }
      if ((paramFromServiceMsg.msg_update_todo_rsp.has()) && (paramFromServiceMsg.msg_update_todo_rsp.get() != null))
      {
        paramObject = (oidb_0xb3c.UpdateTodoRsp)paramFromServiceMsg.msg_update_todo_rsp.get();
        if ((paramObject.bytes_todo_id.has()) && (paramObject.bytes_todo_id.get() != null))
        {
          paramFromServiceMsg = paramObject.bytes_todo_id.get().toStringUtf8();
          if (paramObject.msg_todo_item.has())
          {
            paramObject = a((oidb_0xb3c.TodoItem)paramObject.msg_todo_item.get());
            localauoi = (auoi)this.app.getManager(376);
            if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null))
            {
              m = paramToServiceMsg.extraData.getInt("updateType", 1);
              paramToServiceMsg = new ArrayList();
              localArrayList = new ArrayList();
              if (m == 2)
              {
                localauoi.aaT(localauoi.OL() + 1);
                k = 3;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if ((k != -1) && (paramObject != null))
      {
        paramToServiceMsg.add(new Pair(Integer.valueOf(k), paramObject));
        localauoi.of(paramToServiceMsg);
      }
      if ((i != -1) && (paramObject != null))
      {
        localArrayList.add(new Pair(Integer.valueOf(i), paramObject));
        localauoi.oe(localArrayList);
      }
      notifyUI(5, true, new Object[] { paramFromServiceMsg, Integer.valueOf(m), paramObject });
      if (j != -1)
      {
        return;
        if (m != 3) {
          break label655;
        }
        localauoi.aaT(localauoi.OL() - 1);
        i = 2;
        j = 5;
        k = 2;
        continue;
        notifyUI(5, false, null);
      }
      label647:
      label654:
      label655:
      while (m != 1) {
        return;
      }
      j = 6;
      k = 2;
      i = -1;
    }
  }
  
  private void ms(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool3 = false;
    bool2 = false;
    if (paramFromServiceMsg.getResultCode() != 1000) {
      notifyUI(6, false, null);
    }
    for (;;)
    {
      try
      {
        i = ((Integer)paramToServiceMsg.getAttributes().get("delete_todo_status")).intValue();
        str = (String)paramToServiceMsg.getAttributes().get("delete_todo_id");
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool1 = bool2;
        if (paramToServiceMsg.uint32_result.has())
        {
          j = paramToServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.d("TodoHandler", 2, "handleDeleteTodo ret = " + j);
          }
          if ((j != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
            continue;
          }
          paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          paramToServiceMsg = new oidb_0xb3c.RspBody();
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        String str;
        int j;
        bool2 = bool3;
        boolean bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleDeleteTodo ", paramToServiceMsg);
        bool1 = bool2;
        continue;
        bool1 = false;
        continue;
        paramFromServiceMsg = "";
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0xb3c.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          notifyUI(6, true, paramToServiceMsg);
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("TodoHandler", 2, "handleDeleteTodo isSuccess：" + bool1);
          }
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          bool2 = true;
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleDeleteTodo|parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
      }
    }
    if (paramToServiceMsg != null)
    {
      if ((paramToServiceMsg.msg_result.has()) && (paramToServiceMsg.msg_result.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.ResultMsg)paramToServiceMsg.msg_result.get();
        j = paramFromServiceMsg.uint32_result.get();
        if ((!paramFromServiceMsg.bytes_err_msg.has()) || (paramFromServiceMsg.bytes_err_msg.get() == null)) {
          break label542;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleDeleteTodo|result = " + j + ", errMsg = " + paramFromServiceMsg);
        }
      }
      if ((paramToServiceMsg.msg_delete_todo_rsp.has()) && (paramToServiceMsg.msg_delete_todo_rsp.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.DeleteTodoRsp)paramToServiceMsg.msg_delete_todo_rsp.get();
        paramToServiceMsg = str;
        if (paramFromServiceMsg.bytes_todo_id.has())
        {
          paramToServiceMsg = str;
          if (paramFromServiceMsg.bytes_todo_id.get() != null) {
            paramToServiceMsg = paramFromServiceMsg.bytes_todo_id.get().toStringUtf8();
          }
        }
        es(i, paramToServiceMsg);
        for (;;)
        {
          if (j == 130)
          {
            es(i, str);
            notifyUI(6, true, str);
            bool1 = true;
          }
          else
          {
            notifyUI(6, false, str);
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  public TodoInfo a(oidb_0xb3c.TodoItem paramTodoItem)
  {
    if ((paramTodoItem == null) || (!paramTodoItem.bytes_todo_id.has()) || (paramTodoItem.bytes_todo_id.get() == null) || (TextUtils.isEmpty(paramTodoItem.bytes_todo_id.get().toStringUtf8())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TodoHandler", 2, "readTodoInfoFromPb, item null or id null");
      }
      return null;
    }
    TodoInfo localTodoInfo = new TodoInfo();
    localTodoInfo.todoId = paramTodoItem.bytes_todo_id.get().toStringUtf8();
    if ((paramTodoItem.msg_source.has()) && (paramTodoItem.msg_source.get() != null)) {
      localTodoInfo.appid = ((oidb_0xb3c.TodoSource)paramTodoItem.msg_source.get()).uin32_src_appid.get();
    }
    if (paramTodoItem.uint64_author_uin.has()) {
      localTodoInfo.creatorUin = paramTodoItem.uint64_author_uin.get();
    }
    Object localObject;
    if ((paramTodoItem.msg_content.has()) && (paramTodoItem.msg_content.get() != null))
    {
      localObject = (oidb_0xb3c.TodoContent)paramTodoItem.msg_content.get();
      if ((((oidb_0xb3c.TodoContent)localObject).bytes_content.has()) && (((oidb_0xb3c.TodoContent)localObject).bytes_content.get() != null)) {
        localTodoInfo.content = ((oidb_0xb3c.TodoContent)localObject).bytes_content.get().toStringUtf8();
      }
    }
    if ((paramTodoItem.msg_todo_remind.has()) && (paramTodoItem.msg_todo_remind.get() != null))
    {
      localObject = (oidb_0xb3c.TodoRemind)paramTodoItem.msg_todo_remind.get();
      if (((oidb_0xb3c.TodoRemind)localObject).uint64_remind_time.has()) {
        localTodoInfo.remindTime = ((oidb_0xb3c.TodoRemind)localObject).uint64_remind_time.get();
      }
      if ((((oidb_0xb3c.TodoRemind)localObject).bytes_schedule_id.has()) && (((oidb_0xb3c.TodoRemind)localObject).bytes_schedule_id.get() != null)) {
        localTodoInfo.scheduleId = ((oidb_0xb3c.TodoRemind)localObject).bytes_schedule_id.get().toStringUtf8();
      }
    }
    if (paramTodoItem.uint64_create_time.has()) {
      localTodoInfo.createTime = paramTodoItem.uint64_create_time.get();
    }
    if (paramTodoItem.uint64_update_time.has()) {
      localTodoInfo.updateTime = paramTodoItem.uint64_update_time.get();
    }
    if (paramTodoItem.uint64_finish_time.has()) {
      localTodoInfo.finishTime = paramTodoItem.uint64_finish_time.get();
    }
    if (paramTodoItem.enum_state.has()) {
      localTodoInfo.status = paramTodoItem.enum_state.get();
    }
    if ((paramTodoItem.msg_aio_msginfo.has()) && (paramTodoItem.msg_aio_msginfo.get() != null))
    {
      paramTodoItem = (oidb_0xb3c.AIOMsgInfo)paramTodoItem.msg_aio_msginfo.get();
      if (paramTodoItem.uint64_uin.has()) {
        localTodoInfo.fromUin = paramTodoItem.uint64_uin.get();
      }
      if (paramTodoItem.enum_msg_type.has()) {
        localTodoInfo.fromUinType = paramTodoItem.enum_msg_type.get();
      }
      if (paramTodoItem.uint32_msg_seq.has()) {
        localTodoInfo.msgSeq = paramTodoItem.uint32_msg_seq.get();
      }
      if (paramTodoItem.uint32_msg_time.has()) {
        localTodoInfo.msgTime = paramTodoItem.uint32_msg_time.get();
      }
      if (paramTodoItem.uint32_msg_random.has()) {
        localTodoInfo.msgRandom = paramTodoItem.uint32_msg_random.get();
      }
      if ((paramTodoItem.msg_tmp_info.has()) && (paramTodoItem.msg_tmp_info.get() != null))
      {
        paramTodoItem = (oidb_0xb3c.TempSessionInfo)paramTodoItem.msg_tmp_info.get();
        if ((paramTodoItem.has()) && (paramTodoItem.get() != null))
        {
          localTodoInfo.c2cTempUinType = paramTodoItem.enum_session_type.get();
          if (localTodoInfo.c2cTempUinType != 1) {
            break label588;
          }
          localTodoInfo.c2cTempUin = paramTodoItem.uint64_group_code.get();
        }
      }
    }
    for (;;)
    {
      return localTodoInfo;
      label588:
      if (localTodoInfo.c2cTempUinType == 2) {
        localTodoInfo.c2cTempUin = paramTodoItem.uint64_conf_code.get();
      } else if (localTodoInfo.c2cTempUinType == 3) {
        localTodoInfo.numStr = paramTodoItem.msg_addrlist.bytes_to_phone.get().toStringUtf8();
      }
    }
  }
  
  public void a(int paramInt, TodoInfo paramTodoInfo)
  {
    if (paramTodoInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TodoHandler", 2, "addTodo, TodoInfo is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "addTodo, msgSeq = " + paramTodoInfo.msgSeq + ", msgRandom = " + paramTodoInfo.msgRandom);
    }
    Object localObject1 = new oidb_0xb3c.TodoSource();
    ((oidb_0xb3c.TodoSource)localObject1).uin32_src_appid.set(paramInt);
    Object localObject2 = new oidb_0xb3c.TodoContent();
    if (!TextUtils.isEmpty(paramTodoInfo.content)) {
      ((oidb_0xb3c.TodoContent)localObject2).bytes_content.set(ByteStringMicro.copyFromUtf8(paramTodoInfo.content));
    }
    Object localObject3 = new oidb_0xb3c.TempSessionInfo();
    ((oidb_0xb3c.TempSessionInfo)localObject3).enum_session_type.set(paramTodoInfo.c2cTempUinType);
    if ((paramTodoInfo.c2cTempUinType == 1) || (paramTodoInfo.c2cTempUinType == 2)) {
      ((oidb_0xb3c.TempSessionInfo)localObject3).uint64_group_code.set(paramTodoInfo.c2cTempUin);
    }
    oidb_0xb3c.AIOMsgInfo localAIOMsgInfo = new oidb_0xb3c.AIOMsgInfo();
    localAIOMsgInfo.enum_msg_type.set(paramTodoInfo.fromUinType);
    localAIOMsgInfo.uint64_uin.set(paramTodoInfo.fromUin);
    localAIOMsgInfo.uint32_msg_seq.set(paramTodoInfo.msgSeq);
    localAIOMsgInfo.uint32_msg_time.set(paramTodoInfo.msgTime);
    localAIOMsgInfo.uint32_msg_random.set(paramTodoInfo.msgRandom);
    localAIOMsgInfo.msg_tmp_info.set((MessageMicro)localObject3);
    localObject3 = new oidb_0xb3c.AddTodoReq();
    ((oidb_0xb3c.AddTodoReq)localObject3).msg_source.set((MessageMicro)localObject1);
    ((oidb_0xb3c.AddTodoReq)localObject3).msg_content.set((MessageMicro)localObject2);
    if (paramTodoInfo.remindTime > NetConnInfoCenter.getServerTimeMillis()) {
      ((oidb_0xb3c.AddTodoReq)localObject3).uint64_remind_time.set(paramTodoInfo.remindTime);
    }
    ((oidb_0xb3c.AddTodoReq)localObject3).msg_aio_msginfo.set(localAIOMsgInfo);
    localObject1 = new oidb_0xb3c.ReqBody();
    ((oidb_0xb3c.ReqBody)localObject1).msg_add_todo_req.set((MessageMicro)localObject3);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xb3c.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xb3c_add");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    if (paramInt == 1)
    {
      ((ToServiceMsg)localObject1).extraData.putInt("add_todo_from_todo_message_uintype", paramTodoInfo.istroop);
      ((ToServiceMsg)localObject1).extraData.putLong("add_todo_from_todo_message_uniseq", paramTodoInfo.uniseq);
    }
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void a(TodoInfo paramTodoInfo, int paramInt)
  {
    if (paramTodoInfo == null) {}
    label201:
    for (;;)
    {
      return;
      auoi localauoi = (auoi)this.app.getManager(376);
      if (localauoi != null)
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        if (paramInt == 3)
        {
          bool = localauoi.sX(paramTodoInfo.todoId);
          paramInt = 3;
        }
        for (;;)
        {
          if ((paramInt == -1) || (!bool)) {
            break label201;
          }
          localArrayList.add(new Pair(Integer.valueOf(paramInt), paramTodoInfo));
          localauoi.of(localArrayList);
          if (paramInt == 1)
          {
            notifyUI(1, true, new Object[] { Integer.valueOf(paramTodoInfo.appid), paramTodoInfo.todoId, paramTodoInfo });
            return;
            if (paramInt == 1)
            {
              bool = localauoi.sY(paramTodoInfo.todoId);
              paramInt = 1;
              continue;
            }
            if (paramInt == 2)
            {
              if (paramTodoInfo.status == 1)
              {
                bool = false;
                paramInt = -1;
                continue;
              }
              if (paramTodoInfo.status == 2)
              {
                bool = false;
                paramInt = -1;
              }
            }
          }
          else
          {
            if (paramInt != 3) {
              break;
            }
            notifyUI(6, true, paramTodoInfo.todoId);
            return;
          }
          bool = false;
          paramInt = -1;
        }
      }
    }
  }
  
  public void a(String paramString1, long paramLong1, int paramInt, long paramLong2, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "shareTodo, id = " + paramString1 + ", uin = " + paramLong1 + ", uinType = " + paramInt + ", troopUin = " + paramLong2 + ", from_phone = " + paramString2 + ", to_phone" + paramString3);
    }
    Object localObject = new oidb_0xb3c.TempSessionInfo.AddrListTmpInfo();
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      ((oidb_0xb3c.TempSessionInfo.AddrListTmpInfo)localObject).bytes_from_phone.set(ByteStringMicro.copyFromUtf8(paramString2));
      ((oidb_0xb3c.TempSessionInfo.AddrListTmpInfo)localObject).bytes_to_phone.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    paramString2 = new oidb_0xb3c.TempSessionInfo();
    if (paramInt == 1000)
    {
      paramString2.enum_session_type.set(1);
      paramString2.uint64_group_code.set(paramLong2);
      localObject = new oidb_0xb3c.ShareTodoReq();
      if (!TextUtils.isEmpty(paramString1)) {
        ((oidb_0xb3c.ShareTodoReq)localObject).bytes_todo_id.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      if (paramInt != 0) {
        break label385;
      }
      ((oidb_0xb3c.ShareTodoReq)localObject).enum_share_type.set(3);
      ((oidb_0xb3c.ShareTodoReq)localObject).uint64_friend_uin.set(paramLong1);
    }
    for (;;)
    {
      paramString1 = new oidb_0xb3c.ReqBody();
      paramString1.msg_share_todo_req.set((MessageMicro)localObject);
      paramString2 = new oidb_sso.OIDBSSOPkg();
      paramString2.uint32_command.set(2876);
      paramString2.uint32_result.set(0);
      paramString2.uint32_service_type.set(7);
      paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
      paramString1 = createToServiceMsg("OidbSvc.0xb3c_share");
      paramString1.putWupBuffer(paramString2.toByteArray());
      paramString1.setTimeout(30000L);
      sendPbReq(paramString1);
      return;
      if (paramInt == 1004)
      {
        paramString2.enum_session_type.set(2);
        paramString2.uint64_conf_code.set(paramLong2);
        break;
      }
      if (paramInt != 1006) {
        break;
      }
      paramString2.enum_session_type.set(3);
      paramString2.msg_addrlist.set((MessageMicro)localObject);
      break;
      label385:
      if (paramInt == 3000)
      {
        ((oidb_0xb3c.ShareTodoReq)localObject).enum_share_type.set(2);
        ((oidb_0xb3c.ShareTodoReq)localObject).uint64_conf_code.set(paramLong1);
      }
      else if (paramInt == 1)
      {
        ((oidb_0xb3c.ShareTodoReq)localObject).enum_share_type.set(1);
        ((oidb_0xb3c.ShareTodoReq)localObject).uint64_group_code.set(paramLong1);
      }
      else
      {
        ((oidb_0xb3c.ShareTodoReq)localObject).enum_share_type.set(4);
        ((oidb_0xb3c.ShareTodoReq)localObject).msg_temp_info.set(paramString2);
        if (paramInt == 1006)
        {
          paramLong1 = Long.valueOf(aqgv.x(this.app, paramString3)).longValue();
          ((oidb_0xb3c.ShareTodoReq)localObject).uint64_temp_uin.set(paramLong1);
        }
        else
        {
          ((oidb_0xb3c.ShareTodoReq)localObject).uint64_temp_uin.set(paramLong1);
        }
      }
    }
  }
  
  public void a(SubMsgType0x9c.MsgBody paramMsgBody, boolean paramBoolean)
  {
    paramMsgBody = paramMsgBody.bytes_ext_msg.get().toByteArray();
    Object localObject = new todo_notice.TodoNotice();
    try
    {
      ((todo_notice.TodoNotice)localObject).mergeFrom(paramMsgBody);
      int i = ((todo_notice.TodoNotice)localObject).enum_notice_type.get();
      paramMsgBody = ((todo_notice.TodoNotice)localObject).bytes_todo_id.get().toStringUtf8();
      if (i == 3)
      {
        localObject = new TodoInfo();
        ((TodoInfo)localObject).todoId = paramMsgBody;
        a((TodoInfo)localObject, i);
        return;
      }
      aj(paramMsgBody, i, "s2c.msgtype0x210.submsgtype0x9c");
      return;
    }
    catch (Exception paramMsgBody) {}
  }
  
  public void aj(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "getTodoById, id = " + paramString1 + ", operationType = " + paramInt + ", previousCMD = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    Object localObject = new oidb_0xb3c.GetTodoByIdReq();
    ((oidb_0xb3c.GetTodoByIdReq)localObject).bytes_todo_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString1 = new oidb_0xb3c.ReqBody();
    paramString1.msg_get_todo_byid_req.set((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(4);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString1 = createToServiceMsg("OidbSvc.0xb3c_get_by_id");
    paramString1.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramString1.setTimeout(30000L);
    paramString1.extraData.putInt("operation_type", paramInt);
    paramString1.extraData.putString("get_todo_by_id_type", paramString2);
    sendPbReq(paramString1);
  }
  
  public void b(String paramString1, int paramInt, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "updateTodo, id = " + paramString1 + ", updateType = " + paramInt + ", content = " + paramString2);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    oidb_0xb3c.TodoContent localTodoContent = new oidb_0xb3c.TodoContent();
    if (!TextUtils.isEmpty(paramString2)) {
      localTodoContent.bytes_content.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    paramString2 = new oidb_0xb3c.UpdateTodoReq();
    paramString2.bytes_todo_id.set(ByteStringMicro.copyFromUtf8(paramString1));
    paramString2.enum_update_type.set(paramInt);
    paramString2.msg_content.set(localTodoContent);
    if (paramLong > NetConnInfoCenter.getServerTimeMillis()) {
      paramString2.uint64_remind_time.set(paramLong);
    }
    paramString1 = new oidb_0xb3c.ReqBody();
    paramString1.msg_update_todo_req.set(paramString2);
    paramString2 = new oidb_sso.OIDBSSOPkg();
    paramString2.uint32_command.set(2876);
    paramString2.uint32_result.set(0);
    paramString2.uint32_service_type.set(5);
    paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString1 = createToServiceMsg("OidbSvc.0xb3c_update");
    paramString1.putWupBuffer(paramString2.toByteArray());
    paramString1.setTimeout(30000L);
    paramString1.extraData.putInt("updateType", paramInt);
    sendPbReq(paramString1);
  }
  
  public void bk(long paramLong, int paramInt)
  {
    this.Lc.clear();
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "getDoneTodo, lastReadTime = " + paramLong + ", count = " + paramInt);
    }
    Object localObject2 = new oidb_0xb3c.GetDoneTodoReq();
    ((oidb_0xb3c.GetDoneTodoReq)localObject2).uint64_begin_time.set(paramLong);
    ((oidb_0xb3c.GetDoneTodoReq)localObject2).uint32_wanted_count.set(paramInt);
    Object localObject1 = new oidb_0xb3c.ReqBody();
    ((oidb_0xb3c.ReqBody)localObject1).msg_get_done_todo_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(3);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xb3c.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xb3c_get_done");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void evE()
  {
    this.Lb.clear();
    long l = ((auoi)this.app.getManager(376)).iE();
    if (l == 0L) {}
    for (int i = 2;; i = 1)
    {
      bj(l, i);
      return;
    }
  }
  
  public void evF()
  {
    Object localObject2 = new oidb_0xb3c.GetDoneCountReq();
    Object localObject1 = new oidb_0xb3c.ReqBody();
    ((oidb_0xb3c.ReqBody)localObject1).msg_get_done_count_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(8);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xb3c.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xb3c_get_done_count");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void gR(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TodoHandler", 2, "deleteTodo, id = " + paramString + ", status: " + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = new oidb_0xb3c.DeleteTodoReq();
    ((oidb_0xb3c.DeleteTodoReq)localObject2).bytes_todo_id.set(ByteStringMicro.copyFromUtf8(paramString));
    Object localObject1 = new oidb_0xb3c.ReqBody();
    ((oidb_0xb3c.ReqBody)localObject1).msg_delete_todo_req.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2876);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(6);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0xb3c.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0xb3c_delete");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    ((ToServiceMsg)localObject1).addAttribute("delete_todo_status", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject1).addAttribute("delete_todo_id", paramString);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0xb3c_add");
      this.allowCmdSet.add("OidbSvc.0xb3c_get_undone");
      this.allowCmdSet.add("OidbSvc.0xb3c_get_done");
      this.allowCmdSet.add("OidbSvc.0xb3c_get_by_id");
      this.allowCmdSet.add("OidbSvc.0xb3c_update");
      this.allowCmdSet.add("OidbSvc.0xb3c_delete");
      this.allowCmdSet.add("OidbSvc.0xb3c_share");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void mt(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          return;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleShareTodo ret = " + i);
        }
        if ((i != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("TodoHandler", 2, "handleShareTodo ", paramToServiceMsg);
        return;
        paramFromServiceMsg = "";
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0xb3c.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleShareTodo|parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
      }
    }
    if (paramToServiceMsg != null)
    {
      if ((paramToServiceMsg.msg_result.has()) && (paramToServiceMsg.msg_result.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.ResultMsg)paramToServiceMsg.msg_result.get();
        i = paramFromServiceMsg.uint32_result.get();
        if ((!paramFromServiceMsg.bytes_err_msg.has()) || (paramFromServiceMsg.bytes_err_msg.get() == null)) {
          break label329;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleShareTodo|result = " + i + ", errMsg = " + paramFromServiceMsg);
        }
      }
      if ((paramToServiceMsg.msg_share_todo_rsp.has()) && (paramToServiceMsg.msg_share_todo_rsp.get() != null))
      {
        notifyUI(7, true, null);
        return;
        notifyUI(7, false, null);
        return;
      }
    }
    label329:
  }
  
  public void mu(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          return;
        }
        j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetDoneTodoCount ret = " + j);
        }
        if ((j != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          return;
        }
        paramFromServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramToServiceMsg = new oidb_0xb3c.RspBody();
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("TodoHandler", 2, "handleGetDoneTodoCount ", paramToServiceMsg);
        return;
        paramFromServiceMsg = "";
        continue;
      }
      try
      {
        paramFromServiceMsg = (oidb_0xb3c.RspBody)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TodoHandler", 2, "handleGetDoneTodoCount|parseFrom byte InvalidProtocolBufferMicroException");
        paramFromServiceMsg.printStackTrace();
      }
    }
    if (paramToServiceMsg != null)
    {
      if ((paramToServiceMsg.msg_result.has()) && (paramToServiceMsg.msg_result.get() != null))
      {
        paramFromServiceMsg = (oidb_0xb3c.ResultMsg)paramToServiceMsg.msg_result.get();
        j = paramFromServiceMsg.uint32_result.get();
        if ((!paramFromServiceMsg.bytes_err_msg.has()) || (paramFromServiceMsg.bytes_err_msg.get() == null)) {
          break label415;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_err_msg.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetDoneTodoCount|result = " + j + ", errMsg = " + paramFromServiceMsg);
        }
      }
      if ((paramToServiceMsg.msg_get_done_count_rsp.has()) && (paramToServiceMsg.msg_get_done_count_rsp.get() != null))
      {
        paramToServiceMsg = (oidb_0xb3c.GetDoneCountRsp)paramToServiceMsg.msg_get_done_count_rsp.get();
        if (paramToServiceMsg.uint32_total_count.has()) {
          i = paramToServiceMsg.uint32_total_count.get();
        }
        if (QLog.isColorLevel()) {
          QLog.d("TodoHandler", 2, "handleGetDoneTodoCount|doneTodoCount = " + i);
        }
        ((auoi)this.app.getManager(376)).aaT(i);
        notifyUI(8, true, new Object[] { Integer.valueOf(i) });
        return;
      }
    }
    label415:
  }
  
  protected Class<? extends acci> observerClass()
  {
    return aupd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    boolean bool = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.i("TodoHandler", 2, "onReceive, cmd=" + str + ", isSucc=" + bool);
    }
    if ("OidbSvc.0xb3c_add".equals(str)) {
      mn(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0xb3c_get_undone".equals(str))
      {
        mo(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb3c_get_done".equals(str))
      {
        mp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb3c_get_by_id".equals(str))
      {
        mq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb3c_update".equals(str))
      {
        mr(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb3c_delete".equals(str))
      {
        ms(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb3c_share".equals(str))
      {
        mt(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xb3c_get_done_count".equals(str));
    mu(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aunu
 * JD-Core Version:    0.7.0.1
 */