public class zek
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
      ykq.d("NumberUtils", "Invalid num string " + paramString + ", return default number " + paramLong);
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zek
 * JD-Core Version:    0.7.0.1
 */