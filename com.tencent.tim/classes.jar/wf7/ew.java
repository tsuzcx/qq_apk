package wf7;

public class ew
{
  private static a pm;
  private static a pn;
  
  public static a dg()
  {
    if (pm == null) {}
    try
    {
      if (pm == null) {
        pm = new a();
      }
      return pm;
    }
    finally {}
  }
  
  public static a dh()
  {
    if (pn == null) {}
    try
    {
      if (pn == null) {
        pn = new a();
      }
      return pn;
    }
    finally {}
  }
  
  public static class a
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.ew
 * JD-Core Version:    0.7.0.1
 */