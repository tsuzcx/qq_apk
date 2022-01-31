package com.tencent.beacon.heatmap;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.beacon.event.e;
import com.tencent.beacon.event.n;

public class TouchAction
{
  public static void onCreate(Activity paramActivity, String paramString)
  {
    Object localObject2 = c.a();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Object localObject3 = n.d();
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((n)localObject3).k();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = c.a(((e)localObject3).s(), ((e)localObject3).t(), ((e)localObject3).u());
        }
      }
    }
    if ((localObject1 != null) && (((c)localObject1).b())) {
      try
      {
        paramString = new d(paramActivity, new GestureDetector(paramActivity, new a(paramActivity, paramString)));
        paramString.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        paramString.setLongClickable(true);
        paramString.setClickable(true);
        localObject1 = (View)paramActivity.findViewById(16908290).getParent();
        localObject2 = ((View)localObject1).getParent();
        if ((localObject2 != null) && ((localObject2 instanceof ViewGroup)))
        {
          localObject2 = (ViewGroup)localObject2;
          if (localObject2 != null)
          {
            ((ViewGroup)localObject2).removeView((View)localObject1);
            paramString.addView((View)localObject1);
            ((ViewGroup)localObject2).addView(paramString);
          }
        }
        paramActivity = paramActivity.getApplicationContext();
        c.a(paramActivity);
        c.b(paramActivity);
        return;
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
    }
    com.tencent.beacon.d.a.c("Heatmap is not enable!", new Object[0]);
  }
  
  public static void onDestory() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.heatmap.TouchAction
 * JD-Core Version:    0.7.0.1
 */