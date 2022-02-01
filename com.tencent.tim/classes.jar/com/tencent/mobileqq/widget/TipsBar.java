package com.tencent.mobileqq.widget;

import acfp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import arjm;
import atau.a;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.theme.SkinnableBitmapDrawable;

public class TipsBar
  extends RelativeLayout
{
  private View EY;
  private int aqk;
  private String cAB;
  private int eiB;
  private int eiC;
  private int eiD;
  protected ImageView gX;
  private Drawable gw;
  protected ImageView ir;
  protected Button mButton;
  private float mDensity;
  private int mIconHeight;
  private ImageView mIconView;
  private int mIconWidth;
  private int mItemHeight;
  private View.OnClickListener mListener;
  private int mTextPadding;
  protected TextView mTextView;
  private String mTipsText;
  private boolean showCloseBtn;
  
  public TipsBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TipsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Resources localResources = getResources();
    this.mDensity = localResources.getDisplayMetrics().density;
    this.mItemHeight = localResources.getDimensionPixelSize(2131298894);
    this.aqk = localResources.getDimensionPixelSize(2131298896);
    this.mTextPadding = localResources.getDimensionPixelSize(2131298898);
    this.eiC = localResources.getDimensionPixelSize(2131298897);
    this.eiD = localResources.getDimensionPixelSize(2131298897);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sz);
    this.mTipsText = paramContext.getString(6);
    this.gw = paramContext.getDrawable(5);
    this.cAB = paramContext.getString(1);
    this.eiB = paramContext.getInt(0, 2);
    this.showCloseBtn = paramContext.getBoolean(4, false);
    this.mIconWidth = paramContext.getDimensionPixelSize(3, this.eiC);
    this.mIconHeight = paramContext.getDimensionPixelSize(2, this.eiD);
    paramContext.recycle();
    initViews();
  }
  
  private ImageView E()
  {
    Resources localResources = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setImageDrawable(n(localResources, this.eiB));
    return localImageView;
  }
  
  protected static ColorStateList e(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    default: 
      return paramResources.getColorStateList(2131167337);
    }
    return paramResources.getColorStateList(2131167337);
  }
  
  private void eji()
  {
    this.gX.setId(2131379760);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.rightMargin = this.aqk;
    localLayoutParams.leftMargin = this.aqk;
    localLayoutParams.addRule(11);
    localLayoutParams.addRule(15);
    addView(this.gX, localLayoutParams);
  }
  
  protected static ColorStateList f(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131167383);
    case 4: 
      return paramResources.getColorStateList(2131167453);
    }
    return paramResources.getColorStateList(2131167311);
  }
  
  private Button f()
  {
    Resources localResources = getResources();
    Button localButton = new Button(getContext());
    localButton.setText(this.cAB);
    localButton.setContentDescription(this.cAB);
    localButton.setTextSize(2, 14.0F);
    localButton.setTextColor(e(localResources, this.eiB));
    localButton.setMinWidth((int)(this.mDensity * 48.0F + 0.5D));
    localButton.setMinHeight((int)(this.mDensity * 24.0F + 0.5D));
    localButton.setSingleLine(true);
    localButton.setEllipsize(TextUtils.TruncateAt.END);
    localButton.setGravity(17);
    localButton.setBackgroundDrawable(m(localResources, this.eiB));
    int i = (int)(this.mDensity * 10.0F + 0.5D);
    localButton.setPadding(i, i / 2, i, i / 2);
    localButton.setOnClickListener(this.mListener);
    return localButton;
  }
  
  private void initViews()
  {
    setFocusable(true);
    setClickable(true);
    Resources localResources = getResources();
    this.mIconView = new ImageView(getContext());
    this.mIconView.setId(2131379758);
    this.mIconView.setScaleType(ImageView.ScaleType.FIT_XY);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.mIconWidth, this.mIconHeight);
    localLayoutParams.leftMargin = this.aqk;
    localLayoutParams.addRule(9);
    localLayoutParams.addRule(15);
    addView(this.mIconView, localLayoutParams);
    this.mTextView = new TextView(getContext());
    this.mTextView.setId(2131379759);
    this.mTextView.setSingleLine(true);
    this.mTextView.setGravity(19);
    this.mTextView.setEllipsize(TextUtils.TruncateAt.END);
    this.mTextView.setTextSize(2, 14.0F);
    this.mTextView.setTextColor(f(localResources, this.eiB));
    this.mTextView.setDuplicateParentStateEnabled(true);
    if (!TextUtils.isEmpty(this.mTipsText))
    {
      this.mTextView.setText(this.mTipsText);
      this.mTextView.setContentDescription(this.mTipsText);
    }
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    if (this.gw != null)
    {
      localLayoutParams.leftMargin = this.mTextPadding;
      localLayoutParams.addRule(15);
      localLayoutParams.addRule(1, 2131379758);
      localLayoutParams.addRule(0, 2131379760);
      addView(this.mTextView, localLayoutParams);
      this.mIconView.setVisibility(8);
      if (this.gw != null) {
        setTipsIcon(this.gw, this.mIconWidth, this.mIconHeight);
      }
      this.mButton = f();
      this.ir = D();
      this.gX = E();
      if (TextUtils.isEmpty(this.cAB)) {
        break label367;
      }
      ehJ();
    }
    for (;;)
    {
      setBackgroundDrawable(e(localResources, this.eiB));
      ehH();
      return;
      localLayoutParams.leftMargin = this.aqk;
      break;
      label367:
      if (this.showCloseBtn) {
        ehI();
      } else {
        eji();
      }
    }
  }
  
  private Drawable l(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (paramResources = paramResources.getDrawable(2130839722);; paramResources = paramResources.getDrawable(2130839722)) {
      return F(paramResources);
    }
  }
  
  public static Drawable m(Resources paramResources, int paramInt)
  {
    return paramResources.getDrawable(2130839559);
  }
  
  protected ImageView D()
  {
    Object localObject = getResources();
    ImageView localImageView = new ImageView(getContext());
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localObject = l((Resources)localObject, this.eiB);
    localImageView.setPadding(15, 15, 15, 15);
    localImageView.setImageDrawable((Drawable)localObject);
    localImageView.setOnClickListener(new arjm(this));
    if (AppSetting.enableTalkBack) {
      localImageView.setContentDescription(acfp.m(2131715360));
    }
    return localImageView;
  }
  
  Drawable F(Drawable paramDrawable)
  {
    Object localObject2;
    Object localObject1;
    Bitmap localBitmap;
    Resources localResources;
    if (!(paramDrawable instanceof SkinnableBitmapDrawable))
    {
      localObject2 = paramDrawable;
      if (!(paramDrawable instanceof BitmapDrawable)) {}
    }
    else
    {
      localObject1 = null;
      if (!(paramDrawable instanceof SkinnableBitmapDrawable)) {
        break label143;
      }
      localObject1 = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      localBitmap = Bitmap.createBitmap((Bitmap)localObject1);
      localResources = getResources();
      localObject2 = paramDrawable;
      if (localResources != null)
      {
        if ((localObject1 == null) || (localBitmap != null)) {
          break label161;
        }
        localObject2 = localObject1;
      }
    }
    label143:
    label161:
    do
    {
      do
      {
        paramDrawable = new BitmapDrawable(localResources, (Bitmap)localObject1);
        localObject1 = new BitmapDrawable(localResources, (Bitmap)localObject2);
        ((BitmapDrawable)localObject1).setAlpha(127);
        localObject2 = new StateListDrawable();
        ((StateListDrawable)localObject2).addState(new int[] { 16842919, 16842910 }, (Drawable)localObject1);
        ((StateListDrawable)localObject2).addState(new int[] { 16842908 }, paramDrawable);
        ((StateListDrawable)localObject2).addState(new int[0], paramDrawable);
        return localObject2;
        if (!(paramDrawable instanceof BitmapDrawable)) {
          break;
        }
        localObject1 = ((BitmapDrawable)paramDrawable).getBitmap();
        break;
        localObject2 = localBitmap;
      } while (localObject1 != null);
      localObject2 = localBitmap;
    } while (localBitmap != null);
    return paramDrawable;
  }
  
  public ImageView F()
  {
    return this.mIconView;
  }
  
  public int MN()
  {
    return this.eiB;
  }
  
  public void TB(boolean paramBoolean)
  {
    if (this.ir == null) {
      this.ir = D();
    }
    removeView(this.ir);
    removeView(this.mButton);
    removeView(this.gX);
    if (paramBoolean) {
      ehI();
    }
  }
  
  public View cC()
  {
    return this.EY;
  }
  
  protected Drawable e(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramResources = paramResources.getDrawable(2130839642);
    }
    for (;;)
    {
      return F(paramResources);
      paramResources = paramResources.getDrawable(2130839642);
      continue;
      paramResources = paramResources.getDrawable(2130839718);
      continue;
      paramResources = paramResources.getDrawable(2130839714);
      continue;
      paramResources = paramResources.getDrawable(2130839643);
    }
  }
  
  public void ehH()
  {
    if (ThemeUtil.isNowThemeIsNight(null, true, null)) {
      if (this.EY == null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.EY = new View(getContext());
        this.EY.setId(2131379757);
        this.EY.setBackgroundColor(Color.parseColor("#7f000000"));
        addView(this.EY, localLayoutParams);
      }
    }
    while (this.EY == null)
    {
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    removeView(this.EY);
    this.EY = null;
  }
  
  protected void ehI()
  {
    if (this.ir != null)
    {
      this.ir.setId(2131379760);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = this.aqk;
      localLayoutParams.leftMargin = this.aqk;
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.ir, localLayoutParams);
    }
  }
  
  protected void ehJ()
  {
    if (this.mButton != null)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.rightMargin = this.aqk;
      localLayoutParams.leftMargin = this.aqk;
      this.mButton.setId(2131379760);
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(15);
      addView(this.mButton, localLayoutParams);
    }
  }
  
  public Button getButton()
  {
    return this.mButton;
  }
  
  public TextView getTextView()
  {
    return this.mTextView;
  }
  
  protected Drawable n(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (paramResources = paramResources.getDrawable(2130851155);; paramResources = paramResources.getDrawable(2130839713)) {
      return F(paramResources);
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(this.mItemHeight, 1073741824));
    setMeasuredDimension(getMeasuredWidth(), this.mItemHeight);
  }
  
  public void setBarType(int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3) && (paramInt != 4) && (paramInt != 5) && (paramInt != 6)) {
      throw new RuntimeException("Parameter bgType is illegal!");
    }
    if (paramInt == this.eiB) {}
    Resources localResources;
    do
    {
      return;
      this.eiB = paramInt;
      localResources = getResources();
      if (this.mTextView != null) {
        this.mTextView.setTextColor(f(localResources, this.eiB));
      }
      setBackgroundDrawable(e(localResources, this.eiB));
      Drawable localDrawable;
      if (this.gX != null)
      {
        localDrawable = n(localResources, this.eiB);
        this.gX.setImageDrawable(localDrawable);
      }
      if (this.ir != null)
      {
        localDrawable = l(localResources, this.eiB);
        this.ir.setImageDrawable(localDrawable);
      }
    } while (this.mButton == null);
    this.mButton.setTextColor(e(localResources, this.eiB));
    this.mButton.setBackgroundDrawable(m(localResources, this.eiB));
  }
  
  public void setButtonText(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.mButton == null) {
        this.mButton = f();
      }
      removeView(this.mButton);
      removeView(this.gX);
      removeView(this.ir);
      this.cAB = paramCharSequence.toString();
      this.mButton.setText(this.cAB);
      ehJ();
    }
  }
  
  public void setCloseListener(View.OnClickListener paramOnClickListener)
  {
    if ((paramOnClickListener != null) && (this.ir != null)) {
      this.ir.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mListener = paramOnClickListener;
    if ((!TextUtils.isEmpty(this.cAB)) && (this.mButton != null))
    {
      this.mButton.setOnClickListener(this.mListener);
      return;
    }
    super.setOnClickListener(this.mListener);
  }
  
  public void setOriginalOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setTipsIcon(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mTextView.getLayoutParams();
    localLayoutParams.leftMargin = this.mTextPadding;
    this.mTextView.setLayoutParams(localLayoutParams);
    this.mIconView.setVisibility(0);
    this.gw = F(paramDrawable);
    int i = paramDrawable.getIntrinsicHeight();
    paramDrawable.setBounds(0, 0, this.eiC, this.eiD);
    if (i > this.mItemHeight)
    {
      this.mIconView.setImageDrawable(this.gw);
      return;
    }
    this.mIconView.setImageDrawable(this.gw);
  }
  
  public void setTipsIcon(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable == null) || (this.mTextView == null) || (paramInt1 < 0) || (paramInt2 < 0)) {}
    do
    {
      return;
      this.mIconView.setVisibility(0);
      if ((paramInt1 > 0) && (paramInt2 > 0))
      {
        this.gw = F(paramDrawable);
        this.mIconWidth = paramInt1;
        this.mIconHeight = Math.min(this.mItemHeight, paramInt2);
        this.gw.setBounds(0, 0, this.mIconWidth, this.mIconHeight);
        this.mIconView.setImageDrawable(this.gw);
        return;
      }
    } while ((paramInt1 != 0) && (paramInt2 != 0));
    setTipsIcon(paramDrawable);
  }
  
  public void setTipsText(CharSequence paramCharSequence)
  {
    this.mTipsText = paramCharSequence.toString();
    this.mTextView.setText(this.mTipsText);
    this.mTextView.setContentDescription(this.mTipsText);
  }
  
  public void showArrow(boolean paramBoolean)
  {
    if (this.gX == null) {
      this.gX = E();
    }
    removeView(this.gX);
    removeView(this.mButton);
    removeView(this.ir);
    if (paramBoolean) {
      eji();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TipsBar
 * JD-Core Version:    0.7.0.1
 */