package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import kgk;
import nhw;
import nhx;
import nhy;
import wja;

@TargetApi(14)
public class ReadinjoySlidingIndicator
  extends FrameLayout
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private int LB;
  private a a;
  private Paint aI;
  private int aYR;
  private int aYS = -16777216;
  private int aYT = -7829368;
  private int aYU = -16776961;
  private int aYV;
  private int aii = 18;
  private int aim = 4;
  private String[] bD;
  private LinearLayout.LayoutParams c;
  private int currentPosition;
  private int[] dw;
  private LinearLayout ek;
  private LinearLayout el;
  private ImageView kB;
  private int tabPadding = 18;
  
  public ReadinjoySlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadinjoySlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.aim = ((int)TypedValue.applyDimension(1, this.aim, (DisplayMetrics)localObject));
    this.tabPadding = ((int)TypedValue.applyDimension(1, this.tabPadding, (DisplayMetrics)localObject));
    this.aii = ((int)TypedValue.applyDimension(2, this.aii, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.aii = ((TypedArray)localObject).getDimensionPixelSize(0, this.aii);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rG);
    this.aYU = paramAttributeSet.getColor(2, this.aYU);
    this.aYS = paramAttributeSet.getColor(1, this.aYS);
    this.aYT = paramAttributeSet.getColor(4, this.aYT);
    this.aim = paramAttributeSet.getDimensionPixelSize(0, this.aim);
    this.tabPadding = paramAttributeSet.getDimensionPixelSize(3, this.tabPadding);
    paramAttributeSet.recycle();
    initPaint();
    ck(paramContext);
    if (Build.VERSION.SDK_INT >= 14) {
      setAccessibilityDelegate(new nhw(this));
    }
  }
  
  private void aXo()
  {
    this.el = new LinearLayout(getContext());
    this.el.setOrientation(0);
    this.el.setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 1));
    this.el.addView(this.ek);
    this.el.addView(h());
    addView(this.el);
  }
  
  private void aXp()
  {
    if (this.kB != null)
    {
      this.kB.setColorFilter(this.aYS);
      QLog.d("tag", 2, new Object[] { "color: ", Integer.valueOf(this.aYS) });
    }
  }
  
  private void aXq()
  {
    if (this.LB != this.currentPosition)
    {
      Object localObject = this.ek.getChildAt(this.LB);
      View localView = this.ek.getChildAt(this.currentPosition);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new nhx(this));
        ((ValueAnimator)localObject).start();
      }
      return;
    }
    this.aYV = this.ek.getChildAt(this.currentPosition).getLeft();
    invalidate();
  }
  
  private void ck(Context paramContext)
  {
    this.c = new LinearLayout.LayoutParams(-2, -1);
    this.ek = new LinearLayout(paramContext);
    this.ek.setOrientation(0);
    this.ek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.ek.setGravity(1);
    aXo();
  }
  
  private void initPaint()
  {
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.FILL);
    this.aI.setTextSize(this.aii);
  }
  
  private void j(int paramInt1, String paramString, int paramInt2)
  {
    int i = kgk.aIG;
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    localTextView.setMaxLines(1);
    localTextView.setPadding(this.tabPadding, 0, this.tabPadding, 0);
    localTextView.setTextSize(0, this.aii);
    localTextView.setFilters(new InputFilter[] { new InputFilter.LengthFilter(i + 3) });
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    String str = paramString;
    if (paramString.length() > i) {
      str = paramString.substring(0, i) + "...";
    }
    localTextView.setText(str);
    paramString = new RedTouch(getContext(), localTextView).a(53).c(8).d(12).a(true).a();
    paramString.setId(paramInt2);
    k(paramInt1, paramString);
  }
  
  private void k(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    this.ek.addView(paramView, paramInt, this.c);
  }
  
  private void tB(int paramInt)
  {
    int j = this.ek.getChildCount();
    int i = 0;
    if (i < j)
    {
      TextView localTextView = (TextView)((RedTouch)this.ek.getChildAt(i)).cq();
      if (i == paramInt) {
        localTextView.setTextColor(this.aYS);
      }
      for (;;)
      {
        i += 1;
        break;
        localTextView.setTextColor(this.aYT);
      }
    }
  }
  
  public void T(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aYS = getResources().getColor(paramInt1);
    this.aYT = (this.aYS & 0xFFFFFF | 0x99000000);
    this.aYU = getResources().getColor(paramInt3);
    tB(this.currentPosition);
    aXp();
    invalidate();
  }
  
  public LinearLayout e()
  {
    return this.el;
  }
  
  public boolean ed(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.ek.findViewById(this.dw[paramInt]);
    return (localRedTouch != null) && (localRedTouch.aux());
  }
  
  public ImageView h()
  {
    if (this.kB == null)
    {
      this.kB = new ImageView(getContext());
      aXp();
      this.kB.setImageResource(2130850366);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(wja.dp2px(7.0F, getResources()), wja.dp2px(7.0F, getResources()));
      localLayoutParams.gravity = 16;
      localLayoutParams.leftMargin = (-wja.dp2px(11.0F, getResources()));
      this.kB.setLayoutParams(localLayoutParams);
    }
    return this.kB;
  }
  
  protected void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.LB = this.currentPosition;
    this.currentPosition = paramInt;
    RedTouch localRedTouch;
    if ((this.currentPosition != this.LB) && (this.currentPosition >= 0))
    {
      localRedTouch = (RedTouch)this.ek.getChildAt(this.currentPosition);
      tB(paramInt);
      if (!paramBoolean1) {
        break label87;
      }
      aXq();
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.c(this.LB, this.currentPosition, paramBoolean2);
      }
      return;
      label87:
      this.aYV = localRedTouch.getLeft();
      invalidate();
    }
  }
  
  public void notifyDataSetChanged()
  {
    this.ek.removeAllViews();
    this.aYR = this.bD.length;
    int i = 0;
    while (i < this.aYR)
    {
      j(i, this.bD[i], this.dw[i]);
      i += 1;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new nhy(this));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.aYR == 0)) {
      return;
    }
    getHeight();
    this.aI.setColor(this.aYU);
  }
  
  public void setAccessibilityMsg()
  {
    if (AppSetting.enableTalkBack)
    {
      int i = 0;
      while (i < this.aYR)
      {
        View localView = this.ek.getChildAt(i);
        if (localView != null)
        {
          if (i == this.currentPosition) {}
          localView.setContentDescription("");
        }
        i += 1;
      }
    }
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    h(paramInt, paramBoolean, false);
  }
  
  public void setOnIndicatorChangeListener(a parama)
  {
    this.a = parama;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setTabData(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0) || (paramArrayOfInt == null) || (paramArrayOfInt.length != paramArrayOfString.length)) {
      return;
    }
    this.bD = ((String[])paramArrayOfString.clone());
    this.dw = ((int[])paramArrayOfInt.clone());
    notifyDataSetChanged();
  }
  
  public void tC(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.ek.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.aux())) {
      localRedTouch.dGB();
    }
  }
  
  public static abstract interface a
  {
    public abstract int c(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySlidingIndicator
 * JD-Core Version:    0.7.0.1
 */