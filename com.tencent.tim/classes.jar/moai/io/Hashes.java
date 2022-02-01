package moai.io;

public class Hashes
{
  public static int BKDRHashInt(String paramString)
  {
    int i = 0;
    int j = 0;
    while (i < paramString.length())
    {
      j = j * 131 + paramString.charAt(i);
      i += 1;
    }
    return j;
  }
  
  public static long BKDRHashLong(String paramString)
  {
    long l = 0L;
    int i = 0;
    while (i < paramString.length())
    {
      l = l * 131L + paramString.charAt(i);
      i += 1;
    }
    return l;
  }
  
  public static int BKDRHashPositiveInt(String paramString)
  {
    return BKDRHashInt(paramString) & 0x7FFFFFFF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.Hashes
 * JD-Core Version:    0.7.0.1
 */