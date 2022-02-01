package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import aoop;
import aqqx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.data.MedalList;
import com.tencent.mobileqq.data.MedalList.Info;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import rom;
import rpq;

public class QVipMedalView
  extends ViewGroup
{
  protected a a;
  protected int ehR;
  protected List<ImageView> fD;
  protected int mItemWidth;
  
  public QVipMedalView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QVipMedalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void c(ImageView paramImageView, int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("QVipSettingMe.QVipMedalView", 1, "bindData with null value!!");
      return;
    }
    paramString = aqqx.a(paramString, aqqx.pe, aoop.TRANSPARENT, null, null);
    ProfileActivity.a((AppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramImageView);
    paramImageView.setImageDrawable(paramString);
  }
  
  private void eiH()
  {
    if (this.a == null) {}
    while (this.a.getCount() == getChildCount()) {
      return;
    }
    rom.fail("consistency check failed ! adapter count=" + this.a.getCount() + " view list size=" + this.fD.size() + " child count=" + getChildCount(), new Object[0]);
    int j = this.a.getCount();
    removeAllViews();
    int i = 0;
    label97:
    if (i < j)
    {
      if (this.fD.size() <= i) {
        break label189;
      }
      ((ImageView)this.fD.get(i)).setImageDrawable(null);
    }
    for (;;)
    {
      c((ImageView)this.fD.get(i), this.a.kB(i), this.a.gs(i));
      addView((View)this.fD.get(i));
      i += 1;
      break label97;
      break;
      label189:
      this.fD.add(new ImageView(getContext()));
    }
  }
  
  protected void init()
  {
    this.ehR = rpq.dip2px(getContext(), 4.0F);
    this.fD = new ArrayList();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a == null) {}
    label163:
    for (;;)
    {
      return;
      int i = this.a.getCount();
      int j = getPaddingTop();
      int k = getPaddingBottom();
      paramInt2 = 0;
      for (;;)
      {
        if (paramInt2 >= i) {
          break label163;
        }
        int m = this.mItemWidth;
        int n = this.ehR;
        m = getPaddingLeft() + (m + n) * paramInt2;
        n = m + this.mItemWidth;
        if (n > paramInt3 - paramInt1)
        {
          if (paramInt2 == 0)
          {
            QLog.e("QVipMedalView", 1, "illegal size to layout the medal!! no one can layout");
            return;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QVipMedalView", 1, "It only can layout " + paramInt2 + "medal");
          return;
        }
        ((ImageView)this.fD.get(paramInt2)).layout(m, j, n, paramInt4 - k);
        paramInt2 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    if (this.a == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      this.mItemWidth = (paramInt1 - getPaddingTop() - getPaddingBottom());
      if (k != 1073741824) {
        break label162;
      }
    }
    for (paramInt2 = j;; paramInt2 = (paramInt2 - 1) * this.ehR + j * paramInt2 + getPaddingLeft() + getPaddingRight())
    {
      j = this.a.getCount();
      eiH();
      while (i < j)
      {
        ((ImageView)this.fD.get(i)).measure(View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mItemWidth, 1073741824));
        i += 1;
      }
      this.mItemWidth = rpq.dip2px(getContext(), 20.0F);
      paramInt1 = this.mItemWidth + getPaddingBottom() + getPaddingTop();
      break;
      label162:
      paramInt2 = this.a.getCount();
      j = this.mItemWidth;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setAdapter(a parama)
  {
    this.a = parama;
    removeAllViews();
    if (this.a != null)
    {
      int j = this.a.getCount();
      int i = 0;
      if (i < j)
      {
        if (this.fD.size() > i) {
          ((ImageView)this.fD.get(i)).setImageDrawable(null);
        }
        for (;;)
        {
          c((ImageView)this.fD.get(i), this.a.kB(i), this.a.gs(i));
          addView((View)this.fD.get(i));
          i += 1;
          break;
          this.fD.add(new ImageView(getContext()));
        }
      }
    }
    requestLayout();
  }
  
  public void setData(MedalList paramMedalList)
  {
    if (this.a == null) {
      this.a = new a();
    }
    this.a.setData(paramMedalList);
    setAdapter(this.a);
  }
  
  public void setItemMargin(int paramInt)
  {
    this.ehR = paramInt;
  }
  
  public void setItemWidth(int paramInt)
  {
    this.mItemWidth = paramInt;
  }
  
  public static class a
  {
    private MedalList b;
    
    public int getCount()
    {
      if (this.b != null) {
        return this.b.infoList.size();
      }
      return 0;
    }
    
    public String gs(int paramInt)
    {
      if ((this.b != null) && (this.b.infoList.size() > paramInt)) {
        return ((MedalList.Info)this.b.infoList.get(paramInt)).value;
      }
      return null;
    }
    
    public int kB(int paramInt)
    {
      if ((this.b != null) && (this.b.infoList.size() > paramInt)) {
        return ((MedalList.Info)this.b.infoList.get(paramInt)).type;
      }
      return 0;
    }
    
    public void setData(MedalList paramMedalList)
    {
      this.b = paramMedalList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QVipMedalView
 * JD-Core Version:    0.7.0.1
 */