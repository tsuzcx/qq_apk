import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg.GetCrmQQMenuRequest;
import com.tencent.crmqq.structmsg.StructMsg.RetInfo;
import com.tencent.crmqq.structmsg.StructMsg.SendMenuEventRequest;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.mp.mobileqq_mp.CRMSendLBSInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetUserEqqListResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

public class aceb
  extends accg
{
  public static final Long V = Long.valueOf(2202087152L);
  
  public aceb(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getEqqList: start");
    }
    mobileqq_mp.GetUserEqqListRequest localGetUserEqqListRequest = new mobileqq_mp.GetUserEqqListRequest();
    localGetUserEqqListRequest.version.set(1);
    localGetUserEqqListRequest.begin.set(aqft.ag(paramLong1));
    localGetUserEqqListRequest.limit.set(aqft.ag(paramLong2));
    localGetUserEqqListRequest.seqno.set(aqft.ag(paramLong3));
    ToServiceMsg localToServiceMsg = createToServiceMsg("EqqAccountSvc.get_eqq_list");
    localToServiceMsg.putWupBuffer(localGetUserEqqListRequest.toByteArray());
    localToServiceMsg.extraData.putLong("begin", paramLong1);
    localToServiceMsg.extraData.putLong("limit", paramLong2);
    localToServiceMsg.extraData.putLong("seqno", paramLong3);
    localToServiceMsg.extraData.putLong("time", paramLong4);
    sendPbReq(localToServiceMsg);
  }
  
  private void dv(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "handleGetList, ts=" + System.currentTimeMillis());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList begin.");
    }
    acje.b localb = new acje.b();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess()) || (paramObject == null))
    {
      localb.mErrCode = -1;
      localb.fV = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList error");
      }
      return;
    }
    int i = paramFromServiceMsg.getResultCode();
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handleGetList result=" + i);
    }
    if (i != 1000)
    {
      localb.mErrCode = -1;
      localb.fV = true;
      return;
    }
    long l1 = paramToServiceMsg.extraData.getLong("begin");
    paramToServiceMsg.extraData.getLong("seqno");
    long l2 = paramToServiceMsg.extraData.getLong("time");
    paramToServiceMsg = new mobileqq_mp.GetUserEqqListResponse();
    boolean bool;
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.ret_info.has()) || (!((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.has())) {
          continue;
        }
        i = ((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get();
        localb.mErrCode = i;
        if (i == 0) {
          continue;
        }
        localb.fV = true;
        bool = false;
      }
      catch (Exception paramToServiceMsg)
      {
        long l3;
        RecentUser localRecentUser;
        localb.mErrCode = -1;
        localb.fV = true;
        paramToServiceMsg.printStackTrace();
        bool = false;
        continue;
        continue;
        i = 0;
        continue;
        bool = false;
        continue;
      }
      notifyUI(100, bool, localb);
      ((PublicAccountHandler)this.app.getBusinessHandler(11)).notifyUI(100, true, localb);
      return;
      i = 0;
      continue;
      if (paramToServiceMsg.seqno.has())
      {
        i = paramToServiceMsg.seqno.get();
        l3 = aqft.K(i);
        paramFromServiceMsg = PublicAccountInfo.createPublicAccountInfoListFromEqq(paramToServiceMsg.accountInfo.get(), l2);
        localb.mList = paramFromServiceMsg;
        if ((!paramToServiceMsg.is_over.has()) || (!paramToServiceMsg.is_over.get())) {
          continue;
        }
        bool = true;
        localb.fV = bool;
        paramObject = ((acja)this.app.getManager(56)).c(paramFromServiceMsg, l2);
        i = 0;
        paramFromServiceMsg = this.app.a().a();
        paramObject = paramObject.iterator();
        if (paramObject.hasNext())
        {
          localRecentUser = paramFromServiceMsg.b(((PublicAccountInfo)paramObject.next()).getUin(), 0);
          if (localRecentUser != null)
          {
            paramFromServiceMsg.f(localRecentUser);
            i = 1;
          }
        }
        else
        {
          paramFromServiceMsg = this.app.getHandler(Conversation.class);
          if ((i != 0) && (paramFromServiceMsg != null)) {
            paramFromServiceMsg.sendEmptyMessage(1009);
          }
          if (!localb.fV) {
            if (!paramToServiceMsg.next_pos.has()) {
              break label602;
            }
          }
        }
      }
    }
    label596:
    label602:
    for (l1 = paramToServiceMsg.next_pos.get();; l1 += 20L)
    {
      c(l1, 20L, 0L, l2);
      break label596;
      hr(l3);
      bool = true;
      break;
    }
  }
  
  private void dw(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerGetMenu,begin.");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      try
      {
        int i = paramFromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
          QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handlerGetMenu. result=" + i);
        }
        if (i != 1000) {
          continue;
        }
        i = -1;
        paramToServiceMsg = new StructMsg.GetCRMMenuResponse();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          j = i;
          if (paramToServiceMsg.ret_info.has())
          {
            paramFromServiceMsg = (StructMsg.RetInfo)paramToServiceMsg.ret_info.get();
            if (paramFromServiceMsg.ret_code.has()) {
              i = paramFromServiceMsg.ret_code.get();
            }
            j = i;
            if (i != 0)
            {
              j = i;
              if (paramFromServiceMsg.err_info.has())
              {
                paramFromServiceMsg.err_info.get();
                if (i != 0) {
                  continue;
                }
                paramFromServiceMsg = String.valueOf(paramToServiceMsg.uin.get());
                i = paramToServiceMsg.seqno.get();
                afrx.a(this.app).a(this.app, paramFromServiceMsg, i, paramToServiceMsg);
                notifyUI(1, true, paramFromServiceMsg);
                return;
              }
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          for (;;)
          {
            int j;
            paramFromServiceMsg.printStackTrace();
            continue;
            i = j;
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg) {}
    }
  }
  
  /* Error */
  private void dx(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 31	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 33
    //   8: iconst_2
    //   9: ldc_w 367
    //   12: invokestatic 39	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +7 -> 23
    //   19: aload_2
    //   20: ifnonnull +4 -> 24
    //   23: return
    //   24: aload_2
    //   25: invokevirtual 158	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   28: sipush 1000
    //   31: if_icmpne -8 -> 23
    //   34: iconst_m1
    //   35: istore 4
    //   37: new 369	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse
    //   40: dup
    //   41: invokespecial 370	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_3
    //   47: checkcast 172	[B
    //   50: checkcast 172	[B
    //   53: invokevirtual 371	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   56: pop
    //   57: iload 4
    //   59: istore 5
    //   61: aload_1
    //   62: getfield 372	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:ret_info	Lcom/tencent/crmqq/structmsg/StructMsg$RetInfo;
    //   65: invokevirtual 331	com/tencent/crmqq/structmsg/StructMsg$RetInfo:has	()Z
    //   68: ifeq +76 -> 144
    //   71: aload_1
    //   72: getfield 372	com/tencent/crmqq/structmsg/StructMsg$SendMenuEventResponse:ret_info	Lcom/tencent/crmqq/structmsg/StructMsg$RetInfo;
    //   75: invokevirtual 332	com/tencent/crmqq/structmsg/StructMsg$RetInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   78: checkcast 330	com/tencent/crmqq/structmsg/StructMsg$RetInfo
    //   81: astore_1
    //   82: aload_1
    //   83: getfield 333	com/tencent/crmqq/structmsg/StructMsg$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   86: invokevirtual 193	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   89: ifeq +12 -> 101
    //   92: aload_1
    //   93: getfield 333	com/tencent/crmqq/structmsg/StructMsg$RetInfo:ret_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   96: invokevirtual 195	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   99: istore 4
    //   101: iload 4
    //   103: istore 5
    //   105: iload 4
    //   107: ifeq +37 -> 144
    //   110: iload 4
    //   112: istore 5
    //   114: aload_1
    //   115: getfield 337	com/tencent/crmqq/structmsg/StructMsg$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   118: invokevirtual 340	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   121: ifeq +23 -> 144
    //   124: aload_1
    //   125: getfield 337	com/tencent/crmqq/structmsg/StructMsg$RetInfo:err_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   128: invokevirtual 342	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   131: pop
    //   132: iload 4
    //   134: ifne -111 -> 23
    //   137: return
    //   138: astore_1
    //   139: return
    //   140: astore_2
    //   141: goto -84 -> 57
    //   144: iload 5
    //   146: istore 4
    //   148: goto -16 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	aceb
    //   0	151	1	paramToServiceMsg	ToServiceMsg
    //   0	151	2	paramFromServiceMsg	FromServiceMsg
    //   0	151	3	paramObject	Object
    //   35	112	4	i	int
    //   59	86	5	j	int
    // Exception table:
    //   from	to	target	type
    //   24	34	138	java/lang/Exception
    //   37	45	138	java/lang/Exception
    //   61	82	138	java/lang/Exception
    //   82	101	138	java/lang/Exception
    //   114	132	138	java/lang/Exception
    //   45	57	140	java/lang/Exception
  }
  
  private void dy(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): BEGIN");
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
        paramToServiceMsg = new mobileqq_mp.CRMSendLBSInfoResponse();
      }
    }
    else
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret_info.has()) && (((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.has()))
        {
          i = ((mobileqq_mp.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get();
          QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): errCode=" + i);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          continue;
          int i = -1;
        }
      }
    }
    QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "handelCrmSendLBSInfo(): FAILED");
  }
  
  private long eR()
  {
    return this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getLong("eqq_data_seq2", 0L);
  }
  
  private void hr(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit();
    localEditor.putLong("eqq_data_seq2", paramLong);
    localEditor.commit();
  }
  
  public void DC(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: start");
    }
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramString = new StructMsg.GetCrmQQMenuRequest();
      paramString.seqno.set(0);
      paramString.uin.set(l);
      ToServiceMsg localToServiceMsg = createToServiceMsg("mq_crm.get_menu");
      localToServiceMsg.putWupBuffer(paramString.toByteArray());
      sendPbReq(localToServiceMsg);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "getMenu: arg uin error.");
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3, BusinessObserver paramBusinessObserver)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      paramString = new NewIntent(this.app.getApplication().getApplicationContext(), kbs.class);
      paramString.putExtra("cmd", "set_function_flag");
      mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
      localSetFunctionFlagRequset.luin.set(l);
      localSetFunctionFlagRequset.type.set(paramInt1);
      localSetFunctionFlagRequset.value.set(paramInt2);
      localSetFunctionFlagRequset.account_type.set(paramInt3);
      localSetFunctionFlagRequset.version.set(1);
      paramString.putExtra("data", localSetFunctionFlagRequset.toByteArray());
      paramString.setObserver(paramBusinessObserver);
      this.app.startServlet(paramString);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString1, String paramString2, int paramInt, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: start");
    }
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg error.");
      }
      return;
    }
    try
    {
      long l = Long.valueOf(paramString1).longValue();
      paramString1 = new StructMsg.SendMenuEventRequest();
      paramString1.uin.set(l);
      paramString1.key.set(paramString2);
      paramString1.type.set(paramInt);
      paramString1.is_need_lbs.set(paramBoolean);
      if (paramBoolean)
      {
        paramString1.latitude.set(paramDouble1);
        paramString1.longitude.set(paramDouble2);
      }
      paramString2 = createToServiceMsg("mq_crm.send_key");
      paramString2.putWupBuffer(paramString1.toByteArray());
      sendPbReq(paramString2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "sendMenuEvent: arg uin error.");
      }
      paramString1.printStackTrace();
    }
  }
  
  public void hq(long paramLong)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("crmtest", 4, "getEqqList, ts=" + System.currentTimeMillis());
    }
    c(0L, 20L, eR(), paramLong);
  }
  
  protected Class<? extends acci> observerClass()
  {
    return acec.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ((str == null) || (str.length() == 0)) {}
    do
    {
      return;
      if ("mq_crm.get_menu".equalsIgnoreCase(str))
      {
        dw(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("mq_crm.send_key".equalsIgnoreCase(str))
      {
        dx(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("EqqAccountSvc.get_eqq_list".equalsIgnoreCase(str))
      {
        dv(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("CrmSvcEx.ReportLbs".equalsIgnoreCase(str))
      {
        dy(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.enterprise.EnterpriseQQHandler", 2, "cmdfilter error=" + str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aceb
 * JD-Core Version:    0.7.0.1
 */