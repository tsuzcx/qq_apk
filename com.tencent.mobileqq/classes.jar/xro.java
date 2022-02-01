public class xro
{
  private int a = 0;
  
  xro(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static xro a(int paramInt)
  {
    return new xro(paramInt);
  }
  
  public int a()
  {
    switch (this.a)
    {
    default: 
      return this.a;
    }
    return 0;
  }
  
  public int b()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xro
 * JD-Core Version:    0.7.0.1
 */