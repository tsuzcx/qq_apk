package com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kkb;
import kkk;

public class CommonAdBar
  extends FrameLayout
  implements kkb
{
  private kkk a;
  
  public CommonAdBar(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonAdBar(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void Hj()
  {
    setVisibility(8);
  }
  
  public kkk a()
  {
    return this.a;
  }
  
  public void a(kkk paramkkk)
  {
    if (this.a != null) {
      this.a.close();
    }
    this.a = paramkkk;
    this.a.a(this);
    addView(paramkkk.ah());
  }
  
  public void aDM()
  {
    removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.CommonAdBar
 * JD-Core Version:    0.7.0.1
 */