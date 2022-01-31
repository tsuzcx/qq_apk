package com.tencent.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout.LayoutParams;

public class ActionSheetHelper
{
  public static Dialog a(Context paramContext, View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.a(paramContext);
    localActionSheet.b(paramView, new LinearLayout.LayoutParams(paramContext.getResources().getDisplayMetrics().widthPixels * 1 / 2, -2, 1.0F));
    return localActionSheet;
  }
  
  public static Dialog b(Context paramContext, View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.c(paramContext);
    localActionSheet.b(paramView, new LinearLayout.LayoutParams(paramContext.getResources().getDisplayMetrics().widthPixels * 1 / 2, -2, 1.0F));
    paramView = localActionSheet.getWindow();
    WindowManager localWindowManager = paramView.getWindowManager();
    WindowManager.LayoutParams localLayoutParams = paramView.getAttributes();
    localLayoutParams.y = paramContext.getResources().getDimensionPixelSize(2131427376);
    localLayoutParams.width = ((int)(localWindowManager.getDefaultDisplay().getWidth() * 0.65D));
    paramView.setGravity(53);
    paramView.setAttributes(localLayoutParams);
    return localActionSheet;
  }
  
  public static Dialog c(Context paramContext, View paramView)
  {
    ActionSheet localActionSheet = ActionSheet.c(paramContext);
    localActionSheet.b(paramView, new LinearLayout.LayoutParams(paramContext.getResources().getDisplayMetrics().widthPixels * 1 / 2, -2, 1.0F));
    paramContext = localActionSheet.getWindow();
    paramView = paramContext.getWindowManager();
    WindowManager.LayoutParams localLayoutParams = paramContext.getAttributes();
    localLayoutParams.width = ((int)(paramView.getDefaultDisplay().getWidth() * 0.65D));
    paramContext.setGravity(80);
    paramContext.setAttributes(localLayoutParams);
    return localActionSheet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.ActionSheetHelper
 * JD-Core Version:    0.7.0.1
 */