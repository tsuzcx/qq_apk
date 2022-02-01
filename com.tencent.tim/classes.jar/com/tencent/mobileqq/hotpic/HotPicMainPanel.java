package com.tencent.mobileqq.hotpic;

import abrb;
import ahyv;
import ahyx;
import ahyy;
import ahyz;
import ahza;
import ahzb;
import ahzc;
import ahzd;
import ahzd.b;
import ahze;
import alul;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import anot;
import aoop;
import aqiw;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.a;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.XPanelContainer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import wja;

@TargetApi(15)
public class HotPicMainPanel
  extends RelativeLayout
  implements ahzd.b, Handler.Callback, AdapterView.OnItemClickListener, PanelIconLinearLayout.a, HotPicPanelViewPagerAdapter.a, HotPicRecyclerView.a
{
  public static final int bQT;
  public static final int bsz;
  public static final int cZI;
  public View DC;
  protected View DD;
  protected ahyx a;
  protected PanelIconLinearLayout a;
  protected HotPicPanelViewPagerAdapter a;
  protected HotPicTab a;
  protected int bQS;
  int cSl;
  protected boolean cjf;
  Set<String> cy = new HashSet();
  public int dcy;
  public XPanelContainer f;
  public PopupWindow k;
  protected BaseActivity mActivity;
  public QQAppInterface mApp;
  protected Context mContext;
  protected View mLoadingView;
  protected SessionInfo mSessionInfo;
  public Handler mUiHandler = new auru(Looper.getMainLooper(), this);
  public ViewPager mViewPager;
  float wb;
  
  static
  {
    Resources localResources = BaseApplicationImpl.sApplication.getResources();
    bQT = (int)(localResources.getDisplayMetrics().heightPixels * 0.6D);
    cZI = wja.dp2px(1.0F, localResources);
    bsz = (localResources.getDisplayMetrics().widthPixels - cZI * 6) / 2;
  }
  
  public HotPicMainPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Ahyx = new ahyx();
  }
  
  private boolean ajz()
  {
    return bQT > this.bQS;
  }
  
  private boolean aoz()
  {
    return (AppSetting.aHR.equalsIgnoreCase("oppo-x907")) || (Build.MODEL.toLowerCase().equals("mi 1s"));
  }
  
  private void dra()
  {
    ahzd.a(this.mApp).drf();
    this.DD.setVisibility(8);
  }
  
  @TargetApi(11)
  public boolean R(MotionEvent paramMotionEvent)
  {
    if (!ajz()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 2: 
      i = (int)(paramMotionEvent.getY() - this.wb + 0.5F);
      j = XPanelContainer.aLe;
      XPanelContainer.aLe -= i;
      if (XPanelContainer.aLe > bQT) {
        XPanelContainer.aLe = bQT;
      }
      while (XPanelContainer.aLe != j)
      {
        AbstractGifImage.pauseAll();
        this.f.requestLayout();
        break;
        if (XPanelContainer.aLe < this.bQS) {
          XPanelContainer.aLe = this.bQS;
        }
      }
    }
    int j = XPanelContainer.aLe;
    if ((j != bQT) && (j != this.bQS)) {
      if (j > this.cSl)
      {
        i = bQT;
        label154:
        if (Math.abs(j - this.cSl) <= 100) {
          break label273;
        }
        j = i;
        label170:
        if ((this.cSl == bQT) || (j != bQT)) {
          break label311;
        }
      }
    }
    label273:
    label309:
    label311:
    for (int i = 1;; i = 0)
    {
      paramMotionEvent = ValueAnimator.ofInt(new int[] { XPanelContainer.aLe, j });
      paramMotionEvent.setDuration(150L);
      paramMotionEvent.addUpdateListener(new ahzc(this, j));
      paramMotionEvent.start();
      for (;;)
      {
        if (i == 0) {
          break label309;
        }
        anot.a(this.mApp, "dc00898", "", "", "0X8007B21", "0X8007B21", 0, 0, "", "", "", "");
        break;
        i = this.bQS;
        break label154;
        j = this.cSl;
        break label170;
        AbstractGifImage.resumeAll();
        if ((this.cSl != bQT) && (j == bQT)) {
          i = 1;
        } else {
          i = 0;
        }
      }
      break;
    }
  }
  
  public boolean S(MotionEvent paramMotionEvent)
  {
    if (!ajz()) {}
    float f1;
    int i;
    do
    {
      do
      {
        return false;
        switch (paramMotionEvent.getAction())
        {
        }
      } while (getParent() == null);
      getParent().requestDisallowInterceptTouchEvent(false);
      return false;
      this.wb = paramMotionEvent.getY();
      this.cSl = XPanelContainer.aLe;
      return false;
      f1 = paramMotionEvent.getY();
      i = (int)(f1 - this.wb + 0.5F);
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null) || (Math.abs(i) <= this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.getHeight() * 0.6F));
    this.wb = f1;
    return true;
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatPie paramBaseChatPie, PanelIconLinearLayout paramPanelIconLinearLayout, XPanelContainer paramXPanelContainer)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.mActivity = paramBaseChatPie.mActivity;
    this.mSessionInfo = paramBaseChatPie.sessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
    this.f = paramXPanelContainer;
    this.mLoadingView = findViewById(2131370787);
    this.DD = findViewById(2131368657);
    this.DC = LayoutInflater.from(paramContext).inflate(2131558659, null);
    this.DC.setVisibility(8);
    this.mViewPager = ((ViewPager)findViewById(2131368663));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab = ((HotPicTab)findViewById(2131368644));
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    setId(2131362408);
  }
  
  @TargetApi(14)
  protected void aM(int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.setDuration(paramInt1);
    localValueAnimator.addUpdateListener(new ahyy(this));
    localValueAnimator.start();
  }
  
  public void aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    Message localMessage = this.mUiHandler.obtainMessage(paramInt1);
    localMessage.arg1 = paramInt2;
    localMessage.arg2 = paramInt3;
    this.mUiHandler.sendMessage(localMessage);
  }
  
  @TargetApi(16)
  protected boolean aoy()
  {
    bool1 = true;
    Object localObject1;
    Object localObject2;
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 16)
    {
      localObject1 = (ActivityManager)this.mActivity.getSystemService("activity");
      localObject2 = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject1).getMemoryInfo((ActivityManager.MemoryInfo)localObject2);
      if (((ActivityManager.MemoryInfo)localObject2).totalMem < 1073741824L)
      {
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice mi.totalMem is " + ((ActivityManager.MemoryInfo)localObject2).totalMem + " limitHovVideoMemory is " + 1073741824L);
        }
        bool2 = bool1;
      }
    }
    do
    {
      return bool2;
      bool1 = false;
      break;
      long l3 = 0L;
      l2 = l3;
      try
      {
        localObject1 = new FileReader("/proc/meminfo");
        l2 = l3;
        localObject2 = new BufferedReader((Reader)localObject1, 2048);
        l2 = l3;
        String str = ((BufferedReader)localObject2).readLine();
        l1 = l3;
        if (str != null)
        {
          l2 = l3;
          str = str.substring(str.indexOf("MemTotal:"));
          l1 = l3;
          if (str != null)
          {
            l2 = l3;
            l1 = Integer.parseInt(str.replaceAll("\\D+", "")) * 1024L;
          }
        }
        l2 = l1;
        ((BufferedReader)localObject2).close();
        l2 = l1;
        ((FileReader)localObject1).close();
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          localIOException.printStackTrace();
          long l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice has IOException", localIOException);
            l1 = l2;
            continue;
            bool1 = false;
          }
        }
      }
      if (l1 >= 1073741824L) {
        break label326;
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "isLowPerformanceDevice totalMem is " + l1 + " limitHovVideoMemory is " + 1073741824L);
    return bool1;
  }
  
  public void c(HotPicData paramHotPicData)
  {
    ImageView localImageView = (ImageView)this.DC.findViewById(2131368656);
    Object localObject = (ViewGroup.MarginLayoutParams)localImageView.getLayoutParams();
    int j = paramHotPicData.width;
    int m = paramHotPicData.height;
    int i = (int)(bsz * 1.5F + 0.5F);
    float f1 = j / i;
    j = (int)(m / f1 + 0.5F);
    ((ViewGroup.MarginLayoutParams)localObject).width = i;
    ((ViewGroup.MarginLayoutParams)localObject).height = j;
    i = (int)(160.0F / f1 + 0.5F);
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aoop.TRANSPARENT;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
    ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramHotPicData;
    URL localURL = ahze.h(paramHotPicData.originalUrl);
    if (localURL == null) {
      return;
    }
    localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
    ((URLDrawable)localObject).setTargetDensity(i);
    localImageView.setImageDrawable((Drawable)localObject);
    if ((((URLDrawable)localObject).getStatus() == 2) && (aqiw.isNetworkAvailable(this.mContext))) {
      ((URLDrawable)localObject).restartDownload();
    }
    if (this.k == null)
    {
      i = getResources().getDisplayMetrics().widthPixels;
      j = getRootView().getHeight();
      this.k = new PopupWindow(this.DC, i, j);
    }
    if (!this.k.isShowing()) {
      this.k.showAtLocation(this, 0, 0, 0);
    }
    this.DC.setVisibility(0);
    if (ahyv.f(paramHotPicData.originalUrl).exists())
    {
      gR(localImageView);
      return;
    }
    ((URLDrawable)localObject).setDownloadListener(new ahyz(this, localImageView));
  }
  
  public void cZu()
  {
    if (!ajz()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.aLe != this.bQS);
      aM(200, XPanelContainer.aLe, bQT);
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "onPullUp");
  }
  
  public void cZv()
  {
    if (!ajz()) {}
    do
    {
      do
      {
        return;
      } while (XPanelContainer.aLe != bQT);
      aM(250, XPanelContainer.aLe, this.bQS);
    } while (!QLog.isColorLevel());
    QLog.d("HotPicManager.Panel", 2, "onPullDown");
  }
  
  public void dqW()
  {
    abrb.b(this.mApp, "hot_pic", true);
  }
  
  public void dqX()
  {
    abrb.b(this.mApp, "hot_pic", false);
  }
  
  @TargetApi(11)
  public void dqY()
  {
    Object localObject = (ImageView)this.DC.findViewById(2131368656);
    if (aoz())
    {
      if ((this.k != null) && (this.k.isShowing())) {
        this.k.dismiss();
      }
      this.DC.setVisibility(8);
    }
    while (!VersionUtils.isHoneycomb()) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "scaleX", new float[] { 1.0F, 0.4F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "scaleY", new float[] { 1.0F, 0.4F });
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F, 0.1F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with((Animator)localObject);
    localAnimatorSet.setDuration(200L);
    localAnimatorSet.setInterpolator(new LinearInterpolator());
    localAnimatorSet.addListener(new ahza(this));
    localAnimatorSet.start();
  }
  
  protected void dqZ()
  {
    if ((!ahzd.a(this.mApp).cjg) || (!ahzd.a(this.mApp).kc(2))) {
      return;
    }
    this.DD.setVisibility(0);
    this.DD.setOnTouchListener(new ahzb(this));
  }
  
  public void gR(View paramView)
  {
    if (aoz())
    {
      paramView.setVisibility(0);
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.2F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.2F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.4F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(paramView);
    localAnimatorSet.setDuration(500L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.start();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.arg1;
    int j = paramMessage.arg2;
    if ((getVisibility() == 8) || (this.jdField_a_of_type_Ahyx.a(i) == null)) {}
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "handleMessage, tagHotPic = " + i + ", version = " + j + ", msg = " + paramMessage.what + ", index = " + this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.Fv());
      }
      if (paramMessage.what == 8)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.iq(i, paramMessage.what);
          return true;
        }
      }
      else if (this.jdField_a_of_type_Ahyx.a(i).version == j)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.iq(i, paramMessage.what);
        }
        if ((aqiw.isNetworkAvailable(this.mContext)) && (paramMessage.what == 7))
        {
          i = this.jdField_a_of_type_Ahyx.a(i).position + 1;
          while (i < this.jdField_a_of_type_Ahyx.size())
          {
            j = this.jdField_a_of_type_Ahyx.b(i).tagId;
            if (j != -20) {
              break label237;
            }
            i += 1;
          }
        }
      }
    }
    label237:
    ahzd.a(this.mApp).Pz(j);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      anot.a(this.mApp, "dc00898", "", "", "0X8007B12", "0X8007B12", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
      this.mViewPager.setCurrentItem(paramInt);
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        anot.a(this.mApp, "dc00898", "", "", "0X8007B13", "0X8007B13", 0, 0, "", "", "", "");
      } else if ((this.jdField_a_of_type_Ahyx.size() > paramInt) && (this.jdField_a_of_type_Ahyx.b(paramInt).tagType == 2)) {
        anot.a(this.mApp, "dc00898", "", "", "0X8007ED3", "0X8007ED3", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    HotPicPageView.cjn = true;
    dra();
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.Fv() != paramInt) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setSelection(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.PG(paramInt);
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_Ahyx.b(paramInt);
    if (localHotPicTagInfo != null) {
      anot.a(this.mApp, "dc00898", "", "", "0X8008076", "0X8008076", 0, 0, paramInt + "", "", localHotPicTagInfo.tagName, "");
    }
  }
  
  public void onPause()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab == null) || (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter == null)) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.Fv();
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.PH(i);
  }
  
  @TargetApi(16)
  public void onShow()
  {
    this.bQS = XPanelContainer.aLe;
    boolean bool;
    ahzd localahzd;
    if (bQT > this.bQS)
    {
      bool = true;
      this.cjf = bool;
      if (QLog.isColorLevel()) {
        QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.getRevision() + " init panelH " + this.bQS + " needExtendPanel" + this.cjf);
      }
      localahzd = ahzd.a(this.mApp);
      localahzd.a(this);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(this);
      }
      localahzd.drb();
      localahzd.dre();
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(localahzd.di());
      bool = aoy();
      if ((this.mSessionInfo.cZ != 1011) && (this.mSessionInfo.cZ != 1006) && (this.mSessionInfo.cZ != 1000) && (this.mSessionInfo.cZ != 10004) && (this.mSessionInfo.cZ != 1020) && (this.mSessionInfo.cZ != 1004) && (this.mSessionInfo.cZ != 1025) && (this.mSessionInfo.cZ != 1009) && (this.mSessionInfo.cZ != 1022) && (this.mSessionInfo.cZ != 1008) && (this.mSessionInfo.cZ != 10008)) {
        break label417;
      }
      i = 1;
    }
    label295:
    Object localObject2;
    for (;;)
    {
      if ((i != 0) || (bool))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotPicManager.Panel", 2, "onShow " + AppSetting.getRevision() + " isTempSession is true mSessionInfo.curType is " + this.mSessionInfo.cZ);
        }
        localObject2 = new ArrayList();
        Object localObject3 = ((ArrayList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            HotPicTagInfo localHotPicTagInfo = (HotPicTagInfo)((Iterator)localObject3).next();
            if (localHotPicTagInfo.tagType == 2)
            {
              ((ArrayList)localObject2).add(localHotPicTagInfo);
              continue;
              bool = false;
              break;
              label417:
              i = 0;
              break label295;
            }
          }
        }
        if (((ArrayList)localObject2).size() > 0)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (HotPicTagInfo)((Iterator)localObject2).next();
            if (((ArrayList)localObject1).contains(localObject3)) {
              ((ArrayList)localObject1).remove(localObject3);
            }
          }
        }
      }
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    int i = 0;
    int j = -1;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
      if (this.mSessionInfo.cZ == 1)
      {
        if (((HotPicTagInfo)localObject2).tagName.equals(alul.bYy)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(alul.bYx)) {
          this.dcy = (i + 2);
        }
      }
      if (this.mSessionInfo.cZ == 0)
      {
        if (((HotPicTagInfo)localObject2).tagName.equals(alul.bYx)) {
          continue;
        }
        if (((HotPicTagInfo)localObject2).tagName.equals(alul.bYy)) {
          this.dcy = (i + 2);
        }
      }
      this.jdField_a_of_type_Ahyx.a((HotPicTagInfo)localObject2);
      if (((HotPicTagInfo)localObject2).tagId == localahzd.dcz) {
        j = i;
      }
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter = new HotPicPanelViewPagerAdapter(this, this.mViewPager);
    this.mViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.mViewPager.setOnPageChangeListener(this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.X(this.jdField_a_of_type_Ahyx.fk(), j);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.setOnItemClickListener(this);
    if (j != -1) {
      this.mViewPager.setCurrentItem(j);
    }
    if (aqiw.isNetworkAvailable(this.mContext))
    {
      localObject1 = localahzd.di().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (HotPicTagInfo)((Iterator)localObject1).next();
        i = ((HotPicTagInfo)localObject2).tagId;
        j = ((HotPicTagInfo)localObject2).tagType;
        if ((i != 2) && (j != 255) && (!localahzd.kc(i))) {
          localahzd.Pz(i);
        }
      }
    }
    anot.a(this.mApp, "dc00898", "", "", "0X8007B11", "0X8007B11", 0, 0, "", "", "", "");
    if (this.mSessionInfo.cZ == 3000) {
      anot.a(this.mApp, "dc00898", "", "", "0X8007B15", "0X8007B15", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      dqW();
      dqZ();
      return;
      if (this.mSessionInfo.cZ == 1) {
        anot.a(this.mApp, "dc00898", "", "", "0X8007B16", "0X8007B16", 0, 0, "", "", "", "");
      } else {
        anot.a(this.mApp, "dc00898", "", "", "0X8007B14", "0X8007B14", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void yQ(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManager.Panel", 2, "onHide");
    }
    HotPicPageView.cjn = true;
    HotPicTagInfo localHotPicTagInfo = this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.a();
    if (localHotPicTagInfo != null) {
      ahzd.a(this.mApp).b(localHotPicTagInfo);
    }
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicTab.clear();
    if (!paramBoolean) {
      XPanelContainer.aLe = this.bQS;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setInterceptListener(null);
    }
    ahzd.a(this.mApp).a(null);
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPanelViewPagerAdapter.reset();
    this.mViewPager.setAdapter(null);
    this.mViewPager.removeAllViews();
    this.jdField_a_of_type_Ahyx.clear();
    this.cy.clear();
    ahzd.a(this.mApp).drd();
    setVisibility(8);
    dqX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel
 * JD-Core Version:    0.7.0.1
 */