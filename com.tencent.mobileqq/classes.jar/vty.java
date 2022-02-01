public class vty
  implements vuf
{
  public final vtw[] a = new vtw[2];
  
  private void a(vtw paramvtw, int paramInt)
  {
    this.a[paramInt] = paramvtw;
  }
  
  public <T extends vtw> T a(int paramInt)
  {
    vtw localvtw = this.a[paramInt];
    if (localvtw == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localvtw = this.a[paramInt];
        if (localvtw == null) {
          break label80;
        }
        return localvtw;
        a(localvtw, paramInt);
        if (localvtw != null) {
          localvtw.b();
        }
        return localvtw;
      }
      Object localObject2 = new vvl();
      continue;
      localObject2 = new vtp();
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
    xvv.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    xvv.b("DataProviderManager", "onDestroy");
    vtw[] arrayOfvtw = this.a;
    int j = arrayOfvtw.length;
    int i = 0;
    while (i < j)
    {
      vtw localvtw = arrayOfvtw[i];
      if (localvtw != null) {
        localvtw.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vty
 * JD-Core Version:    0.7.0.1
 */