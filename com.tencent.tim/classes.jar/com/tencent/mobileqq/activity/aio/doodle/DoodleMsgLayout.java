package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aoop;
import argt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.GifDrawable.OnGIFPlayOnceListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.scribble.ScribbleResMgr.ResInfo;
import com.tencent.mobileqq.scribble.ScribbleResMgr.b;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import wja;
import wrd;
import wrq;

public class DoodleMsgLayout
  extends RelativeLayout
  implements GifDrawable.OnGIFPlayOnceListener, DoodleMsgView.a, ScribbleResMgr.b
{
  private b jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b = new b();
  private DoodleMsgView jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView;
  private URLImageView ao;
  private URLImageView ap;
  private URLImageView aq;
  private int bRb;
  private int bRc;
  private int bRd;
  private boolean bfG;
  private boolean bfH;
  private boolean bfI;
  private URLDrawableDownListener d;
  private WeakReference<a> dQ;
  private RelativeLayout hv;
  private String mFile;
  private int mInitHeight;
  private boolean mPrepared;
  private int mState = 0;
  private ImageView sA;
  private ImageView sz;
  
  public DoodleMsgLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void CG(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "changeStateUI:" + this.mFile + " state:" + paramInt);
    }
    this.mState = paramInt;
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        return;
        aN(4, false);
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(4);
      return;
      aN(1, true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(4);
      }
      aN(2, false);
      aN(3, false);
      return;
      aN(1, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.clear();
      }
      aN(3, true);
      aN(2, false);
      return;
      aN(1, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setVisibility(0);
      }
    } while (!this.bfG);
    aN(3, false);
    aN(2, true);
  }
  
  private Drawable aA()
  {
    return aoop.getFailedDrawable();
  }
  
  private void aN(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 4)
    {
      aN(1, paramBoolean);
      aN(2, paramBoolean);
      aN(3, paramBoolean);
    }
    URLImageView localURLImageView;
    for (;;)
    {
      return;
      localURLImageView = null;
      if (paramInt == 1) {
        localURLImageView = this.ao;
      }
      while (localURLImageView != null)
      {
        if (paramBoolean) {
          break label77;
        }
        localURLImageView.setVisibility(8);
        return;
        if (paramInt == 2) {
          localURLImageView = this.ap;
        } else if (paramInt == 3) {
          localURLImageView = this.aq;
        }
      }
    }
    label77:
    if (this.bRb > 0)
    {
      localURLImageView.setVisibility(0);
      return;
    }
    localURLImageView.setVisibility(4);
  }
  
  private Bitmap aj()
  {
    if (BaseApplicationImpl.sImageCache != null) {}
    for (Bitmap localBitmap = (Bitmap)BaseApplicationImpl.sImageCache.get("aio_doodle_progress");; localBitmap = null)
    {
      if ((localBitmap == null) && (!this.bfI))
      {
        this.bfI = true;
        ThreadManager.post(new DoodleMsgLayout.2(this), 5, null, true);
      }
      return localBitmap;
    }
  }
  
  private void cbj()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.sA == null)
    {
      this.sA = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      this.sA.setLayoutParams(localLayoutParams);
      this.sA.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.sA.setClickable(false);
      addView(this.sA);
    }
    if (this.sz == null)
    {
      this.sz = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(wja.dp2px(19.0F, getResources()), wja.dp2px(19.0F, getResources()));
      localLayoutParams.addRule(13);
      this.sz.setLayoutParams(localLayoutParams);
      this.sz.setClickable(false);
      addView(this.sz);
    }
  }
  
  private void checkState()
  {
    CG(this.mState);
  }
  
  private void init()
  {
    QLog.d("DoodleMsgLayout", 2, "init begin");
    this.d = new wrd(this);
    Object localObject = getResources().getDisplayMetrics();
    int i = Math.min(((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels);
    int k = getResources().getDimensionPixelSize(2131296418);
    int m = getResources().getDimensionPixelSize(2131296420);
    int n = getResources().getDimensionPixelSize(2131296419);
    int i1 = getResources().getDimensionPixelSize(2131296417);
    this.bRd = ((int)(i * 0.544F));
    this.mInitHeight = ((int)(this.bRd * 1.0F / 1.133333F));
    int j = this.bRd - k - n;
    i = this.mInitHeight - i1 - m;
    if (j * 1.0F / i > 1.133333F) {
      j = (int)(i * 1.133333F);
    }
    for (;;)
    {
      if (this.aq == null)
      {
        this.aq = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        addView(this.aq, (ViewGroup.LayoutParams)localObject);
        aN(3, false);
      }
      if (this.ao == null)
      {
        this.ao = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        addView(this.ao, (ViewGroup.LayoutParams)localObject);
        this.ao.setURLDrawableDownListener(this.d);
        aN(1, false);
      }
      if (this.ap == null)
      {
        this.ap = new URLImageView(getContext());
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        addView(this.ap, (ViewGroup.LayoutParams)localObject);
        this.ap.setURLDrawableDownListener(this.d);
        aN(2, false);
      }
      QLog.d("DoodleMsgLayout", 2, "brefor crate DoodleMsgView ");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView = new DoodleMsgView(getContext(), null);
        localObject = new RelativeLayout.LayoutParams(j, i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        ((RelativeLayout.LayoutParams)localObject).setMargins(k, m, n, i1);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setBackgroundColor(getResources().getColor(2131167595));
        addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.a(this, j, i);
      }
      setLayoutParams(new RelativeLayout.LayoutParams(this.bRd, this.mInitHeight));
      return;
      i = (int)(j / 1.133333F);
    }
  }
  
  private void setTemplateID(int paramInt)
  {
    if (paramInt > 0)
    {
      this.bfG = false;
      Drawable localDrawable = wrq.a().a(1, paramInt, true);
      if ((localDrawable != null) && (this.ao != null))
      {
        this.ao.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).setIndividualPause(true);
      }
      localDrawable = wrq.a().a(2, paramInt, false);
      if ((this.aq != null) && (localDrawable != null))
      {
        this.aq.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).startDownload();
      }
      localDrawable = wrq.a().a(2, paramInt, true);
      if ((this.ap != null) && (localDrawable != null))
      {
        this.ap.setImageDrawable(localDrawable);
        ((URLDrawable)localDrawable).startDownload();
      }
      return;
    }
    if (this.ao != null) {
      this.ao.setImageDrawable(null);
    }
    if (this.aq != null) {
      this.aq.setImageDrawable(null);
    }
    if (this.ap != null) {
      this.ap.setImageDrawable(null);
    }
    this.bfG = true;
  }
  
  private void unInit()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.unInit();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView = null;
    }
    this.ao = null;
    this.aq = null;
    this.ap = null;
    this.d = null;
  }
  
  public void CH(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "onInitState:" + this.mFile + " state:" + paramInt);
    }
    a locala = null;
    if (this.dQ != null) {
      locala = (a)this.dQ.get();
    }
    if ((paramInt == -1) || (paramInt == 4) || (this.bRc == 2))
    {
      CG(0);
      this.bfH = false;
      if ((paramInt != -1) && (locala != null)) {
        locala.T(this, 2);
      }
      return;
    }
    if ((paramInt == 0) && (this.bRc == 0))
    {
      if (this.mPrepared) {
        CG(3);
      }
      for (;;)
      {
        if (locala != null) {
          locala.T(this, 0);
        }
        if (!this.bfH) {
          break;
        }
        play();
        return;
        CG(0);
      }
    }
    if (locala != null) {
      locala.T(this, 1);
    }
    QLog.i("DoodleMsgLayout", 2, "onLoadData end");
  }
  
  public boolean M(View paramView)
  {
    if (paramView == null) {}
    while ((paramView != this.ap) && (paramView != this.ao) && (paramView != this.aq) && (paramView != this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView)) {
      return false;
    }
    return true;
  }
  
  public void a(View paramView, int paramInt1, ScribbleResMgr.ResInfo paramResInfo, int paramInt2)
  {
    if ((paramResInfo == null) || (paramView == null) || (paramInt1 != 2) || (paramResInfo.sourceId != this.bRb)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DoodleMsgLayout", 2, "handleMessage begin:" + paramInt2);
    }
    if (1 == paramInt2)
    {
      this.bRc = 0;
      setTemplateID(this.bRb);
      label77:
      paramInt1 = getDataState();
      if (paramInt1 != 0) {
        break label202;
      }
      if (!this.mPrepared) {
        break label194;
      }
      CG(3);
    }
    for (;;)
    {
      paramView = null;
      if (this.dQ != null) {
        paramView = (a)this.dQ.get();
      }
      if (paramView != null)
      {
        paramView.T(this, paramInt1);
        QLog.i("DoodleMsgLayout", 2, "handleMessage end:" + paramInt1);
      }
      if ((paramInt1 != 0) || (!this.bfH)) {
        break;
      }
      play();
      return;
      if (4 == paramInt2)
      {
        this.bRc = 1;
        break label77;
      }
      this.bRc = 2;
      break label77;
      label194:
      CG(0);
      continue;
      label202:
      if ((paramInt1 == 2) || (paramInt1 == -1)) {
        CG(0);
      }
    }
  }
  
  public void aGs()
  {
    if ((this.bRb > 0) && (this.bRc != 0))
    {
      wrq.a().b(1, this.bRb, this, this);
      this.bRc = 1;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.aGs();
    }
  }
  
  public void buY()
  {
    CG(3);
    Drawable localDrawable;
    if (this.ap != null)
    {
      localDrawable = this.ap.getDrawable();
      if ((localDrawable instanceof URLDrawable))
      {
        ((URLDrawable)localDrawable).setIndividualPause(false);
        localDrawable = ((URLDrawable)localDrawable).getCurrDrawable();
        if ((localDrawable instanceof GifDrawable)) {
          ((GifDrawable)localDrawable).getImage().reset();
        }
      }
    }
    if (this.ao != null)
    {
      localDrawable = this.ao.getDrawable();
      if ((localDrawable instanceof URLDrawable)) {
        ((URLDrawable)localDrawable).setIndividualPause(false);
      }
    }
  }
  
  public void cbk()
  {
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin");
    cbj();
    QLog.d("DoodleMsgLayout", 2, "showLoadingStatus begin 1");
    if (this.sz != null) {
      if (this.sz.getDrawable() == null)
      {
        Object localObject = aj();
        if (localObject == null) {
          break label147;
        }
        localObject = new argt((Bitmap)localObject, 0, false);
        ((argt)localObject).setBounds(new Rect(0, 0, wja.dp2px(19.0F, getResources()), wja.dp2px(19.0F, getResources())));
        this.sz.setImageDrawable((Drawable)localObject);
      }
    }
    for (;;)
    {
      this.sz.setVisibility(0);
      if (this.sA != null) {
        this.sA.setVisibility(8);
      }
      if (this.hv != null) {
        this.hv.setVisibility(4);
      }
      QLog.d("DoodleMsgLayout", 2, "showLoadingStatus end");
      return;
      label147:
      QLog.d("DoodleMsgLayout", 2, "showLoadingStatus wait callback");
    }
  }
  
  public void cbl()
  {
    if (this.sz != null) {
      this.sz.setVisibility(8);
    }
    if (this.sA != null) {
      this.sA.setVisibility(8);
    }
    if (this.hv != null) {
      this.hv.setVisibility(4);
    }
  }
  
  public boolean d(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent :" + paramString + " GifID:" + paramInt + " prepare:" + paramBoolean);
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 0;
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = false;
      this.mFile = null;
      this.bRb = 0;
      this.bRc = 0;
      CG(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.clear();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(null, false);
      }
    }
    do
    {
      return false;
      if ((this.bRb != i) || (this.mFile == null) || (!this.mFile.equals(paramString))) {
        break label277;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = false;
      if (!isPlaying()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("DoodleMsgLayout", 2, "setDoodleContent isplaying, return:");
    return false;
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent same data, prepare old:" + this.mPrepared);
    }
    if ((this.bRb > 0) && (this.bRc == 2))
    {
      wrq.a().b(1, this.bRb, this, this);
      this.bRc = 1;
    }
    this.mPrepared = paramBoolean;
    CG(0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(paramString, paramBoolean);
    }
    return true;
    label277:
    if (QLog.isColorLevel()) {
      QLog.d("DoodleMsgLayout", 2, "setDoodleContent old data:" + this.mFile + " GifID:" + this.bRb + " prepare:" + this.mPrepared);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.mPause)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoodleMsgLayout", 2, "pending data, return");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.mFile = paramString;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bRb = i;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfF = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = true;
      CG(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.pause(true);
      }
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.pause(false);
    }
    this.mFile = paramString;
    this.mPrepared = paramBoolean;
    if (i > 0) {
      if (i == this.bRb) {
        if (QLog.isColorLevel()) {
          QLog.d("DoodleMsgLayout", 2, "setDoodleContent use same template:" + this.bRb + " status:" + this.bRc + "loopOK:" + this.bfG);
        }
      }
    }
    for (;;)
    {
      CG(0);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContent(paramString, paramBoolean);
      }
      return true;
      this.bRb = i;
      this.bRc = 1;
      this.bfG = false;
      ThreadManager.post(new DoodleMsgLayout.3(this, this.bRb), 5, null, true);
      continue;
      this.bRb = 0;
      this.bRc = 0;
      setTemplateID(i);
    }
  }
  
  public int getDataState()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.getDataState())
      {
      }
    }
    do
    {
      return 2;
      return -1;
      return this.bRc;
      if (this.bRc == 0) {
        return 1;
      }
    } while ((this.bRc == 2) || (this.bRc != 1));
    return 1;
  }
  
  public boolean isDataValid()
  {
    return !TextUtils.isEmpty(this.mFile);
  }
  
  public boolean isPlaying()
  {
    return (this.mState != 0) && (this.mState != 3);
  }
  
  protected void onDetachedFromWindow()
  {
    unInit();
    super.onDetachedFromWindow();
    QLog.i("DoodleMsgLayout", 2, "onDetachedFromWindow");
  }
  
  public void onPlayOnce()
  {
    CG(2);
    if (this.ao != null)
    {
      Drawable localDrawable = this.ao.getDrawable();
      if ((localDrawable != null) && ((localDrawable instanceof URLDrawable)))
      {
        ((URLDrawable)localDrawable).setIndividualPause(true);
        localDrawable = ((URLDrawable)localDrawable).getCurrDrawable();
        if ((localDrawable instanceof GifDrawable)) {
          ((GifDrawable)localDrawable).getImage().reset();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.play(100L);
    }
  }
  
  public void onPlayStart() {}
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0) {
      return;
    }
    stop();
  }
  
  public void pause(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.mPause = paramBoolean;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.pause(paramBoolean);
    }
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ)
      {
        if ((!d(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.mFile, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bRb, this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfF)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)) {
          CH(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.getDataState());
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = false;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bRb = this.bRb;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfF = this.mPrepared;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.mFile = this.mFile;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$b.bfJ = true;
  }
  
  public void play()
  {
    if (getDataState() != 0) {
      this.bfH = true;
    }
    do
    {
      do
      {
        return;
        if ((this.mState != 0) || (this.mState != 3)) {
          stop();
        }
        this.bfH = false;
        if (this.bRb <= 0) {
          break;
        }
      } while (this.ao == null);
      Drawable localDrawable1 = this.ao.getDrawable();
      if ((localDrawable1 != null) && ((localDrawable1 instanceof URLDrawable)))
      {
        Drawable localDrawable2 = ((URLDrawable)localDrawable1).getCurrDrawable();
        if ((localDrawable2 instanceof GifDrawable)) {
          ((GifDrawable)localDrawable2).getImage().reset();
        }
        ((URLDrawable)localDrawable1).setIndividualPause(false);
        CG(1);
        return;
      }
      CG(0);
      ThreadManager.post(new DoodleMsgLayout.4(this), 5, null, true);
      return;
      CG(2);
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.play(0L);
  }
  
  public void setOperateListener(View.OnClickListener paramOnClickListener, View.OnTouchListener paramOnTouchListener, View.OnLongClickListener paramOnLongClickListener, a parama)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null)
    {
      if (paramOnClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    if (this.ao != null)
    {
      if (paramOnClickListener != null) {
        this.ao.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.ao.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.ao.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    if (this.aq != null)
    {
      if (paramOnClickListener != null) {
        this.aq.setOnClickListener(paramOnClickListener);
      }
      if (paramOnTouchListener != null) {
        this.aq.setOnTouchListener(paramOnTouchListener);
      }
      if (paramOnLongClickListener != null) {
        this.aq.setOnLongClickListener(paramOnLongClickListener);
      }
    }
    this.dQ = new WeakReference(parama);
  }
  
  public void setTalkBack(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.setContentDescription(paramString);
    }
  }
  
  public void stop()
  {
    this.bfH = false;
    CG(3);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgView.stop();
    }
    if (this.ao != null) {
      this.ao.setImageDrawable(null);
    }
    if (this.aq != null) {
      this.aq.setImageDrawable(null);
    }
  }
  
  public void yR(boolean paramBoolean)
  {
    QLog.d("DoodleMsgLayout", 2, "showFailedStatus begin");
    cbj();
    if (this.sz != null) {
      this.sz.setVisibility(8);
    }
    if (paramBoolean)
    {
      if (this.sA != null) {
        this.sA.setVisibility(8);
      }
      if (this.hv != null) {
        this.hv.setVisibility(4);
      }
    }
    for (;;)
    {
      QLog.d("DoodleMsgLayout", 2, "showFailedStatus end");
      return;
      if (this.hv != null) {
        this.hv.setVisibility(4);
      }
      if (this.sA != null)
      {
        this.sA.setVisibility(0);
        if (this.sA.getDrawable() == null)
        {
          Drawable localDrawable = aA();
          this.sA.setImageDrawable(localDrawable);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void T(View paramView, int paramInt);
  }
  
  class b
  {
    int bRb;
    boolean bfF;
    boolean bfJ = false;
    String mFile;
    boolean mPause = false;
    
    b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout
 * JD-Core Version:    0.7.0.1
 */