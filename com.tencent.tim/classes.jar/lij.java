import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveStateReqBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.GetNumApproveStateRspBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.NumApproveStateItem;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.ReqBody;
import tencent.im.oidb.cmd0xb57.oidb_cmd0xb57.RspBody;

public class lij
  extends lir
{
  private lij.a a;
  
  public lij(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void an(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xb57.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.d("RIJUserApproveModule", 1, new Object[] { "handle0xb57UserInfo result = ", Integer.valueOf(i) });
    if ((i == 0) && (((oidb_cmd0xb57.RspBody)localObject).msg_get_num_approve_state_rsp.has()))
    {
      paramFromServiceMsg = ((oidb_cmd0xb57.RspBody)localObject).msg_get_num_approve_state_rsp.rpt_msg_num_approve_state_items.get();
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (oidb_cmd0xb57.NumApproveStateItem)paramFromServiceMsg.next();
          if ((paramObject != null) && (paramObject.uint64_query_num.has()))
          {
            localObject = (Long)paramToServiceMsg.getAttribute("KEY_USER_APPROVE_UIN");
            long l = paramObject.uint64_query_num.get();
            if ((l == ((Long)localObject).longValue()) && (paramObject.uint32_is_approve.has()))
            {
              QLog.d("RIJUserApproveModule", 1, "handle0xb57UserInfo state = " + paramObject.uint32_is_approve.get());
              localObject = ReadInJoyUserInfoModule.a(l, null);
              if (localObject != null) {
                ((ReadInJoyUserInfo)localObject).isApproved = paramObject.uint32_is_approve.get();
              }
              if (this.a != null) {
                this.a.pv(paramObject.uint32_is_approve.get());
              }
            }
          }
        }
      }
    }
  }
  
  private ToServiceMsg b(long paramLong)
  {
    oidb_cmd0xb57.ReqBody localReqBody = new oidb_cmd0xb57.ReqBody();
    localReqBody.uint32_oper.set(2);
    List localList = Arrays.asList(new Long[] { Long.valueOf(paramLong) });
    oidb_cmd0xb57.GetNumApproveStateReqBody localGetNumApproveStateReqBody = new oidb_cmd0xb57.GetNumApproveStateReqBody();
    localGetNumApproveStateReqBody.rpt_uint64_query_num.set(localList);
    localReqBody.msg_get_num_approve_state_req.set(localGetNumApproveStateReqBody);
    return lup.makeOIDBPkg("OidbSvc.0xb57", 2903, 16, localReqBody.toByteArray());
  }
  
  public void a(long paramLong, lij.a parama)
  {
    QLog.d("RIJUserApproveModule", 1, "requestUserApproveInfo uin: " + paramLong);
    if (parama != null) {
      this.a = parama;
    }
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, null);
    if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isApproved != -1)) {
      if (parama != null) {
        parama.pv(localReadInJoyUserInfo.isApproved);
      }
    }
    do
    {
      return;
      parama = b(paramLong);
    } while (parama == null);
    parama.addAttribute("KEY_USER_APPROVE_UIN", Long.valueOf(paramLong));
    sendPbReq(parama);
  }
  
  public void aEL()
  {
    this.a = null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb57")) {
      an(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void pv(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lij
 * JD-Core Version:    0.7.0.1
 */