package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

@RequiresApi(21)
class PopupWindowCompat$PopupWindowCompatApi21Impl
  extends PopupWindowCompat.PopupWindowCompatApi19Impl
{
  private static final String TAG = "PopupWindowCompatApi21";
  private static Field sOverlapAnchorField;
  
  static
  {
    try
    {
      sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      sOverlapAnchorField.setAccessible(true);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
    }
  }
  
  public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    if (sOverlapAnchorField != null) {
      try
      {
        boolean bool = ((Boolean)sOverlapAnchorField.get(paramPopupWindow)).booleanValue();
        return bool;
      }
      catch (IllegalAccessException paramPopupWindow)
      {
        Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", paramPopupWindow);
      }
    }
    return false;
  }
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (sOverlapAnchorField != null) {}
    try
    {
      sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (IllegalAccessException paramPopupWindow)
    {
      Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", paramPopupWindow);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi21Impl
 * JD-Core Version:    0.7.0.1
 */