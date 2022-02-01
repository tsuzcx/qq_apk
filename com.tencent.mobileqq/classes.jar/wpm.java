public class wpm
  implements wou
{
  public final wou[] a = new wou[40];
  
  public static wou a(int paramInt)
  {
    return wpo.a.b(paramInt);
  }
  
  public static wpm a()
  {
    return wpo.a;
  }
  
  private void a(int paramInt, wou paramwou)
  {
    this.a[paramInt] = paramwou;
  }
  
  public void a() {}
  
  public wou b(int paramInt)
  {
    wou localwou1 = this.a[paramInt];
    if (localwou1 == null) {}
    for (;;)
    {
      wou localwou2;
      synchronized (this.a)
      {
        localwou2 = this.a[paramInt];
        if (localwou2 == null) {
          break label408;
        }
        return localwou2;
        if (localwou1 != null)
        {
          localwou1.a();
          yqp.b("Q.qqstory.SuperManager", "onInit manager : %s", localwou1);
        }
        a(paramInt, localwou1);
        return localwou1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new wps();
      continue;
      localObject2 = new xxe();
      continue;
      localObject2 = new wqk();
      continue;
      localObject2 = new wpf();
      continue;
      localObject2 = new wrf();
      continue;
      localObject2 = new yye();
      continue;
      localObject2 = new bpja();
      continue;
      localObject2 = new wpy();
      continue;
      localObject2 = new whg();
      continue;
      localObject2 = new wfs();
      continue;
      localObject2 = new why();
      continue;
      localObject2 = new wpj();
      continue;
      localObject2 = new wpc();
      continue;
      localObject2 = new wix();
      continue;
      localObject2 = new woy();
      continue;
      localObject2 = new wpa();
      continue;
      localObject2 = new woj();
      continue;
      localObject2 = new woz();
      continue;
      localObject2 = new won();
      continue;
      localObject2 = new wpx();
      continue;
      localObject2 = new wos();
      continue;
      localObject2 = new yij();
      continue;
      localObject2 = new yip();
      continue;
      localObject2 = new wpu();
      continue;
      localObject2 = new xzh();
      continue;
      localObject2 = new wot();
      continue;
      localObject2 = new wpp();
      continue;
      localObject2 = new wfy();
      continue;
      localObject2 = new wpk();
      continue;
      localObject2 = new wca();
      continue;
      return localObject2;
      label408:
      localObject2 = localwou2;
      switch (paramInt)
      {
      }
      localObject2 = localwou2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    wou[] arrayOfwou = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        wou localwou = this.a[i];
        yqp.b("Q.qqstory.SuperManager", "destroy manager : %s", localwou);
        if (localwou != null) {
          localwou.b();
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
 * Qualified Name:     wpm
 * JD-Core Version:    0.7.0.1
 */