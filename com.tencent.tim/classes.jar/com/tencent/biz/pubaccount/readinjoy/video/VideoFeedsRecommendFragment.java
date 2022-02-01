package com.tencent.biz.pubaccount.readinjoy.video;

import acfd;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import aqcx;
import aqgv;
import aqho;
import aqiw;
import aqux;
import awit;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.ECommerceEntranceInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import jzk;
import jzu;
import jzv;
import kbp;
import kcp;
import kcq;
import kcr;
import kcs;
import kct;
import knc;
import kxm;
import kxy;
import lgv.b;
import mqq.app.MobileQQ;
import mrp;
import mrr;
import mrx;
import mrz;
import mss;
import msv;
import mtg;
import mtg.b;
import mtg.d;
import mtg.e;
import mtg.g;
import mtg.k;
import mtg.l;
import mtw;
import mtw.a;
import mud;
import muj;
import mve;
import mvh;
import mvn;
import mvy;
import mvz;
import mwa;
import mwb;
import mwc;
import mwc.a;
import mwe;
import mwi;
import mwj;
import mwl;
import mxi;
import mxm;
import mxu;
import mxu.a;
import mxy;
import myc;
import myc.b;
import myc.c;
import myi;
import mzj;
import mzn;
import naa;
import nce;
import nce.a;
import oep;
import oeq;
import txn;

public class VideoFeedsRecommendFragment
  extends ReportV4Fragment
  implements VideoFeedsRecyclerView.a, mtg.d, mwc.a, mxu.a
{
  private static int aVo;
  private HashSet<VideoInfo> P = new HashSet();
  private HashSet<String> Q;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private ADVideoAppDownloadManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager;
  private VideoFeedsPlayManager.d jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d;
  private e jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$e;
  private f jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f;
  private h jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h;
  private j jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j;
  private k jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$k;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private jzu jdField_a_of_type_Jzu;
  private kcp jdField_a_of_type_Kcp;
  private kcq jdField_a_of_type_Kcq;
  private lgv.b jdField_a_of_type_Lgv$b;
  private mtg jdField_a_of_type_Mtg;
  private mtw jdField_a_of_type_Mtw;
  private mvn jdField_a_of_type_Mvn;
  private mwc jdField_a_of_type_Mwc;
  private mwe jdField_a_of_type_Mwe;
  private mwi jdField_a_of_type_Mwi;
  private mwj jdField_a_of_type_Mwj;
  private mxi jdField_a_of_type_Mxi;
  private mxu jdField_a_of_type_Mxu;
  private mzn jdField_a_of_type_Mzn;
  private oep jdField_a_of_type_Oep;
  private oeq jdField_a_of_type_Oeq;
  private int aHx;
  private int aRA = 5;
  private int aUp;
  private int aVi;
  private String akh;
  private String aki;
  private String akw;
  private String akx;
  private String aky;
  private boolean anU;
  private boolean anY = true;
  private boolean anZ;
  private boolean apA;
  private boolean apB;
  private boolean apC;
  private boolean apD;
  private boolean apE;
  private boolean apF;
  private boolean apG;
  private boolean apn;
  private boolean apy;
  private boolean apz;
  private jzv jdField_b_of_type_Jzv;
  private kcr jdField_b_of_type_Kcr;
  private mss jdField_b_of_type_Mss;
  private mtw.a jdField_b_of_type_Mtw$a;
  private mud jdField_b_of_type_Mud;
  private mve jdField_b_of_type_Mve;
  private mxm jdField_b_of_type_Mxm;
  private myc jdField_b_of_type_Myc;
  private ViewGroup bB;
  private byte[] bs;
  private VideoFeedsPlayManager jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  private mrp jdField_c_of_type_Mrp;
  private mtg.l d;
  private VideoInfo i;
  private ArrayList<VideoInfo> lt = new ArrayList();
  private QQAppInterface mApp;
  private Bundle mBundle;
  private boolean mIsFullScreen;
  private LinearLayoutManager mLayoutManager;
  private int mRequestTimes;
  private ViewGroup mRootView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private long wW;
  private long wX = -1L;
  private long wY;
  
  private void E(VideoInfo paramVideoInfo)
  {
    if ((TextUtils.isEmpty(paramVideoInfo.hH)) || (paramVideoInfo.adB)) {
      return;
    }
    ThreadManager.post(new CheckAccountFollowedRunnable(paramVideoInfo), 1, null, true);
  }
  
  private void F(VideoInfo paramVideoInfo)
  {
    if (paramVideoInfo.busiType != 0)
    {
      if ((!TextUtils.isEmpty(paramVideoInfo.vid)) || (!TextUtils.isEmpty(paramVideoInfo.Wz))) {
        this.jdField_a_of_type_Kcp.br(paramVideoInfo.vid, paramVideoInfo.Wz);
      }
      if (!TextUtils.isEmpty(paramVideoInfo.hH)) {
        E(paramVideoInfo);
      }
    }
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString2);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private void a(int paramInt, VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (!TextUtils.isEmpty(paramVideoInfo.Wz)) && (!TextUtils.isEmpty(paramVideoInfo.WF))) {
      RIJRedPacketManager.a().a(paramVideoInfo.Wz, paramVideoInfo.WF, 4, new mvz(this, paramVideoInfo, paramInt));
    }
  }
  
  private void a(mtg.e parame)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.jdField_a_of_type_Mtw.El()) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), bool1);
      return;
      bool1 = bool2;
      if (!(parame instanceof mtg.b))
      {
        bool1 = bool2;
        if ((parame instanceof mtg.g))
        {
          bool1 = bool2;
          if (!((mtg.g)parame).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.k(getActivity())) {
            bool1 = true;
          }
        }
      }
    }
  }
  
  private void a(mtg.l paraml, boolean paramBoolean)
  {
    if ((paraml != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null))
    {
      if (paramBoolean) {
        kxy.mJ(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz);
      }
    }
    else {
      return;
    }
    kxy.mK(paraml.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.Wz);
  }
  
  private void aSW()
  {
    this.jdField_b_of_type_Kcr = ((kcr)this.mApp.getBusinessHandler(90));
    this.jdField_b_of_type_Kcr.ox(this.aHx);
    this.jdField_a_of_type_Mwc = new mwc(this.mApp, getActivity(), this.lt, this.jdField_a_of_type_Mtg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_Mwc.a(this);
    this.jdField_a_of_type_Mwc.a(this.jdField_a_of_type_Mtg);
    this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_Mwc);
    this.jdField_a_of_type_Mwe.a(this.jdField_a_of_type_Mwc);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_Mwc);
    this.jdField_a_of_type_Kcp = ((kcp)this.mApp.getBusinessHandler(99));
    this.jdField_a_of_type_Kcq = new i(null);
    this.jdField_a_of_type_Oep = ((oep)this.mApp.getBusinessHandler(126));
    this.jdField_a_of_type_Oeq = new c(null);
    this.jdField_a_of_type_Jzu = ((jzu)this.mApp.getBusinessHandler(93));
    this.jdField_b_of_type_Jzv = new a(null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$e = new e(null);
    ix();
    aSX();
    if (this.mBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j.o(true, this.mBundle);
    }
    int j = this.mBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((j > 0) && (j < this.lt.size()))
    {
      this.jdField_a_of_type_Mtg.sv(j);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.scrollToPosition(j);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.lt.get(0);
    F(localVideoInfo);
    if ((localVideoInfo.adB) && (TextUtils.isEmpty(localVideoInfo.accountName))) {
      localVideoInfo.accountName = aqgv.b(this.mApp, localVideoInfo.hH, true);
    }
    this.jdField_b_of_type_Mss = new mss(this.jdField_a_of_type_Mtg, this.lt, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.mUIHandler);
    this.jdField_b_of_type_Mss.ob(this.apn);
    this.jdField_a_of_type_Mtg.a(this.jdField_b_of_type_Mss);
    this.jdField_a_of_type_Mwe.b(this.jdField_b_of_type_Mss);
  }
  
  private void aSX()
  {
    if (!this.apA) {
      aTa();
    }
  }
  
  private void aSY()
  {
    if (this.apA) {}
    while (this.apB) {
      return;
    }
    aTa();
    this.jdField_a_of_type_Mtg.sy(1);
    this.jdField_a_of_type_Mtg.aRT();
  }
  
  private void aSZ()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_b_of_type_Kcr != null) && (this.jdField_a_of_type_Mwc != null))
    {
      l2 = this.wY;
      localQQAppInterface = this.mApp;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      this.jdField_b_of_type_Kcr.a(this.jdField_a_of_type_Mwc.a(), l1, this.jdField_a_of_type_Mwc.kv(), this.aVi, this.jdField_a_of_type_Mwc.h());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void aTa()
  {
    long l2;
    Object localObject;
    long l1;
    if (this.jdField_b_of_type_Kcr != null)
    {
      l2 = this.wY;
      localObject = this.mApp;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localObject == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(((QQAppInterface)localObject).getCurrentAccountUin());
      int k;
      int j;
      if ((this.jdField_b_of_type_Myc != null) && (this.i != null))
      {
        localObject = this.jdField_b_of_type_Myc.eV(this.i.Wz);
        k = 0;
        j = k;
        if (this.i != null)
        {
          if (this.i.aHc <= 0) {
            break label199;
          }
          j = this.i.aHc;
        }
      }
      for (;;)
      {
        this.apB = true;
        this.jdField_b_of_type_Kcr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j, l1, (VideoInfo)this.lt.get(0), this.aVi, this.lt, ((VideoInfo)this.lt.get(0)).WA, this.wX, true, j, this.akx, this.aky, null, this.mRequestTimes, (String)localObject, this.bs, 0, new ArrayList(this.P));
        return;
        localObject = null;
        break;
        label199:
        j = k;
        if (this.i.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo != null) {
          j = this.i.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.aHc;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void aTb()
  {
    if (this.jdField_a_of_type_Mzn != null) {
      this.jdField_a_of_type_Mzn.aTb();
    }
  }
  
  private void aTd()
  {
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$e);
    getActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j);
    getActivity().removeObserver(this.jdField_a_of_type_Kcq);
    getActivity().removeObserver(this.jdField_b_of_type_Jzv);
    getActivity().removeObserver(this.jdField_a_of_type_Oeq);
  }
  
  private void asF()
  {
    if (this.jdField_a_of_type_Mzn != null) {
      this.jdField_a_of_type_Mzn.M((VideoInfo)this.lt.get(0));
    }
  }
  
  private void doOnResume()
  {
    if ((this.jdField_a_of_type_Mxu != null) && (this.jdField_a_of_type_Mxu.cV())) {
      return;
    }
    mzj.a().z(true, "videoFeeds doOnResume");
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnResume();
    }
    if ((this.jdField_b_of_type_Mve != null) && (this.jdField_b_of_type_Mve.Ev())) {
      this.jdField_b_of_type_Mve.doOnResume();
    }
    if (this.jdField_a_of_type_Mtg != null) {
      this.jdField_a_of_type_Mtg.doOnResume();
    }
    if ((this.jdField_c_of_type_Mrp != null) && (this.jdField_c_of_type_Mrp.DY()) && (this.jdField_c_of_type_Mrp.a() != null) && (this.jdField_a_of_type_Mtg != null)) {
      this.jdField_a_of_type_Mtg.e(this.jdField_c_of_type_Mrp.a());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.doOnResume();
    }
    if (this.jdField_b_of_type_Mud != null) {
      this.jdField_b_of_type_Mud.doOnResume();
    }
    if ((this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)) {
      E(this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d);
    }
    if (this.jdField_b_of_type_Myc != null) {
      this.jdField_b_of_type_Myc.aTG();
    }
    a(this.d, true);
  }
  
  private void initData()
  {
    boolean bool2 = true;
    this.mBundle = getArguments();
    this.Q = new HashSet();
    this.akh = this.mBundle.getString("ARGS_SESSION_ID");
    this.aki = this.mBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.aHx = this.mBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    this.apz = this.mBundle.getBoolean("VIDEO_FROM_AIO", false);
    this.aVi = this.mBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.wX = this.mBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.wY = this.mBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.apA = awit.nN(this.aVi);
    this.wW = this.mBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.apC = this.mBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    label244:
    ArrayList localArrayList;
    if ((this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 2) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 3) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 6) || (this.mBundle.getInt("VIDEO_FROM_TYPE", -1) == 7))
    {
      bool1 = true;
      this.apE = bool1;
      if (this.apE) {
        break label664;
      }
      bool1 = true;
      this.anY = bool1;
      if ((this.wW <= 0L) || (!this.apE)) {
        break label669;
      }
      bool1 = true;
      label267:
      this.apF = bool1;
      this.anU = this.mBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
      this.akx = this.mBundle.getString("VIDEO_COMMON_DATA");
      this.bs = this.mBundle.getByteArray("VIDEO_BUSINESS_INFO");
      this.apn = awit.nM(this.aVi);
      this.aRA = kxm.nR();
      this.aUp = kct.nd();
      if (aqux.Mv() != 1) {
        break label674;
      }
      bool1 = true;
      label349:
      this.anZ = bool1;
      this.jdField_a_of_type_Lgv$b = new d(null);
      if (aVo <= 0) {
        aVo = aqcx.dip2px(getActivity(), 120.0F);
      }
      this.i = ((VideoInfo)this.mBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
      localArrayList = new ArrayList();
      localArrayList.add(this.i);
      if (this.lt.size() <= 1) {
        break label679;
      }
    }
    label664:
    label669:
    label674:
    label679:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j = new j(bool1);
      j.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j, localArrayList);
      if ((RIJRedPacketManager.a().Dr()) && (RIJRedPacketManager.a().Dt()) && ((this.aVi == 0) || (this.aVi >= 100))) {
        a(0, this.i);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoFromType = " + this.aVi);
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mBundle = " + this.mBundle.toString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() mVideoDataList[0] = " + this.i.toLogString());
        QLog.d("VideoFeedsRecommendFragment", 2, "initData() needReloadTitle = " + this.apz + ", showSingleVideo = " + this.apA + ", mFirstVideoStartPosition = " + this.wW);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label244;
      bool1 = false;
      break label267;
      bool1 = false;
      break label349;
    }
  }
  
  private void initUI()
  {
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.mRootView.findViewById(2131381801));
    VideoFeedsAccessibilityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setExtraFooterCount(0);
    this.mLayoutManager = new mvh(getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, 1, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setLayoutManager(this.mLayoutManager);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d = new l(null);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = new VideoFeedsPlayManager(getActivity().getApplicationContext(), this.mApp);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oC(false);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oE(this.apn);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.setLoopback(this.apC);
    this.jdField_a_of_type_Mwe = new mwe(getActivity(), this.mApp, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.anU, this.akh, this.aki, this.apF, this.apn, this.lt);
    this.jdField_c_of_type_Mrp = new mrp(getActivity().getApplicationContext());
    this.jdField_c_of_type_Mrp.a(new mvy(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager = new ADVideoAppDownloadManager(getActivity(), false);
    this.jdField_a_of_type_Mtg = new mtg(getActivity().getApplicationContext(), getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.mLayoutManager, this.mApp, this.akh, this.aki, this.anU, this.aVi, this.jdField_a_of_type_Mwe);
    this.jdField_a_of_type_Mtg.ol(getUserVisibleHint());
    this.jdField_a_of_type_Mtg.og(this.apz);
    Object localObject = this.jdField_a_of_type_Mtg;
    int j;
    if (this.apA)
    {
      j = 3;
      ((mtg)localObject).sy(j);
      this.jdField_a_of_type_Mtg.cS(this.lt);
      this.jdField_a_of_type_Mtg.setVideoPlayManager(this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager);
      this.jdField_a_of_type_Mtg.a(this.jdField_c_of_type_Mrp);
      this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager);
      this.jdField_a_of_type_Mtg.a(this);
      this.jdField_a_of_type_Mtg.cX(this.aRA, this.aUp);
      this.jdField_a_of_type_Mtg.oi(this.anY);
      this.jdField_a_of_type_Mtg.oj(this.apC);
      this.jdField_a_of_type_Mtg.ok(this.anZ);
      this.jdField_a_of_type_Mtg.l((VideoInfo)this.lt.get(0));
      this.jdField_a_of_type_Mtg.eK(this.wW);
      if (this.mBundle != null) {}
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$k = new k(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_Mtg);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$k);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$k);
      this.jdField_b_of_type_Mtw$a = new b(null);
      this.bB = ((ViewGroup)this.mRootView.findViewById(2131365045));
      this.jdField_a_of_type_Mtw = new mtw(getActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView, this.jdField_a_of_type_Mtg, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.bB);
      this.jdField_a_of_type_Mtw.initUI();
      this.jdField_a_of_type_Mtw.v((VideoInfo)this.lt.get(0));
      this.jdField_a_of_type_Mtw.a(this.jdField_b_of_type_Mtw$a);
      if (this.apC)
      {
        localObject = (AnchorData)this.mBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_Mtw.b((AnchorData)localObject);
      }
      this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_Mtw);
      j = this.mBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_Mxu = new mxu(getActivity(), this.mRootView, this, this.anU, j, this.aVi);
      this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_Mxu);
      this.jdField_b_of_type_Mve = new mve(getActivity(), this.mApp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$d, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager, this.jdField_a_of_type_Mtg, this.anU);
      this.jdField_a_of_type_Mxi = new mxi(this.mApp, getActivity(), this.jdField_a_of_type_Mtg);
      this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_Mxi);
      if (this.jdField_b_of_type_Mud == null) {
        this.jdField_b_of_type_Mud = new mud(this.mApp, getActivity(), this.jdField_a_of_type_Mtg, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Mtg.a(this.jdField_b_of_type_Mud);
      if (this.jdField_b_of_type_Mxm == null) {
        this.jdField_b_of_type_Mxm = new mxm(this.mApp, getActivity(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_Mtg.a(this.jdField_b_of_type_Mxm);
      this.jdField_a_of_type_Mzn = new mzn(getActivity(), getActivity().getAppRuntime(), this.mRootView, true, this.apC);
      if ((this.mRootView instanceof FrameLayout))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f = new f(null);
        this.jdField_b_of_type_Myc = new myc(getActivity(), (FrameLayout)this.mRootView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f);
        this.jdField_b_of_type_Myc.oK(false);
        this.jdField_b_of_type_Myc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f);
        this.jdField_b_of_type_Myc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f);
      }
      if (this.jdField_a_of_type_Mvn == null)
      {
        this.jdField_a_of_type_Mvn = new mvn(getActivity(), 1);
        this.jdField_a_of_type_Mtg.a(this.jdField_a_of_type_Mvn);
      }
      mzj.a().aO(getActivity());
      if (!getActivity().getIntent().hasExtra("param_needSmooth")) {
        break label1128;
      }
      mzj.a().oX(true);
    }
    for (;;)
    {
      mzj.a().g(mzj.a().P(true), "init view set mute itself FromMutiVideo", 2);
      msv.a().oe(true);
      msv.a().setSceneType(2);
      return;
      j = 1;
      break;
      label1128:
      mzj.a().oX(false);
    }
  }
  
  private void ix()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$e != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$e);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j != null) {
      getActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$j);
    }
    if (this.jdField_a_of_type_Kcq != null) {
      getActivity().addObserver(this.jdField_a_of_type_Kcq);
    }
    if (this.jdField_b_of_type_Jzv != null) {
      getActivity().addObserver(this.jdField_b_of_type_Jzv);
    }
    if (this.jdField_a_of_type_Oeq != null) {
      getActivity().addObserver(this.jdField_a_of_type_Oeq);
    }
  }
  
  private void sG(int paramInt)
  {
    if ((this.apG) && (paramInt == 1)) {
      this.apG = false;
    }
    do
    {
      return;
      a(this.d, false);
      mzj.a().z(false, "videoFeeds doOnPause");
      if (this.jdField_a_of_type_Mtg != null) {
        this.jdField_a_of_type_Mtg.sx(paramInt);
      }
    } while (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager == null);
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnPause();
  }
  
  public boolean BT()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.jdField_a_of_type_Mtw != null) && (this.jdField_a_of_type_Mtw.El()))
      {
        this.jdField_a_of_type_Mtw.aSk();
        return true;
      }
    } while ((this.d == null) || (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null));
    VideoInfo localVideoInfo = this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
    nce.a locala = new nce.a(localVideoInfo);
    locala.h(localVideoInfo.Wz).l(this.mApp.getCurrentAccountUin()).m(this.d.position).l(this.d.aUv);
    locala.o(1).h(localVideoInfo.Wz);
    kbp.a(this.mApp, localVideoInfo.hH, "0X8009953", "0X8009953", 0, 0, "", "", "", locala.a().toJsonString(), false);
    return false;
  }
  
  public boolean EH()
  {
    return false;
  }
  
  public boolean EI()
  {
    return this.jdField_a_of_type_Mwe.EJ();
  }
  
  public boolean El()
  {
    return (this.jdField_a_of_type_Mtw != null) && (this.jdField_a_of_type_Mtw.El());
  }
  
  public VideoInfo a(View paramView)
  {
    sG(1);
    return g();
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.mIsFullScreen = paramBoolean;
    if (this.jdField_a_of_type_Mzn != null) {
      this.jdField_a_of_type_Mzn.setFullScreen(paramBoolean);
    }
    String str1;
    if (paramBoolean)
    {
      aTb();
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
      {
        paramViewHolder = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.e();
        if (paramViewHolder != null)
        {
          if ((paramViewHolder.busiType != 0) || (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
            break label218;
          }
          str1 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5();
          label69:
          str1 = new nce.a(str1, paramViewHolder.hH, paramViewHolder.vid, paramViewHolder.Wz, this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.cV(), paramViewHolder.getDuration() * 1000L).a(409409).a().toJsonString();
          String str2 = paramViewHolder.hH;
          if (TextUtils.isEmpty(paramViewHolder.Wz)) {
            break label223;
          }
          paramViewHolder = paramViewHolder.Wz;
          label139:
          kbp.a(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
        }
        if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
          this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oE(false);
        }
        if ((this.d instanceof mtg.g)) {
          this.jdField_b_of_type_Myc.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f.a(this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d), 0);
        }
      }
    }
    label218:
    label223:
    do
    {
      return;
      paramViewHolder = null;
      break;
      str1 = null;
      break label69;
      paramViewHolder = "0";
      break label139;
      if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) {
        this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.oE(this.apn);
      }
    } while (this.jdField_b_of_type_Myc == null);
    paramBoolean = this.jdField_b_of_type_Myc.EO();
    this.jdField_b_of_type_Myc.aTE();
    this.jdField_b_of_type_Myc.aTF();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$f.oG(paramBoolean);
  }
  
  public void a(h paramh)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h = paramh;
  }
  
  public void a(mwi parammwi)
  {
    this.jdField_a_of_type_Mwi = parammwi;
  }
  
  public void a(mwj parammwj)
  {
    this.jdField_a_of_type_Mwj = parammwj;
  }
  
  public void aRC()
  {
    if (this.jdField_c_of_type_Mrp != null) {
      this.jdField_c_of_type_Mrp.aRC();
    }
    a(this.d, false);
  }
  
  public void aRD()
  {
    if (this.jdField_c_of_type_Mrp != null) {
      this.jdField_c_of_type_Mrp.aRD();
    }
    a(this.d, true);
  }
  
  public void aRU()
  {
    aSZ();
  }
  
  public void aRV() {}
  
  public void aSa()
  {
    if (QLog.isColorLevel()) {
      kxm.p("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    aSY();
  }
  
  public void aSb()
  {
    aSY();
  }
  
  public void aTc()
  {
    sG(1);
  }
  
  public void aTe()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.setNeedDetectOrientation(getActivity(), false);
    }
  }
  
  public void aTf()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      a(this.d);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof mtg.e)) {
      a((mtg.e)paramViewHolder);
    }
    if ((paramViewHolder instanceof mtg.l))
    {
      if (this.jdField_a_of_type_Mxi != null) {
        this.jdField_a_of_type_Mxi.h(this.d);
      }
      if (this.jdField_b_of_type_Mud != null) {
        this.jdField_b_of_type_Mud.h((mtg.l)paramViewHolder);
      }
      if (this.jdField_b_of_type_Mxm != null) {
        this.jdField_b_of_type_Mxm.a(this.d, (mtg.l)paramViewHolder);
      }
      this.jdField_c_of_type_Mrp.d((mtg.l)paramViewHolder);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.d((mtg.l)paramViewHolder);
      a(this.d, false);
      this.d = ((mtg.l)paramViewHolder);
      a(this.d, true);
      if ((this.jdField_b_of_type_Mve != null) && ((this.d instanceof mtg.k))) {
        this.jdField_b_of_type_Mve.a((mtg.k)this.d, k.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$k));
      }
      if (((this.jdField_a_of_type_Mxu == null) || (this.d == null) || (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b == null)) || (this.d.aUv > 0))
      {
        if (this.jdField_a_of_type_Mzn != null) {
          this.jdField_a_of_type_Mzn.pa(false);
        }
        aTb();
      }
      if ((this.d.aos) && (this.d.aUv < this.lt.size() - 1)) {
        F((VideoInfo)this.lt.get(this.d.aUv + 1));
      }
      if ((this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null))
      {
        VideoInfo localVideoInfo = this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
        VideoFeedsAccessibilityHelper.a(this.d.bf, localVideoInfo.getDuration() * 1000);
        this.P.add(localVideoInfo);
        if (this.jdField_a_of_type_Mwj != null) {
          this.jdField_a_of_type_Mwj.H(localVideoInfo);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h != null)
    {
      boolean bool = paramViewHolder instanceof mtg.b;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h.oy(bool);
    }
  }
  
  public long cW()
  {
    return this.wW;
  }
  
  public void d(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oep != null) {
      this.jdField_a_of_type_Oep.g(paramVideoInfo, paramBoolean);
    }
  }
  
  public VideoInfo f()
  {
    if ((this.lt != null) && (this.lt.size() > 0)) {
      return (VideoInfo)this.lt.get(0);
    }
    return null;
  }
  
  public void f(mtg.l paraml) {}
  
  public VideoInfo g()
  {
    if ((this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null)) {
      return this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
    }
    return null;
  }
  
  public void oA(boolean paramBoolean)
  {
    this.apG = paramBoolean;
  }
  
  public void oF(boolean paramBoolean)
  {
    if (paramBoolean) {
      doOnResume();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        String str;
        do
        {
          do
          {
            do
            {
              return;
            } while (this.jdField_a_of_type_Mtw == null);
            this.jdField_a_of_type_Mtw.onActivityResult(paramInt1, paramInt2, paramIntent);
            return;
          } while (paramInt2 != -1);
          str = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
        } while ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (str == null) || (this.jdField_a_of_type_Mtg == null));
        paramIntent = this.jdField_a_of_type_Mtg.a(str);
      } while (paramIntent == null);
      paramIntent.aHb += 1;
      this.jdField_a_of_type_Mtg.i(paramIntent);
      return;
    } while (paramInt2 != -1);
    QQToast.a(getActivity(), -1, getString(2131701915), 0).show(getActivity().getTitleBarHeight());
  }
  
  public boolean onBackPressed()
  {
    if (!getUserVisibleHint()) {}
    do
    {
      return false;
      if ((this.mIsFullScreen) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.aTn();
        VideoFeedsPlayActivity.nX("BackPressed, back to list from fullscreen");
        return true;
      }
    } while ((this.jdField_a_of_type_Mtw == null) || (!this.jdField_a_of_type_Mtw.El()));
    this.jdField_a_of_type_Mtw.aSk();
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.mRootView != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new mwa(this, paramConfiguration);
      this.mRootView.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mRootView = ((ViewGroup)mwl.a(2131560546, true, new ViewGroup.LayoutParams(-1, -1)));
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
    initData();
    initUI();
    aSW();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment$h.aSK();
    }
    paramLayoutInflater = this.mRootView;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    if (this.jdField_a_of_type_Mtg != null) {
      this.jdField_a_of_type_Mtg.doOnDestory();
    }
    if (this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null)
    {
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.doOnDestory();
      this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager = null;
    }
    if (this.jdField_c_of_type_Mrp != null)
    {
      this.jdField_c_of_type_Mrp.doOnDestory();
      this.jdField_c_of_type_Mrp = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.doOnDestory();
    }
    if (this.jdField_b_of_type_Mss != null)
    {
      this.jdField_b_of_type_Mss.doOnDestory();
      this.jdField_b_of_type_Mss = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView.doOnDestory();
    }
    if (this.mUIHandler != null)
    {
      this.mUIHandler.removeCallbacksAndMessages(null);
      this.mUIHandler = null;
    }
    if (this.jdField_a_of_type_Mwc != null)
    {
      this.jdField_a_of_type_Mwc.doOnDestory();
      this.jdField_a_of_type_Mwc = null;
    }
    if (this.jdField_b_of_type_Mve != null)
    {
      this.jdField_b_of_type_Mve.doOnDestory();
      this.jdField_b_of_type_Mve = null;
    }
    if (this.jdField_a_of_type_Mxi != null)
    {
      this.jdField_a_of_type_Mxi.doOnDestory();
      this.jdField_a_of_type_Mxi = null;
    }
    if (this.jdField_b_of_type_Mud != null)
    {
      this.jdField_b_of_type_Mud.doOnDestory();
      this.jdField_b_of_type_Mud = null;
    }
    if (this.jdField_b_of_type_Mxm != null)
    {
      this.jdField_b_of_type_Mxm.doOnDestory();
      this.jdField_b_of_type_Mxm = null;
    }
    if (this.jdField_b_of_type_Myc != null) {
      this.jdField_b_of_type_Myc.doOnDestroy();
    }
    Iterator localIterator = this.lt.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (VideoInfo)localIterator.next();
      kxy.mI(((VideoInfo)localObject).Wz);
      if (((VideoInfo)localObject).jT != null)
      {
        localObject = ((VideoInfo)localObject).jT.iterator();
        while (((Iterator)localObject).hasNext()) {
          kxy.mI(((VideoInfo)((Iterator)localObject).next()).Wz);
        }
      }
    }
    if (this.jdField_a_of_type_Mvn != null)
    {
      this.jdField_a_of_type_Mvn.onDestroy();
      this.jdField_a_of_type_Mvn = null;
    }
    this.d = null;
    this.mApp = null;
    if (this.jdField_a_of_type_Mzn != null) {
      this.jdField_a_of_type_Mzn.aUN();
    }
    aTd();
    msv.a().reset();
    mzj.a().aP(getActivity());
    if (this.jdField_a_of_type_Mwe != null) {
      this.jdField_a_of_type_Mwe.onDestroyView();
    }
    VideoFeedsPlayActivity.nX("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
      return bool;
    }
    if ((this.d != null) && (!this.mIsFullScreen))
    {
      if (paramInt == 25) {}
      for (paramInt = -1;; paramInt = 1)
      {
        mzj.a().sW(paramInt);
        if (this.d == null) {
          break;
        }
        this.d.jdField_a_of_type_Mrx.S(mzj.a().aj());
        return true;
      }
    }
    return false;
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.nX("VideoFeedsPlayActivity doOnPause()");
    sG(1);
    if (this.jdField_c_of_type_Mrp != null) {
      this.jdField_c_of_type_Mrp.doOnPause();
    }
    if (this.jdField_b_of_type_Myc != null) {
      this.jdField_b_of_type_Myc.aTH();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoADVideoAppDownloadManager.doOnPause();
    }
    super.onPause();
  }
  
  public void onProgressChanged(long paramLong)
  {
    if (this.jdField_b_of_type_Mve != null) {
      this.jdField_b_of_type_Mve.dV((int)(paramLong / 1000.0D));
    }
    Object localObject;
    if ((this.jdField_a_of_type_Mxi != null) && ((this.d instanceof mtg.l)))
    {
      localObject = this.d;
      if (!this.mIsFullScreen) {
        this.jdField_a_of_type_Mxi.a(((mtg.l)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d, (mtg.l)localObject, (int)(paramLong / 1000.0D), (int)(((mtg.l)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.getDuration() / 1000.0D));
      }
    }
    if ((this.jdField_b_of_type_Mud != null) && (this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null))
    {
      localObject = this.d;
      this.jdField_b_of_type_Mud.a((mtg.l)localObject, this.mIsFullScreen);
    }
    long l;
    if ((this.jdField_b_of_type_Mxm != null) && (this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null))
    {
      localObject = this.d;
      l = this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e.getDuration();
      this.jdField_b_of_type_Mxm.a((mtg.l)localObject, this.mIsFullScreen, paramLong * 100.0D / l, l);
    }
    if ((this.jdField_a_of_type_Mwc != null) && (this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e != null))
    {
      localObject = this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e;
      this.jdField_a_of_type_Mwc.eL(((myi)localObject).c(false));
    }
    if ((this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager != null) && (this.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != null) && (this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.isAD) && (this.jdField_b_of_type_Mss != null))
    {
      localObject = this.d.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d.b;
      l = this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager.getVideoDuration();
      if ((knc.e((VideoAdInfo)localObject)) && (knc.a((VideoAdInfo)localObject)))
      {
        if (paramLong < l * 0.8D) {
          break label420;
        }
        this.jdField_b_of_type_Mss.a((VideoAdInfo)localObject, this.d.aUv);
      }
    }
    label420:
    while (paramLong < l * 0.5D) {
      return;
    }
    this.jdField_b_of_type_Mss.sr(this.d.aUv);
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.nX("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      doOnResume();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.nX("VideoFeedsPlayActivity doOnStop()");
    sG(2);
    super.onStop();
  }
  
  public int pY()
  {
    if (this.d != null) {
      return this.d.aUv;
    }
    return 0;
  }
  
  public void sH(int paramInt)
  {
    this.mRequestTimes = paramInt;
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      doOnResume();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mtg != null) {
        this.jdField_a_of_type_Mtg.ol(paramBoolean);
      }
      return;
      sG(2);
    }
  }
  
  class CheckAccountFollowedRunnable
    implements Runnable
  {
    private VideoInfo d;
    
    public CheckAccountFollowedRunnable(VideoInfo paramVideoInfo)
    {
      this.d = paramVideoInfo;
    }
    
    private boolean a(VideoInfo paramVideoInfo, boolean paramBoolean)
    {
      if ((paramVideoInfo.hH != null) && (paramVideoInfo.hH.equals(this.d.hH)) && (!paramVideoInfo.isAD) && (paramVideoInfo.isFollowed != paramBoolean))
      {
        paramVideoInfo.isFollowed = paramBoolean;
        return true;
      }
      return false;
    }
    
    public void run()
    {
      try
      {
        boolean bool = muj.b(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), Long.valueOf(this.d.hH).longValue());
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) == null) {
          return;
        }
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable.1(this, bool));
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  class a
    extends jzv
  {
    private a() {}
    
    public void c(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
    
    public void d(boolean paramBoolean, String paramString, int paramInt) {}
    
    public void n(boolean paramBoolean, String paramString)
    {
      VideoFeedsPlayActivity.nX("onSendArticleLikeReq isSuccess=" + paramBoolean + ", articleID=" + paramString);
    }
  }
  
  class b
    implements mtw.a
  {
    private b() {}
    
    public void aGM()
    {
      VideoFeedsRecommendFragment.this.oA(true);
    }
    
    public void aJ(boolean paramBoolean)
    {
      boolean bool2 = true;
      VideoFeedsRecyclerView localVideoFeedsRecyclerView;
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a.nX(paramBoolean);
        if ((!VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aos) && ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).itemView.getParent() instanceof VideoFeedsRecyclerView)))
        {
          localVideoFeedsRecyclerView = (VideoFeedsRecyclerView)VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).itemView.getParent();
          if (paramBoolean) {
            break label201;
          }
          bool1 = true;
          localVideoFeedsRecyclerView.setScrollable(bool1);
        }
      }
      if (paramBoolean)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).setNeedDetectOrientation(VideoFeedsRecommendFragment.this.getActivity(), false);
        label112:
        if (!VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this))
        {
          localVideoFeedsRecyclerView = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this);
          if (paramBoolean) {
            break label223;
          }
        }
      }
      label201:
      label223:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        localVideoFeedsRecyclerView.setScrollable(bool1);
        if ((!paramBoolean) && (VideoFeedsRecommendFragment.c(VideoFeedsRecommendFragment.this)))
        {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).EK();
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this, false);
        }
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).ox(paramBoolean);
        }
        return;
        bool1 = false;
        break;
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this, VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this));
        break label112;
      }
    }
  }
  
  class c
    extends oeq
  {
    private c() {}
    
    public void p(boolean paramBoolean, Bundle paramBundle)
    {
      VideoFeedsPlayActivity.nX("onGetDianZanState isSuccess: " + paramBoolean);
      if ((!paramBoolean) || (paramBundle == null)) {}
      int i;
      do
      {
        String str;
        do
        {
          return;
          str = paramBundle.getString("VALUE_VIDEO_ARTICLE_ID");
          i = paramBundle.getInt("VALUE_VIDEO_FAVORITE_STATE");
        } while (str == null);
        paramBundle = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(str);
      } while (paramBundle == null);
      if (i == 1) {
        paramBundle.adM = true;
      }
      for (;;)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).i(paramBundle);
        return;
        if (i == 0) {
          paramBundle.adM = false;
        }
      }
    }
  }
  
  class d
    extends lgv.b
  {
    private d() {}
    
    public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
    {
      VideoFeedsPlayActivity.nX("handleDoFavoriteResult isSuccess = " + paramBoolean + ", operationType = " + paramInt + ", cid = " + paramString2);
      if (TextUtils.isEmpty(paramString1)) {}
      do
      {
        return;
        paramString1 = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(paramString1);
      } while (paramString1 == null);
      if (paramBoolean)
      {
        if (paramInt != 1) {
          break label204;
        }
        paramString1.F.add(paramString2);
        if (!paramString1.isFavorite) {
          new ArrayList(paramString1.F);
        }
      }
      label103:
      if (paramString1.adC)
      {
        paramString2 = new QQToast(VideoFeedsRecommendFragment.this.getActivity().getApplicationContext());
        paramString2.setDuration(2000);
        if (!paramBoolean) {
          break label212;
        }
        paramString2.setToastIcon(QQToast.getIconRes(2));
        paramString2.setToastMsg(2131693408);
        paramString2.show(VideoFeedsRecommendFragment.this.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(VideoFeedsRecommendFragment.this.getActivity().getApplicationContext(), 5.0F));
      }
      for (;;)
      {
        paramString1.adC = false;
        return;
        label204:
        if (paramInt != 2) {
          break label103;
        }
        break label103;
        break;
        label212:
        paramString2.setToastIcon(QQToast.getIconRes(1));
        paramString2.setToastMsg(2131693409);
        paramString2.show(VideoFeedsRecommendFragment.this.getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(VideoFeedsRecommendFragment.this.getActivity().getApplicationContext(), 5.0F));
        paramString1.isFavorite = false;
      }
    }
    
    public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, ArrayList<String> paramArrayList)
    {
      VideoFeedsPlayActivity.nX("handleFavoriteStatus isSuccess = " + paramBoolean1 + ", rowkey = " + paramString + ", isFavorite = " + paramBoolean2);
      if ((!paramBoolean1) || (TextUtils.isEmpty(paramString))) {}
      do
      {
        return;
        paramString = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(paramString);
      } while (paramString == null);
      paramString.isFavorite = paramBoolean2;
      paramString.F.addAll(paramArrayList);
    }
  }
  
  class e
    extends acfd
  {
    private e() {}
    
    public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
    {
      int j = 0;
      if (TextUtils.isEmpty(paramString)) {
        break label10;
      }
      label10:
      label227:
      for (;;)
      {
        return;
        if (paramBoolean)
        {
          Object localObject1 = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this);
          if (localObject1 != null) {}
          for (localObject1 = aqgv.b((QQAppInterface)localObject1, paramString, false);; localObject1 = null)
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label227;
            }
            Iterator localIterator = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).iterator();
            while (localIterator.hasNext())
            {
              Object localObject2 = (VideoInfo)localIterator.next();
              int i = j;
              if (paramString.equals(((VideoInfo)localObject2).hH))
              {
                i = j;
                if (!((String)localObject1).equals(((VideoInfo)localObject2).accountName))
                {
                  ((VideoInfo)localObject2).accountName = ((String)localObject1);
                  i = 1;
                }
              }
              j = i;
              if (((VideoInfo)localObject2).jT != null)
              {
                localObject2 = ((VideoInfo)localObject2).jT.iterator();
                for (;;)
                {
                  j = i;
                  if (!((Iterator)localObject2).hasNext()) {
                    break;
                  }
                  VideoInfo localVideoInfo = (VideoInfo)((Iterator)localObject2).next();
                  if ((paramString.equals(localVideoInfo.hH)) && (!((String)localObject1).equals(localVideoInfo.accountName)))
                  {
                    localVideoInfo.accountName = ((String)localObject1);
                    i = 1;
                  }
                }
              }
            }
            if (j == 0) {
              break;
            }
            VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).nS(paramString);
            return;
          }
        }
      }
    }
  }
  
  class f
    implements mrz, myc.b, myc.c
  {
    private f() {}
    
    public List<mrr> Z(List<VideoInfo> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.next();
        localArrayList.add(a(localVideoInfo));
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).I(localVideoInfo);
        }
      }
      return localArrayList;
    }
    
    public VideoFeedsRecommendFragment.g a(VideoInfo paramVideoInfo)
    {
      VideoFeedsRecommendFragment.g localg = new VideoFeedsRecommendFragment.g(null);
      VideoFeedsRecommendFragment.g.a(localg, paramVideoInfo);
      localg.channelId = 409409L;
      localg.position = 0;
      localg.title = paramVideoInfo.title;
      localg.videoCoverUrl = paramVideoInfo.coverUrl;
      localg.videoVid = paramVideoInfo.vid;
      localg.vn = paramVideoInfo.ry;
      return localg;
    }
    
    public void a(mrr parammrr)
    {
      if ((parammrr instanceof VideoFeedsRecommendFragment.g))
      {
        parammrr = VideoFeedsRecommendFragment.g.a((VideoFeedsRecommendFragment.g)parammrr);
        if (parammrr != VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d) {
          break label64;
        }
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).d(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b, false);
      }
      for (;;)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aTk();
        return;
        label64:
        int i = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv;
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).remove(i);
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).add(i, parammrr);
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aos) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).notifyItemChanged(i);
        }
      }
    }
    
    public void a(mrr parammrr1, mrr parammrr2, int paramInt, boolean paramBoolean) {}
    
    public void aCj()
    {
      VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aTn();
    }
    
    public void aTg()
    {
      VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_Mrx.nZ(false);
      VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_Mxy.sL(6);
    }
    
    public void oG(boolean paramBoolean)
    {
      Object localObject = VideoFeedsRecommendFragment.g.a((VideoFeedsRecommendFragment.g)VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a());
      VideoInfo localVideoInfo = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d;
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d != localObject)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).add(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv, localObject);
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).notifyItemInserted(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv);
        if (!VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aos) {
          break label231;
        }
        localObject = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this);
      }
      label231:
      for (((mtg.l)localObject).position += 1;; VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).position = 0)
      {
        localObject = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this);
        ((mtg.l)localObject).aUv += 1;
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).scrollToPosition(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv);
        if (paramBoolean) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).d(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b, false);
        }
        kbp.a(null, "", "0X8009505", "0X8009505", 0, 0, "", "0", "", new nce.a(null, null, localVideoInfo.vid, localVideoInfo.Wz).a(409409).a().toJsonString(), false);
        return;
      }
    }
  }
  
  static class g
    extends mrr
  {
    private VideoInfo c;
    
    public VideoInfo a()
    {
      return this.c;
    }
    
    public String getInnerUniqueID()
    {
      return this.c.Wz;
    }
  }
  
  static abstract interface h
    extends VideoFeedsRecyclerView.a
  {
    public abstract void aSK();
    
    public abstract void aa(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void ox(boolean paramBoolean);
    
    public abstract void oy(boolean paramBoolean);
  }
  
  class i
    extends kcq
  {
    private i() {}
    
    public void n(boolean paramBoolean, Bundle paramBundle)
    {
      VideoFeedsPlayActivity.nX("onGetVideoPlayCount isSuccess: " + paramBoolean);
      if ((!paramBoolean) || (paramBundle == null)) {}
      Object localObject;
      do
      {
        do
        {
          return;
          localObject = paramBundle.getString("VALUE_VIDEO_VID");
        } while (localObject == null);
        localObject = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).b((String)localObject);
      } while (localObject == null);
      ((VideoInfo)localObject).playCount = paramBundle.getInt("VALUE_VIDEO_PLAY_COUNT");
      VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).i((VideoInfo)localObject);
    }
  }
  
  class j
    extends kcs
  {
    private boolean apI;
    
    public j(boolean paramBoolean)
    {
      this.apI = paramBoolean;
    }
    
    private void a(VideoInfo paramVideoInfo1, VideoInfo paramVideoInfo2, Bundle paramBundle)
    {
      if ((VideoFeedsRecommendFragment.f(VideoFeedsRecommendFragment.this)) || (TextUtils.isEmpty(paramVideoInfo1.title)))
      {
        if ((TextUtils.isEmpty(paramVideoInfo2.title)) && (!TextUtils.isEmpty(paramVideoInfo1.title))) {
          paramVideoInfo2.title = paramVideoInfo1.title;
        }
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).og(false);
      }
      for (;;)
      {
        if ((paramVideoInfo1.jR != null) && (paramVideoInfo1.jR.size() > 0))
        {
          if (paramVideoInfo2.jR == null) {
            paramVideoInfo2.jR = new ArrayList();
          }
          paramVideoInfo2.jR.addAll(paramVideoInfo1.jR);
        }
        if ((paramVideoInfo2.ry <= 0L) && (paramVideoInfo1.ry > 0L)) {
          paramVideoInfo2.ry = paramVideoInfo1.ry;
        }
        if ((paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo != null) && (paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null))
        {
          paramVideoInfo2.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramVideoInfo1.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
          paramVideoInfo2.busiType = paramVideoInfo1.busiType;
        }
        if (paramVideoInfo1.strategyID > 0) {
          paramVideoInfo2.strategyID = paramVideoInfo1.strategyID;
        }
        if (paramVideoInfo1.algorithmID > 0L) {
          paramVideoInfo2.algorithmID = paramVideoInfo1.algorithmID;
        }
        if ((paramVideoInfo2.width <= 0) && (paramVideoInfo1.width > 0)) {
          paramVideoInfo2.width = paramVideoInfo1.width;
        }
        if ((paramVideoInfo2.height <= 0) && (paramVideoInfo1.height > 0)) {
          paramVideoInfo2.height = paramVideoInfo1.height;
        }
        if ((paramVideoInfo2.duration <= 0) && (paramVideoInfo1.duration > 0)) {
          paramVideoInfo2.duration = paramVideoInfo1.duration;
        }
        if ((paramVideoInfo2.playCount <= 0) && (paramVideoInfo1.playCount > 0)) {
          paramVideoInfo2.playCount = paramVideoInfo1.playCount;
        }
        if ((paramVideoInfo2.likeCount <= 0) && (paramVideoInfo1.likeCount > 0)) {
          paramVideoInfo2.likeCount = paramVideoInfo1.likeCount;
        }
        if (!TextUtils.isEmpty(paramVideoInfo1.WA)) {
          paramVideoInfo2.WA = paramVideoInfo1.WA;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.accountName)) && (!TextUtils.isEmpty(paramVideoInfo1.accountName))) {
          paramVideoInfo2.accountName = paramVideoInfo1.accountName;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.hH)) && (!TextUtils.isEmpty(paramVideoInfo1.hH))) {
          paramVideoInfo2.hH = paramVideoInfo1.hH;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.Wz)) && (!TextUtils.isEmpty(paramVideoInfo1.Wz))) {
          paramVideoInfo2.Wz = paramVideoInfo1.Wz;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.vid)) && (!TextUtils.isEmpty(paramVideoInfo1.vid)))
        {
          paramVideoInfo2.vid = paramVideoInfo1.vid;
          paramVideoInfo2.busiType = paramVideoInfo1.busiType;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.webUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.webUrl))) {
          paramVideoInfo2.webUrl = paramVideoInfo1.webUrl;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.summary)) && (!TextUtils.isEmpty(paramVideoInfo1.summary))) {
          paramVideoInfo2.summary = paramVideoInfo1.summary;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.title)) && (!TextUtils.isEmpty(paramVideoInfo1.title))) {
          paramVideoInfo2.title = paramVideoInfo1.title;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.WC)) && (!TextUtils.isEmpty(paramVideoInfo1.WC))) {
          paramVideoInfo2.WC = paramVideoInfo1.WC;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.thirdAction)) && (!TextUtils.isEmpty(paramVideoInfo1.thirdAction))) {
          paramVideoInfo2.thirdAction = paramVideoInfo1.thirdAction;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.videoUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.videoUrl))) {
          paramVideoInfo2.videoUrl = paramVideoInfo1.videoUrl;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.videoUrl)) && (!TextUtils.isEmpty(paramVideoInfo1.videoUrl))) {
          paramVideoInfo2.videoUrl = paramVideoInfo1.videoUrl;
        }
        if ((TextUtils.isEmpty(paramVideoInfo2.recommendReason)) && (!TextUtils.isEmpty(paramVideoInfo1.recommendReason))) {
          paramVideoInfo2.recommendReason = paramVideoInfo1.recommendReason;
        }
        if (!paramVideoInfo2.adB) {
          paramVideoInfo2.isFollowed = paramVideoInfo1.isFollowed;
        }
        if (!TextUtils.isEmpty(paramVideoInfo1.coverUrl)) {
          paramVideoInfo2.coverUrl = paramVideoInfo1.coverUrl;
        }
        if (!TextUtils.isEmpty(paramVideoInfo1.WH)) {
          paramVideoInfo2.WH = paramVideoInfo1.WH;
        }
        if (!TextUtils.isEmpty(paramVideoInfo1.WI)) {
          paramVideoInfo2.WI = paramVideoInfo1.WI;
        }
        bJ("subscribeText", paramVideoInfo2.WH);
        bJ("subscribeColor", paramVideoInfo2.WI);
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(paramVideoInfo2.jdField_a_of_type_ComTencentBizPubaccountVideoInfo$InterruptedWeishiAd);
        }
        paramVideoInfo1 = (VideoInfo.ECommerceEntranceInfo)paramBundle.getParcelable("VALUE_ECOMMERCE_ENTRANCE_INFO");
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(paramVideoInfo1);
        }
        paramVideoInfo2.aHe = 0;
        muj.x(paramVideoInfo2);
        return;
        paramVideoInfo2.title = paramVideoInfo1.title;
      }
    }
    
    private void bJ(String paramString1, String paramString2) {}
    
    private void nY(String paramString) {}
    
    private void o(ArrayList<VideoInfo> paramArrayList, boolean paramBoolean)
    {
      if (paramArrayList != null) {}
      for (int i = paramArrayList.size();; i = 0)
      {
        if ((1 == VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).size() - i) && (paramBoolean) && (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).get(1) != null))
        {
          paramArrayList = (VideoInfo)VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).get(1);
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this, paramArrayList);
        }
        return;
      }
    }
    
    private void onFailed()
    {
      mtg localmtg = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this);
      if (VideoFeedsRecommendFragment.d(VideoFeedsRecommendFragment.this)) {}
      for (int i = 3;; i = 2)
      {
        localmtg.sy(i);
        if (VideoFeedsRecommendFragment.f(VideoFeedsRecommendFragment.this)) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).og(false);
        }
        if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).size() > 0) {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).i((VideoInfo)VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).get(0));
        }
        return;
      }
    }
    
    private boolean s(List<VideoInfo> paramList)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList == null)
      {
        nY("articleList为空");
        return false;
      }
      nY("articleList.size()=: " + paramList.size());
      paramList = paramList.iterator();
      boolean bool = false;
      if (paramList.hasNext())
      {
        VideoInfo localVideoInfo = (VideoInfo)paramList.next();
        if (localVideoInfo.isAD)
        {
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).add(localVideoInfo);
          nY("info.adType=" + localVideoInfo.qU + ", info.title=" + localVideoInfo.title + ", adInfo.aid=" + localVideoInfo.b.ru + ", adInfo.traceid=" + localVideoInfo.b.We + " add to videoDataList");
        }
        for (;;)
        {
          bool = true;
          break;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(localVideoInfo.vid).append(" ").append(localVideoInfo.Wz);
          localObject = ((StringBuilder)localObject).toString();
          if (VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this).contains(localObject))
          {
            nY("info.vid=" + localVideoInfo.vid + ", info.title=" + localVideoInfo.title + ", info.articleID=" + localVideoInfo.Wz + " has exist");
            break;
          }
          nY("info.vid=" + localVideoInfo.vid + ", info.title=" + localVideoInfo.title + ", info.articleID=" + localVideoInfo.Wz + " add to videoDataList");
          if ((localVideoInfo.adB) && (TextUtils.isEmpty(localVideoInfo.accountName))) {
            localVideoInfo.accountName = aqgv.b(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), localVideoInfo.hH, true);
          }
          muj.x(localVideoInfo);
          localVideoInfo.aHe = VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this);
          localArrayList.add(localVideoInfo.Wz);
          VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).add(localVideoInfo);
          VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this).add(localObject);
          if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
            VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).I(localVideoInfo);
          }
        }
      }
      nY("hasNewVideo = " + bool);
      return bool;
    }
    
    /* Error */
    public void o(boolean paramBoolean, Bundle paramBundle)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   4: aload_2
      //   5: ldc_w 339
      //   8: iconst_0
      //   9: invokevirtual 343	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
      //   12: invokestatic 346	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
      //   15: pop
      //   16: aload_0
      //   17: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   20: astore 10
      //   22: aload_0
      //   23: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   26: invokestatic 348	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   29: ifne +13 -> 42
      //   32: aload_0
      //   33: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   36: invokestatic 214	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   39: ifeq +130 -> 169
      //   42: iconst_1
      //   43: istore 5
      //   45: aload 10
      //   47: iload 5
      //   49: invokestatic 351	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
      //   52: pop
      //   53: iload_1
      //   54: ifne +121 -> 175
      //   57: aload_0
      //   58: invokespecial 353	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:onFailed	()V
      //   61: aload_0
      //   62: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   65: invokestatic 348	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   68: ifne +83 -> 151
      //   71: aload_0
      //   72: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   75: invokestatic 214	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   78: ifne +73 -> 151
      //   81: aload_0
      //   82: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   85: invokestatic 356	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtw;
      //   88: ifnull +1336 -> 1424
      //   91: aload_0
      //   92: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   95: invokestatic 356	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtw;
      //   98: invokevirtual 361	mtw:El	()Z
      //   101: ifeq +1323 -> 1424
      //   104: aload_0
      //   105: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   108: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
      //   111: iconst_0
      //   112: invokevirtual 369	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:setScrollable	(Z)V
      //   115: aload_0
      //   116: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   119: invokestatic 372	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$h;
      //   122: ifnull +29 -> 151
      //   125: aload_0
      //   126: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   129: invokestatic 372	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$h;
      //   132: aload_0
      //   133: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   136: invokestatic 348	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   139: aload_0
      //   140: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   143: invokestatic 214	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   146: invokeinterface 378 3 0
      //   151: aload_0
      //   152: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   155: invokestatic 380	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
      //   158: pop
      //   159: aload_0
      //   160: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   163: iconst_0
      //   164: invokestatic 382	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
      //   167: pop
      //   168: return
      //   169: iconst_0
      //   170: istore 5
      //   172: goto -127 -> 45
      //   175: aload_2
      //   176: ldc_w 384
      //   179: iconst_0
      //   180: invokevirtual 343	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
      //   183: ifne +947 -> 1130
      //   186: aload_0
      //   187: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   190: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   193: invokevirtual 58	java/util/ArrayList:size	()I
      //   196: istore_3
      //   197: aload_2
      //   198: ldc_w 386
      //   201: invokevirtual 390	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
      //   204: astore 11
      //   206: aload_2
      //   207: ldc_w 392
      //   210: invokevirtual 396	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   213: astore 12
      //   215: aload_0
      //   216: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   219: aload_2
      //   220: ldc_w 398
      //   223: aconst_null
      //   224: invokevirtual 401	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      //   227: invokestatic 404	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Ljava/lang/String;)Ljava/lang/String;
      //   230: pop
      //   231: new 227	java/lang/StringBuilder
      //   234: dup
      //   235: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   238: ldc_w 406
      //   241: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   244: aload 12
      //   246: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   249: ldc_w 408
      //   252: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   255: aload_0
      //   256: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   259: invokestatic 411	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
      //   262: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   265: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   268: invokestatic 416	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayActivity:nX	(Ljava/lang/String;)V
      //   271: aload_0
      //   272: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   275: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   278: invokevirtual 58	java/util/ArrayList:size	()I
      //   281: ifle +537 -> 818
      //   284: aload_0
      //   285: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   288: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   291: iconst_0
      //   292: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   295: checkcast 29	com/tencent/biz/pubaccount/VideoInfo
      //   298: astore 10
      //   300: aload_2
      //   301: ldc_w 418
      //   304: invokevirtual 170	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
      //   307: checkcast 29	com/tencent/biz/pubaccount/VideoInfo
      //   310: astore 13
      //   312: aload 10
      //   314: ifnull +105 -> 419
      //   317: aload_0
      //   318: getfield 20	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:apI	Z
      //   321: ifne +98 -> 419
      //   324: aload 13
      //   326: ifnull +93 -> 419
      //   329: aload_0
      //   330: aload 10
      //   332: aload 13
      //   334: aload_2
      //   335: invokespecial 420	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:a	(Lcom/tencent/biz/pubaccount/VideoInfo;Lcom/tencent/biz/pubaccount/VideoInfo;Landroid/os/Bundle;)V
      //   338: aload 10
      //   340: aload 13
      //   342: invokevirtual 422	com/tencent/biz/pubaccount/VideoInfo:a	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
      //   345: aload_0
      //   346: iconst_1
      //   347: putfield 20	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:apI	Z
      //   350: iload_3
      //   351: iconst_1
      //   352: if_icmpne +43 -> 395
      //   355: aload_0
      //   356: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   359: invokestatic 372	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$h;
      //   362: ifnull +33 -> 395
      //   365: aload_0
      //   366: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   369: invokestatic 425	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmxu;
      //   372: ifnull +23 -> 395
      //   375: aload_0
      //   376: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   379: invokestatic 425	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmxu;
      //   382: aload 10
      //   384: aload_0
      //   385: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   388: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   391: iconst_1
      //   392: invokevirtual 433	mxu:a	(Lcom/tencent/biz/pubaccount/VideoInfo;Lmtg$l;Z)V
      //   395: aload_0
      //   396: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   399: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   402: aload 10
      //   404: invokevirtual 221	mtg:i	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
      //   407: aload_0
      //   408: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   411: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   414: aload 10
      //   416: invokevirtual 436	mtg:h	(Lcom/tencent/biz/pubaccount/VideoInfo;)V
      //   419: aload_0
      //   420: aload 11
      //   422: invokespecial 194	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:s	(Ljava/util/List;)Z
      //   425: istore_1
      //   426: aload_0
      //   427: aload 11
      //   429: iload_1
      //   430: invokespecial 438	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:o	(Ljava/util/ArrayList;Z)V
      //   433: aload_0
      //   434: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   437: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   440: iconst_3
      //   441: invokevirtual 218	mtg:sy	(I)V
      //   444: aload_0
      //   445: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   448: invokestatic 348	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   451: ifne +19 -> 470
      //   454: iload_3
      //   455: iconst_1
      //   456: if_icmpne +14 -> 470
      //   459: iload_1
      //   460: ifeq +10 -> 470
      //   463: aload_0
      //   464: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   467: invokestatic 441	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)V
      //   470: aload_0
      //   471: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   474: aload 12
      //   476: invokestatic 443	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Ljava/lang/String;)Ljava/lang/String;
      //   479: pop
      //   480: aload_0
      //   481: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   484: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   487: invokevirtual 58	java/util/ArrayList:size	()I
      //   490: iload_3
      //   491: isub
      //   492: istore 4
      //   494: aload_0
      //   495: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   498: invokestatic 446	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmss;
      //   501: ifnull +23 -> 524
      //   504: aload_0
      //   505: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   508: invokestatic 446	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmss;
      //   511: iload_1
      //   512: iload 4
      //   514: aload_0
      //   515: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   518: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   521: invokevirtual 451	mss:a	(ZILjava/util/ArrayList;)V
      //   524: iload 4
      //   526: ifle +144 -> 670
      //   529: aload_0
      //   530: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   533: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
      //   536: invokevirtual 454	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:qa	()I
      //   539: iflt +285 -> 824
      //   542: aload_0
      //   543: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   546: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
      //   549: invokevirtual 454	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:qa	()I
      //   552: iload_3
      //   553: if_icmpne +271 -> 824
      //   556: aload_0
      //   557: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   560: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   563: iload_3
      //   564: invokevirtual 457	mtg:notifyItemChanged	(I)V
      //   567: iload 4
      //   569: iconst_1
      //   570: isub
      //   571: ifle +20 -> 591
      //   574: aload_0
      //   575: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   578: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   581: iload_3
      //   582: iconst_1
      //   583: iadd
      //   584: iload 4
      //   586: iconst_1
      //   587: isub
      //   588: invokevirtual 461	mtg:notifyItemRangeInserted	(II)V
      //   591: invokestatic 466	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   594: ifeq +13 -> 607
      //   597: ldc_w 468
      //   600: iconst_2
      //   601: ldc_w 470
      //   604: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   607: invokestatic 466	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   610: ifeq +60 -> 670
      //   613: ldc_w 468
      //   616: iconst_2
      //   617: new 227	java/lang/StringBuilder
      //   620: dup
      //   621: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   624: ldc_w 475
      //   627: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: iload_3
      //   631: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   634: ldc_w 477
      //   637: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   640: aload_0
      //   641: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   644: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
      //   647: invokevirtual 454	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:qa	()I
      //   650: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   653: ldc_w 479
      //   656: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: iload 4
      //   661: invokevirtual 240	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   664: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   667: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   670: aload_0
      //   671: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   674: invokestatic 482	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lkcr;
      //   677: ifnull -616 -> 61
      //   680: aload_0
      //   681: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   684: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   687: ifnull -626 -> 61
      //   690: aload_0
      //   691: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   694: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   697: invokevirtual 490	mud:a	()Lmuc;
      //   700: ifnull -639 -> 61
      //   703: aload_0
      //   704: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   707: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   710: invokevirtual 490	mud:a	()Lmuc;
      //   713: invokestatic 495	knd:a	(Lmuc;)Z
      //   716: ifne -655 -> 61
      //   719: aload_2
      //   720: ldc_w 497
      //   723: invokevirtual 390	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
      //   726: astore 10
      //   728: iload_3
      //   729: iconst_1
      //   730: isub
      //   731: ifge +109 -> 840
      //   734: iconst_0
      //   735: istore_3
      //   736: aload 13
      //   738: ifnull +32 -> 770
      //   741: aload 13
      //   743: getfield 500	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
      //   746: astore_2
      //   747: aload 10
      //   749: ifnull +21 -> 770
      //   752: aload_2
      //   753: ifnull +17 -> 770
      //   756: aload_2
      //   757: getfield 505	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:aHj	I
      //   760: ifne +10 -> 770
      //   763: aload 10
      //   765: iconst_0
      //   766: aload_2
      //   767: invokevirtual 508	java/util/ArrayList:add	(ILjava/lang/Object;)V
      //   770: aload 10
      //   772: ifnull -711 -> 61
      //   775: aload 10
      //   777: invokevirtual 510	java/util/ArrayList:isEmpty	()Z
      //   780: ifne -719 -> 61
      //   783: aload 10
      //   785: invokevirtual 511	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   788: astore_2
      //   789: aload_2
      //   790: invokeinterface 254 1 0
      //   795: ifeq +52 -> 847
      //   798: aload_2
      //   799: invokeinterface 258 1 0
      //   804: checkcast 502	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo
      //   807: iload_3
      //   808: putfield 514	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:pos	I
      //   811: iload_3
      //   812: iconst_1
      //   813: iadd
      //   814: istore_3
      //   815: goto -26 -> 789
      //   818: aconst_null
      //   819: astore 10
      //   821: goto -521 -> 300
      //   824: aload_0
      //   825: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   828: invokestatic 42	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg;
      //   831: iload_3
      //   832: iload 4
      //   834: invokevirtual 461	mtg:notifyItemRangeInserted	(II)V
      //   837: goto -230 -> 607
      //   840: iload_3
      //   841: iconst_1
      //   842: isub
      //   843: istore_3
      //   844: goto -108 -> 736
      //   847: aload_0
      //   848: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   851: invokestatic 517	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)J
      //   854: lstore 8
      //   856: aload_0
      //   857: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   860: invokestatic 312	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/mobileqq/app/QQAppInterface;
      //   863: astore_2
      //   864: lload 8
      //   866: lstore 6
      //   868: lload 8
      //   870: lconst_0
      //   871: lcmp
      //   872: ifne +20 -> 892
      //   875: lload 8
      //   877: lstore 6
      //   879: aload_2
      //   880: ifnull +12 -> 892
      //   883: aload_2
      //   884: invokevirtual 522	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
      //   887: invokestatic 528	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   890: lstore 6
      //   892: aload_0
      //   893: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   896: invokestatic 531	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmyc;
      //   899: ifnull +226 -> 1125
      //   902: aload_0
      //   903: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   906: invokestatic 534	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/VideoInfo;
      //   909: ifnull +216 -> 1125
      //   912: aload_0
      //   913: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   916: invokestatic 531	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmyc;
      //   919: aload_0
      //   920: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   923: invokestatic 534	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/VideoInfo;
      //   926: getfield 107	com/tencent/biz/pubaccount/VideoInfo:Wz	Ljava/lang/String;
      //   929: invokevirtual 539	myc:eV	(Ljava/lang/String;)Ljava/lang/String;
      //   932: astore_2
      //   933: aload_0
      //   934: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   937: iconst_1
      //   938: invokestatic 382	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:d	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;Z)Z
      //   941: pop
      //   942: aload_0
      //   943: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   946: invokestatic 482	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lkcr;
      //   949: aload_0
      //   950: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   953: invokestatic 542	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j;
      //   956: lload 6
      //   958: aload_0
      //   959: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   962: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   965: iconst_0
      //   966: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   969: checkcast 29	com/tencent/biz/pubaccount/VideoInfo
      //   972: aload_0
      //   973: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   976: invokestatic 544	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
      //   979: aload_0
      //   980: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   983: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   986: aload_0
      //   987: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   990: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   993: iconst_0
      //   994: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   997: checkcast 29	com/tencent/biz/pubaccount/VideoInfo
      //   1000: getfield 98	com/tencent/biz/pubaccount/VideoInfo:WA	Ljava/lang/String;
      //   1003: aload_0
      //   1004: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1007: invokestatic 546	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)J
      //   1010: iconst_1
      //   1011: iconst_0
      //   1012: aload_0
      //   1013: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1016: invokestatic 548	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
      //   1019: aload_0
      //   1020: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1023: invokestatic 550	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:c	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/lang/String;
      //   1026: aconst_null
      //   1027: aload_0
      //   1028: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1031: invokestatic 320	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:b	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)I
      //   1034: aload_2
      //   1035: aload_0
      //   1036: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1039: invokestatic 553	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)[B
      //   1042: aload 10
      //   1044: aload_0
      //   1045: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1048: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   1051: invokevirtual 556	mud:pM	()I
      //   1054: aload_0
      //   1055: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1058: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   1061: invokevirtual 559	mud:pN	()I
      //   1064: iconst_0
      //   1065: new 54	java/util/ArrayList
      //   1068: dup
      //   1069: aload_0
      //   1070: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1073: invokestatic 561	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/HashSet;
      //   1076: invokespecial 564	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
      //   1079: invokevirtual 569	kcr:a	(Lkcs;JLcom/tencent/biz/pubaccount/VideoInfo;ILjava/util/ArrayList;Ljava/lang/String;JZILjava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/WeishiRedDotInfo;ILjava/lang/String;[BLjava/util/ArrayList;IIILjava/util/ArrayList;)V
      //   1082: goto -1021 -> 61
      //   1085: astore_2
      //   1086: invokestatic 466	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1089: ifeq -1028 -> 61
      //   1092: ldc_w 468
      //   1095: iconst_2
      //   1096: new 227	java/lang/StringBuilder
      //   1099: dup
      //   1100: invokespecial 228	java/lang/StringBuilder:<init>	()V
      //   1103: ldc_w 571
      //   1106: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1109: aload_2
      //   1110: invokevirtual 574	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1113: invokevirtual 234	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1116: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1119: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1122: goto -1061 -> 61
      //   1125: aconst_null
      //   1126: astore_2
      //   1127: goto -194 -> 933
      //   1130: aload_2
      //   1131: ldc_w 576
      //   1134: invokevirtual 390	android/os/Bundle:getParcelableArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
      //   1137: astore_2
      //   1138: aload_2
      //   1139: ifnull +10 -> 1149
      //   1142: aload_2
      //   1143: invokevirtual 510	java/util/ArrayList:isEmpty	()Z
      //   1146: ifeq +20 -> 1166
      //   1149: invokestatic 466	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
      //   1152: ifeq -984 -> 168
      //   1155: ldc_w 468
      //   1158: iconst_2
      //   1159: ldc_w 578
      //   1162: invokestatic 473	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
      //   1165: return
      //   1166: aload_0
      //   1167: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1170: invokestatic 201	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Ljava/util/ArrayList;
      //   1173: invokevirtual 511	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   1176: astore 10
      //   1178: aload 10
      //   1180: invokeinterface 254 1 0
      //   1185: ifeq +83 -> 1268
      //   1188: aload 10
      //   1190: invokeinterface 258 1 0
      //   1195: checkcast 29	com/tencent/biz/pubaccount/VideoInfo
      //   1198: astore 11
      //   1200: aload 11
      //   1202: getfield 500	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
      //   1205: ifnull -27 -> 1178
      //   1208: aload 11
      //   1210: getfield 500	com/tencent/biz/pubaccount/VideoInfo:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$AdTagInfo	Lcom/tencent/biz/pubaccount/VideoInfo$AdTagInfo;
      //   1213: getfield 581	com/tencent/biz/pubaccount/VideoInfo$AdTagInfo:rowkey	Ljava/lang/String;
      //   1216: astore 12
      //   1218: iconst_0
      //   1219: istore_3
      //   1220: iload_3
      //   1221: aload_2
      //   1222: invokevirtual 58	java/util/ArrayList:size	()I
      //   1225: if_icmpge -47 -> 1178
      //   1228: aload_2
      //   1229: iload_3
      //   1230: invokevirtual 205	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   1233: checkcast 583	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
      //   1236: astore 13
      //   1238: aload 13
      //   1240: getfield 586	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mRowKey	Ljava/lang/String;
      //   1243: aload 12
      //   1245: invokevirtual 591	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1248: ifeq +13 -> 1261
      //   1251: aload 11
      //   1253: aload 13
      //   1255: putfield 595	com/tencent/biz/pubaccount/VideoInfo:advertisementInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;
      //   1258: goto -80 -> 1178
      //   1261: iload_3
      //   1262: iconst_1
      //   1263: iadd
      //   1264: istore_3
      //   1265: goto -45 -> 1220
      //   1268: aload_0
      //   1269: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1272: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   1275: ifnull +69 -> 1344
      //   1278: aload_0
      //   1279: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1282: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1285: ifnull +59 -> 1344
      //   1288: aload_0
      //   1289: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1292: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1295: getfield 600	mtg$l:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1298: ifnull +46 -> 1344
      //   1301: aload_0
      //   1302: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1305: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1308: getfield 600	mtg$l:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1311: getfield 605	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   1314: ifnull +30 -> 1344
      //   1317: aload_0
      //   1318: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1321: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1324: astore_2
      //   1325: aload_0
      //   1326: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1329: invokestatic 485	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmud;
      //   1332: aload_2
      //   1333: aload_0
      //   1334: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1337: invokestatic 608	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:e	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   1340: invokevirtual 611	mud:a	(Lmtg$l;Z)Z
      //   1343: pop
      //   1344: aload_0
      //   1345: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1348: invokestatic 614	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmxm;
      //   1351: ifnull -1290 -> 61
      //   1354: aload_0
      //   1355: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1358: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1361: ifnull -1300 -> 61
      //   1364: aload_0
      //   1365: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1368: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1371: getfield 600	mtg$l:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1374: ifnull -1313 -> 61
      //   1377: aload_0
      //   1378: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1381: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1384: getfield 600	mtg$l:a	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b;
      //   1387: getfield 605	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsPlayManager$b:d	Lcom/tencent/biz/pubaccount/VideoInfo;
      //   1390: ifnull -1329 -> 61
      //   1393: aload_0
      //   1394: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1397: invokestatic 428	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmtg$l;
      //   1400: astore_2
      //   1401: aload_0
      //   1402: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1405: invokestatic 614	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lmxm;
      //   1408: aload_2
      //   1409: aload_0
      //   1410: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1413: invokestatic 608	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:e	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Z
      //   1416: dconst_0
      //   1417: lconst_0
      //   1418: invokevirtual 619	mxm:a	(Lmtg$l;ZDJ)V
      //   1421: goto -1360 -> 61
      //   1424: aload_0
      //   1425: getfield 15	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment$j:this$0	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;
      //   1428: invokestatic 364	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment:a	(Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecommendFragment;)Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView;
      //   1431: iconst_1
      //   1432: invokevirtual 369	com/tencent/biz/pubaccount/readinjoy/video/VideoFeedsRecyclerView:setScrollable	(Z)V
      //   1435: goto -1320 -> 115
      //   1438: astore_2
      //   1439: lload 8
      //   1441: lstore 6
      //   1443: goto -551 -> 892
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1446	0	this	j
      //   0	1446	1	paramBoolean	boolean
      //   0	1446	2	paramBundle	Bundle
      //   196	1069	3	i	int
      //   492	341	4	j	int
      //   43	128	5	bool	boolean
      //   866	576	6	l1	long
      //   854	586	8	l2	long
      //   20	1169	10	localObject1	Object
      //   204	1048	11	localObject2	Object
      //   213	1031	12	str	String
      //   310	944	13	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   670	728	1085	java/lang/Exception
      //   741	747	1085	java/lang/Exception
      //   756	770	1085	java/lang/Exception
      //   775	789	1085	java/lang/Exception
      //   789	811	1085	java/lang/Exception
      //   847	864	1085	java/lang/Exception
      //   892	933	1085	java/lang/Exception
      //   933	1082	1085	java/lang/Exception
      //   883	892	1438	java/lang/Exception
    }
  }
  
  class k
    extends RecyclerView.OnScrollListener
    implements RecyclerView.OnItemTouchListener
  {
    private int aVr = 0;
    private boolean apJ;
    private boolean apK;
    
    private k() {}
    
    public boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return false;
      case 0: 
        this.apJ = true;
        return false;
      }
      this.apJ = false;
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
    
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      if (paramInt == 0)
      {
        txn.a().stopMonitorScene("list_video_feeds", false);
        if ((!this.apJ) || (this.aVr != 0) || (paramInt != 1)) {
          break label91;
        }
      }
      label91:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          this.apK = true;
          VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this);
        }
        if ((!this.apJ) && (this.aVr == 0) && (paramInt == 2)) {
          this.apK = false;
        }
        this.aVr = paramInt;
        return;
        txn.a().startMonitorScene("list_video_feeds");
        break;
      }
    }
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).ak();
      if (paramRecyclerView != null)
      {
        paramRecyclerView = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getChildViewHolder(paramRecyclerView);
        RecyclerView.ViewHolder localViewHolder1 = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() - 1);
        RecyclerView.ViewHolder localViewHolder2 = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).findViewHolderForLayoutPosition(paramRecyclerView.getLayoutPosition() + 1);
        if ((paramRecyclerView instanceof mtg.e)) {
          ((mtg.e)paramRecyclerView).a(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), true);
        }
        if ((localViewHolder1 instanceof mtg.e)) {
          ((mtg.e)localViewHolder1).a(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), false);
        }
        if ((localViewHolder2 instanceof mtg.e)) {
          ((mtg.e)localViewHolder2).a(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this), false);
        }
      }
    }
    
    public void onTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent) {}
  }
  
  public class l
    implements VideoFeedsPlayManager.d
  {
    private l() {}
    
    public void a(VideoFeedsPlayManager.b paramb)
    {
      if ((naa.a().b(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.e)) && (awit.J(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this))) && (paramb == VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b))
      {
        int i = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv;
        int j = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getHeaderViewsCount();
        Object localObject = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).findViewHolderForLayoutPosition(i + j + 1);
        if ((localObject instanceof mtg.g))
        {
          localObject = (mtg.g)localObject;
          if (((mtg.g)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b != null) {
            VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).m(((mtg.g)localObject).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b);
          }
        }
      }
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv == 0) && (paramb.d.busiType == 0)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_Mxy.sL(3);
      }
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).E(paramb.d.Wz, VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getVideoDuration());
      }
    }
    
    public void a(VideoFeedsPlayManager.b paramb, int paramInt) {}
    
    public void a(VideoFeedsPlayManager.b paramb, int paramInt1, int paramInt2, String paramString)
    {
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aOJ();
      }
    }
    
    public void b(VideoFeedsPlayManager.b paramb)
    {
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
        VideoFeedsAccessibilityHelper.n(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jO, false);
      }
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).E(paramb.d.Wz, VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getVideoDuration());
      }
    }
    
    public void d(VideoFeedsPlayManager.b paramb)
    {
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) {
        VideoFeedsAccessibilityHelper.n(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jO, true);
      }
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aOJ();
      }
    }
    
    public void g(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
    {
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aOJ();
      }
    }
    
    public void h(VideoFeedsPlayManager.b paramb, boolean paramBoolean)
    {
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD) && (paramBoolean)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).E(paramb.d.Wz, VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getVideoDuration());
      }
    }
    
    public void i(VideoFeedsPlayManager.b paramb)
    {
      if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (!paramb.d.isAD)) {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aOJ();
      }
    }
    
    public void q(VideoFeedsPlayManager.b paramb) {}
    
    public void r(VideoFeedsPlayManager.b paramb)
    {
      boolean bool;
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null)
      {
        bool = VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).Ex();
        VideoFeedsPlayActivity.nX("video play completion!, in weishi mode! interrupted weishi ad");
        if (!bool) {}
      }
      do
      {
        do
        {
          return;
          VideoFeedsPlayActivity.nX("video play completion!, move to next position");
          bool = VideoFeedsRecommendFragment.e(VideoFeedsRecommendFragment.this);
          if (VideoFeedsRecommendFragment.b(VideoFeedsRecommendFragment.this))
          {
            if (bool)
            {
              VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aTn();
              return;
            }
            VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_Mxy.sL(5);
            return;
          }
          if (VideoFeedsRecommendFragment.e(VideoFeedsRecommendFragment.this))
          {
            if ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) != null) && (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a() != null))
            {
              VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).b(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayManager$b.d));
              VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aTg();
              return;
            }
            VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aTn();
          }
          if ((paramb == null) || (paramb.d == null) || (!paramb.d.isAD) || (jzk.a(paramb.d.b).mShowAdButton)) {
            break;
          }
        } while ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) == null) || (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a() == null) || (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this) == null));
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aRE();
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).e(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).a());
        return;
      } while ((VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).b(paramb)) || (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).aUv == VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).size() - 1) || ((!VideoFeedsRecommendFragment.g(VideoFeedsRecommendFragment.this)) && (aqiw.isMobileNetWork(VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).getApplication().getApplicationContext()))));
      if (VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).El())
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this, true);
        return;
      }
      if (bool)
      {
        VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).addOnLayoutChangeListener(new mwb(this));
        return;
      }
      VideoFeedsRecommendFragment.a(VideoFeedsRecommendFragment.this).EK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */