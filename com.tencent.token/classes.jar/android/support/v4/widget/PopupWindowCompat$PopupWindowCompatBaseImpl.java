package android.support.v4.widget;

import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

class PopupWindowCompat$PopupWindowCompatBaseImpl
{
  private static Method sGetWindowLayoutTypeMethod;
  private static boolean sGetWindowLayoutTypeMethodAttempted;
  private static Method sSetWindowLayoutTypeMethod;
  private static boolean sSetWindowLayoutTypeMethodAttempted;
  
  public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    return false;
  }
  
  public int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    if (!sGetWindowLayoutTypeMethodAttempted) {}
    try
    {
      sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
      sGetWindowLayoutTypeMethod.setAccessible(true);
      label27:
      sGetWindowLayoutTypeMethodAttempted = true;
      if (sGetWindowLayoutTypeMethod != null) {
        try
        {
          int i = ((Integer)sGetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[0])).intValue();
          return i;
        }
        catch (Exception paramPopupWindow) {}
      }
      return 0;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (!sSetWindowLayoutTypeMethodAttempted) {}
    try
    {
      sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      sSetWindowLayoutTypeMethod.setAccessible(true);
      label33:
      sSetWindowLayoutTypeMethodAttempted = true;
      if (sSetWindowLayoutTypeMethod != null) {}
      try
      {
        sSetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramPopupWindow) {}
    }
    catch (Exception localException)
    {
      break label33;
    }
  }
  
  public void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    if ((GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView)) & 0x7) == 5) {
      i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
    }
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.PopupWindowCompatBaseImpl
 * JD-Core Version:    0.7.0.1
 */