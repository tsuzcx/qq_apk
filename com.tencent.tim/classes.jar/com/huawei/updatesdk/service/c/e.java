package com.huawei.updatesdk.service.c;

import android.content.Context;

public class e
  implements Runnable
{
  private b a;
  private Context b;
  
  public e(Context paramContext, b paramb)
  {
    this.b = paramContext;
    this.a = paramb;
  }
  
  public void run()
  {
    com.huawei.updatesdk.a.a.b.a.a.a.a("PackageManagerRunnable", "PackageManagerRunnable run!!!!" + this.a.toString());
    if (this.a.e() == c.b.a) {
      a.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.service.c.e
 * JD-Core Version:    0.7.0.1
 */