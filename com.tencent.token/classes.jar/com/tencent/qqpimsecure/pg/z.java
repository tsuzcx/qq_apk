package com.tencent.qqpimsecure.pg;

import android.content.Context;
import android.view.View;

final class z
  extends View
{
  z(Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (q.d(this.a))
    {
      q.a(this.a, 2);
      return;
    }
    if (paramBoolean)
    {
      q.a(this.a, 0);
      return;
    }
    q.a(this.a, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.z
 * JD-Core Version:    0.7.0.1
 */