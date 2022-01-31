package android.support.v4.widget;

import android.support.annotation.RequiresApi;
import android.widget.PopupWindow;

@RequiresApi(23)
class PopupWindowCompat$PopupWindowCompatApi23Impl
  extends PopupWindowCompat.PopupWindowCompatApi21Impl
{
  public boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    return paramPopupWindow.getOverlapAnchor();
  }
  
  public int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    return paramPopupWindow.getWindowLayoutType();
  }
  
  public void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    paramPopupWindow.setOverlapAnchor(paramBoolean);
  }
  
  public void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    paramPopupWindow.setWindowLayoutType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat.PopupWindowCompatApi23Impl
 * JD-Core Version:    0.7.0.1
 */