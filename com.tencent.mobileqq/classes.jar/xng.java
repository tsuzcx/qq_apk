public class xng
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
      wsv.d("NumberUtils", "Invalid num string " + paramString + ", return default number " + paramLong);
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xng
 * JD-Core Version:    0.7.0.1
 */