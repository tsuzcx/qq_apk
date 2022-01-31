public class urr
  implements uqz
{
  public final uqz[] a = new uqz[40];
  
  public static uqz a(int paramInt)
  {
    return urt.a.b(paramInt);
  }
  
  public static urr a()
  {
    return urt.a;
  }
  
  private void a(int paramInt, uqz paramuqz)
  {
    this.a[paramInt] = paramuqz;
  }
  
  public void a() {}
  
  public uqz b(int paramInt)
  {
    uqz localuqz1 = this.a[paramInt];
    if (localuqz1 == null) {}
    for (;;)
    {
      uqz localuqz2;
      synchronized (this.a)
      {
        localuqz2 = this.a[paramInt];
        if (localuqz2 == null) {
          break label408;
        }
        return localuqz2;
        if (localuqz1 != null)
        {
          localuqz1.a();
          wsv.b("Q.qqstory.SuperManager", "onInit manager : %s", localuqz1);
        }
        a(paramInt, localuqz1);
        return localuqz1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new urx();
      continue;
      localObject2 = new vzk();
      continue;
      localObject2 = new usp();
      continue;
      localObject2 = new urk();
      continue;
      localObject2 = new utk();
      continue;
      localObject2 = new xak();
      continue;
      localObject2 = new bmni();
      continue;
      localObject2 = new usd();
      continue;
      localObject2 = new ujl();
      continue;
      localObject2 = new uhx();
      continue;
      localObject2 = new ukd();
      continue;
      localObject2 = new uro();
      continue;
      localObject2 = new urh();
      continue;
      localObject2 = new ulc();
      continue;
      localObject2 = new urd();
      continue;
      localObject2 = new urf();
      continue;
      localObject2 = new uqo();
      continue;
      localObject2 = new ure();
      continue;
      localObject2 = new uqs();
      continue;
      localObject2 = new usc();
      continue;
      localObject2 = new uqx();
      continue;
      localObject2 = new wkp();
      continue;
      localObject2 = new wkv();
      continue;
      localObject2 = new urz();
      continue;
      localObject2 = new wbn();
      continue;
      localObject2 = new uqy();
      continue;
      localObject2 = new uru();
      continue;
      localObject2 = new uid();
      continue;
      localObject2 = new urp();
      continue;
      localObject2 = new uef();
      continue;
      return localObject2;
      label408:
      localObject2 = localuqz2;
      switch (paramInt)
      {
      }
      localObject2 = localuqz2;
    }
  }
  
  public void b() {}
  
  public void c()
  {
    uqz[] arrayOfuqz = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        uqz localuqz = this.a[i];
        wsv.b("Q.qqstory.SuperManager", "destroy manager : %s", localuqz);
        if (localuqz != null) {
          localuqz.b();
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
 * Qualified Name:     urr
 * JD-Core Version:    0.7.0.1
 */