package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

public class ActionSheetHelper
{
  public static Dialog a(Context paramContext, View paramView)
  {
    paramContext = ActionSheet.a(paramContext);
    paramContext.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
  
  public static Dialog a(Context paramContext, View paramView, int paramInt)
  {
    paramContext = ActionSheet.a(paramContext, paramInt);
    paramContext.b(paramView, new LinearLayout.LayoutParams(-1, -1));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */