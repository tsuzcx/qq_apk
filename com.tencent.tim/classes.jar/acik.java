import android.os.Build.VERSION;
import com.tencent.mobileqq.app.PPCLoginAuthHandler.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.comering_req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.comering_rsp;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.plat_info;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.req;
import com.tencent.pb.ppcloginauth.PPCLoginAuth.rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class acik
  extends accg
{
  public QQAppInterface app;
  private long commingRingId = 0L;
  
  public acik(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  public void cKU()
  {
    EntityManager localEntityManager = this.app.getEntityManagerFactory(this.app.getCurrentAccountUin()).createEntityManager();
    ExtensionInfo localExtensionInfo = (ExtensionInfo)localEntityManager.find(ExtensionInfo.class, this.app.getAccount());
    localEntityManager.close();
    if ((localExtensionInfo != null) && (localExtensionInfo.commingRingId != 0L))
    {
      this.commingRingId = localExtensionInfo.commingRingId;
      sendRequest();
    }
  }
  
  protected void cR(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramToServiceMsg = new PPCLoginAuth.rsp();
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.ret.get() == 0L) && (((PPCLoginAuth.comering_rsp)paramToServiceMsg.rspcmd_0x01.get()).ret.get() != 0)) {
          this.app.execute(new PPCLoginAuthHandler.1(this));
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  protected Class<? extends acci> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Loginauth.1".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("PPCLoginAuthHandler", 2, "onReceive called.");
      }
      cR(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void sendRequest()
  {
    Object localObject = this.app.getCurrentAccountUin();
    PPCLoginAuth.plat_info localplat_info = new PPCLoginAuth.plat_info();
    localplat_info.implat.set(109L);
    localplat_info.mqqver.set("3.4.4.3058");
    localplat_info.osver.set(Build.VERSION.RELEASE);
    PPCLoginAuth.comering_req localcomering_req = new PPCLoginAuth.comering_req();
    localcomering_req.id.set(String.valueOf(this.commingRingId));
    PPCLoginAuth.req localreq = new PPCLoginAuth.req();
    localreq.comm.set(localplat_info);
    localreq.reqcmd_0x01.set(localcomering_req);
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, "Loginauth.1");
    ((ToServiceMsg)localObject).putWupBuffer(localreq.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PPCLoginAuthHandler", 2, "sendPbReq called. req=" + localreq.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acik
 * JD-Core Version:    0.7.0.1
 */