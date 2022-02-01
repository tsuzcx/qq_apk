public class won
  implements wou
{
  public final wol[] a = new wol[2];
  
  private void a(wol paramwol, int paramInt)
  {
    this.a[paramInt] = paramwol;
  }
  
  public <T extends wol> T a(int paramInt)
  {
    wol localwol = this.a[paramInt];
    if (localwol == null) {}
    for (;;)
    {
      synchronized (this.a)
      {
        localwol = this.a[paramInt];
        if (localwol == null) {
          break label80;
        }
        return localwol;
        a(localwol, paramInt);
        if (localwol != null) {
          localwol.b();
        }
        return localwol;
      }
      Object localObject2 = new wqa();
      continue;
      localObject2 = new woe();
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
    yqp.b("DataProviderManager", "onInit");
  }
  
  public void b()
  {
    yqp.b("DataProviderManager", "onDestroy");
    wol[] arrayOfwol = this.a;
    int j = arrayOfwol.length;
    int i = 0;
    while (i < j)
    {
      wol localwol = arrayOfwol[i];
      if (localwol != null) {
        localwol.c();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     won
 * JD-Core Version:    0.7.0.1
 */