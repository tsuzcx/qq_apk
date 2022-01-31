public class vyo
{
  public static long a(String paramString, long paramLong)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ved.d("NumberUtils", "Invalid num string " + paramString + ", return default number " + paramLong);
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vyo
 * JD-Core Version:    0.7.0.1
 */