package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;

public final class ListPopupWindowCompat
{
  @Nullable
  public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow paramListPopupWindow, @NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramListPopupWindow.createDragToOpenListener(paramView);
    }
    return null;
  }
  
  @Deprecated
  public static View.OnTouchListener createDragToOpenListener(Object paramObject, View paramView)
  {
    return createDragToOpenListener((ListPopupWindow)paramObject, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ListPopupWindowCompat
 * JD-Core Version:    0.7.0.1
 */