public class psx
  implements psj
{
  public final psj[] a = new psj[40];
  
  public static psj a(int paramInt)
  {
    return psx.a.a.b(paramInt);
  }
  
  public static psx a()
  {
    return psx.a.a;
  }
  
  private void a(int paramInt, psj parampsj)
  {
    this.a[paramInt] = parampsj;
  }
  
  public psj b(int paramInt)
  {
    psj localpsj1 = this.a[paramInt];
    if (localpsj1 == null) {}
    for (;;)
    {
      psj localpsj2;
      synchronized (this.a)
      {
        localpsj2 = this.a[paramInt];
        if (localpsj2 == null) {
          break label408;
        }
        return localpsj2;
        if (localpsj1 != null)
        {
          localpsj1.onInit();
          ram.d("Q.qqstory.SuperManager", "onInit manager : %s", localpsj1);
        }
        a(paramInt, localpsj1);
        return localpsj1;
      }
      Object localObject2 = this;
      continue;
      localObject2 = new ptb();
      continue;
      localObject2 = new qph();
      continue;
      localObject2 = new ptn();
      continue;
      localObject2 = new psr();
      continue;
      localObject2 = new pub();
      continue;
      localObject2 = new rgp();
      continue;
      localObject2 = new aykn();
      continue;
      localObject2 = new ptf();
      continue;
      localObject2 = new pnm();
      continue;
      localObject2 = new pmm();
      continue;
      localObject2 = new pnx();
      continue;
      localObject2 = new psu();
      continue;
      localObject2 = new psq();
      continue;
      localObject2 = new poj();
      continue;
      localObject2 = new psm();
      continue;
      localObject2 = new pso();
      continue;
      localObject2 = new psa();
      continue;
      localObject2 = new psn();
      continue;
      localObject2 = new psd();
      continue;
      localObject2 = new pte();
      continue;
      localObject2 = new psh();
      continue;
      localObject2 = new qvf();
      continue;
      localObject2 = new qvi();
      continue;
      localObject2 = new ptc();
      continue;
      localObject2 = new qqe();
      continue;
      localObject2 = new psi();
      continue;
      localObject2 = new psz();
      continue;
      localObject2 = new pmq();
      continue;
      localObject2 = new psv();
      continue;
      localObject2 = new pju();
      continue;
      return localObject2;
      label408:
      localObject2 = localpsj2;
      switch (paramInt)
      {
      }
      localObject2 = localpsj2;
    }
  }
  
  public void destroy()
  {
    psj[] arrayOfpsj = this.a;
    int i = 0;
    try
    {
      while (i < this.a.length)
      {
        psj localpsj = this.a[i];
        ram.d("Q.qqstory.SuperManager", "destroy manager : %s", localpsj);
        if (localpsj != null) {
          localpsj.onDestroy();
        }
        this.a[i] = null;
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  static class a
  {
    public static final psx a = new psx(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psx
 * JD-Core Version:    0.7.0.1
 */