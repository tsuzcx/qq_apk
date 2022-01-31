public class uwa
  implements uvi
{
  public final uvi[] a = new uvi[40];
  
  public static uvi a(int paramInt)
  {
    return uwc.a.b(paramInt);
  }
  
  public static uwa a()
  {
    return uwc.a;
  }
  
  private void a(int paramInt, uvi paramuvi)
  {
    this.a[paramInt] = paramuvi;
  }
  
  public void a() {}
  
  public uvi b(int paramInt)
  {
    uvi localuvi1 = this.a[paramInt];
    if (localuvi1 == null) {}
    for (;;)
    {
      uvi localuvi2;
      synchronized (this.a)
      {
        localuvi2 = this.a[paramInt];
        if (localuvi2 == null) {
          break label408;
        }
        return localuvi2;
        if (localuvi1 != null)
        {
          localuvi1.a();
          wxe.b("Q.qqstory.SuperManager", "onInit manager : %s", localuvi1);
        }
        a(paramInt, localuvi1);
        return localuvi1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new uwg();
      continue;
      localObject2 = new wdt();
      continue;
      localObject2 = new uwy();
      continue;
      localObject2 = new uvt();
      continue;
      localObject2 = new uxt();
      continue;
      localObject2 = new xet();
      continue;
      localObject2 = new bmru();
      continue;
      localObject2 = new uwm();
      continue;
      localObject2 = new unu();
      continue;
      localObject2 = new umg();
      continue;
      localObject2 = new uom();
      continue;
      localObject2 = new uvx();
      continue;
      localObject2 = new uvq();
      continue;
      localObject2 = new upl();
      continue;
      localObject2 = new uvm();
      continue;
      localObject2 = new uvo();
      continue;
      localObject2 = new uux();
      continue;
      localObject2 = new uvn();
      continue;
      localObject2 = new uvb();
      continue;
      localObject2 = new uwl();
      continue;
      localObject2 = new uvg();
      continue;
      localObject2 = new woy();
      continue;
      localObject2 = new wpe();
      continue;
      localObject2 = new uwi();
      continue;
      localObject2 = new wfw();
      continue;
      localObject2 = new uvh();
      continue;
      localObject2 = new uwd();
      continue;
      localObject2 = new umm();
      continue;
      localObject2 = new uvy();
      continue;
      localObject2 = new uio();
      continue;
      return localObject2;
      label408:
      localObject2 = localuvi2;
      switch (paramInt)
      {
      }
      localObject2 = localuvi2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    uvi[] arrayOfuvi = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        uvi localuvi = this.a[i];
        wxe.b("Q.qqstory.SuperManager", "destroy manager : %s", localuvi);
        if (localuvi != null) {
          localuvi.b();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uwa
 * JD-Core Version:    0.7.0.1
 */