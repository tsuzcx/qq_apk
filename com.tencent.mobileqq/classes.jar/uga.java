import java.util.List;

public class uga
  extends ugb<uer>
{
  private int a = 200;
  
  protected double a()
  {
    return 0.3D;
  }
  
  protected int a()
  {
    return this.a;
  }
  
  protected long a(uer paramuer1, uer paramuer2)
  {
    if ((paramuer1 != paramuer2) && (paramuer1.b == paramuer2.b)) {
      return 1L;
    }
    return Math.abs(paramuer1.b - paramuer2.b);
  }
  
  protected uer a(List<uer> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((uer)paramList.get(i)).b;
      i += 1;
    }
    uer localuer = new uer();
    localuer.b = (l / paramList.size());
    return localuer;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected boolean a(long paramLong)
  {
    int i = b();
    if (i > 0) {
      if (paramLong / i >= 1500L) {}
    }
    while (paramLong < 200L)
    {
      return true;
      return false;
    }
    return false;
  }
  
  protected boolean a(uer paramuer1, uer paramuer2)
  {
    return paramuer1.b == paramuer2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uga
 * JD-Core Version:    0.7.0.1
 */