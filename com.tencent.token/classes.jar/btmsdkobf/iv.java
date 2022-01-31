package btmsdkobf;

class iv
  implements Comparable, Runnable
{
  private es.c b = new es.c();
  
  public iv(en paramen, int paramInt, Runnable paramRunnable, String paramString, long paramLong, boolean paramBoolean, Object paramObject)
  {
    if (paramString != null)
    {
      paramen = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      paramen = paramRunnable.getClass().getName();
    }
    this.b.oT = 1;
    this.b.priority = paramInt;
    this.b.name = paramen;
    this.b.de = paramLong;
    this.b.oY = paramRunnable;
    this.b.oX = paramBoolean;
    this.b.oZ = paramObject;
    this.b.oU = System.currentTimeMillis();
  }
  
  public int a(iv paramiv)
  {
    int k = (int)(Math.abs(System.currentTimeMillis() - this.b.oU) / 200L);
    int j = this.b.priority;
    int i = j;
    if (k > 0) {
      i = j + k;
    }
    return paramiv.b.priority - i;
  }
  
  public es.c a()
  {
    return this.b;
  }
  
  public void run()
  {
    try
    {
      if ((this.b != null) && (this.b.oY != null)) {
        this.b.oY.run();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      eg.h("ThreadPool", "run (Throwable):" + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.iv
 * JD-Core Version:    0.7.0.1
 */