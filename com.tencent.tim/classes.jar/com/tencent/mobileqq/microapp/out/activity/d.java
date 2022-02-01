package com.tencent.mobileqq.microapp.out.activity;

import android.widget.TextView;
import java.util.List;

final class d
  implements Runnable
{
  d(MapActivity paramMapActivity, List paramList, int paramInt) {}
  
  public void run()
  {
    int i = 0;
    Object localObject = this.c.q;
    List localList = this.a;
    boolean bool;
    if (this.b > 0)
    {
      bool = true;
      ((f)localObject).a(localList, bool);
      localObject = this.c.r;
      if (this.c.q.getCount() >= 1) {
        break label65;
      }
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(i);
      return;
      bool = false;
      break;
      label65:
      i = 8;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.activity.d
 * JD-Core Version:    0.7.0.1
 */