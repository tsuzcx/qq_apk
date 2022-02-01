import java.util.List;

public class wdv
  extends wdw<wcm>
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
  
  protected long a(wcm paramwcm1, wcm paramwcm2)
  {
    if ((paramwcm1 != paramwcm2) && (paramwcm1.b == paramwcm2.b)) {
      return 1L;
    }
    return Math.abs(paramwcm1.b - paramwcm2.b);
  }
  
  protected wcm a(List<wcm> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((wcm)paramList.get(i)).b;
      i += 1;
    }
    wcm localwcm = new wcm();
    localwcm.b = (l / paramList.size());
    return localwcm;
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
  
  protected boolean a(wcm paramwcm1, wcm paramwcm2)
  {
    return paramwcm1.b == paramwcm2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wdv
 * JD-Core Version:    0.7.0.1
 */