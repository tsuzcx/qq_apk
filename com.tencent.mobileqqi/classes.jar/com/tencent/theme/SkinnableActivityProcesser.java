package com.tencent.theme;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.os.Process;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Field;

public class SkinnableActivityProcesser
  extends BroadcastReceiver
{
  private Activity a;
  private Callback b;
  
  public SkinnableActivityProcesser(Activity paramActivity, Callback paramCallback)
  {
    this.a = paramActivity;
    this.b = paramCallback;
    try
    {
      this.a.registerReceiver(this, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"));
      return;
    }
    catch (Exception paramActivity)
    {
      while (!SkinEngine.DEBUG) {}
      Log.e("SKinEngine", paramActivity.getMessage(), paramActivity);
    }
  }
  
  static boolean a(Drawable paramDrawable)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1;
    if (!(paramDrawable instanceof DrawableContainer)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      paramDrawable = (DrawableContainer.DrawableContainerState)paramDrawable.getConstantState();
      Object localObject = paramDrawable.getChildren();
      int j = paramDrawable.getChildCount();
      int i = 0;
      if (i < j)
      {
        Drawable localDrawable = localObject[i];
        if ((localDrawable instanceof SkinnableNinePatchDrawable)) {
          bool1 = true;
        }
        for (;;)
        {
          i += 1;
          bool2 = bool1;
          break;
          bool1 = bool2;
          if ((localDrawable instanceof DrawableContainer)) {
            bool1 = bool2 | a(localDrawable);
          }
        }
      }
      try
      {
        localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mComputedConstantSize");
        ((Field)localObject).setAccessible(true);
        ((Field)localObject).setBoolean(paramDrawable, false);
        if (bool2)
        {
          try
          {
            localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mPaddingChecked");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).setBoolean(paramDrawable, false);
            localObject = DrawableContainer.DrawableContainerState.class.getDeclaredField("mConstantPadding");
            ((Field)localObject).setAccessible(true);
            ((Field)localObject).set(paramDrawable, null);
            return true;
          }
          catch (Exception paramDrawable)
          {
            bool1 = bool3;
          }
          if (!SkinEngine.DEBUG) {
            continue;
          }
          Log.e("SKinEngine", "", paramDrawable);
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (SkinEngine.DEBUG) {
            Log.e("SKinEngine", "", localException);
          }
        }
      }
    }
    return bool2;
  }
  
  public void destory()
  {
    try
    {
      this.a.unregisterReceiver(this);
      return;
    }
    catch (Exception localException)
    {
      while (!SkinEngine.DEBUG) {}
      Log.e("SKinEngine", localException.getMessage(), localException);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 0;
    if (paramIntent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {}
    do
    {
      return;
      if (this.b != null) {
        this.b.onPreThemeChanged();
      }
      paramContext = this.a.getWindow().getDecorView();
      paramIntent = (ViewGroup)paramContext;
      View[] arrayOfView = new View[paramIntent.getChildCount()];
      int i = 0;
      while (i < paramIntent.getChildCount())
      {
        arrayOfView[i] = paramIntent.getChildAt(i);
        i += 1;
      }
      paramIntent.removeAllViews();
      i = j;
      while (i < arrayOfView.length)
      {
        paramIntent.addView(arrayOfView[i]);
        i += 1;
      }
      SkinEngine.invalidateAll(paramContext);
    } while (this.b == null);
    this.b.onPostThemeChanged();
  }
  
  public static abstract interface Callback
  {
    public abstract void onPostThemeChanged();
    
    public abstract void onPreThemeChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableActivityProcesser
 * JD-Core Version:    0.7.0.1
 */