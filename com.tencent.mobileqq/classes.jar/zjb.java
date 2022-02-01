public class zjb
{
  public static String a(String paramString)
  {
    return "Q.qqstory.record.RMW." + paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    yuk.a(a(paramString1), paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    yuk.c(a(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    yuk.b(a(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    yuk.c(a(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zjb
 * JD-Core Version:    0.7.0.1
 */