package com.tencent.qqpimsecure.pg;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

final class aa
  implements Runnable
{
  aa(View paramView, WindowManager paramWindowManager, WindowManager.LayoutParams paramLayoutParams, Context paramContext) {}
  
  public void run()
  {
    if (this.a.getParent() == null) {}
    try
    {
      this.b.addView(this.a, this.c);
      if (!q.d(this.d)) {
        q.a(this.d, -1);
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.aa
 * JD-Core Version:    0.7.0.1
 */