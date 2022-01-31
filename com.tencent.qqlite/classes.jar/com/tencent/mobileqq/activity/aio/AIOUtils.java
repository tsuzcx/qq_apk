package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.widget.ListView;

public final class AIOUtils
{
  public static final int a = 100;
  public static volatile boolean a = false;
  public static volatile boolean b = false;
  public static volatile boolean c = false;
  public static volatile boolean d = false;
  public static volatile boolean e = false;
  public static volatile boolean f = false;
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int a(long paramLong, ListAdapter paramListAdapter)
  {
    int i = 0;
    while (i < paramListAdapter.getCount())
    {
      Object localObject = paramListAdapter.getItem(i);
      if (((localObject instanceof ChatMessage)) && (((ChatMessage)localObject).uniseq == paramLong)) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static final View a(ListView paramListView, int paramInt)
  {
    if ((paramInt >= paramListView.q()) && (paramInt <= paramListView.r())) {
      return paramListView.getChildAt(paramInt - paramListView.q());
    }
    return null;
  }
  
  @Deprecated
  public static final ChatMessage a(View paramView)
  {
    paramView = (ChatItemBuilder.BaseHolder)a(paramView);
    if (paramView != null) {
      return paramView.a;
    }
    return null;
  }
  
  public static final Object a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if ((paramView.getParent() == null) || ((paramView.getParent() instanceof ListView))) {
      return paramView.getTag();
    }
    return a((View)paramView.getParent());
  }
  
  public static boolean a()
  {
    return Build.MANUFACTURER.equalsIgnoreCase("Samsung");
  }
  
  public static boolean a(Context paramContext)
  {
    return paramContext.getResources().getConfiguration().hardKeyboardHidden == 1;
  }
  
  public static boolean b()
  {
    return (a()) && (b(BaseApplicationImpl.getContext())) && (!a(BaseApplicationImpl.getContext()));
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.hasSystemFeature("com.sec.feature.folder_type")) && (paramContext.hasSystemFeature("com.sec.feature.dual_lcd"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOUtils
 * JD-Core Version:    0.7.0.1
 */