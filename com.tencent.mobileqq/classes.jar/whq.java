import java.util.List;

public class whq
  extends whr<wgh>
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
  
  protected long a(wgh paramwgh1, wgh paramwgh2)
  {
    if ((paramwgh1 != paramwgh2) && (paramwgh1.b == paramwgh2.b)) {
      return 1L;
    }
    return Math.abs(paramwgh1.b - paramwgh2.b);
  }
  
  protected wgh a(List<wgh> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((wgh)paramList.get(i)).b;
      i += 1;
    }
    wgh localwgh = new wgh();
    localwgh.b = (l / paramList.size());
    return localwgh;
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
  
  protected boolean a(wgh paramwgh1, wgh paramwgh2)
  {
    return paramwgh1.b == paramwgh2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     whq
 * JD-Core Version:    0.7.0.1
 */