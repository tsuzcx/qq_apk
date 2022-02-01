public class asfd
  extends asfb
{
  private static asfd a;
  private static final Object fJ = new Object();
  
  public static asfd a()
  {
    if (a == null) {}
    synchronized (fJ)
    {
      if (a == null) {
        a = new asfd();
      }
      return a;
    }
  }
  
  public void destroy()
  {
    super.destroy();
    a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asfd
 * JD-Core Version:    0.7.0.1
 */