package btmsdkobf;

public class cu$a
  implements ci
{
  private Object V = new Object();
  private int ix = 1;
  
  public int bm()
  {
    synchronized (this.V)
    {
      int i = this.ix;
      this.ix += 1;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.cu.a
 * JD-Core Version:    0.7.0.1
 */