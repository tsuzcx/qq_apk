package com.tencent.android.tpush.inappmessage;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.android.tpush.logging.TLogger;

public class c
  extends h
{
  public c(Activity paramActivity, d paramd, Intent paramIntent)
  {
    super(paramActivity, paramd, paramIntent);
  }
  
  protected RelativeLayout.LayoutParams b()
  {
    Object localObject = SizeUtil.getDisplaySize(this.b);
    int n = SizeUtil.dipTopx(this.b, this.d.a());
    int i1 = SizeUtil.dipTopx(this.b, this.d.b());
    TLogger.i("Center Popup", "size.x = " + ((Point)localObject).x + ", size.y =" + ((Point)localObject).y + "width = " + n + ", height =" + i1);
    int m = ((Point)localObject).x - SizeUtil.dp20;
    int k = ((Point)localObject).y - SizeUtil.dp20;
    double d = n / i1;
    int j = i1;
    int i = n;
    if (n > m)
    {
      j = i1;
      i = n;
      if ((int)(n / d) < k)
      {
        j = (int)(m / d);
        i = m;
      }
    }
    if ((j > k) && ((int)(j * d) < m))
    {
      j = (int)(k * d);
      i = k;
    }
    for (;;)
    {
      TLogger.i("Center Popup", "InAppMsg LayoutParams width = " + j + ", height = " + i);
      localObject = new RelativeLayout.LayoutParams(j, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      return localObject;
      k = i;
      i = j;
      j = k;
    }
  }
  
  boolean d()
  {
    return false;
  }
  
  protected void e()
  {
    Window localWindow = getWindow();
    if (localWindow == null) {}
    do
    {
      return;
      localWindow.addFlags(2);
    } while (Build.VERSION.SDK_INT < 14);
    localWindow.setDimAmount(0.7F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.c
 * JD-Core Version:    0.7.0.1
 */