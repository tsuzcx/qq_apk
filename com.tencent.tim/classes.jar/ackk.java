import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.remind.RemindPB.RemindItem;
import com.tencent.pb.remind.RemindPB.RemindQuota;
import com.tencent.pb.remind.RemindPB.ReqBody;
import com.tencent.pb.remind.RemindPB.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ackk
  extends accg
{
  public ackk(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private boolean ai(List<String> paramList)
  {
    return (paramList != null) && (paramList.size() > 0);
  }
  
  public void a(List<String> paramList1, int paramInt, List<String> paramList2)
  {
    RemindPB.ReqBody localReqBody = new RemindPB.ReqBody();
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramList1 = createToServiceMsg("SpecialRemind.Service");
        paramList1.putWupBuffer(localReqBody.toByteArray());
        sendPbReq(paramList1);
        return;
      }
      catch (Exception paramList1)
      {
        paramList1.printStackTrace();
        return;
      }
      localReqBody.uint32_method.set(1);
      continue;
      if ((ai(paramList1)) && (ai(paramList2)) && (paramList1.size() == paramList2.size()))
      {
        int j = paramList2.size();
        int i = 0;
        while (i < j)
        {
          RemindPB.RemindItem localRemindItem = new RemindPB.RemindItem();
          localRemindItem.uint64_uin.set(Long.parseLong((String)paramList1.get(i)));
          localRemindItem.uint32_id.set(Integer.parseInt((String)paramList2.get(i)));
          localReqBody.rep_set_info.add(localRemindItem);
          localReqBody.setHasFlag(true);
          i += 1;
        }
        localReqBody.uint32_method.set(paramInt);
        continue;
        if (ai(paramList1))
        {
          paramList1 = paramList1.iterator();
          while (paramList1.hasNext())
          {
            paramList2 = (String)paramList1.next();
            localReqBody.rep_clear_uin.add(Long.valueOf(Long.parseLong(paramList2)));
          }
          localReqBody.uint32_method.set(4);
        }
      }
    }
  }
  
  public void i(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      localObject1 = new RemindPB.RspBody();
      try
      {
        ((RemindPB.RspBody)localObject1).mergeFrom((byte[])paramObject);
        paramObject = localObject1;
      }
      catch (Exception paramObject)
      {
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("SpecialRemind.Service", 2, "handle send special sound exception:" + paramObject.getMessage());
            }
            paramObject.printStackTrace();
            paramObject = null;
            continue;
            if (paramObject.msg_quota.has())
            {
              paramObject = (RemindPB.RemindQuota)paramObject.msg_quota.get();
              if (paramObject.uint32_comm_quota.has()) {
                abbf.b(paramObject.uint32_comm_quota.get(), this.app);
              }
              if (paramObject.uint32_svip_quota.has()) {
                abbf.c(paramObject.uint32_svip_quota.get(), this.app);
              }
              abbf.bO(this.app);
              continue;
              if (paramObject.rep_set_info.has())
              {
                localObject1 = paramObject.rep_set_info.get();
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  paramObject = new ArrayList();
                  localObject1 = ((List)localObject1).iterator();
                  while (((Iterator)localObject1).hasNext())
                  {
                    localObject2 = (RemindPB.RemindItem)((Iterator)localObject1).next();
                    if ((((RemindPB.RemindItem)localObject2).uint64_uin.has()) && (((RemindPB.RemindItem)localObject2).uint32_id.has()))
                    {
                      str = String.valueOf(((RemindPB.RemindItem)localObject2).uint64_uin.get());
                      paramObject.add(str);
                      abbf.b(str, ((RemindPB.RemindItem)localObject2).uint32_id.get(), this.app);
                    }
                  }
                  abbf.b(paramObject, this.app);
                  continue;
                  if (paramObject.rep_clear_uin.has())
                  {
                    localObject1 = paramObject.rep_clear_uin.get();
                    paramObject = new ArrayList();
                    if ((localObject1 != null) && (((List)localObject1).size() > 0))
                    {
                      localObject1 = ((List)localObject1).iterator();
                      while (((Iterator)localObject1).hasNext())
                      {
                        localObject2 = String.valueOf((Long)((Iterator)localObject1).next());
                        paramObject.add(localObject2);
                        abbf.i((String)localObject2, this.app);
                      }
                      abbf.c(paramObject, this.app);
                    }
                  }
                }
              }
            }
          }
          if (i != 1) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.i("SpecialRemind.Service", 2, "get count fail.");
        return;
        int i = paramObject.int32_ret.get();
        notifyUI(1001, paramFromServiceMsg.isSuccess(), Integer.valueOf(i));
        return;
      }
      if ((paramObject != null) && (paramObject.uint32_method.has()))
      {
        i = paramObject.uint32_method.get();
        if (paramObject.int32_ret.has())
        {
          if (paramObject.int32_ret.get() != 0) {
            break label503;
          }
          switch (i)
          {
          default: 
            notifyUI(1000, paramFromServiceMsg.isSuccess(), Integer.valueOf(i));
          }
        }
      }
    }
    label503:
    do
    {
      return;
      Object localObject2;
      String str;
      if (QLog.isColorLevel()) {
        QLog.e("QVipSpeicalCareHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
      }
    } while (paramFromServiceMsg.isSuccess());
    arts.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, acfp.m(2131712790), true);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return ackl.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramToServiceMsg == null) || (paramToServiceMsg.length() == 0)) {}
    while (!"SpecialRemind.Service".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    i(paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     ackk
 * JD-Core Version:    0.7.0.1
 */