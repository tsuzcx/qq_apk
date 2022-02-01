public class wjs
  implements wja
{
  public final wja[] a = new wja[40];
  
  public static wja a(int paramInt)
  {
    return wju.a.b(paramInt);
  }
  
  public static wjs a()
  {
    return wju.a;
  }
  
  private void a(int paramInt, wja paramwja)
  {
    this.a[paramInt] = paramwja;
  }
  
  public void a() {}
  
  public wja b(int paramInt)
  {
    wja localwja1 = this.a[paramInt];
    if (localwja1 == null) {}
    for (;;)
    {
      wja localwja2;
      synchronized (this.a)
      {
        localwja2 = this.a[paramInt];
        if (localwja2 == null) {
          break label408;
        }
        return localwja2;
        if (localwja1 != null)
        {
          localwja1.a();
          ykq.b("Q.qqstory.SuperManager", "onInit manager : %s", localwja1);
        }
        a(paramInt, localwja1);
        return localwja1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new wjy();
      continue;
      localObject2 = new xrf();
      continue;
      localObject2 = new wkq();
      continue;
      localObject2 = new wjl();
      continue;
      localObject2 = new wll();
      continue;
      localObject2 = new ysa();
      continue;
      localObject2 = new bowz();
      continue;
      localObject2 = new wke();
      continue;
      localObject2 = new wbv();
      continue;
      localObject2 = new wah();
      continue;
      localObject2 = new wcn();
      continue;
      localObject2 = new wjp();
      continue;
      localObject2 = new wji();
      continue;
      localObject2 = new wde();
      continue;
      localObject2 = new wje();
      continue;
      localObject2 = new wjg();
      continue;
      localObject2 = new wip();
      continue;
      localObject2 = new wjf();
      continue;
      localObject2 = new wit();
      continue;
      localObject2 = new wkd();
      continue;
      localObject2 = new wiy();
      continue;
      localObject2 = new yck();
      continue;
      localObject2 = new ycq();
      continue;
      localObject2 = new wka();
      continue;
      localObject2 = new xti();
      continue;
      localObject2 = new wiz();
      continue;
      localObject2 = new wjv();
      continue;
      localObject2 = new wan();
      continue;
      localObject2 = new wjq();
      continue;
      localObject2 = new vwv();
      continue;
      return localObject2;
      label408:
      localObject2 = localwja2;
      switch (paramInt)
      {
      }
      localObject2 = localwja2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    wja[] arrayOfwja = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        wja localwja = this.a[i];
        ykq.b("Q.qqstory.SuperManager", "destroy manager : %s", localwja);
        if (localwja != null) {
          localwja.b();
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
 * Qualified Name:     wjs
 * JD-Core Version:    0.7.0.1
 */