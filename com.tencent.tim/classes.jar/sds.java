public class sds
{
  public static String aO(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    String str1 = acfp.m(2131706430);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sds
 * JD-Core Version:    0.7.0.1
 */