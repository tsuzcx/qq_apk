import android.content.Intent;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.dingdong.DingdongPluginBizHandler.2;
import com.tencent.tim.dingdong.DingdongPluginBizObserver;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.TempLiteMailIndexInfo;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.a;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.b;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.c;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.d;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.e;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.e.a;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.e.b;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.f;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.g;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.h;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.i;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.j;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.k;
import com.tencent.tim.dingdong.DingdongPluginBizObserver.l;
import com.tencent.tim.dingdong.DingdongPluginDataFactory;
import com.tencent.tim.dingdong.DingdongPluginDataFactory.ScheduleSummaryData;
import com.tencent.tim.dingdong.MessageForDingdongSchedule;
import com.trunk.Qworkflow.Qworkflow.AppID;
import com.trunk.Qworkflow.Qworkflow.BusinessInfo;
import com.trunk.Qworkflow.Qworkflow.ContentElement;
import com.trunk.Qworkflow.Qworkflow.NoticedUser;
import com.trunk.Qworkflow.Qworkflow.Notification;
import com.trunk.Qworkflow.Qworkflow.Observer;
import com.trunk.Qworkflow.Qworkflow.RemindTimer;
import com.trunk.Qworkflow.Qworkflow.ScheduleChangeNotification;
import com.trunk.Qworkflow.Qworkflow.Text;
import com.trunk.Qworkflow.Qworkflow.UserSource;
import com.trunk.Qworkflow.Qworkflow.Workflow;
import com.trunk.Qworkflow.Qworkflow.WorkflowContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x4f2.oidb_0x4f2.RspBody;
import tencent.im.oidb.cmd0x508.oidb_0x508.RspBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.AppNoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetAppNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.GetOfficeNoticeRsp;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.NoticeInfo;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.ReqBody;
import tencent.im.oidb.cmd0x51d.oidb_0x51d.RspBody;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdReq;
import tencent.im.oidb.cmd0x589.oidb_0x589.GetUserOpenIdRsp;
import tencent.im.oidb.cmd0x589.oidb_0x589.RspBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDReq;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleByIDRsp;
import tencent.im.oidb.cmd0x592.oidb_0x592.GetScheduleResult;
import tencent.im.oidb.cmd0x592.oidb_0x592.ReqBody;
import tencent.im.oidb.cmd0x592.oidb_0x592.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.GetUnreadMailCountRsp;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.RspBody;
import tencent.im.oidb.cmd0x8f6.oidb_cmd0x8f6.UnreadMailCountInfo;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoReq;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.GetLatestNodeInfoRsp;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.LiteMailBrief;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ReqBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ResultMsg;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.RspBody;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.SourceID;
import tencent.im.oidb.cmd0x8f9.oidb_0x8f9.UnreadMailCountInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x8f.submsgtype0x8f.SourceID;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.LiteMailIndexInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.SourceID;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.StateChangeNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountChanged;
import tencent.im.s2c.msgtype0x210.submsgtype0x93.submsgtype0x93.UnreadMailCountInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x9b.SubMsgType0x9b.PbOfficeNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x9c.SubMsgType0x9c.MsgBody;

public class atnf
  extends accg
{
  public atnf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private DingdongPluginBizObserver.i a(long paramLong, oidb_0x592.GetScheduleResult paramGetScheduleResult)
  {
    if (paramGetScheduleResult.msg_schedule.has()) {}
    for (Object localObject1 = (Qworkflow.Workflow)paramGetScheduleResult.msg_schedule.get(); localObject1 == null; localObject1 = null) {
      return null;
    }
    DingdongPluginBizObserver.i locali = new DingdongPluginBizObserver.i();
    DingdongPluginDataFactory.ScheduleSummaryData localScheduleSummaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
    if (((Qworkflow.Workflow)localObject1).bytes_workflow_id.has()) {
      localScheduleSummaryData.id = ((Qworkflow.Workflow)localObject1).bytes_workflow_id.get().toStringUtf8();
    }
    if (((Qworkflow.Workflow)localObject1).uint64_author_uin.has()) {
      localScheduleSummaryData.authorUin = Long.toString(((Qworkflow.Workflow)localObject1).uint64_author_uin.get());
    }
    Object localObject4;
    Object localObject3;
    if (((Qworkflow.Workflow)localObject1).msg_workflow_content.has())
    {
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.has()) {
        localScheduleSummaryData.title = ((Qworkflow.Workflow)localObject1).msg_workflow_content.bytes_title.get().toStringUtf8();
      }
      if (((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.has())
      {
        localObject2 = ((Qworkflow.Workflow)localObject1).msg_workflow_content.rpt_content_list.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Qworkflow.ContentElement)((Iterator)localObject2).next();
          if ((((Qworkflow.ContentElement)localObject4).bytes_userdef.has()) && (((Qworkflow.ContentElement)localObject4).rpt_text_list.has()) && (((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.has()))
          {
            localObject3 = ((Qworkflow.Text)((Qworkflow.ContentElement)localObject4).rpt_text_list.get(0)).bytes_content.get().toStringUtf8();
            localObject4 = ((Qworkflow.ContentElement)localObject4).bytes_userdef.get().toStringUtf8();
            if ("loc".equals(localObject4)) {
              localScheduleSummaryData.location = ((String)localObject3);
            } else if ("mark".equals(localObject4)) {
              localScheduleSummaryData.mark = ((String)localObject3);
            }
          }
        }
      }
    }
    if (((Qworkflow.Workflow)localObject1).msg_remind_timer.has())
    {
      localScheduleSummaryData.beginTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_start_time.get();
      localScheduleSummaryData.endTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint64_end_time.get();
      if (((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_flag.get() != 0) {
        localScheduleSummaryData.offsetTime = ((Qworkflow.Workflow)localObject1).msg_remind_timer.uint32_remind_offset.get();
      }
      localScheduleSummaryData.repeatType = ((Qworkflow.Workflow)localObject1).msg_remind_timer.enum_repeat_type.get();
    }
    Object localObject2 = new ArrayList();
    if (((Qworkflow.Workflow)localObject1).rpt_noticed_users.has())
    {
      localObject3 = ((Qworkflow.Workflow)localObject1).rpt_noticed_users.get().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Qworkflow.NoticedUser)((Iterator)localObject3).next();
        if (((Qworkflow.NoticedUser)localObject4).msg_user_source.has())
        {
          DingdongPluginBizObserver.a locala = new DingdongPluginBizObserver.a();
          locala.uin = String.valueOf(((Qworkflow.NoticedUser)localObject4).uint64_uin.get());
          locala.sourceId = String.valueOf(((Qworkflow.NoticedUser)localObject4).msg_user_source.uint64_source_code.get());
          switch (((Qworkflow.NoticedUser)localObject4).msg_user_source.enum_source_type.get())
          {
          }
          for (;;)
          {
            if (((Qworkflow.NoticedUser)localObject4).enum_handle_state.has()) {
              locala.dT = ((Qworkflow.NoticedUser)localObject4).enum_handle_state.get();
            }
            ((ArrayList)localObject2).add(locala);
            break;
            locala.sourceType = 3;
            continue;
            locala.sourceType = 2;
            continue;
            locala.sourceType = 1;
          }
        }
      }
    }
    if (((Qworkflow.Workflow)localObject1).rpt_msg_observers.has())
    {
      localObject1 = ((Qworkflow.Workflow)localObject1).rpt_msg_observers.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (Qworkflow.Observer)((Iterator)localObject1).next();
        if (((Qworkflow.Observer)localObject4).msg_observer_source.has())
        {
          localObject3 = new DingdongPluginBizObserver.a();
          ((DingdongPluginBizObserver.a)localObject3).uin = String.valueOf(((Qworkflow.Observer)localObject4).uint64_uin.get());
          ((DingdongPluginBizObserver.a)localObject3).sourceId = String.valueOf(((Qworkflow.Observer)localObject4).msg_observer_source.uint64_source_code.get());
          switch (((Qworkflow.Observer)localObject4).msg_observer_source.enum_source_type.get())
          {
          default: 
            label768:
            localObject4 = ((ArrayList)localObject2).iterator();
            do
            {
              if (!((Iterator)localObject4).hasNext()) {
                break;
              }
            } while (!((DingdongPluginBizObserver.a)((Iterator)localObject4).next()).uin.equals(((DingdongPluginBizObserver.a)localObject3).uin));
          }
        }
      }
    }
    for (int i = 1; i == 0; i = 0)
    {
      ((DingdongPluginBizObserver.a)localObject3).dT = 1;
      ((ArrayList)localObject2).add(localObject3);
      break;
      ((DingdongPluginBizObserver.a)localObject3).sourceType = 3;
      break label768;
      ((DingdongPluginBizObserver.a)localObject3).sourceType = 2;
      break label768;
      ((DingdongPluginBizObserver.a)localObject3).sourceType = 1;
      break label768;
      localScheduleSummaryData.specialFlag = paramGetScheduleResult.uint32_result.get();
      locali.seq = paramLong;
      locali.summaryData = localScheduleSummaryData;
      locali.Ef = ((ArrayList)localObject2);
      return locali;
    }
  }
  
  private String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    boolean bool = true;
    eug();
    Object localObject1 = new Qworkflow.Notification();
    Object localObject2;
    for (;;)
    {
      try
      {
        ((Qworkflow.Notification)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (Qworkflow.ScheduleChangeNotification)((Qworkflow.Notification)localObject1).msg_schedule_change.get();
        if (QLog.isColorLevel()) {
          QLog.i("DingdongPluginBizHandler", 1, "handlePushMsg_ScheduleChangeNotification type:" + paramArrayOfByte.enum_change_type.get());
        }
        if (1 != paramArrayOfByte.enum_change_type.get()) {
          break;
        }
        localObject1 = new DingdongPluginBizObserver.j();
        ((DingdongPluginBizObserver.j)localObject1).dim = paramBoolean;
        if ((paramArrayOfByte.msg_busi_info.has()) && (paramArrayOfByte.msg_busi_info.bytes_userdef.has()) && (paramArrayOfByte.msg_busi_info.enum_busi_type.get() == 2))
        {
          ((DingdongPluginBizObserver.j)localObject1).summaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
          try
          {
            localObject2 = new JSONObject(paramArrayOfByte.msg_busi_info.bytes_userdef.get().toStringUtf8());
            ((DingdongPluginBizObserver.j)localObject1).summaryData.todoId = ((JSONObject)localObject2).getString("ToDoID");
            ((DingdongPluginBizObserver.j)localObject1).summaryData.title = paramArrayOfByte.msg_summary.bytes_content.get().toStringUtf8();
            ((DingdongPluginBizObserver.j)localObject1).summaryData.beginTime = paramArrayOfByte.uint64_start_time.get();
            if (((DingdongPluginBizObserver.j)localObject1).errCode != 0) {
              break label889;
            }
            paramBoolean = bool;
            super.notifyUI(10, paramBoolean, localObject1);
          }
          catch (Exception paramArrayOfByte)
          {
            ((DingdongPluginBizObserver.j)localObject1).summaryData.todoId = "";
            ((DingdongPluginBizObserver.j)localObject1).errCode = -1;
            QLog.e("DingdongPluginBizHandler", 1, "parse todo id fail, feedId:" + ((DingdongPluginBizObserver.j)localObject1).summaryData.id);
            continue;
          }
        }
        ((DingdongPluginBizObserver.j)localObject1).summaryData = DingdongPluginDataFactory.a((Qworkflow.Text)paramArrayOfByte.msg_summary.get());
      }
      catch (Exception paramArrayOfByte)
      {
        return paramArrayOfByte.toString();
      }
      if (((DingdongPluginBizObserver.j)localObject1).summaryData != null)
      {
        ((DingdongPluginBizObserver.j)localObject1).summaryData.id = paramArrayOfByte.bytes_workflow_id.get().toStringUtf8();
        ((DingdongPluginBizObserver.j)localObject1).summaryData.authorUin = String.valueOf(paramArrayOfByte.uint64_author_uin.get());
        localObject2 = ((DingdongPluginBizObserver.j)localObject1).summaryData;
        if (paramArrayOfByte.uint32_remind_bell_switch.get() != 1) {
          break label884;
        }
        paramBoolean = true;
        label387:
        ((DingdongPluginDataFactory.ScheduleSummaryData)localObject2).hasAlarm = paramBoolean;
        if ((paramArrayOfByte.uint64_start_time.has()) && (paramArrayOfByte.uint64_end_time.has()))
        {
          ((DingdongPluginBizObserver.j)localObject1).summaryData.beginTime = paramArrayOfByte.uint64_start_time.get();
          ((DingdongPluginBizObserver.j)localObject1).summaryData.endTime = paramArrayOfByte.uint64_end_time.get();
        }
      }
      else
      {
        ((DingdongPluginBizObserver.j)localObject1).errCode = -1;
      }
    }
    if (7 == paramArrayOfByte.enum_change_type.get())
    {
      localObject1 = new DingdongPluginBizObserver.j();
      ((DingdongPluginBizObserver.j)localObject1).dim = paramBoolean;
      ((DingdongPluginBizObserver.j)localObject1).summaryData = DingdongPluginDataFactory.a((Qworkflow.Text)paramArrayOfByte.msg_summary.get());
      if (((DingdongPluginBizObserver.j)localObject1).summaryData != null)
      {
        ((DingdongPluginBizObserver.j)localObject1).summaryData.id = paramArrayOfByte.bytes_workflow_id.get().toStringUtf8();
        ((DingdongPluginBizObserver.j)localObject1).summaryData.title = paramArrayOfByte.bytes_title.get().toStringUtf8();
        ((DingdongPluginBizObserver.j)localObject1).summaryData.authorUin = String.valueOf(paramArrayOfByte.uint64_author_uin.get());
        localObject2 = ((DingdongPluginBizObserver.j)localObject1).summaryData;
        if (paramArrayOfByte.uint32_remind_bell_switch.get() != 1) {
          break label894;
        }
      }
    }
    label882:
    label884:
    label889:
    label894:
    for (bool = true;; bool = false)
    {
      ((DingdongPluginDataFactory.ScheduleSummaryData)localObject2).hasAlarm = bool;
      if ((paramArrayOfByte.uint64_start_time.has()) && (paramArrayOfByte.uint64_end_time.has()))
      {
        ((DingdongPluginBizObserver.j)localObject1).summaryData.beginTime = paramArrayOfByte.uint64_start_time.get();
        ((DingdongPluginBizObserver.j)localObject1).summaryData.endTime = paramArrayOfByte.uint64_end_time.get();
      }
      super.notifyUI(15, true, localObject1);
      for (;;)
      {
        paramArrayOfByte = ((DingdongPluginBizObserver.j)localObject1).summaryData.id;
        if ((this.app == null) || (sU(paramArrayOfByte))) {
          break label882;
        }
        if (QLog.isDebugVersion()) {
          QLog.i("DingdongPluginBizHandler", 1, "SchedulePushForAccept need update schedule message background : " + paramArrayOfByte);
        }
        if (!paramBoolean) {
          break;
        }
        d(paramArrayOfByte, "2", 1000L, "offlineAcceptPush");
        break label882;
        ((DingdongPluginBizObserver.j)localObject1).errCode = -1;
        super.notifyUI(15, false, localObject1);
      }
      d(paramArrayOfByte, "2", 0L, "onlineAcceptPush");
      break label882;
      if (4 == paramArrayOfByte.enum_change_type.get())
      {
        if (QLog.isDebugVersion()) {
          QLog.i("DingdongPluginBizHandler", 1, "SchedulePushForCancel need update schedule message background");
        }
      }
      else if (6 == paramArrayOfByte.enum_change_type.get())
      {
        if (QLog.isDebugVersion()) {
          QLog.i("DingdongPluginBizHandler", 1, "SchedulePushForUpdate need update schedule message background");
        }
      }
      else
      {
        localObject1 = new DingdongPluginBizObserver.h();
        ((DingdongPluginBizObserver.h)localObject1).errCode = 0;
        ((DingdongPluginBizObserver.h)localObject1).id = paramArrayOfByte.bytes_workflow_id.get().toStringUtf8();
        ((DingdongPluginBizObserver.h)localObject1).authorUin = paramArrayOfByte.uint64_author_uin.get();
        ((DingdongPluginBizObserver.h)localObject1).changeType = paramArrayOfByte.enum_change_type.get();
        super.notifyUI(9, true, localObject1);
      }
      return null;
      paramBoolean = false;
      break label387;
      paramBoolean = false;
      break;
    }
  }
  
  private void d(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new DingdongPluginBizHandler.2(this, paramString1, paramString3, paramString2);
    if (paramLong == 0L)
    {
      ThreadManager.executeOnSubThread(paramString1);
      return;
    }
    ThreadManager.getUIHandler().postDelayed(paramString1, paramLong);
  }
  
  private void eug()
  {
    if (!atne.a().getBoolean("officecenter_always_show_flag", false)) {
      atne.a().S("officecenter_always_show_flag", true);
    }
    notifyUI(13, true, null);
  }
  
  private void lK(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    Object localObject = new oidb_0x589.RspBody();
    int j;
    if (1000 == i)
    {
      j = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      i = j;
      if (j == 0) {
        break label410;
      }
      QLog.e("DingdongPluginBizHandler", 1, "0x589 respond oidb error:retCode[" + j + "].");
      i = j;
    }
    for (;;)
    {
      paramFromServiceMsg = new DingdongPluginBizObserver.e();
      paramFromServiceMsg.asr = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
      if (i != 0) {
        break label489;
      }
      try
      {
        paramToServiceMsg = ((oidb_0x589.RspBody)localObject).rpt_msg_open_id.get();
        paramFromServiceMsg.appId = ((oidb_0x589.RspBody)localObject).uint64_app_id.get();
        paramFromServiceMsg.dataNum = paramToServiceMsg.size();
        paramObject = new DingdongPluginBizObserver.e.a[paramFromServiceMsg.dataNum];
        j = 0;
        for (;;)
        {
          if (j < paramFromServiceMsg.dataNum)
          {
            localObject = (oidb_0x589.GetUserOpenIdRsp)paramToServiceMsg.get(j);
            paramObject[j] = new DingdongPluginBizObserver.e.a();
            paramObject[j].a = new DingdongPluginBizObserver.e.b();
            paramObject[j].a.flag = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint32_req_flag.get();
            paramObject[j].a.uin = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_uin.get();
            paramObject[j].a.hostUin = ((oidb_0x589.GetUserOpenIdRsp)localObject).msg_req_id.uint64_req_host_uin.get();
            paramObject[j].resultCode = ((oidb_0x589.GetUserOpenIdRsp)localObject).uint32_result.get();
            paramObject[j].openId = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_open_id.get().toStringUtf8();
            paramObject[j].cHF = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_group_open_id.get().toStringUtf8();
            paramObject[j].cHG = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_discuss_open_id.get().toStringUtf8();
            paramObject[j].token = ((oidb_0x589.GetUserOpenIdRsp)localObject).bytes_token.get().toStringUtf8();
            j += 1;
            continue;
            QLog.e("DingdongPluginBizHandler", 1, "0x589 respond msf error:retCode[" + i + "],errMsg[" + paramFromServiceMsg.getBusinessFailMsg() + "]");
            label410:
            break;
          }
        }
        paramFromServiceMsg.a = paramObject;
        paramFromServiceMsg.errCode = 1;
      }
      catch (NullPointerException paramToServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.errCode = -1;
          QLog.e("DingdongPluginBizHandler", 1, "0x589 handleRsp nullPointer error:[" + paramToServiceMsg.toString() + "]");
          i = -1;
        }
      }
    }
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      super.notifyUI(6, bool, paramFromServiceMsg);
      return;
      label489:
      paramFromServiceMsg.errCode = -1;
      break;
    }
  }
  
  private void lL(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    oidb_0x508.RspBody localRspBody = new oidb_0x508.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        int j = localRspBody.opt_uint32_result.get();
        i = j;
        if (j == 0) {
          break label297;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond biz error: retCode[" + j + "].");
        i = j;
        paramFromServiceMsg = new DingdongPluginBizObserver.d();
        paramFromServiceMsg.ayw = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (i != 0) {
          break label300;
        }
        paramFromServiceMsg.resultCode = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.IV = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.ayx = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.Ch = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.Ch.addAll(paramToServiceMsg);
        }
        label208:
        if (i != 0) {
          break label308;
        }
      }
    }
    label297:
    label300:
    label308:
    for (boolean bool = true;; bool = false)
    {
      super.notifyUI(11, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond oidb error: retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_2 respond msf error: retCode[" + i + "].");
      break;
      paramFromServiceMsg.resultCode = -1;
      break label208;
    }
  }
  
  private void lM(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    oidb_0x4f2.RspBody localRspBody = new oidb_0x4f2.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        int j = localRspBody.opt_uint32_result.get();
        i = j;
        if (j == 0) {
          break label297;
        }
        QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond biz error: retCode[" + j + "].");
        i = j;
        paramFromServiceMsg = new DingdongPluginBizObserver.k();
        paramFromServiceMsg.ayw = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
        if (i != 0) {
          break label300;
        }
        paramFromServiceMsg.resultCode = localRspBody.opt_uint32_result.get();
        paramFromServiceMsg.IV = localRspBody.opt_bytes_errinfo.get().toStringUtf8();
        paramFromServiceMsg.ayy = localRspBody.opt_uint64_update_seq.get();
        paramToServiceMsg = localRspBody.rpt_uint64_appid_list.get();
        if (paramToServiceMsg != null)
        {
          paramFromServiceMsg.Ch = new ArrayList(paramToServiceMsg.size());
          paramFromServiceMsg.Ch.addAll(paramToServiceMsg);
        }
        label208:
        if (i != 0) {
          break label308;
        }
      }
    }
    label297:
    label300:
    label308:
    for (boolean bool = true;; bool = false)
    {
      super.notifyUI(12, bool, paramFromServiceMsg);
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond oidb error: retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x4f2 respond msf error: retCode[" + i + "].");
      break;
      paramFromServiceMsg.resultCode = -1;
      break label208;
    }
  }
  
  private void lN(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int k = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f6_1_subCmd")).intValue();
    paramToServiceMsg = new oidb_cmd0x8f6.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        int j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (j != 0)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz error:subCmd[" + k + "],retCode[" + j + "].");
          i = j;
        }
        switch (k)
        {
        }
      }
    }
    label365:
    do
    {
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond oidb error:subCmd[" + k + "],retCode[" + i + "].");
      break;
      QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond msf error:subCmd[" + k + "],retCode[" + i + "].");
      break;
      paramFromServiceMsg = new DingdongPluginBizObserver.l();
      if (i == 0) {}
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_cmd0x8f6.UnreadMailCountInfo)((oidb_cmd0x8f6.GetUnreadMailCountRsp)paramToServiceMsg.msg_get_umc.get()).msg_unread.get();
          paramFromServiceMsg.unreadNum = paramToServiceMsg.uint32_unread_count.get();
          paramFromServiceMsg.eqx = paramToServiceMsg.uint32_data_version.get();
          if (paramFromServiceMsg.errCode != 0) {
            break label365;
          }
          bool = true;
          super.notifyUI(1, bool, paramFromServiceMsg);
          return;
        }
        catch (NullPointerException paramToServiceMsg)
        {
          QLog.e("DingdongPluginBizHandler", 1, "0x8f6_1 respond biz package error:subCmd[0x1],errMsg[" + paramToServiceMsg.toString() + "].");
          paramFromServiceMsg.errCode = -1;
          continue;
        }
        paramFromServiceMsg.errCode = i;
        continue;
        boolean bool = false;
      }
    } while (i != 0);
  }
  
  private void lO(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    int k = ((Integer)paramToServiceMsg.getAttribute("OidbSvc.0x8f9_13_subCmd")).intValue();
    paramToServiceMsg = new oidb_0x8f9.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i != 0) {}
    }
    for (;;)
    {
      try
      {
        int j = paramToServiceMsg.msg_result_msg.uint32_result.get();
        i = j;
        if (j != 0)
        {
          i = j;
          paramFromServiceMsg = paramToServiceMsg.msg_result_msg.bytes_err_msg.get().toStringUtf8();
          i = j;
          QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + k + "retCode[" + j + "],errMsg[" + paramFromServiceMsg + "].");
          i = j;
        }
      }
      catch (NullPointerException paramFromServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond biz package error -> subCmd" + k + "retCode[" + i + "],errMsg[" + paramFromServiceMsg.toString() + "].");
        i = -1;
        continue;
      }
      switch (k)
      {
      default: 
        return;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond oidb package error -> subCmd" + k + "retCode[" + i + "].");
        continue;
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_11 respond msf error -> subCmd" + k + "retCode[" + i + "].");
      }
    }
    paramFromServiceMsg = new DingdongPluginBizObserver.g();
    if (i == 0) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg.errCode = paramToServiceMsg.msg_rsp_get_latest_node_info.uint32_result.get();
        if (132 == paramFromServiceMsg.errCode)
        {
          paramFromServiceMsg.errCode = 0;
          paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$f = new DingdongPluginBizObserver.f();
          paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l = new DingdongPluginBizObserver.l();
          if (QLog.isColorLevel()) {
            QLog.i("DingdongPluginBizHandler", 2, "0x8f9_13 respond no feed data.");
          }
          if (paramFromServiceMsg.errCode != 0) {
            break label853;
          }
          bool = true;
          super.notifyUI(2, bool, paramFromServiceMsg);
          return;
        }
        if (paramFromServiceMsg.errCode == 0)
        {
          paramObject = new DingdongPluginBizObserver.f();
          if (paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.has())
          {
            paramObject.feedId = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_id.get().toStringUtf8();
            paramObject.eqw = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_last_modify_time.get();
            paramObject.sourceType = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint32_source_type.get();
            paramObject.sourceId = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.msg_source_id.uint64_source_code.get());
            paramObject.fromUin = String.valueOf(paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint64_author_uin.get());
            paramObject.msgBrief = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.bytes_feeds_summary.get().toStringUtf8();
            if (1 == paramToServiceMsg.msg_rsp_get_latest_node_info.msg_litemail_brief.uint32_summary_truncate_flag.get()) {
              paramObject.msgBrief = (paramObject.msgBrief.substring(0, paramObject.msgBrief.length() - 1) + "...");
            }
          }
          paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$f = paramObject;
          if (!paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.has()) {
            continue;
          }
          paramObject = new DingdongPluginBizObserver.l();
          paramObject.unreadNum = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_unread_count.get();
          paramObject.eqx = paramToServiceMsg.msg_rsp_get_latest_node_info.msg_unread_cnt_info.uint32_data_version.get();
          paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l = paramObject;
          continue;
        }
      }
      catch (NullPointerException paramToServiceMsg)
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error:errMsg[" + paramToServiceMsg.toString() + "].");
        paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$l = null;
        paramFromServiceMsg.jdField_a_of_type_ComTencentTimDingdongDingdongPluginBizObserver$f = null;
        paramFromServiceMsg.errCode = -1;
        continue;
      }
      if (paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.has()) {}
      for (paramToServiceMsg = paramToServiceMsg.msg_rsp_get_latest_node_info.bytes_err_msg.get().toStringUtf8();; paramToServiceMsg = "serveUnknownError")
      {
        QLog.e("DingdongPluginBizHandler", 1, "0x8f9_13 respond biz error -> retCode[" + paramFromServiceMsg.errCode + ",errMsg[" + paramToServiceMsg + "].");
        break;
      }
      paramFromServiceMsg.errCode = i;
      continue;
      label853:
      boolean bool = false;
    }
  }
  
  private void lP(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x508.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      new atng(this, paramToServiceMsg).execute(new Void[] { null, null, null });
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x508_1 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void lQ(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_office_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetOfficeNoticeRsp)paramToServiceMsg.opt_msg_office_notice_rsp.get();
        if (paramToServiceMsg.opt_msg_office_notice.has())
        {
          paramToServiceMsg = (oidb_0x51d.NoticeInfo)paramToServiceMsg.opt_msg_office_notice.get();
          i = paramToServiceMsg.opt_uint32_notice_count.get();
          int j = paramToServiceMsg.opt_uint32_notice_version.get();
          QLog.e("DingdongPluginBizHandler", 4, "handleRspMsg_0x51d_1 cnt: " + i + " ver: " + j);
          if (i > 0)
          {
            atne.a().S("officecenter_red_point_flag_" + this.app.getLongAccountUin(), true);
            atne.a().av("officecenter_red_point_cnt_" + this.app.getLongAccountUin(), i);
            atne.a().av("officecenter_red_point_ver_" + this.app.getLongAccountUin(), j);
            notifyUI(5, true, null);
          }
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_1 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void lR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramToServiceMsg = new oidb_0x51d.RspBody();
    if (1000 == i)
    {
      i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      if (i == 0)
      {
        i = paramToServiceMsg.opt_uint32_result.get();
        if (i != 0) {
          QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond biz error: retCode[" + i + "].");
        }
      }
    }
    for (;;)
    {
      if (paramToServiceMsg.opt_msg_app_notice_rsp.has())
      {
        paramToServiceMsg = (oidb_0x51d.GetAppNoticeRsp)paramToServiceMsg.opt_msg_app_notice_rsp.get();
        if (paramToServiceMsg.has()) {
          nP(paramToServiceMsg.rpt_msg_app_notice.get());
        }
      }
      return;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond oidb error: retCode[" + i + "].");
      continue;
      QLog.e("DingdongPluginBizHandler", 1, "0x51d_2 respond msf error: retCode[" + i + "].");
    }
  }
  
  private void lS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    paramFromServiceMsg.getResultCode();
    paramObject = new oidb_sso.OIDBSSOPkg();
    if (1000 == i) {}
    int j;
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        i = paramObject.uint32_result.get();
        if (i != 0)
        {
          paramFromServiceMsg = paramObject.str_error_msg.get();
          QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + "." + paramObject.uint32_service_type.get() + " ssoPkg biz return error(" + i + ") -> " + paramFromServiceMsg);
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        try
        {
          paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          switch (j)
          {
          default: 
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592." + j + " decode pkg error -> " + paramFromServiceMsg.toString());
          return;
        }
        paramFromServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg.toString();
        QLog.e("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]" + paramToServiceMsg.getServiceCmd() + " decode ssoPkg error -> " + paramFromServiceMsg.toString());
        continue;
      }
      j = paramObject.uint32_service_type.get();
      paramFromServiceMsg = new oidb_0x592.RspBody();
      QLog.e("DingdongPluginBizHandler", 2, "0x592 respond msf error: retCode[" + i + "].");
    }
    paramFromServiceMsg = (oidb_0x592.GetScheduleByIDRsp)paramFromServiceMsg.msg_get_schedule_by_id_rsp.get();
    if (paramFromServiceMsg == null) {}
    long l;
    for (i = -1;; i = paramFromServiceMsg.uint32_result.get())
    {
      l = ((Long)paramToServiceMsg.getAttribute("ReqSeq", Long.valueOf(-1L))).longValue();
      paramObject = (String)paramToServiceMsg.getAttribute("scheduleid", "");
      if (i != 0) {
        break label653;
      }
      if (QLog.isColorLevel()) {
        QLog.i("DingdongPluginBizHandler", 2, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp success.],serviceType = " + j + ", seq = " + l);
      }
      paramToServiceMsg = a(l, (oidb_0x592.GetScheduleResult)paramFromServiceMsg.msg_schedule_result.get());
      label471:
      if (paramToServiceMsg == null) {
        break label858;
      }
      notifyUI(14, true, paramToServiceMsg);
      if ((this.app == null) || (TextUtils.isEmpty(paramObject)) || (sU(paramObject))) {
        break;
      }
      if (QLog.isDebugVersion()) {
        QLog.i("DingdongPluginBizHandler", 1, "updateScheduleMsg background from get schedule detail : " + paramObject);
      }
      String str = this.app.getCurrentAccountUin();
      paramFromServiceMsg = "";
      if (paramToServiceMsg.summaryData.authorUin.equals(str)) {
        break;
      }
      paramToServiceMsg = paramToServiceMsg.Ef.iterator();
      DingdongPluginBizObserver.a locala;
      do
      {
        if (!paramToServiceMsg.hasNext()) {
          break;
        }
        locala = (DingdongPluginBizObserver.a)paramToServiceMsg.next();
      } while (!locala.uin.equals(str));
      if (locala.dT != 2) {
        break label829;
      }
      paramToServiceMsg = "2";
      label620:
      i = 1;
      label623:
      if (i != 0) {
        break label836;
      }
      d(paramObject, "4", 0L, "getScheduleDetailReturnBackground2");
      return;
    }
    label653:
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.bytes_error_msg.has())) {}
    for (paramFromServiceMsg = paramFromServiceMsg.bytes_error_msg.get().toStringUtf8();; paramFromServiceMsg = null)
    {
      QLog.e("DingdongPluginBizHandler", 1, "reqSeq[" + paramToServiceMsg + "]0x592.FETCH_DETAIL rsp error retCode:" + i + ",retMsg:" + paramFromServiceMsg + ", seq = " + l);
      if (i == 49)
      {
        paramToServiceMsg = new DingdongPluginBizObserver.i();
        if (paramToServiceMsg.summaryData == null) {
          paramToServiceMsg.summaryData = new DingdongPluginDataFactory.ScheduleSummaryData();
        }
        paramToServiceMsg.summaryData.id = paramObject;
        paramToServiceMsg.summaryData.specialFlag = -1;
        notifyUI(14, true, paramToServiceMsg);
        if ((this.app == null) || (TextUtils.isEmpty(paramObject)) || (sU(paramObject))) {
          break;
        }
        d(paramObject, "4", 0L, "getScheduleDetailReturnBackground1");
        return;
        label829:
        paramToServiceMsg = "1";
        break label620;
        label836:
        d(paramObject, paramToServiceMsg, 0L, "getScheduleDetailReturnBackground3");
        return;
        i = 0;
        paramToServiceMsg = paramFromServiceMsg;
        break label623;
      }
      paramToServiceMsg = null;
      break label471;
      label858:
      break;
    }
  }
  
  private void nP(List<oidb_0x51d.AppNoticeInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    label7:
    if (i < paramList.size())
    {
      Object localObject = (oidb_0x51d.AppNoticeInfo)paramList.get(i);
      long l = ((oidb_0x51d.AppNoticeInfo)localObject).opt_uint64_appdid.get();
      localObject = (oidb_0x51d.NoticeInfo)((oidb_0x51d.AppNoticeInfo)localObject).opt_msg_app_notice.get();
      j = ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_count.get();
      ((oidb_0x51d.NoticeInfo)localObject).opt_uint32_notice_version.get();
      if (l == 1800000002L) {
        i = j;
      }
    }
    for (int j = 1;; j = 0)
    {
      paramList = (atnk)this.app.getManager(115);
      if (j != 0)
      {
        if (i <= 0) {
          break;
        }
        atne.a().S("officecenter_red_point_flag_" + this.app.getLongAccountUin(), true);
        paramList.aay(i);
        return;
        i += 1;
        break label7;
      }
      atne.a().S("officecenter_red_point_flag_" + this.app.getLongAccountUin(), false);
      paramList.aay(i);
      return;
      i = 0;
    }
  }
  
  private boolean sU(String paramString)
  {
    if (this.app == null) {}
    while (!this.app.b().Op()) {
      return false;
    }
    Object localObject = this.app.b().oA();
    int i = this.app.b().vc();
    localObject = this.app.b().k((String)localObject, i).iterator();
    MessageRecord localMessageRecord;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject).next();
    } while ((!(localMessageRecord instanceof MessageForDingdongSchedule)) || (!paramString.equals(((MessageForDingdongSchedule)localMessageRecord).getSummaryData().id)));
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void VD(boolean paramBoolean)
  {
    Object localObject = new oidb_0x8f9.ReqBody();
    oidb_0x8f9.GetLatestNodeInfoReq localGetLatestNodeInfoReq = new oidb_0x8f9.GetLatestNodeInfoReq();
    localGetLatestNodeInfoReq.uint32_node_type.set(1);
    PBUInt32Field localPBUInt32Field = localGetLatestNodeInfoReq.uint32_unread_count_flag;
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      localPBUInt32Field.set(i);
      ((oidb_0x8f9.ReqBody)localObject).msg_req_get_latest_node_info.set(localGetLatestNodeInfoReq, true);
      localObject = super.makeOIDBPkg("OidbSvc.0x8f9_13", 2297, 13, ((oidb_0x8f9.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).addAttribute("OidbSvc.0x8f9_13_subCmd", Integer.valueOf(1));
      super.sendPbReq((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(submsgtype0x8f.MsgBody paramMsgBody)
  {
    DingdongPluginBizObserver.b localb = new DingdongPluginBizObserver.b();
    try
    {
      localb.feedId = paramMsgBody.bytes_feeds_id.get().toStringUtf8();
      localb.sourceType = paramMsgBody.msg_source_id.uint32_source_type.get();
      localb.sourceId = String.valueOf(paramMsgBody.msg_source_id.uint64_source_code.get());
      localb.authorUin = String.valueOf(paramMsgBody.uint64_author_uin.get());
      localb.fromUin = String.valueOf(paramMsgBody.uint64_confirm_uin.get());
      localb.eqv = paramMsgBody.enum_msg_type.get();
      if (localb.errCode == 0)
      {
        bool = true;
        super.notifyUI(4, bool, localb);
        return;
      }
    }
    catch (NullPointerException paramMsgBody)
    {
      for (;;)
      {
        localb.errCode = -1;
        continue;
        boolean bool = false;
      }
    }
  }
  
  public void a(submsgtype0x93.MsgBody paramMsgBody)
  {
    boolean bool = true;
    int i = paramMsgBody.uint32_msg_type.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 2, "handlePushMsg_0x210_0x93:msgType[" + i + "].");
    }
    switch (i)
    {
    default: 
      return;
    case 1: 
      localObject = new DingdongPluginBizObserver.l();
      try
      {
        ((DingdongPluginBizObserver.l)localObject).unreadNum = paramMsgBody.msg_umc_changed.msg_umc.uint32_unread_count.get();
        ((DingdongPluginBizObserver.l)localObject).eqx = paramMsgBody.msg_umc_changed.msg_umc.uint32_data_version.get();
        if (((DingdongPluginBizObserver.l)localObject).errCode == 0)
        {
          bool = true;
          super.notifyUI(1, bool, localObject);
          return;
        }
      }
      catch (NullPointerException paramMsgBody)
      {
        for (;;)
        {
          QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x93_0x1 error:nullPointer[" + paramMsgBody.toString() + "].");
          ((DingdongPluginBizObserver.l)localObject).errCode = -1;
          continue;
          bool = false;
        }
      }
    }
    Object localObject = new DingdongPluginBizObserver.c();
    try
    {
      ((DingdongPluginBizObserver.c)localObject).updateType = paramMsgBody.msg_state_changed.enum_msg_type.get();
      ((DingdongPluginBizObserver.c)localObject).sourceType = paramMsgBody.msg_state_changed.msg_source_id.uint32_source_type.get();
      ((DingdongPluginBizObserver.c)localObject).sourceId = String.valueOf(paramMsgBody.msg_state_changed.msg_source_id.uint64_source_code.get());
      ((DingdongPluginBizObserver.c)localObject).feedId = paramMsgBody.msg_state_changed.bytes_feeds_id.get().toStringUtf8();
      ((DingdongPluginBizObserver.c)localObject).fromUin = String.valueOf(paramMsgBody.msg_state_changed.uint64_req_uin.get());
      paramMsgBody = paramMsgBody.msg_state_changed.rpt_msg_lite_mail_index.get();
      if ((paramMsgBody != null) && (paramMsgBody.size() > 0))
      {
        ((DingdongPluginBizObserver.c)localObject).Ee = new ArrayList();
        paramMsgBody = paramMsgBody.iterator();
        while (paramMsgBody.hasNext())
        {
          submsgtype0x93.LiteMailIndexInfo localLiteMailIndexInfo = (submsgtype0x93.LiteMailIndexInfo)paramMsgBody.next();
          DingdongPluginBizObserver.TempLiteMailIndexInfo localTempLiteMailIndexInfo = new DingdongPluginBizObserver.TempLiteMailIndexInfo();
          localTempLiteMailIndexInfo.feedId = localLiteMailIndexInfo.bytes_feeds_id.get().toStringUtf8();
          localTempLiteMailIndexInfo.sourceType = localLiteMailIndexInfo.msg_source_id.uint32_source_type.get();
          localTempLiteMailIndexInfo.ayz = localLiteMailIndexInfo.msg_source_id.uint64_source_code.get();
          ((DingdongPluginBizObserver.c)localObject).Ee.add(localTempLiteMailIndexInfo);
        }
      }
      if (((DingdongPluginBizObserver.c)localObject).errCode != 0) {}
    }
    catch (NullPointerException paramMsgBody)
    {
      ((DingdongPluginBizObserver.c)localObject).errCode = -1;
      QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x93_0x2 error:nullPointer[" + paramMsgBody.toString() + "].");
    }
    for (;;)
    {
      super.notifyUI(3, bool, localObject);
      return;
      bool = false;
    }
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody)
  {
    eug();
    int i = paramMsgBody.uint32_main_type.get();
    String str = paramMsgBody.bytes_workflow_id.get().toStringUtf8();
    boolean bool = atne.a().getBoolean("officecenter_mark_leave_activity", true);
    if (i == 1) {
      if (!bool)
      {
        paramMsgBody = new Intent();
        paramMsgBody.putExtra("reqCode", 4);
        paramMsgBody.putExtra("serviceType", i);
        atni.K(2, paramMsgBody);
      }
    }
    for (;;)
    {
      return;
      if (i == 2)
      {
        SubMsgType0x9b.PbOfficeNotify localPbOfficeNotify = new SubMsgType0x9b.PbOfficeNotify();
        paramMsgBody = paramMsgBody.bytes_ext_msg.get().toByteArray();
        try
        {
          localPbOfficeNotify.mergeFrom(paramMsgBody);
          int j = localPbOfficeNotify.opt_uint32_myoffice_flag.get();
          paramMsgBody = localPbOfficeNotify.rpt_uint64_appid.get();
          QLog.i("DingdongPluginBizHandler", 4, "0x210_0x9b push msg, serviceType: " + i + " workId: " + str + " flag: " + j + " id list: " + paramMsgBody.toString());
          if ((j == 1) && (bool)) {
            euh();
          }
          if (paramMsgBody.size() > 0)
          {
            paramMsgBody = new Intent();
            paramMsgBody.putExtra("reqCode", 4);
            paramMsgBody.putExtra("serviceType", i);
            paramMsgBody.putExtra("hasAppNotice", true);
            atni.K(2, paramMsgBody);
            nn(0L);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramMsgBody)
        {
          paramMsgBody.printStackTrace();
        }
      }
    }
  }
  
  public void a(SubMsgType0x9b.MsgBody paramMsgBody, boolean paramBoolean)
  {
    long l = paramMsgBody.uint64_app_id.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b. appid = " + l + "  beoffline = " + paramBoolean);
    }
    if (1800000000L == l) {
      a(paramMsgBody);
    }
    do
    {
      do
      {
        return;
      } while ((1800000002L != l) || (!paramMsgBody.uint32_main_type.has()) || (!paramMsgBody.uint32_sub_type.has()) || (paramMsgBody.uint32_main_type.get() != 100) || ((paramMsgBody.uint32_sub_type.get() != 1) && (paramMsgBody.uint32_sub_type.get() != 2)));
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void a(SubMsgType0x9c.MsgBody paramMsgBody, boolean paramBoolean)
  {
    int i = paramMsgBody.uint32_main_type.get();
    if (QLog.isColorLevel()) {
      QLog.i("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9c. mainType:" + i + "  subtype: " + paramMsgBody.uint32_sub_type.get());
    }
    switch (i)
    {
    }
    do
    {
      do
      {
        return;
      } while (paramMsgBody.uint32_sub_type.get() != 1);
      paramMsgBody = a(paramMsgBody.bytes_ext_msg.get().toByteArray(), paramBoolean);
    } while (paramMsgBody == null);
    QLog.e("DingdongPluginBizHandler", 1, "handlePushMsg_0x210_0x9b.100 error(-1):" + paramMsgBody + ".");
  }
  
  public void ba(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DingdongPluginBizHandler", 2, "getScheduleDetail workFlowId = " + paramString + " req =" + paramLong + ",serviceType = " + 3);
    }
    Object localObject = new oidb_0x592.GetScheduleByIDReq();
    ((oidb_0x592.GetScheduleByIDReq)localObject).bytes_workflow_id.set(ByteStringMicro.copyFrom(paramString.getBytes()), true);
    oidb_0x592.ReqBody localReqBody = new oidb_0x592.ReqBody();
    localReqBody.msg_appid.setHasFlag(true);
    localReqBody.msg_appid.uint64_appid.set(1800000002L);
    localReqBody.msg_appid.uint32_type.set(3);
    localReqBody.msg_get_schedule_by_id_req.set((MessageMicro)localObject, true);
    localObject = super.makeOIDBPkg("OidbSvc.0x592", 1426, 3, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).addAttribute("ReqSeq", Long.valueOf(paramLong));
    ((ToServiceMsg)localObject).addAttribute("scheduleid", paramString);
    ((ToServiceMsg)localObject).setTimeout(20000L);
    super.sendPbReq((ToServiceMsg)localObject);
  }
  
  public void euh()
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.app.getLongAccountUin());
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x51d_1", 1309, 1, localReqBody.toByteArray()));
  }
  
  public void nn(long paramLong)
  {
    oidb_0x51d.ReqBody localReqBody = new oidb_0x51d.ReqBody();
    localReqBody.setHasFlag(true);
    localReqBody.opt_uint64_handled_uin.set(this.app.getLongAccountUin());
    if (paramLong > 0L) {
      localReqBody.opt_uint64_office_appid.set(paramLong);
    }
    super.sendPbReq(super.makeOIDBPkg("OidbSvc.0x51d_2", 1309, 2, localReqBody.toByteArray()));
  }
  
  public Class<? extends acci> observerClass()
  {
    return DingdongPluginBizObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.getServiceCmd();
    if ("OidbSvc.0x8f6_1".equals(str)) {
      lN(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x8f9_13".equals(str))
      {
        lO(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_1".equals(str))
      {
        lQ(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x51d_2".equals(str))
      {
        lR(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_1".equals(str))
      {
        lP(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x589".equals(str))
      {
        lK(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x508_2".equals(str))
      {
        lL(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f2".equals(str))
      {
        lM(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x592".equals(str));
    lS(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atnf
 * JD-Core Version:    0.7.0.1
 */