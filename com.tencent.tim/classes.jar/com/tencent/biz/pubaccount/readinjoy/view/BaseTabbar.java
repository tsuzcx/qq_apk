package com.tencent.biz.pubaccount.readinjoy.view;

import acej;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nci;
import ncj;
import nck;
import ncl;
import ncm;

public class BaseTabbar
  extends LinearLayout
{
  private static int SCREEN_WIDTH;
  private static final int aXr;
  private static final int aXs;
  private static final int aXt = 14;
  public final Paint aE;
  private int aXA = -1;
  int aXB = 1;
  protected int aXC = 99;
  private int aXu = aXr;
  private int aXv = aXs;
  private int aXw;
  private int aXx;
  private int aXy;
  private int aXz = -1;
  private boolean arh = true;
  private AtomicBoolean az = new AtomicBoolean(false);
  public a b;
  private LinearLayout.LayoutParams c;
  private List<b> jN = new ArrayList();
  private List<RelativeLayout> jO = new ArrayList();
  private List<String> jP = new ArrayList();
  private float ki;
  private Handler mHandler = new nci(this);
  private int mLeftPadding;
  public final Paint mPaint;
  private int mRightPadding;
  private int mTextSize = aXt;
  private int mTopPadding;
  Paint paint = new Paint();
  
  static
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    aXr = (int)(40.0F * localBaseApplication.getResources().getDisplayMetrics().density + 0.5F);
    aXs = (int)(localBaseApplication.getResources().getDisplayMetrics().density * 4.0F + 0.5F);
  }
  
  public BaseTabbar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseTabbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aXw = paramContext.getResources().getColor(2131167312);
    this.aXx = paramContext.getResources().getColor(2131167304);
    this.mPaint = new Paint();
    this.mPaint.setColor(this.aXw);
    this.c = new LinearLayout.LayoutParams(0, -1);
    this.c.weight = 1.0F;
    this.c.gravity = 17;
    setBackgroundDrawable(getResources().getDrawable(2130851395));
    if (SCREEN_WIDTH == 0) {
      SCREEN_WIDTH = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
    }
    this.aE = new Paint();
    this.aE.setColor(-8355712);
    int i = aqnm.getScreenWidth();
    if (i > 480) {}
    for (this.aXB = 1;; this.aXB = 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TabBarView", 2, "width:" + i + "mode:" + this.aXB);
      }
      return;
    }
  }
  
  private float a(float paramFloat, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (paramFloat < 0.6F) {
        return 0.0F;
      }
      return (paramFloat - 0.6F) / 0.4F;
    }
    if (paramFloat < 0.6F) {
      return paramFloat / 0.6F;
    }
    return 1.0F;
  }
  
  private void aVv()
  {
    Object localObject = (AccessibilityManager)getContext().getSystemService("accessibility");
    if ((localObject != null) && (((AccessibilityManager)localObject).isEnabled()))
    {
      int j = this.jN.size();
      int i = 0;
      while (i < j)
      {
        localObject = ((b)this.jN.get(i)).a;
        if (localObject != null) {
          ((RedDotTextView)localObject).setContentDescription(((RedDotTextView)localObject).getText() + getContext().getString(2131692117));
        }
        i += 1;
      }
    }
  }
  
  private int g(View paramView)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private void onTabSelected(int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.onTabSelected(paramInt1, paramInt2);
    }
  }
  
  public b a(int paramInt, String paramString)
  {
    if ((paramInt < 0) || (paramInt > getChildCount())) {
      throw new IllegalArgumentException("position is not legal, please check!");
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    if (paramInt == 2) {
      localRelativeLayout.setVisibility(8);
    }
    Object localObject = LayoutInflater.from(getContext()).inflate(2131560273, localRelativeLayout, true);
    b localb = new b();
    localb.root = ((View)localObject).findViewById(2131379141);
    localb.a = ((RedDotTextView)((View)localObject).findViewById(2131379401));
    localb.ko = ((ImageView)((View)localObject).findViewById(2131377002));
    localb.sJ = ((TextView)((View)localObject).findViewById(2131372577));
    localb.kp = ((ImageView)((View)localObject).findViewById(2131368820));
    localb.kq = ((ImageView)((View)localObject).findViewById(2131378465));
    localObject = localb.a;
    ((RedDotTextView)localObject).setText(paramString);
    ((RedDotTextView)localObject).setTextSize(2, this.mTextSize);
    ((RedDotTextView)localObject).setTextColor(this.aXx);
    ((RedDotTextView)localObject).setPadding(this.mLeftPadding, this.mTopPadding, this.mRightPadding, this.aXy);
    ((RedDotTextView)localObject).setSingleLine();
    ((RedDotTextView)localObject).setFocusable(true);
    ((RedDotTextView)localObject).setContentDescription(paramString);
    ((RedDotTextView)localObject).setGravity(17);
    localb.kp.setContentDescription(paramString);
    if (this.aXB == 1)
    {
      localb.sJ.setTextSize(0, acej.k.density * 10.0F);
      ViewCompat.setAccessibilityDelegate((View)localObject, new ncj(this));
      this.jN.add(localb);
      this.jO.add(localRelativeLayout);
      this.jP.add(paramString);
      if (this.jN.size() != 2) {
        break label429;
      }
      setGravity(1);
    }
    for (;;)
    {
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      ((LinearLayout.LayoutParams)localObject).gravity = 17;
      addView(localRelativeLayout, paramInt, (ViewGroup.LayoutParams)localObject);
      if (!TextUtils.isEmpty(paramString)) {
        localRelativeLayout.setOnClickListener(new nck(this, paramInt));
      }
      return localb;
      if (this.aXB != 2) {
        break;
      }
      localb.sJ.setTextSize(0, acej.k.density * 7.0F);
      break;
      label429:
      setGravity(8388627);
    }
  }
  
  public void c(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jN.size())) {
      return;
    }
    b localb = (b)this.jN.get(paramInt1);
    if (paramInt2 == 0)
    {
      localb.ko.setVisibility(8);
      localb.sJ.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      if (paramInt2 > this.aXC)
      {
        localb.sJ.setText(String.valueOf(99) + "+");
        if (this.aXB == 1) {
          localb.sJ.setTextSize(0, acej.k.density * 8.5F);
        }
      }
      for (;;)
      {
        localb.sJ.setVisibility(0);
        localb.ko.setVisibility(8);
        return;
        localb.sJ.setText(String.valueOf(paramInt2));
        if (this.aXB == 1) {
          localb.sJ.setTextSize(0, acej.k.density * 10.0F);
        }
      }
    }
    localb.ko.setVisibility(0);
    localb.sJ.setVisibility(8);
  }
  
  public void df(int paramInt1, int paramInt2)
  {
    if (this.jN == null) {}
    b localb;
    do
    {
      do
      {
        return;
        if ((paramInt1 >= 0) && (paramInt1 < this.jN.size()))
        {
          localb = (b)this.jN.get(paramInt1);
          if (localb != null) {
            localb.a.setTextColor(this.aXx);
          }
        }
      } while ((paramInt2 < 0) || (paramInt2 >= this.jN.size()));
      localb = (b)this.jN.get(paramInt2);
    } while (localb == null);
    localb.a.setTextColor(this.aXw);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    boolean bool2 = true;
    super.dispatchDraw(paramCanvas);
    View localView1 = getChildAt(this.aXA);
    View localView2 = getChildAt(this.aXz);
    int j;
    int i;
    b localb;
    boolean bool1;
    float f1;
    if (localView1 != null)
    {
      this.paint.setTextSize(this.mTextSize * getContext().getResources().getDisplayMetrics().density + 0.5F);
      j = localView1.getLeft();
      i = localView1.getRight();
      localb = (b)this.jN.get(this.aXA);
      if (!localb.Fl()) {
        break label362;
      }
      if (this.ki <= 0.0F) {
        break label359;
      }
      if (this.aXA >= this.aXz) {
        break label347;
      }
      bool1 = true;
      j = (int)(localView1.getLeft() + a(this.ki, bool1) * (localView2.getLeft() - localView1.getLeft()));
      f1 = localView1.getRight();
      float f2 = this.ki;
      if (bool1) {
        break label353;
      }
      bool1 = bool2;
      label179:
      i = (int)(a(f2, bool1) * (localView2.getRight() - localView1.getRight()) + f1);
      label204:
      paramCanvas.drawRect(j, getHeight() - this.aXv, i, getHeight(), this.mPaint);
    }
    label347:
    label353:
    label359:
    label362:
    for (;;)
    {
      j = (localView2.getLeft() + localView2.getRight()) / 2;
      int k = localb.root.getTop();
      int m = localb.root.getBottom();
      int n = (k + m) / 2;
      f1 = (localView2.getRight() - localView2.getLeft()) / 2;
      this.aE.setAlpha((int)(96.0F * (1.0F - this.ki)));
      paramCanvas.clipRect(0, k, i, m);
      paramCanvas.drawCircle(j, n, this.ki * (f1 * 1.2F), this.aE);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label179;
      break label204;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.aXu, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.aXu);
  }
  
  public int qt()
  {
    return this.aXA;
  }
  
  public void setEnableRepeatedClick(boolean paramBoolean)
  {
    this.arh = paramBoolean;
  }
  
  public void setOnTabChangeListener(a parama)
  {
    this.b = parama;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.aXw = paramInt;
    this.mPaint.setColor(this.aXw);
    invalidate();
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean)
  {
    setSelectedTab(paramInt, paramBoolean, false);
  }
  
  public void setSelectedTab(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if ((paramBoolean1) && (this.az.get())) {}
    label175:
    do
    {
      do
      {
        return;
        int i = paramInt;
        if (paramInt < 0) {
          i = 0;
        }
        int k = getChildCount();
        paramInt = i;
        if (i >= k) {
          paramInt = k - 1;
        }
        if (this.aXA == paramInt) {
          break label175;
        }
        if (this.aXA == -1) {
          paramBoolean1 = false;
        }
        if (!paramBoolean1) {
          break;
        }
      } while (!this.az.compareAndSet(false, true));
      this.ki = 0.0F;
      this.aXz = paramInt;
      Message localMessage = this.mHandler.obtainMessage(0);
      paramInt = j;
      if (paramBoolean2) {
        paramInt = 1;
      }
      localMessage.arg1 = paramInt;
      this.mHandler.sendMessage(localMessage);
      return;
      aVv();
      if (!paramBoolean2) {
        onTabSelected(this.aXA, paramInt);
      }
      this.aXz = paramInt;
      this.ki = 1.0F;
      df(this.aXA, paramInt);
      invalidate();
      this.aXA = paramInt;
      return;
    } while ((!this.arh) || (paramBoolean2));
    onTabSelected(this.aXA, this.aXA);
  }
  
  public void setTabHeight(int paramInt)
  {
    this.aXu = paramInt;
  }
  
  public void setTabLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    this.c = paramLayoutParams;
  }
  
  public void setTabTextSize(int paramInt)
  {
    this.mTextSize = paramInt;
  }
  
  public void setTextPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mLeftPadding = paramInt1;
    this.mTopPadding = paramInt2;
    this.mRightPadding = paramInt3;
    this.aXy = paramInt4;
  }
  
  public void setUnderLineHeight(int paramInt)
  {
    this.aXv = paramInt;
  }
  
  public void setUnselectColor(int paramInt)
  {
    this.aXx = paramInt;
  }
  
  public void tp(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jN.size())) {
      return;
    }
    b localb = (b)this.jN.get(paramInt);
    localb.sJ.setVisibility(8);
    localb.ko.setVisibility(8);
  }
  
  public static abstract interface a
  {
    public abstract void onTabSelected(int paramInt1, int paramInt2);
    
    public abstract void pc(int paramInt);
  }
  
  public static class b
  {
    public RedDotTextView a;
    private boolean ari = true;
    public ImageView ko;
    public ImageView kp;
    public ImageView kq;
    public View root;
    public TextView sJ;
    
    private void aVw()
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ko.getLayoutParams();
      localLayoutParams.addRule(1, this.a.getId());
      this.ko.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.sJ.getLayoutParams();
      localLayoutParams.addRule(1, this.a.getId());
      this.sJ.setLayoutParams(localLayoutParams);
      this.a.setVisibility(0);
      this.kp.setVisibility(8);
    }
    
    private void aVx()
    {
      this.kp.setVisibility(0);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.ko.getLayoutParams();
      localLayoutParams.addRule(1, this.kp.getId());
      this.ko.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.sJ.getLayoutParams();
      localLayoutParams.addRule(1, this.kp.getId());
      this.sJ.setLayoutParams(localLayoutParams);
      this.a.setVisibility(8);
    }
    
    private void pq(boolean paramBoolean)
    {
      this.ari = paramBoolean;
      if (this.ari)
      {
        aVw();
        return;
      }
      aVx();
    }
    
    private void pr(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.kp, "scaleX", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.kp, "scaleY", new float[] { 1.0F, 0.8F, 1.0F }).setDuration(150L);
        localObject = ObjectAnimator.ofFloat(this.kp, "rotation", new float[] { 0.0F, 720.0F }).setDuration(800L);
        ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.kp, "alpha", new float[] { 1.0F, 0.0F }).setDuration(200L);
        localObjectAnimator3.setStartDelay(700L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.setInterpolator(new LinearInterpolator());
        localAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
        localAnimatorSet.play(localObjectAnimator2).before((Animator)localObject);
        localAnimatorSet.play((Animator)localObject).with(localObjectAnimator3);
        localAnimatorSet.addListener(new ncl(this, paramBoolean));
        localAnimatorSet.start();
        return;
      }
      this.ari = paramBoolean;
      this.kp.setVisibility(0);
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.kp, "alpha", new float[] { 0.0F, 1.0F }).setDuration(500L);
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.kp, "rotation", new float[] { -30.0F, 0.0F }).setDuration(500L);
      Object localObject = new AnimatorSet();
      ((AnimatorSet)localObject).play(localObjectAnimator2).with(localObjectAnimator1);
      ((AnimatorSet)localObject).addListener(new ncm(this));
      ((AnimatorSet)localObject).start();
    }
    
    public boolean Fl()
    {
      return this.ari;
    }
    
    public void ac(boolean paramBoolean1, boolean paramBoolean2)
    {
      if (this.ari == paramBoolean1) {
        return;
      }
      if (QLog.isDebugVersion()) {
        QLog.d("TabBarView", 4, "setIsTextStyle isTextStyle:");
      }
      if (paramBoolean2)
      {
        pr(paramBoolean1);
        return;
      }
      pq(paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.BaseTabbar
 * JD-Core Version:    0.7.0.1
 */