import java.util.List;

public class vyq
  extends vyr<vxh>
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
  
  protected long a(vxh paramvxh1, vxh paramvxh2)
  {
    if ((paramvxh1 != paramvxh2) && (paramvxh1.b == paramvxh2.b)) {
      return 1L;
    }
    return Math.abs(paramvxh1.b - paramvxh2.b);
  }
  
  protected vxh a(List<vxh> paramList)
  {
    long l = 0L;
    int i = 0;
    while (i < paramList.size())
    {
      l += ((vxh)paramList.get(i)).b;
      i += 1;
    }
    vxh localvxh = new vxh();
    localvxh.b = (l / paramList.size());
    return localvxh;
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
  
  protected boolean a(vxh paramvxh1, vxh paramvxh2)
  {
    return paramvxh1.b == paramvxh2.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyq
 * JD-Core Version:    0.7.0.1
 */