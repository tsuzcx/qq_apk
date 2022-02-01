package com.tencent.mobileqq.activity.qwallet.widget;

import aafx;
import aafz;
import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ImmersionBar
{
  private boolean darkFont;
  private Activity mActivity;
  private Window mWindow;
  private int resId;
  private View statusBarView;
  private int statusBarViewColor;
  
  public ImmersionBar(Activity paramActivity, int paramInt, View paramView)
  {
    this.mActivity = paramActivity;
    this.mWindow = this.mActivity.getWindow();
    this.statusBarView = paramView;
    this.statusBarViewColor = paramInt;
    this.resId = 0;
    initStateBar(paramInt);
  }
  
  public ImmersionBar(Activity paramActivity, int paramInt, View paramView, boolean paramBoolean)
  {
    this.mActivity = paramActivity;
    this.mWindow = this.mActivity.getWindow();
    this.statusBarView = paramView;
    this.resId = paramInt;
    initStateBar(paramInt);
  }
  
  private void initStateBar(int paramInt)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        if (ImmersiveUtils.isSupporImmersive() != 1) {
          break;
        }
        int i = 256;
        if ((Build.VERSION.SDK_INT >= 21) && (!aafz.isEMUI3_1()))
        {
          if (this.statusBarView != null) {
            i = 1280;
          }
          i = setStatusBarDarkFont(i);
          this.mWindow.clearFlags(67108864);
          this.mWindow.addFlags(-2147483648);
          this.mWindow.setStatusBarColor(0);
          this.mWindow.getDecorView().setSystemUiVisibility(i);
          if (Build.VERSION.SDK_INT >= 24)
          {
            bool2 = this.mActivity.isInMultiWindowMode();
            bool1 = this.mActivity.isInPictureInPictureMode();
            if ((this.statusBarView == null) || (bool2) || (bool1)) {
              break;
            }
            setupStatusBarView(paramInt);
          }
        }
        else
        {
          this.mWindow.addFlags(4194304);
          continue;
        }
        boolean bool2 = false;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
    }
  }
  
  public static boolean isSupportStatusBarDarkFont()
  {
    return (aafz.isMIUI6More()) || (aafz.isFlymeOS4More()) || (Build.VERSION.SDK_INT >= 23);
  }
  
  private static void setMIUIStatusBarDarkFont(Window paramWindow, boolean paramBoolean)
  {
    if (paramWindow != null)
    {
      Object localObject = paramWindow.getClass();
      try
      {
        Class localClass = Class.forName("android.view.MiuiWindowManager$LayoutParams");
        int i = localClass.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(localClass);
        localObject = ((Class)localObject).getMethod("setExtraFlags", new Class[] { Integer.TYPE, Integer.TYPE });
        if (paramBoolean)
        {
          ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(i), Integer.valueOf(i) });
          return;
        }
        ((Method)localObject).invoke(paramWindow, new Object[] { Integer.valueOf(0), Integer.valueOf(i) });
        return;
      }
      catch (Exception paramWindow)
      {
        paramWindow.printStackTrace();
      }
    }
  }
  
  private int setStatusBarDarkFont(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT >= 23)
    {
      i = paramInt;
      if (this.darkFont) {
        i = paramInt | 0x2000;
      }
    }
    return i;
  }
  
  private void setupStatusBarView(int paramInt)
  {
    ViewGroup.LayoutParams localLayoutParams = this.statusBarView.getLayoutParams();
    localLayoutParams.height = ImmersiveUtils.getStatusBarHeight(this.mActivity);
    this.statusBarView.setLayoutParams(localLayoutParams);
    if (this.resId != 0)
    {
      this.statusBarView.setBackgroundResource(this.resId);
      return;
    }
    this.statusBarView.setBackgroundColor(paramInt);
  }
  
  public void statusBarDarkFont(boolean paramBoolean)
  {
    this.darkFont = paramBoolean;
    try
    {
      if (isSupportStatusBarDarkFont())
      {
        initStateBar(this.statusBarViewColor);
        if (aafz.isMIUI6More()) {
          setMIUIStatusBarDarkFont(this.mWindow, paramBoolean);
        }
        if (aafz.isFlymeOS4More()) {
          aafx.setStatusBarDarkIcon(this.mActivity, paramBoolean);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar
 * JD-Core Version:    0.7.0.1
 */