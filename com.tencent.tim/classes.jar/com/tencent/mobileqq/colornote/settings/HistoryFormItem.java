package com.tencent.mobileqq.colornote.settings;

import aedm;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import aqcx;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class HistoryFormItem
  extends FormSimpleItem
{
  private a a;
  private boolean mChecked;
  private boolean mEnable = true;
  private int mIndex;
  private ImageView ys;
  
  public HistoryFormItem(Context paramContext)
  {
    super(paramContext);
    cVO();
  }
  
  public HistoryFormItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    cVO();
  }
  
  private void Hj(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundResource(2130851348);
      return;
    }
    setBgType(2);
  }
  
  private void Hk(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.ys.setImageResource(2130839491);
      return;
    }
    this.ys.setImageResource(2130839490);
  }
  
  private void cVO()
  {
    cVQ();
  }
  
  private void cVQ()
  {
    this.ys = new ImageView(getContext());
    this.ys.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.ys.setContentDescription(getResources().getString(2131691743));
    Hk(this.mChecked);
    int i = getResources().getDimensionPixelSize(2131299400);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    addView(this.ys, localLayoutParams);
    this.ys.setOnClickListener(new aedm(this));
  }
  
  public void F(View paramView, boolean paramBoolean)
  {
    Hj(paramBoolean);
    Hk(paramBoolean);
  }
  
  public void cVP()
  {
    super.cVP();
    this.efR = aqcx.dip2px(getContext(), 290.0F);
  }
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public boolean isEnable()
  {
    return this.mEnable;
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.mChecked = paramBoolean;
    F(this.ys, paramBoolean);
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setIndex(int paramInt)
  {
    this.mIndex = paramInt;
  }
  
  public void setItemLeftText(CharSequence paramCharSequence)
  {
    setLeftText(paramCharSequence);
  }
  
  public void setItemOnClickListener(View.OnClickListener paramOnClickListener)
  {
    setOnClickListener(paramOnClickListener);
  }
  
  public void setLeftIconResource(int paramInt)
  {
    if (paramInt != 0) {
      setLeftIcon(getResources().getDrawable(paramInt));
    }
  }
  
  public void setOnIconClickListener(a parama)
  {
    this.a = parama;
  }
  
  public void setRightIconResource(int paramInt)
  {
    if (paramInt != 0) {
      setRightIcon(getResources().getDrawable(paramInt));
    }
  }
  
  public static abstract interface a
  {
    public abstract void f(View paramView, int paramInt, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem
 * JD-Core Version:    0.7.0.1
 */