package android.support.v4.view;

import android.graphics.Rect;
import android.support.annotation.RequiresApi;
import android.view.View;

@RequiresApi(18)
class ViewCompat$ViewCompatApi18Impl
  extends ViewCompat.ViewCompatApi17Impl
{
  public Rect getClipBounds(View paramView)
  {
    return paramView.getClipBounds();
  }
  
  public boolean isInLayout(View paramView)
  {
    return paramView.isInLayout();
  }
  
  public void setClipBounds(View paramView, Rect paramRect)
  {
    paramView.setClipBounds(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewCompat.ViewCompatApi18Impl
 * JD-Core Version:    0.7.0.1
 */