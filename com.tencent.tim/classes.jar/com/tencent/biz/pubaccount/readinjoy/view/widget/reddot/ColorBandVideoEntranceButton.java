package com.tencent.biz.pubaccount.readinjoy.view.widget.reddot;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import aqcx;
import awit;
import com.tencent.biz.pubaccount.readinjoy.view.KanDianUrlRoundCornerImageView;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngDrawable.OnPlayRepeatListener;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import kxm;
import lcc;
import lce;
import mfj;
import mfs;
import mfs.a;
import mqq.app.AppRuntime;
import nso;
import nsp;
import nsq;
import nsr;
import nss;
import nst;
import oax;
import wja;

public class ColorBandVideoEntranceButton
  extends FrameLayout
  implements View.OnClickListener, URLDrawable.URLDrawableListener2, mfs.a
{
  private AnimatorSet F;
  private AnimatorSet G;
  private boolean aur;
  public boolean aus;
  private boolean aut;
  private boolean auu;
  private boolean auv;
  private ApngDrawable.OnPlayRepeatListener jdField_b_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener;
  private nss jdField_b_of_type_Nss;
  Animator c;
  private View.OnClickListener cB;
  Animator d;
  Runnable dc = new ColorBandVideoEntranceButton.7(this);
  Animator e;
  Animator f;
  protected KanDianUrlRoundCornerImageView f;
  private RelativeLayout fA;
  private RelativeLayout fz;
  private KanDianUrlRoundCornerImageView g;
  private ImageView kY;
  private ImageView kZ;
  protected URLDrawable l;
  protected ImageView la;
  protected ImageView lb;
  private ImageView lc;
  private ImageView ld;
  lce m = new nsq(this);
  protected Drawable mDefaultDrawable;
  private int mHeight;
  private Drawable mLoadingDrawable;
  private URLDrawable mURLDrawable;
  private int mWidth;
  private View mX;
  private TextView tJ;
  private TextView tK;
  private long ye;
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext)
  {
    super(paramContext);
    initViews();
  }
  
  public ColorBandVideoEntranceButton(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViews();
  }
  
  private boolean FZ()
  {
    return System.currentTimeMillis() - this.ye > 1000L;
  }
  
  private Drawable a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mDefaultDrawable = b();
    }
    for (;;)
    {
      return this.mDefaultDrawable;
      if (this.mDefaultDrawable == null) {
        this.mDefaultDrawable = b();
      }
    }
  }
  
  private void a(ApngDrawable paramApngDrawable)
  {
    if (this.jdField_b_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener == null) {
      this.jdField_b_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener = new nsr(this);
    }
    paramApngDrawable.setOnPlayRepeatListener(this.jdField_b_of_type_ComTencentImageApngDrawable$OnPlayRepeatListener);
    paramApngDrawable.repaly();
  }
  
  private void a(nst paramnst)
  {
    if (!this.aus) {}
    do
    {
      do
      {
        return;
      } while (paramnst == null);
      if ((this.tJ != null) && (!TextUtils.isEmpty(paramnst.title))) {
        this.tJ.setText(paramnst.title);
      }
    } while ((this.tK == null) || (TextUtils.isEmpty(paramnst.subTitle)));
    this.tK.setText(paramnst.title);
  }
  
  private void af(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (paramBoolean1) {
      localObject = this.fA;
    }
    for (;;)
    {
      try
      {
        localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
        int i = ((FrameLayout.LayoutParams)localObject).bottomMargin;
        int k = ((FrameLayout.LayoutParams)localObject).rightMargin;
        int j = ((FrameLayout.LayoutParams)localObject).width;
        localObject = (FrameLayout.LayoutParams)this.kY.getLayoutParams();
        k -= aqcx.dip2px(getContext(), 12.0F);
        i += j + (aqcx.dip2px(getContext(), 30.0F) - ((FrameLayout.LayoutParams)localObject).width);
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
        ((FrameLayout.LayoutParams)localObject).rightMargin = k;
        this.kY.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = (FrameLayout.LayoutParams)this.kZ.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).bottomMargin = i;
        ((FrameLayout.LayoutParams)localObject).rightMargin = k;
        this.kZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      catch (Exception localException)
      {
        QLog.d("ColorBandVideoEntranceButton", 1, "updateSkinPosition error!  msg=" + localException);
      }
      if (paramBoolean2) {
        localObject = this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
      } else {
        localObject = this.la;
      }
    }
  }
  
  private Drawable b()
  {
    if (!this.aus) {}
    for (int i = RecommendFeedsDiandianEntranceManager.qF();; i = 2130843619) {
      return getResources().getDrawable(i);
    }
  }
  
  private void b(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.clearAnimation();
    paramView.setScaleX(paramFloat);
    paramView.setScaleX(paramFloat);
  }
  
  private void baH()
  {
    if ((this.mX == null) || (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) || (this.la == null)) {
      return;
    }
    this.mX.setScaleX(0.2F);
    this.mX.setScaleY(0.2F);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.2F);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.2F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.la, "translationX", new float[] { 0.0F, wja.dp2px(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.la, "translationY", new float[] { 0.0F, wja.dp2px(21.0F, getResources()) });
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.la, "scaleX", new float[] { 1.0F, 0.38F });
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.la, "scaleY", new float[] { 1.0F, 0.38F });
    this.F = new AnimatorSet();
    this.F.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, localObjectAnimator3, localObjectAnimator4 });
    this.F.setDuration(333L);
    this.G = new AnimatorSet();
    this.G.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.mX, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.mX, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.2F, 1.1F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.2F, 1.1F, 1.0F }) });
    this.G.setDuration(400L);
    localObjectAnimator1.addUpdateListener(new nso(this));
    this.F.start();
  }
  
  private void baJ()
  {
    Object localObject = (mfs)kxm.getAppRuntime().getManager(261);
    mfj localmfj = ((mfs)localObject).a(3);
    if (localmfj != null) {
      this.kY.setImageDrawable(localmfj.getDrawable());
    }
    localObject = ((mfs)localObject).a(2);
    if (localObject != null) {
      this.kZ.setImageDrawable(((mfj)localObject).getDrawable());
    }
  }
  
  private void baL()
  {
    baO();
    baG();
  }
  
  private void baM()
  {
    if (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView == null) {
      return;
    }
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleX(0.3F);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setScaleY(0.3F);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleX", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }), ObjectAnimator.ofFloat(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView, "scaleY", new float[] { 0.3F, 1.1F, 0.8F, 1.0F }) });
    localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
    localAnimatorSet.setDuration(400L);
    localAnimatorSet.start();
  }
  
  private void baO()
  {
    if ((this.F != null) && (this.F.isRunning())) {
      this.F.cancel();
    }
    if ((this.G != null) && (this.G.isRunning())) {
      this.G.cancel();
    }
  }
  
  private void baR()
  {
    if (awit.aMQ()) {
      if (!this.aus)
      {
        this.aus = true;
        qc(this.aus);
        this.jdField_b_of_type_Nss = null;
        this.auv = false;
      }
    }
    while (!this.aus) {
      return;
    }
    this.aus = false;
    qc(this.aus);
  }
  
  private void baS()
  {
    if (this.c == null) {
      this.c = AnimatorInflater.loadAnimator(getContext(), 2130903042);
    }
    if (this.d == null) {
      this.d = AnimatorInflater.loadAnimator(getContext(), 2130903043);
    }
    if (this.e == null) {
      this.e = AnimatorInflater.loadAnimator(getContext(), 2130903044);
    }
    if (this.jdField_f_of_type_AndroidAnimationAnimator == null) {
      this.jdField_f_of_type_AndroidAnimationAnimator = AnimatorInflater.loadAnimator(getContext(), 2130903041);
    }
  }
  
  private void baT()
  {
    b(this.lc, 1.0F);
    b(this.fz, 0.0F);
    b(this.g, 0.0F);
    b(this.ld, 0.0F);
  }
  
  private void c(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof ApngDrawable))
    {
      this.lc.setImageDrawable(paramURLDrawable);
      if ((this.jdField_b_of_type_Nss instanceof nst)) {
        this.auu = true;
      }
    }
    for (;;)
    {
      if ((this.aut) && (this.auu))
      {
        paramURLDrawable = this.lc.getDrawable();
        if ((paramURLDrawable instanceof ApngDrawable))
        {
          a((ApngDrawable)paramURLDrawable);
          this.aut = false;
          this.auu = false;
        }
      }
      return;
      this.auv = true;
      continue;
      this.g.setImageDrawable(paramURLDrawable);
      this.aut = true;
    }
  }
  
  private void dk(View paramView)
  {
    if (FZ())
    {
      this.ye = System.currentTimeMillis();
      baK();
      this.aur = false;
      this.mURLDrawable = null;
      if (this.cB != null) {
        this.cB.onClick(paramView);
      }
    }
  }
  
  private void f(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = this.mLoadingDrawable;
      localURLDrawableOptions.mRequestWidth = this.mWidth;
      localURLDrawableOptions.mRequestHeight = this.mHeight;
      if (paramBoolean1)
      {
        localURLDrawableOptions.mUseApngImage = true;
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_loop", 1);
        localURLDrawableOptions.mExtraInfo = localBundle;
      }
      paramString = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
    } while (!paramBoolean2);
    if (paramString.getStatus() == 1)
    {
      onLoadSuccessed(paramString);
      return;
    }
    paramString.setURLDrawableListener(this);
    paramString.startDownload();
  }
  
  private void initViews()
  {
    inflate(getContext(), 2131560282, this);
    this.mX = findViewById(2131381905);
    this.la = ((ImageView)findViewById(2131376752));
    this.la.setOnClickListener(this);
    this.lb = ((ImageView)findViewById(2131369879));
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView = ((KanDianUrlRoundCornerImageView)findViewById(2131376753));
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setOnClickListener(this);
    l(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
    this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.mWidth / 2);
    this.kY = ((ImageView)findViewById(2131381946));
    this.kZ = ((ImageView)findViewById(2131381945));
    this.mLoadingDrawable = getResources().getDrawable(2130841149);
    baJ();
    this.lc = ((ImageView)findViewById(2131364942));
    this.g = ((KanDianUrlRoundCornerImageView)findViewById(2131364936));
    this.ld = ((ImageView)findViewById(2131377002));
    this.fz = ((RelativeLayout)findViewById(2131364946));
    this.fA = ((RelativeLayout)findViewById(2131364945));
    this.tJ = ((TextView)findViewById(2131364950));
    this.tK = ((TextView)findViewById(2131364949));
  }
  
  private void j(nss paramnss)
  {
    post(new ColorBandVideoEntranceButton.4(this, paramnss));
  }
  
  private void k(nss paramnss)
  {
    if (paramnss == null) {
      return;
    }
    if (paramnss.yT())
    {
      l(paramnss);
      return;
    }
    preloadImage(paramnss.getCoverUrl());
  }
  
  private void l(ImageView paramImageView)
  {
    paramImageView = paramImageView.getLayoutParams();
    this.mWidth = paramImageView.width;
    this.mHeight = paramImageView.height;
    if (QLog.isColorLevel()) {
      QLog.d("ColorBandVideoEntranceButton", 2, "initCoverImageSize, width: " + this.mWidth + ", height: " + this.mHeight);
    }
  }
  
  private void l(nss paramnss)
  {
    if (paramnss == null) {}
    do
    {
      return;
      if (!this.aus) {
        break;
      }
    } while (!(paramnss instanceof nst));
    a((nst)paramnss);
    baT();
    f(true, nst.anC, true);
    f(false, paramnss.getCoverUrl(), true);
    return;
    if (paramnss.yS())
    {
      if (!TextUtils.isEmpty(paramnss.hZ())) {}
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions1 = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions1.mLoadingDrawable = this.mLoadingDrawable;
          localURLDrawableOptions1.mRequestWidth = this.mWidth;
          localURLDrawableOptions1.mRequestHeight = this.mHeight;
          localURLDrawableOptions1.mPlayGifImage = true;
          this.mURLDrawable = URLDrawable.getDrawable(paramnss.hZ(), localURLDrawableOptions1);
          this.mURLDrawable.setURLDrawableListener(this);
          this.mURLDrawable.startDownload();
          preloadImage(paramnss.getCoverUrl());
          return;
        }
        catch (Exception localException1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException1.getMessage());
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
        }
      }
    }
    Object localObject = paramnss.getCoverUrl();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "rawUrl: " + (String)localObject);
      }
      localObject = kxm.c((String)localObject, this.mWidth, this.mHeight);
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "showCover(): startDownload smartCutUrl: " + (String)localObject + "，mWidth:" + this.mWidth + ", mHeight:" + this.mHeight);
      }
    }
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions2.mLoadingDrawable = this.mLoadingDrawable;
        localURLDrawableOptions2.mRequestWidth = this.mWidth;
        localURLDrawableOptions2.mRequestHeight = this.mHeight;
        this.mURLDrawable = URLDrawable.getDrawable((String)localObject, localURLDrawableOptions2);
        if ((this.mURLDrawable.getStatus() != 1) || (!(this.mURLDrawable.getCurrDrawable() instanceof RegionDrawable))) {
          continue;
        }
        onLoadSuccessed(this.mURLDrawable);
        paramnss.setCoverUrl((String)localObject);
      }
      catch (Exception localException2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ColorBandVideoEntranceButton", 2, "url error: " + localException2.getMessage());
        continue;
      }
      if ((!paramnss.yU()) || (TextUtils.isEmpty(paramnss.ia()))) {
        break;
      }
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = a(false);
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.mWidth;
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.mHeight;
      this.l = URLDrawable.getDrawable(paramnss.ia(), (URLDrawable.URLDrawableOptions)localObject);
      this.l.startDownload();
      return;
      this.mURLDrawable.setURLDrawableListener(this);
      this.mURLDrawable.startDownload();
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("ColorBandVideoEntranceButton", 2, "url is null");
      }
    }
  }
  
  private void preloadImage(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    if (!TextUtils.isEmpty(paramString))
    {
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = this.mWidth;
      localURLDrawableOptions.mRequestHeight = this.mHeight;
    }
    try
    {
      URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions).startDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ColorBandVideoEntranceButton", 2, "url format error: " + paramString);
    }
  }
  
  private void qc(boolean paramBoolean)
  {
    qd(paramBoolean);
    ImageView localImageView = this.la;
    int i;
    if (paramBoolean)
    {
      i = 8;
      localImageView.setVisibility(i);
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(4);
      this.mX.setVisibility(4);
      this.lb.setVisibility(4);
      if (!paramBoolean) {
        break label148;
      }
      lcc.a().b(this.m);
      this.fz.setOnClickListener(this);
      this.fA.setOnClickListener(this);
      baS();
      l(this.g);
      this.g.setCorner(this.mWidth / 2);
    }
    for (;;)
    {
      a(true);
      af(this.aus, false);
      QLog.d("ColorBandVideoEntranceButton", 1, "showColumnDiandian! showColumnDiandian=" + paramBoolean);
      return;
      i = 0;
      break;
      label148:
      l(this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView);
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setCorner(this.mWidth / 2);
      lcc.a().c(this.m);
    }
  }
  
  private void qd(boolean paramBoolean)
  {
    this.lc.setImageDrawable(b());
    ImageView localImageView = this.lc;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localImageView.setVisibility(i);
      b(this.fz, 0.0F);
      b(this.g, 0.0F);
      b(this.ld, 0.0F);
      removeCallbacks(this.dc);
      this.fz.setClickable(false);
      return;
    }
  }
  
  public nss a()
  {
    return this.jdField_b_of_type_Nss;
  }
  
  public void baG()
  {
    baN();
    this.aur = false;
    af(this.aus, false);
  }
  
  public void baI()
  {
    if ((this.la != null) && (!this.aus)) {
      onClick(this.la);
    }
  }
  
  protected void baK()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { ObjectAnimator.ofFloat(this, "scaleX", new float[] { 1.0F, 0.5F, 1.0F }), ObjectAnimator.ofFloat(this, "scaleY", new float[] { 1.0F, 0.5F, 1.0F }) });
    int[] arrayOfInt1 = new int[2];
    getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    Object localObject = this.mX;
    if (this.aus) {
      localObject = this.fA;
    }
    ((View)localObject).getLocationOnScreen(arrayOfInt2);
    setPivotX(arrayOfInt2[0] - arrayOfInt1[0] + this.mWidth / 2);
    setPivotY(arrayOfInt2[1] - arrayOfInt1[1] + this.mHeight / 2);
    localAnimatorSet.setDuration(600L);
    localAnimatorSet.setInterpolator(new OvershootInterpolator());
    localAnimatorSet.addListener(new nsp(this));
    localAnimatorSet.start();
  }
  
  protected void baN()
  {
    if (this.aus)
    {
      qd(this.aus);
      return;
    }
    if (this.mX.getVisibility() == 0) {
      this.mX.setVisibility(4);
    }
    if (this.la.getVisibility() != 0) {
      this.la.setVisibility(0);
    }
    this.la.setTranslationX(0.0F);
    this.la.setTranslationY(0.0F);
    this.la.setScaleX(1.0F);
    this.la.setScaleY(1.0F);
    if ((this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 8))
    {
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(8);
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(null);
    }
    this.la.setImageDrawable(a(false));
  }
  
  public void baP()
  {
    if ((this.jdField_b_of_type_Nss != null) && (this.jdField_b_of_type_Nss.yS()))
    {
      AbstractGifImage.pauseAll();
      oax.bcZ();
    }
  }
  
  public void baQ()
  {
    if ((this.jdField_b_of_type_Nss != null) && (this.jdField_b_of_type_Nss.yS()))
    {
      AbstractGifImage.resumeAll();
      oax.bcY();
    }
  }
  
  public void baU()
  {
    if ((this.fz != null) && ((this.jdField_b_of_type_Nss instanceof nst)))
    {
      baS();
      this.fz.setClickable(true);
      this.fz.setPivotX(this.fz.getWidth());
      this.fz.setPivotY(this.fz.getHeight() / 2);
      this.c.setTarget(this.fz);
      this.c.start();
      this.d.setTarget(this.g);
      this.d.start();
      this.e.setTarget(this.ld);
      this.e.start();
      postDelayed(this.dc, 3000L);
    }
  }
  
  public void d(int paramInt, String paramString, boolean paramBoolean)
  {
    baJ();
  }
  
  public View getAnchorView()
  {
    return this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView;
  }
  
  public int getCoverWidth()
  {
    return this.mWidth;
  }
  
  public ImageView i()
  {
    return this.lb;
  }
  
  public void i(nss paramnss)
  {
    if (paramnss != null) {
      j(paramnss);
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
      dk(paramView);
      continue;
      paramView.setTag(Integer.valueOf(nst.bcj));
      dk(paramView);
    }
  }
  
  public void onDestroy()
  {
    lcc.a().c(this.m);
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    this.mURLDrawable = null;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadCanceled");
    }
    this.mURLDrawable = null;
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ColorBandVideoEntranceButton", 2, "onLoadFialed: " + paramThrowable.getMessage());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ColorBandVideoEntranceButton", 2, "loadSuccess, start setImage, dataSource=" + this.jdField_b_of_type_Nss);
    }
    if (this.aus) {
      c(paramURLDrawable);
    }
    while (this.jdField_b_of_type_Nss == null) {
      return;
    }
    if ((this.mX != null) && (this.mX.getVisibility() != 0)) {
      this.mX.setVisibility(0);
    }
    if ((this.la != null) && (this.la.getVisibility() != 0)) {
      this.la.setVisibility(0);
    }
    if ((this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null) && (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.getVisibility() != 0)) {
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setVisibility(0);
    }
    if (this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView != null)
    {
      this.jdField_f_of_type_ComTencentBizPubaccountReadinjoyViewKanDianUrlRoundCornerImageView.setImageDrawable(paramURLDrawable);
      if (this.aur) {
        break label221;
      }
      baH();
      this.aur = true;
    }
    for (;;)
    {
      af(this.aus, true);
      if ((this.la != null) && (this.jdField_b_of_type_Nss.yU()) && (!TextUtils.isEmpty(this.jdField_b_of_type_Nss.ia()))) {
        this.la.setImageDrawable(this.l);
      }
      this.mURLDrawable = null;
      return;
      label221:
      baM();
    }
  }
  
  public void onResume()
  {
    baR();
    if (this.jdField_b_of_type_Nss == null)
    {
      baO();
      baN();
      if ((!this.auv) && (this.aus)) {
        f(true, nst.anD, true);
      }
    }
  }
  
  public int qT()
  {
    return this.mHeight;
  }
  
  public void setDataSource(nss paramnss)
  {
    this.jdField_b_of_type_Nss = paramnss;
  }
  
  public void setDefaultDrawable(Drawable paramDrawable)
  {
    this.mDefaultDrawable = paramDrawable;
    this.la.setImageDrawable(this.mDefaultDrawable);
  }
  
  public void setDefaultIconBigMode(int paramInt1, int paramInt2)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.la.getLayoutParams();
    localLayoutParams.width = wja.dp2px(paramInt1, getContext().getResources());
    localLayoutParams.height = wja.dp2px(paramInt2, getContext().getResources());
    this.la.setLayoutParams(localLayoutParams);
  }
  
  public void setNotMsg()
  {
    post(new ColorBandVideoEntranceButton.1(this));
  }
  
  public void setOnVideoCoverClickListener(View.OnClickListener paramOnClickListener)
  {
    this.cB = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton
 * JD-Core Version:    0.7.0.1
 */