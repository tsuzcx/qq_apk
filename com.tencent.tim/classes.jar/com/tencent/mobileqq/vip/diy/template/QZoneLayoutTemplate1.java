package com.tencent.mobileqq.vip.diy.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QZoneLayoutTemplate1
  extends ViewGroup
{
  protected int AD;
  private ImageView Fo;
  private ImageView Fp;
  protected int borderWidth;
  protected int height;
  protected List<View> mItems;
  protected int width;
  
  public QZoneLayoutTemplate1(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QZoneLayoutTemplate1(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new ColorDrawable(-16777216);
    this.mItems = new ArrayList();
    this.Fo = new ImageView(paramContext);
    this.Fp = new ImageView(paramContext);
    this.Fo.setImageDrawable(paramAttributeSet);
    this.Fp.setImageDrawable(paramAttributeSet);
    super.addView(this.Fo);
    super.addView(this.Fp);
    this.AD = dip2px(8.0F);
  }
  
  private int dip2px(float paramFloat)
  {
    return (int)(getContext().getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    this.mItems.add(paramView);
    paramView.setPadding(this.borderWidth, this.borderWidth, this.borderWidth, this.borderWidth);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = this.width / 3;
    if (this.mItems.size() > 0) {
      ((View)this.mItems.get(0)).layout(0, 0, paramInt1, paramInt1);
    }
    if (this.mItems.size() > 1)
    {
      ((View)this.mItems.get(1)).layout(this.AD + paramInt1, 0, paramInt1 * 2 + this.AD, paramInt1);
      this.Fp.layout(paramInt1 * 2 + this.AD * 2, 0, this.width, paramInt1);
    }
    if (this.mItems.size() > 2)
    {
      ((View)this.mItems.get(2)).layout(this.width - paramInt1 * 2 - this.AD, this.AD + paramInt1, this.width - paramInt1 - this.AD, this.height);
      this.Fo.layout(0, this.AD + paramInt1, paramInt1 - this.AD * 2, this.height);
    }
    if (this.mItems.size() > 3) {
      ((View)this.mItems.get(3)).layout(this.width - paramInt1, paramInt1 + this.AD, this.width, this.height);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.width = View.MeasureSpec.getSize(paramInt1);
    this.height = (this.width * 2 / 3 + this.AD);
    paramInt1 = this.width / 3;
    this.Fp.measure(View.MeasureSpec.makeMeasureSpec(this.width - paramInt1 * 2 - this.AD * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    this.Fo.measure(View.MeasureSpec.makeMeasureSpec(this.width - paramInt1 * 2 - this.AD * 2, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    if (this.mItems.size() > 0) {
      ((View)this.mItems.get(0)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.mItems.size() > 1) {
      ((View)this.mItems.get(1)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.mItems.size() > 2) {
      ((View)this.mItems.get(2)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.mItems.size() > 3) {
      ((View)this.mItems.get(3)).measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824));
    }
    if (this.mItems.size() > 2)
    {
      setMeasuredDimension(this.width, this.height);
      return;
    }
    setMeasuredDimension(this.width, paramInt1);
  }
  
  public void removeAllViewsInLayout()
  {
    super.removeAllViewsInLayout();
    super.addView(this.Fo);
    super.addView(this.Fp);
    this.mItems.clear();
  }
  
  public void setBorderColor(int paramInt)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext()) {
      ((View)localIterator.next()).setBackgroundColor(paramInt);
    }
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.borderWidth = paramInt;
  }
  
  public void setItemBg(Drawable paramDrawable, int paramInt)
  {
    Iterator localIterator = this.mItems.iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if (paramDrawable != null) {
        localView.setBackgroundDrawable(paramDrawable);
      } else {
        localView.setBackgroundColor(paramInt);
      }
    }
  }
  
  public void setLeftView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.Fo.setImageDrawable(paramString);
  }
  
  public void setRightView(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = URLDrawable.getDrawable(paramString, URLDrawable.URLDrawableOptions.obtain());
    this.Fp.setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1
 * JD-Core Version:    0.7.0.1
 */