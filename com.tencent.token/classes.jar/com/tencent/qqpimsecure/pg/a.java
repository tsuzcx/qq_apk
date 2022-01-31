package com.tencent.qqpimsecure.pg;

import android.os.Handler;
import java.util.ArrayList;
import taiji.cq;

class a
  extends cq
{
  private String e;
  private boolean f;
  
  a(PermissionGuideActivity paramPermissionGuideActivity, taiji.b paramb, int paramInt, ArrayList paramArrayList) {}
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2)
  {
    taiji.a locala = (taiji.a)this.a.c.get(paramInt1);
    if (locala.a == 1) {
      this.e = locala.f;
    }
    if (paramInt2 == 2)
    {
      this.f = true;
      f.a(this.d, this.a.b, 0, PermissionGuideActivity.a(this.d), paramInt1, this.e);
    }
  }
  
  public void b()
  {
    PermissionGuideActivity.b(this.d).post(new b(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.a
 * JD-Core Version:    0.7.0.1
 */