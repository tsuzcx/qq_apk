public class wsi
  implements wsp
{
  public final wsg[] a = new wsg[2];
  
  private void a(wsg paramwsg, int paramInt)
  {
    this.a[paramInt] = paramwsg;
  }
  
  public <T extends wsg> T a(int paramInt)
  {
    wsg localwsg = this.a[paramInt];
    if (localwsg == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localwsg = this.a[paramInt];
        if (localwsg == null) {
          break label80;
        }
        return localwsg;
        a(localwsg, paramInt);
        if (localwsg != null) {
          localwsg.b();
        }
        return localwsg;
      }
      Object localObject2 = new wtv();
      continue;
      localObject2 = new wrz();
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
    yuk.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    yuk.b("DataProviderManager", "onDestroy");
    wsg[] arrayOfwsg = this.a;
    int j = arrayOfwsg.length;
    int i = 0;
    while (i < j)
    {
      wsg localwsg = arrayOfwsg[i];
      if (localwsg != null) {
        localwsg.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsi
 * JD-Core Version:    0.7.0.1
 */