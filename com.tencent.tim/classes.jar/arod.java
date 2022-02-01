public class arod
{
  private static arod a;
  
  public static arod a()
  {
    try
    {
      if (a == null) {
        a = new arod();
      }
      arod localarod = a;
      return localarod;
    }
    finally {}
  }
  
  public void WE(String paramString)
  {
    aryn.WE(paramString);
  }
  
  public void WF(String paramString)
  {
    aryn.WF(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arod
 * JD-Core Version:    0.7.0.1
 */