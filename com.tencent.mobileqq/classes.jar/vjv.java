import java.util.List;

public class vjv
  extends vjw<vim>
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
  
  protected long a(vim paramvim1, vim paramvim2)
  {
    if ((paramvim1 != paramvim2) && (paramvim1.b == paramvim2.b)) {
      return 1L;
    }
    return Math.abs(paramvim1.b - paramvim2.b);
  }
  
  protected vim a(List<vim> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((vim)paramList.get(i)).b;
      i += 1;
    }
    vim localvim = new vim();
    localvim.b = (l / paramList.size());
    return localvim;
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
  
  protected boolean a(vim paramvim1, vim paramvim2)
  {
    return paramvim1.b == paramvim2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjv
 * JD-Core Version:    0.7.0.1
 */