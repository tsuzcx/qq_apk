public class wit
  implements wja
{
  public final wir[] a = new wir[2];
  
  private void a(wir paramwir, int paramInt)
  {
    this.a[paramInt] = paramwir;
  }
  
  public <T extends wir> T a(int paramInt)
  {
    wir localwir = this.a[paramInt];
    if (localwir == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localwir = this.a[paramInt];
        if (localwir == null) {
          break label80;
        }
        return localwir;
        a(localwir, paramInt);
        if (localwir != null) {
          localwir.b();
        }
        return localwir;
      }
      Object localObject2 = new wkg();
      continue;
      localObject2 = new wik();
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
    ykq.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    ykq.b("DataProviderManager", "onDestroy");
    wir[] arrayOfwir = this.a;
    int j = arrayOfwir.length;
    int i = 0;
    while (i < j)
    {
      wir localwir = arrayOfwir[i];
      if (localwir != null) {
        localwir.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wit
 * JD-Core Version:    0.7.0.1
 */