package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.mobileqq.widget.FormSimpleItem;

public class ReadinjoyFormSimpleItem
  extends FormSimpleItem
{
  public ReadinjoyFormSimpleItem(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadinjoyFormSimpleItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void aXn()
  {
    setArrowIcon(getResources().getDrawable(2130848118));
    super.aXn();
  }
  
  public ColorStateList b(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getColorStateList(2131165381);
    case 0: 
      return paramResources.getColorStateList(2131165381);
    case 2: 
      return paramResources.getColorStateList(2131165857);
    case 1: 
      return paramResources.getColorStateList(2131165446);
    }
    return paramResources.getColorStateList(2131165857);
  }
  
  public Drawable d(Resources paramResources, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramResources.getDrawable(2130847253);
    case 0: 
      if (daf) {
        return paramResources.getDrawable(2130847253);
      }
      return paramResources.getDrawable(2130847247);
    case 1: 
      if (daf) {
        return paramResources.getDrawable(2130847256);
      }
      return paramResources.getDrawable(2130847252);
    case 2: 
      if (daf) {
        return paramResources.getDrawable(2130847255);
      }
      return paramResources.getDrawable(2130847250);
    }
    if (daf) {
      return paramResources.getDrawable(2130847254);
    }
    return paramResources.getDrawable(2130847248);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyFormSimpleItem
 * JD-Core Version:    0.7.0.1
 */