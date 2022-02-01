package com.tencent.mobileqq.onlinestatus;

import akto;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime.Status;
import wja;

public class OnlineStatusListLayout
  extends ViewGroup
{
  private int dpb;
  private int dpc;
  private int dpd;
  private int mItemHeight;
  private int mItemWidth;
  private int mTopPadding;
  
  public OnlineStatusListLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public OnlineStatusListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean a(akto paramakto1, akto paramakto2)
  {
    if ((paramakto1 == null) || (paramakto2 == null) || (paramakto1.f.getValue() != paramakto2.f.getValue())) {}
    while (paramakto1.id != paramakto2.id) {
      return false;
    }
    return true;
  }
  
  private void init()
  {
    this.dpd = wja.dp2px(12.0F, getResources());
    this.mTopPadding = wja.dp2px(16.0F, getResources());
    setPadding(this.dpd, this.mTopPadding, this.dpd, 0);
    this.dpb = wja.dp2px(16.0F, getResources());
    this.dpc = wja.dp2px(20.0F, getResources());
    this.mItemHeight = wja.dp2px(32.0F, getResources());
  }
  
  private int iv(int paramInt)
  {
    int i = (paramInt + 1) / 3;
    if ((paramInt + 1) % 3 == 0) {}
    for (paramInt = 0;; paramInt = 1) {
      return paramInt + i;
    }
  }
  
  public void a(List<akto> paramList, View.OnClickListener paramOnClickListener)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      akto localakto = (akto)paramList.get(i);
      OnlineStatusItemView localOnlineStatusItemView = new OnlineStatusItemView(getContext());
      localOnlineStatusItemView.b(localakto);
      localOnlineStatusItemView.setTag(localakto);
      localOnlineStatusItemView.setOnClickListener(paramOnClickListener);
      addView(localOnlineStatusItemView);
      i += 1;
    }
  }
  
  public void c(akto paramakto)
  {
    if (paramakto == null) {}
    for (;;)
    {
      return;
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        Object localObject = getChildAt(i);
        if ((localObject instanceof OnlineStatusItemView))
        {
          localObject = (OnlineStatusItemView)localObject;
          ((OnlineStatusItemView)localObject).Nm(a(((OnlineStatusItemView)localObject).b, paramakto));
        }
        i += 1;
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getWidth() > 0) {}
    for (paramInt1 = getWidth();; paramInt1 = getResources().getDisplayMetrics().widthPixels)
    {
      this.mItemWidth = ((paramInt1 - this.dpd * 2 - this.dpb * 2) / 3);
      paramInt1 = 0;
      paramInt2 = getChildCount();
      while (paramInt1 < paramInt2)
      {
        paramInt3 = this.dpd + paramInt1 % 3 * (this.mItemWidth + this.dpb);
        paramInt4 = this.mTopPadding + (iv(paramInt1) - 1) * (this.mItemHeight + this.dpc);
        getChildAt(paramInt1).layout(paramInt3, paramInt4, this.mItemWidth + paramInt3, this.mItemHeight + paramInt4);
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusListLayout", 2, "onLayout : startX -> " + paramInt3 + ", startY -> " + paramInt4 + ", getRowByChildIndex(i) -> " + iv(paramInt1));
        }
        paramInt1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {}
    for (i = View.MeasureSpec.getSize(paramInt2);; i = iv(i - 1) * (this.mItemHeight + this.dpc) - this.dpc)
    {
      setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), i);
      measureChildren(paramInt1, View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.getMode(paramInt2)));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusListLayout
 * JD-Core Version:    0.7.0.1
 */