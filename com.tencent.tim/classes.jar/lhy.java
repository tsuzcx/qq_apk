import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.8;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.FollowListInfo;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.ReqFollowPara;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspBody;
import tencent.im.oidb.cmd0x977.oidb_cmd0x977.RspFollowData;

public class lhy
  extends lir
{
  private String afb = "";
  private String afc = "";
  private String afd = "";
  private boolean akq = true;
  private boolean akr = true;
  private boolean aks = true;
  private List<mhg> hZ = new ArrayList();
  private List<mhf> ia = new ArrayList();
  private List<mhg> ib = new ArrayList();
  private long uu;
  private long uv;
  private long uw;
  
  public lhy(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = (Integer)paramToServiceMsg.getAttribute("attr_follow_list_type");
    QLog.i("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] reqType=" + localObject);
    paramToServiceMsg = new oidb_cmd0x977.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i != 0)
    {
      QLog.e("FollowingInfoModule", 1, "[handleGetFollowMemberListFromServer] result = " + i);
      if (((Integer)localObject).intValue() != 3) {}
    }
    while (!paramToServiceMsg.msg_rsp_follow_data.has())
    {
      this.mMainThreadHandler.post(new FollowListInfoModule.1(this));
      do
      {
        return;
      } while (((Integer)localObject).intValue() != 2);
      this.mMainThreadHandler.post(new FollowListInfoModule.2(this));
      return;
    }
    paramObject = paramToServiceMsg.msg_rsp_follow_data.msg_follow_list;
    localObject = paramObject.rpt_follow_status_info.get();
    paramFromServiceMsg = paramToServiceMsg.msg_rsp_follow_data.bytes_cookie.get().toStringUtf8();
    long l = paramToServiceMsg.msg_rsp_follow_data.uint64_total_count.get();
    if (paramToServiceMsg.msg_rsp_follow_data.uint32_is_no_more_data.get() == 0) {}
    for (boolean bool = true; paramObject.uint32_follow_list_type.get() == 3; bool = false)
    {
      paramToServiceMsg = mis.a((Iterable)localObject, new lhz(this));
      this.afc = paramFromServiceMsg;
      this.akr = bool;
      this.uv = l;
      this.ia.addAll(paramToServiceMsg);
      this.mMainThreadHandler.post(new FollowListInfoModule.4(this, paramToServiceMsg, l, bool));
      return;
    }
    if (paramObject.uint32_follow_list_type.get() == 1)
    {
      paramToServiceMsg = mis.a((Iterable)localObject, new lia(this));
      this.afd = paramFromServiceMsg;
      this.uw = l;
      this.aks = bool;
      this.ib.addAll(paramToServiceMsg);
      this.mMainThreadHandler.post(new FollowListInfoModule.6(this, paramToServiceMsg, l, bool));
      return;
    }
    paramToServiceMsg = mis.a((Iterable)localObject, new lib(this));
    this.afb = paramFromServiceMsg;
    this.uu = l;
    this.akq = bool;
    this.hZ.addAll(paramToServiceMsg);
    this.mMainThreadHandler.post(new FollowListInfoModule.8(this, paramToServiceMsg, l, bool));
  }
  
  public boolean Cm()
  {
    return this.akq;
  }
  
  public List<mhg> aP()
  {
    return this.hZ;
  }
  
  public void cO(int paramInt1, int paramInt2)
  {
    j(paramInt1, paramInt2, false);
  }
  
  public void j(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FollowingInfoModule", 0, "[requestFollowersListFromServer] mFollowingList=" + this.hZ + ", mFollowingListCookie=" + this.afb + ", listType=" + paramInt2);
    }
    oidb_cmd0x977.ReqBody localReqBody = new oidb_cmd0x977.ReqBody();
    localReqBody.uint64_uin.set(kxm.getLongAccountUin());
    oidb_cmd0x977.ReqFollowPara localReqFollowPara = new oidb_cmd0x977.ReqFollowPara();
    localReqFollowPara.op_type.set(2);
    localReqFollowPara.uint32_req_count.set(paramInt1);
    PBBytesField localPBBytesField = localReqFollowPara.bytes_cookie;
    Object localObject;
    if (paramInt2 == 2)
    {
      localObject = this.afb;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqFollowPara.uint32_follow_list_type.set(paramInt2);
      localObject = localReqFollowPara.uint32_need_kd_user_info;
      if (!paramBoolean) {
        break label222;
      }
    }
    label222:
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localReqFollowPara.uint32_no_check_friends.set(1);
      localReqBody.msg_req_follow_para.set(localReqFollowPara);
      localObject = lup.makeOIDBPkg("OidbSvc.0x977", 2423, 5, localReqBody.toByteArray());
      ((ToServiceMsg)localObject).addAttribute("attr_follow_list_type", Integer.valueOf(paramInt2));
      sendPbReq((ToServiceMsg)localObject);
      return;
      localObject = this.afd;
      break;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x977")) {
      ah(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhy
 * JD-Core Version:    0.7.0.1
 */