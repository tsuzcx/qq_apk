package com.tencent.mobileqq.activity.aio.intimate;

import aejw;
import aejx;
import ahpl;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anot;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ticker.TickerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.IntimateScoreCardInfo;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.io.FileInputStream;
import wja;
import wxs;
import wxt;

public class IntimateScoreCardView
  extends RelativeLayout
  implements View.OnClickListener, View.OnTouchListener, ImageAssetDelegate, OnCompositionLoadedListener
{
  public static String TAG = "IntimateScoreView";
  private Button B;
  private TextView ID;
  private TextView IE;
  private ValueAnimator Z;
  private a jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a;
  private IntimateInfo.IntimateScoreCardInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private String aUv;
  private boolean aqw;
  private int bPg;
  private int bPj;
  private boolean bgs;
  private int bvC = 4;
  private TickerView d;
  Runnable en = new IntimateScoreCardView.1(this);
  Runnable eo = new IntimateScoreCardView.2(this);
  private DiniFlyAnimationView f;
  private RelativeLayout fj;
  private ImageView gX;
  private RelativeLayout hx;
  private QQAppInterface mApp;
  public Context mContext;
  private boolean mInited;
  private TextView mTitle;
  private boolean uA;
  private View wB;
  
  public IntimateScoreCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IntimateScoreCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IntimateScoreCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
  }
  
  private boolean Ru()
  {
    boolean bool = true;
    if (this.bPg == 4) {
      bool = false;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "canUpdateAnim res: " + bool + "  mCurrentShowType:" + this.bPg);
    }
    return bool;
  }
  
  private void bZw()
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "checkAndStartUpdateAnim mIsResumed:" + this.uA + " mCurrentShowType:" + this.bPg + " mIntimateInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
    if ((this.uA) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (iD()))
    {
      removeCallbacks(this.en);
      if ((Ru()) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore != this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore > 0)) {
        postDelayed(this.en, 300L);
      }
    }
    else
    {
      return;
    }
    cdo();
  }
  
  private void cdm()
  {
    boolean bool = true;
    int j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
    int k = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore);
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "smoothUpdateScores fromScore:" + j + " toScore:" + k);
    }
    TickerView localTickerView = this.d;
    int i;
    if (k > j)
    {
      i = 1;
      localTickerView.setPreferredScrollingDirection(i);
      this.d.setDigitalAnimWidthSpeedIncrement(true);
      this.d.setIgnoreWidthAnim(true);
      this.d.setText(String.valueOf(k));
      removeCallbacks(this.eo);
      postDelayed(this.eo, 2500L);
      if ((this.bPj == 3) || (this.bPj == 2) || (this.bPj == 1)) {
        if (k <= j) {
          break label192;
        }
      }
    }
    for (;;)
    {
      zn(bool);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a.bZj();
      }
      return;
      i = 2;
      break;
      label192:
      bool = false;
    }
  }
  
  private void cdn()
  {
    if ((this.f.getVisibility() == 0) || (this.f.isAnimating()))
    {
      this.f.setVisibility(8);
      this.f.cancelAnimation();
      this.f.removeAllLottieOnCompositionLoadedListener();
    }
  }
  
  private void cdo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo == null) {
      cdp();
    }
    do
    {
      return;
      if ((this.bPj != 3) && (this.bPj != 2) && (this.bPj != 1))
      {
        cdp();
        return;
      }
      aejw localaejw = aejx.a();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= localaejw.cNC) || (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < localaejw.cNB))
      {
        cdp();
        return;
      }
    } while ((this.Z != null) && (this.Z.isRunning()));
    if (this.Z == null)
    {
      this.Z = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.Z.setInterpolator(new LinearInterpolator());
      this.Z.setDuration(1500L);
      this.Z.setRepeatCount(-1);
      this.Z.addUpdateListener(new wxs(this));
      this.Z.addListener(new wxt(this));
    }
    this.Z.start();
  }
  
  private void cdp()
  {
    if ((this.Z != null) && (this.Z.isRunning())) {
      this.Z.cancel();
    }
  }
  
  private boolean iD()
  {
    int i = 0;
    boolean bool = true;
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo != null))
    {
      localObject = aejx.a();
      if ((this.bPj == 3) || (this.bPj == 2) || (this.bPj == 1)) {
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < ((aejw)localObject).cNB) {
          break label152;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder().append("canShow res: ").append(bool).append("  mCurrentShowType:").append(this.bPg).append(" score:");
        if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) {
          i = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
        }
        QLog.d((String)localObject, 2, i);
      }
      return bool;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore < ((aejw)localObject).cND) {
        label152:
        bool = false;
      }
    }
  }
  
  private void init()
  {
    this.mInited = true;
    View localView = LayoutInflater.from(this.mContext).inflate(2131559451, this, true);
    this.fj = ((RelativeLayout)localView.findViewById(2131377727));
    this.mTitle = ((TextView)localView.findViewById(2131377726));
    this.gX = ((ImageView)localView.findViewById(2131377721));
    this.hx = ((RelativeLayout)localView.findViewById(2131377725));
    this.d = ((TickerView)localView.findViewById(2131377724));
    this.d.setCharacterLists(new String[] { "9876543210" });
    this.d.setAnimationDuration(2000L);
    this.f = ((DiniFlyAnimationView)localView.findViewById(2131377723));
    this.ID = ((TextView)localView.findViewById(2131377728));
    this.IE = ((TextView)localView.findViewById(2131377722));
    this.B = ((Button)localView.findViewById(2131377720));
    this.B.setOnClickListener(this);
    this.wB = localView.findViewById(2131369349);
    this.wB.setOnClickListener(this);
    this.wB.setOnTouchListener(this);
  }
  
  private void zn(boolean paramBoolean)
  {
    if ((this.mApp == null) || (!this.uA)) {}
    String str2;
    do
    {
      do
      {
        return;
        localObject = (ahpl)this.mApp.getManager(323);
      } while (localObject == null);
      str2 = ((ahpl)localObject).m(this.bPj, paramBoolean);
    } while (TextUtils.isEmpty(str2));
    Object localObject = new File(str2).getParent();
    if (((String)localObject).endsWith("/")) {}
    String str1;
    for (localObject = (String)localObject + "images";; str1 = localThrowable + "/images")
    {
      this.aUv = ((String)localObject);
      try
      {
        LottieComposition.Factory.fromInputStream(getContext(), new FileInputStream(str2), this);
        this.f.setVisibility(0);
        return;
      }
      catch (Throwable localThrowable)
      {
        QLog.d(TAG, 2, "startScoreLottieAnim error:" + localThrowable.getMessage());
        return;
      }
    }
  }
  
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    if (!this.mInited) {
      return null;
    }
    paramLottieImageAsset = paramLottieImageAsset.getFileName();
    paramLottieImageAsset = this.aUv + File.separator + paramLottieImageAsset;
    boolean bool = new File(paramLottieImageAsset).exists();
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "fetchBitmap exists:" + bool + " imagePath:" + paramLottieImageAsset);
      }
      return null;
    }
    Object localObject = BaseApplicationImpl.sImageCache.get(paramLottieImageAsset);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramLottieImageAsset, (BitmapFactory.Options)localObject);
      BaseApplicationImpl.sImageCache.put(paramLottieImageAsset, localObject);
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      QLog.i(TAG, 2, "fetchBitmap error " + paramLottieImageAsset.getMessage());
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onClick");
    }
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a != null) && (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a.xn(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.buttonUrl);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(null, "dc00898", "", "", "0X800AE5B", "0X800AE5B", this.bvC, 0, "", "", "", "");
      continue;
      anot.a(null, "dc00898", "", "", "0X800AE5C", "0X800AE5C", this.bvC, 0, "", "", "", "");
    }
  }
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (!this.mInited) {}
    for (;;)
    {
      return;
      if ((paramLottieComposition == null) || (this.f.getVisibility() != 0) || (!this.uA))
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "composition is null ,return");
        }
      }
      else
      {
        int i = wja.dp2px(75.0F, getResources());
        int j = wja.dp2px(90.0F, getResources());
        Rect localRect = paramLottieComposition.getBounds();
        float f1 = i / localRect.width();
        float f2 = j / localRect.height();
        this.f.setImageAssetDelegate(this);
        this.f.setComposition(paramLottieComposition);
        this.f.setScaleXY(f1, f2);
        this.f.setScaleType(ImageView.ScaleType.FIT_XY);
        if ((this.uA) && (this.f.getVisibility() == 0)) {
          this.f.playAnimation();
        }
        while (QLog.isColorLevel())
        {
          QLog.d(TAG, 2, "onCompositionLoaded playAnim duration: " + this.f.getDuration() + " mIsResumed:" + this.uA);
          return;
          this.f.cancelAnimation();
          this.f.removeAllLottieOnCompositionLoadedListener();
        }
      }
    }
  }
  
  public void onDestroy()
  {
    this.uA = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a = null;
    this.mApp = null;
    if (!this.mInited) {
      return;
    }
    removeCallbacks(this.en);
    cdn();
    cdp();
  }
  
  public void onDrawerClosed()
  {
    this.uA = false;
    this.bgs = false;
    this.aqw = false;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onDrawerClosed mIsResumed:" + this.uA);
    }
    if (!this.mInited) {
      return;
    }
    removeCallbacks(this.en);
    cdn();
    cdp();
  }
  
  public void onDrawerOpened()
  {
    this.uA = true;
    this.aqw = true;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onDrawerOpened mIsResumed:" + this.uA);
    }
    if (!this.mInited) {
      return;
    }
    bZw();
  }
  
  public void onPaused()
  {
    this.uA = false;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "onPaused mIsResumed:" + this.uA);
    }
    if (!this.mInited) {
      return;
    }
    removeCallbacks(this.en);
    cdn();
    cdp();
  }
  
  public void onResumed()
  {
    if (this.bPg == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onResumed mIsOpened:" + this.aqw);
      }
      if (this.aqw) {}
    }
    do
    {
      return;
      this.uA = true;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "onResumed mIsResumed:" + this.uA);
      }
    } while (!this.mInited);
    bZw();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return false;
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramView.setAlpha(0.5F);
        continue;
        if (Build.VERSION.SDK_INT >= 11) {
          paramView.setAlpha(1.0F);
        }
      }
    }
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public void setCallBack(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateIntimateScoreCardView$a = parama;
  }
  
  public void setCurrentShowType(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setCurrentShowType showType: " + paramInt + "  old:" + this.bPg + "  this:" + this);
    }
    this.bPg = paramInt;
  }
  
  public void setData(IntimateInfo paramIntimateInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.bPj = paramInt;
    if (paramIntimateInfo != null) {}
    for (paramIntimateInfo = paramIntimateInfo.scoreCardInfo;; paramIntimateInfo = null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo = paramIntimateInfo;
      if (QLog.isColorLevel()) {
        QLog.i(TAG, 2, "setData scoreCardInfo:" + this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo);
      }
      if (iD()) {
        break;
      }
      setVisibility(8);
      return;
    }
    if (!this.mInited) {
      init();
    }
    label100:
    int j;
    int i;
    if (paramInt == 1)
    {
      this.bvC = 1;
      setVisibility(0);
      j = this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore;
      if (this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.currentScore >= 0) {
        j = Math.max(0, this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.lastAnimAfterScore);
      }
      this.d.setText(String.valueOf(j), false);
      this.mTitle.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.title);
      this.ID.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.typeDescribe);
      this.IE.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.levelDescribe);
      this.B.setText(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo$IntimateScoreCardInfo.buttonDescribe);
      i = 2131165897;
      if (paramInt != 3) {
        break label358;
      }
      i = 2131165894;
    }
    for (;;)
    {
      this.d.setTextColor(this.mContext.getResources().getColor(i));
      bZw();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "updateIntimateInfo score: " + j);
      }
      if (this.bgs) {
        break;
      }
      this.bgs = true;
      anot.a(null, "dc00898", "", "", "0X800AE5A", "0X800AE5A", this.bvC, 0, "", "", "", "");
      return;
      if (paramInt == 2)
      {
        this.bvC = 2;
        break label100;
      }
      if (paramInt == 3)
      {
        this.bvC = 3;
        break label100;
      }
      this.bvC = 4;
      break label100;
      label358:
      if (paramInt == 2) {
        i = 2131165892;
      } else if (paramInt == 1) {
        i = 2131165896;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void bZj();
    
    public abstract void xn(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.IntimateScoreCardView
 * JD-Core Version:    0.7.0.1
 */