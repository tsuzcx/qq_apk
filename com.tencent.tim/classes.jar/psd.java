public class psd
  implements psj
{
  public final psc[] a = new psc[2];
  
  private void a(psc parampsc, int paramInt)
  {
    this.a[paramInt] = parampsc;
  }
  
  public <T extends psc> T a(int paramInt)
  {
    psc localpsc = this.a[paramInt];
    if (localpsc == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localpsc = this.a[paramInt];
        if (localpsc == null) {
          break label80;
        }
        return localpsc;
        a(localpsc, paramInt);
        if (localpsc != null) {
          localpsc.onInit();
        }
        return localpsc;
      }
      Object localObject2 = new pth();
      continue;
      localObject2 = new prw();
      continue;
      return localObject2;
      label80:
      switch (paramInt)
      {
      }
    }
  }
  
  public void onDestroy()
  {
    ram.d("DataProviderManager", "onDestroy");
    psc[] arrayOfpsc = this.a;
    int j = arrayOfpsc.length;
    int i = 0;
    while (i < j)
    {
      psc localpsc = arrayOfpsc[i];
      if (localpsc != null) {
        localpsc.onDestroy();
      }
      i += 1;
    }
  }
  
  public void onInit()
  {
    ram.d("DataProviderManager", "onInit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     psd
 * JD-Core Version:    0.7.0.1
 */