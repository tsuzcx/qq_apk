package android.support.v4.app;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.lang.reflect.Method;

class ActionBarDrawerToggle$SetIndicatorInfo
{
  Method mSetHomeActionContentDescription;
  Method mSetHomeAsUpIndicator;
  ImageView mUpIndicatorView;
  
  ActionBarDrawerToggle$SetIndicatorInfo(Activity paramActivity)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[] { Drawable.class });
        this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[] { Integer.TYPE });
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        paramActivity = paramActivity.findViewById(16908332);
        if (paramActivity == null) {
          continue;
        }
        localObject = (ViewGroup)paramActivity.getParent();
        if (((ViewGroup)localObject).getChildCount() != 2) {
          continue;
        }
        paramActivity = ((ViewGroup)localObject).getChildAt(0);
        localObject = ((ViewGroup)localObject).getChildAt(1);
        if (paramActivity.getId() != 16908332) {
          break label113;
        }
      }
      paramActivity = (Activity)localObject;
      label113:
      while ((paramActivity instanceof ImageView))
      {
        this.mUpIndicatorView = ((ImageView)paramActivity);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActionBarDrawerToggle.SetIndicatorInfo
 * JD-Core Version:    0.7.0.1
 */