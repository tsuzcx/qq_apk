public class rlg
{
  public static void d(String paramString1, String paramString2)
  {
    ram.d(gi(paramString1), paramString2);
  }
  
  public static String gi(String paramString)
  {
    return "Q.qqstory.record.RMW." + paramString;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    ram.i(gi(paramString1), paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ram.i(gi(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void v(String paramString1, String paramString2)
  {
    ram.v(gi(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rlg
 * JD-Core Version:    0.7.0.1
 */