package com.tencent.mobileqq.hotpic;

import aasq;
import acfp;
import ahyv;
import ahyw;
import ahzd;
import ahzf;
import ahzg;
import ahzh;
import ahzi;
import ahzj;
import ahzk;
import ahzp;
import ahzq;
import ahzs;
import ahzw;
import ahzx;
import alul;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import aqhq;
import aqiw;
import com.nineoldandroids.animation.ValueAnimator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.TribeHotPicPanel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import wja;

@TargetApi(14)
public class HotPicPageView
  extends RelativeLayout
  implements ahzx, HotPicRecyclerView.b, HotVideoMongoliaRelativeLayout.c
{
  public static final int bsz;
  public static Drawable cF = new ColorDrawable(-855310);
  public static final double cG;
  public static final int cZI;
  public static boolean cjm = true;
  public static boolean cjn = true;
  public static int dcB;
  public static final int dcD;
  public static final int dcE;
  View DE;
  public ahzp a;
  ahzw jdField_a_of_type_Ahzw;
  HotPicMainPanel jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
  public a a;
  b jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b;
  public c a;
  protected e a;
  public HotPicRecyclerView a;
  HotPicTagInfo jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo;
  StaggeredGridLayoutManager b;
  Set<Integer> cA = new HashSet();
  Set<Integer> cB = new HashSet();
  private SparseArray<String> cL = new SparseArray();
  int cVe;
  Handler cY;
  private int dcC;
  public int dcF = -1;
  public int dcG = -1;
  BaseActivity mActivity;
  QQAppInterface mApp;
  BroadcastReceiver mBroadcastReceiver;
  Context mContext;
  boolean mHasInited = false;
  View mLoadingView;
  public int mPostion;
  SessionInfo mSessionInfo;
  public ArrayList<HotVideoMongoliaRelativeLayout> xl = new ArrayList();
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    cZI = wja.dp2px(1.0F, localResources);
    bsz = (localResources.getDisplayMetrics().widthPixels - cZI * 8) / 3;
    dcD = wja.dp2px(1.0F, localResources);
    dcE = localResources.getDisplayMetrics().widthPixels - cZI * 4;
    cG = 1.777777791023254D;
    dcB = -1;
  }
  
  public HotPicPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public static int a(HotPicData paramHotPicData)
  {
    if (paramHotPicData.getDataType() == 2) {}
    for (URL localURL = ahzs.a((HotVideoData)paramHotPicData); localURL == null; localURL = ahyv.getURL(paramHotPicData.url)) {
      return -1;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URLDrawable localURLDrawable = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    if (paramHotPicData.getDataType() == 2) {}
    for (localObject = ahzs.f(paramHotPicData.md5); (localObject != null) && (aqhq.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath())); localObject = ahyv.f(paramHotPicData.url)) {
      return 0;
    }
    if (localURLDrawable.getStatus() == 1)
    {
      localObject = ahyv.f(paramHotPicData.url);
      if ((localObject == null) || (!aqhq.fileExistsAndNotEmpty(((File)localObject).getAbsolutePath())))
      {
        URLDrawable.removeMemoryCacheByUrl(localURL.toString());
        paramHotPicData = a(paramHotPicData);
        if (paramHotPicData != null) {
          paramHotPicData.startDownload();
        }
        return 1;
      }
      return -1;
    }
    localURLDrawable.startDownload();
    return 2;
  }
  
  public static aasq a(int paramInt1, int paramInt2, int paramInt3, double paramDouble)
  {
    if ((paramInt2 <= 0) || (paramInt3 <= 0) || (paramDouble == 0.0D) || (paramInt1 <= 0)) {
      return null;
    }
    double d = paramInt2 / paramInt3 - paramDouble;
    int i;
    int j;
    if (d > 0.01D)
    {
      i = paramInt2;
      j = paramInt3;
      if (paramInt2 != paramInt1)
      {
        j = (int)(paramInt1 / paramInt2 * paramInt3);
        i = paramInt1;
      }
    }
    for (;;)
    {
      return new aasq(i, j);
      if (d < 0.01D)
      {
        i = paramInt2;
        j = paramInt3;
        if (paramInt2 != paramInt1)
        {
          paramDouble = paramInt1 / paramDouble;
          i = paramInt2;
          j = paramInt3;
          if (Math.abs(paramInt3 - paramDouble) > 0.01D)
          {
            i = (int)(paramDouble / paramInt3 * paramInt2);
            j = (int)paramDouble;
          }
        }
      }
      else
      {
        i = paramInt2;
        j = paramInt3;
        if (paramInt2 != paramInt1)
        {
          j = (int)(paramInt1 / paramInt2 * paramInt3);
          i = paramInt1;
        }
      }
    }
  }
  
  static URLDrawable a(HotPicData paramHotPicData)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = cF;
    localURLDrawableOptions.mFailedDrawable = cF;
    boolean bool;
    if (paramHotPicData.getDataType() != 2)
    {
      bool = true;
      localURLDrawableOptions.mPlayGifImage = bool;
      localURLDrawableOptions.mExtraInfo = paramHotPicData;
      if (paramHotPicData.getDataType() != 2) {
        break label65;
      }
    }
    label65:
    for (paramHotPicData = ahzs.a((HotVideoData)paramHotPicData);; paramHotPicData = ahyv.getURL(paramHotPicData.url))
    {
      if (paramHotPicData != null) {
        break label76;
      }
      return null;
      bool = false;
      break;
    }
    label76:
    return URLDrawable.getDrawable(paramHotPicData, localURLDrawableOptions);
  }
  
  public static void drh()
  {
    cjm = true;
    dcB = -1;
  }
  
  public static boolean isMainThread()
  {
    return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
  }
  
  public void N(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) {}
    HotPicData localHotPicData;
    do
    {
      do
      {
        return;
        localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.get(paramInt);
      } while (localHotPicData.getDataType() == 2);
      paramInt = a(localHotPicData);
    } while ((paramInt == 2) || (paramInt == -1));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.c(localHotPicData);
    paramView.getParent().requestDisallowInterceptTouchEvent(true);
    anot.a(this.mApp, "dc00898", "", "", "0X8007B22", "0X8007B22", 0, 0, "", "", "", "");
  }
  
  public void PB(int paramInt)
  {
    dcB = paramInt;
    if (dcB <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      cjm = bool;
      return;
    }
  }
  
  public void PC(int paramInt)
  {
    this.cB.add(Integer.valueOf(paramInt));
    this.cA.add(Integer.valueOf(paramInt));
  }
  
  public void a(HotPicMainPanel paramHotPicMainPanel, HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView = ((HotPicRecyclerView)findViewById(2131376994));
    this.mLoadingView = findViewById(2131370787);
    this.DE = findViewById(2131368662);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = paramHotPicMainPanel;
    this.mContext = paramHotPicMainPanel.mContext;
    this.mApp = paramHotPicMainPanel.mApp;
    this.mSessionInfo = paramHotPicMainPanel.mSessionInfo;
    this.mActivity = paramHotPicMainPanel.mActivity;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo = paramHotPicTagInfo;
    this.cVe = paramHotPicTagInfo.tagId;
    this.mPostion = paramHotPicTagInfo.position;
    if (paramHotPicTagInfo.tagType == 2) {}
    for (int i = 1;; i = 3)
    {
      this.b = new StaggeredGridLayoutManager(i, 1);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setLayoutManager(this.b);
      this.b.mExceptionListener = new ahzf(this);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a = new a(this.cVe);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.a = this;
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b = new b(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a);
      if (this.cVe == -20) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setType(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = paramHotPicMainPanel;
      this.jdField_a_of_type_Ahzw = new ahzw(this);
      paramHotPicMainPanel = ahzd.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mApp);
      if (paramHotPicMainPanel.kb(this.cVe))
      {
        this.jdField_a_of_type_Ahzw.KM(true);
        this.jdField_a_of_type_Ahzp = ahzp.a(this.mContext);
        dri();
      }
      if (paramHotPicMainPanel.kb(this.cVe))
      {
        cjn = false;
        ah(0, 3000L);
      }
      this.mBroadcastReceiver = new ahzg(this);
      paramHotPicMainPanel = new IntentFilter();
      paramHotPicMainPanel.addAction("android.intent.action.SCREEN_OFF");
      paramHotPicMainPanel.addAction("android.intent.action.SCREEN_ON");
      paramHotPicMainPanel.addAction("tencent.av.v2q.StartVideoChat");
      paramHotPicMainPanel.addAction("tencent.av.v2q.StopVideoChat");
      paramHotPicMainPanel.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
      this.mContext.registerReceiver(this.mBroadcastReceiver, paramHotPicMainPanel);
      return;
    }
  }
  
  public void a(c paramc)
  {
    if (paramc == null) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c != paramc))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c.mPlayState >= 1) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c.PD(0);
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c = paramc;
  }
  
  public void a(c paramc, int paramInt)
  {
    cjn = true;
    if (paramc == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView == null);
      paramc = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
      HotPicRecyclerView.KS("onVideoItemClick");
      bool = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.ke(paramInt);
      paramc = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView;
      HotPicRecyclerView.KS("onVideoItemClick CheckItemIsNeedToScroll End isNeedScroll is " + bool);
    } while (!bool);
    this.dcG = paramInt;
    cjn = false;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.ir(-1, paramInt);
  }
  
  void ah(int paramInt, long paramLong)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay startAutoPlayTimer");
    }
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {}
    while ((cjn) || (i == 0))
    {
      return;
      i = 0;
    }
    drj();
    this.cY.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public boolean aoC()
  {
    if (this.mContext == null) {}
    do
    {
      return false;
      if (ahzq.aoD()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.isBlurSwitch is false");
    return false;
    int i = ahzq.Fw();
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, " HotVideoDPC.getBlurMemory is " + i);
    }
    ActivityManager localActivityManager = (ActivityManager)this.mContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, " mi.availMem is " + localMemoryInfo.availMem / 1024L);
    }
    if (localMemoryInfo.availMem > i * 1024 * 1024) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void clearView()
  {
    if (!this.mHasInited) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.clearDatas();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyDataSetChanged();
    this.mHasInited = false;
  }
  
  void dri()
  {
    cjn = true;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setScrollStatusChengedListener(this);
    this.cY = new ahzh(this);
  }
  
  void drj()
  {
    this.cY.removeMessages(1);
    this.cY.removeMessages(0);
  }
  
  public void drk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HotPicManagerHotPicPageView", 2, "AutoPlay TryScrollAndPlayNextVideo");
    }
    if (cjn) {}
    int i;
    int j;
    do
    {
      return;
      i = this.dcF;
      j = i + 1;
    } while (j >= this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.getItemCount());
    this.dcG = j;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.ir(i, j);
  }
  
  public void drl()
  {
    if (this.jdField_a_of_type_Ahzp != null) {
      ahzp.b(this.jdField_a_of_type_Ahzp);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c;
    if (localObject != null)
    {
      if (((c)localObject).mPlayState <= 2) {
        break label45;
      }
      localObject = ((c)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).pauseVideo();
      }
    }
    label45:
    while (((c)localObject).mPlayState == -10) {
      return;
    }
    ((c)localObject).PD(0);
  }
  
  public void drm()
  {
    int i = 2;
    ahzd localahzd = ahzd.a(this.mApp);
    if (this.cVe == -20)
    {
      this.mLoadingView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setType(2);
      if (localahzd.a().size() <= 0)
      {
        this.DE.setVisibility(0);
        return;
      }
      this.DE.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.setDatas(localahzd.a());
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyDataSetChanged();
      return;
    }
    if (localahzd.kc(this.cVe))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.setDatas(localahzd.r(this.cVe));
      if (localahzd.kd(this.cVe)) {}
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$b.setType(i);
        this.mLoadingView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.scrollToPosition(0);
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.notifyDataSetChanged();
        return;
        i = 1;
      }
    }
    this.mLoadingView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.setVisibility(8);
    localahzd.Pz(this.cVe);
  }
  
  void drn()
  {
    for (;;)
    {
      int i1;
      int k;
      int i3;
      int i2;
      int m;
      boolean bool;
      try
      {
        if ((aqiw.isWifiEnabled(this.mContext)) && (this.cA.size() == this.cB.size()) && (this.dcC + 1 <= this.cA.size()))
        {
          i1 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.size();
          if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) || (!ahzd.a(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mApp).kb(this.cVe))) {
            break label722;
          }
          i = 8;
          k = 1;
          i3 = (this.dcC / i + 1) * i - 1;
          i2 = i3 + i;
          j = 0;
          i = 0;
          int n = 0;
          if (this.cA.size() > i3) {
            break label408;
          }
          if (this.cB.size() <= i3)
          {
            m = this.cB.size();
            i = n;
            j = i;
            if (m <= i3)
            {
              j = i;
              if (m < i1)
              {
                bool = this.cB.contains(Integer.valueOf(m));
                if (bool) {
                  break label719;
                }
              }
            }
          }
        }
        else
        {
          try
          {
            localURLDrawable1 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.get(m));
            if (localURLDrawable1 == null) {
              return;
            }
            j = localURLDrawable1.getStatus();
            if (j != 1)
            {
              j = i + 1;
              if (i >= k) {
                continue;
              }
            }
          }
          catch (Exception localException1)
          {
            URLDrawable localURLDrawable1;
            j = i;
          }
        }
      }
      finally {}
      label653:
      try
      {
        this.jdField_a_of_type_Ahzw.d(m, localURLDrawable1);
      }
      catch (Exception localException5)
      {
        label408:
        continue;
      }
      try
      {
        this.cB.add(Integer.valueOf(m));
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.cVe + " " + m);
          i = j;
        }
        m += 1;
      }
      catch (Exception localException6)
      {
        continue;
        break label653;
      }
      this.cA.add(Integer.valueOf(m));
      int j = i;
      continue;
      localException1.printStackTrace();
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("HotPicManagerHotPicPageView", 2, "preDownloadOnUi !mStartDownLoadIndex.contains(index) Exception ", localException1);
        i = j;
        continue;
        if (j == 0)
        {
          i = j;
          if (this.cA.size() > i3)
          {
            j = this.cVe;
            if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.size() < i2) && (!ahzd.a(this.mApp).kd(j))) {
              ahzd.a(this.mApp).Pz(j);
            }
            if (this.cB.size() <= i2)
            {
              m = this.cB.size();
              if ((m <= i2) && (m < i1))
              {
                bool = this.cB.contains(Integer.valueOf(m));
                if (!bool) {
                  for (;;)
                  {
                    for (;;)
                    {
                      try
                      {
                        localURLDrawable2 = a((HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.get(m));
                        if (localURLDrawable2 == null) {
                          break;
                        }
                        j = localURLDrawable2.getStatus();
                        if (j != 1)
                        {
                          j = i + 1;
                          if (i >= k) {
                            break;
                          }
                        }
                      }
                      catch (Exception localException2)
                      {
                        URLDrawable localURLDrawable2;
                        localException2.printStackTrace();
                        continue;
                      }
                      try
                      {
                        this.jdField_a_of_type_Ahzw.d(m, localURLDrawable2);
                      }
                      catch (Exception localException3)
                      {
                        i = j;
                        continue;
                      }
                      try
                      {
                        this.cB.add(Integer.valueOf(m));
                        i = j;
                        if (QLog.isColorLevel())
                        {
                          QLog.d("HotPicManagerHotPicPageView", 2, "preDownload  " + this.cVe + " " + m);
                          i = j;
                        }
                        m += 1;
                      }
                      catch (Exception localException4)
                      {
                        i = j;
                      }
                    }
                    this.cA.add(Integer.valueOf(m));
                    j = i;
                  }
                }
                label719:
                continue;
                label722:
                k = 2;
                i = 16;
              }
            }
          }
        }
      }
    }
  }
  
  void dro()
  {
    if (this.jdField_a_of_type_Ahzp == null) {
      this.jdField_a_of_type_Ahzp = ahzp.a(this.mContext);
    }
    for (;;)
    {
      int i = 0;
      while (i < this.cL.size())
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
        {
          int j = this.cL.keyAt(i);
          String str1 = (String)this.cL.valueAt(i);
          String str2 = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "_" + j;
          m("0X8007EDD", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", j + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", str1 + "");
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.cy.add(str2);
        }
        i += 1;
      }
      ahzp.a(this.jdField_a_of_type_Ahzp);
    }
    this.cL.clear();
  }
  
  public void initView()
  {
    if (this.mHasInited) {
      return;
    }
    drm();
    this.mHasInited = true;
  }
  
  void m(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 1;
    int k = 0;
    String str2 = "";
    String str1;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof PublicAccountHotPicPanel)) {
        i = 3;
      }
    }
    else
    {
      str1 = str2;
      j = k;
      if (i == 1)
      {
        str1 = str2;
        j = k;
        if (this.mSessionInfo != null)
        {
          str1 = str2;
          j = k;
          if (this.mSessionInfo.aTl != null)
          {
            str1 = this.mSessionInfo.aTl;
            switch (this.mSessionInfo.cZ)
            {
            default: 
              j = k;
            }
          }
        }
      }
    }
    for (;;)
    {
      anot.a(this.mApp, "dc00898", "", str1, paramString1, paramString1, i, j, paramString2, paramString3, paramString4, paramString5);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof TribeHotPicPanel))
      {
        i = 4;
        break;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel instanceof HotPicMainPanel))
      {
        i = 1;
        break;
      }
      i = 5;
      break;
      j = 1;
      continue;
      j = 2;
      continue;
      j = 3;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagType == 2)) {
      cjn = true;
    }
  }
  
  public void onItemClick(View paramView, int paramInt)
  {
    HotPicData localHotPicData;
    try
    {
      localHotPicData = (HotPicData)this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$a.mDatas.get(paramInt);
      if (localHotPicData.getDataType() == 2) {
        return;
      }
    }
    catch (IndexOutOfBoundsException paramView)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, onItemClick IndexOutOfBoundsException " + paramView.getMessage());
      return;
    }
    int i = localHotPicData.tag;
    int j = 0;
    Object localObject1 = ahyv.f(localHotPicData.originalUrl);
    Object localObject2;
    if ((localObject1 != null) && (aqhq.fileExistsAndNotEmpty(((File)localObject1).getAbsolutePath())))
    {
      localObject2 = ((File)localObject1).getAbsolutePath();
      i = 1;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label412;
      }
      QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPicOringinal = " + localHotPicData.originalUrl + ", paths = " + (String)localObject2);
      localObject1 = localObject2;
      i = 1;
    }
    for (;;)
    {
      m("0X8007EDE", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", localHotPicData.url + "");
      if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e.a(paramView, (String)localObject1, localHotPicData))) {
        break;
      }
      if ((localObject1 == null) && (this.mSessionInfo.cZ != 1008))
      {
        QQToast.a(this.mContext, 2131701267, 0).show();
        return;
        if (a(localHotPicData) == 0)
        {
          localObject2 = ahyv.f(localHotPicData.url).getAbsolutePath();
          localObject1 = localObject2;
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicManagerHotPicPageView", 2, "senHotPic, urlHotPic = " + localHotPicData.url + ", paths = " + (String)localObject2);
            i = j;
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        label412:
        paramView = new Intent();
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(localObject1);
        paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
        paramView.putExtra("uin", this.mSessionInfo.aTl);
        paramView.putExtra("uintype", this.mSessionInfo.cZ);
        paramView.putExtra("troop_uin", this.mSessionInfo.troopUin);
        paramView.putExtra("key_confess_topicid", this.mSessionInfo.topicId);
        paramView.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
        paramView.putExtra("send_in_background", true);
        paramView.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (Serializable)localObject2);
        paramView.putExtra("PicContants.NEED_COMPRESS", false);
        if (i == 0)
        {
          paramView.putExtra("quick_send_original_md5", localHotPicData.originalMD5);
          paramView.putExtra("quick_send_original_size", localHotPicData.oringinalSize);
          paramView.putExtra("quick_send_thumb_md5", localHotPicData.md5);
          paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1042);
          label601:
          ThreadManager.post(new SendPhotoTask(this.mActivity, paramView, null), 8, null, false);
          ahzd.a(this.mApp).d(localHotPicData);
          anot.a(this.mApp, "dc00898", "", "", "0X8007B17", "0X8007B17", 0, 0, "", "", "", "");
          if (this.mSessionInfo.cZ != 3000) {
            break label848;
          }
          anot.a(this.mApp, "dc00898", "", "", "0X8007B1A", "0X8007B1A", 0, 0, "", "", "", "");
        }
        for (;;)
        {
          if (this.cVe == -20) {
            anot.a(this.mApp, "dc00898", "", "", "0X8007B18", "0X8007B18", 0, 0, "", "", "", "");
          }
          switch (localHotPicData.sourceType)
          {
          default: 
            return;
          case 1: 
            anot.a(this.mApp, "dc00898", "", "", "0X8007B1E", "0X8007B1E", 0, 0, "", "", "", "");
            return;
            paramView.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1031);
            break label601;
            label848:
            if (this.mSessionInfo.cZ == 1)
            {
              anot.a(this.mApp, "dc00898", "", "", "0X8007B1B", "0X8007B1B", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(alul.bYx)) {
                anot.a(this.mApp, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 2, 0, "", "", "", "");
              }
            }
            else
            {
              anot.a(this.mApp, "dc00898", "", "", "0X8007B19", "0X8007B19", 0, 0, "", "", "", "");
              if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName.equals(alul.bYy)) {
                anot.a(this.mApp, "dc00898", "", "", "0X800A4CE", "0X800A4CE", 1, 0, "", "", "", "");
              }
            }
            break;
          }
        }
        anot.a(this.mApp, "dc00898", "", "", "0X8007B1F", "0X8007B1F", 0, 0, "", "", "", "");
        return;
        anot.a(this.mApp, "dc00898", "", "", "0X8007B20", "0X8007B20", 0, 0, "", "", "", "");
        return;
      }
      localObject1 = null;
      i = 0;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((ahzd.a(this.mApp).kb(this.cVe)) && (paramKeyEvent.getAction() == 0)) {
      cjn = true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c != null) && (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c.mPlayState == 3))
    {
      HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c.a();
      if (localHotVideoMongoliaRelativeLayout != null) {
        localHotVideoMongoliaRelativeLayout.pauseVideo();
      }
    }
  }
  
  public void onScrollEnd()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c;
    if (localObject != null)
    {
      localObject = ((c)localObject).a();
      if (localObject != null) {
        ((HotVideoMongoliaRelativeLayout)localObject).drB();
      }
    }
    int i;
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1)
    {
      i = 1;
      if (i != 0) {
        break label44;
      }
    }
    label44:
    do
    {
      do
      {
        do
        {
          return;
          i = 0;
          break;
        } while (cjn);
        i = this.dcG;
        localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.findViewHolderForPosition(i);
      } while ((i < 0) || (localObject == null) || (!(localObject instanceof c)));
      localObject = (c)localObject;
    } while (((c)localObject).mPlayState == 0);
    ((c)localObject).cjo = true;
  }
  
  public void onScrollStart()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c;
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((c)localObject).a();
    } while (localObject == null);
    ((HotVideoMongoliaRelativeLayout)localObject).drA();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel == null) {}
    do
    {
      return false;
      if (!ahzd.a(this.mApp).kb(this.cVe)) {
        break;
      }
    } while (paramMotionEvent.getAction() != 0);
    cjn = true;
    return false;
    View localView = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.DC;
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView;
    if (paramMotionEvent.getAction() == 0)
    {
      paramMotionEvent = localRelativeLayout.findViewWithTag("HotPicControlTag");
      if (paramMotionEvent != null)
      {
        int i = ((ViewGroup.MarginLayoutParams)paramMotionEvent.getLayoutParams()).topMargin;
        paramView = new RelativeLayout.LayoutParams(paramView.getWidth(), paramView.getHeight());
        paramMotionEvent = new ImageView(localRelativeLayout.getContext());
        paramMotionEvent.setTag("HotPicPopControlTag");
        paramView.topMargin = i;
        if (Build.VERSION.SDK_INT >= 16)
        {
          paramMotionEvent.setBackgroundColor(Color.parseColor("#7f000000"));
          localRelativeLayout.addView(paramMotionEvent, paramView);
        }
      }
      else
      {
        label151:
        if (localView.getVisibility() != 0) {
          break label238;
        }
      }
    }
    label238:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      paramMotionEvent.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#7f000000")));
      break;
      if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) {
        break label151;
      }
      paramView = localRelativeLayout.findViewWithTag("HotPicPopControlTag");
      if (paramView != null) {
        localRelativeLayout.removeView(paramView);
      }
      if (localView.getVisibility() != 0) {
        break label151;
      }
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.dqY();
      break label151;
    }
  }
  
  public void px()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      drn();
      return;
    }
    ThreadManager.getUIHandler().post(new HotPicPageView.4(this));
  }
  
  void reset()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicRecyclerView.a = null;
    this.jdField_a_of_type_Ahzw.reset();
    this.jdField_a_of_type_Ahzw = null;
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = null;
    this.cA.clear();
    this.cB.clear();
    this.dcC = 0;
    if (this.mBroadcastReceiver != null) {
      this.mContext.unregisterReceiver(this.mBroadcastReceiver);
    }
  }
  
  public void setOnHotPicItemClickListener(e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$e = parame;
  }
  
  public class a
    extends RecyclerView.Adapter<HotPicPageView.d>
  {
    ahzx a;
    List<HotPicData> mDatas = new ArrayList();
    
    public a(int paramInt) {}
    
    public HotPicPageView.d a(ViewGroup paramViewGroup, int paramInt)
    {
      if (ahzd.a(HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mApp).kb(HotPicPageView.this.cVe)) {
        return new HotPicPageView.c(HotPicPageView.this, LayoutInflater.from(HotPicPageView.this.mContext).inflate(2131558662, paramViewGroup, false), this.a);
      }
      return new HotPicPageView.d(HotPicPageView.this, LayoutInflater.from(HotPicPageView.this.mContext).inflate(2131558661, paramViewGroup, false), this.a);
    }
    
    public void a(HotPicPageView.d paramd, int paramInt)
    {
      Object localObject1;
      Object localObject2;
      if ((paramd instanceof HotPicPageView.c))
      {
        localObject1 = (HotPicPageView.c)paramd;
        ((HotPicPageView.c)localObject1).drs();
        localObject2 = ((HotPicPageView.c)localObject1).a();
        if (localObject2 != null)
        {
          ((HotVideoData)localObject2).SetPreviewDownloadListener(null);
          if (HotPicPageView.this.jdField_a_of_type_Ahzp != null) {
            HotPicPageView.this.jdField_a_of_type_Ahzp.b((HotVideoData)localObject2);
          }
        }
        ((HotPicPageView.c)localObject1).a(null);
      }
      for (;;)
      {
        HotPicData localHotPicData = (HotPicData)this.mDatas.get(paramInt);
        ViewGroup.MarginLayoutParams localMarginLayoutParams1 = (ViewGroup.MarginLayoutParams)paramd.imageView.getLayoutParams();
        localMarginLayoutParams1.rightMargin = HotPicPageView.cZI;
        localMarginLayoutParams1.leftMargin = HotPicPageView.cZI;
        int i;
        int k;
        int j;
        Object localObject3;
        float f;
        if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2))
        {
          localMarginLayoutParams1.topMargin = (HotPicPageView.cZI * 2);
          i = localHotPicData.width;
          k = localHotPicData.height;
          j = HotPicPageView.bsz;
          if ((localHotPicData.getDataType() != 2) || (localObject1 == null)) {
            break label805;
          }
          ViewGroup.MarginLayoutParams localMarginLayoutParams2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.c)localObject1).kL.getLayoutParams();
          localMarginLayoutParams1.topMargin = 0;
          localMarginLayoutParams1.rightMargin = 0;
          localMarginLayoutParams1.leftMargin = 0;
          HotVideoData localHotVideoData = (HotVideoData)localHotPicData;
          ((HotPicPageView.c)localObject1).a(localHotVideoData);
          localHotVideoData.SetPreviewDownloadListener((URLDrawable.DownloadListener)localObject1);
          j = HotPicPageView.dcE;
          localObject3 = HotPicPageView.a(HotPicPageView.dcE, localHotVideoData.width, localHotVideoData.height, HotPicPageView.cG);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = new aasq(localHotVideoData.width, localHotVideoData.height);
          }
          f = i / ((aasq)localObject2).getWidth();
          i = ((aasq)localObject2).getHeight();
          ((HotPicPageView.c)localObject1).TY.setText(localHotVideoData.getVideoLengthString());
          ((HotPicPageView.c)localObject1).TX.setText(localHotVideoData.name);
          localMarginLayoutParams2.width = j;
          localMarginLayoutParams2.height = i;
          localObject2 = (ViewGroup.MarginLayoutParams)((HotPicPageView.c)localObject1).backgroundView.getLayoutParams();
          ((ViewGroup.MarginLayoutParams)localObject2).width = j;
          ((ViewGroup.MarginLayoutParams)localObject2).height = i;
          label355:
          localMarginLayoutParams1.width = j;
          localMarginLayoutParams1.height = i;
          k = (int)(160.0F / f + 0.5F);
          localObject2 = HotPicPageView.a(localHotPicData);
          if ((localObject2 == null) || (localHotPicData.getDataType() != 2) || (localObject1 == null)) {
            break label1239;
          }
          anot.a(HotPicPageView.this.mApp, "dc00898", "", "", "0X8007EDC", "0X8007EDC", 0, 0, HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", localHotPicData.name + "", localHotPicData.url + "");
          localObject3 = (HotVideoData)localHotPicData;
          i = ((URLDrawable)localObject2).getStatus();
          if ((i != 1) && (i != 4)) {
            break label907;
          }
          if (ahzs.b((HotVideoData)localObject3)) {
            break label827;
          }
          ((HotPicPageView.c)localObject1).PD(-11);
          i = 1;
        }
        for (;;)
        {
          label564:
          if (localObject2 != null)
          {
            if (HotPicPageView.this.cVe != -20)
            {
              localObject3 = HotPicPageView.this;
              if (paramInt < HotPicPageView.a(HotPicPageView.this)) {
                break label991;
              }
              j = paramInt;
              label601:
              HotPicPageView.a((HotPicPageView)localObject3, j);
              HotPicPageView.this.cB.add(Integer.valueOf(paramInt));
              if (((URLDrawable)localObject2).getStatus() == 1) {
                break label1003;
              }
              HotPicPageView.this.jdField_a_of_type_Ahzw.a((URLDrawable)localObject2, paramInt);
              j = 16;
              if (localHotPicData.getDataType() == 2) {
                j = 8;
              }
              if (paramInt % j == 1) {
                HotPicPageView.this.px();
              }
            }
            if (localHotPicData.getDataType() == 2) {
              break label1029;
            }
            ((URLDrawable)localObject2).setTargetDensity(k);
            label696:
            if (i != 0)
            {
              if (localHotPicData.getDataType() != 2) {
                break label1040;
              }
              ((HotPicPageView.c)localObject1).X((Drawable)localObject2);
            }
            label717:
            if (HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
            {
              localObject1 = HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "_" + paramInt;
              if (!HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.cy.contains(localObject1)) {
                break label1052;
              }
            }
          }
          for (;;)
          {
            label648:
            EventCollector.getInstance().onRecyclerBindViewHolder(paramd, paramInt, getItemId(paramInt));
            return;
            localMarginLayoutParams1.topMargin = 0;
            break;
            label805:
            f = i / j;
            i = (int)(k / f + 0.5F);
            break label355;
            label827:
            ((HotPicPageView.c)localObject1).PD(0);
            if (!((HotVideoData)localObject3).CheckIsNeedBlurBackground()) {
              break label1239;
            }
            ((HotPicPageView.c)localObject1).Y(new ColorDrawable(Color.parseColor("#7f000000")));
            if ((!HotPicPageView.this.aoC()) || (Build.VERSION.SDK_INT < 17) || (HotPicPageView.this.jdField_a_of_type_Ahzp == null)) {
              break label1239;
            }
            HotPicPageView.this.jdField_a_of_type_Ahzp.a((HotPicPageView.c)localObject1, (HotVideoData)localObject3);
            i = 1;
            break label564;
            label907:
            if (((HotVideoData)localObject3).url.isEmpty())
            {
              i = 0;
              ((HotPicPageView.c)localObject1).PD(-10);
              ((HotVideoData)localObject3).GetPreviewURLAsync(HotPicPageView.this.mApp, 0, "0", new ahzi(this, (HotVideoData)localObject3, (HotPicPageView.c)localObject1, (URLDrawable)localObject2));
              break label564;
            }
            j = 1;
            i = j;
            if (localHotPicData.getDataType() != 2) {
              break label564;
            }
            localObject3 = (HotVideoData)localHotPicData;
            i = j;
            break label564;
            label991:
            j = HotPicPageView.a(HotPicPageView.this);
            break label601;
            label1003:
            HotPicPageView.this.cA.add(Integer.valueOf(paramInt));
            ((URLDrawable)localObject2).setAutoDownload(true);
            break label648;
            label1029:
            ((URLDrawable)localObject2).setTargetDensity(160);
            break label696;
            label1040:
            paramd.imageView.setImageDrawable((Drawable)localObject2);
            break label717;
            label1052:
            if (HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mViewPager != null) {
              if (HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.mViewPager.getCurrentItem() == HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position)
              {
                HotPicPageView.this.m("0X8007EDD", HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.position + "", paramInt + "", HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTagInfo.tagName + "", localHotPicData.url + "");
                HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.cy.add(localObject1);
              }
              else
              {
                HotPicPageView.a(HotPicPageView.this).put(paramInt, localHotPicData.url);
              }
            }
          }
          label1239:
          i = 1;
        }
        localObject1 = null;
      }
    }
    
    public void clearDatas()
    {
      this.mDatas.clear();
    }
    
    public int getItemCount()
    {
      return this.mDatas.size();
    }
    
    public void setDatas(List<? extends HotPicData> paramList)
    {
      this.mDatas.clear();
      this.mDatas.addAll(paramList);
    }
  }
  
  class b
    implements ahyw
  {
    HotPicPageView.a c;
    int mFooterType = 1;
    public boolean my;
    
    public b(HotPicPageView.a parama)
    {
      this.c = parama;
    }
    
    public RecyclerView.ViewHolder d(ViewGroup paramViewGroup, int paramInt)
    {
      return new HotPicPageView.d(HotPicPageView.this, LayoutInflater.from(HotPicPageView.this.mContext).inflate(2131558664, paramViewGroup, false), null);
    }
    
    public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      StaggeredGridLayoutManager.LayoutParams localLayoutParams1 = null;
      if (StaggeredGridLayoutManager.LayoutParams.class.isInstance(paramViewHolder.itemView.getLayoutParams())) {
        localLayoutParams1 = (StaggeredGridLayoutManager.LayoutParams)paramViewHolder.itemView.getLayoutParams();
      }
      StaggeredGridLayoutManager.LayoutParams localLayoutParams2 = localLayoutParams1;
      if (localLayoutParams1 == null)
      {
        localLayoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
        paramViewHolder.itemView.setLayoutParams(localLayoutParams2);
      }
      localLayoutParams2.setFullSpan(true);
      paramInt = HotPicPageView.this.cVe;
      if ((!this.my) && (paramInt != -20) && (this.mFooterType == 1))
      {
        ahzd.a(HotPicPageView.this.mApp).Pz(paramInt);
        this.my = true;
      }
      if (this.mFooterType == 1)
      {
        paramViewHolder.itemView.findViewById(2131368660).setVisibility(0);
        paramViewHolder.itemView.findViewById(2131368661).setVisibility(4);
        return;
      }
      if (HotPicPageView.isMainThread())
      {
        paramViewHolder.itemView.findViewById(2131368661).setVisibility(0);
        paramViewHolder.itemView.findViewById(2131368660).setVisibility(8);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.HotPicFooter.1(this, paramViewHolder));
    }
    
    public void setLoading(boolean paramBoolean)
    {
      this.my = paramBoolean;
    }
    
    public void setType(int paramInt)
    {
      this.mFooterType = paramInt;
    }
  }
  
  public class c
    extends HotPicPageView.d
    implements URLDrawable.DownloadListener, HotVideoMongoliaRelativeLayout.b
  {
    ImageView AH;
    View DF;
    TextView TX;
    TextView TY;
    ImageView backgroundView;
    public boolean cjo;
    RelativeLayout fL;
    WeakReference<HotVideoData> he;
    RelativeLayout kK;
    RelativeLayout kL;
    public ImageView kN;
    public int mPlayState = -10;
    TextView nM;
    TextView wX;
    
    public c(View paramView, ahzx paramahzx)
    {
      super(paramView, paramahzx);
      if (this.itemView != null) {
        this.itemView.setOnTouchListener(null);
      }
      this.fL = ((RelativeLayout)paramView.findViewById(2131368659));
      this.kL = ((RelativeLayout)paramView.findViewById(2131368665));
      this.kK = ((RelativeLayout)paramView.findViewById(2131368664));
      this.TX = ((TextView)paramView.findViewById(2131381834));
      this.TY = ((TextView)paramView.findViewById(2131381840));
      this.kN = ((ImageView)paramView.findViewById(2131381757));
      this.nM = ((TextView)paramView.findViewById(2131373557));
      this.wX = ((TextView)paramView.findViewById(2131381769));
      this.AH = ((ImageView)paramView.findViewById(2131381835));
      this.DF = paramView.findViewById(2131364616);
      this.backgroundView = ((ImageView)paramView.findViewById(2131381637));
    }
    
    public void PD(int paramInt)
    {
      if (HotPicPageView.isMainThread())
      {
        PE(paramInt);
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.2(this, paramInt));
    }
    
    public void PE(int paramInt)
    {
      if (paramInt == this.mPlayState) {
        return;
      }
      drr();
      switch (paramInt)
      {
      }
      for (;;)
      {
        this.mPlayState = paramInt;
        if ((paramInt != 0) || (!this.cjo)) {
          break;
        }
        Object localObject = a();
        if (localObject == null) {
          break;
        }
        HotPicPageView.this.a(this, ((HotVideoData)localObject).picIndex);
        this.cjo = false;
        return;
        drs();
        HotPicPageView.this.setContentDescription("");
        this.cjo = false;
        continue;
        this.imageView.setVisibility(0);
        drp();
        this.TX.setVisibility(0);
        this.TY.setVisibility(0);
        this.AH.setVisibility(0);
        this.kN.setVisibility(0);
        this.nM.setVisibility(8);
        this.DF.setVisibility(8);
        this.itemView.setContentDescription(acfp.m(2131707265));
        continue;
        this.imageView.setVisibility(0);
        drp();
        this.TX.setVisibility(0);
        this.TY.setVisibility(0);
        this.AH.setVisibility(0);
        this.kN.setVisibility(0);
        this.nM.setVisibility(8);
        this.DF.setVisibility(8);
        this.itemView.setContentDescription(acfp.m(2131707262));
        this.cjo = false;
        continue;
        this.cjo = false;
        if (paramInt == 1) {
          HotPicPageView.this.a(this);
        }
        this.imageView.setVisibility(0);
        this.TX.setVisibility(0);
        this.TY.setVisibility(0);
        this.AH.setVisibility(0);
        this.kN.setVisibility(8);
        this.nM.setVisibility(8);
        this.DF.setVisibility(0);
        continue;
        this.imageView.setVisibility(8);
        this.TX.setVisibility(8);
        this.TY.setVisibility(8);
        this.AH.setVisibility(8);
        this.kN.setVisibility(8);
        this.nM.setVisibility(8);
        this.DF.setVisibility(8);
        this.itemView.setContentDescription(acfp.m(2131707268));
        continue;
        if ((this.imageView.getVisibility() == 0) && ((this.mPlayState == 1) || (this.mPlayState == 2)))
        {
          localObject = new AlphaAnimation(1.0F, 0.8F);
          ((AlphaAnimation)localObject).setDuration(600L);
          ((AlphaAnimation)localObject).setAnimationListener(new ahzj(this));
          this.imageView.startAnimation((Animation)localObject);
        }
        for (;;)
        {
          this.TX.setVisibility(8);
          this.TY.setVisibility(8);
          this.AH.setVisibility(8);
          this.kN.setVisibility(8);
          this.nM.setVisibility(8);
          this.DF.setVisibility(8);
          this.itemView.setContentDescription(acfp.m(2131707264));
          break;
          this.imageView.setVisibility(8);
        }
        this.imageView.setVisibility(8);
        this.TX.setVisibility(0);
        this.TY.setVisibility(8);
        this.AH.setVisibility(8);
        this.kN.setVisibility(0);
        this.nM.setVisibility(0);
        this.DF.setVisibility(8);
        this.itemView.setContentDescription(acfp.m(2131707266));
        drq();
        continue;
        this.imageView.setVisibility(8);
        this.TX.setVisibility(8);
        this.TY.setVisibility(8);
        this.AH.setVisibility(8);
        this.kN.setVisibility(8);
        this.nM.setVisibility(8);
        this.DF.setVisibility(8);
        this.itemView.setContentDescription(acfp.m(2131707267));
      }
    }
    
    public void PF(int paramInt)
    {
      PD(paramInt);
    }
    
    public void X(Drawable paramDrawable)
    {
      if (paramDrawable != null)
      {
        if (HotPicPageView.isMainThread()) {
          this.imageView.setImageDrawable(paramDrawable);
        }
      }
      else {
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.1(this, paramDrawable));
    }
    
    public void Y(Drawable paramDrawable)
    {
      if (paramDrawable != null)
      {
        if (HotPicPageView.isMainThread()) {
          this.backgroundView.setImageDrawable(paramDrawable);
        }
      }
      else {
        return;
      }
      ThreadManager.getUIHandler().post(new HotPicPageView.MyVideoViewHolder.5(this, paramDrawable));
    }
    
    public HotVideoData a()
    {
      if (this.he == null) {
        return null;
      }
      return (HotVideoData)this.he.get();
    }
    
    public HotVideoMongoliaRelativeLayout a()
    {
      if ((this.kK == null) || (this.kK.getChildCount() == 0)) {
        return null;
      }
      View localView = this.kK.findViewWithTag("HotVideoControlTag");
      if (localView == null) {
        return null;
      }
      if ((localView instanceof HotVideoMongoliaRelativeLayout)) {
        return (HotVideoMongoliaRelativeLayout)localView;
      }
      return null;
    }
    
    public void a(HotVideoData paramHotVideoData)
    {
      if (paramHotVideoData == null)
      {
        this.he = null;
        return;
      }
      this.he = new WeakReference(paramHotVideoData);
    }
    
    public boolean a(HotVideoData paramHotVideoData)
    {
      if (paramHotVideoData == null) {}
      HotVideoData localHotVideoData;
      do
      {
        return false;
        localHotVideoData = a();
      } while (localHotVideoData == null);
      return localHotVideoData.equals(paramHotVideoData);
    }
    
    public void drp()
    {
      drr();
      HotVideoMongoliaRelativeLayout localHotVideoMongoliaRelativeLayout = a();
      if (localHotVideoMongoliaRelativeLayout != null)
      {
        localHotVideoMongoliaRelativeLayout.setVidoeControlListener(null);
        localHotVideoMongoliaRelativeLayout.setControlStateListener(null);
        if (HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c == this) {
          HotPicPageView.this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView$c = null;
        }
        this.kK.removeView(localHotVideoMongoliaRelativeLayout);
      }
    }
    
    public void drq()
    {
      ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, 1000 });
      localValueAnimator.setTarget(this.itemView);
      localValueAnimator.setDuration(500L);
      localValueAnimator.addUpdateListener(new ahzk(this));
      localValueAnimator.start();
    }
    
    public void drr()
    {
      this.itemView.clearAnimation();
    }
    
    public void drs()
    {
      this.imageView.setImageDrawable(new ColorDrawable(0));
      this.imageView.setVisibility(0);
      this.mPlayState = -10;
      drp();
      drt();
      this.nM.setVisibility(8);
      this.kN.setVisibility(8);
      this.AH.setVisibility(8);
      this.DF.setVisibility(8);
      this.TX.setVisibility(0);
      this.TY.setVisibility(0);
      this.AH.setVisibility(0);
    }
    
    public void drt()
    {
      this.backgroundView.setImageDrawable(new ColorDrawable(0));
    }
    
    public void onClick(View paramView)
    {
      if ((this.b != null) && ((this.mPlayState == 0) || (this.mPlayState == -11))) {
        this.b.a(this, getPosition());
      }
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (this.mPlayState == 1) {
          PD(0);
        }
      }
    }
    
    public void onFileDownloadFailed(int paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadFailed");
      }
      HotVideoData localHotVideoData = a();
      if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramInt)) {
        PD(-10);
      }
      HotPicPageView.this.jdField_a_of_type_Ahzw.drC();
    }
    
    public void onFileDownloadStarted()
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadStarted");
      }
      a();
    }
    
    public void onFileDownloadSucceed(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HotPicManagerHotPicPageView", 2, "HotPreview Download onFileDownloadSucceed");
      }
      HotVideoData localHotVideoData = a();
      if ((localHotVideoData != null) && (localHotVideoData.picIndex == paramLong))
      {
        if (this.mPlayState == -10) {
          PD(0);
        }
        if (localHotVideoData.CheckIsNeedBlurBackground())
        {
          Y(new ColorDrawable(Color.parseColor("#7f000000")));
          if ((Build.VERSION.SDK_INT >= 17) && (HotPicPageView.this.aoC()) && (HotPicPageView.this.jdField_a_of_type_Ahzp != null)) {
            HotPicPageView.this.jdField_a_of_type_Ahzp.a(this, localHotVideoData);
          }
        }
      }
      HotPicPageView.this.jdField_a_of_type_Ahzw.drC();
    }
    
    public boolean onLongClick(View paramView)
    {
      return false;
    }
  }
  
  public class d
    extends RecyclerView.ViewHolder
    implements View.OnClickListener, View.OnLongClickListener
  {
    ahzx b;
    public ImageView imageView;
    
    public d(View paramView, ahzx paramahzx)
    {
      super();
      if (paramahzx != null)
      {
        this.b = paramahzx;
        this.imageView = ((ImageView)paramView.findViewById(2131368658));
        this.imageView.setTag("HotPicControlTag");
        this.itemView.setOnClickListener(this);
        this.itemView.setOnLongClickListener(this);
        this.itemView.setOnTouchListener(paramahzx);
      }
    }
    
    public void onClick(View paramView)
    {
      if (this.b != null) {
        this.b.onItemClick(paramView, getPosition());
      }
      EventCollector.getInstance().onViewClicked(paramView);
    }
    
    public boolean onLongClick(View paramView)
    {
      boolean bool = false;
      if (this.b != null)
      {
        this.b.N(paramView, getPosition());
        bool = true;
      }
      return bool;
    }
  }
  
  public static abstract interface e
  {
    public abstract boolean a(View paramView, String paramString, HotPicData paramHotPicData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView
 * JD-Core Version:    0.7.0.1
 */