import android.os.Handler;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.SelfInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ColumnInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.CountDetailInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.FollowCountInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.LimitInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.MedalInfo;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.ReqBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.RspBody;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SignIn;
import tencent.im.oidb.cmd0x97b.oidb_cmd0x97b.SimpleInfo;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetReq;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgGetRsp;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.ReqBody;
import tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.RspBody;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.GetFlagInfoReq;
import tencent.im.oidb.cmd0xe1b.oidb_0xe1b.ReqBody;

public class liw
  extends lir
{
  private Map<Integer, liw.b> ep = new ConcurrentHashMap();
  private volatile long uA;
  private volatile long uB;
  
  public liw(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "construct!");
    }
  }
  
  private ArrayList<kgj> a(List<oidb_cmd0x97b.MedalInfo> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oidb_cmd0x97b.MedalInfo localMedalInfo = (oidb_cmd0x97b.MedalInfo)paramList.next();
        kgj localkgj = new kgj();
        if (localMedalInfo.uint32_is_jump.has()) {
          localkgj.aIC = localMedalInfo.uint32_is_jump.get();
        }
        if (localMedalInfo.bytes_jump_url.has()) {
          localkgj.mJumpUrl = localMedalInfo.bytes_jump_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_medal_type.has()) {
          localkgj.aIB = localMedalInfo.uint32_medal_type.get();
        }
        if (localMedalInfo.uint64_medal_id.has()) {
          localkgj.rU = localMedalInfo.uint64_medal_id.get();
        }
        if (localMedalInfo.bytes_medal_name.has()) {
          localkgj.Za = localMedalInfo.bytes_medal_name.get().toStringUtf8();
        }
        if (localMedalInfo.bytes_medal_url.has()) {
          localkgj.Zb = localMedalInfo.bytes_medal_url.get().toStringUtf8();
        }
        if (localMedalInfo.uint32_pic_width.has()) {
          localkgj.mPicWidth = localMedalInfo.uint32_pic_width.get();
        }
        if (localMedalInfo.uint32_pic_height.has()) {
          localkgj.mPicHeight = localMedalInfo.uint32_pic_height.get();
        }
        localkgj.Zg = String.valueOf(paramLong);
        localArrayList.add(localkgj);
      }
    }
    QLog.d("SelfInfoModule", 1, "convertMedalInfo,count=" + localArrayList.size());
    return localArrayList;
  }
  
  private lhs a(oidb_cmd0x97b.ColumnInfo paramColumnInfo)
  {
    lhs locallhs = new lhs();
    locallhs.aPg = paramColumnInfo.uint32_video_count.get();
    locallhs.aPh = paramColumnInfo.uint32_column_count.get();
    locallhs.aPi = paramColumnInfo.uint32_subscribe_count.get();
    locallhs.aeX = paramColumnInfo.bytes_video_jump_url.get().toStringUtf8();
    locallhs.aeY = paramColumnInfo.bytes_column_jump_url.get().toStringUtf8();
    locallhs.aeZ = paramColumnInfo.bytes_subscribe_jump_url.get().toStringUtf8();
    return locallhs;
  }
  
  private void a(String paramString, int paramInt, liw.b paramb)
  {
    oidb_cmd0xbe4.ReqBody localReqBody = new oidb_cmd0xbe4.ReqBody();
    localReqBody.client_version.set("3.4.4");
    oidb_cmd0xbe4.MsgGetReq localMsgGetReq = new oidb_cmd0xbe4.MsgGetReq();
    if (Aladdin.getConfig(215).getIntegerFromString("message_reddot_style", 1) == 2)
    {
      QLog.d("SelfInfoModule", 2, "send0xbe4Req cardMode add flag!");
      localMsgGetReq.uint32_msg_content.set(1);
      if (!paramString.isEmpty()) {
        localMsgGetReq.str_msgid.set(paramString);
      }
    }
    localReqBody.msg_get_req.set(localMsgGetReq);
    paramString = lup.makeOIDBPkg("OidbSvc.0xbe4", 3044, 1, localReqBody.toByteArray());
    paramString.addAttribute("from", Integer.toString(paramInt));
    if (paramb != null) {
      this.ep.put(Integer.valueOf(paramString.getRequestSsoSeq()), paramb);
    }
    sendPbReq(paramString);
  }
  
  private void as(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "handle0x97bGetFollowAndFansCount!");
    }
    oidb_cmd0x97b.RspBody localRspBody = new oidb_cmd0x97b.RspBody();
    int j = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    int k = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_follow_count.get();
    int m = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).uint32_my_fans_count.get();
    paramFromServiceMsg = new ArrayList();
    Object localObject;
    if (((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.has())
    {
      paramToServiceMsg = ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).rpt_fans_detail_info.get().iterator();
      while (paramToServiceMsg.hasNext())
      {
        paramObject = (oidb_cmd0x97b.CountDetailInfo)paramToServiceMsg.next();
        if (paramObject.enum_type.get() == 1)
        {
          localObject = new liw.a();
          ((liw.a)localObject).businessId = paramObject.uint32_id.get();
          ((liw.a)localObject).businessType = 1;
          ((liw.a)localObject).businessName = paramObject.bytes_name.get().toStringUtf8();
          ((liw.a)localObject).afm = paramObject.bytes_icon_url.get().toStringUtf8();
          ((liw.a)localObject).jumpUrl = paramObject.bytes_url.get().toStringUtf8();
          ((liw.a)localObject).fansCount = paramObject.uint32_count.get();
          ((oidb_cmd0x97b.FollowCountInfo)localRspBody.msg_follow_count_info.get()).toByteArray();
          paramFromServiceMsg.add(localObject);
        }
      }
    }
    if ((localRspBody.msg_limit_info.has()) && (((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.has())) {}
    for (int i = ((oidb_cmd0x97b.LimitInfo)localRspBody.msg_limit_info.get()).uint32_forbidden_flag.get();; i = 0)
    {
      boolean bool;
      label468:
      long l1;
      label507:
      long l2;
      label546:
      label587:
      long l3;
      if (i == 1)
      {
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result=" + j + ", followCnt=" + k + ", fansCnt=" + m + ", isForbidden=" + bool);
        }
        paramObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_header_url.get().toStringUtf8();
        localObject = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_nick.get().toStringUtf8();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.has()) {
          break label902;
        }
        i = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).uint32_is_vip.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.has()) {
          break label908;
        }
        l1 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_like_total.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.has()) {
          break label916;
        }
        l2 = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).int64_publish_feeds_total.get();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.has()) {
          break label924;
        }
        paramToServiceMsg = ((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).bytes_desc.get().toStringUtf8();
        if (!((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.has()) {
          break label931;
        }
        l3 = ((oidb_cmd0x97b.SignIn)((oidb_cmd0x97b.SimpleInfo)localRspBody.msg_simpleinfo.get()).msg_sign_in.get()).int64_status.get();
        label635:
        if (QLog.isColorLevel()) {
          QLog.d("SelfInfoModule", 1, "handle0x97bGetFollowAndFansCount result userinfo=" + j + ", signinStatus=" + l3 + ", userDesc=" + paramToServiceMsg + ",userTotalLike=" + l1 + ",userTotalFeeds=" + l2);
        }
        awit.a(this.mApp, k, m, paramFromServiceMsg);
        awit.p(this.mApp, bool);
        awit.a(this.mApp, paramObject, (String)localObject, i, l1, l2, paramToServiceMsg, l3);
        paramToServiceMsg = null;
        if (localRspBody.msg_simpleinfo.rpt_msg_medal_info.has())
        {
          l1 = 0L;
          if (localRspBody.uint64_uin.has()) {
            l1 = localRspBody.uint64_uin.get();
          }
          paramToServiceMsg = a(localRspBody.msg_simpleinfo.rpt_msg_medal_info.get(), l1);
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.isEmpty())) {
          break label939;
        }
        awit.a(this.mApp, (kgj)paramToServiceMsg.get(0));
      }
      for (;;)
      {
        paramToServiceMsg = new lhs();
        if (localRspBody.msg_simpleinfo.msg_column_info.has()) {
          paramToServiceMsg = a(localRspBody.msg_simpleinfo.msg_column_info);
        }
        this.mMainThreadHandler.post(new SelfInfoModule.1(this, j, k, m, bool, paramToServiceMsg));
        return;
        bool = false;
        break;
        label902:
        i = -1;
        break label468;
        label908:
        l1 = -1L;
        break label507;
        label916:
        l2 = -1L;
        break label546;
        label924:
        paramToServiceMsg = "";
        break label587;
        label931:
        l3 = -1L;
        break label635;
        label939:
        awit.z(this.mApp);
      }
    }
  }
  
  private void at(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xbe4.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    paramObject = (liw.b)this.ep.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    if (i == 0)
    {
      paramFromServiceMsg = (oidb_cmd0xbe4.MsgGetRsp)((oidb_cmd0xbe4.RspBody)localObject).msg_get_rsp.get();
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = KandianMsgBoxRedPntInfo.createFromPB(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          localObject = kxm.getAppRuntime();
          if (localObject != null)
          {
            localObject = (KandianMergeManager)((AppRuntime)localObject).getManager(162);
            if (localObject != null)
            {
              QLog.d("SelfInfoModule", 1, "update msgbox : " + paramFromServiceMsg);
              if ((paramToServiceMsg.getAttribute("from") != null) && (paramToServiceMsg.getAttribute("from").toString().equals(Integer.toString(2)))) {
                paramFromServiceMsg.isFromNotification = true;
              }
              ((KandianMergeManager)localObject).a(paramFromServiceMsg);
            }
          }
        }
      }
    }
    for (paramToServiceMsg = paramFromServiceMsg;; paramToServiceMsg = null)
    {
      if (paramObject != null) {
        paramObject.b(paramToServiceMsg);
      }
      QLog.d("SelfInfoModule", 1, "handleGetMsgBoxResp, retCode : " + i);
      return;
    }
  }
  
  public void a(int paramInt, String paramString, liw.b paramb)
  {
    if (!((Boolean)awit.f("sp_msg_box_80a_enable_receive", Boolean.valueOf(true))).booleanValue())
    {
      QLog.d("SelfInfoModule", 1, "unable to show msgbox redpnt, give up send req !");
      return;
    }
    if (paramString.isEmpty())
    {
      if ((Aladdin.getConfig(186).getIntegerFromString("use_new_route", 0) == 1) && (paramInt == 0))
      {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer use new route, give up request!");
        return;
      }
      if (System.currentTimeMillis() - this.uA < 200L) {
        QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
      }
      this.uA = System.currentTimeMillis();
      a("", paramInt, paramb);
      QLog.d("SelfInfoModule", 1, "trigger get MsgRedPntReq, from " + paramInt);
      return;
    }
    if (System.currentTimeMillis() - this.uB < 200L) {
      QLog.d("SelfInfoModule", 2, "getMsgBoxRedPntInfoFromServer has excute now, give up !");
    }
    this.uB = System.currentTimeMillis();
    a(paramString, paramInt, paramb);
    QLog.d("SelfInfoModule", 1, "getMsgBoxRedPntInfoFromServerWithMsgId: from = " + paramInt + ", messageId = " + paramString);
  }
  
  public void aMD()
  {
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)awit.f("key_sp_readinjoy_youngster_last_pull_time", Long.valueOf(0L))).longValue();
    if (((Integer)awit.f("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue() == 0) {}
    for (int i = 1; (awce.g(l1, l2)) && (i == 0); i = 0) {
      return;
    }
    QLog.e("SelfInfoModule", 2, "updateSelfYoungsterModeSetting.");
    awit.H("key_sp_readinjoy_youngster_last_pull_time", Long.valueOf(l1));
    oidb_0xe1b.ReqBody localReqBody = new oidb_0xe1b.ReqBody();
    localReqBody.uint32_req_type.set(1);
    oidb_0xe1b.GetFlagInfoReq localGetFlagInfoReq = new oidb_0xe1b.GetFlagInfoReq();
    localGetFlagInfoReq.rpt_uint64_uin_list.add(Long.valueOf(this.mApp.getCurrentAccountUin()));
    localGetFlagInfoReq.uint32_need_teenager_flag.set(1);
    localReqBody.msg_get_flag_info_req.set(localGetFlagInfoReq);
    jnm.a((QQAppInterface)kxm.getAppRuntime(), new lix(this), localReqBody.toByteArray(), "OidbSvc.0xe1b", 3611, 1);
  }
  
  public void mS(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "getSelfInfo uin=" + paramString);
    }
    oidb_cmd0x97b.ReqBody localReqBody = new oidb_cmd0x97b.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(paramString);
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label52:
      break label52;
    }
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_req_ctrl_bits.set(3);
    localReqBody.uint32_like_total.set(1);
    localReqBody.uint32_sign_in.set(1);
    localReqBody.uint32_publish_feeds_total.set(1);
    localReqBody.uint32_medal.set(1);
    localReqBody.uint32_column_info.set(1);
    sendPbReq(lup.makeOIDBPkg("OidbSvc.0x97b", 2427, 1, localReqBody.toByteArray()));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SelfInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x97b")) {
      as(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbe4")) {
      return;
    }
    at(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public static class a
  {
    public String afm;
    public int businessId;
    public String businessName;
    public int businessType;
    public int fansCount;
    public String jumpUrl;
    
    public void V(JSONObject paramJSONObject)
      throws JSONException
    {
      this.businessId = paramJSONObject.getInt("businessId");
      this.businessType = paramJSONObject.getInt("businessType");
      this.businessName = paramJSONObject.getString("businessName");
      this.jumpUrl = paramJSONObject.getString("jumpUrl");
      this.afm = paramJSONObject.getString("businessIconUrl");
      this.fansCount = paramJSONObject.getInt("fansCount");
    }
    
    public JSONObject toJson()
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("businessId", this.businessId);
        localJSONObject.put("businessType", this.businessType);
        localJSONObject.put("businessName", this.businessName);
        localJSONObject.put("jumpUrl", this.jumpUrl);
        localJSONObject.put("businessIconUrl", this.afm);
        localJSONObject.put("fansCount", this.fansCount);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("SelfInfoModule", 1, "toJson error. " + localJSONException);
      }
      return localJSONObject;
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     liw
 * JD-Core Version:    0.7.0.1
 */