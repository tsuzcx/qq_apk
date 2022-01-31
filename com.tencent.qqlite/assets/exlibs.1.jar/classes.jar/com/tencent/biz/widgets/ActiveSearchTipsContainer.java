package com.tencent.biz.widgets;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import st;

public class ActiveSearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  public static final int a = 1000;
  public static final String a = "ActiveSearchTipsContainer";
  private static final int b = 14;
  private static final int c = 10;
  private static final int d = 8;
  private static final int e = 10;
  private static final int f = 6;
  private ActiveSearchTipsContainer.OnTipClickListener a;
  private int g;
  private int h = 6;
  
  public ActiveSearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = new DisplayMetrics();
    ((Activity)paramContext).getWindow().getWindowManager().getDefaultDisplay().getMetrics(paramAttributeSet);
    this.g = paramAttributeSet.heightPixels;
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130838211);
    localButton.setText(paramString);
    localButton.setTextSize(14.0F);
    localButton.setTextColor(-16777216);
    localButton.setOnClickListener(this);
    localButton.setTag(paramString);
    addView(localButton);
  }
  
  public void a(List paramList)
  {
    removeAllViews();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((String)paramList.next());
    }
  }
  
  public void onClick(View paramView)
  {
    st localst = new st(this, Looper.getMainLooper());
    if (localst != null)
    {
      Message localMessage = localst.obtainMessage();
      localMessage.obj = paramView.getTag();
      localst.sendMessage(localMessage);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = (int)DisplayUtils.a(getContext(), 8.0F);
    int j = (int)DisplayUtils.a(getContext(), 10.0F);
    int i2 = (int)DisplayUtils.a(getContext(), 10.0F);
    int i3 = getChildCount();
    int i = 1;
    paramInt2 = 0;
    paramInt4 = 0;
    for (;;)
    {
      View localView;
      int i4;
      int i5;
      int n;
      int k;
      int m;
      if (paramInt4 < i3)
      {
        localView = getChildAt(paramInt4);
        i4 = localView.getMeasuredWidth();
        i5 = localView.getMeasuredHeight();
        n = i;
        k = j;
        m = paramInt2;
        if (paramInt2 + i4 <= paramInt3 - paramInt1) {
          break label182;
        }
        m = 0;
        k = j + (i5 + i1);
        n = i + 1;
        if (k + i5 <= this.g) {
          break label173;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ActiveSearchTipsContainer", 2, "tips line = " + n);
        }
        this.h = (n - 1);
      }
      label173:
      while (n > this.h) {
        return;
      }
      label182:
      localView.layout(m, k, i4 + m, i5 + k);
      paramInt4 += 1;
      paramInt2 = i2 + i4 + m;
      i = n;
      j = k;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    switch (m)
    {
    default: 
      i = 0;
    }
    switch (k)
    {
    default: 
      j = 0;
    }
    measureChildren(paramInt1, paramInt2);
    setMeasuredDimension(i, j);
  }
  
  public void setOnTipsClickListener(ActiveSearchTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.a = paramOnTipClickListener;
  }
  
  public void setVisibleHeight(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ActiveSearchTipsContainer
 * JD-Core Version:    0.7.0.1
 */