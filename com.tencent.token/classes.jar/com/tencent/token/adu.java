package com.tencent.token;

import android.content.Context;

public final class adu
  extends Thread
{
  public adu(agr paramagr) {}
  
  public final void run()
  {
    Object localObject = this.a;
    abz.a();
    localObject = ((agr)localObject).c;
    aeq localaeq = abz.a((Context)localObject, 100, 0, 0);
    adz.c = localaeq;
    if (localaeq == null) {
      adz.c = new aeq((Context)localObject, 0, 0, 0, 0, 100);
    }
    aek.b.getClass();
    localaeq = abz.a((Context)localObject, 999, (int)aek.a((Context)localObject, "mm_max_day_cnt", 20L, 1L), (int)aek.a((Context)localObject, "mm_max_hour_cnt", 3L, 1L));
    adz.a = localaeq;
    if (localaeq == null) {
      adz.a = new aeq((Context)localObject, (int)aek.a((Context)localObject, "mm_max_day_cnt", 20L, 1L), (int)aek.a((Context)localObject, "mm_max_hour_cnt", 3L, 1L), 30, 3, 999);
    }
    localaeq = abz.a((Context)localObject, 998, 3, 1);
    adz.b = localaeq;
    if (localaeq == null) {
      adz.b = new aeq((Context)localObject, 3, 1, 3600, 3, 998);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adu
 * JD-Core Version:    0.7.0.1
 */