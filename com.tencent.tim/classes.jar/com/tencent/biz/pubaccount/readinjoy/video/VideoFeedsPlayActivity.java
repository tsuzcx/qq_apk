package com.tencent.biz.pubaccount.readinjoy.video;

import aeej;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import aqho;
import aqnm;
import ayxa;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import com.tencent.biz.pubaccount.readinjoy.view.FrameLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TopEdgeGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.qqstory.view.widget.DragFrameLayout;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import kbp;
import kct;
import kcw;
import kgw;
import kxm;
import lcc;
import lce;
import mes;
import mry;
import mry.a;
import msv;
import mtg.l;
import muj;
import mvq;
import mvs;
import mvt;
import mvu;
import mvv;
import mwi;
import mwj;
import mwj.a;
import mwl;
import mwq;
import mwq.a;
import mzr;
import naa;
import nce;
import nce.a;
import nha;
import org.json.JSONObject;

public class VideoFeedsPlayActivity
  extends FragmentActivity
  implements View.OnClickListener, VideoFeedsRecommendFragment.h, mry.a, mwi, mwj.a, mwq.a
{
  private URLImageView G;
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private VideoFeedsCustomFrameLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity$b;
  private VideoFeedsRecommendFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment;
  private FrameLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat;
  private mry jdField_a_of_type_Mry;
  private mwj jdField_a_of_type_Mwj;
  private mwl jdField_a_of_type_Mwl;
  private mwq jdField_a_of_type_Mwq;
  private int aVi;
  private int aVj;
  private Set<String> ad = new HashSet();
  private String akh;
  private String aki;
  private boolean anU;
  private boolean apd = true;
  private boolean ape;
  private boolean apf;
  private boolean apg;
  private boolean aph;
  private boolean api = true;
  private DragFrameLayout b;
  private ViewGroup bK;
  private ViewGroup bL;
  private ImageView kd;
  private View lX;
  private QQAppInterface mApp;
  private Bundle mBundle;
  private ImageView mCloseBtn;
  private ViewGroup mContainer;
  private RIJRedPacketProgressView mRedPacketProgressView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper());
  private long sd;
  private TextView sm;
  
  private void A(VideoInfo paramVideoInfo)
  {
    this.mUIHandler.post(new VideoFeedsPlayActivity.3(this, paramVideoInfo));
  }
  
  private mry a()
  {
    if (this.jdField_a_of_type_Mry == null) {
      switch (getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0))
      {
      }
    }
    for (;;)
    {
      return this.jdField_a_of_type_Mry;
      this.jdField_a_of_type_Mry = new VideoFeedsLoadDelegate(this, getIntent().getExtras(), this.mApp, this, this.akh, this.aki, this.anU, this.aVi);
      continue;
      this.jdField_a_of_type_Mry = new VideoFeedsLazyLoadDelegate(this, getIntent().getExtras(), this.mApp, this, this.akh, this.aki, this.anU, this.aVi);
      continue;
      this.jdField_a_of_type_Mry = new mzr(this, getIntent().getExtras(), this.mApp, this, this.akh, this.aki, this.anU, this.aVi);
    }
  }
  
  public static void aN(Activity paramActivity)
  {
    muj.aM(paramActivity);
  }
  
  private void aSJ()
  {
    ThreadManager.post(new VideoFeedsPlayActivity.1(this), 1, null, true);
  }
  
  private void aSL()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
    int i = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
    int j = getIntent().getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", 0);
    String str2;
    if ((localObject != null) && (((VideoInfo)localObject).busiType == 0) && (((VideoInfo)localObject).a != null)) {
      str2 = ((VideoInfo)localObject).a.getMd5();
    }
    for (;;)
    {
      String str3;
      label74:
      String str1;
      label86:
      String str4;
      label98:
      long l;
      label114:
      JSONObject localJSONObject;
      if (localObject != null)
      {
        str3 = ((VideoInfo)localObject).hH;
        if (localObject == null) {
          break label218;
        }
        str1 = ((VideoInfo)localObject).Wz;
        if (localObject == null) {
          break label224;
        }
        str4 = ((VideoInfo)localObject).vid;
        if (localObject == null) {
          break label230;
        }
        l = ((VideoInfo)localObject).getDuration() * 1000L;
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("session_id", this.akh);
        localJSONObject.put("video_session_id", this.aki);
        label147:
        if (!TextUtils.isEmpty(str1)) {}
        for (localObject = str1;; localObject = "0")
        {
          kbp.a(null, str3, "0X800740A", "0X800740A", 0, 0, String.valueOf(i), String.valueOf(j), (String)localObject, kct.a(str2, str3, str4, str1, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.cW(), l, localJSONObject), false);
          return;
          str2 = null;
          break;
          str3 = null;
          break label74;
          label218:
          str1 = null;
          break label86;
          label224:
          str4 = null;
          break label98;
          label230:
          l = 0L;
          break label114;
        }
      }
      catch (Exception localException)
      {
        break label147;
      }
    }
  }
  
  private void aSM()
  {
    boolean bool2 = false;
    if (!ReadinjoyTabFrame.Dx())
    {
      this.apf = false;
      return;
    }
    int[] arrayOfInt = new int[9];
    int[] tmp23_21 = arrayOfInt;
    tmp23_21[0] = 0;
    int[] tmp27_23 = tmp23_21;
    tmp27_23[1] = 1;
    int[] tmp31_27 = tmp27_23;
    tmp31_27[2] = 9;
    int[] tmp36_31 = tmp31_27;
    tmp36_31[3] = 12;
    int[] tmp41_36 = tmp36_31;
    tmp41_36[4] = 20;
    int[] tmp46_41 = tmp41_36;
    tmp46_41[5] = 21;
    int[] tmp51_46 = tmp46_41;
    tmp51_46[6] = 22;
    int[] tmp57_51 = tmp51_46;
    tmp57_51[7] = 23;
    int[] tmp63_57 = tmp57_51;
    tmp63_57[8] = 24;
    tmp63_57;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if (this.aVi == k)
      {
        this.apf = false;
        return;
      }
      i += 1;
    }
    boolean bool1 = bool2;
    if (RIJRedPacketManager.a().Dr())
    {
      bool1 = bool2;
      if (RIJRedPacketManager.a().Dt()) {
        bool1 = true;
      }
    }
    this.aph = bool1;
    RIJRedPacketManager.a().a(new mvs(this));
  }
  
  private void aSN()
  {
    if (this.mRedPacketProgressView.getVisibility() == 0) {
      return;
    }
    this.mRedPacketProgressView.setVisibility(0);
    this.mRedPacketProgressView.post(new VideoFeedsPlayActivity.5(this));
  }
  
  private void aSP()
  {
    FlingGestureHandler localFlingGestureHandler;
    if ((this.mFlingHandler != null) && ((this.mFlingHandler instanceof FlingGestureHandler)))
    {
      localFlingGestureHandler = (FlingGestureHandler)this.mFlingHandler;
      if (!(this.mContainer instanceof ViewPagerCompat)) {
        break label71;
      }
      localFlingGestureHandler.setTopLayout(new TopEdgeGestureLayout(this));
    }
    for (;;)
    {
      localFlingGestureHandler.mTopLayout.setInterceptScrollLRFlag(true);
      localFlingGestureHandler.mTopLayout.setOnFlingGesture(new mvt(this));
      return;
      label71:
      localFlingGestureHandler.setTopLayout(new TopGestureLayout(this));
    }
  }
  
  private void aSQ()
  {
    int i = 3;
    if (!this.apf) {
      return;
    }
    RIJRedPacketManager.a().a(this, 2, 1, 1);
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
    nce.a locala1 = new nce.a(localVideoInfo);
    Object localObject = locala1.a("icon_position", Integer.valueOf(3));
    nce.a locala2;
    if (this.apg)
    {
      locala2 = ((nce.a)localObject).a("icon_status", Integer.valueOf(i));
      if (localVideoInfo == null) {
        break label143;
      }
    }
    label143:
    for (localObject = localVideoInfo.Wz;; localObject = "")
    {
      locala2.h((String)localObject);
      kbp.a(null, "", "0X800ABBC", "0X800ABBC", 0, 0, "", "", localVideoInfo.Wz, locala1.a().toJsonString(), false);
      return;
      if (this.mRedPacketProgressView.getCurrentState() == 1)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
    }
  }
  
  private void aSR()
  {
    try
    {
      Object localObject1 = getSupportFragmentManager();
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = localObject1.getClass().getDeclaredField("mExecCommit");
      if (localObject2 != null)
      {
        ((Field)localObject2).setAccessible(true);
        localObject1 = ((Field)localObject2).get(localObject1);
        if (localObject1 != null)
        {
          localObject2 = FragmentActivity.class.getDeclaredField("mHandler");
          if (localObject2 != null)
          {
            ((Field)localObject2).setAccessible(true);
            localObject2 = ((Field)localObject2).get(this);
            if (localObject2 != null)
            {
              ((Handler)localObject2).removeCallbacks((Runnable)localObject1);
              return;
            }
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void aSS()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
    if (this.jdField_a_of_type_Mwj.isShowing())
    {
      this.kd.setImageResource(2130843976);
      return;
    }
    if ((localVideoInfo != null) && (this.jdField_a_of_type_Mwj.k(localVideoInfo)))
    {
      if (this.mRedPacketProgressView.getVisibility() == 0)
      {
        this.kd.setImageResource(2130843977);
        return;
      }
      this.kd.setImageResource(2130850294);
      return;
    }
    this.kd.setImageResource(2130843976);
  }
  
  static void b(String paramString, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString, paramException);
    }
  }
  
  private void initData()
  {
    int i = this.mBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.aVi = i;
    if ((i == 9) || (i == 12) || (i == 21) || (i == 20) || (i == 22) || (i == 23)) {}
    for (boolean bool = true;; bool = false)
    {
      this.anU = bool;
      this.mBundle.putBoolean("KEY_IS_WEISHI_MODE", this.anU);
      getIntent().putExtra("KEY_IS_WEISHI_MODE", this.anU);
      aSM();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity$b = new b(null);
      return;
    }
  }
  
  @TargetApi(11)
  private void initUI()
  {
    int i = getIntent().getIntExtra("KEY_LOAD_DELEGATE_TYPE", 0);
    this.jdField_a_of_type_Mwl = new mwl(this);
    this.jdField_a_of_type_Mwl.sI(i);
    this.b = ((DragFrameLayout)findViewById(2131366128));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout = ((VideoFeedsCustomFrameLayout)findViewById(2131377556));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setVisibility(0);
    this.b.setEnabled(false);
    this.b.setDraggableView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout);
    this.sm = ((TextView)findViewById(2131368444));
    this.G = ((URLImageView)findViewById(2131368443));
    this.bL = ((ViewGroup)findViewById(2131368445));
    this.bK = ((ViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131371292));
    this.bK.bringToFront();
    this.lX = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131369271);
    if (ayxa.isLiuHaiUseValid())
    {
      i = ayxa.getNotchInScreenHeight(this);
      this.bK.setPadding(this.bK.getPaddingLeft(), i + this.bK.getPaddingTop(), this.bK.getPaddingRight(), this.bK.getPaddingBottom());
    }
    this.mContainer = ((ViewGroup)a().a(getLayoutInflater(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout));
    this.mCloseBtn = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131371280));
    this.mCloseBtn.setOnClickListener(this);
    if (this.mBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      oz(false);
    }
  }
  
  private void ma(boolean paramBoolean)
  {
    int i;
    label31:
    Object localObject2;
    boolean bool;
    label170:
    label194:
    Object localObject3;
    label206:
    label243:
    Object localObject4;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label407;
      }
      i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.pY();
      Object localObject5 = new nce.a("", "", "", "").b(this.akh).a(409409).b((System.currentTimeMillis() - this.sd) / 1000L);
      if (localObject1 != null)
      {
        localObject2 = ((nce.a)localObject5).e(((VideoInfo)localObject1).algorithmID).c(((VideoInfo)localObject1).strategyID).l(i).r(((VideoInfo)localObject1).nb()).s(this.aVj + 1).d(((VideoInfo)localObject1).hH).e(((VideoInfo)localObject1).vid).f(((VideoInfo)localObject1).Wz);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.EI())) {
          break label412;
        }
        bool = true;
        ((nce.a)localObject2).b(bool);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) {
        break label418;
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f();
      if (localObject2 == null) {
        break label424;
      }
      localObject3 = ((VideoInfo)localObject2).Wz;
      int j = getIntent().getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      ((nce.a)localObject5).g((String)localObject3).F(j).N(0);
      if (!paramBoolean) {
        break label430;
      }
      localObject3 = "1";
      if (!this.anU) {
        break label438;
      }
      localObject4 = "0X8009501";
      label255:
      kbp.a(null, "", (String)localObject4, (String)localObject4, 0, 0, (String)localObject3, "", "", ((nce.a)localObject5).a().toJsonString(), false);
      String str1 = "";
      localObject4 = "";
      localObject5 = "";
      localObject3 = str1;
      if (localObject1 != null)
      {
        String str2 = String.valueOf(i + 1);
        localObject3 = str1;
        localObject4 = str2;
        if (((VideoInfo)localObject1).b != null)
        {
          localObject3 = ((VideoInfo)localObject1).b.We;
          localObject4 = str2;
        }
      }
      localObject1 = localObject5;
      if (localObject2 != null) {
        if (((VideoInfo)localObject2).width < ((VideoInfo)localObject2).height) {
          break label446;
        }
      }
    }
    label407:
    label412:
    label418:
    label424:
    label430:
    label438:
    label446:
    for (Object localObject1 = String.valueOf(1);; localObject1 = String.valueOf(2))
    {
      kbp.a(null, "", "0X800957B", "0X800957B", 0, 0, (String)localObject3, (String)localObject4, (String)localObject1, "", false);
      return;
      localObject1 = null;
      break;
      i = 0;
      break label31;
      bool = false;
      break label170;
      localObject2 = null;
      break label194;
      localObject3 = null;
      break label206;
      localObject3 = "0";
      break label243;
      localObject4 = "0X8007DBB";
      break label255;
    }
  }
  
  public static void nX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, paramString);
    }
  }
  
  public void B(VideoInfo paramVideoInfo) {}
  
  public void C(VideoInfo paramVideoInfo)
  {
    aSS();
  }
  
  public void D(VideoInfo paramVideoInfo)
  {
    aSS();
  }
  
  public void E(String paramString, long paramLong)
  {
    if (this.apf) {
      RIJRedPacketManager.a().a(new mvq(this, paramString, paramLong));
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bK.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
      if ((this.mContainer instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.mContainer).setScrollable(false);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
      this.bK.setVisibility(0);
    } while (!(this.mContainer instanceof ViewPagerCompat));
    ((ViewPagerCompat)this.mContainer).setScrollable(true);
  }
  
  public void a(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment = paramVideoFeedsRecommendFragment;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
    this.kd = ((ImageView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.findViewById(2131378181));
    this.kd.setOnClickListener(this);
    this.jdField_a_of_type_Mwj = new mwj(this, this.aph, this.kd, this.bK, this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this.jdField_a_of_type_Mwj);
  }
  
  public void aOJ()
  {
    if (this.apf)
    {
      this.mRedPacketProgressView.stopTiming();
      this.mRedPacketProgressView.aOP();
    }
  }
  
  public void aRC()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.aRC();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.aTe();
    }
  }
  
  public void aRD()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.aRD();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.aTf();
    }
  }
  
  protected void aSI()
  {
    super.setContentView(2131560506);
    this.mBundle = getIntent().getExtras();
    if (!TextUtils.isEmpty(this.mBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID"))) {}
    for (this.akh = this.mBundle.getString("VIDEO_FEEDS_INNER_SESSION_ID");; this.akh = muj.d(this.mApp, this.mBundle.getString("VIDEO_ARTICLE_ID")))
    {
      this.aki = this.mBundle.getString("VIDEO_CHANNEL_SESSION_ID");
      initData();
      initUI();
      aSJ();
      aSP();
      return;
    }
  }
  
  public void aSK()
  {
    if (!this.ape)
    {
      this.jdField_a_of_type_Mwq = new mwq(this, this.mApp, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(), this.aVi, this.anU, this, 0);
      this.jdField_a_of_type_Mwq.l(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f());
    }
    aSL();
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.El()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.kd.setVisibility(0);
    }
    this.mRedPacketProgressView = ((RIJRedPacketProgressView)this.bK.findViewById(2131381686));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat = ((FrameLayoutCompat)this.bK.findViewById(2131381669));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setOnClickListener(this);
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.El()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.getUserVisibleHint())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
    }
    if (this.apf) {
      aSN();
    }
    ((ViewGroup.MarginLayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.getLayoutParams()).rightMargin = aqnm.dip2px(36.0F);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a(this);
    this.jdField_a_of_type_Mwj.I(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f());
    this.jdField_a_of_type_Mwq.a(this.jdField_a_of_type_Mwj);
  }
  
  public void aSO()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a() == null))
    {
      finish();
      overridePendingTransition(0, 2130772028);
      if (this.mBundle.getBoolean(kcw.XZ)) {
        kgw.b(this.mApp, this, 14, 0);
      }
      return;
    }
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.a();
    long l = localVideoFeedsPlayManager.cV();
    Object localObject = localVideoFeedsPlayManager.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.f() == localObject)
    {
      this.mBundle.putInt("VIDEO_PLAY_STATUS", localVideoFeedsPlayManager.pX());
      this.mBundle.putLong("VIDEO_PLAY_POSITION", l);
    }
    for (;;)
    {
      if (localObject != null) {
        this.mBundle.putString("VIDEO_ARTICLE_ID", ((VideoInfo)localObject).Wz);
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(this.mBundle);
      setResult(-1, (Intent)localObject);
      finish();
      overridePendingTransition(0, 2130772028);
      if (this.mBundle.getBoolean("VIDEO_IS_FROM_CONVERSATION")) {
        kgw.b(this.mApp, this, 14, 0);
      }
      nX("finishActivityWithResult() position=" + l + ", currentPlayStatus=" + localVideoFeedsPlayManager.pX());
      return;
      this.mBundle.putInt("VIDEO_PLAY_STATUS", 0);
      this.mBundle.putLong("VIDEO_PLAY_POSITION", 0L);
    }
  }
  
  public void aSa() {}
  
  public void aa(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!paramBoolean2)) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsCustomFrameLayout.setScrollable(true);
    }
    if (((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder instanceof mtg.l)) && (((mtg.l)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a != null) && (((mtg.l)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).aUv == 0)) {
      A(((mtg.l)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder).a.d);
    }
  }
  
  public void c(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    VideoInfo localVideoInfo;
    int i;
    if ((paramViewHolder instanceof mtg.l))
    {
      paramViewHolder = (mtg.l)paramViewHolder;
      localVideoInfo = paramViewHolder.a.d;
      if (this.jdField_a_of_type_Mwq != null) {
        this.jdField_a_of_type_Mwq.v(localVideoInfo);
      }
      i = paramViewHolder.aUv;
      if (i <= this.aVj) {
        break label78;
      }
    }
    for (;;)
    {
      this.aVj = i;
      this.ad.add(localVideoInfo.vid);
      A(localVideoInfo);
      return;
      label78:
      i = this.aVj;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
      if (this.jdField_a_of_type_Mwq != null) {
        this.jdField_a_of_type_Mwq.doOnActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      if (paramInt2 == -1)
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putAll(paramIntent.getExtras());
        muj.b(this.mApp, (Bundle)localObject);
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g().WF)))
        {
          RIJRedPacketManager.a().a(new mvu(this));
          continue;
          if (paramInt2 == -1)
          {
            if (!paramIntent.getBooleanExtra("bFailed", false)) {
              i = 1;
            }
            localObject = new QQToast(getActivity().getApplicationContext());
            ((QQToast)localObject).setDuration(2000);
            if (i != 0)
            {
              ((QQToast)localObject).setToastIcon(QQToast.getIconRes(2));
              ((QQToast)localObject).setToastMsg(2131693408);
              ((QQToast)localObject).show(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getActivity().getApplicationContext(), 5.0F));
            }
            else
            {
              ((QQToast)localObject).setToastIcon(QQToast.getIconRes(1));
              ((QQToast)localObject).setToastMsg(2131693409);
              ((QQToast)localObject).show(getActivity().getApplicationContext().getResources().getDimensionPixelSize(2131299627) - (int)aqho.convertDpToPixel(getActivity().getApplicationContext(), 5.0F));
              continue;
              if (paramInt2 == -1) {
                QQToast.a(getActivity(), 2131720247, 0).show();
              }
            }
          }
        }
      }
    }
  }
  
  public void doOnBackPressed()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onBackPressed())) {
      return;
    }
    ma(false);
    aSO();
    super.doOnBackPressed();
  }
  
  @TargetApi(11)
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      kxm.p("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "VideoFeedsPlayActivity doOnCreate()");
    }
    super.doOnCreate(paramBundle);
    if (VersionUtils.isIceScreamSandwich()) {
      getActivity().getWindow().setFlags(16777216, 16777216);
    }
    ayxa.initLiuHaiProperty(this);
    if (ayxa.isLiuHaiUseValid()) {
      ayxa.enableNotch(this);
    }
    aN(this);
    this.sd = System.currentTimeMillis();
    kbp.a(null, "", "0X800AF10", "0X800AF10", 0, 0, "", "", "", String.valueOf(System.currentTimeMillis()), false);
    QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 1, "doOnCreate: " + paramBundle);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finish();
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "doOnCreate: getIntent().getExtras() = null");
      return true;
    }
    aSI();
    if (paramBundle != null) {
      overridePendingTransition(2130772289, 0);
    }
    for (;;)
    {
      VideoReport.setPageId(this, "8006");
      VideoReport.addToDetectionWhitelist(this);
      return true;
      if (getIntent().getBooleanExtra("VIDEO_FEEDS_ANIM_ENABLE", true)) {
        a().a(this.b);
      }
    }
  }
  
  public void doOnDestroy()
  {
    try
    {
      super.doOnDestroy();
      this.ape = true;
      mry localmry = a();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null)
      {
        VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.g();
        localmry.g(localVideoInfo);
        if (this.b != null) {
          this.b.onDestroy();
        }
        if (this.jdField_a_of_type_Mwq != null) {
          this.jdField_a_of_type_Mwq.onDestroy();
        }
        if (this.mUIHandler != null)
        {
          this.mUIHandler.removeCallbacksAndMessages(null);
          this.mUIHandler = null;
        }
        if (this.jdField_a_of_type_Mwl != null) {
          this.jdField_a_of_type_Mwl.onDestroy();
        }
        this.mApp = null;
        msv.a().reset();
        nha.a(this).doOnDestory();
        lcc.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity$b);
        naa.a().aO("video_feeds", this.aVj);
        nX("VideoFeedsPlayActivity doOnDestroy()");
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        b("super.doOnDestroy failed. \n", localIllegalArgumentException);
        aSR();
        continue;
        Object localObject = null;
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnPause()
  {
    if (this.jdField_a_of_type_Mwq != null) {
      this.jdField_a_of_type_Mwq.onPause();
    }
    lcc.a().c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity$b);
    super.doOnPause();
  }
  
  public void doOnResume()
  {
    aN(this);
    this.mUIHandler.postDelayed(new VideoFeedsPlayActivity.7(this), 500L);
    if (this.jdField_a_of_type_Mwq != null) {
      this.jdField_a_of_type_Mwq.onResume();
    }
    nha.a(this).di(-1, -1);
    lcc.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsPlayActivity$b);
    super.doOnResume();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle) {}
  
  public void doOnStop()
  {
    super.doOnStop();
    nha.a(getActivity()).aWY();
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    super.doOnWindowFocusChanged(paramBoolean);
    aN(this);
  }
  
  public String getModuleId()
  {
    return "module_videofeeds";
  }
  
  public ViewGroup m()
  {
    return this.bK;
  }
  
  public void oA(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.oA(paramBoolean);
    }
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
      ma(false);
      aSO();
      continue;
      if (this.jdField_a_of_type_Mwq != null)
      {
        this.jdField_a_of_type_Mwq.sJ(0);
        continue;
        aSQ();
      }
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onRestoreInstanceState: ");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "onSaveInstanceState: ");
    }
  }
  
  public void ox(boolean paramBoolean)
  {
    boolean bool;
    if (!paramBoolean)
    {
      bool = true;
      oz(bool);
      if (paramBoolean) {
        break label46;
      }
      aN(this);
      if ((this.mContainer instanceof ViewPagerCompat)) {
        ((ViewPagerCompat)this.mContainer).setScrollable(true);
      }
    }
    label46:
    while (!(this.mContainer instanceof ViewPagerCompat))
    {
      return;
      bool = false;
      break;
    }
    ((ViewPagerCompat)this.mContainer).setScrollable(false);
  }
  
  public void oy(boolean paramBoolean)
  {
    if (!paramBoolean) {
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.apf) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecommendFragment.El())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    for (;;)
    {
      aSS();
      return;
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.apf)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
      }
    }
  }
  
  public void oz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.kd != null) {
        this.kd.setVisibility(0);
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat != null) && (this.apf)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(0);
      }
    }
    do
    {
      return;
      if (this.kd != null) {
        this.kd.setVisibility(8);
      }
    } while ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat == null) || (!this.apf));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFrameLayoutCompat.setVisibility(8);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
    this.mActNeedImmersive = false;
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(null);
    setRequestedOrientation(1);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if ((Build.VERSION.SDK_INT == 26) && (this.api))
    {
      aeej.convertActivityFromTranslucent(this);
      this.api = false;
    }
    try
    {
      superSetRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.pubaccount.video.feeds.VideoFeedsPlayActivity", 2, "setRequestedOrientation: ", localException);
    }
  }
  
  public void updateAppRuntime()
  {
    this.mApp = ((QQAppInterface)kxm.getAppRuntime());
  }
  
  public static class a
    implements Interpolator
  {
    private float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      return -paramFloat3 * (float)Math.cos(paramFloat1 / paramFloat4 * 1.570796326794897D) + paramFloat3 + paramFloat2;
    }
    
    public float getInterpolation(float paramFloat)
    {
      return a(paramFloat, 0.0F, 1.0F, 1.0F);
    }
  }
  
  public class b
    extends lce
  {
    private b() {}
    
    public void o(boolean paramBoolean, String paramString)
    {
      if ((paramBoolean) && (VideoFeedsPlayActivity.a(VideoFeedsPlayActivity.this).getVisibility() == 0))
      {
        VideoFeedsPlayActivity.b(VideoFeedsPlayActivity.this, true);
        localmes = new mes(VideoFeedsPlayActivity.this);
        localmes.setTips(paramString);
        localmes.rI(RIJRedPacketManager.a().oW());
        localmes.showAsDropDown(VideoFeedsPlayActivity.a(VideoFeedsPlayActivity.this), 0, -aqnm.dip2px(10.0F));
      }
      while (!paramBoolean)
      {
        mes localmes;
        return;
      }
      VideoFeedsPlayActivity.a(VideoFeedsPlayActivity.this).setVisibilityChangedListener(new mvv(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity
 * JD-Core Version:    0.7.0.1
 */