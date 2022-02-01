package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arfs;
import arft;
import atau.a;
import com.tencent.mobileqq.theme.ThemeUtil;

public class FormEditItem
  extends RelativeLayout
  implements arft
{
  private CharSequence aC;
  private CharSequence aD;
  private CharSequence aE;
  private final boolean aYy;
  private EditText ah;
  private int efQ;
  private int efR = -2;
  private int efS = -2;
  private int efT;
  private int efU;
  private int efV;
  private TextView kK;
  private int mBgType;
  private ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new arfs(this);
  private int mItemHeight;
  private Drawable mLeftIcon;
  private int mLeftIconHeight;
  private int mLeftIconWidth;
  protected boolean mNeedSetHeight;
  private int mPadding;
  private final Paint mPaint = new Paint();
  private final Rect mRect = new Rect();
  private TextView xt;
  
  public FormEditItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormEditItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = getResources().getDimensionPixelSize(2131298645);
    int j = getResources().getDimensionPixelSize(2131296927);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qB);
    this.mPadding = paramAttributeSet.getDimensionPixelSize(2, i);
    this.mItemHeight = paramAttributeSet.getDimensionPixelSize(1, j);
    this.aC = paramAttributeSet.getString(9);
    this.mLeftIcon = paramAttributeSet.getDrawable(6);
    this.mLeftIconWidth = paramAttributeSet.getDimensionPixelSize(8, 0);
    this.mLeftIconHeight = paramAttributeSet.getDimensionPixelSize(7, 0);
    this.mLeftIconHeight = Math.min(this.mItemHeight, this.mLeftIconHeight);
    this.aD = paramAttributeSet.getString(17);
    this.efQ = paramAttributeSet.getInt(18, 0);
    this.mBgType = paramAttributeSet.getInt(0, -1);
    this.mNeedSetHeight = paramAttributeSet.getBoolean(12, true);
    i = 300;
    this.aE = paramAttributeSet.getString(3);
    try
    {
      j = paramContext.getResources().getDimensionPixelSize(2131296920);
      i = j;
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
    this.efT = paramAttributeSet.getDimensionPixelSize(4, i);
    paramAttributeSet.recycle();
    paramContext = ThemeUtil.getCurrentThemeId();
    if (("1000".equals(paramContext)) || ("999".equals(paramContext)))
    {
      bool = true;
      this.aYy = bool;
      this.mPaint.setAntiAlias(true);
      this.mPaint.setColor(COLOR_DEFAULT_BG_DIVIDER);
      initViews();
      return;
    }
  }
  
  public static void a(TextView paramTextView, int paramInt, CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramTextView != null)
    {
      paramTextView.setWidth(paramInt);
      boolean bool = TextUtils.isEmpty(paramCharSequence);
      if (bool) {
        paramCharSequence = "";
      }
      if ((!bool) || (paramBoolean)) {
        break label51;
      }
    }
    label51:
    for (paramInt = 8;; paramInt = 0)
    {
      paramTextView.setText(paramCharSequence);
      paramTextView.setContentDescription(paramCharSequence);
      paramTextView.setVisibility(paramInt);
      return;
    }
  }
  
  private void cVP()
  {
    int i1 = 0;
    int k = this.efV - this.efT - this.mPadding * 2;
    int i;
    if (this.mLeftIcon != null) {
      if (this.mLeftIconWidth == 0)
      {
        i = this.mLeftIcon.getIntrinsicWidth();
        i += this.mPadding;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.aC)) {}
      for (int j = (int)this.xt.getPaint().measureText(this.aC.toString());; j = 0)
      {
        j = i + j;
        if (j > 0) {}
        for (i = k - this.mPadding;; i = k)
        {
          if (!TextUtils.isEmpty(this.aD)) {}
          for (int m = (int)this.kK.getPaint().measureText(this.aD.toString());; m = 0)
          {
            k = i / 2;
            int n;
            if ((j >= k) && (m >= k))
            {
              n = k;
              i = k;
              k = i1;
            }
            for (;;)
            {
              this.efR = i;
              this.efS = n;
              this.efU = (this.efT + k);
              return;
              i = this.mLeftIconWidth;
              break;
              if ((j > k) && (m < k))
              {
                int i2 = i - m;
                k = i1;
                n = m;
                i = i2;
                if (j < i2)
                {
                  k = i2 - j;
                  i = j;
                  n = m;
                }
              }
              else if ((j < k) && (m > k))
              {
                n = i - j;
                if (m < n)
                {
                  k = n - m;
                  i = j;
                  n = m;
                }
                else
                {
                  i = j;
                  k = i1;
                }
              }
              else
              {
                k = i - j - m;
                i = j;
                n = m;
              }
            }
          }
        }
      }
      i = 0;
    }
  }
  
  private void ehU()
  {
    TextView localTextView;
    int i;
    CharSequence localCharSequence;
    if (this.efV > 0)
    {
      cVP();
      localTextView = this.xt;
      i = this.efR;
      localCharSequence = this.aC;
      if (this.mLeftIcon == null) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      a(localTextView, i, localCharSequence, bool);
      a(this.kK, this.efS, this.aD, false);
      this.ah.setMaxWidth(this.efU);
      return;
    }
  }
  
  @TargetApi(16)
  private void initViews()
  {
    setFocusable(true);
    setClickable(true);
    this.kK = new TextView(getContext());
    this.kK.setId(2131367517);
    this.kK.setTextColor(FormSimpleItem.d(getResources(), this.efQ));
    int i = getContext().getResources().getDimensionPixelSize(2131296925);
    this.kK.setTextSize(0, i);
    this.kK.setGravity(19);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    localLayoutParams.rightMargin = this.mPadding;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    if (this.mNeedSetHeight)
    {
      this.kK.setSingleLine(true);
      this.kK.setEllipsize(TextUtils.TruncateAt.END);
      this.kK.setDuplicateParentStateEnabled(true);
      addView(this.kK, localLayoutParams);
      this.ah = new EditText(getContext());
      this.ah.setId(2131367514);
      this.ah.setMinWidth(this.efT);
      i = getContext().getResources().getDimensionPixelSize(2131296925);
      this.ah.setTextSize(0, i);
      this.ah.setTextColor(-16777216);
      this.ah.setGravity(21);
      this.ah.setBackgroundDrawable(null);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.mPadding;
      localLayoutParams.addRule(0, 2131367517);
      localLayoutParams.addRule(15);
      addView(this.ah, localLayoutParams);
      if (!TextUtils.isEmpty(this.aE))
      {
        this.ah.setHintTextColor(-7829368);
        this.ah.setHint(this.aE);
      }
      this.xt = new TextView(getContext());
      this.xt.setId(2131367515);
      i = getContext().getResources().getDimensionPixelSize(2131296925);
      this.xt.setTextColor(getResources().getColorStateList(2131167304));
      this.xt.setTextSize(0, i);
      this.xt.setGravity(19);
      setLeftIcon(this.mLeftIcon, this.mLeftIconWidth, this.mLeftIconHeight);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = this.mPadding;
      if (!this.mNeedSetHeight) {
        break label559;
      }
      this.xt.setSingleLine(true);
      this.xt.setEllipsize(TextUtils.TruncateAt.END);
      this.xt.setDuplicateParentStateEnabled(true);
    }
    for (;;)
    {
      localLayoutParams.addRule(9);
      localLayoutParams.addRule(0, 2131367514);
      localLayoutParams.addRule(15);
      this.xt.setMaxWidth(this.efR);
      addView(this.xt, localLayoutParams);
      getViewTreeObserver().addOnGlobalLayoutListener(this.mGlobalLayoutListener);
      if (this.mBgType >= 0) {
        setBackgroundDrawable(FormSimpleItem.c(getResources(), this.mBgType, this.aYy));
      }
      return;
      localLayoutParams.topMargin = this.mPadding;
      localLayoutParams.bottomMargin = this.mPadding;
      break;
      label559:
      localLayoutParams.topMargin = this.mPadding;
      localLayoutParams.bottomMargin = this.mPadding;
      setMinimumHeight(this.mItemHeight);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.aYy) && ((this.mBgType == 1) || (this.mBgType == 2)))
    {
      int i = getMeasuredWidth();
      int j = getMeasuredHeight();
      this.mRect.set(PADDING_DEFAULT_BG_DIVIDER, j - HEIGHT_DEFAULT_BG_DIVIDER, i, j);
      paramCanvas.drawRect(this.mRect, this.mPaint);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mNeedSetHeight) {
      try
      {
        super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
        return;
      }
      catch (Exception localException)
      {
        setMinimumHeight(this.mItemHeight);
        super.onMeasure(paramInt1, paramInt2);
        return;
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setBgType(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    this.mBgType = paramInt;
    setBackgroundDrawable(FormSwitchItem.getBgDrawable(getResources(), this.mBgType, this.aYy));
  }
  
  public void setCustomHeight(int paramInt)
  {
    if ((paramInt > 0) && (this.mNeedSetHeight))
    {
      this.mItemHeight = paramInt;
      requestLayout();
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable)
  {
    if (this.xt != null)
    {
      this.mLeftIcon = paramDrawable;
      if (paramDrawable == null) {
        this.xt.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      }
    }
    else
    {
      return;
    }
    if (paramDrawable.getIntrinsicHeight() > this.mItemHeight)
    {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), this.mItemHeight);
      this.xt.setCompoundDrawables(paramDrawable, null, null, null);
    }
    for (;;)
    {
      this.xt.setCompoundDrawablePadding(this.mPadding);
      return;
      this.xt.setCompoundDrawablesWithIntrinsicBounds(paramDrawable, null, null, null);
    }
  }
  
  public void setLeftIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.xt == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.mLeftIcon = paramDrawable;
        this.mLeftIconWidth = paramInt1;
        this.mLeftIconHeight = Math.min(this.mItemHeight, paramInt2);
        paramDrawable.setBounds(0, 0, this.mLeftIconWidth, this.mLeftIconHeight);
        this.xt.setCompoundDrawables(paramDrawable, null, null, null);
        this.xt.setCompoundDrawablePadding(this.mPadding);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setLeftIcon(paramDrawable);
  }
  
  public void setLeftText(CharSequence paramCharSequence)
  {
    if (this.xt != null)
    {
      this.aC = paramCharSequence;
      ehU();
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    this.aD = paramCharSequence;
    ehU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormEditItem
 * JD-Core Version:    0.7.0.1
 */