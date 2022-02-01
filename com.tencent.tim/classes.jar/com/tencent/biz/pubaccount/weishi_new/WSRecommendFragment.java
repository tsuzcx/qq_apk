package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stGlobalConfig;
import UserGrowth.stH5OpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNotificationRsp;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import adak;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import ankt;
import arlc;
import aryy;
import auwm;
import auwt;
import auwz;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.event.ForeBackgroundEvent;
import com.tencent.biz.pubaccount.weishi_new.event.LikeRspEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WeiShiNoticeView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import com.tencent.widget.pull2refresh.XRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map<Ljava.lang.Integer;LUserGrowth.stSimpleMetaFeed;>;
import java.util.Map<Ljava.lang.Integer;Ljava.lang.String;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lcr;
import mqq.os.MqqHandler;
import noy;
import oev;
import ofp;
import ofv;
import ofw;
import ofx;
import ofy;
import ofz;
import oga;
import ogb;
import ogc;
import ogd;
import ogj;
import ogk;
import ogr;
import ohy;
import oiu;
import oiv;
import oix;
import ojk;
import okp;
import okw;
import omc;
import omy.a;
import omy.b;
import ond;
import ong;
import onk;
import oop;
import oow;
import ooz;
import opa;
import opb;
import opn;
import opn.a;
import org.json.JSONObject;
import rpw;
import rwv;
import rwx;
import tlo;
import tlo.a;

public class WSRecommendFragment
  extends WSBaseHomeFragment<omy.b, omy.a, List<stSimpleMetaFeed>>
  implements oix, omy.b, rwx
{
  private stNotificationRsp jdField_a_of_type_UserGrowthStNotificationRsp;
  private InternetDynamicBroadCastReceiver jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver;
  private WeiShiNoticeView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView;
  private ofv jdField_a_of_type_Ofv;
  private oow jdField_a_of_type_Oow;
  public opn.a a;
  public FrameLayout av;
  private boolean awN;
  private boolean awO;
  private boolean awT;
  private boolean awU;
  private boolean awV;
  private stGlobalConfig jdField_b_of_type_UserGrowthStGlobalConfig;
  private WSRedDotPushMsg jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg;
  private oev jdField_b_of_type_Oev;
  private int beQ;
  private volatile HashMap<Integer, String> eJ = new HashMap();
  private boolean en;
  private LinearLayout eu;
  private Map<Integer, stSimpleMetaFeed> fe = new ConcurrentHashMap();
  private Map<Integer, String> ff = new ConcurrentHashMap();
  private long fq;
  private Handler mHandler;
  private View mLoadingView;
  private ViewGroup mRootView;
  private String mRowKey;
  private long mStartTime;
  private long yH;
  private long yI;
  private long yJ;
  
  public WSRecommendFragment()
  {
    this.jdField_a_of_type_Opn$a = new ofw(this);
  }
  
  private int a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return 102;
    }
    switch (paramstNotificationRsp.type)
    {
    case 4: 
    case 5: 
    default: 
      return 102;
    case 1: 
    case 2: 
    case 3: 
      return 101;
    }
    return 103;
  }
  
  @NonNull
  private WSDownloadParams a(int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = paramInt;
    localWSDownloadParams.mEventId = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    localWSDownloadParams.mTestId = opn.getSceneTypeTestId(4);
    stReportItem localstReportItem = ond.getInitialReportItem();
    localstReportItem.pagetype = 4;
    localstReportItem.optype = 115;
    localWSDownloadParams.mStReportItem = localstReportItem;
    localWSDownloadParams.mScheme = a(this.jdField_a_of_type_UserGrowthStNotificationRsp);
    return localWSDownloadParams;
  }
  
  private String a(stNotificationRsp paramstNotificationRsp)
  {
    if (paramstNotificationRsp == null) {
      return "weishi://main";
    }
    if (!TextUtils.isEmpty(paramstNotificationRsp.scheme_url)) {
      return paramstNotificationRsp.scheme_url;
    }
    switch (paramstNotificationRsp.type)
    {
    default: 
      return "weishi://main";
    case 1: 
    case 2: 
    case 3: 
      return "weishi://message";
    case 4: 
      return "weishi://main";
    case 6: 
      return "weishi://main";
    }
    return "weishi://main";
  }
  
  private String a(boolean paramBoolean, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str1;
    String str2;
    if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null)
    {
      str1 = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mFeedIds;
      str2 = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mPushId;
    }
    for (boolean bool = opn.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);; bool = false)
    {
      if ((!paramBoolean) && (TextUtils.isEmpty(str1)) && (paramstSimpleMetaFeed != null)) {
        str1 = paramstSimpleMetaFeed.id;
      }
      for (;;)
      {
        int i;
        int j;
        if (bool)
        {
          i = ogr.a().ro();
          if (!bool) {
            break label158;
          }
          j = 1;
          label77:
          if (!paramBoolean) {
            break label164;
          }
        }
        label158:
        label164:
        for (int k = 1;; k = 2)
        {
          Object localObject = ond.a(paramstSimpleMetaFeed, 0);
          if (localObject != null) {
            localObject = ((stReportItem)localObject).authorid;
          }
          ong.n(301, new Object[] { Integer.valueOf(paramInt), ong.a(str2, str1, i, j, k) });
          WSPublicAccReport.getInstance().reportPublicAccDataExposure(paramstSimpleMetaFeed, j, k, i);
          return str1;
          i = 0;
          break;
          j = 0;
          break label77;
        }
      }
      str2 = "0";
      str1 = "";
    }
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (this.mHandler == null) {
      return;
    }
    this.mHandler.post(new WSRecommendFragment.6(this, paramInt, paramstSimpleMetaFeed));
  }
  
  private void a(stSimpleMetaFeed paramstSimpleMetaFeed, Integer paramInteger, stReportItem paramstReportItem, ArrayList<stReportItem> paramArrayList)
  {
    stH5OpInfo localstH5OpInfo = paramstSimpleMetaFeed.h5_op_info;
    if ((localstH5OpInfo != null) && (localstH5OpInfo.type > 0))
    {
      stReportItem localstReportItem = ond.a(paramstSimpleMetaFeed, paramInteger.intValue());
      if (localstH5OpInfo.type == 1) {}
      for (localstReportItem.pagetype = 9;; localstReportItem.pagetype = 14)
      {
        localstReportItem.optype = 6;
        paramArrayList.add(localstReportItem);
        ong.q(6, localstH5OpInfo.type, paramInteger.intValue(), paramstSimpleMetaFeed.h5_op_info.id);
        WSPublicAccReport.getInstance().reportOperationCard("gzh_exposure", 0, paramstSimpleMetaFeed);
        ooz.i("weishi-report", "luopan report H5");
        paramstReportItem.pagetype = 1;
        return;
      }
    }
    if (paramstSimpleMetaFeed.video_type == 6)
    {
      paramstReportItem.pagetype = 1;
      ong.qS(false);
      ooz.i("weishi-report", "luopan report NOW");
      return;
    }
    paramstReportItem.pagetype = 1;
    ooz.d("weishi-report", "luopan normal is no need report");
  }
  
  private void a(List<stSimpleMetaFeed> paramList, stGlobalConfig paramstGlobalConfig, String paramString, boolean paramBoolean)
  {
    int j = 1;
    if (paramstGlobalConfig != null) {
      ooz.e("WSRecommendFragment", "RockDownloader:" + paramstGlobalConfig.download);
    }
    for (int i = paramstGlobalConfig.link_strategy_type;; i = 1)
    {
      oiu.a().a(getActivity(), i, (stSimpleMetaFeed)paramList.get(0));
      oiu.a().beZ();
      if (i == 7)
      {
        if ((paramstGlobalConfig.jumpinfo == null) || (TextUtils.isEmpty(paramstGlobalConfig.jumpinfo.h5url))) {
          break label151;
        }
        ogj.aM(this.mContext, paramstGlobalConfig.jumpinfo.h5url);
      }
      label151:
      for (i = j;; i = 2)
      {
        ong.m(i, 2, paramString);
        do
        {
          return;
          if (i != 4) {
            break;
          }
        } while (!rpw.isWeishiInstalled(this.mContext));
        dy(paramList);
        return;
        dy(paramList);
        return;
      }
    }
  }
  
  private void b(Map<Integer, stSimpleMetaFeed> paramMap, Map<Integer, String> paramMap1)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new StringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3;
    if (paramMap.size() > 0)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject4 = (Map.Entry)paramMap.next();
        localObject3 = (Integer)((Map.Entry)localObject4).getKey();
        localObject4 = (stSimpleMetaFeed)((Map.Entry)localObject4).getValue();
        stReportItem localstReportItem = ond.a((stSimpleMetaFeed)localObject4, ((Integer)localObject3).intValue());
        a((stSimpleMetaFeed)localObject4, (Integer)localObject3, localstReportItem, (ArrayList)localObject2);
        localstReportItem.optype = 6;
        ooz.i("weishi-report", "推荐实时上报:" + localstReportItem.feedid + ", upos:" + localstReportItem.upos);
        ((ArrayList)localObject2).add(localstReportItem);
        localObject3 = opn.e((stSimpleMetaFeed)localObject4);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          ((StringBuilder)localObject1).append((String)localObject3);
          ((StringBuilder)localObject1).append("_");
          localStringBuilder.append("0");
          localStringBuilder.append("_");
        }
      }
      if (((StringBuilder)localObject1).length() <= 1) {
        break label591;
      }
    }
    label582:
    label591:
    for (paramMap = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1)
    {
      if (localStringBuilder.length() > 1) {
        localStringBuilder = new StringBuilder(localStringBuilder.substring(0, localStringBuilder.length() - 1));
      }
      for (;;)
      {
        ond.ce((ArrayList)localObject2);
        while (paramMap1.size() > 0)
        {
          localObject1 = new StringBuilder();
          paramMap1 = paramMap1.entrySet().iterator();
          for (;;)
          {
            if (paramMap1.hasNext())
            {
              localObject3 = (Map.Entry)paramMap1.next();
              localObject2 = (Integer)((Map.Entry)localObject3).getKey();
              localObject3 = (String)((Map.Entry)localObject3).getValue();
              ooz.i("weishi-report", "898实时上报:" + (String)localObject3 + ", upos:" + localObject2);
              if (!TextUtils.isEmpty((CharSequence)localObject3))
              {
                ((StringBuilder)localObject1).append((String)localObject3);
                ((StringBuilder)localObject1).append("_");
                continue;
                ooz.w("weishi-report", "推荐上报的feeds为0个");
                paramMap = (Map<Integer, stSimpleMetaFeed>)localObject1;
                break;
              }
            }
          }
          if (((StringBuilder)localObject1).length() <= 1) {
            break label582;
          }
        }
        for (paramMap1 = new StringBuilder(((StringBuilder)localObject1).substring(0, ((StringBuilder)localObject1).length() - 1));; paramMap1 = (Map<Integer, String>)localObject1)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("feedid", paramMap1.toString());
          ((Map)localObject1).put("cover_type", paramMap.toString());
          ((Map)localObject1).put("dynamic_cover", localStringBuilder.toString());
          paramMap = new JSONObject((Map)localObject1);
          ooz.w("weishi-report", "jsonObj:" + paramMap);
          ong.n(303, paramMap.toString());
          return;
          ooz.w("weishi-report", "898上报的feeds为0个");
          return;
        }
      }
    }
  }
  
  private void bea()
  {
    if (!this.en)
    {
      oni.bft = 2;
      return;
    }
    if ((!opn.axW) && (!this.awN) && (!this.awO))
    {
      oni.bft = 3;
      return;
    }
    oni.bft = 1;
  }
  
  private void beq()
  {
    lcr locallcr = opn.a();
    if (locallcr != null) {
      locallcr.aI(getActivity());
    }
  }
  
  private void ber()
  {
    oop.a().bfV();
    boolean bool = oop.a().Hd();
    QLog.i("QzoneVerticalVideoPluginApk", 1, "WSRecommendFragment onAttach start!! preloadInWsRecommend = " + bool);
    if (bool) {
      oop.a().bfT();
    }
  }
  
  private void bes()
  {
    ooz.e("weishi-report", "hasClickFuceng:" + opn.axW + ",mHasRefresh:" + this.awN + ",mHasScroll:" + this.awO);
    if ((!this.en) || ((!opn.axW) && (!this.awN) && (!this.awO))) {
      ond.a(137, 1, null);
    }
  }
  
  private void bet()
  {
    if (!ogk.awX)
    {
      this.fq = (System.currentTimeMillis() - this.yI);
      ooz.i("weishi-report", "用户退出公众号，一共使用:" + this.fq + "毫秒");
      this.yI = 0L;
    }
    ong.n(117, new Object[] { Long.valueOf(this.fq), Integer.valueOf(this.eJ.size()) });
    onk.a().a(this.fq, ((omy.a)b()).dr(), this.eJ.size(), opn.axW, opb.axV);
    bea();
    beu();
  }
  
  private void beu()
  {
    this.yH = 0L;
    this.yJ = 0L;
  }
  
  private void bev()
  {
    if (this.jdField_a_of_type_Oow != null)
    {
      this.jdField_a_of_type_Oow.bfW();
      this.jdField_a_of_type_Oow = null;
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler = null;
    }
  }
  
  private void bew()
  {
    ThreadManager.getSubThreadHandler().post(new WSRecommendFragment.9(this));
  }
  
  private void init()
  {
    aryy.a();
    ber();
    this.yH = System.currentTimeMillis();
    ooz.i("weishi-beacon", "进入瀑布流的时间：" + this.yH);
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("weishi_public_account_ding_state_change");
    ((IntentFilter)localObject).addAction("weishi_public_account_follow_state_change");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver = new InternetDynamicBroadCastReceiver();
    this.mContext.registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver, (IntentFilter)localObject);
    localObject = new tlo.a();
    tlo.a().a(this.mContext, (tlo.a)localObject);
    omc.setGdtArgs("");
    this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg = opn.b();
    this.mRowKey = opn.getRowKey();
    beq();
    rwv.a().a(this);
    oiv.a().a(this);
    this.yJ = System.currentTimeMillis();
    if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg == null) {}
    for (localObject = "";; localObject = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      oiu.a().start(this.mContext);
      ((omy.a)b()).pL((String)localObject);
      ((omy.a)b()).pM((String)localObject);
      try
      {
        this.jdField_a_of_type_Oow = new oow();
        localObject = this.jdField_a_of_type_Oow.d();
        if (!((HandlerThread)localObject).isAlive()) {
          ((HandlerThread)localObject).start();
        }
        this.mHandler = new Handler(((HandlerThread)localObject).getLooper());
        return;
      }
      catch (Exception localException)
      {
        ooz.d("WSRecommendFragment", "HandlerThread Exception.");
      }
    }
  }
  
  private void initViews()
  {
    this.av = ((FrameLayout)this.mRootView.findViewById(2131367152));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView = ((WeiShiNoticeView)LayoutInflater.from(this.mContext).inflate(2131560207, null));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.setOnClickListener(new ofx(this));
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView = ((XRecyclerView)this.mRootView.findViewById(2131376993));
    Object localObject = this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    if (localObject != null) {
      ((auwt)localObject).abv(12);
    }
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.setRefreshCallback(new ofy(this));
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().addOnScrollListener(new ofz(this));
    localObject = this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a();
    this.jdField_a_of_type_Ofv = new ofv(getActivity(), (RecyclerViewWithHeaderFooter)localObject);
    ((RecyclerViewWithHeaderFooter)localObject).setAdapter(this.jdField_a_of_type_Ofv);
    this.jdField_a_of_type_Ofv.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg);
    this.jdField_a_of_type_Ofv.a(new oga(this));
    ogc localogc = new ogc(2, 1);
    localogc.setGapStrategy(0);
    ((RecyclerViewWithHeaderFooter)localObject).setLayoutManager(localogc);
    ((RecyclerViewWithHeaderFooter)localObject).setItemAnimator(null);
    ((RecyclerViewWithHeaderFooter)localObject).addItemDecoration(new ofp());
    this.mLoadingView = this.mRootView.findViewById(2131373025);
    this.eu = ((LinearLayout)this.mRootView.findViewById(2131370766));
    int i = ankt.aC(this.mContext);
    if (i > 1920) {}
  }
  
  private void qB(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.yJ;
    ooz.w("weishi-report", "瀑布流拿到Notification的时间点：" + l1 + ",请求接口耗时：" + l2 + "毫秒");
    onk.a().u(paramBoolean, l2);
    this.yJ = 0L;
  }
  
  private void s(List<stSimpleMetaFeed> paramList, boolean paramBoolean)
  {
    if (this.mHandler == null) {
      return;
    }
    try
    {
      i = getLastVisiblePosition();
      int j = rl();
      i = i - j + 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        ooz.e("WSRecommendFragment", "exposeRefreshCard getLastVisiblePosition error: " + localException.getMessage());
        int i = 4;
      }
    }
    this.mHandler.post(new WSRecommendFragment.7(this, i, paramList, paramBoolean));
  }
  
  private void showErrorView()
  {
    ooz.d("WSRecommendFragment", "showErrorView");
    this.eu.setVisibility(0);
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(8);
    ond.a(135, 1, null);
    ong.qT(false);
    this.eu.setOnClickListener(new ogb(this));
  }
  
  protected RecyclerView.LayoutManager a()
  {
    return null;
  }
  
  protected auwm a()
  {
    return null;
  }
  
  @NonNull
  public omy.a a()
  {
    return new omc();
  }
  
  public void a(stNotificationRsp paramstNotificationRsp, okp paramokp)
  {
    this.jdField_a_of_type_UserGrowthStNotificationRsp = paramstNotificationRsp;
    qB(true);
    qC(true);
    oiu.uH(2);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView.b(paramstNotificationRsp, paramokp);
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if ((paramWSSimpleBaseEvent instanceof LikeRspEvent))
    {
      paramWSSimpleBaseEvent = (LikeRspEvent)paramWSSimpleBaseEvent;
      String str = paramWSSimpleBaseEvent.getFeedId();
      List localList = this.jdField_a_of_type_Ofv.be();
      if (localList != null)
      {
        int i = 0;
        if (i < localList.size())
        {
          stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)localList.get(i);
          int j;
          if (TextUtils.equals(localstSimpleMetaFeed.id, str)) {
            if (paramWSSimpleBaseEvent.getRspIsDing() != localstSimpleMetaFeed.is_ding)
            {
              if (localstSimpleMetaFeed.is_ding != 1) {
                break label134;
              }
              j = 1;
              label94:
              if (j == 0) {
                break label139;
              }
            }
          }
          label134:
          label139:
          for (localstSimpleMetaFeed.ding_count -= 1;; localstSimpleMetaFeed.ding_count += 1)
          {
            localstSimpleMetaFeed.is_ding = paramWSSimpleBaseEvent.getRspIsDing();
            this.jdField_a_of_type_Ofv.notifyItemChanged(i);
            i += 1;
            break;
            j = 0;
            break label94;
          }
        }
      }
    }
  }
  
  protected void a(XRecyclerView paramXRecyclerView, int paramInt) {}
  
  protected void a(XRecyclerView paramXRecyclerView, boolean paramBoolean) {}
  
  public void a(List<stSimpleMetaFeed> paramList, okp paramokp, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    ooz.bZ("WSRecommendFragment", "onLoadDataSuccess:" + paramList.size() + ", isFirstFromService:" + paramBoolean1);
    if (paramokp != null)
    {
      this.en = true;
      ooz.bZ("WSRecommendFragment", "onLoadDataSuccess AbTestId = " + paramokp.testId);
    }
    this.jdField_b_of_type_UserGrowthStGlobalConfig = ohy.a().a();
    ooz.i("WeishiDownloadUtil", "WeishiDownloadUtil link_strategy_type:" + this.jdField_b_of_type_UserGrowthStGlobalConfig.link_strategy_type);
    int i;
    if (paramBoolean1) {
      if (this.jdField_b_of_type_UserGrowthStGlobalConfig != null)
      {
        i = this.jdField_b_of_type_UserGrowthStGlobalConfig.link_strategy_type;
        paramokp = a(false, i, (stSimpleMetaFeed)paramList.get(0));
        a(paramList, this.jdField_b_of_type_UserGrowthStGlobalConfig, paramokp, paramBoolean4);
        if (!paramBoolean4) {
          break label260;
        }
        paramList.remove(0);
        this.jdField_a_of_type_Ofv.dx(paramList);
      }
    }
    for (;;)
    {
      if ((paramBoolean2) || (paramBoolean1))
      {
        this.beQ = paramList.size();
        if (!paramBoolean4) {
          s(paramList, paramBoolean1);
        }
      }
      if ((paramBoolean3) || (paramBoolean4)) {
        opn.t(paramList, true);
      }
      if (paramBoolean1)
      {
        opa.bfX();
        opa.uQ(ohy.a().rp());
      }
      return;
      i = 1;
      break;
      label260:
      hideLoading();
      this.eu.setVisibility(8);
      this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
      if (((omy.a)b()).Hc()) {
        this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.pn(true);
      }
      this.jdField_a_of_type_Ofv.D(paramList);
      ((omy.a)b()).b(false, false, "");
      continue;
      if (paramBoolean2)
      {
        this.eJ.clear();
        this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.pn(true);
        this.jdField_a_of_type_Ofv.D(paramList);
      }
      else
      {
        this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.ad(true, paramBoolean3);
        this.jdField_a_of_type_Ofv.dx(paramList);
      }
    }
  }
  
  protected void aCB() {}
  
  public void aG(int paramInt, String paramString)
  {
    ooz.d("WSRecommendFragment", "onGetNotificationFailed" + paramInt + " | " + paramString);
    this.yJ = 0L;
    oiu.uI(2);
  }
  
  protected void aS(Bundle paramBundle) {}
  
  protected void bdX()
  {
    super.bdX();
    if (this.isVisible) {
      opn.pQ("feeds");
    }
  }
  
  public void c(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    ooz.e("WSRecommendFragment", "onLoadDataFailed:" + paramInt + " | " + paramString);
    if (paramBoolean1)
    {
      if (((omy.a)b()).Hc())
      {
        this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.pn(false);
        return;
      }
      showErrorView();
      return;
    }
    if (paramBoolean2)
    {
      this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.pn(false);
      return;
    }
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.ad(false, true);
  }
  
  public void c(List<stSimpleMetaFeed> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.en = paramBoolean1;
    hideLoading();
    this.eu.setVisibility(8);
    this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.setVisibility(0);
    if (paramBoolean2) {
      a(true, -1, null);
    }
    if (paramBoolean1) {
      if (this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg != null) {
        break label104;
      }
    }
    label104:
    for (String str = "";; str = this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg.mMsgData)
    {
      ((omy.a)this.jdField_a_of_type_Oeu).a(false, true, true, str);
      s(paramList, false);
      this.jdField_a_of_type_Ofv.dx(paramList);
      this.beQ = paramList.size();
      this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.ad(true, true);
      return;
    }
  }
  
  protected void dr(View paramView)
  {
    this.mRootView = ((ViewGroup)paramView);
    initViews();
    init();
  }
  
  public void dy(List<stSimpleMetaFeed> paramList)
  {
    if (ogd.GI()) {
      return;
    }
    if (this.jdField_b_of_type_Oev == null) {
      this.jdField_b_of_type_Oev = new oev(getActivity());
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = (stSimpleMetaFeed)paramList.get(0);
      if (paramList != null)
      {
        paramList = "weishi://feed?feed_id=" + paramList.id;
        this.jdField_b_of_type_Oev.setScheme(paramList);
      }
    }
    this.jdField_b_of_type_Oev.a(this.jdField_b_of_type_UserGrowthStGlobalConfig);
    this.jdField_b_of_type_Oev.cp(getActivity());
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ForeBackgroundEvent.class);
    localArrayList.add(LikeRspEvent.class);
    return localArrayList;
  }
  
  protected int getLayoutResId()
  {
    return 2131560201;
  }
  
  public String getRowKey()
  {
    return this.mRowKey;
  }
  
  public void hideLoading()
  {
    this.mLoadingView.setVisibility(8);
  }
  
  public void ie() {}
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if (!this.awV)
    {
      this.awV = true;
      bet();
      bes();
      oiu.a().release();
      bew();
      bev();
      if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver != null) {
        this.mContext.unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSRecommendFragment$InternetDynamicBroadCastReceiver);
      }
      noy.a().clean();
      this.eJ.clear();
      if (this.jdField_a_of_type_Ofv != null)
      {
        List localList = this.jdField_a_of_type_Ofv.be();
        ogr.a().w(localList, this.beQ);
        if (this.jdField_a_of_type_Ofv.jdField_a_of_type_Oiq != null) {
          this.jdField_a_of_type_Ofv.jdField_a_of_type_Oiq = null;
        }
        if (this.jdField_a_of_type_Ofv.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper != null) {
          this.jdField_a_of_type_Ofv.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadRockDownloadListenerWrapper = null;
        }
      }
      rwv.a().b(this);
      oiv.a().b(this);
      opn.aD.clear();
      okw.fp.clear();
      ofv.beL = 0;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    arlc.sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true);
  }
  
  public void onPause()
  {
    super.onPause();
    adak.a(getActivity().app, "2062433139", 1, 4, System.currentTimeMillis() - this.mStartTime);
    if (this.isVisible) {
      WSPublicAccReport.getInstance().reportPageVisitExit("feeds");
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if (((paramSimpleBaseEvent instanceof ForeBackgroundEvent)) && (!getActivity().isFinishing()))
    {
      if (((ForeBackgroundEvent)paramSimpleBaseEvent).mIsBackground)
      {
        WSPublicAccReport.getInstance().backgroundPublicAccReport();
        bew();
      }
    }
    else {
      return;
    }
    WSPublicAccReport.getInstance().foregroundPublicAccReport();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!ogk.awX) {
      this.yI = System.currentTimeMillis();
    }
    for (;;)
    {
      ong.n(6, ong.a(this.jdField_b_of_type_ComTencentBizPubaccountWeishi_newPushWSRedDotPushMsg));
      if (this.yH > 0L)
      {
        long l = System.currentTimeMillis() - this.yH;
        this.yH = 0L;
        ooz.i("weishi-beacon", "瀑布流初始化耗时page init cost：" + l);
        ond.bfP();
        onk.a().s(true, l);
        onk.a().a(true, l, "feeds", "feeds");
      }
      arlc.sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), false);
      if (this.isVisible) {
        WSPublicAccReport.getInstance().reportPageVisitEnter("feeds");
      }
      ohy.a().pz("global_key_recommend");
      return;
      ogk.awX = false;
    }
  }
  
  public void qA(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView != null)
    {
      this.awT = paramBoolean;
      this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.aXj();
    }
  }
  
  public void qC(boolean paramBoolean)
  {
    this.awU = paramBoolean;
    if (paramBoolean) {
      ((auwz)this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).co(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
    for (;;)
    {
      ((auwz)this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).notifyDataSetChanged();
      return;
      ((auwz)this.jdField_b_of_type_ComTencentWidgetPull2refreshXRecyclerView.a().getAdapter()).cp(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWeiShiNoticeView);
    }
  }
  
  public void setData(List<stSimpleMetaFeed> paramList) {}
  
  public void showLoading(boolean paramBoolean)
  {
    this.mLoadingView.setVisibility(0);
  }
  
  public class InternetDynamicBroadCastReceiver
    extends BroadcastReceiver
  {
    public InternetDynamicBroadCastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent != null)
      {
        paramContext = paramIntent.getAction();
        if (!"weishi_public_account_ding_state_change".equals(paramContext)) {
          break label70;
        }
        i = paramIntent.getIntExtra("position", -1);
        j = paramIntent.getIntExtra("is_ding", -1);
        if ((i != -1) && (j != -1) && (WSRecommendFragment.a(WSRecommendFragment.this) != null)) {
          WSRecommendFragment.a(WSRecommendFragment.this).dz(i, j);
        }
      }
      label70:
      while (!"weishi_public_account_follow_state_change".equals(paramContext))
      {
        int i;
        int j;
        return;
      }
      ojk.e.poster.followStatus = paramIntent.getIntExtra("followStatus", 2);
      ooz.e("VerticalVideoLayerTopPresenter", "WSGridCardPresenter.clickFeed.poster.followStatus:" + ojk.e.poster.followStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */