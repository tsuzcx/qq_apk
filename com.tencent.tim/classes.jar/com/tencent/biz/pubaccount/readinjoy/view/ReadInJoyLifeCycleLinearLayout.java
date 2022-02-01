package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import lwm;
import nda;
import ndc;

public class ReadInJoyLifeCycleLinearLayout
  extends LinearLayout
  implements nda
{
  private boolean uA;
  
  public ReadInJoyLifeCycleLinearLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean isResumed()
  {
    return this.uA;
  }
  
  public void onViewPause()
  {
    Object localObject = getTag();
    if ((localObject instanceof lwm))
    {
      localObject = ((lwm)localObject).a();
      if ((localObject instanceof ndc)) {
        ((ndc)localObject).aMR();
      }
    }
  }
  
  public void onViewResume()
  {
    Object localObject = getTag();
    if ((localObject instanceof lwm))
    {
      localObject = ((lwm)localObject).a();
      if ((localObject instanceof ndc)) {
        ((ndc)localObject).aMQ();
      }
    }
  }
  
  public void setIsResume(boolean paramBoolean)
  {
    this.uA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyLifeCycleLinearLayout
 * JD-Core Version:    0.7.0.1
 */