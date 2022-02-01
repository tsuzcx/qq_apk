import android.os.Handler;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.ReqBody;
import tencent.im.oidb.cmd0xe71.oidb_cmd0xe71.RspBody;

public class lii
  extends lir
{
  private lii.a a;
  
  public lii(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private ToServiceMsg a(long paramLong)
  {
    oidb_cmd0xe71.ReqBody localReqBody = new oidb_cmd0xe71.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.uint32_client_type.set(1);
    return lup.makeOIDBPkg("OidbSvc.0xe71", 3697, 1, localReqBody.toByteArray());
  }
  
  private void am(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xe71.RspBody();
    if ((lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (paramToServiceMsg.uint32_result.has()))
    {
      QLog.d("RIJUGCAccountCreateModule", 1, "handleUGCAccountCreateResponsePkg result = " + paramToServiceMsg.uint32_result.get());
      if (this.a != null) {
        this.a.ro(paramToServiceMsg.uint32_result.get());
      }
    }
  }
  
  public void a(long paramLong, lii.a parama)
  {
    QLog.d("RIJUGCAccountCreateModule", 1, "requestUserApproveInfo uin: " + paramLong);
    if (parama != null) {
      this.a = parama;
    }
    parama = a(paramLong);
    parama.addAttribute("KEY_UGC_USER_ACCOUNT_UIN", Long.valueOf(paramLong));
    sendPbReq(parama);
  }
  
  public void aEL()
  {
    this.a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe71")) {
      am(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void ro(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lii
 * JD-Core Version:    0.7.0.1
 */