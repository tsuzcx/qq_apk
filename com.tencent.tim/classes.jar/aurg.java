public class aurg
{
  public static int au(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static int t(String paramString)
  {
    return au(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aurg
 * JD-Core Version:    0.7.0.1
 */