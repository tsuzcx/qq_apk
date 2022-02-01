public class wth
  implements wsp
{
  public final wsp[] a = new wsp[40];
  
  public static wsp a(int paramInt)
  {
    return wtj.a.b(paramInt);
  }
  
  public static wth a()
  {
    return wtj.a;
  }
  
  private void a(int paramInt, wsp paramwsp)
  {
    this.a[paramInt] = paramwsp;
  }
  
  public void a() {}
  
  public wsp b(int paramInt)
  {
    wsp localwsp1 = this.a[paramInt];
    if (localwsp1 == null) {}
    for (;;)
    {
      wsp localwsp2;
      synchronized (this.a)
      {
        localwsp2 = this.a[paramInt];
        if (localwsp2 == null) {
          break label408;
        }
        return localwsp2;
        if (localwsp1 != null)
        {
          localwsp1.a();
          yuk.b("Q.qqstory.SuperManager", "onInit manager : %s", localwsp1);
        }
        a(paramInt, localwsp1);
        return localwsp1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new wtn();
      continue;
      localObject2 = new yaz();
      continue;
      localObject2 = new wuf();
      continue;
      localObject2 = new wta();
      continue;
      localObject2 = new wva();
      continue;
      localObject2 = new zbz();
      continue;
      localObject2 = new bqkv();
      continue;
      localObject2 = new wtt();
      continue;
      localObject2 = new wlb();
      continue;
      localObject2 = new wjn();
      continue;
      localObject2 = new wlt();
      continue;
      localObject2 = new wte();
      continue;
      localObject2 = new wsx();
      continue;
      localObject2 = new wms();
      continue;
      localObject2 = new wst();
      continue;
      localObject2 = new wsv();
      continue;
      localObject2 = new wse();
      continue;
      localObject2 = new wsu();
      continue;
      localObject2 = new wsi();
      continue;
      localObject2 = new wts();
      continue;
      localObject2 = new wsn();
      continue;
      localObject2 = new yme();
      continue;
      localObject2 = new ymk();
      continue;
      localObject2 = new wtp();
      continue;
      localObject2 = new ydc();
      continue;
      localObject2 = new wso();
      continue;
      localObject2 = new wtk();
      continue;
      localObject2 = new wjt();
      continue;
      localObject2 = new wtf();
      continue;
      localObject2 = new wfv();
      continue;
      return localObject2;
      label408:
      localObject2 = localwsp2;
      switch (paramInt)
      {
      }
      localObject2 = localwsp2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    wsp[] arrayOfwsp = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        wsp localwsp = this.a[i];
        yuk.b("Q.qqstory.SuperManager", "destroy manager : %s", localwsp);
        if (localwsp != null) {
          localwsp.b();
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
 * Qualified Name:     wth
 * JD-Core Version:    0.7.0.1
 */