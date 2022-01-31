public class yda
{
  public static String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    String str1 = alpo.a(2131705103);
    if (l < 10000L) {
      return String.valueOf(l);
    }
    if (l < 10000000L)
    {
      str1 = String.valueOf(l / 10000.0D + 0.05D);
      return str1.substring(0, str1.indexOf(".") + 2) + "w";
    }
    if (l < 100000000L) {
      return l / 10000L + "w";
    }
    String str2 = String.valueOf(l / 100000000.0D);
    return str2.substring(0, str2.indexOf(".") + 2) + str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yda
 * JD-Core Version:    0.7.0.1
 */