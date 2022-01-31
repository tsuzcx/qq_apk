package wf7;

public class ew$a
{
  private Object hx = new Object();
  private int oP = 1;
  
  public int di()
  {
    synchronized (this.hx)
    {
      int i = this.oP;
      this.oP += 1;
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.ew.a
 * JD-Core Version:    0.7.0.1
 */