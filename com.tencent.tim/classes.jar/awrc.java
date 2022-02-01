public class awrc
{
  private static int eCo;
  private static int eCp;
  private static int eCq;
  private static int eCr;
  
  public static int Qt()
  {
    init();
    return eCq;
  }
  
  public static int Qu()
  {
    init();
    return eCr;
  }
  
  public static int getMajorVersion()
  {
    init();
    return eCo;
  }
  
  public static int getMinorVersion()
  {
    init();
    return eCp;
  }
  
  private static void init()
  {
    String[] arrayOfString;
    if (eCq == 0)
    {
      arrayOfString = aonc.getVersionCode().split("\\.");
      if (arrayOfString.length >= 4) {}
    }
    else
    {
      return;
    }
    try
    {
      eCo = Integer.valueOf(arrayOfString[0]).intValue();
      eCp = Integer.valueOf(arrayOfString[1]).intValue();
      eCr = Integer.valueOf(arrayOfString[2]).intValue();
      eCq = Integer.valueOf(arrayOfString[3]).intValue();
      return;
    }
    catch (NumberFormatException localNumberFormatException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awrc
 * JD-Core Version:    0.7.0.1
 */