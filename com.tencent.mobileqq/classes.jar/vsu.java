public class vsu
{
  public static String a(String paramString)
  {
    return "Q.qqstory.record.RMW." + paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    ved.a(a(paramString1), paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    ved.c(a(paramString1), String.format(paramString2, paramVarArgs));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    ved.b(a(paramString1), paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    ved.c(a(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vsu
 * JD-Core Version:    0.7.0.1
 */