import Wallet.AcsAckMsgReq;
import Wallet.AcsAckMsgRsp;
import Wallet.AcsDelMsgReq;
import Wallet.AcsDelMsgRsp;
import Wallet.AcsGetMsgListReq;
import Wallet.AcsGetMsgListRsp;
import Wallet.AcsGetMsgReq;
import Wallet.AcsGetMsgRsp;
import Wallet.AcsHead;
import Wallet.AcsPullMsgReq;
import Wallet.AcsPullMsgRsp;
import Wallet.AcsSubNoticeReq;
import Wallet.AcsSubNoticeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderServlet.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

public class wih
  extends MSFServlet
{
  private static final String TAG = wih.class.getSimpleName();
  private static AppInterface mApp;
  
  private static AcsHead a()
  {
    AcsHead localAcsHead = new AcsHead();
    localAcsHead.model = aqgz.getModel();
    localAcsHead.platform = "Android";
    localAcsHead.version = aqgz.getQQVersion();
    return localAcsHead;
  }
  
  public static void a(int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver)
  {
    if (mApp == null) {
      return;
    }
    AcsGetMsgListReq localAcsGetMsgListReq = new AcsGetMsgListReq();
    localAcsGetMsgListReq.head = a();
    localAcsGetMsgListReq.uin = Long.parseLong(mApp.getCurrentAccountUin());
    localAcsGetMsgListReq.record_start = paramInt1;
    localAcsGetMsgListReq.record_size = paramInt2;
    NewIntent localNewIntent = new NewIntent(mApp.getApplication(), wih.class);
    localNewIntent.putExtra("req", localAcsGetMsgListReq);
    localNewIntent.putExtra("param_req_type", 2000);
    localNewIntent.setObserver(paramBusinessObserver);
    mApp.startServlet(localNewIntent);
  }
  
  private void a(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.DelMsg");
      paramBundle = (AcsDelMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("DelMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void a(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (mApp == null) {
      return;
    }
    AcsSubNoticeReq localAcsSubNoticeReq = new AcsSubNoticeReq();
    localAcsSubNoticeReq.head = a();
    localAcsSubNoticeReq.uin = Long.parseLong(mApp.getCurrentAccountUin());
    localAcsSubNoticeReq.msg_id = paramString1;
    localAcsSubNoticeReq.domain = paramString2;
    paramString1 = new NewIntent(mApp.getApplication(), wih.class);
    paramString1.putExtra("req", localAcsSubNoticeReq);
    paramString1.putExtra("param_req_type", 2002);
    paramString1.setObserver(paramBusinessObserver);
    mApp.startServlet(paramString1);
  }
  
  public static void a(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (mApp == null) {
      return;
    }
    AcsDelMsgReq localAcsDelMsgReq = new AcsDelMsgReq();
    localAcsDelMsgReq.head = a();
    localAcsDelMsgReq.uin = Long.parseLong(mApp.getCurrentAccountUin());
    localAcsDelMsgReq.msg_id = paramString;
    paramString = new NewIntent(mApp.getApplication(), wih.class);
    paramString.putExtra("req", localAcsDelMsgReq);
    paramString.putExtra("param_req_type", 2001);
    paramString.setObserver(paramBusinessObserver);
    mApp.startServlet(paramString);
  }
  
  private void b(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.GetMsgList");
      paramBundle = (AcsGetMsgListReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("GetMsgList");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void b(String paramString1, String paramString2, BusinessObserver paramBusinessObserver)
  {
    if (mApp == null) {
      return;
    }
    AcsGetMsgReq localAcsGetMsgReq = new AcsGetMsgReq();
    localAcsGetMsgReq.head = a();
    localAcsGetMsgReq.uin = Long.parseLong(mApp.getCurrentAccountUin());
    localAcsGetMsgReq.msg_id = paramString1;
    localAcsGetMsgReq.domain = paramString2;
    paramString1 = new NewIntent(mApp.getApplication(), wih.class);
    paramString1.putExtra("req", localAcsGetMsgReq);
    paramString1.putExtra("param_req_type", 2005);
    paramString1.setObserver(paramBusinessObserver);
    mApp.startServlet(paramString1);
  }
  
  public static void b(String paramString, BusinessObserver paramBusinessObserver)
  {
    if (mApp == null) {
      return;
    }
    AcsPullMsgReq localAcsPullMsgReq = new AcsPullMsgReq();
    localAcsPullMsgReq.head = a();
    localAcsPullMsgReq.uin = Long.parseLong(mApp.getCurrentAccountUin());
    localAcsPullMsgReq.day = paramString;
    paramString = new NewIntent(mApp.getApplication(), wih.class);
    paramString.putExtra("req", localAcsPullMsgReq);
    paramString.putExtra("param_req_type", 2003);
    paramString.setObserver(paramBusinessObserver);
    mApp.startServlet(paramString);
  }
  
  private void c(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.SubNotice");
      paramBundle = (AcsSubNoticeReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("SubNotice");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void clear()
  {
    mApp = null;
  }
  
  private void d(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.PullMsg");
      paramBundle = (AcsPullMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("PullMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  private void e(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.AckMsg");
      paramBundle = (AcsAckMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("AckMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public static void e(AppInterface paramAppInterface)
  {
    mApp = paramAppInterface;
  }
  
  private void f(Bundle paramBundle, Packet paramPacket)
  {
    if (mApp == null) {}
    ToServiceMsg localToServiceMsg;
    do
    {
      return;
      localToServiceMsg = new ToServiceMsg("mobileqq.service", mApp.getAccount(), "NoticeSvr.GetMsg");
      paramBundle = (AcsGetMsgReq)paramBundle.getSerializable("req");
      paramPacket.setServantName("Wallet.NoticeAccessServer.NoticeAccessObj");
      paramPacket.setFuncName("GetMsg");
      paramPacket.addRequestPacket("req", paramBundle);
      paramPacket.setSSOCommand(localToServiceMsg.getServiceCmd());
      paramPacket.setTimeout(15000L);
    } while (localToServiceMsg.isNeedCallback());
    paramPacket.setNoResponse();
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    int i = paramIntent.getIntExtra("param_req_type", 0);
    if (i == 0) {
      super.notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle, paramClass);
    }
    do
    {
      do
      {
        return;
      } while ((i == 1) && (!(paramIntent instanceof NewIntent)));
      paramIntent = ((NewIntent)paramIntent).getObserver();
    } while (paramIntent == null);
    ThreadManager.post(new QQReminderServlet.1(this, paramIntent, paramInt, paramBoolean, paramBundle), 5, null, true);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "cmd: " + (String)localObject1 + " ");
    }
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      return;
      if (((String)localObject1).equals("NoticeSvr.GetMsgList"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsGetMsgListRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgListRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2000, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2000, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.DelMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsDelMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsDelMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2001, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2001, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.SubNotice"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsSubNoticeRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsSubNoticeRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2002, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2002, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.PullMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsPullMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsPullMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2003, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2003, false, (Bundle)localObject1, null);
          return;
        }
      }
      if (((String)localObject1).equals("NoticeSvr.AckMsg"))
      {
        localObject1 = new Bundle();
        try
        {
          localObject2 = (AcsAckMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsAckMsgRsp());
          if (localObject2 != null) {
            ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
          }
          ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
          notifyObserver(paramIntent, 2004, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
          return;
        }
        catch (Exception paramFromServiceMsg)
        {
          notifyObserver(paramIntent, 2004, false, (Bundle)localObject1, null);
          return;
        }
      }
    } while (!((String)localObject1).equals("NoticeSvr.GetMsg"));
    localObject1 = new Bundle();
    try
    {
      localObject2 = (AcsGetMsgRsp)Packet.decodePacket(paramFromServiceMsg.getWupBuffer(), "rsp", new AcsGetMsgRsp());
      if (localObject2 != null) {
        ((Bundle)localObject1).putSerializable("rsp", (Serializable)localObject2);
      }
      ((Bundle)localObject1).putSerializable("req", paramIntent.getSerializableExtra("req"));
      notifyObserver(paramIntent, 2005, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, null);
      return;
    }
    catch (Exception paramFromServiceMsg)
    {
      notifyObserver(paramIntent, 2005, false, (Bundle)localObject1, null);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent == null) {
      return;
    }
    switch (paramIntent.getInt("param_req_type", 0))
    {
    default: 
      return;
    case 2000: 
      b(paramIntent, paramPacket);
      return;
    case 2001: 
      a(paramIntent, paramPacket);
      return;
    case 2002: 
      c(paramIntent, paramPacket);
      return;
    case 2003: 
      d(paramIntent, paramPacket);
      return;
    case 2004: 
      e(paramIntent, paramPacket);
      return;
    }
    f(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wih
 * JD-Core Version:    0.7.0.1
 */