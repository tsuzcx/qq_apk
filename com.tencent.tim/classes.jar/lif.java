import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.InterestLabelInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.struct.InterestLabelInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x6e4.oidb_cmd0x6e4.RspBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.ReqBody;
import tencent.im.oidb.cmd0x6e5.oidb_cmd0x6e5.RspBody;

public class lif
  extends lir
{
  private boolean akv;
  private HashMap<Integer, InterestLabelInfo> dV = new HashMap();
  private List<InterestLabelInfo> id = new ArrayList();
  
  public lif(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void aj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    oidb_cmd0x6e5.RspBody localRspBody = new oidb_cmd0x6e5.RspBody();
    boolean bool = false;
    if (lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody) == 0)
    {
      if (localRspBody.uint64_uin.has()) {
        localRspBody.uint64_uin.get();
      }
      if ((!localRspBody.rpt_uint32_default_interest_label_id_list.has()) || (localRspBody.rpt_uint32_default_interest_label_id_list.get() == null)) {
        break label195;
      }
    }
    label195:
    for (paramFromServiceMsg = localRspBody.rpt_uint32_default_interest_label_id_list.get();; paramFromServiceMsg = null)
    {
      paramToServiceMsg = localObject;
      if (localRspBody.rpt_interest_label_list.has())
      {
        paramToServiceMsg = localObject;
        if (localRspBody.rpt_interest_label_list.get() != null) {
          paramToServiceMsg = lum.b(localRspBody.rpt_interest_label_list.get(), paramFromServiceMsg);
        }
      }
      if ((this.akv) && ((!localRspBody.rpt_uint64_last_interest_label_id_list.has()) || (localRspBody.rpt_uint64_last_interest_label_id_list.get() == null) || (localRspBody.rpt_uint64_last_interest_label_id_list.get().size() <= 0)))
      {
        lcc.a().nc(true);
        bool = true;
      }
      for (;;)
      {
        p(bool, paramToServiceMsg);
        return;
        paramToServiceMsg = lum.b(null, null);
        continue;
        bool = true;
      }
    }
  }
  
  public void aEL()
  {
    this.id.clear();
  }
  
  public void aMw()
  {
    this.mExecutorService.execute(new InterestLabelInfoModule.1(this));
  }
  
  public void ak(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    qy(lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0x6e4.RspBody()));
  }
  
  public void cw(List<InterestLabelInfo> paramList)
  {
    if (this.mMainThreadHandler != null) {
      this.mMainThreadHandler.post(new InterestLabelInfoModule.5(this, paramList));
    }
  }
  
  public void e(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    oidb_cmd0x6e5.ReqBody localReqBody = new oidb_cmd0x6e5.ReqBody();
    long l = Long.valueOf(this.mApp.getCurrentAccountUin()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_req_all_interest_label_list.set(paramInt1);
    localReqBody.uint32_req_default_interest_label_id_list.set(paramInt2);
    localReqBody.uint32_req_last_interest_label_id_list.set(paramInt3);
    this.akv = paramBoolean;
    sendPbReq(lup.makeOIDBPkg("OidbSvc.0x6e5", 1765, 0, localReqBody.toByteArray()));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e5")) {
      aj(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x6e4")) {
      return;
    }
    ak(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void p(boolean paramBoolean, List<InterestLabelInfo> paramList)
  {
    if (paramList != null) {
      this.mMainThreadHandler.post(new InterestLabelInfoModule.3(this, paramList));
    }
  }
  
  public void qy(int paramInt)
  {
    this.mMainThreadHandler.post(new InterestLabelInfoModule.4(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lif
 * JD-Core Version:    0.7.0.1
 */