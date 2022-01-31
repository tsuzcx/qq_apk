public class uvb
  implements uvi
{
  public final uuz[] a = new uuz[2];
  
  private void a(uuz paramuuz, int paramInt)
  {
    this.a[paramInt] = paramuuz;
  }
  
  public <T extends uuz> T a(int paramInt)
  {
    uuz localuuz = this.a[paramInt];
    if (localuuz == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localuuz = this.a[paramInt];
        if (localuuz == null) {
          break label80;
        }
        return localuuz;
        a(localuuz, paramInt);
        if (localuuz != null) {
          localuuz.b();
        }
        return localuuz;
      }
      Object localObject2 = new uwo();
      continue;
      localObject2 = new uus();
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
    wxe.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    wxe.b("DataProviderManager", "onDestroy");
    uuz[] arrayOfuuz = this.a;
    int j = arrayOfuuz.length;
    int i = 0;
    while (i < j)
    {
      uuz localuuz = arrayOfuuz[i];
      if (localuuz != null) {
        localuuz.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uvb
 * JD-Core Version:    0.7.0.1
 */