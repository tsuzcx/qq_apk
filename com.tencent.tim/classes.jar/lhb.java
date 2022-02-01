import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;

public class lhb
  extends lir
{
  public static int aJx = 10;
  public static int aJy;
  public static int aOL = 15;
  private ConcurrentHashMap<Integer, WeakReference<lhw.a>> bg = new ConcurrentHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> bh = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> j = new LinkedHashMap();
  private LinkedHashMap<Integer, Long> k = new LinkedHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> m = new LinkedHashMap();
  private LinkedHashMap<Integer, Pair<Integer, Integer>> n = new LinkedHashMap();
  private LinkedHashMap<Integer, Boolean> o = new LinkedHashMap();
  private final long ui = 86400000L;
  
  static
  {
    aJy = 10;
  }
  
  public lhb(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int dl(int paramInt)
  {
    int i = 1;
    Object localObject1 = new ArrayList();
    Object localObject2 = (ConcurrentHashMap)this.m.get(Integer.valueOf(paramInt));
    paramInt = i;
    if (localObject2 != null)
    {
      paramInt = i;
      if (((ConcurrentHashMap)localObject2).size() > 0)
      {
        localObject2 = ((ConcurrentHashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((AdvertisementInfo)((Iterator)localObject2).next());
        }
        Collections.sort((List)localObject1, new lhd(this));
        localObject1 = (AdvertisementInfo)((ArrayList)localObject1).get(0);
        paramInt = i;
        if (localObject1 != null)
        {
          paramInt = i;
          if (((AdvertisementInfo)localObject1).mAdKdPos <= 100) {
            if (!((AdvertisementInfo)localObject1).hasAddExposure) {
              break label132;
            }
          }
        }
      }
    }
    label132:
    for (paramInt = 1;; paramInt = 2) {
      return paramInt;
    }
  }
  
  private int getNetType()
  {
    switch (aqiw.getSystemNetwork(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i1 = 0;
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    int i3 = ((Integer)paramToServiceMsg.getAttribute(afk, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + i3);
    }
    int i2 = ((Integer)paramToServiceMsg.getAttribute(afl, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + i3);
    }
    if (i == 0) {
      if (!localRspBody.uint64_uin.has()) {
        break label572;
      }
    }
    label569:
    label572:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.mApp.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (i2 == 0)) {
          break label569;
        }
        i = i2;
      }
      for (;;)
      {
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null)) {
          a(paramToServiceMsg, paramFromServiceMsg, i3, i2, false);
        }
        for (;;)
        {
          knj.a().mt(true);
          if ((this.bg.containsKey(Integer.valueOf(i))) && (i1 == 0))
          {
            paramToServiceMsg = (WeakReference)this.bg.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((lhw.a)paramToServiceMsg.get()).rc(i);
            }
          }
          return;
          if (i3 == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! 重复曝光加载数据返回空");
            }
            i1 = 1;
          }
        }
        i1 = ((Integer)paramToServiceMsg.getAttribute(afi)).intValue();
        QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList Error result = " + i + " requestCount = " + i1);
        if ((i == 154) && (i1 == 1))
        {
          paramToServiceMsg.getAttributes().put(afi, Integer.valueOf(2));
          sendPbReq(paramToServiceMsg);
          return;
        }
        paramToServiceMsg = new JSONObject();
        try
        {
          paramToServiceMsg.put("svrresp_result", 1);
          paramToServiceMsg.put("svrresp_fail_type", 2);
          paramToServiceMsg.put("svrresp_fail_code", i);
          jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aET).b(jzk.aFD).b(paramToServiceMsg).a());
          return;
        }
        catch (JSONException paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
    }
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    int i = lup.parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (i != 0)
    {
      int i1 = ((Integer)paramToServiceMsg.getAttribute(afj)).intValue();
      if ((i == 154) && (i1 == 1))
      {
        paramToServiceMsg.getAttributes().put(afj, Integer.valueOf(2));
        sendPbReq(paramToServiceMsg);
      }
    }
  }
  
  private boolean x(AdvertisementInfo paramAdvertisementInfo)
  {
    boolean bool = false;
    if (paramAdvertisementInfo == null) {}
    while (TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) {
      return true;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList))
    {
      if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)) || (TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl))) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  public void M(int paramInt1, int paramInt2, int paramInt3)
  {
    Pair localPair = (Pair)this.n.get(Integer.valueOf(paramInt1));
    if (localPair == null) {
      localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    for (;;)
    {
      int i = paramInt3;
      if (paramInt2 != 0)
      {
        i = paramInt3;
        if (paramInt3 < ((Integer)localPair.second).intValue()) {
          i = ((Integer)localPair.second).intValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async setLocalAdvertisementRange channelid=" + paramInt1 + "  adStart=" + paramInt2 + "  adEnd=" + i);
      }
      localPair = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      this.n.remove(Integer.valueOf(paramInt1));
      this.n.put(Integer.valueOf(paramInt1), localPair);
      return;
    }
  }
  
  public void U(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "async setChannelNeedRequestAdvertisement channelid=" + paramInt + "  bNeed= " + paramBoolean);
    }
    this.o.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    return (Pair)this.n.get(Integer.valueOf(paramInt));
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.m.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      }
      return null;
    }
    return (AdvertisementInfo)localConcurrentHashMap.get(Integer.valueOf(paramInt2));
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(luq.b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, jys paramjys)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new tlm.a();
    ((tlm.a)localObject1).aJy = "ce2d9f";
    Object localObject3 = tlm.a(BaseApplication.getContext(), (tlm.a)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    long l;
    if (localObject3 != null)
    {
      localObject1 = ((tlm.b)localObject3).b;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.j.get(Integer.valueOf(paramInt1)) != null) {
        break label1131;
      }
      l = 0L;
      label115:
      ((PBUInt64Field)localObject2).set(l, true);
      localObject2 = new oidb_cmd0x68b.PhoneInfo();
      if ((localObject3 != null) && (((tlm.b)localObject3).b != null) && (((tlm.b)localObject3).b.muid != null) && (((tlm.b)localObject3).b.muid_type != null))
      {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((tlm.b)localObject3).b.muid.get()));
        ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((tlm.b)localObject3).b.muid_type.get());
      }
      localObject3 = kms.it();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
      }
      i = jxp.na();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
      i = 0;
    }
    try
    {
      int i1 = aqgz.LU();
      i = i1;
    }
    catch (Exception localException)
    {
      label258:
      break label258;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = aqgz.getDeviceOSVersion();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = aqgz.getQQVersion();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    int i = AppSetting.getAppId();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    localObject3 = cz.f(cz.s());
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(jzk.cZ()));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    if (localObject1 != null)
    {
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("AdvertisementInfoModule", 2, "makeReqAdvertisePara: deviceInfo: ma=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.get() + ", mm=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.get() + ", oa=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.get() + ", ta=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.get());
      }
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(kms.T(BaseApplication.getContext()).getBytes()));
    localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
    if (paramInt3 != paramInt4) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("adPosType", paramInt2);
        ((JSONObject)localObject1).put("adStartPos", paramInt3);
        ((JSONObject)localObject1).put("adEndPos", paramInt4);
        if ((paramjys != null) && (paramjys.yO()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramjys.aEw);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramjys.aEx);
          ((JSONObject)localObject1).put("KdPos", paramjys.aEy);
          ((JSONObject)localObject1).put("adPosId", paramjys.re);
        }
        if (!lke.b(paramb)) {
          continue;
        }
        ((JSONObject)localObject1).put("adRequestFlag", dl(paramInt1));
        if (this.k.get(Integer.valueOf(paramInt1)) != null) {
          continue;
        }
        l = 0L;
        ((JSONObject)localObject1).put("lastRefreshTime", l);
        if ((knj.a().zS()) && (paramInt2 == 1) && (knj.a().bc().size() > 0))
        {
          ((JSONObject)localObject1).put("superMaskType", 2);
          ((JSONObject)localObject1).put("reqList", new JSONArray(knj.a().bc()));
          knj.a().ms(false);
          knj.a().mt(false);
        }
        QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        if ((paramInt2 == 1) && (paramjys != null))
        {
          ((JSONObject)localObject1).put("videoPatchAdFlag", paramjys.aEz);
          ((JSONObject)localObject1).put("prePatchAdCount", paramjys.aEA);
          ((JSONObject)localObject1).put("postPatchAdCount", paramjys.aEB);
          ((JSONObject)localObject1).put("social_card_flag", paramjys.aEC);
        }
        if (anwa.aze()) {
          ((JSONObject)localObject1).put("reqLearningPatternFlag", 1);
        }
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        }
      }
      catch (JSONException paramb)
      {
        label1131:
        paramb.printStackTrace();
        continue;
      }
      paramb = new oidb_cmd0x68b.AdReqInfo();
      paramb.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(paramb);
      return localReqAdvertisePara;
      localObject1 = null;
      break;
      l = ((Long)this.j.get(Integer.valueOf(paramInt1))).longValue();
      break label115;
      l = ((Long)this.k.get(Integer.valueOf(paramInt1))).longValue();
      continue;
      ((JSONObject)localObject1).put("adRequestFlag", 0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, jys paramjys)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4);
    }
    if (!this.bg.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      lgy.a().qW(paramInt1);
    }
    if (this.bg.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.bg.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        lgy.a().qW(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(kxm.getAccount()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(getNetType());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramjys));
    Object localObject = lup.makeOIDBPkg("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(afg, Long.valueOf(paramInt3));
    if ((paramjys != null) && (paramjys.aEx == 1))
    {
      ((ToServiceMsg)localObject).getAttributes().put(afk, Integer.valueOf(paramjys.aEx));
      ((ToServiceMsg)localObject).getAttributes().put(afi, Integer.valueOf(0));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!kys.dv(paramInt1))
      {
        paramjys = (jys)localObject;
        if (!awit.ds(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(npr.eY("default_feeds")));
        paramjys = (jys)localObject;
        if (awit.aMU())
        {
          paramjys = lik.bo(paramInt1);
          if (!TextUtils.isEmpty(paramjys)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramjys));
          }
          paramjys = lup.makeOIDBPkg("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          paramjys.getAttributes().put("realTimeServiceKey", "default_feeds");
          paramjys.getAttributes().put(afg, Long.valueOf(paramInt3));
        }
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        paramjys.getAttributes().put(afl, Integer.valueOf(paramInt1));
        paramjys.getAttributes().put(afi, Integer.valueOf(0));
      }
      sendPbReq(paramjys);
      kbp.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      ((ToServiceMsg)localObject).getAttributes().put(afi, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, lhw.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.bg.put(Integer.valueOf(paramInt), new WeakReference(parama));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "doUninterestAdvertisement tagId=" + paramLong + ", channelId=" + paramAdvertisementInfo.mChannelID + ", pos=" + paramAdvertisementInfo.mAdKdPos + ", traceID=" + paramAdvertisementInfo.mAdTraceId);
      }
      if (!kni.v(paramAdvertisementInfo))
      {
        localObject1 = (ConcurrentHashMap)this.m.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
        if (localObject1 != null) {
          ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
        }
      }
    } while (paramBoolean);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject2 = localObject1;
      if (i < paramArrayList.size())
      {
        localObject2 = (DislikeInfo)paramArrayList.get(i);
        if (localObject2 == null) {
          break label367;
        }
        localObject2 = (String)localObject1 + ((DislikeInfo)localObject2).vf;
        localObject1 = localObject2;
        if (i != paramArrayList.size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
      }
    }
    label367:
    for (;;)
    {
      i += 1;
      break;
      if (paramAdvertisementInfo.mChannelID == 56L)
      {
        jzk.a(new kku.a().a(paramContext).a(jzk.aEL).b(jzk.aFx).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
      if (kxm.j(paramAdvertisementInfo)) {}
      for (i = jzk.aFB;; i = jzk.aFw)
      {
        jzk.a(new kku.a().a(paramContext).a(jzk.aEL).b(i).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("traceid", paramAdvertisementInfo.mAdTraceId);
      ((JSONObject)localObject1).put("rl", paramAdvertisementInfo.mAdRl);
      ((JSONObject)localObject1).put("productid", paramAdvertisementInfo.mAdProductId);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "native object is null");
        }
      }
      else
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoUrl", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("coverUrl", paramAdvertisementInfo.mVideoCoverUrl);
        localJSONObject.put("duration", paramAdvertisementInfo.mVideoDuration);
        ((JSONObject)localObject1).put("video", localJSONObject);
        ((JSONObject)localObject1).put("native", ((JSONObject)localObject2).getJSONObject("native"));
        localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("uin", paramAppInterface.getAccount());
        ((JSONObject)localObject1).put("type", 3);
        ((JSONObject)localObject1).put("ads", localObject2);
        localObject2 = ((JSONObject)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "get ad app json: " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
          localObject2 = new NewIntent(paramAppInterface.getApplication(), kbs.class);
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new lhe(this, paramAdvertisementInfo));
          paramAppInterface.startServlet((NewIntent)localObject2);
          return;
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramRspChannelArticle == null) {
      return;
    }
    int i = (int)paramRspChannelArticle.uint64_channel_id.get();
    if ((i == 0) && (paramInt2 != 0)) {
      i = paramInt2;
    }
    for (;;)
    {
      long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
      ArrayList localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + ",repeatedreqFlag=" + paramInt1);
      }
      int i2 = 0;
      long l2 = ((Long)paramToServiceMsg.getAttribute(afg)).longValue();
      int i1 = i;
      paramInt1 = i2;
      int i3;
      Object localObject2;
      Object localObject3;
      if (paramRspChannelArticle.rpt_advertise_list.has())
      {
        i1 = i;
        paramInt1 = i2;
        if (paramRspChannelArticle.rpt_advertise_list.get() != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + paramRspChannelArticle.rpt_advertise_list.get().size());
          }
          Iterator localIterator = paramRspChannelArticle.rpt_advertise_list.get().iterator();
          i3 = 0;
          paramInt1 = 0;
          i1 = 0;
          i2 = i;
          i = i1;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject2 = (articlesummary.ArticleSummary)localIterator.next();
              if ((((articlesummary.ArticleSummary)localObject2).msg_feeds_info.has()) && (((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get() != null) && (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.has()))
              {
                localObject3 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.get();
                if ((localObject3 != null) && (((articlesummary.PosAdInfo)localObject3).int32_ret.get() == 0))
                {
                  int i4 = ((articlesummary.PosAdInfo)localObject3).enum_pos_layout.get();
                  long l3 = ((articlesummary.PosAdInfo)localObject3).uint64_pos_id.get();
                  long l4 = ((articlesummary.PosAdInfo)localObject3).is_auto_play.get();
                  localObject3 = (articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject3).msg_ad_info.get();
                  i1 = i2;
                  if (localObject3 != null)
                  {
                    i1 = i2;
                    if (paramInt2 == 0)
                    {
                      i2 = (int)((articlesummary.AdInfo)localObject3).uint64_channel_id.get();
                      i1 = i2;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID from AdInfo:" + i2);
                        i1 = i2;
                      }
                    }
                  }
                  localObject3 = new AdvertisementInfo((articlesummary.AdInfo)localObject3);
                  knd.e((AdvertisementInfo)localObject3);
                  lum.a((articlesummary.ArticleSummary)localObject2, i1, 0, (ArticleInfo)localObject3);
                  ((AdvertisementInfo)localObject3).mAdFetchTime = l1;
                  ((AdvertisementInfo)localObject3).mAdPosLayout = i4;
                  ((AdvertisementInfo)localObject3).mAdPosID = l3;
                  ((AdvertisementInfo)localObject3).mADVideoAutoPlay = l4;
                  if ((l2 == -1L) && (i == 0) && (((AdvertisementInfo)localObject3).mAdvertisementExtInfo != null) && (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJw > 0))
                  {
                    aOL = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJw;
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosX= +" + aOL);
                    }
                    M(i1, 0, aOL);
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJy > 0)
                    {
                      aJy = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJy;
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosZ= +" + aJy);
                      }
                    }
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJx > 0)
                    {
                      aJx = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJx;
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosY= +" + aJx);
                      }
                    }
                    i = 1;
                    label698:
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo pos= +" + ((AdvertisementInfo)localObject3).mAdKdPos + "  info=" + ((AdvertisementInfo)localObject3).toString());
                    }
                    if (kxb.AG()) {
                      kxb.a().a((articlesummary.ArticleSummary)localObject2, (ArticleInfo)localObject3);
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "info.mAdExtInfo= +" + ((AdvertisementInfo)localObject3).mAdExtInfo);
                    }
                    for (;;)
                    {
                      try
                      {
                        bool = TextUtils.isEmpty(((AdvertisementInfo)localObject3).mAdExtInfo);
                        if (bool) {
                          continue;
                        }
                      }
                      catch (Exception localException3)
                      {
                        boolean bool;
                        JSONObject localJSONObject;
                        continue;
                        continue;
                      }
                      try
                      {
                        localJSONObject = new JSONObject(((AdvertisementInfo)localObject3).mAdExtInfo);
                        if (localJSONObject.has("adPosType"))
                        {
                          i2 = localJSONObject.getInt("adPosType");
                          if (i2 == 2)
                          {
                            i2 = 1;
                            paramInt1 = 1;
                          }
                        }
                      }
                      catch (Exception localException1)
                      {
                        try
                        {
                          QLog.d("AdvertisementInfoModule", 1, " adPosType ==2 , last advertisement, setChannelNeedRequestAdvertisement false");
                          i2 = paramInt1;
                          if (QLog.isColorLevel())
                          {
                            i2 = paramInt1;
                            QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo mAdExtInfo=" + localJSONObject.toString());
                          }
                          i2 = paramInt1;
                          knj.a().h((AdvertisementInfo)localObject3);
                          i2 = paramInt1;
                          if (kng.t((AdvertisementInfo)localObject3))
                          {
                            i3 = 1;
                            i2 = i1;
                            break;
                          }
                          i2 = paramInt1;
                          bool = kni.u((AdvertisementInfo)localObject3);
                          i2 = paramInt1;
                          if (!bool) {
                            continue;
                          }
                          i2 = i1;
                        }
                        catch (Exception localException2)
                        {
                          paramInt1 = i2;
                          continue;
                          continue;
                        }
                        localException1 = localException1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (paramInt2 = i1;; paramInt2 = i2)
      {
        if (i3 != 0)
        {
          if (localArrayList.size() != 0) {
            break;
          }
          paramToServiceMsg = new JSONObject();
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              paramToServiceMsg.put("svrresp_result", 1);
              paramToServiceMsg.put("svrresp_fail_type", 1);
              jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aET).b(jzk.aFD).b(paramToServiceMsg).a());
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
              return;
              i2 = paramInt1;
              paramInt1 = i2;
              i2 = i;
              if (l2 == -1L)
              {
                i2 = i;
                if (i == 0)
                {
                  i2 = i;
                  if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo != null)
                  {
                    i2 = i;
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJw > 0)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPos= +" + ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJw);
                      }
                      M(i1, 0, ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.aJw);
                      i2 = 1;
                    }
                  }
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo pos= +" + ((AdvertisementInfo)localObject3).mAdKdPos + "  info=" + ((AdvertisementInfo)localObject3).toString());
              }
              if (kxb.AG()) {
                kxb.a().a((articlesummary.ArticleSummary)localObject2, (ArticleInfo)localObject3);
              }
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "info.mAdExtInfo= +" + ((AdvertisementInfo)localObject3).mAdExtInfo);
              }
              if (!x((AdvertisementInfo)localObject3))
              {
                if (knc.a((AdvertisementInfo)localObject3, null)) {
                  localObject2 = new JSONObject();
                }
                try
                {
                  ((JSONObject)localObject2).put("svrresp_result", 0);
                  ((JSONObject)localObject2).put("svrresp_count", 1);
                  jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aET).b(jzk.aFD).a((AdvertisementInfo)localObject3).b((JSONObject)localObject2).a());
                  localArrayList.add(localObject3);
                  i = paramInt1;
                  paramInt1 = i2;
                  i2 = i;
                  i = paramInt1;
                  paramInt1 = i2;
                  i2 = i1;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    localJSONException.printStackTrace();
                  }
                }
              }
            }
            if ((QLog.isColorLevel()) && (localObject3 != null)) {
              QLog.d("AdvertisementInfoModule", 2, "filterAdvertisementInfo info = " + ((AdvertisementInfo)localObject3).toSString());
            }
            i = paramInt1;
            paramInt1 = i2;
            continue;
          }
          catch (JSONException paramRspChannelArticle)
          {
            paramRspChannelArticle.printStackTrace();
            continue;
          }
          if (paramRspChannelArticle.msg_ad_pos_map.has())
          {
            paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
            if (paramRspChannelArticle.bytes_ads_context.has())
            {
              jzk.lA(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
              if (paramInt1 != 0) {
                U(paramInt2, false);
              }
              this.j.put(Integer.valueOf(paramInt2), Long.valueOf(l1));
              if ((paramBoolean) && (l1 > 0L)) {
                this.k.put(Integer.valueOf(paramInt2), Long.valueOf(l1));
              }
              QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
              paramRspChannelArticle = (ConcurrentHashMap)this.m.get(Integer.valueOf(paramInt2));
              if (paramRspChannelArticle != null) {
                break label2433;
              }
              paramRspChannelArticle = new ConcurrentHashMap();
              this.m.put(Integer.valueOf(paramInt2), paramRspChannelArticle);
              if ((paramRspChannelArticle != null) && (QLog.isColorLevel())) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + paramInt2);
              }
              localObject1 = new ConcurrentHashMap();
              paramBoolean = lke.h(paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean);
              }
              if ((!paramBoolean) || (localArrayList.size() > 0)) {
                break label1934;
              }
            }
          }
          for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = paramRspChannelArticle)
          {
            if ((paramToServiceMsg != null) && (QLog.isColorLevel())) {
              QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramToServiceMsg.size());
            }
            localObject1 = paramToServiceMsg.values().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
              lbz.a().b(paramInt2, (BaseArticleInfo)localObject2);
            }
            jzk.lA("");
            break;
            jzk.lA("");
            i1 = paramInt2;
            paramInt2 = i1;
            break;
            label1934:
            if (l2 != -1L) {
              break label1948;
            }
          }
          label1948:
          localObject2 = localArrayList.iterator();
          for (;;)
          {
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject2).next();
            if (paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements info = " + paramToServiceMsg.toSString());
              }
              ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
              paramRspChannelArticle.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
            }
          }
          paramToServiceMsg.clear();
          paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + "\n");
          Object localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
            paramRspChannelArticle.put(Integer.valueOf(((AdvertisementInfo)localObject2).mAdKdPos), localObject2);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.append("[pos=").append(((AdvertisementInfo)localObject2).mAdKdPos).append(", traceID=").append(((AdvertisementInfo)localObject2).mAdTraceId).append("]\n");
            }
            if ((((AdvertisementInfo)localObject2).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdAppJson))) {
              a(this.mApp, (AdvertisementInfo)localObject2);
            }
          }
          if (paramToServiceMsg != null) {
            QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
          }
          if ((paramRspChannelArticle != null) && (QLog.isColorLevel())) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + paramInt2);
          }
          if (localArrayList.size() != 0) {
            break;
          }
          paramToServiceMsg = new JSONObject();
          try
          {
            paramToServiceMsg.put("svrresp_result", 1);
            paramToServiceMsg.put("svrresp_fail_type", 1);
            jzk.a(new kku.a().a(BaseApplication.getContext()).a(jzk.aET).b(jzk.aFD).b(paramToServiceMsg).a());
            QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
            return;
          }
          catch (JSONException paramRspChannelArticle)
          {
            for (;;)
            {
              paramRspChannelArticle.printStackTrace();
            }
          }
          label2433:
          break label698;
          i1 = paramInt1;
          paramInt1 = i;
          i = i1;
          i1 = i2;
        }
      }
    }
  }
  
  public void aEL()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.m.clear();
    this.j.clear();
    this.k.clear();
    this.bg.clear();
    this.bh.clear();
    kni.aEL();
    kng.aEL();
  }
  
  public void aMk()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
  
  public Pair<Integer, Integer> b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getPreloadAdvertisementAtPostion postion = " + paramInt2);
    }
    if (!dy(paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "   !needRequestAdvertisement ");
      }
      return null;
    }
    Pair localPair = (Pair)this.n.get(Integer.valueOf(paramInt1));
    if (localPair != null)
    {
      if (paramInt2 + aJx <= ((Integer)localPair.second).intValue()) {
        return null;
      }
      int i = ((Integer)localPair.second).intValue();
      int i1 = aJy + i;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "first = " + localPair.first + " second = " + localPair.second);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "  position=" + paramInt2 + "  startpos=" + i + "  endpos=" + i1);
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf(i1));
    }
    return null;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.m.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      }
      return null;
    }
    return (AdvertisementInfo)localConcurrentHashMap.remove(Integer.valueOf(paramInt2));
  }
  
  public int[] c(int paramInt)
  {
    ArrayList localArrayList = l(paramInt);
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return empty!");
      }
      return new int[0];
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((AdvertisementInfo)localArrayList.get(i)).mAdKdPos;
      localStringBuilder.append(arrayOfInt[i]);
      if (i != localArrayList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    }
    return arrayOfInt;
  }
  
  public boolean dy(int paramInt)
  {
    if (this.o.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.o.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return true;
  }
  
  public ArrayList<BaseArticleInfo> k(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPosArticleListSync channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(l(paramInt));
    return localArrayList;
  }
  
  public ArrayList<AdvertisementInfo> l(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ConcurrentHashMap)this.m.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new lhc(this));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      int i = 0;
      while (i < localArrayList.size())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
        ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append("]");
        if (i != localArrayList.size() - 1) {
          ((StringBuilder)localObject).append("\n");
        }
        i += 1;
      }
      QLog.d("AdvertisementInfoModule", 2, "loadChannelAdvertisement channelId=" + paramInt + ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if (!kni.an.get()) {
      kni.aEP();
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) || (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))) {
      w(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    x(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void rd(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "removeFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.bg.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lhb
 * JD-Core Version:    0.7.0.1
 */