package com.tencent.qqpimsecure.pg;

import android.app.Activity;
import com.tencent.qqpimsecure.taiji.f;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class i
{
  private l a;
  
  public static i a()
  {
    return k.a();
  }
  
  private boolean a(int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0)) {
      return false;
    }
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label53;
      }
      int k = paramArrayOfInt[i];
      if (r.a().b(new int[] { k })[0] == 2) {
        break;
      }
      i += 1;
    }
    label53:
    return true;
  }
  
  public void a(int[] paramArrayOfInt, Activity paramActivity)
  {
    if (!a(paramArrayOfInt)) {
      return;
    }
    b();
    this.a = new l(paramArrayOfInt, paramActivity, null);
    f.a().d().addUrgentTask(this.a, "manual-auto-back-thread");
  }
  
  public void b()
  {
    if (this.a != null) {
      l.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.i
 * JD-Core Version:    0.7.0.1
 */