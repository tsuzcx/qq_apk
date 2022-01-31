package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public final class ActionTabViewBinder
  extends EmoticonViewBinder
{
  public ActionTabViewBinder(int paramInt)
  {
    super(paramInt);
  }
  
  public Drawable a(Context paramContext)
  {
    switch (this.n)
    {
    default: 
      return null;
    case 100: 
      return paramContext.getResources().getDrawable(2130839033);
    }
    return paramContext.getResources().getDrawable(2130839036);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ActionTabViewBinder
 * JD-Core Version:    0.7.0.1
 */