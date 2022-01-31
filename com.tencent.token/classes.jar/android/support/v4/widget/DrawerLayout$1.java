package android.support.v4.widget;

import android.annotation.TargetApi;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

class DrawerLayout$1
  implements View.OnApplyWindowInsetsListener
{
  DrawerLayout$1(DrawerLayout paramDrawerLayout) {}
  
  @TargetApi(21)
  public WindowInsets onApplyWindowInsets(View paramView, WindowInsets paramWindowInsets)
  {
    paramView = (DrawerLayout)paramView;
    if (paramWindowInsets.getSystemWindowInsetTop() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChildInsets(paramWindowInsets, bool);
      return paramWindowInsets.consumeSystemWindowInsets();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout.1
 * JD-Core Version:    0.7.0.1
 */