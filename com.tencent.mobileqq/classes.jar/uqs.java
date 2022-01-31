public class uqs
  implements uqz
{
  public final uqq[] a = new uqq[2];
  
  private void a(uqq paramuqq, int paramInt)
  {
    this.a[paramInt] = paramuqq;
  }
  
  public <T extends uqq> T a(int paramInt)
  {
    uqq localuqq = this.a[paramInt];
    if (localuqq == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localuqq = this.a[paramInt];
        if (localuqq == null) {
          break label80;
        }
        return localuqq;
        a(localuqq, paramInt);
        if (localuqq != null) {
          localuqq.b();
        }
        return localuqq;
      }
      Object localObject2 = new usf();
      continue;
      localObject2 = new uqj();
      continue;
      return localObject2;
      label80:
      switch (paramInt)
      {
      }
    }
  }
  
  public void a()
  {
    wsv.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    wsv.b("DataProviderManager", "onDestroy");
    uqq[] arrayOfuqq = this.a;
    int j = arrayOfuqq.length;
    int i = 0;
    while (i < j)
    {
      uqq localuqq = arrayOfuqq[i];
      if (localuqq != null) {
        localuqq.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqs
 * JD-Core Version:    0.7.0.1
 */