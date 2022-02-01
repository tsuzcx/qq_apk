package com.tencent.mobileqq.activity.contacts.base.tabs;

import acfp;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqnm;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import yzw;
import yzz;
import zaa;
import zab;
import zac;

@TargetApi(14)
public class SimpleSlidingIndicator
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  protected int LB;
  private a jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$a;
  private yzw jdField_a_of_type_Yzw;
  private Paint aI;
  private int aXv;
  private int aYR;
  private int aYS = -16777216;
  private int aYT = -7829368;
  protected int aYU = -16776961;
  public int aYV;
  private int aii = 12;
  private RectF ap;
  protected b b;
  protected String[] bD;
  private boolean bqe;
  private Paint bu;
  ViewTreeObserver.OnGlobalLayoutListener c = new zac(this);
  private int ccf = 25;
  private int ccg;
  private int cch = 12;
  private int cci = 12;
  private int ccj = 16;
  private int cck = 16;
  private int ccl = 52;
  private int ccm;
  private int ccn;
  private int cco;
  private int ccp;
  private int ccq;
  public int currentPosition;
  protected int[] dw;
  Drawable ef;
  public LinearLayout ek;
  SparseBooleanArray n = new SparseBooleanArray();
  
  public SimpleSlidingIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SimpleSlidingIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    Object localObject = getResources().getDisplayMetrics();
    this.ccl = ((int)TypedValue.applyDimension(1, this.ccl, (DisplayMetrics)localObject));
    this.cch = ((int)TypedValue.applyDimension(1, this.cch, (DisplayMetrics)localObject));
    this.cci = ((int)TypedValue.applyDimension(1, this.cci, (DisplayMetrics)localObject));
    this.ccj = ((int)TypedValue.applyDimension(1, this.ccj, (DisplayMetrics)localObject));
    this.cck = ((int)TypedValue.applyDimension(1, this.cck, (DisplayMetrics)localObject));
    this.ccg = ((int)TypedValue.applyDimension(1, this.ccg, (DisplayMetrics)localObject));
    this.aii = ((int)TypedValue.applyDimension(2, this.aii, (DisplayMetrics)localObject));
    this.ccm = ((int)TypedValue.applyDimension(1, this.ccm, (DisplayMetrics)localObject));
    this.ccn = ((int)TypedValue.applyDimension(1, this.ccn, (DisplayMetrics)localObject));
    this.cco = ((int)TypedValue.applyDimension(1, this.cco, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, ATTRS);
    this.aii = ((TypedArray)localObject).getDimensionPixelSize(0, this.aii);
    ((TypedArray)localObject).recycle();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sd);
    this.aYU = paramAttributeSet.getColor(2, this.aYU);
    this.ccf = paramAttributeSet.getInt(1, this.ccf);
    this.aYS = paramAttributeSet.getColor(0, this.aYS);
    this.aYT = paramAttributeSet.getColor(11, this.aYT);
    this.ccj = paramAttributeSet.getDimensionPixelSize(5, this.ccj);
    this.cck = paramAttributeSet.getDimensionPixelSize(6, this.cck);
    this.cch = paramAttributeSet.getDimensionPixelSize(4, this.cch);
    this.cci = paramAttributeSet.getDimensionPixelSize(3, this.cci);
    this.ccg = paramAttributeSet.getDimensionPixelSize(9, this.ccg);
    this.ccm = paramAttributeSet.getDimensionPixelSize(8, this.ccm);
    this.ccn = paramAttributeSet.getDimensionPixelSize(10, this.ccn);
    this.cco = paramAttributeSet.getDimensionPixelSize(7, this.cco);
    this.bqe = paramAttributeSet.getBoolean(12, false);
    if (this.bqe)
    {
      this.ccp = paramAttributeSet.getDimensionPixelSize(16, aqnm.dpToPx(25.0F));
      this.aXv = paramAttributeSet.getDimensionPixelSize(14, aqnm.dpToPx(3.0F));
      this.ccq = paramAttributeSet.getDimensionPixelSize(15, aqnm.dpToPx(6.0F));
      paramInt = paramAttributeSet.getColor(13, getResources().getColor(2131165723));
      this.bu = new Paint();
      this.bu.setAntiAlias(true);
      this.bu.setColor(paramInt);
    }
    paramAttributeSet.recycle();
    if (this.ccf > 255) {
      this.ccf = 255;
    }
    for (;;)
    {
      initPaint();
      ck(paramContext);
      if (Build.VERSION.SDK_INT >= 14) {
        setAccessibilityDelegate(new yzz(this));
      }
      return;
      if (this.ccf < 0) {
        this.ccf = 0;
      }
    }
  }
  
  private void ck(Context paramContext)
  {
    this.ef = getResources().getDrawable(2130840184);
    this.ek = new LinearLayout(paramContext);
    this.ek.setOrientation(0);
    this.ek.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    this.ek.setPadding(this.cco, 0, this.cco, 0);
    addView(this.ek);
  }
  
  private void cnp()
  {
    int i = 0;
    while (i < this.aYR)
    {
      View localView = this.ek.getChildAt(i);
      if (((localView instanceof RedTouch)) && ((((RedTouch)localView).cq() instanceof TextView))) {
        ((TextView)((RedTouch)localView).cq()).setTextSize(0, this.aii);
      }
      i += 1;
    }
  }
  
  private void initPaint()
  {
    this.aI = new Paint();
    this.aI.setAntiAlias(true);
    this.aI.setStyle(Paint.Style.FILL);
    this.aI.setTextSize(this.aii);
    this.ap = new RectF();
  }
  
  private void j(int paramInt1, String paramString, int paramInt2)
  {
    RedDotTextView localRedDotTextView = new RedDotTextView(getContext());
    localRedDotTextView.setText(paramString);
    localRedDotTextView.setGravity(17);
    int i = aqnm.dpToPx(15.0F);
    int j = aqnm.dpToPx(2.0F);
    localRedDotTextView.setPadding(i, j, i, j);
    localRedDotTextView.setSingleLine();
    paramString = new RedTouch(getContext(), localRedDotTextView).a(53).a();
    paramString.setId(paramInt2);
    k(paramInt1, paramString);
  }
  
  private void k(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new zaa(this, paramInt));
    paramView.setPadding(this.ccg, 0, this.ccg, 0);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.gravity = 17;
    if (this.ccm != 0) {
      if (paramInt != 0) {
        break label91;
      }
    }
    label91:
    for (localLayoutParams.leftMargin = 0;; localLayoutParams.leftMargin = this.ccm)
    {
      if (this.ccn != 0) {
        localLayoutParams.width = this.ccn;
      }
      this.ek.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }
  
  public void ET(int paramInt)
  {
    if (this.aYR == 0) {}
    do
    {
      View localView;
      do
      {
        return;
        setAccessibilityMsg();
        localView = this.ek.getChildAt(paramInt);
      } while (localView == null);
      paramInt = getScrollX();
      int i = this.ccg * 3;
      int j = localView.getRight() - paramInt + i - getWidth();
      if (j > 0)
      {
        smoothScrollBy(j, 0);
        return;
      }
      paramInt = localView.getLeft() - paramInt - i;
    } while (paramInt >= 0);
    smoothScrollBy(paramInt, 0);
  }
  
  public void EU(int paramInt)
  {
    if (paramInt > 255)
    {
      this.ccf = 255;
      return;
    }
    if (paramInt < 0)
    {
      this.ccf = 0;
      return;
    }
    this.ccf = paramInt;
  }
  
  public void EV(int paramInt)
  {
    this.n.put(paramInt, true);
    invalidate();
  }
  
  public void EW(int paramInt)
  {
    this.n.delete(paramInt);
    invalidate();
  }
  
  public void T(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aYS = getResources().getColor(paramInt1);
    this.aYT = getResources().getColor(paramInt2);
    this.aYU = getResources().getColor(paramInt3);
    tB(this.currentPosition);
    invalidate();
  }
  
  protected void aXq()
  {
    if (this.LB != this.currentPosition)
    {
      Object localObject = this.ek.getChildAt(this.LB);
      View localView = this.ek.getChildAt(this.currentPosition);
      if ((localObject != null) && (localView != null))
      {
        localObject = ValueAnimator.ofInt(new int[] { ((View)localObject).getLeft(), localView.getLeft() });
        ((ValueAnimator)localObject).setDuration(200L);
        ((ValueAnimator)localObject).addUpdateListener(new zab(this));
        ((ValueAnimator)localObject).start();
      }
      return;
    }
    this.aYV = this.ek.getChildAt(this.currentPosition).getLeft();
    invalidate();
  }
  
  public void b(int paramInt, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    RedTouch localRedTouch = (RedTouch)this.ek.findViewById(paramInt);
    if (localRedTouch != null) {
      localRedTouch.e(paramAppInfo);
    }
  }
  
  public void bx(int paramInt, String paramString)
  {
    if ((this.bD == null) || (this.dw == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.dw.length)
      {
        if (this.dw[i] == paramInt)
        {
          this.bD[i] = paramString;
          return;
        }
        i += 1;
      }
    }
  }
  
  public int getCurrentPosition()
  {
    return this.currentPosition;
  }
  
  public void h(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.currentPosition != paramInt) && (this.currentPosition >= 0))
    {
      this.LB = this.currentPosition;
      this.currentPosition = paramInt;
      tB(paramInt);
      ET(this.currentPosition);
      if (!paramBoolean1) {
        break label69;
      }
      aXq();
    }
    for (;;)
    {
      if (this.b != null) {
        this.b.d(paramInt, paramBoolean2);
      }
      return;
      label69:
      View localView = this.ek.getChildAt(this.currentPosition);
      if (localView != null) {
        this.aYV = localView.getLeft();
      }
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
    cnp();
    getViewTreeObserver().addOnGlobalLayoutListener(this.c);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.aYR == 0)) {
      return;
    }
    int i = getHeight();
    this.aI.setColor(this.aYU);
    this.aI.setAlpha(this.ccf);
    Object localObject = this.ek.getChildAt(this.currentPosition);
    int j;
    int k;
    int m;
    if (localObject != null)
    {
      if (!this.bqe) {
        break label322;
      }
      i = (((View)localObject).getWidth() - this.ccg * 2 - 60 - this.ccp) / 2;
      j = this.aYV;
      k = this.ccg;
      m = this.aYV;
      int i1 = ((View)localObject).getWidth();
      int i2 = this.ccg;
      int i3 = (((View)localObject).getHeight() + this.aii) / 2;
      this.ap.set(j + k + 30 + i, this.ccq + i3, m + i1 - i2 - 30 - i, i3 + this.ccq + this.aXv);
      paramCanvas.drawRect(this.ap, this.bu);
    }
    for (;;)
    {
      i = 0;
      while (i < this.aYR)
      {
        if (this.n.get(i))
        {
          localObject = (TextView)((RedTouch)this.ek.getChildAt(i)).cq();
          k = ((TextView)localObject).getRight();
          j = ((TextView)localObject).getTop();
          k -= this.ccg;
          m = aqnm.dip2px(10.0F);
          this.ef.setBounds(k, j, k + m, m + j);
          this.ef.draw(paramCanvas);
        }
        i += 1;
      }
      break;
      label322:
      RectF localRectF = this.ap;
      float f1 = this.aYV + this.ccg - this.cci;
      float f2 = this.cch;
      j = this.aYV;
      localRectF.set(f1, f2, ((View)localObject).getWidth() + j - this.ccg + this.cci, i - this.cch);
      paramCanvas.drawRoundRect(this.ap, this.ccj, this.cck, this.aI);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Yzw != null)
      {
        this.jdField_a_of_type_Yzw.Bg(true);
        continue;
        if (this.jdField_a_of_type_Yzw != null) {
          this.jdField_a_of_type_Yzw.Bg(false);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      if (this.jdField_a_of_type_Yzw != null) {
        this.jdField_a_of_type_Yzw.Bg(false);
      }
    }
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
          String str2 = this.bD[i] + acfp.m(2131714599);
          String str1 = str2;
          if (i == this.currentPosition) {
            str1 = str2 + acfp.m(2131714600);
          }
          localView.setContentDescription(str1);
        }
        i += 1;
      }
    }
  }
  
  public void setCheckedTextColor(int paramInt)
  {
    this.aYS = paramInt;
  }
  
  public void setCurrentPosition(int paramInt, boolean paramBoolean)
  {
    h(paramInt, paramBoolean, false);
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.aYU = paramInt;
  }
  
  public void setInterceptListener(yzw paramyzw)
  {
    this.jdField_a_of_type_Yzw = paramyzw;
  }
  
  public void setOnTabClickListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator$a = parama;
  }
  
  public void setOnTabListener(b paramb)
  {
    this.b = paramb;
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
  
  public void tB(int paramInt)
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
  
  public void tC(int paramInt)
  {
    RedTouch localRedTouch = (RedTouch)this.ek.findViewById(paramInt);
    if ((localRedTouch != null) && (localRedTouch.aux())) {
      localRedTouch.dGB();
    }
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.ccn = paramInt1;
    this.ccm = paramInt2;
    this.ccg = paramInt3;
    this.cco = paramInt4;
    if (this.ek != null) {
      this.ek.setPadding(paramInt4, 0, paramInt4, 0);
    }
    if ((this.ek != null) && (this.dw != null) && (this.dw.length > 0) && (this.bD != null) && (this.bD.length > 0)) {
      notifyDataSetChanged();
    }
    if (QLog.isColorLevel()) {
      QLog.i("SimpleSlidingIndicator", 2, "update, tabWidth[" + paramInt1 + "], gap[" + paramInt2 + "], plr[" + paramInt3 + "], cplr[" + paramInt4 + "], pos[" + this.currentPosition);
    }
  }
  
  public static abstract interface a
  {
    public abstract void hf(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract int d(int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator
 * JD-Core Version:    0.7.0.1
 */