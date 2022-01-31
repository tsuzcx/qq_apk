import java.util.List;

public class ukj
  extends ukk<uja>
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
  
  protected long a(uja paramuja1, uja paramuja2)
  {
    if ((paramuja1 != paramuja2) && (paramuja1.b == paramuja2.b)) {
      return 1L;
    }
    return Math.abs(paramuja1.b - paramuja2.b);
  }
  
  protected uja a(List<uja> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((uja)paramList.get(i)).b;
      i += 1;
    }
    uja localuja = new uja();
    localuja.b = (l / paramList.size());
    return localuja;
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
  
  protected boolean a(uja paramuja1, uja paramuja2)
  {
    return paramuja1.b == paramuja2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukj
 * JD-Core Version:    0.7.0.1
 */