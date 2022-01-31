package tmsdk.common.d.a.b;

public class q
  implements f
{
  private Object a = new Object();
  private int b = 1;
  
  public int a()
  {
    synchronized (this.a)
    {
      int i = this.b;
      this.b += 1;
      return i;
    }
  }
  
  public int b()
  {
    synchronized (this.a)
    {
      int i = this.b;
      return i;
    }
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      this.b += 1;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.q
 * JD-Core Version:    0.7.0.1
 */