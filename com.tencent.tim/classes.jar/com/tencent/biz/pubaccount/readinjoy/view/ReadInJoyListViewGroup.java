package com.tencent.biz.pubaccount.readinjoy.view;

import acfd;
import acnm;
import aifd;
import aifl;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anwa;
import aqdf;
import aqiw;
import aqiz;
import aqmj;
import awit;
import ayxa;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.SerializableMap;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyLockScreenJumpDelegate;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoyJumpActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.c;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentVerticalSmallVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.b;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.q;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.t;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.u;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.a;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ChannelTopPositionView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.ListView;
import com.tencent.widget.XListView.a;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jzh;
import jzk;
import kbp;
import kct;
import kfn;
import kfr;
import kfv;
import kge;
import kgq;
import kgw;
import kku.a;
import klu;
import knd;
import knj;
import kpp;
import kqd;
import kqo;
import ksz;
import kvp;
import kvs;
import kvx;
import kws;
import kwz;
import kxa;
import kxj;
import kxm;
import kxt;
import kyo;
import kys;
import kzw;
import lbz;
import lcc;
import lcd;
import lce;
import lcm;
import lcm.k;
import lcr;
import lft;
import lfx;
import lfy;
import lfz;
import lgb;
import lgd;
import lge;
import lgf.f;
import lgp;
import lgy;
import lhk;
import lhn;
import lhu;
import lil;
import lrm;
import luq.a;
import lwh;
import lwm;
import mde;
import meu;
import mfo;
import mgn;
import mgu;
import mhr;
import mhr.a;
import mhr.d;
import mhs;
import mhu;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mst;
import msv;
import muj;
import mye;
import mye.b;
import myp;
import mza.b;
import mzj;
import nce;
import nce.a;
import ndh;
import ndi;
import ndi.a;
import ndi.b;
import ndi.c;
import ndi.d;
import nfd;
import nfg;
import nfh;
import nfi;
import nfj;
import nfk;
import nfl;
import nfn;
import nfo;
import nfp;
import nfq;
import nfr;
import nfs;
import nft;
import nfu;
import nfv;
import nfw;
import nfx;
import nfy;
import nfz;
import ngb;
import ngc;
import ngd;
import nge;
import ngf;
import ngg;
import ngh;
import ngi;
import nhz;
import nib;
import nid;
import nnw;
import nny;
import nof;
import npy;
import npy.b;
import ntp;
import ocp;
import odd;
import odj;
import ods;
import odv;
import org.json.JSONException;
import org.json.JSONObject;
import sum;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;
import wja;

public class ReadInJoyListViewGroup
  extends ReadInJoyBaseListViewGroup
  implements View.OnClickListener, ReadInJoyBaseListView.c, AdapterView.c, AdapterView.d, mza.b, ndi.a, ndi.b, ndi.c, ndi.d
{
  private LinearLayout E;
  protected aqdf a;
  private KandianMergeManager.c jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c = new ngc(this);
  a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup$a;
  private SlideActiveAnimController jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController;
  private ChannelTopPositionView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private ChannelTopBanner jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner;
  private XListView.a jdField_a_of_type_ComTencentWidgetXListView$a = new nfz(this);
  private kgq jdField_a_of_type_Kgq;
  private kqd jdField_a_of_type_Kqd;
  kqo jdField_a_of_type_Kqo;
  private mst jdField_a_of_type_Mst;
  private ndh jdField_a_of_type_Ndh;
  private nid jdField_a_of_type_Nid;
  private npy.b jdField_a_of_type_Npy$b;
  private int aIz = 1;
  private int aMR = -1;
  int aRd;
  private int aYo;
  private int aYp;
  private int aYq;
  private boolean aeL;
  private boolean aeM;
  private boolean afo = true;
  private boolean arO = true;
  private boolean arP;
  private boolean arQ;
  private boolean arR;
  private boolean arS;
  private boolean arT;
  private boolean arU;
  private boolean arV;
  private SparseArray<lfz> av;
  private ChannelTopPositionView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView;
  private jzh jdField_b_of_type_Jzh;
  private acfd c = new nge(this);
  Runnable cQ;
  Map<String, KandianProgressView> eD = new HashMap();
  private HashMap<String, Integer> ev = new HashMap();
  private ImageView id;
  boolean isFromAIO = false;
  private lce j;
  private View jH;
  List<KandianProgressView> jU = new ArrayList();
  private List<nny> jW = new ArrayList();
  private lce k = new ngh(this);
  private ArticleInfo l;
  private int mChannelType = -1;
  private AbsListView.e mOnScrollListener = new nfd(this);
  private View mRootView;
  private Handler mUiHandler;
  private long oK;
  private TextView oa;
  private ViewStub r;
  private TextView sY;
  private long xm;
  private long xq;
  private long xr = -1L;
  private long xs;
  private long xt = -1L;
  
  public ReadInJoyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, int paramInt3, kxa paramkxa)
  {
    this(paramkfr, paramInt1, paramInt2, paramInt3, paramkxa, 2131560479);
  }
  
  public ReadInJoyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, int paramInt3, kxa paramkxa, int paramInt4)
  {
    super(paramkfr, paramInt1, paramkxa);
    this.mRootView = getCurrentActivity().getLayoutInflater().inflate(paramInt4, this);
    this.mChannelType = paramInt2;
    this.xm = paramInt3;
    this.afo = muj.Eq();
    setId(2131376754);
    this.av = lgd.a(this);
    initUI(paramInt1);
    if (paramInt1 != 41695) {
      aBi();
    }
    this.jdField_a_of_type_Kxa.sY = awit.s((QQAppInterface)kxm.getAppRuntime());
    a(new nfo(this, "onListViewGroupInited"));
  }
  
  public ReadInJoyListViewGroup(kfr paramkfr, int paramInt1, int paramInt2, kxa paramkxa)
  {
    this(paramkfr, paramInt1, paramInt2, -1, paramkxa);
  }
  
  public ReadInJoyListViewGroup(kfr paramkfr, int paramInt, kxa paramkxa)
  {
    this(paramkfr, paramInt, -1, paramkxa);
  }
  
  private boolean Fs()
  {
    boolean bool = getCurrentActivity().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    getCurrentActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", false);
    return bool;
  }
  
  private boolean Ft()
  {
    List localList = (List)this.jdField_a_of_type_Kfr.getActivity().getIntent().getSerializableExtra("subscription_all_article_id");
    if ((localList != null) && (localList.size() > 0)) {}
    for (long l1 = ((Long)localList.get(0)).longValue(); Long.valueOf(l1).longValue() != 0L; l1 = -1L) {
      return true;
    }
    return false;
  }
  
  private void I(Map<Long, mgu> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (mgu)paramMap.next();
      if (!((mgu)localObject2).amq)
      {
        ((mgu)localObject2).amq = true;
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = kxm.getLongAccountUin();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = ((mgu)localObject2).v.longValue();
        localReportInfo.mChannelId = this.mChannelID;
        localReportInfo.mAlgorithmId = ((int)((mgu)localObject2).mAlgorithmID);
        localReportInfo.mStrategyId = ((mgu)localObject2).mStrategyId;
        localReportInfo.mOperation = 7;
        localReportInfo.mServerContext = ((mgu)localObject2).mServerContext;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = ((mgu)localObject2).agO;
        if (((mgu)localObject2).j.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = ((mgu)localObject2).j.mVideoColumnInfo.aHc;
        }
        Object localObject1;
        if (this.mChannelID == 56)
        {
          localReportInfo.mOpSource = 11;
          localObject1 = new ReportInfo.b();
          if (this.xs != 0L) {
            break label606;
          }
        }
        label606:
        for (int i = 1;; i = 0)
        {
          ((ReportInfo.b)localObject1).aSB = i;
          localObject1 = ((ReportInfo.b)localObject1).toString();
          localReportInfo.mInnerId = ((mgu)localObject2).agO;
          if (QLog.isColorLevel()) {
            QLog.d("VideoReporter", 2, "reportVideoUserOperationByOidbOfFeed--mUin:" + localReportInfo.mUin + "; mSource:" + localReportInfo.mSource + "; mOpSource:" + localReportInfo.mOpSource + "; mInnerId:" + localReportInfo.mInnerId + "; mChannelId:" + localReportInfo.mChannelId + "; mAlgorithmId:" + localReportInfo.mAlgorithmId + "; mStrategyId:" + localReportInfo.mStrategyId + "; mOperation:" + localReportInfo.mOperation + "; mPlayTimeLength:" + localReportInfo.mPlayTimeLength + "; videoExtraRepoerData:" + (String)localObject1);
          }
          if ((((mgu)localObject2).j == null) || (((mgu)localObject2).j.mSocialFeedInfo == null)) {
            break label618;
          }
          localObject1 = new ReportInfo.a();
          ((ReportInfo.a)localObject1).vd = ((mgu)localObject2).j.mSocialFeedInfo.mFeedId;
          if (((mgu)localObject2).j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
            ((ReportInfo.a)localObject1).vg = ((mgu)localObject2).j.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
          }
          ((ReportInfo.a)localObject1).aSx = ((mgu)localObject2).j.mSocialFeedInfo.mLikeCount;
          ((ReportInfo.a)localObject1).aSy = ((mgu)localObject2).j.mSocialFeedInfo.mCommentCount;
          localObject2 = ((mgu)localObject2).j.mSocialFeedInfo.iS;
          if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
            break;
          }
          ((ReportInfo.a)localObject1).iR = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject2).next();
            if (locale != null) {
              ((ReportInfo.a)localObject1).iR.add(Long.valueOf(locale.uin));
            }
          }
        }
        localReportInfo.mFeedsReportData = ((ReportInfo.a)localObject1);
        label618:
        localArrayList.add(localReportInfo);
      }
    }
    if (!localArrayList.isEmpty()) {
      lbz.a().cb(localArrayList);
    }
  }
  
  private boolean N(boolean paramBoolean)
  {
    if ((this.mChannelID == 56) && (!this.jdField_a_of_type_Ndh.isResume())) {
      return false;
    }
    long l2 = System.currentTimeMillis();
    boolean bool3;
    boolean bool6;
    Object localObject2;
    Object localObject1;
    if (this.jdField_a_of_type_Ndh.getCount() == 0)
    {
      bool3 = true;
      bool6 = kfv.db(this.mChannelID);
      if (!zn()) {
        break label834;
      }
      localObject2 = ((BaseActivity)getCurrentActivity()).app;
      localObject1 = (KandianMergeManager)((QQAppInterface)localObject2).getManager(162);
      if ((this.mChannelID != 70) && (!kys.dv(this.mChannelID))) {
        break label666;
      }
      paramBoolean = getCurrentActivity().getIntent().hasExtra("kandian_feeds_red_pnt_info");
    }
    for (;;)
    {
      label113:
      long l1;
      label147:
      boolean bool4;
      label183:
      boolean bool7;
      boolean bool2;
      label206:
      boolean bool5;
      label243:
      boolean bool1;
      if (this.mChannelID == 70)
      {
        l1 = ((Integer)awit.f("sp_key_kandian_subscribe_auto_refresh_config", Integer.valueOf(600))).intValue() * 1000;
        if (kys.dt(this.mChannelID)) {
          l1 = dj();
        }
        if (System.currentTimeMillis() - this.jdField_a_of_type_Kxa.sZ <= l1) {
          break label743;
        }
        bool4 = true;
        bool7 = zm();
        if ((!Fu()) || (this.arU)) {
          break label749;
        }
        bool2 = true;
        if ((!awit.aMH()) || (this.mChannelID != 56) || (this.xm != 1001L) || (!((KandianMergeManager)localObject1).BB())) {
          break label755;
        }
        bool5 = true;
        localObject1 = getCurrentActivity();
        if (localObject1 != null)
        {
          localObject1 = ((Activity)localObject1).getIntent();
          if (localObject1 != null)
          {
            if (((Intent)localObject1).getIntExtra("launch_from", 0) != 15) {
              break label761;
            }
            bool1 = true;
            label283:
            this.isFromAIO = bool1;
          }
        }
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!this.isFromAIO)) {
          break label767;
        }
        bool1 = true;
        label328:
        QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5) }));
        if (!zl()) {
          break label779;
        }
        bool4 = kfv.dd(this.mChannelID);
        if ((!bool3) && (!bool4) && (!bool7) && (!paramBoolean) && (!bool2) && (!bool5) && (!bool6)) {
          break label773;
        }
        bool1 = true;
        label475:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, isLastExitChannelOverTimeLimit=%s, hasChannelMap=%s, hasPushMsg=%s, needForceInsertFresh=%s, hasRed=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool7), Boolean.valueOf(paramBoolean), Boolean.valueOf(bool2), Boolean.valueOf(bool5), Boolean.valueOf(bool6) }));
        paramBoolean = bool1;
      }
      int i;
      for (;;)
      {
        QLog.i("ReadInJoyListViewGroup", 1, "[loadFinishedRefresh], forceRefresh = " + paramBoolean);
        if ((!paramBoolean) && (!lfx.dH(this.mChannelID))) {
          break label1389;
        }
        i = 1;
        label604:
        if (i == 0) {
          break label1403;
        }
        if ((this.mChannelID == 0) || (kys.dv(this.mChannelID))) {
          lcm.a().a.ajn = true;
        }
        if ((!kys.dv(this.mChannelID)) || (kys.Bk())) {
          break label1394;
        }
        d(true, 1, false);
        label658:
        return true;
        bool3 = false;
        break;
        label666:
        if (this.mChannelID == 40677)
        {
          localObject2 = (lcr)((QQAppInterface)localObject2).getManager(274);
          if ((((lcr)localObject2).aF() != null) && (((lcr)localObject2).aF().size() > 0)) {}
          for (paramBoolean = true;; paramBoolean = false) {
            break;
          }
        }
        if (this.mChannelID != 40830) {
          break label1458;
        }
        paramBoolean = true;
        break label113;
        l1 = 300000L;
        break label147;
        label743:
        bool4 = false;
        break label183;
        label749:
        bool2 = false;
        break label206;
        label755:
        bool5 = false;
        break label243;
        label761:
        bool1 = false;
        break label283;
        label767:
        bool1 = false;
        break label328;
        label773:
        bool1 = false;
        break label475;
        label779:
        paramBoolean = bool1;
        if (this.mChannelID != 70)
        {
          paramBoolean = bool1;
          if (this.mChannelID != 56)
          {
            paramBoolean = bool1;
            if (this.mChannelID != 40677)
            {
              paramBoolean = bool1;
              if (!kys.dv(this.mChannelID)) {
                paramBoolean = true;
              }
            }
          }
        }
      }
      label834:
      localObject1 = ((BaseActivity)getCurrentActivity()).app;
      localObject2 = (KandianMergeManager)((QQAppInterface)localObject1).getManager(162);
      label874:
      boolean bool8;
      label895:
      int m;
      if (awit.cA((QQAppInterface)localObject1))
      {
        bool1 = ((KandianMergeManager)localObject2).Bw();
        bool8 = getCurrentActivity() instanceof ReadInJoyNewFeedsActivity;
        if (!bool8) {
          break label1187;
        }
        l1 = awit.h((AppRuntime)localObject1);
        if (System.currentTimeMillis() - this.jdField_a_of_type_Kxa.sY <= l1) {
          break label1197;
        }
        i = 1;
        label914:
        localObject1 = getCurrentActivity().getIntent();
        bool7 = ((Intent)localObject1).getBooleanExtra("from_search", false);
        if ((!Fw()) || (!((Intent)localObject1).getBooleanExtra("force_refresh", false))) {
          break label1202;
        }
        bool4 = true;
        label956:
        if (Fw()) {
          ((Intent)localObject1).removeExtra("force_refresh");
        }
        if (getCurrentActivity().getIntent().getIntExtra("launch_from", -1) != 8) {
          break label1208;
        }
        m = 1;
        label992:
        if (!zl()) {
          break label1219;
        }
        bool5 = kfv.dd(this.mChannelID);
        if ((!bool3) && (!bool1) && (!bool7) && (!bool5) && (m == 0) && (!bool4) && (!bool6)) {
          break label1213;
        }
        bool2 = true;
        label1045:
        QLog.d("ReadInJoyListViewGroup", 1, String.format("new channel tab, loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, isLastExitChannelOverTimeLimit=%s, isInMessageKandian=%s, fromDaily=%s, isNeedRefreshChannel=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4), Boolean.valueOf(bool6) }));
        if (!bool3) {
          break label1355;
        }
        i = 1;
      }
      for (;;)
      {
        paramBoolean = bool2;
        if (!bool2) {
          break;
        }
        kxm.pW(i);
        paramBoolean = bool2;
        break;
        localObject2 = bg();
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          bool1 = true;
          break label874;
        }
        bool1 = false;
        break label874;
        label1187:
        l1 = awit.g((AppRuntime)localObject1);
        break label895;
        label1197:
        i = 0;
        break label914;
        label1202:
        bool4 = false;
        break label956;
        label1208:
        m = 0;
        break label992;
        label1213:
        bool2 = false;
        break label1045;
        label1219:
        if ((bool3) || (bool1) || (bool7) || ((i != 0) && (paramBoolean)) || (m != 0) || (bool4))
        {
          bool2 = true;
          label1254:
          if ((i == 0) || (!paramBoolean)) {
            break label1349;
          }
        }
        label1349:
        for (bool5 = true;; bool5 = false)
        {
          QLog.d("ReadInJoyListViewGroup", 1, String.format("loadFinishedRefresh forceRefresh=%s, isDBCacheEmpty=%s, hasPushMsg=%s, fromSearch=%s, lastExitKandianOver10min=%s, isInMessageKandian=%s, fromDaily=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Boolean.valueOf(bool7), Boolean.valueOf(bool5), Boolean.valueOf(bool8), Boolean.valueOf(bool4) }));
          break;
          bool2 = false;
          break label1254;
        }
        label1355:
        if (bool1)
        {
          i = 1;
        }
        else if (bool7)
        {
          i = 1;
        }
        else
        {
          if ((i != 0) && (paramBoolean))
          {
            i = 6;
            continue;
            label1389:
            i = 0;
            break label604;
            label1394:
            O(true, 2);
            break label658;
            label1403:
            localObject1 = this.jdField_a_of_type_Kxa;
            if (this.jdField_a_of_type_Kxa.sT == 0L) {}
            for (l1 = l2;; l1 = this.jdField_a_of_type_Kxa.sT)
            {
              ((kxa)localObject1).sT = l1;
              if (this.mChannelID == 0) {}
              return false;
            }
          }
          i = 1;
        }
      }
      label1458:
      paramBoolean = false;
    }
  }
  
  private void Q(boolean paramBoolean, int paramInt)
  {
    if (Fs())
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aXd();
      return;
    }
    String str;
    if (this.mChannelID == 70) {
      if ((paramBoolean) && (paramInt > 0)) {
        str = getResources().getString(2131718424);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.t(true, str);
      aWE();
      if (!awit.aMG()) {
        break;
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.28(this), 1500L);
      return;
      str = getResources().getString(2131718423);
      continue;
      if (this.mChannelID == 40677)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt * 2) });
        } else {
          str = getResources().getString(2131718335);
        }
      }
      else if (this.mChannelID == 40531)
      {
        if ((paramBoolean) && (paramInt > 0)) {
          str = String.format(getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt) });
        } else {
          str = getResources().getString(2131718334);
        }
      }
      else if ((paramBoolean) && (paramInt > 0)) {
        str = String.format(getResources().getString(2131718336), new Object[] { Integer.valueOf(paramInt) });
      } else {
        str = getResources().getString(2131718335);
      }
    }
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, false, 0, 0, false, paramInt);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramContext, paramBaseAdapter, paramArticleInfo, true, paramInt1, paramInt2, paramBoolean, 1);
  }
  
  public static void a(Context paramContext, BaseAdapter paramBaseAdapter, ArticleInfo paramArticleInfo, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramArticleInfo.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramArticleInfo.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    boolean bool;
    if (!ndi.aa(paramArticleInfo))
    {
      bool = true;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", bool);
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO", paramArticleInfo);
      paramInt3 = ndi.k(paramArticleInfo);
      if ((!paramBoolean1) || ((paramInt3 != 6) && (paramInt3 != 28) && (paramInt3 != 71))) {
        break label247;
      }
      localIntent.putExtra("is_need_show_animation_translate", true);
      localIntent.putExtra("is_need_show_animation_adapter", true);
      if (paramBoolean2)
      {
        localIntent.putExtra("view_translation_animation_top", paramInt1);
        localIntent.putExtra("view_translation_animation_left", paramInt2);
      }
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      kct.cZ.put(ReadInJoyChannelActivity.class, kct.ic());
      mzj.a().g(false, "jumpFromKandianFeed", 1);
      return;
      bool = false;
      break;
      label247:
      if (paramBaseAdapter != null) {
        paramBaseAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView)
  {
    if (kxm.B(paramArticleInfo))
    {
      b(paramArticleInfo, paramView);
      return;
    }
    mye.b localb = new mye.b();
    localb.articleID = paramArticleInfo.mArticleID;
    localb.fileSize = paramArticleInfo.mXGFileSize;
    localb.thirdUin = paramArticleInfo.thirdUin;
    localb.thirdUinName = paramArticleInfo.thirdUinName;
    localb.puin = paramArticleInfo.mSubscribeID;
    localb.strategyId = paramArticleInfo.mStrategyId;
    localb.algorithmID = paramArticleInfo.mAlgorithmID;
    mhu localmhu = new mhu();
    localmhu.w = Long.valueOf(paramArticleInfo.mArticleID);
    localmhu.rowkey = paramArticleInfo.innerUniqueID;
    label403:
    Object localObject;
    if (((!ndi.ak(paramArticleInfo)) && (!ndi.S(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) || ((!ndi.aa(paramArticleInfo)) || ((kxm.u(paramArticleInfo)) && (!ndi.aa(paramArticleInfo)))))
    {
      localb.aDs = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aSY;
      localb.videoWidth = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTc;
      localb.videoHeight = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aTd;
      localmhu.busiType = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aSY;
      localb.videoDuration = ((int)(((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).duration / 1000L));
      localb.videoCoverUrl = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url;
      localb.akK = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).aim;
      localb.videoVid = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).vid;
      if ((kxm.r(paramArticleInfo)) && (kxm.j(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localb.videoCoverUrl = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localmhu.vid = paramArticleInfo.mVideoVid;
        localb.c = localmhu;
        localb.thirdIcon = paramArticleInfo.thirdIcon;
        localb.thirdName = paramArticleInfo.thirdName;
        localb.thirdAction = paramArticleInfo.thirdAction;
        if (paramView != null)
        {
          localObject = new int[2];
          paramView.getLocationOnScreen((int[])localObject);
          localb.aKB = localObject[0];
          localb.aKC = localObject[1];
          localb.viewWidth = paramView.getWidth();
          localb.viewHeight = paramView.getHeight();
          if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).isSingleVideo))
          {
            localObject = kwz.a(3, this.mChannelID);
            int i = localb.aKB;
            localb.aKB = ((localb.viewWidth - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
            localb.viewWidth = ((Integer)((Pair)localObject).first).intValue();
          }
          muj.a(localb, paramView);
        }
        localObject = new ReportInfo.b();
        ((ReportInfo.b)localObject).aSz = 409409;
        if (this.mChannelID != 56) {
          break label831;
        }
      }
    }
    for (;;)
    {
      if (this.mChannelID == 0) {
        kct.a(paramArticleInfo, this.mChannelID, 24, -1L, (ReportInfo.b)localObject);
      }
      lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
      if ((paramView instanceof ComponentContentVerticalSmallVideo)) {
        break;
      }
      this.jdField_a_of_type_Ndh.notifyDataSetChanged();
      return;
      localb.videoCoverUrl = ((SocializeFeedsInfo.t)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.lb.get(0)).pic_url;
      break label403;
      if ((kxm.r(paramArticleInfo)) && (kxm.j(paramArticleInfo)) && (paramArticleInfo.mPolymericSmallVideoCoverUrl != null))
      {
        localb.videoCoverUrl = paramArticleInfo.mPolymericSmallVideoCoverUrl.getFile();
        localb.videoVid = paramArticleInfo.mVideoVid;
        localb.aDs = paramArticleInfo.busiType;
        localb.videoWidth = paramArticleInfo.mVideoJsonWidth;
        localb.videoHeight = paramArticleInfo.mVideoJsonHeight;
        localmhu.busiType = paramArticleInfo.busiType;
        localb.videoDuration = paramArticleInfo.mVideoDuration;
        localb.akK = paramArticleInfo.innerUniqueID;
        localb.ahw = paramArticleInfo.mThirdVideoURL;
        localb.xc = paramArticleInfo.mThirdVideoURLExpireTime;
        break label403;
      }
      if (paramArticleInfo.mVideoCoverUrl == null) {}
      for (localObject = null;; localObject = paramArticleInfo.mVideoCoverUrl.getFile())
      {
        localb.videoCoverUrl = ((String)localObject);
        break;
      }
      label831:
      this.jdField_a_of_type_Ndh.a(localb, paramArticleInfo);
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, View paramView, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (paramArticleInfo.mFeedType == 2) {
      return;
    }
    if ((this.mChannelID == 0) && (muj.b(getCurrentActivity(), paramArticleInfo)))
    {
      D(paramArticleInfo);
      return;
    }
    if ((this.mChannelID != 0) || (kxm.r(paramArticleInfo)) || (kxm.v(paramArticleInfo)) || (kxm.w(paramArticleInfo)))
    {
      if (kxm.w(paramArticleInfo)) {
        a(paramArticleInfo, (mhr.a)paramArticleInfo.mNewPolymericInfo.iP.get(paramInt3), paramView);
      }
      for (;;)
      {
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
        if (!(paramView instanceof ComponentContentVerticalSmallVideo)) {
          this.jdField_a_of_type_Ndh.notifyDataSetChanged();
        }
        if (!kxm.u(paramArticleInfo)) {
          break;
        }
        paramView = odv.a(getContext(), paramArticleInfo.mVideoAdsSource, paramInt3, paramArticleInfo.getInnerUniqueID(), 54, odv.l(paramArticleInfo), paramArticleInfo.videoReportInfo);
        kbp.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mPolymericInfo.uin), "0X8008D33", "0X8008D33", 0, 0, Long.toString(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), paramView, false);
        kxm.b(paramArticleInfo, paramInt3);
        return;
        a(paramArticleInfo, paramView);
      }
    }
    lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramInt3 = -1;
    if (paramArticleInfo.videoJumpChannelID > 0) {
      if (paramArticleInfo.videoJumpChannelID == 56)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.videoanimation", 2, " init translation animation for viewTop:" + paramInt1 + "view left:" + paramInt2 + "isFromItemClick:" + paramBoolean);
        }
        a(getContext(), this.jdField_a_of_type_Ndh, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        label324:
        paramInt1 = paramArticleInfo.videoJumpChannelID;
        D(paramArticleInfo);
      }
    }
    for (;;)
    {
      if (paramInt1 != -1)
      {
        paramView = new ReportInfo.b();
        paramView.aSz = paramInt1;
        kct.a(paramArticleInfo, this.mChannelID, 24, -1L, paramView);
      }
      if ((ndi.k(paramArticleInfo) == 6) || (ndi.k(paramArticleInfo) == 28)) {
        break;
      }
      this.jdField_a_of_type_Ndh.notifyDataSetChanged();
      return;
      paramView = new HashMap();
      paramView.put("param_key_insert_article_id", Long.valueOf(paramArticleInfo.mArticleID));
      kgw.b(getCurrentActivity(), paramArticleInfo.videoJumpChannelID, paramArticleInfo.videoJumpChannelName, paramArticleInfo.videoJumpChannelType, 5, paramView);
      break label324;
      if (awit.i(BaseApplicationImpl.getApplication().getRuntime()) == 1)
      {
        a(getContext(), this.jdField_a_of_type_Ndh, paramArticleInfo, paramInt1, paramInt2, paramBoolean);
        D(paramArticleInfo);
        paramInt1 = 56;
      }
      else
      {
        a(paramArticleInfo, paramView);
        paramInt1 = paramInt3;
      }
    }
  }
  
  private void a(ArticleInfo paramArticleInfo, mhr.a parama, View paramView)
  {
    mye.b localb = new mye.b();
    if (parama.a == null) {
      QLog.e("handleJumpFullVideoPlayForNewPolymeric", 2, " bad data need backend check");
    }
    do
    {
      return;
      localb.articleID = parama.articleID;
      localb.thirdUin = (parama.a.vo + "");
      localb.thirdUinName = parama.a.thirdUinName;
      localb.puin = parama.subscribeID;
      localb.strategyId = parama.strategyID;
      localb.algorithmID = parama.algorithmID;
      Object localObject = new mhu();
      ((mhu)localObject).w = Long.valueOf(parama.articleID);
      ((mhu)localObject).rowkey = parama.ahs;
      ((mhu)localObject).busiType = parama.a.businessType;
      ((mhu)localObject).vid = parama.a.vid;
      localb.c = ((mhu)localObject);
      localb.videoCoverUrl = parama.ahr;
      localb.videoVid = parama.a.vid;
      localb.aDs = parama.a.businessType;
      localb.videoWidth = parama.a.width;
      localb.videoHeight = parama.a.height;
      localb.videoDuration = parama.a.duration;
      localb.fileSize = parama.a.vn;
      localb.akK = parama.ahs;
      localb.ahw = parama.a.ahw;
      localb.thirdIcon = parama.a.thirdIcon;
      localb.thirdName = parama.a.thirdName;
      localb.thirdAction = parama.a.thirdAction;
      if (paramView != null)
      {
        localObject = new int[2];
        paramView.getLocationOnScreen((int[])localObject);
        localb.aKB = localObject[0];
        localb.aKC = localObject[1];
        localb.viewWidth = paramView.getWidth();
        localb.viewHeight = paramView.getHeight();
        if (((paramView instanceof ComponentContentVerticalSmallVideo)) && (((ComponentContentVerticalSmallVideo)paramView).isSingleVideo))
        {
          localObject = kwz.a(3, this.mChannelID);
          int i = localb.aKB;
          localb.aKB = ((localb.viewWidth - ((Integer)((Pair)localObject).first).intValue()) / 2 + i);
          localb.viewWidth = ((Integer)((Pair)localObject).first).intValue();
        }
      }
      localObject = new ReportInfo.b();
      ((ReportInfo.b)localObject).aSz = 409409;
      this.jdField_a_of_type_Ndh.a(localb, paramArticleInfo);
      if (this.mChannelID == 0) {
        kct.a(parama.articleID, parama.ahs, this.mChannelID, (int)parama.algorithmID, parama.strategyID, 24, -1L, (ReportInfo.b)localObject, -1, parama.aha);
      }
      lbz.a().H(parama.articleID, System.currentTimeMillis());
    } while ((paramView instanceof ComponentContentVerticalSmallVideo));
    this.jdField_a_of_type_Ndh.notifyDataSetChanged();
  }
  
  private void a(nce.a parama)
  {
    if ((parama != null) && ((this.jdField_a_of_type_Kfr instanceof kge))) {
      if (!this.isFromAIO) {
        break label36;
      }
    }
    label36:
    for (int i = 1;; i = 0)
    {
      parama.a("from_aio", Integer.valueOf(i));
      return;
    }
  }
  
  private boolean a(ArticleInfo paramArticleInfo, View paramView)
  {
    String str = kvx.b(paramArticleInfo);
    if (!TextUtils.isEmpty(str))
    {
      if (mgn.dV(str)) {
        kxm.a(paramView.getContext(), paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("ReadInJoyListViewGroup", 1, "UGRuleManager articleInfo hit ug title" + paramArticleInfo.mTitle);
        return true;
        muj.aP(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  private void aBi()
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.8(this), 3000L);
  }
  
  private void aCA()
  {
    long l1 = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
    try
    {
      Parcelable localParcelable = ((lcd)kxm.getAppRuntime().getManager(163)).b().a(this.mChannelID);
      if (localParcelable != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onRestoreInstanceState(localParcelable);
        QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "channelID: ", Integer.valueOf(this.mChannelID), " restoreToHistoryPos." });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "restoreToHistoryPos Exception.");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "restoreToHistoryPos cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
  }
  
  private void aDy()
  {
    if (this.jH != null) {
      this.jH.setVisibility(8);
    }
    View localView = findViewById(2131374329);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(localView);
    localView.setOnClickListener(null);
    aWH();
  }
  
  private void aLd()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = new ChannelTopPositionView(getCurrentActivity());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView, 2);
    }
  }
  
  private void aS(Intent paramIntent)
  {
    int i = 2;
    QLog.d("ReadInJoyListViewGroup", 1, "back from readInJoyList");
    if (paramIntent.getIntExtra("click_comment_edit_src", -1) == 2) {
      i = 1;
    }
    ArticleInfo localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_articleid");
    if (localArticleInfo != null)
    {
      if (this.jdField_a_of_type_Kqd != null) {
        this.jdField_a_of_type_Kqd.clear();
      }
      this.jdField_a_of_type_Kqd = new kqd();
      this.jdField_a_of_type_Kqd.a(new ngg(this, localArticleInfo));
      ReadInJoyCommentListFragment.a(paramIntent, this.jdField_a_of_type_Kqd, 7, true, localArticleInfo, 1, i);
      return;
    }
    QLog.e("ReadInJoyListViewGroup", 1, "handleMainFeedCommentRequest articleInfo is NULL");
  }
  
  private void aWA()
  {
    boolean bool = this.jdField_a_of_type_Kfr.getActivity().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
    if ((Fu()) && (!bool) && ((!awit.aMG()) || ((this.jdField_a_of_type_Kfr.getActivity() instanceof ReadInJoyNewFeedsActivity))))
    {
      aDB();
      aWD();
    }
    if (((!awit.aMG()) || ((this.jdField_a_of_type_Kfr.getActivity() instanceof ReadInJoyNewFeedsActivity))) && (this.mChannelID == 56)) {
      kct.aHF = kct.cR(getCurrentActivity().getIntent().getIntExtra("channel_from", -1));
    }
  }
  
  private void aWB()
  {
    if (this.mChannelID == 56)
    {
      this.arU = false;
      this.arT = false;
      this.jdField_a_of_type_Kfr.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      this.jdField_a_of_type_Kfr.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", 0L);
      this.jdField_a_of_type_Kfr.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", false);
      this.jdField_a_of_type_Kfr.getActivity().getIntent().putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
    }
  }
  
  private void aWC()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      try
      {
        if ((awit.aMH()) && ((this.jdField_a_of_type_Kfr.getActivity() instanceof SplashActivity))) {
          return;
        }
        Parcelable localParcelable = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onSaveInstanceState();
        lcd locallcd = (lcd)kxm.getAppRuntime().getManager(163);
        locallcd.b().a(this.mChannelID, localParcelable);
        locallcd.b().qu(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getPaddingTop());
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("ReadInJoyListViewGroup", 1, "updateLeaveChannelPosInfo Exception.");
      }
    }
  }
  
  private void aWD()
  {
    if (Fu())
    {
      if (this.jdField_a_of_type_Kfr.getActivity().getIntent().getIntExtra("channel_from", 0) != 1004) {
        break label67;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "handleJump2VideoChannelForceInsert(): 从主feeds点点流入口跳转过来，跳过强插.");
      }
    }
    label67:
    label710:
    for (;;)
    {
      return;
      long l1 = this.jdField_a_of_type_Kfr.getActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      int i = this.jdField_a_of_type_Kfr.getActivity().getIntent().getIntExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 0);
      Object localObject1 = this.jdField_a_of_type_Ndh.c();
      if ((i == 2) && (localObject1 != null) && (((ArticleInfo)localObject1).mSubArtilceList != null) && (((ArticleInfo)localObject1).mSubArtilceList.size() == 1)) {
        localObject1 = (ArticleInfo)((ArticleInfo)localObject1).mSubArtilceList.get(0);
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label710;
        }
        ArticleInfo localArticleInfo = ((ArticleInfo)localObject1).clone();
        Object localObject2 = lbz.a().a(Integer.valueOf(56));
        List localList = a().getData();
        if ((localList == null) || (localList.isEmpty()) || (localObject2 == null) || (((List)localObject2).isEmpty()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "handleJump2VideoChannelForceInsert(): adapterSeqList is empty, just ignore.");
          return;
        }
        if (((List)localObject2).contains(Long.valueOf(l1)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "handleJump2VideoChannelForceInsert(): 发现强插重复, need to delete old, sourceArticleInfo =" + localObject1);
          }
          localObject2 = lbz.a().b(Integer.valueOf(56));
          if (localObject2 == null) {
            break label703;
          }
          Iterator localIterator = ((List)localObject2).iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)localIterator.next();
          } while (((ArticleInfo)localObject2).mArticleID != l1);
        }
        for (;;)
        {
          if (localObject2 != null)
          {
            lbz.a().a(56, (BaseArticleInfo)localObject2, Boolean.valueOf(false));
            boolean bool = localList.remove(localObject2);
            if (QLog.isColorLevel()) {
              QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "delete duplicateArticleInfo: " + localObject2 + ", deleteDuplicateSuccess= " + bool);
            }
          }
          l1 = ((BaseArticleInfo)localList.get(0)).mRecommendSeq;
          localArticleInfo.mRecommendSeq = (1L + l1);
          localArticleInfo.mChannelID = 56L;
          if (localArticleInfo.isTwoItemVideoFeed()) {
            localArticleInfo.mSubArtilceList = null;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "handleJump2VideoChannelForceInsert(): sourceArticleInfo =" + localObject1 + ",firtstArticleSeq=" + l1 + "， insert cloneInfo=" + localArticleInfo);
          }
          localObject1 = new ArrayList();
          ((List)localObject1).add(localArticleInfo);
          lbz.a().a(Integer.valueOf(56), (List)localObject1, true);
          localList.add(0, localArticleInfo);
          this.jdField_a_of_type_Ndh.notifyDataSetChanged();
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Ndh);
          if (this.jdField_a_of_type_Kqo == null) {}
          for (i = 0;; i = 1)
          {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(i, 0);
            this.jdField_a_of_type_Ndh.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, ndi.aYc);
            return;
          }
          localObject2 = null;
        }
      }
    }
  }
  
  private void aWE()
  {
    if (this.cQ != null) {
      ThreadManager.getUIHandler().postDelayed(this.cQ, 2000L);
    }
  }
  
  private void aWF()
  {
    int m = this.jdField_a_of_type_Ndh.getCount();
    if (m > 0)
    {
      int i = 0;
      while (i < m)
      {
        Object localObject = this.jdField_a_of_type_Ndh.getItem(i);
        if ((localObject instanceof ArticleInfo))
        {
          localObject = (ArticleInfo)localObject;
          ((ArticleInfo)localObject).setSearchWordInfo(null, null, null);
          ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        }
        i += 1;
      }
    }
  }
  
  private void aWG()
  {
    Object localObject = this.jdField_a_of_type_Ndh.getItem(0);
    if ((this.mChannelID == 0) && ((localObject instanceof ArticleInfo)))
    {
      localObject = (ArticleInfo)localObject;
      if (localObject != null)
      {
        this.oK = NetConnInfoCenter.getServerTime();
        this.l = ((ArticleInfo)localObject);
        localObject = ocp.b((QQAppInterface)kxm.getAppRuntime(), this.l);
        String str = ocp.q(this.l);
        ocp.a(((BaseActivity)this.jdField_a_of_type_Kfr.getActivity()).app, str, String.valueOf(this.oK), (String)localObject, true);
      }
    }
  }
  
  private void aWH()
  {
    if (this.mChannelID == 41695)
    {
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView = ((ChannelTopPositionView)findViewById(2131376789));
      }
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(0);
      }
    }
  }
  
  private void aWK()
  {
    try
    {
      if (this.jdField_a_of_type_Nid != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_Nid.getContentView());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
        this.jdField_a_of_type_Nid = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void aWO()
  {
    this.sY = ((TextView)findViewById(2131374333));
    if (kys.dv(this.mChannelID))
    {
      this.E = ((LinearLayout)findViewById(2131374332));
      return;
    }
    this.r = ((ViewStub)findViewById(2131374331));
  }
  
  private void aWP()
  {
    if ((lwh.a().CT()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() == 0) && (!this.arR))
    {
      d(true, 0, false);
      this.arR = true;
      return;
    }
    lwh.a().aNQ();
  }
  
  private void aWQ()
  {
    new Handler(Looper.getMainLooper()).post(new ReadInJoyListViewGroup.47(this));
  }
  
  private void aWr()
  {
    ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.4(this));
  }
  
  private void aWs()
  {
    Activity localActivity;
    ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout;
    View localView1;
    int i;
    if ((this.jdField_a_of_type_Kfr instanceof kfn))
    {
      localActivity = getCurrentActivity();
      if (localActivity.findViewById(2131362038) != null) {
        pB(true);
      }
      while (localActivity.findViewById(2131362039) == null) {
        return;
      }
      localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362039);
      localView1 = localActivity.findViewById(2131379798);
      i = wja.dp2px(50.0F, getResources());
      if (ImmersiveUtils.isSupporImmersive() != 1) {
        break label225;
      }
      i += ImmersiveUtils.getStatusBarHeight(getContext());
    }
    label225:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "initUI 消息看点 mListView.setPadding heightDef=" + i);
      }
      View localView2 = findViewById(2131367492);
      localView2.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.mChannelID, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, null, new ReadInJoyListViewGroup.5(this, localView1, i, localView2));
      return;
      if (!(this.jdField_a_of_type_Kfr instanceof kge)) {
        break;
      }
      ((kge)this.jdField_a_of_type_Kfr).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Ndh);
      return;
    }
  }
  
  private void aWt()
  {
    this.jdField_a_of_type_Ndh.setChannelType(ni());
    this.jdField_a_of_type_Ndh.eJ(this.xm);
    this.jdField_a_of_type_Ndh.a(this);
    this.jdField_a_of_type_Ndh.a(this);
    this.jdField_a_of_type_Ndh.a(this);
    this.jdField_a_of_type_Ndh.a(this);
    this.jdField_a_of_type_Ndh.b(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAdapter(this.jdField_a_of_type_Ndh);
  }
  
  private void aWu()
  {
    this.jdField_a_of_type_Mst = mst.a();
    this.jdField_a_of_type_Mst.eJ(this.xm);
    if (this.mChannelID == 56)
    {
      this.xs = getCurrentActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
      kct.aHF = kct.cR(getCurrentActivity().getIntent().getIntExtra("channel_from", -1));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(new ColorDrawable(-1));
    }
    if (this.jdField_a_of_type_Kfr.a() != null)
    {
      this.jdField_a_of_type_Ndh.a(this.jdField_a_of_type_Kfr.a(), this.jdField_a_of_type_Mst);
      return;
    }
    this.jdField_a_of_type_Ndh.aVK();
  }
  
  private void aWv()
  {
    boolean bool = getCurrentActivity().getIntent().getBooleanExtra("is_need_show_animation_translate", false);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Ndh.c();
    int i;
    if ((bool) && ((getCurrentActivity() instanceof ReadInJoyChannelActivity)))
    {
      if (!this.afo) {
        break label220;
      }
      i = ndi.k(localArticleInfo);
      if ((i != 6) && (i != 71)) {
        break label177;
      }
      this.aYp = getCurrentActivity().getIntent().getIntExtra("view_translation_animation_left", 0);
      this.aYo = getCurrentActivity().getIntent().getIntExtra("view_translation_animation_top", 0);
      kws.a(d(), localArticleInfo, getCurrentActivity(), this.jdField_a_of_type_Ndh, this.mChannelID, this.aYp, this.aYo);
      tv(this.aYo);
    }
    for (;;)
    {
      this.jdField_b_of_type_Jzh = new jzh(getCurrentActivity(), true, this, this.jdField_a_of_type_Ndh);
      this.jdField_a_of_type_Ndh.a(this.jdField_b_of_type_Jzh);
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.6(this));
      return;
      label177:
      if (i == 28)
      {
        i = awit.j(kxm.getAppRuntime());
        kws.a(d(), localArticleInfo, getCurrentActivity(), this.jdField_a_of_type_Ndh, this.mChannelID, 0, i);
        tv(i);
        continue;
        label220:
        this.jdField_a_of_type_Ndh.aVV();
      }
    }
  }
  
  private void aWw()
  {
    if (this.mChannelID == 0) {
      if (!awit.Vs()) {}
    }
    for (;;)
    {
      Iterator localIterator = this.jW.iterator();
      while (localIterator.hasNext()) {
        ((nny)localIterator.next()).e(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      this.jW.add(new nof(getContext()));
      continue;
      if (this.mChannelID == 56)
      {
        if (awit.F(kxm.getAppRuntime()) != 2)
        {
          this.jdField_a_of_type_Kqo = new kqo(getCurrentActivity(), this.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
          db(this.jdField_a_of_type_Kqo.b());
        }
      }
      else if (this.mChannelID == 70)
      {
        this.jW.add(new ReadInJoyDiandianHeaderController(getCurrentActivity()));
      }
      else if ((this.mChannelID == 41523) && (awit.G(kxm.getAppRuntime()) != 1))
      {
        this.jdField_a_of_type_Kqo = new kqo(getCurrentActivity(), this.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
        this.jdField_a_of_type_Kqo.b().setBackgroundColor(-1);
        db(this.jdField_a_of_type_Kqo.b());
      }
    }
  }
  
  private void aWx()
  {
    if (this.mChannelID == 0)
    {
      if (kpp.a().Ak())
      {
        lP(false);
        QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | shouldAutoRefresh and backToTop");
      }
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.22(this), 500L);
      return;
    }
    kpp.a().aFR();
    QLog.d("ReadInJoyListViewGroup", 2, "transformCommentBiuCard | not in recommend feeds and clear biuinfo");
  }
  
  private void aWy()
  {
    if (ReadinjoyJumpActivity.p(getCurrentActivity().getIntent())) {
      ReadinjoyJumpActivity.b(getCurrentActivity(), getCurrentActivity().getIntent(), 500L);
    }
    Intent localIntent;
    do
    {
      do
      {
        return;
        if (ReadinjoyJumpActivity.q(getCurrentActivity().getIntent()))
        {
          localIntent = getCurrentActivity().getIntent();
          ReadInJoyLockScreenJumpDelegate.o(getCurrentActivity(), localIntent);
          localIntent.removeExtra("daily_lock_screen_flag");
          return;
        }
      } while ((!ReadinjoyJumpActivity.r(getCurrentActivity().getIntent())) || (awit.Vs()));
      localIntent = getCurrentActivity().getIntent();
    } while (localIntent.getIntExtra("launch_from", 0) != 9);
    ReadInJoyLockScreenJumpDelegate.o(getCurrentActivity(), localIntent);
    localIntent.removeExtra("kan_dian_lock_screen_flag");
  }
  
  private void aWz()
  {
    if (awit.nJ(ni())) {
      this.xq = System.currentTimeMillis();
    }
    if (this.mChannelID == 56) {
      lbz.a().qo(56);
    }
  }
  
  public static ArticleInfo b(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.mChannelID = paramArticleInfo.mChannelID;
    mhr.a locala = (mhr.a)paramArticleInfo.mNewPolymericInfo.iP.get(0);
    localArticleInfo.mStrategyId = locala.strategyID;
    localArticleInfo.mAlgorithmID = locala.algorithmID;
    localArticleInfo.mTitle = locala.articleTitle;
    localArticleInfo.mFirstPagePicUrl = locala.ahr;
    localArticleInfo.mArticleContentUrl = locala.articleContentUrl;
    localArticleInfo.mArticleID = locala.articleID;
    localArticleInfo.mSubscribeID = locala.subscribeID;
    localArticleInfo.mSubscribeName = locala.subscribeName;
    localArticleInfo.innerUniqueID = locala.ahs;
    localArticleInfo.mNewPolymericInfo = paramArticleInfo.mNewPolymericInfo;
    return localArticleInfo;
  }
  
  private void b(ArticleInfo paramArticleInfo, View paramView)
  {
    if ((paramArticleInfo.mNewPolymericInfo.iP == null) || (paramArticleInfo.mNewPolymericInfo.iP.size() <= 0))
    {
      QLog.e("ReadInJoyListViewGroup", 1, "handleJumpFullVideoPlayForNewPolymeric, bad data need backend check");
      return;
    }
    a(paramArticleInfo, (mhr.a)paramArticleInfo.mNewPolymericInfo.iP.get(0), paramView);
  }
  
  private void b(String paramString, Drawable paramDrawable)
  {
    findViewById(2131374329).setVisibility(8);
    if (this.jH == null)
    {
      this.jH = ((ViewStub)findViewById(2131372278)).inflate();
      this.oa = ((TextView)this.jH.findViewById(2131376708));
      this.id = ((ImageView)this.jH.findViewById(2131376707));
    }
    this.oa.setText(paramString);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setEmptyView(this.jH);
    this.jH.setOnClickListener(this);
    if (paramDrawable != null)
    {
      this.id.setImageDrawable(paramDrawable);
      if (this.mChannelID == 70) {
        this.oa.setTextColor(-4473925);
      }
    }
    for (((LinearLayout.LayoutParams)this.oa.getLayoutParams()).topMargin = wja.dp2px(20.0F, getResources());; ((LinearLayout.LayoutParams)this.oa.getLayoutParams()).topMargin = wja.dp2px(10.0F, getResources()))
    {
      aWH();
      return;
      this.id.setImageDrawable(getResources().getDrawable(2130839516));
      this.oa.setTextColor(getResources().getColor(2131167155));
    }
  }
  
  private boolean b(ArticleInfo paramArticleInfo, View paramView)
  {
    if (mgn.Z(paramArticleInfo)) {}
    boolean bool;
    String str;
    do
    {
      return false;
      bool = kxj.a().a(paramArticleInfo, null, null);
      str = kxj.a().gd();
    } while ((!bool) || (TextUtils.isEmpty(str)));
    lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Ndh.notifyDataSetChanged();
    kxm.a(getCurrentActivity(), paramArticleInfo, this.jdField_a_of_type_Ndh, this.mChannelID);
    kxm.a(paramView.getContext(), paramArticleInfo, str);
    return true;
  }
  
  private void bQ(List<Long> paramList)
  {
    Object localObject = kxm.getAppRuntime();
    if ((!awit.Q((AppRuntime)localObject)) || (!awit.R((AppRuntime)localObject))) {}
    while ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    if (paramList.size() > 5) {}
    for (int i = 5;; i = paramList.size())
    {
      localObject = new ArrayList();
      int m = 0;
      while (m < i)
      {
        long l1 = ((Long)paramList.get(m)).longValue();
        BaseArticleInfo localBaseArticleInfo = this.jdField_a_of_type_Ndh.a(this.mChannelID, l1);
        if ((localBaseArticleInfo != null) && (!kxm.j(localBaseArticleInfo))) {
          ((ArrayList)localObject).add((ArticleInfo)localBaseArticleInfo);
        }
        m += 1;
      }
    }
    lbz.a().a().bQ((List)localObject);
  }
  
  private List<Long> bg()
  {
    Intent localIntent = this.jdField_a_of_type_Kfr.getActivity().getIntent();
    List localList = null;
    Long localLong = Long.valueOf(localIntent.getLongExtra("subscription_click_article_id", -1L));
    int i = localIntent.getIntExtra("channel_id", 0);
    if (this.mChannelID == i) {
      localList = (List)localIntent.getSerializableExtra("subscription_all_article_id");
    }
    if ((localLong.longValue() > 0L) && (localList != null) && (localList.size() > 0))
    {
      localList.remove(localLong);
      localList.add(0, localLong);
    }
    return localList;
  }
  
  private void c(int paramInt, Runnable paramRunnable)
  {
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.46(this, paramRunnable), paramInt);
  }
  
  private void c(ProteusItemView paramProteusItemView)
  {
    paramProteusItemView = (TextBase)paramProteusItemView.a().getVirtualView().findViewBaseByName("id_artilce_title");
    if (paramProteusItemView != null)
    {
      paramProteusItemView.setTextColor(getContext().getResources().getColor(2131166741));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void c(ArticleInfo paramArticleInfo, View paramView)
  {
    if (paramArticleInfo == null) {
      return;
    }
    if (kxm.a(paramArticleInfo.mArticleContentUrl, paramArticleInfo.mChannelID, paramArticleInfo)) {
      f(paramArticleInfo);
    }
    for (;;)
    {
      odv.J(paramArticleInfo);
      return;
      kxm.a(getCurrentActivity(), paramArticleInfo, this.jdField_a_of_type_Ndh, this.mChannelID);
    }
  }
  
  private void c(KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    if (this.jdField_a_of_type_Nid == null)
    {
      if (kxm.nX() != 1) {
        break label107;
      }
      this.jdField_a_of_type_Nid = new nib(getCurrentActivity(), LayoutInflater.from(getContext()).inflate(2131560477, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, false));
    }
    for (;;)
    {
      this.jdField_a_of_type_Nid.setOnClickListener(new ngd(this));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_Nid.getContentView());
      this.jdField_a_of_type_Nid.d(paramKandianMsgBoxRedPntInfo);
      this.jdField_a_of_type_Nid.show();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.postInvalidate();
      return;
      label107:
      if (kxm.nX() == 2) {
        this.jdField_a_of_type_Nid = new nhz(getCurrentActivity());
      }
    }
  }
  
  private long ca()
  {
    if ((zn()) && (getCurrentActivity().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)getCurrentActivity().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        long l1 = ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return l1;
        }
      }
    }
    return -1L;
  }
  
  private LinearLayout d()
  {
    if (kys.dv(this.mChannelID)) {
      return this.E;
    }
    if (this.E == null) {
      this.E = ((LinearLayout)this.r.inflate());
    }
    return this.E;
  }
  
  private void d(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = (TextView)paramLinearLayout.findViewById(2131365126);
    if (paramLinearLayout != null)
    {
      paramLinearLayout.setTextColor(getContext().getResources().getColor(2131166741));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.videoanimation", 2, " change ui state after readed");
      }
    }
  }
  
  private void d(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Context localContext = getContext();
    if (kys.dv(this.mChannelID)) {}
    for (int i = 2;; i = 1)
    {
      odj.a(localContext, i, new ReadInJoyListViewGroup.37(this, paramBoolean1, paramInt, paramBoolean2));
      return;
    }
  }
  
  private void db(View paramView)
  {
    if ((getCurrentActivity() instanceof ReadInJoyNewFeedsActivity)) {
      ((ReadInJoyNewFeedsActivity)getCurrentActivity()).bY(paramView);
    }
    for (;;)
    {
      return;
      if (awit.aMG()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)getCurrentActivity()).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.db(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d("ReadInJoyListViewGroup", 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  private long dj()
  {
    long l2 = 9223372036854775807L;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(161);
    long l1 = l2;
    if (localAladdinConfig != null)
    {
      int i = localAladdinConfig.getIntegerFromString("is_auto_refresh", 0);
      int m = localAladdinConfig.getIntegerFromString("daily_refresh_interval", 0);
      QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, isAutoRefresh = ", Integer.valueOf(i), ", refreshInterval = ", Integer.valueOf(m) });
      l1 = l2;
      if (i == 1) {
        l1 = m * 60 * 1000;
      }
    }
    QLog.d("ReadInJoyListViewGroup", 1, new Object[] { "getDailyRefreshTimeLimit, res = ", Long.valueOf(l1) });
    return l1;
  }
  
  private void e(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (!kyo.Bh()) {
      lcc.a().aJJ();
    }
    this.jdField_a_of_type_Kxa.sT = System.currentTimeMillis();
    awit.a(this.mChannelID, this.jdField_a_of_type_Kxa.sT, (QQAppInterface)kxm.getAppRuntime());
    lbz locallbz = null;
    Object localObject8 = null;
    Object localObject4 = null;
    long l1 = 0L;
    long l2 = 0L;
    Object localObject2 = null;
    Object localObject1 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    Object localObject7 = null;
    Bundle localBundle = null;
    int n = 0;
    int i = -1;
    QQAppInterface localQQAppInterface = ((BaseActivity)getCurrentActivity()).app;
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if ((this.mChannelID == 0) || (this.mChannelID == lhn.oC()))
    {
      if (!this.jdField_a_of_type_Kxa.aie) {
        break label2166;
      }
      localObject1 = bg();
      bool2 = Ft();
      this.jdField_a_of_type_Kxa.aie = false;
      if (getCurrentActivity().getIntent().getIntExtra("launch_from", -1) == 8) {
        bool1 = true;
      }
    }
    for (localObject4 = (LebaKDCellInfo)getCurrentActivity().getIntent().getSerializableExtra("param_leba_cell_articleinfo");; localObject4 = localBundle)
    {
      int m;
      if (localObject1 == null)
      {
        localObject2 = localKandianMergeManager.aA();
        if ((localObject2 != null) && (((List)localObject2).size() > 2))
        {
          l2 = ((Long)((List)localObject2).get(((List)localObject2).size() - 2)).longValue();
          l1 = ((Long)((List)localObject2).get(((List)localObject2).size() - 1)).longValue();
          localObject2 = ((List)localObject2).subList(0, ((List)localObject2).size() - 2);
          localObject1 = localKandianMergeManager.jd();
          m = 1;
          if (Fv())
          {
            localObject6 = localKandianMergeManager.c();
            if (localObject6 != null)
            {
              localObject5 = ((KandianRedDotInfo)localObject6).articleIDList;
              if ((localObject5 != null) && (((List)localObject5).size() > 0))
              {
                localObject2 = new ArrayList();
                localObject1 = ((KandianRedDotInfo)localObject6).cookie;
                i = ((List)localObject5).size() - 1;
                for (;;)
                {
                  if (i >= 0)
                  {
                    ((List)localObject2).add(0, (Long)((List)localObject5).get(i));
                    i -= 1;
                    continue;
                    bool1 = false;
                    break;
                  }
                }
                i = 1;
                label424:
                localKandianMergeManager.aIG();
                localKandianMergeManager.aIF();
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject5 = localKandianMergeManager.l();
        localKandianMergeManager.aIM();
        if (i != 0)
        {
          i = 32;
          kxm.mO(false);
        }
        for (;;)
        {
          long l3 = l1;
          n = m;
          localObject7 = localObject4;
          bool3 = bool1;
          m = i;
          l1 = l2;
          l2 = l3;
          bool1 = bool2;
          localObject4 = localObject5;
          i = n;
          if (this.mChannelID == 40830)
          {
            localObject8 = getCurrentActivity().getIntent();
            localObject6 = localObject1;
            n = i;
            localObject5 = localObject2;
            if (localObject8 != null)
            {
              localObject9 = (ReadInJoyChannelActivity.SerializableMap)((Intent)localObject8).getSerializableExtra("channel_map_data");
              localObject6 = localObject1;
              n = i;
              localObject5 = localObject2;
              if (localObject9 != null)
              {
                localObject1 = (Long)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().remove("articleID");
                if (localObject1 != null)
                {
                  localObject2 = new ArrayList();
                  ((List)localObject2).add(localObject1);
                  ((Intent)localObject8).putExtra("channel_map_data", (Serializable)localObject9);
                }
                n = 9;
                localObject6 = (String)((ReadInJoyChannelActivity.SerializableMap)localObject9).getMap().get("pushContext");
                localObject5 = localObject2;
              }
            }
            localObject2 = localObject6;
            localObject1 = localObject5;
            i = n;
            label656:
            if (this.jdField_a_of_type_Ndh != null) {
              this.jdField_a_of_type_Ndh.nq(paramBoolean1);
            }
            localObject8 = new ArrayList();
            n = m;
            if (Fw())
            {
              ((List)localObject8).addAll(localKandianMergeManager.aB());
              n = m | 0x80;
            }
            m = n;
            if (lwh.a().CT()) {
              m = n | 0x1000;
            }
            localObject9 = new ArrayList();
            if (this.mChannelID == 56)
            {
              localObject5 = new luq.a();
              ((luq.a)localObject5).packageName = "com.tencent.weishi";
              ((luq.a)localObject5).isInstalled = aqiz.isAppInstalled(getContext(), ((luq.a)localObject5).packageName);
              ((List)localObject9).add(localObject5);
            }
            if (localObject4 != null) {
              break label1878;
            }
            localObject5 = null;
            label803:
            if (localObject4 != null) {
              break label1888;
            }
            localObject4 = null;
            label811:
            if (this.mChannelID != 70) {
              break label1901;
            }
            lbz.a().s(true, (String)localObject2);
            lgp.a().nw(true);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(false);
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aDC = 1;
            this.aIz += 1;
            odv.a(paramInt, this.mChannelID, getCurrentActivity(), paramBoolean2, -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getScrollY());
            return;
            if ((Fu()) && (!this.arU))
            {
              l3 = this.jdField_a_of_type_Kfr.getActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L);
              bool1 = this.jdField_a_of_type_Kfr.getActivity().getIntent().getBooleanExtra("READINJOY_VIDEO_FORCE_INSERT_IS_UGC_VIDEO", false);
              this.arU = true;
              this.arT = true;
              if (bool1)
              {
                localObject2 = (ArticleInfo)this.jdField_a_of_type_Kfr.getActivity().getIntent().getParcelableExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_INFO");
                if (localObject2 == null) {
                  break label2097;
                }
                localObject1 = new Pair(((ArticleInfo)localObject2).getInnerUniqueID(), ((ArticleInfo)localObject2).mTitle);
                localObject4 = new JSONObject();
              }
            }
          }
          for (;;)
          {
            try
            {
              ((JSONObject)localObject4).put("ArticleId", kxm.toBigInteger(((ArticleInfo)localObject2).mArticleID));
              ((JSONObject)localObject4).put("FeedsId", kxm.toBigInteger(((ArticleInfo)localObject2).mFeedId));
              ((JSONObject)localObject4).put("algorithmIds", 0);
              ((JSONObject)localObject4).put("biuUin", 0);
              localObject2 = new JSONObject();
              ((JSONObject)localObject2).put("socialFeedsType", 1);
              ((JSONObject)localObject4).put("extension", localObject2);
              ((JSONObject)localObject4).put("feedsType", 1);
              ((JSONObject)localObject4).put("id", 0);
              ((JSONObject)localObject4).put("network_type", 1);
              ((JSONObject)localObject4).put("orange", "");
              ((JSONObject)localObject4).put("pushMessage", "");
              ((JSONObject)localObject4).put("push_type", 0);
              ((JSONObject)localObject4).put("strategyIds", 0);
              ((JSONObject)localObject4).put("title", "");
              ((JSONObject)localObject4).put("uin", localQQAppInterface.getLongAccountUin());
              localObject2 = ((JSONObject)localObject4).toString();
              localObject4 = null;
              i = 5;
              bool1 = false;
              localObject5 = localObject4;
              localObject4 = localObject1;
              localObject1 = localObject2;
              localObject2 = localObject5;
              m = n;
            }
            catch (JSONException localJSONException)
            {
              localJSONException.printStackTrace();
              localObject3 = null;
              continue;
            }
            localObject4 = new ArrayList();
            ((List)localObject4).add(Long.valueOf(l3));
            localObject1 = null;
            continue;
            if (this.mChannelID == 70)
            {
              localObject3 = (KandianRedDotInfo)getCurrentActivity().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
              if (localObject3 != null)
              {
                localObject1 = ((KandianRedDotInfo)localObject3).cookie;
                getCurrentActivity().getIntent().removeExtra("kandian_feeds_red_pnt_info");
              }
              localObject3 = null;
              bool1 = false;
              localObject4 = null;
              m = n;
              break;
            }
            long l4;
            if ((this.mChannelID == 56) && (this.xm == 1001L))
            {
              n = 2;
              localObject5 = localKandianMergeManager.e();
              m = i;
              localObject1 = localObject10;
              localObject3 = locallbz;
              l4 = l2;
              l3 = l1;
              if (localObject5 != null)
              {
                if (!((KandianRedDotInfo)localObject5).hasArticleID()) {
                  break label1477;
                }
                localObject3 = ((KandianRedDotInfo)localObject5).articleIDList;
                localObject1 = ((KandianRedDotInfo)localObject5).cookie;
                l1 = ((KandianRedDotInfo)localObject5).algorithmID;
                l2 = ((KandianRedDotInfo)localObject5).strategyID;
                i = 1;
                n = 10;
              }
              for (;;)
              {
                localKandianMergeManager.aIO();
                l3 = l1;
                l4 = l2;
                m = i;
                bool1 = false;
                localObject4 = null;
                i = m;
                l2 = l4;
                l1 = l3;
                m = n;
                break;
                label1477:
                n = 6;
                localObject1 = localObject9;
                localObject3 = localObject4;
              }
            }
            if (this.mChannelID == 40677)
            {
              localObject6 = (lcr)localQQAppInterface.getManager(274);
              m = i;
              localObject1 = localObject5;
              localObject3 = localObject8;
              if (((lcr)localObject6).aF() != null)
              {
                m = i;
                localObject1 = localObject5;
                localObject3 = localObject8;
                if (((lcr)localObject6).aF().size() > 0)
                {
                  localObject4 = new ArrayList(((lcr)localObject6).aF());
                  i = 8;
                  m = i;
                  localObject1 = localObject5;
                  localObject3 = localObject4;
                  if (!TextUtils.isEmpty(((lcr)localObject6).jl()))
                  {
                    localObject1 = ((lcr)localObject6).jl();
                    localObject3 = localObject4;
                    m = i;
                  }
                }
              }
              ((lcr)localObject6).aI(getCurrentActivity());
              bool1 = false;
              localObject4 = null;
              i = m;
              m = n;
              break;
              if (kys.dv(this.mChannelID))
              {
                localObject8 = (KandianRedDotInfo)getCurrentActivity().getIntent().getSerializableExtra("kandian_feeds_red_pnt_info");
                localObject6 = localObject1;
                n = i;
                l4 = l2;
                l3 = l1;
                localObject5 = localObject3;
                if (localObject8 != null)
                {
                  localObject6 = localObject1;
                  n = i;
                  l4 = l2;
                  l3 = l1;
                  localObject5 = localObject3;
                  if (!((KandianRedDotInfo)localObject8).shouldRemoveFloatingRedPntArticleId())
                  {
                    l3 = ((KandianRedDotInfo)localObject8).algorithmID;
                    l4 = ((KandianRedDotInfo)localObject8).strategyID;
                    localObject5 = ((KandianRedDotInfo)localObject8).articleIDList;
                    n = 1;
                    localObject6 = ((KandianRedDotInfo)localObject8).cookie;
                    getCurrentActivity().getIntent().removeExtra("kandian_feeds_red_pnt_info");
                  }
                }
                localObject3 = localObject6;
                l2 = l4;
                l1 = l3;
                localObject1 = localObject5;
                i = n;
                break label656;
              }
              l3 = ca();
              if (this.jdField_a_of_type_Ndh != null)
              {
                localObject5 = (ArticleInfo)this.jdField_a_of_type_Ndh.c(0);
                if ((l3 != -1L) && (localObject5 != null) && (l3 != ((ArticleInfo)localObject5).mArticleID))
                {
                  localObject5 = new ArrayList();
                  ((List)localObject5).add(Long.valueOf(l3));
                  i = 6;
                  localObject3 = localObject1;
                  localObject1 = localObject5;
                  break label656;
                  label1878:
                  localObject5 = ((Pair)localObject4).first;
                  break label803;
                  label1888:
                  localObject4 = (String)((Pair)localObject4).second;
                  break label811;
                  label1901:
                  if ((this.aRd == 6) || (this.aRd == 7)) {
                    m |= 0x800;
                  }
                  for (;;)
                  {
                    localBundle = new Bundle();
                    localBundle.putInt("FeedsRefreshType", this.aRd);
                    locallbz = lbz.a();
                    n = this.mChannelID;
                    int i1 = this.aIz;
                    if ((localObject5 instanceof String))
                    {
                      localObject6 = (String)localObject5;
                      label1980:
                      if (!(localObject5 instanceof Long)) {
                        break label2052;
                      }
                    }
                    label2052:
                    for (l3 = ((Long)localObject5).longValue();; l3 = -1L)
                    {
                      locallbz.a(n, (List)localObject1, i, true, bool1, i1, (String)localObject6, l3, (String)localObject4, ni(), l1, l2, (String)localObject3, paramInt, bool3, localObject7, m, (List)localObject8, (List)localObject9, localBundle);
                      break;
                      localObject6 = null;
                      break label1980;
                    }
                  }
                }
              }
              localObject5 = localObject1;
              localObject1 = localObject3;
              localObject3 = localObject5;
              break label656;
            }
            localObject3 = null;
            bool1 = false;
            localObject4 = null;
            localObject1 = null;
            m = n;
            break;
            label2097:
            localObject1 = null;
            localObject3 = localObject6;
          }
          i = 0;
        }
        i = 1;
        break label424;
        i = 0;
        break label424;
        localObject1 = null;
        l1 = 0L;
        l2 = 0L;
        m = -1;
        break;
        m = -1;
        localObject5 = null;
        l1 = 0L;
        l2 = 0L;
        Object localObject3 = localObject1;
        i = 0;
        localObject1 = localObject5;
      }
      label2166:
      localObject1 = null;
    }
  }
  
  private void f(ArticleInfo paramArticleInfo)
  {
    nnw.K("fast_web_show_light_house_1");
    lhu locallhu = lbz.a().a();
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (kxm.B(paramArticleInfo))
    {
      localArticleInfo = paramArticleInfo;
      if (!paramArticleInfo.mNewPolymericInfo.amx) {
        localArticleInfo = b(paramArticleInfo);
      }
    }
    if (locallhu != null) {
      this.aMR = locallhu.a(localArticleInfo.mArticleContentUrl, String.valueOf(localArticleInfo.innerUniqueID), localArticleInfo.mSubscribeID, 1, null);
    }
    g(localArticleInfo);
  }
  
  private void g(ArticleInfo paramArticleInfo)
  {
    kxm.a(getCurrentActivity(), paramArticleInfo, this.jdField_a_of_type_Ndh, this.mChannelID);
    lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
    this.jdField_a_of_type_Ndh.notifyDataSetChanged();
    kxm.a(getCurrentActivity(), paramArticleInfo);
  }
  
  private void i(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.innerUniqueID)))
    {
      kxm.a(getCurrentActivity(), paramArticleInfo, this.jdField_a_of_type_Ndh, this.mChannelID);
      if (this.jdField_a_of_type_Ndh.m(this.jdField_a_of_type_Ndh.nh(), paramArticleInfo.mArticleID)) {}
      kxm.k(paramArticleInfo);
      if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
      {
        str = paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8();
        localBundle = new Bundle();
        localBundle.putString("big_brother_source_key", kxm.bg(0));
        kxm.a(getContext(), str, localBundle);
        kvp.a(getContext(), paramArticleInfo, this.jdField_a_of_type_Ndh);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      Bundle localBundle;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery failed: url is null");
      return;
    }
    QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery falied articleInfo is null or rowkey is empty");
  }
  
  private void initListView()
  {
    if (!kxm.AV())
    {
      QLog.d("ReadInJoyListViewGroup", 2, "ListView overdraw switch close");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setContentBackground(2130838900);
      int i = Color.parseColor("#f8f8f8");
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setBackgroundColor(i);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setChannelId(this.mChannelID);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOnItemLongClickListener(this);
    if (this.mChannelID == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollTouchMode(1);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setOverScrollFlingMode(1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(this.jdField_a_of_type_ComTencentWidgetXListView$a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.c(this.mOnScrollListener);
    if ((this.mChannelID == 0) || (kys.dv(this.mChannelID))) {
      meu.a().i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.mChannelID);
    }
  }
  
  private void initUI(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView = ((ReadInJoyXListView)findViewById(2131379011));
    if (paramInt == 41695) {
      aLd();
    }
    if (kys.dv(this.mChannelID)) {
      kxt.a().register();
    }
    this.jdField_a_of_type_Aqdf = new aqdf(getCurrentActivity(), ((BaseActivity)getCurrentActivity()).app);
    this.jdField_a_of_type_Ndh = new ndh(getCurrentActivity(), getCurrentActivity().getLayoutInflater(), this.mChannelID, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Aqdf, this.av);
    a(new nfu(this, "onListViewGroupInit"));
    aWO();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI before mListView.setPadding :" + this.jdField_a_of_type_Kfr + getCurrentActivity());
    }
    aWs();
    initListView();
    aWu();
    aWt();
    aDy();
    aWw();
    ((BaseActivity)getCurrentActivity()).app.addObserver(this.c);
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c);
    aWv();
    aWr();
    lcc.a().b(this.k);
  }
  
  private void j(ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramInt == 1) {
      kxm.a(getContext(), paramArticleInfo, false);
    }
    while (paramInt != 2) {
      return;
    }
    if ((ndi.N(paramArticleInfo)) && (ndi.M(paramArticleInfo)))
    {
      c(paramArticleInfo, null);
      return;
    }
    kxm.a(getContext(), paramArticleInfo, 3);
  }
  
  private Pair<Integer, Long> m()
  {
    long l2 = 0L;
    int m = 0;
    int i = 0;
    int n = -1;
    if ((getContext() instanceof ReadInJoyNewFeedsActivity))
    {
      if (((ReadInJoyNewFeedsActivity)getContext()).cb() > 0L)
      {
        l1 = ((ReadInJoyNewFeedsActivity)getContext()).cb();
        if (!((ReadInJoyNewFeedsActivity)getContext()).zt()) {
          break label97;
        }
      }
      label97:
      for (i = 0;; i = 1)
      {
        return new Pair(Integer.valueOf(i), Long.valueOf(l1));
        l1 = System.currentTimeMillis() - ((ReadInJoyNewFeedsActivity)getContext()).cc();
        break;
      }
    }
    ReadinjoyTabFrame localReadinjoyTabFrame;
    if ((getContext() instanceof SplashActivity))
    {
      localReadinjoyTabFrame = kxm.a(getContext());
      if (localReadinjoyTabFrame == null) {
        break label185;
      }
      if (localReadinjoyTabFrame.aIW == 0) {}
    }
    label134:
    for (long l1 = localReadinjoyTabFrame.dk();; l1 = 0L)
    {
      break;
      i = 1;
      break label134;
      i = n;
      l1 = l2;
      if (!kys.dv(this.mChannelID)) {
        break;
      }
      if (kvs.nM() != 0) {}
      for (i = m;; i = 1)
      {
        l1 = l2;
        break;
      }
      label185:
      i = -1;
    }
  }
  
  private void mb(String paramString)
  {
    b(paramString, null);
  }
  
  private int ni()
  {
    if (this.mChannelType != -1) {
      return this.mChannelType;
    }
    return getCurrentActivity().getIntent().getIntExtra("channel_type", 0);
  }
  
  private void pB(boolean paramBoolean)
  {
    int i = 2131299219;
    boolean bool2 = false;
    label406:
    for (;;)
    {
      try
      {
        boolean bool3 = anwa.aze();
        if ((bool3 == this.arV) && (!paramBoolean)) {
          return;
        }
        Activity localActivity = getCurrentActivity();
        if (localActivity == null) {
          break;
        }
        this.arV = bool3;
        if (kys.dv(this.mChannelID))
        {
          if (!paramBoolean) {
            break;
          }
          bool1 = false;
          if (nh() == 0) {
            break label406;
          }
          if (!paramBoolean) {
            break;
          }
          bool1 = bool2;
          QLog.d("ReadInJoyListViewGroup", 1, "updateListViewPadding,update2StudyMode=" + bool1 + " ,isOnCreate=" + paramBoolean);
          ReadInjoySlideAnimLayout localReadInjoySlideAnimLayout = (ReadInjoySlideAnimLayout)localActivity.findViewById(2131362038);
          View localView1 = localActivity.findViewById(2131378734);
          View localView2 = findViewById(2131367492);
          if (bool1) {
            i = 2131299215;
          }
          i = getResources().getDimensionPixelOffset(i);
          if (!bool1) {
            break label376;
          }
          i = ImmersiveUtils.getStatusBarHeight(getContext()) + i;
          m = wja.dp2px(50.0F, getResources());
          n = ImmersiveUtils.getStatusBarHeight(getContext());
          int i1 = getResources().getDimensionPixelOffset(2131299219);
          localView2.setPadding(0, i, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setPadding(0, i, 0, 0);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.initPaddingManual();
          if (QLog.isColorLevel()) {
            QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding :" + i);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController = new SlideActiveAnimController(this.mChannelID, localActivity, localReadInjoySlideAnimLayout, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, localView1, localActivity.findViewById(16908307), new ReadInJoyListViewGroup.49(this, localView1, i, m + n + i1, localView2));
          if (!bool3) {
            break;
          }
          d(true, 3, false);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("ReadInJoyListViewGroup", 2, "update ListViewPadding error, e=" + localException);
        return;
      }
      boolean bool1 = this.arV;
      continue;
      label376:
      int m = wja.dp2px(50.0F, getResources());
      int n = ImmersiveUtils.getStatusBarHeight(getContext());
      i = m + n + i;
    }
  }
  
  private void tv(int paramInt)
  {
    d().setLayerType(2, null);
    this.sY.setLayerType(2, null);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.sY, View.ALPHA, new float[] { 0.0F, 1.0F });
    localObjectAnimator1.addListener(new ngi(this));
    localObjectAnimator1.setDuration(400L);
    localObjectAnimator1.setInterpolator(new LinearInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(d(), View.TRANSLATION_Y, new float[] { 0.0F, -paramInt });
    localObjectAnimator2.addListener(new nfg(this));
    localObjectAnimator2.setDuration(400L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setAlpha(0.0F);
    localObjectAnimator2.start();
    this.sY.setVisibility(0);
    localObjectAnimator1.start();
  }
  
  private boolean zm()
  {
    if ((zn()) && (getCurrentActivity().getIntent().getIntExtra("channel_from", -1) == 4))
    {
      Object localObject = (ReadInJoyChannelActivity.SerializableMap)getCurrentActivity().getIntent().getSerializableExtra("channel_map_data");
      if ((localObject != null) && (((ReadInJoyChannelActivity.SerializableMap)localObject).getMap() != null))
      {
        localObject = ((ReadInJoyChannelActivity.SerializableMap)localObject).getMap();
        ((Long)((Map)localObject).get("param_key_ariticle_id")).longValue();
        if (((Integer)((Map)localObject).get("param_key_channel_cover_style")).intValue() == 1) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean zn()
  {
    return this.mChannelID != 0;
  }
  
  public void D(ArticleInfo paramArticleInfo)
  {
    int i1 = this.mChannelID;
    Object localObject1 = kxm.f(paramArticleInfo);
    int i;
    int m;
    label36:
    int n;
    label49:
    Object localObject2;
    Object localObject3;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label765;
      }
      m = 0;
      if (paramArticleInfo.videoJumpChannelID <= 0) {
        break label770;
      }
      n = paramArticleInfo.videoJumpChannelID;
      kbp.a(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.b(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), this.mChannelID, i), false);
      kbp.d("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.b(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), this.mChannelID, i));
      localObject2 = odv.aB(i1);
      if ((!ndi.S(paramArticleInfo)) && (!ndi.ak(paramArticleInfo)) && (!ndi.T(paramArticleInfo)) && (!ndi.U(paramArticleInfo))) {
        break label777;
      }
      localObject3 = new nce.a(kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), i1, i, m, aqiw.isWifiConnected(getContext()), String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin), paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), n, paramArticleInfo));
      if (this.mChannelID == 0) {
        ((nce.a)localObject3).h(n).c((String)kct.cZ.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(kxm.F(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      kbp.a(null, "CliOper", "", String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin), (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), paramArticleInfo.businessId + "", Integer.toString(paramArticleInfo.mStrategyId), ((nce.a)localObject3).a().toJsonString(), false);
    }
    for (;;)
    {
      kbp.d((String)localObject2, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), i1, i, m, aqiw.isWifiConnected(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), n, paramArticleInfo));
      localObject1 = new ArrayList();
      localObject2 = new ReportInfo();
      ((ReportInfo)localObject2).mUin = kxm.getLongAccountUin();
      ((ReportInfo)localObject2).mSource = 0;
      ((ReportInfo)localObject2).mSourceArticleId = paramArticleInfo.mArticleID;
      ((ReportInfo)localObject2).mChannelId = this.mChannelID;
      ((ReportInfo)localObject2).mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      ((ReportInfo)localObject2).mStrategyId = paramArticleInfo.mStrategyId;
      ((ReportInfo)localObject2).mOperation = 1;
      ((ReportInfo)localObject2).mServerContext = paramArticleInfo.mServerContext;
      ((ReportInfo)localObject2).mReadTimeLength = -1;
      ((ReportInfo)localObject2).mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!mgn.Z(paramArticleInfo)) && (!kxj.a().AH()) && (kxm.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        ((ReportInfo)localObject2).noDifferenceJump = 1;
      }
      if (paramArticleInfo.mVideoColumnInfo != null) {
        ((ReportInfo)localObject2).mColumnID = paramArticleInfo.mVideoColumnInfo.aHc;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label932;
      }
      localObject3 = new ReportInfo.a();
      ((ReportInfo.a)localObject3).vd = paramArticleInfo.mSocialFeedInfo.mFeedId;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e != null) {
        ((ReportInfo.a)localObject3).vg = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
      }
      ((ReportInfo.a)localObject3).aSx = paramArticleInfo.mSocialFeedInfo.mLikeCount;
      ((ReportInfo.a)localObject3).aSy = paramArticleInfo.mSocialFeedInfo.mCommentCount;
      Object localObject4 = paramArticleInfo.mSocialFeedInfo.iS;
      if ((localObject4 == null) || (((List)localObject4).isEmpty())) {
        break label925;
      }
      ((ReportInfo.a)localObject3).iR = new ArrayList();
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        SocializeFeedsInfo.e locale = (SocializeFeedsInfo.e)((Iterator)localObject4).next();
        if (locale != null) {
          ((ReportInfo.a)localObject3).iR.add(Long.valueOf(locale.uin));
        }
      }
      i = 0;
      break;
      label765:
      m = 1;
      break label36;
      label770:
      n = 56;
      break label49;
      label777:
      localObject3 = new nce.a(kxm.a(paramArticleInfo.mAlgorithmID, kxm.a(paramArticleInfo), i1, i, m, aqiw.isWifiConnected(getContext()), (String)localObject1, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, kxm.h(paramArticleInfo), n, paramArticleInfo));
      if (this.mChannelID == 0) {
        ((nce.a)localObject3).h(n).c((String)kct.cZ.get(ReadInJoyChannelActivity.class)).a(Boolean.valueOf(kxm.F(paramArticleInfo))).a(paramArticleInfo.videoReportInfo);
      }
      kbp.a(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject2, (String)localObject2, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), ((nce.a)localObject3).a().toJsonString(), false);
    }
    label925:
    ((ReportInfo)localObject2).mFeedsReportData = ((ReportInfo.a)localObject3);
    label932:
    ((List)localObject1).add(localObject2);
    lbz.a().cb((List)localObject1);
    if ((paramArticleInfo instanceof AdvertisementInfo))
    {
      if (!ods.a((AdvertisementInfo)paramArticleInfo, i1)) {
        break label1010;
      }
      i = jzk.aFC;
    }
    for (;;)
    {
      jzk.a(new kku.a().a(BaseApplicationImpl.getContext()).a(jzk.aEJ).b(i).a((AdvertisementInfo)paramArticleInfo).a());
      return;
      label1010:
      if (kxm.j(paramArticleInfo)) {
        i = jzk.aFB;
      } else {
        i = jzk.aFw;
      }
    }
  }
  
  public void D(Map<Integer, mgu> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        mgu localmgu = (mgu)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localmgu.f;
        int m = kqo.aLl;
        if ((localmgu.f != null) && (localmgu.f.redPoint != null) && (localmgu.f.redPoint.isShow)) {}
        for (int i = localmgu.f.redPoint.type + 1;; i = 0)
        {
          kqo.a("0X8009495", localTabChannelCoverInfo, m, i, -1);
          break;
        }
      }
    }
  }
  
  public void F(Map<Integer, mgu> paramMap)
  {
    a(new nfh(this, "attachToViewGroup#1", paramMap));
    if (this.jdField_a_of_type_Kgq != null) {
      this.jdField_a_of_type_Kgq.E(paramMap);
    }
  }
  
  public boolean Fu()
  {
    return (this.mChannelID == 56) && (this.jdField_a_of_type_Kfr.getActivity().getIntent().getLongExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", 0L) != 0L);
  }
  
  public boolean Fv()
  {
    int i = getCurrentActivity().getIntent().getIntExtra("launch_from", -1);
    return (i == 9) || (i == 6);
  }
  
  public boolean Fw()
  {
    return getCurrentActivity().getIntent().getIntExtra("launch_from", -1) == 13;
  }
  
  public boolean Fx()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "[isOpenFloatingWindow], res = " + this.arS);
    }
    return this.arS;
  }
  
  public void G(Map<Integer, Boolean> paramMap) {}
  
  public void H(Map<Integer, Boolean> paramMap)
  {
    paramMap.put(Integer.valueOf(this.mChannelID), Boolean.valueOf(true));
  }
  
  public void O(boolean paramBoolean, int paramInt)
  {
    if (!this.aeK) {}
    do
    {
      return;
      if (paramInt != 8) {
        break;
      }
      aWP();
    } while (!this.arR);
    a(new nfk(this, "onBackToTop", paramBoolean, paramInt));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.post(new ReadInJoyListViewGroup.16(this, paramBoolean));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.tw(paramInt);
    }
    for (;;)
    {
      aDB();
      lft.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      t(2, null);
    }
  }
  
  public Object a(lge paramlge)
  {
    if (paramlge == null) {
      return null;
    }
    int i = -1;
    int m = 0;
    Object localObject = null;
    long l1;
    if (m < this.av.size())
    {
      l1 = SystemClock.currentThreadTimeMillis();
      paramlge.a((lfz)this.av.valueAt(m));
      if (paramlge.aI == null) {
        break label210;
      }
      if (localObject == null)
      {
        localObject = paramlge.aI;
        i = ((lfz)this.av.valueAt(m)).np();
        paramlge.aI = null;
      }
    }
    label210:
    for (;;)
    {
      long l2 = SystemClock.currentThreadTimeMillis();
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute with return value handler job , id : ", Integer.valueOf(this.av.keyAt(m)), ", jobName : ", paramlge.aV(), ", cost : ", Long.valueOf(l2 - l1) });
      m += 1;
      break;
      throw new RuntimeException("has more than one handler return value. preHandlerID : " + i + ", now : " + ((lfz)this.av.valueAt(m)).np());
      return localObject;
    }
  }
  
  public lfz a()
  {
    return c(2);
  }
  
  public ndh a()
  {
    return this.jdField_a_of_type_Ndh;
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo, String paramString1, String paramString2)
  {
    if ((paramArticleInfo != null) && (this.mChannelID == paramArticleInfo.mChannelID))
    {
      if (paramInt == 0)
      {
        ksz.a(paramArticleInfo, ArticleCommentModule.buildFeedsOutsideComment(paramArticleInfo, paramString1), false);
        ksz.a(paramArticleInfo, paramString1);
        QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult succeed ");
      }
    }
    else {
      return;
    }
    QLog.d("ReadInJoyListViewGroup", 2, "onSubmitCommentResult failed " + paramInt);
    QQToast.a(getCurrentActivity(), 1, paramString2, 0).show();
  }
  
  public void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!TextUtils.isEmpty(paramString)) {
      if (Boolean.valueOf(awit.I(kxm.getAppRuntime())).booleanValue()) {
        ntp.b(paramContext, "", "https://viola.qq.com/js/kd_pic_detail.js?_rij_violaUrl=1&v_tid=15&v_bid=3811&v_bundleName=kd_pic_detail&hideNav=1&v_nav_immer=1&v_minVersion=8.0.8&v_from_native=1&album_source=" + paramInt2 + "&rowkey=" + paramString, null);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        lbz.a().H(paramArticleInfo.mArticleID, System.currentTimeMillis());
        this.jdField_a_of_type_Ndh.notifyDataSetChanged();
        odv.J(paramArticleInfo);
        return;
        if (QLog.isColorLevel()) {
          QLog.e("ReadInJoyListViewGroup", 2, "jumpToGallery failed: isShowViolaPage is false");
        }
      }
    }
    QLog.e("ReadInJoyListViewGroup", 2, "rowKey is empty");
  }
  
  public void a(View paramView, ArticleInfo paramArticleInfo, int paramInt)
  {
    if (paramArticleInfo == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            kxm.c = paramArticleInfo;
            a(new nfy(this, "onRegionClick", paramView, paramArticleInfo, paramInt));
            if (paramInt != 2) {
              break;
            }
          } while (muj.a(paramArticleInfo, getContext()));
          paramInt = ndi.k(paramArticleInfo);
          if ((paramInt == 23) || (paramInt == 26) || (paramInt == 56) || (paramInt == 59) || (paramInt == 19) || (paramInt == 17) || (paramInt == 11) || (paramInt == 28))
          {
            a(paramArticleInfo, paramView);
            return;
          }
          paramInt = ndi.k(paramArticleInfo);
          if ((mde.dP(paramInt)) || (ndi.S(paramArticleInfo)) || (ndi.ak(paramArticleInfo)) || (ndi.T(paramArticleInfo)) || (ndi.U(paramArticleInfo)))
          {
            if ((paramInt == 11) || (paramInt == 28) || (ndi.i(paramArticleInfo) == 23) || (ndi.j(paramArticleInfo) == 56)) {
              a(paramArticleInfo, null, 0, 0, false, 0);
            }
            if ((paramInt == 95) || (paramInt == 94)) {
              kxm.aJ(getContext(), paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$q.webUrl);
            }
            for (;;)
            {
              aWG();
              return;
              if (paramArticleInfo.isPGCShortContent()) {
                lrm.b(getContext(), paramArticleInfo);
              } else if (!AdvertisementInfo.isAdvertisementInfo(paramArticleInfo)) {
                c(paramArticleInfo, paramView);
              }
            }
          }
        } while ((!ndi.K(paramArticleInfo)) && (!ndi.R(paramArticleInfo)) && (!kxm.i(paramArticleInfo)) && (!kxm.j(paramArticleInfo)) && (!kxm.l(paramArticleInfo)) && (!kxm.m(paramArticleInfo)));
        if (kxm.j(paramArticleInfo))
        {
          a(paramArticleInfo, null, 0, 0, false, 0);
          return;
        }
        if (paramArticleInfo.isPGCShortContent())
        {
          lrm.b(getContext(), paramArticleInfo);
          return;
        }
      } while (AdvertisementInfo.isAdvertisementInfo(paramArticleInfo));
      c(paramArticleInfo, paramView);
      return;
    } while (paramInt != 1);
    if (paramArticleInfo.isPGCShortContent())
    {
      lrm.b(getContext(), paramArticleInfo);
      return;
    }
    j(paramArticleInfo, 2);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    ArticleInfo localArticleInfo = (ArticleInfo)paramBaseArticleInfo;
    if (kxm.B(localArticleInfo)) {
      if ((kxm.v(localArticleInfo)) || (kxm.l(localArticleInfo)))
      {
        a(localArticleInfo, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
        paramInt = 4;
      }
    }
    for (;;)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity))
      {
        ((ReadInJoyNewFeedsActivity)getContext()).oT(paramInt);
        label70:
        if (kys.dv(this.mChannelID)) {
          kvs.oT(paramInt);
        }
        aWG();
      }
      do
      {
        return;
        if (kxm.n(localArticleInfo))
        {
          if (!QLog.isColorLevel()) {
            break label178;
          }
          QLog.e("ReadInJoyListViewGroup", 2, "atlas native has undercarriage");
          paramInt = 0;
          break;
        }
        f(localArticleInfo);
        paramInt = 2;
        break;
        if (!(getContext() instanceof SplashActivity)) {
          break label70;
        }
        paramBaseArticleInfo = kxm.a(getContext());
        if (paramBaseArticleInfo == null) {
          break label70;
        }
        paramBaseArticleInfo.oT(paramInt);
        break label70;
        a(null, paramBaseArticleInfo, paramView, paramInt, paramLong);
      } while (paramBaseArticleInfo == null);
      paramBaseArticleInfo.invalidateProteusTemplateBean();
      return;
      label178:
      paramInt = 0;
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    this.aRd = paramInt;
    a(new nfv(this, "onStartTopRefresh", paramReadInJoyBaseListView, paramInt));
    boolean bool1;
    label59:
    int i;
    if (paramInt != 0)
    {
      bool1 = true;
      if (kys.dv(this.mChannelID))
      {
        if (Aladdin.getConfig(252).getIntegerFromString("fix_daily", 0) != 0) {
          break label227;
        }
        kvs.oT(1);
      }
      if ((kxm.AI()) && (!zn()) && (!bool1)) {
        break label239;
      }
      i = 1;
      label79:
      if (i == 0) {
        break label244;
      }
      i = 3;
      label85:
      if (paramInt == 2) {
        break label313;
      }
      if (!(getContext() instanceof ReadInJoyNewFeedsActivity)) {
        break label251;
      }
      paramReadInJoyBaseListView = (ReadInJoyNewFeedsActivity)getContext();
      paramReadInJoyBaseListView.oT(1);
      if (this.mChannelID == 0) {
        paramReadInJoyBaseListView.md(false);
      }
      label125:
      kxm.pW(3);
      label129:
      d(true, i, bool1);
      if ((this.mChannelID == 0) && (paramInt != 2))
      {
        if (!awit.aMQ()) {
          break label336;
        }
        lbz.a().a().aMx();
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.31(this));
      paramReadInJoyBaseListView = this.jW.iterator();
      while (paramReadInJoyBaseListView.hasNext())
      {
        nny localnny = (nny)paramReadInJoyBaseListView.next();
        if ((localnny instanceof ReadInJoyDiandianHeaderController)) {
          localnny.onRefresh();
        }
      }
      bool1 = false;
      break;
      label227:
      if (paramInt == 2) {
        break label59;
      }
      kvs.oT(1);
      break label59;
      label239:
      i = 0;
      break label79;
      label244:
      i = 1001;
      break label85;
      label251:
      if (!(getContext() instanceof SplashActivity)) {
        break label125;
      }
      lcc.a().h(2, null);
      paramReadInJoyBaseListView = kxm.a(getContext());
      boolean bool2 = kxm.Y(this.mChannelID, paramInt);
      if ((paramReadInJoyBaseListView != null) && (bool2)) {
        paramReadInJoyBaseListView.oT(1);
      }
      if (paramInt == 3) {
        break label125;
      }
      odv.uy(1);
      break label125;
      label313:
      if ((getContext() instanceof SplashActivity)) {
        lcc.a().h(2, null);
      }
      i = 1;
      break label129;
      label336:
      lcc.a().qA(2);
    }
    if (this.mChannelID == 0) {
      odv.bdK();
    }
    lft.j(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void a(AdapterView<?> paramAdapterView, BaseArticleInfo paramBaseArticleInfo, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    if ((localObject instanceof lwm)) {
      ((lwm)localObject).aNS();
    }
    localObject = (ArticleInfo)paramBaseArticleInfo;
    int i;
    int i1;
    int n;
    int m;
    label247:
    int i2;
    if (localObject != null)
    {
      QLog.d("ReadInJoyListViewGroup", 1, "onItemClick, rowkey= " + paramBaseArticleInfo.innerUniqueID);
      a(new nfw(this, "onFeedsItemClick", paramAdapterView, paramView, paramInt, paramLong));
      if (kys.dv(this.mChannelID))
      {
        paramBaseArticleInfo.mJumpType = 1;
        awit.o(paramBaseArticleInfo);
      }
      kxm.c = (ArticleInfo)localObject;
      if (ndi.ag((BaseArticleInfo)localObject))
      {
        kxm.c(getCurrentActivity(), (ArticleInfo)localObject, 6);
        kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, nh());
        i = 0;
        i3 = i;
        if (!anwa.aze())
        {
          i3 = i;
          if (!((ArticleInfo)localObject).hasSearchWordInfo()) {
            if (ndi.k((ArticleInfo)localObject) != 3)
            {
              i3 = i;
              if (ndi.k((ArticleInfo)localObject) != 1) {}
            }
            else
            {
              i3 = i;
              if (((ArticleInfo)localObject).mIsShowSearchord == 1)
              {
                paramAdapterView = Aladdin.getConfig(201);
                if (paramAdapterView == null) {
                  break label2433;
                }
                i1 = paramAdapterView.getIntegerFromString("feeds_searchterm", 0);
                n = paramAdapterView.getIntegerFromString("feeds_searchterm_max", 1000);
                m = paramAdapterView.getIntegerFromString("feeds_pos_range_each_max", 3);
                if (!DateUtils.isToday(aqmj.bd("search_word_prefix_last_request_time")))
                {
                  aqmj.bn("search_word_prefix_last_request_time", System.currentTimeMillis());
                  aqmj.bn("search_word_prefix_show_times", 0L);
                }
                if (!this.ev.containsKey(((ArticleInfo)localObject).mRefreshTime)) {
                  break label2396;
                }
                i2 = ((Integer)this.ev.get(((ArticleInfo)localObject).mRefreshTime)).intValue();
                label310:
                i3 = i;
                if (i2 < m)
                {
                  i3 = i;
                  if (aqmj.bd("search_word_prefix_show_times") < n)
                  {
                    i3 = i;
                    if (i1 == 1) {
                      ((acnm)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getBusinessHandler(111)).a(ByteStringMicro.copyFromUtf8(((ArticleInfo)localObject).innerUniqueID), new nfx(this, (ArticleInfo)localObject, i2, paramInt));
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (int i3 = i;; i3 = 0)
    {
      if ((getContext() instanceof ReadInJoyNewFeedsActivity)) {
        ((ReadInJoyNewFeedsActivity)getContext()).oT(i3);
      }
      for (;;)
      {
        for (;;)
        {
          for (;;)
          {
            if (kys.dv(this.mChannelID)) {
              kvs.oT(i3);
            }
            aWG();
            return;
            if (kxm.u((BaseArticleInfo)localObject))
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              i = 4;
              break;
            }
            if (((ArticleInfo)localObject).mFeedType == 3)
            {
              paramAdapterView = BaseApplicationImpl.getApplication().getRuntime();
              label527:
              boolean bool;
              if ((paramAdapterView instanceof QQAppInterface))
              {
                paramView = (QQAppInterface)paramAdapterView;
                paramAdapterView = new aifd();
                if (this.mChannelID != 56) {
                  break label618;
                }
                paramAdapterView.bND = "kandian_video";
                paramAdapterView.bNC = "kandian_video";
                paramBaseArticleInfo = new Bundle();
                if (((ArticleInfo)localObject).mCommentIconType != 1) {
                  break label635;
                }
                bool = true;
                paramBaseArticleInfo.putBoolean("jump_now_switch", bool);
              }
              try
              {
                paramView = (aifl)paramView.getManager(306);
                paramBaseArticleInfo.putString("roomid", ((ArticleInfo)localObject).mArticleContentUrl);
                paramBaseArticleInfo.putString("fromid", paramAdapterView.bND);
                paramView.cL(paramBaseArticleInfo);
                kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
                i = 0;
                break;
                label618:
                paramAdapterView.bND = "kandian_shouye";
                paramAdapterView.bNC = "kandian_shouye";
                break label527;
                label635:
                bool = false;
              }
              catch (NumberFormatException paramAdapterView)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ReadInJoyListViewGroup", 2, "subscribeId to roomId error, " + paramAdapterView.getMessage());
                  }
                }
              }
            }
          }
          if (((ArticleInfo)localObject).mFeedType == 13)
          {
            paramAdapterView = ((ArticleInfo)localObject).mArticleContentUrl;
            if (!TextUtils.isEmpty(paramAdapterView))
            {
              paramBaseArticleInfo = new Intent(getContext(), QQBrowserActivity.class);
              paramBaseArticleInfo.putExtra("url", paramAdapterView);
              getContext().startActivity(paramBaseArticleInfo);
            }
            kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
            i = 0;
            break;
          }
          if ((((ArticleInfo)localObject).mFeedType == 22) || (((ArticleInfo)localObject).mFeedType == 21) || (kxm.u((ArticleInfo)localObject)))
          {
            kxm.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            i = 0;
            break;
          }
          if (ndi.L((ArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ShortContent feeds");
              QLog.d("ReadInJoyListViewGroup", 1, "tryJumpToUgUrl: true");
              ((ArticleInfo)localObject).click_jump_target = lrm.R(kvx.b((BaseArticleInfo)localObject), "-1");
            }
            for (;;)
            {
              paramBaseArticleInfo.click_area = 7;
              kxm.b(getContext(), (ArticleInfo)localObject, (int)paramBaseArticleInfo.mChannelID);
              i = 0;
              break;
              QLog.d("ReadInJoyListViewGroup", 1, "short content redirectToOtherPage");
              lrm.b(getContext(), (ArticleInfo)localObject);
            }
          }
          if ((ndi.K((ArticleInfo)localObject)) && (ndi.M((ArticleInfo)localObject)))
          {
            c((ArticleInfo)localObject, paramView);
            i = 0;
            break;
          }
          if (ndi.K((ArticleInfo)localObject))
          {
            kxm.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            i = 0;
            break;
          }
          if (ndi.k((ArticleInfo)localObject) == 71)
          {
            if ((paramView instanceof ProteusItemView)) {
              c((ProteusItemView)paramView);
            }
            for (;;)
            {
              a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              i = 4;
              break;
              if ((paramView instanceof LinearLayout)) {
                d((LinearLayout)paramView);
              }
            }
          }
          if ((ndi.ak((BaseArticleInfo)localObject)) || (ndi.T((ArticleInfo)localObject)))
          {
            kxm.a(getContext(), (ArticleInfo)localObject, 4, false, 3, false);
            ndi.g((ArticleInfo)localObject, this.jdField_a_of_type_Ndh.nh());
            i = 0;
            break;
          }
          if ((kxm.i((ArticleInfo)localObject)) || (kxm.j((ArticleInfo)localObject)))
          {
            kxm.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            ndi.g((ArticleInfo)localObject, this.jdField_a_of_type_Ndh.nh());
            kxm.b((ArticleInfo)localObject, this.jdField_a_of_type_Ndh.nh());
            i = 0;
            break;
          }
          if (kxm.g((ArticleInfo)localObject))
          {
            j((ArticleInfo)localObject, 1);
            kvp.a(getContext(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh);
            i = 2;
            break;
          }
          if ((ndi.S((ArticleInfo)localObject)) || (ndi.U((ArticleInfo)localObject)))
          {
            kxm.a(getContext(), (ArticleInfo)localObject, 0, false, 1, false);
            ndi.g((ArticleInfo)localObject, this.jdField_a_of_type_Ndh.nh());
            i = 0;
            break;
          }
          if (ndi.R((ArticleInfo)localObject))
          {
            if (ndi.M((ArticleInfo)localObject))
            {
              c((ArticleInfo)localObject, paramView);
              i = 0;
              break;
            }
            kxm.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
            i = 0;
            break;
          }
          if (kxm.j((BaseArticleInfo)localObject))
          {
            if ((((ArticleInfo)localObject).isTwoItemVideoFeed()) && (((ArticleInfo)localObject).mFeedType != 36))
            {
              QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() RETURN article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle);
              return;
            }
            if (ndi.k((ArticleInfo)localObject) == 6)
            {
              if ((paramView instanceof ProteusItemView)) {
                c((ProteusItemView)paramView);
              }
            }
            else
            {
              label1363:
              if (!a((ArticleInfo)localObject, paramView)) {
                break label1566;
              }
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug video feeds");
              lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Ndh.notifyDataSetChanged();
              kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.readinjoy.video", 2, "JumpAndForceInsert onVideoArticleClick() article.mArticleID:" + ((ArticleInfo)localObject).mArticleID + " article.mTitle:" + ((ArticleInfo)localObject).mTitle + " article.mSummary:" + ((ArticleInfo)localObject).mSummary + "mJsonVideoList:" + ((ArticleInfo)localObject).mJsonVideoList + " videoJumpChannelID=" + ((ArticleInfo)localObject).videoJumpChannelID + " videoJumpChannelName=" + ((ArticleInfo)localObject).videoJumpChannelName + " videoJumpChannelType=" + ((ArticleInfo)localObject).videoJumpChannelType);
              }
              i = 4;
              break;
              if (!(paramView instanceof LinearLayout)) {
                break label1363;
              }
              d((LinearLayout)paramView);
              break label1363;
              label1566:
              if (b((ArticleInfo)localObject, paramView))
              {
                QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt video feeds");
              }
              else if (paramBaseArticleInfo.isAccountShown)
              {
                paramBaseArticleInfo.click_area = 7;
                paramBaseArticleInfo.click_jump_target = lrm.R("", "3");
                f((ArticleInfo)localObject);
              }
              else
              {
                a((ArticleInfo)localObject, paramView, paramView.getTop(), paramView.getLeft(), true, paramInt);
              }
            }
          }
          if (kxm.m((BaseArticleInfo)localObject))
          {
            if (a((ArticleInfo)localObject, paramView))
            {
              kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit Gallery feeds");
              label1690:
              lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              if (this.jdField_a_of_type_Ndh == null) {
                break label2447;
              }
            }
            try
            {
              if (!TextUtils.isEmpty(ntp.fd(((ArticleInfo)localObject).mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
              {
                if (this.mUiHandler == null) {
                  this.mUiHandler = new Handler(Looper.getMainLooper());
                }
                this.mUiHandler.postDelayed(new ReadInJoyListViewGroup.34(this), 2000L);
              }
              for (;;)
              {
                i = 0;
                break;
                i((ArticleInfo)localObject, paramInt - 1);
                break label1690;
                this.jdField_a_of_type_Ndh.notifyDataSetChanged();
              }
            }
            catch (Exception paramAdapterView)
            {
              this.jdField_a_of_type_Ndh.notifyDataSetChanged();
              i = 0;
            }
          }
        }
        if ((kxm.a(((ArticleInfo)localObject).mArticleContentUrl, ((ArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) || (((ArticleInfo)localObject).isAccountShown))
        {
          if (paramBaseArticleInfo.isAccountShown) {
            paramBaseArticleInfo.click_area = 7;
          }
          if (a((ArticleInfo)localObject, paramView))
          {
            QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit ug normal feeds");
            lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
            this.jdField_a_of_type_Ndh.notifyDataSetChanged();
            paramBaseArticleInfo.click_jump_target = lrm.R(kvx.b((BaseArticleInfo)localObject), "-1");
            kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
          }
          for (;;)
          {
            i = 2;
            break;
            if (b((ArticleInfo)localObject, paramView))
            {
              QLog.d("ReadInJoyListViewGroup", 2, "main feeds hit srt normal feeds");
              paramBaseArticleInfo.click_jump_target = lrm.R(kxj.a().gd(), "-1");
            }
            else if ((!mgn.Z((BaseArticleInfo)localObject)) && (!kxj.a().AH()) && (kxm.a(paramView.getContext(), (BaseArticleInfo)localObject)))
            {
              kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
              lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Ndh.notifyDataSetChanged();
              paramAdapterView = kxm.eA(((ArticleInfo)localObject).getInnerUniqueID());
              paramBaseArticleInfo.click_jump_target = lrm.R(paramAdapterView, "-1");
              kxm.a(paramView.getContext(), (BaseArticleInfo)localObject, paramAdapterView);
            }
            else if (lfy.G(paramView.getContext(), ((ArticleInfo)localObject).mArticleContentUrl))
            {
              kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
              lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
              this.jdField_a_of_type_Ndh.notifyDataSetChanged();
            }
            else
            {
              paramBaseArticleInfo.click_jump_target = lrm.R("", "3");
              f((ArticleInfo)localObject);
            }
          }
        }
        if (((ArticleInfo)localObject).mFeedType == 26)
        {
          if ((((ArticleInfo)localObject).mSocialFeedInfo == null) || (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u == null) || (TextUtils.isEmpty(((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.jumpUrl))) {
            break label2447;
          }
          kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
          kxm.aL(getContext(), ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$u.jumpUrl);
          lbz.a().H(((ArticleInfo)localObject).mArticleID, System.currentTimeMillis());
          i = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 23)
        {
          kxm.a(getContext(), (ArticleInfo)localObject, 1, false, 4, false);
          i = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 34)
        {
          kxm.a(getContext(), ((ArticleInfo)localObject).mArticleContentUrl, null);
          ndi.g((ArticleInfo)localObject, this.jdField_a_of_type_Ndh.nh());
          i = 0;
          break;
        }
        if (((ArticleInfo)localObject).mFeedType == 39)
        {
          knd.a((ArticleInfo)localObject, getContext(), paramInt);
          i = 0;
          break;
        }
        if ((!AdvertisementInfo.isAdvertisementInfo((BaseArticleInfo)localObject)) && (this.jdField_a_of_type_Ndh != null) && (!ndi.ag((BaseArticleInfo)localObject))) {
          kxm.a(getCurrentActivity(), (ArticleInfo)localObject, this.jdField_a_of_type_Ndh, this.mChannelID);
        }
        i = 2;
        break;
        label2396:
        i2 = 0;
        break label310;
        if ((getContext() instanceof SplashActivity))
        {
          paramAdapterView = kxm.a(getContext());
          if (paramAdapterView != null) {
            paramAdapterView.oT(i3);
          }
        }
      }
      label2433:
      i1 = 0;
      n = 1000;
      m = 3;
      break label247;
      label2447:
      i = 0;
      break;
    }
  }
  
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "detachFromViewGroup()");
    }
    a(new nfj(this, "detachFromViewGroup", paramMap, paramBoolean));
    Map localMap = odv.a(this.mChannelID);
    String str = kxm.bf(this.mChannelID);
    ThreadManager.post(new ReadInJoyListViewGroup.14(this, zl(), paramMap, paramBoolean, localMap, str), 5, null, false);
    if (zn())
    {
      if (this.mChannelID != 56) {
        break label156;
      }
      awit.a((QQAppInterface)kxm.getAppRuntime(), System.currentTimeMillis(), getCurrentActivity());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.pu(false);
      }
      getCurrentActivity().getIntent().putExtra("from_search", false);
      return;
      label156:
      awit.g((QQAppInterface)kxm.getAppRuntime(), System.currentTimeMillis(), this.mChannelID);
    }
  }
  
  /* Error */
  public void a(Map<Long, mgu> paramMap, boolean paramBoolean, Map<Long, odv.b> paramMap1, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: invokeinterface 3431 1 0
    //   10: ifne +7 -> 17
    //   13: iload_2
    //   14: ifne +35 -> 49
    //   17: ldc_w 658
    //   20: iconst_2
    //   21: ldc_w 3433
    //   24: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   27: aload_3
    //   28: ifnull +20 -> 48
    //   31: aload_3
    //   32: invokeinterface 3431 1 0
    //   37: ifne +11 -> 48
    //   40: aload_3
    //   41: aload_0
    //   42: getfield 150	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:isFromAIO	Z
    //   45: invokestatic 3435	odv:c	(Ljava/util/Map;Z)V
    //   48: return
    //   49: aload_0
    //   50: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   53: bipush 56
    //   55: if_icmpne +87 -> 142
    //   58: aload_0
    //   59: getfield 281	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Kfr	Lkfr;
    //   62: invokevirtual 3438	kfr:a	()Lmyp;
    //   65: astore 14
    //   67: aload 14
    //   69: ifnull +73 -> 142
    //   72: aload_1
    //   73: invokeinterface 319 1 0
    //   78: invokeinterface 325 1 0
    //   83: astore 15
    //   85: aload 15
    //   87: invokeinterface 330 1 0
    //   92: ifeq +50 -> 142
    //   95: aload 15
    //   97: invokeinterface 334 1 0
    //   102: checkcast 336	mgu
    //   105: astore 16
    //   107: aload 16
    //   109: aload 14
    //   111: invokevirtual 3443	myp:qi	()I
    //   114: putfield 3446	mgu:aRB	I
    //   117: aload 14
    //   119: aload 16
    //   121: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   124: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   127: invokevirtual 3450	myp:aR	(J)Z
    //   130: ifeq -45 -> 85
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 3453	mgu:amu	Z
    //   139: goto -54 -> 85
    //   142: new 143	java/util/HashMap
    //   145: dup
    //   146: invokespecial 144	java/util/HashMap:<init>	()V
    //   149: astore 18
    //   151: aload_1
    //   152: invokeinterface 319 1 0
    //   157: invokeinterface 325 1 0
    //   162: astore 19
    //   164: aload 19
    //   166: invokeinterface 330 1 0
    //   171: ifeq +4179 -> 4350
    //   174: aload 19
    //   176: invokeinterface 334 1 0
    //   181: checkcast 336	mgu
    //   184: astore 20
    //   186: aload 20
    //   188: getfield 3456	mgu:amp	Z
    //   191: ifne -27 -> 164
    //   194: aload 20
    //   196: iconst_1
    //   197: putfield 3456	mgu:amp	Z
    //   200: aload_0
    //   201: invokespecial 3458	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:m	()Landroid/util/Pair;
    //   204: astore 14
    //   206: aload 14
    //   208: getfield 2400	android/util/Pair:second	Ljava/lang/Object;
    //   211: checkcast 304	java/lang/Long
    //   214: invokevirtual 308	java/lang/Long:longValue	()J
    //   217: lstore 8
    //   219: aload 14
    //   221: getfield 1112	android/util/Pair:first	Ljava/lang/Object;
    //   224: checkcast 592	java/lang/Integer
    //   227: invokevirtual 602	java/lang/Integer:intValue	()I
    //   230: istore 7
    //   232: aconst_null
    //   233: ldc_w 1207
    //   236: ldc_w 1209
    //   239: ldc_w 1209
    //   242: ldc_w 3460
    //   245: ldc_w 3460
    //   248: iconst_0
    //   249: iconst_0
    //   250: ldc_w 1209
    //   253: aload 20
    //   255: getfield 355	mgu:v	Ljava/lang/Long;
    //   258: invokevirtual 308	java/lang/Long:longValue	()J
    //   261: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   264: aload 20
    //   266: getfield 373	mgu:mStrategyId	I
    //   269: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   272: aload 20
    //   274: getfield 367	mgu:mAlgorithmID	J
    //   277: aload 20
    //   279: getfield 3463	mgu:mArticleType	I
    //   282: aload_0
    //   283: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   286: aload 20
    //   288: getfield 3466	mgu:aRx	I
    //   291: invokestatic 3468	kxm:a	(JIII)Ljava/lang/String;
    //   294: iconst_0
    //   295: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   298: ldc_w 3460
    //   301: ldc_w 1209
    //   304: ldc_w 1209
    //   307: aload 20
    //   309: getfield 355	mgu:v	Ljava/lang/Long;
    //   312: invokevirtual 308	java/lang/Long:longValue	()J
    //   315: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   318: aload 20
    //   320: getfield 373	mgu:mStrategyId	I
    //   323: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   326: aload 20
    //   328: getfield 367	mgu:mAlgorithmID	J
    //   331: aload 20
    //   333: getfield 3463	mgu:mArticleType	I
    //   336: aload_0
    //   337: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   340: aload 20
    //   342: getfield 3466	mgu:aRx	I
    //   345: invokestatic 3468	kxm:a	(JIII)Ljava/lang/String;
    //   348: invokestatic 2740	kbp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload 20
    //   353: getfield 367	mgu:mAlgorithmID	J
    //   356: aload 20
    //   358: getfield 3463	mgu:mArticleType	I
    //   361: aload_0
    //   362: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   365: aload 20
    //   367: getfield 3466	mgu:aRx	I
    //   370: aload 20
    //   372: getfield 3471	mgu:aRy	I
    //   375: aload_0
    //   376: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   379: invokestatic 2748	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   382: aload 20
    //   384: getfield 3474	mgu:agM	Ljava/lang/String;
    //   387: aload 20
    //   389: getfield 3475	mgu:mStrCircleId	Ljava/lang/String;
    //   392: aload 20
    //   394: getfield 389	mgu:agO	Ljava/lang/String;
    //   397: aload 20
    //   399: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   402: invokestatic 2753	kxm:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   405: aload 20
    //   407: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   410: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   413: lload 8
    //   415: iload 7
    //   417: aload 20
    //   419: getfield 3478	mgu:aRz	I
    //   422: aload 20
    //   424: getfield 3481	mgu:aRA	I
    //   427: aload 20
    //   429: getfield 3446	mgu:aRB	I
    //   432: aload 20
    //   434: getfield 3453	mgu:amu	Z
    //   437: aload 20
    //   439: getfield 3484	mgu:aRD	I
    //   442: aload 20
    //   444: getfield 3487	mgu:aRC	I
    //   447: aload 20
    //   449: getfield 3490	mgu:aRF	I
    //   452: invokestatic 3493	kxm:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   455: astore 16
    //   457: aload 20
    //   459: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   462: ifnull -298 -> 164
    //   465: aload_0
    //   466: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   469: bipush 56
    //   471: if_icmpne +453 -> 924
    //   474: aload 16
    //   476: aload_0
    //   477: getfield 281	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Kfr	Lkfr;
    //   480: invokevirtual 1816	kfr:a	()Lmye;
    //   483: invokevirtual 3498	mye:kx	()Ljava/lang/String;
    //   486: getstatic 1499	kct:aHF	I
    //   489: invokestatic 3501	kxm:e	(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   492: astore 14
    //   494: aload 20
    //   496: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   499: ifnull +3919 -> 4418
    //   502: aload 20
    //   504: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   507: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   510: ifnull +3908 -> 4418
    //   513: new 1350	nce$a
    //   516: dup
    //   517: aload 14
    //   519: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   522: aload 20
    //   524: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   527: invokevirtual 3504	nce$a:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   530: aload 20
    //   532: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   535: invokevirtual 3506	nce$a:d	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   538: aload 20
    //   540: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   543: getfield 3507	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   546: invokevirtual 2772	nce$a:a	(Ljava/lang/String;)Lnce$a;
    //   549: invokevirtual 2781	nce$a:a	()Lnce;
    //   552: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   555: astore 14
    //   557: aload 20
    //   559: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   562: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   565: invokestatic 871	ndi:k	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   568: bipush 46
    //   570: if_icmpeq +14 -> 584
    //   573: aload 20
    //   575: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   578: getfield 3510	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   581: ifeq +121 -> 702
    //   584: aload 20
    //   586: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   589: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   592: ifnull +110 -> 702
    //   595: aload 20
    //   597: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   600: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   603: getfield 3520	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   606: ifnull +96 -> 702
    //   609: aload 20
    //   611: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   614: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   617: getfield 3520	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   620: getfield 3525	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   623: invokestatic 3528	kxm:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   626: ifeq +76 -> 702
    //   629: aload 20
    //   631: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   634: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   637: getfield 3520	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   640: getfield 3531	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   643: invokestatic 3528	kxm:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Z
    //   646: ifeq +56 -> 702
    //   649: new 433	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   656: aload 20
    //   658: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   661: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   664: getfield 3520	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   667: getfield 3525	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_report_base_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   670: invokestatic 3534	kxm:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   673: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload 20
    //   678: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   681: getfield 3514	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoDownloadBarInfo	Ltencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo;
    //   684: getfield 3520	tencent/im/oidb/articlesummary/articlesummary$VideoDownloadBarInfo:weishiUGInfo	Ltencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo;
    //   687: getfield 3531	tencent/im/oidb/articlesummary/articlesummary$WeishiUGInfo:bytes_exposure_report_tail	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   690: invokestatic 3534	kxm:a	(Lcom/tencent/mobileqq/pb/PBBytesField;)Ljava/lang/String;
    //   693: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 3537	muj:nW	(Ljava/lang/String;)V
    //   702: aload 14
    //   704: astore 15
    //   706: new 2324	org/json/JSONObject
    //   709: dup
    //   710: aload 15
    //   712: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   715: astore 14
    //   717: aload 14
    //   719: ldc_w 3540
    //   722: aload 4
    //   724: invokevirtual 2334	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   727: pop
    //   728: aload 14
    //   730: ldc_w 3542
    //   733: invokestatic 233	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   736: aload_0
    //   737: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   740: invokestatic 3547	kyn:a	(Lmqq/app/AppRuntime;I)I
    //   743: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   746: pop
    //   747: aload 20
    //   749: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   752: ifnonnull +645 -> 1397
    //   755: aload 14
    //   757: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   760: astore 14
    //   762: aload_0
    //   763: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   766: i2l
    //   767: invokestatic 3550	odv:aT	(J)Z
    //   770: ifeq +745 -> 1515
    //   773: ldc_w 3552
    //   776: astore 15
    //   778: aload_0
    //   779: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   782: invokestatic 605	kys:dt	(I)Z
    //   785: ifne +14 -> 799
    //   788: aload_0
    //   789: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   792: i2l
    //   793: invokestatic 3555	awit:ds	(J)Z
    //   796: ifeq +3619 -> 4415
    //   799: ldc_w 3557
    //   802: astore 15
    //   804: aload 20
    //   806: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   809: invokestatic 3560	ndi:am	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   812: ifeq +711 -> 1523
    //   815: iconst_0
    //   816: istore 5
    //   818: iload 5
    //   820: aload 20
    //   822: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   825: getfield 3564	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lmih;
    //   828: getfield 3569	mih:ld	Ljava/util/ArrayList;
    //   831: invokevirtual 3570	java/util/ArrayList:size	()I
    //   834: if_icmpge +883 -> 1717
    //   837: aconst_null
    //   838: aload 20
    //   840: getfield 3573	mgu:agN	Ljava/lang/String;
    //   843: aload 15
    //   845: aload 15
    //   847: iconst_0
    //   848: iconst_0
    //   849: aload 20
    //   851: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   854: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   857: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   860: new 433	java/lang/StringBuilder
    //   863: dup
    //   864: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   867: aload 20
    //   869: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   872: getfield 3564	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mTopicRecommendFeedsInfo	Lmih;
    //   875: getfield 3569	mih:ld	Ljava/util/ArrayList;
    //   878: iload 5
    //   880: invokevirtual 991	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   883: checkcast 3576	mih$b
    //   886: getfield 3578	mih$b:businessId	I
    //   889: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   892: ldc_w 1209
    //   895: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   901: aload 20
    //   903: getfield 373	mgu:mStrategyId	I
    //   906: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   909: aload 14
    //   911: iconst_0
    //   912: invokestatic 3581	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   915: iload 5
    //   917: iconst_1
    //   918: iadd
    //   919: istore 5
    //   921: goto -103 -> 818
    //   924: aload 16
    //   926: astore 15
    //   928: aload_0
    //   929: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   932: ifne -226 -> 706
    //   935: aload 20
    //   937: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   940: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   943: invokestatic 871	ndi:k	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   946: istore 5
    //   948: iload 5
    //   950: bipush 6
    //   952: if_icmpeq +45 -> 997
    //   955: iload 5
    //   957: bipush 66
    //   959: if_icmpeq +38 -> 997
    //   962: iload 5
    //   964: bipush 115
    //   966: if_icmpeq +31 -> 997
    //   969: iload 5
    //   971: bipush 28
    //   973: if_icmpeq +24 -> 997
    //   976: iload 5
    //   978: bipush 11
    //   980: if_icmpeq +17 -> 997
    //   983: iload 5
    //   985: bipush 26
    //   987: if_icmpeq +10 -> 997
    //   990: iload 5
    //   992: bipush 19
    //   994: if_icmpne +65 -> 1059
    //   997: aload 20
    //   999: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1002: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   1005: invokestatic 3583	kct:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)I
    //   1008: aload 16
    //   1010: invokestatic 3586	kct:j	(ILjava/lang/String;)Ljava/lang/String;
    //   1013: astore 14
    //   1015: aload 14
    //   1017: astore 15
    //   1019: iload 5
    //   1021: bipush 6
    //   1023: if_icmpne -317 -> 706
    //   1026: new 1350	nce$a
    //   1029: dup
    //   1030: aload 14
    //   1032: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   1035: astore 14
    //   1037: aload 14
    //   1039: invokestatic 3589	muj:pQ	()I
    //   1042: invokevirtual 3592	nce$a:ac	(I)Lnce$a;
    //   1045: pop
    //   1046: aload 14
    //   1048: invokevirtual 2781	nce$a:a	()Lnce;
    //   1051: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   1054: astore 15
    //   1056: goto -350 -> 706
    //   1059: iload 5
    //   1061: bipush 46
    //   1063: if_icmpeq +14 -> 1077
    //   1066: aload 20
    //   1068: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1071: getfield 3510	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isTwoItem	Z
    //   1074: ifeq +104 -> 1178
    //   1077: new 1350	nce$a
    //   1080: dup
    //   1081: aload 16
    //   1083: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   1086: astore 14
    //   1088: aload 14
    //   1090: aload 20
    //   1092: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1095: getfield 3593	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoVid	Ljava/lang/String;
    //   1098: invokevirtual 3595	nce$a:e	(Ljava/lang/String;)Lnce$a;
    //   1101: pop
    //   1102: aload 14
    //   1104: aload 20
    //   1106: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1109: invokestatic 2734	kxm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1112: invokevirtual 3598	nce$a:W	(I)Lnce$a;
    //   1115: pop
    //   1116: aload 14
    //   1118: aload 20
    //   1120: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1123: getfield 3507	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1126: invokevirtual 2772	nce$a:a	(Ljava/lang/String;)Lnce$a;
    //   1129: pop
    //   1130: iload 5
    //   1132: bipush 46
    //   1134: if_icmpne +34 -> 1168
    //   1137: aload 14
    //   1139: iconst_0
    //   1140: invokevirtual 3601	nce$a:x	(I)Lnce$a;
    //   1143: pop
    //   1144: aload 14
    //   1146: aload 20
    //   1148: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1151: invokevirtual 3603	nce$a:e	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   1154: pop
    //   1155: aload 14
    //   1157: invokevirtual 2781	nce$a:a	()Lnce;
    //   1160: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   1163: astore 14
    //   1165: goto -150 -> 1015
    //   1168: aload 14
    //   1170: iconst_1
    //   1171: invokevirtual 3601	nce$a:x	(I)Lnce$a;
    //   1174: pop
    //   1175: goto -31 -> 1144
    //   1178: iload 5
    //   1180: bipush 118
    //   1182: if_icmpne +103 -> 1285
    //   1185: new 1350	nce$a
    //   1188: dup
    //   1189: aload 16
    //   1191: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   1194: astore 14
    //   1196: aload 20
    //   1198: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1201: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1204: ifnull +54 -> 1258
    //   1207: aload 14
    //   1209: aload 20
    //   1211: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1214: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1217: getfield 406	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aHc	I
    //   1220: invokevirtual 3605	nce$a:aa	(I)Lnce$a;
    //   1223: pop
    //   1224: aload 20
    //   1226: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1229: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1232: getfield 3608	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1235: ifnull +23 -> 1258
    //   1238: aload 14
    //   1240: aload 20
    //   1242: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1245: getfield 401	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1248: getfield 3608	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:h	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1251: getfield 3613	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:WT	Ljava/lang/String;
    //   1254: invokevirtual 3615	nce$a:r	(Ljava/lang/String;)Lnce$a;
    //   1257: pop
    //   1258: aload 14
    //   1260: aload 20
    //   1262: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1265: getfield 3157	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1268: invokevirtual 3617	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   1271: pop
    //   1272: aload 14
    //   1274: invokevirtual 2781	nce$a:a	()Lnce;
    //   1277: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   1280: astore 14
    //   1282: goto -267 -> 1015
    //   1285: aload 16
    //   1287: astore 14
    //   1289: iload 5
    //   1291: sipush 128
    //   1294: if_icmpne -279 -> 1015
    //   1297: new 1350	nce$a
    //   1300: dup
    //   1301: aload 16
    //   1303: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   1306: astore 14
    //   1308: aload 20
    //   1310: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1313: getfield 3620	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1316: ifnull +54 -> 1370
    //   1319: aload 14
    //   1321: aload 20
    //   1323: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1326: getfield 3620	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1329: getfield 406	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:aHc	I
    //   1332: invokevirtual 3605	nce$a:aa	(I)Lnce$a;
    //   1335: pop
    //   1336: aload 20
    //   1338: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1341: getfield 3620	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1344: getfield 3622	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1347: ifnull +23 -> 1370
    //   1350: aload 14
    //   1352: aload 20
    //   1354: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1357: getfield 3620	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSimpleVideoColumnInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo;
    //   1360: getfield 3622	com/tencent/biz/pubaccount/readinjoy/struct/VideoColumnInfo:i	Lcom/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo;
    //   1363: getfield 3613	com/tencent/biz/pubaccount/readinjoy/struct/UrlJumpInfo:WT	Ljava/lang/String;
    //   1366: invokevirtual 3615	nce$a:r	(Ljava/lang/String;)Lnce$a;
    //   1369: pop
    //   1370: aload 14
    //   1372: aload 20
    //   1374: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1377: getfield 3157	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1380: invokevirtual 3617	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   1383: pop
    //   1384: aload 14
    //   1386: invokevirtual 2781	nce$a:a	()Lnce;
    //   1389: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   1392: astore 14
    //   1394: goto -379 -> 1015
    //   1397: aload 20
    //   1399: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1402: invokevirtual 3623	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isPGCShortContent	()Z
    //   1405: istore_2
    //   1406: aload 20
    //   1408: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1411: getfield 3626	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1414: invokestatic 1364	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1417: ifne +92 -> 1509
    //   1420: aload 20
    //   1422: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1425: getfield 3626	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:proteusItemsData	Ljava/lang/String;
    //   1428: ldc_w 3628
    //   1431: invokevirtual 3630	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1434: ifeq +75 -> 1509
    //   1437: iconst_1
    //   1438: istore 5
    //   1440: goto +2981 -> 4421
    //   1443: aload_3
    //   1444: aload 20
    //   1446: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1449: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1452: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1455: invokeinterface 2138 2 0
    //   1460: checkcast 3632	odv$b
    //   1463: astore 16
    //   1465: aload 16
    //   1467: ifnull -712 -> 755
    //   1470: aload 16
    //   1472: getfield 3634	odv$b:d	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1475: aload 20
    //   1477: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1480: if_acmpne -725 -> 755
    //   1483: aload 14
    //   1485: ldc_w 3636
    //   1488: aload 16
    //   1490: getfield 3639	odv$b:duringTime	J
    //   1493: invokevirtual 2367	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   1496: pop
    //   1497: goto -742 -> 755
    //   1500: astore 14
    //   1502: aload 15
    //   1504: astore 14
    //   1506: goto -744 -> 762
    //   1509: iconst_0
    //   1510: istore 5
    //   1512: goto +2909 -> 4421
    //   1515: ldc_w 3641
    //   1518: astore 15
    //   1520: goto -742 -> 778
    //   1523: aload 20
    //   1525: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1528: invokestatic 980	kxm:u	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1531: ifeq +953 -> 2484
    //   1534: aload 20
    //   1536: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1539: invokestatic 3643	kxm:s	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   1542: ifeq +758 -> 2300
    //   1545: aload 20
    //   1547: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1550: getfield 3646	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mGroupSubArticleList	Ljava/util/List;
    //   1553: iconst_0
    //   1554: invokeinterface 302 2 0
    //   1559: checkcast 397	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo
    //   1562: astore 14
    //   1564: aload_0
    //   1565: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1568: aload 14
    //   1570: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1573: aload 14
    //   1575: getfield 3647	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1578: bipush 54
    //   1580: aload_0
    //   1581: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   1584: aload 14
    //   1586: invokevirtual 3648	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   1589: aload 14
    //   1591: invokevirtual 3651	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getVideoVid	()Ljava/lang/String;
    //   1594: aload 14
    //   1596: invokestatic 1199	odv:l	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1599: aload 14
    //   1601: getfield 3507	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   1604: invokestatic 3654	odv:a	(Landroid/content/Context;JJIILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    //   1607: astore 15
    //   1609: aload 15
    //   1611: astore 14
    //   1613: aload 20
    //   1615: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1618: ifnull +42 -> 1660
    //   1621: new 2324	org/json/JSONObject
    //   1624: dup
    //   1625: aload 15
    //   1627: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1630: astore 14
    //   1632: aload 20
    //   1634: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1637: getfield 3657	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:isShowGif	Z
    //   1640: ifeq +605 -> 2245
    //   1643: aload 14
    //   1645: ldc_w 3659
    //   1648: iconst_1
    //   1649: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1652: pop
    //   1653: aload 14
    //   1655: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1658: astore 14
    //   1660: aload 14
    //   1662: astore 15
    //   1664: aload 20
    //   1666: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1669: ifnull +38 -> 1707
    //   1672: new 2324	org/json/JSONObject
    //   1675: dup
    //   1676: aload 14
    //   1678: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1681: astore 15
    //   1683: aload 15
    //   1685: ldc_w 3661
    //   1688: aload 20
    //   1690: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1693: invokestatic 3663	kxm:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   1696: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1699: pop
    //   1700: aload 15
    //   1702: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1705: astore 15
    //   1707: aload 20
    //   1709: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1712: aload 15
    //   1714: invokestatic 3666	kxm:c	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Ljava/lang/String;)V
    //   1717: aload 20
    //   1719: getfield 3463	mgu:mArticleType	I
    //   1722: bipush 48
    //   1724: if_icmpeq +116 -> 1840
    //   1727: aload 20
    //   1729: getfield 3463	mgu:mArticleType	I
    //   1732: bipush 49
    //   1734: if_icmpeq +106 -> 1840
    //   1737: aload 20
    //   1739: getfield 3463	mgu:mArticleType	I
    //   1742: bipush 50
    //   1744: if_icmpeq +96 -> 1840
    //   1747: aload 20
    //   1749: getfield 3463	mgu:mArticleType	I
    //   1752: bipush 51
    //   1754: if_icmpeq +86 -> 1840
    //   1757: aload 20
    //   1759: getfield 3463	mgu:mArticleType	I
    //   1762: bipush 52
    //   1764: if_icmpeq +76 -> 1840
    //   1767: aload 20
    //   1769: getfield 3463	mgu:mArticleType	I
    //   1772: bipush 53
    //   1774: if_icmpeq +66 -> 1840
    //   1777: aload 20
    //   1779: getfield 3463	mgu:mArticleType	I
    //   1782: bipush 78
    //   1784: if_icmpeq +56 -> 1840
    //   1787: aload 20
    //   1789: getfield 3463	mgu:mArticleType	I
    //   1792: bipush 79
    //   1794: if_icmpeq +46 -> 1840
    //   1797: aload 20
    //   1799: getfield 3463	mgu:mArticleType	I
    //   1802: bipush 80
    //   1804: if_icmpeq +36 -> 1840
    //   1807: aload 20
    //   1809: getfield 3463	mgu:mArticleType	I
    //   1812: sipush 1005
    //   1815: if_icmpeq +25 -> 1840
    //   1818: aload 20
    //   1820: getfield 3463	mgu:mArticleType	I
    //   1823: sipush 1006
    //   1826: if_icmpeq +14 -> 1840
    //   1829: aload 20
    //   1831: getfield 3463	mgu:mArticleType	I
    //   1834: sipush 1007
    //   1837: if_icmpne +214 -> 2051
    //   1840: aload 20
    //   1842: getfield 3669	mgu:ve	J
    //   1845: lstore 12
    //   1847: aload 20
    //   1849: getfield 3672	mgu:mPosition	I
    //   1852: istore 5
    //   1854: aload_0
    //   1855: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   1858: aload 20
    //   1860: getfield 3463	mgu:mArticleType	I
    //   1863: invokestatic 3675	kvp:M	(II)I
    //   1866: istore 6
    //   1868: aload 20
    //   1870: getfield 3463	mgu:mArticleType	I
    //   1873: invokestatic 3677	kvp:db	(I)I
    //   1876: istore 7
    //   1878: lconst_0
    //   1879: lstore 8
    //   1881: aconst_null
    //   1882: astore 14
    //   1884: aconst_null
    //   1885: astore 15
    //   1887: aload 20
    //   1889: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1892: ifnull +2511 -> 4403
    //   1895: aload 20
    //   1897: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1900: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   1903: lstore 8
    //   1905: aload 20
    //   1907: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1910: getfield 3157	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   1913: astore 14
    //   1915: aload 20
    //   1917: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1920: getfield 3680	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:galleryReprotExdData	Ljava/lang/String;
    //   1923: astore 15
    //   1925: aload 20
    //   1927: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   1930: getfield 3647	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   1933: lstore 10
    //   1935: aload_0
    //   1936: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   1939: invokestatic 345	kxm:getLongAccountUin	()J
    //   1942: iload 6
    //   1944: lload 8
    //   1946: lload 12
    //   1948: iload 5
    //   1950: aload 14
    //   1952: aload 15
    //   1954: iload 7
    //   1956: aload_0
    //   1957: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   1960: invokestatic 3683	kvp:a	(Landroid/content/Context;JIJJILjava/lang/String;Ljava/lang/String;II)Ljava/lang/String;
    //   1963: astore 16
    //   1965: aconst_null
    //   1966: aload 20
    //   1968: getfield 3573	mgu:agN	Ljava/lang/String;
    //   1971: ldc_w 3685
    //   1974: ldc_w 3685
    //   1977: iconst_0
    //   1978: iconst_0
    //   1979: ldc_w 1209
    //   1982: new 433	java/lang/StringBuilder
    //   1985: dup
    //   1986: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   1989: lload 8
    //   1991: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1994: ldc_w 1209
    //   1997: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2000: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2003: new 433	java/lang/StringBuilder
    //   2006: dup
    //   2007: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2010: lload 10
    //   2012: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2015: ldc_w 1209
    //   2018: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2024: aload 16
    //   2026: iconst_0
    //   2027: invokestatic 3581	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2030: bipush 7
    //   2032: invokestatic 345	kxm:getLongAccountUin	()J
    //   2035: lload 10
    //   2037: l2i
    //   2038: iload 6
    //   2040: lload 12
    //   2042: iload 5
    //   2044: aload 14
    //   2046: aload 15
    //   2048: invokestatic 3688	kvp:a	(IJIIJILjava/lang/String;Ljava/lang/String;)V
    //   2051: aload 20
    //   2053: getfield 3691	mgu:amr	Z
    //   2056: ifeq +97 -> 2153
    //   2059: aload 20
    //   2061: getfield 3694	mgu:ams	Z
    //   2064: ifeq +89 -> 2153
    //   2067: invokestatic 3697	kxm:v	()Lorg/json/JSONObject;
    //   2070: astore 15
    //   2072: aload 15
    //   2074: ldc_w 3699
    //   2077: aload 20
    //   2079: getfield 3474	mgu:agM	Ljava/lang/String;
    //   2082: invokevirtual 2334	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2085: pop
    //   2086: aload 15
    //   2088: ldc_w 3701
    //   2091: invokestatic 3704	kxm:nR	()I
    //   2094: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2097: pop
    //   2098: aload_0
    //   2099: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   2102: i2l
    //   2103: invokestatic 3550	odv:aT	(J)Z
    //   2106: ifeq +2226 -> 4332
    //   2109: ldc_w 3706
    //   2112: astore 14
    //   2114: aconst_null
    //   2115: ldc_w 1207
    //   2118: ldc_w 1209
    //   2121: ldc_w 1209
    //   2124: aload 14
    //   2126: aload 14
    //   2128: iconst_0
    //   2129: iconst_0
    //   2130: aload 20
    //   2132: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2135: invokestatic 3708	kxm:g	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   2138: ldc_w 1209
    //   2141: ldc_w 1209
    //   2144: aload 15
    //   2146: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2149: iconst_0
    //   2150: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2153: aload 20
    //   2155: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2158: invokestatic 3710	kxm:t	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2161: ifeq +29 -> 2190
    //   2164: aconst_null
    //   2165: aconst_null
    //   2166: ldc_w 3712
    //   2169: ldc_w 3712
    //   2172: iconst_0
    //   2173: iconst_0
    //   2174: ldc_w 1209
    //   2177: ldc_w 1209
    //   2180: ldc_w 1209
    //   2183: ldc_w 1209
    //   2186: iconst_0
    //   2187: invokestatic 3581	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2190: aload 20
    //   2192: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2195: ifnull -2031 -> 164
    //   2198: aload 20
    //   2200: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2203: getfield 476	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2206: ifnull -2042 -> 164
    //   2209: aload 20
    //   2211: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2214: getfield 476	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2217: getfield 3715	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:b	Lkgj;
    //   2220: ifnull -2056 -> 164
    //   2223: aload 20
    //   2225: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2228: getfield 476	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSocialFeedInfo	Lcom/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo;
    //   2231: getfield 3715	com/tencent/biz/pubaccount/readinjoy/struct/SocializeFeedsInfo:b	Lkgj;
    //   2234: aload 20
    //   2236: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2239: invokestatic 3718	kxm:a	(Lkgj;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   2242: goto -2078 -> 164
    //   2245: aload 14
    //   2247: ldc_w 3659
    //   2250: iconst_0
    //   2251: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2254: pop
    //   2255: goto -602 -> 1653
    //   2258: astore 14
    //   2260: ldc_w 658
    //   2263: iconst_2
    //   2264: aload 14
    //   2266: invokevirtual 3719	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2269: invokestatic 1284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2272: aload 15
    //   2274: astore 14
    //   2276: goto -616 -> 1660
    //   2279: astore 15
    //   2281: ldc_w 658
    //   2284: iconst_2
    //   2285: aload 15
    //   2287: invokevirtual 3719	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2290: invokestatic 1284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2293: aload 14
    //   2295: astore 15
    //   2297: goto -590 -> 1707
    //   2300: aload_0
    //   2301: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2304: aload 20
    //   2306: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2309: getfield 3720	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mVideoAdsSource	I
    //   2312: aload 20
    //   2314: getfield 3672	mgu:mPosition	I
    //   2317: aload 20
    //   2319: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2322: invokevirtual 3648	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2325: bipush 54
    //   2327: aload 20
    //   2329: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2332: invokestatic 1199	odv:l	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2335: aload 20
    //   2337: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2340: getfield 3507	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   2343: invokestatic 1205	odv:a	(Landroid/content/Context;IILjava/lang/String;IILjava/lang/String;)Ljava/lang/String;
    //   2346: astore 14
    //   2348: aconst_null
    //   2349: ldc_w 1207
    //   2352: ldc_w 1209
    //   2355: aload 20
    //   2357: getfield 3573	mgu:agN	Ljava/lang/String;
    //   2360: ldc_w 3722
    //   2363: ldc_w 3722
    //   2366: iconst_0
    //   2367: iconst_0
    //   2368: aload 20
    //   2370: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2373: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2376: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2379: aload 20
    //   2381: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2384: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2387: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2390: aload 20
    //   2392: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2395: getfield 3723	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2398: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2401: aload 14
    //   2403: iconst_0
    //   2404: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2407: aconst_null
    //   2408: aconst_null
    //   2409: ldc_w 3641
    //   2412: ldc_w 3641
    //   2415: iconst_0
    //   2416: iconst_0
    //   2417: ldc_w 1209
    //   2420: ldc_w 1209
    //   2423: ldc_w 1209
    //   2426: new 1350	nce$a
    //   2429: dup
    //   2430: aconst_null
    //   2431: aconst_null
    //   2432: aconst_null
    //   2433: aconst_null
    //   2434: invokespecial 3726	nce$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2437: bipush 54
    //   2439: invokevirtual 3598	nce$a:W	(I)Lnce$a;
    //   2442: aload 20
    //   2444: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2447: invokevirtual 3648	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getInnerUniqueID	()Ljava/lang/String;
    //   2450: invokevirtual 3617	nce$a:h	(Ljava/lang/String;)Lnce$a;
    //   2453: aload 20
    //   2455: getfield 3672	mgu:mPosition	I
    //   2458: iconst_1
    //   2459: iadd
    //   2460: invokevirtual 3601	nce$a:x	(I)Lnce$a;
    //   2463: aload 20
    //   2465: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2468: invokevirtual 3728	nce$a:f	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   2471: invokevirtual 2781	nce$a:a	()Lnce;
    //   2474: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   2477: iconst_0
    //   2478: invokestatic 3581	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2481: goto -764 -> 1717
    //   2484: aload 20
    //   2486: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2489: invokestatic 3731	kxm:C	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2492: ifeq +15 -> 2507
    //   2495: aload 20
    //   2497: aload 14
    //   2499: aload 15
    //   2501: invokestatic 3734	kxm:a	(Lmgu;Ljava/lang/String;Ljava/lang/String;)V
    //   2504: goto -787 -> 1717
    //   2507: aload 20
    //   2509: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2512: invokestatic 917	kxm:B	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2515: ifeq +481 -> 2996
    //   2518: aload 20
    //   2520: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2523: getfield 3735	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mNewPolymericInfo	Lmhr;
    //   2526: getfield 2425	mhr:amx	Z
    //   2529: ifne +428 -> 2957
    //   2532: invokestatic 3739	ndi:getApp	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2535: astore 16
    //   2537: ldc_w 3741
    //   2540: astore 14
    //   2542: aload 16
    //   2544: ifnull +10 -> 2554
    //   2547: aload 16
    //   2549: invokevirtual 3744	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2552: astore 14
    //   2554: aload 20
    //   2556: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2559: getfield 3647	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2562: aload 20
    //   2564: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2567: invokestatic 2734	kxm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2570: aload_0
    //   2571: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   2574: iconst_0
    //   2575: iconst_0
    //   2576: aload_0
    //   2577: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2580: invokestatic 2748	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   2583: aload 20
    //   2585: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2588: getfield 3745	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2591: aconst_null
    //   2592: aload 20
    //   2594: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2597: getfield 3157	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2600: aconst_null
    //   2601: aload 20
    //   2603: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2606: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2609: invokestatic 3748	kxm:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Ljava/lang/String;
    //   2612: astore 17
    //   2614: aconst_null
    //   2615: ldc_w 1207
    //   2618: ldc_w 1209
    //   2621: aload 14
    //   2623: aload 15
    //   2625: aload 15
    //   2627: iconst_0
    //   2628: iconst_0
    //   2629: new 433	java/lang/StringBuilder
    //   2632: dup
    //   2633: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2636: aload 20
    //   2638: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2641: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2644: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2647: ldc_w 1209
    //   2650: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2653: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2656: new 433	java/lang/StringBuilder
    //   2659: dup
    //   2660: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2663: aload 20
    //   2665: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2668: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2671: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2674: ldc_w 1209
    //   2677: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2680: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2683: new 433	java/lang/StringBuilder
    //   2686: dup
    //   2687: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2690: aload 20
    //   2692: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2695: getfield 3723	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2698: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2701: ldc_w 1209
    //   2704: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2707: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2710: aload 17
    //   2712: iconst_0
    //   2713: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2716: aload_0
    //   2717: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   2720: i2l
    //   2721: invokestatic 3750	odv:aA	(J)Ljava/lang/String;
    //   2724: astore 15
    //   2726: aload 16
    //   2728: ifnull +1684 -> 4412
    //   2731: aload 16
    //   2733: invokevirtual 3744	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   2736: astore 14
    //   2738: aload 20
    //   2740: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2743: getfield 3647	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mAlgorithmID	J
    //   2746: aload 20
    //   2748: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2751: invokestatic 2734	kxm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)I
    //   2754: aload_0
    //   2755: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   2758: aload_0
    //   2759: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   2762: invokestatic 2748	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   2765: aload 20
    //   2767: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2770: getfield 3745	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mSubscribeID	Ljava/lang/String;
    //   2773: aload 20
    //   2775: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2778: getfield 3157	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:innerUniqueID	Ljava/lang/String;
    //   2781: aconst_null
    //   2782: iconst_0
    //   2783: aload 20
    //   2785: getfield 3478	mgu:aRz	I
    //   2788: aload 20
    //   2790: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2793: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   2796: invokestatic 3753	kxm:a	(JIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Lorg/json/JSONObject;
    //   2799: astore 16
    //   2801: aload_0
    //   2802: getfield 150	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:isFromAIO	Z
    //   2805: ifeq +129 -> 2934
    //   2808: iconst_1
    //   2809: istore 5
    //   2811: aload 16
    //   2813: ldc_w 1348
    //   2816: iload 5
    //   2818: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2821: pop
    //   2822: aload 16
    //   2824: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2827: astore 16
    //   2829: aconst_null
    //   2830: ldc_w 1207
    //   2833: ldc_w 1209
    //   2836: aload 14
    //   2838: aload 15
    //   2840: aload 15
    //   2842: iconst_0
    //   2843: iconst_0
    //   2844: new 433	java/lang/StringBuilder
    //   2847: dup
    //   2848: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2851: aload 20
    //   2853: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2856: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   2859: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2862: ldc_w 1209
    //   2865: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2868: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2871: new 433	java/lang/StringBuilder
    //   2874: dup
    //   2875: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2878: aload 20
    //   2880: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2883: getfield 3447	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mArticleID	J
    //   2886: invokevirtual 443	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2889: ldc_w 1209
    //   2892: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2895: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2898: new 433	java/lang/StringBuilder
    //   2901: dup
    //   2902: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   2905: aload 20
    //   2907: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2910: getfield 3723	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mStrategyId	I
    //   2913: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2916: ldc_w 1209
    //   2919: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2922: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2925: aload 16
    //   2927: iconst_0
    //   2928: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2931: goto -1214 -> 1717
    //   2934: iconst_0
    //   2935: istore 5
    //   2937: goto -126 -> 2811
    //   2940: astore 17
    //   2942: ldc_w 658
    //   2945: iconst_2
    //   2946: aload 17
    //   2948: invokevirtual 3719	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2951: invokestatic 1284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2954: goto -132 -> 2822
    //   2957: aload 20
    //   2959: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   2962: invokestatic 1170	kxm:w	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   2965: ifeq -1248 -> 1717
    //   2968: aconst_null
    //   2969: aconst_null
    //   2970: ldc_w 3641
    //   2973: ldc_w 3641
    //   2976: iconst_0
    //   2977: iconst_0
    //   2978: ldc_w 1209
    //   2981: ldc_w 1209
    //   2984: ldc_w 1209
    //   2987: aload 14
    //   2989: iconst_0
    //   2990: invokestatic 3581	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2993: goto -1276 -> 1717
    //   2996: aload 20
    //   2998: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3001: invokestatic 3755	kxm:D	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3004: ifeq +92 -> 3096
    //   3007: aload 20
    //   3009: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3012: getfield 3759	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lmhx;
    //   3015: getfield 3764	mhx:cardStyle	I
    //   3018: ifne +18 -> 3036
    //   3021: aload 20
    //   3023: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3026: aload_0
    //   3027: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   3030: invokestatic 3768	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommend:i	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3033: goto -1316 -> 1717
    //   3036: aload 20
    //   3038: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3041: getfield 3759	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lmhx;
    //   3044: getfield 3764	mhx:cardStyle	I
    //   3047: iconst_1
    //   3048: if_icmpne +18 -> 3066
    //   3051: aload 20
    //   3053: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3056: aload_0
    //   3057: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   3060: invokestatic 3771	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowList:i	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3063: goto -1346 -> 1717
    //   3066: aload 20
    //   3068: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3071: getfield 3759	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mRecommendFollowInfos	Lmhx;
    //   3074: getfield 3764	mhx:cardStyle	I
    //   3077: iconst_2
    //   3078: if_icmpne -1361 -> 1717
    //   3081: aload 20
    //   3083: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3086: aload_0
    //   3087: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   3090: invokestatic 3774	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentRecommendFollowGroup:i	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;I)V
    //   3093: goto -1376 -> 1717
    //   3096: aload 20
    //   3098: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3101: getfield 3775	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedType	I
    //   3104: bipush 33
    //   3106: if_icmpne +37 -> 3143
    //   3109: aload 20
    //   3111: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3114: invokevirtual 3778	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:getProteusItemData	()Lorg/json/JSONObject;
    //   3117: astore 14
    //   3119: aload 14
    //   3121: ifnull -3073 -> 48
    //   3124: iconst_0
    //   3125: aload 14
    //   3127: aload 20
    //   3129: invokestatic 3781	kxm:a	(ZLorg/json/JSONObject;Lmgu;)V
    //   3132: iconst_1
    //   3133: aload 14
    //   3135: aload 20
    //   3137: invokestatic 3781	kxm:a	(ZLorg/json/JSONObject;Lmgu;)V
    //   3140: goto -1423 -> 1717
    //   3143: aload 20
    //   3145: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3148: invokestatic 3784	kxm:z	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3151: ifeq +16 -> 3167
    //   3154: aload 20
    //   3156: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3159: aload 20
    //   3161: invokestatic 3787	kxm:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;Lmgu;)V
    //   3164: goto -1447 -> 1717
    //   3167: aload 20
    //   3169: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3172: invokestatic 1042	kxm:r	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3175: ifeq +135 -> 3310
    //   3178: aload 20
    //   3180: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3183: astore 16
    //   3185: aload 16
    //   3187: getfield 3788	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lmhs;
    //   3190: invokestatic 3791	kxm:a	(Lmhs;)Lorg/json/JSONObject;
    //   3193: astore 17
    //   3195: aconst_null
    //   3196: ldc_w 1207
    //   3199: ldc_w 1209
    //   3202: aload 20
    //   3204: getfield 3573	mgu:agN	Ljava/lang/String;
    //   3207: ldc_w 3793
    //   3210: ldc_w 3793
    //   3213: iconst_0
    //   3214: iconst_0
    //   3215: new 433	java/lang/StringBuilder
    //   3218: dup
    //   3219: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   3222: aload 20
    //   3224: getfield 3672	mgu:mPosition	I
    //   3227: invokevirtual 448	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3230: ldc_w 1209
    //   3233: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3236: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3239: aload 20
    //   3241: getfield 355	mgu:v	Ljava/lang/Long;
    //   3244: invokevirtual 308	java/lang/Long:longValue	()J
    //   3247: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3250: aload 16
    //   3252: getfield 3788	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lmhs;
    //   3255: getfield 3794	mhs:strategyID	J
    //   3258: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3261: aload 17
    //   3263: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3266: iconst_0
    //   3267: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3270: aload 18
    //   3272: aload 16
    //   3274: getfield 3788	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lmhs;
    //   3277: getfield 3797	mhs:vq	J
    //   3280: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3283: invokevirtual 3212	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   3286: ifne -3122 -> 164
    //   3289: aload 18
    //   3291: aload 16
    //   3293: getfield 3788	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mPolymericInfo	Lmhs;
    //   3296: getfield 3797	mhs:vq	J
    //   3299: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3302: iconst_1
    //   3303: invokestatic 644	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3306: invokevirtual 897	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3309: pop
    //   3310: new 1350	nce$a
    //   3313: dup
    //   3314: aload 14
    //   3316: invokespecial 2758	nce$a:<init>	(Ljava/lang/String;)V
    //   3319: astore 16
    //   3321: aload 16
    //   3323: aload 20
    //   3325: getfield 3799	mgu:k	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3328: invokestatic 2767	kxm:F	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Z
    //   3331: invokestatic 644	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3334: invokevirtual 2770	nce$a:a	(Ljava/lang/Boolean;)Lnce$a;
    //   3337: aload 20
    //   3339: getfield 3799	mgu:k	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3342: getfield 3507	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:videoReportInfo	Ljava/lang/String;
    //   3345: invokevirtual 2772	nce$a:a	(Ljava/lang/String;)Lnce$a;
    //   3348: aload 20
    //   3350: getfield 3799	mgu:k	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3353: invokevirtual 3801	nce$a:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   3356: pop
    //   3357: aload_0
    //   3358: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   3361: ldc_w 693
    //   3364: if_icmpne +224 -> 3588
    //   3367: aload 16
    //   3369: aload 20
    //   3371: getfield 3484	mgu:aRD	I
    //   3374: invokevirtual 3803	nce$a:b	(I)Lnce$a;
    //   3377: pop
    //   3378: aconst_null
    //   3379: ldc_w 1207
    //   3382: ldc_w 1209
    //   3385: aload 20
    //   3387: getfield 3573	mgu:agN	Ljava/lang/String;
    //   3390: ldc_w 3805
    //   3393: ldc_w 3805
    //   3396: iconst_0
    //   3397: iconst_0
    //   3398: aload 20
    //   3400: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3403: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3406: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3409: aload 20
    //   3411: getfield 355	mgu:v	Ljava/lang/Long;
    //   3414: invokevirtual 308	java/lang/Long:longValue	()J
    //   3417: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3420: aload 20
    //   3422: getfield 373	mgu:mStrategyId	I
    //   3425: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3428: aload 16
    //   3430: invokevirtual 2781	nce$a:a	()Lnce;
    //   3433: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   3436: iconst_0
    //   3437: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3440: ldc_w 3805
    //   3443: aload 20
    //   3445: getfield 3573	mgu:agN	Ljava/lang/String;
    //   3448: aload 20
    //   3450: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3453: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3456: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3459: aload 20
    //   3461: getfield 355	mgu:v	Ljava/lang/Long;
    //   3464: invokevirtual 308	java/lang/Long:longValue	()J
    //   3467: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3470: aload 20
    //   3472: getfield 373	mgu:mStrategyId	I
    //   3475: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3478: aload 20
    //   3480: getfield 367	mgu:mAlgorithmID	J
    //   3483: aload 20
    //   3485: getfield 3463	mgu:mArticleType	I
    //   3488: aload_0
    //   3489: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   3492: aload 20
    //   3494: getfield 3466	mgu:aRx	I
    //   3497: aload 20
    //   3499: getfield 3471	mgu:aRy	I
    //   3502: aload_0
    //   3503: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   3506: invokestatic 2748	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   3509: aload 20
    //   3511: getfield 3474	mgu:agM	Ljava/lang/String;
    //   3514: aload 20
    //   3516: getfield 3475	mgu:mStrCircleId	Ljava/lang/String;
    //   3519: aload 20
    //   3521: getfield 389	mgu:agO	Ljava/lang/String;
    //   3524: aload 20
    //   3526: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3529: invokestatic 2753	kxm:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   3532: aload 20
    //   3534: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3537: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   3540: lload 8
    //   3542: iload 7
    //   3544: aload 20
    //   3546: getfield 3478	mgu:aRz	I
    //   3549: aload 20
    //   3551: getfield 3481	mgu:aRA	I
    //   3554: aload 20
    //   3556: getfield 3446	mgu:aRB	I
    //   3559: aload 20
    //   3561: getfield 3453	mgu:amu	Z
    //   3564: aload 20
    //   3566: getfield 3484	mgu:aRD	I
    //   3569: aload 20
    //   3571: getfield 3487	mgu:aRC	I
    //   3574: aload 20
    //   3576: getfield 3490	mgu:aRF	I
    //   3579: invokestatic 3493	kxm:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   3582: invokestatic 2740	kbp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3585: goto -1868 -> 1717
    //   3588: aload_0
    //   3589: getfield 130	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelType	I
    //   3592: iconst_3
    //   3593: if_icmpne +51 -> 3644
    //   3596: iconst_m1
    //   3597: istore 6
    //   3599: iload 6
    //   3601: istore 5
    //   3603: aload_0
    //   3604: getfield 281	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Kfr	Lkfr;
    //   3607: ifnull +29 -> 3636
    //   3610: iload 6
    //   3612: istore 5
    //   3614: aload_0
    //   3615: getfield 281	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Kfr	Lkfr;
    //   3618: instanceof 3807
    //   3621: ifeq +15 -> 3636
    //   3624: aload_0
    //   3625: getfield 281	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Kfr	Lkfr;
    //   3628: checkcast 3807	kfs
    //   3631: invokevirtual 3810	kfs:getFrom	()I
    //   3634: istore 5
    //   3636: aload 16
    //   3638: iload 5
    //   3640: invokevirtual 3812	nce$a:O	(I)Lnce$a;
    //   3643: pop
    //   3644: aload 16
    //   3646: aload 20
    //   3648: getfield 3799	mgu:k	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3651: invokevirtual 3814	nce$a:a	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Lnce$a;
    //   3654: pop
    //   3655: aload 20
    //   3657: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3660: ifnull +113 -> 3773
    //   3663: aload 20
    //   3665: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3668: getfield 3818	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3671: ifnull +102 -> 3773
    //   3674: aload 20
    //   3676: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3679: getfield 3818	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3682: aconst_null
    //   3683: invokevirtual 3824	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3686: astore 17
    //   3688: aload 17
    //   3690: ifnull +83 -> 3773
    //   3693: aload 17
    //   3695: invokeinterface 3828 1 0
    //   3700: ifnull +73 -> 3773
    //   3703: aload 17
    //   3705: invokeinterface 3828 1 0
    //   3710: invokeinterface 3831 1 0
    //   3715: astore 17
    //   3717: aload 17
    //   3719: ifnull +54 -> 3773
    //   3722: aload 17
    //   3724: invokeinterface 330 1 0
    //   3729: ifeq +44 -> 3773
    //   3732: aload 17
    //   3734: invokeinterface 334 1 0
    //   3739: checkcast 3833	java/util/Map$Entry
    //   3742: astore 21
    //   3744: aload 16
    //   3746: aload 21
    //   3748: invokeinterface 3836 1 0
    //   3753: checkcast 646	java/lang/String
    //   3756: aload 21
    //   3758: invokeinterface 3839 1 0
    //   3763: invokevirtual 3840	java/lang/Object:toString	()Ljava/lang/String;
    //   3766: invokevirtual 1353	nce$a:a	(Ljava/lang/String;Ljava/lang/Object;)Lnce$a;
    //   3769: pop
    //   3770: goto -53 -> 3717
    //   3773: aload 16
    //   3775: aload 20
    //   3777: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3780: invokestatic 3845	lwd:a	(Lnce$a;Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)V
    //   3783: aload 15
    //   3785: aload 20
    //   3787: aload 16
    //   3789: invokestatic 3848	kxm:a	(Ljava/lang/String;Lmgu;Lnce$a;)V
    //   3792: aload_0
    //   3793: aload 16
    //   3795: invokespecial 3850	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Lnce$a;)V
    //   3798: aconst_null
    //   3799: ldc_w 1207
    //   3802: ldc_w 1209
    //   3805: aload 20
    //   3807: getfield 3573	mgu:agN	Ljava/lang/String;
    //   3810: aload 15
    //   3812: aload 15
    //   3814: iconst_0
    //   3815: iconst_0
    //   3816: aload 20
    //   3818: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3821: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3824: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3827: aload 20
    //   3829: getfield 355	mgu:v	Ljava/lang/Long;
    //   3832: invokevirtual 308	java/lang/Long:longValue	()J
    //   3835: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3838: aload 20
    //   3840: getfield 373	mgu:mStrategyId	I
    //   3843: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   3846: aload 16
    //   3848: invokevirtual 2781	nce$a:a	()Lnce;
    //   3851: invokevirtual 2786	nce:toJsonString	()Ljava/lang/String;
    //   3854: iconst_0
    //   3855: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   3858: aload 20
    //   3860: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3863: getfield 3818	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3866: invokestatic 3855	obr:a	(Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;)Ljava/util/List;
    //   3869: astore 17
    //   3871: aload 14
    //   3873: astore 16
    //   3875: aload 17
    //   3877: ifnull +173 -> 4050
    //   3880: aload 17
    //   3882: invokeinterface 520 1 0
    //   3887: astore 21
    //   3889: aload 14
    //   3891: astore 16
    //   3893: aload 21
    //   3895: invokeinterface 330 1 0
    //   3900: ifeq +150 -> 4050
    //   3903: aload 21
    //   3905: invokeinterface 334 1 0
    //   3910: checkcast 646	java/lang/String
    //   3913: astore 17
    //   3915: new 2324	org/json/JSONObject
    //   3918: dup
    //   3919: aload 14
    //   3921: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3924: astore 16
    //   3926: aload 20
    //   3928: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3931: getfield 3818	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mProteusTemplateBean	Lcom/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean;
    //   3934: aload 17
    //   3936: invokevirtual 3824	com/tencent/biz/pubaccount/readinjoy/view/proteus/bean/TemplateBean:getDataAttribute	(Ljava/lang/String;)Ljava/util/Map;
    //   3939: astore 17
    //   3941: aload 17
    //   3943: ifnull +466 -> 4409
    //   3946: aload 16
    //   3948: aload 17
    //   3950: invokestatic 3858	obr:a	(Lorg/json/JSONObject;Ljava/util/Map;)V
    //   3953: aload 16
    //   3955: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3958: astore 16
    //   3960: aload 16
    //   3962: astore 14
    //   3964: aconst_null
    //   3965: ldc_w 1207
    //   3968: ldc_w 1209
    //   3971: aload 20
    //   3973: getfield 3573	mgu:agN	Ljava/lang/String;
    //   3976: aload 15
    //   3978: aload 15
    //   3980: iconst_0
    //   3981: iconst_0
    //   3982: aload 20
    //   3984: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   3987: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   3990: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3993: aload 20
    //   3995: getfield 355	mgu:v	Ljava/lang/Long;
    //   3998: invokevirtual 308	java/lang/Long:longValue	()J
    //   4001: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4004: aload 20
    //   4006: getfield 373	mgu:mStrategyId	I
    //   4009: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4012: aload 14
    //   4014: iconst_0
    //   4015: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4018: goto -129 -> 3889
    //   4021: astore 17
    //   4023: aload 14
    //   4025: astore 16
    //   4027: aload 17
    //   4029: astore 14
    //   4031: ldc_w 658
    //   4034: iconst_1
    //   4035: ldc_w 3860
    //   4038: aload 14
    //   4040: invokestatic 3863	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4043: aload 16
    //   4045: astore 14
    //   4047: goto -158 -> 3889
    //   4050: aload 15
    //   4052: aload 20
    //   4054: getfield 3573	mgu:agN	Ljava/lang/String;
    //   4057: aload 20
    //   4059: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4062: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4065: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4068: aload 20
    //   4070: getfield 355	mgu:v	Ljava/lang/Long;
    //   4073: invokevirtual 308	java/lang/Long:longValue	()J
    //   4076: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4079: aload 20
    //   4081: getfield 373	mgu:mStrategyId	I
    //   4084: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4087: aload 20
    //   4089: getfield 367	mgu:mAlgorithmID	J
    //   4092: aload 20
    //   4094: getfield 3463	mgu:mArticleType	I
    //   4097: aload_0
    //   4098: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   4101: aload 20
    //   4103: getfield 3466	mgu:aRx	I
    //   4106: aload 20
    //   4108: getfield 3471	mgu:aRy	I
    //   4111: aload_0
    //   4112: invokevirtual 1188	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getContext	()Landroid/content/Context;
    //   4115: invokestatic 2748	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   4118: aload 20
    //   4120: getfield 3474	mgu:agM	Ljava/lang/String;
    //   4123: aload 20
    //   4125: getfield 3475	mgu:mStrCircleId	Ljava/lang/String;
    //   4128: aload 20
    //   4130: getfield 389	mgu:agO	Ljava/lang/String;
    //   4133: aload 20
    //   4135: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4138: invokestatic 2753	kxm:h	(Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;)Ljava/lang/String;
    //   4141: aload 20
    //   4143: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4146: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   4149: lload 8
    //   4151: iload 7
    //   4153: aload 20
    //   4155: getfield 3478	mgu:aRz	I
    //   4158: aload 20
    //   4160: getfield 3481	mgu:aRA	I
    //   4163: aload 20
    //   4165: getfield 3446	mgu:aRB	I
    //   4168: aload 20
    //   4170: getfield 3453	mgu:amu	Z
    //   4173: aload 20
    //   4175: getfield 3484	mgu:aRD	I
    //   4178: aload 20
    //   4180: getfield 3487	mgu:aRC	I
    //   4183: aload 20
    //   4185: getfield 3490	mgu:aRF	I
    //   4188: invokestatic 3493	kxm:a	(JIIIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;JIIIIZIII)Ljava/lang/String;
    //   4191: invokestatic 2740	kbp:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4194: sipush 250
    //   4197: invokestatic 3865	com/tencent/aladdin/config/Aladdin:get	(I)Lcom/tencent/aladdin/config/AladdinConfig;
    //   4200: ldc_w 3867
    //   4203: iconst_0
    //   4204: invokevirtual 2183	com/tencent/aladdin/config/AladdinConfig:getIntegerFromString	(Ljava/lang/String;I)I
    //   4207: iconst_1
    //   4208: if_icmpne -2491 -> 1717
    //   4211: aload_0
    //   4212: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   4215: invokestatic 582	kys:dv	(I)Z
    //   4218: ifne -2501 -> 1717
    //   4221: new 3869	kxm$b
    //   4224: dup
    //   4225: new 2324	org/json/JSONObject
    //   4228: dup
    //   4229: aload 16
    //   4231: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4234: invokespecial 3872	kxm$b:<init>	(Lorg/json/JSONObject;)V
    //   4237: astore 14
    //   4239: invokestatic 3873	odv:nM	()I
    //   4242: ifle +84 -> 4326
    //   4245: iconst_0
    //   4246: istore 5
    //   4248: aload 14
    //   4250: ldc_w 3875
    //   4253: iload 5
    //   4255: invokevirtual 3878	kxm$b:b	(Ljava/lang/String;I)Lkxm$b;
    //   4258: pop
    //   4259: aconst_null
    //   4260: ldc_w 1207
    //   4263: ldc_w 1209
    //   4266: aload 20
    //   4268: getfield 3573	mgu:agN	Ljava/lang/String;
    //   4271: ldc_w 3880
    //   4274: ldc_w 3880
    //   4277: iconst_0
    //   4278: iconst_0
    //   4279: aload 20
    //   4281: getfield 395	mgu:j	Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;
    //   4284: getfield 3574	com/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo:mFeedId	J
    //   4287: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4290: aload 20
    //   4292: getfield 355	mgu:v	Ljava/lang/Long;
    //   4295: invokevirtual 308	java/lang/Long:longValue	()J
    //   4298: invokestatic 1224	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4301: aload 20
    //   4303: getfield 373	mgu:mStrategyId	I
    //   4306: invokestatic 1226	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   4309: aload 14
    //   4311: invokevirtual 3883	kxm$b:build	()Ljava/lang/String;
    //   4314: iconst_0
    //   4315: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   4318: goto -2601 -> 1717
    //   4321: astore 14
    //   4323: goto -2606 -> 1717
    //   4326: iconst_1
    //   4327: istore 5
    //   4329: goto -81 -> 4248
    //   4332: ldc_w 3885
    //   4335: astore 14
    //   4337: goto -2223 -> 2114
    //   4340: astore 14
    //   4342: aload 14
    //   4344: invokevirtual 2369	org/json/JSONException:printStackTrace	()V
    //   4347: goto -2194 -> 2153
    //   4350: aload_0
    //   4351: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   4354: ldc_w 693
    //   4357: if_icmpeq +8 -> 4365
    //   4360: aload_0
    //   4361: aload_1
    //   4362: invokespecial 3887	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:I	(Ljava/util/Map;)V
    //   4365: aload_3
    //   4366: aload_0
    //   4367: getfield 150	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:isFromAIO	Z
    //   4370: invokestatic 3435	odv:c	(Ljava/util/Map;Z)V
    //   4373: aload_0
    //   4374: invokespecial 3458	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:m	()Landroid/util/Pair;
    //   4377: getfield 1112	android/util/Pair:first	Ljava/lang/Object;
    //   4380: checkcast 592	java/lang/Integer
    //   4383: invokevirtual 602	java/lang/Integer:intValue	()I
    //   4386: invokestatic 3890	nhz:tD	(I)V
    //   4389: return
    //   4390: astore 17
    //   4392: aload 14
    //   4394: astore 16
    //   4396: aload 17
    //   4398: astore 14
    //   4400: goto -369 -> 4031
    //   4403: lconst_0
    //   4404: lstore 10
    //   4406: goto -2471 -> 1935
    //   4409: goto -391 -> 4018
    //   4412: goto -1674 -> 2738
    //   4415: goto -3611 -> 804
    //   4418: goto -3861 -> 557
    //   4421: iload_2
    //   4422: ifne -2979 -> 1443
    //   4425: iload 5
    //   4427: ifeq -3672 -> 755
    //   4430: goto -2987 -> 1443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4433	0	this	ReadInJoyListViewGroup
    //   0	4433	1	paramMap	Map<Long, mgu>
    //   0	4433	2	paramBoolean	boolean
    //   0	4433	3	paramMap1	Map<Long, odv.b>
    //   0	4433	4	paramString	String
    //   816	3610	5	i	int
    //   1866	1745	6	m	int
    //   230	3922	7	n	int
    //   217	3933	8	l1	long
    //   1933	2472	10	l2	long
    //   1845	196	12	l3	long
    //   65	1419	14	localObject1	Object
    //   1500	1	14	localException1	Exception
    //   1504	742	14	localObject2	Object
    //   2258	7	14	localJSONException1	JSONException
    //   2274	2036	14	localObject3	Object
    //   4321	1	14	localException2	Exception
    //   4335	1	14	str1	String
    //   4340	53	14	localJSONException2	JSONException
    //   4398	1	14	localObject4	Object
    //   83	2190	15	localObject5	Object
    //   2279	7	15	localJSONException3	JSONException
    //   2295	1756	15	localObject6	Object
    //   105	4290	16	localObject7	Object
    //   2612	99	17	str2	String
    //   2940	7	17	localJSONException4	JSONException
    //   3193	756	17	localObject8	Object
    //   4021	7	17	localJSONException5	JSONException
    //   4390	7	17	localJSONException6	JSONException
    //   149	3141	18	localHashMap	HashMap
    //   162	13	19	localIterator	Iterator
    //   184	4118	20	localmgu	mgu
    //   3742	162	21	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   706	755	1500	java/lang/Exception
    //   755	762	1500	java/lang/Exception
    //   1397	1437	1500	java/lang/Exception
    //   1443	1465	1500	java/lang/Exception
    //   1470	1497	1500	java/lang/Exception
    //   1621	1653	2258	org/json/JSONException
    //   1653	1660	2258	org/json/JSONException
    //   2245	2255	2258	org/json/JSONException
    //   1672	1707	2279	org/json/JSONException
    //   2801	2808	2940	org/json/JSONException
    //   2811	2822	2940	org/json/JSONException
    //   3915	3941	4021	org/json/JSONException
    //   3946	3960	4021	org/json/JSONException
    //   4194	4245	4321	java/lang/Exception
    //   4248	4318	4321	java/lang/Exception
    //   2059	2109	4340	org/json/JSONException
    //   2114	2153	4340	org/json/JSONException
    //   3964	4018	4390	org/json/JSONException
  }
  
  public void a(Set<Long> paramSet, Map<Long, mgu> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "attachToViewGroup()");
    }
    a(new nfi(this, "attachToViewGroup#2", paramSet, paramMap));
    if (this.jdField_a_of_type_Ndh != null) {
      this.jdField_a_of_type_Ndh.b(paramSet, paramMap);
    }
    this.jdField_a_of_type_Kxa.sX = System.currentTimeMillis();
    if (zn()) {
      if (this.mChannelID != 56) {
        break label134;
      }
    }
    label134:
    for (this.jdField_a_of_type_Kxa.sZ = awit.a((QQAppInterface)kxm.getAppRuntime(), getCurrentActivity());; this.jdField_a_of_type_Kxa.sZ = awit.c((QQAppInterface)kxm.getAppRuntime(), this.mChannelID))
    {
      aWJ();
      odd.bU(null, "KANDIAN_FEEDS_STAGE_2_COST");
      if (!zl()) {
        break;
      }
      return;
    }
    aCz();
  }
  
  public void a(lge paramlge)
  {
    if (paramlge == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.av.size())
      {
        long l1 = SystemClock.currentThreadTimeMillis();
        paramlge.a((lfz)this.av.valueAt(i));
        long l2 = SystemClock.currentThreadTimeMillis();
        QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "execute handler job , id : ", Integer.valueOf(this.av.keyAt(i)), ", jobName : ", paramlge.aV(), ", cost : ", Long.valueOf(l2 - l1) });
        i += 1;
      }
    }
  }
  
  public void a(mye.b paramb1, mye.b paramb2)
  {
    this.arQ = false;
    ((lgb)c(2)).aLY();
    if (this.xm == 1002L) {
      setPadding(0, wja.dp2px(44.5F, getResources()) + getResources().getDimensionPixelOffset(2131299219), 0, 0);
    }
  }
  
  public void a(npy.b paramb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(paramb);
      this.jdField_a_of_type_Npy$b = paramb;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    int n = 0;
    int i;
    int m;
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0) && (paramInt == 56))
    {
      i = 0;
      for (paramInt = -1; i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildCount(); paramInt = m)
      {
        Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getChildAt(i);
        m = paramInt;
        if (localObject != null)
        {
          m = paramInt;
          if (((View)localObject).getTag() != null)
          {
            m = paramInt;
            if ((((View)localObject).getTag() instanceof lgf.f))
            {
              localObject = (lgf.f)((View)localObject).getTag();
              m = paramInt;
              if (paramLong == ((lgf.f)localObject).a.articleID) {
                m = ((lgf.f)localObject).position;
              }
            }
          }
        }
        i += 1;
      }
      m = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getHeaderViewsCount();
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getFirstVisiblePosition() - m;
      if (i >= 0) {
        break label354;
      }
      i = n;
    }
    label354:
    for (;;)
    {
      n = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.getLastVisiblePosition() - m;
      if ((paramInt + 1 >= i) && (paramInt + 1 <= n))
      {
        this.jdField_a_of_type_Ndh.setData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList));
        this.jdField_a_of_type_Ndh.yJ(paramInt + 1);
      }
      for (;;)
      {
        paramList = this.jdField_a_of_type_Kfr.a();
        if (paramList != null) {
          paramList.cU(paramList1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "onVideoRealtimeRelpaceListRefreshed success!  reqArticleID=" + paramLong + ", positionRequested=" + paramInt + ", firstVisiblePosi=" + i + ", lastVisblePosi=" + n + "， headerCount=" + m);
        }
        return;
        this.jdField_a_of_type_Ndh.setData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList));
        this.jdField_a_of_type_Ndh.notifyDataSetChanged();
      }
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    if ((paramInt != this.mChannelID) || (this.jdField_a_of_type_Ndh == null)) {
      return;
    }
    a(new nfs(this, "onChannelRefreshed", paramBoolean1, paramInt, paramList, paramBoolean2));
    if (this.jdField_a_of_type_Ndh.getCount() == 0) {}
    int m = lbz.a().a(Integer.valueOf(paramInt));
    if (this.arR)
    {
      if ((paramList != null) && (m == 1)) {
        this.jdField_a_of_type_Ndh.yJ(0);
      }
      this.arR = false;
    }
    lwh.a().aNQ();
    Object localObject = new StringBuilder().append("onChannelRefreshed, success = ").append(paramBoolean1).append(", refreshedArticleSize = ").append(m).append(", articleSeqList size = ");
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("ReadInJoyListViewGroup", 1, i);
      if (!paramBoolean1) {
        break label704;
      }
      if ((paramList == null) || (m <= 0) || (paramList.size() <= 0)) {
        break label641;
      }
      if (!QLog.isColorLevel()) {
        break label303;
      }
      localObject = new StringBuilder("onChannelRefreshed ");
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        ((StringBuilder)localObject).append("recommendSeq = " + localLong + ",\n ");
      }
    }
    QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 1, ((StringBuilder)localObject).toString());
    label303:
    if (!this.jdField_a_of_type_Ndh.arz) {
      this.jdField_a_of_type_Ndh.ary = false;
    }
    this.jdField_a_of_type_Ndh.arz = true;
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "onChannelRefreshed hasRefreshed:" + this.jdField_a_of_type_Ndh.arz + "  mHasKingCardGuideShowed:" + this.jdField_a_of_type_Ndh.ary);
    }
    msv.a().of(true);
    setAdapterData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList), 1);
    this.jdField_a_of_type_Ndh.sN(0);
    if ((paramInt == 56) || (paramInt == 0))
    {
      localObject = kxm.getAppRuntime();
      if (localObject != null) {
        ((klu)((AppRuntime)localObject).getManager(307)).N(getContext(), paramInt);
      }
    }
    if (paramInt == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(paramBoolean2);
    }
    if ((paramInt == 0) || (kys.dv(this.mChannelID))) {
      lcm.a().a.a(2, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    }
    Q(paramBoolean1, m);
    if (this.mChannelID == 70) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aDC = 0;
    }
    if ((this.mChannelID == 56) && (this.arT)) {
      if (this.jdField_a_of_type_Kqo != null) {
        break label731;
      }
    }
    label641:
    label704:
    label731:
    for (paramInt = 0;; paramInt = 1)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setSelectionFromTop(paramInt, 0);
      this.arT = false;
      if ((kys.dt(this.mChannelID)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).aWj();
      }
      bP(paramList);
      bQ(paramList);
      AbstractGifImage.resumeAll();
      lfx.a(this.jdField_a_of_type_Ndh.c(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.jdField_a_of_type_Ndh);
      kzw.a(this.jdField_a_of_type_Ndh.c(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      return;
      if (!this.jdField_a_of_type_Ndh.isEmpty()) {
        break;
      }
      if (this.mChannelID == 70)
      {
        b(getResources().getString(2131718422), getResources().getDrawable(2130850254));
        break;
      }
      mb(getResources().getString(2131718494));
      break;
      if (!this.jdField_a_of_type_Ndh.isEmpty()) {
        break;
      }
      mb(getResources().getString(2131718448));
      break;
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    return false;
  }
  
  public void aCB()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup$a != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup$a.oB(this.aRd);
    }
    if (this.jdField_a_of_type_Ndh != null) {
      this.jdField_a_of_type_Ndh.s(2, null);
    }
    a(new ngb(this, "onEndRefresh"));
    if (this.jdField_a_of_type_Ndh != null) {
      lft.a(this.jdField_a_of_type_Ndh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, true);
    }
  }
  
  public void aCh()
  {
    this.cQ = null;
  }
  
  public void aCk()
  {
    this.arQ = true;
    ((lgb)c(2)).aLX();
    if (this.xm == 1002L) {
      setPadding(0, 0, 0, 0);
    }
  }
  
  public void aDB()
  {
    mye localmye = this.jdField_a_of_type_Kfr.a();
    if ((localmye != null) && (localmye.c() != null)) {
      localmye.stop(11);
    }
  }
  
  public void aWI()
  {
    if (this.jdField_a_of_type_Ndh != null) {
      this.jdField_a_of_type_Ndh.notifyDataSetChanged();
    }
  }
  
  public void aWJ()
  {
    if (kxm.nX() == 0) {}
    while (this.mChannelID != 0) {
      return;
    }
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.41(this));
  }
  
  public void aWL()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(this.jdField_a_of_type_Npy$b);
    }
  }
  
  public void aWM()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aXe();
    }
  }
  
  public void aWN()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null) {}
  }
  
  public void aWg()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWg();
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c);
  }
  
  public void aWh()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aWh();
  }
  
  public ListView b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
  }
  
  public void b(Configuration paramConfiguration)
  {
    if ((paramConfiguration == null) || (paramConfiguration.hashCode() == this.aYq) || ((!ayxa.isSamsungFolderMobile()) && (!ayxa.isHuaWeiFolderMobile()))) {
      return;
    }
    this.aYq = paramConfiguration.hashCode();
    ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.40(this));
  }
  
  public void b(TopBannerInfo paramTopBannerInfo)
  {
    if ((paramTopBannerInfo == null) || (paramTopBannerInfo.mChannelId != this.mChannelID)) {}
    while (this.mChannelID == 41695) {
      return;
    }
    if (paramTopBannerInfo.isEmpty())
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner = new ChannelTopBanner(getCurrentActivity());
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.addHeaderView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner, 2);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.a(this.jdField_a_of_type_Ndh, paramTopBannerInfo);
  }
  
  public void b(ReadInJoyBaseListView paramReadInJoyBaseListView, int paramInt)
  {
    int i = 0;
    boolean bool;
    if (paramInt == 4)
    {
      bool = true;
      this.aeL = bool;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "loadmorechannel " + this.mChannelID + " " + paramInt + " " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.aDC);
      }
      paramReadInJoyBaseListView = kxm.getAppRuntime();
      if ((paramReadInJoyBaseListView == null) || (this.mChannelID != 56) || (this.xm != 1001L)) {
        break label205;
      }
      if (((KandianMergeManager)paramReadInJoyBaseListView.getManager(162)).BB()) {
        i = 4;
      }
      i |= 0x2;
    }
    for (;;)
    {
      int m;
      if ((this.mChannelID == 40830) || (kys.dv(this.mChannelID)))
      {
        m = this.aIz;
        this.aIz = (m + 1);
      }
      for (;;)
      {
        lbz.a().b(this.mChannelID, ni(), paramInt, i, m);
        ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.32(this));
        return;
        bool = false;
        break;
        m = 1;
      }
      label205:
      i = 0;
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    boolean bool2 = true;
    if ((paramInt != this.mChannelID) || (this.jdField_a_of_type_Ndh == null))
    {
      this.aeL = false;
      return;
    }
    a(new nft(this, "onLoadMoreArticle", paramBoolean1, paramInt, paramList, paramBoolean2));
    if ((paramBoolean1) && (paramList != null)) {
      setAdapterData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList), 2);
    }
    boolean bool1;
    label104:
    ReadInJoyXListView localReadInJoyXListView;
    if ((paramBoolean1) && (paramList == null))
    {
      paramBoolean1 = true;
      bool1 = paramBoolean1;
      if (this.mChannelID == 70)
      {
        if ((!paramBoolean1) && (!paramBoolean2)) {
          break label317;
        }
        paramBoolean1 = true;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.arG = paramBoolean1;
        bool1 = paramBoolean1;
      }
      localReadInJoyXListView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView;
      if (bool1) {
        break label322;
      }
    }
    label317:
    label322:
    for (paramBoolean1 = bool2;; paramBoolean1 = false)
    {
      localReadInJoyXListView.lA(paramBoolean1);
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.oK = NetConnInfoCenter.getServerTime();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyListViewGroup", 2, "autoLoad:" + this.aeL + " noMoreData:" + bool1 + " fore:" + GesturePWDUtils.isAppOnForeground(getContext()));
      }
      if ((!this.aeL) && (bool1) && (GesturePWDUtils.isAppOnForeground(getContext())) && (this.mChannelID != 70))
      {
        paramList = getResources().getString(2131718335);
        QQToast.a(getContext().getApplicationContext(), paramList, 0).show();
      }
      if ((kys.dt(this.mChannelID)) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView instanceof ReadInJoyDailyXListView))) {
        ((ReadInJoyDailyXListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView).aWj();
      }
      this.aeL = false;
      return;
      paramBoolean1 = false;
      break;
      paramBoolean1 = false;
      break label104;
    }
  }
  
  public void bP(List<Long> paramList)
  {
    if (!PreloadManager.a().Gu()) {}
    for (;;)
    {
      return;
      PreloadManager.a().bdm();
      int m = this.jdField_a_of_type_Ndh.nh();
      if ((paramList != null) && (paramList.size() >= 5))
      {
        int i = 0;
        while (i < 5)
        {
          long l1 = ((Long)paramList.get(i)).longValue();
          Object localObject = this.jdField_a_of_type_Ndh.a(m, l1);
          if ((localObject != null) && (!kxm.a(((BaseArticleInfo)localObject).mArticleContentUrl, ((BaseArticleInfo)localObject).mChannelID, (ArticleInfo)localObject)) && (!kxm.j((BaseArticleInfo)localObject)) && (!this.jdField_a_of_type_Ndh.m(m, ((BaseArticleInfo)localObject).mArticleID)))
          {
            localObject = ((BaseArticleInfo)localObject).mArticleContentUrl;
            if (sum.gg((String)localObject)) {
              PreloadManager.a().oZ((String)localObject);
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public List<nny> bf()
  {
    return this.jW;
  }
  
  public lfz c(int paramInt)
  {
    return (lfz)this.av.get(paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    kzw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.mChannelID);
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void j(int paramInt, List<Long> paramList)
  {
    odd.bU(null, "KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED");
    if ((paramInt != this.mChannelID) || (this.jdField_a_of_type_Ndh == null)) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      setAdapterData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList), 1);
      if (paramInt == 70)
      {
        localObject1 = kxm.getAppRuntime();
        if (localObject1 != null)
        {
          paramInt = ((KandianMergeManager)((AppRuntime)localObject1).getManager(162)).og();
          if ((paramInt >= 0) && (paramList.size() >= paramInt)) {
            this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setNoMoreData(true);
          }
        }
      }
      Object localObject3;
      if (!paramList.isEmpty())
      {
        localObject1 = (Long)paramList.get(0);
        localObject2 = lbz.a().a(this.mChannelID, ((Long)localObject1).longValue());
        localObject3 = new StringBuilder().append("load history successful ! first article title : ");
        if (localObject2 == null) {
          break label348;
        }
        localObject1 = ((ArticleInfo)localObject2).mTitle;
        localObject1 = kxm.ev((String)localObject1);
        localObject3 = new StringBuilder().append((String)localObject1).append(" articleID : ");
        if (localObject2 == null) {
          break label356;
        }
      }
      label348:
      label356:
      for (localObject1 = Long.valueOf(((ArticleInfo)localObject2).mArticleID);; localObject1 = "-1")
      {
        localObject1 = localObject1;
        QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 1, (String)localObject1);
        if (!QLog.isColorLevel()) {
          break label396;
        }
        localObject1 = new StringBuilder("onChannelArticleLoaded ");
        localObject2 = paramList.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append("recommendSeq = " + localObject3 + ",\n ");
        }
        localObject1 = "";
        break;
      }
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 1, ((StringBuilder)localObject1).toString());
      label396:
      localObject1 = lbz.a().a();
      if (localObject1 != null) {
        b(((lhk)localObject1).a(this.mChannelID));
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()) && ((this.mChannelID == 0) || (this.mChannelID == 70) || (kys.dv(this.mChannelID))))
    {
      this.oK = NetConnInfoCenter.getServerTime();
      this.l = lbz.a().a(this.mChannelID, ((Long)paramList.get(0)).longValue());
      localObject1 = (QQAppInterface)kxm.getAppRuntime();
      if ((this.l != null) && (localObject1 != null))
      {
        if (this.mChannelID != 0) {
          break label889;
        }
        localObject1 = ocp.b((QQAppInterface)localObject1, this.l);
        localObject2 = ocp.q(this.l);
        ocp.a(((BaseActivity)this.jdField_a_of_type_Kfr.getActivity()).app, (String)localObject2, String.valueOf(this.oK), (String)localObject1, false);
      }
    }
    this.jdField_a_of_type_Kxa.sX = 0L;
    if (!this.aeM)
    {
      bool = true;
      label588:
      bool = N(bool);
      this.arP = bool;
      knj.a().T(this.mChannelID, bool);
      if (getCurrentActivity().getIntent().getIntExtra("launch_from", 5) != 11) {
        break label960;
      }
    }
    for (int i = 1;; i = 0)
    {
      try
      {
        paramInt = ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).ol();
        if (paramInt <= 0) {
          break label1015;
        }
        paramInt = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          long l1;
          label889:
          localException.printStackTrace();
          label960:
          paramInt = 0;
          continue;
          bool = kxm.aM(((ReadInJoyNewFeedsActivity)getCurrentActivity()).cc());
          continue;
          bool = true;
          continue;
          if (this.mChannelID != 0)
          {
            aCA();
            continue;
            paramInt = 0;
          }
        }
      }
      if (!(getCurrentActivity() instanceof ReadInJoyNewFeedsActivity)) {
        break label995;
      }
      if (i == 0) {
        break label977;
      }
      bool = true;
      if ((!this.arP) && (bool))
      {
        if ((i == 0) && (paramInt != 0)) {
          break label1001;
        }
        aCA();
      }
      if (!this.arP) {
        kzw.a(this.jdField_a_of_type_Ndh.c(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
      }
      if (!this.aeM) {
        this.aeM = true;
      }
      if ((this.mChannelID == 40677) && (paramList != null) && (!paramList.isEmpty()))
      {
        l1 = NetConnInfoCenter.getServerTime();
        localObject1 = (QQAppInterface)kxm.getAppRuntime();
        if (localObject1 != null)
        {
          paramList = ((lcd)((QQAppInterface)localObject1).getManager(163)).b().a(this.mChannelID, ((Long)paramList.get(0)).longValue());
          if (paramList != null)
          {
            localObject2 = (lcr)((QQAppInterface)localObject1).getManager(274);
            if (localObject2 != null) {
              ((lcr)localObject2).B(ocp.a((QQAppInterface)localObject1, paramList), l1);
            }
          }
        }
      }
      aWD();
      if ((this.mChannelID == 0) && (lwh.a().CU())) {
        aWP();
      }
      odd.bU("KANDIAN_NEW_FEEDS_ON_CHANNEL_ARTICLE_LOADED", null);
      odd.bU("KANDIAN_NEW_FEEDS_LOAD_ARTICLE", null);
      odd.bU(null, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE");
      return;
      if (this.mChannelID == 70)
      {
        ((KandianSubscribeManager)((QQAppInterface)localObject1).getManager(280)).a(this.l, this.oK);
        break;
      }
      if (!kys.dv(this.mChannelID)) {
        break;
      }
      ((KandianDailyManager)((QQAppInterface)localObject1).getManager(296)).h(this.l);
      break;
      bool = false;
      break label588;
    }
  }
  
  public void k(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.mChannelID) || (paramList == null) || (this.jdField_a_of_type_Ndh == null)) {
      return;
    }
    this.jdField_a_of_type_Ndh.cV(lbz.a().a(Integer.valueOf(this.mChannelID), paramList));
    this.jdField_a_of_type_Ndh.notifyDataSetChanged();
  }
  
  public void l(int paramInt, List<Long> paramList)
  {
    if ((paramInt != this.mChannelID) || (this.jdField_a_of_type_Ndh == null) || (paramList == null)) {}
    do
    {
      return;
      if (paramList.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("refreshChannelData ");
          localStringBuilder.append("channelID : ").append(paramInt).append("\n");
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            Long localLong = (Long)localIterator.next();
            localStringBuilder.append("recommendSeq = " + localLong + ",\n ");
          }
          QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 1, localStringBuilder.toString());
        }
        msv.a().of(true);
        setAdapterData(lbz.a().a(Integer.valueOf(this.mChannelID), paramList), 1);
        this.jdField_a_of_type_Ndh.sN(0);
        return;
      }
    } while (!this.jdField_a_of_type_Ndh.isEmpty());
    mb(getResources().getString(2131718494));
  }
  
  public void lP(boolean paramBoolean)
  {
    O(paramBoolean, 1);
  }
  
  public void oC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyListViewGroup", 2, "refreshListByChannelID channelID = " + paramInt + " mChannelID = " + this.mChannelID);
    }
    if ((paramInt == this.mChannelID) && (this.jdField_a_of_type_Ndh != null)) {
      d(true, 1001, true);
    }
  }
  
  /* Error */
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 4314	nfm
    //   4: dup
    //   5: aload_0
    //   6: ldc_w 4315
    //   9: iload_1
    //   10: iload_2
    //   11: aload_3
    //   12: invokespecial 4318	nfm:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup;Ljava/lang/String;IILandroid/content/Intent;)V
    //   15: invokevirtual 255	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:a	(Llge;)V
    //   18: iload_1
    //   19: sipush 9991
    //   22: if_icmpne +10 -> 32
    //   25: aload_0
    //   26: iconst_2
    //   27: aload_3
    //   28: invokevirtual 2918	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:t	(ILandroid/content/Intent;)V
    //   31: return
    //   32: iload_1
    //   33: sipush 9091
    //   36: if_icmpne +10 -> 46
    //   39: aload_0
    //   40: iconst_0
    //   41: aload_3
    //   42: invokevirtual 2918	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:t	(ILandroid/content/Intent;)V
    //   45: return
    //   46: iload_1
    //   47: sipush 9993
    //   50: if_icmpne +13 -> 63
    //   53: iload_2
    //   54: iconst_1
    //   55: if_icmpne -24 -> 31
    //   58: aload_0
    //   59: invokevirtual 4319	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:onRefresh	()V
    //   62: return
    //   63: iload_1
    //   64: bipush 21
    //   66: if_icmpne +60 -> 126
    //   69: iload_2
    //   70: iconst_m1
    //   71: if_icmpne +30 -> 101
    //   74: aload_3
    //   75: ifnull +26 -> 101
    //   78: invokestatic 233	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   81: checkcast 235	com/tencent/mobileqq/app/QQAppInterface
    //   84: aload_0
    //   85: invokevirtual 183	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getCurrentActivity	()Landroid/app/Activity;
    //   88: aload_0
    //   89: invokevirtual 183	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getCurrentActivity	()Landroid/app/Activity;
    //   92: invokevirtual 4320	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   95: aload_3
    //   96: aconst_null
    //   97: invokestatic 4325	com/tencent/mobileqq/activity/aio/ForwardUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/app/Activity;Landroid/content/Context;Landroid/content/Intent;Lmqq/os/MqqHandler;)Z
    //   100: pop
    //   101: getstatic 4330	odg$d:a	Lodg$d;
    //   104: astore_3
    //   105: iconst_m1
    //   106: iload_2
    //   107: if_icmpne +13 -> 120
    //   110: iconst_1
    //   111: istore 4
    //   113: aload_3
    //   114: iload 4
    //   116: invokevirtual 4333	odg$d:nV	(Z)V
    //   119: return
    //   120: iconst_0
    //   121: istore 4
    //   123: goto -10 -> 113
    //   126: iload_1
    //   127: sipush 19202
    //   130: if_icmpeq +9 -> 139
    //   133: iload_1
    //   134: bipush 125
    //   136: if_icmpne +28 -> 164
    //   139: getstatic 4330	odg$d:a	Lodg$d;
    //   142: astore_3
    //   143: iconst_m1
    //   144: iload_2
    //   145: if_icmpne +13 -> 158
    //   148: iconst_1
    //   149: istore 4
    //   151: aload_3
    //   152: iload 4
    //   154: invokevirtual 4333	odg$d:nV	(Z)V
    //   157: return
    //   158: iconst_0
    //   159: istore 4
    //   161: goto -10 -> 151
    //   164: iload_1
    //   165: iconst_2
    //   166: if_icmpne +10 -> 176
    //   169: aload_0
    //   170: iconst_2
    //   171: aload_3
    //   172: invokevirtual 2918	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:t	(ILandroid/content/Intent;)V
    //   175: return
    //   176: iload_1
    //   177: iconst_1
    //   178: if_icmpne +10 -> 188
    //   181: aload_0
    //   182: iconst_1
    //   183: aload_3
    //   184: invokevirtual 2918	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:t	(ILandroid/content/Intent;)V
    //   187: return
    //   188: iload_1
    //   189: sipush 10922
    //   192: if_icmpne +49 -> 241
    //   195: iload_2
    //   196: sipush -10069
    //   199: if_icmpne -168 -> 31
    //   202: aload_3
    //   203: ifnull -172 -> 31
    //   206: aload_3
    //   207: invokevirtual 4337	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   210: ldc_w 4339
    //   213: invokevirtual 4342	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   216: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   219: astore_3
    //   220: aload_3
    //   221: ifnull -190 -> 31
    //   224: aload_0
    //   225: invokevirtual 183	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getCurrentActivity	()Landroid/app/Activity;
    //   228: aload_3
    //   229: aload_0
    //   230: getfield 543	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ndh	Lndh;
    //   233: aload_0
    //   234: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   237: invokestatic 2092	kxm:a	(Landroid/app/Activity;Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;Lndi;I)V
    //   240: return
    //   241: iload_1
    //   242: bipush 117
    //   244: if_icmpne +65 -> 309
    //   247: aload_3
    //   248: ldc_w 1460
    //   251: invokevirtual 1464	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   254: checkcast 842	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   257: astore 5
    //   259: invokestatic 4347	kqc:Al	()Z
    //   262: ifeq +31 -> 293
    //   265: iload_2
    //   266: sipush 1699
    //   269: if_icmpne +24 -> 293
    //   272: aload 5
    //   274: invokestatic 4349	kpp:b	(Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;)Z
    //   277: ifeq +16 -> 293
    //   280: aload_0
    //   281: invokevirtual 2651	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:nh	()I
    //   284: ifne +9 -> 293
    //   287: aload_0
    //   288: aload_3
    //   289: invokespecial 4351	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:aS	(Landroid/content/Intent;)V
    //   292: return
    //   293: aload_0
    //   294: invokevirtual 183	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:getCurrentActivity	()Landroid/app/Activity;
    //   297: checkcast 567	com/tencent/mobileqq/app/BaseActivity
    //   300: getfield 571	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: aload_3
    //   304: iload_2
    //   305: invokestatic 4354	ksz:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/content/Intent;I)V
    //   308: return
    //   309: iload_1
    //   310: sipush 20001
    //   313: if_icmpne +35 -> 348
    //   316: invokestatic 233	kxm:getAppRuntime	()Lmqq/app/AppRuntime;
    //   319: astore_3
    //   320: aload_3
    //   321: ifnull -290 -> 31
    //   324: aload_3
    //   325: sipush 162
    //   328: invokevirtual 1394	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   331: checkcast 577	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager
    //   334: invokevirtual 4357	com/tencent/biz/pubaccount/readinjoy/engine/KandianMergeManager:aIS	()V
    //   337: ldc_w 658
    //   340: iconst_1
    //   341: ldc_w 4359
    //   344: invokestatic 472	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: return
    //   348: iload_1
    //   349: sipush 1032
    //   352: if_icmpne +176 -> 528
    //   355: aload_3
    //   356: ldc_w 4361
    //   359: invokevirtual 4364	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   362: astore_3
    //   363: aload_3
    //   364: ifnull -333 -> 31
    //   367: new 2324	org/json/JSONObject
    //   370: dup
    //   371: aload_3
    //   372: invokespecial 3538	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   375: astore_3
    //   376: new 2324	org/json/JSONObject
    //   379: dup
    //   380: invokespecial 2325	org/json/JSONObject:<init>	()V
    //   383: astore 5
    //   385: aload 5
    //   387: ldc_w 829
    //   390: aload_0
    //   391: getfield 361	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:mChannelID	I
    //   394: invokevirtual 2341	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   397: pop
    //   398: aload 5
    //   400: ldc_w 4365
    //   403: aload_3
    //   404: ldc_w 4365
    //   407: invokevirtual 4368	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   410: invokevirtual 2334	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   413: pop
    //   414: aload 5
    //   416: ldc_w 4370
    //   419: ldc_w 1209
    //   422: invokevirtual 2334	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   425: pop
    //   426: aconst_null
    //   427: ldc_w 1207
    //   430: ldc_w 1209
    //   433: ldc_w 1209
    //   436: ldc_w 4372
    //   439: ldc_w 4372
    //   442: iconst_0
    //   443: iconst_0
    //   444: new 433	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   451: aload_3
    //   452: ldc_w 4374
    //   455: invokevirtual 4368	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   458: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: ldc_w 1209
    //   464: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: ldc_w 4376
    //   473: ldc_w 1209
    //   476: aload 5
    //   478: invokevirtual 2368	org/json/JSONObject:toString	()Ljava/lang/String;
    //   481: iconst_0
    //   482: invokestatic 1231	kbp:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   485: return
    //   486: astore_3
    //   487: ldc_w 658
    //   490: iconst_1
    //   491: new 433	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 434	java/lang/StringBuilder:<init>	()V
    //   498: ldc_w 4378
    //   501: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_3
    //   505: invokevirtual 4379	java/lang/Exception:toString	()Ljava/lang/String;
    //   508: invokevirtual 440	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: invokevirtual 468	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 1284	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: return
    //   518: astore 6
    //   520: aload 6
    //   522: invokevirtual 1417	java/lang/Exception:printStackTrace	()V
    //   525: goto -99 -> 426
    //   528: iload_1
    //   529: sipush 9999
    //   532: if_icmpne +39 -> 571
    //   535: iload_2
    //   536: iconst_m1
    //   537: if_icmpne -506 -> 31
    //   540: aload_3
    //   541: ifnull -510 -> 31
    //   544: aload_3
    //   545: ldc_w 4381
    //   548: invokevirtual 1464	android/content/Intent:getParcelableExtra	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   551: astore_3
    //   552: aload_3
    //   553: instanceof 2802
    //   556: ifeq -525 -> 31
    //   559: aload_0
    //   560: getfield 543	com/tencent/biz/pubaccount/readinjoy/view/ReadInJoyListViewGroup:jdField_a_of_type_Ndh	Lndh;
    //   563: aload_3
    //   564: checkcast 2802	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo
    //   567: invokevirtual 4384	ndh:m	(Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)V
    //   570: return
    //   571: iload_1
    //   572: bipush 102
    //   574: if_icmpne -543 -> 31
    //   577: getstatic 4330	odg$d:a	Lodg$d;
    //   580: astore_3
    //   581: iload_2
    //   582: iconst_m1
    //   583: if_icmpne +13 -> 596
    //   586: iconst_1
    //   587: istore 4
    //   589: aload_3
    //   590: iload 4
    //   592: invokevirtual 4333	odg$d:nV	(Z)V
    //   595: return
    //   596: iconst_0
    //   597: istore 4
    //   599: goto -10 -> 589
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	ReadInJoyListViewGroup
    //   0	602	1	paramInt1	int
    //   0	602	2	paramInt2	int
    //   0	602	3	paramIntent	Intent
    //   111	487	4	bool	boolean
    //   257	220	5	localObject	Object
    //   518	3	6	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   367	385	486	java/lang/Exception
    //   426	485	486	java/lang/Exception
    //   520	525	486	java/lang/Exception
    //   385	426	518	java/lang/Exception
  }
  
  public boolean onBackPressed()
  {
    Boolean localBoolean = (Boolean)a(new ngf(this, "onBackPressed"));
    if (localBoolean != null) {
      return localBoolean.booleanValue();
    }
    return (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onBackPressed());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aDy();
      kxm.pW(3);
      d(true, 3, false);
    }
  }
  
  public void onDestroy()
  {
    a(new nfl(this, "onDestroy"));
    awit.e(System.currentTimeMillis(), (QQAppInterface)kxm.getAppRuntime());
    Object localObject = ((lcd)kxm.getAppRuntime().getManager(163)).b().a();
    if (localObject != null) {
      ((lhu)localObject).rm(this.aMR);
    }
    ((BaseActivity)getCurrentActivity()).app.removeObserver(this.c);
    this.aIz = 1;
    this.jdField_a_of_type_Ndh.aVM();
    this.jdField_a_of_type_Ndh.clearData();
    this.jdField_a_of_type_Ndh.a(null);
    this.jdField_a_of_type_Ndh = null;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView != null)
    {
      kzw.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.mChannelID);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setDrawFinishedListener(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.setRefreshCallback(null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.onDestroy();
    }
    if (this.jdField_a_of_type_Aqdf != null)
    {
      this.jdField_a_of_type_Aqdf.destory();
      this.jdField_a_of_type_Aqdf = null;
    }
    if (this.j != null) {
      lcc.a().c(this.j);
    }
    awit.eW(((BaseActivity)getCurrentActivity()).app);
    if (this.jdField_a_of_type_Kqo != null)
    {
      this.jdField_a_of_type_Kqo.onDestroy();
      this.jdField_a_of_type_Kqo = null;
    }
    if (this.jdField_a_of_type_Nid != null)
    {
      this.jdField_a_of_type_Nid.onDestroy();
      this.jdField_a_of_type_Nid = null;
    }
    localObject = this.jW.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((nny)((Iterator)localObject).next()).onDestroy();
    }
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c = null;
    ods.unRegisterReceiver();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onDestroy();
    }
    if (this.jdField_b_of_type_Jzh != null) {
      this.jdField_b_of_type_Jzh.doOnDestory();
    }
    lft.k(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
    if (kys.dv(nh())) {
      kxt.a().unRegister();
    }
    mgn.rK(nh());
    if (this.jdField_a_of_type_Kqd != null) {
      this.jdField_a_of_type_Kqd.clear();
    }
    lcc.a().c(this.k);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    EventCollector.getInstance().onViewClicked(paramView);
    int i;
    if ((paramAdapterView instanceof ReadInJoyXListView))
    {
      i = ((ReadInJoyXListView)paramAdapterView).getHeaderViewsCount();
      if (paramInt - i >= 0) {
        i = paramInt - i;
      }
    }
    for (;;)
    {
      Object localObject = this.jdField_a_of_type_Ndh.getItem(i);
      ArticleInfo localArticleInfo = null;
      if ((localObject instanceof ArticleInfo))
      {
        localArticleInfo = (ArticleInfo)localObject;
        if (!kxm.A(localArticleInfo)) {}
      }
      do
      {
        do
        {
          return;
          i = paramInt;
          break;
        } while (localArticleInfo.mFeedType == 20);
        QLog.d("ReadInJoyListViewGroup", 1, "onItemClick pos : " + paramInt + ", id : " + paramLong + ", data : " + localArticleInfo);
        a(paramAdapterView, localArticleInfo, paramView, paramInt, paramLong);
      } while (localArticleInfo == null);
      localArticleInfo.invalidateProteusTemplateBean();
      return;
      i = paramInt;
    }
  }
  
  public void onLogout()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onLogout();
    }
  }
  
  public void onPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "onPause()");
    }
    a(new nfp(this, "onPause"));
    if (this.jdField_a_of_type_Ndh != null) {
      this.jdField_a_of_type_Ndh.doOnPause();
    }
    Iterator localIterator = this.jW.iterator();
    while (localIterator.hasNext()) {
      ((nny)localIterator.next()).onPause();
    }
    aWB();
    long l1 = System.currentTimeMillis();
    aWC();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.onPause();
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "mListView onSaveInstanceState cost: ", Long.valueOf(System.currentTimeMillis() - l1) });
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onPause();
    }
    lft.i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView);
  }
  
  public void onRefresh()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView == null) {
      return;
    }
    lP(true);
  }
  
  public void onResume()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "OnResume()");
      QLog.d("ReadInJoyListViewGroup", 2, new Object[] { "onResume, mChannelID= ", Integer.valueOf(this.mChannelID) });
    }
    aWx();
    a(new nfn(this, "onResume"));
    aWQ();
    if (zl()) {
      aCz();
    }
    aWz();
    if (System.currentTimeMillis() - this.xt > 10000L)
    {
      this.xt = System.currentTimeMillis();
      ThreadManager.executeOnSubThread(new ReadInJoyListViewGroup.20(this));
    }
    if (this.jdField_a_of_type_Ndh != null) {
      this.jdField_a_of_type_Ndh.doOnResume();
    }
    Iterator localIterator = this.jW.iterator();
    while (localIterator.hasNext()) {
      ((nny)localIterator.next()).onResume();
    }
    aWJ();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.invalidate();
    if ((this.mChannelID == 0) || (kys.dv(this.mChannelID))) {
      meu.a().i(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView, this.mChannelID);
    }
    aWA();
    aWy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner.onResume();
    }
    ((KandianMergeManager)kxm.getAppRuntime().getManager(162)).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager$c);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController.onResume();
    }
    ThreadManager.getUIHandler().postDelayed(new ReadInJoyListViewGroup.21(this), 50L);
    mgn.rJ(nh());
    pB(false);
  }
  
  public void onStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "onStart()");
    }
    a(new nfq(this, "onStart"));
    lwh.a().onStart();
    if ((this.mChannelID == 0) && (!this.arR)) {
      c(1500, new ReadInJoyListViewGroup.25(this));
    }
  }
  
  public void onStop()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup_" + this.mChannelID, 2, "onStop()");
    }
    a(new nfr(this, "onStop"));
    if ((zn()) && (zm()))
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_Ndh.c(0);
      if (localArticleInfo != null) {
        lbz.a().c(this.mChannelID, localArticleInfo.mTitle, localArticleInfo.mArticleID);
      }
    }
    lwh.a().onStop();
  }
  
  public void setAdapterData(List<BaseArticleInfo> paramList, int paramInt)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.jdField_a_of_type_Ndh.getData().iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject1).add((BaseArticleInfo)((Iterator)localObject2).next());
    }
    paramList = lgy.a().a(this.mChannelID, paramList, (List)localObject1, paramInt);
    if ((this.mChannelID == 0) || (kys.du(kys.getChannelId()))) {
      this.jdField_a_of_type_Ndh.nq(true);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("setAdapterData: srcData size ");
      if (paramList != null) {}
      for (paramInt = paramList.size();; paramInt = 0)
      {
        QLog.d("ReadInJoyListViewGroup", 2, paramInt);
        if (paramList == null) {
          break;
        }
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (BaseArticleInfo)((Iterator)localObject1).next();
          if (localObject2 != null) {
            QLog.d("ReadInJoyListViewGroup", 2, "setAdapterData: " + ((BaseArticleInfo)localObject2).mTitle + " type: " + ((BaseArticleInfo)localObject2).mFeedType);
          }
        }
      }
    }
    this.jdField_a_of_type_Ndh.setData(paramList);
    this.jdField_a_of_type_Ndh.notifyDataSetChanged();
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView != null) {
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetChannelTopPositionView.setVisibility(8);
    }
  }
  
  public void setChannelType(int paramInt)
  {
    this.mChannelType = paramInt;
  }
  
  public void setNotifyEndRefresh(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup$a = parama;
  }
  
  public void setRefreshHeader(int paramInt)
  {
    if ((!mfo.amn) && ((getCurrentActivity() instanceof SplashActivity))) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz());
        if (this.mChannelID != 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
          return;
        }
      } while (paramInt == -1);
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz());
    npy localnpy = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    aWL();
    localnpy.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void setSkinCheckAction(Runnable paramRunnable)
  {
    this.cQ = paramRunnable;
  }
  
  public void setSkinHeader(int paramInt, boolean paramBoolean)
  {
    if ((!mfo.amn) && ((getCurrentActivity() instanceof SplashActivity))) {}
    label94:
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz());
        if (this.mChannelID != 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
          return;
        }
        if (paramInt != 0) {
          break label94;
        }
        if (!paramBoolean) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz());
      localnpy = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
      aWL();
      localnpy.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(0);
      return;
    } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.Fz());
    npy localnpy = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyXListView.a(2);
    aWL();
    localnpy.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewSlideActiveAnimController);
  }
  
  public void t(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_Ndh.s(paramInt, paramIntent);
  }
  
  public static abstract interface a
  {
    public abstract void oB(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup
 * JD-Core Version:    0.7.0.1
 */