package com.tencent.tim.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqge;
import aupe;
import auqj;
import auqk;
import auql;
import auqm;
import auqn;
import com.tencent.lottieNew.LottieAnimationView;
import com.tencent.lottieNew.LottieAnimationView.CacheStrategy;
import com.tencent.tim.todo.widget.TodoCardView;
import com.tencent.widget.ListView;
import son;

public class PullRefreshHeader
  extends RelativeLayout
  implements son
{
  private int ZY;
  private ValueAnimator aT;
  private ListView b;
  private LottieAnimationView c;
  private boolean djA;
  private boolean djB;
  private boolean djy;
  private boolean djz;
  private int esd = (int)(getResources().getDisplayMetrics().density * 200.0F);
  private int ese = (int)(getResources().getDisplayMetrics().density * 20.0F);
  private RelativeLayout fs;
  private boolean isReleased;
  private Runnable iv = new PullRefreshHeader.4(this);
  private Context mContext;
  private int mPullType = 0;
  private LinearLayout mf;
  private RelativeLayout nF;
  public long yb;
  
  public PullRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private void aaW(int paramInt)
  {
    float f1 = 1.0F;
    float f2 = paramInt / this.c.getMeasuredHeight();
    if (f2 > 1.0F) {}
    for (;;)
    {
      this.c.setScaleX(f1);
      this.c.setScaleY(f1);
      this.c.setAlpha(f1);
      if (paramInt < this.nF.getMeasuredHeight())
      {
        int i = (paramInt - this.c.getMeasuredHeight()) / 2;
        this.c.setTranslationY(i);
      }
      for (;;)
      {
        this.c.setRotation(-paramInt);
        return;
        this.c.setTranslationY((this.nF.getMeasuredHeight() - this.c.getMeasuredHeight()) / 2);
      }
      f1 = f2;
    }
  }
  
  private void baf()
  {
    if (this.fs == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.fs.getLayoutParams();
    if (this.mPullType == 0)
    {
      a(localLayoutParams, 10);
      localLayoutParams.addRule(12);
    }
    for (;;)
    {
      this.fs.setLayoutParams(localLayoutParams);
      return;
      a(localLayoutParams, 12);
      localLayoutParams.addRule(10);
    }
  }
  
  private void ewh()
  {
    if (getParent() == null) {}
    do
    {
      return;
      if ((getParent() instanceof ListView))
      {
        this.b = ((ListView)getParent());
        return;
      }
    } while ((getParent().getParent() == null) || (!(getParent().getParent() instanceof ListView)));
    this.b = ((ListView)getParent().getParent());
  }
  
  private void ewi()
  {
    this.isReleased = true;
    this.djB = false;
    if (this.aT == null)
    {
      this.aT = ValueAnimator.ofInt(new int[] { 0, 72 });
      this.aT.addUpdateListener(new auqm(this));
      this.aT.addListener(new auqn(this));
      this.aT.setInterpolator(null);
      this.aT.setRepeatCount(-1);
      this.aT.setDuration(100L);
    }
    this.aT.start();
  }
  
  private void ewj()
  {
    this.isReleased = false;
    this.djB = true;
    if ((Build.VERSION.SDK_INT >= 26) && (this.b != null)) {
      this.b.setLayerType(1, null);
    }
  }
  
  private int lc(int paramInt)
  {
    float f1 = 1.0F;
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    float f2 = (paramInt - this.ese) / (this.esd - this.ese);
    if (f2 > 1.0F) {}
    for (;;)
    {
      return (int)(localDecelerateInterpolator.getInterpolation(f1) * (this.ZY + this.ese));
      f1 = f2;
    }
  }
  
  public void K(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      this.c.setAnimation("pull_refresh_header.json", LottieAnimationView.CacheStrategy.Strong);
    }
    for (;;)
    {
      ewj();
      return;
      this.c.setAnimation("pull_refresh_header_fail.json");
    }
  }
  
  public void Q(long paramLong)
  {
    this.c.cancelAnimation();
    this.c.setProgress(0.0F);
    postDelayed(this.iv, 20L);
    this.djA = false;
  }
  
  public void R(long paramLong) {}
  
  public void S(long paramLong)
  {
    aaW(this.nF.getMeasuredHeight());
    ewi();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.djy) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public long dl()
  {
    return this.yb;
  }
  
  public View getHeaderView()
  {
    return this;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.isReleased) && (this.aT != null)) {
      this.aT.start();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.isReleased) && (this.aT != null)) {
      this.aT.cancel();
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.fs = ((RelativeLayout)findViewById(2131365360));
    if (this.mPullType != 0) {
      baf();
    }
    this.nF = this.fs;
    if (this.nF != null)
    {
      this.c = ((LottieAnimationView)findViewById(2131366048));
      this.c.setAnimation("pull_refresh_header.json");
      if (Build.VERSION.SDK_INT >= 26) {
        this.c.addAnimatorListener(new auqj(this));
      }
      this.mf = ((LinearLayout)findViewById(2131366566));
      if (this.mf != null) {
        this.ZY = ((RelativeLayout.LayoutParams)this.mf.getLayoutParams()).topMargin;
      }
    }
  }
  
  public void pn()
  {
    postDelayed(this.iv, 20L);
    this.djA = false;
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setOverCrossDistance(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (!this.djA)
      {
        ((Vibrator)getContext().getSystemService("vibrator")).vibrate(10L);
        this.djA = true;
      }
      localObject = (ViewGroup.MarginLayoutParams)this.mf.getLayoutParams();
      if (paramInt1 >= this.ese) {
        break label230;
      }
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.ZY + paramInt1);
      this.mf.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramBoolean)
      {
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
        localValueAnimator.setInterpolator(new DecelerateInterpolator(2.0F));
        localValueAnimator.addUpdateListener(new auqk(this, (ViewGroup.MarginLayoutParams)localObject));
        localValueAnimator.addListener(new auql(this));
        localValueAnimator.setDuration(400L);
        localValueAnimator.start();
        if (!this.djz) {
          if ((this.mf.getChildAt(0) instanceof TodoCardView))
          {
            localObject = (TodoCardView)this.mf.getChildAt(0);
            if (((TodoCardView)localObject).isEmpty()) {
              ((TodoCardView)localObject).ewc();
            }
            if (!((TodoCardView)localObject).isEmpty()) {
              break label298;
            }
          }
        }
      }
    }
    label298:
    for (Object localObject = "0X80091B1";; localObject = "0X80091AF")
    {
      aupe.L(null, (String)localObject, 1);
      aqge.ce(2131230775, false);
      this.djy = true;
      return;
      label230:
      if ((paramInt1 >= this.ese) && (paramInt1 < this.esd))
      {
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = (this.ZY + this.ese - lc(paramInt1));
        break;
      }
      this.nF.setVisibility(4);
      this.djy = true;
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((paramInt1 - this.esd) / 2);
      break;
    }
  }
  
  public void setPullType(int paramInt)
  {
    if (this.mPullType != paramInt)
    {
      this.mPullType = paramInt;
      baf();
    }
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {}
  
  public void setTheme(int paramInt) {}
  
  public void setTriggerDistance(int paramInt)
  {
    this.esd = paramInt;
  }
  
  public void tT(int paramInt)
  {
    K(paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.widget.PullRefreshHeader
 * JD-Core Version:    0.7.0.1
 */