public class vux
  implements vuf
{
  public final vuf[] a = new vuf[40];
  
  public static vuf a(int paramInt)
  {
    return vuz.a.b(paramInt);
  }
  
  public static vux a()
  {
    return vuz.a;
  }
  
  private void a(int paramInt, vuf paramvuf)
  {
    this.a[paramInt] = paramvuf;
  }
  
  public void a() {}
  
  public vuf b(int paramInt)
  {
    vuf localvuf1 = this.a[paramInt];
    if (localvuf1 == null) {}
    for (;;)
    {
      vuf localvuf2;
      synchronized (this.a)
      {
        localvuf2 = this.a[paramInt];
        if (localvuf2 == null) {
          break label408;
        }
        return localvuf2;
        if (localvuf1 != null)
        {
          localvuf1.a();
          xvv.b("Q.qqstory.SuperManager", "onInit manager : %s", localvuf1);
        }
        a(paramInt, localvuf1);
        return localvuf1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new vvd();
      continue;
      localObject2 = new xck();
      continue;
      localObject2 = new vvv();
      continue;
      localObject2 = new vuq();
      continue;
      localObject2 = new vwq();
      continue;
      localObject2 = new ydh();
      continue;
      localObject2 = new bnhh();
      continue;
      localObject2 = new vvj();
      continue;
      localObject2 = new vna();
      continue;
      localObject2 = new vlm();
      continue;
      localObject2 = new vns();
      continue;
      localObject2 = new vuu();
      continue;
      localObject2 = new vun();
      continue;
      localObject2 = new voj();
      continue;
      localObject2 = new vuj();
      continue;
      localObject2 = new vul();
      continue;
      localObject2 = new vtu();
      continue;
      localObject2 = new vuk();
      continue;
      localObject2 = new vty();
      continue;
      localObject2 = new vvi();
      continue;
      localObject2 = new vud();
      continue;
      localObject2 = new xnp();
      continue;
      localObject2 = new xnv();
      continue;
      localObject2 = new vvf();
      continue;
      localObject2 = new xen();
      continue;
      localObject2 = new vue();
      continue;
      localObject2 = new vva();
      continue;
      localObject2 = new vls();
      continue;
      localObject2 = new vuv();
      continue;
      localObject2 = new via();
      continue;
      return localObject2;
      label408:
      localObject2 = localvuf2;
      switch (paramInt)
      {
      }
      localObject2 = localvuf2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    vuf[] arrayOfvuf = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        vuf localvuf = this.a[i];
        xvv.b("Q.qqstory.SuperManager", "destroy manager : %s", localvuf);
        if (localvuf != null) {
          localvuf.b();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vux
 * JD-Core Version:    0.7.0.1
 */