package com.tencent.widget;

import acfp;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class FormMultiLineItem
  extends RelativeLayout
{
  private ImageView Hk;
  private int acv = -1;
  private int etq;
  private int etr;
  private int mBgType;
  private int mImageHeight;
  private int mImageWidth;
  private ArrayList<MultiImageTextView> mLines;
  private int mMarginLeft;
  private int mMarginRight;
  private int minHeight;
  
  public FormMultiLineItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FormMultiLineItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g(paramAttributeSet);
    initView();
  }
  
  private void bl(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt3 = 0;
    paramInt2 = paramInt1;
    paramInt1 = paramInt3;
    while (paramInt1 < this.acv)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.mLines.get(paramInt1)).getLayoutParams();
      localLayoutParams.topMargin = paramInt2;
      localLayoutParams.leftMargin = this.etr;
      paramInt2 += ((MultiImageTextView)this.mLines.get(paramInt1)).getMeasuredHeight();
      ((MultiImageTextView)this.mLines.get(paramInt1)).setLayoutParams(localLayoutParams);
      paramInt1 += 1;
    }
  }
  
  private void g(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.rc);
    try
    {
      if (this.acv < 0) {
        this.acv = paramAttributeSet.getInt(5, 2);
      }
      this.mImageWidth = paramAttributeSet.getDimensionPixelSize(3, 0);
      this.mImageHeight = paramAttributeSet.getDimensionPixelSize(2, 0);
      this.minHeight = paramAttributeSet.getDimensionPixelSize(6, 0);
      int i = getResources().getDimensionPixelSize(2131296916);
      int j = getResources().getDimensionPixelSize(2131296918);
      int k = getResources().getDimensionPixelSize(2131296914);
      this.mMarginLeft = paramAttributeSet.getDimensionPixelSize(4, i);
      this.mMarginRight = paramAttributeSet.getDimensionPixelSize(8, j);
      this.etr = paramAttributeSet.getDimensionPixelSize(7, k);
      this.mBgType = paramAttributeSet.getInteger(0, 0);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FormMultiLineItem", 2, localException.toString());
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void initView()
  {
    if ((this.acv < 2) && (this.acv > 0)) {
      throw new RuntimeException("mLineNum < 2, recommend to use FormSimpleItem");
    }
    int m = getResources().getDimensionPixelSize(2131296925);
    int j = getResources().getDimensionPixelSize(2131296934);
    int k = getResources().getDimensionPixelSize(2131296923);
    int i;
    MultiImageTextView localMultiImageTextView;
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.acv == 2)
    {
      i = getResources().getDimensionPixelSize(2131296909);
      this.etq = k;
      setBackgroundDrawable(o(getResources(), this.mBgType));
      setMinimumHeight(this.minHeight);
      setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
      this.Hk = new ImageView(getContext());
      this.Hk.setId(2131367506);
      this.Hk.setFocusable(false);
      this.Hk.setClickable(false);
      this.Hk.setScaleType(ImageView.ScaleType.FIT_XY);
      addView(this.Hk);
      this.mLines = new ArrayList();
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setId(2131367504);
      localMultiImageTextView.setTextSize(0, m);
      localMultiImageTextView.setTextColor(getResources().getColor(2131167366));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(acfp.m(2131706431));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(1, 2131367506);
      localLayoutParams.bottomMargin = i;
      localLayoutParams.leftMargin = this.etr;
      this.mLines.add(localMultiImageTextView);
      addView(localMultiImageTextView, localLayoutParams);
      i = 1;
      label314:
      if (i >= this.acv) {
        return;
      }
      localMultiImageTextView = new MultiImageTextView(getContext());
      localMultiImageTextView.setTextSize(0, j);
      localMultiImageTextView.setTextColor(getResources().getColor(2131167385));
      localMultiImageTextView.setSingleLine(true);
      localMultiImageTextView.setDuplicateParentStateEnabled(true);
      localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
      localMultiImageTextView.setText(acfp.m(2131706433));
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.leftMargin = this.etr;
      localLayoutParams.addRule(1, 2131367506);
      if (i != 1) {
        break label487;
      }
      localMultiImageTextView.setId(2131367510);
    }
    for (;;)
    {
      if (i != this.acv - 1) {
        localLayoutParams.bottomMargin = k;
      }
      addView(localMultiImageTextView, localLayoutParams);
      this.mLines.add(localMultiImageTextView);
      i += 1;
      break label314;
      i = getResources().getDimensionPixelSize(2131296924);
      break;
      label487:
      if (i == 2) {
        localMultiImageTextView.setId(2131367511);
      }
    }
  }
  
  public static Drawable o(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130839682);
    case 0: 
      return paramResources.getDrawable(2130839682);
    case 1: 
      return paramResources.getDrawable(2130839701);
    case 2: 
      return paramResources.getDrawable(2130839695);
    }
    return paramResources.getDrawable(2130839689);
  }
  
  public ImageView G()
  {
    return this.Hk;
  }
  
  public MultiImageTextView a(int paramInt)
  {
    if ((paramInt >= this.acv) || (paramInt < 0)) {
      throw new RuntimeException("Qui MultiLineItem array index out of range");
    }
    return (MultiImageTextView)this.mLines.get(paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mImageHeight == 0)
    {
      if (this.acv == 2) {
        this.mImageHeight = getResources().getDimensionPixelSize(2131296908);
      }
    }
    else
    {
      if (this.mImageWidth == 0)
      {
        if (this.acv != 2) {
          break label226;
        }
        this.mImageWidth = getResources().getDimensionPixelSize(2131296908);
      }
      label58:
      if (this.minHeight == 0) {
        if (this.acv != 2) {
          break label243;
        }
      }
    }
    RelativeLayout.LayoutParams localLayoutParams;
    int j;
    int i;
    label226:
    label243:
    for (this.minHeight = getResources().getDimensionPixelSize(2131296907);; this.minHeight = getResources().getDimensionPixelSize(2131296921))
    {
      setMinimumHeight(this.minHeight);
      setPadding(this.mMarginLeft, 0, this.mMarginRight, 0);
      localLayoutParams = new RelativeLayout.LayoutParams(this.mImageWidth, this.mImageHeight);
      this.Hk.setLayoutParams(localLayoutParams);
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(15, -1);
      j = 0;
      i = 0;
      while (j < this.acv)
      {
        ((MultiImageTextView)this.mLines.get(j)).measure(paramInt1, paramInt2);
        i += ((MultiImageTextView)this.mLines.get(j)).getMeasuredHeight();
        j += 1;
      }
      this.mImageHeight = getResources().getDimensionPixelSize(2131296922);
      break;
      this.mImageWidth = getResources().getDimensionPixelSize(2131296922);
      break label58;
    }
    this.Hk.measure(paramInt1, paramInt2);
    if ((this.Hk.getMeasuredHeight() > i) || (this.acv <= 3))
    {
      j = this.etq;
      int k = this.acv;
      bl((this.minHeight - (j * (k - 1) + i)) / 2, paramInt1, paramInt2);
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      i = getResources().getDimensionPixelSize(2131296919);
      j = getResources().getDimensionPixelSize(2131296915);
      localLayoutParams = (RelativeLayout.LayoutParams)this.Hk.getLayoutParams();
      localLayoutParams.topMargin = i;
      this.Hk.setLayoutParams(localLayoutParams);
      bl(i, paramInt1, paramInt2);
      localLayoutParams = (RelativeLayout.LayoutParams)((MultiImageTextView)this.mLines.get(this.acv - 1)).getLayoutParams();
      localLayoutParams.bottomMargin = j;
      ((MultiImageTextView)this.mLines.get(this.acv - 1)).setLayoutParams(localLayoutParams);
    }
  }
  
  public void setAllTextColor(int paramInt)
  {
    ColorStateList localColorStateList = getResources().getColorStateList(paramInt);
    Iterator localIterator = this.mLines.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextColor(localColorStateList);
    }
  }
  
  public void setAllTextSize(float paramFloat)
  {
    Iterator localIterator = this.mLines.iterator();
    while (localIterator.hasNext()) {
      ((MultiImageTextView)localIterator.next()).setTextSize(paramFloat);
    }
  }
  
  public void setBackGroundByType(int paramInt)
  {
    setBackgroundDrawable(o(getResources(), paramInt));
  }
  
  public void setHeaderView(int paramInt)
  {
    if (this.Hk != null) {
      this.Hk.setImageResource(paramInt);
    }
  }
  
  public void setHeaderWeight(int paramInt1, int paramInt2)
  {
    this.mImageWidth = paramInt1;
    this.mImageHeight = paramInt2;
  }
  
  public void setLineNum(int paramInt)
  {
    if (paramInt < 2) {
      throw new RuntimeException("recommend to use >=2 lineNum, or use FormSingleItem widget");
    }
    if (this.acv == paramInt) {}
    for (;;)
    {
      postInvalidate();
      return;
      int i;
      if (this.acv < paramInt)
      {
        int j = getResources().getDimensionPixelSize(2131296934);
        int k = this.acv;
        i = 0;
        while (i < paramInt - k)
        {
          MultiImageTextView localMultiImageTextView = new MultiImageTextView(getContext());
          localMultiImageTextView.setTextSize(0, j);
          localMultiImageTextView.setTextColor(getResources().getColor(2131167385));
          localMultiImageTextView.setSingleLine(true);
          localMultiImageTextView.setDuplicateParentStateEnabled(true);
          localMultiImageTextView.setEllipsize(TextUtils.TruncateAt.END);
          localMultiImageTextView.setText(acfp.m(2131706432));
          RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
          localLayoutParams.leftMargin = this.etr;
          localLayoutParams.addRule(1, 2131367506);
          this.mLines.add(localMultiImageTextView);
          addView(localMultiImageTextView, localLayoutParams);
          i += 1;
        }
        this.acv = paramInt;
      }
      else if (this.acv > paramInt)
      {
        i = this.acv;
        while (i > paramInt)
        {
          this.mLines.remove(this.acv - 1);
          i -= 1;
        }
        this.acv = paramInt;
      }
    }
  }
  
  public void setMarginLeftRight(int paramInt1, int paramInt2)
  {
    this.mMarginLeft = paramInt1;
    this.mMarginRight = paramInt2;
  }
  
  public void setmMinHeight(int paramInt)
  {
    this.minHeight = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.FormMultiLineItem
 * JD-Core Version:    0.7.0.1
 */