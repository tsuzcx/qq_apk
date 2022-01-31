public class xny
{
  public static Throwable a(String paramString)
  {
    return new NullPointerException(paramString);
  }
  
  public static Throwable a(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return new IllegalStateException(paramString);
    }
    return new IllegalStateException(paramString, paramThrowable);
  }
  
  public static Throwable b(String paramString, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return new Throwable(paramString);
    }
    return new Throwable(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xny
 * JD-Core Version:    0.7.0.1
 */